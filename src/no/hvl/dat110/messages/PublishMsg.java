package no.hvl.dat110.messages;

public class PublishMsg extends Message {
    private String topic;
    private String message;

    public PublishMsg(String user, String topic, String message){
        super(MessageType.PUBLISH, user);
        this.topic = topic;
        this.message = message;
    }

    public void setTopic(String topic){
        this.topic = topic;
    }

    public String getTopic(){
        return this.topic;
    }

    public String getMessage(){
        return this.message;
    }

    public void setMessage(String message){
        this.message = message;
    }


    @Override
    public String toString(){
        return "[New publication: " + topic + ", user: " + getUser() + ", message: " + message + "]";
    }

	// message sent from client to create publish a message on a topic 

	// TODO:
	// Implement object variables - a topic and a message is required

	// Constructor, get/set-methods, and toString method
	// as described in the project text
	
}
