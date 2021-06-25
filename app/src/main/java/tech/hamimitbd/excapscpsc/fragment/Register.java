package tech.hamimitbd.excapscpsc.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.util.Objects;

import tech.hamimitbd.excapscpsc.R;

import static android.app.Activity.RESULT_OK;

public class Register extends Fragment {
    CheckBox checkBox;
    EditText preDis, preThana, preVill, prePost, perDis, perThana, perVill, perPost;
   // AutoCompleteTextView autoCompleteTextView;

   /* String[] dis = {"Dhaka","Chittagong","Rangpur","Rajshahi",
                                "Jashore","Sylhet","Dinajpur","Mymensingh","Comilla"};

    ArrayAdapter<String> adapter;*/

    public Register() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_register, container, false);
        //adding custom toolbar
        setHasOptionsMenu(true);
        Toolbar toolbar = view.findViewById(R.id.toolbar_register);
        ((AppCompatActivity) requireActivity()).setSupportActionBar(toolbar);
        Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).setDisplayHomeAsUpEnabled(true);


        // present address
        preDis = view.findViewById(R.id.text_input_dis_id);
        preThana = view.findViewById(R.id.text_input_thana_id);
        preVill = view.findViewById(R.id.text_input_vill_id);
        prePost = view.findViewById(R.id.text_input_po_id);
        // permanent address
        perDis = view.findViewById(R.id.text_input_permanent_dis_id);
        perVill = view.findViewById(R.id.text_input_permanent_vil_id);
        perThana = view.findViewById(R.id.text_input_permanent_thana_id);
        perPost = view.findViewById(R.id.text_input_permanent_po_id);


        /*// autocomplete

        autoCompleteTextView = view.findViewById(R.id.auto_com1);
        autoCompleteTextView.setThreshold(1);
        autoCompleteTextView.setAdapter(adapter);


        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                preDis.setText(adapter.getItem(position));
            }
        });
*/

       /* // adapter
        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,dis);*/


        ImageView img = view.findViewById(R.id.reg_img_id);
        checkBox = view.findViewById(R.id.checkbox_id);


        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startCropActivity();

            }
        });


        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkBox.isChecked()) {

                    String permanentDis = preDis.getText().toString();
                    String permanentThana = preThana.getText().toString();
                    String permanentVll = preVill.getText().toString();
                    String permanentPost = prePost.getText().toString();

                    perDis.setText(permanentDis);
                    perThana.setText(permanentThana);
                    perVill.setText(permanentVll);
                    perPost.setText(permanentPost);


                } else {

                    perDis.setText("");
                    perThana.setText("");
                    perVill.setText("");
                    perPost.setText("");

                }


            }


        });


        return view;
    }


    private void startCropActivity() {

        CropImage.activity()
                .setGuidelines(CropImageView.Guidelines.ON)
                .start(getActivity().getApplicationContext(), Register.this);

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();

                ImageView img = requireActivity().findViewById(R.id.reg_img_id);

                img.setImageURI(resultUri);

            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_id, new HomeFragment()).commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}