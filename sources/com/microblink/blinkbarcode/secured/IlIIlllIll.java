package com.microblink.blinkbarcode.secured;

import android.graphics.Rect;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import com.microblink.blinkbarcode.hardware.IllIIIllII;
import com.microblink.blinkbarcode.util.Log;

/* compiled from: line */
class IlIIlllIll {
    private int IIlIIIllIl = 0;
    private Rect IlIllIlIIl = null;
    private Rect[] IllIIIIllI = null;
    private Rect IllIIIllII = null;
    private int lIlIIIIlIl = 0;
    private float llIIIlllll = 0.0f;
    private int llIIlIIlll = 0;
    private IllIIIllII llIIlIlIIl;

    public IlIIlllIll(IllIIIllII illIIIllII) {
        this.llIIlIlIIl = illIIIllII;
    }

    public void llIIlIlIIl(CameraCharacteristics cameraCharacteristics) {
        Rect rect = (Rect) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
        this.IllIIIllII = rect;
        if (rect != null) {
            Log.m40231i(this, "Sensor active array size: {}x{}", Integer.valueOf(rect.width()), Integer.valueOf(this.IllIIIllII.height()));
            Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
            Integer num2 = (Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AE);
            Integer num3 = (Integer) cameraCharacteristics.get(CameraCharacteristics.CONTROL_MAX_REGIONS_AWB);
            if (num == null || num2 == null || num3 == null) {
                throw new RuntimeException("Unable to obtain max number of regions for AF, AE and AWB. This is a bug in device!");
            }
            this.lIlIIIIlIl = num.intValue();
            this.llIIlIIlll = num2.intValue();
            this.IIlIIIllIl = num3.intValue();
            Log.m40231i(this, "Max AF regions: {}, Max AE regions: {}, Max AWB regions: {}", Integer.valueOf(this.lIlIIIIlIl), Integer.valueOf(this.llIIlIIlll), Integer.valueOf(this.IIlIIIllIl));
            Float f = (Float) cameraCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
            if (f != null) {
                float floatValue = f.floatValue();
                this.llIIIlllll = floatValue;
                Log.m40231i(this, "Maximum digital zoom: {}", Float.valueOf(floatValue));
                return;
            }
            throw new RuntimeException("Unable to obtain max digital zoom value. This is a bug in device!");
        }
        throw new RuntimeException("Unable to obtain sensor active array size. This is a bug in device!");
    }

    public Rect[] llIIlIlIIl() {
        return this.IllIIIIllI;
    }

