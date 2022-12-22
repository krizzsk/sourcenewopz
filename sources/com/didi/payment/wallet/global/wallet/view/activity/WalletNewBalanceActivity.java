package com.didi.payment.wallet.global.wallet.view.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.payment.base.cons.WalletExtraConstant;
import com.didi.payment.base.dialog.VerifyDialogFragment;
import com.didi.payment.base.service.IWalletService;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.view.PayRichInfo;
import com.didi.payment.commonsdk.basemodel.account.AccountFreezeData;
import com.didi.payment.wallet.global.model.resp.WalletBalanceInfoResp;
import com.didi.payment.wallet.global.omega.GlobalOmegaConstant;
import com.didi.payment.wallet.global.wallet.contract.WalletNewBalanceContract;
import com.didi.payment.wallet.global.wallet.presenter.WalletNewBalancePresenter;
import com.didi.payment.wallet.global.wallet.view.fragment.WalletNewBalanceHistoryFragment;
import com.didi.payment.wallet.global.wallet.view.fragment.WalletNewBalanceInterestFragment;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.HashMap;

public class WalletNewBalanceActivity extends WalletBaseActivity implements View.OnClickListener, WalletNewBalanceContract.View {

    /* renamed from: a */
    private static final String f32156a = "wallet_balance_tab_history";

    /* renamed from: b */
    private static final String f32157b = "fragment_tag_tab_interest";

    /* renamed from: c */
    private static final String f32158c = "fragment_tag_tab_cashback";

    /* renamed from: d */
    private LinearLayout f32159d;

    /* renamed from: e */
    private View f32160e;

    /* renamed from: f */
    private View f32161f;

    /* renamed from: g */
    private ViewGroup f32162g;

    /* renamed from: h */
    private TextView f32163h;

    /* renamed from: i */
    private TextView f32164i;

    /* renamed from: j */
    private TextView f32165j;

    /* renamed from: k */
    private TextView f32166k;

    /* renamed from: l */
    private TextView f32167l;

    /* renamed from: m */
    private Group f32168m;

    /* renamed from: n */
    private TextView f32169n;

    /* renamed from: o */
    private TextView f32170o;

    /* renamed from: p */
    private TextView f32171p;

    /* renamed from: q */
    private TextView f32172q;

    /* renamed from: r */
    private TextView f32173r;

    /* renamed from: s */
    private TextView f32174s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public WalletNewBalanceContract.Presenter f32175t;

    public void releaseLoadingDialog() {
    }

