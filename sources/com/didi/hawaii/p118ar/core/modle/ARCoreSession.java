package com.didi.hawaii.p118ar.core.modle;

import android.content.Context;
import android.media.Image;
import android.os.Build;
import android.util.Size;
import com.didi.hawaii.p118ar.jni.AREngineJNI;
import com.didi.hawaii.p118ar.jni.DARCARImage;
import com.didi.hawaii.p118ar.jni.DARCARTrackState;
import com.didi.hawaii.p118ar.jni.DARCARTrackStateReason;
import com.didi.hawaii.p118ar.jni.DARCLocationInScene;
import com.didi.hawaii.p118ar.jni.DARCNAVStatus;
import com.didi.hawaii.p118ar.jni.DARCNAVUpdateData;
import com.didi.hawaii.p118ar.utils.ARAPollo;
import com.didi.hawaii.p118ar.utils.ARNavGlobal;
import com.didi.hawaii.p118ar.utils.LocationUtil;
import com.didi.hawaii.p118ar.utils.MatrixUtil;
import com.didi.hawaii.p118ar.utils.SensorUtil;
import com.didichuxing.hawaii.arsdk.darcore.OSImage;
import com.google.p217ar.core.Camera;
import com.google.p217ar.core.CameraConfig;
import com.google.p217ar.core.Config;
import com.google.p217ar.core.Frame;
import com.google.p217ar.core.Session;
import com.google.p217ar.core.TrackingState;
import com.google.p217ar.core.exceptions.CameraNotAvailableException;
import com.google.p217ar.core.exceptions.UnavailableApkTooOldException;
import com.google.p217ar.core.exceptions.UnavailableArcoreNotInstalledException;
import com.google.p217ar.core.exceptions.UnavailableDeviceNotCompatibleException;
import com.google.p217ar.core.exceptions.UnavailableSdkTooOldException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.didi.hawaii.ar.core.modle.ARCoreSession */
public class ARCoreSession extends Session {
    public static final int EXCESSMOTION = 2;
    public static final int HINTNAVIGATIONDISMISS = 4;
    public static final int PITCHNOTAVIABLENAVIGATION = 6;

    /* renamed from: b */
    private static final String f23045b = ARCoreSession.class.getSimpleName();

    /* renamed from: c */
    private static ArrayList<Float> f23046c;

    /* renamed from: d */
    private static boolean f23047d = false;

    /* renamed from: e */
    private static int f23048e = 15;

    /* renamed from: x */
    private static boolean f23049x = ARAPollo.isUseDeFaultImageSize();

    /* renamed from: a */
    float[] f23050a;

    /* renamed from: f */
    private Frame f23051f = null;

    /* renamed from: g */
    private Camera f23052g = null;

    /* renamed from: h */
    private Size f23053h = new Size(1280, 720);

    /* renamed from: i */
    private boolean f23054i = false;

    /* renamed from: j */
    private float f23055j;

    /* renamed from: k */
    private float f23056k;

    /* renamed from: l */
    private float f23057l;

    /* renamed from: m */
    private long f23058m;

    /* renamed from: n */
    private long f23059n;

    /* renamed from: o */
    private int f23060o;

    /* renamed from: p */
    private ARPosition f23061p;

    /* renamed from: q */
    private ARPosition f23062q;

    /* renamed from: r */
    private ARAngle f23063r;

    /* renamed from: s */
    private ARAngle f23064s;

    /* renamed from: t */
    private NavStartHintData f23065t = new NavStartHintData();

    /* renamed from: u */
    private long f23066u = 0;

    /* renamed from: v */
    private DARCLocationInScene f23067v;

    /* renamed from: w */
    private DARCLocationInScene f23068w;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.hawaii.ar.core.modle.ARCoreSession$checkStatus */
    public @interface checkStatus {
    }

    /* renamed from: a */
    private static float m16578a(float f) {
        return f < 0.0f ? f + 360.0f : f > 360.0f ? f % 360.0f : f;
    }

