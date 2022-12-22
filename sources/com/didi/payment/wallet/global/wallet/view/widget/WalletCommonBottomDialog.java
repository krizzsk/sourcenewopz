package com.didi.payment.wallet.global.wallet.view.widget;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.view.BaseDialogFragment;
import com.didi.unifiedPay.util.UIUtils;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001=B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010*\u001a\u00020\u0004J\u0006\u0010+\u001a\u00020\u0004J\u0006\u0010,\u001a\u00020\u0004J\u0006\u0010-\u001a\u00020\bJ\u0006\u0010.\u001a\u00020\u0004J\u0012\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102H\u0016J&\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u0001082\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u001a\u00109\u001a\u0002002\u0006\u0010:\u001a\u0002042\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u000e\u0010;\u001a\u0002002\u0006\u0010<\u001a\u00020 R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R\u001c\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0013\"\u0004\b'\u0010\u0015R\u000e\u0010(\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000¨\u0006>"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/widget/WalletCommonBottomDialog;", "Lcom/didi/sdk/view/BaseDialogFragment;", "()V", "btnCancel", "Landroid/widget/TextView;", "btnConfirm", "btnLargeCancel", "clRoot", "Landroidx/constraintlayout/widget/ConstraintLayout;", "isShowClose", "", "()Z", "setShowClose", "(Z)V", "ivClose", "Landroid/widget/ImageView;", "mCancelStr", "", "getMCancelStr", "()Ljava/lang/String;", "setMCancelStr", "(Ljava/lang/String;)V", "mConfirmStr", "getMConfirmStr", "setMConfirmStr", "mContent", "getMContent", "setMContent", "mLargeCancelStr", "getMLargeCancelStr", "setMLargeCancelStr", "mListener", "Lcom/didi/payment/wallet/global/wallet/view/widget/ICommonBottomListener;", "getMListener", "()Lcom/didi/payment/wallet/global/wallet/view/widget/ICommonBottomListener;", "setMListener", "(Lcom/didi/payment/wallet/global/wallet/view/widget/ICommonBottomListener;)V", "mTitle", "getMTitle", "setMTitle", "tvContent", "tvTitle", "getCancelView", "getConfirmBtn", "getContentView", "getRootView", "getTitleView", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "setClickListener", "listener", "Builder", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: WalletCommonBottomDialog.kt */
public final class WalletCommonBottomDialog extends BaseDialogFragment {

    /* renamed from: a */
    private TextView f32841a;

    /* renamed from: b */
    private TextView f32842b;

    /* renamed from: c */
    private TextView f32843c;

    /* renamed from: d */
    private TextView f32844d;

    /* renamed from: e */
    private TextView f32845e;

    /* renamed from: f */
    private ImageView f32846f;

    /* renamed from: g */
    private ConstraintLayout f32847g;

    /* renamed from: h */
    private String f32848h;

    /* renamed from: i */
    private String f32849i;

    /* renamed from: j */
    private String f32850j;

    /* renamed from: k */
    private String f32851k;

    /* renamed from: l */
    private String f32852l;

    /* renamed from: m */
    private ICommonBottomListener f32853m;

    /* renamed from: n */
    private boolean f32854n;

    public final String getMTitle() {
        return this.f32848h;
    }

    public final void setMTitle(String str) {
        this.f32848h = str;
    }

    public final String getMContent() {
        return this.f32849i;
    }

    public final void setMContent(String str) {
        this.f32849i = str;
    }

    public final String getMCancelStr() {
        return this.f32850j;
    }

    public final void setMCancelStr(String str) {
        this.f32850j = str;
    }

    public final String getMLargeCancelStr() {
        return this.f32851k;
    }

    public final void setMLargeCancelStr(String str) {
        this.f32851k = str;
    }

    public final String getMConfirmStr() {
        return this.f32852l;
    }

    public final void setMConfirmStr(String str) {
        this.f32852l = str;
    }

    public final ICommonBottomListener getMListener() {
        return this.f32853m;
    }

    public final void setMListener(ICommonBottomListener iCommonBottomListener) {
        this.f32853m = iCommonBottomListener;
    }

    public final boolean isShowClose() {
        return this.f32854n;
    }

