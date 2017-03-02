package br.com.jerodac.fragments;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import br.com.jerodac.R;
import br.com.jerodac.controllers.MainController;
import br.com.jerodac.model.ModelPresenter;
import butterknife.BindView;

/**
 * @author Jean Rodrigo Dalbon Cunha on 02/03/17.
 */
public class ChannelListFragment extends BaseFragment {

    @BindView(R.id.recyclerview)
    protected RecyclerView recyclerView;

    @BindView(R.id.swiperefresh)
    protected SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.container_loader)
    protected ViewGroup mContainerLoader;

    private MainController controller;

    @Override
    protected int getLayoutResource() {
        return R.layout.channel_list_fragment;
    }

    @Override
    public String getTagName() {
        return getClass().getSimpleName();
    }

    @Override
    protected void initComponents(View rootView) {
        controller = MainController.getInstance();
        controller.attatchListener(onResult);
        controller.getChannelList();
    }

    private SwipeRefreshLayout.OnRefreshListener onSwipeRefresh = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {

        }
    };

    private void populateRecyclerView() {

    }

    MainController.OnRefreshListener onResult = new MainController.OnRefreshListener() {
        @Override
        public void onSucess(ModelPresenter modelPresenter) {
            populateRecyclerView();
        }

        @Override
        public void onError() {

        }
    };

    private void hideLoader() {
        mContainerLoader.setVisibility(View.GONE);
        mContainerLoader.removeAllViews();
        swipeRefreshLayout.setVisibility(View.VISIBLE);
    }

    @Override
    protected void settings(View rootView) {

    }
}
