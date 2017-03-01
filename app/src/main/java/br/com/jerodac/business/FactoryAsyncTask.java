package br.com.jerodac.business;

import android.os.AsyncTask;
import android.os.Handler;

import java.util.ArrayList;
import java.util.List;

import br.com.jerodac.dto.ResponseDto;
import br.com.jerodac.utils.AppLog;
import retrofit.RetrofitError;

/**
 * @author Jean Rodrigo Dalbon Cunha on 01/03/17.
 */
public abstract class FactoryAsyncTask<Result extends ResponseDto>
        extends AsyncTask<Void, Void, Result> {

    private List<Runnable> mExitListeners = new ArrayList<>();
    private Exception mError;

    protected abstract Result doIt();

    protected abstract void onSuccess(Result result);

    protected void onAbort() {
    }

    protected void onError(RestError restError) {
    }

    protected void onFail(ResponseDto responseVO) {

    }

    public void addExitListener(Runnable runnable) {
        mExitListeners.add(runnable);
    }

    @Override
    protected Result doInBackground(Void... params) {
        try {
            return doIt();
        } catch (Exception ex) {
            mError = ex;
            return null;
        }
    }

    @Override
    protected void onPostExecute(Result result) {
        if (!isCancelled()) {
            onExit();
            if (mError == null) {
                onSuccess(result);
            } else {
                error();
            }
        }
    }

    @Override
    protected void onCancelled() {
        onExit();
    }

    private void error() {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                onExit();
                RestError restError = new RestError(mError);
                try {
                    if (mError instanceof RetrofitError) {
                        ResponseDto responseVO = (ResponseDto) ((RetrofitError) mError).getBodyAs(ResponseDto.class);
                        if (responseVO != null) {
                            onFail(responseVO);
                        } else {
                            RetrofitError e = (RetrofitError) mError;
                            if (e.getKind().equals(RetrofitError.Kind.NETWORK)) {
                                AppLog.e(AppLog.TAG, "Internet connection not detected.");
                                restError.setConnectionError(true);
                            }
                            onError(restError);
                        }
                    } else {
                        onError(restError);
                    }
                } catch (Exception e) {
                    onError(new RestError(e));
                }
            }
        });
    }

    private void onExit() {
        for (Runnable r : mExitListeners) {
            r.run();
        }
    }

}
