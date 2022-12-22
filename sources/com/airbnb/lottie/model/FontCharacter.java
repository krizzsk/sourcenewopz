package com.airbnb.lottie.model;

import com.airbnb.lottie.model.content.ShapeGroup;
import java.util.List;

public class FontCharacter {

    /* renamed from: a */
    private final List<ShapeGroup> f1375a;

    /* renamed from: b */
    private final char f1376b;

    /* renamed from: c */
    private final double f1377c;

    /* renamed from: d */
    private final double f1378d;

    /* renamed from: e */
    private final String f1379e;

    /* renamed from: f */
    private final String f1380f;

    public static int hashFor(char c, String str, String str2) {
        return ((((0 + c) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public FontCharacter(List<ShapeGroup> list, char c, double d, double d2, String str, String str2) {
        this.f1375a = list;
        this.f1376b = c;
        this.f1377c = d;
        this.f1378d = d2;
        this.f1379e = str;
        this.f1380f = str2;
    }

    public List<ShapeGroup> getShapes() {
        return this.f1375a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public double mo15286a() {
        return this.f1377c;
    }

    public double getWidth() {
        return this.f1378d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public String mo15287b() {
        return this.f1379e;
    }

    public int hashCode() {
        return hashFor(this.f1376b, this.f1380f, this.f1379e);
    }
}
