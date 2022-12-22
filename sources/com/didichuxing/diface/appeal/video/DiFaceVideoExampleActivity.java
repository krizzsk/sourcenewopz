package com.didichuxing.diface.appeal.video;

import android.graphics.Color;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.diface.DiFaceResult;
import com.didichuxing.diface.core.DiFaceFacade;
import com.didichuxing.diface.core.DiFaceVideoManager;
import com.didichuxing.diface.core.MVP.DiFaceBaseActivity;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.taxis99.R;

public class DiFaceVideoExampleActivity extends DiFaceBaseActivity {

    /* renamed from: a */
    private RelativeLayout f47119a;

    /* renamed from: b */
    private ImageView f47120b;

    /* renamed from: c */
    private TextView f47121c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ProgressBar f47122d;

    /* renamed from: e */
    private SurfaceView f47123e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public SurfaceHolder f47124f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ImageView f47125g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ImageView f47126h;

    /* renamed from: i */
    private DiFaceVideoManager f47127i;

    /* renamed from: j */
    private String f47128j;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_diface_video_example_layout);
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_ENTER_VIDEO_DEMO_CHECK);
        this.f47119a = (RelativeLayout) findViewById(R.id.tb);
        this.f47120b = (ImageView) findViewById(R.id.iv_left);
        this.f47121c = (TextView) findViewById(R.id.tv_title);
        this.f47122d = (ProgressBar) findViewById(R.id.pb);
        this.f47123e = (SurfaceView) findViewById(R.id.sv);
        this.f47125g = (ImageView) findViewById(R.id.iv_replay);
        this.f47126h = (ImageView) findViewById(R.id.iv_to_take_video);
        m33782a();
        m33785b();
    }

    /* renamed from: a */
    private void m33782a() {
        this.f47119a.setBackgroundColor(Color.parseColor("#55000000"));
        this.f47120b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DiFaceVideoExampleActivity.this.finishWithResult(new DiFaceResult(102));
            }
        });
        this.f47121c.setText(getString(R.string.video_example_title));
        this.f47123e.getHolder().addCallback(new SurfaceHolder.Callback() {
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            }

            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                SurfaceHolder unused = DiFaceVideoExampleActivity.this.f47124f = surfaceHolder;
                DiFaceVideoExampleActivity.this.m33787c();
            }
        });
        this.f47125g.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DiFaceVideoExampleActivity.this.m33787c();
            }
        });
        this.f47126h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DiFaceVideoExampleActivity.this.finishWithResult(new DiFaceResult(1003));
            }
        });
    }

    /* renamed from: b */
    private void m33785b() {
        this.f47127i = new DiFaceVideoManager();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m33787c() {
        showProgress();
        this.f47125g.setVisibility(8);
        this.f47126h.setVisibility(8);
        this.f47127i.startPlay(this.f47128j, this.f47124f, false, new DiFaceVideoManager.IVideoProgressListener() {
            public void onStart(int i) {
                LogUtils.m33563d("on Max: " + i);
                DiFaceVideoExampleActivity.this.f47122d.setMax(i);
                DiFaceVideoExampleActivity.this.hideProgress();
            }

            public void onProgress(int i) {
                LogUtils.m33563d("on Progress: " + i);
                DiFaceVideoExampleActivity.this.f47122d.setProgress(i);
            }

            public void onCompletion() {
                LogUtils.m33563d("on Completion");
                DiFaceVideoExampleActivity.this.f47122d.setProgress(0);
                DiFaceVideoExampleActivity.this.f47125g.setVisibility(0);
                DiFaceVideoExampleActivity.this.f47126h.setVisibility(0);
            }

            public void onStop() {
                DiFaceVideoExampleActivity.this.setProgress(0);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f47127i.stopPlay();
    }
}
