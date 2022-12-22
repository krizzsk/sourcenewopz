package com.megvii.livenessdetection.obf;

import android.graphics.Rect;
import android.os.Build;
import com.megvii.livenessdetection.bean.FaceInfo;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.megvii.livenessdetection.obf.b */
public class C20343b {

    /* renamed from: a */
    private float[] f55798a = new float[5];

    /* renamed from: b */
    private int f55799b = 0;

    /* renamed from: c */
    private boolean f55800c = false;

    /* renamed from: a */
    public static String m40204a(byte[] bArr) {
        try {
            MessageDigest instance = MessageDigest.getInstance("SHA");
            instance.update(bArr);
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() == 2) {
                    sb.append(hexString);
                } else {
                    sb.append("0");
                    sb.append(hexString);
                }
            }
            return sb.toString().toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static JSONObject m40205a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version", Build.VERSION.SDK_INT);
            jSONObject.put("release", Build.VERSION.RELEASE);
            jSONObject.put("model", Build.MODEL);
            jSONObject.put("brand", Build.BRAND);
            jSONObject.put("manufacturer", Build.MANUFACTURER);
            jSONObject.put("arch", Build.CPU_ABI);
            jSONObject.put("fingerprint", Build.FINGERPRINT);
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    /* renamed from: a */
    private static void m40206a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: a */
    public static byte[] m40207a(String str) {
        FileInputStream fileInputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str);
            while (true) {
                try {
                    int read = fileInputStream.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        byteArrayOutputStream.close();
                        m40206a((InputStream) fileInputStream);
                        return byteArrayOutputStream.toByteArray();
                    }
                } catch (IOException unused) {
                    m40206a((InputStream) fileInputStream);
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    m40206a((InputStream) fileInputStream2);
                    throw th;
                }
            }
        } catch (IOException unused2) {
            fileInputStream = null;
            m40206a((InputStream) fileInputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            m40206a((InputStream) fileInputStream2);
            throw th;
        }
    }

    /* renamed from: b */
    public static boolean m40208b(String str) {
        if (str == null) {
            return false;
        }
        try {
            System.load(str);
            return true;
        } catch (UnsatisfiedLinkError unused) {
            C20346d.m40222b("load dynamic library failed, please check library path");
            return false;
        }
    }

    /* renamed from: a */
    public static String m40203a(Rect rect) {
        return "242 " + rect.left + "," + rect.top + "," + rect.right + "," + rect.bottom;
    }

    /* renamed from: a */
    public synchronized void mo165089a(boolean z) {
        this.f55800c = true;
        for (int i = 0; i < 5; i++) {
            this.f55798a[i] = 0.0f;
        }
        this.f55799b = 0;
    }

    /* renamed from: a */
    public void mo165088a(FaceInfo faceInfo) {
        if (faceInfo == null) {
            if (this.f55800c) {
                float[] fArr = this.f55798a;
                int i = this.f55799b;
                this.f55799b = i + 1;
                fArr[i % 5] = 0.0f;
            }
        } else if (this.f55800c) {
            float[] fArr2 = this.f55798a;
            int i2 = this.f55799b;
            this.f55799b = i2 + 1;
            fArr2[i2 % 5] = faceInfo.faceQuality;
            float f = 100.0f;
            for (float f2 : this.f55798a) {
                if (f2 < f) {
                    f = f2;
                }
            }
            faceInfo.smoothQuality = f;
        } else {
            faceInfo.smoothQuality = faceInfo.faceQuality;
        }
    }
}
