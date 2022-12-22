package com.didichuxing.diface.utils;

import android.content.Context;
import android.graphics.Bitmap;
import com.didi.beatles.p099im.picture.config.IMPictureMimeType;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.diface.biz.bioassay.fpp.p182M.compare.CompareParam;
import com.didichuxing.sdk.alphaface.core.liveness.ILivenessCallback;
import com.google.common.base.Ascii;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DFileUtils {

    /* renamed from: e */
    private static final String f47527e = "image_best";

    /* renamed from: f */
    private static final String f47528f = "image_env";

    /* renamed from: g */
    private static final String f47529g = "image_action";

    /* renamed from: a */
    private String f47530a;

    /* renamed from: b */
    private String f47531b;

    /* renamed from: c */
    private List<String> f47532c;

    /* renamed from: d */
    private String f47533d;

    /* renamed from: h */
    private Context f47534h;

    public DFileUtils(Context context) {
        this.f47534h = context;
    }

    public boolean saveValidFrames(Map<String, byte[]> map, int i) {
        boolean z;
        this.f47533d = DTimeUtils.getFormatterTime(System.currentTimeMillis());
        if (i == CompareParam.FACE_PLUS_UPLOAD_BEST) {
            z = true;
        } else {
            int i2 = CompareParam.FACE_PLUS_UPLOAD_ALL;
            z = false;
        }
        try {
            File file = new File(getFileDirPath(this.f47534h));
            if (!file.exists()) {
                file.mkdirs();
            }
            this.f47530a = this.f47533d + "-best.png";
            saveFile(map.get(f47527e), this.f47530a, file);
            this.f47531b = this.f47533d + "-env.png";
            saveFile(map.get(f47528f), this.f47531b, file);
            if (!z) {
                this.f47532c = new ArrayList();
                int i3 = 1;
                for (String next : map.keySet()) {
                    if (next.contains(f47529g)) {
                        String str = this.f47533d + "_" + i3 + IMPictureMimeType.PNG;
                        this.f47532c.add(str);
                        saveFile(map.get(next), str, file);
                        i3++;
                    }
                }
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void saveFile(byte[] bArr, String str, File file) {
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(file, str));
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public boolean removeLocalImage(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return deleteDir(file);
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public String getFpBestImagePath() {
        return this.f47530a;
    }

    public String getFpEnvImagePath() {
        return this.f47531b;
    }

    public List<String> getAllFramesImagePaths() {
        return this.f47532c;
    }

    public static boolean deleteDir(File file) {
        if (file.isDirectory()) {
            String[] list = file.list();
            for (String file2 : list) {
                if (!deleteDir(new File(file, file2))) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    public static String getFileDirPath(Context context) {
        return context.getFilesDir().getAbsolutePath() + File.separator + "diface";
    }

    public static void delFiles(List<File> list) {
        boolean z = true;
        for (File delete : list) {
            z &= delete.delete();
        }
        LogUtils.m33563d("del files ok=" + z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0028 A[SYNTHETIC, Splitter:B:15:0x0028] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] compressBitmap(int r2, int r3, byte[] r4) {
        /*
            r0 = 0
            android.graphics.Bitmap r2 = bitmapFromRgba(r2, r3, r4)     // Catch:{ all -> 0x0021 }
            java.io.ByteArrayOutputStream r3 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0021 }
            r3.<init>()     // Catch:{ all -> 0x0021 }
            android.graphics.Bitmap$CompressFormat r4 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ all -> 0x001f }
            r1 = 75
            r2.compress(r4, r1, r3)     // Catch:{ all -> 0x001f }
            r2.recycle()     // Catch:{ all -> 0x001f }
            byte[] r2 = r3.toByteArray()     // Catch:{ all -> 0x001f }
            r3.close()     // Catch:{ all -> 0x001f }
            r3.close()     // Catch:{ all -> 0x001e }
        L_0x001e:
            return r2
        L_0x001f:
            r2 = move-exception
            goto L_0x0023
        L_0x0021:
            r2 = move-exception
            r3 = r0
        L_0x0023:
            r2.printStackTrace()     // Catch:{ all -> 0x002c }
            if (r3 == 0) goto L_0x002b
            r3.close()     // Catch:{ all -> 0x002b }
        L_0x002b:
            return r0
        L_0x002c:
            r2 = move-exception
            if (r3 == 0) goto L_0x0032
            r3.close()     // Catch:{ all -> 0x0032 }
        L_0x0032:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.diface.utils.DFileUtils.compressBitmap(int, int, byte[]):byte[]");
    }

    public static Bitmap bitmapFromRgba(int i, int i2, byte[] bArr) {
        int length = bArr.length / 4;
        int[] iArr = new int[length];
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            int i5 = i4 + 1;
            int i6 = i5 + 1;
            int i7 = i6 + 1;
            iArr[i3] = ((bArr[i4] & 255) << 16) | ((bArr[i7] & 255) << Ascii.CAN) | ((bArr[i5] & 255) << 8) | (bArr[i6] & 255);
            i3++;
            i4 = i7 + 1;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, i, 0, 0, i, i2);
        return createBitmap;
    }

    public static String sourceToMD5(List<ILivenessCallback.PicWithScore> list) {
        String str = "";
        if (list == null) {
            return str;
        }
        int size = list.size();
        int i = 0;
        while (i < size) {
            str = str + FileUtils.byteToMD5(list.get(i).rgba);
            i++;
            if (i < size) {
                str = str + ParamKeys.SIGN_AND;
            }
        }
        return str;
    }
}
