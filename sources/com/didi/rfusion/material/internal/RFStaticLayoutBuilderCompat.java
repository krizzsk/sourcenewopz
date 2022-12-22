package com.didi.rfusion.material.internal;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import java.lang.reflect.Constructor;

public class RFStaticLayoutBuilderCompat {

    /* renamed from: a */
    private static final String f33276a = "android.text.TextDirectionHeuristic";

    /* renamed from: b */
    private static final String f33277b = "android.text.TextDirectionHeuristics";

    /* renamed from: c */
    private static final String f33278c = "LTR";

    /* renamed from: d */
    private static final String f33279d = "RTL";

    /* renamed from: e */
    private static boolean f33280e;

    /* renamed from: f */
    private static Constructor<StaticLayout> f33281f;

    /* renamed from: g */
    private static Object f33282g;

    /* renamed from: h */
    private CharSequence f33283h;

    /* renamed from: i */
    private final TextPaint f33284i;

    /* renamed from: j */
    private final int f33285j;

    /* renamed from: k */
    private int f33286k = 0;

    /* renamed from: l */
    private int f33287l;

    /* renamed from: m */
    private Layout.Alignment f33288m;

    /* renamed from: n */
    private int f33289n;

    /* renamed from: o */
    private boolean f33290o;

    /* renamed from: p */
    private boolean f33291p;

    /* renamed from: q */
    private TextUtils.TruncateAt f33292q;

    private RFStaticLayoutBuilderCompat(CharSequence charSequence, TextPaint textPaint, int i) {
        this.f33283h = charSequence;
        this.f33284i = textPaint;
        this.f33285j = i;
        this.f33287l = charSequence.length();
        this.f33288m = Layout.Alignment.ALIGN_NORMAL;
        this.f33289n = Integer.MAX_VALUE;
        this.f33290o = true;
        this.f33292q = null;
    }

    public static RFStaticLayoutBuilderCompat obtain(CharSequence charSequence, TextPaint textPaint, int i) {
        return new RFStaticLayoutBuilderCompat(charSequence, textPaint, i);
    }

    public RFStaticLayoutBuilderCompat setAlignment(Layout.Alignment alignment) {
        this.f33288m = alignment;
        return this;
    }

    public RFStaticLayoutBuilderCompat setIncludePad(boolean z) {
        this.f33290o = z;
        return this;
    }

    public RFStaticLayoutBuilderCompat setStart(int i) {
        this.f33286k = i;
        return this;
    }

    public RFStaticLayoutBuilderCompat setEnd(int i) {
        this.f33287l = i;
        return this;
    }

    public RFStaticLayoutBuilderCompat setMaxLines(int i) {
        this.f33289n = i;
        return this;
    }

    public RFStaticLayoutBuilderCompat setEllipsize(TextUtils.TruncateAt truncateAt) {
        this.f33292q = truncateAt;
        return this;
    }

    public StaticLayout build() throws StaticLayoutBuilderCompatException {
        if (this.f33283h == null) {
            this.f33283h = "";
        }
        int max = Math.max(0, this.f33285j);
        CharSequence charSequence = this.f33283h;
        if (this.f33289n == 1) {
            charSequence = TextUtils.ellipsize(charSequence, this.f33284i, (float) max, this.f33292q);
        }
        this.f33287l = Math.min(charSequence.length(), this.f33287l);
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.f33291p && this.f33289n == 1) {
                this.f33288m = Layout.Alignment.ALIGN_OPPOSITE;
            }
            StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, this.f33286k, this.f33287l, this.f33284i, max);
            obtain.setAlignment(this.f33288m);
            obtain.setIncludePad(this.f33290o);
            obtain.setTextDirection(this.f33291p ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR);
            TextUtils.TruncateAt truncateAt = this.f33292q;
            if (truncateAt != null) {
                obtain.setEllipsize(truncateAt);
            }
            obtain.setMaxLines(this.f33289n);
            if (this.f33289n > 1) {
                obtain.setHyphenationFrequency(1);
            }
            return obtain.build();
        }
        m23410a();
        try {
            return (StaticLayout) ((Constructor) RFPreconditions.checkNotNull(f33281f)).newInstance(new Object[]{charSequence, Integer.valueOf(this.f33286k), Integer.valueOf(this.f33287l), this.f33284i, Integer.valueOf(max), this.f33288m, RFPreconditions.checkNotNull(f33282g), Float.valueOf(1.0f), Float.valueOf(0.0f), Boolean.valueOf(this.f33290o), null, Integer.valueOf(max), Integer.valueOf(this.f33289n)});
        } catch (Exception e) {
            throw new StaticLayoutBuilderCompatException(e);
        }
    }

    /* renamed from: a */
    private void m23410a() throws StaticLayoutBuilderCompatException {
        Class cls;
        if (!f33280e) {
            try {
                boolean z = this.f33291p && Build.VERSION.SDK_INT >= 23;
                if (Build.VERSION.SDK_INT >= 18) {
                    cls = TextDirectionHeuristic.class;
                    f33282g = z ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
                } else {
                    ClassLoader classLoader = RFStaticLayoutBuilderCompat.class.getClassLoader();
                    String str = this.f33291p ? f33279d : f33278c;
                    Class<?> loadClass = classLoader.loadClass(f33276a);
                    Class<?> loadClass2 = classLoader.loadClass(f33277b);
                    f33282g = loadClass2.getField(str).get(loadClass2);
                    cls = loadClass;
                }
                Constructor<StaticLayout> declaredConstructor = StaticLayout.class.getDeclaredConstructor(new Class[]{CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE, Layout.Alignment.class, cls, Float.TYPE, Float.TYPE, Boolean.TYPE, TextUtils.TruncateAt.class, Integer.TYPE, Integer.TYPE});
                f33281f = declaredConstructor;
                declaredConstructor.setAccessible(true);
                f33280e = true;
            } catch (Exception e) {
                throw new StaticLayoutBuilderCompatException(e);
            }
        }
    }

    public RFStaticLayoutBuilderCompat setIsRtl(boolean z) {
        this.f33291p = z;
        return this;
    }

    static class StaticLayoutBuilderCompatException extends Exception {
        StaticLayoutBuilderCompatException(Throwable th) {
            super("Error thrown initializing StaticLayout " + th.getMessage(), th);
        }
    }
}