    public ARCoreSession(Context context) throws UnavailableSdkTooOldException, UnavailableDeviceNotCompatibleException, UnavailableArcoreNotInstalledException, UnavailableApkTooOldException {
        super(context);
        if (!f23049x) {
            Iterator<CameraConfig> it = getSupportedCameraConfigs().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                CameraConfig next = it.next();
                if (next.getImageSize().equals(this.f23053h)) {
                    setCameraConfig(next);
                    break;
                }
            }
        }
        Config config = new Config(this);
        config.setFocusMode(Config.FocusMode.FIXED);
        config.setUpdateMode(Config.UpdateMode.LATEST_CAMERA_IMAGE);
        config.setAugmentedFaceMode(Config.AugmentedFaceMode.DISABLED);
        config.setPlaneFindingMode(Config.PlaneFindingMode.DISABLED);
        configure(config);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002e A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean m16583a(float r2, float r3, float r4) {
        /*
            float r2 = m16578a((float) r2)
            float r3 = m16578a((float) r3)
            float r4 = m16578a((float) r4)
            r0 = 1
            int r1 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r1 >= 0) goto L_0x001a
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x002e
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x002e
            goto L_0x002f
        L_0x001a:
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x0024
            r3 = 1135869952(0x43b40000, float:360.0)
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x002f
        L_0x0024:
            r3 = 0
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 < 0) goto L_0x002e
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x002e
            goto L_0x002f
        L_0x002e:
            r0 = 0
        L_0x002f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.p118ar.core.modle.ARCoreSession.m16583a(float, float, float):boolean");
    }

    public Frame update(int[] iArr, DARCLocationInScene dARCLocationInScene, DARCNAVStatus dARCNAVStatus) throws CameraNotAvailableException {
        this.f23068w = dARCLocationInScene;
        Frame update = super.update();
        this.f23051f = update;
        this.f23052g = update.getCamera();
        if (!this.f23054i) {
            m16584b();
            this.f23054i = true;
        }
        if (this.f23054i) {
            long currentTimeMillis = System.currentTimeMillis();
            this.f23061p = new ARPosition(this.f23052g.getPose().getTranslation());
            this.f23059n = currentTimeMillis;
            this.f23050a = this.f23052g.getPose().getRotationQuaternion();
            this.f23064s = new ARAngle(MatrixUtil.quaternionToEuler(this.f23052g.getPose().getRotationQuaternion()));
            iArr[0] = m16579a();
            iArr[1] = m16580a(dARCNAVStatus);
            iArr[2] = m16587d();
        }
        return this.f23051f;
    }

    public OSImage acquireCameraOSImage() {
        Image image;
        OSImage oSImage = null;
        try {
            image = this.f23051f.acquireCameraImage();
        } catch (Exception unused) {
            image = null;
        }
        if (image != null) {
            oSImage = new OSImage(image);
            if (Build.VERSION.SDK_INT >= 19) {
                image.close();
            }
        }
        return oSImage;
    }

    public DARCNAVUpdateData getUpdateData(OSImage oSImage, boolean z) {
        float[] fArr = new float[16];
        this.f23052g.getProjectionMatrix(fArr, 0, 1.0E-4f, 1000.0f);
        float[] fArr2 = new float[16];
        this.f23052g.getPose().toMatrix(fArr2, 0);
        return m16581a(fArr, fArr2, this.f23052g, this.f23051f, z, oSImage);
    }

    /* renamed from: a */
    private DARCNAVUpdateData m16581a(float[] fArr, float[] fArr2, Camera camera, Frame frame, boolean z, OSImage oSImage) {
        DARCNAVUpdateData dARCNAVUpdateData = new DARCNAVUpdateData();
        AREngineJNI.DARCNAVUpdateData_cameraColorBuffer_set(dARCNAVUpdateData, (byte[]) null);
        AREngineJNI.DARCNAVUpdateData_cameraDepthBuffer_set(dARCNAVUpdateData, (byte[]) null);
        dARCNAVUpdateData.setProjection(MatrixUtil.convertViewMatrix2DARCMatrix(fArr));
        DARCARImage alloc = DARCARImage.alloc();
        if (z) {
            alloc.setOSImage(oSImage);
        } else {
            alloc.setOSImage((Object) null);
        }
        if (camera.getTrackingState() == TrackingState.PAUSED) {
            alloc.setTrackState(DARCARTrackState.DARCARTrackState_Limited);
            int i = C88691.$SwitchMap$com$google$ar$core$TrackingFailureReason[camera.getTrackingFailureReason().ordinal()];
            if (i == 1) {
                alloc.setTrackStateReason(DARCARTrackStateReason.DARCARTrackStateReason_None);
            } else if (i == 2) {
                alloc.setTrackStateReason(DARCARTrackStateReason.DARCARTrackStateReason_Initializing);
            } else if (i == 3) {
                alloc.setTrackStateReason(DARCARTrackStateReason.DARCARTrackStateReason_Relocalizing);
            } else if (i == 4) {
                alloc.setTrackStateReason(DARCARTrackStateReason.DARCARTrackStateReason_ExcessiveMotion);
            } else if (i == 5) {
                alloc.setTrackStateReason(DARCARTrackStateReason.DARCARTrackStateReason_InsufficientFeatures);
            }
        } else if (camera.getTrackingState() == TrackingState.TRACKING) {
            alloc.setTrackState(DARCARTrackState.DARCARTrackState_Normal);
            alloc.setTrackStateReason(DARCARTrackStateReason.DARCARTrackStateReason_None);
        } else if (camera.getTrackingState() == TrackingState.STOPPED) {
            alloc.setTrackState(DARCARTrackState.DARCARTrackState_NotAvailable);
            alloc.setTrackStateReason(DARCARTrackStateReason.DARCARTrackStateReason_None);
        }
        alloc.setTransform(MatrixUtil.convertViewMatrix2DARCMatrix(fArr2));
        alloc.setEulerAngle(MatrixUtil.convet2DARCPoint3F(MatrixUtil.quaternionToEuler(camera.getPose().getRotationQuaternion())));
        alloc.setAmbientColorTemperature(0.0f);
        alloc.setAmbientIntensity(frame.getLightEstimate().getPixelIntensity());
        alloc.setAirPressure(SensorUtil.getInstance().GetPressureData());
        alloc.setAttitudeMatrix(MatrixUtil.convetMatrix3F2DARCMatrix3F(SensorUtil.getInstance().getRotationMatrix3D()));
        alloc.setGPSData(LocationUtil.getCurLocation2DARCGPSData());
        alloc.setArOriginTimeStamp(((double) frame.getTimestamp()) / 1.0E9d);
        float[] focalLength = camera.getImageIntrinsics().getFocalLength();
        float[] fArr3 = new float[9];
        fArr3[0] = focalLength[0];
        fArr3[1] = focalLength[1];
        alloc.setIntrinsics(MatrixUtil.convetMatrix3F2DARCMatrix3F(fArr3));
        dARCNAVUpdateData.setArImage(alloc);
        return dARCNAVUpdateData;
    }

    /* renamed from: com.didi.hawaii.ar.core.modle.ARCoreSession$1 */
    static /* synthetic */ class C88691 {
        static final /* synthetic */ int[] $SwitchMap$com$google$ar$core$TrackingFailureReason;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.ar.core.TrackingFailureReason[] r0 = com.google.p217ar.core.TrackingFailureReason.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$ar$core$TrackingFailureReason = r0
                com.google.ar.core.TrackingFailureReason r1 = com.google.p217ar.core.TrackingFailureReason.NONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$ar$core$TrackingFailureReason     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.ar.core.TrackingFailureReason r1 = com.google.p217ar.core.TrackingFailureReason.BAD_STATE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$ar$core$TrackingFailureReason     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.ar.core.TrackingFailureReason r1 = com.google.p217ar.core.TrackingFailureReason.INSUFFICIENT_LIGHT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$ar$core$TrackingFailureReason     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.ar.core.TrackingFailureReason r1 = com.google.p217ar.core.TrackingFailureReason.EXCESSIVE_MOTION     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$ar$core$TrackingFailureReason     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.ar.core.TrackingFailureReason r1 = com.google.p217ar.core.TrackingFailureReason.INSUFFICIENT_FEATURES     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.p118ar.core.modle.ARCoreSession.C88691.<clinit>():void");
        }
    }

