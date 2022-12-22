package com.google.p220vr.dynamite.client;

import android.os.IInterface;
import android.os.RemoteException;

/* renamed from: com.google.vr.dynamite.client.ILoadedInstanceCreator */
public interface ILoadedInstanceCreator extends IInterface {
    INativeLibraryLoader newNativeLibraryLoader(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException;
}
