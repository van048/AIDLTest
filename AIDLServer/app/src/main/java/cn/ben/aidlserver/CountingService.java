package cn.ben.aidlserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class CountingService extends Service {
    private MyBinder mMyBinder;

    public CountingService() {
        mMyBinder = new MyBinder();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mMyBinder;
    }

    class MyBinder extends IMyAidlInterface.Stub {

        @Override
        public int getCount() throws RemoteException {
            return 100;
        }
    }
}
