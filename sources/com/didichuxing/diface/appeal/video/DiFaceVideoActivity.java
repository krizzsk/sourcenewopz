package com.didichuxing.diface.appeal.video;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.dfbasesdk.camera.DiFaceCameraManager;
import com.didichuxing.dfbasesdk.utils.StringUtils;
import com.didichuxing.diface.DiFace;
import com.didichuxing.diface.DiFaceResult;
import com.didichuxing.diface.core.DiFaceFacade;
import com.didichuxing.diface.core.DiFaceVideoManager;
import com.didichuxing.diface.core.MVP.DiFaceBaseActivity;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.didichuxing.diface.utils.DisplayUtils;
import com.didichuxing.diface.utils.ToastUtil;
import com.taxis99.R;
import java.util.Arrays;
import java.util.HashMap;

public class DiFaceVideoActivity extends DiFaceBaseActivity {

    /* renamed from: m */
    private static final int f47090m = 15;

    /* renamed from: n */
    private static final int f47091n = 640;

    /* renamed from: o */
    private static final int f47092o = 480;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public RelativeLayout f47093a;

    /* renamed from: b */
    private ImageView f47094b;

    /* renamed from: c */
    private ImageView f47095c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public RelativeLayout f47096d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public TextView f47097e;

    /* renamed from: f */
    private SurfaceView f47098f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public SurfaceHolder f47099g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ImageView f47100h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public TextView f47101i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ImageView f47102j;

    /* renamed from: k */
    private DiFaceVideoManager f47103k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public DiFaceCameraManager f47104l;

    /* renamed from: p */
    private String f47105p;

    /* access modifiers changed from: protected */
    public boolean fullScreen() {
        return true;
    }

    public void onBackPressed() {
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_VIDEO_TAKE_EXIT, DiFaceLogger.getExitType("1"), (HashMap<String, Object>) null);
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_diface_video_layout);
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_ENTER_VIDEO_TAKE);
        this.f47093a = (RelativeLayout) findViewById(R.id.tb);
        this.f47094b = (ImageView) findViewById(R.id.iv_left);
        this.f47095c = (ImageView) findViewById(R.id.iv_right);
        this.f47096d = (RelativeLayout) findViewById(R.id.rl_timer_container);
        this.f47097e = (TextView) findViewById(R.id.tv_timer);
        this.f47098f = (SurfaceView) findViewById(R.id.sv);
        this.f47100h = (ImageView) findViewById(R.id.iv_exclamation);
        this.f47101i = (TextView) findViewById(R.id.tv_take_hint);
        this.f47102j = (ImageView) findViewById(R.id.iv_take_video);
        m33754a();
        m33756b();
        m33757c();
    }

    /* renamed from: a */
    private void m33754a() {
        this.f47093a.setBackgroundColor(Color.parseColor("#55000000"));
        this.f47095c.setImageResource(R.drawable.ic_switch_camera);
        this.f47094b.setImageResource(R.drawable.ic_back_arrow_white);
        this.f47094b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_VIDEO_TAKE_EXIT, DiFaceLogger.getExitType("2"), (HashMap<String, Object>) null);
                DiFaceVideoActivity.this.finishWithResult(new DiFaceResult(102));
            }
        });
        this.f47095c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DiFaceVideoActivity.this.f47104l.switchCamera(DiFaceVideoActivity.this.f47099g);
            }
        });
        this.f47098f.getHolder().addCallback(new SurfaceHolder.Callback() {
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            }

            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                SurfaceHolder unused = DiFaceVideoActivity.this.f47099g = surfaceHolder;
                DiFaceVideoActivity.this.f47104l.startPreview(surfaceHolder);
            }
        });
        this.f47098f.getHolder().setType(3);
        this.f47102j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DiFaceVideoActivity.this.m33760d();
            }
        });
    }

    /* renamed from: b */
    private void m33756b() {
        this.f47104l = new DiFaceCameraManager(DisplayUtils.getWindowRotation(getWindow()), DisplayUtils.isPortrait(this), DisplayUtils.getScreenWidth(this), DisplayUtils.getScreenHeight(this));
    }

    /* renamed from: c */
    private void m33757c() {
        DiFaceVideoManager diFaceVideoManager = new DiFaceVideoManager();
        this.f47103k = diFaceVideoManager;
        diFaceVideoManager.initRecordParam(640, 480);
        this.f47105p = getIntent().getStringExtra("videoPath");
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m33760d() {
        if (this.f47103k.isStartRecord()) {
            DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_STOP_VIDEO_TAKE);
            this.f47103k.stopRecord();
            m33761e();
            return;
        }
        DiFaceFacade.getInstance().report(DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_START_VIDEO_TAKE);
        this.f47103k.record(this.f47104l.getCamera(), this.f47104l.getMediaPlayerRotation(), this.f47099g.getSurface(), this.f47105p, 15, new DiFaceVideoManager.ITimerCallback() {
            public void onTick(int i) {
                if (i != 0) {
                    DiFaceVideoActivity.this.f47097e.setText(DiFaceVideoActivity.this.getString(R.string.df_appeal_video_record_remaining_time, new Object[]{Integer.valueOf(i)}));
                    return;
                }
                DiFaceVideoActivity.this.m33761e();
            }
        });
        m33764f();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m33761e() {
        this.f47102j.postDelayed(new Runnable() {
            public void run() {
                DiFaceVideoActivity.this.f47102j.setBackgroundResource(R.drawable.ic_take_video_start);
                DiFaceVideoActivity.this.f47096d.setVisibility(8);
                DiFaceVideoActivity.this.f47093a.setVisibility(0);
                DiFaceVideoActivity.this.f47101i.setText(DiFaceVideoActivity.this.getString(R.string.take_view_hint));
                DiFaceVideoActivity.this.f47100h.setVisibility(8);
            }
        }, 500);
        Intent intent = new Intent(this, DiFaceVideoConfirmActivity.class);
        intent.putExtra("videoPath", this.f47105p);
        startActivityForResult(intent, 1);
    }

    /* renamed from: f */
    private void m33764f() {
        this.f47102j.setBackgroundResource(R.drawable.ic_take_video_stop);
        this.f47096d.setVisibility(0);
        this.f47093a.setVisibility(8);
        this.f47097e.setText(getString(R.string.df_appeal_video_record_remaining_time, new Object[]{15}));
        this.f47101i.setText(StringUtils.makeSpannableString(getString(R.string.appeal_take_video_hint), Arrays.asList(getResources().getStringArray(R.array.df_appeal_id_card_highlights)), "#FC9153"));
        this.f47100h.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f47104l.openCamera();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f47104l.closeCamera();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i != 1 || i2 != -1) {
            return;
        }
        if (((DiFaceResult) intent.getSerializableExtra(DiFace.DIFACE_RESULT_KEY)).getCode() == 102) {
            ToastUtil.showToastInfo((Context) this, (int) R.string.df_appeal_re_photo_video);
            return;
        }
        new HashMap();
        finishWithResult(new DiFaceResult(1004));
    }
}
