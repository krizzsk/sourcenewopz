package com.didi.payment.wallet.global.prepaidcard;

import com.didi.payment.wallet.global.prepaidcard.PrepaidSettingActivity;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletHomeTrackerManager;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/payment/wallet/global/prepaidcard/PrepaidSettingActivity$initData$adapter$1", "Lcom/didi/payment/wallet/global/prepaidcard/PrepaidSettingActivity$IItemClickListener;", "onItemClick", "", "position", "", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PrepaidSettingActivity.kt */
public final class PrepaidSettingActivity$initData$adapter$1 implements PrepaidSettingActivity.IItemClickListener {
    final /* synthetic */ PrepaidSettingActivity this$0;

    PrepaidSettingActivity$initData$adapter$1(PrepaidSettingActivity prepaidSettingActivity) {
        this.this$0 = prepaidSettingActivity;
    }

    public void onItemClick(int i) {
        String str;
        PrepaidSettingActivity.SettingResp settingResp = (PrepaidSettingActivity.SettingResp) this.this$0.f31762c.get(i);
        if (i == 0) {
            str = PrepaidSource.SETTING_REQUEST.getValue();
        } else if (i == 1) {
            str = PrepaidSource.SETTING_CANCEL.getValue();
        } else if (i != 2) {
            str = "";
        } else {
            str = PrepaidSource.SETTING_RESET.getValue();
        }
        String str2 = str;
        if (i != 0) {
            if (i == 1) {
                PrepaidSettingActivity$initData$adapter$1$onItemClick$listener$1 prepaidSettingActivity$initData$adapter$1$onItemClick$listener$1 = new PrepaidSettingActivity$initData$adapter$1$onItemClick$listener$1(this.this$0, str2);
                PrepaidSettingActivity prepaidSettingActivity = this.this$0;
                PrepaidSettingActivity.showDialog$default(prepaidSettingActivity, settingResp, (Function0) null, new PrepaidSettingActivity$initData$adapter$1$onItemClick$1(prepaidSettingActivity, str2, prepaidSettingActivity$initData$adapter$1$onItemClick$listener$1), 2, (Object) null);
            } else if (i == 2) {
                PrepaidSettingActivity$initData$adapter$1$onItemClick$callback$1 prepaidSettingActivity$initData$adapter$1$onItemClick$callback$1 = new PrepaidSettingActivity$initData$adapter$1$onItemClick$callback$1(this.this$0, str2);
                this.this$0.showLoadingDialog();
                PrepaidCardManager.Companion.start(this.this$0, str2, PrepaidConstant.SCENE_SET_PASSWORD, WalletHomeTrackerManager.Companion.getStatus(), "0", this.this$0.getCardId(), prepaidSettingActivity$initData$adapter$1$onItemClick$callback$1);
            }
        } else if (this.this$0.getCurrentNumberCards() < this.this$0.getMaximumNumberCards()) {
            PrepaidSettingActivity$initData$adapter$1$onItemClick$listener$2 prepaidSettingActivity$initData$adapter$1$onItemClick$listener$2 = new PrepaidSettingActivity$initData$adapter$1$onItemClick$listener$2(this.this$0, str2);
            PrepaidSettingActivity prepaidSettingActivity2 = this.this$0;
            PrepaidSettingActivity.showDialog$default(prepaidSettingActivity2, settingResp, (Function0) null, new PrepaidSettingActivity$initData$adapter$1$onItemClick$2(prepaidSettingActivity2, str2, prepaidSettingActivity$initData$adapter$1$onItemClick$listener$2), 2, (Object) null);
        } else {
            PrepaidSettingActivity.DialogResp dialog = settingResp.getDialog();
            if (dialog != null) {
                dialog.setTitle(this.this$0.getString(R.string.Fintech_Payment_management_You_have_ZQcK));
            }
            PrepaidSettingActivity.DialogResp dialog2 = settingResp.getDialog();
            if (dialog2 != null) {
                dialog2.setContent(this.this$0.getString(R.string.Fintech_Payment_management_You_have_UaRB));
            }
            PrepaidSettingActivity.DialogResp dialog3 = settingResp.getDialog();
            if (dialog3 != null) {
                dialog3.setCommitStr(this.this$0.getString(R.string.Fintech_Payment_management_Got_it_JAnQ));
            }
            PrepaidSettingActivity.DialogResp dialog4 = settingResp.getDialog();
            if (dialog4 != null) {
                dialog4.setCancelStr(this.this$0.getString(R.string.Fintech_Payment_management_Learn_more_kfUq));
            }
            settingResp.setLinkUrl(this.this$0.getCardListUrl());
            PrepaidSettingActivity prepaidSettingActivity3 = this.this$0;
            prepaidSettingActivity3.showDialog(settingResp, new PrepaidSettingActivity$initData$adapter$1$onItemClick$3(settingResp, prepaidSettingActivity3), (Function1<? super String, Unit>) null);
        }
    }
}
