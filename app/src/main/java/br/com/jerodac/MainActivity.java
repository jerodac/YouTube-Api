package br.com.jerodac;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.com.jerodac.business.FactoryAsyncTask;
import br.com.jerodac.business.RestClient;
import br.com.jerodac.utils.AppLog;
import br.com.jerodac.vo.PlaylistListResponse;
import br.com.jerodac.vo.VideoListResponse;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //test api services
        new FactoryAsyncTask<PlaylistListResponse>() {
            @Override
            protected PlaylistListResponse doIt() {
                return RestClient.getAllPlayList();
            }

            @Override
            protected void onSuccess(PlaylistListResponse response) {
                AppLog.v(AppLog.TAG, "success! " + response.toString());
            }
        }.execute();

        new FactoryAsyncTask<PlaylistListResponse>() {
            @Override
            protected PlaylistListResponse doIt() {
                return RestClient.getVideosByPLayList("PLWz5rJ2EKKc9tH0dRV1_HmQBXe_-qFQPl");
            }

            @Override
            protected void onSuccess(PlaylistListResponse response) {
                AppLog.v(AppLog.TAG, "success!");
            }
        }.execute();

        new FactoryAsyncTask<VideoListResponse>() {
            @Override
            protected VideoListResponse doIt() {
                return RestClient.getInfoByVideo("TxAbht2DkyU");
            }

            @Override
            protected void onSuccess(VideoListResponse response) {
                AppLog.v(AppLog.TAG, "success!");
            }
        }.execute();

    }
}
