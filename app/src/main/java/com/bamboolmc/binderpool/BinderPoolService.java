package com.bamboolmc.binderpool;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public class BinderPoolService extends Service {


    private static final String TAG = "BinderPoolService";
    public static final int BINDER_NONE = -1;
    public static final int BINDER_COMPUTE = 0;
    public static final int BINDER_SECURITY = 1;
//    private Binder mBinderPool = new BinderPool.BinderPoolImpl();

    private IBinderPool.Stub mBinderPool = new IBinderPool.Stub() {
        @Override
        public IBinder queryBinder(int binderCode) throws RemoteException {
            IBinder binder = null;
            switch (binderCode) {
                case BINDER_SECURITY:
                    binder = new ISecurityCenterImpl();
                    break;
                case BINDER_COMPUTE:
                    binder = new IComputeImpl();
                    break;
                default:
                    break;
            }
            return binder;
        }
    };


    public BinderPoolService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinderPool;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


}
