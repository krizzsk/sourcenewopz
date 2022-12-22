package com.didi.component.splitfare.util;

import android.content.Context;
import android.os.Bundle;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.didi.component.common.util.GLog;
import com.didi.sdk.app.DIDIBaseApplication;
import com.didi.sdk.util.DebugUtils;
import com.didi.sdk.util.ToastHelper;
import java.util.ArrayList;

public final class SplitFarePermissionUtil {

    public interface OnPermissionGrantCallback {
        void onDenied(String... strArr);

        void onGranted(String... strArr);
    }

    public static boolean checkPermissionGranted(Context context, String... strArr) {
        for (String a : strArr) {
            if (!m11764a(context, a)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m11764a(Context context, String str) {
        try {
            return ContextCompat.checkSelfPermission(context, str) == 0;
        } catch (RuntimeException unused) {
            return false;
        }
    }

    public static void checkAndRequestPermission(FragmentActivity fragmentActivity, OnPermissionGrantCallback onPermissionGrantCallback, String[] strArr) {
        if (checkPermissionGranted(fragmentActivity, strArr)) {
            onPermissionGrantCallback.onGranted(strArr);
        } else {
            m11763a(fragmentActivity.getSupportFragmentManager(), onPermissionGrantCallback, strArr);
        }
    }

    public static void checkAndRequestPermission(Fragment fragment, OnPermissionGrantCallback onPermissionGrantCallback, String[] strArr) {
        Context context = fragment.getContext();
        if (context == null) {
            if (!DebugUtils.isDebug()) {
                context = DIDIBaseApplication.getAppContext();
            } else {
                throw new NullPointerException("fragment's context is NULL");
            }
        }
        if (context == null) {
            GLog.m7968e("SplitFarePermissionUtil", "fragment context is null...");
        } else if (checkPermissionGranted(context, strArr)) {
            onPermissionGrantCallback.onGranted(strArr);
        } else {
            m11763a(fragment.getChildFragmentManager(), onPermissionGrantCallback, strArr);
        }
    }

    /* renamed from: a */
    private static void m11763a(FragmentManager fragmentManager, OnPermissionGrantCallback onPermissionGrantCallback, String[] strArr) {
        SupportPermissionHandler supportPermissionHandler = new SupportPermissionHandler();
        Bundle bundle = new Bundle();
        bundle.putStringArray("permissions", strArr);
        supportPermissionHandler.setArguments(bundle);
        supportPermissionHandler.setCallback(onPermissionGrantCallback);
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add((Fragment) supportPermissionHandler, "PermissionHandler" + supportPermissionHandler.hashCode()).commit();
    }

    public static void handleOptionalPermissionDenied(Context context, String str) {
        ToastHelper.showLongInfo(context, str);
    }

    public static class SupportPermissionHandler extends Fragment {
        private static final int PERMISSION_REQUEST_CODE = 4193;
        private static final String TAG = "PermissionHandler";
        private OnPermissionGrantCallback callback;
        private String[] permissions;

        public void setCallback(OnPermissionGrantCallback onPermissionGrantCallback) {
            this.callback = onPermissionGrantCallback;
        }

        public void onAttach(Context context) {
            super.onAttach(context);
            if (getArguments() != null) {
                this.permissions = getArguments().getStringArray("permissions");
            }
            String[] strArr = this.permissions;
            if (strArr != null) {
                requestPermissions(strArr, 4193);
            }
        }

        public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
            super.onRequestPermissionsResult(i, strArr, iArr);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < strArr.length; i2++) {
                String str = strArr[i2];
                if (iArr[i2] == 0) {
                    arrayList.add(str);
                } else {
                    arrayList2.add(str);
                }
            }
            if (arrayList.size() > 0) {
                this.callback.onGranted((String[]) arrayList.toArray(new String[arrayList.size()]));
            }
            if (arrayList2.size() > 0) {
                this.callback.onDenied((String[]) arrayList2.toArray(new String[arrayList2.size()]));
            }
            getFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
        }
    }
}
