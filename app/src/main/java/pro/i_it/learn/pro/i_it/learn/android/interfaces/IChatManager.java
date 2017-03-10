package pro.i_it.learn.pro.i_it.learn.android.interfaces;


import io.reactivex.Observable;
import pro.i_it.learn.pro.i_it.learn.android.remote.retorfit.model.MessageModel;

/**
 * Created by syn on 10.03.17.
 */

public interface IChatManager {
    void sendMessage(MessageModel model);

    Observable<MessageModel> getInputModelObservable();

}
