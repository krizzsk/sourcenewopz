package com.didiglobal.dittoview.view;

import android.graphics.Color;
import com.didichuxing.bigdata.p173dp.locsdk.Const;

public class DittoShadow {

    /* renamed from: a */
    private int f49943a;

    /* renamed from: b */
    private int f49944b;

    /* renamed from: c */
    private float f49945c;

    /* renamed from: d */
    private String f49946d;

    public boolean isEmpty() {
        return this.f49943a == 0 || this.f49944b <= 0;
    }

    public int getShadowColor() {
        return this.f49943a;
    }

    public void setShadowColor(String str) {
        this.f49943a = Color.parseColor(str);
    }

    public float getShadowOpacity() {
        return this.f49945c;
    }

    public void setShadowOpacity(float f) {
        this.f49945c = f;
    }

    public float getShadowOffsetX() {
        String[] split = this.f49946d.trim().replace(Const.joLeft, "").replace("}", "").split(",");
        if (split == null || split.length <= 0) {
            return 0.0f;
        }
        return Float.parseFloat(split[0]);
    }

    public float getShadowOffsetY() {
        String[] split = this.f49946d.trim().replace(Const.joLeft, "").replace("}", "").split(",");
        if (split == null || split.length <= 1) {
            return 0.0f;
        }
        return Float.parseFloat(split[1]);
    }

    public void setShadowOffset(String str) {
        this.f49946d = str;
    }

    public int getShadowRadius() {
        return this.f49944b;
    }

    public void setShadowRadius(int i) {
        this.f49944b = i;
    }
}
