package com.didi.commoninterfacelib.permission;

import android.content.Context;
import android.content.Intent;
import android.util.SparseArray;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PermissionUtil {
    private static SparseArray<Request> permissionCallback = new SparseArray<>();
    private static int requestCode;
    private static Map<String, Integer> sPermissionMap;

    private static class Request {
        PermissionCallback callback;
        String[] permissions;

        public Request(String[] strArr, PermissionCallback permissionCallback) {
            this.permissions = strArr;
            this.callback = permissionCallback;
        }
    }

    static {
        HashMap hashMap = new HashMap();
        sPermissionMap = hashMap;
        hashMap.put(Permission.CAMERA, Integer.valueOf(R.string.permission_camera));
        sPermissionMap.put(Permission.RECORD_AUDIO, Integer.valueOf(R.string.permission_microphone));
    }

    public static synchronized int createRequestCode() {
        int i;
        synchronized (PermissionUtil.class) {
            int i2 = requestCode + 1;
            requestCode = i2;
            i = i2 % 65535;
            requestCode = i;
        }
        return i;
    }

    public static void requestPermissions(PermissionContext permissionContext, PermissionCallback permissionCallback2, String str, boolean z) {
        requestPermissions(permissionContext, permissionCallback2, new String[]{str}, z);
    }

    public static void requestPermissions(final PermissionContext permissionContext, final PermissionCallback permissionCallback2, String[] strArr, final boolean z) {
        int createRequestCode = createRequestCode();
        permissionCallback.put(createRequestCode, new Request(strArr, new PermissionCallback() {
            public void isAllGranted(boolean z, String[] strArr) {
                PermissionCallback permissionCallback = permissionCallback2;
                if (permissionCallback != null) {
                    permissionCallback.isAllGranted(z, strArr);
                }
                if (!z && z) {
                    try {
                        SystemUtils.showToast(Toast.makeText(permissionContext.getContextByPermissionContext(), PermissionUtil.getDeniedPermissionTipContent(permissionContext.getContextByPermissionContext(), strArr), 0));
                    } catch (Exception unused) {
                    }
                }
            }
        }));
        permissionContext.requestPermissionsByPermissionContext(strArr, createRequestCode);
    }

    public static void checkAndRequestPermissions(PermissionContext permissionContext, PermissionCallback permissionCallback2, String[] strArr, boolean z) {
        if (!checkPermissionAllGranted(permissionContext.getContextByPermissionContext(), strArr)) {
            requestPermissions(permissionContext, permissionCallback2, strArr, z);
        } else if (permissionCallback2 != null) {
            permissionCallback2.isAllGranted(true, (String[]) null);
        }
    }

    public static void checkAndRequestPermissions(PermissionContext permissionContext, PermissionCallback permissionCallback2, String str, boolean z) {
        checkAndRequestPermissions(permissionContext, permissionCallback2, new String[]{str}, z);
    }

    static void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        PermissionCallback permissionCallback2;
        Request request = permissionCallback.get(i);
        if (request != null && (permissionCallback2 = request.callback) != null) {
            permissionCallback.delete(i);
            String[] deniedPermission = getDeniedPermission(request.permissions, iArr);
            permissionCallback2.isAllGranted(deniedPermission.length == 0, deniedPermission);
        }
    }

    static boolean hasPermissions(String[] strArr, int[] iArr) {
        for (int i : iArr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    static String[] getDeniedPermission(String[] strArr, int[] iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < iArr.length; i++) {
            if (iArr[i] != 0 && strArr.length > i) {
                arrayList.add(strArr[i]);
            }
        }
        if (iArr.length == 0) {
            return (String[]) strArr.clone();
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean checkPermissionAllGranted(Context context, String[] strArr) {
        for (String checkPermissionAllGranted : strArr) {
            if (!checkPermissionAllGranted(context, checkPermissionAllGranted)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkPermissionAllGranted(Context context, String str) {
        return ContextCompat.checkSelfPermission(context, str) == 0;
    }

    public static void openCameraWithPermission(final PermissionContext permissionContext, String str, PermissionCallback permissionCallback2, boolean z) {
        final Intent cameraIntent = IntentUtil.getCameraIntent(permissionContext.getContextByPermissionContext(), str);
        if (cameraIntent != null) {
            checkAndRequestPermissions(permissionContext, (PermissionCallback) new PermissionCallback() {
                public void isAllGranted(boolean z, String[] strArr) {
                    permissionContext.startActivityByPermissionContext(cameraIntent);
                }
            }, Permission.CAMERA, z);
        }
    }

    static String getDeniedPermissionTipContent(Context context, String[] strArr) {
        return context.getString(R.string.denied_permission_toast, new Object[]{(strArr == null || strArr.length <= 0) ? "permission" : context.getString(sPermissionMap.get(strArr[0]).intValue())});
    }
}
