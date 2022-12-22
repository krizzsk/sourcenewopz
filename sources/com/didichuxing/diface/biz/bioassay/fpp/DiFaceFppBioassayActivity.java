package com.didichuxing.diface.biz.bioassay.fpp;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.view.dialog.ProgressDialogFragment;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.dfbasesdk.utils.NetworkUtils;
import com.didichuxing.dfbasesdk.utils.OpenGLUtil;
import com.didichuxing.diface.DiFaceResult;
import com.didichuxing.diface.biz.bioassay.fpp.p182M.compare.CompareModel;
import com.didichuxing.diface.biz.bioassay.fpp.p182M.compare.CompareParam;
import com.didichuxing.diface.biz.bioassay.fpp.p182M.compare.CompareResult;
import com.didichuxing.diface.biz.bioassay.fpp.p182M.report_failed.ReportFailedModel;
import com.didichuxing.diface.biz.bioassay.fpp.p182M.report_failed.ReportFailedParam;
import com.didichuxing.diface.biz.bioassay.fpp.p182M.report_failed.ReportFailedResult;
import com.didichuxing.diface.biz.bioassay.fpp.util.DialogUtil;
import com.didichuxing.diface.biz.bioassay.fpp.util.ICamera;
import com.didichuxing.diface.biz.bioassay.fpp.util.IDetection;
import com.didichuxing.diface.biz.bioassay.fpp.util.IMediaPlayer;
import com.didichuxing.diface.biz.bioassay.fpp.util.Screen;
import com.didichuxing.diface.biz.bioassay.fpp.util.SensorUtil;
import com.didichuxing.diface.biz.bioassay.fpp.view.AutoRatioImageView;
import com.didichuxing.diface.biz.bioassay.fpp.view.CircleProgressBar;
import com.didichuxing.diface.biz.bioassay.fpp.view.FaceMask;
import com.didichuxing.diface.biz.bioassay.video_capture.CameraMatrix;
import com.didichuxing.diface.biz.bioassay.video_capture.DiFaceVideoCaptureManager;
import com.didichuxing.diface.biz.guide.GuideHelper;
import com.didichuxing.diface.biz.guide.p183M.GuideResult;
import com.didichuxing.diface.core.DiFaceFacade;
import com.didichuxing.diface.core.MVP.DiFaceBaseActivity;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.didichuxing.diface.utils.DFileUtils;
import com.didichuxing.diface.utils.ToastUtil;
import com.didichuxing.diface.utils.http.AbsHttpCallback;
import com.megvii.livenessdetection.DetectionConfig;
import com.megvii.livenessdetection.DetectionFrame;
import com.megvii.livenessdetection.Detector;
import com.megvii.livenessdetection.FaceQualityManager;
import com.megvii.livenessdetection.bean.FaceIDDataStruct;
import com.megvii.livenessdetection.bean.FaceInfo;
import com.taxis99.R;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class DiFaceFppBioassayActivity extends DiFaceBaseActivity implements Camera.PreviewCallback, TextureView.SurfaceTextureListener, Detector.DetectionListener {
    /* access modifiers changed from: private */

    /* renamed from: A */
    public final float[] f47181A = new float[16];
    /* access modifiers changed from: private */

    /* renamed from: B */
    public final float[] f47182B = new float[16];
    /* access modifiers changed from: private */

    /* renamed from: C */
    public GLSurfaceView f47183C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public SurfaceTexture f47184D;

    /* renamed from: E */
    private int f47185E = 0;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public CameraMatrix f47186F;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public DiFaceVideoCaptureManager f47187G;

    /* renamed from: H */
    private boolean f47188H;

    /* renamed from: I */
    private boolean f47189I;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public GuideResult f47190J;

    /* renamed from: K */
    private GuideResult.Result.CaptureInfo f47191K;

    /* renamed from: L */
    private DFileUtils f47192L;

    /* renamed from: M */
    private Runnable f47193M = new Runnable() {
        public void run() {
            DiFaceFppBioassayActivity.this.m33855h();
            if (DiFaceFppBioassayActivity.this.f47215q.mDetectionSteps != null) {
                DiFaceFppBioassayActivity diFaceFppBioassayActivity = DiFaceFppBioassayActivity.this;
                diFaceFppBioassayActivity.changeType(diFaceFppBioassayActivity.f47215q.mDetectionSteps.get(0), 10);
            }
        }
    };

    /* renamed from: N */
    private int f47194N = 0;
    /* access modifiers changed from: private */

    /* renamed from: O */
    public CompareResult f47195O;
    /* access modifiers changed from: private */

    /* renamed from: P */
    public boolean f47196P;

    /* renamed from: Q */
    private int f47197Q = 0;

    /* renamed from: R */
    private boolean f47198R = false;

    /* renamed from: a */
    String f47199a;

    /* renamed from: b */
    String f47200b;

    /* renamed from: c */
    private TextureView f47201c;

    /* renamed from: d */
    private FaceMask f47202d;

    /* renamed from: e */
    private LinearLayout f47203e;

    /* renamed from: f */
    private RelativeLayout f47204f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public TextView f47205g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public RelativeLayout f47206h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public CircleProgressBar f47207i;

    /* renamed from: j */
    private AutoRatioImageView f47208j;

    /* renamed from: k */
    private Detector f47209k;

    /* renamed from: l */
    private ICamera f47210l;

    /* renamed from: m */
    private Handler f47211m;

    /* renamed from: n */
    private HandlerThread f47212n = new HandlerThread("videoEncoder");

    /* renamed from: o */
    private Handler f47213o;

    /* renamed from: p */
    private IMediaPlayer f47214p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public IDetection f47215q;

    /* renamed from: r */
    private DialogUtil f47216r;

    /* renamed from: s */
    private TextView f47217s;

    /* renamed from: t */
    private ImageView f47218t;

    /* renamed from: u */
    private boolean f47219u;

    /* renamed from: v */
    private FaceQualityManager f47220v;

    /* renamed from: w */
    private SensorUtil f47221w;

    /* renamed from: x */
    private int f47222x;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public ProgressDialogFragment f47223y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public final float[] f47224z = new float[16];

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_di_face_fpp_bioassay_layout);
        m33843b();
    }

    /* renamed from: b */
    private void m33843b() {
        DiFaceFacade.getInstance().report("11");
        this.f47190J = (GuideResult) getIntent().getSerializableExtra(GuideHelper.EXTRA_KEY_GUIDE_RESULT);
        this.f47221w = new SensorUtil(this);
        Screen.initialize(this);
        this.f47211m = new Handler();
        this.f47212n.start();
        this.f47213o = new Handler(this.f47212n.getLooper());
        this.f47214p = new IMediaPlayer(this);
        this.f47216r = new DialogUtil(this);
        ICamera iCamera = new ICamera();
        this.f47210l = iCamera;
        iCamera.addAllFlipCameraType(this.f47190J.data.result.flipCameraType);
        ProgressDialogFragment progressDialogFragment = new ProgressDialogFragment();
        this.f47223y = progressDialogFragment;
        progressDialogFragment.setContent(getString(R.string.df_fpp_act_loading_msg), false);
        if (this.f47190J.data.result.changeVolume != -1.0f) {
            com.didichuxing.diface.utils.SystemUtils.changeAppBrightness(this, 255);
            this.f47222x = com.didichuxing.diface.utils.SystemUtils.getMediaVolume(this);
            com.didichuxing.diface.utils.SystemUtils.changeMediaVolume(this, (int) (this.f47190J.data.result.changeVolume * ((float) com.didichuxing.diface.utils.SystemUtils.getMediaMaxVolume(this))));
            LogUtils.m33563d("change volume to " + this.f47190J.data.result.changeVolume);
        }
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.liveness_layout_rootRel);
        this.f47204f = relativeLayout;
        this.f47215q = new IDetection(this, relativeLayout);
        this.f47202d = (FaceMask) findViewById(R.id.liveness_layout_facemask);
        this.f47208j = (AutoRatioImageView) findViewById(R.id.liveness_layout_head_mask);
        this.f47217s = (TextView) findViewById(R.id.liveness_layout_promptText);
        this.f47201c = (TextureView) findViewById(R.id.liveness_layout_textureview);
        this.f47223y.dismiss();
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.liveness_layout_bottom_tips_head);
        this.f47203e = linearLayout;
        linearLayout.setVisibility(0);
        this.f47206h = (RelativeLayout) findViewById(R.id.detection_step_timeoutRel);
        this.f47205g = (TextView) findViewById(R.id.detection_step_timeout_garden);
        this.f47207i = (CircleProgressBar) findViewById(R.id.detection_step_timeout_progressBar);
        ImageView imageView = (ImageView) findViewById(R.id.iv_back);
        this.f47218t = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_BIOASSAY_EXIT, DiFaceLogger.getExitType("2"), (HashMap<String, Object>) null);
                DiFaceFppBioassayActivity.this.finishWithResult(new DiFaceResult(102));
            }
        });
        this.f47183C = (GLSurfaceView) findViewById(R.id.liveness_layout_cameraView);
        this.f47188H = m33847d();
        LogUtils.m33563d("isRecordVideo -> " + this.f47188H);
        if (this.f47188H) {
            this.f47183C.setEGLContextClientVersion(2);
            this.f47183C.setRenderer(new GLSurfaceView.Renderer() {
                public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
                    GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
                    DiFaceFppBioassayActivity.this.m33850e();
                }

                public void onSurfaceChanged(GL10 gl10, int i, int i2) {
                    GLES20.glViewport(0, 0, i, i2);
                    Matrix.frustumM(DiFaceFppBioassayActivity.this.f47181A, 0, -1.0f, 1.0f, -1.0f, 1.0f, 3.0f, 7.0f);
                }

                public void onDrawFrame(GL10 gl10) {
                    GLES20.glClear(16640);
                    Matrix.setLookAtM(DiFaceFppBioassayActivity.this.f47182B, 0, 0.0f, 0.0f, -3.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
                    Matrix.multiplyMM(DiFaceFppBioassayActivity.this.f47224z, 0, DiFaceFppBioassayActivity.this.f47181A, 0, DiFaceFppBioassayActivity.this.f47182B, 0);
                    DiFaceFppBioassayActivity.this.f47184D.updateTexImage();
                    float[] fArr = new float[16];
                    DiFaceFppBioassayActivity.this.f47184D.getTransformMatrix(fArr);
                    DiFaceFppBioassayActivity.this.f47186F.draw(fArr);
                    DiFaceFppBioassayActivity.this.f47184D.updateTexImage();
                    synchronized (this) {
                        DiFaceFppBioassayActivity.this.f47187G.frameAvailable(fArr);
                    }
                }
            });
            this.f47183C.setRenderMode(1);
        }
    }

    /* renamed from: c */
    private void m33845c() {
        if (this.f47188H) {
            this.f47183C.setVisibility(0);
            this.f47201c.setVisibility(8);
        } else {
            this.f47183C.setVisibility(8);
            this.f47201c.setVisibility(0);
            this.f47201c.setSurfaceTextureListener(this);
        }
        this.f47215q.viewsInit();
    }

    /* renamed from: d */
    private boolean m33847d() {
        if (Build.VERSION.SDK_INT < 16 || DiFaceFacade.getInstance().isCaptureUploaded()) {
            return false;
        }
        GuideResult.Result.CaptureInfo captureInfo = this.f47190J.data.result.captureInfo;
        this.f47191K = captureInfo;
        if (captureInfo == null) {
            return false;
        }
        return captureInfo.captureEnable;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m33850e() {
        this.f47185E = OpenGLUtil.createTextureID();
        this.f47184D = new SurfaceTexture(this.f47185E);
        this.f47187G.startRecording(this, this.f47185E);
        LogUtils.m33563d("start bioassay capture");
        this.f47211m.postDelayed(new Runnable() {
            public void run() {
                DiFaceFppBioassayActivity.this.m33860j();
            }
        }, (long) (this.f47191K.maxTime * 1000));
        this.f47184D.setOnFrameAvailableListener(new SurfaceTexture.OnFrameAvailableListener() {
            public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                DiFaceFppBioassayActivity.this.f47183C.requestRender();
            }
        });
        this.f47186F = new CameraMatrix(this.f47185E);
        this.f47210l.startPreview(this.f47184D);
        this.f47210l.actionDetect(this);
        this.f47209k.setDetectionListener(this);
    }

    /* renamed from: f */
    private void m33852f() {
        this.f47209k = new Detector(this, new DetectionConfig.Builder().setDetectionTimeout(10000).build());
        this.f47216r.showDialog(getString(R.string.meglive_detect_initfailed));
        new Thread(new Runnable() {
            public void run() {
                if (DiFaceFppBioassayActivity.this.f47215q != null) {
                    DiFaceFppBioassayActivity.this.f47215q.animationInit();
                }
            }
        }).start();
        this.f47192L = new DFileUtils(this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        new C15441a(this).execute(new Void[0]);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo116206a() {
        return this.f47210l.openCamera(this, this.f47188H);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo116207a(int i) {
        if (this.f47189I) {
            this.f47210l.closeCamera();
        } else if (i == -1) {
            this.f47216r.showDialog(getString(R.string.meglive_camera_initfailed));
        } else {
            m33845c();
            m33852f();
            this.f47219u = false;
            FaceMask faceMask = this.f47202d;
            boolean z = true;
            if (i != 1) {
                z = false;
            }
            faceMask.setFrontal(z);
            RelativeLayout.LayoutParams layoutParam = this.f47210l.getLayoutParam();
            if (this.f47188H) {
                this.f47183C.setVisibility(0);
                this.f47183C.setLayoutParams(layoutParam);
                this.f47187G = new DiFaceVideoCaptureManager(this.f47210l.cameraWidth, this.f47210l.cameraHeight, true, this.f47183C, this.f47191K.bpp, this.f47191K.fps);
                this.f47183C.onResume();
            } else {
                this.f47201c.setVisibility(0);
                this.f47201c.setLayoutParams(layoutParam);
            }
            this.f47202d.setLayoutParams(layoutParam);
            FaceQualityManager faceQualityManager = new FaceQualityManager(0.5f, 0.6f);
            this.f47220v = faceQualityManager;
            faceQualityManager.faceMaxSizeRatioThreshold = 0.5f;
            this.f47220v.faceWidthThreshold = 100.0f;
            this.f47220v.minBrightnessThreshold = (float) this.f47190J.data.result.minBrightness;
            this.f47220v.maxBrightnessThreshold = (float) this.f47190J.data.result.maxBrightness;
            this.f47215q.mCurShowIndex = -1;
        }
    }

    /* renamed from: g */
    private void m33854g() {
        if (!this.f47219u) {
            this.f47219u = true;
            DiFaceFacade.getInstance().report("12");
            this.f47208j.setImageResource(R.drawable.bioassay_head_mask_finish);
            Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.liveness_rightin);
            Animation loadAnimation2 = AnimationUtils.loadAnimation(this, R.anim.liveness_leftout);
            this.f47203e.startAnimation(loadAnimation2);
            this.f47215q.mAnimViews[0].setVisibility(0);
            this.f47215q.mAnimViews[0].startAnimation(loadAnimation);
            loadAnimation2.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    DiFaceFppBioassayActivity.this.f47206h.setVisibility(0);
                }
            });
            this.f47211m.post(this.f47193M);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m33855h() {
        if (this.f47210l.mCamera != null) {
            this.f47223y.dismiss();
            this.f47215q.detectionTypeInit(this.f47190J.data.result.plan_content.face_plus_action);
            this.f47197Q = 0;
            this.f47209k.reset();
            this.f47209k.changeDetectionType(this.f47215q.mDetectionSteps.get(0));
        }
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        ICamera iCamera = this.f47210l;
        if (iCamera != null && iCamera.isOpen()) {
            int cameraAngle = 360 - this.f47210l.getCameraAngle(this);
            if (this.f47210l.cameraId == 0) {
                cameraAngle -= 180;
            }
            this.f47209k.doDetection(bArr, this.f47210l.cameraWidth, this.f47210l.cameraHeight, cameraAngle);
        }
    }

    public Detector.DetectionType onDetectionSuccess(DetectionFrame detectionFrame) {
        this.f47214p.reset();
        this.f47197Q++;
        this.f47202d.setFaceInfo((DetectionFrame) null);
        if (this.f47197Q == this.f47215q.mDetectionSteps.size()) {
            this.f47223y.show(getSupportFragmentManager(), "");
            m33858i();
        } else {
            changeType(this.f47215q.mDetectionSteps.get(this.f47197Q), 10);
        }
        if (this.f47197Q >= this.f47215q.mDetectionSteps.size()) {
            return Detector.DetectionType.DONE;
        }
        return this.f47215q.mDetectionSteps.get(this.f47197Q);
    }

    /* renamed from: i */
    private void m33858i() {
        FaceIDDataStruct faceIDDataStruct = this.f47209k.getFaceIDDataStruct();
        m33833a((int) R.string.verify_success, faceIDDataStruct.delta, faceIDDataStruct.images);
    }

    public void onDetectionFailed(Detector.DetectionFailedType detectionFailedType) {
        m33839a(detectionFailedType);
    }

    public void onFrameDetected(long j, DetectionFrame detectionFrame) {
        m33838a(detectionFrame);
        handleNotPass(j);
        this.f47202d.setFaceInfo(detectionFrame);
    }

    /* renamed from: a */
    private void m33838a(DetectionFrame detectionFrame) {
        FaceInfo faceInfo;
        this.f47194N++;
        if (!(detectionFrame == null || (faceInfo = detectionFrame.getFaceInfo()) == null)) {
            if (((double) faceInfo.eyeLeftOcclusion) > 0.5d || ((double) faceInfo.eyeRightOcclusion) > 0.5d) {
                if (this.f47194N > 10) {
                    this.f47194N = 0;
                    this.f47217s.setText(R.string.meglive_keep_eyes_open);
                    return;
                }
                return;
            } else if (((double) faceInfo.mouthOcclusion) <= 0.5d) {
                this.f47215q.checkFaceTooLarge(faceInfo.faceTooLarge);
            } else if (this.f47194N > 10) {
                this.f47194N = 0;
                this.f47217s.setText(R.string.meglive_keep_mouth_open);
                return;
            } else {
                return;
            }
        }
        faceInfoChecker(this.f47220v.feedFrame(detectionFrame));
    }

    public void faceInfoChecker(List<FaceQualityManager.FaceQualityErrorType> list) {
        String str;
        if (list == null || list.size() == 0) {
            m33854g();
            return;
        }
        FaceQualityManager.FaceQualityErrorType faceQualityErrorType = list.get(0);
        if (faceQualityErrorType == FaceQualityManager.FaceQualityErrorType.FACE_NOT_FOUND) {
            str = getString(R.string.face_not_found);
        } else if (faceQualityErrorType == FaceQualityManager.FaceQualityErrorType.FACE_POS_DEVIATED) {
            str = getString(R.string.face_not_found);
        } else if (faceQualityErrorType == FaceQualityManager.FaceQualityErrorType.FACE_NONINTEGRITY) {
            str = getString(R.string.face_not_found);
        } else if (faceQualityErrorType == FaceQualityManager.FaceQualityErrorType.FACE_TOO_DARK) {
            str = getString(R.string.face_too_dark);
        } else if (faceQualityErrorType == FaceQualityManager.FaceQualityErrorType.FACE_TOO_BRIGHT) {
            str = getString(R.string.face_too_bright);
        } else if (faceQualityErrorType == FaceQualityManager.FaceQualityErrorType.FACE_TOO_SMALL) {
            str = getString(R.string.face_too_small);
        } else if (faceQualityErrorType == FaceQualityManager.FaceQualityErrorType.FACE_TOO_LARGE) {
            str = getString(R.string.face_too_large);
        } else if (faceQualityErrorType == FaceQualityManager.FaceQualityErrorType.FACE_TOO_BLURRY) {
            str = getString(R.string.face_too_blurry);
        } else {
            str = faceQualityErrorType == FaceQualityManager.FaceQualityErrorType.FACE_OUT_OF_RECT ? getString(R.string.face_out_of_rect) : "";
        }
        if (this.f47194N > 10) {
            this.f47194N = 0;
            this.f47217s.setText(str);
        }
    }

    /* renamed from: a */
    private void m33833a(int i, String str, Map<String, byte[]> map) {
        m33860j();
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_BIOASSAY_ACTION_SUCCESS);
        this.f47192L.saveValidFrames(map, this.f47190J.data.result.plan_content.face_plus_upload);
        CompareParam compareParam = new CompareParam();
        compareParam.token = this.f47190J.token;
        compareParam.sessionId = DiFaceFacade.getInstance().getSessionId();
        compareParam.delta = str;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String fileDirPath = DFileUtils.getFileDirPath(this);
        if (!TextUtils.isEmpty(this.f47192L.getFpBestImagePath())) {
            arrayList.add("bestPic");
            arrayList2.add(new File(fileDirPath, this.f47192L.getFpBestImagePath()));
        }
        if (!TextUtils.isEmpty(this.f47192L.getFpEnvImagePath())) {
            arrayList.add("envPic");
            arrayList2.add(new File(fileDirPath, this.f47192L.getFpEnvImagePath()));
        }
        if (this.f47192L.getAllFramesImagePaths() != null && !this.f47192L.getAllFramesImagePaths().isEmpty()) {
            for (int i2 = 0; i2 < this.f47192L.getAllFramesImagePaths().size(); i2++) {
                arrayList.add("actionPic" + i2);
                arrayList2.add(new File(fileDirPath, this.f47192L.getAllFramesImagePaths().get(i2)));
            }
        }
        m33837a(compareParam, (List<String>) arrayList, (List<File>) arrayList2);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33837a(final CompareParam compareParam, final List<String> list, final List<File> list2) {
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_COMPARE_REQUEST_LAUNCH);
        new CompareModel(this).compare(compareParam, list, list2, new AbsHttpCallback<CompareResult>() {
            public void onSuccess(CompareResult compareResult) {
                DiFaceFppBioassayActivity.this.f47223y.dismiss();
                CompareResult unused = DiFaceFppBioassayActivity.this.f47195O = compareResult;
                int i = DiFaceFppBioassayActivity.this.f47195O.data.code;
                String str = DiFaceFppBioassayActivity.this.f47195O.data.message;
                String str2 = DiFaceFppBioassayActivity.this.f47195O.data.result.session_id;
                DiFaceFppBioassayActivity.this.m33841a(str2);
                boolean z = false;
                if (i == 100000) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("result", "success");
                    DiFaceFacade.getInstance().report("16", (HashMap<String, Object>) hashMap, (HashMap<String, Object>) null);
                    DiFaceFppBioassayActivity.this.finishWithResult(new DiFaceResult(str2, 0));
                    return;
                }
                if (!(DiFaceFppBioassayActivity.this.f47195O.data.result == null || DiFaceFppBioassayActivity.this.f47195O.data.result.appealInfo == null)) {
                    z = DiFaceFppBioassayActivity.this.f47195O.data.result.show_appeal_entry;
                }
                if (z) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("hintForUser", DiFaceFppBioassayActivity.this.getString(R.string.df_fpp_act_face_recognition_failed));
                    hashMap2.put("token", DiFaceFppBioassayActivity.this.f47190J.token);
                    hashMap2.put("idCard", DiFaceFppBioassayActivity.this.f47195O.data.result.appealInfo.idCard);
                    hashMap2.put("name", DiFaceFppBioassayActivity.this.f47195O.data.result.appealInfo.name);
                    DiFaceFppBioassayActivity.this.finishWithResult(new DiFaceResult(str2, 1011, (Map<String, Object>) hashMap2));
                    return;
                }
                onFailed(i, str);
            }

            public void onFailed(int i, String str) {
                String str2;
                LogUtils.m33563d("compare failed, code======" + i + ", msg=" + str);
                HashMap hashMap = new HashMap();
                hashMap.put("result", i + ":" + str);
                DiFaceFacade.getInstance().report("16", (HashMap<String, Object>) hashMap, (HashMap<String, Object>) null);
                DiFaceFppBioassayActivity.this.f47223y.dismiss();
                if (DiFaceFppBioassayActivity.this.f47195O == null || DiFaceFppBioassayActivity.this.f47195O.data == null || DiFaceFppBioassayActivity.this.f47195O.data.result == null) {
                    str2 = "";
                } else {
                    str2 = DiFaceFppBioassayActivity.this.f47195O.data.result.session_id;
                }
                if (i == 100001) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("hintForUser", DiFaceFppBioassayActivity.this.getString(R.string.df_fpp_act_face_recognition_failed));
                    DiFaceFppBioassayActivity.this.finishWithResult(new DiFaceResult(str2, 103, (Map<String, Object>) hashMap2));
                } else if (i == 100002) {
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("message", str);
                    DiFaceFppBioassayActivity.this.finishWithResult(new DiFaceResult(str2, 104, (Map<String, Object>) hashMap3));
                } else if (i == 100003) {
                    HashMap hashMap4 = new HashMap();
                    hashMap4.put("message", str);
                    DiFaceFppBioassayActivity.this.finishWithResult(new DiFaceResult(str2, 2, (Map<String, Object>) hashMap4));
                } else if (i == 999999) {
                    new Bundle().putString("message", str);
                    DiFaceFppBioassayActivity.this.finishWithResult(new DiFaceResult(107));
                } else if (DiFaceFppBioassayActivity.this.f47196P) {
                    boolean unused = DiFaceFppBioassayActivity.this.f47196P = false;
                    DiFaceFppBioassayActivity.this.finishWithResult(new DiFaceResult(3));
                } else if (NetworkUtils.isNetworkConnected(DiFaceFppBioassayActivity.this)) {
                    boolean unused2 = DiFaceFppBioassayActivity.this.f47196P = true;
                    DiFaceFppBioassayActivity.this.f47223y.show(DiFaceFppBioassayActivity.this.getSupportFragmentManager(), "");
                    DiFaceFppBioassayActivity.this.m33837a(compareParam, (List<String>) list, (List<File>) list2);
                } else {
                    ToastUtil.showToastInfo((Context) DiFaceFppBioassayActivity.this, (int) R.string.df_no_net_connected_toast);
                    DiFaceFppBioassayActivity.this.finishWithResult(new DiFaceResult(112));
                }
            }
        });
    }

    /* renamed from: a */
    private void m33839a(final Detector.DetectionFailedType detectionFailedType) {
        m33860j();
        final String log = this.f47209k.getLog();
        this.f47199a = getString(R.string.df_fpp_act_face_recognition_failed_retry);
        this.f47200b = detectionFailedType.toString();
        switch (C1543011.f47225x49054cfa[detectionFailedType.ordinal()]) {
            case 1:
                this.f47199a = getString(R.string.df_fpp_act_hint_for_user1);
                this.f47200b = getString(R.string.df_fpp_act_hint_for_server1);
                break;
            case 2:
                this.f47199a = getString(R.string.df_fpp_act_hint_for_user2);
                this.f47200b = getString(R.string.df_fpp_act_hint_for_server2);
                break;
            case 3:
                this.f47199a = getString(R.string.df_fpp_act_hint_for_user3);
                this.f47200b = getString(R.string.df_fpp_act_hint_for_server3);
                break;
            case 4:
                this.f47200b = getString(R.string.df_fpp_act_hint_for_server4);
                break;
            case 5:
                this.f47200b = getString(R.string.df_fpp_act_hint_for_server5);
                break;
            case 6:
                this.f47200b = getString(R.string.df_fpp_act_hint_for_server6);
                break;
            case 7:
                this.f47200b = getString(R.string.df_fpp_act_hint_for_server7);
                break;
        }
        LogUtils.m33563d("活体检测失败: " + this.f47200b + "\n" + log);
        ReportFailedParam reportFailedParam = new ReportFailedParam();
        GuideResult guideResult = this.f47190J;
        if (!(guideResult == null || guideResult.data == null || this.f47190J.data.result == null)) {
            reportFailedParam.facePlan = this.f47190J.data.result.plan_code;
        }
        reportFailedParam.aliveErrorCode = detectionFailedType.name();
        reportFailedParam.aliveErrorMsg = this.f47200b + ":" + log;
        reportFailedParam.token = this.f47190J.token;
        reportFailedParam.sessionId = DiFaceFacade.getInstance().getSessionId();
        this.f47223y.show(getSupportFragmentManager(), "");
        new ReportFailedModel(this).report(reportFailedParam, new AbsHttpCallback<ReportFailedResult>() {
            public void onSuccess(ReportFailedResult reportFailedResult) {
                DiFaceFppBioassayActivity.this.f47223y.dismiss();
                int i = reportFailedResult.data.code;
                String str = reportFailedResult.data.message;
                if (i == 100000) {
                    if (!TextUtils.isEmpty(reportFailedResult.data.result.session_id)) {
                        DiFaceFppBioassayActivity.this.m33841a(reportFailedResult.data.result.session_id);
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("errorType", detectionFailedType.name());
                    hashMap.put("errorHint", DiFaceFppBioassayActivity.this.f47200b);
                    hashMap.put("errorLog", log);
                    DiFaceFacade.getInstance().report("14", (HashMap<String, Object>) hashMap, (HashMap<String, Object>) null);
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("hintForUser", DiFaceFppBioassayActivity.this.f47199a);
                    DiFaceFppBioassayActivity.this.finishWithResult(new DiFaceResult((String) null, 1009, (Map<String, Object>) hashMap2));
                    return;
                }
                onFailed(i, str);
            }

            public void onFailed(int i, String str) {
                DiFaceFppBioassayActivity.this.f47223y.dismiss();
                HashMap hashMap = new HashMap();
                hashMap.put("errorType", detectionFailedType.name());
                hashMap.put("errorHint", DiFaceFppBioassayActivity.this.f47200b);
                hashMap.put("errorLog", log);
                DiFaceFacade.getInstance().report("14", (HashMap<String, Object>) hashMap, (HashMap<String, Object>) null);
                HashMap hashMap2 = new HashMap();
                hashMap2.put("hintForUser", DiFaceFppBioassayActivity.this.f47199a);
                DiFaceFppBioassayActivity.this.finishWithResult(new DiFaceResult((String) null, 1009, (Map<String, Object>) hashMap2));
            }
        });
    }

    /* renamed from: com.didichuxing.diface.biz.bioassay.fpp.DiFaceFppBioassayActivity$11 */
    static /* synthetic */ class C1543011 {

        /* renamed from: $SwitchMap$com$megvii$livenessdetection$Detector$DetectionFailedType */
        static final /* synthetic */ int[] f47225x49054cfa;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.megvii.livenessdetection.Detector$DetectionFailedType[] r0 = com.megvii.livenessdetection.Detector.DetectionFailedType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f47225x49054cfa = r0
                com.megvii.livenessdetection.Detector$DetectionFailedType r1 = com.megvii.livenessdetection.Detector.DetectionFailedType.ACTIONBLEND     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f47225x49054cfa     // Catch:{ NoSuchFieldError -> 0x001d }
                com.megvii.livenessdetection.Detector$DetectionFailedType r1 = com.megvii.livenessdetection.Detector.DetectionFailedType.NOTVIDEO     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f47225x49054cfa     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.megvii.livenessdetection.Detector$DetectionFailedType r1 = com.megvii.livenessdetection.Detector.DetectionFailedType.TIMEOUT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f47225x49054cfa     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.megvii.livenessdetection.Detector$DetectionFailedType r1 = com.megvii.livenessdetection.Detector.DetectionFailedType.MASK     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f47225x49054cfa     // Catch:{ NoSuchFieldError -> 0x003e }
                com.megvii.livenessdetection.Detector$DetectionFailedType r1 = com.megvii.livenessdetection.Detector.DetectionFailedType.FACENOTCONTINUOUS     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f47225x49054cfa     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.megvii.livenessdetection.Detector$DetectionFailedType r1 = com.megvii.livenessdetection.Detector.DetectionFailedType.TOOMANYFACELOST     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f47225x49054cfa     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.megvii.livenessdetection.Detector$DetectionFailedType r1 = com.megvii.livenessdetection.Detector.DetectionFailedType.FACELOSTNOTCONTINUOUS     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.diface.biz.bioassay.fpp.DiFaceFppBioassayActivity.C1543011.<clinit>():void");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m33860j() {
        DiFaceVideoCaptureManager diFaceVideoCaptureManager;
        if (this.f47188H && this.f47187G.isRecording() && (diFaceVideoCaptureManager = this.f47187G) != null) {
            diFaceVideoCaptureManager.stopRecording();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33841a(String str) {
        if (this.f47188H) {
            String videoPath = this.f47187G.getVideoPath();
            if (TextUtils.isEmpty(videoPath)) {
                LogUtils.m33563d("video capture videoPath empty");
            } else if (TextUtils.isEmpty(str)) {
                LogUtils.m33563d("video capture sessionId empty");
            } else {
                File file = new File(videoPath);
                long length = file.length() / 1024;
                LogUtils.m33563d("video capture succeed in: " + videoPath + ", and size is " + length + "KB");
                if (NetworkUtils.isWifi(this)) {
                    if (length <= ((long) (this.f47191K.thresholdWifi * 1024))) {
                        m33840a(file, str);
                    } else {
                        file.delete();
                    }
                } else if (!NetworkUtils.is4G(this)) {
                    file.delete();
                } else if (length <= ((long) (this.f47191K.threshold4G * 1024))) {
                    m33840a(file, str);
                } else {
                    file.delete();
                }
            }
        }
    }

    /* renamed from: a */
    private void m33840a(File file, String str) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add("video");
        arrayList2.add(file);
        DiFaceFacade.getInstance().uploadCapture(str, arrayList, arrayList2);
    }

    public void changeType(Detector.DetectionType detectionType, long j) {
        this.f47215q.changeType(detectionType, j);
        this.f47202d.setFaceInfo((DetectionFrame) null);
        if (this.f47197Q == 0) {
            IMediaPlayer iMediaPlayer = this.f47214p;
            iMediaPlayer.doPlay(iMediaPlayer.getSoundRes(detectionType));
            return;
        }
        this.f47214p.setOnCompletionListener(detectionType);
    }

    public void handleNotPass(final long j) {
        if (j > 0) {
            this.f47211m.post(new Runnable() {
                public void run() {
                    TextView q = DiFaceFppBioassayActivity.this.f47205g;
                    q.setText((j / 1000) + "");
                    DiFaceFppBioassayActivity.this.f47207i.setProgress((int) (j / 100));
                }
            });
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f47198R = true;
        m33862k();
        this.f47209k.setDetectionListener(this);
        this.f47210l.actionDetect(this);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.f47198R = false;
        return false;
    }

    /* renamed from: k */
    private void m33862k() {
        if (this.f47198R) {
            this.f47210l.startPreview(this.f47201c.getSurfaceTexture());
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f47189I = true;
        this.f47211m.removeCallbacksAndMessages((Object) null);
        if (this.f47188H) {
            this.f47183C.onPause();
            if (this.f47187G != null) {
                m33860j();
                String videoPath = this.f47187G.getVideoPath();
                if (!TextUtils.isEmpty(videoPath)) {
                    File file = new File(videoPath);
                    if (file.exists()) {
                        file.delete();
                    }
                }
            }
        }
        this.f47210l.closeCamera();
        this.f47214p.close();
        HashMap hashMap = new HashMap();
        hashMap.put("hintForUser", getString(R.string.df_fpp_act_face_recognition_failed_retry));
        finishWithResult(new DiFaceResult((String) null, 1010, (Map<String, Object>) hashMap));
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        Detector detector = this.f47209k;
        if (detector != null) {
            detector.release();
        }
        DialogUtil dialogUtil = this.f47216r;
        if (dialogUtil != null) {
            dialogUtil.onDestory();
        }
        IDetection iDetection = this.f47215q;
        if (iDetection != null) {
            iDetection.onDestroy();
        }
        SensorUtil sensorUtil = this.f47221w;
        if (sensorUtil != null) {
            sensorUtil.release();
        }
        if (this.f47212n != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                this.f47212n.quitSafely();
            } else {
                this.f47212n.quit();
            }
        }
        GuideResult guideResult = this.f47190J;
        if (!(guideResult == null || guideResult.data == null || this.f47190J.data.result == null || this.f47190J.data.result.changeVolume == -1.0f)) {
            com.didichuxing.diface.utils.SystemUtils.changeMediaVolume(this, this.f47222x);
        }
        ProgressDialogFragment progressDialogFragment = this.f47223y;
        if (progressDialogFragment != null && progressDialogFragment.getDialog() != null && this.f47223y.getDialog().isShowing()) {
            this.f47223y.dismiss();
        }
    }

    public void onBackPressed() {
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_BIOASSAY_EXIT, DiFaceLogger.getExitType("1"), (HashMap<String, Object>) null);
        super.onBackPressed();
    }
}
