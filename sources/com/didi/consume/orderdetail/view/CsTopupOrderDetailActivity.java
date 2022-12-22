package com.didi.consume.orderdetail.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.didi.consume.orderdetail.presenter.CsTopupOrderDetailPresenter;
import com.didi.payment.wallet.global.model.resp.WalletPayResultResp;
import com.didi.payment.wallet.global.wallet.contract.WalletTopUpPayResultContract;
import com.didi.payment.wallet.global.wallet.view.activity.WalletTopUpPayResultActivity;
import com.didi.sdk.apm.SystemUtils;

public class CsTopupOrderDetailActivity extends WalletTopUpPayResultActivity {
    public static void launch(Context context, int i, Bundle bundle) {
        Intent intent = new Intent(context, CsTopupOrderDetailActivity.class);
        intent.putExtras(bundle);
        SystemUtils.log(3, "hgl_tag", "OrderDetail Activity bundle = " + bundle, (Throwable) null, "com.didi.consume.orderdetail.view.CsTopupOrderDetailActivity", 28);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, i);
            return;
        }
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void initViews() {
        super.initViews();
    }

    /* access modifiers changed from: protected */
    public WalletTopUpPayResultContract.Presenter createPresenter() {
        Intent intent = getIntent();
        if (intent == null || intent.getIntExtra("product_line", -1) != 605) {
            return super.createPresenter();
        }
        return new CsTopupOrderDetailPresenter(this, this);
    }

    public void showLoadingFinish(WalletPayResultResp.PayResultData payResultData) {
        super.showLoadingFinish(payResultData);
    }

    /* access modifiers changed from: protected */
    public void refreshUIData(WalletPayResultResp.PayResultData payResultData) {
        super.refreshUIData(payResultData);
    }
}
