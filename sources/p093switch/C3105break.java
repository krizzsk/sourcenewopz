package p093switch;

import android.graphics.RectF;

/* renamed from: switch.break */
/* compiled from: SmootherRectF */
public class C3105break {

    /* renamed from: a */
    private final C3126this f6928a;

    /* renamed from: b */
    private final C3126this f6929b;

    /* renamed from: c */
    private final C3126this f6930c;

    /* renamed from: case  reason: not valid java name */
    public double f61695case;

    /* renamed from: d */
    private final C3126this f6931d;

    /* renamed from: else  reason: not valid java name */
    public double f61696else;

    /* renamed from: goto  reason: not valid java name */
    public double f61697goto;

    /* renamed from: try  reason: not valid java name */
    public double f61698try;

    public C3105break(double d) {
        this.f6928a = new C3126this(d);
        this.f6929b = new C3126this(d);
        this.f6930c = new C3126this(d);
        this.f6931d = new C3126this(d);
    }

    /* renamed from: do */
    public void mo38613do(RectF rectF) {
        this.f6928a.mo38627do(Double.valueOf(C3106case.m4003do(rectF.left)));
        this.f61698try = this.f6928a.mo38626do().doubleValue();
        this.f6929b.mo38627do(Double.valueOf(C3106case.m4003do(rectF.top)));
        this.f61695case = this.f6929b.mo38626do().doubleValue();
        this.f6930c.mo38627do(Double.valueOf(C3106case.m4003do(rectF.right)));
        this.f61696else = this.f6930c.mo38626do().doubleValue();
        this.f6931d.mo38627do(Double.valueOf(C3106case.m4003do(rectF.bottom)));
        this.f61697goto = this.f6931d.mo38626do().doubleValue();
    }

    /* renamed from: if */
    public RectF mo38614if() {
        return new RectF(C3106case.m4005do(this.f61698try), C3106case.m4005do(this.f61695case), C3106case.m4005do(this.f61696else), C3106case.m4005do(this.f61697goto));
    }

    /* renamed from: do */
    public void mo38612do() {
        this.f6928a.mo38628if();
        this.f6929b.mo38628if();
        this.f6930c.mo38628if();
        this.f6931d.mo38628if();
    }
}
