package com.didi.soda.home.topgun.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.didi.soda.customer.animation.CustomerInterpolator;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0002J\u0018\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000bH\u0002J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0018\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0019\u001a\u00020\u000bR\u001c\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00070\nX\u0004¢\u0006\u0002\n\u0000R$\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006 "}, mo175978d2 = {"Lcom/didi/soda/home/topgun/widget/ExpandTextView;", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cache", "", "", "value", "maxAnimWidth", "getMaxAnimWidth", "()I", "setMaxAnimWidth", "(I)V", "doAnimate", "", "oldText", "newText", "findMaxWidthFromFontType", "textView", "Landroid/widget/TextView;", "text", "measureExceptTextWidth", "waitMeasureText", "", "setTextWithAnim", "", "preText", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeFilterLayout.kt */
public final class ExpandTextView extends CustomerAppCompatTextView {

    /* renamed from: a */
    private final Map<String, Integer> f43045a;

    /* renamed from: b */
    private int f43046b;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ExpandTextView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ExpandTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ExpandTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExpandTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        setFontType(IToolsService.FontType.MEDIUM);
        this.f43045a = new LinkedHashMap();
        this.f43046b = -1;
    }

    public final int getMaxAnimWidth() {
        return this.f43046b;
    }

    public final void setMaxAnimWidth(int i) {
        this.f43046b = i;
        setMaxWidth(i);
    }

    public final boolean setTextWithAnim(String str, String str2) {
        Intrinsics.checkNotNullParameter(str2, "text");
        CharSequence charSequence = str;
        boolean z = true;
        if ((charSequence == null || charSequence.length() == 0) || TextUtils.equals(charSequence, str2)) {
            getLayoutParams().width = -2;
            setEllipsize(TextUtils.TruncateAt.END);
            requestLayout();
            z = false;
        } else {
            m30456a(str, str2);
        }
        setText(str2);
        return z;
    }

    /* renamed from: a */
    private final void m30456a(String str, String str2) {
        int a = m30454a(str);
        int a2 = m30454a(str2);
        int i = this.f43046b;
        if (a >= i) {
            a = i;
        }
        int i2 = this.f43046b;
        if (a2 >= i2) {
            setEllipsize(TextUtils.TruncateAt.END);
            a2 = i2;
        } else {
            setEllipsize((TextUtils.TruncateAt) null);
        }
        LogUtil.m29100d("ExpandTextView", " >>>>> begin width = " + a + " end width = " + a2);
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{a, a2});
        ofInt.setDuration(250);
        ofInt.setInterpolator(CustomerInterpolator.newInstance());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ExpandTextView.m30455a(ExpandTextView.this, valueAnimator);
            }
        });
        ofInt.start();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m30455a(ExpandTextView expandTextView, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(expandTextView, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        if (animatedValue != null) {
            expandTextView.getLayoutParams().width = ((Integer) animatedValue).intValue();
            expandTextView.requestLayout();
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }

    /* renamed from: a */
    private final int m30454a(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            return 0;
        }
        String obj = charSequence.toString();
        Integer num = this.f43045a.get(obj);
        if (num == null) {
            return m30453a((TextView) this, obj);
        }
        return num.intValue();
    }

    /* renamed from: a */
    private final int m30453a(TextView textView, String str) {
        List arrayList = new ArrayList();
        Typeface fontTypeFace = ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).getFontTypeFace(IToolsService.FontType.LIGHT);
        Intrinsics.checkNotNullExpressionValue(fontTypeFace, "getService(IToolsService…tTypeFace(FontType.LIGHT)");
        arrayList.add(fontTypeFace);
        Typeface fontTypeFace2 = ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).getFontTypeFace(IToolsService.FontType.MEDIUM);
        Intrinsics.checkNotNullExpressionValue(fontTypeFace2, "getService(IToolsService…TypeFace(FontType.MEDIUM)");
        arrayList.add(fontTypeFace2);
        int size = arrayList.size() - 1;
        int i = 0;
        if (size < 0) {
            return 0;
        }
        int i2 = 0;
        while (true) {
            int i3 = i + 1;
            TextPaint paint = textView.getPaint();
            Typeface typeface = paint.getTypeface();
            paint.setTypeface((Typeface) arrayList.get(i));
            i2 = Math.max((int) Math.ceil((double) paint.measureText(str)), i2);
            paint.setTypeface(typeface);
            if (i3 > size) {
                return i2;
            }
            i = i3;
        }
    }
}
