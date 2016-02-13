package com.example.kimjh.autologinpj;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class LoginFragment extends Fragment {

    public LoginFragment() {
        // Required empty public constructor
    }

    EditText idView, pwView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        idView = (EditText)view.findViewById(R.id.edit_id);
        pwView = (EditText)view.findViewById(R.id.edit_password);
        Button btn = (Button)view.findViewById(R.id.btn_login);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String userId = idView.getText().toString();
                final String password = pwView.getText().toString();

                NetworkManager.getInstance().login(getContext(), userId, password, new NetworkManager.OnResultListener<String>() {
                    @Override
                    public void onSuccess(String result) {
                        PropertyManager.getInstance().setUserId(userId);
                        PropertyManager.getInstance().setPassword(password);
                        startActivity(new Intent(getContext(), MainActivity.class));
                        getActivity().finish();
                    }

                    @Override
                    public void onFailure(int code) {

                    }
                });
            }
        });


        btn = (Button)view.findViewById(R.id.btn_signup);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((LoginActivity)getActivity()).changeSignup();
            }
        });
        return view;
    }




}
