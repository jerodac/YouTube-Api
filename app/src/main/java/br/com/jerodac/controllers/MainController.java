package br.com.jerodac.controllers;

import br.com.jerodac.business.FactoryAsyncTask;
import br.com.jerodac.business.RestClient;
import br.com.jerodac.business.RestError;
import br.com.jerodac.model.ModelPresenter;
import br.com.jerodac.utils.AppLog;
import br.com.jerodac.vo.PLaylistListResponse;
import br.com.jerodac.vo.PlayListItem;
import br.com.jerodac.vo.VideoInfoResponse;

/**
 * @author Jean Rodrigo Dalbon Cunha on 02/03/17.
 */
public class MainController {

    private ModelPresenter modelPresenter;
    private static MainController mainController;
    private OnRefreshListener mListener;

    public static MainController getInstance() {
        if (mainController == null) {
            mainController = new MainController();
        }
        return mainController;
    }

    private MainController() {
        modelPresenter = new ModelPresenter();
    }

    public ModelPresenter getModel() {
        return modelPresenter;
    }

    public void attatchListener(OnRefreshListener onRefreshListener) {
        mListener = onRefreshListener;
    }

    public void setCurrentChannel(PlayListItem currentChannel) {
        modelPresenter.setCurrentChannel(currentChannel);
    }

    public void getChannelList() {
        new FactoryAsyncTask<PLaylistListResponse>() {
            @Override
            protected PLaylistListResponse doIt() {
                return RestClient.getAllPlayList();
            }

            @Override
            protected void onSuccess(PLaylistListResponse response) {
                AppLog.v(AppLog.TAG, "getChannelList() - success");
                modelPresenter.setChannelList(response.getItems());
                notifyListener(true);
            }

            @Override
            protected void onError(RestError restError) {
                AppLog.e(AppLog.TAG, "getChannelList() - error", restError.getException());
                notifyListener(false);
            }
        }.execute();
    }

    public void getPlaylistList() {
        new FactoryAsyncTask<PLaylistListResponse>() {
            @Override
            protected PLaylistListResponse doIt() {
                return RestClient.getVideosByPLayList(modelPresenter.getCurrentChannel().getId());
            }

            @Override
            protected void onSuccess(PLaylistListResponse response) {
                AppLog.v(AppLog.TAG, "getPlaylistList() - success");
                modelPresenter.setPlaylistList(response.getItems());
                notifyListener(true);
            }

            @Override
            protected void onError(RestError restError) {
                AppLog.e(AppLog.TAG, "getPlaylistList - error", restError.getException());
                notifyListener(false);
            }
        }.execute();
    }

    public void getVideoInfo() {
        new FactoryAsyncTask<VideoInfoResponse>() {
            @Override
            protected VideoInfoResponse doIt() {
                return RestClient.getInfoByVideo(modelPresenter.getCurrentPLaylist().getSnippet().getResourceId().getVideoId());
            }

            @Override
            protected void onSuccess(VideoInfoResponse response) {
                AppLog.v(AppLog.TAG, "getPlaylistList() - success");
                modelPresenter.setCurrentInfoVideo(response.getItems().get(0));
                notifyListener(true);
            }

            @Override
            protected void onError(RestError restError) {
                AppLog.e(AppLog.TAG, "getPlaylistList - error", restError.getException());
                notifyListener(false);
            }
        }.execute();
    }

    private void notifyListener(boolean isSuccess) {
        if (mListener != null) {
            if (isSuccess) {
                mListener.onSucess(modelPresenter);
            } else {
                mListener.onError();
            }
        }
    }

    public interface OnRefreshListener {
        public void onSucess(ModelPresenter modelPresenter);

        public void onError();
    }

}
