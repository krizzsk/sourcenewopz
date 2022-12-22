package com.didi.zxing.client.camera;

import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import com.didi.bike.utils.SystemUtil;
import com.didi.payment.base.cons.WalletExtraConstant;
import com.didi.sdk.apm.SystemUtils;
import com.didi.zxing.barcodescanner.camera.CameraSettings;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import kotlinx.coroutines.DebugKt;
import org.osgi.framework.VersionRange;

public final class CameraConfigurationUtils {

    /* renamed from: a */
    private static final String f45486a = "CameraConfiguration";

    /* renamed from: b */
    private static final Pattern f45487b = Pattern.compile(";");

    /* renamed from: c */
    private static final float f45488c = 1.5f;

    /* renamed from: d */
    private static final float f45489d = 0.0f;

    /* renamed from: e */
    private static final int f45490e = 10;

    /* renamed from: f */
    private static final int f45491f = 20;

    /* renamed from: g */
    private static final int f45492g = 400;

    private CameraConfigurationUtils() {
    }

    public static void setFocus(Camera.Parameters parameters, CameraSettings.FocusMode focusMode, boolean z) {
        String str;
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (z || focusMode == CameraSettings.FocusMode.AUTO) {
            str = m32623a("focus mode", supportedFocusModes, DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
        } else if (focusMode == CameraSettings.FocusMode.CONTINUOUS) {
            str = m32623a("focus mode", supportedFocusModes, "continuous-picture", "continuous-video", DebugKt.DEBUG_PROPERTY_VALUE_AUTO);
        } else if (focusMode == CameraSettings.FocusMode.INFINITY) {
            str = m32623a("focus mode", supportedFocusModes, "infinity");
        } else {
            str = focusMode == CameraSettings.FocusMode.MACRO ? m32623a("focus mode", supportedFocusModes, "macro") : null;
        }
        if (!z && str == null) {
            str = m32623a("focus mode", supportedFocusModes, "macro", "edof");
        }
        if (str == null) {
            return;
        }
        if (str.equals(parameters.getFocusMode())) {
            SystemUtils.log(4, f45486a, "Focus mode already set to " + str, (Throwable) null, "com.didi.zxing.client.camera.CameraConfigurationUtils", 90);
            return;
        }
        parameters.setFocusMode(str);
    }

    public static void setTorch(Camera.Parameters parameters, boolean z) {
        String str;
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        if (z) {
            str = m32623a("flash mode", supportedFlashModes, "torch", "on");
        } else {
            str = m32623a("flash mode", supportedFlashModes, DebugKt.DEBUG_PROPERTY_VALUE_OFF);
        }
        if (str == null) {
            return;
        }
        if (str.equals(parameters.getFlashMode())) {
            SystemUtils.log(4, f45486a, "Flash mode already set to " + str, (Throwable) null, "com.didi.zxing.client.camera.CameraConfigurationUtils", 112);
            return;
        }
        SystemUtils.log(4, f45486a, "Setting flash mode to " + str, (Throwable) null, "com.didi.zxing.client.camera.CameraConfigurationUtils", 114);
        parameters.setFlashMode(str);
    }

    public static void setBestExposure(Camera.Parameters parameters, boolean z) {
        int minExposureCompensation = parameters.getMinExposureCompensation();
        int maxExposureCompensation = parameters.getMaxExposureCompensation();
        float exposureCompensationStep = parameters.getExposureCompensationStep();
        if (!(minExposureCompensation == 0 && maxExposureCompensation == 0)) {
            float f = 0.0f;
            if (exposureCompensationStep > 0.0f) {
                if (!z) {
                    f = 1.5f;
                }
                int round = Math.round(f / exposureCompensationStep);
                float f2 = exposureCompensationStep * ((float) round);
                int max = Math.max(Math.min(round, maxExposureCompensation), minExposureCompensation);
                if (parameters.getExposureCompensation() == max) {
                    SystemUtils.log(4, f45486a, "Exposure compensation already set to " + max + " / " + f2, (Throwable) null, "com.didi.zxing.client.camera.CameraConfigurationUtils", 132);
                    return;
                }
                SystemUtils.log(4, f45486a, "Setting exposure compensation to " + max + " / " + f2, (Throwable) null, "com.didi.zxing.client.camera.CameraConfigurationUtils", 134);
                parameters.setExposureCompensation(max);
                return;
            }
        }
        SystemUtils.log(4, f45486a, "Camera does not support exposure compensation", (Throwable) null, "com.didi.zxing.client.camera.CameraConfigurationUtils", 138);
    }

    public static void setBestPreviewFPS(Camera.Parameters parameters) {
        setBestPreviewFPS(parameters, 10, 20);
    }

    public static void setBestPreviewFPS(Camera.Parameters parameters, int i, int i2) {
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        SystemUtils.log(4, f45486a, "Supported FPS ranges: " + m32624a((Collection<int[]>) supportedPreviewFpsRange), (Throwable) null, "com.didi.zxing.client.camera.CameraConfigurationUtils", 148);
        if (supportedPreviewFpsRange != null && !supportedPreviewFpsRange.isEmpty()) {
            int[] iArr = null;
            Iterator<int[]> it = supportedPreviewFpsRange.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                int[] next = it.next();
                int i3 = next[0];
                int i4 = next[1];
                if (i3 >= i * 1000 && i4 <= i2 * 1000) {
                    iArr = next;
                    break;
                }
            }
            if (iArr == null) {
                SystemUtils.log(4, f45486a, "No suitable FPS range?", (Throwable) null, "com.didi.zxing.client.camera.CameraConfigurationUtils", 160);
                return;
            }
            int[] iArr2 = new int[2];
            parameters.getPreviewFpsRange(iArr2);
            if (Arrays.equals(iArr2, iArr)) {
                SystemUtils.log(4, f45486a, "FPS range already set to " + Arrays.toString(iArr), (Throwable) null, "com.didi.zxing.client.camera.CameraConfigurationUtils", 165);
                return;
            }
            SystemUtils.log(4, f45486a, "Setting FPS range to " + Arrays.toString(iArr), (Throwable) null, "com.didi.zxing.client.camera.CameraConfigurationUtils", 167);
            parameters.setPreviewFpsRange(iArr[0], iArr[1]);
        }
    }

