package br.com.jerodac.controllers;

import br.com.jerodac.business.FactoryAsyncTask;
import br.com.jerodac.business.RestClient;
import br.com.jerodac.business.RestError;
import br.com.jerodac.model.ModelPresenter;
import br.com.jerodac.utils.AppLog;
import br.com.jerodac.vo.ChannelListResponse;

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
        new FactoryAsyncTask<ChannelListResponse>() {
            @Override
            protected ChannelListResponse doIt() {
                return RestClient.getAllPlayList();
            }

            @Override
            protected void onSuccess(ChannelListResponse response) {
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
