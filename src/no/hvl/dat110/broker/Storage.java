package no.hvl.dat110.broker;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import no.hvl.dat110.common.TODO;
import no.hvl.dat110.common.Logger;
import no.hvl.dat110.messages.Message;
import no.hvl.dat110.messagetransport.Connection;

public class Storage {

	// data structure for managing subscriptions
	// maps from user to set of topics subscribed to by user
	protected ConcurrentHashMap<String, Set<String>> subscriptions;
	protected ConcurrentHashMap<String, Set<Message>> bufferedMessages;
	
	// data structure for managing currently connected clients
	// maps from user to corresponding client session object
	
	protected ConcurrentHashMap<String, ClientSession> clients;

	public Storage() {
		subscriptions = new ConcurrentHashMap<>();
		clients = new ConcurrentHashMap<>();
		bufferedMessages = new ConcurrentHashMap<>();
	}
	public Set<Message> getBufferedMessages(String user){
		return bufferedMessages.get(user);
	}

	public void addBufferedMessages(String user, Message message){
		Set<Message> m;
		if (!bufferedMessages.containsKey((user))) {
			m = new HashSet<>();
		} else {
			m = bufferedMessages.get((user));
		}
		m.add(message);
		bufferedMessages.put(user, m);
	}
	public void clearBufferedMessages(String user){
		bufferedMessages.remove(user);
	}

	public Collection<ClientSession> getSessions() {
		return clients.values();
	}

	public Set<String> getTopics() {

		return subscriptions.keySet();

	}

	// get the session object for a given user
	// session object can be used to send a message to the user
	
	public ClientSession getSession(String user) {

		ClientSession session = clients.get(user);

		return session;
	}

	public Set<String> getSubscribers(String topic) {

		return (subscriptions.get(topic));

	}

	public void addClientSession(String user, Connection connection) {
		clients.put(user, new ClientSession(user, connection));
	}

	public void removeClientSession(String user) {
		clients.remove(user);
	}

	public void createTopic(String topic) {
		Set<String> subscribers = new HashSet<>();
		subscriptions.put(topic, subscribers);
	}

	public void deleteTopic(String topic) {
		subscriptions.remove(topic);
	}

	public void addSubscriber(String user, String topic) {
		HashSet<String> hs = (HashSet<String>) getSubscribers(topic);
		hs.add(user);
		subscriptions.put(topic,hs);



	}

	public void removeSubscriber(String user, String topic) {
		HashSet<String> hs = (HashSet<String>) getSubscribers(topic);
		hs.remove(user);
		subscriptions.put(topic,hs);
	}
}
