package com.didi.map.global.component.myLocation.apollo;

public class ApolloParamsAccuracyCircle {

    /* renamed from: a */
    private int f26047a = 0;

    /* renamed from: b */
    private int f26048b = 0;

    /* renamed from: c */
    private int f26049c = 0;

    public int getEnable() {
        return this.f26047a;
    }

    public void setEnable(int i) {
        this.f26047a = i;
    }

    public int getMinRadius() {
        return this.f26048b;
    }

    public void setMinRadius(int i) {
        this.f26048b = i;
    }

    public int getMaxRadius() {
        return this.f26049c;
    }

    public void setMaxRadius(int i) {
        this.f26049c = i;
    }

    public ApolloParamsAccuracyCircle(int i, int i2, int i3) {
        this.f26047a = i;
        this.f26048b = i2;
        this.f26049c = i3;
    }

    public String toString() {
        return "ApolloParamsAccuracyCircle{enable=" + this.f26047a + ", minRadius=" + this.f26048b + ", maxRadius=" + this.f26049c + '}';
    }
}
