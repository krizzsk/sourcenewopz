package com.didi.dimina.container.secondparty.jsmodule.jsbridge.photo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.commoninterfacelib.permission.TheOneBaseActivity;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bridge.permission.DiminaPermissionDescDialog;
import com.didi.dimina.container.bridge.permission.SinglePermissionCallBack;
import com.didi.dimina.container.mina.DMMinaPool;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.PermissionUtil;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ToastUtil;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import com.google.android.cameraview.AspectRatio;
import com.google.android.cameraview.CameraView;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;

public class TakePhotoActivity extends TheOneBaseActivity {
    public static final String KEY_DMMINA_INDEX = "key_dmmina_index";
    public static final String KEY_FILEPATH = "key_filepath";
    public static final String KEY_PHOTOTYPE = "key_phototype";

    /* renamed from: a */
    private static final String f17247a = "TakePhotoActivity";

    /* renamed from: b */
    private static final int f17248b = 2000;

    /* renamed from: c */
    private static final int f17249c = 10;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f17250d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public CameraView f17251e;

    /* renamed from: f */
    private DMMina f17252f;

    /* renamed from: g */
    private Handler f17253g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f17254h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public ImageView f17255i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public View f17256j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public View f17257k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public boolean f17258l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public long f17259m;

    /* renamed from: n */
    private int f17260n;

    /* renamed from: o */
    private final Runnable f17261o = new Runnable() {
        public void run() {
            TakePhotoActivity.this.m12802b();
        }
    };

    /* renamed from: p */
    private final CameraView.Callback f17262p = new CameraView.Callback() {
        public void onCameraOpened(CameraView cameraView) {
            LogUtil.m13411i("onCameraOpened");
        }

        public void onCameraClosed(CameraView cameraView) {
            LogUtil.m13411i("onCameraClosed");
        }

        public void onPictureTaken(CameraView cameraView, byte[] bArr) {
            boolean unused = TakePhotoActivity.this.f17258l = false;
            if (!TakePhotoActivity.this.f17254h) {
                boolean unused2 = TakePhotoActivity.this.f17254h = true;
                TakePhotoActivity.this.f17256j.setVisibility(8);
                TakePhotoActivity.this.f17257k.setVisibility(0);
                LogUtil.m13411i("onPictureTaken " + bArr.length);
                final Bitmap cropBitmap = Utils.cropBitmap(BitmapFactory.decodeByteArray(bArr, 0, bArr.length), TakePhotoActivity.this.f17251e.getWidth(), TakePhotoActivity.this.f17251e.getHeight());
                TakePhotoActivity.this.f17255i.setImageBitmap(cropBitmap);
                TakePhotoActivity.this.m12805c().post(new Runnable() {
                    public void run() {
                        Utils.m12821a(cropBitmap, TakePhotoActivity.this.f17250d);
                    }
                });
            }
        }
    };

    public enum PhotoType {
        TYPE_PEOPLE_HOLD_CARD,
        TYPE_CARD
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        m12800a();
        this.f17250d = getIntent().getStringExtra(KEY_FILEPATH);
        this.f17252f = DMMinaPool.get(getIntent().getIntExtra(KEY_DMMINA_INDEX, -1));
    }

    /* renamed from: a */
    private void m12800a() {
        setContentView((int) R.layout.dimina_card_activity_take_photo);
        findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                TakePhotoActivity.this.finish();
            }
        });
        findViewById(R.id.takePhoto).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (SystemClock.elapsedRealtime() - TakePhotoActivity.this.f17259m > 2000 && !TakePhotoActivity.this.f17258l && TakePhotoActivity.this.f17251e != null && TakePhotoActivity.this.f17251e.isCameraOpened()) {
                    TakePhotoActivity.this.f17251e.takePicture();
                    long unused = TakePhotoActivity.this.f17259m = SystemClock.elapsedRealtime();
                    boolean unused2 = TakePhotoActivity.this.f17258l = true;
                }
            }
        });
        findViewById(R.id.retake).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                TakePhotoActivity.this.m12802b();
            }
        });
        findViewById(R.id.accept).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                TakePhotoActivity.this.setResult(-1);
                TakePhotoActivity.this.finish();
            }
        });
        PreviewCover previewCover = (PreviewCover) findViewById(R.id.takePhoto_bg);
        TextView textView = (TextView) findViewById(R.id.tips);
        int intExtra = getIntent().getIntExtra(KEY_PHOTOTYPE, PhotoType.TYPE_CARD.ordinal());
        if (intExtra == PhotoType.TYPE_CARD.ordinal()) {
            previewCover.setContent(R.color.dimina_color_CD000000, R.drawable.dimina_auth_camera_normal);
            textView.setText(R.string.dimina_takephoto_normal_tip);
        } else if (intExtra == PhotoType.TYPE_PEOPLE_HOLD_CARD.ordinal()) {
            previewCover.setContent(R.color.dimina_color_CD000000, R.drawable.dimina_auth_camera_hold);
            textView.setText(R.string.dimina_takephoto_normal_tip);
        }
        this.f17256j = findViewById(R.id.take_layout);
        this.f17257k = findViewById(R.id.retake_layout);
        this.f17251e = (CameraView) findViewById(R.id.camera);
        this.f17255i = (ImageView) findViewById(R.id.photo);
        CameraView cameraView = this.f17251e;
        if (cameraView != null) {
            cameraView.addCallback(this.f17262p);
            this.f17251e.setAspectRatio(AspectRatio.m37333of(1, 1));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m12802b() {
        if (!this.f17251e.start()) {
            int i = this.f17260n + 1;
            this.f17260n = i;
            if (i > 10) {
                SystemUtils.showToast(Toast.makeText(this, getString(R.string.dimina_opencamera_fail), 0));
                finish();
                return;
            }
            Utils.m12823a(this.f17261o, 200);
            return;
        }
        this.f17260n = 0;
        this.f17254h = false;
        this.f17256j.setVisibility(0);
        this.f17257k.setVisibility(8);
        this.f17255i.setImageBitmap((Bitmap) null);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        PermissionUtil.INSTANCE.checkAndRequestPermissionsWithDescDialog(this, Permission.CAMERA, DiminaPermissionDescDialog.createCameraDescInfo(this.f17252f), new SinglePermissionCallBack() {
            public void onDenied(String str) {
                TakePhotoActivity takePhotoActivity = TakePhotoActivity.this;
                ToastUtil.show((Context) takePhotoActivity, (CharSequence) takePhotoActivity.getString(R.string.dimina_permission_camera_grant_failed));
            }

            public void onGranted(String str) {
                if (!TakePhotoActivity.this.f17251e.start()) {
                    TakePhotoActivity takePhotoActivity = TakePhotoActivity.this;
                    SystemUtils.showToast(Toast.makeText(takePhotoActivity, takePhotoActivity.getString(R.string.dimina_opencamera_fail), 0));
                    TakePhotoActivity.this.finish();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        this.f17251e.stop();
        Utils.m12822a(this.f17261o);
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (this.f17253g != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                this.f17253g.getLooper().quitSafely();
            } else {
                this.f17253g.getLooper().quit();
            }
            this.f17253g = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public Handler m12805c() {
        if (this.f17253g == null) {
            HandlerThread handlerThread = new HandlerThread(Constants.BACKGROUND);
            handlerThread.start();
            this.f17253g = new Handler(handlerThread.getLooper());
        }
        return this.f17253g;
    }
}
