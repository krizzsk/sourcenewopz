package com.didi.payment.wallet.global.wallet.view.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.drouter.api.DRouter;
import com.didi.payment.base.event.WalletRefreshDataEvent;
import com.didi.payment.wallet.global.model.resp.WalletTopUpChannelResp;
import com.didi.payment.wallet.global.omega.GlobalOmegaUtils;
import com.didi.payment.wallet.global.wallet.contract.WalletTopUpAmountContractOldServer;
import com.didi.payment.wallet.global.wallet.presenter.WalletTopUpAmountPresenterOldServer;
import com.didi.payment.wallet.global.wallet.view.adapter.WalletTopUpAdapterOldServer;
import com.didi.payment.wallet.open.DidiWalletFactory;
import com.didi.payment.wallet.open.param.GlobalWalletParam;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import org.greenrobot.eventbus.EventBus;

public class WalletTopUpAmountActivityOldServer extends WalletBaseActivity implements WalletTopUpAmountContractOldServer.View {
    public static final String KEY_FROM_XPANEL = "key_from_wallet";
    public static final String KEY_TOPUP_INFO = "key_topup_info";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public WalletTopUpAmountContractOldServer.Presenter f32214a;

    /* renamed from: b */
    private View f32215b;

    /* renamed from: c */
    private View f32216c;

    /* renamed from: d */
    private TextView f32217d;

    /* renamed from: e */
    private TextView f32218e;

    /* renamed from: f */
    private TextView f32219f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public TextView f32220g;

    /* renamed from: h */
    private RecyclerView f32221h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public WalletTopUpAdapterOldServer f32222i;

    /* renamed from: j */
    private WalletTopUpAdapterOldServer.OnAmountClickListener f32223j = new WalletTopUpAdapterOldServer.OnAmountClickListener() {
        public void onClick(WalletTopUpChannelResp.ExtraDataMexicoOnlineItem extraDataMexicoOnlineItem) {
            WalletTopUpAmountActivityOldServer.this.f32222i.refreshSelectAmount(extraDataMexicoOnlineItem);
            WalletTopUpAmountActivityOldServer.this.f32220g.setEnabled(true);
        }
    };

    /* renamed from: k */
    private View.OnClickListener f32224k = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            WalletTopUpAmountActivityOldServer.this.f32214a.handleTopUpClick(WalletTopUpAmountActivityOldServer.this.f32222i.getCurrentSelectItem());
            GlobalOmegaUtils.trackTopUpConfirmClick(WalletTopUpAmountActivityOldServer.this);
        }
    };

    public static void launch(Context context, WalletTopUpChannelResp.ExtraDataMexicoOnline extraDataMexicoOnline, boolean z) {
        Intent intent = new Intent(context, WalletTopUpAmountActivityOldServer.class);
        intent.putExtra("key_topup_info", extraDataMexicoOnline);
        intent.putExtra("key_from_wallet", z);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, 100);
            return;
        }
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        WalletTopUpChannelResp.ExtraDataMexicoOnline extraDataMexicoOnline;
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.wallet_global_activity_topup_amount);
        m22869a();
        this.f32214a = new WalletTopUpAmountPresenterOldServer(this, this, this);
        Bundle extras = getIntent().getExtras();
        if (extras == null || (extraDataMexicoOnline = (WalletTopUpChannelResp.ExtraDataMexicoOnline) extras.getSerializable("key_topup_info")) == null) {
            this.f32214a.requestData();
        } else {
            refreshUI(extraDataMexicoOnline);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        initLoadingDialog(this, R.id.layout_title_bar);
    }

    /* renamed from: a */
    private void m22869a() {
        this.f32215b = findViewById(R.id.ll_content);
        this.f32216c = findViewById(R.id.ll_empty);
        this.f32221h = (RecyclerView) findViewById(R.id.rv_amount);
        this.f32217d = (TextView) findViewById(R.id.tv_title);
        this.f32218e = (TextView) findViewById(R.id.tv_desc);
        this.f32219f = (TextView) findViewById(R.id.tv_rule);
        this.f32220g = (TextView) findViewById(R.id.bt_topup);
        this.f32216c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                WalletTopUpAmountActivityOldServer.this.f32214a.requestData();
            }
        });
        findViewById(R.id.iv_left).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                WalletTopUpAmountActivityOldServer.this.finish();
            }
        });
    }

    public void refreshUI(WalletTopUpChannelResp.ExtraDataMexicoOnline extraDataMexicoOnline) {
        this.f32215b.setVisibility(0);
        this.f32217d.setText(extraDataMexicoOnline.select_amount_page_title);
        this.f32218e.setText(extraDataMexicoOnline.select_amount_text);
        this.f32219f.setText(extraDataMexicoOnline.select_amount_rule_text);
        this.f32220g.setText(extraDataMexicoOnline.top_up_button_text);
        this.f32220g.setOnClickListener(this.f32224k);
        this.f32216c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                WalletTopUpAmountActivityOldServer.this.f32214a.requestData();
            }
        });
        this.f32222i = new WalletTopUpAdapterOldServer(this, extraDataMexicoOnline.online_top_up_items, this.f32223j);
        this.f32221h.setLayoutManager(new GridLayoutManager(this, 2));
        this.f32221h.setAdapter(this.f32222i);
        GlobalOmegaUtils.trackTopUpDetailShow(this);
    }

    public void onNetworkError() {
        this.f32215b.setVisibility(8);
        this.f32216c.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && intent.getIntExtra("code", 3) == 1) {
            Intent intent2 = new Intent();
            Bundle bundle = new Bundle();
            bundle.putInt("code", 1);
            bundle.putString("message", "");
            intent2.putExtras(bundle);
            setResult(-1, intent2);
            m22871b();
        }
    }

    /* renamed from: b */
    private void m22871b() {
        boolean z = false;
        if (getIntent() != null && getIntent().getBooleanExtra("key_from_wallet", false)) {
            z = true;
        }
        if (z) {
            DidiWalletFactory.createGlobalWalletApi().openWallet(this, new GlobalWalletParam());
        } else {
            EventBus.getDefault().post(new WalletRefreshDataEvent());
            DRouter.build("99pay://one/nativeWallet").start(this);
        }
        finish();
    }
}
