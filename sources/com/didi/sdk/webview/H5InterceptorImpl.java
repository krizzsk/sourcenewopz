package com.didi.sdk.webview;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.didichuxing.apollo.sdk.Apollo;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class H5InterceptorImpl implements IH5Interceptor {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Logger f38387a = LoggerFactory.getLogger("H5InterceptorImpl");

    public boolean intercept(FragmentActivity fragmentActivity, String str) {
        if (fragmentActivity != null && !TextUtils.isEmpty(str)) {
            m27155a("deep_link_web_url", str);
            if (!m27156a(str)) {
                m27155a("deep_link_web_url_intercepted", str);
                m27153a(fragmentActivity, str);
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m27155a(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", str2);
        OmegaSDKAdapter.trackEvent(str, (Map<String, Object>) hashMap);
    }

    /* renamed from: a */
    private void m27153a(final FragmentActivity fragmentActivity, final String str) {
        new AlertDialogFragment.Builder(fragmentActivity).setTitle(fragmentActivity.getResources().getText(R.string.global_invalid_h5_dialog_title)).setMessage(fragmentActivity.getResources().getText(R.string.global_invalid_h5_dialog_content)).setPositiveButton((int) R.string.global_invalid_h5_dialog_positive_btn, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                H5InterceptorImpl.this.m27152a((Activity) fragmentActivity, str);
                Logger a = H5InterceptorImpl.this.f38387a;
                a.debug("open h5 in other browser ,url = " + str, new Object[0]);
            }
        }).setNegativeButton((int) R.string.global_invalid_h5_dialog_nagative_btn, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                fragmentActivity.finish();
            }
        }).setCancelable(false).create().show(fragmentActivity.getSupportFragmentManager(), "");
    }

    /* renamed from: a */
    private boolean m27156a(String str) {
        String[] a = m27157a();
        if (a == null || a.length == 0) {
            return true;
        }
        String host = Uri.parse(str).getHost();
        if (TextUtils.isEmpty(host)) {
            return true;
        }
        for (String equals : a) {
            if (host.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private String[] m27157a() {
        String str = (String) Apollo.getToggle("deep_link_web_whitelist").getExperiment().getParam("whitelist", "");
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(",");
        Logger logger = this.f38387a;
        logger.debug("white list size = " + split.length, new Object[0]);
        return split;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27152a(Activity activity, String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        if (intent.resolveActivity(activity.getPackageManager()) != null) {
            activity.startActivity(intent);
        } else {
            Logger logger = this.f38387a;
            logger.error("can't find browser,url  = " + str, new Object[0]);
        }
        activity.finish();
    }
}
