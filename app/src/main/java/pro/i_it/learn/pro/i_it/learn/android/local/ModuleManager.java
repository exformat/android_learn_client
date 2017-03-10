package pro.i_it.learn.pro.i_it.learn.android.local;

import android.content.Context;

import pro.i_it.learn.pro.i_it.learn.android.local.interfaces.ILocalManager;
import pro.i_it.learn.pro.i_it.learn.android.remote.RemoteManager;
import pro.i_it.learn.pro.i_it.learn.android.remote.interfaces.IRemoteManager;

/**
 * Created by syn on 09.03.17.
 */

public class ModuleManager implements IModuleManager {
    private ILocalManager localManager;
    private IRemoteManager remoteManager;
    private Context context;

    public ModuleManager(Context context) {
        this.context = context;
        localManager = new LocalManager();
        remoteManager = new RemoteManager();
    }


    @Override
    public ILocalManager getLocalManager() {
        return localManager;
    }

    @Override
    public IRemoteManager getRemoteManager() {
        return remoteManager;
    }

    @Override
    public Context getAppContext() {
        return context;
    }
}
