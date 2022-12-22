package com.didi.payment.transfer.common;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.drawer.GGKDrawer;
import com.didi.global.globalgenerickit.drawer.GGKDrawerModel;
import com.didi.global.globalgenerickit.drawer.templatemodel.GGKDrawerModel1;
import com.didi.global.globalgenerickit.utils.GGKOnAntiShakeClickListener;
import com.didi.payment.base.dialog.GGKUICreatorWithThemeCheck;
import com.didi.payment.base.event.PayEventPublisher;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.transfer.DebugUtil;
import com.didi.payment.transfer.common.IPresenter;
import com.didi.payment.transfer.common.PayEventKeys;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.TextUtil;

public abstract class TransBaseActivity<P extends IPresenter> extends BaseLoadingActivity {

    /* renamed from: a */
    PayEventPublisher.OnEventListener<Boolean> f31320a = new PayEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            if (!TransBaseActivity.this.isInActive) {
                DebugUtil.log("Activity: " + getClass().getSimpleName() + " not in active state, Reject update loading view!", new Object[0]);
            } else if (!PayEventKeys.Common.EVENT_KEY_SHOWLOADING.equalsIgnoreCase(str)) {
            } else {
                if (bool.booleanValue()) {
                    TransBaseActivity.this.onShowPageLoadding();
                } else {
                    TransBaseActivity.this.onDismissPageLoadding();
                }
            }
        }
    };

    /* renamed from: b */
    private int f31321b = 0;
    protected GGKDrawer mConfirmDrawer;
    /* access modifiers changed from: protected */
    public P mPresenter;

    /* access modifiers changed from: protected */
    public int getFragContainerId() {
        return -1;
    }

    /* access modifiers changed from: protected */
    public abstract int getLayoutId();

    /* access modifiers changed from: protected */
    public abstract void initViews();

    /* access modifiers changed from: protected */
    public boolean needRebindLoadingBar() {
        return false;
    }

    /* access modifiers changed from: protected */
    public int onBindLoadingBarTo() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public abstract P onCreatePresenter();

    /* access modifiers changed from: protected */
    public void parseIntentData(Intent intent) {
    }

    /* access modifiers changed from: protected */
    public void registeEventListeners() {
    }

    /* access modifiers changed from: protected */
    public void unregisteEventListeners() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        parseIntentData(getIntent());
        this.mPresenter = onCreatePresenter();
        subscribe(PayEventKeys.Common.EVENT_KEY_SHOWLOADING, this.f31320a);
        setContentView(getLayoutId());
        initViews();
        initProgressDialog(this, onBindLoadingBarTo());
        registeEventListeners();
        P p = this.mPresenter;
        if (p != null) {
            p.onAdd();
        }
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        if (needRebindLoadingBar()) {
            initProgressDialog(this, onBindLoadingBarTo());
        }
    }

    /* access modifiers changed from: protected */
    public void subscribe(String str, PayEventPublisher.OnEventListener onEventListener) {
        PayEventPublisher.getPublisher().subscribe(str, onEventListener);
    }

    /* access modifiers changed from: protected */
    public void unsubscribe(String str, PayEventPublisher.OnEventListener onEventListener) {
        PayEventPublisher.getPublisher().unsubscribe(str, onEventListener);
    }

    /* access modifiers changed from: protected */
    public void attactRootFragment(Fragment fragment, String str) {
        forwardFragment(fragment, getFragContainerId(), false, str);
    }

    /* access modifiers changed from: protected */
    public void attactRootFragment(Fragment fragment, int i, String str) {
        forwardFragment(fragment, i, false, str);
    }

    /* access modifiers changed from: protected */
    public void forwardFragment(Fragment fragment, int i, boolean z, String str) {
        if (i > 0) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            beginTransaction.add(i, fragment, fragment.getClass().getSimpleName() + "_tag");
            if (z) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                int i2 = this.f31321b;
                this.f31321b = i2 + 1;
                sb.append(i2);
                beginTransaction.addToBackStack(sb.toString());
            }
            beginTransaction.commitAllowingStateLoss();
            return;
        }
        throw new IllegalArgumentException("fragment contianer id invalid in activity: " + getClass().getSimpleName());
    }

    /* access modifiers changed from: protected */
    public void forwardFragment(Fragment fragment, boolean z, String str) {
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        int fragContainerId = getFragContainerId();
        beginTransaction.add(fragContainerId, fragment, fragment.getClass().getSimpleName() + "_tag");
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            int i = this.f31321b;
            this.f31321b = i + 1;
            sb.append(i);
            beginTransaction.addToBackStack(sb.toString());
        }
        beginTransaction.commitAllowingStateLoss();
    }

    public void showConfirmDialog(String str, String str2, String str3, DoubleCheckOnClickListener doubleCheckOnClickListener) {
        showChooseDialog(str, str2, str3, (String) null, doubleCheckOnClickListener, (DoubleCheckOnClickListener) null);
    }

    public void showChooseDialog(String str, String str2, String str3, String str4, DoubleCheckOnClickListener doubleCheckOnClickListener, DoubleCheckOnClickListener doubleCheckOnClickListener2) {
        m22051a(str, str2, str3, str4, doubleCheckOnClickListener, doubleCheckOnClickListener2, true);
    }

    /* renamed from: a */
    private void m22051a(String str, String str2, String str3, String str4, final DoubleCheckOnClickListener doubleCheckOnClickListener, final DoubleCheckOnClickListener doubleCheckOnClickListener2, final boolean z) {
        C109033 r0 = new GGKDrawerModel1(str, new GGKBtnTextAndCallback(str3, new GGKOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                TransBaseActivity.this.dismissConfirmDialog();
                DoubleCheckOnClickListener doubleCheckOnClickListener = doubleCheckOnClickListener;
                if (doubleCheckOnClickListener != null) {
                    doubleCheckOnClickListener.onClick(view);
                }
            }
        })) {
            /* access modifiers changed from: protected */
            public GGKDrawerModel convertOthers(GGKDrawerModel gGKDrawerModel) {
                if (!z) {
                    return super.convertOthers(gGKDrawerModel);
                }
                gGKDrawerModel.isTwoBtnHorizontal = true;
                return gGKDrawerModel;
            }
        };
        if (!TextUtil.isEmpty(str2)) {
            r0.setSubTitle(str2);
        }
        if (!TextUtil.isEmpty(str4)) {
            r0.addMinorBtn(new GGKBtnTextAndCallback(str4, new GGKOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    TransBaseActivity.this.dismissConfirmDialog();
                    DoubleCheckOnClickListener doubleCheckOnClickListener = doubleCheckOnClickListener2;
                    if (doubleCheckOnClickListener != null) {
                        doubleCheckOnClickListener.onClick(view);
                    }
                }
            }));
        }
        GGKDrawer showDrawerModel = GGKUICreatorWithThemeCheck.showDrawerModel(this, r0);
        this.mConfirmDrawer = showDrawerModel;
        showDrawerModel.setCanceledOnTouchOutside(false);
    }

    /* access modifiers changed from: protected */
    public void dismissConfirmDialog() {
        GGKDrawer gGKDrawer = this.mConfirmDrawer;
        if (gGKDrawer != null) {
            gGKDrawer.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        P p = this.mPresenter;
        if (p != null) {
            p.onPause();
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        P p = this.mPresenter;
        if (p != null) {
            p.onStop();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        unregisteEventListeners();
        unsubscribe(PayEventKeys.Common.EVENT_KEY_SHOWLOADING, this.f31320a);
        P p = this.mPresenter;
        if (p != null) {
            p.onRemove();
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        DebugUtil.log("Base activity onRequestPermission Result() reqCode = " + i, new Object[0]);
        getSupportFragmentManager().getFragments();
        if (getSupportFragmentManager().getFragments().size() > 0) {
            for (Fragment onRequestPermissionsResult : getSupportFragmentManager().getFragments()) {
                onRequestPermissionsResult.onRequestPermissionsResult(i, strArr, iArr);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        DebugUtil.log("Base activity onActivityResult reqCode = " + i, new Object[0]);
        getSupportFragmentManager().getFragments();
        if (getSupportFragmentManager().getFragments().size() > 0) {
            for (Fragment onActivityResult : getSupportFragmentManager().getFragments()) {
                onActivityResult.onActivityResult(i, i2, intent);
            }
        }
    }
}
