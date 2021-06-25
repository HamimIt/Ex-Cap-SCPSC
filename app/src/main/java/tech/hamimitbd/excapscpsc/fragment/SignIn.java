package tech.hamimitbd.excapscpsc.fragment;

import android.os.Bundle;
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

import org.jetbrains.annotations.NotNull;

import tech.hamimitbd.excapscpsc.R;

public class SignIn extends Fragment {

    TextView signup, forgot_pass;

    private EditText email, pass;
    private Button signIn;

    private FirebaseAuth mAuth;

    public SignIn() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);

        signIn = view.findViewById(R.id.sign_in_id);

        email = view.findViewById(R.id.text_input_sn_email_id);
        pass = view.findViewById(R.id.text_input_sn_pass_id);


        signup = view.findViewById(R.id.sign_up_id);
        forgot_pass = view.findViewById(R.id.forgot_pass_id);


        mAuth = FirebaseAuth.getInstance();

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


        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                userSignIn();


            }
        });


        return view;


    }

    private void userSignIn() {

        String signInEmail = email.getText().toString().trim();
        String signInPass = pass.getText().toString().trim();

        if (signInEmail.isEmpty()) {
            email.setError("Email is required");
            email.requestFocus();
            return;

        }


        if (!Patterns.EMAIL_ADDRESS.matcher(signInEmail).matches()) {

            email.setError("please enter a valid email");
            email.requestFocus();
            return;

        }


        if (signInPass.isEmpty()) {

            pass.setError("Password is required");
            pass.requestFocus();
            return;
        }


        if (signInPass.length() < 8) {

            pass.setError("Enter at least 8 password");
            pass.requestFocus();
            return;
        }


        mAuth.signInWithEmailAndPassword(signInEmail, signInPass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {

                if (task.isSuccessful()) {

                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

                    if (user.isEmailVerified()) {

                        ((AppCompatActivity) requireActivity()).getSupportFragmentManager().beginTransaction().
                                replace(R.id.main_activity_id, new Register()).addToBackStack("stack").commit();

                    } else {
                        user.sendEmailVerification();
                        Toast.makeText(getContext(), "Check Your Email to Verify ", Toast.LENGTH_SHORT).show();
                    }




                } else {

                    Toast.makeText(getContext(), "Check your email to verify or signup", Toast.LENGTH_SHORT).show();

                }


            }
        });


    }


}