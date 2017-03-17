package cn.ben.aidlserver;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.NonNull;

public class CountingService extends Service {
    private final MyBinder mMyBinder;

    public CountingService() {
        mMyBinder = new MyBinder();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mMyBinder;
    }

    private class MyBinder extends IMyAidlInterface.Stub {

        @Override
        public int getCount() throws RemoteException {
            return 100;
        }

        @Override
        public String getString() throws RemoteException {
            return "String";
        }

        @Override
        public CharSequence getCharSequence() throws RemoteException {
            return new CharSequence() {
                @Override
                public int length() {
                    return 0;
                }

                @Override
                public char charAt(int index) {
                    return 0;
                }

                @Override
                public CharSequence subSequence(int start, int end) {
                    return null;
                }

                @NonNull
                @Override
                public String toString() {
                    return "CharSequence";
                }
            };
        }
    }
}
