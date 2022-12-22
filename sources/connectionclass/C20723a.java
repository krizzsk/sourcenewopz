package connectionclass;

/* renamed from: connectionclass.a */
/* compiled from: ExponentialGeometricAverage */
class C20723a {

    /* renamed from: a */
    private final double f56292a;

    /* renamed from: b */
    private final int f56293b;

    /* renamed from: c */
    private double f56294c = -1.0d;

    /* renamed from: d */
    private int f56295d;

    public C20723a(double d) {
        int i;
        this.f56292a = d;
        if (d == 0.0d) {
            i = Integer.MAX_VALUE;
        } else {
            i = (int) Math.ceil(1.0d / d);
        }
        this.f56293b = i;
    }

    /* renamed from: a */
    public void mo169164a(double d) {
        double d2 = 1.0d - this.f56292a;
        int i = this.f56295d;
        if (i > this.f56293b) {
            this.f56294c = Math.exp((d2 * Math.log(this.f56294c)) + (this.f56292a * Math.log(d)));
        } else if (i > 0) {
            double d3 = (d2 * ((double) i)) / (((double) i) + 1.0d);
            this.f56294c = Math.exp((d3 * Math.log(this.f56294c)) + ((1.0d - d3) * Math.log(d)));
        } else {
            this.f56294c = d;
        }
        this.f56295d++;
    }

    /* renamed from: a */
    public double mo169163a() {
        return this.f56294c;
    }

    /* renamed from: b */
    public void mo169165b() {
        this.f56294c = -1.0d;
        this.f56295d = 0;
    }
}
