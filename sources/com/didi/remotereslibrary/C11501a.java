package com.didi.remotereslibrary;

import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import com.didi.dimina.container.secondparty.bundle.util.PmFileConstant;
import com.didi.remotereslibrary.broadcast.FileDownBroadcast;
import com.didi.remotereslibrary.downservice.DiDiDownLoadManager;
import com.didi.remotereslibrary.downservice.IRemoteSourceDownLoadManager;
import com.didi.remotereslibrary.exception.RemoteResourceNotFoundException;
import com.didi.remotereslibrary.exception.RemoteResourcenInitException;
import com.didi.remotereslibrary.response.BaseResponse;
import com.didi.remotereslibrary.response.IRemoteCallBack;
import com.didi.remotereslibrary.response.ResourceListResponser;
import com.didi.remotereslibrary.rpcservice.DiDiHttpRequestManager;
import com.didi.remotereslibrary.rpcservice.IRemoteResourceHttpRequestManager;
import com.didi.remotereslibrary.store.RemoteResourceStore;
import com.didi.remotereslibrary.utils.C11505Util;
import com.didi.remotereslibrary.utils.Constants;
import com.didi.remotereslibrary.utils.DLog;
import com.didi.remotereslibrary.utils.FileUtils;
import com.didi.sdk.util.MD5;
import com.didi.sdk.util.UiThreadHandler;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.observer.OnToggleStateChangeListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.didi.remotereslibrary.a */
/* compiled from: RemoteResourceManagerImpl */
class C11501a implements IRemoteResourceManager {

    /* renamed from: a */
    protected Context f33164a;

    /* renamed from: b */
    private IRemoteSourceDownLoadManager f33165b;

    /* renamed from: c */
    private IRemoteResourceHttpRequestManager f33166c;

    /* renamed from: d */
    private FileDownBroadcast f33167d = new FileDownBroadcast();

    /* renamed from: e */
    private boolean f33168e = false;

    /* renamed from: f */
    private int f33169f = 0;

    /* renamed from: g */
    private final int f33170g = 3;

    /* renamed from: h */
    private boolean f33171h = true;

    /* renamed from: i */
    private Config f33172i;

    /* renamed from: j */
    private OnToggleStateChangeListener f33173j = new RemoteResourceManagerImpl$1(this);

    /* renamed from: a */
    public void mo87282a(Config config) {
        this.f33172i = config;
    }

    public C11501a() {
        setDebugMode(false);
        Apollo.addToggleStateChangeListener(this.f33173j);
    }

    public void setDebugMode(boolean z) {
        this.f33168e = z;
    }

    public void init(Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f33164a = applicationContext;
        this.f33165b = new DiDiDownLoadManager(applicationContext);
        this.f33166c = new DiDiHttpRequestManager(this.f33164a);
        m23358a();
    }