    /* renamed from: a */
    private int m16579a() {
        return m16586c();
    }

    /* renamed from: a */
    private void m16582a(int[] iArr) {
        if (this.f23064s.f23069x + 90.0f < (-ARNavGlobal.locationParam.maxAngle) || this.f23064s.f23069x + 90.0f > (-ARNavGlobal.locationParam.minAngle)) {
            iArr[0] = 1;
        }
    }

    /* renamed from: b */
    private void m16585b(int[] iArr) {
        f23046c.add(Float.valueOf(this.f23064s.f23070y));
        if (f23046c.size() > 15) {
            f23046c.remove(0);
            float f = ARNavGlobal.locationParam.maxMotionlessAngle;
            float floatValue = f23046c.get(0).floatValue() - f;
            float floatValue2 = f23046c.get(0).floatValue() + f;
            Iterator<Float> it = f23046c.iterator();
            int i = 0;
            while (it.hasNext()) {
                if (m16583a(it.next().floatValue(), floatValue, floatValue2)) {
                    i++;
                }
            }
            if (!(i < f23046c.size())) {
                iArr[0] = 3;
            }
        }
    }

    /* renamed from: b */
    private void m16584b() {
        this.f23055j = 0.0f;
        this.f23056k = 0.0f;
        this.f23057l = 0.0f;
        this.f23058m = 0;
        this.f23059n = 0;
        this.f23060o = 0;
        this.f23065t.status = 0;
        this.f23066u = 0;
    }