    public final void setShowClose(boolean z) {
        this.f32854n = z;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, 2132017496);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.layout_wallet_commom_bottom_dialog, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.tv_title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.tv_title)");
        this.f32841a = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_content);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.tv_content)");
        this.f32842b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.btn_cancel);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.btn_cancel)");
        this.f32843c = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.btn_confirm);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.btn_confirm)");
        this.f32844d = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.tv_large_cancel);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.tv_large_cancel)");
        this.f32845e = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.iv_close);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.iv_close)");
        this.f32846f = (ImageView) findViewById6;
        View findViewById7 = view.findViewById(R.id.cl_root);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.cl_root)");
        this.f32847g = (ConstraintLayout) findViewById7;
        TextView textView = this.f32841a;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
            textView = null;
        }
        String str = "";
        textView.setText(TextUtil.isEmpty(this.f32848h) ? str : this.f32848h);
        TextView textView3 = this.f32842b;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvContent");
            textView3 = null;
        }
        textView3.setText(TextUtil.isEmpty(this.f32849i) ? str : this.f32849i);
        TextView textView4 = this.f32843c;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnCancel");
            textView4 = null;
        }
        textView4.setText(TextUtil.isEmpty(this.f32850j) ? str : this.f32850j);
        TextView textView5 = this.f32844d;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnConfirm");
            textView5 = null;
        }
        textView5.setText(TextUtil.isEmpty(this.f32852l) ? str : this.f32852l);
        TextView textView6 = this.f32845e;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnLargeCancel");
            textView6 = null;
        }
        if (!TextUtil.isEmpty(this.f32851k)) {
            str = this.f32851k;
        }
        textView6.setText(str);
        ImageView imageView = this.f32846f;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivClose");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                WalletCommonBottomDialog.m23172a(WalletCommonBottomDialog.this, view);
            }
        });
        ImageView imageView2 = this.f32846f;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivClose");
            imageView2 = null;
        }
        int i = 0;
        imageView2.setVisibility(this.f32854n ? 0 : 8);
        TextView textView7 = this.f32842b;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvContent");
            textView7 = null;
        }
        textView7.setVisibility(TextUtil.isEmpty(this.f32849i) ? 8 : 0);
        TextView textView8 = this.f32845e;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnLargeCancel");
            textView8 = null;
        }
        textView8.setVisibility(TextUtil.isEmpty(this.f32851k) ? 8 : 0);
        boolean z = !TextUtil.isEmpty(this.f32850j);
        TextView textView9 = this.f32843c;
        if (textView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnCancel");
            textView9 = null;
        }
        if (!z) {
            i = 8;
        }
        textView9.setVisibility(i);
        if (!z) {
            TextView textView10 = this.f32844d;
            if (textView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnConfirm");
                textView10 = null;
            }
            ViewGroup.LayoutParams layoutParams = textView10.getLayoutParams();
            if (layoutParams != null) {
                ((ConstraintLayout.LayoutParams) layoutParams).leftMargin = UIUtils.dip2px(getContext(), 24.0f);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
        }
        TextView textView11 = this.f32843c;
        if (textView11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnCancel");
            textView11 = null;
        }
        textView11.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                WalletCommonBottomDialog.m23173b(WalletCommonBottomDialog.this, view);
            }
        });
        TextView textView12 = this.f32845e;
        if (textView12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnLargeCancel");
            textView12 = null;
        }
        textView12.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                WalletCommonBottomDialog.m23174c(WalletCommonBottomDialog.this, view);
            }
        });
        TextView textView13 = this.f32844d;
        if (textView13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnConfirm");
        } else {
            textView2 = textView13;
        }
        textView2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                WalletCommonBottomDialog.m23175d(WalletCommonBottomDialog.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m23172a(WalletCommonBottomDialog walletCommonBottomDialog, View view) {
        Intrinsics.checkNotNullParameter(walletCommonBottomDialog, "this$0");
        walletCommonBottomDialog.dismissAllowingStateLoss();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m23173b(WalletCommonBottomDialog walletCommonBottomDialog, View view) {
        Intrinsics.checkNotNullParameter(walletCommonBottomDialog, "this$0");
        walletCommonBottomDialog.dismissAllowingStateLoss();
        ICommonBottomListener mListener = walletCommonBottomDialog.getMListener();
        if (mListener != null) {
            Intrinsics.checkNotNullExpressionValue(view, "it");
            mListener.onCancelClick(view);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m23174c(WalletCommonBottomDialog walletCommonBottomDialog, View view) {
        Intrinsics.checkNotNullParameter(walletCommonBottomDialog, "this$0");
        walletCommonBottomDialog.dismissAllowingStateLoss();
        ICommonBottomListener mListener = walletCommonBottomDialog.getMListener();
        if (mListener != null) {
            Intrinsics.checkNotNullExpressionValue(view, "it");
            mListener.onCancelClick(view);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static final void m23175d(WalletCommonBottomDialog walletCommonBottomDialog, View view) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(walletCommonBottomDialog, "this$0");
        ICommonBottomListener mListener = walletCommonBottomDialog.getMListener();
        if (mListener == null) {
            bool = null;
        } else {
            Intrinsics.checkNotNullExpressionValue(view, "it");
            bool = mListener.onConfirmClick(view);
        }
        if (!Intrinsics.areEqual((Object) bool, (Object) false)) {
            walletCommonBottomDialog.dismissAllowingStateLoss();
        }
    }

    public final void setClickListener(ICommonBottomListener iCommonBottomListener) {
        Intrinsics.checkNotNullParameter(iCommonBottomListener, "listener");
        this.f32853m = iCommonBottomListener;
    }

    public final TextView getConfirmBtn() {
        TextView textView = this.f32844d;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("btnConfirm");
        return null;
    }

    public final ConstraintLayout getRootView() {
        ConstraintLayout constraintLayout = this.f32847g;
        if (constraintLayout != null) {
            return constraintLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("clRoot");
        return null;
    }

    public final TextView getCancelView() {
        TextView textView = this.f32843c;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("btnCancel");
        return null;
    }

    public final TextView getContentView() {
        TextView textView = this.f32842b;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvContent");
        return null;
    }

    public final TextView getTitleView() {
        TextView textView = this.f32841a;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("tvTitle");
        return null;
    }

    @Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\bJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/widget/WalletCommonBottomDialog$Builder;", "", "()V", "dialog", "Lcom/didi/payment/wallet/global/wallet/view/widget/WalletCommonBottomDialog;", "build", "setCancelStr", "str", "", "setClickListener", "listener", "Lcom/didi/payment/wallet/global/wallet/view/widget/ICommonBottomListener;", "setConfirmStr", "setContent", "content", "setLargeCancelStr", "setShowCloseBtn", "showClose", "", "setTitle", "title", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: WalletCommonBottomDialog.kt */
    public static final class Builder {
        private final WalletCommonBottomDialog dialog = new WalletCommonBottomDialog();

        public final Builder setTitle(String str) {
            Intrinsics.checkNotNullParameter(str, "title");
            this.dialog.setMTitle(str);
            return this;
        }

        public final Builder setContent(String str) {
            Intrinsics.checkNotNullParameter(str, "content");
            this.dialog.setMContent(str);
            return this;
        }

        public final Builder setCancelStr(String str) {
            Intrinsics.checkNotNullParameter(str, "str");
            this.dialog.setMCancelStr(str);
            return this;
        }

        public final Builder setLargeCancelStr(String str) {
            Intrinsics.checkNotNullParameter(str, "str");
            this.dialog.setMLargeCancelStr(str);
            return this;
        }

        public final Builder setConfirmStr(String str) {
            Intrinsics.checkNotNullParameter(str, "str");
            this.dialog.setMConfirmStr(str);
            return this;
        }

        public final Builder setClickListener(ICommonBottomListener iCommonBottomListener) {
            Intrinsics.checkNotNullParameter(iCommonBottomListener, "listener");
            this.dialog.setMListener(iCommonBottomListener);
            return this;
        }

        public final Builder setShowCloseBtn(boolean z) {
            this.dialog.setShowClose(z);
            return this;
        }

        public final WalletCommonBottomDialog build() {
            return this.dialog;
        }
    }
}
