package com.didi.payment.wallet.global.wallet.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.wallet.global.model.resp.CsHistoryItem;
import com.didi.payment.wallet.global.model.resp.CsHistoryListResp;
import com.didi.payment.wallet.global.wallet.contract.WalletTopupHistoryContract;
import com.didi.payment.wallet.global.wallet.presenter.WalletTopupHistoryPresenter;
import com.didi.payment.wallet.global.wallet.view.adapter.CsTopupHistoryAdapter;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.taxis99.R;

public class WalletTopupHistoryActivity extends WalletBaseActivity implements WalletTopupHistoryContract.View {

    /* renamed from: a */
    private CommonTitleBar f32281a;

    /* renamed from: b */
    private RecyclerView f32282b;

    /* renamed from: c */
    private View f32283c;

    /* renamed from: d */
    private TextView f32284d;

    /* renamed from: e */
    private CsTopupHistoryAdapter f32285e;

    /* renamed from: f */
    private int f32286f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public WalletTopupHistoryContract.Presenter f32287g;

    /* access modifiers changed from: protected */
    public boolean interceptPopupAction() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.cs_activity_history_list_layout);
        this.f32287g = onCreatePresenter();
        m22920b();
        m22919a();
        int i = this.f32286f;
        if (i == 606) {
            FinOmegaSDK.trackEvent("ibt_gp_didipay_lifebillrecord_sw");
        } else if (i == 605) {
            FinOmegaSDK.trackEvent("ibt_gp_didipay_phonebillrecord_sw");
        }
        checkAndShowTips();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        m22919a();
    }

    /* access modifiers changed from: protected */
    public void checkAndShowTips() {
        if (getIntent().getIntExtra("params_topup_confirm_flag", -1) == 1) {
            ToastHelper.showShortInfo((Context) this, getString(R.string.GRider_Riders_Send_order_wnYI), (int) R.drawable.wallet_toast_icon_successful);
        }
    }

    /* access modifiers changed from: protected */
    public WalletTopupHistoryContract.Presenter onCreatePresenter() {
        return new WalletTopupHistoryPresenter(this, this);
    }

    public static void startActivity(Context context, int i) {
        Intent intent = new Intent(context, WalletTopupHistoryActivity.class);
        intent.putExtra("product_line", i);
        context.startActivity(intent);
    }

    public static void startActivity(Context context, Bundle bundle) {
        Intent intent = new Intent(context, WalletTopupHistoryActivity.class);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        FinOmegaSDK.trackEvent("ibt_gp_didipay_phonebillrecord_sw");
    }

    /* renamed from: a */
    private void m22919a() {
        this.f32286f = getIntent().getIntExtra("product_line", 606);
        this.f32287g.loadHistoryData(true);
    }

    /* renamed from: b */
    private void m22920b() {
        this.f32281a = (CommonTitleBar) findViewById(R.id.cs_history_titlebar);
        this.f32282b = (RecyclerView) findViewById(R.id.cs_history_ry);
        this.f32283c = findViewById(R.id.cs_history_empty_layout);
        this.f32284d = (TextView) findViewById(R.id.cs_history_empty_tv);
        this.f32285e = new CsTopupHistoryAdapter(this, new CsTopupHistoryAdapter.CsHistoryListCallback() {
            public void onLastItemShowed() {
                WalletTopupHistoryActivity.this.f32287g.loadHistoryData(false);
                WalletTopupHistoryActivity.this.f32287g.loadNextPage();
            }
        }, new CsTopupHistoryAdapter.CssHistoryListItemClickListener() {
            public void onItemClick(CsHistoryItem csHistoryItem) {
                if (csHistoryItem != null) {
                    WalletTopupHistoryActivity.this.f32287g.handleItemClick(csHistoryItem);
                }
            }
        });
        this.f32282b.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f32282b.setAdapter(this.f32285e);
        m22921c();
        initLoadingDialog(this, R.id.cs_history_titlebar);
    }

    /* renamed from: c */
    private void m22921c() {
        this.f32281a.setLeftImage(ResourcesHelper.getDrawable(this, R.drawable.one_payment_creditcard_global_btn_title_back_selector), (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                WalletTopupHistoryActivity.this.f32287g.handleBackClick();
            }
        });
        this.f32281a.setTitle(getResources().getString(R.string.cs_history_list_page_title));
    }

    public void appendHistoryItem(CsHistoryListResp.DataModel dataModel) {
        this.f32282b.setVisibility(0);
        this.f32285e.addData(dataModel.orders);
    }

    public void clearHistoryItem() {
        this.f32285e.clearData();
    }

    public void showEmptyView(int i) {
        this.f32282b.setVisibility(8);
        this.f32283c.setVisibility(0);
        this.f32284d.setText(i);
    }
}
