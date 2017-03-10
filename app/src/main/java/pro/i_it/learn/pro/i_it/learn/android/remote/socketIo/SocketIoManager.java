package pro.i_it.learn.pro.i_it.learn.android.remote.socketIo;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;
import pro.i_it.learn.pro.i_it.learn.android.interfaces.IChatManager;
import pro.i_it.learn.pro.i_it.learn.android.remote.socketIo.chat.ChatManager;
import pro.i_it.learn.pro.i_it.learn.android.remote.socketIo.interfaces.ISocketIoManager;

/**
 * Created by syn on 10.03.17.
 */

public class SocketIoManager implements ISocketIoManager {
    private IChatManager chatManager;

    public SocketIoManager() {
        try {
            Socket socket = IO.socket("http://learn.i-it.pro:9090/");
            chatManager = new ChatManager(socket);
            socket.connect();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

    }

    @Override
    public IChatManager getChatManager() {
        return chatManager;
    }
}
