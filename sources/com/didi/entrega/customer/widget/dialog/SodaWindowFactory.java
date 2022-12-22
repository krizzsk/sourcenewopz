package com.didi.entrega.customer.widget.dialog;

import android.content.Context;
import com.didi.app.nova.skeleton.INavigator;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.skeleton.dialog.DialogInstrument;
import java.util.HashMap;
import java.util.Map;
import rui.widget.popup.type.menu.list.PopupMenuList;

public final class SodaWindowFactory {

    /* renamed from: a */
    private static Dialog f20449a;

    /* renamed from: b */
    private static Map<String, CommonLoadingDialog> f20450b;

    /* renamed from: c */
    private static Dialog f20451c;

    public interface DialogKeyBackListener {
        boolean handleBack();
    }

    private SodaWindowFactory() {
    }

    public static void showLoadingDialog(INavigator iNavigator, boolean z, boolean z2, DialogKeyBackListener dialogKeyBackListener) {
        hideLoadingDialog();
        if (f20449a == null) {
            CommonLoadingDialog loadingDialog = CommonLoadingDialog.getLoadingDialog(true, z, z2, dialogKeyBackListener);
            f20449a = loadingDialog;
            iNavigator.showDialog(loadingDialog, "CommonLoadingDialog");
        }
    }

    public static void showSpecifiedLoadingDialog(INavigator iNavigator, boolean z, String str) {
        if (f20450b == null) {
            f20450b = new HashMap();
        }
        hideSpecifiedLoadingDialog(str);
        if (f20450b.get(str) == null) {
            CommonLoadingDialog loadingDialog = CommonLoadingDialog.getLoadingDialog(true, z);
            iNavigator.showDialog(loadingDialog, str);
            f20450b.put(str, loadingDialog);
        }
    }

    public static void hideLoadingDialog() {
        Dialog dialog = f20449a;
        if (dialog != null && !dialog.isDestroyed()) {
            f20449a.dismiss();
        }
        f20449a = null;
    }

    public static void hideSpecifiedLoadingDialog(String str) {
        Map<String, CommonLoadingDialog> map = f20450b;
        if (map != null && map.size() != 0) {
            CommonLoadingDialog commonLoadingDialog = f20450b.get(str);
            if (commonLoadingDialog != null && !commonLoadingDialog.isDestroyed()) {
                commonLoadingDialog.dismiss();
            }
            f20450b.remove(str);
        }
    }

    public static void showBlockDialog(INavigator iNavigator) {
        hideBlockDialog();
        if (f20451c == null) {
            CommonBlockDialog blockDialog = CommonBlockDialog.getBlockDialog();
            f20451c = blockDialog;
            iNavigator.showDialog(blockDialog, "CommonLoadingDialog");
        }
    }

    public static void hideBlockDialog() {
        Dialog dialog = f20451c;
        if (dialog != null && !dialog.isDestroyed()) {
            f20451c.dismiss();
        }
        f20451c = null;
    }

    public static boolean isLoadingDialogShowing() {
        Dialog dialog = f20449a;
        return dialog != null && !dialog.isDestroyed();
    }

    public static void clearLoadingDialog() {
        hideLoadingDialog();
        Map<String, CommonLoadingDialog> map = f20450b;
        if (map != null && map.size() != 0) {
            for (CommonLoadingDialog next : f20450b.values()) {
                if (next != null && !next.isDestroyed()) {
                    next.dismiss();
                }
            }
            f20450b.clear();
        }
    }

    public static CustomerCommonDialog buildDialog(Context context, DialogBuilder dialogBuilder) {
        CustomerCommonDialog customerCommonDialog = new CustomerCommonDialog(context, dialogBuilder.build());
        customerCommonDialog.setCancelable(dialogBuilder.getCancelable());
        return customerCommonDialog;
    }

    public static CustomerPopup buildPopup(Context context, PopupMenuList popupMenuList) {
        return new CustomerPopup(context, popupMenuList);
    }

    public static void showDialog(INavigator iNavigator, Dialog dialog) {
        try {
            iNavigator.showDialog(dialog, "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void showDialog(DialogInstrument dialogInstrument, Dialog dialog) {
        dialog.show(dialogInstrument, "");
    }

    public static void showDialog(DialogInstrument dialogInstrument, Dialog dialog, String str) {
        dialog.show(dialogInstrument, str);
    }
}
