package p093switch;

/* renamed from: switch.goto */
/* compiled from: RollingAverage */
public class C3122goto {

    /* renamed from: a */
    private final double[] f6951a;

    /* renamed from: b */
    private int f6952b = 0;

    public C3122goto(int i) {
        this.f6951a = new double[i];
    }

    /* renamed from: do */
    public synchronized void mo38624do(double d) {
        int i = this.f6952b;
        this.f6952b = i + 1;
        double[] dArr = this.f6951a;
        dArr[i % dArr.length] = d;
    }

    /* renamed from: do */
    public synchronized float mo38623do() {
        float f;
        f = 0.0f;
        for (double d : this.f6951a) {
            f = (float) (((double) f) + d);
        }
        return f / ((float) Math.min(this.f6952b, this.f6951a.length));
    }
}
