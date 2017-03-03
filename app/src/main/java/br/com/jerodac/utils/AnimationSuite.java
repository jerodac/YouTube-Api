package br.com.jerodac.utils;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.widget.FrameLayout;

import br.com.jerodac.R;

/**
 * @author Jean Rodrigo Dalbon Cunha on 03/03/17.
 */
public class AnimationSuite {

    /**
     * Toogle expandable
     */
    public static void toggleExpandable(ViewGroup viewGroup) {
        if (viewGroup.getVisibility() == View.VISIBLE) {
            AnimationSuite.collapse(viewGroup, null);
            //viewGroup.setVisibility(View.GONE);
        } else {
            AnimationSuite.expand(viewGroup, null);
            //viewGroup.setVisibility(View.VISIBLE);
        }
    }

    /**
     * Expandable view
     *
     * @param v
     */
    public static void expand(final View v, Animation.AnimationListener animationListener) {
        v.measure(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        final int targetHeight = v.getMeasuredHeight();

        // Older versions of android (pre API 21) cancel animations for views with a height of 0.
        v.getLayoutParams().height = 1;
        v.setVisibility(View.VISIBLE);
        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                v.getLayoutParams().height = interpolatedTime == 1
                        ? FrameLayout.LayoutParams.WRAP_CONTENT
                        : (int) (targetHeight * interpolatedTime);
                v.requestLayout();
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        a.setDuration((int) (targetHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
        if (animationListener != null) {
            a.setAnimationListener(animationListener);
        }

    }

    /**
     * Collapse iew
     */
    public static void collapse(final View v, Animation.AnimationListener animationListener) {
        final int initialHeight = v.getMeasuredHeight();

        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                if (interpolatedTime == 1) {
                    v.setVisibility(View.GONE);
                } else {
                    v.getLayoutParams().height = initialHeight - (int) (initialHeight * interpolatedTime);
                    v.requestLayout();
                }
            }

            @Override
            public boolean willChangeBounds() {
                return true;
            }
        };

        // 1dp/ms
        a.setDuration((int) (initialHeight / v.getContext().getResources().getDisplayMetrics().density));
        v.startAnimation(a);
        if (animationListener != null) {
            a.setAnimationListener(animationListener);
        }
    }

    public static void pulseAnimation(final View view, final AnimationSuiteListener listener) {
        if (view.isEnabled()) {
            view.setEnabled(false);
            Animation pulse = AnimationUtils.loadAnimation(view.getContext(), R.anim.pulse);
            view.startAnimation(pulse);
            pulse.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    if (listener != null) {
                        listener.onAnimationComplete();
                    }
                    view.setEnabled(true);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
        }
    }

    public interface AnimationSuiteListener {
        public void onAnimationComplete();
    }
}
