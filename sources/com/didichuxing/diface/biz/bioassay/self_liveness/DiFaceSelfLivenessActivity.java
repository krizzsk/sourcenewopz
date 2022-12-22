package com.didichuxing.diface.biz.bioassay.self_liveness;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.GLSurfaceView;
import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.didichuxing.dfbasesdk.ottoevent.ForceExitEvent;
import com.didichuxing.dfbasesdk.utils.ResUtils;
import com.didichuxing.dfbasesdk.utils.SPHelper;
import com.didichuxing.diface.DiFaceResult;
import com.didichuxing.diface.act.DFBaseAct;
import com.didichuxing.diface.biz.bioassay.alpha.AppealAfterCompareFailedEvent;
import com.didichuxing.diface.biz.bioassay.alpha.BioassayFailedDoneEvent;
import com.didichuxing.diface.biz.bioassay.alpha.util.ICamera;
import com.didichuxing.diface.biz.guide.GuideHelper;
import com.didichuxing.diface.biz.guide.p183M.GuideResult;
import com.didichuxing.diface.core.DiFaceFacade;
import com.didichuxing.diface.core.MVP.DiFaceBaseActivity;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.didichuxing.diface.utils.DFileUtils;
import com.didichuxing.diface.utils.DisplayUtils;
import com.didichuxing.diface.utils.SystemUtils;
import com.didichuxing.sdk.alphaface.AlphaFace;
import com.didichuxing.sdk.alphaface.core.RendererDecorate;
import com.didichuxing.sdk.alphaface.core.liveness.ILivenessCallback;
import com.didichuxing.sdk.alphaface.core.liveness.IMirrorCallback;
import com.didichuxing.sdk.alphaface.core.liveness.LivenessCallbackAdapter;
import com.didichuxing.sdk.alphaface.core.liveness.LivenessConfig;
import com.didichuxing.sdk.alphaface.core.liveness.LivenessManager;
import com.didichuxing.sdk.alphaface.core.liveness.LivenessResult;
import com.didichuxing.sdk.alphaface.utils.ICrash;
import com.squareup.otto.Subscribe;
import com.taxis99.R;
import java.util.Arrays;
import java.util.HashMap;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class DiFaceSelfLivenessActivity extends DFBaseAct implements Camera.PreviewCallback {

    /* renamed from: a */
    private static final int f47281a = 640;

    /* renamed from: b */
    private static final int f47282b = 480;

    /* renamed from: c */
    private GLSurfaceView f47283c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ICamera f47284d;

    /* renamed from: e */
    private RendererDecorate f47285e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public LivenessManager f47286f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public RoundMaskLiveness f47287g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public TextView f47288h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public TextView f47289i;

    /* renamed from: j */
    private GuideResult f47290j;

    /* renamed from: k */
    private GuideResult.ModelParam f47291k;

    /* renamed from: l */
    private GuideResult.Result.CaptureInfo f47292l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f47293m = true;

    /* renamed from: n */
    private int f47294n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f47295o = 0;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public LivenessHelper f47296p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public CompareHelper f47297q;

    /* renamed from: r */
    private int[] f47298r = {3};

    /* renamed from: s */
    private int f47299s = 10000;

    /* renamed from: t */
    private int f47300t = 15000;

    /* renamed from: u */
    private boolean f47301u = true;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public RecordHelper f47302v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public StatisticsCallback f47303w;

    /* renamed from: x */
    private ILivenessCallback f47304x = new LivenessCallbackAdapter() {
        public void onActionCountdown(int i) {
        }

        public void onActionFailed() {
        }

        public void onDetectFace(IMirrorCallback.FaceInfo faceInfo) {
        }

        public void onActionTimeout() {
            DiFaceSelfLivenessActivity.this.m33907d();
        }

        public void onActionChange(int i, int i2, int i3, int i4) {
            DiFaceSelfLivenessActivity.this.m33897a(i3, i4);
            if (DiFaceSelfLivenessActivity.this.f47296p != null) {
                DiFaceSelfLivenessActivity.this.f47296p.move(i2, i3);
            }
        }

        public void onActionTip(int i) {
            DiFaceSelfLivenessActivity.this.f47289i.setTextColor(ResUtils.getColor(R.color.df_liveness_mask_progress));
            if (i == 1) {
                DiFaceSelfLivenessActivity.this.f47288h.setText(R.string.df_liveness_tip_blink);
                DiFaceSelfLivenessActivity.this.f47289i.setText(R.string.df_liveness_tip_blink_please);
            } else if (i == 2) {
                DiFaceSelfLivenessActivity.this.f47288h.setText(R.string.df_liveness_tip_mouth);
                DiFaceSelfLivenessActivity.this.f47289i.setText(R.string.df_liveness_tip_mouth_please);
            } else if (i == 3) {
                DiFaceSelfLivenessActivity.this.f47288h.setText(R.string.df_liveness_tip_shake);
                DiFaceSelfLivenessActivity.this.f47289i.setText(R.string.df_liveness_tip_shake_please);
            } else if (i == 4) {
                DiFaceSelfLivenessActivity.this.f47288h.setText(R.string.df_liveness_tip_nod);
                DiFaceSelfLivenessActivity.this.f47289i.setText(R.string.df_liveness_tip_nod_please);
            }
        }

        public void onMirrorReset() {
            if (DiFaceSelfLivenessActivity.this.f47296p != null) {
                DiFaceSelfLivenessActivity.this.f47296p.reset();
            }
            if (DiFaceSelfLivenessActivity.this.f47287g != null) {
                DiFaceSelfLivenessActivity.this.f47287g.setProgress(0);
            }
            int unused = DiFaceSelfLivenessActivity.this.f47295o = 0;
        }

        public void onFaceError(int i) {
            if (i == 0) {
                DiFaceSelfLivenessActivity.this.f47289i.setTextColor(ResUtils.getColor(R.color.df_face_error_text_color));
                DiFaceSelfLivenessActivity.this.f47289i.setText(R.string.df_bioassay_act_error_not_centered);
            } else if (i == 1) {
                DiFaceSelfLivenessActivity.this.f47288h.setText(R.string.df_liveness_tip_blink);
                DiFaceSelfLivenessActivity.this.f47289i.setTextColor(ResUtils.getColor(R.color.df_liveness_mask_progress));
                DiFaceSelfLivenessActivity.this.f47289i.setText(R.string.df_liveness_tip_blink_please);
            } else if (i == 2) {
                DiFaceSelfLivenessActivity.this.f47288h.setText(R.string.df_liveness_tip_mouth);
                DiFaceSelfLivenessActivity.this.f47289i.setTextColor(ResUtils.getColor(R.color.df_liveness_mask_progress));
                DiFaceSelfLivenessActivity.this.f47289i.setText(R.string.df_liveness_tip_mouth_please);
            } else if (i == 3) {
                DiFaceSelfLivenessActivity.this.f47288h.setText(R.string.df_liveness_tip_shake);
                DiFaceSelfLivenessActivity.this.f47289i.setTextColor(ResUtils.getColor(R.color.df_liveness_mask_progress));
                DiFaceSelfLivenessActivity.this.f47289i.setText(R.string.df_liveness_tip_shake_please);
            } else if (i == 4) {
                DiFaceSelfLivenessActivity.this.f47288h.setText(R.string.df_liveness_tip_nod);
                DiFaceSelfLivenessActivity.this.f47289i.setTextColor(ResUtils.getColor(R.color.df_liveness_mask_progress));
                DiFaceSelfLivenessActivity.this.f47289i.setText(R.string.df_liveness_tip_nod_please);
            } else if (i == 5) {
                DiFaceSelfLivenessActivity.this.f47289i.setTextColor(ResUtils.getColor(R.color.df_face_error_text_color));
                DiFaceSelfLivenessActivity.this.f47289i.setText(R.string.df_bioassay_act_error_not_centered);
            } else if (i == 6) {
                DiFaceSelfLivenessActivity.this.f47289i.setTextColor(ResUtils.getColor(R.color.df_face_error_text_color));
                DiFaceSelfLivenessActivity.this.f47289i.setText(R.string.df_bioassay_act_error_face_too_close);
            } else if (i == 7) {
                DiFaceSelfLivenessActivity.this.f47289i.setTextColor(ResUtils.getColor(R.color.df_face_error_text_color));
                DiFaceSelfLivenessActivity.this.f47289i.setText(R.string.df_bioassay_act_error_face_too_far);
            } else if (i == 8) {
                DiFaceSelfLivenessActivity.this.f47289i.setTextColor(ResUtils.getColor(R.color.df_face_error_text_color));
                DiFaceSelfLivenessActivity.this.f47289i.setText(R.string.df_bioassay_act_error_not_centered);
            } else if (i == 9) {
                DiFaceSelfLivenessActivity.this.f47289i.setTextColor(ResUtils.getColor(R.color.df_face_error_text_color));
                DiFaceSelfLivenessActivity.this.f47289i.setText(R.string.df_bioassay_act_error_occ);
            } else if (i == 10) {
                DiFaceSelfLivenessActivity.this.f47289i.setTextColor(ResUtils.getColor(R.color.df_face_error_text_color));
                DiFaceSelfLivenessActivity.this.f47289i.setText(R.string.df_bioassay_act_error_blur);
            } else if (i == 11) {
                DiFaceSelfLivenessActivity.this.f47289i.setTextColor(ResUtils.getColor(R.color.df_face_error_text_color));
                DiFaceSelfLivenessActivity.this.f47289i.setText(R.string.df_bioassay_act_error_illum);
            } else {
                DiFaceSelfLivenessActivity.this.f47289i.setTextColor(ResUtils.getColor(R.color.df_face_error_text_color));
                DiFaceSelfLivenessActivity.this.f47289i.setText(R.string.df_bioassay_act_correct_tip);
            }
        }

        public void onMirrorFaceQualityError() {
            DiFaceSelfLivenessActivity.this.f47289i.setTextColor(ResUtils.getColor(R.color.df_face_error_text_color));
            DiFaceSelfLivenessActivity.this.f47289i.setText(R.string.df_liveness_hold_phone);
        }

        public void onSuccess(LivenessResult livenessResult) {
            DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_BI_DETECT_DONE, DiFaceLogger.setBioType((HashMap<String, Object>) null, "3"));
            String sourceToMD5 = DFileUtils.sourceToMD5(livenessResult.getBestPicList());
            String sourceToMD52 = DFileUtils.sourceToMD5(livenessResult.getAttackPicList());
            String sourceToMD53 = DFileUtils.sourceToMD5(livenessResult.getBestActionPicList());
            HashMap hashMap = new HashMap();
            hashMap.put("bioType", 2);
            hashMap.put("bestPic", sourceToMD5);
            hashMap.put("actionPic", sourceToMD52);
            hashMap.put("envPic", sourceToMD53);
            DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_SOURCE_PICTURES, (HashMap<String, Object>) hashMap);
            if (DiFaceSelfLivenessActivity.this.f47297q != null) {
                DiFaceSelfLivenessActivity.this.f47297q.compare(livenessResult);
            }
        }
    };

    /* access modifiers changed from: protected */
    public int getActTitleId() {
        return R.string.df_act_title;
    }

    /* access modifiers changed from: protected */
    public int getContentLayout() {
        return R.layout.activity_diface_liveness_layout;
    }

    /* access modifiers changed from: protected */
    public boolean needEventBus() {
        return true;
    }

    /* access modifiers changed from: protected */
    public int progressMsgResId() {
        return R.string.df_fpp_act_loading_msg;
    }

    public static void start(final DiFaceBaseActivity diFaceBaseActivity, final GuideResult guideResult) {
        AlphaFace.initialize(new AlphaFace.IInitCallback() {
            public void onResult(int i, String str) {
                if (i == 100000) {
                    Intent intent = new Intent(diFaceBaseActivity, DiFaceSelfLivenessActivity.class);
                    intent.putExtra(GuideHelper.EXTRA_KEY_GUIDE_RESULT, guideResult);
                    diFaceBaseActivity.startActivityForResult(intent, 1);
                    return;
                }
                diFaceBaseActivity.finishWithResult(new DiFaceResult(118));
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onLeftTitleBtnClicked() {
        StatisticsCallback statisticsCallback = this.f47303w;
        if (statisticsCallback != null) {
            statisticsCallback.LivenessEnd();
        }
        super.onLeftTitleBtnClicked();
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_BIOASSAY_EXIT, DiFaceLogger.getExitType("2"), (HashMap<String, Object>) null);
    }

    public void onBackPressed() {
        StatisticsCallback statisticsCallback = this.f47303w;
        if (statisticsCallback != null) {
            statisticsCallback.LivenessEnd();
        }
        super.onBackPressed();
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_BIOASSAY_EXIT, DiFaceLogger.getExitType("1"), (HashMap<String, Object>) null);
    }

    /* access modifiers changed from: protected */
    public void setupSubViews() {
        DiFaceFacade.getInstance().report("11", DiFaceLogger.setBioType((HashMap<String, Object>) null, "3"));
        m33896a();
        m33904b();
    }

    /* renamed from: a */
    private void m33896a() {
        this.f47288h = (TextView) findViewById(R.id.tv_recognizing_tip_up);
        this.f47289i = (TextView) findViewById(R.id.tv_recognizing_tip_down);
        this.f47287g = (RoundMaskLiveness) findViewById(R.id.round_mask_view);
        m33906c();
        this.f47284d = new ICamera(DisplayUtils.getScreenWidth(this), DisplayUtils.getScreenHeight(this), 640, 480);
        this.f47296p = new LivenessHelper(this, findViewById(R.id.liveness_layout_rootRel), this.f47290j.data.result.country);
        getLifecycle().addObserver(this.f47296p);
        this.f47296p.initAction(this.f47298r);
        this.f47297q = new CompareHelper(this, this.f47290j, this.f47287g);
        SystemUtils.changeAppBrightness(this, 255);
        final TextView textView = (TextView) findViewById(R.id.face_voice_ctr);
        final SPHelper sPHelper = new SPHelper(this, "globalface");
        boolean booleanValue = ((Boolean) sPHelper.get("voice", true)).booleanValue();
        this.f47293m = booleanValue;
        m33898a(textView, booleanValue);
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DiFaceSelfLivenessActivity diFaceSelfLivenessActivity = DiFaceSelfLivenessActivity.this;
                boolean unused = diFaceSelfLivenessActivity.f47293m = !diFaceSelfLivenessActivity.f47293m;
                DiFaceSelfLivenessActivity diFaceSelfLivenessActivity2 = DiFaceSelfLivenessActivity.this;
                diFaceSelfLivenessActivity2.m33898a(textView, diFaceSelfLivenessActivity2.f47293m);
                sPHelper.put("voice", Boolean.valueOf(DiFaceSelfLivenessActivity.this.f47293m)).apply();
            }
        });
        AlphaFace.setCrash(new ICrash() {
            public void throwable(Throwable th) {
                DiFaceFacade.getInstance().reportException(new Exception(th));
            }
        });
    }

    /* access modifiers changed from: protected */
    public void initDataFromIntent(Intent intent) {
        GuideResult guideResult = (GuideResult) intent.getSerializableExtra(GuideHelper.EXTRA_KEY_GUIDE_RESULT);
        this.f47290j = guideResult;
        if (guideResult == null || guideResult.data == null || this.f47290j.data.result == null) {
            finishWithResult(new DiFaceResult(101));
            return;
        }
        this.f47292l = this.f47290j.data.result.captureInfo;
        GuideResult.ModelParam modelParam = this.f47290j.data.result.getModelParam();
        this.f47291k = modelParam;
        if (!(modelParam == null || modelParam.getAlive() == null)) {
            this.f47294n = this.f47291k.getAlive().getPicNum4AntiAttack();
        }
        if (!(this.f47290j.data.result == null || this.f47290j.data.result.face_plus_action == null || this.f47290j.data.result.face_plus_action.length <= 0)) {
            this.f47298r = this.f47290j.data.result.face_plus_action;
        }
        this.f47301u = this.f47290j.data.result.antiAttack;
    }

    /* renamed from: b */
    private void m33904b() {
        this.f47303w = new StatisticsCallback("-1");
        this.f47286f = new LivenessManager(new LivenessConfig.Builder().setDetectTime(this.f47291k.getAlive().getTime4AntiAttack()).setFrame_time_interval(this.f47291k.getAlive().getFrameTimeInterval()).setYaw_thresh(this.f47291k.getQuality().getYaw_thresh()).setPitch_thresh(this.f47291k.getQuality().getPitch_thresh()).setOcc_thresh(this.f47291k.getQuality().getOcc_thresh()).setIllum_thresh(this.f47291k.getQuality().getIllum_thresh()).setBlur_thresh(this.f47291k.getQuality().getBlur_thresh()).setFrameSkipTime(75).setActionTimeout(this.f47299s).setActionInterruptTime(this.f47300t).setAttackEnable(this.f47301u).setActionPicCount(Math.min(this.f47294n, 5)).setBestPicQualityThreshold((double) this.f47291k.getQuality().getMinFaceQuality()).setAttackPicQualityThreshold((double) this.f47291k.getAlive().getMinFaceQuality4AntiAttack()).setFaceQualityErrorMaxTimes(1).setDetectAction(this.f47298r).setCallback(new LivenessWrapper(Arrays.asList(new ILivenessCallback[]{this.f47304x, this.f47303w}))).builder(), getLifecycle());
    }

    /* renamed from: c */
    private void m33906c() {
        GLSurfaceView gLSurfaceView = (GLSurfaceView) findViewById(R.id.liveness_layout_cameraView);
        this.f47283c = gLSurfaceView;
        gLSurfaceView.setEGLContextClientVersion(2);
        C154544 r0 = new RendererDecorate(this, this.f47283c) {
            public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig, SurfaceTexture surfaceTexture) {
                if (DiFaceSelfLivenessActivity.this.f47284d != null) {
                    DiFaceSelfLivenessActivity.this.f47284d.startPreview(surfaceTexture);
                    DiFaceSelfLivenessActivity.this.f47284d.actionDetect(DiFaceSelfLivenessActivity.this);
                }
                if (DiFaceSelfLivenessActivity.this.f47302v != null) {
                    DiFaceFacade.getInstance().report("200", DiFaceLogger.setBioType((HashMap<String, Object>) null, "3"), (HashMap<String, Object>) null);
                    DiFaceSelfLivenessActivity.this.f47302v.onStart();
                }
            }
        };
        this.f47285e = r0;
        this.f47283c.setRenderer(r0);
        this.f47283c.setRenderMode(0);
        GuideResult.Result.CaptureInfo captureInfo = this.f47292l;
        if (captureInfo != null) {
            this.f47285e.setRecordVideo(captureInfo.captureEnable, 640, 480, true, this.f47292l.bpp, this.f47292l.fps);
            this.f47302v = new RecordHelper(this, this.f47285e, "3", this.f47292l.maxTime, (long) this.f47292l.thresholdWifi, (long) this.f47292l.threshold4G);
            getLifecycle().addObserver(this.f47302v);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m33907d() {
        new AlertDialogFragment.Builder(this).setSupprtMullineTitle(true).setTitle(getResources().getString(R.string.df_timeout_dialog_verify_fail)).setMessage(getResources().getString(R.string.df_timeout_dialog_content)).setPositiveButton((int) R.string.df_timeout_dialog_try_again, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                alertDialogFragment.dismiss();
                if (DiFaceSelfLivenessActivity.this.f47296p != null) {
                    DiFaceSelfLivenessActivity.this.f47296p.reset();
                }
                if (DiFaceSelfLivenessActivity.this.f47286f != null) {
                    DiFaceSelfLivenessActivity.this.f47286f.restart();
                }
            }
        }).setNegativeButton((int) R.string.df_timeout_dialog_exit, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                alertDialogFragment.dismiss();
                if (DiFaceSelfLivenessActivity.this.f47303w != null) {
                    DiFaceSelfLivenessActivity.this.f47303w.LivenessEnd();
                }
                DiFaceSelfLivenessActivity.this.finishWithResult(new DiFaceResult(102));
            }
        }).setPositiveButtonDefault().setCancelable(false).create().show(getSupportFragmentManager(), "");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33897a(int i, int i2) {
        if (this.f47287g != null) {
            int i3 = i >= i2 ? 100 : (int) (((((float) i) * 1.0f) / ((float) i2)) * 100.0f);
            ValueAnimator duration = ValueAnimator.ofInt(new int[]{this.f47295o, i3}).setDuration(300);
            duration.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    DiFaceSelfLivenessActivity.this.f47287g.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            duration.start();
            this.f47295o = i3;
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        ICamera iCamera = this.f47284d;
        if (iCamera != null) {
            iCamera.openCamera(this, true);
            if (!this.f47284d.isUsingFrontCamera()) {
                m33910e();
            }
        }
        GLSurfaceView gLSurfaceView = this.f47283c;
        if (gLSurfaceView != null) {
            gLSurfaceView.onResume();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        GLSurfaceView gLSurfaceView = this.f47283c;
        if (gLSurfaceView != null) {
            gLSurfaceView.onPause();
        }
        ICamera iCamera = this.f47284d;
        if (iCamera != null) {
            iCamera.closeCamera();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        AlphaFace.setCrash((ICrash) null);
    }

    /* renamed from: e */
    private void m33910e() {
        new AlertDialogFragment.Builder(this).setTitle(getString(R.string.df_bi_act_no_front_camera_dialog_title)).setMessage(getString(R.string.df_bi_act_no_front_camera_dialog_msg)).setPositiveButton((int) R.string.df_ok, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                alertDialogFragment.dismiss();
            }
        }).setCancelable(false).create().show(getSupportFragmentManager(), "");
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        ICamera iCamera;
        if (this.f47286f != null && (iCamera = this.f47284d) != null && bArr != null && bArr.length > 0) {
            this.f47286f.detect(bArr, this.f47284d.cameraWidth, this.f47284d.cameraHeight, iCamera.isUsingFrontCamera() ? this.f47284d.getCameraAngle() : this.f47284d.getCameraAngle() + 180, 4, this.f47291k.getDetect().getCenterRatio(), this.f47291k.getDetect().getMinCropRatio(), this.f47291k.getDetect().getMaxCropRatio(), false);
        }
    }

    @Subscribe
    public void onBioassayFailedDoneEvent(BioassayFailedDoneEvent bioassayFailedDoneEvent) {
        finishWithResult(bioassayFailedDoneEvent.result);
    }

    @Subscribe
    public void onAppealAfterCompareFailedEvent(AppealAfterCompareFailedEvent appealAfterCompareFailedEvent) {
        finish();
    }

    @Subscribe
    public void onForceExitEvent(ForceExitEvent forceExitEvent) {
        finish();
    }

    public void changeTipStatus() {
        this.f47288h.setVisibility(4);
        this.f47289i.setText(R.string.df_fpp_act_loading_msg);
    }

    public void uploadVideo() {
        RecordHelper recordHelper = this.f47302v;
        if (recordHelper != null) {
            recordHelper.onSuccess();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33898a(TextView textView, boolean z) {
        if (z) {
            textView.setBackgroundResource(R.drawable.df_bio_voice_on);
            SystemUtils.changeMediaVolume(this, (int) (((double) SystemUtils.getMediaMaxVolume(this)) * 0.5d));
            return;
        }
        textView.setBackgroundResource(R.drawable.df_bio_voice_off);
        SystemUtils.changeMediaVolume(this, 0);
    }
}
