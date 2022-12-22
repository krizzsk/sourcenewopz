package com.didi.remotereslibrary.downservice;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import com.didi.dimina.container.secondparty.bundle.util.PmFileConstant;
import com.didi.remotereslibrary.ResourceItemModel;
import com.didi.remotereslibrary.store.RemoteResourceStore;
import com.didi.remotereslibrary.utils.C11505Util;
import com.didi.remotereslibrary.utils.Constants;
import com.didi.remotereslibrary.utils.DLog;
import com.didi.remotereslibrary.utils.FileUtils;
import com.didi.sdk.onehotpatch.openapi.HotpatchStateConst;
import com.didi.sdk.util.MD5;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class DiDiDownLoadManager implements IRemoteSourceDownLoadManager {

    /* renamed from: a */
    private DownloadManager f33174a;

    /* renamed from: b */
    private Context f33175b;

    /* renamed from: c */
    private String f33176c = Environment.DIRECTORY_DOWNLOADS;

    public DiDiDownLoadManager(Context context) {
        this.f33175b = context.getApplicationContext();
        this.f33174a = (DownloadManager) context.getSystemService(HotpatchStateConst.DOWNLOAD);
    }

    public long downFile(ResourceItemModel resourceItemModel) {
        String str;
        File downLoadFileBySubPath = FileUtils.getDownLoadFileBySubPath(this.f33175b, resourceItemModel.key);
        if (downLoadFileBySubPath.exists()) {
            try {
                str = MD5.getFileMD5(downLoadFileBySubPath);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                str = "";
            }
            if (TextUtils.equals(str, resourceItemModel.md5)) {
                DLog.m23371d(C11505Util.TAG, "文件没有被修改，并且文件已经存在，无需下载" + resourceItemModel.key);
                return 0;
            }
            if (!TextUtils.isEmpty(downLoadFileBySubPath.getPath()) && downLoadFileBySubPath.getPath().endsWith(PmFileConstant.ZIP_SUFFIX)) {
                ArrayList arrayList = new ArrayList();
                FileUtils.getFiles(arrayList, downLoadFileBySubPath.getPath());
                for (int i = 0; i < arrayList.size(); i++) {
                    File file = new File((String) arrayList.get(i));
                    if (file.exists()) {
                        file.delete();
                    }
                }
            }
            if (downLoadFileBySubPath.exists()) {
                downLoadFileBySubPath.delete();
            }
        }
        long enqueue = this.f33174a.enqueue(m23368a(resourceItemModel));
        DLog.m23371d(C11505Util.TAG, "开始下载: 开始时间:" + System.currentTimeMillis() + "下载号为" + enqueue + " 文件为:" + resourceItemModel.key + "....");
        RemoteResourceStore instance = RemoteResourceStore.getInstance(this.f33175b);
        StringBuilder sb = new StringBuilder();
        sb.append(enqueue);
        sb.append("");
        instance.putJsonObj(sb.toString(), resourceItemModel);
        return enqueue;
    }

    /* renamed from: a */
    private DownloadManager.Request m23368a(ResourceItemModel resourceItemModel) {
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(resourceItemModel.url));
        int i = 2;
        request.setAllowedNetworkTypes(resourceItemModel.OnlyWifiType ? 2 : 1);
        if (!resourceItemModel.HideNoticationView) {
            i = 0;
        }
        request.setNotificationVisibility(i);
        Context context = this.f33175b;
        String str = this.f33176c;
        request.setDestinationInExternalFilesDir(context, str, Constants.DIRECTORY_DOWNLOADS_SUBPATH + resourceItemModel.key);
        return request;
    }
}
