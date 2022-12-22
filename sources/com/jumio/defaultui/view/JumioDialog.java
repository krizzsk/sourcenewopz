package com.jumio.defaultui.view;

import android.content.Context;
import android.content.DialogInterface;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.jumio.commons.log.Log;
import com.jumio.defaultui.view.JumioDialog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0011B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010JR\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n¨\u0006\u0012"}, mo175978d2 = {"Lcom/jumio/defaultui/view/JumioDialog;", "", "Landroid/content/Context;", "context", "", "titleId", "messageId", "", "title", "message", "Lcom/jumio/defaultui/view/JumioDialog$DialogAction;", "positiveAction", "negativeAction", "Landroidx/appcompat/app/AlertDialog;", "create", "<init>", "()V", "DialogAction", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* compiled from: JumioDialog.kt */
public final class JumioDialog {
    public static final JumioDialog INSTANCE = new JumioDialog();

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&R\u0016\u0010\u0007\u001a\u00020\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, mo175978d2 = {"Lcom/jumio/defaultui/view/JumioDialog$DialogAction;", "", "", "onAction", "", "getCaption", "()I", "caption", "jumio-defaultui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
    /* compiled from: JumioDialog.kt */
    public interface DialogAction {
        int getCaption();

        void onAction();
    }

    private JumioDialog() {
    }

    public static /* synthetic */ AlertDialog create$default(JumioDialog jumioDialog, Context context, int i, int i2, String str, String str2, DialogAction dialogAction, DialogAction dialogAction2, int i3, Object obj) {
        int i4 = 0;
        int i5 = (i3 & 2) != 0 ? 0 : i;
        if ((i3 & 4) == 0) {
            i4 = i2;
        }
        DialogAction dialogAction3 = null;
        String str3 = (i3 & 8) != 0 ? null : str;
        String str4 = (i3 & 16) != 0 ? null : str2;
        DialogAction dialogAction4 = (i3 & 32) != 0 ? null : dialogAction;
        if ((i3 & 64) == 0) {
            dialogAction3 = dialogAction2;
        }
        return jumioDialog.create(context, i5, i4, str3, str4, dialogAction4, dialogAction3);
    }

    /* access modifiers changed from: private */
    /* renamed from: create$lambda-0  reason: not valid java name */
    public static final void m47570create$lambda0(DialogAction dialogAction, DialogInterface dialogInterface, int i) {
        dialogAction.onAction();
    }

    /* access modifiers changed from: private */
    /* renamed from: create$lambda-1  reason: not valid java name */
    public static final void m47571create$lambda1(DialogAction dialogAction, DialogInterface dialogInterface, int i) {
        dialogAction.onAction();
    }

    public final AlertDialog create(Context context, int i, int i2, String str, String str2, DialogAction dialogAction, DialogAction dialogAction2) {
        Intrinsics.checkNotNullParameter(context, "context");
        MaterialAlertDialogBuilder materialAlertDialogBuilder = new MaterialAlertDialogBuilder(context);
        if (i != 0) {
            materialAlertDialogBuilder.setTitle(i);
        } else if (str != null) {
            materialAlertDialogBuilder.setTitle((CharSequence) str);
        }
        if (i2 != 0) {
            materialAlertDialogBuilder.setMessage(i2);
        } else if (str2 != null) {
            materialAlertDialogBuilder.setMessage((CharSequence) str2);
        }
        materialAlertDialogBuilder.setCancelable(false);
        if (dialogAction != null) {
            materialAlertDialogBuilder.setPositiveButton(dialogAction.getCaption(), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    JumioDialog.m47570create$lambda0(JumioDialog.DialogAction.this, dialogInterface, i);
                }
            });
        }
        if (dialogAction2 != null) {
            materialAlertDialogBuilder.setNegativeButton(dialogAction2.getCaption(), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                    JumioDialog.m47571create$lambda1(JumioDialog.DialogAction.this, dialogInterface, i);
                }
            });
        }
        AlertDialog show = materialAlertDialogBuilder.show();
        try {
            TextView textView = (TextView) show.findViewById(16908299);
            if (textView != null) {
                textView.setLinkTextColor(textView.getTextColors());
                textView.setMovementMethod(LinkMovementMethod.getInstance());
            }
        } catch (Exception e) {
            Log.printStackTrace(e);
        }
        Intrinsics.checkNotNullExpressionValue(show, "alertDialog");
        return show;
    }
}
