package com.didi.dqr;

public final class Dimension {

    /* renamed from: a */
    private final int f18479a;

    /* renamed from: b */
    private final int f18480b;

    public Dimension(int i, int i2) {
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException();
        }
        this.f18479a = i;
        this.f18480b = i2;
    }

    public int getWidth() {
        return this.f18479a;
    }

    public int getHeight() {
        return this.f18480b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Dimension)) {
            return false;
        }
        Dimension dimension = (Dimension) obj;
        if (this.f18479a == dimension.f18479a && this.f18480b == dimension.f18480b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f18479a * 32713) + this.f18480b;
    }

    public String toString() {
        return this.f18479a + "x" + this.f18480b;
    }
}
