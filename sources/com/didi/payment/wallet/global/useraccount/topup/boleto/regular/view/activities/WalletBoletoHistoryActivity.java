package com.didi.payment.wallet.global.useraccount.topup.boleto.regular.view.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.wallet.global.omega.GlobalOmegaUtils;
import com.didi.payment.wallet.global.useraccount.constant.WalletConstants;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.contract.WalletBoletoHistoryContract;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.model.WalletBoletoResp;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.presenter.WalletBoletoHistoryPresenter;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.view.adapter.BoletoHistoryAdapter;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.view.adapter.DividerItemDecoration;
import com.didi.payment.wallet.global.utils.WalletRouter;
import com.didi.payment.wallet.global.wallet.view.activity.WalletBaseActivity;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class WalletBoletoHistoryActivity extends WalletBaseActivity implements AdapterView.OnItemClickListener, WalletBoletoHistoryContract.View {

    /* renamed from: a */
    RelativeLayout f31964a;

    /* renamed from: b */
    ImageView f31965b;

    /* renamed from: c */
    TextView f31966c;

    /* renamed from: d */
    private WalletBoletoHistoryContract.Presenter f31967d;

    /* renamed from: e */
    private LinearLayout f31968e;

    /* renamed from: f */
    private RecyclerView f31969f;

    /* renamed from: g */
    private BoletoHistoryAdapter f31970g;

    /* renamed from: h */
    private LinearLayoutManager f31971h;

    public void onNetworkError() {
    }

    public static void launch(Context context) {
        Intent intent = new Intent(context, WalletBoletoHistoryActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.wallet_global_activity_boleto_history_list);
        m22634a();
        m22635b();
        WalletBoletoHistoryPresenter walletBoletoHistoryPresenter = new WalletBoletoHistoryPresenter(this, this, this);
        this.f31967d = walletBoletoHistoryPresenter;
        walletBoletoHistoryPresenter.requestData();
        GlobalOmegaUtils.trackBillsViewSW();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        initLoadingDialog(this, R.id.wallet_boleto_history_list_title_bar);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
    }

    /* renamed from: a */
    private void m22634a() {
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.wallet_boleto_history_list_title_bar);
        this.f31964a = relativeLayout;
        this.f31965b = (ImageView) relativeLayout.findViewById(R.id.iv_left);
        this.f31966c = (TextView) this.f31964a.findViewById(R.id.tv_title);
        this.f31968e = (LinearLayout) findViewById(R.id.ll_boleto_history_shimmer_view_container);
        this.f31969f = (RecyclerView) findViewById(R.id.rv_boleto_history);
    }

    /* renamed from: b */
    private void m22635b() {
        this.f31965b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                WalletBoletoHistoryActivity.this.finish();
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        this.f31971h = linearLayoutManager;
        linearLayoutManager.setOrientation(1);
        this.f31969f.setLayoutManager(this.f31971h);
        this.f31969f.addItemDecoration(new DividerItemDecoration(ContextCompat.getDrawable(this, R.drawable.wallet_boleto_history_rv_divider)));
        this.f31969f.setItemAnimator(new DefaultItemAnimator());
        this.f31970g = new BoletoHistoryAdapter(this.f31969f, this, new ArrayList(), this);
    }

    public void displayBoletoHistory(List<WalletBoletoResp> list) {
        this.f31970g.addItemList(list);
        this.f31969f.setAdapter(this.f31970g);
        this.f31968e.setVisibility(8);
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AutoTrackHelper.trackViewOnClick((AdapterView) adapterView, view, i);
        WalletBoletoResp item = this.f31970g.getItem(i);
        if (item.status.toUpperCase().equalsIgnoreCase(WalletConstants.BOLETO_HISTORY_TYPE_UNPAID)) {
            WalletRouter.gotoBoletoDetailPage(this, item);
        }
    }
}
