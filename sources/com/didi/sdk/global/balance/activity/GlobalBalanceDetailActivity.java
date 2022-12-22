package com.didi.sdk.global.balance.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.global.balance.adapter.GlobalBalanceCardAdapter;
import com.didi.sdk.global.balance.adapter.SnapPageScrollListener;
import com.didi.sdk.global.balance.contract.GlobalBalanceAccountContract;
import com.didi.sdk.global.balance.model.bean.BalanceDetail;
import com.didi.sdk.global.balance.model.bean.BalancePageResponse;
import com.didi.sdk.global.balance.presenter.GlobalBalanceAccountPresenter;
import com.didi.sdk.global.balance.widget.BalanceTopUpView;
import com.didi.sdk.global.paypal.activity.GlobalBaseActivity;
import com.didi.sdk.global.util.GlobalOmegaUtils;
import com.taxis99.R;

@Deprecated
public class GlobalBalanceDetailActivity extends GlobalBaseActivity implements GlobalBalanceAccountContract.View {

    /* renamed from: a */
    private static final String f36010a = "Balance";

    /* renamed from: b */
    private TextView f36011b;

    /* renamed from: c */
    private ImageView f36012c;

    /* renamed from: d */
    private LinearLayout f36013d;

    /* renamed from: e */
    private LinearLayout f36014e;

    /* renamed from: f */
    private GlobalBalanceCardAdapter f36015f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public GlobalBalanceAccountContract.Presenter f36016g;

    /* renamed from: h */
    private RecyclerView f36017h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public BalanceTopUpView f36018i;

    public static void launch(Activity activity, int i) {
        activity.startActivityForResult(new Intent(activity, GlobalBalanceDetailActivity.class), i);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.one_payment_activity_global_balance_main);
        m25475a();
        m25478b();
        GlobalOmegaUtils.trackBalanceDetailPageSW(this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        SystemUtils.log(4, "Balance", "onResume called, will load balance info", (Throwable) null, "com.didi.sdk.global.balance.activity.GlobalBalanceDetailActivity", 83);
        m25479c();
    }

    /* renamed from: a */
    private void m25475a() {
        this.f36016g = new GlobalBalanceAccountPresenter(this);
        GlobalBalanceCardAdapter globalBalanceCardAdapter = new GlobalBalanceCardAdapter(this);
        this.f36015f = globalBalanceCardAdapter;
        globalBalanceCardAdapter.setOnItemClickListener(new GlobalBalanceCardAdapter.OnItemClickListener() {
            public void onDetailClick(BalanceDetail balanceDetail, int i) {
                if (GlobalBalanceDetailActivity.this.f36016g != null) {
                    GlobalBalanceDetailActivity.this.f36016g.jumpToBalanceTransDetailsActivity(balanceDetail.transDetailUrl, balanceDetail.currency);
                }
                GlobalOmegaUtils.trackBalanceDetailTransDetailCK(GlobalBalanceDetailActivity.this.getContext());
            }
        });
    }

    /* renamed from: b */
    private void m25478b() {
        this.f36011b = (TextView) findViewById(R.id.tv_title);
        this.f36012c = (ImageView) findViewById(R.id.iv_left);
        this.f36011b.setText(getString(R.string.one_payment_balance_account__title));
        this.f36012c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalBalanceDetailActivity.this.onBackPressed();
                GlobalOmegaUtils.trackPayPalDetailPageReturnCK(GlobalBalanceDetailActivity.this);
            }
        });
        this.f36013d = (LinearLayout) findViewById(R.id.ll_content);
        this.f36014e = (LinearLayout) findViewById(R.id.ll_empty);
        this.f36013d.setVisibility(8);
        this.f36014e.setVisibility(8);
        BalanceTopUpView balanceTopUpView = (BalanceTopUpView) findViewById(R.id.ll_topup_view);
        this.f36018i = balanceTopUpView;
        balanceTopUpView.setPresenter(this.f36016g);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        this.f36017h = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 0, false));
        new PagerSnapHelper().attachToRecyclerView(this.f36017h);
        this.f36017h.setAdapter(this.f36015f);
        this.f36017h.addOnScrollListener(new SnapPageScrollListener() {
            public void onPageSelected(int i) {
                GlobalBalanceDetailActivity.this.f36018i.onPageSelected(i);
            }
        });
    }

    /* renamed from: c */
    private void m25479c() {
        m25481d();
        this.f36016g.loadBalanceAccounts();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m25481d() {
        showLoadingDialog(getResources().getString(R.string.one_payment_waiting));
    }

    /* renamed from: a */
    private boolean m25476a(BalancePageResponse balancePageResponse) {
        return (balancePageResponse == null || balancePageResponse.errno != 0 || balancePageResponse.data == null || balancePageResponse.data.allEntries == null || balancePageResponse.data.allEntries.isEmpty()) ? false : true;
    }

    public void refreshView(BalancePageResponse balancePageResponse) {
        dismissLoadingDialog();
        if (!m25476a(balancePageResponse)) {
            this.f36013d.setVisibility(8);
            this.f36014e.setVisibility(0);
            this.f36014e.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    GlobalBalanceDetailActivity.this.m25481d();
                    GlobalBalanceDetailActivity.this.f36016g.loadBalanceAccounts();
                }
            });
            return;
        }
        this.f36014e.setVisibility(8);
        this.f36013d.setVisibility(0);
        this.f36011b.setText(balancePageResponse.data.title);
        this.f36015f.refreshData(balancePageResponse);
        this.f36018i.refreshData(balancePageResponse);
    }
}
