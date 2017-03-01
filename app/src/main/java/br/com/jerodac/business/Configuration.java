package br.com.jerodac.business;

import br.com.jerodac.BuildConfig;
import br.com.jerodac.utils.AppLog;
import retrofit.ErrorHandler;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;

/**
 * @author Jean Rodrigo Dalbon Cunha on 01/03/17.
 */
public class Configuration {
    private static String BASE_URL = BuildConfig.BASE_URL;

    public static API getApi() {

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .setErrorHandler(new ErrorHandler() {
                    @Override
                    public Throwable handleError(RetrofitError retrofitError) {
                        return retrofitError;
                    }
                })
                .build();

        if (AppLog.isDebug()) {
            restAdapter.setLogLevel(RestAdapter.LogLevel.FULL);
        }

        return restAdapter.create(API.class);
    }

    private static RequestInterceptor interceptor = new RequestInterceptor() {
        @Override
        public void intercept(RequestFacade request) {
            request.addHeader("Accept-Encoding", "gzip");
        }
    };
}
