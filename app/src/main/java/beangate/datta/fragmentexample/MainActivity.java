package beangate.datta.fragmentexample;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }
    private void init() {
        viewPager = findViewById(R.id.main_viewpager);
        tabLayout = findViewById(R.id.main_tablayout);
        viewPager.setAdapter(new TabsAdapter(this.getSupportFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);


    }
}

