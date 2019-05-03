package com.dvinfosys.androidcustomnavigationdrawerusingexpandablelistview.Activity;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dvinfosys.androidcustomnavigationdrawerusingexpandablelistview.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.

 */
public class LoginFragment extends Fragment {
    private TextView RegText;
    private EditText UserName , UserPassword ;
    private Button loginBn;

    OnLoginFormActivityListener loginFormActivityListener ;
    public  interface OnLoginFormActivityListener
    {
        public void performRegister();
        public void performLogin(String name);

    }

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_login, container, false);

        RegText = view.findViewById(R.id.register_txt);
        UserName = view.findViewById(R.id.user_name);
        UserPassword = view.findViewById(R.id.user_pass);
        loginBn = view.findViewById(R.id.login_bn);
        loginBn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performLogin();
            }
        });

        RegText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                loginFormActivityListener.performRegister();

            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        loginFormActivityListener =(OnLoginFormActivityListener) activity;

    }

    private void performLogin()
    {
        String username = UserName.getText().toString();
        String password = UserPassword.getText().toString();

        Call<User> call = CompteCravateConnexion2.apiInterface.performUserLogin(username,password);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                if (response.body().getResponse().equals("ok"))
                {
                    CompteCravateConnexion2.prefConfig.writeLoginStatus(true);
                    loginFormActivityListener.performLogin(response.body().getName());
                }
                else if (response.body().getResponse().equals("Failed")){
                    CompteCravateConnexion2.prefConfig.displayToast("Login Failed...please try again");
                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {

            }
        });


        UserName.setText("");
        UserPassword.setText("");

    }

}
