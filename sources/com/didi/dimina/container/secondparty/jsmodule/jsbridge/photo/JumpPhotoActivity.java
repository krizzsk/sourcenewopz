package com.didi.dimina.container.secondparty.jsmodule.jsbridge.photo;

import android.app.Activity;
import android.content.ClipData;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.mina.DMMinaPool;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.photo.PhotoService;
import com.didi.dimina.container.secondparty.jsmodule.jsbridge.photo.TakePhotoActivity;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.container.util.PermissionUtil;
import com.didi.entrega.customer.app.constant.Const;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.webview.image.PicUploadActivity;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.taxis99.R;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;

public class JumpPhotoActivity extends Activity {
    public static final String TAG = "JumpPhotoActivity";

    /* renamed from: a */
    private static final String f17214a = "param_camera_direction";

    /* renamed from: b */
    private static final String f17215b = "param_photo_max_size";

    /* renamed from: c */
    private static final String f17216c = "param_photo_max_side_length";

    /* renamed from: d */
    private static final String f17217d = "param_photo_theme_color";

    /* renamed from: e */
    private static final String f17218e = "param_photo_capture_type";

    /* renamed from: f */
    private static final String f17219f = "param_photo_source_type";

    /* renamed from: g */
    private static final String f17220g = "param_dimina_index";

    /* renamed from: h */
    private static final int f17221h = 3;

    /* renamed from: i */
    private static final int f17222i = 4;

    /* renamed from: j */
    private static final int f17223j = 5;

    /* renamed from: k */
    private static final int f17224k = 6;

    /* renamed from: l */
    private DMMina f17225l;

    /* renamed from: m */
    private int f17226m;

    /* renamed from: n */
    private long f17227n;

    /* renamed from: o */
    private int f17228o;

    /* renamed from: p */
    private String f17229p;

    /* renamed from: q */
    private int f17230q;

    /* renamed from: r */
    private int f17231r;

    /* renamed from: s */
    private PhotoDialog f17232s;

    /* renamed from: t */
    private String f17233t;

    /* renamed from: u */
    private int f17234u;

    public static void jumpSystemPhoto(PhotoService.Config config) {
        Activity activity = config.activity;
        if (activity != null) {
            if ((config.cameraDirection == 1 || config.cameraDirection == 0) && config.photoMaxSideLength > 0 && config.photoMaxSize > 0) {
                Intent intent = new Intent();
                intent.setClass(activity, JumpPhotoActivity.class);
                intent.putExtra(f17214a, config.cameraDirection);
                intent.putExtra(f17215b, config.photoMaxSize);
                intent.putExtra(f17216c, config.photoMaxSideLength);
                intent.putExtra(f17217d, config.themeColor);
                intent.putExtra(f17218e, config.captureType.ordinal());
                intent.putExtra(f17220g, config.mina.getMinaIndex());
                activity.startActivity(intent);
                activity.overridePendingTransition(R.anim.dimina_photo_dialog_enter, 0);
            }
        }
    }

