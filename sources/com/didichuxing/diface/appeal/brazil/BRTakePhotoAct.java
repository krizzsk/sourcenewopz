package com.didichuxing.diface.appeal.brazil;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didichuxing.dfbasesdk.camera.DiFaceCameraManager;
import com.didichuxing.dfbasesdk.utils.BitmapUtils;
import com.didichuxing.dfbasesdk.utils.BusUtils;
import com.didichuxing.dfbasesdk.utils.CameraUtils;
import com.didichuxing.dfbasesdk.utils.CheckUtils;
import com.didichuxing.dfbasesdk.utils.IOUtils;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.diface.DiFaceResult;
import com.didichuxing.diface.act.DFBaseAct;
import com.didichuxing.diface.appeal.OrientationListenerImpl;
import com.didichuxing.diface.appeal.TakePhotoDoneEvent;
import com.didichuxing.diface.appeal.TakePhotoInfo;
import com.didichuxing.diface.appeal.toolkit.ResizeTakePhoto;
import com.didichuxing.diface.core.DiFaceFacade;
import com.didichuxing.diface.utils.DisplayUtils;
import com.taxis99.R;
import java.io.File;
import java.io.FileOutputStream;

public class BRTakePhotoAct extends DFBaseAct {

    /* renamed from: a */
    private TextureView f47017a;

    /* renamed from: b */
    private TextView f47018b;

    /* renamed from: c */
    private ImageView f47019c;

    /* renamed from: d */
    private RelativeLayout f47020d;

    /* renamed from: e */
    private RelativeLayout f47021e;

    /* renamed from: f */
    private ImageView f47022f;

    /* renamed from: g */
    private ImageView f47023g;

    /* renamed from: h */
    private TextView f47024h;

    /* renamed from: i */
    private TextView f47025i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public DiFaceCameraManager f47026j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public SurfaceTexture f47027k;

    /* renamed from: l */
    private int f47028l;

    /* renamed from: m */
    private String[] f47029m;

    /* renamed from: n */
    private int[] f47030n;

    /* renamed from: o */
    private OrientationListenerImpl f47031o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public byte[] f47032p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public ResizeTakePhoto f47033q;

    /* renamed from: r */
    private int f47034r;

    /* renamed from: s */
    private String f47035s;

    /* access modifiers changed from: protected */
    public boolean fullScreen() {
        return true;
    }

    /* access modifiers changed from: protected */
    public int getActTitleId() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int getContentLayout() {
        return R.layout.br_act_df_take_photo_layout2;
    }

    /* access modifiers changed from: protected */
    public void makeFaceResult(DiFaceResult diFaceResult) {
    }

