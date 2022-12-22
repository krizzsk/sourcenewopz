package com.didi.sdk.webview.image;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Base64;
import androidx.core.app.ActivityCompat;
import com.didi.sdk.util.FileUtil;
import com.didi.sdk.webview.image.BottomListMenu;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.security.InvalidParameterException;

public class ImageHelper {
    public static final int REQ_ALBUM_ACTIVITY = 100;
    public static final int REQ_CAMERA_ACTIVITY = 101;

    /* renamed from: a */
    private static final String f38451a = "image/*";

    /* renamed from: b */
    private Activity f38452b;

    /* renamed from: c */
    private int f38453c;

    /* renamed from: d */
    private int f38454d;

    /* renamed from: e */
    private int f38455e;

    /* renamed from: f */
    private boolean f38456f = true;

    /* renamed from: g */
    private IImg2StrListener f38457g;

    /* renamed from: h */
    private File f38458h;

    /* renamed from: i */
    private BottomListMenu f38459i;

    public interface IImg2StrListener {
        void onResult(String str);
    }

    public ImageHelper(Activity activity) {
        if (activity != null) {
            this.f38452b = activity;
            return;
        }
        throw new InvalidParameterException("the param should not be null");
    }

    public void handleActivityResult(int i, int i2, Intent intent) {
        if (i == 100) {
            handleSelectPicResult(i, i2, intent);
        } else if (i == 101) {
            handleTakePicResult(i, i2, intent);
        }
    }

    public void handleImageChoose(int i, int i2, int i3, IImg2StrListener iImg2StrListener) {
        if (i > 0 && i2 > 0 && i3 > 0 && i3 <= 100 && iImg2StrListener != null) {
            this.f38454d = i2;
            this.f38453c = i;
            this.f38455e = i3;
            this.f38456f = true;
            this.f38457g = iImg2StrListener;
            m27226a();
        }
    }

    public void handleImageChoose(IImg2StrListener iImg2StrListener) {
        if (iImg2StrListener != null) {
            this.f38456f = false;
            this.f38457g = iImg2StrListener;
            m27226a();
        }
    }

