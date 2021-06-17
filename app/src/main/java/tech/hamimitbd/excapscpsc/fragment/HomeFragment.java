package tech.hamimitbd.excapscpsc.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import tech.hamimitbd.excapscpsc.R;
import tech.hamimitbd.excapscpsc.SliderAdapter;


public class HomeFragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;
    Toolbar toolbar;

    SliderView sliderView;
    int[] images = {R.drawable.one, R.drawable.two,
            R.drawable.three, R.drawable.four,
            R.drawable.five, R.drawable.six,
            R.drawable.seven, R.drawable.eight,
            R.drawable.nine, R.drawable.ten,

    };


    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        drawerLayout = view.findViewById(R.id.drawer_layout_id);
        navigationView = view.findViewById(R.id.nav_view_id);
        toolbar = view.findViewById(R.id.toolbar_id);


        ((AppCompatActivity) requireActivity()).setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(((AppCompatActivity) requireActivity()), drawerLayout, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();


        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setHomeAsUpIndicator(R.drawable.menu_icon);


        // slide images
        sliderView = view.findViewById(R.id.image_slider);
        SliderAdapter sliderAdapter = new SliderAdapter(images);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();

        //slider images


        // notice bar

        TextView noticetxt = view.findViewById(R.id.notice_txt_id);
        noticetxt.setMarqueeRepeatLimit(-1);
        noticetxt.setHorizontallyScrolling(true);
        noticetxt.setSingleLine();
        noticetxt.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        noticetxt.setSelected(true);


        navigationView.setNavigationItemSelectedListener(this);


        return view;

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.nav_home:
                ((AppCompatActivity) requireActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_id, new HomeFragment()).addToBackStack("stack").commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;


            case R.id.nav_notice:
                ((AppCompatActivity) requireActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_id, new Notice()).addToBackStack("stack").commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;


            case R.id.nav_profile:
                ((AppCompatActivity) requireActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_id, new Profile()).addToBackStack("stack").commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;


            case R.id.nav_payment:
                ((AppCompatActivity) requireActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_id, new Payment()).addToBackStack("stack").commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;


            case R.id.nav_committee:
                ((AppCompatActivity) requireActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_id, new Committee()).addToBackStack("stack").commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.nav_advisor:
                ((AppCompatActivity) requireActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_id, new Advisor()).addToBackStack("stack").commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;


            case R.id.nav_staff:
                ((AppCompatActivity) requireActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_id, new Executive_Staf()).addToBackStack("stack").commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;


            case R.id.nav_register:
                ((AppCompatActivity) requireActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_id, new Register()).addToBackStack("stack").commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;


            case R.id.nav_registered:
                ((AppCompatActivity) requireActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_id, new Total_Register()).addToBackStack("stack").commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;


            case R.id.nav_chat:
                ((AppCompatActivity) requireActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_id, new General_Chat()).addToBackStack("stack").commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;


            case R.id.nav_signin:
                ((AppCompatActivity) requireActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_id, new SignIn()).addToBackStack("stack").commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;


            case R.id.nav_about:
                ((AppCompatActivity) requireActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_id, new About_App()).addToBackStack("stack").commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;


            case R.id.nav_logout:

                break;


            case R.id.nav_share:

                break;


        }


        return true;
    }


}