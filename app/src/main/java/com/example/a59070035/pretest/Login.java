package com.example.a59070035.pretest;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Login extends Fragment {

    private EditText mUsername;
    private String sUsername;
    private Button btnLogin;
    public Login() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        btnLogin = getView().findViewById(R.id.login_btn);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mUsername = getView().findViewById(R.id.login_user);
                sUsername = mUsername.getText().toString();

                if (sUsername.toLowerCase().equals("admin")){
                    Log.d("System", " Hello " + sUsername);
                    getActivity()
                            .getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.main_view, new Menu())
                            .commit();
                }else
                    Toast.makeText(getActivity(), "User is wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
