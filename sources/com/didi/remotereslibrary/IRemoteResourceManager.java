package com.didi.remotereslibrary;

import android.content.Context;
import com.didi.remotereslibrary.downservice.IRemoteSourceDownLoadManager;
import com.didi.remotereslibrary.exception.RemoteResourceNotFoundException;
import com.didi.remotereslibrary.rpcservice.IRemoteResourceHttpRequestManager;
import java.io.File;

public interface IRemoteResourceManager extends IRemoteSourceDownLoadManager, IRemoteResourceHttpRequestManager {
    void destroy();

    File getResource(String str) throws RemoteResourceNotFoundException;

    File getResource(String str, String str2) throws RemoteResourceNotFoundException;

    void init(Context context);

    void pullRemoteResource(double d, double d2);

    void setDebugMode(boolean z);

    void setEnableApollo(boolean z);
}
