package br.com.jerodac.fragments;

import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import br.com.jerodac.R;
import br.com.jerodac.controllers.MainController;
import br.com.jerodac.model.ModelPresenter;
import br.com.jerodac.utils.AnimationSuite;
import br.com.jerodac.utils.AppUtil;
import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author Jean Rodrigo Dalbon Cunha on 03/03/17.
 */
public class VideoInfoFragment extends BaseFragment {

    @BindView(R.id.container_loader)
    protected ViewGroup mContainerLoader;

    @BindView(R.id.video_info_content)
    protected ViewGroup mContent;

    @BindView(R.id.tv_language)
    protected TextView tvLanguage;

    @BindView(R.id.tv_tag)
    protected TextView tvTag;

    @BindView(R.id.tv_live_stream)
    protected TextView tvLiveStream;

    @Override
    protected int getLayoutResource() {
        return R.layout.video_info_fragment;
    }

    @Override
    protected void initComponents(View rootView) {
        getController().getVideoInfo();
        getController().attatchListener(onResult);
    }

    @OnClick(R.id.btn_play)
    public void play() {
        AnimationSuite.pulseAnimation(getView().findViewById(R.id.btn_play), new AnimationSuite.AnimationSuiteListener() {
            @Override
            public void onAnimationComplete() {
                AppUtil.playYoutube(getBaseActivity(), getModel().getCurrentInfoVideo().getId());
            }
        });
    }

    MainController.OnRefreshListener onResult = new MainController.OnRefreshListener() {
        @Override
        public void onSucess(final ModelPresenter modelPresenter) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mContainerLoader.setVisibility(View.GONE);
                    mContent.setVisibility(View.VISIBLE);

                    tvLanguage.setText(modelPresenter.getCurrentInfoVideo().getSnippet().getDefaultLanguage());
                    tvTag.setText(AppUtil.formatTags(modelPresenter.getCurrentInfoVideo().getSnippet().getTags()));
                    tvLiveStream.setText(modelPresenter.getCurrentInfoVideo().getSnippet().getLiveBroadcastContent());
                }
            }, 200);//handler time transition loading to content
        }

        @Override
        public void onError() {

        }
    };

    @Override
    protected void settings(View rootView) {

    }

}
