package com.didi.drouter.remote;

import android.os.RemoteException;

public interface IRemoteCallback {
    void callback(Object... objArr) throws RemoteException;
}
