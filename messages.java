public class messages {
    String text;
    int senderID;
    int receiverID;
    long sent_timestamp;
    long del_timestamp;
    long seen_timestamp;

    public messages () {

    }

    public messages (String text, int senderID, int receiverID, long sent_timestamp,
                     long del_timestamp, long seen_timestamp) {
        this.text=text;
        this.senderID=senderID;
        this.receiverID=receiverID;
        this.sent_timestamp=sent_timestamp;
        this.del_timestamp=del_timestamp;
        this.seen_timestamp=seen_timestamp;
    }

    public String getText() {
        return this.text;
    }
    public void setText(String text) {
        this.text=text;
    }
    public String getSenderID() {
        return this.senderID;
    }
    public void setSenderID(int senderID) {
        this.senderID = senderID;
    }
    public String getReceiverID() {
        return this.receiverID;
    }
    public void setReceiverID(int receiverID) {
        this.receiverID = receiverID;
    }
    public String getsent_timestamp() {
        return this.sent_timestamp;
    }
    public void setSent_timestamp(int sent_timestamp) {
        this.sent_timestamp = sent_timestamp;
    }
    public String getdel_timestamp() {
        return this.del_timestamp;
    }
    public void setDel_timestamp(int del_timestamp) {
        this.del_timestamp = del_timestamp;
    }
    public String getseen_timestamp() {
        return this.seen_timestamp;
    }
    public void setSeen_timestamp(int seen_timestamp) {
        this.seen_timestamp = seen_timestamp;
    }
    messages msg1=new messages ();
    messages msg2 = new messages("Hi",1,2,12,13,14);

}
