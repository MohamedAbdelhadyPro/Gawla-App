package it_geeks.info.gawla_app.SplashActivities;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import it_geeks.info.gawla_app.LoginActivities.LoginActivity;
import it_geeks.info.gawla_app.R;

public class onBoardActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private LinearLayout mDotLayout;
    private TextView[] mDots;
    TextView txtback,txtnext;
    private int mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //----------------full screen-----------------//
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //--------------------------------------------//
        setContentView(R.layout.activity_onboard);

        txtback = findViewById(R.id.txt_back);
        txtnext = findViewById(R.id.txt_next);
        mViewPager = findViewById(R.id.slideViewPager);
        mDotLayout = findViewById(R.id.dots);
        SliderAdapter sliderAdapter = new SliderAdapter(onBoardActivity.this);
        mViewPager.setAdapter(sliderAdapter);

        addDots(0);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                addDots(i);
                mCurrentPage = i;
                if (i == 0){
                    txtback.setVisibility(View.INVISIBLE);
                    txtnext.setText("التالي");
                }else if (i == 1){
                    txtback.setVisibility(View.VISIBLE);
                    txtnext.setText("التالي");
                    txtback.setText("السابق");
                }else if(i == 2){
                    txtback.setVisibility(View.VISIBLE);
                    txtnext.setText("انهاء");
                    txtback.setText("السابق");
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        txtnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCurrentPage >= 2){
                startActivity(new Intent(onBoardActivity.this,LoginActivity.class));
                finish();
            }
                mViewPager.setCurrentItem(mCurrentPage + 1);
            }
        });
        txtback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewPager.setCurrentItem(mCurrentPage-1);
            }
        });

    }

    public void addDots(int position){
        mDots = new TextView[3];
        mDotLayout.removeAllViews();
        for (int i = 0; i < mDots.length; i++) {
            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226"));
            mDots[i].setTextSize(50);
            mDots[i].setTextColor(getResources().getColor(R.color.dots));
            mDotLayout.addView(mDots[i]);
        }
        if (mDots.length > 0){
            mDots[position].setTextColor(getResources().getColor(R.color.babyBlue));
        }
    }
    public void finishscrean(){
        finish();
    }

}
