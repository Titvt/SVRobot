package Bean;

public class MessageBean {
    private String post_type;
    private String message_type;
    private String sub_type;
    private int message_id;
    private long group_id;
    private long user_id;
    private AnonymousBean anonymous;
    private String message;
    private String raw_message;
    private int font;
    private SenderBean senderBean;

    public String getPost_type() {
        return post_type;
    }

    public void setPost_type(String post_type) {
        this.post_type = post_type;
    }

    public String getMessage_type() {
        return message_type;
    }

    public void setMessage_type(String message_type) {
        this.message_type = message_type;
    }

    public String getSub_type() {
        return sub_type;
    }

    public void setSub_type(String sub_type) {
        this.sub_type = sub_type;
    }

    public int getMessage_id() {
        return message_id;
    }

    public void setMessage_id(int message_id) {
        this.message_id = message_id;
    }

    public long getGroup_id() {
        return group_id;
    }

    public void setGroup_id(long group_id) {
        this.group_id = group_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public AnonymousBean getAnonymous() {
        return anonymous;
    }

    public void setAnonymous(AnonymousBean anonymous) {
        this.anonymous = anonymous;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRaw_message() {
        return raw_message;
    }

    public void setRaw_message(String raw_message) {
        this.raw_message = raw_message;
    }

    public int getFont() {
        return font;
    }

    public void setFont(int font) {
        this.font = font;
    }

    public SenderBean getSenderBean() {
        return senderBean;
    }

    public void setSenderBean(SenderBean senderBean) {
        this.senderBean = senderBean;
    }
}