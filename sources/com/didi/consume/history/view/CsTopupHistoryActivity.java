package com.didi.consume.history.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.didi.consume.history.presenter.CsTopupHistoryListPresenter;
import com.didi.payment.wallet.global.wallet.contract.WalletTopupHistoryContract;
import com.didi.payment.wallet.global.wallet.view.activity.WalletTopupHistoryActivity;
import com.didi.sdk.apm.SystemUtils;

public class CsTopupHistoryActivity extends WalletTopupHistoryActivity {
    public static void startActivity(Context context, Bundle bundle) {
        Intent intent = new Intent(context, CsTopupHistoryActivity.class);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public WalletTopupHistoryContract.Presenter onCreatePresenter() {
        return new CsTopupHistoryListPresenter(this, this);
    }
}
