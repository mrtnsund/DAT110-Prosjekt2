package no.hvl.dat110.messages;

public class CreateTopicMsg extends Message {
	private String topic;

    public CreateTopicMsg(String user, String topic){
        super(MessageType.CREATETOPIC, user);
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
        return "[New topic: " + topic + ", user: " + getUser() + "]";
    }
	// message sent from client to create topic on the broker
	
	// Implement object variables - a topic is required
	
	// Constructor, get/set-methods, and toString method
    // as described in the project text	
}
