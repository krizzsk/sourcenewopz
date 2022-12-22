package p242io.socket.backo;

import java.math.BigDecimal;
import java.math.BigInteger;

/* renamed from: io.socket.backo.Backoff */
public class Backoff {

    /* renamed from: a */
    private long f59491a = 100;

    /* renamed from: b */
    private long f59492b = 10000;

    /* renamed from: c */
    private int f59493c = 2;

    /* renamed from: d */
    private double f59494d;

    /* renamed from: e */
    private int f59495e;

    public long duration() {
        BigInteger valueOf = BigInteger.valueOf(this.f59491a);
        BigInteger valueOf2 = BigInteger.valueOf((long) this.f59493c);
        int i = this.f59495e;
        this.f59495e = i + 1;
        BigInteger multiply = valueOf.multiply(valueOf2.pow(i));
        if (this.f59494d != 0.0d) {
            double random = Math.random();
            BigInteger bigInteger = BigDecimal.valueOf(random).multiply(BigDecimal.valueOf(this.f59494d)).multiply(new BigDecimal(multiply)).toBigInteger();
            multiply = (((int) Math.floor(random * 10.0d)) & 1) == 0 ? multiply.subtract(bigInteger) : multiply.add(bigInteger);
        }
        return multiply.min(BigInteger.valueOf(this.f59492b)).longValue();
    }

    public void reset() {
        this.f59495e = 0;
    }

    public Backoff setMin(long j) {
        this.f59491a = j;
        return this;
    }

    public Backoff setMax(long j) {
        this.f59492b = j;
        return this;
    }

    public Backoff setFactor(int i) {
        this.f59493c = i;
        return this;
    }

    public Backoff setJitter(double d) {
        this.f59494d = d;
        return this;
    }

    public int getAttempts() {
        return this.f59495e;
    }
}