    public void llIIlIlIIl(CaptureRequest.Builder builder, Rect[] rectArr) {
        MeteringRectangle[] meteringRectangleArr;
        MeteringRectangle[] meteringRectangleArr2;
        MeteringRectangle[] meteringRectangleArr3;
        if (this.IlIllIlIIl != null) {
            MeteringRectangle[] meteringRectangleArr4 = null;
            if (rectArr != null) {
                int i = this.lIlIIIIlIl;
                if (i > 0) {
                    if (rectArr.length < i) {
                        i = rectArr.length;
                    }
                    meteringRectangleArr3 = new MeteringRectangle[i];
                } else {
                    meteringRectangleArr3 = null;
                }
                int i2 = this.llIIlIIlll;
                if (i2 > 0) {
                    if (rectArr.length < i2) {
                        i2 = rectArr.length;
                    }
                    meteringRectangleArr = new MeteringRectangle[i2];
                } else {
                    meteringRectangleArr = null;
                }
                int i3 = this.IIlIIIllIl;
                if (i3 > 0) {
                    if (rectArr.length < i3) {
                        i3 = rectArr.length;
                    }
                    meteringRectangleArr4 = new MeteringRectangle[i3];
                }
                for (int i4 = 0; i4 < rectArr.length; i4++) {
                    if (i4 < this.lIlIIIIlIl) {
                        meteringRectangleArr3[i4] = new MeteringRectangle(llIIlIlIIl(rectArr[i4]), 1000);
                    }
                    if (i4 < this.llIIlIIlll) {
                        meteringRectangleArr[i4] = new MeteringRectangle(llIIlIlIIl(rectArr[i4]), 1000);
                    }
                    if (i4 < this.IIlIIIllIl) {
                        meteringRectangleArr4[i4] = new MeteringRectangle(llIIlIlIIl(rectArr[i4]), 1000);
                    }
                }
                MeteringRectangle[] meteringRectangleArr5 = meteringRectangleArr3;
                meteringRectangleArr2 = meteringRectangleArr4;
                meteringRectangleArr4 = meteringRectangleArr5;
            } else {
                meteringRectangleArr2 = null;
                meteringRectangleArr = null;
            }
            if (meteringRectangleArr4 != null) {
                builder.set(CaptureRequest.CONTROL_AF_REGIONS, meteringRectangleArr4);
            } else if (this.lIlIIIIlIl > 0) {
                builder.set(CaptureRequest.CONTROL_AF_REGIONS, new MeteringRectangle[]{new MeteringRectangle(this.IlIllIlIIl, 0)});
            }
            if (meteringRectangleArr != null) {
                builder.set(CaptureRequest.CONTROL_AE_REGIONS, meteringRectangleArr);
            } else if (this.llIIlIIlll > 0) {
                builder.set(CaptureRequest.CONTROL_AE_REGIONS, new MeteringRectangle[]{new MeteringRectangle(this.IlIllIlIIl, 0)});
            }
            if (meteringRectangleArr2 != null) {
                builder.set(CaptureRequest.CONTROL_AWB_REGIONS, meteringRectangleArr2);
            } else if (this.IIlIIIllIl > 0) {
                builder.set(CaptureRequest.CONTROL_AWB_REGIONS, new MeteringRectangle[]{new MeteringRectangle(this.IlIllIlIIl, 0)});
            }
            this.IllIIIIllI = rectArr;
        }
    }

    private Rect llIIlIlIIl(Rect rect) {
        Rect rect2 = this.IlIllIlIIl;
        int round = rect2.left + Math.round((((float) (rect.left + 1000)) / 2000.0f) * ((float) rect2.width()));
        Rect rect3 = this.IlIllIlIIl;
        int round2 = rect3.left + Math.round((((float) (rect.right + 1000)) / 2000.0f) * ((float) rect3.width()));
        Rect rect4 = this.IlIllIlIIl;
        int round3 = rect4.top + Math.round((((float) (rect.top + 1000)) / 2000.0f) * ((float) rect4.height()));
        Rect rect5 = this.IlIllIlIIl;
        return new Rect(round, round3, round2, rect5.top + Math.round((((float) (rect.bottom + 1000)) / 2000.0f) * ((float) rect5.height())));
    }

    public void llIIlIlIIl(CaptureRequest.Builder builder, float f) {
        float llIIlIlIIl2 = this.llIIlIlIIl.llIIlIlIIl(f);
        if (llIIlIlIIl2 < 0.0f) {
            llIIlIlIIl2 = 0.0f;
        }
        if (llIIlIlIIl2 > 1.0f) {
            llIIlIlIIl2 = 1.0f;
        }
        float f2 = ((llIIlIlIIl2 * (this.llIIIlllll - 1.0f)) + 1.0f) * 2.0f;
        int round = Math.round(((float) this.IllIIIllII.width()) / f2);
        int round2 = Math.round(((float) this.IllIIIllII.height()) / f2);
        int width = this.IllIIIllII.width() / 2;
        int height = this.IllIIIllII.height() / 2;
        Rect rect = new Rect(width - round, height - round2, width + round, height + round2);
        this.IlIllIlIIl = rect;
        builder.set(CaptureRequest.SCALER_CROP_REGION, rect);
    }
}
