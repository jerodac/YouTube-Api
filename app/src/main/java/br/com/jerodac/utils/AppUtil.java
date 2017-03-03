package br.com.jerodac.utils;

import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import br.com.jerodac.BaseActivity;
import br.com.jerodac.R;

/**
 * @author Jean Rodrigo Dalbon Cunha on 03/03/17.
 */
public class AppUtil {

    public static void swapBackdrop(AppCompatActivity activity, String Url) {
        activity.findViewById(R.id.collapsing_background).setBackgroundResource(android.R.color.white);
        Picasso.with(activity)
                .load(Url)
                .placeholder(R.drawable.ic_paralax_youtube)
                .error(R.drawable.ic_paralax_youtube)
                .into((ImageView) activity.findViewById(R.id.backdrop));

        ((AppBarLayout) activity.findViewById(R.id.app_bar)).setExpanded(true);
    }

    public static void setDeafultBackdrop(AppCompatActivity activity) {
        activity.findViewById(R.id.collapsing_background).setBackgroundResource(android.R.color.transparent);
        ((AppCompatImageView) activity.findViewById(R.id.backdrop)).setImageResource(R.drawable.ic_paralax_youtube);
        ((AppBarLayout) activity.findViewById(R.id.app_bar)).setExpanded(true);
    }

    public static void setTextBackdrop(AppCompatActivity activity, String text) {
        ((TextView) activity.findViewById(R.id.describe_collapsing)).setText(text);
    }

    public static void enableBackToolbar(final BaseActivity activity) {
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        activity.getSupportActionBar().setDisplayShowHomeEnabled(true);
        ((Toolbar) activity.findViewById(R.id.toolbar)).setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.getFlowManager().popBack();
            }
        });
    }

    public static void disableBackToolbar(BaseActivity activity) {
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        activity.getSupportActionBar().setDisplayShowHomeEnabled(false);
    }
}