    /* renamed from: c */
    private int m16586c() {
        long j = this.f23058m;
        int i = 0;
        if (j != 0) {
            long j2 = this.f23059n;
            if (j2 > j) {
                this.f23055j += (float) Math.sqrt((double) (((this.f23061p.f23072x - this.f23062q.f23072x) * (this.f23061p.f23072x - this.f23062q.f23072x)) + ((this.f23061p.f23073y - this.f23062q.f23073y) * (this.f23061p.f23073y - this.f23062q.f23073y)) + ((this.f23061p.f23074z - this.f23062q.f23074z) * (this.f23061p.f23074z - this.f23062q.f23074z))));
                this.f23056k += Math.abs(this.f23063r.f23070y - this.f23064s.f23070y);
                float f = this.f23057l + (((float) (j2 - j)) / 1000.0f);
                this.f23057l = f;
                if (f >= 0.3f) {
                    if (this.f23055j / f > 0.3f) {
                        this.f23060o++;
                        i = 2;
                    }
                    this.f23055j = 0.0f;
                    this.f23056k = 0.0f;
                    this.f23057l = 0.0f;
                }
            }
        }
        this.f23063r = this.f23064s;
        this.f23058m = this.f23059n;
        this.f23062q = this.f23061p;
        return i;
    }

    public void updateNavHintData() {
        this.f23065t.status = 1;
    }

