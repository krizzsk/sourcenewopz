package com.cardinalcommerce.p060a;

import com.cardinalcommerce.p060a.setPersistentDrawingCache;
import java.io.IOException;
import kotlin.text.Typography;
import org.osgi.framework.VersionRange;

/* renamed from: com.cardinalcommerce.a.setLayoutAnimation */
public final class setLayoutAnimation {
    public static final setLayoutAnimation init = new setLayoutAnimation(0);

    /* renamed from: a */
    setPersistentDrawingCache.cleanup f2840a;

    /* renamed from: b */
    private boolean f2841b;

    /* renamed from: c */
    private boolean f2842c;

    /* renamed from: d */
    private boolean f2843d;

    /* renamed from: e */
    private boolean f2844e;

    /* renamed from: f */
    private setPersistentDrawingCache.values f2845f;

    /* renamed from: g */
    private setPersistentDrawingCache.values f2846g;

    static {
        new setLayoutAnimation(-1);
        new setLayoutAnimation(2);
    }

    private setLayoutAnimation(int i) {
        setPersistentDrawingCache.values values;
        boolean z = false;
        this.f2841b = (i & 1) == 0;
        this.f2843d = (i & 4) == 0;
        this.f2842c = (i & 2) == 0;
        this.f2844e = (i & 16) > 0 ? true : z;
        if ((i & 8) > 0) {
            values = setPersistentDrawingCache.f2916c;
        } else {
            values = setPersistentDrawingCache.f2914a;
        }
        if (this.f2843d) {
            this.f2846g = setPersistentDrawingCache.f2915b;
        } else {
            this.f2846g = values;
        }
        if (this.f2841b) {
            this.f2845f = setPersistentDrawingCache.f2915b;
        } else {
            this.f2845f = values;
        }
        if (this.f2842c) {
            this.f2840a = setPersistentDrawingCache.f2918e;
        } else {
            this.f2840a = setPersistentDrawingCache.f2917d;
        }
    }

    public setLayoutAnimation() {
        this(0);
    }

    public final boolean cca_continue() {
        return this.f2844e;
    }

    public final boolean Cardinal(String str) {
        return this.f2845f.Cardinal(str);
    }

    /* renamed from: a */
    private boolean m2031a(String str) {
        return this.f2846g.Cardinal(str);
    }

    public final void Cardinal(Appendable appendable, String str) throws IOException {
        if (!m2031a(str)) {
            appendable.append(str);
            return;
        }
        appendable.append(Typography.quote);
        setAddStatesFromChildren.configure(str, appendable, this);
        appendable.append(Typography.quote);
    }

    public static void getInstance(Appendable appendable) throws IOException {
        appendable.append('{');
    }

    public static void cca_continue(Appendable appendable) throws IOException {
        appendable.append('}');
    }

    public static void Cardinal(Appendable appendable) throws IOException {
        appendable.append(',');
    }

    public static void configure(Appendable appendable) throws IOException {
        appendable.append(':');
    }

    public static void init(Appendable appendable) throws IOException {
        appendable.append(VersionRange.LEFT_CLOSED);
    }

    public static void CardinalError(Appendable appendable) throws IOException {
        appendable.append(VersionRange.RIGHT_CLOSED);
    }

    public static void values(Appendable appendable) throws IOException {
        appendable.append(',');
    }
}
