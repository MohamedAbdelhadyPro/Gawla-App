package it_geeks.info.gawla_app;

import android.content.Intent;
import android.support.design.bottomappbar.BottomAppBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import it_geeks.info.gawla_app.LoginActivities.LoginActivity;

public class HaleActivity extends AppCompatActivity {
    int joined = 0;
    Button btnJoineRound,btnJoineRound2,btnJoineRound3;
    RelativeLayout rDivPro1,rDivPro2,rDivPro3,rDivPro4,shadowalert,shadowalert2;

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
    }

    @Override
    public void onBackPressed() {
        if (joined == 0){
            rDivPro1.setVisibility(View.VISIBLE);
            rDivPro2.setVisibility(View.VISIBLE);
            rDivPro3.setVisibility(View.GONE);
            btnJoineRound.setVisibility(View.VISIBLE);
            shadowalert.setVisibility(View.GONE);
            shadowalert.setVisibility(View.GONE);
        }else if(joined == 1){
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