package com.iproov.sdk.core;

import com.didi.soda.customer.p165h5.hybird.model.GuideParamModel;
import com.google.firebase.abt.FirebaseABTesting;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p093switch.C3130while;

/* renamed from: com.iproov.sdk.core.final */
/* compiled from: LivenessParameters */
public class C19886final {

    /* renamed from: a */
    private final double f54243a;

    /* renamed from: b */
    private final int f54244b;

    /* renamed from: c */
    private final double f54245c;

    /* renamed from: d */
    private final double f54246d;

    /* renamed from: e */
    private final double[] f54247e;

    /* renamed from: f */
    private final double f54248f;

    /* renamed from: g */
    private final double f54249g;

    /* renamed from: h */
    private final double f54250h;

    /* renamed from: i */
    private final double f54251i;

    /* renamed from: j */
    private final double f54252j;

    /* renamed from: k */
    private final int f54253k;

    /* renamed from: l */
    private final int f54254l;

    public C19886final(JSONObject jSONObject) throws JSONException {
        this.f54243a = jSONObject.optDouble("lui", 0.2d);
        this.f54244b = jSONObject.optInt(FirebaseABTesting.OriginService.REMOTE_CONFIG, 10);
        this.f54245c = jSONObject.optDouble("fdt", 0.1d);
        this.f54246d = jSONObject.optDouble("fsr", 1.25d);
        JSONArray optJSONArray = jSONObject.optJSONArray("wgv");
        if (optJSONArray == null) {
            this.f54247e = new double[]{1.0d, 1.0d, 1.3d};
        } else {
            this.f54247e = new double[]{optJSONArray.getDouble(0), optJSONArray.getDouble(1), optJSONArray.getDouble(2)};
        }
        this.f54248f = jSONObject.optDouble("vps", 0.8d);
        this.f54249g = jSONObject.optDouble(GuideParamModel.ACTION_SET, 0.15d);
        this.f54250h = jSONObject.optDouble("smf", 0.58d);
        this.f54251i = jSONObject.optDouble("lgf", 0.9d);
        this.f54252j = jSONObject.optDouble("lft", 0.58d);
        this.f54253k = jSONObject.optInt("frw", 5);
        this.f54254l = jSONObject.optInt("mmx", 50);
    }

    /* renamed from: break  reason: not valid java name */
    public double m47509break() {
        return this.f54250h;
    }

    /* renamed from: case  reason: not valid java name */
    public double m47510case() {
        return this.f54252j;
    }

    /* renamed from: catch  reason: not valid java name */
    public double m47511catch() {
        return this.f54248f;
    }

    /* renamed from: class  reason: not valid java name */
    public C3130while m47512class() {
        return new C3130while(this.f54247e);
    }

    /* renamed from: do */
    public double mo162077do() {
        return this.f54245c;
    }

    /* renamed from: else  reason: not valid java name */
    public double m47513else() {
        return this.f54251i;
    }

    /* renamed from: for  reason: not valid java name */
    public double m47514for() {
        return this.f54246d;
    }

    /* renamed from: goto  reason: not valid java name */
    public int m47515goto() {
        return ((int) this.f54243a) * 1000;
    }

    /* renamed from: if */
    public double mo162081if() {
        return this.f54249g;
    }

    /* renamed from: new  reason: not valid java name */
    public int m47516new() {
        return this.f54244b;
    }

    /* renamed from: this  reason: not valid java name */
    public int m47517this() {
        return this.f54254l;
    }

    public String toString() {
        return "LivenessParameters{locoUpdateInterval=" + this.f54243a + ", frameCount=" + this.f54244b + ", finalDistanceFromTarget=" + this.f54245c + ", finalSizeRatio=" + this.f54246d + ", weightsVector=" + Arrays.toString(this.f54247e) + ", vectorProgressScale=" + this.f54248f + ", finalSizeErrorFromTarget=" + this.f54249g + ", smallFaceWidth=" + this.f54250h + ", largeFaceWidth=" + this.f54251i + ", largeFaceThreshold=" + this.f54252j + ", frameSelectionWindow=" + this.f54253k + ", maximumMotionUpdatesPerCheckpoint=" + this.f54254l + '}';
    }

    /* renamed from: try  reason: not valid java name */
    public int m47518try() {
        return this.f54253k;
    }
}