    /* renamed from: d */
    private int m16587d() {
        int i = this.f23065t.status;
        if (i == 1) {
            this.f23065t.f23075x = this.f23068w.getPos().getX();
            this.f23065t.f23076z = this.f23068w.getPos().getZ();
            this.f23065t.index = this.f23068w.getIndex();
            this.f23065t.status++;
            return 0;
        } else if (i != 2) {
            if (i != 3 || ((double) (((float) (this.f23059n - this.f23065t.startTime)) / 1000.0f)) < 3.0d) {
                return 0;
            }
            this.f23065t.status = 0;
            return 4;
        } else if (((this.f23065t.f23075x - this.f23068w.getPos().getX()) * (this.f23065t.f23075x - this.f23068w.getPos().getX())) + ((this.f23065t.f23076z - this.f23068w.getPos().getZ()) * (this.f23065t.f23076z - this.f23068w.getPos().getZ())) < 9.0f) {
            return 0;
        } else {
            this.f23065t.startTime = System.currentTimeMillis();
            this.f23065t.status++;
            return 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x00b6, code lost:
        if (java.lang.Math.sqrt((double) (((r8.f23068w.getPos().getX() - r8.f23067v.getPos().getX()) * (r8.f23068w.getPos().getX() - r8.f23067v.getPos().getX())) + ((r8.f23068w.getPos().getZ() - r8.f23067v.getPos().getZ()) * (r8.f23068w.getPos().getZ() - r8.f23067v.getPos().getZ())))) >= 20.0d) goto L_0x00ba;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int m16580a(com.didi.hawaii.p118ar.jni.DARCNAVStatus r9) {
        /*
            r8 = this;
            com.didi.hawaii.ar.jni.DARCNAVStatus r0 = com.didi.hawaii.p118ar.jni.DARCNAVStatus.DARCNAVStatus_Running
            r1 = 0
            r3 = 0
            if (r9 != r0) goto L_0x00bf
            com.didi.hawaii.ar.core.modle.ARCoreSession$ARAngle r9 = r8.f23064s
            float r9 = r9.f23071z
            r0 = 1127481344(0x43340000, float:180.0)
            float r9 = r9 * r0
            double r4 = (double) r9
            r6 = 4614256656552045848(0x400921fb54442d18, double:3.141592653589793)
            double r4 = r4 / r6
            r6 = 0
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            boolean r9 = com.didi.hawaii.p118ar.utils.SensorUtil.isNavigationPitchAviable
            if (r9 != 0) goto L_0x00bc
            long r4 = r8.f23066u
            int r9 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r9 > 0) goto L_0x002a
            long r0 = java.lang.System.currentTimeMillis()
            r8.f23066u = r0
        L_0x002a:
            long r0 = java.lang.System.currentTimeMillis()
            long r4 = r8.f23066u
            long r0 = r0 - r4
            float r9 = (float) r0
            r0 = 1148846080(0x447a0000, float:1000.0)
            float r9 = r9 / r0
            r0 = 1101004800(0x41a00000, float:20.0)
            r1 = 6
            int r9 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r9 <= 0) goto L_0x003d
            r3 = 6
        L_0x003d:
            com.didi.hawaii.ar.jni.DARCLocationInScene r9 = r8.f23067v
            if (r9 != 0) goto L_0x0046
            com.didi.hawaii.ar.jni.DARCLocationInScene r9 = r8.f23068w
            r8.f23067v = r9
            goto L_0x00b9
        L_0x0046:
            com.didi.hawaii.ar.jni.DARCLocationInScene r9 = r8.f23068w
            int r9 = r9.getIndex()
            com.didi.hawaii.ar.jni.DARCLocationInScene r0 = r8.f23067v
            int r0 = r0.getIndex()
            if (r9 != r0) goto L_0x00b9
            com.didi.hawaii.ar.jni.DARCLocationInScene r9 = r8.f23068w
            com.didi.hawaii.ar.jni.DARCPoint3F r9 = r9.getPos()
            float r9 = r9.getX()
            com.didi.hawaii.ar.jni.DARCLocationInScene r0 = r8.f23067v
            com.didi.hawaii.ar.jni.DARCPoint3F r0 = r0.getPos()
            float r0 = r0.getX()
            float r9 = r9 - r0
            com.didi.hawaii.ar.jni.DARCLocationInScene r0 = r8.f23068w
            com.didi.hawaii.ar.jni.DARCPoint3F r0 = r0.getPos()
            float r0 = r0.getX()
            com.didi.hawaii.ar.jni.DARCLocationInScene r2 = r8.f23067v
            com.didi.hawaii.ar.jni.DARCPoint3F r2 = r2.getPos()
            float r2 = r2.getX()
            float r0 = r0 - r2
            float r9 = r9 * r0
            com.didi.hawaii.ar.jni.DARCLocationInScene r0 = r8.f23068w
            com.didi.hawaii.ar.jni.DARCPoint3F r0 = r0.getPos()
            float r0 = r0.getZ()
            com.didi.hawaii.ar.jni.DARCLocationInScene r2 = r8.f23067v
            com.didi.hawaii.ar.jni.DARCPoint3F r2 = r2.getPos()
            float r2 = r2.getZ()
            float r0 = r0 - r2
            com.didi.hawaii.ar.jni.DARCLocationInScene r2 = r8.f23068w
            com.didi.hawaii.ar.jni.DARCPoint3F r2 = r2.getPos()
            float r2 = r2.getZ()
            com.didi.hawaii.ar.jni.DARCLocationInScene r4 = r8.f23067v
            com.didi.hawaii.ar.jni.DARCPoint3F r4 = r4.getPos()
            float r4 = r4.getZ()
            float r2 = r2 - r4
            float r0 = r0 * r2
            float r9 = r9 + r0
            double r4 = (double) r9
            double r4 = java.lang.Math.sqrt(r4)
            r6 = 4626322717216342016(0x4034000000000000, double:20.0)
            int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r9 < 0) goto L_0x00b9
            goto L_0x00ba
        L_0x00b9:
            r1 = r3
        L_0x00ba:
            r3 = r1
            goto L_0x00c1
        L_0x00bc:
            r8.f23066u = r1
            goto L_0x00c1
        L_0x00bf:
            r8.f23066u = r1
        L_0x00c1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.hawaii.p118ar.core.modle.ARCoreSession.m16580a(com.didi.hawaii.ar.jni.DARCNAVStatus):int");
    }

    /* renamed from: com.didi.hawaii.ar.core.modle.ARCoreSession$ARPosition */
    static class ARPosition {

        /* renamed from: x */
        float f23072x;

        /* renamed from: y */
        float f23073y;

        /* renamed from: z */
        float f23074z;

        ARPosition(float[] fArr) {
            this.f23072x = fArr[0];
            this.f23073y = fArr[1];
            this.f23074z = fArr[2];
        }
    }

    /* renamed from: com.didi.hawaii.ar.core.modle.ARCoreSession$ARAngle */
    static class ARAngle {

        /* renamed from: x */
        float f23069x;

        /* renamed from: y */
        float f23070y;

        /* renamed from: z */
        float f23071z;

        ARAngle(double[] dArr) {
            this.f23069x = (float) dArr[0];
            this.f23070y = (float) dArr[1];
            this.f23071z = (float) dArr[2];
        }

        public String toString() {
            return "x=" + this.f23069x + "\ty=" + this.f23070y + "\tz=" + this.f23071z;
        }
    }

    /* renamed from: com.didi.hawaii.ar.core.modle.ARCoreSession$NavStartHintData */
    static class NavStartHintData {
        int index;
        long startTime;
        int status;

        /* renamed from: x */
        float f23075x;

        /* renamed from: z */
        float f23076z;

        NavStartHintData() {
        }
    }
}
