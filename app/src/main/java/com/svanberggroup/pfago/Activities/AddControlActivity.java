package com.svanberggroup.pfago.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.svanberggroup.pfago.Models.Control;
import com.svanberggroup.pfago.Models.Vehicle;
import com.svanberggroup.pfago.R;
import com.svanberggroup.pfago.Repository.ControlRepository;
import com.svanberggroup.pfago.Utils.ViewPagerAdapter;

public class AddControlActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private Control control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_control);

        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tabs);
        control = new Control();
        viewPager.setAdapter(createCardAdapter());

        new TabLayoutMediator(tabLayout, viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        switch (position) {
                            case 0:
                                tab.setText("Fordon");
                                break;
                            case 1:
                                tab.setText("Förare");
                                break;
                            case 2:
                                tab.setText("Platser");
                                break;
                            case 3:
                                tab.setText("Gods");
                                break;
                            case 4:
                                tab.setText("Handlingar");
                                break;
                            case 5:
                                tab.setText("Transport");
                                break;
                        }
                    }
                }).attach();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_control_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.doneControl:

                finish();
                return true;

                default: return super.onOptionsItemSelected(item);
        }

    }

    private ViewPagerAdapter createCardAdapter() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(this, control);
        return adapter;
    }
}
