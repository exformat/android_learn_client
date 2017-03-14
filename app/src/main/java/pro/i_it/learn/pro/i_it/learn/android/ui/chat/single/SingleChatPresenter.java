package pro.i_it.learn.pro.i_it.learn.android.ui.chat.single;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import pro.i_it.learn.R;
import pro.i_it.learn.pro.i_it.learn.android.LearnApp;
import pro.i_it.learn.pro.i_it.learn.android.remote.retorfit.model.MessageModel;
import pro.i_it.learn.pro.i_it.learn.android.ui.Drawer.NameModel;

/**
 * Created by syn on 08.03.17.
 */

public class SingleChatPresenter implements ISingleChatViewPresenter {
    private ISingleChatView view;
    private ArrayList<MessageModel> messages;

    @Override
    public void init(ISingleChatView view) {
        this.view = view;
        messages = new ArrayList<>();
        initMessages();

    }

    private void initMessages() {
        LearnApp.getModuleManager()
                .getRemoteManager()
                .getRetrofitManager()
                .getLearnServer()
                .getHistoryMessage()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::updateChats, Throwable::printStackTrace);

        LearnApp.getModuleManager()
                .getRemoteManager()
                .getSocketIoManager()
                .getChatManager()
                .getInputModelObservable()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::updateChats);
    }

    private void updateChats(ArrayList<MessageModel> messageModels) {
        messages.addAll(messageModels);
        view.updateChats(messages);
    }

    private void updateChats(MessageModel messageModels) {
        messages.add(messageModels);
        view.updateChats(messages);
    }

    @Override
    public void sendOnClick() {
        String message = view.getInputMessage();
        view.clearInputMessage();
        if (!checkValidSendMessage(message)) {
            return;
        }
        sendMessage(message);
    }

    private void sendMessage(String message) {
        MessageModel messageModel = new MessageModel();
        //===============================
        NameModel name = new NameModel();
        //===============================
        messageModel.setMessage(message);
        messageModel.setFrom(name.getInputName()); //TODO fix me please =_= // вроде fixed =)
        LearnApp.getModuleManager()
                .getRemoteManager()
                .getSocketIoManager()
                .getChatManager()
                .sendMessage(messageModel);

    }

    private boolean checkValidSendMessage(String message) {
        if (message == null || message.isEmpty()) {
            view.showErrorFromInputMessage(view.getContext().getString(R.string.message_can_no_be_empty));
            return false;
        }
        return true;
    }

}
