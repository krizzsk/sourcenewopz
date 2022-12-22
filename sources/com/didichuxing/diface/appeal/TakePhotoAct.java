package com.didichuxing.diface.appeal;

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
import com.didichuxing.dfbasesdk.utils.IOUtils;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.diface.DiFaceResult;
import com.didichuxing.diface.act.DFStyleBaseAct;
import com.didichuxing.diface.appeal.mexico.model.DocumentCardsBean;
import com.didichuxing.diface.appeal.toolkit.ResizeTakePhoto;
import com.didichuxing.diface.core.DiFaceFacade;
import com.didichuxing.diface.utils.DisplayUtils;
import com.didichuxing.saimageloader.DiSafetyImageLoader;
import com.taxis99.R;
import java.io.File;
import java.io.FileOutputStream;

public class TakePhotoAct extends DFStyleBaseAct {

    /* renamed from: a */
    private TextureView f46980a;

    /* renamed from: b */
    private TextView f46981b;

    /* renamed from: c */
    private ImageView f46982c;

    /* renamed from: d */
    private RelativeLayout f46983d;

    /* renamed from: e */
    private RelativeLayout f46984e;

    /* renamed from: f */
    private ImageView f46985f;

    /* renamed from: g */
    private ImageView f46986g;

    /* renamed from: h */
    private TextView f46987h;

    /* renamed from: i */
    private TextView f46988i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public DiFaceCameraManager f46989j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public SurfaceTexture f46990k;

    /* renamed from: l */
    private DocumentCardsBean f46991l;

    /* renamed from: m */
    private OrientationListenerImpl f46992m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public byte[] f46993n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public ResizeTakePhoto f46994o;

