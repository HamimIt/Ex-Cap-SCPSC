package tech.hamimitbd.excapscpsc.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.StringTokenizer;

import tech.hamimitbd.excapscpsc.R;


public class WebUpload extends Fragment {

    Spinner categorySpinner;
    DatabaseReference dbref;

    ValueEventListener listener;
    ArrayList<String> list;
    ArrayAdapter<String>adapter;


    public WebUpload() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_web_upload, container, false);

        categorySpinner = view.findViewById(R.id.select_category_id);



        list= new ArrayList<String>();
        adapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(adapter);

        fetchData();




/*
      ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_dropdown_item, getList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(adapter);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("AddCategory");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                adapter.add(dataSnapshot.getValue().toString());
                adapter.notifyDataSetChanged();


                }

            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });*/



        return view;
    }

    private void fetchData() {

        dbref = FirebaseDatabase.getInstance().getReference().child("AddCategory");

        listener = dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren())
                    list.add(dataSnapshot.getValue().toString());
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });


    }




}