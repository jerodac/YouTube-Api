package br.com.jerodac.controllers;

import br.com.jerodac.business.FactoryAsyncTask;
import br.com.jerodac.business.RestClient;
import br.com.jerodac.business.RestError;
import br.com.jerodac.model.ModelPresenter;
import br.com.jerodac.utils.AppLog;
import br.com.jerodac.vo.PlaylistListResponse;

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

    public void attatchListener(OnRefreshListener onRefreshListener) {
        mListener = onRefreshListener;
    }

    public void getChannelList() {
        new FactoryAsyncTask<PlaylistListResponse>() {
            @Override
            protected PlaylistListResponse doIt() {
                return RestClient.getAllPlayList();
            }

            @Override
            protected void onSuccess(PlaylistListResponse response) {
                response.getItems();
                AppLog.v(AppLog.TAG, "success! " + response.toString());
                notifyListener(true);
            }

            @Override
            protected void onError(RestError restError) {
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
