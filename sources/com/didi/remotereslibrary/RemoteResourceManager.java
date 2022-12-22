package com.didi.remotereslibrary;

import android.content.Context;
import com.didi.remotereslibrary.exception.RemoteResourceNotFoundException;
import com.didi.remotereslibrary.response.BaseResponse;
import com.didi.remotereslibrary.response.IRemoteCallBack;
import java.io.File;
import java.util.HashMap;

public class RemoteResourceManager implements IRemoteResourceManager {

    /* renamed from: a */
    private static RemoteResourceManager f33159a;

    /* renamed from: b */
    private IRemoteResourceManager f33160b = new C11501a();

    /* renamed from: c */
    private ILoginParam f33161c;

    /* renamed from: d */
    private IDepartureParam f33162d;

    /* renamed from: e */
    private IDomainParam f33163e;

    public void setLoginParam(ILoginParam iLoginParam) {
        this.f33161c = iLoginParam;
    }

    public void setDomainParam(IDomainParam iDomainParam) {
        this.f33163e = iDomainParam;
    }

    public ILoginParam getLoginParam() {
        return this.f33161c;
    }

    public IDomainParam getDomainParam() {
        return this.f33163e;
    }

    public void setDepartureParam(IDepartureParam iDepartureParam) {
        this.f33162d = iDepartureParam;
    }

    public IDepartureParam getDepartureParam() {
        return this.f33162d;
    }

    private RemoteResourceManager() {
    }

    public void setDebugMode(boolean z) {
        this.f33160b.setDebugMode(z);
    }

    public void init(Context context) {
        this.f33160b.init(context);
    }

    public void pullRemoteResource(double d, double d2) {
        this.f33160b.pullRemoteResource(d, d2);
    }

    public static RemoteResourceManager getInstance() {
        if (f33159a == null) {
            f33159a = new RemoteResourceManager();
        }
        return f33159a;
    }

    public long downFile(ResourceItemModel resourceItemModel) {
        return this.f33160b.downFile(resourceItemModel);
    }

    public long httpRequest(String str, HashMap hashMap, BaseResponse baseResponse, IRemoteCallBack iRemoteCallBack) {
        return this.f33160b.httpRequest(str, hashMap, baseResponse, iRemoteCallBack);
    }

    public File getResource(String str, String str2) throws RemoteResourceNotFoundException {
        return this.f33160b.getResource(str, str2);
    }

    public File getResource(String str) throws RemoteResourceNotFoundException {
        return this.f33160b.getResource(str);
    }

    public void destroy() {
        this.f33160b.destroy();
    }

    public void setEnableApollo(boolean z) {
        this.f33160b.setEnableApollo(z);
    }
}
