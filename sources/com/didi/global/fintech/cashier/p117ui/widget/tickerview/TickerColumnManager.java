package com.didi.global.fintech.cashier.p117ui.widget.tickerview;

import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* renamed from: com.didi.global.fintech.cashier.ui.widget.tickerview.TickerColumnManager */
public class TickerColumnManager {

    /* renamed from: a */
    final ArrayList<TickerColumn> f21985a = new ArrayList<>();

    /* renamed from: b */
    private final TickerDrawMetrics f21986b;

    /* renamed from: c */
    private TickerCharacterList[] f21987c;

    /* renamed from: d */
    private Set<Character> f21988d;

    TickerColumnManager(TickerDrawMetrics tickerDrawMetrics) {
        this.f21986b = tickerDrawMetrics;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66291a(String... strArr) {
        this.f21987c = new TickerCharacterList[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            this.f21987c[i] = new TickerCharacterList(strArr[i]);
        }
        this.f21988d = new HashSet();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            this.f21988d.addAll(this.f21987c[i2].mo66277a());
        }
        Iterator<TickerColumn> it = this.f21985a.iterator();
        while (it.hasNext()) {
            it.next().mo66283a(this.f21987c);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public TickerCharacterList[] mo66292a() {
        return this.f21987c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66290a(char[] cArr) {
        if (this.f21987c != null) {
            int i = 0;
            while (i < this.f21985a.size()) {
                if (this.f21985a.get(i).mo66285c() > 0.0f) {
                    i++;
                } else {
                    this.f21985a.remove(i);
                }
            }
            int[] computeColumnActions = LevenshteinUtils.computeColumnActions(mo66296e(), cArr, this.f21988d);
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < computeColumnActions.length; i4++) {
                int i5 = computeColumnActions[i4];
                if (i5 != 0) {
                    if (i5 == 1) {
                        this.f21985a.add(i2, new TickerColumn(this.f21987c, this.f21986b));
                    } else if (i5 == 2) {
                        this.f21985a.get(i2).mo66280a(0);
                        i2++;
                    } else {
                        throw new IllegalArgumentException("Unknown action: " + computeColumnActions[i4]);
                    }
                }
                this.f21985a.get(i2).mo66280a(cArr[i3]);
                i2++;
                i3++;
            }
            return;
        }
        throw new IllegalStateException("Need to call #setCharacterLists first.");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo66293b() {
        int size = this.f21985a.size();
        for (int i = 0; i < size; i++) {
            this.f21985a.get(i).mo66287e();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66288a(float f) {
        int size = this.f21985a.size();
        for (int i = 0; i < size; i++) {
            this.f21985a.get(i).mo66281a(f);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public float mo66294c() {
        int size = this.f21985a.size();
        float f = 0.0f;
        for (int i = 0; i < size; i++) {
            f += this.f21985a.get(i).mo66286d();
        }
        return f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public float mo66295d() {
        int size = this.f21985a.size();
        float f = 0.0f;
        for (int i = 0; i < size; i++) {
            f += this.f21985a.get(i).mo66285c();
        }
        return f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public char[] mo66296e() {
        int size = this.f21985a.size();
        char[] cArr = new char[size];
        for (int i = 0; i < size; i++) {
            cArr[i] = this.f21985a.get(i).mo66279a();
        }
        return cArr;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66289a(Canvas canvas, Paint paint) {
        int size = this.f21985a.size();
        for (int i = 0; i < size; i++) {
            TickerColumn tickerColumn = this.f21985a.get(i);
            tickerColumn.mo66282a(canvas, paint);
            canvas.translate(tickerColumn.mo66285c(), 0.0f);
        }
    }
}
