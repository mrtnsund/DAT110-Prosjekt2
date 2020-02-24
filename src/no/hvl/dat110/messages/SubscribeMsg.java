package no.hvl.dat110.messages;

public class SubscribeMsg extends Message {
    private String topic;

    public SubscribeMsg(String user, String topic){
        super(MessageType.SUBSCRIBE, user);
        this.topic = topic;
    }

    public void setTopic(String topic){
        this.topic = topic;
    }

    public String getTopic(){
        return this.topic;
    }

    @Override
    public String toString(){
        return "[New subscription: " + topic + ", user: " + getUser() + "]";

    }
	// message sent from client to subscribe on a topic 

	// TODO:
	// Implement object variables - a topic is required

	// Constructor, get/set-methods, and toString method
	// as described in the project text
		
}
