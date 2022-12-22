package com.didiglobal.pay.paysecure.prepaidcard;

import com.didi.component.comp_xpanel.XPanelScene;
import com.didiglobal.pay.paysecure.p204ui.view.CommonBottomDialog;
import com.didiglobal.pay.paysecure.p204ui.view.ConfirmDialogCallback;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, mo175978d2 = {"com/didiglobal/pay/paysecure/prepaidcard/CardPwdManagerActivity$onBackPressed$1", "Lcom/didiglobal/pay/paysecure/ui/view/ConfirmDialogCallback;", "onCancelClicked", "", "dialog", "Lcom/didiglobal/pay/paysecure/ui/view/CommonBottomDialog;", "onConfirmClicked", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: CardPwdManagerActivity.kt */
public final class CardPwdManagerActivity$onBackPressed$1 implements ConfirmDialogCallback {
    final /* synthetic */ CardPwdManagerActivity this$0;

    CardPwdManagerActivity$onBackPressed$1(CardPwdManagerActivity cardPwdManagerActivity) {
        this.this$0 = cardPwdManagerActivity;
    }

    public void onConfirmClicked(CommonBottomDialog commonBottomDialog) {
        if (commonBottomDialog != null) {
            commonBottomDialog.dismiss();
        }
        TrackerManager.Companion.trackStopActiveClick(XPanelScene.SCENE_CONFIRM);
    }

    public void onCancelClicked(CommonBottomDialog commonBottomDialog) {
        IActiveCardListener activeListener = CardPwdManager.INSTANCE.getActiveListener();
        if (activeListener != null) {
            activeListener.onResult(-1);
        }
        if (commonBottomDialog != null) {
            commonBottomDialog.dismiss();
        }
        this.this$0.finish();
        TrackerManager.Companion.trackStopActiveClick("cancel");
    }
}
