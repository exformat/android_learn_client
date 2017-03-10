package pro.i_it.learn.pro.i_it.learn.android.remote.socketIo.chat;


import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashSet;
import java.util.Set;

import io.reactivex.Observable;
import io.socket.client.Socket;
import pro.i_it.learn.pro.i_it.learn.android.interfaces.IChatManager;
import pro.i_it.learn.pro.i_it.learn.android.remote.retorfit.model.MessageModel;
import pro.i_it.learn.pro.i_it.learn.android.remote.socketIo.chat.events.MessageEvent;
import pro.i_it.learn.pro.i_it.learn.android.remote.socketIo.chat.interfaces.IEventListener;

/**
 * Created by syn on 10.03.17.
 */

public class ChatManager implements IChatManager {
    private Socket socket;
    private Set<IEventListener> listeners;
    private Observable<MessageModel> messageModelObservable;

    public ChatManager(Socket socket) {
        this.socket = socket;
        initListener();
        setListener(socket, listeners);
    }

    private void setListener(Socket socket, Set<IEventListener> listeners) {
        if (listeners == null) {
            return;
        }
        Observable.fromIterable(listeners)
                .subscribe(iEventListener -> socket.on(iEventListener.getEvent(), iEventListener.getListener()));
    }

    private void initListener() {
        listeners = new HashSet<>();
        MessageEvent messageEvent = new MessageEvent();
        messageModelObservable = messageEvent.getMessageObservable();
        listeners.add(messageEvent);
    }

    @Override
    public void sendMessage(MessageModel model) {
        JSONObject obj = new JSONObject();
        try {
            obj = new JSONObject(new Gson().toJson(model));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        socket.emit(MessageEvent.MESSAGE_EVENT, obj);
    }

    @Override
    public Observable<MessageModel> getInputModelObservable() {
        return messageModelObservable;
    }
}
