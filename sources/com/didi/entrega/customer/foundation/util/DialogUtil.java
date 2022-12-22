package com.didi.entrega.customer.foundation.util;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.didi.app.nova.skeleton.INavigator;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.skeleton.dialog.DialogFrameLayout;
import com.didi.app.nova.skeleton.dialog.DialogInstrument;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.widget.dialog.CustomerNumProtectDialog;
import com.didi.entrega.customer.widget.dialog.SodaWindowFactory;
import com.didi.rfusion.widget.dialog.RFCommonDialog;
import com.didi.rfusion.widget.dialog.RFDialogInterface;
import com.taxis99.R;

public final class DialogUtil {
    public static final String DIALOG_INSTRUMENT = "dialog_instrument";
    public static final String DIALOG_INSTRUMENT_FRAME = "dialog_instrument_frame";

    private DialogUtil() {
    }

    public static void showLoadingDialog(ScopeContext scopeContext, boolean z) {
        showLoadingDialog(scopeContext, z, true, (SodaWindowFactory.DialogKeyBackListener) null);
    }

    public static void showLoadingDialog(ScopeContext scopeContext, boolean z, boolean z2, SodaWindowFactory.DialogKeyBackListener dialogKeyBackListener) {
        if (scopeContext.getLiveHandler().isActive()) {
            SodaWindowFactory.showLoadingDialog(scopeContext.getNavigator(), z, z2, dialogKeyBackListener);
        }
    }

    public static void showSpecifiedLoadingDialog(ScopeContext scopeContext, boolean z, String str) {
        if (scopeContext.getLiveHandler().isActive()) {
            SodaWindowFactory.showSpecifiedLoadingDialog(scopeContext.getNavigator(), z, str);
        }
    }

    public static void showBlockDialog(ScopeContext scopeContext) {
        if (scopeContext.getLiveHandler().isActive()) {
            SodaWindowFactory.showBlockDialog(scopeContext.getNavigator());
        }
    }

    public static void hideLoadingDialog() {
        SodaWindowFactory.hideLoadingDialog();
    }

    public static void hideSpecifiedLoadingDialog(String str) {
        SodaWindowFactory.hideSpecifiedLoadingDialog(str);
    }

    public static void hideBlockDialog() {
        SodaWindowFactory.hideBlockDialog();
    }

    public static DialogInstrument getScopeDialogInstrument(ScopeContext scopeContext) {
        DialogInstrument dialogInstrument = (DialogInstrument) scopeContext.getObject("dialog_instrument");
        if (dialogInstrument != null) {
            return dialogInstrument;
        }
        throw new IllegalStateException("Add @SupportInnerDialog annotation in your page to add a dialog frame first!");
    }

    public static DialogFrameLayout getScopeDialogFrame(ScopeContext scopeContext) {
        DialogFrameLayout dialogFrameLayout = (DialogFrameLayout) scopeContext.getObject("dialog_instrument_frame");
        if (dialogFrameLayout != null) {
            return dialogFrameLayout;
        }
        throw new IllegalStateException("Add @SupportInnerDialog annotation in your page to add a dialog frame first!");
    }

