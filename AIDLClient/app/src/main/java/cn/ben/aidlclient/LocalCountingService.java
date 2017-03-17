package cn.ben.aidlclient;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

import java.util.Random;

public class LocalCountingService extends Service {
    private final MyBinder mMyBinder;

    public LocalCountingService() {
        mMyBinder = new MyBinder();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mMyBinder;
    }

    private class MyBinder extends Binder implements CountingInterface {
        final Random mRandom;

        MyBinder() {
            mRandom = new Random();
        }

        @Override
        public int getCount() {
            return mRandom.nextInt(100);
        }
    }
}
