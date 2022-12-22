package com.didi.global.fintech.cashier.core.spi;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.didi.global.fintech.cashier.core.GlobalCashierWebActivity;
import com.didi.global.fintech.cashier.core.action.IGlobalCashierOpenUrlActionHandler;
import com.didi.global.fintech.cashier.core.utils.GlobalCashierWebParamUtils;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.didi.global.fintech.cashier.model.net.request.CashierActionData;
import com.didi.payment.base.view.webview.PayBaseWebActivity;
import com.didi.sdk.pay.base.PayCommonParamsUtil;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@ServiceProvider(alias = "open_url", value = {IGlobalCashierOpenUrlActionHandler.class})
@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/core/spi/GlobalCashierOpenUrlActionHandler;", "Lcom/didi/global/fintech/cashier/core/action/IGlobalCashierOpenUrlActionHandler;", "()V", "handle", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "action", "Lcom/didi/global/fintech/cashier/model/net/request/CashierAction;", "onDestroy", "", "cashier_core_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierOpenUrlActionHandler.kt */
public final class GlobalCashierOpenUrlActionHandler implements IGlobalCashierOpenUrlActionHandler {
    public void onDestroy() {
    }

    public boolean handle(FragmentActivity fragmentActivity, CashierAction cashierAction) {
        CashierActionData actionData;
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        GlobalCashierOpenUrlActionHandler globalCashierOpenUrlActionHandler = this;
        String str = null;
        if (((cashierAction != null && cashierAction.openUrl()) && cashierAction.getActionData() != null ? this : null) == null) {
            return false;
        }
        GlobalCashierWebParamUtils globalCashierWebParamUtils = GlobalCashierWebParamUtils.INSTANCE;
        if (!(cashierAction == null || (actionData = cashierAction.getActionData()) == null)) {
            str = actionData.getUrl();
        }
        Context context = fragmentActivity;
        String appendUrlQueryParams = globalCashierWebParamUtils.appendUrlQueryParams(str, PayCommonParamsUtil.getInstance().getCommonParam(context));
        Intent intent = new Intent(context, GlobalCashierWebActivity.class);
        intent.putExtra(PayBaseWebActivity.EXTRA_URL, appendUrlQueryParams);
        fragmentActivity.startActivityForResult(intent, 201);
        return true;
    }
}