    public static void showNotificationRemindDialog(INavigator iNavigator, RFDialogInterface.OnClickListener onClickListener, RFDialogInterface.OnClickListener onClickListener2) {
        SodaWindowFactory.showDialog(iNavigator, (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setMessage(ResourceHelper.getString(R.string.FoodC_presentation_Please_open_rzjh)).setMainAction(ResourceHelper.getString(R.string.FoodC_presentation_Go_on_AglT), onClickListener)).setSubAction1(ResourceHelper.getString(R.string.FoodC_presentation_Next_time_RqPV), onClickListener2)).create());
    }

    public static void showWarningDialog(String str, String str2, int i, int i2, ScopeContext scopeContext, RFDialogInterface.OnClickListener onClickListener, RFDialogInterface.OnClickListener onClickListener2) {
        if (scopeContext.getLiveHandler().isActive()) {
            SodaWindowFactory.showDialog(scopeContext.getNavigator(), (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setTitle(str)).setMessage(str2).setSubAction1(ResourceHelper.getString(i), onClickListener)).setMainAction(ResourceHelper.getString(i2), onClickListener2)).create());
        }
    }

    public static void showFacebookFailAlreadyVerifyDialog(INavigator iNavigator) {
        SodaWindowFactory.showDialog(iNavigator, (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setTitle(ResourceHelper.getString(R.string.FoodC_up_Verification_failed_bdPT))).setMessage(ResourceHelper.getString(R.string.customer_security_fail_content_3)).setMainAction(ResourceHelper.getString(R.string.FoodC_up_Confirmation_hKaf), (RFDialogInterface.OnClickListener) null)).create());
    }

    public static void showFacebookFailSelectOtherDialog(INavigator iNavigator) {
        SodaWindowFactory.showDialog(iNavigator, (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setTitle(ResourceHelper.getString(R.string.FoodC_up_Verification_failed_bdPT))).setMessage(ResourceHelper.getString(R.string.customer_security_fail_content_1)).setMainAction(ResourceHelper.getString(R.string.FoodC_up_Confirmation_hKaf), (RFDialogInterface.OnClickListener) null)).create());
    }

    public static void showFacebookFailNotSelectDialog(INavigator iNavigator) {
        SodaWindowFactory.showDialog(iNavigator, (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setTitle(ResourceHelper.getString(R.string.FoodC_up_Verification_failed_bdPT))).setMessage(ResourceHelper.getString(R.string.customer_security_fail_content_2)).setMainAction(ResourceHelper.getString(R.string.FoodC_up_Confirmation_hKaf), (RFDialogInterface.OnClickListener) null)).create());
    }

    public static void showPayFailDialog(ScopeContext scopeContext, String str, int i, RFDialogInterface.OnClickListener onClickListener) {
        if (scopeContext.getLiveHandler().isActive()) {
            if (i == 2) {
                str = GlobalContext.getContext().getResources().getString(R.string.customer_target_app_uninstall);
            } else if (TextUtils.isEmpty(str)) {
                str = GlobalContext.getContext().getResources().getString(R.string.FoodC_remind_Unable_to_Wjlz);
            }
            SodaWindowFactory.showDialog(scopeContext.getNavigator(), (Dialog) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setMessage(str).setMainAction(ResourceHelper.getString(R.string.FoodC_up_Confirmation_hKaf), onClickListener)).create());
        }
    }

    public static void showOuterPayFailDialog(ScopeContext scopeContext, String str, RFDialogInterface.OnClickListener onClickListener) {
        if (scopeContext.getLiveHandler().isActive()) {
            if (TextUtils.isEmpty(str)) {
                str = GlobalContext.getContext().getResources().getString(R.string.FoodC_up_Current_payment_VpSn);
            }
            SodaWindowFactory.showDialog(scopeContext.getNavigator(), (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setTitle(ResourceHelper.getString(R.string.FoodC_up_Payment_failed_DODd))).setMessage(str).setMainAction(ResourceHelper.getString(R.string.FoodC_demand_Determination_wKQX), onClickListener)).create());
        }
    }

    public static void showErrorDialog(String str, int i, ScopeContext scopeContext, RFDialogInterface.OnClickListener onClickListener) {
        if (scopeContext.getLiveHandler().isActive()) {
            SodaWindowFactory.showDialog(scopeContext.getNavigator(), (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setMessage(str).setMainAction(ResourceHelper.getString(i), onClickListener)).create());
        }
    }

    public static void showErrorDialog(String str, int i, int i2, ScopeContext scopeContext, RFDialogInterface.OnClickListener onClickListener) {
        if (scopeContext.getLiveHandler().isActive()) {
            SodaWindowFactory.showDialog(scopeContext.getNavigator(), (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setMessage(str).setMainAction(ResourceHelper.getString(i), onClickListener)).setSubAction1(ResourceHelper.getString(i2), (RFDialogInterface.OnClickListener) null)).create());
        }
    }

    public static void showErrorDialog(String str, ScopeContext scopeContext, RFDialogInterface.OnClickListener onClickListener) {
        if (scopeContext.getLiveHandler().isActive()) {
            SodaWindowFactory.showDialog(scopeContext.getNavigator(), (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setMessage(str).setMainAction(ResourceHelper.getString(R.string.FoodC_demand_Determination_wKQX), onClickListener)).create());
        }
    }

    public static void showErrorDialog(String str, ScopeContext scopeContext) {
        if (scopeContext.getLiveHandler().isActive()) {
            SodaWindowFactory.showDialog(scopeContext.getNavigator(), (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setMessage(str).setMainAction(ResourceHelper.getString(R.string.FoodC_up_Confirmation_hKaf), (RFDialogInterface.OnClickListener) null)).create());
        }
    }

    public static void showVerifyErrorDialog(ScopeContext scopeContext, RFDialogInterface.OnClickListener onClickListener, RFDialogInterface.OnClickListener onClickListener2) {
        if (scopeContext.getLiveHandler().isActive()) {
            SodaWindowFactory.showDialog(scopeContext.getNavigator(), (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setTitle(ResourceHelper.getString(R.string.FoodC_up_Account_Security_llTu))).setMessage(ResourceHelper.getString(R.string.FoodC_up_To_guarantee_elMD)).setMainAction(ResourceHelper.getString(R.string.FoodC_up_Verify_immediately_ELtW), onClickListener)).setSubAction1(ResourceHelper.getString(R.string.cancel), onClickListener2)).create());
        }
    }

    public static void showDuplicateOrderDialog(ScopeContext scopeContext, RFDialogInterface.OnClickListener onClickListener, RFDialogInterface.OnClickListener onClickListener2) {
        if (scopeContext.getLiveHandler().isActive()) {
            SodaWindowFactory.showDialog(scopeContext.getNavigator(), (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setTitle(ResourceHelper.getString(R.string.FoodC_16version_Attention_gsaT))).setMessage(ResourceHelper.getString(R.string.FoodC_up_You_already_mcdV)).setMainAction(ResourceHelper.getString(R.string.FoodC_up_View_existing_uCux), onClickListener)).setSubAction1(ResourceHelper.getString(R.string.FoodC_up_Place_this_VbmN), onClickListener2)).setSubAction2(ResourceHelper.getString(R.string.FoodC_up_Cancel_anHR), (RFDialogInterface.OnClickListener) null)).setCancelable(false)).create());
        }
    }

    public static void showNotPayDialog(ScopeContext scopeContext, String str, RFDialogInterface.OnClickListener onClickListener, RFDialogInterface.OnClickListener onClickListener2) {
        if (scopeContext.getLiveHandler().isActive()) {
            SodaWindowFactory.showDialog(scopeContext.getNavigator(), (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setTitle(ResourceHelper.getString(R.string.FoodC_unpaid_Request_failed_jlJL))).setMessage(str).setCancelable(false)).setMainAction(ResourceHelper.getString(R.string.FoodC_demand_Determination_wKQX), onClickListener)).setSubAction2(ResourceHelper.getString(R.string.FoodC_up_Cancel_anHR), onClickListener2)).create());
        }
    }

    public static void showCheckLawDialog(DialogInstrument dialogInstrument, String str, int i, View view, RFDialogInterface.OnClickListener onClickListener, RFDialogInterface.OnClickListener onClickListener2) {
        SodaWindowFactory.showDialog(dialogInstrument, (RFCommonDialog) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setTitle(ResourceHelper.getString(i))).setView(view).setMainAction(ResourceHelper.getString(R.string.FoodC_home_Agree_ieSH), onClickListener)).setSubAction1(ResourceHelper.getString(R.string.FoodC_home_Refusal_SZzM), onClickListener2)).setCancelable(false)).setAutoDismiss(false)).create(), str);
    }

    public static void showDebtPayFailDialog(ScopeContext scopeContext, String str, RFDialogInterface.OnClickListener onClickListener) {
        if (scopeContext.getLiveHandler().isActive()) {
            SodaWindowFactory.showDialog(scopeContext.getNavigator(), (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setTitle(ResourceHelper.getString(R.string.FoodC_up_Payment_failed_DODd))).setMessage(str).setMainAction(ResourceHelper.getString(R.string.FoodC_demand_Determination_wKQX), onClickListener)).create());
        }
    }

    public static void showNumProtectDialog(CustomerNumProtectDialog customerNumProtectDialog, INavigator iNavigator) {
        SodaWindowFactory.showDialog(iNavigator, (Dialog) customerNumProtectDialog);
    }

    public static void showProtectNumDegradeDialog(Context context, INavigator iNavigator, String str, boolean z, RFDialogInterface.OnClickListener onClickListener) {
        RFCommonDialog.Builder message = new RFCommonDialog.Builder().setMessage(str);
        if (z) {
            message.setMainAction(context.getString(R.string.FoodC_up_Confirmation_hKaf), onClickListener);
        } else {
            ((RFCommonDialog.Builder) message.setSubAction1(context.getString(R.string.FoodC_up_Cancel_anHR), (RFDialogInterface.OnClickListener) null)).setMainAction(context.getString(R.string.FoodC_phonesafe_Call_ivWZ), onClickListener);
        }
        SodaWindowFactory.showDialog(iNavigator, (Dialog) message.create());
    }

    public static void showBusinessHourRemindDialog(String str, String str2, ScopeContext scopeContext, RFDialogInterface.OnClickListener onClickListener) {
        if (scopeContext.getLiveHandler().isActive()) {
            SodaWindowFactory.showDialog(scopeContext.getNavigator(), (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setMessage(str2).setTitle(str)).setMainAction(ResourceHelper.getString(R.string.FoodC_home1_Got_it_MgpJ), onClickListener)).create());
        }
    }
}
