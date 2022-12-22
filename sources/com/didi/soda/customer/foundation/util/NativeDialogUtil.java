package com.didi.soda.customer.foundation.util;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatDialog;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.sdk.apm.SystemUtils;
import com.didi.soda.customer.widget.dialog.CustomerCommonDialog;
import com.didi.soda.customer.widget.dialog.DialogBuilder;
import com.taxis99.R;

public class NativeDialogUtil {
    NativeDialogUtil() {
    }

    public static void showCustomerDialog(Context context, DialogBuilder dialogBuilder, String str, View.OnClickListener onClickListener) {
        showCustomerDialog(context, dialogBuilder, onClickListener != null ? context.getString(R.string.customer_dialog_cancel) : null, true, (View.OnClickListener) null, str, true, onClickListener);
    }

    public static void showCustomerDialog(Context context, DialogBuilder dialogBuilder, String str, boolean z, View.OnClickListener onClickListener, String str2, boolean z2, View.OnClickListener onClickListener2) {
        AppCompatDialog appCompatDialog = new AppCompatDialog(context);
        if (!TextUtils.isEmpty(str)) {
            dialogBuilder.addSubAction1(new CustomerCommonDialog.DialogAction(str, new View.OnClickListener(z, appCompatDialog) {
                public final /* synthetic */ boolean f$1;
                public final /* synthetic */ AppCompatDialog f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    NativeDialogUtil.m29218b(View.OnClickListener.this, this.f$1, this.f$2, view);
                }
            }));
        }
        if (!TextUtils.isEmpty(str2)) {
            dialogBuilder.addMainAction(new CustomerCommonDialog.DialogAction(str2, new View.OnClickListener(z2, appCompatDialog) {
                public final /* synthetic */ boolean f$1;
                public final /* synthetic */ AppCompatDialog f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void onClick(View view) {
                    NativeDialogUtil.m29216a(View.OnClickListener.this, this.f$1, this.f$2, view);
                }
            }));
        }
        CustomerCommonDialog customerCommonDialog = new CustomerCommonDialog(context, dialogBuilder.build());
        View initRootView = customerCommonDialog.initRootView(LayoutInflater.from(context));
        appCompatDialog.supportRequestWindowFeature(1);
        appCompatDialog.addContentView(initRootView, new FrameLayout.LayoutParams(-1, -1));
        appCompatDialog.setCancelable(dialogBuilder.getCancelable());
        appCompatDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            public final void onShow(DialogInterface dialogInterface) {
                CustomerCommonDialog.this.onShow();
            }
        });
        appCompatDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                NativeDialogUtil.m29217a(CustomerCommonDialog.this, dialogInterface);
            }
        });
        setDialogWidth(context, appCompatDialog);
        SystemUtils.showDialog(appCompatDialog);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m29218b(View.OnClickListener onClickListener, boolean z, AppCompatDialog appCompatDialog, View view) {
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        if (z) {
            appCompatDialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m29216a(View.OnClickListener onClickListener, boolean z, AppCompatDialog appCompatDialog, View view) {
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        if (z) {
            appCompatDialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m29217a(CustomerCommonDialog customerCommonDialog, DialogInterface dialogInterface) {
        customerCommonDialog.onDismiss();
        customerCommonDialog.onDestroy();
    }

    public static void setDialogWidth(Context context, Dialog dialog) {
        Window window = dialog.getWindow();
        window.getDecorView().setBackgroundColor(0);
        window.getDecorView().setPadding(0, 0, 0, 0);
        window.setFlags(1024, 1024);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = DisplayUtils.getScreenWidth(context) - DisplayUtils.dip2px(context, 100.0f);
        attributes.height = -2;
        attributes.gravity = 16;
        dialog.getWindow().setAttributes(attributes);
    }
}
