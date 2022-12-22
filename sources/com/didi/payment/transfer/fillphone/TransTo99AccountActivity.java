package com.didi.payment.transfer.fillphone;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.didi.payment.base.event.PayEventPublisher;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.transfer.accounts.presenter.NNPayAccount;
import com.didi.payment.transfer.common.IPresenter;
import com.didi.payment.transfer.common.PayEventKeys;
import com.didi.payment.transfer.common.TransBaseActivity;
import com.didi.payment.transfer.constants.TransferContants;
import com.didi.payment.transfer.fillamount.IConfirmTransferInfo;
import com.didi.payment.transfer.fillamount.TransCfmAmountFragment;
import com.didi.payment.transfer.utils.TransGlobalOmegaKey;
import com.didi.payment.transfer.utils.TransOmegaUtil;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;

public class TransTo99AccountActivity extends TransBaseActivity implements IPhonePageView {

    /* renamed from: b */
    private PayEventPublisher.OnEventListener<NNPayAccount> f31391b = new PayEventPublisher.OnEventListener<NNPayAccount>() {
        public void onEvent(String str, NNPayAccount nNPayAccount) {
            TransTo99AccountActivity.this.toConfirmTransAmount(nNPayAccount);
        }
    };

    /* access modifiers changed from: protected */
    public int getFragContainerId() {
        return R.id.fragment_container;
    }

    /* access modifiers changed from: protected */
    public int getLayoutId() {
        return R.layout.trans_activity_root_lay;
    }

    /* access modifiers changed from: protected */
    public int onBindLoadingBarTo() {
        return R.id.trans_fillphone_number_titlebar;
    }

    /* access modifiers changed from: protected */
    public IPresenter onCreatePresenter() {
        return null;
    }

    public static void startActivity(Activity activity, Bundle bundle) {
        Intent intent = new Intent(activity, TransTo99AccountActivity.class);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        subscribe(PayEventKeys.TransferFillAmount.EVENT_KEY_GOTO_EDIT_AMOUNT, this.f31391b);
        TransOmegaUtil.removeGlobalParam(TransGlobalOmegaKey.KEY_PAYEE_99PAY_ACCOUNT_STATUS);
        TransOmegaUtil.removeGlobalParam(TransGlobalOmegaKey.KEY_PAYEE_99ACCOUNT_STATUS);
    }

    /* access modifiers changed from: protected */
    public void initViews() {
        m22141b();
        m22139a();
    }

    /* renamed from: a */
    private void m22139a() {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        beginTransaction.add(getFragContainerId(), TransCfmPhoneFragment.getInstance((Bundle) null), "phone_edit_fragment_tag");
        beginTransaction.commitAllowingStateLoss();
    }

    /* renamed from: b */
    private void m22141b() {
        findViewById(R.id.common_title_bar_middle_tv).setVisibility(8);
        findViewById(R.id.common_title_bar_left_img).setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                if (TransTo99AccountActivity.this.getSupportFragmentManager().getBackStackEntryCount() > 0) {
                    TransTo99AccountActivity.this.getSupportFragmentManager().popBackStack();
                } else {
                    TransTo99AccountActivity.this.finish();
                }
            }
        });
    }

    /* renamed from: a */
    private void m22140a(FragmentManager fragmentManager, String str, int i, Bundle bundle) {
        Fragment fragment;
        Bundle arguments;
        if (fragmentManager.getBackStackEntryCount() != 1) {
            if (str == null) {
                fragment = m22138a(fragmentManager, 2);
            } else {
                int backStackEntryCount = fragmentManager.getBackStackEntryCount() - 1;
                while (true) {
                    if (backStackEntryCount < 0) {
                        break;
                    } else if (!str.equals(fragmentManager.getBackStackEntryAt(backStackEntryCount).getName())) {
                        backStackEntryCount--;
                    } else if (i == 1) {
                        int i2 = backStackEntryCount - 1;
                        if (i2 >= 0) {
                            fragment = fragmentManager.findFragmentByTag(fragmentManager.getBackStackEntryAt(i2).getName());
                        }
                    } else {
                        fragment = fragmentManager.findFragmentByTag(str);
                    }
                }
            }
            if (fragment != null && (arguments = fragment.getArguments()) != null && bundle != null) {
                arguments.putAll(bundle);
                return;
            }
        }
        fragment = null;
        if (fragment != null || (arguments = fragment.getArguments()) != null) {
        }
    }

    /* renamed from: c */
    private void m22142c() {
        m22137a(getSupportFragmentManager());
    }

    /* renamed from: a */
    private Fragment m22137a(FragmentManager fragmentManager) {
        Fragment a = m22138a(fragmentManager, 1);
        if (a != null && a.isHidden()) {
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.show(a);
            beginTransaction.commitAllowingStateLoss();
        }
        return a;
    }

    /* renamed from: a */
    private Fragment m22138a(FragmentManager fragmentManager, int i) {
        int backStackEntryCount = fragmentManager.getBackStackEntryCount();
        if (backStackEntryCount <= i - 1) {
            return null;
        }
        return fragmentManager.findFragmentByTag(fragmentManager.getBackStackEntryAt(backStackEntryCount - i).getName());
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        unsubscribe(PayEventKeys.TransferFillAmount.EVENT_KEY_GOTO_EDIT_AMOUNT, this.f31391b);
    }

    public void toConfirmTransAmount(IConfirmTransferInfo iConfirmTransferInfo) {
        Bundle bundle = new Bundle();
        bundle.putInt(TransferContants.IntentKey.INTENT_PARAM_KEY_PRODUCT_LINE, getIntent().getIntExtra(TransferContants.IntentKey.INTENT_PARAM_KEY_PRODUCT_LINE, -1));
        bundle.putSerializable(TransferContants.IntentKey.INTENT_PARAM_KEY_TRANS_CFM_AMOUNT_MODEL, iConfirmTransferInfo);
        forwardFragment(TransCfmAmountFragment.getInstance(bundle), R.id.fragment_container, true, "amount_edit_fragment_tag");
    }
}
