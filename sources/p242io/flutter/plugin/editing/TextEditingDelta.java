package p242io.flutter.plugin.editing;

import org.json.JSONException;
import org.json.JSONObject;
import p242io.flutter.Log;

/* renamed from: io.flutter.plugin.editing.TextEditingDelta */
public final class TextEditingDelta {

    /* renamed from: i */
    private static final String f57794i = "TextEditingDelta";

    /* renamed from: a */
    private CharSequence f57795a;

    /* renamed from: b */
    private CharSequence f57796b;

    /* renamed from: c */
    private int f57797c;

    /* renamed from: d */
    private int f57798d;

    /* renamed from: e */
    private int f57799e;

    /* renamed from: f */
    private int f57800f;

    /* renamed from: g */
    private int f57801g;

    /* renamed from: h */
    private int f57802h;

    public TextEditingDelta(CharSequence charSequence, int i, int i2, CharSequence charSequence2, int i3, int i4, int i5, int i6) {
        this.f57799e = i3;
        this.f57800f = i4;
        this.f57801g = i5;
        this.f57802h = i6;
        m41540a(charSequence, charSequence2.toString(), i, i2);
    }

    public TextEditingDelta(CharSequence charSequence, int i, int i2, int i3, int i4) {
        this.f57799e = i;
        this.f57800f = i2;
        this.f57801g = i3;
        this.f57802h = i4;
        m41540a(charSequence, "", -1, -1);
    }

    public CharSequence getOldText() {
        return this.f57795a;
    }

    public CharSequence getDeltaText() {
        return this.f57796b;
    }

    public int getDeltaStart() {
        return this.f57797c;
    }

    public int getDeltaEnd() {
        return this.f57798d;
    }

    public int getNewSelectionStart() {
        return this.f57799e;
    }

    public int getNewSelectionEnd() {
        return this.f57800f;
    }

    public int getNewComposingStart() {
        return this.f57801g;
    }

    public int getNewComposingEnd() {
        return this.f57802h;
    }

    /* renamed from: a */
    private void m41540a(CharSequence charSequence, CharSequence charSequence2, int i, int i2) {
        this.f57795a = charSequence;
        this.f57796b = charSequence2;
        this.f57797c = i;
        this.f57798d = i2;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("oldText", this.f57795a.toString());
            jSONObject.put("deltaText", this.f57796b.toString());
            jSONObject.put("deltaStart", this.f57797c);
            jSONObject.put("deltaEnd", this.f57798d);
            jSONObject.put("selectionBase", this.f57799e);
            jSONObject.put("selectionExtent", this.f57800f);
            jSONObject.put("composingBase", this.f57801g);
            jSONObject.put("composingExtent", this.f57802h);
        } catch (JSONException e) {
            Log.m41136e(f57794i, "unable to create JSONObject: " + e);
        }
        return jSONObject;
    }
}
