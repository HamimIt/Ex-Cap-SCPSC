package tech.hamimitbd.excapscpsc.fragment;

import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import tech.hamimitbd.excapscpsc.R;
import tech.hamimitbd.excapscpsc.User_SignUp;


public class SignUp extends Fragment {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef;

    EditText name, mobile, email, pass, conPass;
    TextView singin;
    Button signup;


    private FirebaseAuth mAuth;


    public SignUp() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);

        // firebase auth
        // myRef.setValue("Hello, World!");

        // findview by id
        name = view.findViewById(R.id.text_input_name_id);
        mobile = view.findViewById(R.id.text_input_mobile_id);
        email = view.findViewById(R.id.text_input_email_id);
        pass = view.findViewById(R.id.text_input_pass_id);
        //conPass = view.findViewById(R.id.text_input_re_pass_id);
        // edit text layouts

        signup = view.findViewById(R.id.sign_up_id);
        myRef = FirebaseDatabase.getInstance().getReference("UserInfo");

        // firebase auth
        mAuth = FirebaseAuth.getInstance();


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


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });


        // kheye aschi ami tumi dekho okok
        /* AwesomeValidation.addValidation(this.,R.id.text_input_re_pass_id, String.valueOf(Pattern.compile(String.valueOf(Pattern.compile("[a-zA-Z\\s]+")))), R.string.not_match);
        AwesomeValidation.addValidation(getActivity(), R.id.edt_tel, RegexTemplate.TELEPHONE, R.string.err_tel);
        AwesomeValidation.addValidation(getActivity(), R.id.edt_email, android.util.Patterns.EMAIL_ADDRESS, R.string.err_email);
        AwesomeValidation.addValidation(getActivity(), R.id.edt_year, Range.closed(1900, Calendar.getInstance().get(Calendar.YEAR)), R.string.err_year);
        AwesomeValidation.addValidation(getActivity(), R.id.edt_height, Range.closed(0.0f, 2.72f), R.string.err_height);
         */


        return view;

    }


    private void registerUser() {

        String inputName = name.getText().toString().trim();
        String inputMobile = mobile.getText().toString().trim();
        String inputEmail = email.getText().toString().trim();
        String inputPass = pass.getText().toString().trim();
        //String inputConPass = conPass.getText().toString().trim();


        if (inputName.isEmpty()) {

            name.setError("Full name is required");
            name.requestFocus();
            return;

        }


        if (inputMobile.isEmpty()) {

            mobile.setError("Inout Valid Number");
            mobile.requestFocus();
            return;

        }


        if (inputEmail.isEmpty()) {

            email.setError("Required Real Email");
            email.requestFocus();
            return;

        }

        if (!Patterns.EMAIL_ADDRESS.matcher(inputEmail).matches()) {
            email.setError("Please Enter Valid Email");
            email.requestFocus();
            return;

        }

        if (inputPass.isEmpty()) {
            pass.setError("Enter Password");
            pass.requestFocus();
            return;

        }


        if (inputPass.length() < 8) {
            pass.setError("Enter at least 8 password");
            pass.requestFocus();
            return;

        }


        mAuth.createUserWithEmailAndPassword(inputEmail, inputPass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            User_SignUp user_signUp = new User_SignUp(inputName, inputMobile, inputEmail, inputPass);
                            Log.d("values", "" + FirebaseAuth.getInstance().getCurrentUser().getUid());
                            Log.d("values", user_signUp.getName() + " " + user_signUp.getEmail() + " " + user_signUp.getMobile() + " " + user_signUp.getPass());
                            myRef.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue(user_signUp).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull @NotNull Task<Void> task) {

                                    if (task.isSuccessful()) {


                                        ((AppCompatActivity) requireActivity()).getSupportFragmentManager().beginTransaction().
                                                replace(R.id.main_activity_id, new SignIn()).addToBackStack("stack").commit();


                                        Toast.makeText(getContext(), "Sign up Successfully", Toast.LENGTH_SHORT).show();
                                    } else {

                                        Toast.makeText(getContext(), "Sign up failed! Try again", Toast.LENGTH_SHORT).show();

                                    }

                                }
                            });


                        } else {

                            Toast.makeText(getContext(), "Sign up failed! Try again", Toast.LENGTH_SHORT).show();

                        }


                    }
                });


    }
}