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
import android.widget.TextView;

import com.dvinfosys.androidcustomnavigationdrawerusingexpandablelistview.R;

/**
 * A simple {@link Fragment} subclass.

 */
public class WelcomeFragment extends Fragment {
    private TextView textView ;
    private Button BnLogout ;

    OnLogoutListener logoutListener;

    public interface  OnLogoutListener
    {
        public void logoutPerFormed();
    }
    public WelcomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_welcome, container, false);

        textView = view.findViewById(R.id.txt_name_info);
        textView.setText("Welcome   "+CompteCravateConnexion2.prefConfig.readName());
        BnLogout=view.findViewById(R.id.bn_logout);
        BnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutListener.logoutPerFormed();
            }
        });
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity = (Activity) context;
        logoutListener=(OnLogoutListener)activity;
    }
}