    /* renamed from: p */
    private String f46995p;

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
        return R.layout.act_df_take_photo_layout2;
    }

    /* access modifiers changed from: protected */
    public void makeFaceResult(DiFaceResult diFaceResult) {
    }

    public static void start(Activity activity, DocumentCardsBean documentCardsBean) {
        Intent intent = new Intent(activity, TakePhotoAct.class);
        intent.putExtra(TakePhotoInfo.EXTRA_KEY_PHOTO_TYPE, documentCardsBean);
        activity.startActivity(intent);
    }

    /* access modifiers changed from: protected */
    public void initDataFromIntent(Intent intent) {
        this.f46991l = (DocumentCardsBean) intent.getSerializableExtra(TakePhotoInfo.EXTRA_KEY_PHOTO_TYPE);
        int screenWidth = DisplayUtils.getScreenWidth(this);
        int screenHeight = DisplayUtils.getScreenHeight(this);
        LogUtils.m33563d("screenW===" + screenWidth + ", screenH=" + screenHeight);
        int i = (int) (((float) screenHeight) * 0.75f);
        LogUtils.m33563d("wanted prevW===" + screenWidth + ", prevH=" + i);
        this.f46989j = new DiFaceCameraManager(DisplayUtils.getWindowRotation(getWindow()), DisplayUtils.isPortrait(this), screenWidth, screenHeight, screenWidth, i);
        this.f46992m = new OrientationListenerImpl(this, this.f46989j);
    }

    /* access modifiers changed from: protected */
    public void setupSubViews() {
        if (this.f46991l == null) {
            finish();
            return;
        }
        this.f46994o = new ResizeTakePhoto(this, findViewById(R.id.fl_take_photo_container), findViewById(R.id.fl_bottom_container), findViewById(R.id.take_photo_preview_img));
        hideTitleArea();
        TextureView textureView = (TextureView) findViewById(R.id.live_camera_preview);
        this.f46980a = textureView;
        textureView.setSurfaceTextureListener(new TextureView.SurfaceTextureListener() {
            public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
                return true;
            }

            public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            }

            public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            }

            public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
                if (!(TakePhotoAct.this.f46989j.getCamera() == null || TakePhotoAct.this.f46989j.getCamera().getParameters() == null || TakePhotoAct.this.f46989j.getCamera().getParameters().getPreviewSize() == null)) {
                    Camera.Size previewSize = TakePhotoAct.this.f46989j.getCamera().getParameters().getPreviewSize();
                    TakePhotoAct.this.f46994o.resize(previewSize.width, previewSize.height);
                }
                SurfaceTexture unused = TakePhotoAct.this.f46990k = surfaceTexture;
                TakePhotoAct.this.f46989j.startPreview(surfaceTexture);
            }
        });
        this.f46980a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                TakePhotoAct.this.f46989j.autoFocus();
            }
        });
        this.f46982c = (ImageView) findViewById(R.id.take_photo_preview_img);
        DiSafetyImageLoader.with(this).load(this.f46991l.getWireframePicDemo()).into(this.f46982c);
        this.f46981b = (TextView) findViewById(R.id.take_photo_note);
        this.f46983d = (RelativeLayout) findViewById(R.id.take_photo_preview_container);
        ImageView imageView = (ImageView) findViewById(R.id.back_icon);
        this.f46985f = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                TakePhotoAct.this.finish();
            }
        });
        ImageView imageView2 = (ImageView) findViewById(R.id.take_photo_icon);
        this.f46986g = imageView2;
        imageView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                TakePhotoAct.this.f46989j.takePhoto(new Camera.PictureCallback() {
                    public void onPictureTaken(byte[] bArr, Camera camera) {
                        LogUtils.m33563d("original jpeg data.length===" + (bArr.length / 1024) + "KB");
                        byte[] unused = TakePhotoAct.this.f46993n = bArr;
                        camera.stopPreview();
                        TakePhotoAct.this.m33673a(true);
                    }
                });
            }
        });
        this.f46984e = (RelativeLayout) findViewById(R.id.take_photo_confirm_container);
        TextView textView = (TextView) findViewById(R.id.photo_retake_icon);
        this.f46987h = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                byte[] unused = TakePhotoAct.this.f46993n = null;
                TakePhotoAct.this.f46989j.startPreview(TakePhotoAct.this.f46990k);
                TakePhotoAct.this.m33673a(false);
            }
        });
        TextView textView2 = (TextView) findViewById(R.id.photo_confirm_icon);
        this.f46988i = textView2;
        textView2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                TakePhotoAct.this.m33670a();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33670a() {
        m33672a(this.f46991l.getArgs() + ".jpg");
        BusUtils.post(new TakePhotoDoneEvent2(this.f46991l));
        finish();
    }

    /* renamed from: b */
    private void m33676b() {
        this.f46993n = null;
        this.f46989j.startPreview(this.f46990k);
        m33673a(false);
        this.f46982c.setImageResource(R.drawable.df_appeal_rg_back_preview);
        this.f46981b.setText(R.string.df_take_photo_act_preview_note_rg_back);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33673a(boolean z) {
        if (z) {
            this.f46984e.setVisibility(0);
            this.f46983d.setVisibility(4);
            this.f46982c.setVisibility(4);
            this.f46995p = this.f46981b.getText().toString();
            this.f46981b.setText(R.string.df_take_photo_act_confirm_note);
            this.f46992m.disable();
            return;
        }
        this.f46984e.setVisibility(4);
        this.f46983d.setVisibility(0);
        this.f46982c.setVisibility(0);
        this.f46981b.setText(this.f46995p);
        this.f46992m.enable();
    }

    /* renamed from: a */
    private void m33672a(String str) {
        FileOutputStream fileOutputStream;
        Exception e;
        File file = new File(getCacheDir(), str);
        LogUtils.m33563d("save jpeg file====" + file);
        try {
            fileOutputStream = new FileOutputStream(file);
            try {
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(this.f46993n, 0, this.f46993n.length);
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
                Bitmap rotateBitmap = BitmapUtils.rotateBitmap(decodeByteArray, this.f46992m.getRotation());
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
        this.f46992m.enable();
        this.f46989j.openCamera(m33677c(), true);
        SurfaceTexture surfaceTexture = this.f46990k;
        if (surfaceTexture != null) {
            this.f46989j.startPreview(surfaceTexture);
        }
    }

    /* renamed from: c */
    private int m33677c() {
        if (Camera.getNumberOfCameras() != 1 && this.f46991l.isUseFrontCamera() && !DiFaceFacade.getInstance().getConfig().getForceUseBackCamera() && CameraUtils.hasFacingFrontCamera()) {
            return 1;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f46992m.disable();
        this.f46989j.closeCamera();
    }

    /* access modifiers changed from: protected */
    public void onRestart() {
        super.onRestart();
        StringBuilder sb = new StringBuilder();
        sb.append("onRestart need save photo = ");
        sb.append(this.f46993n != null);
        LogUtils.m33563d(sb.toString());
        if (this.f46993n != null) {
            m33670a();
        }
    }
}
