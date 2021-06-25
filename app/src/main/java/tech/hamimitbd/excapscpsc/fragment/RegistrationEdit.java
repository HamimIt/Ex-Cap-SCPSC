package tech.hamimitbd.excapscpsc.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import tech.hamimitbd.excapscpsc.R;


public class RegistrationEdit extends Fragment {

    Toolbar toolbar;


    public RegistrationEdit() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_registration_edit, container, false);


        toolbar = (Toolbar) view.findViewById(R.id.toolbar_reg_edit);
        ((AppCompatActivity) requireActivity()).setSupportActionBar(toolbar);



      /* toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
        ((AppCompatActivity) requireActivity()).getSupportActionBar().setDisplayShowTitleEnabled(false);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        toolbar = view.findViewById(R.id.toolbar_reg_edit);
        ((AppCompatActivity) requireActivity()).setSupportActionBar(toolbar);
*/


        return view;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.menu, menu);

        MenuItem item = menu.findItem(R.id.search_btn_id);
        SearchView searchView = (SearchView) item.getActionView();


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {


                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {


                return false;
            }
        });


        super.onCreateOptionsMenu(menu, inflater);
    }






    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {



        return super.onOptionsItemSelected(item);
    }*/
}