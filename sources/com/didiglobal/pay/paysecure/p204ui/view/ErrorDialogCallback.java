package com.didiglobal.pay.paysecure.p204ui.view;

import android.app.Dialog;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\b"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/ui/view/ErrorDialogCallback;", "", "onCloseDialog", "", "dialog", "Landroid/app/Dialog;", "onNegativeClicked", "onPositiveClicked", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.ui.view.ErrorDialogCallback */
/* compiled from: ErrorDialogCallback.kt */
public interface ErrorDialogCallback {
    void onCloseDialog(Dialog dialog);

    void onNegativeClicked(Dialog dialog);

    void onPositiveClicked(Dialog dialog);
}
