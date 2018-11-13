package it_geeks.info.gawla_app;



import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import it_geeks.info.gawla_app.Adapters.ProductImageAdapter;
import it_geeks.info.gawla_app.Models.RoundUpdate;

public class HaleActivity extends AppCompatActivity {
    int joined = 0;
    Button btnJoineRound,btnJoineRound2,btnJoineRound3;
    RelativeLayout rDivPro1,rDivPro2,rDivPro3,rDivPro4;
    LinearLayout shadowalert,shadowalert2;
    TextView txtReadMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hale);

        btnJoineRound = findViewById(R.id.btnJoineRound);
        btnJoineRound2 = findViewById(R.id.btnJoineRound2);
        btnJoineRound3 = findViewById(R.id.btnJoineRound3);
        rDivPro1 = findViewById(R.id.divPro1);
        rDivPro2 = findViewById(R.id.divPro2);
        rDivPro3 = findViewById(R.id.divPro3);
        rDivPro4 = findViewById(R.id.divPro4);
        shadowalert = findViewById(R.id.shadowalert);
        shadowalert2 = findViewById(R.id.shadowalert2);
        txtReadMore = findViewById(R.id.txtReadMore);

        //open round updates activity
        findViewById(R.id.hales_open_round_updates).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HaleActivity.this, RoundUpdatesActivity.class));
            }
        });


        btnJoineRound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rDivPro1.setVisibility(View.GONE);
                rDivPro2.setVisibility(View.GONE);
                rDivPro3.setVisibility(View.INVISIBLE);
                btnJoineRound.setVisibility(View.INVISIBLE);
                shadowalert.setVisibility(View.VISIBLE);
            }
        });

        shadowalert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rDivPro1.setVisibility(View.VISIBLE);
                rDivPro2.setVisibility(View.VISIBLE);
                rDivPro3.setVisibility(View.GONE);
                btnJoineRound.setVisibility(View.VISIBLE);
                shadowalert.setVisibility(View.GONE);
            }
        });

        btnJoineRound2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shadowalert2.setVisibility(View.VISIBLE);
                shadowalert.setVisibility(View.GONE);
                joined = 1;
            }
        });
        btnJoineRound3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rDivPro1.setVisibility(View.VISIBLE);
                rDivPro2.setVisibility(View.VISIBLE);
                shadowalert2.setVisibility(View.GONE);
                rDivPro3.setVisibility(View.GONE);
                btnJoineRound.setVisibility(View.GONE);
                rDivPro4.setVisibility(View.VISIBLE);
            }
        });
        txtReadMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductDetailsFragment productDetailsFragment = new ProductDetailsFragment();
                setFragment(productDetailsFragment);
            }
        });
    }
    protected void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(android.R.id.content, fragment);
        fragmentTransaction.commit();
    }
    @Override
    public void onBackPressed() {

        if (joined == 0){
          if(ProductDetailsFragment.xPro == 1){
            ProductDetailsFragment.frameLayout.setVisibility(View.GONE);
            ProductDetailsFragment.xPro = 0;
              HaleActivity.this.getWindow().setStatusBarColor(getResources().getColor(R.color.paleGrey));
          }else{
              rDivPro1.setVisibility(View.VISIBLE);
              rDivPro2.setVisibility(View.VISIBLE);
              rDivPro3.setVisibility(View.GONE);
              btnJoineRound.setVisibility(View.VISIBLE);
              shadowalert.setVisibility(View.GONE);
              shadowalert.setVisibility(View.GONE);
              super.onBackPressed();
          }
        }else if(joined == 1){
            if(ProductDetailsFragment.xPro == 1){
                ProductDetailsFragment.frameLayout.setVisibility(View.GONE);
                ProductDetailsFragment.xPro = 0;
                HaleActivity.this.getWindow().setStatusBarColor(getResources().getColor(R.color.paleGrey));
            }else {
                rDivPro1.setVisibility(View.VISIBLE);
                rDivPro2.setVisibility(View.VISIBLE);
                shadowalert2.setVisibility(View.GONE);
                rDivPro3.setVisibility(View.GONE);
                btnJoineRound.setVisibility(View.GONE);
                rDivPro4.setVisibility(View.VISIBLE);
                super.onBackPressed();
            }
        }


    }




}