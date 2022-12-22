package com.didi.hawaii.p118ar.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.didi.passenger.C10448R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.hawaii.ar.view.AlignTextView */
public class AlignTextView extends AppCompatTextView {

    /* renamed from: a */
    private float f23374a;

    /* renamed from: b */
    private float f23375b = 0.0f;

    /* renamed from: c */
    private int f23376c;

    /* renamed from: d */
    private List<String> f23377d = new ArrayList();

    /* renamed from: e */
    private List<Integer> f23378e = new ArrayList();

    /* renamed from: f */
    private Align f23379f = Align.ALIGN_LEFT;

    /* renamed from: g */
    private boolean f23380g = true;

    /* renamed from: h */
    private float f23381h = 1.0f;

    /* renamed from: i */
    private float f23382i = 0.0f;

    /* renamed from: j */
    private int f23383j = 0;

    /* renamed from: k */
    private int f23384k = 0;

    /* renamed from: l */
    private int f23385l = 0;

    /* renamed from: m */
    private boolean f23386m = false;

    /* renamed from: com.didi.hawaii.ar.view.AlignTextView$Align */
    public enum Align {
        ALIGN_LEFT,
        ALIGN_CENTER,
        ALIGN_RIGHT
    }

    public AlignTextView(Context context) {
        super(context);
        setTextIsSelectable(false);
    }

