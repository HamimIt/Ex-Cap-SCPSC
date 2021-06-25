package tech.hamimitbd.excapscpsc.fragment;

import android.content.Context;
import android.content.SharedPreferences;
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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import org.jetbrains.annotations.NotNull;

import tech.hamimitbd.excapscpsc.R;
import tech.hamimitbd.excapscpsc.SliderAdapter;


public class HomeFragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener {

    public static final String SHARED_PRE = "shared";
    public static final String TEXT = "text";
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    TextView noticetxt;

    // publish news
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef;

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


        // navigation menu
        drawerLayout = view.findViewById(R.id.drawer_layout_id);
        navigationView = view.findViewById(R.id.nav_view_id);
        toolbar = view.findViewById(R.id.toolbar_id);
        noticetxt = view.findViewById(R.id.show_news_txt_id);


        ((AppCompatActivity) requireActivity()).setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(((AppCompatActivity) requireActivity()), drawerLayout, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setHomeAsUpIndicator(R.drawable.menu_icon);

        // navigation menu


        // News slider
        noticetxt.setMarqueeRepeatLimit(-1);
        noticetxt.setHorizontallyScrolling(true);
        noticetxt.setSingleLine();
        noticetxt.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        noticetxt.setSelected(true);
        // news slider


        // slide images
        sliderView = view.findViewById(R.id.image_slider);
        SliderAdapter sliderAdapter = new SliderAdapter(images);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderView.startAutoCycle();

        //slider images


        // navigation menu
        navigationView.setNavigationItemSelectedListener(this);


        // publish news
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("News");


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {

                String news = snapshot.getValue(String.class);
                noticetxt.setText(news);

                SharedPreferences sharedPreferences = requireContext().getSharedPreferences(SHARED_PRE, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(TEXT, noticetxt.getText().toString());
                editor.apply();


            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {


            }
        });


        saveNews();


        return view;

    }

    private void saveNews() {

        SharedPreferences sharedPreferences = requireContext().getSharedPreferences(SHARED_PRE, Context.MODE_PRIVATE);
        String txt = sharedPreferences.getString(TEXT, "");
        noticetxt.setText(txt);


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


            case R.id.nav_wc:
                ((AppCompatActivity) requireActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_id, new WebCategory()).addToBackStack("stack").commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;


            case R.id.nav_wu:
                ((AppCompatActivity) requireActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_id, new WebUpload()).addToBackStack("stack").commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;


            case R.id.nav_profile:
                ((AppCompatActivity) requireActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_id, new Profile()).addToBackStack("stack").commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;


            case R.id.nav_admin:
                ((AppCompatActivity) requireActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_id, new AdminPermission()).addToBackStack("stack").commit();
                drawerLayout.closeDrawer(GravityCompat.START);
                break;


            case R.id.nav_id_card:
                ((AppCompatActivity) requireActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_id, new ID_Card()).addToBackStack("stack").commit();
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


            case R.id.nav_regEdit:
                ((AppCompatActivity) requireActivity()).getSupportFragmentManager().beginTransaction().replace(R.id.main_activity_id, new RegistrationEdit()).addToBackStack("stack").commit();
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