package pro.i_it.learn.pro.i_it.learn.android.remote.retorfit.model;

/**
 * Created by syn on 09.03.17.
 */

public class MessageModel {
    private Integer id;
    private String from;
    private String message;

    public void setId(int id) {
        this.id = id;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getFrom() {
        return from;
    }


    public int getId() {
        return id;
    }
}
