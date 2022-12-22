package com.didi.permission;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import androidx.fragment.app.Fragment;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;

public class DPermission {
    public static void permissionRequest(Fragment fragment, int i, OnPermissionCallback onPermissionCallback) {
        permissionRequest((Activity) fragment.getActivity(), i, onPermissionCallback);
    }

    public static void permissionRequest(Activity activity, int i, OnPermissionCallback onPermissionCallback) {
        PermissionManagerByFragment.permissionRequest(activity, i, onPermissionCallback);
    }

    public static void permissionRequest(Fragment fragment, int i, String[] strArr, OnPermissionCallback onPermissionCallback) {
        permissionRequest((Activity) fragment.getActivity(), i, onPermissionCallback);
    }

    public static void permissionRequest(Activity activity, int i, String[] strArr, OnPermissionCallback onPermissionCallback) {
        PermissionManagerByFragment.permissionRequest(activity, i, strArr, onPermissionCallback);
    }

    public static void showTipDialog(Context context, String str, String str2) {
        showTipDialog(context, str, str2, "取消", "设置权限", (OnTipDialogCallback) null);
    }

    public static void showTipDialog(final Context context, String str, String str2, String str3, String str4, final OnTipDialogCallback onTipDialogCallback) {
        SystemUtils.showDialog(new AlertDialog.Builder(context).setTitle(str).setMessage(str2).setNegativeButton(str3, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                AutoTrackHelper.trackViewOnClick(dialogInterface, i);
                OnTipDialogCallback onTipDialogCallback = onTipDialogCallback;
                if (onTipDialogCallback != null) {
                    onTipDialogCallback.onCancel();
                }
            }
        }).setPositiveButton(str4, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                AutoTrackHelper.trackViewOnClick(dialogInterface, i);
                DPermission.toSetPermissions(context);
                OnTipDialogCallback onTipDialogCallback = onTipDialogCallback;
                if (onTipDialogCallback != null) {
                    onTipDialogCallback.onSure();
                }
            }
        }).create());
    }

    public static void toSetPermissions(Context context) {
        context.startActivity(new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.fromParts("package", context.getPackageName(), (String) null)));
    }
}
