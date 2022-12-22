package com.megvii.livenessdetection;

import org.json.JSONException;
import org.json.JSONObject;

public final class DetectionConfig {
    public final float eyeOpenThreshold;
    public final float gaussianBlur;
    public final float integrity;
    public final int maxBrightness;
    public final int minBrightness;
    public final float minFaceSize;
    public final float motionBlur;
    public final float mouthOpenThreshold;
    public final float pitchAngle;
    public final long timeout;
    public final float yawAngle;

    /* synthetic */ DetectionConfig(Builder builder, byte b) {
        this(builder);
    }

    @Deprecated
    public final int getMinBrightness() {
        return this.minBrightness;
    }

    @Deprecated
    public final int getMaxBrightness() {
        return this.maxBrightness;
    }

    @Deprecated
    public final float getMotionBlur() {
        return this.motionBlur;
    }

    @Deprecated
    public final float getGaussianBlur() {
        return this.gaussianBlur;
    }

    @Deprecated
    public final long getTimeout() {
        return this.timeout;
    }

    @Deprecated
    public final float getYawAngle() {
        return this.yawAngle;
    }

    @Deprecated
    public final float getPitchAngle() {
        return this.pitchAngle;
    }

    @Deprecated
    public final float getMinFaceSize() {
        return this.minFaceSize;
    }

    @Deprecated
    public final float getEyeOpenThreshold() {
        return this.eyeOpenThreshold;
    }

    @Deprecated
    public final float getMouthOpenThreshold() {
        return this.mouthOpenThreshold;
    }

    private DetectionConfig(Builder builder) {
        this.gaussianBlur = builder.f55731f;
        this.motionBlur = builder.f55730e;
        this.pitchAngle = builder.f55727b;
        this.yawAngle = builder.f55726a;
        this.minBrightness = builder.f55728c;
        this.maxBrightness = builder.f55729d;
        this.minFaceSize = builder.f55732g;
        this.timeout = (long) builder.f55733h;
        this.eyeOpenThreshold = builder.f55734i;
        this.mouthOpenThreshold = builder.f55735j;
        this.integrity = builder.f55736k;
    }

    public final String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("gaussianBlur", (double) this.gaussianBlur);
            jSONObject.put("motionBlur", (double) this.motionBlur);
            jSONObject.put("pitchAngle", (double) this.pitchAngle);
            jSONObject.put("yawAngle", (double) this.yawAngle);
            jSONObject.put("minBrightness", this.minBrightness);
            jSONObject.put("maxBrightness", this.maxBrightness);
            jSONObject.put("minFaceSize", (double) this.minFaceSize);
            jSONObject.put("timeout", this.timeout);
            jSONObject.put("eyeOpenThreshold", (double) this.eyeOpenThreshold);
            jSONObject.put("mouthOpenThreshold", (double) this.mouthOpenThreshold);
            jSONObject.put("integrity", (double) this.integrity);
            return jSONObject.toString();
        } catch (JSONException unused) {
            return null;
        }
    }

    public static final class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public float f55726a = 0.17f;
        /* access modifiers changed from: private */

        /* renamed from: b */
        public float f55727b = 0.17f;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public int f55728c = 80;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public int f55729d = 170;
        /* access modifiers changed from: private */

        /* renamed from: e */
        public float f55730e = 0.1f;
        /* access modifiers changed from: private */

        /* renamed from: f */
        public float f55731f = 0.08f;
        /* access modifiers changed from: private */

        /* renamed from: g */
        public float f55732g = 150.0f;
        /* access modifiers changed from: private */

        /* renamed from: h */
        public int f55733h = 10000;
        /* access modifiers changed from: private */

        /* renamed from: i */
        public float f55734i = 0.3f;
        /* access modifiers changed from: private */

        /* renamed from: j */
        public float f55735j = 0.4f;
        /* access modifiers changed from: private */

        /* renamed from: k */
        public float f55736k = 0.9f;

        public final Builder setMinFaceSize(int i) {
            this.f55732g = (float) i;
            return this;
        }

        public final Builder setDetectionTimeout(int i) {
            this.f55733h = i;
            return this;
        }

        public final Builder setMaxAngle(float f, float f2, float f3) {
            this.f55727b = f;
            this.f55726a = f2;
            return this;
        }

        public final Builder setBrightness(int i, int i2) {
            this.f55728c = i;
            this.f55729d = i2;
            return this;
        }

        public final Builder setMouthHwratio(float f) {
            this.f55735j = f;
            return this;
        }

        public final Builder setEyeHwratio(float f) {
            this.f55734i = f;
            return this;
        }

        public final Builder setBlur(float f, float f2) {
            this.f55731f = f;
            this.f55730e = f2;
            return this;
        }

        public final Builder setIntegrity(float f) {
            this.f55736k = f;
            return this;
        }

        public final DetectionConfig build() {
            return new DetectionConfig(this, (byte) 0);
        }
    }
}
