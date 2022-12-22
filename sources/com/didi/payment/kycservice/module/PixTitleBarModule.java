package com.didi.payment.kycservice.module;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.payment.commonsdk.utils.NViewUtils;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u0000 \u001e2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0002H\u0016J\u0006\u0010\u001a\u001a\u00020\u0012J\b\u0010\u001b\u001a\u00020\u0018H\u0002J\u000e\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u000eR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000¨\u0006\u001f"}, mo175978d2 = {"Lcom/didi/payment/kycservice/module/PixTitleBarModule;", "Lcom/didi/payment/kycservice/module/BaseModule;", "Lcom/didi/payment/kycservice/module/TitleBarData;", "pContext", "Landroid/content/Context;", "pViewStub", "Landroid/view/ViewStub;", "(Landroid/content/Context;Landroid/view/ViewStub;)V", "pParentView", "Landroid/view/ViewGroup;", "pResID", "", "(Landroid/content/Context;Landroid/view/ViewGroup;I)V", "backImgListener", "Landroid/view/View$OnClickListener;", "ivBack", "Landroid/view/View;", "toolbarContainer", "Landroid/widget/LinearLayout;", "tvMainTitle", "Landroid/widget/TextView;", "tvSubTitle", "tvTopTitle", "bindData", "", "data", "getToolBar", "initView", "setBackImgOnClickListener", "listener", "Companion", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixTitleBarModule.kt */
public final class PixTitleBarModule extends BaseModule<TitleBarData> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private LinearLayout f30901a;

    /* renamed from: b */
    private View f30902b;

    /* renamed from: c */
    private TextView f30903c;

    /* renamed from: d */
    private TextView f30904d;

    /* renamed from: e */
    private TextView f30905e;

    /* renamed from: f */
    private View.OnClickListener f30906f;

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/payment/kycservice/module/PixTitleBarModule$Companion;", "", "()V", "create", "Lcom/didi/payment/kycservice/module/PixTitleBarModule;", "pContext", "Landroid/content/Context;", "pParentView", "Landroid/view/ViewGroup;", "pViewStub", "Landroid/view/ViewStub;", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixTitleBarModule.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final PixTitleBarModule create(Context context, ViewStub viewStub) {
            Intrinsics.checkNotNullParameter(context, "pContext");
            Intrinsics.checkNotNullParameter(viewStub, "pViewStub");
            return new PixTitleBarModule(context, viewStub);
        }

        public final PixTitleBarModule create(Context context, ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(context, "pContext");
            Intrinsics.checkNotNullParameter(viewGroup, "pParentView");
            return new PixTitleBarModule(context, viewGroup, R.layout.kyc_module_title_bar_view);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PixTitleBarModule(Context context, ViewStub viewStub) {
        super(context, viewStub);
        Intrinsics.checkNotNullParameter(context, "pContext");
        Intrinsics.checkNotNullParameter(viewStub, "pViewStub");
        m21740a();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PixTitleBarModule(Context context, ViewGroup viewGroup, int i) {
        super(context, viewGroup, i);
        Intrinsics.checkNotNullParameter(context, "pContext");
        Intrinsics.checkNotNullParameter(viewGroup, "pParentView");
        m21740a();
    }

    /* renamed from: a */
    private final void m21740a() {
        View findViewById = getMRootView().findViewById(R.id.pix_toolbar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.pix_toolbar)");
        this.f30901a = (LinearLayout) findViewById;
        View findViewById2 = getMRootView().findViewById(R.id.pix_title_bar_left_back_iv);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R…x_title_bar_left_back_iv)");
        this.f30902b = findViewById2;
        View findViewById3 = getMRootView().findViewById(R.id.pix_title_bar_top_title);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R….pix_title_bar_top_title)");
        this.f30903c = (TextView) findViewById3;
        View findViewById4 = getMRootView().findViewById(R.id.pix_title_bar_main_title);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById(R…pix_title_bar_main_title)");
        this.f30904d = (TextView) findViewById4;
        View findViewById5 = getMRootView().findViewById(R.id.pix_title_bar_sub_title);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mRootView.findViewById(R….pix_title_bar_sub_title)");
        this.f30905e = (TextView) findViewById5;
        View view = this.f30902b;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivBack");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PixTitleBarModule.m21741a(PixTitleBarModule.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21741a(PixTitleBarModule pixTitleBarModule, View view) {
        Intrinsics.checkNotNullParameter(pixTitleBarModule, "this$0");
        View.OnClickListener onClickListener = pixTitleBarModule.f30906f;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    public final PixTitleBarModule setBackImgOnClickListener(View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "listener");
        this.f30906f = onClickListener;
        return this;
    }

    public void bindData(TitleBarData titleBarData) {
        Intrinsics.checkNotNullParameter(titleBarData, "data");
        NViewUtils nViewUtils = NViewUtils.INSTANCE;
        TextView textView = this.f30903c;
        View view = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvTopTitle");
            textView = null;
        }
        nViewUtils.setText(textView, titleBarData.getTopTitleTxt());
        NViewUtils nViewUtils2 = NViewUtils.INSTANCE;
        TextView textView2 = this.f30904d;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvMainTitle");
            textView2 = null;
        }
        nViewUtils2.setText(textView2, titleBarData.getMainTitleTxt());
        NViewUtils nViewUtils3 = NViewUtils.INSTANCE;
        TextView textView3 = this.f30905e;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvSubTitle");
            textView3 = null;
        }
        nViewUtils3.setText(textView3, titleBarData.getSubTitleTxt());
        if (titleBarData.isHideBack()) {
            View view2 = this.f30902b;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivBack");
            } else {
                view = view2;
            }
            view.setVisibility(8);
            return;
        }
        View view3 = this.f30902b;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivBack");
        } else {
            view = view3;
        }
        view.setVisibility(0);
    }

    public final LinearLayout getToolBar() {
        LinearLayout linearLayout = this.f30901a;
        if (linearLayout != null) {
            return linearLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("toolbarContainer");
        return null;
    }
}
