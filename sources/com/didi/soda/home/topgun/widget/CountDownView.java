package com.didi.soda.home.topgun.widget;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.taxis99.R;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0015\u001a\u00020\u000fJ\b\u0010\u0016\u001a\u00020\fH\u0002J\b\u0010\u0017\u001a\u00020\u0007H\u0014J\b\u0010\u0018\u001a\u00020\u000fH\u0002J\u0010\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\nH\u0002J\u0014\u0010\u001b\u001a\u00020\u000f2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eJ\u000e\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\nR\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/widget/CountDownView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mCount", "", "mCountDownTimer", "Landroid/os/CountDownTimer;", "mCountTimeoutListener", "Lkotlin/Function0;", "", "mRemianTime", "mTvHour", "Lcom/didi/soda/home/topgun/widget/MidLineTextView;", "mTvMin", "mTvSecond", "cancel", "getCountDownTimer", "getResId", "initView", "setTime2Text", "remainTime", "setTimeoutCallBack", "countTimeoutListener", "start", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CountDownView.kt */
public final class CountDownView extends RelativeLayout {

    /* renamed from: a */
    private MidLineTextView f43038a;

    /* renamed from: b */
    private MidLineTextView f43039b;

    /* renamed from: c */
    private MidLineTextView f43040c;

    /* renamed from: d */
    private long f43041d;

    /* renamed from: e */
    private final long f43042e;

    /* renamed from: f */
    private CountDownTimer f43043f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Function0<Unit> f43044g;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CountDownView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CountDownView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* access modifiers changed from: protected */
    public int getResId() {
        return R.layout.layout_widget_count_down;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CountDownView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CountDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f43042e = 1000;
        m30452a();
    }

    /* renamed from: a */
    private final void m30452a() {
        View inflate = LayoutInflater.from(getContext()).inflate(getResId(), this, true);
        View findViewById = inflate.findViewById(R.id.customer_home_tv_hour);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_home_tv_hour)");
        this.f43038a = (MidLineTextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_home_tv_min);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_home_tv_min)");
        this.f43039b = (MidLineTextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.customer_home_tv_second);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.customer_home_tv_second)");
        this.f43040c = (MidLineTextView) findViewById3;
    }

    public final void start(long j) {
        if (j <= 0) {
            setTime2Text(0);
            return;
        }
        this.f43041d = j;
        getCountDownTimer().start();
    }

    public final void cancel() {
        CountDownTimer countDownTimer = this.f43043f;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f43043f = null;
            this.f43044g = null;
        }
    }

    public final void setTimeoutCallBack(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "countTimeoutListener");
        this.f43044g = function0;
    }

    private final CountDownTimer getCountDownTimer() {
        if (this.f43043f == null) {
            this.f43043f = new CountDownView$getCountDownTimer$1(this, this.f43041d, this.f43042e);
        }
        CountDownTimer countDownTimer = this.f43043f;
        if (countDownTimer != null) {
            return countDownTimer;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.os.CountDownTimer");
    }

    /* access modifiers changed from: private */
    public final void setTime2Text(long j) {
        long j2 = (long) 3600000;
        long j3 = j / j2;
        long j4 = j - (j2 * j3);
        long j5 = (long) 60000;
        long j6 = j4 / j5;
        long j7 = (j4 - (j5 * j6)) / ((long) 1000);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Long.valueOf(j3)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String format2 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Long.valueOf(j6)}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(format, *args)");
        StringCompanionObject stringCompanionObject3 = StringCompanionObject.INSTANCE;
        String format3 = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Long.valueOf(j7)}, 1));
        Intrinsics.checkNotNullExpressionValue(format3, "java.lang.String.format(format, *args)");
        MidLineTextView midLineTextView = null;
        if (Integer.parseInt(format) >= 100) {
            MidLineTextView midLineTextView2 = this.f43038a;
            if (midLineTextView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvHour");
                midLineTextView2 = null;
            }
            midLineTextView2.setText("99");
            MidLineTextView midLineTextView3 = this.f43039b;
            if (midLineTextView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvMin");
                midLineTextView3 = null;
            }
            midLineTextView3.setText(DiFaceLogger.EVENT_ID_COMPARE_FAILED_EXIT_CLICKED);
            MidLineTextView midLineTextView4 = this.f43040c;
            if (midLineTextView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTvSecond");
            } else {
                midLineTextView = midLineTextView4;
            }
            midLineTextView.setText(DiFaceLogger.EVENT_ID_COMPARE_FAILED_EXIT_CLICKED);
            return;
        }
        MidLineTextView midLineTextView5 = this.f43038a;
        if (midLineTextView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvHour");
            midLineTextView5 = null;
        }
        midLineTextView5.setText(format);
        MidLineTextView midLineTextView6 = this.f43039b;
        if (midLineTextView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvMin");
            midLineTextView6 = null;
        }
        midLineTextView6.setText(format2);
        MidLineTextView midLineTextView7 = this.f43040c;
        if (midLineTextView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTvSecond");
        } else {
            midLineTextView = midLineTextView7;
        }
        midLineTextView.setText(format3);
    }
}
