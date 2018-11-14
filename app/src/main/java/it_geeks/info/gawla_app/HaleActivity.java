package it_geeks.info.gawla_app;



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class HaleActivity extends AppCompatActivity {

    int joined ;
    Button btnJoineRound,btnJoineRound2,btnJoineRound3;
    RelativeLayout rDivPro1,rDivPro2,rDivPro3,rDivPro4;
    LinearLayout shadowalert,shadowalert2;
    TextView txtReadMore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hale);

        if (savedInstanceState != null){
           joined = savedInstanceState.getInt("Joined");
        }
        setBtnTypeCast();
        setupLoginButton();
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
        }

        //open round updates activity
        findViewById(R.id.hales_open_round_updates).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HaleActivity.this, RoundUpdatesActivity.class));
            }
        });

    }

    public void setBtnTypeCast() {

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

    }

    private void setupLoginButton() {



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
                startActivity(new Intent(HaleActivity.this,ProductDetailsActivity.class));
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
              super.onBackPressed();

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

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Joined",joined);
    }
}




