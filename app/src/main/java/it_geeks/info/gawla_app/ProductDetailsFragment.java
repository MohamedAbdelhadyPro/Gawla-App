package it_geeks.info.gawla_app;


import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import it_geeks.info.gawla_app.Adapters.ProductImageAdapter;

public class ProductDetailsFragment extends Fragment {

    RecyclerView rProdList;
    ImageView imgOut;
    static FrameLayout frameLayout;
    public static int xPro = 0 ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_product_details, container, false);

        rProdList = v.findViewById(R.id.RecyProdList);
        imgOut = v.findViewById(R.id.outProductDetails);
        frameLayout = v.findViewById(R.id.proDp);

            frameLayout.setElevation(100);
            getActivity().getWindow().setStatusBarColor(getResources().getColor(R.color.ops));

                xPro = 1;



                rProdList.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
                ProductImageAdapter productImageAdapter = new ProductImageAdapter(getActivity());
                rProdList.setAdapter(productImageAdapter);

                imgOut.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        frameLayout.setVisibility(View.GONE);
                        getActivity().getWindow().setStatusBarColor(getResources().getColor(R.color.paleGrey));
                    }
                });

        return v;
    }


}