    public static void setFocusArea(Camera.Parameters parameters) {
        if (parameters.getMaxNumFocusAreas() > 0) {
            SystemUtils.log(4, f45486a, "Old focus areas: " + m32622a((Iterable<Camera.Area>) parameters.getFocusAreas()), (Throwable) null, "com.didi.zxing.client.camera.CameraConfigurationUtils", 178);
            List<Camera.Area> a = m32625a(400);
            SystemUtils.log(4, f45486a, "Setting focus area to : " + m32622a((Iterable<Camera.Area>) a), (Throwable) null, "com.didi.zxing.client.camera.CameraConfigurationUtils", 180);
            parameters.setFocusAreas(a);
            return;
        }
        SystemUtils.log(4, f45486a, "Device does not support focus areas", (Throwable) null, "com.didi.zxing.client.camera.CameraConfigurationUtils", 183);
    }

    public static void setMetering(Camera.Parameters parameters) {
        if (parameters.getMaxNumMeteringAreas() > 0) {
            SystemUtils.log(4, f45486a, "Old metering areas: " + parameters.getMeteringAreas(), (Throwable) null, "com.didi.zxing.client.camera.CameraConfigurationUtils", 190);
            List<Camera.Area> a = m32625a(400);
            SystemUtils.log(4, f45486a, "Setting metering area to : " + m32622a((Iterable<Camera.Area>) a), (Throwable) null, "com.didi.zxing.client.camera.CameraConfigurationUtils", 192);
            parameters.setMeteringAreas(a);
            return;
        }
        SystemUtils.log(4, f45486a, "Device does not support metering areas", (Throwable) null, "com.didi.zxing.client.camera.CameraConfigurationUtils", 195);
    }

    /* renamed from: a */
    private static List<Camera.Area> m32625a(int i) {
        int i2 = -i;
        return Collections.singletonList(new Camera.Area(new Rect(i2, i2, i, i), 1));
    }

