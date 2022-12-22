package p235for;

import org.json.JSONObject;

/* renamed from: for.new */
/* compiled from: GpaParameters */
public class C20840new {

    /* renamed from: case  reason: not valid java name */
    public final int f61845case;

    /* renamed from: do */
    public final float f57254do;

    /* renamed from: else  reason: not valid java name */
    public final int f61846else;

    /* renamed from: for  reason: not valid java name */
    public final int f61847for;

    /* renamed from: if */
    public final int f57255if;

    /* renamed from: new  reason: not valid java name */
    public final int f61848new;

    /* renamed from: try  reason: not valid java name */
    public final int f61849try;

    public C20840new(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f57254do = (float) i;
        this.f57255if = i2;
        this.f61847for = i3;
        this.f61848new = i4;
        this.f61849try = i5;
        this.f61845case = i6;
        this.f61846else = i7;
    }

    /* renamed from: do */
    public static C20840new m41058do() {
        return new C20840new(3500, 2, 1, 2, 2, 250, 800);
    }

    public C20840new(JSONObject jSONObject) {
        this.f57254do = (float) jSONObject.optInt("frs", 3500);
        this.f57255if = jSONObject.optInt("fpf", 2);
        this.f61847for = jSONObject.optInt("cfc", 1);
        this.f61848new = jSONObject.optInt("pfc", 2);
        this.f61849try = jSONObject.optInt("afc", 2);
        this.f61845case = jSONObject.optInt("lfd", 250);
        this.f61846else = jSONObject.optInt("ufd", 800);
    }
}
