package com.didiglobal.pay.paysecure.p204ui.view;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.raven.config.RavenKey;
import com.didiglobal.pay.paysecure.PaySecure;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 %2\u00020\u00012\u00020\u0002:\u0001%B'\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0002J\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001aH\u0014J\u0010\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u001a2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\b\u0010$\u001a\u00020\u001aH\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016¨\u0006&"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/ui/view/CommonBottomDialog;", "Landroid/app/Dialog;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "type", "", "title", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "listener", "Lcom/didiglobal/pay/paysecure/ui/view/ConfirmDialogCallback;", "mCancelBtn", "Landroid/widget/TextView;", "mConfirmBtn", "mLlBtn", "Landroid/widget/LinearLayout;", "mSCancelBtn", "mSConfirmBtn", "mTvTitle", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getType", "setType", "dismiss", "", "init", "onClick", "v", "Landroid/view/View;", "onStart", "setCancelable", "flag", "", "show", "showDialog", "Companion", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* renamed from: com.didiglobal.pay.paysecure.ui.view.CommonBottomDialog */
/* compiled from: CommonBottomDialog.kt */
public final class CommonBottomDialog extends Dialog implements View.OnClickListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private TextView f50437a;

    /* renamed from: b */
    private TextView f50438b;

    /* renamed from: c */
    private TextView f50439c;

    /* renamed from: d */
    private TextView f50440d;

    /* renamed from: e */
    private LinearLayout f50441e;

    /* renamed from: f */
    private TextView f50442f;

    /* renamed from: g */
    private ConfirmDialogCallback f50443g;

    /* renamed from: h */
    private String f50444h;

    /* renamed from: i */
    private String f50445i;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CommonBottomDialog(Context context, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? DialogType.BIG_BTN.name() : str, (i & 4) != 0 ? "" : str2);
    }

    public final String getTitle() {
        return this.f50445i;
    }

    public final String getType() {
        return this.f50444h;
    }

    public final void setTitle(String str) {
        this.f50445i = str;
    }

    public final void setType(String str) {
        this.f50444h = str;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommonBottomDialog(Context context, String str, String str2) {
        super(context, R.style.CustomDialog);
        if (context == null) {
            Intrinsics.throwNpe();
        }
        this.f50444h = str;
        this.f50445i = str2;
        m36276b();
    }

    public final void show(ConfirmDialogCallback confirmDialogCallback) {
        this.f50443g = confirmDialogCallback;
        m36275a();
    }

    /* renamed from: a */
    private final void m36275a() {
        if (getContext() instanceof Activity) {
            Companion companion = Companion;
            Context context = getContext();
            if (context == null) {
                throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
            } else if (companion.isDestroyed((Activity) context)) {
                return;
            }
        }
        try {
            super.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setCancelable(boolean z) {
        super.setCancelable(z);
        setCanceledOnTouchOutside(z);
    }

    /* renamed from: b */
    private final void m36276b() {
        TextView textView;
        setContentView(R.layout.dialog_pay_secure_confirm);
        this.f50437a = (TextView) findViewById(R.id.btn_pay_secure_confirm);
        this.f50438b = (TextView) findViewById(R.id.btn_pay_secure_cancel);
        this.f50440d = (TextView) findViewById(R.id.tv_cancel);
        this.f50439c = (TextView) findViewById(R.id.tv_confirm);
        this.f50441e = (LinearLayout) findViewById(R.id.ll_small);
        this.f50442f = (TextView) findViewById(R.id.tv_title);
        if (!TextUtils.isEmpty(this.f50445i) && (textView = this.f50442f) != null) {
            textView.setText(this.f50445i);
        }
        String str = this.f50444h;
        if (Intrinsics.areEqual((Object) str, (Object) DialogType.BIG_BTN.name())) {
            LinearLayout linearLayout = this.f50441e;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            TextView textView2 = this.f50437a;
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            TextView textView3 = this.f50438b;
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
        } else if (Intrinsics.areEqual((Object) str, (Object) DialogType.SMALL_BTN.name())) {
            TextView textView4 = this.f50437a;
            if (textView4 != null) {
                textView4.setVisibility(8);
            }
            TextView textView5 = this.f50438b;
            if (textView5 != null) {
                textView5.setVisibility(8);
            }
            LinearLayout linearLayout2 = this.f50441e;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(0);
            }
        }
        TextView textView6 = this.f50437a;
        if (textView6 != null) {
            Context context = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context, "context");
            textView6.setBackground(ResourcesCompat.getDrawable(context.getResources(), PaySecure.INSTANCE.getConfig().getTheme().getPositiveBtnBg(), (Resources.Theme) null));
        }
        TextView textView7 = this.f50437a;
        if (textView7 != null) {
            Context context2 = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context2, "context");
            textView7.setTextColor(ResourcesCompat.getColor(context2.getResources(), PaySecure.INSTANCE.getConfig().getTheme().getPositiveBtnTextColor(), (Resources.Theme) null));
        }
        TextView textView8 = this.f50438b;
        if (textView8 != null) {
            Context context3 = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context3, "context");
            textView8.setBackground(ResourcesCompat.getDrawable(context3.getResources(), PaySecure.INSTANCE.getConfig().getTheme().getNegativeBtnBg(), (Resources.Theme) null));
        }
        TextView textView9 = this.f50438b;
        if (textView9 != null) {
            Context context4 = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context4, "context");
            textView9.setTextColor(ResourcesCompat.getColor(context4.getResources(), PaySecure.INSTANCE.getConfig().getTheme().getNegativeBtnTextColor(), (Resources.Theme) null));
        }
        TextView textView10 = this.f50439c;
        if (textView10 != null) {
            Context context5 = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context5, "context");
            textView10.setBackground(ResourcesCompat.getDrawable(context5.getResources(), PaySecure.INSTANCE.getConfig().getTheme().getPositiveBtnBg(), (Resources.Theme) null));
        }
        TextView textView11 = this.f50439c;
        if (textView11 != null) {
            Context context6 = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context6, "context");
            textView11.setTextColor(ResourcesCompat.getColor(context6.getResources(), PaySecure.INSTANCE.getConfig().getTheme().getPositiveBtnTextColor(), (Resources.Theme) null));
        }
        TextView textView12 = this.f50440d;
        if (textView12 != null) {
            Context context7 = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context7, "context");
            textView12.setBackground(ResourcesCompat.getDrawable(context7.getResources(), PaySecure.INSTANCE.getConfig().getTheme().getNegativeBtnBg(), (Resources.Theme) null));
        }
        TextView textView13 = this.f50440d;
        if (textView13 != null) {
            Context context8 = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context8, "context");
            textView13.setTextColor(ResourcesCompat.getColor(context8.getResources(), PaySecure.INSTANCE.getConfig().getTheme().getNegativeBtnTextColor(), (Resources.Theme) null));
        }
        TextView textView14 = this.f50437a;
        if (textView14 != null) {
            textView14.setOnClickListener(this);
        }
        TextView textView15 = this.f50438b;
        if (textView15 != null) {
            textView15.setOnClickListener(this);
        }
        TextView textView16 = this.f50439c;
        if (textView16 != null) {
            textView16.setOnClickListener(this);
        }
        TextView textView17 = this.f50440d;
        if (textView17 != null) {
            textView17.setOnClickListener(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        Window window = getWindow();
        if (window == null) {
            Intrinsics.throwNpe();
        }
        window.setLayout(-1, -2);
        Window window2 = getWindow();
        if (window2 == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(window2, "window!!");
        WindowManager.LayoutParams attributes = window2.getAttributes();
        attributes.gravity = 80;
        Window window3 = getWindow();
        if (window3 == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(window3, "window!!");
        window3.setAttributes(attributes);
    }

    public void onClick(View view) {
        ConfirmDialogCallback confirmDialogCallback;
        AutoTrackHelper.trackViewOnClick(view);
        Intrinsics.checkParameterIsNotNull(view, RavenKey.VERSION);
        if (this.f50443g == null) {
            dismiss();
        } else if (view.getId() == R.id.btn_pay_secure_confirm || view.getId() == R.id.tv_confirm) {
            ConfirmDialogCallback confirmDialogCallback2 = this.f50443g;
            if (confirmDialogCallback2 != null) {
                confirmDialogCallback2.onConfirmClicked(this);
            }
        } else if ((view.getId() == R.id.btn_pay_secure_cancel || view.getId() == R.id.tv_cancel) && (confirmDialogCallback = this.f50443g) != null) {
            confirmDialogCallback.onCancelClicked(this);
        }
    }

    public void dismiss() {
        try {
            super.dismiss();
        } catch (Exception unused) {
        }
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002¨\u0006\u0007"}, mo175978d2 = {"Lcom/didiglobal/pay/paysecure/ui/view/CommonBottomDialog$Companion;", "", "()V", "isDestroyed", "", "activity", "Landroid/app/Activity;", "paysecure_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* renamed from: com.didiglobal.pay.paysecure.ui.view.CommonBottomDialog$Companion */
    /* compiled from: CommonBottomDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final boolean isDestroyed(Activity activity) {
            if (Build.VERSION.SDK_INT < 17) {
                return activity.isFinishing();
            }
            return activity.isFinishing() || activity.isDestroyed();
        }
    }
}
