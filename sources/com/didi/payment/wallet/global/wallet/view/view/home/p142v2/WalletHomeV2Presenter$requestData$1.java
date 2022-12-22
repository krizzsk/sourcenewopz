package com.didi.payment.wallet.global.wallet.view.view.home.p142v2;

import android.text.TextUtils;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.AccountBalance;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.AccountSection;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.AccountStatusMessage;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.BankCard;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.CommonResourceState;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.Data;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.PrepaidStatus;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.WalletHomeModel;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletHomeTrackerManager;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\t"}, mo175978d2 = {"com/didi/payment/wallet/global/wallet/view/view/home/v2/WalletHomeV2Presenter$requestData$1", "Lcom/didichuxing/foundation/rpc/RpcService$Callback;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/WalletHomeModel;", "onFailure", "", "exception", "Ljava/io/IOException;", "onSuccess", "value", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeV2Presenter$requestData$1 */
/* compiled from: WalletHomeV2Presenter.kt */
public final class WalletHomeV2Presenter$requestData$1 implements RpcService.Callback<WalletHomeModel> {
    final /* synthetic */ WalletHomeV2Presenter this$0;

    WalletHomeV2Presenter$requestData$1(WalletHomeV2Presenter walletHomeV2Presenter) {
        this.this$0 = walletHomeV2Presenter;
    }

    public void onSuccess(WalletHomeModel walletHomeModel) {
        String str;
        String str2;
        String str3;
        Integer num;
        String str4;
        Data data;
        Data data2;
        AccountSection accountSection;
        AccountBalance accountBalance;
        Data data3;
        AccountSection accountSection2;
        PrepaidStatus marketingArea;
        Data data4;
        AccountSection accountSection3;
        BankCard bankCard;
        Data data5;
        AccountSection accountSection4;
        Data data6;
        AccountSection accountSection5;
        AccountStatusMessage accountStatusMessage;
        WalletHomeTrackerManager.Companion companion = WalletHomeTrackerManager.Companion;
        String source = TextUtils.isEmpty(this.this$0.f32664h.resourceId) ? this.this$0.getSource() : this.this$0.f32664h.resourceId;
        Intrinsics.checkNotNullExpressionValue(source, "if (TextUtils.isEmpty(fi… finExtAttrBiz.resourceId");
        CommonResourceState commonResourceState = null;
        if (walletHomeModel == null || (data6 = walletHomeModel.getData()) == null || (accountSection5 = data6.getAccountSection()) == null || (accountStatusMessage = accountSection5.getAccountStatusMessage()) == null) {
            str = null;
        } else {
            str = accountStatusMessage.getStatus();
        }
        String source2 = this.this$0.getSource();
        if (walletHomeModel == null || (data5 = walletHomeModel.getData()) == null || (accountSection4 = data5.getAccountSection()) == null) {
            str2 = null;
        } else {
            str2 = accountSection4.getAuthenticationStatus();
        }
        if (walletHomeModel == null || (data4 = walletHomeModel.getData()) == null || (accountSection3 = data4.getAccountSection()) == null || (bankCard = accountSection3.getBankCard()) == null) {
            str3 = null;
        } else {
            str3 = bankCard.getCardNum();
        }
        if (walletHomeModel == null || (data3 = walletHomeModel.getData()) == null || (accountSection2 = data3.getAccountSection()) == null || (marketingArea = accountSection2.getMarketingArea()) == null) {
            num = null;
        } else {
            num = marketingArea.getType();
        }
        if (walletHomeModel == null || (data2 = walletHomeModel.getData()) == null || (accountSection = data2.getAccountSection()) == null || (accountBalance = accountSection.getAccountBalance()) == null) {
            str4 = null;
        } else {
            str4 = accountBalance.getBalance();
        }
        companion.init(source, str, source2, str2, str3, num, str4);
        this.this$0.m23103a(walletHomeModel);
        boolean z = false;
        if (walletHomeModel != null && walletHomeModel.errno == 0) {
            z = true;
        }
        if (!z || this.this$0.f32662f) {
            this.this$0.setFinSysPopTaskData((CommonResourceState) null);
            return;
        }
        WalletHomeV2Presenter walletHomeV2Presenter = this.this$0;
        if (!(walletHomeModel == null || (data = walletHomeModel.getData()) == null)) {
            commonResourceState = data.getCommonResourceState();
        }
        walletHomeV2Presenter.setFinSysPopTaskData(commonResourceState);
    }

    public void onFailure(IOException iOException) {
        this.this$0.m23107b();
        this.this$0.setFinSysPopTaskData((CommonResourceState) null);
    }
}
