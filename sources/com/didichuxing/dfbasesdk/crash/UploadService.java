package com.didichuxing.dfbasesdk.crash;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.security.safecollector.WsgSecInfo;
import didihttp.DidiHttpClient;
import didihttp.MediaType;
import didihttp.Request;
import didihttp.RequestBody;
import java.io.IOException;

public class UploadService extends IntentService {
    public static final String JSON = "json";
    public static final String URL = "url";

    public UploadService() {
        super("upload_service");
    }

    public static void startService(Context context, String str, String str2) {
        Intent intent = new Intent(context, UploadService.class);
        intent.putExtra("url", str);
        intent.putExtra("json", str2);
        intent.addFlags(268435456);
        context.startService(intent);
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        if (intent != null) {
            try {
                String stringExtra = intent.getStringExtra("url");
                String stringExtra2 = intent.getStringExtra("json");
                try {
                    new DidiHttpClient().newCall(new Request.Builder().url(stringExtra).post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), stringExtra2)).header("User-Agent", m33417a(this)).build()).execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private String m33417a(Context context) {
        StringBuilder sb = new StringBuilder();
        sb.append("Android/");
        sb.append(WsgSecInfo.osVersion(context));
        sb.append(" ");
        sb.append("didihttp");
        sb.append(" ");
        sb.append("OneNet/");
        sb.append("2.1.0.66");
        try {
            String packageName = WsgSecInfo.packageName(context);
            String appVersionName = WsgSecInfo.appVersionName(context);
            sb.append(" ");
            sb.append(packageName);
            sb.append("/");
            sb.append(appVersionName);
        } catch (Exception e) {
            LogUtils.logStackTrace(e);
        }
        return sb.toString();
    }
}
