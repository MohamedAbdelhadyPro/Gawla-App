package it_geeks.info.gawla_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SubscribePlanActivity extends AppCompatActivity {
    TextView txt_pay_later;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscribe_plan);
        txt_pay_later = findViewById(R.id.txt_pay_later);
        txt_pay_later.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SubscribePlanActivity.this,MainActivity.class));
                finish();
            }
        });
    }
}
