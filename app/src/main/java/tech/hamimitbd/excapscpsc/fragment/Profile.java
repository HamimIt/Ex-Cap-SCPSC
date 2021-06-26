package tech.hamimitbd.excapscpsc.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import java.util.Objects;

import tech.hamimitbd.excapscpsc.R;


public class Profile extends Fragment {

    TextView name, fname, mname, dob,mobile;


    public Profile() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        //adding custom toolbar
        setHasOptionsMenu(true);
        Toolbar toolbar = view.findViewById(R.id.toolbar_profile);
        ((AppCompatActivity) requireActivity()).setSupportActionBar(toolbar);
        Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).setDisplayHomeAsUpEnabled(true);




        name = view.findViewById(R.id.name_id);
        fname = view.findViewById(R.id.fn_txt_id);
        mname = view.findViewById(R.id.mn_txt_id);
        dob = view.findViewById(R.id.dob_txt_id);
        mobile = view.findViewById(R.id.mob_txt_id);
/*
        Bundle bundle = getArguments();
        String nametv = bundle.getString("name");
        name.setText(nametv);

        String fnametv = bundle.getString("fname");
        fname.setText(fnametv);

        String mnametv = bundle.getString("mname");
        mname.setText(mnametv);

        String dobtv = bundle.getString("dob");
        dob.setText(dobtv);


        String mobtv = bundle.getString("mobile");
        mobile.setText(mobtv);*/




        return view;


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