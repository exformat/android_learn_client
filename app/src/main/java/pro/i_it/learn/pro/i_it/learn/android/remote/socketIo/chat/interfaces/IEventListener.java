package pro.i_it.learn.pro.i_it.learn.android.remote.socketIo.chat.interfaces;

import io.socket.emitter.Emitter;

/**
 * Created by syn on 10.03.17.
 */

public interface IEventListener<T> {
    String getEvent();

    Emitter.Listener getListener();
}
