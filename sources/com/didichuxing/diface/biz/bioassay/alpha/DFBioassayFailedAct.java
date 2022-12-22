package com.didichuxing.diface.biz.bioassay.alpha;

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
import com.didichuxing.diface.core.DiFaceFacade;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.didichuxing.diface.utils.StyleHelper;
import com.squareup.otto.Subscribe;
import com.taxis99.R;

public class DFBioassayFailedAct extends DFBaseAct {

    /* renamed from: a */
    private ImageView f47130a;

    /* renamed from: b */
    private TextView f47131b;

    /* renamed from: c */
    private TextView f47132c;

    /* renamed from: d */
    private Button f47133d;

    /* renamed from: e */
    private Button f47134e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f47135f;

    /* renamed from: g */
    private String f47136g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public AppealParam f47137h;

    /* renamed from: b */
    private boolean m33793b(int i) {
        return i == 100004 || i == 112 || i == 113 || i == 106;
    }

    /* access modifiers changed from: protected */
    public int getActTitleId() {
        return R.string.df_act_title;
    }

    /* access modifiers changed from: protected */
    public int getContentLayout() {
        return R.layout.act_df_biassay_failed_layout;
    }

    /* access modifiers changed from: protected */
    public boolean needEventBus() {
        return true;
    }

    public static void start(Context context, int i, String str) {
        start(context, i, str, new AppealParam());
    }

    public static void start(Context context, int i, String str, AppealParam appealParam) {
        StyleHelper.toBioassayFailedAct(context, i, str, appealParam);
    }

    public static void realStart(Context context, int i, String str, AppealParam appealParam) {
        Intent intent = new Intent(context, DFBioassayFailedAct.class);
        intent.putExtra("code", i);
        intent.putExtra("msg", str);
        intent.putExtra("param", appealParam);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void initDataFromIntent(Intent intent) {
        this.f47135f = intent.getIntExtra("code", 100001);
        this.f47136g = intent.getStringExtra("msg");
        this.f47137h = (AppealParam) intent.getSerializableExtra("param");
    }

    /* access modifiers changed from: protected */
    public void makeFaceResult(DiFaceResult diFaceResult) {
        BusUtils.post(new BioassayFailedDoneEvent(m33794c(this.f47135f)));
    }

    /* access modifiers changed from: protected */
    public void setupSubViews() {
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_ENTER_COMPARE_FAILED);
        this.f47130a = (ImageView) findViewById(R.id.face_failed_icon);
        this.f47131b = (TextView) findViewById(R.id.face_failed_title);
        this.f47132c = (TextView) findViewById(R.id.face_failed_desc);
        this.f47133d = (Button) findViewById(R.id.exit_btn);
        this.f47134e = (Button) findViewById(R.id.appeal_btn);
        this.f47131b.setText(m33789a(this.f47135f));
        this.f47132c.setText(this.f47136g);
        this.f47133d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_COMPARE_FAILED_EXIT_CLICKED);
                DFBioassayFailedAct dFBioassayFailedAct = DFBioassayFailedAct.this;
                BusUtils.post(new BioassayFailedDoneEvent(dFBioassayFailedAct.m33794c(dFBioassayFailedAct.f47135f)));
                DFBioassayFailedAct.this.finish();
            }
        });
        if (!TextUtils.isEmpty(this.f47137h.faceSessionId)) {
            this.f47134e.setVisibility(0);
            this.f47133d.setBackgroundResource(R.drawable.df_face_failed_result_btn_bg);
            this.f47134e.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_COMPARE_FAILED_APPEAL_CLICKED);
                    DFBioassayFailedAct dFBioassayFailedAct = DFBioassayFailedAct.this;
                    AppealLauncher.start(dFBioassayFailedAct, dFBioassayFailedAct.f47137h);
                }
            });
        } else {
            this.f47133d.setTextColor(getResources().getColor(R.color.df_bioassay_failed_button_text_color));
        }
        int i = R.drawable.bioassay_failed_compare;
        if (m33793b(this.f47135f)) {
            i = R.drawable.bioassay_failed_system_busy;
        }
        this.f47130a.setImageResource(i);
    }

    /* renamed from: a */
    private int m33789a(int i) {
        if (i == 100002 || i == 104) {
            return R.string.df_bi_failed_act_too_many_failed_title;
        }
        return m33793b(i) ? R.string.df_bi_failed_act_system_error_title : R.string.df_bi_failed_act_compare_failed_title;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public DiFaceResult m33794c(int i) {
        if (i > 100000) {
            i = (i == 100001 || i == 100005) ? 103 : i == 100002 ? 104 : 106;
        }
        return new DiFaceResult(i, this.f47136g);
    }

    @Subscribe
    public void onAppealRequestSuccessEvent(AppealRequestSuccessEvent appealRequestSuccessEvent) {
        finish();
    }
}
