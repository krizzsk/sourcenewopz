package com.didi.component.common.dialog;

import com.didi.component.common.dialog.BlockDialog;
import com.didi.component.common.dialog.GuideViewDialog;
import com.didi.component.common.dialog.IDialog;
import com.didi.component.common.dialog.ImageHintDialog;
import com.didi.component.common.dialog.LoadingDialog;
import com.didi.component.common.dialog.NormalDialog;
import com.didi.component.common.dialog.ToastDialog;
import com.didi.component.core.IGroupView;
import com.didi.component.core.dialog.DialogInfo;
import com.didi.sdk.app.BusinessContext;

public class CommonDialogHandler extends DialogHandler {

    /* renamed from: a */
    private BusinessContext f11529a;

    /* access modifiers changed from: protected */
    public IDialog createCustomDialog(DialogInfo dialogInfo) {
        return null;
    }

    public CommonDialogHandler(BusinessContext businessContext, IGroupView iGroupView) {
        super(iGroupView);
        this.f11529a = businessContext;
    }

    /* access modifiers changed from: protected */
    public final IDialog createDialog(DialogInfo dialogInfo) {
        if (dialogInfo instanceof NormalDialogInfo) {
            return m7813a((NormalDialogInfo) dialogInfo);
        }
        if (dialogInfo instanceof LoadingDialogInfo) {
            return m7812a((LoadingDialogInfo) dialogInfo);
        }
        if (dialogInfo instanceof ToastDialogInfo) {
            return m7814a((ToastDialogInfo) dialogInfo);
        }
        if (dialogInfo instanceof ImageHintDialogInfo) {
            return m7811a((ImageHintDialogInfo) dialogInfo);
        }
        if (dialogInfo instanceof GuideViewDialogInfo) {
            return m7810a((GuideViewDialogInfo) dialogInfo);
        }
        if (dialogInfo instanceof BlockDialogInfo) {
            return m7809a((BlockDialogInfo) dialogInfo);
        }
        return createCustomDialog(dialogInfo);
    }

    /* renamed from: a */
    private IDialog m7809a(final BlockDialogInfo blockDialogInfo) {
        BlockDialog.DialogBuilder dialogBuilder = new BlockDialog.DialogBuilder(this.f11529a);
        dialogBuilder.setDialogInfo(blockDialogInfo);
        dialogBuilder.setListener(new IDialog.DialogListener() {
            public void onAction(int i) {
                CommonDialogHandler.this.mGroupView.onDialogClicked(blockDialogInfo.dialogId, i);
            }
        });
        return dialogBuilder.build();
    }

    /* renamed from: a */
    private IDialog m7811a(final ImageHintDialogInfo imageHintDialogInfo) {
        ImageHintDialog.DialogBuilder dialogBuilder = new ImageHintDialog.DialogBuilder(this.f11529a);
        dialogBuilder.setDialogInfo(imageHintDialogInfo);
        dialogBuilder.setListener(new IDialog.DialogListener() {
            public void onAction(int i) {
                CommonDialogHandler.this.mGroupView.onDialogClicked(imageHintDialogInfo.dialogId, i);
            }
        });
        return dialogBuilder.build();
    }

    /* renamed from: a */
    private IDialog m7813a(final NormalDialogInfo normalDialogInfo) {
        NormalDialog.DialogBuilder dialogBuilder = new NormalDialog.DialogBuilder(this.f11529a);
        dialogBuilder.setListener(new IDialog.DialogListener() {
            public void onAction(int i) {
                CommonDialogHandler.this.mShowDialog = null;
                CommonDialogHandler.this.mGroupView.onDialogClicked(normalDialogInfo.dialogId, i);
            }
        });
        dialogBuilder.setDialogInfo(normalDialogInfo);
        return dialogBuilder.build();
    }

    /* renamed from: a */
    private IDialog m7814a(ToastDialogInfo toastDialogInfo) {
        ToastDialog.DialogBuilder dialogBuilder = new ToastDialog.DialogBuilder(this.f11529a);
        dialogBuilder.setDialogInfo(toastDialogInfo);
        dialogBuilder.setListener(new IDialog.DialogListener() {
            public void onAction(int i) {
                CommonDialogHandler.this.mShowDialog = null;
            }
        });
        return dialogBuilder.build();
    }

    /* renamed from: a */
    private IDialog m7812a(final LoadingDialogInfo loadingDialogInfo) {
        LoadingDialog.DialogBuilder dialogBuilder = new LoadingDialog.DialogBuilder(this.f11529a);
        dialogBuilder.setListener(new IDialog.DialogListener() {
            public void onAction(int i) {
                CommonDialogHandler.this.mShowDialog = null;
                CommonDialogHandler.this.mGroupView.onDialogClicked(loadingDialogInfo.dialogId, i);
            }
        });
        dialogBuilder.setDialogInfo(loadingDialogInfo);
        return dialogBuilder.build();
    }

    /* renamed from: a */
    private IDialog m7810a(final GuideViewDialogInfo guideViewDialogInfo) {
        GuideViewDialog.DialogBuilder dialogBuilder = new GuideViewDialog.DialogBuilder(this.f11529a);
        dialogBuilder.setListener(new IDialog.DialogListener() {
            public void onAction(int i) {
                CommonDialogHandler.this.mShowDialog = null;
                CommonDialogHandler.this.mGroupView.onDialogClicked(guideViewDialogInfo.dialogId, i);
            }
        });
        dialogBuilder.setDialogInfo(guideViewDialogInfo);
        return dialogBuilder.build();
    }
}
