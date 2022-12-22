package com.didi.remotereslibrary.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.didi.dimina.container.secondparty.bundle.util.PmFileConstant;
import com.didi.remotereslibrary.ResourceItemModel;
import com.didi.remotereslibrary.store.RemoteResourceStore;
import com.didi.remotereslibrary.utils.C11505Util;
import com.didi.remotereslibrary.utils.DLog;
import com.didi.remotereslibrary.utils.FileUtils;
import com.didi.sdk.util.TextUtil;
import java.io.File;

public class FileDownBroadcast extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String str;
        long longExtra = intent.getLongExtra("extra_download_id", -1);
        RemoteResourceStore instance = RemoteResourceStore.getInstance(context);
        ResourceItemModel resourceItemModel = (ResourceItemModel) instance.getJsonObj(longExtra + "", ResourceItemModel.class);
        if (resourceItemModel != null) {
            if (!TextUtil.isEmpty(resourceItemModel.key) && resourceItemModel.key.endsWith(PmFileConstant.ZIP_SUFFIX)) {
                File downLoadFileBySubPath = FileUtils.getDownLoadFileBySubPath(context, resourceItemModel.key);
                FileUtils.unZip(downLoadFileBySubPath.getPath(), downLoadFileBySubPath.getParent());
            }
            StringBuilder sb = new StringBuilder();
            sb.append("下载广播id：");
            sb.append(longExtra);
            sb.append("结束时间:");
            sb.append(System.currentTimeMillis());
            sb.append("  下载完成 文件名称:");
            if (resourceItemModel == null) {
                str = "";
            } else {
                str = resourceItemModel.key;
            }
            sb.append(str);
            sb.append("\r\n\r\n");
            DLog.m23371d(C11505Util.TAG, sb.toString());
            RemoteResourceStore.getInstance(context).post(resourceItemModel);
            RemoteResourceStore instance2 = RemoteResourceStore.getInstance(context);
            instance2.remove(longExtra + "");
        }
    }
}
