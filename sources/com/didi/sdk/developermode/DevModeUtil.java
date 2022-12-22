package com.didi.sdk.developermode;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Process;
import android.view.View;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.UiThreadHandler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class DevModeUtil {

    /* renamed from: a */
    private static String f35829a = "";

    @Deprecated
    public static boolean isTestEnvironment(Context context) {
        return getDevEnvironment(context) == DevEnvironment.DEBUG;
    }

    public static DevEnvironment getDevEnvironment(Context context) {
        return DevEnvironment.getDevEnvironmentByOrdinal(DevModePreference.getDevEnvironmentFlag(context));
    }

    public static boolean isPreRelease(Context context) {
        return DevModePreference.getPreEnable(context);
    }

    public static boolean isWebViewDebugEnable(Context context) {
        return DevModePreference.getWebViewDebugEnable(context);
    }

    /* renamed from: a */
    static void m25372a(Context context, String str, String str2, DialogInterface.OnClickListener onClickListener) {
        if (context != null) {
            SystemUtils.showDialog(new AlertDialog.Builder(context).setTitle(str).setMessage(str2).setPositiveButton("确定", onClickListener).setNegativeButton("取消", (DialogInterface.OnClickListener) null).create());
        }
    }

    /* renamed from: a */
    static void m25371a(Context context, String str, View view, DialogInterface.OnClickListener onClickListener) {
        if (context != null) {
            SystemUtils.showDialog(new AlertDialog.Builder(context).setTitle(str).setView(view).setPositiveButton("确定", onClickListener).setNegativeButton("取消", (DialogInterface.OnClickListener) null).create());
        }
    }

    /* renamed from: a */
    static void m25370a() {
        UiThreadHandler.postDelayed(new Runnable() {
            public void run() {
                Process.killProcess(Process.myPid());
            }
        }, 2000);
    }

    /* renamed from: a */
    static String m25369a(Context context) {
        if (!TextUtil.isEmpty(f35829a)) {
            return f35829a;
        }
        String str = "";
        if (context == null) {
            return str;
        }
        try {
            ZipFile zipFile = new ZipFile(context.getApplicationInfo().sourceDir);
            ZipEntry entry = zipFile.getEntry("assets/META-INF/versions");
            if (entry != null) {
                if (entry.getSize() > 0) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(zipFile.getInputStream(entry)));
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        str = str + "\n" + readLine;
                    }
                    bufferedReader.close();
                    if (!TextUtil.isEmpty(str)) {
                        f35829a = str;
                    }
                    return str;
                }
            }
            return str;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public enum DevEnvironment {
        RELEASE("线上环境"),
        DEBUG("线下环境"),
        UNDEFINE("未定义，业务线可控制环境");
        
        private String meaning;

        private DevEnvironment(String str) {
            this.meaning = str;
        }

        public String getMeaning() {
            return this.meaning;
        }

        public static List<String> getDevEnvironmentTypeMeanings() {
            ArrayList arrayList = new ArrayList();
            for (DevEnvironment meaning2 : values()) {
                arrayList.add(meaning2.getMeaning());
            }
            return arrayList;
        }

        public static DevEnvironment getDevEnvironmentByOrdinal(int i) {
            for (DevEnvironment devEnvironment : values()) {
                if (devEnvironment.ordinal() == i) {
                    return devEnvironment;
                }
            }
            return UNDEFINE;
        }
    }
}
