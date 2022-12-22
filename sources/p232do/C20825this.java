package p232do;

import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.exifinterface.media.ExifInterface;
import p093switch.C3127throw;

/* renamed from: do.this */
/* compiled from: EXIFData */
public class C20825this {

    /* renamed from: a */
    private final Double f57203a;

    /* renamed from: b */
    private final Double f57204b;

    /* renamed from: c */
    private final Double f57205c;

    /* renamed from: d */
    private final Double f57206d;

    /* renamed from: e */
    private final Double f57207e;

    /* renamed from: f */
    private final Double f57208f;

    /* renamed from: g */
    private final Double f57209g;

    /* renamed from: h */
    private final Double f57210h;

    /* renamed from: i */
    private final Double f57211i;

    /* renamed from: j */
    private final Double f57212j;

    /* renamed from: k */
    private final Double f57213k;

    /* renamed from: l */
    private final Double f57214l;

    /* renamed from: m */
    private final Double f57215m;

    /* renamed from: n */
    private final Double f57216n;

    /* renamed from: o */
    private final Double f57217o;

    /* renamed from: p */
    private final Double f57218p;

    /* renamed from: q */
    private final Double f57219q;

    /* renamed from: r */
    private final Double f57220r;

    /* renamed from: s */
    private final Double f57221s;

    /* renamed from: t */
    private final Double f57222t;

