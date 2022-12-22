package com.didichuxing.diface.biz.bioassay.alpha.p181br;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didichuxing.dfbasesdk.utils.BusUtils;
import com.didichuxing.diface.DiFaceResult;
import com.didichuxing.diface.act.DFBaseAct;
import com.didichuxing.diface.appeal.AppealLauncher;
import com.didichuxing.diface.appeal.AppealParam;
import com.didichuxing.diface.appeal.AppealRequestSuccessEvent;
import com.didichuxing.diface.biz.bioassay.alpha.BioassayFailedDoneEvent;
import com.didichuxing.diface.core.DiFaceFacade;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.squareup.otto.Subscribe;
import com.taxis99.R;

/* renamed from: com.didichuxing.diface.biz.bioassay.alpha.br.BRDFBioassayFailedAct */
public class BRDFBioassayFailedAct extends DFBaseAct {

    /* renamed from: a */
    private ImageView f47165a;

    /* renamed from: b */
    private TextView f47166b;

    /* renamed from: c */
    private TextView f47167c;

    /* renamed from: d */
    private Button f47168d;

    /* renamed from: e */
    private Button f47169e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f47170f;

    /* renamed from: g */
    private String f47171g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public AppealParam f47172h;

    /* renamed from: b */
    private boolean m33828b(int i) {
        return i == 100004 || i == 112 || i == 113 || i == 106;
    }

    /* access modifiers changed from: protected */
    public int getActTitleId() {
        return R.string.df_act_title;
    }

    /* access modifiers changed from: protected */
    public int getContentLayout() {
        return R.layout.br_act_df_biassay_failed_layout;
    }

    /* access modifiers changed from: protected */
    public boolean needEventBus() {
        return true;
    }

    public static void realStart(Context context, int i, String str, AppealParam appealParam) {
        Intent intent = new Intent(context, BRDFBioassayFailedAct.class);
        intent.putExtra("code", i);
        intent.putExtra("msg", str);
        intent.putExtra("param", appealParam);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void initDataFromIntent(Intent intent) {
        this.f47170f = intent.getIntExtra("code", 100001);
        this.f47171g = intent.getStringExtra("msg");
        this.f47172h = (AppealParam) intent.getSerializableExtra("param");
    }

    /* access modifiers changed from: protected */
    public void makeFaceResult(DiFaceResult diFaceResult) {
        BusUtils.post(new BioassayFailedDoneEvent(m33829c(this.f47170f)));
    }

    /* access modifiers changed from: protected */
    public void setupSubViews() {
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_ENTER_COMPARE_FAILED);
        this.f47165a = (ImageView) findViewById(R.id.face_failed_icon);
        this.f47166b = (TextView) findViewById(R.id.face_failed_title);
        this.f47167c = (TextView) findViewById(R.id.face_failed_desc);
        this.f47168d = (Button) findViewById(R.id.exit_btn);
        this.f47169e = (Button) findViewById(R.id.appeal_btn);
        this.f47166b.setText(m33824a(this.f47170f));
        this.f47167c.setText(this.f47171g);
        this.f47168d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_COMPARE_FAILED_EXIT_CLICKED);
                BRDFBioassayFailedAct bRDFBioassayFailedAct = BRDFBioassayFailedAct.this;
                BusUtils.post(new BioassayFailedDoneEvent(bRDFBioassayFailedAct.m33829c(bRDFBioassayFailedAct.f47170f)));
                BRDFBioassayFailedAct.this.finish();
            }
        });
        if (!TextUtils.isEmpty(this.f47172h.faceSessionId)) {
            this.f47169e.setVisibility(0);
            this.f47168d.setBackgroundResource(R.drawable.df_face_failed_result_btn_bg);
            this.f47169e.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_COMPARE_FAILED_APPEAL_CLICKED);
                    BRDFBioassayFailedAct bRDFBioassayFailedAct = BRDFBioassayFailedAct.this;
                    AppealLauncher.start(bRDFBioassayFailedAct, bRDFBioassayFailedAct.f47172h);
                }
            });
        } else {
            this.f47168d.setTextColor(getResources().getColor(R.color.br_df_bioassay_failed_button_text_color));
        }
        int i = R.drawable.br_bioassay_failed_compare;
        if (m33828b(this.f47170f)) {
            i = R.drawable.br_bioassay_failed_system_busy;
        }
        this.f47165a.setImageResource(i);
    }

    @Subscribe
    public void onAppealRequestSuccessEvent(AppealRequestSuccessEvent appealRequestSuccessEvent) {
        finish();
    }

    /* renamed from: a */
    private int m33824a(int i) {
        if (i == 100002 || i == 104) {
            return R.string.df_bi_failed_act_too_many_failed_title;
        }
        return m33828b(i) ? R.string.df_bi_failed_act_system_error_title : R.string.df_bi_failed_act_compare_failed_title;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public DiFaceResult m33829c(int i) {
        if (i > 100000) {
            i = (i == 100001 || i == 100005) ? 103 : i == 100002 ? 104 : 106;
        }
        return new DiFaceResult(i, this.f47171g);
    }
}
