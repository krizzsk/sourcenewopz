package com.didi.sdk.webview.image;

import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.commoninterfacelib.permission.PermissionCallback;
import com.didi.commoninterfacelib.permission.PermissionContext;
import com.didi.commoninterfacelib.permission.PermissionUtil;
import com.didi.commoninterfacelib.permission.TheOneBaseActivity;
import com.didi.hawaii.mapsdk.gesture.NNGestureClassfy;
import com.didi.payment.utilities.scan.collect.CollectionConstant;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.common.DDRpcServiceHelper;
import com.didi.sdk.util.FileUtil;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.ToastHelper;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.foundation.rpc.RpcService;
import com.didiglobal.privacy.disclosure.PositiveResultReason;
import com.didiglobal.privacy.disclosure.PrivacyDisclosureBaseDialog;
import com.didiglobal.privacy.disclosure.PrivacyDisclosureManager;
import com.didiglobal.privacy.disclosure.PrivacyTypeEnum;
import com.facebook.internal.AnalyticsEvents;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.UndeclaredThrowableException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONObject;

public class PicUploadActivity extends TheOneBaseActivity {
    public static final String DATA_PARAMS_KEY = "DATA_PARAMS_KEY";
    public static final String FINAL_PIC_MSG_KEY = "pic_msg_key";
    public static final String IMAGE_UNSPECIFIED = "image/*";
    public static final int REQUEST_CODE_SYSTEM_RESIZE_IMAGE = 104;
    public static final String TAG = "PicUploadActivity";
    public static final String UPLOAD_URL_KEY = "UPLOAD_URL_KEY";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static ImageUploadCallback f38460a = null;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static ImageCallback f38461b = null;

    /* renamed from: e */
    private static final int f38462e = 100;

    /* renamed from: f */
    private static final int f38463f = 101;

    /* renamed from: g */
    private static final int f38464g = 102;

    /* renamed from: c */
    private ListView f38465c;

    /* renamed from: d */
    private TextView f38466d;

    /* renamed from: h */
    private String f38467h;

    /* renamed from: i */
    private String f38468i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public File f38469j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public File f38470k;

    /* renamed from: l */
    private String f38471l;

    /* renamed from: m */
    private RelativeLayout f38472m;

    /* renamed from: n */
    private String f38473n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f38474o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public int f38475p;

    /* renamed from: q */
    private String f38476q = "";

    /* renamed from: r */
    private boolean f38477r;

    /* renamed from: s */
    private ProgressDialog f38478s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public Handler f38479t;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public String f38480u;

    /* renamed from: v */
    private File f38481v = null;

