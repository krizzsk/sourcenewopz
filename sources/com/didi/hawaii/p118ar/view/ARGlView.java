package com.didi.hawaii.p118ar.view;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.didi.hawaii.p118ar.core.CreateDiARNavViewException;
import com.didi.hawaii.p118ar.core.DiARNavController;
import com.didi.hawaii.p118ar.jni.AREngineJNI;
import com.didi.hawaii.p118ar.jni.DARCNAVCreateData;
import com.didi.hawaii.p118ar.utils.ARAPollo;
import com.didi.hawaii.p118ar.utils.ARCoreCheckerAndGenerator;
import com.didi.hawaii.p118ar.utils.NetStateUtil;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* renamed from: com.didi.hawaii.ar.view.ARGlView */
public class ARGlView extends GLSurfaceView implements GLSurfaceView.Renderer {

    /* renamed from: b */
    private static final int f23356b = ARAPollo.getARNavVersion();

    /* renamed from: c */
    private static final boolean f23357c = ARAPollo.isUseOldBoard();

    /* renamed from: d */
    private static final boolean f23358d = ARAPollo.getUsePDR();

    /* renamed from: e */
    private static final boolean f23359e = ARAPollo.getUsePDRShadow();

    /* renamed from: f */
    private static final boolean f23360f = ARAPollo.getUsePDRFusion();

    /* renamed from: g */
    private static final int f23361g = ARAPollo.getUsePDRTotalDuration();

    /* renamed from: h */
    private static final int f23362h = ARAPollo.getUsePDRCoreDuration();

    /* renamed from: i */
    private static final int f23363i = ARAPollo.getUsePDRInterLocInterval();

    /* renamed from: j */
    private static final int f23364j = ARAPollo.getUsePDRInterLocDistance();

    /* renamed from: k */
    private static final boolean f23365k = ARAPollo.getUsePDRLevelDetection();

    /* renamed from: l */
    private static final boolean f23366l = ARAPollo.getUseARDriftDetectionInInit();

    /* renamed from: m */
    private static final int f23367m = ARAPollo.getARDriftDetectionSpeedInInit();

    /* renamed from: n */
    private static final boolean f23368n = ARAPollo.getUseARDriftDetectionInNavi();

    /* renamed from: o */
    private static final int f23369o = ARAPollo.getARDriftDetectionSpeedInNavi();

    /* renamed from: a */
    private DiARNavController f23370a;

    /* renamed from: p */
    private DARCNAVCreateData f23371p;

    /* renamed from: q */
    private int f23372q;

    /* renamed from: r */
    private int f23373r;

    /* renamed from: com.didi.hawaii.ar.view.ARGlView$LifeCycleCallback */
    public interface LifeCycleCallback {
        void onHostCreated();

        void onHostDestroy();

        void onHostDetached();

        void onHostPause();

        void onHostResume();

        void onHostSizeChanged(int i, int i2);
    }

    public ARGlView(Context context, ViewGroup viewGroup) throws CreateDiARNavViewException {
        super(context);
        this.f23370a = null;
        this.f23372q = 0;
        this.f23373r = 0;
        mo68569a();
        mo68570a(context, viewGroup);
    }

    public ARGlView(Context context, AttributeSet attributeSet) throws CreateDiARNavViewException {
        this(context, attributeSet, 0);
    }

    public ARGlView(Context context, AttributeSet attributeSet, int i) throws CreateDiARNavViewException {
        super(context);
        this.f23370a = null;
        this.f23372q = 0;
        this.f23373r = 0;
        mo68569a();
        mo68570a(context, (ViewGroup) getParent());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo68569a() {
        setPreserveEGLContextOnPause(true);
        setEGLContextClientVersion(2);
        setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        setRenderer(this);
        setRenderMode(1);
        setWillNotDraw(false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo68570a(Context context, ViewGroup viewGroup) throws CreateDiARNavViewException {
        try {
            DARCNAVCreateData alloc = DARCNAVCreateData.alloc();
            this.f23371p = alloc;
            AREngineJNI.DARCNAVCreateData_containerView_set(alloc, viewGroup);
            this.f23371p.setDataPath("file");
            this.f23371p.setDataIsSimple(false);
            this.f23371p.setNetworkStatus(NetStateUtil.convertNetworkeStateJava2AR(NetStateUtil.getNetworkState()));
            this.f23371p.setUid(ARCoreCheckerAndGenerator.cacheResponseData.getArRequestOption().getmUID());
            String orderID = ARCoreCheckerAndGenerator.cacheResponseData.getArRequestOption().getOrderID();
            if (!TextUtils.isEmpty(orderID)) {
                this.f23371p.setOrderID(AREngineJNI.encryptStringWrap(orderID, orderID.length()));
            }
            this.f23371p.setAskData(ARCoreCheckerAndGenerator.cacheResponseData.getcResData());
            this.f23371p.setLocVersion(f23356b);
            this.f23371p.setUseOldBoard(f23357c);
            this.f23371p.setPDREnabled(f23358d);
            this.f23371p.setPDRShadowEnabled(f23359e);
            this.f23371p.setPDRFusionEnable(f23360f);
            this.f23371p.setPDRTotalDuration(f23361g);
            this.f23371p.setPDRCoreDuration(f23362h);
            this.f23371p.setPDRInterLocInterval(f23363i);
            this.f23371p.setPDRInterLocDistance(f23364j);
            this.f23371p.setPDRLevelDetectionEnable(f23365k);
            this.f23371p.setARDriftDetectionInInitEnable(f23366l);
            this.f23371p.setARDriftDetectionInInitSpeed((float) f23367m);
            this.f23371p.setARDriftDetectionInNaviEnable(f23368n);
            this.f23371p.setARDriftDetectionInNaviSpeed((float) f23369o);
            this.f23370a = new DiARNavController(this.f23371p, context, viewGroup);
        } catch (Exception unused) {
            throw new CreateDiARNavViewException();
        }
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        GLES20.glClearColor(0.1f, 0.1f, 0.1f, 1.0f);
        this.f23370a.onHostCreated();
    }

    public void onSurfaceChanged(GL10 gl10, int i, int i2) {
        GLES20.glViewport(0, 0, i, i2);
        this.f23372q = i;
        this.f23373r = i2;
        this.f23370a.onHostSizeChanged(i, i2);
    }

    public void onDrawFrame(GL10 gl10) {
        GLES20.glClear(16640);
        this.f23370a.drawFrame();
    }

    public DiARNavController getDiARController() {
        return this.f23370a;
    }

    public void onDestroy() {
        this.f23370a.onHostDestroy();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f23370a.onHostDetached();
    }

    public void onResume() {
        this.f23370a.onHostResume();
        super.onResume();
    }

    public void onPause() {
        super.onPause();
        this.f23370a.onHostPause();
    }
}
