package beangate.datta.fragmentexample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsAdapter extends FragmentPagerAdapter {

    public TabsAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment;
        switch (position)
        {
            case 0:
                return fragment = new Frag1();
            case 1:
                return fragment = new Frag2();
            case 2:
                return fragment = new Frag3();


            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 3;
    }


    public CharSequence getPageTitle(int Position)
    {
        switch (Position)
        {
            case 0:
                return "Frag1";
                case 1:
            return "Frag2";
            case 2:
                return "Frag3";


            default:
                return null;
        }
    }
}
