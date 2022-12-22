package com.didi.payment.wallet.global.wallet.view.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.wallet.global.constant.WalletConstant;
import com.didi.payment.wallet.global.model.resp.CsHistoryItem;
import com.didi.payment.wallet.global.model.resp.CsHistoryListResp;
import com.didi.payment.wallet.global.omega.GlobalOmegaUtils;
import com.didi.payment.wallet.global.wallet.contract.WalletStatusHistoryContract;
import com.didi.payment.wallet.global.wallet.presenter.WalletStatusHistoryPresenter;
import com.didi.payment.wallet.global.wallet.view.adapter.WalletStatusHistoryAdapter;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class WalletStatusHistoryActivity extends WalletBaseActivity implements View.OnClickListener, WalletStatusHistoryContract.View {
    public static final int UNPAID_BILL_DEFAULT_VALUE = -1;

    /* renamed from: a */
    private View f32193a;

    /* renamed from: b */
    private RecyclerView f32194b;

    /* renamed from: c */
    private View f32195c;

    /* renamed from: d */
    private TextView f32196d;

    /* renamed from: e */
    private WalletStatusHistoryAdapter f32197e;

    /* renamed from: f */
    private int f32198f;

    /* renamed from: g */
    private TextView f32199g;

    /* renamed from: h */
    private TextView f32200h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public WalletStatusHistoryContract.Presenter f32201i;

    /* access modifiers changed from: protected */
    public boolean interceptPopupAction() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.cs_activity_status_history_list_layout);
        this.f32201i = onCreatePresenter();
        m22855b();
        m22854a();
        int i = this.f32198f;
        if (i == 606) {
            FinOmegaSDK.trackEvent("ibt_gp_didipay_lifebillrecord_sw");
        } else if (i == 605) {
            FinOmegaSDK.trackEvent("ibt_gp_didipay_phonebillrecord_sw");
        }
        checkAndShowTips();
    }

    /* access modifiers changed from: protected */
    public void initStatusBar() {
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, 0);
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        m22854a();
    }

    /* access modifiers changed from: protected */
    public void checkAndShowTips() {
        if (getIntent().getIntExtra("params_topup_confirm_flag", -1) == 1) {
            WalletToastNew.showSuccessMsg(this, getString(R.string.GRider_Riders_Send_order_wnYI));
        }
    }

    /* access modifiers changed from: protected */
    public WalletStatusHistoryContract.Presenter onCreatePresenter() {
        return new WalletStatusHistoryPresenter(this, this);
    }

    public static void startActivity(Context context, int i) {
        startActivity(context, i, -1);
    }

    public static void startActivity(Context context, int i, int i2) {
        Intent intent = new Intent(context, WalletStatusHistoryActivity.class);
        intent.putExtra("product_line", i);
        intent.putExtra(WalletConstant.IntentBundleKey.INTENT_PARAM_KEY_UNPAID_BILLS, i2);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static void startActivity(Context context, Bundle bundle) {
        Intent intent = new Intent(context, WalletStatusHistoryActivity.class);
        intent.putExtras(bundle);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        FinOmegaSDK.trackEvent("ibt_gp_didipay_phonebillrecord_sw");
        WalletStatusHistoryContract.Presenter presenter = this.f32201i;
        if (presenter != null) {
            presenter.checkAccountStatus();
        }
    }

    /* renamed from: a */
    private void m22854a() {
        this.f32198f = getIntent().getIntExtra("product_line", 606);
        this.f32201i.loadHistoryData(true, getCurrentCategory());
    }

    /* renamed from: b */
    private void m22855b() {
        View findViewById = findViewById(R.id.iv_wallet_new_balance_title_left);
        this.f32193a = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                WalletStatusHistoryActivity.this.f32201i.handleBackClick();
                GlobalOmegaUtils.trackBoletoHistoryExitCK(WalletStatusHistoryActivity.this.getCurrentCategory());
            }
        });
        this.f32194b = (RecyclerView) findViewById(R.id.cs_history_ry);
        this.f32195c = findViewById(R.id.cs_history_empty_layout);
        this.f32196d = (TextView) findViewById(R.id.cs_history_empty_tv);
        this.f32197e = new WalletStatusHistoryAdapter(this, new WalletStatusHistoryAdapter.CsStatusHistoryListCallback() {
            public void onLastItemShowed() {
                WalletStatusHistoryActivity.this.f32201i.loadHistoryData(false, WalletStatusHistoryActivity.this.getCurrentCategory());
                WalletStatusHistoryActivity.this.f32201i.loadNextPage(WalletStatusHistoryActivity.this.getCurrentCategory());
            }

            public void onListEmpty() {
                WalletStatusHistoryActivity.this.showEmptyView(WalletStatusHistoryActivity.this.getCurrentCategory() == 0 ? R.string.GRider_reminder_You_currently_ZrqL : R.string.cs_history_list_empty_text);
            }
        }, new WalletStatusHistoryAdapter.CsStatusHistoryListItemClickListener() {
            public void onItemClick(CsHistoryItem csHistoryItem, boolean z, int i) {
                if (csHistoryItem != null) {
                    WalletStatusHistoryActivity.this.f32201i.handleItemClick(csHistoryItem, z, i);
                }
            }

            public void onCancelClick(CsHistoryItem csHistoryItem, int i) {
                WalletStatusHistoryActivity.this.f32201i.getCancelReason(csHistoryItem, i);
            }

            public void onPayClick(CsHistoryItem csHistoryItem, int i) {
                WalletStatusHistoryActivity.this.f32201i.prepayOrder(csHistoryItem, i);
            }
        });
        this.f32194b.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f32194b.setAdapter(this.f32197e);
        initLoadingDialog(this, R.id.iv_wallet_new_balance_title_left);
        this.f32199g = (TextView) findViewById(R.id.history_unpaid);
        this.f32200h = (TextView) findViewById(R.id.history_completed);
        m22856c();
    }

    /* renamed from: c */
    private void m22856c() {
        if (getIntent().getIntExtra(WalletConstant.IntentBundleKey.INTENT_PARAM_KEY_UNPAID_BILLS, -1) != 0) {
            this.f32199g.setSelected(true);
            this.f32200h.setSelected(false);
            GlobalOmegaUtils.trackBoletoHistoryUnpaidSW();
        } else {
            this.f32199g.setSelected(false);
            this.f32200h.setSelected(true);
            GlobalOmegaUtils.trackBoletoHistoryCompletedSW();
        }
        this.f32199g.setOnClickListener(this);
        this.f32200h.setOnClickListener(this);
    }

    public void appendHistoryItem(CsHistoryListResp.DataModel dataModel) {
        this.f32194b.setVisibility(0);
        this.f32197e.addData(dataModel.orders, this.f32199g.isSelected());
    }

    public void clearHistoryItem() {
        this.f32197e.clearData();
    }

    public void removeItem(int i) {
        WalletStatusHistoryAdapter walletStatusHistoryAdapter = this.f32197e;
        if (walletStatusHistoryAdapter != null) {
            walletStatusHistoryAdapter.removeItem(i);
        }
    }

    public void showEmptyView(int i) {
        this.f32194b.setVisibility(8);
        this.f32195c.setVisibility(0);
        this.f32196d.setText(i);
    }

    public void hideEmptyView() {
        this.f32195c.setVisibility(8);
    }

    /* renamed from: d */
    private void m22857d() {
        if (!this.f32199g.isSelected()) {
            this.f32199g.setSelected(true);
            this.f32200h.setSelected(false);
            this.f32201i.loadHistoryData(true, getCurrentCategory());
            GlobalOmegaUtils.trackBoletoHistoryUnpaidCK();
        }
    }

    /* renamed from: e */
    private void m22858e() {
        if (!this.f32200h.isSelected()) {
            this.f32200h.setSelected(true);
            this.f32199g.setSelected(false);
            this.f32201i.loadHistoryData(true, getCurrentCategory());
            GlobalOmegaUtils.trackBoletoHistoryCompletedCK();
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.history_unpaid) {
            m22857d();
        } else if (view.getId() == R.id.history_completed) {
            m22858e();
        }
    }

    public int getCurrentCategory() {
        return this.f32199g.isSelected() ^ true ? 1 : 0;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f32201i.destroy();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        WalletStatusHistoryContract.Presenter presenter;
        WalletStatusHistoryContract.Presenter presenter2;
        super.onActivityResult(i, i2, intent);
        if (i2 != -1) {
            return;
        }
        if (i == 100) {
            if (intent.getIntExtra("code", 3) == 1 && (presenter2 = this.f32201i) != null) {
                presenter2.gotoPayResultPage();
            }
        } else if (i == 200) {
            if (intent.getIntExtra("code", 3) == 1 && (presenter = this.f32201i) != null) {
                presenter.gotoPayResultPage();
            }
        } else if (i == 101) {
            this.f32201i.loadHistoryData(true, getCurrentCategory());
        }
    }
}
