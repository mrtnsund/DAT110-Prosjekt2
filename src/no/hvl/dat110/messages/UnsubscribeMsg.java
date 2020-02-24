package no.hvl.dat110.messages;

public class UnsubscribeMsg extends Message {
    private String topic;

    public UnsubscribeMsg(String user, String topic){
        super(MessageType.UNSUBSCRIBE, user);
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
        return "[New unsubscription: " + topic + ", user: " + getUser() + "]";

    }
	// message sent from client to unsubscribe on a topic 

	// TODO:
	// Implement object variables - a topic is required

	// Constructor, get/set-methods, and toString method
	// as described in the project text
	
}
