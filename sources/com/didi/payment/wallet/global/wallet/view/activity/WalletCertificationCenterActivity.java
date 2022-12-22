package com.didi.payment.wallet.global.wallet.view.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.wallet.global.utils.WalletSPUtils;
import com.didi.payment.wallet.global.wallet.contract.WalletMainListSettingContract;
import com.didi.payment.wallet.global.wallet.view.activity.WalletMainListSettingActivity;
import com.didi.payment.wallet.global.wallet.view.adapter.WalletMainListSettingListAdapter;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.AccountSection;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ResourcesHelper;
import com.taxis99.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class WalletCertificationCenterActivity extends WalletBaseActivity {

    /* renamed from: a */
    private RecyclerView f32124a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public WalletMainListSettingListAdapter f32125b;

    /* renamed from: c */
    private ImageView f32126c;

    /* renamed from: d */
    private TextView f32127d;

    /* renamed from: e */
    private ArrayList<WalletMainListSettingContract.SettingItemModel> f32128e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public AccountSection f32129f;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.wallet_activity_certification_center);
        m22814a();
        m22816b();
    }

    /* renamed from: a */
    private void m22814a() {
        HashMap hashMap = new HashMap();
        hashMap.put("pub_from_page", "");
        hashMap.put("pub_page", getString(R.string.Fintech_Payment_mgmt__Arfd));
        FinOmegaSDK.trackEvent("fin_wallet_kyc_center_sw", hashMap);
        if (getIntent() != null) {
            this.f32128e = getIntent().getParcelableArrayListExtra("subSettingsData");
            this.f32129f = (AccountSection) getIntent().getSerializableExtra("accountSection");
        }
    }

    /* renamed from: b */
    private void m22816b() {
        this.f32124a = (RecyclerView) findViewById(R.id.rv_certification_center_list);
        this.f32126c = (ImageView) findViewById(R.id.iv_left);
        this.f32127d = (TextView) findViewById(R.id.tv_title);
        this.f32126c.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                WalletCertificationCenterActivity.this.finish();
            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(1);
        this.f32124a.setLayoutManager(linearLayoutManager);
        this.f32124a.setItemAnimator(new DefaultItemAnimator());
        WalletMainListSettingActivity.ItemDivider itemDivider = new WalletMainListSettingActivity.ItemDivider(this, 1);
        itemDivider.setDrawable(ResourcesHelper.getDrawable(this, R.drawable.wallet_balance_history_list_divider));
        this.f32124a.addItemDecoration(itemDivider);
        WalletMainListSettingListAdapter walletMainListSettingListAdapter = new WalletMainListSettingListAdapter(this);
        this.f32125b = walletMainListSettingListAdapter;
        walletMainListSettingListAdapter.setCallback(new WalletMainListSettingListAdapter.Callback() {
            public void onSettingItemClicked(int i, String str, WalletMainListSettingContract.SettingItemModel settingItemModel) {
                HashMap hashMap = new HashMap();
                hashMap.put("title", settingItemModel.name);
                hashMap.put("pub_page", WalletCertificationCenterActivity.this.getString(R.string.Fintech_Payment_mgmt__Arfd));
                hashMap.put("pub_from_page", "");
                FinOmegaSDK.trackEvent("fin_wallet_kyc_center_ck", hashMap);
                if (!TextUtils.isEmpty(str)) {
                    WalletSPUtils.setIsShowSettingRedDot(WalletCertificationCenterActivity.this.getContext(), settingItemModel.type, true);
                    Request build = DRouter.build(str);
                    if (i == 2) {
                        build.putExtra("accountSection", (Serializable) WalletCertificationCenterActivity.this.f32129f);
                    }
                    build.start(WalletCertificationCenterActivity.this.getContext());
                    if (WalletCertificationCenterActivity.this.f32125b != null) {
                        WalletCertificationCenterActivity.this.f32125b.refreshRedDot(settingItemModel.type);
                    }
                }
            }
        });
        this.f32124a.setAdapter(this.f32125b);
        ArrayList<WalletMainListSettingContract.SettingItemModel> arrayList = this.f32128e;
        if (arrayList != null) {
            this.f32125b.setData(arrayList);
        }
    }
}
