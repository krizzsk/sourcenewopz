package com.didichuxing.diface.biz.preguide;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.didichuxing.dfbasesdk.data.NewBaseResult;
import com.didichuxing.dfbasesdk.http.AbsOkHttpCallback;
import com.didichuxing.dfbasesdk.http.AbsRpcCallback;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.dfbasesdk.utils.NetworkUtils;
import com.didichuxing.diface.BuildConfig;
import com.didichuxing.diface.DiFace;
import com.didichuxing.diface.DiFaceParam;
import com.didichuxing.diface.DiFaceResult;
import com.didichuxing.diface.act.DFBaseAct;
import com.didichuxing.diface.appeal.AppealCanceledEvent;
import com.didichuxing.diface.appeal.AppealDoneEvent;
import com.didichuxing.diface.appeal.AppealLauncher;
import com.didichuxing.diface.appeal.AppealParam;
import com.didichuxing.diface.appeal.AppealResultAct;
import com.didichuxing.diface.appeal.ReappealEvent;
import com.didichuxing.diface.biz.bioassay.alpha.BioassayFailedDoneEvent;
import com.didichuxing.diface.biz.bioassay.alpha.DFBioassayFailedAct;
import com.didichuxing.diface.biz.guide.DiFaceGuideActivity;
import com.didichuxing.diface.biz.guide.GuideHelper;
import com.didichuxing.diface.biz.guide.p183M.GuideModel;
import com.didichuxing.diface.biz.guide.p183M.GuideParam;
import com.didichuxing.diface.biz.guide.p183M.GuideResult;
import com.didichuxing.diface.biz.preguide.model.PreGuideModel;
import com.didichuxing.diface.core.DiFaceFacade;
import com.didichuxing.diface.data.ModelUpdateResult;
import com.didichuxing.diface.data.PreGuideContent;
import com.didichuxing.diface.data.PreGuideResult;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.didichuxing.diface.utils.GDfApi;
import com.didichuxing.diface.utils.HttpUtils;
import com.didichuxing.diface.utils.ModelFileUpdateUtils;
import com.didichuxing.diface.utils.StyleHelper;
import com.didichuxing.diface.utils.http.AbsHttpCallback;
import com.didichuxing.sdk.alphaface.core.AlphaFaceFacade;
import com.squareup.otto.Subscribe;
import com.taxis99.R;
import java.util.HashMap;

public class DFPreGuideAct extends DFBaseAct {

    /* renamed from: a */
    private static final String f47474a = "face_param";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public GuideParam f47475b;

    /* renamed from: c */
    private GuideModel f47476c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public GuideResult f47477d;

    /* renamed from: e */
    private GuideHelper f47478e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public PreGuideContent f47479f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f47480g;

    /* access modifiers changed from: protected */
    public int getActTitleId() {
        return R.string.pre_guide_act_title;
    }

    /* access modifiers changed from: protected */
    public int getContentLayout() {
        return R.layout.pre_guide_act;
    }

    /* access modifiers changed from: protected */
    public boolean needEventBus() {
        return true;
    }

