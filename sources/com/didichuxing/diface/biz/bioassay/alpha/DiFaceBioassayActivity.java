package com.didichuxing.diface.biz.bioassay.alpha;

import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.sdk.p146ad.model.AdParams;
import com.didi.sdk.util.SystemUtil;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.dfbasesdk.encrypt.Encrypter;
import com.didichuxing.dfbasesdk.http.MultiSerializerForAccessSecurity;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.dfbasesdk.utils.MathUtils;
import com.didichuxing.dfbasesdk.utils.NetworkUtils;
import com.didichuxing.dfbasesdk.utils.ResUtils;
import com.didichuxing.diface.DiFaceResult;
import com.didichuxing.diface.act.DFBaseAct;
import com.didichuxing.diface.appeal.AppealParam;
import com.didichuxing.diface.biz.bioassay.alpha.p180M.compare.CompareModel;
import com.didichuxing.diface.biz.bioassay.alpha.p180M.compare.CompareParam;
import com.didichuxing.diface.biz.bioassay.alpha.p180M.compare.CompareResult;
import com.didichuxing.diface.biz.bioassay.alpha.p180M.report_failed.ReportFailedModel;
import com.didichuxing.diface.biz.bioassay.alpha.p180M.report_failed.ReportFailedParam;
import com.didichuxing.diface.biz.bioassay.alpha.p180M.report_failed.ReportFailedResult;
import com.didichuxing.diface.biz.bioassay.alpha.util.ICamera;
import com.didichuxing.diface.biz.bioassay.self_liveness.RecordHelper;
import com.didichuxing.diface.biz.guide.GuideHelper;
import com.didichuxing.diface.biz.guide.p183M.GuideResult;
import com.didichuxing.diface.core.DiFaceFacade;
import com.didichuxing.diface.core.MVP.DiFaceBaseActivity;
import com.didichuxing.diface.custom_view.RoundMask;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.didichuxing.diface.utils.DFileUtils;
import com.didichuxing.diface.utils.DisplayUtils;
import com.didichuxing.diface.utils.FileUtils;
import com.didichuxing.diface.utils.SystemUtils;
import com.didichuxing.diface.utils.http.AbsHttpCallback;
import com.didichuxing.sdk.alphaface.AlphaFace;
import com.didichuxing.sdk.alphaface.core.BioassayManager;
import com.didichuxing.sdk.alphaface.core.RendererDecorate;
import com.squareup.otto.Subscribe;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONArray;

public class DiFaceBioassayActivity extends DFBaseAct implements Camera.PreviewCallback {
    public static final String WATER_MARK_FAIL = "-1";

    /* renamed from: g */
    private static final int f47138g = 640;

    /* renamed from: h */
    private static final int f47139h = 480;

    /* renamed from: t */
    private static final String f47140t = "1";

    /* renamed from: u */
    private static final String f47141u = "2";

    /* renamed from: a */
    private RelativeLayout f47142a;

    /* renamed from: b */
    private GLSurfaceView f47143b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public RoundMask f47144c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public TextView f47145d;

    /* renamed from: e */
    private BioassayManager f47146e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ICamera f47147f;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public GuideResult f47148i;

    /* renamed from: j */
    private GuideResult.ModelParam f47149j;

    /* renamed from: k */
    private GuideResult.Result.CaptureInfo f47150k;

    /* renamed from: l */
    private RendererDecorate f47151l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public RecordHelper f47152m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f47153n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f47154o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public String f47155p = "";

    /* renamed from: q */
    private String f47156q = "";
    /* access modifiers changed from: private */

    /* renamed from: r */
    public String f47157r = "";

    /* renamed from: s */
    private String f47158s = "";

    /* access modifiers changed from: protected */
    public int getActTitleId() {
        return R.string.df_act_title;
    }

