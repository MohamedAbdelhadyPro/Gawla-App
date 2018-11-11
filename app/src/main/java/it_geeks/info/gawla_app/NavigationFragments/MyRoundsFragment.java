package it_geeks.info.gawla_app.NavigationFragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import it_geeks.info.gawla_app.Adapters.RoundsPagerAdapter;
import it_geeks.info.gawla_app.Models.Round;
import it_geeks.info.gawla_app.R;

public class MyRoundsFragment extends Fragment {

    private ViewPager roundsViewPager;
    private RoundsPagerAdapter roundsAdapter;

    private List<Round> roundsList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_rounds, container, false);

        getData();

        initPager(view);

        return view;
    }

    private void getData() {
        // fake data
        for (int i = 0; i < 5; i++) {
            Round round  = new Round("samsung A" + i + " 201" + i
                    , "image" + i
                    , "Electronics"
                    , i + "0000 L.E"
                    , "14 hr 40 min"
                    , "8 hr 40 min"
                    , "2" + i + " member joined");

            roundsList.add(round);
        }
    }

    private void initPager(View view) {
        roundsViewPager = view.findViewById(R.id.rounds_pager);
        roundsAdapter = new RoundsPagerAdapter(getActivity(), roundsList);
        roundsViewPager.setAdapter(roundsAdapter);
    }

}