    public C20825this(TotalCaptureResult totalCaptureResult) {
        Double d = C20820else.m41012do((Float) totalCaptureResult.get(CaptureResult.LENS_APERTURE));
        this.f57203a = d;
        this.f57206d = d;
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.SENSOR_SENSITIVITY);
        this.f57205c = (num == null || num.intValue() == 0) ? null : C20820else.m41013do(num);
        Long l = (Long) totalCaptureResult.get(CaptureResult.SENSOR_EXPOSURE_TIME);
        this.f57204b = (l == null || l.longValue() == 0) ? null : Double.valueOf(((double) l.longValue()) / 1.0E9d);
        this.f57207e = C20820else.m41012do((Float) totalCaptureResult.get(CaptureResult.LENS_FOCAL_LENGTH));
        this.f57208f = null;
        this.f57209g = C20820else.m41012do((Float) totalCaptureResult.get(CaptureResult.LENS_FOCUS_DISTANCE));
        this.f57210h = C20820else.m41013do((Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_EXPOSURE_COMPENSATION));
        this.f57211i = null;
        this.f57212j = null;
        this.f57213k = null;
        this.f57214l = null;
        this.f57215m = null;
        this.f57216n = null;
        this.f57217o = null;
        this.f57218p = null;
        this.f57219q = null;
        this.f57220r = null;
        this.f57221s = null;
        this.f57222t = null;
    }

    /* renamed from: break  reason: not valid java name */
    public Double m47619break() {
        return this.f57205c;
    }

    /* renamed from: case  reason: not valid java name */
    public Double m47620case() {
        return this.f57210h;
    }

    /* renamed from: catch  reason: not valid java name */
    public Double m47621catch() {
        return this.f57221s;
    }

    /* renamed from: class  reason: not valid java name */
    public Double m47622class() {
        return this.f57212j;
    }

    /* renamed from: const  reason: not valid java name */
    public Double m47623const() {
        return this.f57216n;
    }

    /* renamed from: do */
    public Double mo170645do() {
        return this.f57203a;
    }

    /* renamed from: else  reason: not valid java name */
    public Double m47624else() {
        return this.f57204b;
    }

    /* renamed from: final  reason: not valid java name */
    public Double m47625final() {
        return this.f57214l;
    }

    /* renamed from: for  reason: not valid java name */
    public Double m47626for() {
        return this.f57213k;
    }

    /* renamed from: goto  reason: not valid java name */
    public Double m47627goto() {
        return this.f57207e;
    }

    /* renamed from: if */
    public Double mo170650if() {
        return this.f57208f;
    }

    /* renamed from: import  reason: not valid java name */
    public Double m47628import() {
        return this.f57220r;
    }

    /* renamed from: native  reason: not valid java name */
    public Double m47629native() {
        return this.f57219q;
    }

    /* renamed from: new  reason: not valid java name */
    public Double m47630new() {
        return this.f57215m;
    }

    /* renamed from: public  reason: not valid java name */
    public Double m47631public() {
        return this.f57206d;
    }

    /* renamed from: super  reason: not valid java name */
    public Double m47632super() {
        return this.f57222t;
    }

    /* renamed from: this  reason: not valid java name */
    public Double m47633this() {
        return this.f57218p;
    }

    /* renamed from: throw  reason: not valid java name */
    public Double m47634throw() {
        return this.f57211i;
    }

    public String toString() {
        return "EXIFData{aperture=" + this.f57203a + ", exposureTime=" + this.f57204b + ", iso=" + this.f57205c + ", fNumber=" + this.f57206d + ", focalLength=" + this.f57207e + ", brightness=" + this.f57208f + ", subjectDistance=" + this.f57209g + ", exposureBias=" + this.f57210h + ", subjectArea=" + this.f57211i + ", meteringMode=" + this.f57212j + ", colorSpace=" + this.f57213k + ", sensingMethod=" + this.f57214l + ", componentsConfiguration=" + this.f57215m + ", saturation=" + this.f57216n + ", contrast=" + this.f57217o + ", gainControl=" + this.f57218p + ", whiteBalance=" + this.f57219q + ", subjectDistanceRange=" + this.f57220r + ", maxApertureValue=" + this.f57221s + ", spatialFrequencyResponse=" + this.f57222t + '}';
    }

    /* renamed from: try  reason: not valid java name */
    public Double m47635try() {
        return this.f57217o;
    }

    /* renamed from: while  reason: not valid java name */
    public Double m47636while() {
        return this.f57209g;
    }

    public C20825this(ExifInterface exifInterface) {
        ExifInterface exifInterface2 = exifInterface;
        String attribute = exifInterface2.getAttribute(ExifInterface.TAG_APERTURE_VALUE);
        String attribute2 = exifInterface2.getAttribute(ExifInterface.TAG_F_NUMBER);
        String attribute3 = exifInterface2.getAttribute(ExifInterface.TAG_EXPOSURE_TIME);
        String attribute4 = exifInterface2.getAttribute(ExifInterface.TAG_ISO_SPEED_RATINGS);
        String attribute5 = exifInterface2.getAttribute(ExifInterface.TAG_BRIGHTNESS_VALUE);
        String attribute6 = exifInterface2.getAttribute(ExifInterface.TAG_FOCAL_LENGTH);
        String attribute7 = exifInterface2.getAttribute(ExifInterface.TAG_SUBJECT_DISTANCE);
        String attribute8 = exifInterface2.getAttribute(ExifInterface.TAG_EXPOSURE_BIAS_VALUE);
        String attribute9 = exifInterface2.getAttribute(ExifInterface.TAG_SUBJECT_AREA);
        String attribute10 = exifInterface2.getAttribute(ExifInterface.TAG_METERING_MODE);
        String attribute11 = exifInterface2.getAttribute(ExifInterface.TAG_COLOR_SPACE);
        String attribute12 = exifInterface2.getAttribute(ExifInterface.TAG_SENSING_METHOD);
        String attribute13 = exifInterface2.getAttribute(ExifInterface.TAG_COMPONENTS_CONFIGURATION);
        String attribute14 = exifInterface2.getAttribute(ExifInterface.TAG_SATURATION);
        String attribute15 = exifInterface2.getAttribute(ExifInterface.TAG_CONTRAST);
        String attribute16 = exifInterface2.getAttribute(ExifInterface.TAG_GAIN_CONTROL);
        String attribute17 = exifInterface2.getAttribute(ExifInterface.TAG_WHITE_BALANCE);
        String attribute18 = exifInterface2.getAttribute(ExifInterface.TAG_SUBJECT_DISTANCE_RANGE);
        String attribute19 = exifInterface2.getAttribute(ExifInterface.TAG_MAX_APERTURE_VALUE);
        String attribute20 = exifInterface2.getAttribute(ExifInterface.TAG_SPATIAL_FREQUENCY_RESPONSE);
        Double d = C20820else.m41014do(attribute);
        Double d2 = C20820else.m41014do(attribute2);
        this.f57203a = (Double) C3127throw.m4049do(d, d2);
        this.f57204b = C20820else.m41014do(attribute3);
        this.f57205c = C20820else.m41014do(attribute4);
        this.f57206d = (Double) C3127throw.m4049do(d2, d);
        this.f57208f = C20820else.m41014do(attribute5);
        this.f57207e = C20820else.m41014do(attribute6);
        this.f57209g = C20820else.m41014do(attribute7);
        this.f57210h = C20820else.m41014do(attribute8);
        this.f57211i = C20820else.m41014do(attribute9);
        this.f57212j = C20820else.m41014do(attribute10);
        this.f57213k = C20820else.m41014do(attribute11);
        this.f57214l = C20820else.m41014do(attribute12);
        this.f57215m = C20820else.m41014do(attribute13);
        this.f57216n = C20820else.m41014do(attribute14);
        this.f57217o = C20820else.m41014do(attribute15);
        this.f57218p = C20820else.m41014do(attribute16);
        this.f57219q = C20820else.m41014do(attribute17);
        this.f57220r = C20820else.m41014do(attribute18);
        this.f57221s = C20820else.m41014do(attribute19);
        this.f57222t = C20820else.m41014do(attribute20);
    }
}
