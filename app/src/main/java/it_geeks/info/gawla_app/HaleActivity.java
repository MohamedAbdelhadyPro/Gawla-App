package it_geeks.info.gawla_app;

import android.support.design.bottomappbar.BottomAppBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class HaleActivity extends AppCompatActivity {
    Button btnJoineRound;
    RelativeLayout rDivPro1,rDivPro2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hale);

        btnJoineRound = findViewById(R.id.btnJoineRound);
        rDivPro1 = findViewById(R.id.divPro1);
        rDivPro2 = findViewById(R.id.divPro2);

        btnJoineRound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rDivPro1.setVisibility(View.GONE);
                rDivPro2.setVisibility(View.GONE);
            }
        });
    }
}
