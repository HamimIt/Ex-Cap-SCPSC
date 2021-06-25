package tech.hamimitbd.excapscpsc.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import tech.hamimitbd.excapscpsc.AddWebCategory;
import tech.hamimitbd.excapscpsc.R;


public class WebCategory extends Fragment {

    EditText catName, catNum;
    Button ac;
    RecyclerView tableItem;


    public WebCategory() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_web_category, container, false);


        catName = view.findViewById(R.id.category_edit_txt_id);
        catNum = view.findViewById(R.id.nu_edit_txt_id);
        
        tableItem = view.findViewById(R.id.table_item_id);


        
        ac = view.findViewById(R.id.add_category_btn_id);
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                addCategory();


            }
        });


        return view;
    }


    private void addCategory() {

        String inputName = catName.getText().toString().trim();
        String inputNum = catNum.getText().toString().trim();

        AddWebCategory addWebCategory = new AddWebCategory(inputName, inputNum);

        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference node = db.getReference().child("AddCategory");
        node.child(catName.getText().toString()).setValue(addWebCategory);


        if (inputName.isEmpty()) {
            catName.setError("Input text to publish");

        }


        if (inputNum.isEmpty()) {
            catNum.setError("Input text to publish");

        }


        // node.child(catName.getText().toString()).setValue("");

        catName.setText("");
        catNum.setText("");

        Toast.makeText(getContext(), "Category Added", Toast.LENGTH_SHORT).show();





        /*
        DatabaseReference myRef = database.getReference("AddCategory");


        if (inputName.isEmpty()) {

            catName.setError("Input news to publish");

        }
        if (inputNum.isEmpty()){

            catNum.setError("Input news to publish");
        }

        else {


            myRef.setValue(inputName);

        }*/


    }


}