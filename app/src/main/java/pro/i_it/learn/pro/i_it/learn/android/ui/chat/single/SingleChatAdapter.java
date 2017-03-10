package pro.i_it.learn.pro.i_it.learn.android.ui.chat.single;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import pro.i_it.learn.R;
import pro.i_it.learn.pro.i_it.learn.android.remote.retorfit.model.MessageModel;

/**
 * Created by syn on 08.03.17.
 */

public class SingleChatAdapter extends RecyclerView.Adapter<SingleChatAdapter.Holder> {
    private ArrayList<MessageModel> messageModels;


    public SingleChatAdapter() {
        messageModels = new ArrayList<>();
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_single_chat, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.from.setText((messageModels.get(position).getFrom() == null || messageModels.get(position).getFrom().isEmpty()) ? "From not Set" : messageModels.get(position).getFrom());
        holder.message.setText(messageModels.get(position).getMessage());
    }


    @Override
    public int getItemCount() {
        return messageModels.size();
    }

    public void update(ArrayList<MessageModel> messageModels) {
        this.messageModels.clear();
        if (messageModels != null) {
            this.messageModels.addAll(messageModels);
        }
        notifyDataSetChanged();
    }

    public static class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.view_single_chat_message)
        public TextView message;
        @BindView(R.id.view_single_chat_from)
        public TextView from;

        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
