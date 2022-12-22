package com.didi.payment.utilities.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.didi.payment.base.cons.WalletExtraConstant;
import com.didi.payment.base.service.IWalletService;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.commonsdk.utils.OmegaComParams;
import com.didi.payment.utilities.entrance.CsUtilitiesEntranceActivity;
import com.didi.payment.utilities.input.CsManualInputActivity;
import com.didi.payment.utilities.photo.CsPhotoInputActivity;
import com.didi.payment.utilities.resp.CsCreateOrderResp;
import com.didi.payment.utilities.scan.CsScanActivity;
import com.didi.payment.wallet.global.model.resp.LimitRiskReminderVo;
import com.didi.payment.wallet.global.wallet.view.activity.WalletStatusHistoryActivity;
import com.didi.payment.wallet.global.wallet.view.activity.WalletTopUpPayResultActivity;
import com.didi.payment.wallet.global.wallet.view.activity.WalletTopupHistoryActivity;
import com.didichuxing.foundation.spi.ServiceLoader;

public class CsRouter {
    public static void startUtilitiesActivity(Context context) {
        Intent intent = new Intent(context, CsUtilitiesEntranceActivity.class);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static void startScanActivity(Context context) {
        Intent intent = new Intent(context, CsScanActivity.class);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static void startScanActivity(Context context, String str, String str2) {
        Intent intent = new Intent(context, CsScanActivity.class);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            intent.putExtra(WalletExtraConstant.Key.ACTIVITY_TEXT, str);
            intent.putExtra("activity_url", str2);
        }
        intent.putExtra(WalletExtraConstant.Key.PUB_PAGE_FROM, OmegaComParams.BOLETO_HOME);
        context.startActivity(intent);
    }

    public static void startManualInputActivity(Context context, String str, String str2, String str3, LimitRiskReminderVo limitRiskReminderVo, String str4) {
        Intent intent = new Intent(context, CsManualInputActivity.class);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            intent.putExtra(WalletExtraConstant.Key.ACTIVITY_TEXT, str);
            intent.putExtra("activity_url", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            intent.putExtra(WalletExtraConstant.Key.BARCODE, str3);
        }
        if (limitRiskReminderVo != null) {
            intent.putExtra(WalletExtraConstant.Key.RISK_LIMIT_REMINDER, limitRiskReminderVo);
        }
        if (!TextUtils.isEmpty(str4)) {
            intent.putExtra(WalletExtraConstant.Key.PUB_PAGE_FROM, str4);
        }
        context.startActivity(intent);
    }

    public static void startPayResultActivity(Activity activity, int i, String str, int i2) {
        WalletTopUpPayResultActivity.launch(activity, 100, i, str, i2);
    }

    public static void startHistoryListActivity4Boleto(Activity activity, int i) {
        startHistoryListActivity4Boleto(activity, i, -1);
    }

    public static void startHistoryListActivity4Boleto(Activity activity, int i, int i2) {
        if (WalletApolloUtil.isBoletoUnpaidBillReminder()) {
            WalletStatusHistoryActivity.startActivity(activity, i, i2);
        } else {
            WalletTopupHistoryActivity.startActivity((Context) activity, i);
        }
    }

    @Deprecated
    public static void gotoAccountStatusPage(Activity activity, CsCreateOrderResp.DataBean dataBean) {
        if (dataBean != null && dataBean.extraInfo != null) {
            gotoAccountPage(activity, dataBean.extraInfo.accountStatus, dataBean.extraInfo.accountInfo);
        }
    }

    public static void gotoAccountPage(Activity activity, int i, IWalletService.AccountInfo accountInfo) {
        IWalletService iWalletService = (IWalletService) ServiceLoader.load(IWalletService.class).get();
        if (iWalletService != null) {
            iWalletService.gotoAccountPage(activity, i, accountInfo);
        }
    }

    public static void startPhotoInputActivity(Context context) {
        if (context != null) {
            Intent intent = new Intent(context, CsPhotoInputActivity.class);
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            context.startActivity(intent);
        }
    }
}
