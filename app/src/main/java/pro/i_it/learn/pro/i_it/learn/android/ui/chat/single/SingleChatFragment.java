package pro.i_it.learn.pro.i_it.learn.android.ui.chat.single;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pro.i_it.learn.R;
import pro.i_it.learn.pro.i_it.learn.android.remote.retorfit.model.MessageModel;

/**
 * Created by syn on 08.03.17.
 */

public class SingleChatFragment extends Fragment implements ISingleChatView {
    @BindView(R.id.fragment_single_chat)
    protected RecyclerView recyclerView;
    private SingleChatAdapter adapter;
    @BindView(R.id.fragment_single_chat_input_message)
    protected EditText imputMessage;

    private ISingleChatViewPresenter presenter;

    public SingleChatFragment() {
        presenter = new SingleChatPresenter();
        adapter = new SingleChatAdapter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_single_chat, container, false);
        ButterKnife.bind(this, rootView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        presenter.init(this);
        return rootView;
    }

    @OnClick(R.id.fragment_single_chat_send)
    void sendOnClick() {
        presenter.sendOnClick();
    }

    @Override
    public void updateChats(ArrayList<MessageModel> messageModels) {
        adapter.update(messageModels);
        recyclerView.scrollToPosition(messageModels.size() - 1);
    }

    @Override
    public String getInputMessage() {
        return imputMessage.getText().toString();
    }

    @Override
    public void clearInputMessage() {
        imputMessage.getText().clear();
        imputMessage.setError(null);
    }

    @Override
    public void showErrorFromInputMessage(String errorMessage) {
        imputMessage.setError(errorMessage);
    }
}
