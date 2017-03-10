package pro.i_it.learn.pro.i_it.learn.android.remote.socketIo.chat.events;

import android.util.Log;

import com.google.gson.Gson;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import io.socket.emitter.Emitter;
import pro.i_it.learn.pro.i_it.learn.android.remote.retorfit.model.MessageModel;
import pro.i_it.learn.pro.i_it.learn.android.remote.socketIo.chat.interfaces.IEventListener;

/**
 * Created by syn on 10.03.17.
 */

public class MessageEvent implements IEventListener {
    public static final String MESSAGE_EVENT = "MESSAGE";

    private final Subject<MessageModel> messagesBus = PublishSubject.create();

    private String TAG = MessageEvent.class.getSimpleName();

    public MessageEvent() {
        messagesBus.subscribe(model -> Log.d(TAG, "MessageEvent: "+new Gson().toJson(model)));
    }

    @Override
    public String getEvent() {
        return MESSAGE_EVENT;
    }

    @Override
    public Emitter.Listener getListener() {
        return args -> {
            Log.d(TAG, "call: ");
            MessageModel messageModel = new Gson().fromJson(args[0].toString(), MessageModel.class);
            messagesBus.onNext(messageModel);
        };
    }

    public Observable<MessageModel> getMessageObservable() {
        return messagesBus;
    }
}