    public static void start(Activity activity, int i) {
        Intent intent = new Intent(activity, BRTakePhotoAct.class);
        intent.putExtra(TakePhotoInfo.EXTRA_KEY_PHOTO_TYPE, i);
        activity.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void initDataFromIntent(Intent intent) {
        this.f47028l = intent.getIntExtra(TakePhotoInfo.EXTRA_KEY_PHOTO_TYPE, 0);
        this.f47029m = getResources().getStringArray(R.array.df_take_photo_act_confirm_notes);
        this.f47030n = new int[]{R.drawable.br_df_appeal_driver_license_g1_preview, R.drawable.df_appeal_driver_license_g2_qr_preview, R.drawable.df_appeal_rg_front_preview, R.drawable.df_appeal_cdr_preview, R.drawable.br_df_appeal_cdt_preview, R.drawable.br_df_appeal_passport_preview, R.drawable.br_df_appeal_self_photo_preview};
        int screenWidth = DisplayUtils.getScreenWidth(this);
        int screenHeight = DisplayUtils.getScreenHeight(this);
        LogUtils.m33563d("screenW===" + screenWidth + ", screenH=" + screenHeight);
        int i = (int) (((float) screenHeight) * 0.75f);
        LogUtils.m33563d("wanted prevW===" + screenWidth + ", prevH=" + i);
        this.f47026j = new DiFaceCameraManager(DisplayUtils.getWindowRotation(getWindow()), DisplayUtils.isPortrait(this), screenWidth, screenHeight, screenWidth, i);
        this.f47031o = new OrientationListenerImpl(this, this.f47026j);
    }

    /* access modifiers changed from: protected */
    public void setupSubViews() {
        boolean isValidType = TakePhotoInfo.isValidType(this.f47028l);
        CheckUtils.checkAssert(isValidType, "invalid photoType, mPhotoType=" + this.f47028l);
        if (!isValidType) {
            finish();
            return;
        }
        this.f47033q = new ResizeTakePhoto(this, findViewById(R.id.fl_take_photo_container), findViewById(R.id.fl_bottom_container), findViewById(R.id.take_photo_preview_img));
        hideTitleArea();
        TextureView textureView = (TextureView) findViewById(R.id.live_camera_preview);
        this.f47017a = textureView;
        textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                return true;
            }

            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (!(BRTakePhotoAct.this.f47026j.getCamera() == null || BRTakePhotoAct.this.f47026j.getCamera().getParameters() == null || BRTakePhotoAct.this.f47026j.getCamera().getParameters().getPreviewSize() == null)) {
                    Camera.Size previewSize = BRTakePhotoAct.this.f47026j.getCamera().getParameters().getPreviewSize();
                    BRTakePhotoAct.this.f47033q.resize(previewSize.width, previewSize.height);
                }
                SurfaceTexture unused = BRTakePhotoAct.this.f47027k = surfaceTexture;
                BRTakePhotoAct.this.f47026j.startPreview(surfaceTexture);
            }
        });
        this.f47017a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                BRTakePhotoAct.this.f47026j.autoFocus();
            }
        });
        ImageView imageView = (ImageView) findViewById(R.id.take_photo_preview_img);
        this.f47019c = imageView;
        imageView.setImageResource(this.f47030n[this.f47028l - 1]);
        this.f47018b = (TextView) findViewById(R.id.take_photo_note);
        if (TakePhotoInfo.isSpecialRGType(this.f47028l)) {
            this.f47018b.setText(R.string.df_take_photo_act_preview_note_rg);
        } else if (this.f47028l == 7) {
            this.f47018b.setText(R.string.df_take_photo_act_preview_note_self_photo);
        }
        this.f47020d = (RelativeLayout) findViewById(R.id.take_photo_preview_container);
        ImageView imageView2 = (ImageView) findViewById(R.id.back_icon);
        this.f47022f = imageView2;
        imageView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                BRTakePhotoAct.this.finish();
            }
        });
        ImageView imageView3 = (ImageView) findViewById(R.id.take_photo_icon);
        this.f47023g = imageView3;
        imageView3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                BRTakePhotoAct.this.f47026j.takePhoto(new Camera.PictureCallback() {
                    public void onPictureTaken(byte[] bArr, Camera camera) {
                        LogUtils.m33563d("original jpeg data.length===" + (bArr.length / 1024) + "KB");
                        byte[] unused = BRTakePhotoAct.this.f47032p = bArr;
                        camera.stopPreview();
                        BRTakePhotoAct.this.m33701a(true);
                    }
                });
            }
        });
        this.f47021e = (RelativeLayout) findViewById(R.id.take_photo_confirm_container);
        TextView textView = (TextView) findViewById(R.id.photo_retake_icon);
        this.f47024h = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                byte[] unused = BRTakePhotoAct.this.f47032p = null;
                BRTakePhotoAct.this.f47026j.startPreview(BRTakePhotoAct.this.f47027k);
                BRTakePhotoAct.this.m33701a(false);
            }
        });
        TextView textView2 = (TextView) findViewById(R.id.photo_confirm_icon);
        this.f47025i = textView2;
        textView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                BRTakePhotoAct.this.m33698a();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33698a() {
        String fileName = TakePhotoInfo.getFileName(this.f47028l, this.f47034r);
        m33700a(fileName);
        BusUtils.post(new TakePhotoDoneEvent(fileName));
        if (this.f47034r != 0 || !TakePhotoInfo.isSpecialRGType(this.f47028l)) {
            finish();
            return;
        }
        m33704b();
        this.f47034r++;
    }

    /* renamed from: b */
    private void m33704b() {
        this.f47032p = null;
        this.f47026j.startPreview(this.f47027k);
        m33701a(false);
        this.f47019c.setImageResource(R.drawable.df_appeal_rg_back_preview);
        this.f47018b.setText(R.string.df_take_photo_act_preview_note_rg_back);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33701a(boolean z) {
        if (z) {
            this.f47021e.setVisibility(0);
            this.f47020d.setVisibility(4);
            this.f47019c.setVisibility(4);
            this.f47035s = this.f47018b.getText().toString();
            this.f47018b.setText(this.f47029m[this.f47028l - 1]);
            this.f47031o.disable();
            return;
        }
        this.f47021e.setVisibility(4);
        this.f47020d.setVisibility(0);
        this.f47019c.setVisibility(0);
        this.f47018b.setText(this.f47035s);
        this.f47031o.enable();
    }

    /* renamed from: a */
    private void m33700a(String str) {
        FileOutputStream fileOutputStream;
        Exception e;
        File file = new File(getCacheDir(), str);
        LogUtils.m33563d("save jpeg file====" + file);
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(this.f47032p, 0, this.f47032p.length);
                int width = decodeByteArray.getWidth();
                int height = decodeByteArray.getHeight();
                LogUtils.m33563d("origin bitmap w=" + width + ", h=" + height);
                if (width * height > 307200) {
                    int i = 640;
                    int i2 = 480;
                    if (width < height) {
                        i = 480;
                        i2 = 640;
                    }
                    Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeByteArray, i, i2, false);
                    LogUtils.m33563d("create scaled bitmap...");
                    if (!(createScaledBitmap == null || createScaledBitmap == decodeByteArray)) {
                        decodeByteArray.recycle();
                        decodeByteArray = createScaledBitmap;
                    }
                }
                Bitmap rotateBitmap = BitmapUtils.rotateBitmap(decodeByteArray, this.f47031o.getRotation());
                LogUtils.m33563d("rotated bitmap w=" + rotateBitmap.getWidth() + ", h=" + rotateBitmap.getHeight());
                rotateBitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
                LogUtils.m33563d("after 90% compress, file length====" + (file.length() / 1024) + "KB");
                rotateBitmap.recycle();
            } catch (Exception e2) {
                e = e2;
                try {
                    LogUtils.logStackTrace(e);
                    IOUtils.closeQuietly(fileOutputStream);
                } catch (Throwable th) {
                    th = th;
                    IOUtils.closeQuietly(fileOutputStream);
                    throw th;
                }
            }
        } catch (Exception e3) {
            fileOutputStream = null;
            e = e3;
            LogUtils.logStackTrace(e);
            IOUtils.closeQuietly(fileOutputStream);
        } catch (Throwable th2) {
            fileOutputStream = null;
            th = th2;
            IOUtils.closeQuietly(fileOutputStream);
            throw th;
        }
        IOUtils.closeQuietly(fileOutputStream);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f47031o.enable();
        this.f47026j.openCamera(m33705c(), true);
        SurfaceTexture surfaceTexture = this.f47027k;
        if (surfaceTexture != null) {
            this.f47026j.startPreview(surfaceTexture);
        }
    }

    /* renamed from: c */
    private int m33705c() {
        if (Camera.getNumberOfCameras() != 1 && this.f47028l == 7 && !DiFaceFacade.getInstance().getConfig().getForceUseBackCamera() && CameraUtils.hasFacingFrontCamera()) {
            return 1;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f47031o.disable();
        this.f47026j.closeCamera();
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        StringBuilder sb = new StringBuilder();
        sb.append("onRestart need save photo = ");
        sb.append(this.f47032p != null);
        LogUtils.m33563d(sb.toString());
        if (this.f47032p != null) {
            m33698a();
        }
    }
}
