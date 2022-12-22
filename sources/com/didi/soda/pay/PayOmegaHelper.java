package com.didi.soda.pay;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.repo.CustomerActivityResultRepo;

public final class PayOmegaHelper {
    private PayOmegaHelper() {
    }

    public static void openPayView(ScopeContext scopeContext, int i, int i2, boolean z) {
        if (scopeContext != null && !scopeContext.getLiveHandler().isDestroyed()) {
            Bundle bundle = scopeContext.getBundle();
            OmegaTracker.Builder.create(EventConst.Pay.EVENT_OPEN_PAYMETHOD_PAGE, scopeContext).addEventParam("cart_id", bundle.getString("cart_id")).addEventParam("shop_id", bundle.getString("current_shop_id")).addEventParam("card_num", Integer.valueOf(i)).addEventParam("pay_status", Integer.valueOf(i2)).addEventParam(ParamConst.PARAM_IS_SELECTED_WALLET, Integer.valueOf(z ? 2 : 1)).enableGuideParam().build().track();
        }
    }

    public static void closePay(ScopeContext scopeContext, int i) {
        if (scopeContext != null) {
            Bundle bundle = scopeContext.getBundle();
            OmegaTracker.Builder.create(EventConst.Pay.EVENT_CLICK_PAYMETHOD_BACK).addEventParam("cart_id", bundle.getString("cart_id")).addEventParam("shop_id", bundle.getString("current_shop_id")).addEventParam("card_num", Integer.valueOf(i)).build().track();
            String str = "";
            String str2 = scopeContext.getObject("PageName") != null ? (String) scopeContext.getObject("PageName") : str;
            OmegaTracker.Builder create = OmegaTracker.Builder.create("sailing_c_x_page_return_ck");
            if (str2 != null) {
                str = str2;
            }
            create.addEventParam("from", str).build().track();
        }
    }

    public static void openPayUniActivity() {
        OmegaTracker.Builder.create(EventConst.Pay.TECH_SAILING_C_EVENT_DIDI_PASS_PAY_SW).build().track();
    }

    public static void bindCardResult(CustomerActivityResultRepo.ActivityResult activityResult, String str) {
        if (activityResult != null) {
            if (activityResult.resultCode != -1) {
                return;
            }
            if (!(activityResult.data == null || activityResult.data.getExtras() == null || TextUtils.isEmpty(activityResult.data.getExtras().getString("card_index")))) {
                return;
            }
        }
        ErrorTracker.create(ErrorConst.ErrorName.TECH_SAILING_C_EVENT_CARD_BIND_FAIL).addModuleName(str).build().trackError();
    }

    public static void bindPayPayFail(int i, String str) {
        ErrorTracker.create(ErrorConst.ErrorName.TECH_SAILING_C_EVENT_PAYPAY_BIND_FAIL).addModuleName("bill").addErrorType(String.valueOf(i)).addErrorMsg(str).build().trackError();
    }
}