    public static void launch(Context context, PayRichInfo payRichInfo, int i, String str, double d, int i2, IWalletService.AccountInfo accountInfo, int i3, boolean z) {
        Intent intent = new Intent(context, WalletNewBalanceActivity.class);
        intent.putExtra(WalletExtraConstant.Key.AMOUNT_RICH_TEXT, payRichInfo);
        intent.putExtra("channelId", i);
        intent.putExtra(WalletExtraConstant.Key.BALANCE_TAB, i3);
        intent.putExtra(WalletExtraConstant.Key.BALANCE_DETAILS, str);
        intent.putExtra(WalletExtraConstant.Key.BALANCE_ACCOUNT_STATUS, i2);
        intent.putExtra(WalletExtraConstant.Key.BALANCE_ACCOUNT_INFO, accountInfo);
        intent.putExtra(WalletExtraConstant.Key.BALANCE_AMOUNT, d);
        intent.putExtra(WalletExtraConstant.Key.HAS_INTEREST, z);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    public static void launch(Context context, PayRichInfo payRichInfo, int i, String str, double d, int i2, IWalletService.AccountInfo accountInfo, int i3, boolean z, AccountFreezeData accountFreezeData) {
        Intent intent = new Intent(context, WalletNewBalanceActivity.class);
        intent.putExtra(WalletExtraConstant.Key.AMOUNT_RICH_TEXT, payRichInfo);
        intent.putExtra("channelId", i);
        intent.putExtra(WalletExtraConstant.Key.BALANCE_TAB, i3);
        intent.putExtra(WalletExtraConstant.Key.BALANCE_DETAILS, str);
        intent.putExtra(WalletExtraConstant.Key.BALANCE_ACCOUNT_STATUS, i2);
        intent.putExtra(WalletExtraConstant.Key.BALANCE_ACCOUNT_INFO, accountInfo);
        intent.putExtra(WalletExtraConstant.Key.BALANCE_AMOUNT, d);
        intent.putExtra(WalletExtraConstant.Key.HAS_INTEREST, z);
        intent.putExtra(WalletExtraConstant.Key.KEY_BLOCK_DATA, accountFreezeData);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void initStatusBar() {
        setTheme(R.style.GlobalActivityTheme);
        StatusBarLightingCompat.setStatusBarBgLightning(this, false, 0);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 23) {
            m22840a(true);
        }
        setContentView((int) R.layout.wallet_global_activity_new_balance);
        m22838a();
        WalletNewBalancePresenter walletNewBalancePresenter = new WalletNewBalancePresenter(this, this);
        this.f32175t = walletNewBalancePresenter;
        walletNewBalancePresenter.init();
    }

    /* renamed from: a */
    private void m22840a(boolean z) {
        int systemUiVisibility = getWindow().getDecorView().getSystemUiVisibility();
        getWindow().getDecorView().setSystemUiVisibility(z ? systemUiVisibility & -8193 : systemUiVisibility | 8192);
    }

    /* renamed from: a */
    private void m22838a() {
        initLoadingDialog(this);
        this.f32159d = (LinearLayout) findViewById(R.id.ll_new_balance_content);
        this.f32160e = findViewById(R.id.iv_wallet_new_balance_title_left);
        this.f32161f = findViewById(R.id.iv_wallet_new_balance_title_right);
        this.f32162g = (ViewGroup) findViewById(R.id.ll_wallet_new_balance_tab_container);
        this.f32163h = (TextView) findViewById(R.id.tv_wallet_new_balance_tab_history);
        this.f32164i = (TextView) findViewById(R.id.tv_wallet_new_balance_tab_interest);
        this.f32165j = (TextView) findViewById(R.id.tv_wallet_new_balance_tab_callback);
        this.f32160e.setOnClickListener(this);
        this.f32161f.setOnClickListener(this);
        this.f32163h.setOnClickListener(this);
        this.f32164i.setOnClickListener(this);
        this.f32165j.setOnClickListener(this);
        this.f32166k = (TextView) findViewById(R.id.tv_total_label);
        this.f32167l = (TextView) findViewById(R.id.tv_total_value);
        this.f32168m = (Group) findViewById(R.id.g_interests);
        this.f32169n = (TextView) findViewById(R.id.tv_daily_interests_label);
        this.f32170o = (TextView) findViewById(R.id.tv_daily_interests_value);
        this.f32171p = (TextView) findViewById(R.id.tv_daily_cashback_label);
        this.f32172q = (TextView) findViewById(R.id.tv_daily_cashback_value);
        this.f32173r = (TextView) findViewById(R.id.tv_monthly_earning_label);
        this.f32174s = (TextView) findViewById(R.id.tv_monthly_earning_value);
        this.f32159d.setVisibility(4);
    }

    public void initLoadingDialog(Activity activity) {
        initLoadingDialog(activity, R.id.ll_wallet_new_balance_title);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    public void updateContent(WalletBalanceInfoResp.BalanceInfoData balanceInfoData, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put("pub_page", "walletbalance");
        if (balanceInfoData == null || !balanceInfoData.hasHit || balanceInfoData.withoutHistory) {
            this.f32168m.setVisibility(8);
            this.f32159d.setBackground(getResources().getDrawable(R.drawable.wallet_balance_bg));
        } else {
            this.f32168m.setVisibility(0);
            this.f32159d.setBackground(getResources().getDrawable(R.drawable.wallet_balance_bg_long));
            hashMap.put("daily_profit", Integer.valueOf(balanceInfoData.interests));
            this.f32170o.setText(balanceInfoData.interestLabel);
            hashMap.put("daily_cashback", Integer.valueOf(balanceInfoData.cashback));
            this.f32172q.setText(balanceInfoData.cashbackLabel);
            hashMap.put("total_reward", Integer.valueOf(balanceInfoData.totalEarning));
            this.f32174s.setText(balanceInfoData.totalEarningLabel);
        }
        this.f32161f.setVisibility(0);
        this.f32162g.setVisibility(0);
        if (balanceInfoData != null) {
            this.f32167l.setText(balanceInfoData.totalBalanceLabel);
            hashMap.put(WalletExtraConstant.Key.BALANCE_AMOUNT, Integer.valueOf(balanceInfoData.totalBalance > 0 ? 1 : 0));
            this.f32165j.setVisibility(balanceInfoData.hasHit ? 0 : 8);
        } else {
            this.f32167l.setText("--");
            hashMap.put(WalletExtraConstant.Key.BALANCE_AMOUNT, 0);
            this.f32165j.setVisibility(8);
        }
        this.f32159d.setVisibility(0);
        FinOmegaSDK.trackEvent("fin_walletbalance_sw", hashMap);
        if (i == 7) {
            showBalanceInterest();
        } else if (i != 8) {
            showBalanceHistory();
        } else if (balanceInfoData == null || !balanceInfoData.hasHit) {
            showBalanceHistory();
        } else {
            showBalanceCallback();
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.iv_wallet_new_balance_title_left) {
            finish();
        } else if (view.getId() == R.id.iv_wallet_new_balance_title_right) {
            this.f32175t.onServicesClicked();
        } else if (view.getId() == R.id.tv_wallet_new_balance_tab_history) {
            this.f32175t.onTabHistoryClicked();
        } else {
            if (view.getId() == R.id.tv_wallet_new_balance_tab_interest) {
                this.f32175t.onTabInterestClicked();
            }
            if (view.getId() == R.id.tv_wallet_new_balance_tab_callback) {
                this.f32175t.onTabCashbackClicked();
            }
        }
    }

    public void showBalanceHistory() {
        if (!this.f32163h.isSelected()) {
            this.f32163h.setSelected(true);
            this.f32164i.setSelected(false);
            this.f32165j.setSelected(false);
            PayTracker.trackEvent(GlobalOmegaConstant.AccountBalancePage.EventId.GLOBAL_99PAY_ACCOUNT_BALANCE_VIEW_SW);
            HashMap hashMap = new HashMap();
            hashMap.put("pub_page", "walletbalance");
            hashMap.put("button_name", "activity");
            FinOmegaSDK.trackEvent("fin_walletbalance_button_ck", hashMap);
            m22839a(f32156a);
            m22841b(f32157b);
            m22841b(f32158c);
        }
    }

    public void showBalanceInterest() {
        if (!this.f32164i.isSelected()) {
            this.f32164i.setSelected(true);
            this.f32163h.setSelected(false);
            this.f32165j.setSelected(false);
            PayTracker.trackEvent("ibt_didipay_interest_earning_detail_sw");
            HashMap hashMap = new HashMap();
            hashMap.put("pub_page", "walletbalance");
            hashMap.put("button_name", "profits");
            FinOmegaSDK.trackEvent("fin_walletbalance_button_ck", hashMap);
            m22839a(f32157b);
            m22841b(f32156a);
            m22841b(f32158c);
        }
    }

    public void showBalanceCallback() {
        if (!this.f32165j.isSelected()) {
            this.f32165j.setSelected(true);
            this.f32164i.setSelected(false);
            this.f32163h.setSelected(false);
            HashMap hashMap = new HashMap();
            hashMap.put("pub_page", "walletbalance");
            hashMap.put("button_name", "cashback");
            FinOmegaSDK.trackEvent("fin_walletbalance_button_ck", hashMap);
            m22839a(f32158c);
            m22841b(f32156a);
            m22841b(f32157b);
        }
    }

    /* renamed from: a */
    private void m22839a(String str) {
        Fragment fragment;
        if (!TextUtils.isEmpty(str)) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            Fragment findFragmentByTag = supportFragmentManager.findFragmentByTag(str);
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            if (findFragmentByTag == null) {
                if (TextUtils.equals(str, f32156a)) {
                    fragment = new WalletNewBalanceHistoryFragment();
                } else {
                    Bundle bundle = new Bundle();
                    bundle.putInt(WalletNewBalanceInterestFragment.TYPE_KEY, TextUtils.equals(str, f32157b) ^ true ? 1 : 0);
                    WalletNewBalanceInterestFragment walletNewBalanceInterestFragment = new WalletNewBalanceInterestFragment();
                    walletNewBalanceInterestFragment.setArguments(bundle);
                    fragment = walletNewBalanceInterestFragment;
                }
                beginTransaction.add(R.id.fl_wallet_new_balance_tab_content_container, fragment, str);
            } else {
                beginTransaction.show(findFragmentByTag);
            }
            beginTransaction.commitAllowingStateLoss();
            supportFragmentManager.executePendingTransactions();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0007, code lost:
        r0 = getSupportFragmentManager();
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m22841b(java.lang.String r3) {
        /*
            r2 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            androidx.fragment.app.FragmentManager r0 = r2.getSupportFragmentManager()
            androidx.fragment.app.Fragment r3 = r0.findFragmentByTag(r3)
            if (r3 == 0) goto L_0x0022
            androidx.fragment.app.FragmentManager r1 = r2.getSupportFragmentManager()
            androidx.fragment.app.FragmentTransaction r1 = r1.beginTransaction()
            r1.hide(r3)
            r1.commitAllowingStateLoss()
            r0.executePendingTransactions()
        L_0x0022:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet.global.wallet.view.activity.WalletNewBalanceActivity.m22841b(java.lang.String):void");
    }

    public void showVerifyDialog(final AccountFreezeData accountFreezeData) {
        new VerifyDialogFragment.Builder().showCloseBtn(true).setTitle(accountFreezeData.dialogData.title).setContent(accountFreezeData.dialogData.desc).setClickListener(getString(R.string.wallet_common_btn_verify_now), getString(R.string.wallet_common_btn_details), new VerifyDialogFragment.OnClickListener() {
            public void onPositiveClick(VerifyDialogFragment verifyDialogFragment) {
                if (WalletNewBalanceActivity.this.f32175t != null) {
                    WalletNewBalanceActivity.this.f32175t.onVerifyNowClicked(accountFreezeData.dialogData.landingUrl);
                }
                verifyDialogFragment.dismiss();
            }

            public void onNegativeClick(VerifyDialogFragment verifyDialogFragment) {
                if (WalletNewBalanceActivity.this.f32175t != null) {
                    WalletNewBalanceActivity.this.f32175t.onDetailsClicked(accountFreezeData.link);
                }
            }
        }).create().show(getSupportFragmentManager(), "verify_dialog_fragment");
    }
}
