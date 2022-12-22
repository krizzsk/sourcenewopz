package com.didi.payment.utilities.photo;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.FileProvider;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.globaluikit.utils.UIThreadHandler;
import com.didi.hawaii.mapsdk.gesture.NNGestureClassfy;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.base.utils.WalletToast;
import com.didi.payment.utilities.base.CsBaseActivity;
import com.didi.payment.utilities.base.CsOmegaUtils;
import com.didi.payment.utilities.details.CsBillDetailActivity;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.FileUtil;
import com.didi.sdk.webview.image.PicUploadActivity;
import com.didi.unifiedPay.util.UIUtils;
import com.taxis99.R;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CsPhotoInputActivity extends CsBaseActivity {

    /* renamed from: a */
    private static final int f31637a = 10;

    /* renamed from: b */
    private static final int f31638b = 11;

    /* renamed from: c */
    private static final String f31639c = ".fileprovider";

    /* renamed from: d */
    private static final int f31640d = 4;

    /* renamed from: e */
    private static final int f31641e = 1;

    /* renamed from: f */
    private ImageView f31642f;

    /* renamed from: g */
    private Uri f31643g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Bitmap f31644h;

    /* renamed from: i */
    private File f31645i;

    /* renamed from: j */
    private File f31646j;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.cs_activity_utilities_photo_input_layout);
        m22418a();
        m22424b();
        CsOmegaUtils.trackBoletoChoosePhotoSw();
    }

    /* renamed from: a */
    private void m22418a() {
        this.f31642f = (ImageView) findViewById(R.id.cs_photo_input);
        try {
            ((TextView) findViewById(R.id.photo_scan_button)).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    WalletToast.showMsg(CsPhotoInputActivity.this.getContext(), CsPhotoInputActivity.this.getString(R.string.GRider_reminder_Photo_recognition_eFFp));
                    CsPhotoInputActivity csPhotoInputActivity = CsPhotoInputActivity.this;
                    csPhotoInputActivity.m22419a(csPhotoInputActivity.f31644h);
                    CsOmegaUtils.trackBoletoChoosePhotoCk();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            finish();
        }
        ((ImageView) findViewById(R.id.title_back)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CsPhotoInputActivity.this.finish();
            }
        });
    }

    /* renamed from: a */
    private void m22420a(Uri uri) {
        try {
            Bitmap b = m22423b(uri);
            this.f31644h = b;
            if (b == null) {
                WalletToast.showFailedMsg(getApplication(), getString(R.string.GRider_reminder_Unrecognized_bar_WXhr));
                finish();
                return;
            }
            this.f31642f.setImageBitmap(b);
        } catch (Throwable unused) {
            WalletToast.showFailedMsg(getApplication(), getString(R.string.GRider_reminder_Unrecognized_bar_WXhr));
            finish();
        }
    }

    /* renamed from: b */
    private void m22424b() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.PICK");
        intent.setType(PicUploadActivity.IMAGE_UNSPECIFIED);
        startActivityForResult(intent, 10);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        try {
            if (this.f31645i != null && this.f31645i.exists()) {
                this.f31645i.delete();
            }
            if (this.f31646j != null && this.f31646j.exists()) {
                this.f31646j.delete();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22419a(Bitmap bitmap) {
        CsPhotoInputViewModel csPhotoInputViewModel = (CsPhotoInputViewModel) new ViewModelProvider(this).get(CsPhotoInputViewModel.class);
        csPhotoInputViewModel.getBareCodeData().observe(this, new Observer<String>() {
            public void onChanged(String str) {
                if (TextUtils.isEmpty(str)) {
                    WalletToast.cancel();
                    UIThreadHandler.post(new Runnable() {
                        public void run() {
                            WalletToast.showFailedMsg(CsPhotoInputActivity.this.getApplication(), CsPhotoInputActivity.this.getString(R.string.GRider_reminder_Unrecognized_bar_WXhr));
                        }
                    }, 500);
                    CsOmegaUtils.trackBoletoPhotoInputFailSw();
                } else {
                    CsBillDetailActivity.startActivity(str, (Context) CsPhotoInputActivity.this, "photo_input");
                }
                CsPhotoInputActivity.this.finish();
            }
        });
        csPhotoInputViewModel.scanPhoto(bitmap);
    }

    /* renamed from: b */
    private Bitmap m22423b(Uri uri) {
        int i;
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
            if (!WalletApolloUtil.isBoletoPhotoCrop()) {
                return bitmap;
            }
            int height = bitmap.getHeight();
            int width = bitmap.getWidth();
            if (height <= width) {
                i = UIUtils.getScreenHeight(this) / height;
            } else {
                i = UIUtils.getScreenWidth(this) / width;
            }
            if (i < 1) {
                i = 1;
            } else if (i > 4) {
                i = 4;
            }
            Matrix matrix = new Matrix();
            float f = (float) i;
            matrix.postScale(f, f);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private void m22422a(String str) {
        File c = m22425c();
        this.f31645i = c;
        FileUtil.copyFile(str, c.getAbsolutePath());
        Uri fromFile = Uri.fromFile(this.f31645i);
        Intent intent = new Intent("com.android.camera.action.CROP");
        String str2 = getPackageName() + f31639c;
        if (Build.VERSION.SDK_INT >= 24) {
            Uri uriForFile = FileProvider.getUriForFile(this, str2, new File(fromFile.getPath()));
            intent.addFlags(1);
            intent.setDataAndType(uriForFile, PicUploadActivity.IMAGE_UNSPECIFIED);
        } else if (Build.VERSION.SDK_INT >= 19) {
            intent.setDataAndType(Uri.fromFile(new File(FileUtil.getPath(this, fromFile))), PicUploadActivity.IMAGE_UNSPECIFIED);
        } else {
            intent.setDataAndType(fromFile, PicUploadActivity.IMAGE_UNSPECIFIED);
        }
        File d = m22426d();
        this.f31646j = d;
        this.f31643g = Uri.fromFile(d);
        intent.putExtra("crop", "true");
        intent.putExtra(NNGestureClassfy.SCALE_LABLE, true);
        intent.putExtra("return-data", false);
        intent.putExtra("output", this.f31643g);
        intent.putExtra("noFaceDetection", true);
        startActivityForResult(intent, 11);
    }

    /* renamed from: c */
    private File m22425c() {
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        return new File(externalStoragePublicDirectory, "IMG_" + format + "_output.jpg");
    }

    /* renamed from: d */
    private File m22426d() {
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        String format = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        return new File(externalStoragePublicDirectory, "IMG_" + format + "_crop.jpg");
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (-1 == i2) {
            if (i == 10) {
                Uri data = intent.getData();
                if (WalletApolloUtil.isBoletoPhotoCrop()) {
                    try {
                        m22422a(FileUtil.getPath(this, data));
                    } catch (Exception e) {
                        e.printStackTrace();
                        m22420a(data);
                    }
                } else {
                    m22420a(data);
                }
            } else if (i == 11) {
                m22420a(this.f31643g);
                CsOmegaUtils.trackBoletoZoomClipCK();
            }
        } else if (i2 == 0) {
            finish();
        }
    }
}
