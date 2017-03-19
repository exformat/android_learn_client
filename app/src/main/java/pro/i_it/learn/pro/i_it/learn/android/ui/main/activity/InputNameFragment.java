package pro.i_it.learn.pro.i_it.learn.android.ui.main.activity;

import android.content.Context;
//import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import pro.i_it.learn.R;
import pro.i_it.learn.pro.i_it.learn.android.remote.retorfit.model.UserModel;


/**
 * Created by exformat on 17.03.17.
 */

public class InputNameFragment extends Fragment {

    @BindView(R.id.btn_input_name)
    Button btn_input_name;
    @BindView(R.id.input_name)
    EditText input_name;
    @BindView(R.id.text_view_name)
    TextView nameView;

    /*
    public static final String APP_PREFERENCES = "my_nick_name";
    public static final String APP_PREFERENCES_COUNTER = "counter";
    private SharedPreferences mSettings;
    private String mCounter;
    */

    UserModel nickName = new UserModel();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_input_name, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    /*
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

    }*/



    @OnClick(R.id.btn_input_name)
    void onClick(){
        //присвоение никнейма по нажатию кнопки
        nickName.setNickName(input_name.getText().toString());
        nameView.setText(nickName.getNickName());

        //сскрытие клавиатуры при нажатии кнопки
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(btn_input_name.getWindowToken(),
               InputMethodManager.HIDE_NOT_ALWAYS);

        //нерабочая хрень которая пытается сохранить никнейм
        /*
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(APP_PREFERENCES_COUNTER, mCounter);
        editor.apply();
        */
    }


}
