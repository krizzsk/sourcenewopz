package com.iproov.sdk.cameray;

import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Range;
import android.util.Size;
import com.iproov.sdk.cameray.C19771case;
import java.util.ArrayList;
import p232do.C20817break;
import p232do.C20824new;
import p232do.C20826try;

/* renamed from: com.iproov.sdk.cameray.for */
/* compiled from: Camera2Info */
public class C19780for implements C20824new {

    /* renamed from: a */
    private final String f54040a;

    /* renamed from: b */
    private final C19768break f54041b;

    /* renamed from: c */
    private final C20817break f54042c;

    /* renamed from: d */
    private final Float f54043d;

    /* renamed from: e */
    private final Range<Integer> f54044e;

    /* renamed from: f */
    private final Rect f54045f;

    /* renamed from: try  reason: not valid java name */
    protected final Orientation f61747try;

    C19780for(String str, C19768break breakR, CameraCharacteristics cameraCharacteristics, Float f, C20826try tryR) throws C19771case {
        this.f54040a = str;
        this.f54041b = breakR;
        this.f54043d = f;
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION);
        this.f54045f = (Rect) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        if (streamConfigurationMap == null) {
            throw new C19771case(C19771case.C19772do.CAMERA_ERROR, "StreamConfiguration unavailable");
        } else if (num != null) {
            this.f61747try = Orientation.findByDegrees(num.intValue());
            ArrayList arrayList = new ArrayList();
            for (Size size : streamConfigurationMap.getOutputSizes(SurfaceTexture.class)) {
                arrayList.add(new C20817break(size.getWidth(), size.getHeight()));
            }
            this.f54042c = tryR.mo162071do(C19775const.CAMERA2, arrayList);
            this.f54044e = C19790super.m38755a(cameraCharacteristics, 30);
        } else {
            throw new C19771case(C19771case.C19772do.CAMERA_ERROR, "Camera orientation unavailable");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C20817break mo161920a() {
        return new C20817break(this.f54042c.mo170632if(), this.f54042c.mo170629do());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public Range<Integer> mo161921b() {
        return this.f54044e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo161922c() {
        return this.f54040a;
    }

    /* renamed from: do */
    public C19768break mo161909do() {
        return this.f54041b;
    }

    /* renamed from: for  reason: not valid java name */
    public Float m47462for() {
        return this.f54043d;
    }

    /* renamed from: if */
    public C20817break mo161911if() {
        return new C20817break(this.f54042c.mo170632if(), this.f54042c.mo170629do());
    }

    /* renamed from: new  reason: not valid java name */
    public Orientation m47463new() {
        return this.f61747try;
    }

    /* renamed from: try  reason: not valid java name */
    public Rect m47464try() {
        return this.f54045f;
    }
}
