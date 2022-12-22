package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.popmgr;

import android.content.Context;
import android.view.View;
import com.didi.drouter.api.DRouter;
import com.didi.payment.base.event.WalletRefreshDataEvent;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.wallet.global.model.resp.WalletPopUpWindowResp;
import com.didi.payment.wallet_ui.dialog.WalletDialog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
import org.greenrobot.eventbus.EventBus;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/payment/wallet/global/wallet/view/view/home/v2/popmgr/PopUpApiTask$popUpKycInfoDialog$1$1", "Lcom/didi/payment/base/widget/DoubleCheckOnClickListener;", "doClick", "", "v", "Landroid/view/View;", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.popmgr.PopUpApiTask$popUpKycInfoDialog$1$1 */
/* compiled from: PopUpApiTask.kt */
public final class PopUpApiTask$popUpKycInfoDialog$1$1 extends DoubleCheckOnClickListener {
    final /* synthetic */ WalletPopUpWindowResp.Data $bizData;
    final /* synthetic */ Context $context;
    final /* synthetic */ Ref.ObjectRef<WalletDialog> $dialog;

    PopUpApiTask$popUpKycInfoDialog$1$1(WalletPopUpWindowResp.Data data, Context context, Ref.ObjectRef<WalletDialog> objectRef) {
        this.$bizData = data;
        this.$context = context;
        this.$dialog = objectRef;
    }

    public void doClick(View view) {
        String linkUrl = this.$bizData.getLinkUrl();
        if (linkUrl == null) {
            linkUrl = "";
        }
        DRouter.build(linkUrl).start(this.$context);
        EventBus.getDefault().post(new WalletRefreshDataEvent());
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("url", this.$bizData.getLinkUrl());
        linkedHashMap.put("btnname", "verify now");
        linkedHashMap.put("pub_page", "wallethome");
        linkedHashMap.put("pub_from_page", "");
        FinOmegaSDK.trackEvent("fin_wallet_home_popup_btn_ck", linkedHashMap);
        WalletDialog walletDialog = (WalletDialog) this.$dialog.element;
        if (walletDialog != null) {
            walletDialog.dismiss();
        }
    }
}
