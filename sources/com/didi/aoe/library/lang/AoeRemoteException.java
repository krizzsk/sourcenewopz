package com.didi.aoe.library.lang;

import android.os.RemoteException;

public class AoeRemoteException extends RemoteException {
    public AoeRemoteException(String str) {
        super(str);
    }
}