    /* renamed from: w */
    private AdapterView.OnItemClickListener f38482w = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AutoTrackHelper.trackViewOnClick((AdapterView) adapterView, view, i);
            if (i == 0) {
                PicUploadActivity picUploadActivity = PicUploadActivity.this;
                File unused = picUploadActivity.f38469j = ImageFileConfig.getPhotoOutputFile(picUploadActivity.getApplicationContext());
                PicUploadActivity.this.m27256e();
            } else if (i == 1) {
                PicUploadActivity.this.m27261g();
            }
        }
    };

    /* renamed from: x */
    private View.OnClickListener f38483x = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            if (PicUploadActivity.f38461b != null) {
                PicUploadActivity.f38461b.onCancel();
            }
            PicUploadActivity.this.finish();
        }
    };

    public static void setImageUploadCallback(ImageUploadCallback imageUploadCallback) {
        f38460a = imageUploadCallback;
    }

    public static void setImageCallback(ImageCallback imageCallback) {
        f38461b = imageCallback;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        if (bundle != null) {
            this.f38471l = bundle.getString("mOutPutFile");
        }
        this.f38479t = new Handler();
        m27250c();
    }

    public void finish() {
        super.finish();
        f38460a = null;
        f38461b = null;
    }

    /* renamed from: a */
    private int m27237a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: c */
    private void m27250c() {
        Intent intent = getIntent();
        if (intent != null) {
            this.f38473n = intent.getStringExtra("type");
            String stringExtra = intent.getStringExtra(UPLOAD_URL_KEY);
            this.f38467h = stringExtra;
            if (!TextUtils.isEmpty(stringExtra) && Uri.parse(this.f38467h).isRelative()) {
                finish();
            }
            this.f38468i = intent.getStringExtra(DATA_PARAMS_KEY);
            this.f38474o = m27237a(intent.getStringExtra("width"));
            this.f38475p = m27237a(intent.getStringExtra("height"));
            this.f38476q = intent.getStringExtra(CollectionConstant.APOLLO_PARAM_QUALITY);
            this.f38477r = intent.getBooleanExtra("cut", false);
        }
        File photoOutputFile = ImageFileConfig.getPhotoOutputFile(getApplicationContext());
        this.f38470k = photoOutputFile;
        if (photoOutputFile != null) {
            this.f38471l = photoOutputFile.getAbsolutePath();
        }
        if (this.f38473n.equals("camera")) {
            this.f38469j = ImageFileConfig.getPhotoOutputFile(getApplicationContext());
            m27256e();
        } else if (this.f38473n.equals(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO)) {
            m27261g();
        } else {
            overridePendingTransition(R.anim.down_to_up_slide_in, R.anim.up_to_down_slide_out);
            setContentView((int) R.layout.image_pick_dialog_layout);
            m27254d();
        }
    }

    /* renamed from: d */
    private void m27254d() {
        this.f38465c = (ListView) findViewById(R.id.pic_menu_list);
        this.f38472m = (RelativeLayout) findViewById(R.id.bts_upload_rela);
        this.f38465c.setAdapter(new ArrayAdapter(this, R.layout.v_pic_upload_list, getResources().getStringArray(R.array.avatar_menu)));
        this.f38465c.setOnItemClickListener(this.f38482w);
        TextView textView = (TextView) findViewById(R.id.cancel_text);
        this.f38466d = textView;
        textView.setOnClickListener(this.f38483x);
    }

    public static boolean isCameraCanUse() {
        Camera camera;
        boolean z = false;
        try {
            camera = Camera.open(0);
            try {
                camera.setDisplayOrientation(90);
                z = true;
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            camera = null;
        }
        if (z) {
            camera.release();
        }
        return z;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m27256e() {
        PrivacyDisclosureManager.getInstance().openPrivacyDisclosureDialog(this, PrivacyTypeEnum.CAMERA, new String[]{Permission.CAMERA, Permission.READ_EXTERNAL_STORAGE, Permission.WRITE_EXTERNAL_STORAGE}, new PrivacyDisclosureBaseDialog.Callback() {
            public void onPositiveResult(PositiveResultReason positiveResultReason) {
                PicUploadActivity.this.m27259f();
            }

            public void onNegativeResult() {
                if (PicUploadActivity.f38461b != null) {
                    PicUploadActivity.f38461b.onPermissionFail();
                }
                PicUploadActivity.this.finish();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m27259f() {
        final Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(getPackageManager()) != null && this.f38469j != null) {
            PermissionUtil.checkAndRequestPermissions((PermissionContext) this, (PermissionCallback) new PermissionCallback() {
                public void isAllGranted(boolean z, String[] strArr) {
                    Uri uri;
                    if (z) {
                        if (Build.VERSION.SDK_INT < 24) {
                            intent.putExtra("output", Uri.fromFile(PicUploadActivity.this.f38469j));
                        } else {
                            if (Apollo.getToggle("global_pick_image_provider_uri", true).allow()) {
                                PicUploadActivity picUploadActivity = PicUploadActivity.this;
                                uri = FileProvider.getUriForFile(picUploadActivity, PicUploadActivity.this.getPackageName() + ".fileprovider", PicUploadActivity.this.f38469j);
                            } else {
                                ContentValues contentValues = new ContentValues(1);
                                contentValues.put("_data", PicUploadActivity.this.f38469j.getAbsolutePath());
                                uri = PicUploadActivity.this.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                            }
                            intent.putExtra("output", uri);
                            intent.addFlags(2);
                        }
                        PicUploadActivity.this.startActivityForResult(intent, 101);
                        return;
                    }
                    if (PicUploadActivity.f38461b != null) {
                        PicUploadActivity.f38461b.onPermissionFail();
                    }
                    PicUploadActivity.this.finish();
                }
            }, new String[]{Permission.CAMERA, Permission.READ_EXTERNAL_STORAGE, Permission.WRITE_EXTERNAL_STORAGE}, true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m27261g() {
        PrivacyDisclosureManager.getInstance().openPrivacyDisclosureDialog(this, PrivacyTypeEnum.ALBUM, new String[]{Permission.READ_EXTERNAL_STORAGE, Permission.WRITE_EXTERNAL_STORAGE}, new PrivacyDisclosureBaseDialog.Callback() {
            public void onPositiveResult(PositiveResultReason positiveResultReason) {
                PicUploadActivity.this.m27263h();
            }

            public void onNegativeResult() {
                if (PicUploadActivity.f38461b != null) {
                    PicUploadActivity.f38461b.onPermissionFail();
                }
                PicUploadActivity.this.finish();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m27263h() {
        PermissionUtil.checkAndRequestPermissions((PermissionContext) this, (PermissionCallback) new PermissionCallback() {
            public void isAllGranted(boolean z, String[] strArr) {
                if (z) {
                    try {
                        Intent intent = new Intent("android.intent.action.PICK", (Uri) null);
                        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, PicUploadActivity.IMAGE_UNSPECIFIED);
                        PicUploadActivity.this.startActivityForResult(intent, 100);
                    } catch (Exception unused) {
                        ToastHelper.showShortInfo((Context) PicUploadActivity.this, "Open Pick App Error");
                    }
                } else {
                    if (PicUploadActivity.f38461b != null) {
                        PicUploadActivity.f38461b.onPermissionFail();
                    }
                    PicUploadActivity.this.finish();
                }
            }
        }, new String[]{Permission.READ_EXTERNAL_STORAGE, Permission.WRITE_EXTERNAL_STORAGE}, true);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 0) {
            ImageCallback imageCallback = f38461b;
            if (imageCallback != null) {
                imageCallback.onCancel();
            }
            finish();
        } else if (i != 104) {
            switch (i) {
                case 100:
                    if (i2 == -1) {
                        if (this.f38470k == null) {
                            finish();
                        }
                        if (this.f38474o == 0 || this.f38475p == 0) {
                            Uri data = intent.getData();
                            String path = FileUtil.getPath(this, data);
                            File photoOutputFile = ImageFileConfig.getPhotoOutputFile(getApplicationContext());
                            FileUtil.copyFile(path, photoOutputFile.getAbsolutePath());
                            if (this.f38477r) {
                                m27251c(Uri.fromFile(photoOutputFile));
                                return;
                            } else {
                                m27247b(data);
                                return;
                            }
                        } else if (!this.f38477r || !m27244a(intent.getData())) {
                            m27247b(intent.getData());
                            return;
                        } else {
                            return;
                        }
                    } else {
                        ImageCallback imageCallback2 = f38461b;
                        if (imageCallback2 != null) {
                            imageCallback2.onCancel();
                        }
                        finish();
                        return;
                    }
                case 101:
                    if (i2 == -1) {
                        File file = this.f38469j;
                        if (file == null || file.length() <= 0) {
                            FileUtil.deleteFile(this.f38469j);
                            ImageCallback imageCallback3 = f38461b;
                            if (imageCallback3 != null) {
                                imageCallback3.onFail();
                            }
                            finish();
                            return;
                        }
                        Uri fromFile = Uri.fromFile(this.f38469j);
                        if (this.f38474o == 0 || this.f38475p == 0) {
                            if (this.f38477r) {
                                m27251c(fromFile);
                                return;
                            } else {
                                m27247b(fromFile);
                                return;
                            }
                        } else if (!this.f38477r || !m27244a(fromFile)) {
                            m27247b(fromFile);
                            return;
                        } else {
                            return;
                        }
                    } else {
                        FileUtil.deleteFile(this.f38469j);
                        if (f38461b != null) {
                            if (ActivityCompat.checkSelfPermission(this, Permission.CAMERA) != 0 || !isCameraCanUse()) {
                                f38461b.onPermissionFail();
                            } else {
                                f38461b.onCancel();
                            }
                        }
                        finish();
                        return;
                    }
                case 102:
                    if (i2 != -1 || intent == null) {
                        ImageCallback imageCallback4 = f38461b;
                        if (imageCallback4 != null) {
                            imageCallback4.onFail();
                        }
                        finish();
                        return;
                    }
                    RelativeLayout relativeLayout = this.f38472m;
                    if (relativeLayout != null) {
                        relativeLayout.setVisibility(8);
                    }
                    String stringExtra = intent.getStringExtra("CROP_PIC_PASS_KEY");
                    if (!TextUtils.isEmpty(this.f38467h)) {
                        m27255d(stringExtra);
                        return;
                    }
                    ImageUploadCallback imageUploadCallback = f38460a;
                    if (imageUploadCallback != null) {
                        imageUploadCallback.onSuccess(m27249c(stringExtra));
                    }
                    ImageCallback imageCallback5 = f38461b;
                    if (imageCallback5 != null) {
                        imageCallback5.onSuccess(m27249c(stringExtra), this.f38480u, m27246b(stringExtra));
                    }
                    finish();
                    return;
                default:
                    return;
            }
        } else if (i2 == -1) {
            final Uri fromFile2 = Uri.fromFile(this.f38481v);
            new Thread(new Runnable() {
                public void run() {
                    try {
                        final String decodeSampledBitmap = PicUploadActivity.this.decodeSampledBitmap(fromFile2, 600, 600);
                        PicUploadActivity.this.f38479t.post(new Runnable() {
                            public void run() {
                                if (PicUploadActivity.f38461b != null) {
                                    PicUploadActivity.f38461b.onSuccess(decodeSampledBitmap, PicUploadActivity.this.f38480u, PicUploadActivity.this.m27246b(FileUtil.getPath(PicUploadActivity.this, fromFile2)));
                                }
                                PicUploadActivity.this.finish();
                            }
                        });
                    } catch (Exception unused) {
                        PicUploadActivity.this.f38479t.post(new Runnable() {
                            public void run() {
                                if (PicUploadActivity.f38461b != null) {
                                    PicUploadActivity.f38461b.onFail();
                                }
                                PicUploadActivity.this.finish();
                            }
                        });
                    }
                }
            }).start();
            this.f38465c.setOnItemClickListener((AdapterView.OnItemClickListener) null);
        } else {
            ImageCallback imageCallback6 = f38461b;
            if (imageCallback6 != null) {
                imageCallback6.onCancel();
            }
            finish();
        }
    }

    /* renamed from: a */
    private boolean m27244a(Uri uri) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeStream(getContentResolver().openInputStream(uri), (Rect) null, options);
            if (options.outHeight < this.f38475p || options.outWidth < this.f38474o) {
                return false;
            }
            Intent intent = new Intent(this, CropActivity.class);
            intent.setData(uri);
            intent.putExtra("width", this.f38474o);
            intent.putExtra("height", this.f38475p);
            intent.putExtra("output", this.f38471l);
            startActivityForResult(intent, 102);
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public String m27246b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String exifDateTime = ExifUtils.getExifDateTime(str);
            if (!TextUtils.isEmpty(exifDateTime)) {
                return exifDateTime;
            }
            return new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", Locale.getDefault()).format(new Date(new File(str).lastModified()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: b */
    private void m27247b(final Uri uri) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    final String decodeSampledBitmap = PicUploadActivity.this.decodeSampledBitmap(uri, PicUploadActivity.this.f38474o, PicUploadActivity.this.f38475p);
                    PicUploadActivity.this.f38479t.post(new Runnable() {
                        public void run() {
                            if (PicUploadActivity.f38461b != null) {
                                PicUploadActivity.f38461b.onSuccess(decodeSampledBitmap, PicUploadActivity.this.f38480u, PicUploadActivity.this.m27246b(FileUtil.getPath(PicUploadActivity.this, uri)));
                            }
                            PicUploadActivity.this.finish();
                        }
                    });
                } catch (Exception unused) {
                    PicUploadActivity.this.f38479t.post(new Runnable() {
                        public void run() {
                            if (PicUploadActivity.f38461b != null) {
                                PicUploadActivity.f38461b.onFail();
                            }
                            PicUploadActivity.this.finish();
                        }
                    });
                }
            }
        }).start();
        ListView listView = this.f38465c;
        if (listView != null) {
            listView.setOnItemClickListener((AdapterView.OnItemClickListener) null);
        }
    }

    /* renamed from: c */
    private void m27251c(Uri uri) {
        try {
            Intent intent = new Intent("com.android.camera.action.CROP");
            if (Build.VERSION.SDK_INT >= 24) {
                Uri uriForFile = FileProvider.getUriForFile(this, "com.didi.sdk.fileprovider.global", new File(uri.getPath()));
                intent.addFlags(1);
                intent.setDataAndType(uriForFile, IMAGE_UNSPECIFIED);
            } else if (Build.VERSION.SDK_INT >= 19) {
                intent.setDataAndType(Uri.fromFile(new File(FileUtil.getPath(this, uri))), IMAGE_UNSPECIFIED);
            } else {
                intent.setDataAndType(uri, IMAGE_UNSPECIFIED);
            }
            File photoOutputFile = ImageFileConfig.getPhotoOutputFile(getApplicationContext());
            this.f38481v = photoOutputFile;
            Uri fromFile = Uri.fromFile(photoOutputFile);
            intent.putExtra("crop", "true");
            intent.putExtra(NNGestureClassfy.SCALE_LABLE, true);
            intent.putExtra("return-data", false);
            intent.putExtra("output", fromFile);
            intent.putExtra("noFaceDetection", true);
            startActivityForResult(intent, 104);
        } catch (Exception unused) {
            ToastHelper.showShortError((Context) this, getString(R.string.crop_pic_modify_error2));
        }
    }

    public int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 1;
        }
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        if (i3 <= i2 && i4 <= i) {
            return 1;
        }
        int round = Math.round(((float) i3) / ((float) i2));
        int round2 = Math.round(((float) i4) / ((float) i));
        return round < round2 ? round : round2;
    }

    public String decodeSampledBitmap(Uri uri, int i, int i2) throws FileNotFoundException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(getContentResolver().openInputStream(uri), (Rect) null, options);
        options.inSampleSize = calculateInSampleSize(options, i, i2);
        options.inJustDecodeBounds = false;
        Bitmap decodeStream = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri), (Rect) null, options);
        int exifOrientation = ExifUtils.getExifOrientation(this, uri);
        if (exifOrientation != 0) {
            decodeStream = m27238a(decodeStream, exifOrientation, true);
        }
        return m27241a(decodeStream, options);
    }

    /* renamed from: a */
    private Bitmap m27238a(Bitmap bitmap, int i, boolean z) {
        if (i == 0) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postRotate((float) i);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        if (z) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    /* renamed from: c */
    private String m27249c(String str) {
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        try {
            if (TextUtil.isEmpty(this.f38476q)) {
                this.f38476q = "100";
            }
            int parseInt = Integer.parseInt(this.f38476q);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            decodeFile.compress(Bitmap.CompressFormat.JPEG, parseInt, byteArrayOutputStream);
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 4);
        } catch (IOException e) {
            SystemUtils.log(3, TAG, e.toString(), (Throwable) null, "com.didi.sdk.webview.image.PicUploadActivity", 674);
            return "";
        } catch (Exception e2) {
            SystemUtils.log(3, TAG, e2.toString(), (Throwable) null, "com.didi.sdk.webview.image.PicUploadActivity", 676);
            return "";
        }
    }

    /* renamed from: a */
    private String m27241a(Bitmap bitmap, BitmapFactory.Options options) {
        try {
            if (TextUtil.isEmpty(this.f38476q)) {
                this.f38476q = "75";
            }
            int parseInt = Integer.parseInt(this.f38476q);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (!TextUtil.isEmpty(this.f38480u) && this.f38480u.contains("jpeg")) {
                bitmap.compress(Bitmap.CompressFormat.JPEG, parseInt, byteArrayOutputStream);
                this.f38480u = com.didi.dimina.starbox.util.FileUtil.JPG;
            } else if (TextUtil.isEmpty(this.f38480u) || !this.f38480u.contains("png")) {
                bitmap.compress(Bitmap.CompressFormat.JPEG, parseInt, byteArrayOutputStream);
                String str = options.outMimeType;
                if (TextUtil.isEmpty(str) || !str.contains("/")) {
                    this.f38480u = "";
                } else {
                    this.f38480u = str.split("/")[1];
                }
            } else {
                this.f38480u = "png";
                bitmap.compress(Bitmap.CompressFormat.PNG, parseInt, byteArrayOutputStream);
            }
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 4);
        } catch (IOException e) {
            SystemUtils.log(3, TAG, e.toString(), (Throwable) null, "com.didi.sdk.webview.image.PicUploadActivity", 710);
            return "";
        } catch (Exception e2) {
            SystemUtils.log(3, TAG, e2.toString(), (Throwable) null, "com.didi.sdk.webview.image.PicUploadActivity", 712);
            return "";
        }
    }

    /* renamed from: i */
    private void m27265i() {
        try {
            if (this.f38478s == null) {
                this.f38478s = new ProgressDialog(this);
            }
            this.f38478s.setMessage(getString(R.string.image_uploading));
            this.f38478s.setCancelable(false);
            this.f38478s.setCanceledOnTouchOutside(false);
            SystemUtils.showDialog(this.f38478s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m27266j() {
        ProgressDialog progressDialog = this.f38478s;
        if (progressDialog != null) {
            if (progressDialog.isShowing()) {
                try {
                    this.f38478s.dismiss();
                } catch (Exception unused) {
                }
            }
            this.f38478s = null;
        }
    }

    /* renamed from: d */
    private void m27255d(String str) {
        if (!TextUtils.isEmpty(str)) {
            m27265i();
            ImageUploadService imageUploadService = (ImageUploadService) DDRpcServiceHelper.getRpcServiceFactory().newRpcService(ImageUploadService.class, this.f38467h);
            HashMap<String, Object> createParams = UploadParams.createParams(this, new File(str), this.f38468i);
            try {
                imageUploadService.uploadImage(UploadParams.createQueryParams(this), createParams, new RpcService.Callback<String>() {
                    public void onSuccess(String str) {
                        PicUploadActivity.this.m27266j();
                        FileUtil.deleteFile(PicUploadActivity.this.f38470k);
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            int optInt = jSONObject.optInt("errno");
                            String optString = jSONObject.optString("errmsg");
                            if (optInt != 0) {
                                ToastHelper.showShortError((Context) PicUploadActivity.this, optString);
                            } else if (PicUploadActivity.f38460a != null) {
                                PicUploadActivity.f38460a.onSuccess(str);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        PicUploadActivity.this.finish();
                    }

                    public void onFailure(IOException iOException) {
                        PicUploadActivity.this.m27266j();
                        ToastHelper.showShortError((Context) PicUploadActivity.this, (int) R.string.image_upload_failed);
                        FileUtil.deleteFile(PicUploadActivity.this.f38470k);
                        PicUploadActivity.this.finish();
                    }
                });
            } catch (UndeclaredThrowableException e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("mOutPutFile", this.f38471l);
    }

    public void onBackPressed() {
        ImageCallback imageCallback = f38461b;
        if (imageCallback != null) {
            imageCallback.onCancel();
        }
        super.onBackPressed();
    }
}
