package com.didichuxing.diface.appeal.video;

import android.graphics.Color;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.didichuxing.diface.DiFaceResult;
import com.didichuxing.diface.core.DiFaceVideoManager;
import com.didichuxing.diface.core.MVP.DiFaceBaseActivity;
import com.taxis99.R;
import java.io.File;

public class DiFaceVideoDisposeActivity extends DiFaceBaseActivity {

    /* renamed from: a */
    private RelativeLayout f47112a;

    /* renamed from: b */
    private ImageView f47113b;

    /* renamed from: c */
    private ImageView f47114c;

    /* renamed from: d */
    private SurfaceView f47115d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public DiFaceVideoManager f47116e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public SurfaceHolder f47117f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public String f47118g;

    /* access modifiers changed from: protected */
    public boolean fullScreen() {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_diface_video_dispose_layout);
        this.f47112a = (RelativeLayout) findViewById(R.id.tb);
        this.f47113b = (ImageView) findViewById(R.id.iv_left);
        this.f47114c = (ImageView) findViewById(R.id.iv_right);
        this.f47115d = (SurfaceView) findViewById(R.id.sv);
        m33775a();
        m33777b();
    }

    /* renamed from: a */
    private void m33775a() {
        this.f47118g = getIntent().getStringExtra("videoPath");
        this.f47115d.getHolder().addCallback(new SurfaceHolder.Callback() {
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            }

            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            }

            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                SurfaceHolder unused = DiFaceVideoDisposeActivity.this.f47117f = surfaceHolder;
                DiFaceVideoDisposeActivity.this.f47116e.startPlay(DiFaceVideoDisposeActivity.this.f47118g, surfaceHolder);
            }
        });
        this.f47112a.setBackgroundColor(Color.parseColor("#55000000"));
        this.f47114c.setImageResource(R.drawable.ic_trash_can);
        this.f47113b.setImageResource(R.drawable.ic_back_arrow_white);
        this.f47113b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DiFaceVideoDisposeActivity.this.finishWithResult(new DiFaceResult(102));
            }
        });
        this.f47114c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DiFaceVideoDisposeActivity.this.m33778c();
            }
        });
    }

    /* renamed from: b */
    private void m33777b() {
        this.f47116e = new DiFaceVideoManager();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f47116e.stopPlay();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m33778c() {
        this.f47116e.stopPlay();
        new AlertDialogFragment.Builder(this).setTitle(getString(R.string.df_appeal_delete_video_dialog_title)).setCancelable(false).setPositiveButton((int) R.string.df_delete_text, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                alertDialogFragment.dismiss();
                new File(DiFaceVideoDisposeActivity.this.f47118g).delete();
                DiFaceVideoDisposeActivity.this.finishWithResult(new DiFaceResult(1005));
            }
        }).setPositiveButtonDefault().setNegativeButton((int) R.string.df_dialog_negative_btn_text, (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                alertDialogFragment.dismiss();
                DiFaceVideoDisposeActivity.this.f47116e.startPlay(DiFaceVideoDisposeActivity.this.f47118g, DiFaceVideoDisposeActivity.this.f47117f);
            }
        }).create().show(getSupportFragmentManager(), "");
    }
}
