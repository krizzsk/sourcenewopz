package com.didi.rfusion.widget.progress;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.didi.rfusion.widget.RFTextView;
import com.taxis99.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u000f\u001a\u00020\fJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\b\b\u0001\u0010\u0015\u001a\u00020\fJ\u0010\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/rfusion/widget/progress/RFProgress;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "pbProgress", "Landroid/widget/ProgressBar;", "progress", "", "tvText", "Lcom/didi/rfusion/widget/RFTextView;", "getProgress", "getTipsText", "", "initView", "", "setProgress", "value", "setTipsText", "text", "Companion", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: RFProgress.kt */
public final class RFProgress extends LinearLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int MAX_PROGRESS = 1000;

    /* renamed from: a */
    private ProgressBar f33652a;

    /* renamed from: b */
    private RFTextView f33653b;

    /* renamed from: c */
    private float f33654c;

    /* renamed from: d */
    private HashMap f33655d;

    public RFProgress(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public RFProgress(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.f33655d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f33655d == null) {
            this.f33655d = new HashMap();
        }
        View view = (View) this.f33655d.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f33655d.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RFProgress(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RFProgress(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        setOrientation(0);
        setGravity(16);
        m23709a();
    }

    /* renamed from: a */
    private final void m23709a() {
        LinearLayout.inflate(getContext(), R.layout.rf_progress, this);
        View findViewById = findViewById(R.id.rf_pb_progress);
        Intrinsics.checkExpressionValueIsNotNull(findViewById, "findViewById(R.id.rf_pb_progress)");
        this.f33652a = (ProgressBar) findViewById;
        View findViewById2 = findViewById(R.id.rf_tv_text);
        Intrinsics.checkExpressionValueIsNotNull(findViewById2, "findViewById(R.id.rf_tv_text)");
        this.f33653b = (RFTextView) findViewById2;
        ProgressBar progressBar = this.f33652a;
        if (progressBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pbProgress");
        }
        progressBar.setMax(1000);
        ProgressBar progressBar2 = this.f33652a;
        if (progressBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pbProgress");
        }
        progressBar2.setProgress(0);
    }

    public final void setProgress(float f) {
        if (f != this.f33654c) {
            ProgressBar progressBar = this.f33652a;
            if (progressBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pbProgress");
            }
            progressBar.setProgress(MathKt.roundToInt(((float) 1000) * f));
            this.f33654c = f;
        }
    }

    public final float getProgress() {
        return this.f33654c;
    }

    public final void setTipsText(CharSequence charSequence) {
        RFTextView rFTextView = this.f33653b;
        if (rFTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvText");
        }
        rFTextView.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
        RFTextView rFTextView2 = this.f33653b;
        if (rFTextView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvText");
        }
        rFTextView2.setText(charSequence);
    }

    public final CharSequence getTipsText() {
        RFTextView rFTextView = this.f33653b;
        if (rFTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvText");
        }
        return rFTextView.getText();
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/rfusion/widget/progress/RFProgress$Companion;", "", "()V", "MAX_PROGRESS", "", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: RFProgress.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
