package tech.hamimitbd.excapscpsc.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.util.Objects;

import tech.hamimitbd.excapscpsc.R;

import static android.app.Activity.RESULT_OK;

public class Register extends Fragment {
    CheckBox checkBox;
    EditText name, fname, mname, dob,mobile, passYear,lastClass,instNameAddress,group,releg,lastIns,
            preprofession,workingplce,blood,gender,preDis, preThana, preVill, prePost, perDis, perThana,
            perVill, perPost,tom;


    TextView tvname,tvfname,tvmname,tvdob,tvmobile,tvpassyear,tvlastclass,tvinst,tvgroup,
            tvreleg,tvlastinst, tvpp,tvwp,tvblood,tvgender,tvpredis,tvpreThana,tvpreVill
            ,tvprePost, tvperDis, tvperThana, tvperVill, tvperPost,tvtom;


    Button save;


    public static final String SAVEDSHARED_PRE = "myref";
    public static final String Name_Key = "name";

    /*public static final String FAName_Key = "father";
    public static final String MAName_Key = "mother";
    public static final String DOB_Key = "dob";
    public static final String MO_Key = "mobile";
    public static final String PY_Key = "py";
    public static final String LC_Key = "lc";
    public static final String INA_Key = "ina";
    public static final String G_Key = "g";
    public static final String R_Key = "r";
    public static final String LIN_Key = "lin";
    public static final String PP_Key = "pp";
    public static final String WP_Key = "wp";
    public static final String BG_Key = "bg";
    public static final String GENDER_Key = "gender";
    public static final String PRED_Key = "pred";
    public static final String PRET_Key = "pret";
    public static final String PREV_Key = "prev";
    public static final String PREPC_Key = "prepc";
    public static final String PERD_Key = "perd";
    public static final String PERT_Key = "pert";
    public static final String PERV_Key = "perv";
    public static final String PERPC_Key = "perpc";
    public static final String MC_Key = "mc";*/


    private String n,fn,mn,regdob,mo,py,pc,ina,pp,wc,bg,g,pd,pt,pv,ppc, ped,pet,pev,pepc,mt ;



    // AutoCompleteTextView autoCompleteTextView;
   /* String[] dis = {"Dhaka","Chittagong","Rangpur","Rajshahi",
   "Jashore","Sylhet","Dinajpur","Mymensingh","Comilla"};
    ArrayAdapter<String> adapter;*/

