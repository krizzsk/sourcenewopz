package com.iproov.sdk.core;

import android.text.TextUtils;
import com.iproov.sdk.cameray.C19792try;
import com.iproov.sdk.face.FaceDetector;
import com.iproov.sdk.face.model.FaceFeature;
import com.iproov.sdk.face.model.Pose;
import com.iproov.sdk.graphics.iproov.OpenGLRenderer;
import java.util.Locale;
import p055case.C1269do;
import p092super.C3098for;
import p227const.C20726if;
import p232do.C20824new;
import p239if.C21001if;

/* renamed from: com.iproov.sdk.core.new */
/* compiled from: DebugUtils */
public class C19900new {
    /* renamed from: if */
    public static String m39244if(Double d) {
        if (d == null) {
            d = Double.valueOf(-1.0d);
        }
        return String.format(Locale.getDefault(), "%.3f", new Object[]{d});
    }

    /* renamed from: a */
    static String m39241a(C3098for forR, C21001if ifVar, FaceFeature faceFeature, OpenGLRenderer openGLRenderer, C19792try tryR, C20824new newR, FaceDetector faceDetector, C1269do doVar, float f, C20726if ifVar2, C20726if ifVar3) {
        String str;
        if (ifVar == null) {
            return "<Awaiting Claim Response>";
        }
        float f2 = ifVar2.mo169173do();
        float f3 = ifVar3.mo169173do();
        Pose pose = null;
        if (newR == null) {
            str = null;
        } else {
            str = newR.mo161911if().mo170632if() + " x " + newR.mo161911if().mo170629do();
        }
        String screenSizeString = openGLRenderer.getScreenSizeString();
        if (faceFeature != null) {
            pose = faceFeature.getPose();
        }
        String[] strArr = new String[7];
        strArr[0] = "Camera: " + tryR.mo161905if();
        strArr[1] = "Preview: " + str + ", Display: " + screenSizeString + ")";
        StringBuilder sb = new StringBuilder();
        sb.append("FPS renderer: ");
        Locale locale = Locale.ENGLISH;
        sb.append(String.format(locale, "%.1f", new Object[]{Float.valueOf(f)}));
        sb.append(" camera: ");
        sb.append(String.format(locale, "%.1f", new Object[]{Float.valueOf(f2)}));
        sb.append(", processing: ");
        sb.append(String.format(locale, "%.1f", new Object[]{Float.valueOf(f3)}));
        strArr[2] = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Face detector: ");
        sb2.append(faceDetector != null ? faceDetector.getFaceDetector() : "NULL");
        strArr[3] = sb2.toString();
        strArr[4] = "Encoder: " + doVar.mo14141if();
        strArr[5] = forR != null ? forR.mo38584do() : "Lighting model: Disabled";
        strArr[6] = "Feature: " + m39240a(pose);
        return TextUtils.join("\n", strArr);
    }

    /* renamed from: a */
    private static String m39240a(Pose pose) {
        if (pose == null) {
            return "🔄 Pose not supported";
        }
        return "🔄 " + m39243do(Float.valueOf(pose.roll)) + ", ↔️ " + m39243do(Float.valueOf(pose.yaw)) + ", ↕️ " + m39243do(Float.valueOf(pose.pitch));
    }

    /* renamed from: do */
    public static String m39243do(Float f) {
        return m39244if(Double.valueOf((double) f.floatValue()));
    }

    /* renamed from: do */
    public static String m39242do(Double d) {
        if (d == null) {
            d = Double.valueOf(0.0d);
        }
        return Math.abs(d.doubleValue() - 1.0d) < 0.1d ? "T" : "F";
    }
}
