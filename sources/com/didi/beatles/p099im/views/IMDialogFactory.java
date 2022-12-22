package com.didi.beatles.p099im.views;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import com.didi.beatles.p099im.views.dialog.IMAlertController;
import com.didi.beatles.p099im.views.dialog.IMAlertDialogFragment;
import com.didi.beatles.p099im.views.dialog.IMDialog;
import com.didi.beatles.p099im.views.dialog.IMProgressDialogFragment;

/* renamed from: com.didi.beatles.im.views.IMDialogFactory */
public class IMDialogFactory {
    private IMDialogFactory() {
    }

    public static IMDialog getConfirmDialog(Activity activity, String str, String str2, String str3, IMDialog.Callback callback) {
        return m6672a(activity, (Drawable) null, -1, (IMAlertController.IconType) null, (String) null, str, str2, str3, callback);
    }

    public static IMDialog getConfirmDialog(Activity activity, String str, String str2, String str3, String str4, IMDialog.Callback callback) {
        return m6672a(activity, (Drawable) null, -1, (IMAlertController.IconType) null, str, str2, str3, str4, callback);
    }

    public static IMDialog getConfirmDialog(Activity activity, Drawable drawable, String str, String str2, String str3, IMDialog.Callback callback) {
        return m6672a(activity, drawable, -1, (IMAlertController.IconType) null, (String) null, str, str2, str3, callback);
    }

    public static IMDialog getConfirmDialog(Activity activity, int i, String str, String str2, String str3, IMDialog.Callback callback) {
        return m6672a(activity, (Drawable) null, i, (IMAlertController.IconType) null, (String) null, str, str2, str3, callback);
    }

    public static IMDialog getConfirmDialog(Activity activity, IMAlertController.IconType iconType, String str, String str2, String str3, IMDialog.Callback callback) {
        return m6672a(activity, (Drawable) null, -1, iconType, (String) null, str, str2, str3, callback);
    }

    public static IMDialog getOkDialog(Activity activity, String str, String str2, IMDialog.Callback callback) {
        return m6672a(activity, (Drawable) null, -1, (IMAlertController.IconType) null, (String) null, str, str2, (String) null, callback);
    }

    public static IMDialog getOkDialog(Activity activity, int i, String str, String str2, IMDialog.Callback callback) {
        return m6672a(activity, (Drawable) null, i, (IMAlertController.IconType) null, (String) null, str, str2, (String) null, callback);
    }

    public static IMDialog getOkDialog(Activity activity, String str, String str2, String str3, IMDialog.Callback callback) {
        return m6672a(activity, (Drawable) null, -1, (IMAlertController.IconType) null, str, str2, str3, (String) null, callback);
    }

    /* renamed from: a */
    private static IMDialog m6672a(Activity activity, Drawable drawable, int i, IMAlertController.IconType iconType, String str, String str2, String str3, String str4, final IMDialog.Callback callback) {
        final IMDialog iMDialog = new IMDialog(activity);
        IMAlertDialogFragment.Builder builder = new IMAlertDialogFragment.Builder(activity);
        if (drawable != null) {
            builder.setIcon(drawable);
        }
        if (i != -1) {
            builder.setIcon(i);
        }
        if (iconType != null) {
            builder.setIcon(iconType);
        }
        if (!TextUtils.isEmpty(str)) {
            builder.setTitle(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            builder.setMessage(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            builder.setPositiveButton((CharSequence) str3, (IMAlertDialogFragment.OnClickListener) new IMAlertDialogFragment.OnClickListener() {
                public void onClick(IMAlertDialogFragment iMAlertDialogFragment, View view) {
                    iMDialog.dismiss();
                    IMDialog.Callback callback = callback;
                    if (callback != null) {
                        callback.onSubmit();
                    }
                }
            });
        }
        if (!TextUtils.isEmpty(str4)) {
            builder.setNegativeButton((CharSequence) str4, (IMAlertDialogFragment.OnClickListener) new IMAlertDialogFragment.OnClickListener() {
                public void onClick(IMAlertDialogFragment iMAlertDialogFragment, View view) {
                    iMDialog.dismiss();
                    IMDialog.Callback callback = callback;
                    if (callback != null) {
                        callback.onCancel();
                    }
                }
            });
        }
        iMDialog.setDialog(builder.create());
        return iMDialog;
    }

    public static IMDialog getLoadingDialog(Activity activity, int i, boolean z) {
        return getLoadingDialog(activity, activity.getString(i), z);
    }

    public static IMDialog getLoadingDialog(Activity activity, String str, boolean z) {
        IMProgressDialogFragment iMProgressDialogFragment = new IMProgressDialogFragment();
        iMProgressDialogFragment.setContent(str, z);
        IMDialog iMDialog = new IMDialog(activity);
        iMDialog.setDialog(iMProgressDialogFragment);
        iMDialog.setCancelable(z);
        return iMDialog;
    }
}
