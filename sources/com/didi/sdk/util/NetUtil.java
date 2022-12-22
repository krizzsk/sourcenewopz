package com.didi.sdk.util;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.log.Logger;
import com.didi.sdk.log.Printer;
import com.didi.sdk.log.TraceLogUtil;
import com.didi.sdk.view.dialog.AlertController;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.taxis99.R;
import java.io.IOException;

public class NetUtil {

    /* renamed from: a */
    private static final String f37661a = "NetUtil";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static boolean f37662b = false;

    public static boolean isAvailable(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected();
    }

    public static void checkNetStatus(FragmentActivity fragmentActivity) {
        if (fragmentActivity != null && !isAvailable(fragmentActivity)) {
            showNetDialog(fragmentActivity);
        }
    }

    public static void showNetDialog(final FragmentActivity fragmentActivity) {
        if (!f37662b) {
            TraceLogUtil.addLogWithTab("permission_locate_net_error_show", new String[0]);
            new AlertDialogFragment.Builder(fragmentActivity).setIcon(AlertController.IconType.INFO).setMessage(fragmentActivity.getString(R.string.locate_net_error_txt)).setOnDismissListener(new AlertDialogFragment.OnDismissListener() {
                public void onDismiss(AlertDialogFragment alertDialogFragment) {
                    boolean unused = NetUtil.f37662b = false;
                }
            }).setPositiveButton((CharSequence) fragmentActivity.getString(R.string.setting), (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
                public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                    alertDialogFragment.dismiss();
                    try {
                        Intent intent = new Intent("android.settings.DATA_ROAMING_SETTINGS");
                        intent.setFlags(268435456);
                        fragmentActivity.startActivity(intent);
                        TraceLogUtil.addLogWithTab("permission_locate_net_error_submit", new String[0]);
                    } catch (Exception unused) {
                    }
                }
            }).setPositiveButtonDefault().setNegativeButton((CharSequence) fragmentActivity.getString(R.string.cancel), (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
                public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                    alertDialogFragment.dismiss();
                    TraceLogUtil.addLogWithTab("permission_locate_net_error_cancel", new String[0]);
                }
            }).create().show(fragmentActivity.getSupportFragmentManager(), "locate_net_error_dlg");
            f37662b = true;
        }
    }

    public static int ping(String str) {
        try {
            Runtime runtime = Runtime.getRuntime();
            int waitFor = runtime.exec("ping -c 1 -w 20 " + str).waitFor();
            Printer t = Logger.m25813t(f37661a);
            t.normalLog("status = " + waitFor);
            return waitFor;
        } catch (IOException e) {
            e.printStackTrace();
            Logger.m25813t(f37661a).normalLog("ping IOException");
            return -1;
        } catch (InterruptedException e2) {
            Logger.m25813t(f37661a).normalLog("ping InterruptedException");
            e2.printStackTrace();
            return -1;
        }
    }
}