    /* renamed from: a */
    private void m27226a() {
        if (this.f38459i == null) {
            Activity activity = this.f38452b;
            BottomListMenu bottomListMenu = new BottomListMenu(activity, activity.findViewById(16908290), this.f38452b.getResources().getStringArray(R.array.avatar_menu));
            this.f38459i = bottomListMenu;
            bottomListMenu.setListMenuListener(new BottomListMenu.ListMenuListener() {
                public void onItemSelected(int i, String str) {
                    if (i == 0) {
                        ImageHelper.this.m27231b();
                    } else if (i == 1) {
                        ImageHelper.this.m27235c();
                    }
                }
            });
        }
        this.f38459i.showDialog();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m27231b() {
        if (ActivityCompat.checkSelfPermission(this.f38452b, Permission.CAMERA) == 0 && ActivityCompat.checkSelfPermission(this.f38452b, Permission.WRITE_EXTERNAL_STORAGE) == 0) {
            File photoOutputFile = ImageFileConfig.getPhotoOutputFile(this.f38452b);
            this.f38458h = photoOutputFile;
            try {
                this.f38452b.startActivityForResult(ImageFileConfig.getCameraIntent(this.f38452b, photoOutputFile), 101);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            ActivityCompat.requestPermissions(this.f38452b, new String[]{Permission.CAMERA, Permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m27235c() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        intent.addCategory("android.intent.category.OPENABLE");
        if (intent.resolveActivity(this.f38452b.getPackageManager()) != null) {
            this.f38452b.startActivityForResult(intent, 100);
        }
    }

    /* access modifiers changed from: protected */
    public void handleTakePicResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            File file = this.f38458h;
            if (file != null) {
                Uri fromFile = Uri.fromFile(file);
                if (fromFile != null) {
                    m27227a(fromFile);
                } else {
                    m27236d();
                }
            }
        } else {
            m27236d();
        }
    }

    /* access modifiers changed from: protected */
    public void handleSelectPicResult(int i, int i2, Intent intent) {
        Uri data;
        if (i2 == -1 && intent != null && intent.getData() != null && (data = intent.getData()) != null) {
            m27227a(data);
        }
    }

    /* renamed from: a */
    private void m27227a(Uri uri) {
        Bitmap bitmap;
        if (this.f38456f) {
            bitmap = m27234c(uri);
        } else {
            bitmap = m27230b(uri);
        }
        String a = m27225a(bitmap);
        IImg2StrListener iImg2StrListener = this.f38457g;
        if (iImg2StrListener != null) {
            iImg2StrListener.onResult(a);
        }
        m27236d();
        m27232b(bitmap);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0010, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:?, code lost:
        m27232b((android.graphics.Bitmap) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        m27236d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        throw r3;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0012 */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap m27230b(android.net.Uri r3) {
        /*
            r2 = this;
            r0 = 0
            android.app.Activity r1 = r2.f38452b     // Catch:{ Exception -> 0x0012 }
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ Exception -> 0x0012 }
            java.io.InputStream r3 = r1.openInputStream(r3)     // Catch:{ Exception -> 0x0012 }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r3)     // Catch:{ Exception -> 0x0012 }
            goto L_0x0015
        L_0x0010:
            r3 = move-exception
            goto L_0x0019
        L_0x0012:
            r2.m27232b((android.graphics.Bitmap) r0)     // Catch:{ all -> 0x0010 }
        L_0x0015:
            r2.m27236d()
            return r0
        L_0x0019:
            r2.m27236d()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.webview.image.ImageHelper.m27230b(android.net.Uri):android.graphics.Bitmap");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:4|5) */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0035, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:?, code lost:
        m27232b((android.graphics.Bitmap) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003e, code lost:
        m27236d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0041, code lost:
        throw r6;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:4:0x0037 */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap m27234c(android.net.Uri r6) {
        /*
            r5 = this;
            r0 = 0
            android.graphics.BitmapFactory$Options r1 = new android.graphics.BitmapFactory$Options     // Catch:{ Exception -> 0x0037 }
            r1.<init>()     // Catch:{ Exception -> 0x0037 }
            r2 = 1
            r1.inJustDecodeBounds = r2     // Catch:{ Exception -> 0x0037 }
            android.app.Activity r2 = r5.f38452b     // Catch:{ Exception -> 0x0037 }
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ Exception -> 0x0037 }
            java.io.InputStream r2 = r2.openInputStream(r6)     // Catch:{ Exception -> 0x0037 }
            android.graphics.BitmapFactory.decodeStream(r2, r0, r1)     // Catch:{ Exception -> 0x0037 }
            r2 = -1
            int r3 = r5.f38454d     // Catch:{ Exception -> 0x0037 }
            int r4 = r5.f38453c     // Catch:{ Exception -> 0x0037 }
            int r3 = r3 * r4
            int r2 = r5.m27224a(r1, r2, r3)     // Catch:{ Exception -> 0x0037 }
            r1.inSampleSize = r2     // Catch:{ Exception -> 0x0037 }
            r2 = 0
            r1.inJustDecodeBounds = r2     // Catch:{ Exception -> 0x0037 }
            android.app.Activity r2 = r5.f38452b     // Catch:{ Exception -> 0x0037 }
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ Exception -> 0x0037 }
            java.io.InputStream r6 = r2.openInputStream(r6)     // Catch:{ Exception -> 0x0037 }
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeStream(r6, r0, r1)     // Catch:{ Exception -> 0x0037 }
            goto L_0x003a
        L_0x0035:
            r6 = move-exception
            goto L_0x003e
        L_0x0037:
            r5.m27232b((android.graphics.Bitmap) r0)     // Catch:{ all -> 0x0035 }
        L_0x003a:
            r5.m27236d()
            return r0
        L_0x003e:
            r5.m27236d()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.webview.image.ImageHelper.m27234c(android.net.Uri):android.graphics.Bitmap");
    }

    /* renamed from: a */
    private String m27225a(Bitmap bitmap) {
        if (bitmap == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, this.f38455e, byteArrayOutputStream);
        return encodeByBase64(byteArrayOutputStream.toByteArray());
    }

    public String encodeByBase64(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            try {
                return Base64.encodeToString(bArr, 2);
            } catch (Exception unused) {
            }
        }
        return "";
    }

    /* renamed from: b */
    private void m27232b(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
    }

    /* renamed from: d */
    private void m27236d() {
        FileUtil.deleteFile(this.f38458h);
        this.f38458h = null;
    }

    /* renamed from: a */
    private int m27224a(BitmapFactory.Options options, int i, int i2) {
        int b = m27229b(options, i, i2);
        if (b > 8) {
            return ((b + 7) / 8) * 8;
        }
        int i3 = 1;
        while (i3 < b) {
            i3 <<= 1;
        }
        return i3;
    }

    /* renamed from: b */
    private int m27229b(BitmapFactory.Options options, int i, int i2) {
        int i3;
        int i4;
        double d = (double) options.outWidth;
        double d2 = (double) options.outHeight;
        if (i2 == -1) {
            i3 = 1;
        } else {
            i3 = (int) Math.ceil(Math.sqrt((d * d2) / ((double) i2)));
        }
        if (i == -1) {
            i4 = 128;
        } else {
            double d3 = (double) i;
            i4 = (int) Math.min(Math.floor(d / d3), Math.floor(d2 / d3));
        }
        if (i4 < i3) {
            return i3;
        }
        if (i2 == -1 && i == -1) {
            return 1;
        }
        return i == -1 ? i3 : i4;
    }
}
