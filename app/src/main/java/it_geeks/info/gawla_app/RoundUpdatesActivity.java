package it_geeks.info.gawla_app;

import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import it_geeks.info.gawla_app.Adapters.RoundUpdatesAdapter;
import it_geeks.info.gawla_app.Models.RoundUpdate;

public class RoundUpdatesActivity extends AppCompatActivity {

    private RecyclerView roundUpdatesRecycler;
    private RoundUpdatesAdapter roundUpdatesAdapter;
    private List<RoundUpdate> roundUpdateList = new ArrayList<>();

    private View sheetView;
    private BottomSheetDialog mBottomSheetDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round_updates);

        getData();

        initRecycler();

        initViews();

        initBottomSheet();
    }

    private void initBottomSheet() {
        mBottomSheetDialog = new BottomSheetDialog(this);
        sheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_round_update, null);

        //init bottom sheet views
        //close bottom sheet
        sheetView.findViewById(R.id.close_bottom_sheet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mBottomSheetDialog.isShowing()) {
                    mBottomSheetDialog.dismiss();

                } else {
                    mBottomSheetDialog.show();
                }
            }
        });

        mBottomSheetDialog.setContentView(sheetView);

        mBottomSheetDialog.getWindow().findViewById(R.id.design_bottom_sheet)
                .setBackgroundResource(android.R.color.transparent);
    }

    private void initViews() {
        // back btn
        findViewById(R.id.round_update_btn_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        // open cards bottom sheet
        findViewById(R.id.round_update_btn_cards).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mBottomSheetDialog.isShowing()) {
                    mBottomSheetDialog.dismiss();

                } else {
                    mBottomSheetDialog.show();
                }
            }
        });
    }

    private void getData() {
        // fake data
        for (int i = 0; i < 8; i++) {
            RoundUpdate roundUpdate = new RoundUpdate("image" + i
                    , "انضم الصالة العضو سالم الدوثري"
                    , "3 hrs");

            roundUpdateList.add(roundUpdate);
        }
    }

    private void initRecycler() {
        roundUpdatesRecycler = findViewById(R.id.round_updates_recycler);
        roundUpdatesRecycler.setHasFixedSize(true);
        roundUpdatesRecycler.setLayoutManager(new LinearLayoutManager(RoundUpdatesActivity.this, 1, false));
        roundUpdatesAdapter = new RoundUpdatesAdapter(RoundUpdatesActivity.this, roundUpdateList);
        roundUpdatesRecycler.setAdapter(roundUpdatesAdapter);
    }
}