    public static void startByChooseImage(ChooseImageReq chooseImageReq) {
        Activity activity = chooseImageReq.activity;
        if (activity != null) {
            Intent intent = new Intent(activity, JumpPhotoActivity.class);
            intent.putExtra(f17219f, chooseImageReq.sourceType);
            intent.putExtra(f17218e, chooseImageReq.captureType);
            intent.putExtra(f17215b, ((long) chooseImageReq.maxSize) * 1024);
            intent.putExtra(f17220g, chooseImageReq.mina.getMinaIndex());
            intent.putExtra(Const.PageParams.COUNT, chooseImageReq.count);
            activity.startActivity(intent);
            activity.overridePendingTransition(R.anim.dimina_photo_dialog_enter, 0);
        }
    }

    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.f17225l = DMMinaPool.get(intent.getIntExtra(f17220g, -1));
        this.f17226m = intent.getIntExtra(f17214a, 1);
        this.f17227n = intent.getLongExtra(f17215b, 512000);
        this.f17228o = intent.getIntExtra(f17216c, 650);
        this.f17230q = intent.getIntExtra(f17217d, Color.parseColor("#2E2E3A"));
        this.f17231r = intent.getIntExtra(f17218e, PhotoService.CaptureType.NORMAL.ordinal());
        this.f17233t = intent.getStringExtra(f17219f);
        this.f17234u = intent.getIntExtra(Const.PageParams.COUNT, 1);
        if (TextUtils.isEmpty(this.f17233t)) {
            this.f17233t = "all";
        }
        if ("all".equals(this.f17233t)) {
            showDialog();
        } else if (ChooseImageReq.SOURCE_TYPE_ALBUM.equals(this.f17233t)) {
            m12787c();
        } else {
            m12781a();
        }
        if (Build.VERSION.SDK_INT != 26) {
            SystemUtils.hookSetRequestedOrientation(this, 1);
        }
    }

    public void showDialog() {
        PhotoDialog photoDialog = new PhotoDialog(this);
        this.f17232s = photoDialog;
        photoDialog.mo55749a(this.f17230q);
        this.f17232s.mo55750a((SingleCallback<Void>) new SingleCallback<Void>() {
            public void onCallback(Void voidR) {
                JumpPhotoActivity.this.m12787c();
            }
        });
        this.f17232s.mo55751b(new SingleCallback<Void>() {
            public void onCallback(Void voidR) {
                JumpPhotoActivity.this.m12781a();
            }
        });
        this.f17232s.mo55752c(new SingleCallback<Void>() {
            public void onCallback(Void voidR) {
                PhotoService.m12796a(1002, (String) null, (String) null, (String) null);
                JumpPhotoActivity.this.finish();
                JumpPhotoActivity.this.overridePendingTransition(0, R.anim.dimina_photo_dialog_outer);
            }
        });
        this.f17232s.mo55748a();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12781a() {
        if (this.f17231r == PhotoService.CaptureType.NORMAL.ordinal()) {
            m12785b();
        } else if (this.f17231r == PhotoService.CaptureType.CARD.ordinal()) {
            m12784a(TakePhotoActivity.PhotoType.TYPE_CARD);
        } else if (this.f17231r == PhotoService.CaptureType.HOLD_CARD.ordinal()) {
            m12784a(TakePhotoActivity.PhotoType.TYPE_PEOPLE_HOLD_CARD);
        }
    }

    /* renamed from: b */
    private void m12785b() {
        if (!PermissionUtil.requestCameraPermission(this)) {
            PhotoService.m12796a(1001, (String) null, (String) null, (String) null);
            LogUtil.eRelease(TAG, "没有相机权限，直接返回");
            return;
        }
        m12790f();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 6) {
                ClipData clipData = intent.getClipData();
                if (clipData != null) {
                    LogUtil.iRelease(TAG, "用户选择了多张: " + clipData.toString());
                    m12782a(clipData);
                    return;
                }
                this.f17229p = Utils.getPath(this, intent.getData());
                LogUtil.iRelease(TAG, "用户只选择了一张:" + this.f17229p);
            }
            if (!(i == 5 || i == 3 || i != 4)) {
                if (Build.VERSION.SDK_INT >= 24) {
                    this.f17229p = Utils.getFilePathFromURIForAPI24(this, intent.getData());
                    LogUtil.iRelease(TAG, ">=24  data.getData().toString():" + intent.getData().toString());
                    LogUtil.iRelease(TAG, ">=24   mImagePath:" + this.f17229p);
                } else {
                    this.f17229p = Utils.m12819a((Context) this, intent.getData());
                    LogUtil.iRelease(TAG, "<24  data.getData().toString():" + intent.getData().toString());
                    LogUtil.iRelease(TAG, "<24   mImagePath:" + this.f17229p);
                }
            }
            if (!TextUtils.isEmpty(this.f17229p)) {
                String str = this.f17229p;
                int i3 = this.f17228o;
                Bitmap decodeSampledBitmap = Utils.decodeSampledBitmap(str, i3, i3);
                PrintStream printStream = System.out;
                printStream.println("sample bitmap1===" + decodeSampledBitmap);
                if (decodeSampledBitmap == null) {
                    ContentResolver contentResolver = getContentResolver();
                    Uri data = intent.getData();
                    int i4 = this.f17228o;
                    decodeSampledBitmap = Utils.decodeImgByUriStream(contentResolver, data, i4, i4);
                }
                PrintStream printStream2 = System.out;
                printStream2.println("sample bitmap2===" + decodeSampledBitmap);
                if (decodeSampledBitmap == null) {
                    PhotoService.m12796a(1001, (String) null, (String) null, (String) null);
                    finish();
                    return;
                }
                Bitmap a = Utils.m12817a(decodeSampledBitmap, this.f17227n);
                if (a == null) {
                    PhotoService.m12796a(1003, (String) null, (String) null, (String) null);
                    finish();
                    return;
                }
                File a2 = Utils.m12818a((Context) this);
                if (a2 == null) {
                    PhotoService.m12796a(1003, (String) null, (String) null, (String) null);
                    finish();
                    return;
                }
                String absolutePath = a2.getAbsolutePath();
                Bitmap a3 = m12780a(a, getImageOrientation(this.f17229p));
                Utils.m12821a(a3, absolutePath);
                String a4 = Utils.m12820a(a3);
                if (TextUtils.isEmpty(a4)) {
                    PhotoService.m12796a(1003, (String) null, (String) null, (String) null);
                    finish();
                    return;
                }
                PhotoService.m12796a(1000, a4, absolutePath, (String) null);
            } else {
                PhotoService.m12796a(1001, (String) null, (String) null, (String) null);
            }
        } else {
            PhotoService.m12796a(1002, (String) null, (String) null, (String) null);
        }
        finish();
        overridePendingTransition(0, R.anim.dimina_photo_dialog_outer);
    }

    public int getImageOrientation(String str) {
        try {
            return new ExifInterface(str).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
        } catch (Exception unused) {
            return -1;
        }
    }

    /* renamed from: a */
    private Bitmap m12780a(Bitmap bitmap, int i) {
        if (bitmap == null || i == 1) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (i == 6) {
            matrix.setRotate(90.0f);
            return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        } else if (i != 8) {
            return bitmap;
        } else {
            matrix.setRotate(270.0f);
            return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, false);
        }
    }

    /* renamed from: a */
    private void m12782a(ClipData clipData) {
        int min = Math.min(this.f17234u, clipData.getItemCount());
        String[] strArr = new String[min];
        for (int i = 0; i < min; i++) {
            String filePathFromURIForAPI24 = Utils.getFilePathFromURIForAPI24(this, clipData.getItemAt(i).getUri());
            LogUtil.eRelease(TAG, "第" + i + "个的path是: " + filePathFromURIForAPI24);
            if (!TextUtils.isEmpty(filePathFromURIForAPI24)) {
                int i2 = this.f17228o;
                Bitmap decodeSampledBitmap = Utils.decodeSampledBitmap(filePathFromURIForAPI24, i2, i2);
                if (decodeSampledBitmap == null) {
                    LogUtil.eRelease(TAG, "1111 ");
                } else {
                    Bitmap a = Utils.m12817a(decodeSampledBitmap, this.f17227n);
                    if (a == null) {
                        LogUtil.eRelease(TAG, "22222");
                    } else {
                        File a2 = Utils.m12818a((Context) this);
                        if (a2 == null) {
                            LogUtil.eRelease(TAG, "33333");
                        } else {
                            String absolutePath = a2.getAbsolutePath();
                            Utils.m12821a(a, absolutePath);
                            strArr[i] = absolutePath;
                        }
                    }
                }
            } else {
                strArr[i] = null;
            }
        }
        LogUtil.iRelease(TAG, "最终返回的结果是:" + strArr);
        PhotoService.m12797a(1000, strArr);
        finish();
        overridePendingTransition(0, R.anim.dimina_photo_dialog_outer);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m12787c() {
        if (this.f17234u < 2) {
            m12788d();
        } else {
            m12789e();
        }
    }

    /* renamed from: d */
    private void m12788d() {
        Intent intent = new Intent("android.intent.action.PICK", (Uri) null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, PicUploadActivity.IMAGE_UNSPECIFIED);
        startActivityForResult(intent, 4);
    }

    /* renamed from: e */
    private void m12789e() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType(AsyncHttpRequest.HEADER_ACCEPT_ALL);
        ArrayList arrayList = new ArrayList();
        arrayList.add(PicUploadActivity.IMAGE_UNSPECIFIED);
        intent.putExtra("android.intent.extra.MIME_TYPES", arrayList);
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
        intent.putExtra("android.intent.extra.LOCAL_ONLY", false);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 6);
        }
    }

    /* renamed from: f */
    private void m12790f() {
        Uri uri;
        File photoOutputFile = Utils.getPhotoOutputFile(this);
        if (photoOutputFile != null) {
            this.f17229p = photoOutputFile.getAbsolutePath();
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            int i = this.f17226m;
            if (i == 0) {
                intent.putExtra("android.intent.extras.CAMERA_FACING", 1);
            } else if (i == 1) {
                intent.putExtra("android.intent.extras.CAMERA_FACING", 0);
            }
            if (Build.VERSION.SDK_INT >= 24) {
                uri = FileProvider.getUriForFile(this, Dimina.getConfig().getAdapterConfig().getWsgService().getPackageName(this) + ".dimina.file.provider", photoOutputFile);
            } else {
                uri = Uri.fromFile(photoOutputFile);
            }
            intent.putExtra("output", uri);
            startActivityForResult(intent, 3);
        }
    }

    /* renamed from: a */
    private void m12784a(TakePhotoActivity.PhotoType photoType) {
        File photoOutputFile;
        if (photoType != null && (photoOutputFile = Utils.getPhotoOutputFile(this)) != null) {
            this.f17229p = photoOutputFile.getAbsolutePath();
            Intent intent = new Intent(this, TakePhotoActivity.class);
            intent.putExtra(TakePhotoActivity.KEY_DMMINA_INDEX, this.f17225l.getMinaIndex());
            intent.putExtra(TakePhotoActivity.KEY_FILEPATH, photoOutputFile.getAbsolutePath());
            intent.putExtra(TakePhotoActivity.KEY_PHOTOTYPE, photoType.ordinal());
            startActivityForResult(intent, 5);
        }
    }
}
