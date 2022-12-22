package com.didi.soda.bill.dialog;

import android.content.Context;
import android.view.View;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.soda.bill.dialog.entity.CommonConfirmationDialogEntity;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.widget.dialog.CustomerCommonDialog;
import com.didi.soda.customer.widget.dialog.DialogBuilder;
import com.didi.soda.customer.widget.dialog.SodaWindowFactory;

public class SeriesDialogHelper {
    public static void showSeriesDialog(CommonConfirmationDialogEntity commonConfirmationDialogEntity, ScopeContext scopeContext, Context context, View.OnClickListener onClickListener) {
        if (commonConfirmationDialogEntity != null && commonConfirmationDialogEntity.hasConfirmDialog() && scopeContext.getLiveHandler().isActive()) {
            CustomerCommonDialog buildDialog = SodaWindowFactory.buildDialog(context, new DialogBuilder().setTitle(commonConfirmationDialogEntity.getConfirm().title).setContent(commonConfirmationDialogEntity.getConfirm().msg).setCancelable(false).addSubAction2(new CustomerCommonDialog.DialogAction(commonConfirmationDialogEntity.getConfirm().cancelBtnDesc, $$Lambda$SeriesDialogHelper$RCK6WrLHORT0EaWwfKqeIevOjW4.INSTANCE)).addMainAction(new CustomerCommonDialog.DialogAction(commonConfirmationDialogEntity.getConfirm().okBtnDesc, new View.OnClickListener() {
                public final void onClick(View view) {
                    SeriesDialogHelper.m27693a(View.OnClickListener.this, view);
                }
            })));
            m27692a(EventConst.Cart.EVENT_JUVENILES_POPUP_SW).build().track();
            SodaWindowFactory.showDialog(scopeContext.getNavigator(), (Dialog) buildDialog);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m27693a(View.OnClickListener onClickListener, View view) {
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        m27692a(EventConst.Cart.EVENT_JUVENILES_POPUP_CK).addEventParam("click_type", 1).build().track();
    }

    /* renamed from: a */
    private static OmegaTracker.Builder m27692a(String str) {
        return OmegaTracker.Builder.create(str);
    }
}
