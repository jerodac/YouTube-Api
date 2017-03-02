package br.com.jerodac;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import br.com.jerodac.fragments.ChannelListFragment;

public class MainActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initCollapsingToolbar();

        if (savedInstanceState == null) {
            getFlowManager().add(new ChannelListFragment(), false);
        }
    }
}
