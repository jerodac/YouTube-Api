package br.com.jerodac.business;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import br.com.jerodac.R;
import br.com.jerodac.fragments.BaseFragment;

/**
 * @author Jean Rodrigo Dalbon Cunha on 01/03/17.
 */
public class FlowManager {

    private int mContainer = R.id.container;
    private FragmentManager mFragmentManager;

    public FlowManager(AppCompatActivity appCompatActivity) {
        mFragmentManager = appCompatActivity.getSupportFragmentManager();
    }

    public void add(BaseFragment addFragment, boolean backStack) {
        FragmentTransaction ft = mFragmentManager.beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.add(mContainer, addFragment, addFragment.getTagName());
        if (backStack) {
            ft.addToBackStack(null);
        }
        ft.commit();
    }
}
