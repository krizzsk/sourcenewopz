package p093switch;

import org.osgi.framework.VersionRange;

/* renamed from: switch.while */
/* compiled from: VectorMatrix */
public class C3130while {

    /* renamed from: a */
    private final int f6962a;

    /* renamed from: b */
    private double[] f6963b;

    public C3130while(int i) {
        this.f6962a = i;
        this.f6963b = new double[i];
    }

    /* renamed from: do */
    public int mo38630do() {
        return this.f6962a;
    }

    /* renamed from: for  reason: not valid java name */
    public C3130while m46205for(C3130while whileR) {
        if (mo38630do() == whileR.mo38630do()) {
            C3130while whileR2 = new C3130while(this.f6962a);
            for (int i = 0; i < this.f6962a; i++) {
                whileR2.f6963b[i] = Math.min(whileR.f6963b[i], this.f6963b[i]);
            }
            return whileR2;
        }
        throw new IllegalArgumentException("dimensions disagree");
    }

    /* renamed from: if */
    public double mo38634if() {
        double d = 0.0d;
        for (int i = 0; i < this.f6962a; i++) {
            double[] dArr = this.f6963b;
            d += dArr[i] * dArr[i];
        }
        return Math.sqrt(d);
    }

    /* renamed from: new  reason: not valid java name */
    public C3130while m46206new(C3130while whileR) {
        if (mo38630do() == whileR.mo38630do()) {
            C3130while whileR2 = new C3130while(this.f6962a);
            for (int i = 0; i < this.f6962a; i++) {
                whileR2.f6963b[i] = this.f6963b[i] - whileR.f6963b[i];
            }
            return whileR2;
        }
        throw new IllegalArgumentException("dimensions disagree");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(VersionRange.LEFT_OPEN);
        for (int i = 0; i < this.f6962a; i++) {
            sb.append(this.f6963b[i]);
            if (i < this.f6962a - 1) {
                sb.append(", ");
            }
        }
        sb.append(VersionRange.RIGHT_OPEN);
        return sb.toString();
    }

    /* renamed from: try  reason: not valid java name */
    public C3130while m46207try(C3130while whileR) {
        if (mo38630do() == whileR.mo38630do()) {
            C3130while whileR2 = new C3130while(this.f6962a);
            for (int i = 0; i < this.f6962a; i++) {
                whileR2.f6963b[i] = whileR.f6963b[i] * this.f6963b[i];
            }
            return whileR2;
        }
        throw new IllegalArgumentException("dimensions disagree");
    }

    /* renamed from: do */
    public double mo38629do(C3130while whileR) {
        if (mo38630do() == whileR.mo38630do()) {
            double d = 0.0d;
            for (int i = 0; i < this.f6962a; i++) {
                d += this.f6963b[i] * whileR.f6963b[i];
            }
            return d;
        }
        throw new IllegalArgumentException("dimensions disagree");
    }

    public C3130while(double... dArr) {
        int length = dArr.length;
        this.f6962a = length;
        this.f6963b = new double[length];
        for (int i = 0; i < this.f6962a; i++) {
            this.f6963b[i] = dArr[i];
        }
    }

    /* renamed from: if */
    public C3130while mo38635if(C3130while whileR) {
        if (mo38630do() == whileR.mo38630do()) {
            C3130while whileR2 = new C3130while(this.f6962a);
            for (int i = 0; i < this.f6962a; i++) {
                whileR2.f6963b[i] = Math.max(whileR.f6963b[i], this.f6963b[i]);
            }
            return whileR2;
        }
        throw new IllegalArgumentException("dimensions disagree");
    }

    /* renamed from: do */
    public C3130while mo38631do(double d) {
        C3130while whileR = new C3130while(this.f6962a);
        for (int i = 0; i < this.f6962a; i++) {
            whileR.f6963b[i] = this.f6963b[i] * d;
        }
        return whileR;
    }

    /* renamed from: do */
    public C3130while mo38632do(C3130while whileR, C3130while whileR2) {
        if (mo38630do() == whileR.mo38630do() && mo38630do() == whileR2.mo38630do()) {
            C3130while whileR3 = new C3130while(this.f6962a);
            for (int i = 0; i < this.f6962a; i++) {
                whileR3.f6963b[i] = C3127throw.m4046do(this.f6963b[i], whileR.f6963b[i], whileR2.f6963b[i]);
            }
            return whileR3;
        }
        throw new IllegalArgumentException("dimensions disagree");
    }
}
