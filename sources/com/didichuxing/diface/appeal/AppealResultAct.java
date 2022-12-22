package com.didichuxing.diface.appeal;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didichuxing.dfbasesdk.utils.BusUtils;
import com.didichuxing.diface.act.DFBaseAct;
import com.didichuxing.diface.core.DiFaceFacade;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.squareup.otto.Subscribe;
import com.taxis99.R;
import java.util.HashMap;

public class AppealResultAct extends DFBaseAct {
    public static final int STATUS_FAIL = 3;
    public static final int STATUS_UNDERWAY = 2;

    /* renamed from: a */
    private ImageView f46971a;

    /* renamed from: b */
    private TextView f46972b;

    /* renamed from: c */
    private TextView f46973c;

    /* renamed from: d */
    private Button f46974d;

    /* renamed from: e */
    private Button f46975e;

    /* renamed from: f */
    private int f46976f;

    /* renamed from: g */
    private String f46977g;

    /* access modifiers changed from: protected */
    public int getActTitleId() {
        return R.string.df_appeal_result_act_title;
    }

    /* access modifiers changed from: protected */
    public int getContentLayout() {
        return R.layout.act_df_appeal_result_layout;
    }

    /* access modifiers changed from: protected */
    public boolean needEventBus() {
        return true;
    }

    public static void start(Context context, int i, String str) {
        Intent intent = new Intent(context, AppealResultAct.class);
        intent.putExtra("status", i);
        intent.putExtra("desc", str);
        context.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void initDataFromIntent(Intent intent) {
        this.f46976f = intent.getIntExtra("status", 2);
        this.f46977g = intent.getStringExtra("desc");
    }

    /* access modifiers changed from: protected */
    public void setupSubViews() {
        HashMap hashMap = new HashMap();
        hashMap.put("status", Integer.valueOf(this.f46976f));
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_ENTER_APPEAL_RESULT, (HashMap<String, Object>) hashMap);
        ImageView imageView = (ImageView) findViewById(R.id.result_status_icon);
        this.f46971a = imageView;
        imageView.setImageResource(m33666b());
        TextView textView = (TextView) findViewById(R.id.result_title_tv);
        this.f46972b = textView;
        textView.setText(m33667c());
        TextView textView2 = (TextView) findViewById(R.id.result_desc_tv);
        this.f46973c = textView2;
        textView2.setText(this.f46977g);
        this.f46974d = (Button) findViewById(R.id.main_btn);
        this.f46975e = (Button) findViewById(R.id.secondary_btn);
        if (this.f46976f == 3) {
            this.f46974d.setText(R.string.df_appeal_result_main_btn_text);
            this.f46974d.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_APPEAL_RESULT_REAPPEAL_CLICKED);
                    BusUtils.post(new ReappealEvent());
                }
            });
            this.f46975e.setVisibility(0);
            this.f46975e.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_APPEAL_RESULT_EXIT_CLICKED);
                    AppealResultAct.this.m33664a();
                }
            });
            return;
        }
        this.f46974d.setText(R.string.df_exit);
        this.f46974d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_APPEAL_RESULT_EXIT_CLICKED);
                AppealResultAct.this.m33664a();
            }
        });
    }

    @Subscribe
    public void onAppealRequestSuccessEvent(AppealRequestSuccessEvent appealRequestSuccessEvent) {
        finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33664a() {
        BusUtils.post(new AppealDoneEvent(this.f46976f));
        finish();
    }

    /* renamed from: b */
    private int m33666b() {
        return this.f46976f == 3 ? R.drawable.df_appeal_result_failed : R.drawable.df_appeal_result_underway;
    }

    /* renamed from: c */
    private int m33667c() {
        return this.f46976f == 3 ? R.string.df_appeal_result_title_fail : R.string.df_appeal_result_title_underway;
    }

    /* access modifiers changed from: protected */
    public void onLeftTitleBtnClicked() {
        m33664a();
    }

    public void onBackPressed() {
        m33664a();
    }
}
