package com.example.skool;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.skool.adapters.ViewPagerAdapter;
import com.example.skool.db.DatabaseHelper;
import com.example.skool.models.Preferences;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends ActionBarActivity {
    @Bind(R.id.app_bar)
    Toolbar toolbar;

    @Bind(R.id.drawer_layout)
    DrawerLayout drawerLayout;

    @Bind(R.id.viewpager)
    ViewPager viewPager;

    @Bind(R.id.tabLayout)
    TabLayout tabLayout;

    @Bind(R.id.navdrawer)
    ListView drawerList;

    private ActionBarDrawerToggle drawerToggle;
    private ViewPagerAdapter pagerAdapter;
    private String titles[] = new String[]{"Week", "Month", "Year"};
    String[] values = new String[]{
            "Overview", "Notices", "Emergency", "Fees Payments", "Settings"
    };
    private DatabaseHelper databaseHelper;
    private List<Preferences> preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(getApplicationContext());

        preferences = databaseHelper.getPreferences();
        if(!(preferences.size()>0)){
            Intent intent = new Intent(getApplicationContext(), PhoneRegisterActivity.class);
            startActivity(intent);
            finish();
        }

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.ic_menu_white_18dp);
        toolbar.getBackground().setAlpha(0);


        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.setDrawerListener(drawerToggle);
        //getSupportActionBar().setHomeButtonEnabled(true);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);
        drawerList.setAdapter(adapter);
        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                switch (position) {
                    case 0:
                        drawerList.setBackgroundColor(getResources().getColor(R.color.icons));
                        toolbar.setBackgroundColor(getResources().getColor(R.color.primary));
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case 1:
                        drawerList.setBackgroundColor(getResources().getColor(R.color.primary_light));
                        toolbar.setBackgroundColor(getResources().getColor(R.color.primary_light));
                        drawerLayout.closeDrawer(GravityCompat.START);

                        break;
                    case 2:
                        drawerList.setBackgroundColor(getResources().getColor(R.color.icons));
                        toolbar.setBackgroundColor(getResources().getColor(R.color.primary_dark));
                        drawerLayout.closeDrawer(GravityCompat.START);

                        break;
                    case 3:
                        drawerList.setBackgroundColor(getResources().getColor(R.color.material_deep_teal_500));
                        toolbar.setBackgroundColor(getResources().getColor(R.color.material_deep_teal_500));
                        drawerLayout.closeDrawer(GravityCompat.START);

                        break;
                }

            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager(), titles));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