    public Register() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_register, container, false);
        //adding custom toolbar
        setHasOptionsMenu(true);
        Toolbar toolbar = view.findViewById(R.id.toolbar_register);
        ((AppCompatActivity) requireActivity()).setSupportActionBar(toolbar);
        Objects.requireNonNull(((AppCompatActivity) requireActivity()).getSupportActionBar()).setDisplayHomeAsUpEnabled(true);



        AdView adView = new AdView(getContext());
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");



        /// find edit text
        name = view.findViewById(R.id.text_input_name_id);
        fname = view.findViewById(R.id.text_input_fname_id);
        mname = view.findViewById(R.id.text_input_mname_id);
        dob = view.findViewById(R.id.text_input_dob_id);
        mobile = view.findViewById(R.id.text_input_mobile_id);
        passYear= view.findViewById(R.id.text_input_yop_id);
        lastClass= view.findViewById(R.id.text_input_lc_id);
        instNameAddress = view.findViewById(R.id.text_input_inaa_id);
        group = view.findViewById(R.id.text_input_group_id);
        releg = view.findViewById(R.id.text_input_religion_id);
        lastIns = view.findViewById(R.id.text_input_lin_id);
        preprofession = view.findViewById(R.id.text_input_pp_id);
        workingplce = view.findViewById(R.id.text_input_wp_id);
        blood = view.findViewById(R.id.text_input_bg_id);
        gender = view.findViewById(R.id.text_input_gender_id);
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

        tom = view.findViewById(R.id.text_input_tom_id);

        //find textview
        tvname= view.findViewById(R.id.saved_name_id);
        tvfname= view.findViewById(R.id.saved_fn_txt_id);
        tvmname= view.findViewById(R.id.saved_mn_txt_id);
        tvdob= view.findViewById(R.id.saved_dob_txt_id);
        tvmobile= view.findViewById(R.id.saved_mob_txt_id);
        tvpassyear= view.findViewById(R.id.saved_py_txt_id);
        tvlastclass= view.findViewById(R.id.saved_pc_txt_id);
        tvinst= view.findViewById(R.id.saved_ina_txt_id);
        tvgroup= view.findViewById(R.id.saved_group_txt_id);
        tvreleg= view.findViewById(R.id.saved_religion_txt_id);
        tvlastinst= view.findViewById(R.id.saved_li_txt_id);
        tvpp= view.findViewById(R.id.saved_pp_txt_id);
        tvwp= view.findViewById(R.id.saved_wp_txt_id);
        tvblood= view.findViewById(R.id.saved_bg_txt_id);
        tvgender= view.findViewById(R.id.saved_gender_txt_id);
        tvpredis= view.findViewById(R.id.saved_pre_dis_txt_id);
        tvpreThana= view.findViewById(R.id.saved_pre_thana_txt_id);
        tvpreVill= view.findViewById(R.id.saved_pre_vill_txt_id);
        tvprePost= view.findViewById(R.id.saved_pre_po_txt_id);
        tvperDis= view.findViewById(R.id.saved_per_dis_txt_id);
        tvperThana= view.findViewById(R.id.saved_per_thana_txt_id);
        tvperVill= view.findViewById(R.id.saved_per_vill_txt_id);
        tvperPost= view.findViewById(R.id.saved_per_po_txt_id);
        tvtom= view.findViewById(R.id.saved_mem_type_txt_id);



        save = view.findViewById(R.id.save_btn_id);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = requireContext().getSharedPreferences(SAVEDSHARED_PRE, Context.MODE_PRIVATE);
                n = name.getText().toString();
                tvname.setText(n);
                SharedPreferences.Editor nam = sharedPreferences.edit();
                nam.putString(Name_Key,tvname.getText().toString());
                nam.apply();

                fn = fname.getText().toString();
                tvfname.setText(fn);
                SharedPreferences.Editor fanam = sharedPreferences.edit();
                fanam.putString(Name_Key,tvfname.getText().toString());
                fanam.apply();

/*
                mn = mname.getText().toString();
                tvmname.setText(mn);

                regdob = dob.getText().toString();
                tvdob.setText(regdob);

                fn = fname.getText().toString();
                tvfname.setText(fn);

                mo = mobile.getText().toString();
                tvmobile.setText(mo);

                py = passYear.getText().toString();
                tvpassyear.setText(py);

                pc = lastClass.getText().toString();
                tvlastclass.setText(pc);

                ina = instNameAddress.getText().toString();
                tvinst.setText(ina);

                pp = preprofession.getText().toString();
                tvpp.setText(pp);

                wc = workingplce.getText().toString();
                tvwp.setText(wc);

                bg = blood.getText().toString();
                tvblood.setText(bg);

                g = group.getText().toString();
                tvgroup.setText(g);

                pd = perDis.getText().toString();
                tvperDis.setText(pd);

                pt = perThana.getText().toString();
                tvperThana.setText(pt);

                pv = perVill.getText().toString();
                tvperVill.setText(pv);

                ppc = perPost.getText().toString();
                tvperPost.setText(ppc);

                ped = perDis.getText().toString();
                tvperDis.setText(ped);

                pet = perThana.getText().toString();
                perThana.setText(pet);

                pev = perVill.getText().toString();
                perVill.setText(pev);

                pepc = perPost.getText().toString();
                perPost.setText(pepc);

                mt = tom.getText().toString();
                tom.setText(mt);
*/






                /*

                Bundle bundle = new Bundle();
                bundle.putString("name", name.getText().toString());
                bundle.putString("fname", fname.getText().toString());
                bundle.putString("mname", mname.getText().toString());
                bundle.putString("dob", dob.getText().toString());
                bundle.putString("mobile", mobile.getText().toString());


                Profile profile = new Profile();
                profile.setArguments(bundle);

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.main_activity_id, profile);
                transaction.addToBackStack(null);
                transaction.commit();
*/

            }
        });


        rersaveNews();



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

    private void rersaveNews() {

        SharedPreferences sharedPreferences = requireContext().getSharedPreferences(SAVEDSHARED_PRE, Context.MODE_PRIVATE);
        String nam =  sharedPreferences.getString(Name_Key,"");
        tvname.setText(nam);

        String fnam =  sharedPreferences.getString(Name_Key,"");
        tvfname.setText(fnam);




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