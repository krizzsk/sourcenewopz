package com.didi.soda.customer.widget.dialog;

import android.content.Context;
import com.didi.app.nova.skeleton.INavigator;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.skeleton.dialog.DialogInstrument;
import com.didi.soda.customer.foundation.rpc.entity.OrderStatusFlowEntity;
import com.didi.soda.order.component.evaluate.EvaluateCallback;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rui.widget.popup.type.menu.list.PopupMenuList;

public final class SodaWindowFactory {

    /* renamed from: a */
    private static Dialog f41788a;

    /* renamed from: b */
    private static Map<String, CommonLoadingDialog> f41789b;

    /* renamed from: c */
    private static Dialog f41790c;

    public interface DialogKeyBackListener {
        boolean handleBack();
    }

    private SodaWindowFactory() {
    }

    public static void showLoadingDialog(INavigator iNavigator, boolean z, boolean z2, DialogKeyBackListener dialogKeyBackListener) {
        hideLoadingDialog();
        if (f41788a == null) {
            CommonLoadingDialog loadingDialog = CommonLoadingDialog.getLoadingDialog(true, z, z2, dialogKeyBackListener);
            f41788a = loadingDialog;
            iNavigator.showDialog(loadingDialog, "CommonLoadingDialog");
        }
    }

    public static void showSpecifiedLoadingDialog(INavigator iNavigator, boolean z, String str) {
        if (f41789b == null) {
            f41789b = new HashMap();
        }
        hideSpecifiedLoadingDialog(str);
        if (f41789b.get(str) == null) {
            CommonLoadingDialog loadingDialog = CommonLoadingDialog.getLoadingDialog(true, z);
            iNavigator.showDialog(loadingDialog, str);
            f41789b.put(str, loadingDialog);
        }
    }

    public static void hideLoadingDialog() {
        Dialog dialog = f41788a;
        if (dialog != null && !dialog.isDestroyed()) {
            f41788a.dismiss();
        }
        f41788a = null;
    }

    public static void hideSpecifiedLoadingDialog(String str) {
        Map<String, CommonLoadingDialog> map = f41789b;
        if (map != null && map.size() != 0) {
            CommonLoadingDialog commonLoadingDialog = f41789b.get(str);
            if (commonLoadingDialog != null && !commonLoadingDialog.isDestroyed()) {
                commonLoadingDialog.dismiss();
            }
            f41789b.remove(str);
        }
    }

    public static void showBlockDialog(INavigator iNavigator) {
        hideBlockDialog();
        if (f41790c == null) {
            CommonBlockDialog blockDialog = CommonBlockDialog.getBlockDialog();
            f41790c = blockDialog;
            iNavigator.showDialog(blockDialog, "CommonLoadingDialog");
        }
    }

    public static void hideBlockDialog() {
        Dialog dialog = f41790c;
        if (dialog != null && !dialog.isDestroyed()) {
            f41790c.dismiss();
        }
        f41790c = null;
    }

    public static boolean isLoadingDialogShowing() {
        Dialog dialog = f41788a;
        return dialog != null && !dialog.isDestroyed();
    }

    public static void clearLoadingDialog() {
        hideLoadingDialog();
        Map<String, CommonLoadingDialog> map = f41789b;
        if (map != null && map.size() != 0) {
            for (CommonLoadingDialog next : f41789b.values()) {
                if (next != null && !next.isDestroyed()) {
                    next.dismiss();
                }
            }
            f41789b.clear();
        }
    }

    public static CustomerCommonDialog buildDialog(Context context, DialogBuilder dialogBuilder) {
        CustomerCommonDialog customerCommonDialog = new CustomerCommonDialog(context, dialogBuilder.build());
        customerCommonDialog.setCancelable(dialogBuilder.getCancelable());
        return customerCommonDialog;
    }

    public static CustomerPolicyDialog buildPolicyDialog(Context context, DialogBuilder dialogBuilder) {
        CustomerPolicyDialog customerPolicyDialog = new CustomerPolicyDialog(context, dialogBuilder.build());
        customerPolicyDialog.setCancelable(dialogBuilder.getCancelable());
        return customerPolicyDialog;
    }

    public static CustomerRateDialog buildRateDialog(Context context, DialogBuilder dialogBuilder) {
        CustomerRateDialog customerRateDialog = new CustomerRateDialog(context, dialogBuilder.build());
        customerRateDialog.setCancelable(dialogBuilder.getCancelable());
        return customerRateDialog;
    }

    public static CustomerOrderStatusDialog buildOrderStatusDialog(Context context, List<OrderStatusFlowEntity> list) {
        return new CustomerOrderStatusDialog(context, list);
    }

    public static CustomerEvaluateFeedbackDialog buildEvaluateFeedbackDialog(Context context, EvaluateCallback evaluateCallback) {
        return new CustomerEvaluateFeedbackDialog(context, evaluateCallback);
    }

    public static CustomerPopup buildPopup(Context context, PopupMenuList popupMenuList) {
        return new CustomerPopup(context, popupMenuList);
    }

    public static void showDialog(INavigator iNavigator, Dialog dialog) {
        iNavigator.showDialog(dialog, "");
    }

    public static void showDialog(DialogInstrument dialogInstrument, Dialog dialog) {
        dialog.show(dialogInstrument, "");
    }

    public static void showDialog(DialogInstrument dialogInstrument, Dialog dialog, String str) {
        dialog.show(dialogInstrument, str);
    }

    public static CustomerBottomDialog buildBottomDialog(Context context, DialogBuilder dialogBuilder) {
        return new CustomerBottomDialog(context, dialogBuilder.build());
    }
}
