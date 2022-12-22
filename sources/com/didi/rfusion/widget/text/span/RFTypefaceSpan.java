package com.didi.rfusion.widget.text.span;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.TypefaceSpan;
import com.didi.rfusion.utils.RFFontUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0002J\n\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0011H\u0016R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, mo175978d2 = {"Lcom/didi/rfusion/widget/text/span/RFTypefaceSpan;", "Landroid/text/style/TypefaceSpan;", "context", "Landroid/content/Context;", "fontType", "", "(Landroid/content/Context;I)V", "typeface", "Landroid/graphics/Typeface;", "kotlin.jvm.PlatformType", "applyRFTypeface", "", "paint", "Landroid/graphics/Paint;", "tf", "getTypeface", "updateDrawState", "Landroid/text/TextPaint;", "updateMeasureState", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: RFTypefaceSpan.kt */
public final class RFTypefaceSpan extends TypefaceSpan {

    /* renamed from: a */
    private final Typeface f33781a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RFTypefaceSpan(Context context, int i) {
        super("");
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.f33781a = RFFontUtils.getFontTypeFace(context, i);
    }

    public Typeface getTypeface() {
        return this.f33781a;
    }

    public void updateDrawState(TextPaint textPaint) {
        Intrinsics.checkParameterIsNotNull(textPaint, "paint");
        Typeface typeface = this.f33781a;
        Intrinsics.checkExpressionValueIsNotNull(typeface, "typeface");
        m23779a(textPaint, typeface);
    }

    public void updateMeasureState(TextPaint textPaint) {
        Intrinsics.checkParameterIsNotNull(textPaint, "paint");
        Typeface typeface = this.f33781a;
        Intrinsics.checkExpressionValueIsNotNull(typeface, "typeface");
        m23779a(textPaint, typeface);
    }

    /* renamed from: a */
    private final void m23779a(Paint paint, Typeface typeface) {
        paint.setTypeface(typeface);
    }
}
