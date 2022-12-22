package com.didi.sdk.global.indexbar.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.didi.passenger.C10448R;
import com.didi.sdk.global.indexbar.listener.OnSideBarTouchListener;
import com.didi.sdk.global.indexbar.utils.ViewUtil;
import java.util.List;
import rui.config.RConfigConstants;

@Deprecated
public class SideBar extends View {

    /* renamed from: a */
    private int f36184a;

    /* renamed from: b */
    private int f36185b;

    /* renamed from: c */
    private int f36186c;

    /* renamed from: d */
    private int f36187d;

    /* renamed from: e */
    private String[] f36188e;

    /* renamed from: f */
    private Context f36189f;

    /* renamed from: g */
    private float f36190g;

    /* renamed from: h */
    private float f36191h;

    /* renamed from: i */
    private float f36192i;

    /* renamed from: j */
    private int f36193j;

    /* renamed from: k */
    private int f36194k;

    /* renamed from: l */
    private TextPaint f36195l;

    /* renamed from: m */
    private List<String> f36196m;

    /* renamed from: n */
    private int f36197n;

    /* renamed from: o */
    private OnSideBarTouchListener f36198o;

    public SideBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public SideBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SideBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f36184a = (int) TypedValue.applyDimension(2, 12.0f, getResources().getDisplayMetrics());
        this.f36185b = -7829368;
        this.f36186c = 0;
        this.f36187d = 0;
        this.f36188e = new String[]{ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, "T", "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, C16471q.f49112a, C16471q.f49113b, "Z", RConfigConstants.KEYWORD_COLOR_SIGN};
        this.f36197n = -1;
        m25562a(context, attributeSet);
    }

    /* renamed from: a */
    private void m25562a(Context context, AttributeSet attributeSet) {
        this.f36189f = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.SideBar, 0, 0);
        for (int i = 0; i < obtainStyledAttributes.getIndexCount(); i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == 2) {
                this.f36184a = obtainStyledAttributes.getDimensionPixelSize(index, this.f36184a);
            } else if (index == 1) {
                this.f36185b = obtainStyledAttributes.getColor(index, this.f36185b);
            } else if (index == 0) {
                this.f36186c = obtainStyledAttributes.getColor(index, this.f36186c);
            } else if (index == 3) {
                this.f36187d = obtainStyledAttributes.getColor(index, this.f36187d);
            }
        }
        obtainStyledAttributes.recycle();
        TextPaint textPaint = new TextPaint();
        this.f36195l = textPaint;
        textPaint.setColor(this.f36185b);
        this.f36195l.setTextSize((float) this.f36184a);
        this.f36195l.setAntiAlias(true);
        setBackgroundColor(this.f36186c);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f36191h = (float) i;
        float f = (float) i2;
        String[] strArr = this.f36188e;
        float length = (1.0f * f) / ((float) strArr.length);
        this.f36192i = length;
        this.f36190g = (f - (length * ((float) strArr.length))) / 2.0f;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode2 == Integer.MIN_VALUE || mode == Integer.MIN_VALUE) {
            getMaxTextSize();
            if (mode2 == Integer.MIN_VALUE) {
                size2 = this.f36188e.length * (this.f36194k + ViewUtil.dip2px(this.f36189f, 5.0f));
            }
            if (mode == Integer.MIN_VALUE) {
                size = this.f36193j + ViewUtil.dip2px(this.f36189f, 5.0f);
            }
        }
        setMeasuredDimension(size, size2);
    }

    private void getMaxTextSize() {
        for (String str : this.f36188e) {
            this.f36193j = (int) Math.max((float) this.f36193j, this.f36195l.measureText(str));
            this.f36194k = Math.max(this.f36194k, ViewUtil.getTextHeight(this.f36195l, str));
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i = 0;
        while (true) {
            String[] strArr = this.f36188e;
            if (i < strArr.length) {
                String str = strArr[i];
                float f = this.f36190g;
                float f2 = this.f36192i;
                canvas.drawText(str, (this.f36191h - ((float) ViewUtil.getTextWidth(this.f36195l, str))) / 2.0f, f + (((float) i) * f2) + ((f2 + ((float) ViewUtil.getTextHeight(this.f36195l, str))) / 2.0f), this.f36195l);
                i++;
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        if (r0 != 3) goto L_0x008c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getAction()
            r1 = -1
            r2 = 1
            if (r0 == 0) goto L_0x0021
            if (r0 == r2) goto L_0x0012
            r3 = 2
            if (r0 == r3) goto L_0x0021
            r6 = 3
            if (r0 == r6) goto L_0x0012
            goto L_0x008c
        L_0x0012:
            r5.f36197n = r1
            int r6 = r5.f36186c
            r5.setBackgroundColor(r6)
            com.didi.sdk.global.indexbar.listener.OnSideBarTouchListener r6 = r5.f36198o
            if (r6 == 0) goto L_0x008c
            r6.onTouchEnd()
            goto L_0x008c
        L_0x0021:
            java.util.List<java.lang.String> r0 = r5.f36196m
            if (r0 == 0) goto L_0x008c
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x002c
            goto L_0x008c
        L_0x002c:
            float r0 = r6.getY()
            float r3 = r5.f36190g
            float r0 = r0 - r3
            float r3 = r5.f36192i
            float r0 = r0 / r3
            int r0 = (int) r0
            int r3 = r5.f36197n
            if (r0 != r3) goto L_0x003c
            return r2
        L_0x003c:
            int r6 = r6.getAction()
            if (r6 != 0) goto L_0x0047
            int r6 = r5.f36187d
            r5.setBackgroundColor(r6)
        L_0x0047:
            if (r0 < 0) goto L_0x008c
            java.lang.String[] r6 = r5.f36188e
            int r6 = r6.length
            if (r0 >= r6) goto L_0x008c
            r5.f36197n = r0
            com.didi.sdk.global.indexbar.listener.OnSideBarTouchListener r6 = r5.f36198o
            if (r6 == 0) goto L_0x008c
            r6 = 0
        L_0x0055:
            java.util.List<java.lang.String> r3 = r5.f36196m
            int r3 = r3.size()
            if (r6 >= r3) goto L_0x008c
            java.lang.String[] r3 = r5.f36188e
            r3 = r3[r0]
            java.util.List<java.lang.String> r4 = r5.f36196m
            java.lang.Object r4 = r4.get(r6)
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0077
            com.didi.sdk.global.indexbar.listener.OnSideBarTouchListener r1 = r5.f36198o
            java.lang.String[] r3 = r5.f36188e
            r0 = r3[r0]
            r1.onTouch(r0, r6)
            goto L_0x008c
        L_0x0077:
            java.util.List<java.lang.String> r3 = r5.f36196m
            int r3 = r3.size()
            int r3 = r3 - r2
            if (r6 != r3) goto L_0x0089
            com.didi.sdk.global.indexbar.listener.OnSideBarTouchListener r3 = r5.f36198o
            java.lang.String[] r4 = r5.f36188e
            r4 = r4[r0]
            r3.onTouch(r4, r1)
        L_0x0089:
            int r6 = r6 + 1
            goto L_0x0055
        L_0x008c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.global.indexbar.widget.SideBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setOnSideBarTouchListener(List<String> list, OnSideBarTouchListener onSideBarTouchListener) {
        this.f36196m = list;
        this.f36198o = onSideBarTouchListener;
    }
}