    public AlignTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setTextIsSelectable(false);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16843287, 16843288});
        this.f23382i = (float) obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f23381h = obtainStyledAttributes.getFloat(1, 1.0f);
        this.f23385l = getPaddingBottom();
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, C10448R.styleable.AlignTextView);
        int i = obtainStyledAttributes2.getInt(0, 0);
        if (i == 1) {
            this.f23379f = Align.ALIGN_CENTER;
        } else if (i != 2) {
            this.f23379f = Align.ALIGN_LEFT;
        } else {
            this.f23379f = Align.ALIGN_RIGHT;
        }
        obtainStyledAttributes2.recycle();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int measuredWidth = getMeasuredWidth();
        this.f23376c = measuredWidth;
        if (measuredWidth > 0 && this.f23380g) {
            String charSequence = getText().toString();
            TextPaint paint = getPaint();
            this.f23377d.clear();
            this.f23378e.clear();
            for (String a : charSequence.split("\\n")) {
                m16726a(paint, a);
            }
            m16727a(charSequence, paint.getTextSize(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
            float f = (((float) this.f23383j) * 1.0f) / ((float) this.f23384k);
            this.f23374a = f;
            float f2 = ((this.f23381h - 1.0f) * f) + this.f23382i;
            this.f23375b = f2;
            int size = (int) ((f2 + f) * ((float) (this.f23377d.size() - this.f23384k)));
            this.f23386m = true;
            setPadding(getPaddingLeft(), getPaddingTop(), getPaddingRight(), this.f23385l + size);
            this.f23380g = false;
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x00a6, code lost:
        if (r0.f23379f == com.didi.hawaii.p118ar.view.AlignTextView.Align.ALIGN_RIGHT) goto L_0x00a0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onDraw(android.graphics.Canvas r17) {
        /*
            r16 = this;
            r0 = r16
            int r1 = r16.getMeasuredWidth()
            r0.f23376c = r1
            if (r1 > 0) goto L_0x000b
            return
        L_0x000b:
            android.text.TextPaint r1 = r16.getPaint()
            int r2 = r16.getCurrentTextColor()
            r1.setColor(r2)
            int[] r2 = r16.getDrawableState()
            r1.drawableState = r2
            android.graphics.Paint$FontMetrics r2 = r1.getFontMetrics()
            float r3 = r16.getTextSize()
            float r4 = r2.bottom
            float r5 = r2.descent
            float r4 = r4 - r5
            float r5 = r2.ascent
            float r4 = r4 + r5
            float r2 = r2.top
            float r4 = r4 - r2
            float r3 = r3 - r4
            int r2 = r16.getGravity()
            r2 = r2 & 4096(0x1000, float:5.74E-42)
            r4 = 1073741824(0x40000000, float:2.0)
            if (r2 != 0) goto L_0x003f
            float r2 = r0.f23374a
            float r2 = r2 - r3
            float r2 = r2 / r4
            float r3 = r3 + r2
        L_0x003f:
            int r2 = r16.getPaddingTop()
            int r5 = r16.getPaddingLeft()
            int r6 = r16.getPaddingRight()
            int r7 = r0.f23376c
            int r7 = r7 - r5
            int r7 = r7 - r6
            r0.f23376c = r7
            java.util.List<java.lang.String> r6 = r0.f23377d
            int r6 = r6.size()
            r7 = 1
            if (r6 != r7) goto L_0x005f
            com.didi.hawaii.ar.view.AlignTextView$Align r6 = com.didi.hawaii.p118ar.view.AlignTextView.Align.ALIGN_CENTER
            r0.f23379f = r6
            goto L_0x0063
        L_0x005f:
            com.didi.hawaii.ar.view.AlignTextView$Align r6 = com.didi.hawaii.p118ar.view.AlignTextView.Align.ALIGN_LEFT
            r0.f23379f = r6
        L_0x0063:
            r6 = 0
            r8 = 0
        L_0x0065:
            java.util.List<java.lang.String> r9 = r0.f23377d
            int r9 = r9.size()
            if (r8 >= r9) goto L_0x00dd
            float r9 = (float) r8
            float r10 = r0.f23374a
            float r10 = r10 * r9
            float r10 = r10 + r3
            java.util.List<java.lang.String> r11 = r0.f23377d
            java.lang.Object r11 = r11.get(r8)
            java.lang.String r11 = (java.lang.String) r11
            float r12 = (float) r5
            int r13 = r0.f23376c
            float r13 = (float) r13
            float r14 = r1.measureText(r11)
            float r13 = r13 - r14
            int r14 = r11.length()
            int r14 = r14 - r7
            float r14 = (float) r14
            float r14 = r13 / r14
            java.util.List<java.lang.Integer> r15 = r0.f23378e
            java.lang.Integer r7 = java.lang.Integer.valueOf(r8)
            boolean r7 = r15.contains(r7)
            if (r7 == 0) goto L_0x00a9
            r14 = 0
            com.didi.hawaii.ar.view.AlignTextView$Align r7 = r0.f23379f
            com.didi.hawaii.ar.view.AlignTextView$Align r15 = com.didi.hawaii.p118ar.view.AlignTextView.Align.ALIGN_CENTER
            if (r7 != r15) goto L_0x00a2
            float r13 = r13 / r4
        L_0x00a0:
            float r12 = r12 + r13
            goto L_0x00a9
        L_0x00a2:
            com.didi.hawaii.ar.view.AlignTextView$Align r7 = r0.f23379f
            com.didi.hawaii.ar.view.AlignTextView$Align r15 = com.didi.hawaii.p118ar.view.AlignTextView.Align.ALIGN_RIGHT
            if (r7 != r15) goto L_0x00a9
            goto L_0x00a0
        L_0x00a9:
            r7 = 0
        L_0x00aa:
            int r13 = r11.length()
            if (r7 >= r13) goto L_0x00d4
            java.lang.String r13 = r11.substring(r6, r7)
            float r13 = r1.measureText(r13)
            float r15 = (float) r7
            float r15 = r15 * r14
            float r13 = r13 + r15
            int r15 = r7 + 1
            java.lang.String r7 = r11.substring(r7, r15)
            float r13 = r13 + r12
            float r4 = (float) r2
            float r4 = r4 + r10
            float r6 = r0.f23375b
            float r6 = r6 * r9
            float r4 = r4 + r6
            r6 = r17
            r6.drawText(r7, r13, r4, r1)
            r7 = r15
            r4 = 1073741824(0x40000000, float:2.0)
            r6 = 0
            goto L_0x00aa
        L_0x00d4:
            r6 = r17
            int r8 = r8 + 1
            r4 = 1073741824(0x40000000, float:2.0)
            r6 = 0
            r7 = 1
            goto L_0x0065
        L_0x00dd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.p118ar.view.AlignTextView.onDraw(android.graphics.Canvas):void");
    }

    public void setAlign(Align align) {
        this.f23379f = align;
        invalidate();
    }

    /* renamed from: a */
    private void m16726a(Paint paint, String str) {
        if (str.length() == 0) {
            this.f23377d.add("\n");
            return;
        }
        int measureText = (int) (((float) this.f23376c) / paint.measureText("中"));
        if (paint.measureText(str) > ((float) this.f23376c) && measureText > 0) {
            measureText--;
        }
        int i = measureText + 1;
        int i2 = 0;
        StringBuilder sb = new StringBuilder(str.substring(0, Math.min(i, str.length())));
        while (true) {
            if (i >= str.length()) {
                break;
            }
            if (paint.measureText(str.substring(i2, i + 1)) > ((float) this.f23376c)) {
                this.f23377d.add(sb.toString());
                sb = new StringBuilder();
                if (str.length() - i <= measureText) {
                    this.f23377d.add(str.substring(i));
                    break;
                }
                int i3 = i + measureText;
                sb.append(str.substring(i, i3));
                i2 = i;
                i = i3 - 1;
            } else {
                sb.append(str.charAt(i));
            }
            i++;
        }
        if (sb.length() > 0) {
            this.f23377d.add(sb.toString());
        }
        this.f23378e.add(Integer.valueOf(this.f23377d.size() - 1));
    }

    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.f23380g = true;
        super.setText(charSequence, bufferType);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (!this.f23386m) {
            this.f23385l = i4;
        }
        this.f23386m = false;
        super.setPadding(i, i2, i3, i4);
    }

    /* renamed from: a */
    private void m16727a(String str, float f, int i) {
        TextView textView = new TextView(getContext());
        textView.setText(str);
        textView.setTextSize(0, f);
        textView.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
        this.f23384k = textView.getLineCount();
        this.f23383j = textView.getMeasuredHeight();
    }
}