    public static void start(Context context, DiFaceParam diFaceParam) {
        Intent intent = new Intent(context, DFPreGuideAct.class);
        intent.putExtra(f47474a, diFaceParam);
        intent.addFlags(268435456);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void setupSubViews() {
        hideTitleArea();
    }

    /* access modifiers changed from: protected */
    public void initDataFromIntent(Intent intent) {
        DiFaceParam diFaceParam = (DiFaceParam) intent.getSerializableExtra(f47474a);
        this.f47478e = new GuideHelper(this);
        GuideParam guideParam = new GuideParam();
        this.f47475b = guideParam;
        guideParam.bizCode = diFaceParam.getBizCode();
        this.f47475b.token = diFaceParam.getToken();
        this.f47475b.data = diFaceParam.getAllData();
        this.f47475b.sdkVersion = BuildConfig.VERSION_NAME;
        this.f47475b.sessionId = diFaceParam.getSessionId();
        this.f47475b.language = diFaceParam.getLanguage();
        this.f47476c = new GuideModel(this);
    }

    /* access modifiers changed from: protected */
    public void requestDataFromServer() {
        m33988a();
    }

    /* renamed from: a */
    private void m33988a() {
        showProgress();
        AlphaFaceFacade.getInstance().releaseModelFilesIfNeeded();
        this.f47475b.modelVersion = ModelFileUpdateUtils.getModelFilesVersion();
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_PREGUIDE_CONFIG_REQUEST);
        new PreGuideModel(this).fetchGuideInfo(this.f47475b, new AbsRpcCallback<NewBaseResult<PreGuideResult>, PreGuideResult>() {
            /* access modifiers changed from: protected */
            public void failure(int i, String str) {
                DiFaceFacade.getInstance().reportEventWithCode(DiFaceLogger.EVENT_ID_PREGUIDE_CONFIG_CALLBACK, i);
                PreGuideContent unused = DFPreGuideAct.this.f47479f = null;
                DFPreGuideAct.this.m34001c();
            }

            /* access modifiers changed from: protected */
            public void success(PreGuideResult preGuideResult, int i, String str) {
                DiFaceFacade.getInstance().reportEventWithCode(DiFaceLogger.EVENT_ID_PREGUIDE_CONFIG_CALLBACK, i);
                if (preGuideResult != null) {
                    PreGuideContent unused = DFPreGuideAct.this.f47479f = preGuideResult.guideContent;
                }
                DFPreGuideAct.this.m34001c();
            }
        });
    }

