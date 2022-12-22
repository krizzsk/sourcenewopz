package com.didi.beatles.p099im.utils;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.commoninterfacelib.permission.IntentUtil;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.didi.beatles.im.utils.IMPermissionUtil */
public final class IMPermissionUtil {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String[] f9786a = {Permission.READ_PHONE_STATE};

    /* renamed from: com.didi.beatles.im.utils.IMPermissionUtil$OnPermissionGrantCallback */
    public interface OnPermissionGrantCallback {
        void onDenied(PermissionDenyResult... permissionDenyResultArr);

        void onGranted(String... strArr);
    }

    public static boolean checkPermissionGranted(Context context, String... strArr) {
        for (String a : strArr) {
            if (!m6641a(context, a)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m6641a(Context context, String str) {
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
            m6640a(fragmentActivity.getSupportFragmentManager(), onPermissionGrantCallback, strArr);
        }
    }

    public static void checkAndRequestPermission(Fragment fragment, OnPermissionGrantCallback onPermissionGrantCallback, String[] strArr) {
        Context context = fragment.getContext();
        if (context == null) {
            context = IMContextInfoHelper.getContext();
        }
        if (context != null) {
            if (checkPermissionGranted(context, strArr)) {
                onPermissionGrantCallback.onGranted(strArr);
            } else {
                m6640a(fragment.getChildFragmentManager(), onPermissionGrantCallback, strArr);
            }
        }
    }

    /* renamed from: a */
    private static void m6640a(FragmentManager fragmentManager, OnPermissionGrantCallback onPermissionGrantCallback, String[] strArr) {
        SupportPermissionHandler supportPermissionHandler = new SupportPermissionHandler();
        Bundle bundle = new Bundle();
        bundle.putStringArray("permissions", strArr);
        supportPermissionHandler.setArguments(bundle);
        supportPermissionHandler.setCallback(onPermissionGrantCallback);
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.add((Fragment) supportPermissionHandler, "PermissionHandler" + supportPermissionHandler.hashCode()).commit();
    }

    public static void handleStrictPermissionDenied(FragmentActivity fragmentActivity, String str) {
        IntentUtil.showPermissionDialog(fragmentActivity, str, (View.OnClickListener) null);
    }

    public static void handleOptionalPermissionDenied(Context context, String str) {
        IMToastHelper.showLongError(context, str);
    }

    /* renamed from: com.didi.beatles.im.utils.IMPermissionUtil$PermissionDenyResult */
    public static class PermissionDenyResult {
        public final boolean neverAsk;
        public final String permission;

        public PermissionDenyResult(String str, boolean z) {
            this.permission = str;
            this.neverAsk = z;
        }
    }

    /* renamed from: com.didi.beatles.im.utils.IMPermissionUtil$SupportPermissionHandler */
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
                for (String showPermissionDesc : strArr) {
                    IMPermissionDescUtil.INSTANCE.showPermissionDesc(context, showPermissionDesc);
                }
                requestPermissions(this.permissions, 4193);
            }
        }

        public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
            OnPermissionGrantCallback onPermissionGrantCallback;
            OnPermissionGrantCallback onPermissionGrantCallback2;
            super.onRequestPermissionsResult(i, strArr, iArr);
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < strArr.length; i2++) {
                String str = strArr[i2];
                if (iArr[i2] == 0) {
                    arrayList.add(str);
                } else {
                    arrayList2.add(new PermissionDenyResult(str, getActivity() != null && !ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), str)));
                }
            }
            if (arrayList.size() > 0 && (onPermissionGrantCallback2 = this.callback) != null) {
                onPermissionGrantCallback2.onGranted((String[]) arrayList.toArray(new String[0]));
            }
            if (arrayList2.size() > 0 && (onPermissionGrantCallback = this.callback) != null) {
                onPermissionGrantCallback.onDenied((PermissionDenyResult[]) arrayList2.toArray(new PermissionDenyResult[0]));
            }
            IMPermissionDescUtil.INSTANCE.hidePermissionDesc();
            List asList = Arrays.asList(IMPermissionUtil.f9786a);
            Iterator it = arrayList2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PermissionDenyResult permissionDenyResult = (PermissionDenyResult) it.next();
                if (asList.contains(permissionDenyResult.permission) && getActivity() != null) {
                    IMPermissionUtil.handleStrictPermissionDenied(getActivity(), permissionDenyResult.permission);
                    break;
                }
            }
            getFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
        }
    }
}
