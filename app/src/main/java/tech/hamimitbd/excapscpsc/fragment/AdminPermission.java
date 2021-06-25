package tech.hamimitbd.excapscpsc.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import tech.hamimitbd.excapscpsc.R;


public class AdminPermission extends Fragment {
    Spinner spinnerMC, spinnerWU;
    Button newsBtn;
    EditText news;
    TextView showNews;
    public static final String SHARED_PRE = "shared";
    public static final String TEXT = "text";
    private String news1 ;


    public AdminPermission() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_admin_permission, container, false);
        spinnerMC = view.findViewById(R.id.category_spinner_id);
        spinnerWU = view.findViewById(R.id.wu_spinner_id);

        news = view.findViewById(R.id.news_txt_id);
        showNews = view.findViewById(R.id.save_news_txt_id);

        newsBtn = view.findViewById(R.id.news_publish_btn_id);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(requireContext(), R.array.membership, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMC.setAdapter(adapter);


        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(requireContext(), R.array.webUpload, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerWU.setAdapter(adapter1);


        newsBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                news1 = news.getText().toString();
                showNews.setText(news1);

                SharedPreferences sharedPreferences = requireContext().getSharedPreferences(SHARED_PRE, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(TEXT,showNews.getText().toString());
                editor.apply();


                publishNews();

            }
        });

        saveNews();


        return view;
    }

    private void saveNews() {

        SharedPreferences sharedPreferences = requireContext().getSharedPreferences(SHARED_PRE, Context.MODE_PRIVATE);
        String txt =  sharedPreferences.getString(TEXT,"");
        showNews.setText(txt);



    }





    private void publishNews() {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("News");

        String inputNews = news.getText().toString().trim();

        if (inputNews.isEmpty()) {

            news.setError("Input news to publish");
        } else {
            myRef.setValue(inputNews);

            Toast.makeText(getContext(), "News Published", Toast.LENGTH_SHORT).show();

        }


    }
}