    /* renamed from: b */
    private void m33997b() {
        showProgress();
        HashMap hashMap = new HashMap();
        hashMap.put("sdkVersion", BuildConfig.VERSION_NAME);
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_CHECK_MODEL_REQ);
        GDfApi.postNew(HttpUtils.getNewFinalUrl("dd_face_global_check_algorithm_model_update"), hashMap, new AbsOkHttpCallback<ModelUpdateResult>() {
            public void onSuccess(ModelUpdateResult modelUpdateResult) {
                DiFaceFacade.getInstance().reportEventWithCode(DiFaceLogger.EVENT_ID_CHECK_MODEL_REQ_CALLBACK, 100000);
                if (modelUpdateResult == null || TextUtils.isEmpty(modelUpdateResult.newModelUrl)) {
                    DFPreGuideAct.this.m34001c();
                }
            }

            public void onFailed(int i, String str) {
                DiFaceFacade.getInstance().reportEventWithCode(DiFaceLogger.EVENT_ID_CHECK_MODEL_REQ_CALLBACK, i);
                DFPreGuideAct.this.m34001c();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m34001c() {
        showProgress();
        DiFaceFacade.getInstance().report("8");
        this.f47475b.modelVersion = ModelFileUpdateUtils.getModelFilesVersion();
        this.f47476c.fetchGuideInfo(this.f47475b, new AbsHttpCallback<GuideResult>() {
            public void onSuccess(GuideResult guideResult) {
                DFPreGuideAct.this.hideProgress();
                GuideResult unused = DFPreGuideAct.this.f47477d = guideResult;
                DFPreGuideAct.this.f47477d.bizCode = String.valueOf(DFPreGuideAct.this.f47475b.bizCode);
                guideResult.bizCode = String.valueOf(DFPreGuideAct.this.f47475b.bizCode);
                int i = guideResult.data.code;
                String str = guideResult.data.message;
                guideResult.token = DFPreGuideAct.this.f47475b.token;
                LogUtils.m33563d("guide2 success, code=" + i + ", msg=" + str);
                boolean unused2 = DFPreGuideAct.this.f47480g = false;
                DiFaceFacade.getInstance().reportEventWithCode("9", i);
                if (!(guideResult == null || guideResult.data == null || guideResult.data.result == null)) {
                    StyleHelper.setCountry(guideResult.data.result.country);
                }
                if (i == 100000 || i == 100006) {
                    if (guideResult.data.result.show_guide_page) {
                        DFPreGuideAct dFPreGuideAct = DFPreGuideAct.this;
                        DiFaceGuideActivity.start(dFPreGuideAct, guideResult, dFPreGuideAct.f47479f);
                        DFPreGuideAct.this.finish();
                    } else if (i == 100000) {
                        DFPreGuideAct.this.m33991a(guideResult);
                    } else {
                        DFPreGuideAct.this.m33989a(3, str);
                    }
                } else if (i == 100001) {
                    DFPreGuideAct.this.m33990a(new DiFaceResult(guideResult.data.result.session_id, 1, str));
                } else if (i == 100002) {
                    DFPreGuideAct.this.m33990a(new DiFaceResult(3, str));
                } else if (i == 100004) {
                    DFBioassayFailedAct.start(DFPreGuideAct.this, 104, str);
                } else if (i == 100005) {
                    DFPreGuideAct.this.m33989a(2, str);
                } else if (i == 999999) {
                    DFBioassayFailedAct.start(DFPreGuideAct.this, 107, str);
                } else if (i == 100007) {
                    DFBioassayFailedAct.start(DFPreGuideAct.this, 113, str);
                } else if (i == 100008) {
                    AppealParam appealParam = new AppealParam();
                    appealParam.token = DFPreGuideAct.this.f47475b.token;
                    appealParam.faceSessionId = guideResult.data.result.appealInfo.faceSessionId;
                    appealParam.country = guideResult.data.result.country;
                    appealParam.bizCode = guideResult.bizCode;
                    DFBioassayFailedAct.start(DFPreGuideAct.this, 104, str, appealParam);
                } else {
                    DFBioassayFailedAct.start(DFPreGuideAct.this, 106, str);
                }
            }

            public void onFailed(int i, String str) {
                DFPreGuideAct.this.hideProgress();
                LogUtils.m33563d("guide2 failed, code=" + i + ", msg=" + str);
                if (DFPreGuideAct.this.f47480g) {
                    boolean unused = DFPreGuideAct.this.f47480g = false;
                    DFPreGuideAct.this.m33990a(new DiFaceResult(3, str));
                } else if (NetworkUtils.isNetworkConnected(DFPreGuideAct.this)) {
                    boolean unused2 = DFPreGuideAct.this.f47480g = true;
                    DFPreGuideAct.this.m34001c();
                } else {
                    DFPreGuideAct dFPreGuideAct = DFPreGuideAct.this;
                    DFBioassayFailedAct.start(dFPreGuideAct, 112, dFPreGuideAct.getString(R.string.df_no_net_connected_toast));
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void makeFaceResult(DiFaceResult diFaceResult) {
        super.makeFaceResult(diFaceResult);
        DiFaceFacade.getInstance().notifyCallback(diFaceResult);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33990a(DiFaceResult diFaceResult) {
        finishWithResult(diFaceResult);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33991a(GuideResult guideResult) {
        this.f47478e.toBioassayAct(this, guideResult);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33989a(int i, String str) {
        AppealResultAct.start(this, i, str);
    }

    @Subscribe
    public void onAppealDoneEvent(AppealDoneEvent appealDoneEvent) {
        if (appealDoneEvent.status == 2) {
            m33990a(new DiFaceResult(114));
        } else {
            this.f47478e.toBioassayAct(this, this.f47477d);
        }
    }

    @Subscribe
    public void onReappealEvent(ReappealEvent reappealEvent) {
        AppealParam appealParam = new AppealParam();
        appealParam.token = this.f47477d.token;
        appealParam.faceSessionId = this.f47477d.data.result.appealInfo.faceSessionId;
        appealParam.country = this.f47477d.data.result.country;
        GuideParam guideParam = this.f47475b;
        appealParam.bizCode = String.valueOf(guideParam != null ? guideParam.bizCode : 0);
        AppealLauncher.start(this, appealParam);
    }

    @Subscribe
    public void onAppealCanceledEvent(AppealCanceledEvent appealCanceledEvent) {
        m33990a(new DiFaceResult(103, appealCanceledEvent.getMsg()));
    }

    @Subscribe
    public void onBioassayFailedDoneEvent(BioassayFailedDoneEvent bioassayFailedDoneEvent) {
        m33990a(bioassayFailedDoneEvent.result);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1) {
            return;
        }
        if (i2 == -1) {
            m33998b((DiFaceResult) intent.getSerializableExtra(DiFace.DIFACE_RESULT_KEY));
        } else if (i2 == 0) {
            m33990a(new DiFaceResult(102));
        }
    }

    /* renamed from: b */
    private void m33998b(DiFaceResult diFaceResult) {
        m33990a(diFaceResult);
    }
}
