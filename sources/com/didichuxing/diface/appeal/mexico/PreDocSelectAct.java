package com.didichuxing.diface.appeal.mexico;

import android.content.Context;
import android.content.Intent;
import com.didichuxing.dfbasesdk.data.NewBaseResult;
import com.didichuxing.dfbasesdk.http.AbsRpcCallback;
import com.didichuxing.dfbasesdk.utils.BusUtils;
import com.didichuxing.diface.act.DFBaseAct;
import com.didichuxing.diface.appeal.AppealLauncher;
import com.didichuxing.diface.appeal.AppealParam;
import com.didichuxing.diface.appeal.mexico.model.AppealParameters;
import com.didichuxing.diface.appeal.mexico.request.AppealModel;
import com.didichuxing.diface.biz.bioassay.alpha.AppealAfterCompareFailedEvent;
import com.didichuxing.diface.core.DiFaceFacade;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.didichuxing.diface.utils.ToastUtil;
import com.taxis99.R;

public class PreDocSelectAct extends DFBaseAct {
    public static final String EXTRA_KEY_APPEAL_PARAM = "appeal_param";

    /* renamed from: a */
    private AppealParam f47072a;

    /* access modifiers changed from: protected */
    public int getActTitleId() {
        return R.string.pre_guide_act_title;
    }

    /* access modifiers changed from: protected */
    public int getContentLayout() {
        return R.layout.pre_guide_act;
    }

    public static void start(Context context, AppealParam appealParam) {
        Intent intent = new Intent(context, PreDocSelectAct.class);
        intent.putExtra(EXTRA_KEY_APPEAL_PARAM, appealParam);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void setupSubViews() {
        hideTitleArea();
    }

    /* access modifiers changed from: protected */
    public void initDataFromIntent(Intent intent) {
        if (intent != null) {
            this.f47072a = (AppealParam) intent.getSerializableExtra(EXTRA_KEY_APPEAL_PARAM);
        }
    }

    /* access modifiers changed from: protected */
    public void requestDataFromServer() {
        showProgress();
        final com.didichuxing.diface.appeal.mexico.request.AppealParam a = m33738a();
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_APPEAL_CONFIG_REQUEST);
        new AppealModel(this).fetchAppealInfo(a, new AbsRpcCallback<NewBaseResult<AppealParameters>, AppealParameters>() {
            /* access modifiers changed from: protected */
            public void failure(int i, String str) {
                if (!PreDocSelectAct.this.isFinishing()) {
                    PreDocSelectAct.this.hideProgress();
                    DiFaceFacade.getInstance().reportEventWithCode(DiFaceLogger.EVENT_ID_APPEAL_CONFIG_CALLBACK, i);
                    PreDocSelectAct.this.finish();
                    ToastUtil.showToastInfo((Context) PreDocSelectAct.this, (int) R.string.df_no_net_connected_toast);
                }
            }

            /* access modifiers changed from: protected */
            public void success(AppealParameters appealParameters, int i, String str) {
                if (!PreDocSelectAct.this.isFinishing()) {
                    PreDocSelectAct.this.hideProgress();
                    if (appealParameters != null) {
                        appealParameters.setToken(a.token);
                        appealParameters.setSessionId(a.sessionId);
                    }
                    DiFaceFacade.getInstance().reportEventWithCode(DiFaceLogger.EVENT_ID_APPEAL_CONFIG_CALLBACK, i);
                    BusUtils.post(new AppealAfterCompareFailedEvent());
                    DocSelectAct.start(PreDocSelectAct.this, appealParameters);
                    PreDocSelectAct.this.finish();
                    AppealLauncher.finishActivity();
                }
            }
        });
    }

    /* renamed from: a */
    private com.didichuxing.diface.appeal.mexico.request.AppealParam m33738a() {
        com.didichuxing.diface.appeal.mexico.request.AppealParam appealParam = new com.didichuxing.diface.appeal.mexico.request.AppealParam();
        try {
            appealParam.bizCode = Integer.parseInt(this.f47072a.bizCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        appealParam.token = this.f47072a.token;
        appealParam.sessionId = this.f47072a.faceSessionId;
        appealParam.language = DiFaceFacade.getInstance().getLanguage();
        return appealParam;
    }
}
