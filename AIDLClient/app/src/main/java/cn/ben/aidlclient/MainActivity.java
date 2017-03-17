package cn.ben.aidlclient;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private CountingInterface mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, LocalCountingService.class);
        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                mService = (CountingInterface) service;
                Log.d("ben", String.valueOf(mService.getCount()));
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                mService = null;

            }
        }, BIND_AUTO_CREATE);
    }
}
