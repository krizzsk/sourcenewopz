package com.didi.safety.god2020.task;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.net.Uri;
import android.text.Html;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.websocket.DMWebSocketListener;
import com.didi.safety.god.event.RestartDetectionEvent;
import com.didi.safety.god.event.TaskType;
import com.didi.safety.god.http.Card;
import com.didi.safety.god.http.SafetyTraceEventHandler;
import com.didi.safety.god.manager.GodManager;
import com.didi.safety.god.p144ui.CaptureRequestsFragment;
import com.didi.safety.god.p144ui.DetectionRectBgDrawables;
import com.didi.safety.god.p144ui.GLSurfaceRecorder;
import com.didi.safety.god.p144ui.HollowEffectView;
import com.didi.safety.god.p144ui.PosSizeInfo;
import com.didi.safety.god.util.Constant;
import com.didi.safety.god.util.IMediaPlayer;
import com.didi.safety.god.util.LogUtils;
import com.didi.sdk.util.ToastHelper;
import com.didichuxing.dfbasesdk.utils.BusUtils;
import com.didichuxing.dfbasesdk.utils.SPHelper;
import com.didichuxing.dfbasesdk.utils.UIHandler;
import com.didichuxing.saimageloader.DiSafetyImageLoader;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public abstract class DetectionTask implements View.OnClickListener, GLSurfaceRecorder.RecordListener {

    /* renamed from: H */
    private static final int f34853H = 0;

    /* renamed from: I */
    private static final int f34854I = 1;

    /* renamed from: J */
    private static final int f34855J = 2;

    /* renamed from: K */
    private static final int f34856K = 3;

    /* renamed from: L */
    private static final int f34857L = 4;

    /* renamed from: M */
    private static final int f34858M = 5;

    /* renamed from: N */
    private static final int f34859N = 6;

    /* renamed from: k */
    private static final String f34860k = "voice_on";
    /* access modifiers changed from: private */

    /* renamed from: A */
    public AnimatorSet f34861A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public final int f34862B;

    /* renamed from: C */
    private boolean f34863C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public float f34864D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public float f34865E;

    /* renamed from: F */
    private SPHelper f34866F;

    /* renamed from: G */
    private IMediaPlayer f34867G;
    /* access modifiers changed from: private */

    /* renamed from: O */
    public int f34868O;

    /* renamed from: P */
    private final Runnable f34869P = new Runnable() {
        public void run() {
            DetectionTask.this.f34888q.setVisibility(4);
        }
    };

    /* renamed from: Q */
    private boolean f34870Q;

    /* renamed from: R */
    private boolean f34871R;

    /* renamed from: S */
    private String f34872S = "global_doorgod_torch_state";

    /* renamed from: a */
    private final GLSurfaceRecorder f34873a;
    protected final FragmentActivity activity;

    /* renamed from: b */
    private final View f34874b;

    /* renamed from: c */
    private final View f34875c;
    protected final Card card;
    protected String cardDesc;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public TaskListener f34876d;

    /* renamed from: e */
    private ImageView f34877e;

    /* renamed from: f */
    private TextView f34878f;

    /* renamed from: g */
    private TextView f34879g;

    /* renamed from: h */
    private ImageView f34880h;

    /* renamed from: i */
    private ImageView f34881i;

    /* renamed from: j */
    private boolean f34882j;

    /* renamed from: l */
    private HollowEffectView f34883l;
    protected int label;

    /* renamed from: m */
    private TextView f34884m;

    /* renamed from: n */
    private TextView f34885n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public FrameLayout f34886o;

    /* renamed from: p */
    private FrameLayout f34887p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public ImageView f34888q;

    /* renamed from: r */
    private TextView f34889r;

    /* renamed from: s */
    private View f34890s;

    /* renamed from: t */
    private ImageView f34891t;

    /* renamed from: u */
    private ImageView f34892u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public FrameLayout f34893v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public View f34894w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public ImageView f34895x;

    /* renamed from: y */
    private TextView f34896y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public TextView f34897z;

    public interface TaskListener {
        void onComplete();
    }

    public void onDetectNoGoodQuality(int i) {
    }

    public DetectionTask(FragmentActivity fragmentActivity, View view, View view2, GLSurfaceRecorder gLSurfaceRecorder, Card card2) {
        this.activity = fragmentActivity;
        this.f34874b = view;
        this.f34875c = view2;
        this.f34873a = gLSurfaceRecorder;
        gLSurfaceRecorder.setVideoLength(card2.getVideoLength());
        this.f34873a.setTimeoutSec(card2.getTimeOutSec());
        this.card = card2;
        this.f34862B = card2.getVideoLength();
        if (this.card.getTimeOutSec() > 0) {
            GodManager.getInstance().getConfig().timeOutSec = (long) this.card.getTimeOutSec();
        }
        if (card2.getAlgoType() != null) {
            this.label = card2.getAlgoType().intValue();
        } else {
            this.label = TaskType.convertToLocalType(card2.getCardName());
        }
        if (!card2.algoModelSwitch) {
            GodManager.getInstance().setManual(true);
        }
        if (card2.getCardImgName() == null || card2.getCardImgName().trim().length() <= 0) {
            this.cardDesc = TaskType.getTaskDesc(this.label);
        } else {
            this.cardDesc = card2.getCardImgName();
        }
        this.f34866F = new SPHelper(fragmentActivity, Constant.SP_FILE);
        this.f34867G = IMediaPlayer.getInstance();
    }

    /* renamed from: d */
    private void m24596d() {
        this.f34874b.findViewById(R.id.start_detection).setOnClickListener(this);
        this.f34874b.findViewById(R.id.back_layout).setOnClickListener(this);
        this.f34877e = (ImageView) this.f34874b.findViewById(R.id.card_preview);
        this.f34878f = (TextView) this.f34874b.findViewById(R.id.card_preview_title);
        this.f34879g = (TextView) this.f34874b.findViewById(R.id.card_preview_requests);
        ImageView imageView = (ImageView) this.f34875c.findViewById(R.id.camera_icon_click);
        this.f34880h = imageView;
        if (imageView.getVisibility() == 0) {
            this.f34880h.setVisibility(4);
        }
        this.f34880h.setOnClickListener(this);
        this.f34883l = (HollowEffectView) this.f34875c.findViewById(R.id.detection_hollow_effect_view);
        this.f34884m = (TextView) this.f34875c.findViewById(R.id.detection_label_title);
        FrameLayout frameLayout = (FrameLayout) this.f34875c.findViewById(R.id.detection_real_rect);
        this.f34886o = frameLayout;
        frameLayout.setOnClickListener(this);
        this.f34886o.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (DetectionTask.this.f34868O != 1 || motionEvent.getActionMasked() != 0) {
                    return false;
                }
                int left = DetectionTask.this.f34888q.getLeft();
                int top = DetectionTask.this.f34888q.getTop();
                int width = DetectionTask.this.f34888q.getWidth();
                int height = DetectionTask.this.f34888q.getHeight();
                LogUtils.m24578d("down focusIcon, left===" + left + ", w=" + width + ", top=" + top + ", h=" + height);
                float x = motionEvent.getX() - (((float) width) / 2.0f);
                float y = motionEvent.getY() - (((float) height) / 2.0f);
                StringBuilder sb = new StringBuilder();
                sb.append("down x===");
                sb.append(x);
                sb.append(", y=");
                sb.append(y);
                LogUtils.m24578d(sb.toString());
                float unused = DetectionTask.this.f34864D = x - ((float) left);
                float unused2 = DetectionTask.this.f34865E = y - ((float) top);
                LogUtils.m24578d("down transX===" + DetectionTask.this.f34864D + ", transY=" + DetectionTask.this.f34865E);
                return false;
            }
        });
        this.f34887p = (FrameLayout) this.f34875c.findViewById(R.id.detection_preview_rect);
        this.f34888q = (ImageView) this.f34875c.findViewById(R.id.detection_focus_icon);
        this.f34890s = this.f34875c.findViewById(R.id.detection_weak_warn);
        this.f34889r = (TextView) this.f34875c.findViewById(R.id.detection_weak_warn_text);
        this.f34891t = (ImageView) this.f34875c.findViewById(R.id.detection_cover_layer_icon);
        ImageView imageView2 = (ImageView) this.f34875c.findViewById(R.id.camera_flashlight_click);
        this.f34892u = imageView2;
        imageView2.setImageResource(this.f34871R ? R.drawable.btn_torch_open : R.drawable.btn_torch_close);
        this.f34892u.setOnClickListener(this);
        this.f34893v = (FrameLayout) this.f34875c.findViewById(R.id.detection_recognize_rect);
        this.f34894w = this.f34875c.findViewById(R.id.detection_bg_grid);
        this.f34895x = (ImageView) this.f34875c.findViewById(R.id.detection_animator_view);
        this.f34896y = (TextView) this.f34875c.findViewById(R.id.detection_recognize_title);
        this.f34897z = (TextView) this.f34875c.findViewById(R.id.detection_recognize_countdown);
        this.f34875c.findViewById(R.id.back_layout).setOnClickListener(this);
        this.f34875c.findViewById(R.id.detection_label_req_icon).setOnClickListener(this);
    }

    public void setLast() {
        this.f34863C = true;
    }

    /* access modifiers changed from: protected */
    public boolean isLast() {
        return this.f34863C;
    }

    public void start(TaskListener taskListener) {
        m24596d();
        this.f34876d = taskListener;
        m24598e();
    }

    /* renamed from: e */
    private void m24598e() {
        closeCamera();
        m24590a(this.cardDesc, this.card.getCardReqContent(this.activity), this.card.getPreviewUrl());
        this.activity.setContentView(this.f34874b);
        this.f34868O = 0;
    }

    /* renamed from: a */
    private void m24590a(String str, String str2, String str3) {
        this.f34878f.setText(str);
        this.f34879g.setText(Html.fromHtml(str2));
        DiSafetyImageLoader.with(this.activity).load(str3).placeholder((int) R.drawable.safety_preview_default).into(this.f34877e);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo90058a() {
        m24600f();
        this.f34873a.setRecordListener(this);
        boolean startDetection = this.f34873a.startDetection(this.label, this.card.getCardName(), this.card.getPicAutoDect());
        m24591a(startDetection);
        if (startDetection) {
            this.f34883l.setTargetView(this.f34886o);
            m24602g();
            return;
        }
        ToastHelper.showLongInfo((Context) this.activity, (int) R.string.GRider_OCR_Camera_permissions_jaju);
        this.activity.finish();
    }

    /* renamed from: f */
    private void m24600f() {
        this.f34868O = 1;
        DetectionRectBgDrawables.setBg(this.f34886o, R.drawable.safety_detection_scanner_rect_orange);
        this.f34887p.setVisibility(0);
        this.f34893v.setVisibility(4);
        this.f34888q.setTranslationX(0.0f);
        this.f34888q.setTranslationY(0.0f);
        this.f34884m.setText(this.card.getCardImgName());
        if ("CL_J1".equals(this.card.getCardName())) {
            DiSafetyImageLoader.with(this.activity.getApplicationContext()).load(this.card.getOutlineUrl()).into(this.f34891t);
        } else {
            this.f34891t.setImageResource(0);
        }
        this.f34896y.setText(R.string.GRider_OCR_Do_not_ftpI);
        this.activity.setContentView(this.f34875c);
    }

    /* renamed from: a */
    private void m24591a(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("cmd", "STARTCAPTURE");
        hashMap.put("collectType", this.card.getCardName());
        hashMap.put(DMWebSocketListener.KEY_ERR_MSG, z ? "" : "open camera failed");
        SafetyTraceEventHandler.trace(hashMap);
    }

    /* renamed from: g */
    private void m24602g() {
        this.f34873a.startAutoFocus(GodManager.getInstance().getConfig().delayedFocusTime);
        this.f34888q.setVisibility(0);
        UIHandler.removeCallbacks(this.f34869P);
        UIHandler.postDelayed(2000, this.f34869P);
    }

    /* access modifiers changed from: protected */
    public void moveToUploadStep() {
        this.f34868O = 3;
    }

    /* access modifiers changed from: protected */
    public void moveToOcrFailedStep() {
        this.f34868O = 4;
    }

    /* access modifiers changed from: protected */
    public void moveToReconizedFailedStep() {
        this.f34868O = 5;
    }

    /* access modifiers changed from: protected */
    public void moveToDefaultFailedStep() {
        this.f34868O = 6;
    }

    /* renamed from: h */
    private void m24604h() {
        if (this.f34868O == 1) {
            this.f34873a.refocus();
            this.f34888q.setVisibility(0);
            this.f34888q.setTranslationX(this.f34864D);
            this.f34888q.setTranslationY(this.f34865E);
            UIHandler.removeCallbacks(this.f34869P);
            UIHandler.postDelayed(2000, this.f34869P);
        }
    }

    public void logReqFocusEvent() {
        HashMap hashMap = new HashMap();
        hashMap.put("cmd", "REQFOCUS");
        hashMap.put("collectType", this.card.getCardName());
        SafetyTraceEventHandler.trace(hashMap);
    }

    public void logFocusEvent(Map<String, Object> map) {
        map.put("collectType", this.card.getCardName());
        SafetyTraceEventHandler.trace(map);
    }

    public String getCollectType() {
        return this.card.getCardName();
    }

    /* access modifiers changed from: protected */
    public void changeToRedErrorRect() {
        DetectionRectBgDrawables.setBg(this.f34886o, R.drawable.safety_detection_scanner_rect_red);
    }

    public void onDetectPosSizeInfo(PosSizeInfo posSizeInfo) {
        if (posSizeInfo.disState > 0) {
            this.f34889r.setText(posSizeInfo.disState == 1 ? R.string.GRider_OCR_Please_come_OLDR : R.string.GRider_OCR_Stay_away_HQmP);
            this.f34890s.setVisibility(0);
            this.f34889r.setVisibility(0);
            this.f34870Q = true;
        } else if (posSizeInfo.notCentered) {
            this.f34889r.setText(R.string.GRider_OCR_Please_complete_gZWm);
            this.f34890s.setVisibility(0);
            this.f34889r.setVisibility(0);
        } else {
            this.f34889r.setText("");
            this.f34890s.setVisibility(4);
            this.f34889r.setVisibility(4);
            if (this.f34870Q) {
                m24604h();
                this.f34870Q = false;
            }
        }
    }

    public void onLightnessChecked(float f) {
        if (GodManager.getInstance().getManualState()) {
            ImageView imageView = this.f34880h;
            if (imageView == null || imageView.getVisibility() == 0) {
                if (f <= 800.0f) {
                    this.f34880h.setVisibility(4);
                    this.f34880h.setEnabled(false);
                }
            } else if (f > 800.0f) {
                this.f34880h.setVisibility(0);
                this.f34880h.setEnabled(true);
            }
        }
    }

    public void handleFinalWrongSizeInfo(int i, boolean z) {
        mo90059b();
        String string = this.activity.getString(i > 0 ? i == 1 ? R.string.GRider_OCR_Please_come_OLDR : R.string.GRider_OCR_Stay_away_HQmP : R.string.GRider_OCR_Please_complete_gZWm);
        this.f34889r.setText(string);
        this.f34890s.setVisibility(0);
        this.f34889r.setVisibility(0);
        BusUtils.post(new RestartDetectionEvent());
        HashMap hashMap = new HashMap();
        hashMap.put("cmd", "COLLPIC");
        hashMap.put("collectType", this.card.getCardName());
        hashMap.put(DMWebSocketListener.KEY_ERR_MSG, string);
        hashMap.put("code", 5);
        SafetyTraceEventHandler.trace(hashMap);
    }

    public void onDetectWrongLabel() {
        this.f34889r.setText("");
        this.f34890s.setVisibility(4);
        this.f34889r.setVisibility(4);
        HashMap hashMap = new HashMap();
        hashMap.put("cmd", "COLLPIC");
        hashMap.put("collectType", this.card.getCardName());
        hashMap.put(DMWebSocketListener.KEY_ERR_MSG, "detect wrong label");
        hashMap.put("code", 4);
        SafetyTraceEventHandler.trace(hashMap);
    }

    public void restartDetection() {
        this.f34868O = 1;
        DetectionRectBgDrawables.setBg(this.f34886o, R.drawable.safety_detection_scanner_rect_orange);
        this.f34887p.setVisibility(0);
        this.f34893v.setVisibility(4);
        this.f34873a.restart(this.label, this.card.getCardName(), this.card.getPicAutoDect());
        onResume();
        this.f34864D = 0.0f;
        this.f34865E = 0.0f;
        m24604h();
    }

    public void restartFromBeginning() {
        m24598e();
    }

    /* access modifiers changed from: protected */
    public void recordAndCapture() {
        this.f34873a.recordAndCapture();
    }

    public void quitTask() {
        LogUtils.m24578d("quitTask===");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo90059b() {
        AnimatorSet animatorSet = this.f34861A;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.f34861A = null;
            this.f34893v.setVisibility(4);
        }
    }

    /* renamed from: i */
    private void m24606i() {
        HashMap hashMap = new HashMap();
        hashMap.put("cmd", "STARTVID");
        hashMap.put("collectType", this.card.getCardName());
        SafetyTraceEventHandler.trace(hashMap);
    }

    public void onDetectNothing() {
        clearWeakNotify();
    }

    public void onCaptureFinished(GLSurfaceRecorder.PicInfo picInfo) {
        this.f34871R = false;
        this.f34866F.put(this.f34872S, false).apply();
        this.f34873a.torchOff();
    }

    public void onRecordVideoStart(GLSurfaceRecorder.VideoInfo videoInfo) {
        this.f34868O = 2;
        DetectionRectBgDrawables.setBg(this.f34886o, R.drawable.safety_detection_scanner_rect_blue);
        this.f34887p.setVisibility(4);
        m24606i();
        this.f34875c.postDelayed(new Runnable() {
            public void run() {
                DetectionTask.this.f34893v.setVisibility(0);
                long f = (long) (DetectionTask.this.f34862B * 1000);
                LogUtils.m24578d("recognize animation total duration===" + f);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(DetectionTask.this.f34894w, "alpha", new float[]{0.0f, 1.0f});
                ofFloat.setDuration((2 * f) / 3);
                int height = DetectionTask.this.f34895x.getHeight();
                int i = height / -2;
                int height2 = DetectionTask.this.f34886o.getHeight() - height;
                ObjectAnimator duration = ObjectAnimator.ofFloat(DetectionTask.this.f34895x, "translationY", new float[]{(float) i, (float) height2}).setDuration(f);
                ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{DetectionTask.this.f34862B, 0});
                ofInt.setDuration(f);
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        String valueOf = String.valueOf(valueAnimator.getAnimatedValue());
                        if (!TextUtils.equals(valueOf, DetectionTask.this.f34897z.getText())) {
                            DetectionTask.this.f34897z.setText(valueOf);
                        }
                    }
                });
                if (DetectionTask.this.f34861A == null) {
                    AnimatorSet unused = DetectionTask.this.f34861A = new AnimatorSet();
                    DetectionTask.this.f34861A.setInterpolator(new LinearInterpolator());
                    DetectionTask.this.f34861A.playTogether(new Animator[]{ofFloat, duration, ofInt});
                    DetectionTask.this.f34861A.start();
                }
            }
        }, 800);
    }

    /* access modifiers changed from: protected */
    public void notifyTaskListener() {
        this.activity.runOnUiThread(new Runnable() {
            public void run() {
                if (DetectionTask.this.f34876d != null) {
                    DetectionTask.this.f34876d.onComplete();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void closeCamera() {
        this.f34873a.closeCamera();
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int id = view.getId();
        if (id == R.id.start_detection) {
            mo90058a();
            if (GodManager.getInstance().getManualState()) {
                m24602g();
            }
        } else if (id == R.id.back_layout) {
            if (this.f34868O != 2) {
                this.activity.onBackPressed();
            }
        } else if (id == R.id.detection_label_req_icon) {
            m24608j();
            CaptureRequestsFragment newInstance = CaptureRequestsFragment.newInstance(this.card.getPreviewUrl(), this.card.getCardImgName(), this.card.getCardReqContent(this.activity), 0);
            FragmentTransaction beginTransaction = this.activity.getSupportFragmentManager().beginTransaction();
            beginTransaction.replace(R.id.detection_fragment_container, newInstance);
            beginTransaction.addToBackStack((String) null);
            beginTransaction.commitAllowingStateLoss();
        } else if (id == R.id.detection_real_rect) {
            m24604h();
        } else if (id == R.id.camera_icon_click) {
            this.f34873a.startCapture();
        } else if (id == R.id.camera_flashlight_click) {
            boolean z = !this.f34871R;
            this.f34871R = z;
            this.f34892u.setImageResource(z ? R.drawable.btn_torch_open : R.drawable.btn_torch_close);
            this.f34866F.put(this.f34872S, Boolean.valueOf(this.f34871R)).apply();
            if (this.f34871R) {
                this.f34873a.torchOn();
            } else {
                this.f34873a.torchOff();
            }
        }
    }

    public void clearWeakNotify() {
        this.f34889r.setText("");
        this.f34890s.setVisibility(4);
        this.f34889r.setVisibility(4);
    }

    public void clearStrongNotify() {
        this.f34893v.setVisibility(4);
    }

    public void onBackPressed() {
        this.f34873a.pauseDetect();
    }

    public void onBackPressCanceled() {
        this.f34873a.resumeDetect();
    }

    /* renamed from: j */
    private void m24608j() {
        HashMap hashMap = new HashMap();
        hashMap.put("cmd", "CHECKSHOOTREQUIRE");
        hashMap.put("collectType", this.card.getCardName());
        SafetyTraceEventHandler.trace(hashMap);
    }

    public void onQuitConfirmed() {
        m24610k();
    }

    /* renamed from: k */
    private void m24610k() {
        HashMap hashMap = new HashMap();
        hashMap.put("cmd", "QUIT");
        hashMap.put("collectType", this.card.getCardName());
        hashMap.put("cardName", this.card.getCardName());
        hashMap.put("cardImgDesc", this.card.getCardImgDesc());
        int i = this.f34868O;
        int i2 = 6;
        if (i == 0) {
            i2 = 1;
        } else if (i == 1) {
            i2 = 2;
        } else if (i == 3) {
            i2 = 3;
        } else if (i == 4) {
            i2 = 4;
        } else if (i == 5) {
            i2 = 5;
        } else if (i != 6) {
            i2 = 0;
        }
        hashMap.put("code", Integer.valueOf(i2));
        SafetyTraceEventHandler.trace(hashMap);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo90060c() {
        this.f34873a.cleanup();
    }

    public void onPause() {
        if (this.f34868O == 1) {
            this.f34873a.pauseDetect();
            closeCamera();
        }
    }

    public void onResume() {
        if (this.f34868O == 1) {
            this.f34873a.resumeDetect();
            if (this.f34873a.openCamera()) {
                this.f34873a.startPreview();
            }
        }
        if (this.f34871R) {
            this.f34873a.torchOn();
        }
    }

    public void onDestroy() {
        mo90060c();
        this.f34873a.onDestroy();
        this.f34867G.release();
    }

    public void onLocalPicSelected(Uri uri) {
        m24600f();
        this.f34883l.setTargetView(this.f34886o);
    }
}
