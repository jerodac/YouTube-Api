package br.com.jerodac.fragments;

import android.content.res.Resources;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.jerodac.R;
import br.com.jerodac.adapters.ChannelListAdapter;
import br.com.jerodac.controllers.MainController;
import br.com.jerodac.model.ModelPresenter;
import br.com.jerodac.vo.PlayListItem;
import br.com.jerodac.widgets.GridItemDecoration;
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

    private RecyclerView.LayoutManager mLayoutManager;
    private ChannelListAdapter mAdapter;

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

        swipeRefreshLayout.setOnRefreshListener(onSwipeRefresh);
        mLayoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridItemDecoration(1, dpToPx(10), true));
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }

    private SwipeRefreshLayout.OnRefreshListener onSwipeRefresh = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            controller.getChannelList();
        }
    };

    private void populateRecyclerView(List<PlayListItem> dataset) {
        recyclerView.removeAllViews();
        mAdapter = new ChannelListAdapter(getContext(), dataset);
        mAdapter.setOnItemClickListener(onItemClickListener);
        recyclerView.setAdapter(mAdapter);
    }

    ChannelListAdapter.OnItemClickListener onItemClickListener = new ChannelListAdapter.OnItemClickListener() {
        @Override
        public void onItemClick(int position, PlayListItem playlist, View v) {

        }
    };

    MainController.OnRefreshListener onResult = new MainController.OnRefreshListener() {
        @Override
        public void onSucess(ModelPresenter modelPresenter) {
            swipeRefreshLayout.setRefreshing(false);
            if (swipeRefreshLayout.getVisibility() != View.VISIBLE) {
                hideLoader();
            }
            populateRecyclerView(modelPresenter.getChannelList());
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
