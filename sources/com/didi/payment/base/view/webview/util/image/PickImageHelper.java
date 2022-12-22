package com.didi.payment.base.view.webview.util.image;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import androidx.fragment.app.FragmentActivity;
import com.didi.dimina.starbox.module.jsbridge.InputModalSubJSBridge;
import com.didi.dimina.starbox.util.FileUtil;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.hawaii.mapsdk.gesture.NNGestureClassfy;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.payment.base.utils.ktx.ActivityKtxKt;
import com.didi.payment.utilities.scan.collect.CollectionConstant;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.webview.image.PicUploadActivity;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import com.yanzhenjie.permission.runtime.Permission;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(mo175977d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u001a\u0010\u0011\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0002J\"\u0010\u001a\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001cH\u0002J\"\u0010 \u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0010\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\u0017H\u0002J\b\u0010!\u001a\u00020\u001eH\u0002J\b\u0010\"\u001a\u00020\u001eH\u0002J\u0006\u0010#\u001a\u00020\u001eJ\b\u0010$\u001a\u00020\u001eH\u0002J\u0014\u0010%\u001a\u00020\u001e2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'H\u0002J\b\u0010(\u001a\u00020\u001eH\u0002J\"\u0010)\u001a\u00020\u001e2\u0006\u0010*\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\b\u0010+\u001a\u0004\u0018\u00010\nH\u0002J \u0010,\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020/H\u0002J\b\u00100\u001a\u00020\u001eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0004¢\u0006\u0002\n\u0000¨\u00061"}, mo175978d2 = {"Lcom/didi/payment/base/view/webview/util/image/PickImageHelper;", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "params", "Lorg/json/JSONObject;", "callback", "Lcom/didi/onehybrid/jsbridge/CallbackFunction;", "(Landroidx/fragment/app/FragmentActivity;Lorg/json/JSONObject;Lcom/didi/onehybrid/jsbridge/CallbackFunction;)V", "editable", "", "kotlin.jvm.PlatformType", "height", "imageType", "quality", "source", "width", "bitmapToBase64", "b", "Landroid/graphics/Bitmap;", "options", "Landroid/graphics/BitmapFactory$Options;", "calculateInSampleSize", "", "targetWidth", "targetHeight", "decodeSampledBitmap", "imageUri", "Landroid/net/Uri;", "dispatchCropImage", "", "uri", "dispatchResultFile", "dispatchSelectFromAlbum", "dispatchTakePhoto", "execute", "onResultCancel", "onResultException", "e", "", "onResultPermissionDenied", "onResultSuccess", "base64", "lastModifyTime", "rotateBitmap", "rotation", "recycle", "", "showSelectImageDialog", "base_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PickImageHelper.kt */
public final class PickImageHelper {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final FragmentActivity f30094a;

    /* renamed from: b */
    private final JSONObject f30095b;

    /* renamed from: c */
    private final CallbackFunction f30096c;

    /* renamed from: d */
    private final String f30097d;

    /* renamed from: e */
    private final String f30098e = this.f30095b.optString(InputModalSubJSBridge.MODAL_PARAM_EDITABLE, "0");

    /* renamed from: f */
    private String f30099f = this.f30095b.optString(CollectionConstant.APOLLO_PARAM_QUALITY, "100");

    /* renamed from: g */
    private final String f30100g = this.f30095b.optString("width", "-1");

    /* renamed from: h */
    private final String f30101h = this.f30095b.optString("height", "-1");

    /* renamed from: i */
    private String f30102i = "";

    public PickImageHelper(FragmentActivity fragmentActivity, JSONObject jSONObject, CallbackFunction callbackFunction) {
        Intrinsics.checkNotNullParameter(fragmentActivity, "activity");
        Intrinsics.checkNotNullParameter(jSONObject, "params");
        this.f30094a = fragmentActivity;
        this.f30095b = jSONObject;
        this.f30096c = callbackFunction;
        this.f30097d = jSONObject.optString("source", "3");
    }

    public final void execute() {
        String str = this.f30097d;
        if (Intrinsics.areEqual((Object) str, (Object) "1")) {
            m21087b();
        } else if (Intrinsics.areEqual((Object) str, (Object) "2")) {
            m21080a();
        } else {
            m21088c();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m21080a() {
        ActivityKtxKt.requestPermissions(this.f30094a, new String[]{Permission.CAMERA}, (Function1<? super String[], Unit>) new PickImageHelper$dispatchTakePhoto$1(this), (Function0<Unit>) new PickImageHelper$dispatchTakePhoto$2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m21087b() {
        ActivityKtxKt.requestPermissions(this.f30094a, new String[]{Permission.READ_EXTERNAL_STORAGE, Permission.WRITE_EXTERNAL_STORAGE}, (Function1<? super String[], Unit>) new PickImageHelper$dispatchSelectFromAlbum$1(this), (Function0<Unit>) new PickImageHelper$dispatchSelectFromAlbum$2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m21081a(Uri uri) {
        String str = this.f30100g;
        Intrinsics.checkNotNullExpressionValue(str, "width");
        int parseInt = Integer.parseInt(str);
        String str2 = this.f30101h;
        Intrinsics.checkNotNullExpressionValue(str2, "height");
        int parseInt2 = Integer.parseInt(str2);
        if (!TextUtils.equals("1", this.f30098e)) {
            m21082a(uri, parseInt, parseInt2);
        } else if (parseInt <= 0 || parseInt2 <= 0) {
            Intent intent = new Intent("com.android.camera.action.CROP");
            intent.setDataAndType(uri, PicUploadActivity.IMAGE_UNSPECIFIED);
            intent.addFlags(1);
            File photoOutputFile = ImageFileConfig.getPhotoOutputFile(this.f30094a.getApplicationContext());
            if (!photoOutputFile.exists()) {
                try {
                    photoOutputFile.createNewFile();
                } catch (Throwable th) {
                    m21085a(th);
                    return;
                }
            }
            intent.putExtra("crop", "true");
            intent.putExtra(NNGestureClassfy.SCALE_LABLE, true);
            intent.putExtra("return-data", false);
            intent.putExtra("output", Uri.fromFile(photoOutputFile));
            intent.putExtra("noFaceDetection", true);
            if (intent.resolveActivity(this.f30094a.getPackageManager()) != null) {
                ActivityKtxKt.startActivityForResult(this.f30094a, intent, new PickImageHelper$dispatchCropImage$2(photoOutputFile, this));
            } else {
                m21083a(this, (Throwable) null, 1, (Object) null);
            }
        } else {
            ((Request) ((Request) ((Request) ((Request) DRouter.build("99pay://one/cropImage").putExtra("width", parseInt)).putExtra("height", parseInt2)).putExtra("input", (Parcelable) uri)).putExtra("output", ImageFileConfig.getPhotoOutputFile(this.f30094a.getApplicationContext()).getAbsolutePath())).start(this.f30094a, new PickImageHelper$dispatchCropImage$1(this, parseInt, parseInt2));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0050 A[Catch:{ Exception -> 0x008f }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m21082a(android.net.Uri r5, int r6, int r7) {
        /*
            r4 = this;
            if (r5 != 0) goto L_0x0006
            r4.m21089d()
            return
        L_0x0006:
            java.lang.String r6 = r4.m21086b(r5, r6, r7)
            r7 = r6
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r0 = 0
            r1 = 1
            if (r7 == 0) goto L_0x001a
            int r7 = r7.length()
            if (r7 != 0) goto L_0x0018
            goto L_0x001a
        L_0x0018:
            r7 = 0
            goto L_0x001b
        L_0x001a:
            r7 = 1
        L_0x001b:
            if (r7 == 0) goto L_0x0021
            r4.m21089d()
            return
        L_0x0021:
            r7 = 0
            androidx.fragment.app.FragmentActivity r2 = r4.f30094a     // Catch:{ Exception -> 0x008f }
            android.content.ContentResolver r2 = r2.getContentResolver()     // Catch:{ Exception -> 0x008f }
            java.io.InputStream r2 = r2.openInputStream(r5)     // Catch:{ Exception -> 0x008f }
            if (r2 != 0) goto L_0x0030
            r3 = r7
            goto L_0x0035
        L_0x0030:
            androidx.exifinterface.media.ExifInterface r3 = new androidx.exifinterface.media.ExifInterface     // Catch:{ Exception -> 0x008f }
            r3.<init>((java.io.InputStream) r2)     // Catch:{ Exception -> 0x008f }
        L_0x0035:
            if (r3 != 0) goto L_0x0039
            r2 = r7
            goto L_0x003f
        L_0x0039:
            java.lang.String r2 = "DateTime"
            java.lang.String r2 = r3.getAttribute(r2)     // Catch:{ Exception -> 0x008f }
        L_0x003f:
            r3 = r2
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x008f }
            if (r3 == 0) goto L_0x004d
            int r3 = r3.length()     // Catch:{ Exception -> 0x008f }
            if (r3 != 0) goto L_0x004b
            goto L_0x004d
        L_0x004b:
            r3 = 0
            goto L_0x004e
        L_0x004d:
            r3 = 1
        L_0x004e:
            if (r3 == 0) goto L_0x008e
            androidx.fragment.app.FragmentActivity r3 = r4.f30094a     // Catch:{ Exception -> 0x008f }
            android.content.Context r3 = (android.content.Context) r3     // Catch:{ Exception -> 0x008f }
            java.lang.String r5 = com.didi.sdk.util.FileUtil.getFilePath(r3, r5)     // Catch:{ Exception -> 0x008f }
            java.lang.String r3 = "path"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r3)     // Catch:{ Exception -> 0x008f }
            r3 = r5
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ Exception -> 0x008f }
            int r3 = r3.length()     // Catch:{ Exception -> 0x008f }
            if (r3 <= 0) goto L_0x0067
            r0 = 1
        L_0x0067:
            if (r0 == 0) goto L_0x008e
            java.io.File r0 = new java.io.File     // Catch:{ Exception -> 0x008f }
            r0.<init>(r5)     // Catch:{ Exception -> 0x008f }
            boolean r5 = r0.exists()     // Catch:{ Exception -> 0x008f }
            if (r5 == 0) goto L_0x008e
            java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat     // Catch:{ Exception -> 0x008f }
            java.lang.String r1 = "yyyy:MM:dd HH:mm:ss"
            java.util.Locale r2 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x008f }
            r5.<init>(r1, r2)     // Catch:{ Exception -> 0x008f }
            java.util.Date r1 = new java.util.Date     // Catch:{ Exception -> 0x008f }
            long r2 = r0.lastModified()     // Catch:{ Exception -> 0x008f }
            r1.<init>(r2)     // Catch:{ Exception -> 0x008f }
            java.lang.String r5 = r5.format(r1)     // Catch:{ Exception -> 0x008f }
            r7 = r5
            goto L_0x008f
        L_0x008e:
            r7 = r2
        L_0x008f:
            java.lang.String r5 = ""
            r4.m21084a((java.lang.String) r6, (java.lang.String) r5, (java.lang.String) r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.base.view.webview.util.image.PickImageHelper.m21082a(android.net.Uri, int, int):void");
    }

    /* renamed from: c */
    private final void m21088c() {
        SelectImageBottomDialog selectImageBottomDialog = new SelectImageBottomDialog();
        selectImageBottomDialog.setOnAlbumClick(new PickImageHelper$showSelectImageDialog$dialog$1$1(this));
        selectImageBottomDialog.setOnCameraClick(new PickImageHelper$showSelectImageDialog$dialog$1$2(this));
        selectImageBottomDialog.show(this.f30094a.getSupportFragmentManager(), "select_image_dialog");
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0024 A[Catch:{ all -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x002d A[Catch:{ all -> 0x0035 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002e A[Catch:{ all -> 0x0035 }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m21084a(java.lang.String r3, java.lang.String r4, java.lang.String r5) {
        /*
            r2 = this;
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            java.lang.String r0 = "errorCode"
            r1 = 104(0x68, float:1.46E-43)
            r4.put(r0, r1)     // Catch:{ all -> 0x0035 }
            java.lang.String r0 = "imageBase64String"
            r4.put(r0, r3)     // Catch:{ all -> 0x0035 }
            r3 = r5
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x0035 }
            r0 = 0
            r1 = 1
            if (r3 == 0) goto L_0x0021
            int r3 = r3.length()     // Catch:{ all -> 0x0035 }
            if (r3 != 0) goto L_0x001f
            goto L_0x0021
        L_0x001f:
            r3 = 0
            goto L_0x0022
        L_0x0021:
            r3 = 1
        L_0x0022:
            if (r3 != 0) goto L_0x0029
            java.lang.String r3 = "createTimeStamp"
            r4.put(r3, r5)     // Catch:{ all -> 0x0035 }
        L_0x0029:
            com.didi.onehybrid.jsbridge.CallbackFunction r3 = r2.f30096c     // Catch:{ all -> 0x0035 }
            if (r3 != 0) goto L_0x002e
            goto L_0x0035
        L_0x002e:
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ all -> 0x0035 }
            r5[r0] = r4     // Catch:{ all -> 0x0035 }
            r3.onCallBack(r5)     // Catch:{ all -> 0x0035 }
        L_0x0035:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.base.view.webview.util.image.PickImageHelper.m21084a(java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public final void m21089d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.ERROR_CODE, 103);
            jSONObject.put("imageBase64String", "");
            jSONObject.put("createTimeStamp", "");
            CallbackFunction callbackFunction = this.f30096c;
            if (callbackFunction != null) {
                callbackFunction.onCallBack(jSONObject);
            }
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public final void m21090e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.ERROR_CODE, 101);
            jSONObject.put("imageBase64String", "");
            jSONObject.put("createTimeStamp", "");
            CallbackFunction callbackFunction = this.f30096c;
            if (callbackFunction != null) {
                callbackFunction.onCallBack(jSONObject);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m21083a(PickImageHelper pickImageHelper, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        pickImageHelper.m21085a(th);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m21085a(Throwable th) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(Constants.ERROR_CODE, 100);
            jSONObject.put("imageBase64String", "");
            jSONObject.put("createTimeStamp", "");
            CallbackFunction callbackFunction = this.f30096c;
            if (callbackFunction != null) {
                callbackFunction.onCallBack(jSONObject);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    private final String m21086b(Uri uri, int i, int i2) throws FileNotFoundException {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(this.f30094a.getContentResolver().openInputStream(uri), (Rect) null, options);
            options.inSampleSize = m21077a(options, i, i2);
            options.inJustDecodeBounds = false;
            Bitmap decodeStream = BitmapFactory.decodeStream(this.f30094a.getContentResolver().openInputStream(uri), (Rect) null, options);
            if (decodeStream == null) {
                return null;
            }
            int exifOrientation = ExifUtils.getExifOrientation(this.f30094a, uri);
            if (exifOrientation != 0) {
                decodeStream = m21078a(decodeStream, exifOrientation, true);
            }
            return m21079a(decodeStream, options);
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: a */
    private final int m21077a(BitmapFactory.Options options, int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 1;
        }
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        if (i3 <= i2 && i4 <= i) {
            return 1;
        }
        int roundToInt = MathKt.roundToInt(((float) i3) / ((float) i2));
        int roundToInt2 = MathKt.roundToInt(((float) i4) / ((float) i));
        if (roundToInt >= roundToInt2) {
            roundToInt = roundToInt2;
        }
        return roundToInt;
    }

    /* renamed from: a */
    private final Bitmap m21078a(Bitmap bitmap, int i, boolean z) {
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
        Intrinsics.checkNotNullExpressionValue(createBitmap, "{\n            val w = so…         bitmap\n        }");
        return createBitmap;
    }

    /* renamed from: a */
    private final String m21079a(Bitmap bitmap, BitmapFactory.Options options) {
        String str;
        try {
            if (TextUtil.isEmpty(this.f30099f)) {
                this.f30099f = "75";
            }
            String str2 = this.f30099f;
            Intrinsics.checkNotNullExpressionValue(str2, CollectionConstant.APOLLO_PARAM_QUALITY);
            int parseInt = Integer.parseInt(str2);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            if (!TextUtil.isEmpty(this.f30102i) && StringsKt.contains$default((CharSequence) this.f30102i, (CharSequence) "jpeg", false, 2, (Object) null)) {
                bitmap.compress(Bitmap.CompressFormat.JPEG, parseInt, byteArrayOutputStream);
                this.f30102i = FileUtil.JPG;
            } else if (TextUtil.isEmpty(this.f30102i) || !StringsKt.contains$default((CharSequence) this.f30102i, (CharSequence) "png", false, 2, (Object) null)) {
                bitmap.compress(Bitmap.CompressFormat.JPEG, parseInt, byteArrayOutputStream);
                String str3 = options.outMimeType;
                if (!TextUtil.isEmpty(str3)) {
                    Intrinsics.checkNotNullExpressionValue(str3, "mimeType");
                    if (StringsKt.contains$default((CharSequence) str3, (CharSequence) "/", false, 2, (Object) null)) {
                        Object[] array = new Regex("/").split(str3, 0).toArray(new String[0]);
                        if (array != null) {
                            str = ((String[]) array)[1];
                            this.f30102i = str;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                        }
                    }
                }
                str = "";
                this.f30102i = str;
            } else {
                this.f30102i = "png";
                bitmap.compress(Bitmap.CompressFormat.PNG, parseInt, byteArrayOutputStream);
            }
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
            return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 4);
        } catch (Throwable unused) {
            return "";
        }
    }
}
