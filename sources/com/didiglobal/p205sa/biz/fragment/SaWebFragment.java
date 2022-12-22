package com.didiglobal.p205sa.biz.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import androidx.fragment.app.FragmentActivity;
import com.didi.global.loading.Loading;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.app.INavigation;
import com.didi.sdk.fusionbridge.FusionUtil;
import com.didi.sdk.fusionbridge.module.ContactModule;
import com.didi.sdk.util.NetUtil;
import com.didi.sdk.webview.WebFragment;
import com.didi.sdk.weight.SaBackLayout;
import com.didichuxing.publicservice.resourcecontrol.utils.DensityUtil;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0014J\u0012\u0010\u0016\u001a\u00020\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0018\u001a\u00020\u0012H\u0016J\"\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0015H\u0002J\u0006\u0010\u001f\u001a\u00020\u0012J\u001a\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u0015H\u0014R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006%"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/fragment/SaWebFragment;", "Lcom/didi/sdk/webview/WebFragment;", "()V", "back", "Lcom/didi/sdk/weight/SaBackLayout;", "getBack", "()Lcom/didi/sdk/weight/SaBackLayout;", "setBack", "(Lcom/didi/sdk/weight/SaBackLayout;)V", "errorView", "Landroid/view/View;", "getErrorView", "()Landroid/view/View;", "setErrorView", "(Landroid/view/View;)V", "getRootLayoutId", "", "goBack", "", "allowFinish", "hideProgress", "", "initCustomerView", "mRootView", "needShowProgressBar", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackClick", "onBackPress", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "showProgress", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.fragment.SaWebFragment */
/* compiled from: SaWebFragment.kt */
public final class SaWebFragment extends WebFragment {

    /* renamed from: a */
    private SaBackLayout f51212a;

    /* renamed from: b */
    private View f51213b;

    public int getRootLayoutId() {
        return R.layout.fragment_sa_web;
    }

    public boolean needShowProgressBar() {
        return false;
    }

    public final SaBackLayout getBack() {
        return this.f51212a;
    }

    public final void setBack(SaBackLayout saBackLayout) {
        this.f51212a = saBackLayout;
    }

    public final View getErrorView() {
        return this.f51213b;
    }

    public final void setErrorView(View view) {
        this.f51213b = view;
    }

    /* access modifiers changed from: protected */
    public void showProgress() {
        if (this.f51212a != null) {
            Loading.make(getContext(), this.f51212a).show();
        }
    }

    /* access modifiers changed from: protected */
    public void hideProgress() {
        SaBackLayout saBackLayout = this.f51212a;
        if (saBackLayout != null) {
            Loading.hide(saBackLayout);
        }
    }

    public void initCustomerView(View view) {
        SaBackLayout saBackLayout;
        super.initCustomerView(view);
        View view2 = null;
        if (view == null) {
            saBackLayout = null;
        } else {
            saBackLayout = (SaBackLayout) view.findViewById(R.id.back);
        }
        this.f51212a = saBackLayout;
        if (view != null) {
            view2 = view.findViewById(R.id.web_error_view);
        }
        this.f51213b = view2;
        SaBackLayout saBackLayout2 = this.f51212a;
        if (saBackLayout2 != null) {
            saBackLayout2.post(new Runnable() {
                public final void run() {
                    SaWebFragment.m36681a(SaWebFragment.this);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m36681a(SaWebFragment saWebFragment) {
        Intrinsics.checkNotNullParameter(saWebFragment, "this$0");
        Context context = saWebFragment.getContext();
        SaBackLayout back = saWebFragment.getBack();
        FusionUtil.topBarHeight = DensityUtil.px2dip(context, back == null ? 0.0f : (float) back.getBottom());
    }

    /* renamed from: a */
    private final void m36680a() {
        if (!needBackInterceptor()) {
            m36683a(true);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        SaBackLayout saBackLayout = this.f51212a;
        if (saBackLayout != null) {
            saBackLayout.setOnBackListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    SaWebFragment.m36682a(SaWebFragment.this, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m36682a(SaWebFragment saWebFragment, View view) {
        Intrinsics.checkNotNullParameter(saWebFragment, "this$0");
        saWebFragment.m36680a();
    }

    /* renamed from: a */
    private final boolean m36683a(boolean z) {
        BusinessContext businessContext;
        INavigation navigation;
        String str;
        INavigation navigation2;
        View view = this.f51213b;
        if (view != null) {
            view.setVisibility(8);
        }
        WebBackForwardList copyBackForwardList = this.mWebView.copyBackForwardList();
        Intrinsics.checkNotNullExpressionValue(copyBackForwardList, "mWebView.copyBackForwardList()");
        boolean z2 = false;
        String url = this.mWebView.getUrl();
        int i = -1;
        while (true) {
            if (!this.mWebView.canGoBackOrForward(i)) {
                break;
            }
            CharSequence charSequence = url;
            if (TextUtils.equals(charSequence, "about:blank")) {
                FragmentActivity activity = getActivity();
                Intrinsics.checkNotNull(activity);
                if (!NetUtil.isAvailable(activity)) {
                    BusinessContext businessContext2 = getBusinessContext();
                    if (businessContext2 != null && (navigation2 = businessContext2.getNavigation()) != null) {
                        navigation2.popBackStack();
                    }
                }
            }
            WebHistoryItem itemAtIndex = copyBackForwardList.getItemAtIndex(copyBackForwardList.getCurrentIndex() + i);
            if (itemAtIndex == null) {
                str = null;
            } else {
                str = itemAtIndex.getUrl();
            }
            if (str != null) {
                CharSequence charSequence2 = str;
                if (!TextUtils.equals(charSequence2, charSequence) && !TextUtils.equals(charSequence2, "about:blank")) {
                    this.mWebView.goBackOrForward(i);
                    break;
                }
            }
            i--;
        }
        z2 = true;
        if (!z2 && z && (businessContext = getBusinessContext()) != null && (navigation = businessContext.getNavigation()) != null) {
            navigation.popBackStack();
        }
        return z2;
    }

    public final boolean onBackPress() {
        m36680a();
        return true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 102) {
            Object exportModuleInstance = this.mWebView.getExportModuleInstance(ContactModule.class);
            if (exportModuleInstance != null) {
                ((ContactModule) exportModuleInstance).handleContactResult(i2, intent);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.didi.sdk.fusionbridge.module.ContactModule");
        }
    }
}
