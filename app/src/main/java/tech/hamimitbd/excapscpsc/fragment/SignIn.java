package tech.hamimitbd.excapscpsc.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import tech.hamimitbd.excapscpsc.R;

public class SignIn extends Fragment {


    TextView signup, forgot_pass;

    public SignIn() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);


        signup = view.findViewById(R.id.sign_up_id);
        forgot_pass = view.findViewById(R.id.forgot_pass_id);


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Fragment newFragment = new SignUp();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_activity_id, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();


            }
        });


        return view;


    }





}