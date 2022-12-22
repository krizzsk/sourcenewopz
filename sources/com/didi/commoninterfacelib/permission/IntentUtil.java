package com.didi.commoninterfacelib.permission;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import java.io.File;

public class IntentUtil {
    public static final int REQUEST_APP_SETTINGS = 201;
    /* access modifiers changed from: private */
    public static AlertDialog.Builder mPermissionDialog;

    @Deprecated
    public static Intent getCameraIntent(Context context, File file) {
        return getCameraIntent(context, file == null ? "" : file.getAbsolutePath());
    }

    @Deprecated
    public static Intent getCameraIntent(Context context, String str) {
        if (context == null) {
            return null;
        }
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(context.getPackageManager()) == null) {
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            if (Build.VERSION.SDK_INT < 24) {
                intent.putExtra("output", Uri.fromFile(new File(str)));
            } else {
                ContentValues contentValues = new ContentValues(1);
                contentValues.put("_data", str);
                intent.putExtra("output", context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues));
            }
        }
        return intent;
    }

    public static Intent getCameraIntent(Context context, String str, String str2) {
        if (context == null) {
            return null;
        }
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(context.getPackageManager()) == null) {
            return null;
        }
        if (!TextUtils.isEmpty(str)) {
            if (Build.VERSION.SDK_INT < 24) {
                intent.putExtra("output", Uri.fromFile(new File(str)));
            } else {
                intent.putExtra("output", FileProvider.getUriForFile(context, str2, new File(str)));
                intent.addFlags(1);
                intent.addFlags(2);
            }
        }
        return intent;
    }

    public static void showPermissionDialog(FragmentActivity fragmentActivity, String str, String str2, String str3) {
        showPermissionDialog(fragmentActivity, str, str2, str3, (View.OnClickListener) null);
    }

    public static AlertDialog showPermissionDialog(final FragmentActivity fragmentActivity, String str, String str2, String str3, final View.OnClickListener onClickListener) {
        if (mPermissionDialog == null) {
            if (Build.VERSION.SDK_INT < 21) {
                mPermissionDialog = new AlertDialog.Builder(fragmentActivity);
            } else {
                mPermissionDialog = new AlertDialog.Builder(fragmentActivity, 16974394);
            }
            mPermissionDialog.setMessage(str);
            mPermissionDialog.setPositiveButton(str2, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    AutoTrackHelper.trackViewOnClick(dialogInterface, i);
                    IntentUtil.toPermissionSetting(fragmentActivity);
                    AlertDialog.Builder unused = IntentUtil.mPermissionDialog = null;
                }
            });
            mPermissionDialog.setNegativeButton(str3, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    AutoTrackHelper.trackViewOnClick(dialogInterface, i);
                    AlertDialog.Builder unused = IntentUtil.mPermissionDialog = null;
                    View.OnClickListener onClickListener = onClickListener;
                    if (onClickListener != null) {
                        onClickListener.onClick((View) null);
                    }
                }
            });
            mPermissionDialog.setCancelable(false);
        }
        return mPermissionDialog.show();
    }

    public static AlertDialog showPermissionDialog(FragmentActivity fragmentActivity, String str, View.OnClickListener onClickListener) {
        return showPermissionDialog(fragmentActivity, IntentPermissionManager.getInstance().getPermissionDescription(str), IntentPermissionManager.getInstance().getConfirm(), IntentPermissionManager.getInstance().getCancel(), onClickListener);
    }

    public static void toPermissionSetting(FragmentActivity fragmentActivity) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + fragmentActivity.getPackageName()));
        intent.addCategory("android.intent.category.DEFAULT");
        fragmentActivity.startActivityForResult(intent, 201);
    }
}
