package br.com.jerodac.fragments;

import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.jerodac.R;
import br.com.jerodac.adapters.ChannelListAdapter;
import br.com.jerodac.controllers.MainController;
import br.com.jerodac.model.ModelPresenter;
import br.com.jerodac.vo.PlayListItem;
import butterknife.BindView;

/**
 * @author Jean Rodrigo Dalbon Cunha on 02/03/17.
 */
public class PlaylistListFragment extends BaseFragment {

    @BindView(R.id.recyclerview)
    protected RecyclerView recyclerView;

    @BindView(R.id.swiperefresh)
    protected SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.container_loader)
    protected ViewGroup mContainerLoader;

    //Adapter
    private ChannelListAdapter mAdapter;

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
        getController().attatchListener(onResult);
        getController().getChannelList();
        swipeRefreshLayout.setOnRefreshListener(onSwipeRefresh);
    }

    private SwipeRefreshLayout.OnRefreshListener onSwipeRefresh = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            getController().getChannelList();
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
        getBaseActivity().findViewById(R.id.collapsing_background).setBackgroundResource(android.R.color.white);
        ((TextView) getBaseActivity().findViewById(R.id.describe_collapsing)).setText(getModel().getCurrentPlaylist().getSnippet().getTitle());
        Picasso.with(getContext())
                .load(getModel().getCurrentPlaylist().getSnippet().getThumbnails().getMedium().getUrl())
                .placeholder(R.drawable.ic_paralax_youtube)
                .error(R.drawable.ic_paralax_youtube)
                .into((ImageView) getActivity().findViewById(R.id.backdrop));

        ((AppBarLayout) getActivity().findViewById(R.id.app_bar)).setExpanded(true);
        getBaseActivity().getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getBaseActivity().getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
}
