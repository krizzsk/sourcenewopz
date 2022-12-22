package com.didi.payment.wallet.password;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/payment/wallet/password/TransparentActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "mIvClose", "Landroid/widget/ImageView;", "mTvContent", "Landroid/widget/TextView;", "mTvNeg", "mTvPos", "mTvTitle", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TransparentActivity.kt */
public final class TransparentActivity extends AppCompatActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static Function0<Unit> f32863f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static Function0<Unit> f32864g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public static Function0<Unit> f32865h;

    /* renamed from: a */
    private TextView f32866a;

    /* renamed from: b */
    private TextView f32867b;

    /* renamed from: c */
    private TextView f32868c;

    /* renamed from: d */
    private TextView f32869d;

    /* renamed from: e */
    private ImageView f32870e;

    @JvmStatic
    public static final void start(Context context, String str) {
        Companion.start(context, str);
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0007R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/payment/wallet/password/TransparentActivity$Companion;", "", "()V", "onCancel", "Lkotlin/Function0;", "", "getOnCancel", "()Lkotlin/jvm/functions/Function0;", "setOnCancel", "(Lkotlin/jvm/functions/Function0;)V", "onClose", "getOnClose", "setOnClose", "onTryAgain", "getOnTryAgain", "setOnTryAgain", "start", "context", "Landroid/content/Context;", "status", "", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: TransparentActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final void start(Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "status");
            Intent intent = new Intent(context, TransparentActivity.class);
            intent.putExtra("status", str);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        }

        public final Function0<Unit> getOnTryAgain() {
            return TransparentActivity.f32863f;
        }

        public final void setOnTryAgain(Function0<Unit> function0) {
            TransparentActivity.f32863f = function0;
        }

        public final Function0<Unit> getOnCancel() {
            return TransparentActivity.f32864g;
        }

        public final void setOnCancel(Function0<Unit> function0) {
            TransparentActivity.f32864g = function0;
        }

        public final Function0<Unit> getOnClose() {
            return TransparentActivity.f32865h;
        }

        public final void setOnClose(Function0<Unit> function0) {
            TransparentActivity.f32865h = function0;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        supportRequestWindowFeature(1);
        getWindow().addFlags(View.STATUS_BAR_TRANSIENT);
        setContentView((int) R.layout.activity_transparent);
        View findViewById = findViewById(16908290);
        if (findViewById != null) {
            View childAt = ((ViewGroup) findViewById).getChildAt(0);
            if (childAt != null) {
                ViewGroup viewGroup = (ViewGroup) childAt;
                viewGroup.setFitsSystemWindows(true);
                viewGroup.setClipToPadding(true);
                Window window = getWindow();
                Intrinsics.checkNotNullExpressionValue(window, "this.window");
                window.getDecorView().setPadding(0, 0, 0, 0);
                WindowManager.LayoutParams attributes = window.getAttributes();
                Intrinsics.checkNotNullExpressionValue(attributes, "win.attributes");
                attributes.width = -1;
                attributes.height = -1;
                attributes.gravity = 80;
                window.setAttributes(attributes);
                String stringExtra = getIntent().getStringExtra("status");
                View findViewById2 = findViewById(R.id.tv_pay_base_dialog_common_title);
                Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tv_pay_base_dialog_common_title)");
                this.f32866a = (TextView) findViewById2;
                View findViewById3 = findViewById(R.id.tv_pay_base_dialog_common_content);
                Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.tv_pay…se_dialog_common_content)");
                this.f32867b = (TextView) findViewById3;
                View findViewById4 = findViewById(R.id.tv_pay_base_dialog_common_pos);
                Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.tv_pay_base_dialog_common_pos)");
                this.f32868c = (TextView) findViewById4;
                View findViewById5 = findViewById(R.id.tv_pay_base_dialog_common_neg);
                Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.tv_pay_base_dialog_common_neg)");
                this.f32869d = (TextView) findViewById5;
                View findViewById6 = findViewById(R.id.iv_close);
                Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.iv_close)");
                ImageView imageView = (ImageView) findViewById6;
                this.f32870e = imageView;
                TextView textView = null;
                if (imageView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mIvClose");
                    imageView = null;
                }
                imageView.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        TransparentActivity.m23181a(TransparentActivity.this, view);
                    }
                });
                if (Intrinsics.areEqual((Object) stringExtra, (Object) "TIMES")) {
                    TextView textView2 = this.f32867b;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTvContent");
                        textView2 = null;
                    }
                    textView2.setVisibility(8);
                    TextView textView3 = this.f32866a;
                    if (textView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTvTitle");
                        textView3 = null;
                    }
                    textView3.setText(R.string.Finance_latour_Too_many_vWrH);
                    TextView textView4 = this.f32868c;
                    if (textView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTvPos");
                        textView4 = null;
                    }
                    textView4.setText(R.string.Finance_latour_I_see_CrYG);
                    TextView textView5 = this.f32869d;
                    if (textView5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTvNeg");
                        textView5 = null;
                    }
                    textView5.setText(R.string.Finance_latour_Contact_customer_guEw);
                    TextView textView6 = this.f32868c;
                    if (textView6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTvPos");
                        textView6 = null;
                    }
                    textView6.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            TransparentActivity.m23182b(TransparentActivity.this, view);
                        }
                    });
                    TextView textView7 = this.f32869d;
                    if (textView7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mTvNeg");
                    } else {
                        textView = textView7;
                    }
                    textView.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            TransparentActivity.m23183c(TransparentActivity.this, view);
                        }
                    });
                    return;
                }
                TextView textView8 = this.f32867b;
                if (textView8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTvContent");
                    textView8 = null;
                }
                textView8.setVisibility(0);
                TextView textView9 = this.f32866a;
                if (textView9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTvTitle");
                    textView9 = null;
                }
                textView9.setText(R.string.Finance_latour_Verification_failed_DFVj);
                TextView textView10 = this.f32867b;
                if (textView10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTvContent");
                    textView10 = null;
                }
                textView10.setText(R.string.Finance_latour_Aim_at_bQLw);
                TextView textView11 = this.f32868c;
                if (textView11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTvPos");
                    textView11 = null;
                }
                textView11.setText(R.string.Finance_latour_Try_again_hZrA);
                TextView textView12 = this.f32869d;
                if (textView12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTvNeg");
                    textView12 = null;
                }
                textView12.setText(R.string.Finance_latour_Contact_customer_aMcK);
                TextView textView13 = this.f32868c;
                if (textView13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTvPos");
                    textView13 = null;
                }
                textView13.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        TransparentActivity.m23184d(TransparentActivity.this, view);
                    }
                });
                TextView textView14 = this.f32869d;
                if (textView14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mTvNeg");
                } else {
                    textView = textView14;
                }
                textView.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        TransparentActivity.m23185e(TransparentActivity.this, view);
                    }
                });
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m23181a(TransparentActivity transparentActivity, View view) {
        Intrinsics.checkNotNullParameter(transparentActivity, "this$0");
        Function0<Unit> function0 = f32865h;
        if (function0 != null) {
            function0.invoke();
        }
        transparentActivity.finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m23182b(TransparentActivity transparentActivity, View view) {
        Intrinsics.checkNotNullParameter(transparentActivity, "this$0");
        Function0<Unit> function0 = f32863f;
        if (function0 != null) {
            function0.invoke();
        }
        transparentActivity.finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m23183c(TransparentActivity transparentActivity, View view) {
        Intrinsics.checkNotNullParameter(transparentActivity, "this$0");
        Function0<Unit> function0 = f32864g;
        if (function0 != null) {
            function0.invoke();
        }
        WebBrowserUtil.startInternalWebActivity(transparentActivity, "https://help.didiglobal.com/passenger-index-new.html?source=99pay&kfPageSource=99pay", "");
        transparentActivity.finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static final void m23184d(TransparentActivity transparentActivity, View view) {
        Intrinsics.checkNotNullParameter(transparentActivity, "this$0");
        Function0<Unit> function0 = f32863f;
        if (function0 != null) {
            function0.invoke();
        }
        transparentActivity.finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static final void m23185e(TransparentActivity transparentActivity, View view) {
        Intrinsics.checkNotNullParameter(transparentActivity, "this$0");
        Function0<Unit> function0 = f32864g;
        if (function0 != null) {
            function0.invoke();
        }
        WebBrowserUtil.startInternalWebActivity(transparentActivity, "https://help.didiglobal.com/passenger-index-new.html?source=99pay&kfPageSource=99pay", "");
        transparentActivity.finish();
    }
}