    /* renamed from: a */
    private void m23358a() {
        try {
            this.f33164a.registerReceiver(this.f33167d, new IntentFilter("android.intent.action.DOWNLOAD_COMPLETE"));
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
    }

    public long downFile(ResourceItemModel resourceItemModel) {
        return this.f33165b.downFile(resourceItemModel);
    }

    public long httpRequest(String str, HashMap hashMap, BaseResponse baseResponse, IRemoteCallBack iRemoteCallBack) {
        return this.f33166c.httpRequest(str, hashMap, baseResponse, iRemoteCallBack);
    }

    public void pullRemoteResource(double d, double d2) {
        m23359a(d, d2);
    }

    /* renamed from: a */
    private void m23359a(double d, double d2) {
        String str;
        DLog.m23371d(C11505Util.TAG, "调用了远程资源Init  lat:" + d + "  lng:" + d2);
        if (!m23366b()) {
            DLog.m23371d(C11505Util.TAG, "APOLLO IS SWITCH OFF");
            return;
        }
        ResourceListResponser resourceListResponser = new ResourceListResponser();
        ResourceListResponser resourceListCache = RemoteResourceStore.getInstance(this.f33164a).getResourceListCache(RemoteResourceStore.KEY_RESLIST_DATA);
        HashMap hashMap = new HashMap();
        Config config = this.f33172i;
        String str2 = config == null ? "2.0.0" : config.apiver;
        Config config2 = this.f33172i;
        String str3 = config2 == null ? Config.VALUE_DEFAULT_NS : config2.f33158ns;
        String remoteResourceUrl = Constants.getRemoteResourceUrl();
        if (resourceListCache == null) {
            str = "";
        } else {
            str = resourceListCache.md5;
        }
        hashMap.put(Config.KEY_APIVER, str2);
        hashMap.put(Config.KEY_NS, str3);
        hashMap.put(Config.KEY_LASTMD5, str);
        hashMap.put("flat", Double.valueOf(d));
        hashMap.put("flng", Double.valueOf(d2));
        httpRequest(remoteResourceUrl, hashMap, resourceListResponser, new RemoteResourceManagerImpl$2(this, resourceListCache, d, d2));
    }

    public File getResource(String str, String str2) throws RemoteResourceNotFoundException {
        return getResource(str + "/" + str2);
    }

    public File getResource(String str) throws RemoteResourceNotFoundException {
        if (this.f33164a == null) {
            throw new RemoteResourcenInitException("context is null,you must call RemoteResourceManager.getInstance().init(Context)");
        } else if (m23366b()) {
            File downLoadFileBySubPath = FileUtils.getDownLoadFileBySubPath(this.f33164a, str);
            if (downLoadFileBySubPath.exists()) {
                return downLoadFileBySubPath;
            }
            throw new RemoteResourceNotFoundException("remote resource file is not exits", 1);
        } else {
            throw new RemoteResourceNotFoundException("apollo switch off ", 2);
        }
    }

    /* renamed from: b */
    private boolean m23366b() {
        return !this.f33171h || Apollo.getToggle("remote_resource").allow();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m23362a(ResourceListResponser resourceListResponser) {
        File downLoadFileDirectory = FileUtils.getDownLoadFileDirectory(this.f33164a);
        if (downLoadFileDirectory != null) {
            ArrayList arrayList = new ArrayList();
            FileUtils.getFiles(arrayList, downLoadFileDirectory.getPath());
            DLog.m23371d(C11505Util.TAG, "已缓存的文件列表:" + arrayList.toString());
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < resourceListResponser.mData.size(); i++) {
                ResourceItemModel resourceItemModel = resourceListResponser.mData.get(i);
                try {
                    if (arrayList.contains(FileUtils.getDownLoadFileBySubPath(this.f33164a, resourceItemModel.key).getPath()) && TextUtils.equals(MD5.getFileMD5(FileUtils.getDownLoadFileBySubPath(this.f33164a, resourceItemModel.key)), "")) {
                        if (resourceItemModel.key.endsWith(PmFileConstant.ZIP_SUFFIX)) {
                            try {
                                File downLoadFileBySubPath = FileUtils.getDownLoadFileBySubPath(this.f33164a, resourceItemModel.key);
                                List<String> filesOfZipAndRar = FileUtils.getFilesOfZipAndRar(downLoadFileBySubPath.getPath());
                                arrayList2.addAll(filesOfZipAndRar);
                                for (int i2 = 0; i2 < filesOfZipAndRar.size(); i2++) {
                                    if (!new File(downLoadFileBySubPath.getParent(), filesOfZipAndRar.get(i2)).exists()) {
                                        FileUtils.unZip(downLoadFileBySubPath.getPath(), downLoadFileBySubPath.getParent());
                                    }
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        arrayList2.add(FileUtils.getDownLoadFileBySubPath(this.f33164a, resourceItemModel.key).getPath());
                    }
                } catch (FileNotFoundException e2) {
                    e2.printStackTrace();
                }
            }
            DLog.m23371d(C11505Util.TAG, "保留的文件列表:" + arrayList2.toString());
            arrayList.removeAll(arrayList2);
            DLog.m23371d(C11505Util.TAG, "需要删除的文件列表:" + arrayList.toString());
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                File file = new File((String) arrayList.get(i3));
                if (file.exists()) {
                    file.delete();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m23365b(ResourceListResponser resourceListResponser) {
        this.f33169f = 0;
        List<ResourceItemModel> list = resourceListResponser.mData;
        for (int i = 0; i < list.size(); i++) {
            ResourceItemModel resourceItemModel = list.get(i);
            if (this.f33172i != null) {
                resourceItemModel.OnlyWifiType = resourceItemModel.OnlyWifiType;
            }
            downFile(list.get(i));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m23363b(double d, double d2) {
        int i = this.f33169f + 1;
        this.f33169f = i;
        if (i <= 3) {
            UiThreadHandler.postOnceDelayed(new RemoteResourceManagerImpl$3(this, d, d2), 15000);
        }
    }

    public void setEnableApollo(boolean z) {
        this.f33171h = z;
    }

    public void destroy() {
        try {
            this.f33164a.unregisterReceiver(this.f33167d);
        } catch (Exception e) {
            Log.d("Context", "unregisterReceiver", e);
        }
        Apollo.removeToggleStateChangeListener(this.f33173j);
    }
}
