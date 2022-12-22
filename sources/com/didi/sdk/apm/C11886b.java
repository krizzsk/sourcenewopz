package com.didi.sdk.apm;

import android.content.Intent;
import android.content.IntentSender;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import androidx.fragment.app.Fragment;

/* renamed from: com.didi.sdk.apm.b */
/* compiled from: FragmentHelper */
class C11886b {

    /* renamed from: a */
    public static final String f34975a = "FragmentHelper";

    C11886b() {
    }

    /* renamed from: a */
    public static boolean m24736a(Fragment fragment) {
        return (fragment.getHost() == null || fragment.getActivity() == null || fragment.getActivity().isFinishing()) ? false : true;
    }

    /* renamed from: a */
    public static boolean m24735a(android.app.Fragment fragment) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (fragment.getHost() == null || fragment.getActivity() == null || fragment.getActivity().isFinishing()) {
                return false;
            }
            return true;
        } else if (fragment.getActivity() == null || fragment.getActivity().isFinishing()) {
            return false;
        } else {
            return true;
        }
    }

    /* renamed from: a */
    public static void m24730a(Fragment fragment, Intent intent) {
        m24733a(fragment, intent, (Bundle) null);
    }

    /* renamed from: a */
    public static void m24733a(Fragment fragment, Intent intent, Bundle bundle) {
        if (!m24736a(fragment)) {
            Log.e(f34975a, "Fragment " + fragment + " try startActivity when detached. ");
            return;
        }
        fragment.startActivity(intent, bundle);
    }

    /* renamed from: a */
    public static void m24731a(Fragment fragment, Intent intent, int i) {
        m24732a(fragment, intent, i, (Bundle) null);
    }

    /* renamed from: a */
    public static void m24732a(Fragment fragment, Intent intent, int i, Bundle bundle) {
        if (!m24736a(fragment)) {
            Log.e(f34975a, "Fragment " + fragment + " try startActivityForResult when detached. ");
            return;
        }
        fragment.startActivityForResult(intent, i, bundle);
    }

    /* renamed from: a */
    public static void m24734a(Fragment fragment, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (!m24736a(fragment)) {
            Log.e(f34975a, "Fragment " + fragment + " try startIntentSenderForResult when detached. ");
            return;
        }
        fragment.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    /* renamed from: a */
    public static void m24725a(android.app.Fragment fragment, Intent intent) {
        m24728a(fragment, intent, (Bundle) null);
    }

    /* renamed from: a */
    public static void m24728a(android.app.Fragment fragment, Intent intent, Bundle bundle) {
        if (!m24735a(fragment)) {
            Log.e(f34975a, "Fragment " + fragment + " try startActivity when detached .");
            return;
        }
        fragment.startActivity(intent, bundle);
    }

    /* renamed from: a */
    public static void m24726a(android.app.Fragment fragment, Intent intent, int i) {
        m24727a(fragment, intent, i, (Bundle) null);
    }

    /* renamed from: a */
    public static void m24727a(android.app.Fragment fragment, Intent intent, int i, Bundle bundle) {
        if (!m24735a(fragment)) {
            Log.e(f34975a, "Fragment " + fragment + " try startActivityForResult when detached. ");
            return;
        }
        fragment.startActivityForResult(intent, i, bundle);
    }

    /* renamed from: a */
    public static void m24729a(android.app.Fragment fragment, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) throws IntentSender.SendIntentException {
        if (!m24735a(fragment)) {
            Log.e(f34975a, "Fragment " + fragment + " try startIntentSenderForResult when detached. ");
            return;
        }
        fragment.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }
}
