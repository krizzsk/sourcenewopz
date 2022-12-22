package com.didichuxing.diface.appeal.video;

import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.dfbasesdk.utils.StringUtils;
import com.didichuxing.diface.DiFaceResult;
import com.didichuxing.diface.core.DiFaceFacade;
import com.didichuxing.diface.core.DiFaceVideoManager;
import com.didichuxing.diface.core.MVP.DiFaceBaseActivity;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.taxis99.R;
import java.io.File;
import java.util.Arrays;

public class DiFaceVideoConfirmActivity extends DiFaceBaseActivity {

    /* renamed from: a */
    private SurfaceView f47106a;

    /* renamed from: b */
    private TextView f47107b;

    /* renamed from: c */
    private ImageView f47108c;

    /* renamed from: d */
    private ImageView f47109d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public DiFaceVideoManager f47110e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f47111f;

    /* access modifiers changed from: protected */
    public boolean fullScreen() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_diface_video_confirm_layout);
        this.f47111f = getIntent().getStringExtra("videoPath");
        this.f47106a = (SurfaceView) findViewById(R.id.sv);
        this.f47107b = (TextView) findViewById(R.id.tv_confirm_hint);
        this.f47108c = (ImageView) findViewById(R.id.iv_back);
        this.f47109d = (ImageView) findViewById(R.id.iv_confirm);
        m33770a();
        m33772b();
    }

    /* renamed from: a */
    private void m33770a() {
        this.f47106a.getHolder().addCallback(new SurfaceHolder.Callback() {
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            }

            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                DiFaceVideoConfirmActivity.this.f47110e.startPlay(DiFaceVideoConfirmActivity.this.f47111f, surfaceHolder);
            }
        });
        this.f47108c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_CONFIRM_VIDEO_NO);
                DiFaceVideoConfirmActivity.this.f47110e.stopPlay();
                new File(DiFaceVideoConfirmActivity.this.f47111f).delete();
                DiFaceVideoConfirmActivity.this.finishWithResult(new DiFaceResult(102));
            }
        });
        this.f47109d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_CONFIRM_VIDEO_YES);
                DiFaceVideoConfirmActivity.this.finishWithResult(new DiFaceResult(1004));
            }
        });
        this.f47107b.setText(StringUtils.makeSpannableString(getString(R.string.appeal_video_confirm_hint), Arrays.asList(getResources().getStringArray(R.array.df_appeal_id_card_highlights)), "#FC9153"));
    }

    /* renamed from: b */
    private void m33772b() {
        this.f47110e = new DiFaceVideoManager();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f47110e.stopPlay();
    }

    public void onBackPressed() {
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_CONFIRM_VIDEO_NO);
        this.f47110e.stopPlay();
        new File(this.f47111f).delete();
        super.onBackPressed();
    }
}
