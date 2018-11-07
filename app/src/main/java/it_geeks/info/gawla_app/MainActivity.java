package it_geeks.info.gawla_app;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import it_geeks.info.gawla_app.NavigationFragments.AccountFragment;
import it_geeks.info.gawla_app.NavigationFragments.CardsFragment;
import it_geeks.info.gawla_app.NavigationFragments.HalesFragment;
import it_geeks.info.gawla_app.NavigationFragments.MenuFragment;
import it_geeks.info.gawla_app.NavigationFragments.MyRoundsFragment;

public class MainActivity extends AppCompatActivity {

    private Fragment fragment = new HalesFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayFragment(fragment);

        initNavigation();
    }

    private void initNavigation() {
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                fragment = null;
                switch (menuItem.getItemId()) {
                    case R.id.navigation_hales:
                        fragment = new HalesFragment();
                        break;
                    case R.id.navigation_my_rounds:
                        fragment = new MyRoundsFragment();
                        break;
                    case R.id.navigation_cards:
                        fragment = new CardsFragment();
                        break;
                    case R.id.navigation_account:
                        fragment = new AccountFragment();
                        break;
                    case R.id.navigation_menu:
                        fragment = new MenuFragment();
                        break;
                }

                if (fragment != null) {
                    displayFragment(fragment);
                    return true;
                }

                return false;
            }
        });
    }

    private void displayFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.main_frame, fragment).commit();
    }

}
