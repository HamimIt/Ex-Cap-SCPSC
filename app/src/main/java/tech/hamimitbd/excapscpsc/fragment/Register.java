package tech.hamimitbd.excapscpsc.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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

    public Register() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_register, container, false);
        //adding custom toolbar
        Toolbar toolbar = view.findViewById(R.id.toolbar_register);
        ((AppCompatActivity) requireActivity()).setSupportActionBar(toolbar);
        Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).setDisplayHomeAsUpEnabled(true);


        ImageView img = view.findViewById(R.id.reg_img_id);


        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startCropActivity();

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