    public static void setVideoStabilization(Camera.Parameters parameters) {
        if (!parameters.isVideoStabilizationSupported()) {
            SystemUtils.log(4, f45486a, "This device does not support video stabilization", (Throwable) null, "com.didi.zxing.client.camera.CameraConfigurationUtils", 215);
        } else if (parameters.getVideoStabilization()) {
            SystemUtils.log(4, f45486a, "Video stabilization already enabled", (Throwable) null, "com.didi.zxing.client.camera.CameraConfigurationUtils", 209);
        } else {
            SystemUtils.log(4, f45486a, "Enabling video stabilization...", (Throwable) null, "com.didi.zxing.client.camera.CameraConfigurationUtils", 211);
            parameters.setVideoStabilization(true);
        }
    }

    public static void setBarcodeSceneMode(Camera.Parameters parameters) {
        if (WalletExtraConstant.Key.BARCODE.equals(parameters.getSceneMode())) {
            SystemUtils.log(4, f45486a, "Barcode scene mode already set", (Throwable) null, "com.didi.zxing.client.camera.CameraConfigurationUtils", 221);
            return;
        }
        String a = m32623a("scene mode", parameters.getSupportedSceneModes(), WalletExtraConstant.Key.BARCODE);
        if (a != null) {
            parameters.setSceneMode(a);
        }
    }

    public static void setZoom(Camera.Parameters parameters, double d) {
        if (parameters.isZoomSupported()) {
            Integer a = m32621a(parameters, d);
            if (a != null) {
                if (parameters.getZoom() == a.intValue()) {
                    SystemUtils.log(4, f45486a, "Zoom is already set to " + a, (Throwable) null, "com.didi.zxing.client.camera.CameraConfigurationUtils", 239);
                    return;
                }
                SystemUtils.log(4, f45486a, "Setting zoom to " + a, (Throwable) null, "com.didi.zxing.client.camera.CameraConfigurationUtils", 241);
                parameters.setZoom(a.intValue());
                return;
            }
            return;
        }
        SystemUtils.log(4, f45486a, "Zoom is not supported", (Throwable) null, "com.didi.zxing.client.camera.CameraConfigurationUtils", 245);
    }

    /* renamed from: a */
    private static Integer m32621a(Camera.Parameters parameters, double d) {
        List<Integer> zoomRatios = parameters.getZoomRatios();
        SystemUtils.log(4, f45486a, "Zoom ratios: " + zoomRatios, (Throwable) null, "com.didi.zxing.client.camera.CameraConfigurationUtils", 251);
        int maxZoom = parameters.getMaxZoom();
        if (zoomRatios == null || zoomRatios.isEmpty() || zoomRatios.size() != maxZoom + 1) {
            SystemUtils.log(5, f45486a, "Invalid zoom ratios!", (Throwable) null, "com.didi.zxing.client.camera.CameraConfigurationUtils", 254);
            return null;
        }
        double d2 = d * 100.0d;
        double d3 = Double.POSITIVE_INFINITY;
        int i = 0;
        for (int i2 = 0; i2 < zoomRatios.size(); i2++) {
            double abs = Math.abs(((double) zoomRatios.get(i2).intValue()) - d2);
            if (abs < d3) {
                i = i2;
                d3 = abs;
            }
        }
        SystemUtils.log(4, f45486a, "Chose zoom ratio of " + (((double) zoomRatios.get(i).intValue()) / 100.0d), (Throwable) null, "com.didi.zxing.client.camera.CameraConfigurationUtils", 267);
        return Integer.valueOf(i);
    }

    public static void setInvertColor(Camera.Parameters parameters) {
        if ("negative".equals(parameters.getColorEffect())) {
            SystemUtils.log(4, f45486a, "Negative effect already set", (Throwable) null, "com.didi.zxing.client.camera.CameraConfigurationUtils", 273);
            return;
        }
        String a = m32623a("color effect", parameters.getSupportedColorEffects(), "negative");
        if (a != null) {
            parameters.setColorEffect(a);
        }
    }

