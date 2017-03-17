package cn.ben.aidlclient;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import cn.ben.aidlserver.IMyAidlInterface;

public class MainActivity extends AppCompatActivity {
    private IMyAidlInterface mService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getExplicitIntent(this, new Intent("cn.ben.AIDLService"));
        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                mService = IMyAidlInterface.Stub.asInterface(service);
                try {
                    Log.d("ben", String.valueOf(mService.getCount()));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                mService = null;

            }
        }, BIND_AUTO_CREATE);
    }

    private Intent getExplicitIntent(Context context, Intent implicitIntent) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) return null;

        List<ResolveInfo> resolveInfoList = packageManager.queryIntentServices(implicitIntent, 0);
        if (resolveInfoList == null || resolveInfoList.size() != 1) return null;

        ResolveInfo resolveInfo = resolveInfoList.get(0);
        if (resolveInfo == null || resolveInfo.serviceInfo == null) return null;

        String packageName = resolveInfo.serviceInfo.packageName;
        String classname = resolveInfo.serviceInfo.name;
        ComponentName componentName = new ComponentName(packageName, classname);

        Intent intent = new Intent(implicitIntent);
        intent.setComponent(componentName);
        return intent;
    }
}
