package tech.hamimitbd.excapscpsc.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import tech.hamimitbd.excapscpsc.R;

public class ID_Card extends Fragment {


    public ID_Card() { }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_id_card, container, false);


        return view;
    }
}