package tech.hamimitbd.excapscpsc;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import tech.hamimitbd.excapscpsc.fragment.HomeFragment;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        HomeFragment homeFragment = new HomeFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().add(R.id.main_activity_id, homeFragment).addToBackStack("stack").commit();


    }


    @Override
    protected void onPause() {
        super.onPause();

    }

    void backDialog(){

        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();

                    }
                })
                .setNegativeButton("No", null)
                .show();
        /*super.onBackPressed();*/

    }
    // on back press
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();

        if (count == 1) {
            Log.d("mms", String.valueOf(count));
            backDialog();
            //additional code
        } else {
            getSupportFragmentManager().popBackStack();
        }

        Log.d("click","ok");


    }



}