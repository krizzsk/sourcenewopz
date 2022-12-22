package com.didiglobal.privacysdk.law.prepose;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.taxis99.R;

public class LawPreposeDialogManager {

    /* renamed from: a */
    private static final String f50658a = "hasAgreeCountryAgreementFor";

    /* renamed from: b */
    private static final String f50659b = "agreeCountryAgreementTimeFor";

    /* renamed from: c */
    private static final String f50660c = "Application";

    /* renamed from: d */
    private static String f50661d = "";
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static boolean f50662e = false;

    public static void showPreposeDialog(final FragmentActivity fragmentActivity, final String str, String str2, final AlertDialogFragment.OnClickListener onClickListener, AlertDialogFragment.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        String appName = ApkUtils.getAppName(fragmentActivity);
        FragmentActivity fragmentActivity2 = fragmentActivity;
        new C17074a().mo123716a(fragmentActivity2, new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                alertDialogFragment.dismiss();
                LawPreposeDialogManager.m36373b(fragmentActivity, str, true);
                AlertDialogFragment.OnClickListener onClickListener = onClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(alertDialogFragment, view);
                }
            }
        }, onClickListener2, onClickListener3, fragmentActivity.getString(R.string.Others_optimization_DiDi_legal_Ghcb, new Object[]{appName}), fragmentActivity.getString(R.string.Others_optimization_Before_you_ITSS, new Object[]{appName}), fragmentActivity.getString(R.string.Others_optimization__app_IWgx, new Object[]{appName}), fragmentActivity.getString(R.string.Others_optimization_Agree_nQGV), fragmentActivity.getString(R.string.Others_optimization_Disagree_and_gUEP));
    }

    public static void showLocationChangeLawDialog(final FragmentActivity fragmentActivity, final String str, final AlertDialogFragment.OnClickListener onClickListener, final AlertDialogFragment.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        f50661d = str;
        String appName = ApkUtils.getAppName(fragmentActivity);
        String string = fragmentActivity.getString(R.string.Others_optimization_DiDi_legal_Ghcb, new Object[]{appName});
        String string2 = fragmentActivity.getString(R.string.Others_optimization_The_area_TKKI);
        String string3 = fragmentActivity.getString(R.string.Others_optimization__app_IWgx, new Object[]{appName});
        String string4 = fragmentActivity.getString(R.string.Others_optimization_Agree_nQGV);
        String string5 = fragmentActivity.getString(R.string.Others_optimization_Disagree_and_gUEP);
        f50662e = true;
        new C17074a().mo123716a(fragmentActivity, new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                alertDialogFragment.dismiss();
                LawPreposeDialogManager.m36373b(fragmentActivity, str, true);
                boolean unused = LawPreposeDialogManager.f50662e = false;
                AlertDialogFragment.OnClickListener onClickListener = onClickListener;
                if (onClickListener != null) {
                    onClickListener.onClick(alertDialogFragment, view);
                }
            }
        }, new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                AlertDialogFragment.OnClickListener onClickListener = onClickListener2;
                if (onClickListener != null) {
                    onClickListener.onClick(alertDialogFragment, view);
                }
                boolean unused = LawPreposeDialogManager.f50662e = false;
            }
        }, onClickListener3, string, string2, string3, string4, string5);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m36373b(Context context, String str, boolean z) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        LawPreposeSPUtils.m36376a(context, m36369a(str), Boolean.valueOf(z));
        LawPreposeSPUtils.m36376a(context, m36369a(f50660c), Boolean.valueOf(z));
        if (0 == getAgreeTimeFor(context, m36369a(str))) {
            LawPreposeSPUtils.m36376a(context, m36372b(str), Long.valueOf(currentTimeMillis));
        }
        if (0 == getAgreeTimeForApp(context)) {
            LawPreposeSPUtils.m36376a(context, m36372b(f50660c), Long.valueOf(currentTimeMillis));
        }
    }

    /* renamed from: a */
    private static String m36369a(String str) {
        return f50658a + str;
    }

    /* renamed from: b */
    private static String m36372b(String str) {
        return f50659b + str;
    }

    public static boolean hasAgreeFor(Context context, String str) {
        return ((Boolean) LawPreposeSPUtils.m36377b(context, m36369a(str), false)).booleanValue();
    }

    public static boolean hasAgreeForApp(Context context) {
        return ((Boolean) LawPreposeSPUtils.m36377b(context, m36369a(f50660c), false)).booleanValue();
    }

    public static long getAgreeTimeFor(Context context, String str) {
        return ((Long) LawPreposeSPUtils.m36377b(context, m36372b(str), 0L)).longValue();
    }

    public static long getAgreeTimeForApp(Context context) {
        return ((Long) LawPreposeSPUtils.m36377b(context, m36372b(f50660c), 0L)).longValue();
    }

    public static String getLastCountryIsoCode() {
        return f50661d;
    }

    public static boolean isLocationChangedDialogShowing() {
        return f50662e;
    }

    public static boolean isLocationChangedDialogShowingForSameCountry(String str) {
        return f50662e && f50661d.equals(str);
    }
}
