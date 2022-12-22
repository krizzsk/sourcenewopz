package com.didi.global.fintech.cashier.p117ui.widget.tickerview;

import android.graphics.Paint;
import com.didi.global.fintech.cashier.p117ui.widget.tickerview.TickerView;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.global.fintech.cashier.ui.widget.tickerview.TickerDrawMetrics */
public class TickerDrawMetrics {

    /* renamed from: a */
    private final Paint f21989a;

    /* renamed from: b */
    private final Map<Character, Float> f21990b = new HashMap(256);

    /* renamed from: c */
    private float f21991c;

    /* renamed from: d */
    private float f21992d;

    /* renamed from: e */
    private TickerView.ScrollingDirection f21993e = TickerView.ScrollingDirection.ANY;

    TickerDrawMetrics(Paint paint) {
        this.f21989a = paint;
        mo66298a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66298a() {
        this.f21990b.clear();
        Paint.FontMetrics fontMetrics = this.f21989a.getFontMetrics();
        this.f21991c = fontMetrics.bottom - fontMetrics.top;
        this.f21992d = -fontMetrics.top;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public float mo66297a(char c) {
        if (c == 0) {
            return 0.0f;
        }
        Float f = this.f21990b.get(Character.valueOf(c));
        if (f != null) {
            return f.floatValue();
        }
        float measureText = this.f21989a.measureText(Character.toString(c));
        this.f21990b.put(Character.valueOf(c), Float.valueOf(measureText));
        return measureText;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public float mo66300b() {
        return this.f21991c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public float mo66301c() {
        return this.f21992d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public TickerView.ScrollingDirection mo66302d() {
        return this.f21993e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66299a(TickerView.ScrollingDirection scrollingDirection) {
        this.f21993e = scrollingDirection;
    }
}
