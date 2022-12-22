package com.didi.soda.customer.foundation.util;

import android.content.Context;
import android.view.View;
import com.didi.app.nova.skeleton.INavigator;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.skeleton.dialog.DialogFrameLayout;
import com.didi.app.nova.skeleton.dialog.DialogInstrument;
import com.didi.rfusion.widget.dialog.RFCommonDialog;
import com.didi.rfusion.widget.dialog.RFDialogInterface;
import com.didi.soda.bill.dialog.entity.DialogContentEntity;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.foundation.rpc.entity.SendInfoEntity;
import com.didi.soda.customer.widget.dialog.CustomerCommonDialog;
import com.didi.soda.customer.widget.dialog.CustomerNumProtectDialog;
import com.didi.soda.customer.widget.dialog.CustomerPopup;
import com.didi.soda.customer.widget.dialog.CustomerRateDialog;
import com.didi.soda.customer.widget.dialog.DialogBuilder;
import com.didi.soda.customer.widget.dialog.SodaWindowFactory;
import com.didi.soda.order.component.evaluate.EvaluateCallback;
import com.taxis99.R;
import rui.widget.popup.type.menu.list.PopupMenuList;

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

    public static void showLoadingDialogForShopCateLanding(ScopeContext scopeContext, boolean z) {
        SodaWindowFactory.showLoadingDialog(scopeContext.getNavigator(), z, true, (SodaWindowFactory.DialogKeyBackListener) null);
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

    public static void showPhotoPopup(Context context, INavigator iNavigator, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        PopupMenuList popupMenuList = new PopupMenuList();
        popupMenuList.cancelText = context.getResources().getString(R.string.customer_dialog_cancel);
        popupMenuList.addButton(context.getResources().getString(R.string.customer_profile_edit_take_photo), onClickListener);
        popupMenuList.addButton(context.getResources().getString(R.string.customer_profile_edit_from_album), onClickListener2);
        CustomerPopup buildPopup = SodaWindowFactory.buildPopup(context, popupMenuList);
        buildPopup.setCancelable(true);
        SodaWindowFactory.showDialog(iNavigator, (Dialog) buildPopup);
    }

    public static void openConfirmClearCacheDialog(INavigator iNavigator, RFDialogInterface.OnClickListener onClickListener) {
        SodaWindowFactory.showDialog(iNavigator, (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setTitle(ResourceHelper.getString(R.string.setting_confirm_hint))).setMessage(ResourceHelper.getString(R.string.setting_confirm_clear_cache_description)).setSubAction1(ResourceHelper.getString(R.string.customer_dialog_cancel), (RFDialogInterface.OnClickListener) null)).setMainAction(ResourceHelper.getString(R.string.customer_dialog_confirm), onClickListener)).create());
    }

    public static void deleteSearchHistoryDialog(INavigator iNavigator, RFDialogInterface.OnClickListener onClickListener) {
        SodaWindowFactory.showDialog(iNavigator, (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setMessage(ResourceHelper.getString(R.string.customer_search_delete_history)).setSubAction1(ResourceHelper.getString(R.string.customer_dialog_cancel), (RFDialogInterface.OnClickListener) null)).setMainAction(ResourceHelper.getString(R.string.customer_dialog_confirm), onClickListener)).create());
    }

    public static void showWarningDialog(String str, int i, int i2, ScopeContext scopeContext, RFDialogInterface.OnClickListener onClickListener, RFDialogInterface.OnClickListener onClickListener2) {
        if (scopeContext.getLiveHandler().isActive()) {
            SodaWindowFactory.showDialog(scopeContext.getNavigator(), (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setMessage(str).setSubAction1(ResourceHelper.getString(i), onClickListener)).setMainAction(ResourceHelper.getString(i2), onClickListener2)).create());
        }
    }

    public static void showErrorDialog(String str, ScopeContext scopeContext, RFDialogInterface.OnClickListener onClickListener) {
        if (scopeContext.getLiveHandler().isActive()) {
            SodaWindowFactory.showDialog(scopeContext.getNavigator(), (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setMessage(str).setMainAction(ResourceHelper.getString(R.string.customer_dialog_confirm), onClickListener)).create());
        }
    }

    public static void showErrorDialog(String str, ScopeContext scopeContext) {
        if (scopeContext.getLiveHandler().isActive()) {
            SodaWindowFactory.showDialog(scopeContext.getNavigator(), (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setMessage(str).setMainAction(ResourceHelper.getString(R.string.customer_common_ok), (RFDialogInterface.OnClickListener) null)).create());
        }
    }

    public static void showErrorDialog(String str, int i, ScopeContext scopeContext, RFDialogInterface.OnClickListener onClickListener) {
        if (scopeContext.getLiveHandler().isActive()) {
            SodaWindowFactory.showDialog(scopeContext.getNavigator(), (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setMessage(str).setMainAction(ResourceHelper.getString(i), onClickListener)).create());
        }
    }

    public static void openConfirmLogOutDialog(INavigator iNavigator, RFDialogInterface.OnClickListener onClickListener, RFDialogInterface.OnClickListener onClickListener2) {
        SodaWindowFactory.showDialog(iNavigator, (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setTitle(ResourceHelper.getString(R.string.setting_confirm_hint))).setMessage(ResourceHelper.getString(R.string.setting_confirm_logout_description)).setSubAction1(ResourceHelper.getString(R.string.customer_dialog_cancel), onClickListener)).setMainAction(ResourceHelper.getString(R.string.customer_dialog_confirm), onClickListener2)).create());
    }

    public static void showPayFailDialog(ScopeContext scopeContext, String str, RFDialogInterface.OnClickListener onClickListener) {
        if (scopeContext.getLiveHandler().isActive()) {
            SodaWindowFactory.showDialog(scopeContext.getNavigator(), (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setMessage(str).setMainAction(ResourceHelper.getString(R.string.customer_common_ok), onClickListener)).create());
        }
    }

    public static void showOuterPayFailDialog(ScopeContext scopeContext, String str, RFDialogInterface.OnClickListener onClickListener) {
        if (scopeContext.getLiveHandler().isActive()) {
            SodaWindowFactory.showDialog(scopeContext.getNavigator(), (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setTitle(ResourceHelper.getString(R.string.customer_order_wait_pay_fail))).setMessage(str).setMainAction(ResourceHelper.getString(R.string.customer_dialog_confirm), onClickListener)).create());
        }
    }

    public static void showDuplicateOrderDialog(ScopeContext scopeContext, RFDialogInterface.OnClickListener onClickListener) {
        if (scopeContext.getLiveHandler().isActive()) {
            SodaWindowFactory.showDialog(scopeContext.getNavigator(), (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setMessage(ResourceHelper.getString(R.string.FoodC_neterror_You_have_Weja)).setMainAction(ResourceHelper.getString(R.string.FoodC_neterror_Confirmation_KTzB), onClickListener)).setCancelable(false)).create());
        }
    }

    public static void showNotPayDialog(ScopeContext scopeContext, String str, boolean z, RFDialogInterface.OnClickListener onClickListener, RFDialogInterface.OnClickListener onClickListener2) {
        String str2;
        if (scopeContext.getLiveHandler().isActive()) {
            RFCommonDialog.Builder builder = (RFCommonDialog.Builder) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setTitle(ResourceHelper.getString(R.string.customer_cart_error_hint))).setMessage(str).setCancelable(false);
            if (z) {
                str2 = ResourceHelper.getString(R.string.customer_business_detail_view);
            } else {
                str2 = ResourceHelper.getString(R.string.FoodC_demand_Determination_wKQX);
            }
            SodaWindowFactory.showDialog(scopeContext.getNavigator(), (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) builder.setMainAction(str2, onClickListener)).setSubAction2(ResourceHelper.getString(R.string.customer_dialog_cancel), onClickListener2)).create());
        }
    }

    public static Dialog showCheckLawDialog(DialogInstrument dialogInstrument, String str, int i, View view, RFDialogInterface.OnClickListener onClickListener, RFDialogInterface.OnClickListener onClickListener2) {
        RFCommonDialog rFCommonDialog = (RFCommonDialog) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setTitle(ResourceHelper.getString(i))).setView(view).setMainAction(ResourceHelper.getString(R.string.customer_dialog_agree), onClickListener)).setSubAction1(ResourceHelper.getString(R.string.customer_dialog_decline), onClickListener2)).setCancelable(false)).setAutoDismiss(false)).create();
        SodaWindowFactory.showDialog(dialogInstrument, rFCommonDialog, str);
        return rFCommonDialog;
    }

    public static void showFacebookFailSelectOtherDialog(INavigator iNavigator) {
        SodaWindowFactory.showDialog(iNavigator, (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setTitle(ResourceHelper.getString(R.string.customer_security_fail_title))).setMessage(ResourceHelper.getString(R.string.customer_security_fail_content_1)).setMainAction(ResourceHelper.getString(R.string.customer_i_know), (RFDialogInterface.OnClickListener) null)).create());
    }

    public static void showFacebookFailNotSelectDialog(INavigator iNavigator) {
        SodaWindowFactory.showDialog(iNavigator, (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setTitle(ResourceHelper.getString(R.string.customer_security_fail_title))).setMessage(ResourceHelper.getString(R.string.customer_security_fail_content_2)).setMainAction(ResourceHelper.getString(R.string.customer_i_know), (RFDialogInterface.OnClickListener) null)).create());
    }

    public static void showFacebookFailAlreadyVerifyDialog(INavigator iNavigator) {
        SodaWindowFactory.showDialog(iNavigator, (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setTitle(ResourceHelper.getString(R.string.customer_security_fail_title))).setMessage(ResourceHelper.getString(R.string.customer_security_fail_content_3)).setMainAction(ResourceHelper.getString(R.string.customer_i_know), (RFDialogInterface.OnClickListener) null)).create());
    }

    public static void showVerifyErrorDialog(ScopeContext scopeContext, RFDialogInterface.OnClickListener onClickListener, RFDialogInterface.OnClickListener onClickListener2) {
        if (scopeContext.getLiveHandler().isActive()) {
            SodaWindowFactory.showDialog(scopeContext.getNavigator(), (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setTitle(ResourceHelper.getString(R.string.customer_security_verify_title))).setMessage(ResourceHelper.getString(R.string.customer_security_verify_content)).setMainAction(ResourceHelper.getString(R.string.customer_security_verify_now), onClickListener)).setSubAction1(ResourceHelper.getString(R.string.cancel), onClickListener2)).create());
        }
    }

    public static void showNumProtectDialog(CustomerNumProtectDialog customerNumProtectDialog, INavigator iNavigator) {
        SodaWindowFactory.showDialog(iNavigator, (Dialog) customerNumProtectDialog);
    }

    public static void showProtectNumDegradeDialog(Context context, INavigator iNavigator, String str, boolean z, View.OnClickListener onClickListener) {
        DialogBuilder content = new DialogBuilder().setIconImage(R.drawable.common_icon_exclamation).setContent(str);
        if (z) {
            content.addMainAction(new CustomerCommonDialog.DialogAction(context.getString(R.string.customer_dialog_confirm), onClickListener));
        } else {
            content.addSubAction1(context.getString(R.string.customer_dialog_cancel)).addMainAction(new CustomerCommonDialog.DialogAction(context.getString(R.string.customer_call_this_phone), onClickListener));
        }
        SodaWindowFactory.showDialog(iNavigator, (Dialog) SodaWindowFactory.buildDialog(context, content));
    }

    public static void showOrderEvaluationDialog(INavigator iNavigator, RFDialogInterface.OnClickListener onClickListener, RFDialogInterface.OnClickListener onClickListener2, RFDialogInterface.OnClickListener onClickListener3) {
        SodaWindowFactory.showDialog(iNavigator, (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setTitle(ResourceHelper.getString(R.string.FoodC_improve__jzel))).setMessage(ResourceHelper.getString(R.string.FoodC_improve__ltMq)).setMainAction(ResourceHelper.getString(R.string.FoodC_improve__yaQF), onClickListener)).setSubAction1(ResourceHelper.getString(R.string.FoodC_improve__HzBp), onClickListener2)).setSubAction2(ResourceHelper.getString(R.string.FoodC_improve__ctKz), onClickListener3)).create());
    }

    public static CustomerRateDialog showRateDialog(Context context, INavigator iNavigator, View.OnClickListener onClickListener) {
        CustomerRateDialog buildRateDialog = SodaWindowFactory.buildRateDialog(context, new DialogBuilder().setTitle(context.getString(R.string.customer_rate_title)).setContent(context.getString(R.string.customer_rate_content)).addSubAction1(new CustomerCommonDialog.DialogAction(context.getString(R.string.customer_rate), onClickListener)).addSubAction2(context.getString(R.string.customer_not_rate)));
        SodaWindowFactory.showDialog(iNavigator, (Dialog) buildRateDialog);
        return buildRateDialog;
    }

    public static void showNotificationRemindDialog(INavigator iNavigator, RFDialogInterface.OnClickListener onClickListener, RFDialogInterface.OnClickListener onClickListener2) {
        SodaWindowFactory.showDialog(iNavigator, (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setMessage(ResourceHelper.getString(R.string.customer_notification_remind_tip)).setMainAction(ResourceHelper.getString(R.string.customer_notification_remind_yes), onClickListener)).setSubAction1(ResourceHelper.getString(R.string.customer_notification_remind_no), onClickListener2)).create());
    }

    public static void showAlcoholRemindDialog(INavigator iNavigator, RFDialogInterface.OnClickListener onClickListener, RFDialogInterface.OnClickListener onClickListener2, String str, String str2) {
        SodaWindowFactory.showDialog(iNavigator, (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setTitle(str)).setMessage(str2).setMainAction(ResourceHelper.getString(R.string.customer_dialog_accept), onClickListener)).setSubAction1(ResourceHelper.getString(R.string.customer_dialog_cancel), onClickListener2)).create());
    }

    public static void showAddressDeleteDialog(INavigator iNavigator, RFDialogInterface.OnClickListener onClickListener) {
        RFCommonDialog.Builder builder = new RFCommonDialog.Builder();
        SodaWindowFactory.showDialog(iNavigator, (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) builder.setMessage(ResourceHelper.getString(R.string.customer_global_next_line) + ResourceHelper.getString(R.string.customer_address_delete_title) + ResourceHelper.getString(R.string.customer_global_next_line)).setMainAction(ResourceHelper.getString(R.string.customer_dialog_confirm), onClickListener)).setSubAction1(ResourceHelper.getString(R.string.customer_dialog_cancel), (RFDialogInterface.OnClickListener) null)).create());
    }

    public static void showAddressUnDeletableDialog(INavigator iNavigator) {
        SodaWindowFactory.showDialog(iNavigator, (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setTitle(ResourceHelper.getString(R.string.customer_address_unable_delete_title))).setMessage(ResourceHelper.getString(R.string.customer_address_unable_delete_reason)).setMainAction(ResourceHelper.getString(R.string.customer_i_know), (RFDialogInterface.OnClickListener) null)).create());
    }

    public static void showSwitchTipDialog(String str, ScopeContext scopeContext, RFDialogInterface.OnClickListener onClickListener, RFDialogInterface.OnClickListener onClickListener2) {
        if (scopeContext.getLiveHandler().isActive()) {
            SodaWindowFactory.showDialog(scopeContext.getNavigator(), (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setTitle(ResourceHelper.getString(R.string.setting_confirm_hint))).setMessage(str).setMainAction(ResourceHelper.getString(R.string.customer_dialog_cancel), onClickListener)).setSubAction1(ResourceHelper.getString(R.string.customer_dialog_confirm), onClickListener2)).create());
        }
    }

    public static void showAddressDetailEmptyTipDialog(ScopeContext scopeContext, String str, RFDialogInterface.OnClickListener onClickListener, RFDialogInterface.OnClickListener onClickListener2) {
        if (scopeContext.getLiveHandler().isActive()) {
            SodaWindowFactory.showDialog(scopeContext.getNavigator(), (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setTitle(ResourceHelper.getString(R.string.customer_cart_address_edit_title))).setMessage(str).setMainAction(ResourceHelper.getString(R.string.customer_cart_address_edit_add), onClickListener)).setSubAction1(ResourceHelper.getString(R.string.customer_cart_address_edit_skip), onClickListener2)).create());
        }
    }

    public static void showDebtPayFailDialog(ScopeContext scopeContext, String str, RFDialogInterface.OnClickListener onClickListener) {
        if (scopeContext.getLiveHandler().isActive()) {
            SodaWindowFactory.showDialog(scopeContext.getNavigator(), (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setTitle(ResourceHelper.getString(R.string.customer_order_wait_pay_fail))).setMessage(str).setMainAction(ResourceHelper.getString(R.string.customer_dialog_confirm), onClickListener)).create());
        }
    }

    public static void showBillErrorDialog(INavigator iNavigator, String str, RFDialogInterface.OnClickListener onClickListener) {
        SodaWindowFactory.showDialog(iNavigator, (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setMessage(str).setMainAction(ResourceHelper.getString(R.string.customer_common_ok), onClickListener)).create());
    }

    public static void showBindEmailTipDialog(ScopeContext scopeContext, SendInfoEntity.BindEmailConfirmEntity bindEmailConfirmEntity, RFDialogInterface.OnClickListener onClickListener, RFDialogInterface.OnClickListener onClickListener2) {
        if (scopeContext.getLiveHandler().isActive()) {
            SodaWindowFactory.showDialog(scopeContext.getNavigator(), (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setMessage(bindEmailConfirmEntity.msg).setTitle(bindEmailConfirmEntity.title)).setMainAction(bindEmailConfirmEntity.okBtnDesc, onClickListener2)).setSubAction1(bindEmailConfirmEntity.cancelBtnDesc, onClickListener)).create());
        }
    }

    public static void showNoCapacityConfirm(INavigator iNavigator, DialogContentEntity dialogContentEntity, RFDialogInterface.OnClickListener onClickListener, RFDialogInterface.OnClickListener onClickListener2, RFDialogInterface.OnClickListener onClickListener3) {
        SodaWindowFactory.showDialog(iNavigator, (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setBanner(dialogContentEntity.url)).setMessage(dialogContentEntity.msg).setTitle(dialogContentEntity.title)).setMainAction(dialogContentEntity.okBtnDesc, onClickListener)).setSubAction1(dialogContentEntity.cancelBtnDesc, onClickListener2)).setCloseable(true, onClickListener3)).create());
    }

    public static void showOrderAddressUpdateFailed(INavigator iNavigator, String str, RFDialogInterface.OnClickListener onClickListener) {
        SodaWindowFactory.showDialog(iNavigator, (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setTitle(ResourceHelper.getString(R.string.FoodC_payment_Unable_to_UBKm))).setMessage(str).setMainAction(ResourceHelper.getString(R.string.FoodC_payment_OK_Oegd), onClickListener)).create());
    }

    public static void showOrderAddressUpdate(INavigator iNavigator, RFDialogInterface.OnClickListener onClickListener, RFDialogInterface.OnClickListener onClickListener2) {
        SodaWindowFactory.showDialog(iNavigator, (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setTitle(ResourceHelper.getString(R.string.FoodC_payment_Are_you_JTYY))).setMessage(ResourceHelper.getString(R.string.FoodC_payment_You_only_MHuA)).setMainAction(ResourceHelper.getString(R.string.FoodC_payment_Confirmation_SXoY), onClickListener)).setSubAction1(ResourceHelper.getString(R.string.FoodC_payment_Wait_LLHg), onClickListener2)).create());
    }

    public static void showOrderCreateConnectError(ScopeContext scopeContext, RFDialogInterface.OnClickListener onClickListener, RFDialogInterface.OnClickListener onClickListener2) {
        SodaWindowFactory.showDialog(scopeContext.getNavigator(), (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setMessage(ResourceHelper.getString(R.string.FoodC_neterror_Please_check_xFwk)).setMainAction(ResourceHelper.getString(R.string.FoodC_neterror_Try_again_XOWo), onClickListener)).setSubAction1(ResourceHelper.getString(R.string.FoodC_neterror_Cancel_Gwmv), onClickListener2)).setCancelable(false)).create());
    }

    public static void showEvaluateFeedbackDialog(Context context, ScopeContext scopeContext, EvaluateCallback evaluateCallback) {
        if (scopeContext.getLiveHandler().isActive()) {
            SodaWindowFactory.showDialog(scopeContext.getNavigator(), (Dialog) SodaWindowFactory.buildEvaluateFeedbackDialog(context, evaluateCallback));
        }
    }

    public static void showOpenLocationPermissionDialog(DialogInstrument dialogInstrument, RFDialogInterface.OnClickListener onClickListener, RFDialogInterface.OnClickListener onClickListener2) {
        SodaWindowFactory.showDialog(dialogInstrument, (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setTitle(ResourceHelper.getString(R.string.FoodC_homepage_No_way_fqEU))).setMessage(ResourceHelper.getString(R.string.FoodC_homepage__app_vEiY, CustomerSystemUtil.getAppName(GlobalContext.getContext()))).setMainAction(ResourceHelper.getString(R.string.FoodC_homepage_To_authorize_CEZR), onClickListener)).setSubAction1(ResourceHelper.getString(R.string.FoodC_homepage_Ignorance_RuyY), onClickListener2)).create());
    }

    public static void showOpenLocationServiceDialog(DialogInstrument dialogInstrument, RFDialogInterface.OnClickListener onClickListener, RFDialogInterface.OnClickListener onClickListener2) {
        SodaWindowFactory.showDialog(dialogInstrument, (Dialog) (RFCommonDialog) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) ((RFCommonDialog.Builder) new RFCommonDialog.Builder().setTitle(ResourceHelper.getString(R.string.FoodC_homepage_Please_location_EFne))).setMessage(ResourceHelper.getString(R.string.FoodC_homepage_The_current_yCwI)).setMainAction(ResourceHelper.getString(R.string.FoodC_homepage_Open_immediately_uIrN), onClickListener)).setSubAction1(ResourceHelper.getString(R.string.FoodC_homepage_Ignorance_RuyY), onClickListener2)).create());
    }
}