    /* renamed from: a */
    private static String m32623a(String str, Collection<String> collection, String... strArr) {
        SystemUtils.log(4, f45486a, "Requesting " + str + " value from among: " + Arrays.toString(strArr), (Throwable) null, "com.didi.zxing.client.camera.CameraConfigurationUtils", 287);
        SystemUtils.log(4, f45486a, "Supported " + str + " values: " + collection, (Throwable) null, "com.didi.zxing.client.camera.CameraConfigurationUtils", 288);
        if (collection != null) {
            for (String str2 : strArr) {
                if (collection.contains(str2)) {
                    SystemUtils.log(4, f45486a, "Can set " + str + " to: " + str2, (Throwable) null, "com.didi.zxing.client.camera.CameraConfigurationUtils", 292);
                    return str2;
                }
            }
        }
        SystemUtils.log(4, f45486a, "No supported values match", (Throwable) null, "com.didi.zxing.client.camera.CameraConfigurationUtils", 297);
        return null;
    }

    /* renamed from: a */
    private static String m32624a(Collection<int[]> collection) {
        if (collection == null || collection.isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(VersionRange.LEFT_CLOSED);
        Iterator<int[]> it = collection.iterator();
        while (it.hasNext()) {
            sb.append(Arrays.toString(it.next()));
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(VersionRange.RIGHT_CLOSED);
        return sb.toString();
    }

    /* renamed from: a */
    private static String m32622a(Iterable<Camera.Area> iterable) {
        if (iterable == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Camera.Area next : iterable) {
            sb.append(next.rect);
            sb.append(':');
            sb.append(next.weight);
            sb.append(' ');
        }
        return sb.toString();
    }

    public static String collectStats(Camera.Parameters parameters) {
        return collectStats((CharSequence) parameters.flatten());
    }

    public static String collectStats(CharSequence charSequence) {
        StringBuilder sb = new StringBuilder(1000);
        sb.append("BOARD=");
        sb.append(Build.BOARD);
        sb.append(10);
        sb.append("BRAND=");
        sb.append(SystemUtil.getBrand());
        sb.append(10);
        sb.append("CPU_ABI=");
        sb.append(Build.CPU_ABI);
        sb.append(10);
        sb.append("DEVICE=");
        sb.append(Build.DEVICE);
        sb.append(10);
        sb.append("DISPLAY=");
        sb.append(Build.DISPLAY);
        sb.append(10);
        sb.append("FINGERPRINT=");
        sb.append(Build.FINGERPRINT);
        sb.append(10);
        sb.append("HOST=");
        sb.append(Build.HOST);
        sb.append(10);
        sb.append("ID=");
        sb.append(Build.ID);
        sb.append(10);
        sb.append("MANUFACTURER=");
        sb.append(Build.MANUFACTURER);
        sb.append(10);
        sb.append("MODEL=");
        sb.append(SystemUtil.getModel());
        sb.append(10);
        sb.append("PRODUCT=");
        sb.append(Build.PRODUCT);
        sb.append(10);
        sb.append("TAGS=");
        sb.append(Build.TAGS);
        sb.append(10);
        sb.append("TIME=");
        sb.append(Build.TIME);
        sb.append(10);
        sb.append("TYPE=");
        sb.append(Build.TYPE);
        sb.append(10);
        sb.append("USER=");
        sb.append(Build.USER);
        sb.append(10);
        sb.append("VERSION.CODENAME=");
        sb.append(Build.VERSION.CODENAME);
        sb.append(10);
        sb.append("VERSION.INCREMENTAL=");
        sb.append(Build.VERSION.INCREMENTAL);
        sb.append(10);
        sb.append("VERSION.RELEASE=");
        sb.append(Build.VERSION.RELEASE);
        sb.append(10);
        sb.append("VERSION.SDK_INT=");
        sb.append(Build.VERSION.SDK_INT);
        sb.append(10);
        if (charSequence != null) {
            String[] split = f45487b.split(charSequence);
            Arrays.sort(split);
            for (String append : split) {
                sb.append(append);
                sb.append(10);
            }
        }
        return sb.toString();
    }
}
