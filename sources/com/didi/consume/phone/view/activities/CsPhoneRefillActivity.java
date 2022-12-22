package com.didi.consume.phone.view.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.consume.base.CsBaseActivity;
import com.didi.consume.base.CsOmegaUtils;
import com.didi.consume.phone.model.CsOperatorListResp;
import com.didi.consume.phone.view.fragments.CsMyFragmentsRouter;
import com.didi.consume.phone.view.fragments.CsPhoneAmountFragment;
import com.didi.consume.phone.view.fragments.CsPhoneNumberFragment;
import com.didi.consume.phone.view.fragments.CsPhoneOperatorFragment;
import com.didi.payment.wallet.global.constant.WalletConstant;
import com.didi.payment.wallet.global.model.event.PagePopupStack;
import com.didi.payment.wallet.global.wallet.view.activity.WalletTopupHistoryActivity;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class CsPhoneRefillActivity extends CsBaseActivity implements CsPhoneAmountFragment.OnFragmentAmountInteractionListener, CsPhoneNumberFragment.OnFragmentPhoneNumberInteractionListener, CsPhoneOperatorFragment.OnFragmentOperatorInteractionListener {

    /* renamed from: a */
    private String f16257a;

    /* renamed from: b */
    private String f16258b;

    /* renamed from: c */
    private int f16259c;

    /* renamed from: d */
    private String f16260d;

    /* renamed from: e */
    private TextView f16261e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public TextView f16262f;

    /* renamed from: g */
    private ImageView f16263g;

    /* renamed from: h */
    private View.OnClickListener f16264h;

    /* renamed from: i */
    private CsMyFragmentsRouter f16265i;

    /* renamed from: j */
    private boolean f16266j;

    public void onFragmentAmountInteraction() {
    }

    public static void launch(Context context, Bundle bundle) {
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.setClass(context, CsPhoneRefillActivity.class);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        EventBus.getDefault().register(this);
        this.f16259c = getIntent().getIntExtra("order_type", -1);
        this.f16260d = getIntent().getStringExtra(WalletConstant.IntentBundleKey.INTENT_PARAM_KEY_EXT_METADATA);
        SystemUtils.log(3, "hgl_tag", "orderType = " + this.f16259c + " \nextMetadata = " + this.f16260d, (Throwable) null, "com.didi.consume.phone.view.activities.CsPhoneRefillActivity", 67);
        setContentView((int) R.layout.cs_activity_phone);
        m11919a();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.initProgressDialog(this, R.id.history_contacts_title_bar);
        super.onStart();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    /* renamed from: a */
    private void m11919a() {
        this.f16261e = (TextView) findViewById(R.id.tv_title);
        this.f16262f = (TextView) findViewById(R.id.tv_right);
        this.f16263g = (ImageView) findViewById(R.id.iv_left);
        m11921c();
        m11920b();
        CsMyFragmentsRouter csMyFragmentsRouter = new CsMyFragmentsRouter(this);
        this.f16265i = csMyFragmentsRouter;
        csMyFragmentsRouter.addPhoneNumberView();
        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            public void onBackStackChanged() {
                Fragment findFragmentById = CsPhoneRefillActivity.this.getSupportFragmentManager().findFragmentById(R.id.fl_boleto_addr_patch_fragment_contrainer);
                if ((findFragmentById instanceof CsPhoneAmountFragment) || (findFragmentById instanceof CsPhoneOperatorFragment)) {
                    CsPhoneRefillActivity.this.f16262f.setVisibility(4);
                } else if (findFragmentById instanceof CsPhoneNumberFragment) {
                    CsPhoneRefillActivity.this.f16262f.setVisibility(0);
                } else {
                    SystemUtils.log(6, "consume", "Fragment source not handled", (Throwable) null, "com.didi.consume.phone.view.activities.CsPhoneRefillActivity$1", 104);
                }
            }
        });
    }

    /* renamed from: b */
    private void m11920b() {
        this.f16263g.setOnClickListener(this.f16264h);
        if (this.f16259c != 1) {
            this.f16262f.setText(getString(R.string.cs_phone_toolbar_txt_right));
            this.f16262f.setVisibility(0);
            this.f16262f.setOnClickListener(this.f16264h);
        }
    }

    /* renamed from: c */
    private void m11921c() {
        this.f16264h = new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (view.getId() == R.id.iv_left) {
                    CsPhoneRefillActivity.this.onBackPressed();
                } else if (view.getId() == R.id.tv_right) {
                    CsOmegaUtils.trackPhoneBillHistoryBtnClicked("phonenumber");
                    WalletTopupHistoryActivity.startActivity((Context) CsPhoneRefillActivity.this, 605);
                }
            }
        };
    }

    public void onFragmentPhoneNumberInteraction(String str, String str2) {
        this.f16257a = str;
        this.f16258b = str2;
        this.f16265i.addOperatorListView(str, str2);
    }

    public void onFragmentOperatorInteraction(CsOperatorListResp.Operator operator) {
        this.f16265i.addAmountListView(this.f16257a, this.f16258b, operator.operatorId, this.f16259c, this.f16260d);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPopupStack(PagePopupStack pagePopupStack) {
        SystemUtils.log(3, "hgl_tag", "activity popup :" + getClass().getSimpleName(), (Throwable) null, "com.didi.consume.phone.view.activities.CsPhoneRefillActivity", 161);
        finish();
    }
}
