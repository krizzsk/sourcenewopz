package p093switch;

import java.util.Date;

/* renamed from: switch.this */
/* compiled from: Smoother */
public class C3126this {

    /* renamed from: a */
    private final double f6954a;

    /* renamed from: b */
    private Double f6955b;

    /* renamed from: c */
    private Double f6956c;

    /* renamed from: d */
    private Date f6957d;

    public C3126this(double d) {
        this.f6954a = d;
    }

    /* renamed from: do */
    public Double mo38627do(Double d) {
        if (this.f6957d == null) {
            m4042a(d.doubleValue(), d.doubleValue());
        } else {
            double time = (((double) (new Date().getTime() - this.f6957d.getTime())) / 1000.0d) / this.f6954a;
            double exp = Math.exp(-time);
            double d2 = (1.0d - exp) / time;
            m4042a((this.f6955b.doubleValue() * exp) + ((d2 - exp) * this.f6956c.doubleValue()) + ((1.0d - d2) * d.doubleValue()), d.doubleValue());
        }
        return this.f6955b;
    }

    /* renamed from: if */
    public void mo38628if() {
        this.f6955b = null;
        this.f6956c = null;
        this.f6957d = null;
    }

    /* renamed from: a */
    private void m4042a(double d, double d2) {
        this.f6955b = Double.valueOf(d);
        this.f6956c = Double.valueOf(d2);
        this.f6957d = new Date();
    }

    /* renamed from: do */
    public Double mo38626do() {
        return this.f6955b;
    }
}
