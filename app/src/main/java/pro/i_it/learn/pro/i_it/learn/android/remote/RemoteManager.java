package pro.i_it.learn.pro.i_it.learn.android.remote;

import pro.i_it.learn.pro.i_it.learn.android.remote.interfaces.IRemoteManager;
import pro.i_it.learn.pro.i_it.learn.android.remote.retorfit.RetrofitManager;
import pro.i_it.learn.pro.i_it.learn.android.remote.retorfit.interfaces.IRetrofitManager;
import pro.i_it.learn.pro.i_it.learn.android.remote.socketIo.SocketIoManager;
import pro.i_it.learn.pro.i_it.learn.android.remote.socketIo.interfaces.ISocketIoManager;

/**
 * Created by syn on 01.03.17.
 */

public class RemoteManager implements IRemoteManager {
    private IRetrofitManager retrofitManager;
    private ISocketIoManager socketIoManager;

    public RemoteManager() {
        retrofitManager = new RetrofitManager();
        socketIoManager = new SocketIoManager();
    }

    @Override
    public IRetrofitManager getRetrofitManager() {
        return retrofitManager;
    }

    @Override
    public ISocketIoManager getSocketIoManager() {
        return socketIoManager;
    }
}
