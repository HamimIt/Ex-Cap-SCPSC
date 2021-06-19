package tech.hamimitbd.excapscpsc.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import tech.hamimitbd.excapscpsc.R;


public class SignUp extends Fragment {


    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("message");

    EditText name, mobile, email, pass, conPass;

    TextView singin;


    public SignUp() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);


        // firebase auth

        myRef.setValue("Hello, World!");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d(getTag(), "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w(getTag(), "Failed to read value.", error.toException());
            }
        });


        // firebase auth




        // findview by id

        name = view.findViewById(R.id.text_input_name_id);
        mobile = view.findViewById(R.id.text_input_mobile_id);
        email = view.findViewById(R.id.text_input_email_id);
        pass = view.findViewById(R.id.text_input_pass_id);
        conPass = view.findViewById(R.id.text_input_re_pass_id);
        // edit text layouts

        singin = view.findViewById(R.id.signup_signin_id);
        singin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment newFragment = new SignIn();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_activity_id, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();


            }
        });




      /*  private String name;
        private String mobile;
        private String email;
        private String pass;
        private String conPass;*/





        return view;

    }









}