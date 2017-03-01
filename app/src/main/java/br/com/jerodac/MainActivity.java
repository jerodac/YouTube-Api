package br.com.jerodac;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import br.com.jerodac.business.FactoryAsyncTask;
import br.com.jerodac.business.RestClient;
import br.com.jerodac.dto.ResponseDto;
import br.com.jerodac.utils.AppLog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new FactoryAsyncTask<ResponseDto>() {
            @Override
            protected ResponseDto doIt() {
                return RestClient.getAllPlayList();
            }

            @Override
            protected void onSuccess(ResponseDto responseDto) {
                AppLog.v(AppLog.TAG, "success!");
            }
        }.execute();

    }
}
