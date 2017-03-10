package pro.i_it.learn.pro.i_it.learn.android.remote.interfaces;

import pro.i_it.learn.pro.i_it.learn.android.remote.retorfit.interfaces.IRetrofitManager;
import pro.i_it.learn.pro.i_it.learn.android.remote.socketIo.interfaces.ISocketIoManager;

/**
 * Created by syn on 09.03.17.
 */

public interface IRemoteManager {
    IRetrofitManager getRetrofitManager();

    ISocketIoManager getSocketIoManager();
}
