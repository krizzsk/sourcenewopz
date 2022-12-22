package com.didichuxing.diface.appeal.mexico;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import com.didi.autotracker.AutoTrackHelper;
import com.didichuxing.dfbasesdk.data.NewBaseResult;
import com.didichuxing.dfbasesdk.http.AbsRpcCallback;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.diface.act.DFStyleBaseAct;
import com.didichuxing.diface.appeal.AppealDoneEvent;
import com.didichuxing.diface.appeal.AppealLauncher;
import com.didichuxing.diface.appeal.AppealResultAct;
import com.didichuxing.diface.appeal.TakePhotoDoneEvent2;
import com.didichuxing.diface.appeal.TakePhotoGuideAct;
import com.didichuxing.diface.appeal.TakePhotoInfo;
import com.didichuxing.diface.appeal.mexico.adapter.MaterialsSubmitAdapter;
import com.didichuxing.diface.appeal.mexico.adapter.OnItemClickListener;
import com.didichuxing.diface.appeal.mexico.model.AppealAdditionTypesBean;
import com.didichuxing.diface.appeal.mexico.model.DocumentCardsBean;
import com.didichuxing.diface.appeal.mexico.toolkit.Counter;
import com.didichuxing.diface.core.DiFaceFacade;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.didichuxing.diface.utils.ToastUtil;
import com.squareup.otto.Subscribe;
import com.taxis99.R;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MaterialsSubmitAct extends DFStyleBaseAct implements C15390a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Button f47067a;

    /* renamed from: b */
    private ListView f47068b;

    /* renamed from: c */
    private MaterialsSubmitAdapter f47069c;

    /* renamed from: d */
    private AppealAdditionTypesBean f47070d;

    /* renamed from: e */
    private Counter f47071e;

    /* access modifiers changed from: protected */
    public int getActTitleId() {
        return R.string.df_appeal_act_title;
    }

    /* access modifiers changed from: protected */
    public int getContentLayout() {
        return R.layout.act_df_materials_submit_layout;
    }

    /* access modifiers changed from: protected */
    public boolean needEventBus() {
        return true;
    }

    public void onCanceled() {
    }

    /* access modifiers changed from: protected */
    public int progressMsgResId() {
        return R.string.df_appeal_materials_submit_loading_msg;
    }

    public static void start(Context context, AppealAdditionTypesBean appealAdditionTypesBean) {
        Intent intent = new Intent(context, MaterialsSubmitAct.class);
        intent.putExtra(AppealLauncher.EXTRA_KEY_SUBMIT_PARAM, appealAdditionTypesBean);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void initDataFromIntent(Intent intent) {
        this.f47070d = (AppealAdditionTypesBean) intent.getSerializableExtra(AppealLauncher.EXTRA_KEY_SUBMIT_PARAM);
    }

    /* access modifiers changed from: protected */
    public void setupSubViews() {
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_ENTER_SUBMIT_MATERIALS);
        this.f47071e = new Counter(this.f47070d.getDocumentCards(), new Runnable() {
            public void run() {
                if (MaterialsSubmitAct.this.f47067a != null) {
                    MaterialsSubmitAct.this.f47067a.setEnabled(true);
                }
            }
        });
        this.f47068b = (ListView) findViewById(R.id.lv_content_list);
        MaterialsSubmitAdapter materialsSubmitAdapter = new MaterialsSubmitAdapter(this);
        this.f47069c = materialsSubmitAdapter;
        this.f47068b.setAdapter(materialsSubmitAdapter);
        this.f47069c.addAllItem(this.f47070d.getDocumentCards(), true);
        this.f47069c.setOnItemClickListener(new OnItemClickListener<DocumentCardsBean>() {
            public void onClick(View view, int i, DocumentCardsBean documentCardsBean) {
                TakePhotoGuideAct.start(MaterialsSubmitAct.this, documentCardsBean);
            }
        });
        Button button = (Button) findViewById(R.id.submit_btn);
        this.f47067a = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                MaterialsSubmitAct.this.m33735b();
            }
        });
    }

    @Subscribe
    public void onAppealDoneEvent(AppealDoneEvent appealDoneEvent) {
        finish();
    }

    @Subscribe
    public void onTakePhotoDoneEvent(TakePhotoDoneEvent2 takePhotoDoneEvent2) {
        Counter counter = this.f47071e;
        if (counter != null) {
            counter.remove(takePhotoDoneEvent2.documentCardsBean);
        }
        this.f47069c.takeDone(takePhotoDoneEvent2.documentCardsBean);
    }

    /* access modifiers changed from: protected */
    public void onLeftTitleBtnClicked() {
        Counter counter = this.f47071e;
        if (counter == null || counter.residue() != 0) {
            super.onLeftTitleBtnClicked();
        } else {
            m33733a();
        }
    }

    public void onBackPressed() {
        Counter counter = this.f47071e;
        if (counter == null || counter.residue() != 0) {
            super.onBackPressed();
        } else {
            m33733a();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        TakePhotoInfo.delAllPhotos(getCacheDir());
    }

    /* renamed from: a */
    private void m33733a() {
        new BackConfirmDFragment().show(getSupportFragmentManager(), "dialog");
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m33735b() {
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_SUBMIT_MATERIALS_CLICKED);
        showProgress();
        GlobalSubmitParam c = m33737c();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        m33734a(arrayList, arrayList2);
        new SubmitModel(this).submit(c, arrayList, arrayList2, new AbsRpcCallback<NewBaseResult<SubmitResult>, SubmitResult>() {
            /* access modifiers changed from: protected */
            public void failure(int i, String str) {
                LogUtils.m33563d("submit materials failed, code====" + i + ", msg=" + str);
                MaterialsSubmitAct.this.hideProgress();
                ToastUtil.showToastInfo((Context) MaterialsSubmitAct.this, i == 100004 ? R.string.df_appeal_materials_submit_repeated_failed_msg : R.string.df_appeal_materials_submit_failed_msg);
            }

            /* access modifiers changed from: protected */
            public void success(SubmitResult submitResult, int i, String str) {
                MaterialsSubmitAct.this.hideProgress();
                LogUtils.m33563d("submit materials, code====" + i + ", msg=" + str);
                DiFaceFacade.getInstance().reportEventWithCode(DiFaceLogger.EVENT_ID_SUBMIT_MATERIALS_CALLBACK, i);
                ToastUtil.showToastInfo((Context) MaterialsSubmitAct.this, (int) R.string.df_appeal_materials_submit_success_msg);
                AppealResultAct.start(MaterialsSubmitAct.this, 2, str);
            }
        });
    }

    /* renamed from: a */
    private void m33734a(List<String> list, List<File> list2) {
        AppealAdditionTypesBean appealAdditionTypesBean = this.f47070d;
        if (appealAdditionTypesBean != null && appealAdditionTypesBean.getDocumentCards() != null && this.f47070d.getDocumentCards().size() > 0) {
            for (DocumentCardsBean next : this.f47070d.getDocumentCards()) {
                list.add(next.getArgs());
                File cacheDir = getCacheDir();
                list2.add(new File(cacheDir, next.getArgs() + ".jpg"));
            }
        }
    }

    /* renamed from: c */
    private GlobalSubmitParam m33737c() {
        GlobalSubmitParam globalSubmitParam = new GlobalSubmitParam();
        globalSubmitParam.token = this.f47070d.getToken();
        globalSubmitParam.faceSessionId = this.f47070d.getSessionId();
        globalSubmitParam.language = DiFaceFacade.getInstance().getLanguage();
        return globalSubmitParam;
    }

    public void onConfirmed() {
        finish();
    }
}
