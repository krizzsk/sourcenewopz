package com.didi.payment.transfer.common;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.didi.commoninterfacelib.permission.PermissionContext;
import com.didi.global.globalgenerickit.callback.GGKBtnTextAndCallback;
import com.didi.global.globalgenerickit.drawer.GGKDrawer;
import com.didi.global.globalgenerickit.drawer.GGKDrawerModel;
import com.didi.global.globalgenerickit.drawer.templatemodel.GGKDrawerModel1;
import com.didi.global.globalgenerickit.utils.GGKOnAntiShakeClickListener;
import com.didi.payment.base.dialog.GGKUICreatorWithThemeCheck;
import com.didi.payment.base.event.PayEventPublisher;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.transfer.common.IPresenter;
import com.didi.payment.transfer.common.PayEventKeys;
import com.didi.sdk.util.TextUtil;

public abstract class TransBaseFragment<P extends IPresenter> extends Fragment implements PermissionContext, IPageLoading {
    protected GGKDrawer mConfirmDrawer;
    /* access modifiers changed from: protected */
    public P mDefaultPresenter;
    protected View mRootView;

    /* access modifiers changed from: protected */
    public abstract int getLayoutId();

    /* access modifiers changed from: protected */
    public void initViews(View view) {
    }

    /* access modifiers changed from: protected */
    public abstract P onCreatePresenter();

    public void onDismissPageLoadding() {
    }

    public void onShowPageLoadding() {
    }

    /* access modifiers changed from: protected */
    public void registeEventListeners() {
    }

    /* access modifiers changed from: protected */
    public void unregisteEventListeners() {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int layoutId = getLayoutId();
        if (layoutId > 0) {
            View inflate = LayoutInflater.from(getContext()).inflate(layoutId, viewGroup, false);
            this.mRootView = inflate;
            inflate.setClickable(true);
            initViews(this.mRootView);
            this.mDefaultPresenter = onCreatePresenter();
            return this.mRootView;
        }
        throw new IllegalArgumentException("fragment root layout resid needed!");
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        P p = this.mDefaultPresenter;
        if (p != null) {
            p.onAdd();
        }
        registeEventListeners();
    }

    /* access modifiers changed from: protected */
    public boolean isActContextValid() {
        return getActivity() != null;
    }

    /* access modifiers changed from: protected */
    public void notifyParentPageLoading(boolean z) {
        PayEventPublisher.getPublisher().publish(PayEventKeys.Common.EVENT_KEY_SHOWLOADING, Boolean.valueOf(z));
    }

    public void showConfirmDialog(String str, String str2, String str3, DoubleCheckOnClickListener doubleCheckOnClickListener) {
        showChooseDialog(str, str2, str3, (String) null, doubleCheckOnClickListener, (DoubleCheckOnClickListener) null);
    }

    public void showChooseDialog(String str, String str2, String str3, String str4, DoubleCheckOnClickListener doubleCheckOnClickListener, DoubleCheckOnClickListener doubleCheckOnClickListener2) {
        showChooseDialogInHOri(str, str2, str3, str4, doubleCheckOnClickListener, doubleCheckOnClickListener2, false);
    }

    public void showChooseDialogInHOri(String str, String str2, String str3, String str4, final DoubleCheckOnClickListener doubleCheckOnClickListener, final DoubleCheckOnClickListener doubleCheckOnClickListener2, final boolean z) {
        C109062 r0 = new GGKDrawerModel1(str, new GGKBtnTextAndCallback(str3, new GGKOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                TransBaseFragment.this.dismissConfirmDialog();
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
        if (doubleCheckOnClickListener2 != null) {
            r0.addMinorBtn(new GGKBtnTextAndCallback(str4, new GGKOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    TransBaseFragment.this.dismissConfirmDialog();
                    doubleCheckOnClickListener2.onClick(view);
                }
            }));
        }
        GGKDrawer showDrawerModel = GGKUICreatorWithThemeCheck.showDrawerModel(getActivity(), r0);
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

    public void onPause() {
        super.onPause();
    }

    public void onStop() {
        super.onStop();
        P p = this.mDefaultPresenter;
        if (p != null) {
            p.onStop();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        P p = this.mDefaultPresenter;
        if (p != null) {
            p.onRemove();
        }
        unregisteEventListeners();
    }

    public void startActivityByPermissionContext(Intent intent) {
        startActivity(intent);
    }

    public void startActivityForResultByPermissionContext(Intent intent, int i) {
        startActivityForResult(intent, i);
    }

    public Context getContextByPermissionContext() {
        return getContext();
    }

    public void requestPermissionsByPermissionContext(String[] strArr, int i) {
        requestPermissions(strArr, i);
    }
}