    /* access modifiers changed from: protected */
    public int getContentLayout() {
        return R.layout.activity_diface_bioasay_layout;
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
                    Intent intent = new Intent(diFaceBaseActivity, DiFaceBioassayActivity.class);
                    intent.putExtra(GuideHelper.EXTRA_KEY_GUIDE_RESULT, guideResult);
                    diFaceBaseActivity.startActivityForResult(intent, 1);
                    return;
                }
                diFaceBaseActivity.finishWithResult(new DiFaceResult(118));
            }
        });
    }

    /* access modifiers changed from: protected */
    public void initDataFromIntent(Intent intent) {
        GuideResult guideResult = (GuideResult) intent.getSerializableExtra(GuideHelper.EXTRA_KEY_GUIDE_RESULT);
        this.f47148i = guideResult;
        GuideResult.ModelParam modelParam = guideResult.data.result.getModelParam();
        this.f47149j = modelParam;
        this.f47154o = modelParam.getAlive().getPicNum4AntiAttack();
        this.f47150k = this.f47148i.data.result.captureInfo;
    }

    /* access modifiers changed from: protected */
    public void onLeftTitleBtnClicked() {
        super.onLeftTitleBtnClicked();
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_BIOASSAY_EXIT, DiFaceLogger.getExitType("2"), (HashMap<String, Object>) null);
    }

    public void onBackPressed() {
        super.onBackPressed();
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_BIOASSAY_EXIT, DiFaceLogger.getExitType("1"), (HashMap<String, Object>) null);
    }

    /* access modifiers changed from: protected */
    public void setupSubViews() {
        this.f47142a = (RelativeLayout) findViewById(R.id.rl_root);
        this.f47143b = (GLSurfaceView) findViewById(R.id.gsv);
        this.f47145d = (TextView) findViewById(R.id.face_note2);
        m33814b();
        this.f47147f = new ICamera(DisplayUtils.getScreenWidth(this), DisplayUtils.getScreenHeight(this), 640, 480);
        DiFaceFacade.getInstance().report("11");
        SystemUtils.changeActBrightness(this, 0.8f);
    }

    /* renamed from: a */
    private void m33799a() {
        if (this.f47146e == null) {
            this.f47146e = new BioassayManager.Builder().setWaterType(this.f47148i.data.result.getWaterMarking()).setFps(this.f47147f.getFps()).setDetectTime(this.f47149j.getAlive().getTime4AntiAttack()).setFrameSkip(3).setActionPicCount(Math.min(this.f47154o, 5)).setBestPicQualityThreshold((double) this.f47149j.getQuality().getMinFaceQuality()).setAttackPicQualityThreshold((double) this.f47149j.getAlive().getMinFaceQuality4AntiAttack()).setBioassayListener(new BioassayManager.IBioassayListener() {
                public void onDetectFace(BioassayManager.FaceInfo faceInfo) {
                }

                public void onFailed(int i, String str) {
                }

                public void onProcess(int i) {
                    DiFaceBioassayActivity.this.f47144c.setProgress(MathUtils.clamp(i, 0, 100));
                }

                public void onFaceError(int i) {
                    DiFaceBioassayActivity.this.f47145d.setBackgroundResource(R.color.df_face_error_red_bg_color);
                    DiFaceBioassayActivity.this.f47145d.setTextColor(ResUtils.getColor(R.color.df_face_error_text_color));
                    int i2 = R.string.df_bioassay_act_error_not_centered;
                    if (i != 0) {
                        if (i == 1) {
                            i2 = R.string.df_bioassay_act_error_face_too_close;
                        } else if (i == 2) {
                            i2 = R.string.df_bioassay_act_error_face_too_far;
                        } else if (i != 3) {
                            i2 = i == 4 ? R.string.df_bioassay_act_error_pose : i == 5 ? R.string.df_bioassay_act_error_occ : i == 6 ? R.string.df_bioassay_act_error_blur : i == 7 ? R.string.df_bioassay_act_error_illum : R.string.df_bioassay_act_correct_tip;
                        }
                    }
                    DiFaceBioassayActivity.this.f47145d.setText(i2);
                }

                public void onFaceQualityError() {
                    DiFaceBioassayActivity.this.f47145d.setBackgroundResource(R.color.df_face_error_red_bg_color);
                    DiFaceBioassayActivity.this.f47145d.setTextColor(ResUtils.getColor(R.color.df_face_error_text_color));
                    DiFaceBioassayActivity.this.f47145d.setText(R.string.df_bioassay_act_correct_tip);
                }

                public void onSuccess(int i, List<BioassayManager.PicWithScore> list, List<BioassayManager.PicWithScore> list2, List<BioassayManager.PicWithScore> list3) {
                    DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_BI_DETECT_DONE);
                    DiFaceBioassayActivity diFaceBioassayActivity = DiFaceBioassayActivity.this;
                    String unused = diFaceBioassayActivity.f47155p = diFaceBioassayActivity.m33798a(list);
                    DiFaceBioassayActivity diFaceBioassayActivity2 = DiFaceBioassayActivity.this;
                    String unused2 = diFaceBioassayActivity2.f47157r = diFaceBioassayActivity2.m33798a(list2);
                    HashMap hashMap = new HashMap();
                    hashMap.put("bioType", 1);
                    hashMap.put("bestPic", DiFaceBioassayActivity.this.f47155p);
                    hashMap.put("actionPic", DiFaceBioassayActivity.this.f47157r);
                    DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_SOURCE_PICTURES, (HashMap<String, Object>) hashMap);
                    if (list.isEmpty()) {
                        DiFaceBioassayActivity.this.m33809a("1", "NO_BEST_PIC");
                    }
                    int size = list2.size();
                    if (size < DiFaceBioassayActivity.this.f47154o) {
                        DiFaceBioassayActivity diFaceBioassayActivity3 = DiFaceBioassayActivity.this;
                        diFaceBioassayActivity3.m33809a("2", "ACTION_PIC_NOT_ENOUGH, has " + size + ", requires " + DiFaceBioassayActivity.this.f47154o);
                    }
                    DiFaceBioassayActivity.this.m33810a(list, list2, list3);
                }
            }).create();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m33798a(List<BioassayManager.PicWithScore> list) {
        String str = "";
        if (list == null) {
            return str;
        }
        int size = list.size();
        int i = 0;
        while (i < size) {
            str = str + FileUtils.byteToMD5(list.get(i).rgba);
            i++;
            if (i < size) {
                str = str + ParamKeys.SIGN_AND;
            }
        }
        return str;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33809a(String str, String str2) {
        ReportFailedParam reportFailedParam = new ReportFailedParam();
        reportFailedParam.aliveErrorCode = str;
        reportFailedParam.aliveErrorMsg = str2;
        reportFailedParam.token = this.f47148i.token;
        reportFailedParam.sessionId = DiFaceFacade.getInstance().getSessionId();
        new ReportFailedModel(this).report(reportFailedParam, new AbsHttpCallback<ReportFailedResult>() {
            public void onSuccess(ReportFailedResult reportFailedResult) {
                int i = reportFailedResult.data.code;
                String str = reportFailedResult.data.message;
                LogUtils.m33563d("report living failed done, code=" + i + ", msg=" + str);
            }

            public void onFailed(int i, String str) {
                LogUtils.m33563d("report living failed failed, code=" + i + ", msg=" + str);
            }
        });
    }

    /* renamed from: b */
    private void m33814b() {
        this.f47143b.setEGLContextClientVersion(2);
        C154194 r0 = new RendererDecorate(this, this.f47143b) {
            public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig, SurfaceTexture surfaceTexture) {
                if (DiFaceBioassayActivity.this.f47147f != null) {
                    DiFaceBioassayActivity.this.f47147f.startPreview(surfaceTexture);
                    DiFaceBioassayActivity.this.f47147f.actionDetect(DiFaceBioassayActivity.this);
                }
                if (DiFaceBioassayActivity.this.f47152m != null) {
                    DiFaceFacade.getInstance().report("200", DiFaceLogger.setBioType((HashMap<String, Object>) null, "2"), (HashMap<String, Object>) null);
                    DiFaceBioassayActivity.this.f47152m.onStart();
                }
            }
        };
        this.f47151l = r0;
        this.f47143b.setRenderer(r0);
        this.f47143b.setRenderMode(0);
        GuideResult.Result.CaptureInfo captureInfo = this.f47150k;
        if (captureInfo != null) {
            this.f47151l.setRecordVideo(captureInfo.captureEnable, 640, 480, true, this.f47150k.bpp, this.f47150k.fps);
            this.f47152m = new RecordHelper(this, this.f47151l, "2", this.f47150k.maxTime, (long) this.f47150k.thresholdWifi, (long) this.f47150k.threshold4G);
            getLifecycle().addObserver(this.f47152m);
        }
        m33816c();
    }

    /* renamed from: c */
    private void m33816c() {
        int screenWidth = ResUtils.getScreenWidth();
        int i = (int) (((float) screenWidth) * 0.7f);
        int i2 = (int) (((float) i) * 1.3333334f);
        LogUtils.m33563d("screenW====" + screenWidth + ", glW=" + i + ", glH=" + i2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i2);
        layoutParams.addRule(14);
        this.f47143b.setLayoutParams(layoutParams);
        m33800a(i, i2);
    }

    /* renamed from: a */
    private void m33800a(int i, int i2) {
        this.f47144c = new RoundMask(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i2);
        layoutParams.addRule(6, R.id.gsv);
        layoutParams.addRule(5, R.id.gsv);
        this.f47142a.addView(this.f47144c, layoutParams);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.mRecreated) {
            finish();
            return;
        }
        this.f47147f.openCamera(this, true);
        if (!this.f47147f.isUsingFrontCamera()) {
            m33818d();
        }
        this.f47143b.onResume();
        m33799a();
    }

    /* renamed from: d */
    private void m33818d() {
        new AlertDialogFragment.Builder(this).setTitle(getString(R.string.df_bi_act_no_front_camera_dialog_title)).setMessage(getString(R.string.df_bi_act_no_front_camera_dialog_msg)).setPositiveButton((int) R.string.df_ok, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                alertDialogFragment.dismiss();
            }
        }).setCancelable(false).create().show(getSupportFragmentManager(), "");
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        if (this.f47146e != null) {
            this.f47146e.detect(bArr, 640, 480, this.f47147f.isUsingFrontCamera() ? this.f47147f.getCameraAngle() : this.f47147f.getCameraAngle() + 180, 4, this.f47149j.getDetect().getCenterRatio(), this.f47149j.getDetect().getMinCropRatio(), this.f47149j.getDetect().getMaxCropRatio());
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f47143b.onPause();
        this.f47147f.closeCamera();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33810a(List<BioassayManager.PicWithScore> list, List<BioassayManager.PicWithScore> list2, List<BioassayManager.PicWithScore> list3) {
        List<BioassayManager.PicWithScore> list4 = list2;
        List<BioassayManager.PicWithScore> list5 = list3;
        CompareParam compareParam = new CompareParam();
        compareParam.token = this.f47148i.token;
        compareParam.sessionId = DiFaceFacade.getInstance().getSessionId();
        compareParam.language = DiFaceFacade.getInstance().getLanguage();
        HashMap hashMap = new HashMap();
        hashMap.put("model", SystemUtil.getModel());
        hashMap.put(AdParams.USER_AGENT, String.format("Android/%s %s/%s", new Object[]{Build.VERSION.RELEASE, getApplicationContext().getPackageName(), SystemUtil.getVersionName(getApplicationContext())}));
        hashMap.put("brand", Build.BRAND);
        ArrayList arrayList = new ArrayList();
        byte[] generateAesKey = Encrypter.generateAesKey();
        hashMap.put("sc", Encrypter.encryptAesKey(generateAesKey));
        ArrayList arrayList2 = new ArrayList();
        for (BioassayManager.PicWithScore next : list) {
            arrayList.add("bestPic");
            hashMap.put("faceImageQualityScore", Double.valueOf(next.qualityScore));
            arrayList2.add(new MultiSerializerForAccessSecurity.MemJpg(Encrypter.encrypt(DFileUtils.compressBitmap(next.width, next.height, next.rgba), generateAesKey), "bestPic.jpg"));
        }
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        int i = 0;
        while (i < list2.size()) {
            BioassayManager.PicWithScore picWithScore = list4.get(i);
            StringBuilder sb = new StringBuilder();
            sb.append("actionPic");
            int i2 = i + 1;
            sb.append(i2);
            String sb2 = sb.toString();
            arrayList.add(sb2);
            String str = sb2;
            try {
                jSONArray.put(picWithScore.qualityScore);
                jSONArray2.put(picWithScore.attackScore);
            } catch (Exception e) {
                LogUtils.logStackTrace(e);
            }
            byte[] encrypt = Encrypter.encrypt(DFileUtils.compressBitmap(picWithScore.width, picWithScore.height, picWithScore.rgba), generateAesKey);
            arrayList2.add(new MultiSerializerForAccessSecurity.MemJpg(encrypt, str + ".jpg"));
            i = i2;
        }
        hashMap.put("suspectImageQualityScore", jSONArray);
        hashMap.put("suspectImageAttackScore", jSONArray2);
        if (list5 != null && list3.size() > 0) {
            BioassayManager.PicWithScore picWithScore2 = list5.get(0);
            byte[] compressBitmap = DFileUtils.compressBitmap(picWithScore2.width, picWithScore2.height, picWithScore2.rgba);
            arrayList.add("markPic");
            arrayList2.add(new MultiSerializerForAccessSecurity.MemJpg(Encrypter.encrypt(CompareModel.addJpgSessionId(this, compressBitmap, compareParam.sessionId), generateAesKey), "markPic.jpg"));
            if (list5.get(0).qualityOk == 1.0d) {
                compareParam.mark = this.f47148i.data.result.getWaterMarking() + "";
            } else {
                compareParam.mark = "-1";
            }
        }
        compareParam.buildExtra(hashMap);
        this.f47156q = m33798a(list);
        this.f47158s = m33798a(list4);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("bioType", 1);
        hashMap2.put("bestPic", this.f47156q);
        hashMap2.put("actionPic", this.f47158s);
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_UPLOAD_PRE_PICTURES, (HashMap<String, Object>) hashMap2);
        if (!this.f47155p.equals(this.f47156q) || !this.f47157r.equals(this.f47158s)) {
            DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_MD5_COMPARE);
        }
        m33808a(compareParam, (List<String>) arrayList, (List<MultiSerializerForAccessSecurity.MemJpg>) arrayList2);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33808a(final CompareParam compareParam, final List<String> list, final List<MultiSerializerForAccessSecurity.MemJpg> list2) {
        this.f47144c.onFaceOk();
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_COMPARE_REQUEST_LAUNCH);
        new CompareModel(this).compare(compareParam, list, list2, new AbsHttpCallback<CompareResult>() {
            public void onSuccess(CompareResult compareResult) {
                DiFaceBioassayActivity.this.f47144c.cancelRectAnim();
                if (DiFaceBioassayActivity.this.f47152m != null) {
                    DiFaceBioassayActivity.this.f47152m.onSuccess();
                }
                int i = compareResult.data.code;
                String str = compareResult.data.message;
                LogUtils.m33563d("compare onSuccess code=" + i + ", msg=" + str);
                DiFaceFacade.getInstance().reportEventWithCode("16", i);
                if (i == 100000) {
                    DiFaceBioassayActivity.this.finishWithResult(new DiFaceResult(0, str));
                    return;
                }
                String str2 = compareResult.data.result.show_appeal_entry ? compareResult.data.result.appealInfo.faceSessionId : "";
                AppealParam appealParam = new AppealParam();
                appealParam.token = DiFaceBioassayActivity.this.f47148i.token;
                appealParam.faceSessionId = str2;
                appealParam.country = DiFaceBioassayActivity.this.f47148i.data.result.country;
                appealParam.bizCode = DiFaceBioassayActivity.this.f47148i.bizCode;
                DiFaceBioassayActivity.this.m33802a(i, str, appealParam);
            }

            public void onFailed(int i, String str) {
                LogUtils.m33563d("compare onFailed code=" + i + ", msg=" + str);
                DiFaceBioassayActivity.this.f47144c.cancelRectAnim();
                if (DiFaceBioassayActivity.this.f47153n) {
                    boolean unused = DiFaceBioassayActivity.this.f47153n = false;
                    if (DiFaceBioassayActivity.this.f47152m != null) {
                        DiFaceBioassayActivity.this.f47152m.onSuccess();
                    }
                    DiFaceBioassayActivity.this.finishWithResult(new DiFaceResult(3, str));
                } else if (NetworkUtils.isNetworkConnected(DiFaceBioassayActivity.this)) {
                    boolean unused2 = DiFaceBioassayActivity.this.f47153n = true;
                    DiFaceBioassayActivity.this.m33808a(compareParam, (List<String>) list, (List<MultiSerializerForAccessSecurity.MemJpg>) list2);
                } else {
                    if (DiFaceBioassayActivity.this.f47152m != null) {
                        DiFaceBioassayActivity.this.f47152m.onSuccess();
                    }
                    DiFaceBioassayActivity diFaceBioassayActivity = DiFaceBioassayActivity.this;
                    diFaceBioassayActivity.m33801a(112, diFaceBioassayActivity.getString(R.string.df_no_net_connected_toast));
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33801a(int i, String str) {
        DFBioassayFailedAct.start(this, i, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33802a(int i, String str, AppealParam appealParam) {
        DFBioassayFailedAct.start(this, i, str, appealParam);
    }

    @Subscribe
    public void onBioassayFailedDoneEvent(BioassayFailedDoneEvent bioassayFailedDoneEvent) {
        finishWithResult(bioassayFailedDoneEvent.result);
    }

    @Subscribe
    public void onAppealAfterCompareFailedEvent(AppealAfterCompareFailedEvent appealAfterCompareFailedEvent) {
        finish();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        AlphaFace.unInit();
        BioassayManager bioassayManager = this.f47146e;
        if (bioassayManager != null) {
            bioassayManager.quit();
        }
    }
}
