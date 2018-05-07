package com.bamboolmc.binderpool;

import android.os.RemoteException;

/**
 * Created by limc on 18/5/6.
 */

public class IComputeImpl extends ICompute.Stub {
    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }
}
