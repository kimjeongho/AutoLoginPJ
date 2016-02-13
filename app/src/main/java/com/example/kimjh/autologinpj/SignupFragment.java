package com.example.kimjh.autologinpj;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignupFragment extends Fragment {


    public SignupFragment() {
        // Required empty public constructor
    }

    EditText idView, pwView, nameView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        idView = (EditText)view.findViewById(R.id.edit_id);
        pwView = (EditText)view.findViewById(R.id.edit_password);
        nameView = (EditText)view.findViewById(R.id.edit_name);

        Button btn = (Button)view.findViewById(R.id.btn_signup);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String userId = idView.getText().toString();
                final String password = pwView.getText().toString();
                final String username = nameView.getText().toString();
                NetworkManager.getInstance().signup(getContext(), userId, password, username, new NetworkManager.OnResultListener<String>() {
                    @Override
                    public void onSuccess(String result) {
                        PropertyManager.getInstance().setUserId(userId);
                        PropertyManager.getInstance().setPassword(password);
                    }

                    @Override
                    public void onFailure(int code) {

                    }
                });

            }
        });
        return view;
    }

}
