package com.microblink.blinkbarcode.hardware;

import android.content.Context;
import android.os.Build;
import com.microblink.blinkbarcode.util.Log;
import com.microblink.blinkbarcode.view.NotSupportedReason;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: line */
public class MicroblinkDeviceManager {
    private static volatile MicroblinkDeviceManager IllIIIIllI = null;
    private static boolean llIIIlllll;
    private Context IlIllIlIIl;
    private IllIIIllII IllIIIllII = IllIIIllII.llIIlIIlll();
    private Map<String, llIIIlllll> llIIlIlIIl;

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0056, code lost:
        if (r0 != false) goto L_0x0058;
     */
    static {
        /*
            int r0 = com.microblink.blinkbarcode.hardware.IllIIIllII.lIlIIIIlIl
            java.lang.String r0 = android.os.Build.CPU_ABI
            java.lang.String r1 = "armeabi-v7a"
            boolean r0 = r0.equals(r1)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0058
            java.io.File r0 = new java.io.File
            java.lang.String r3 = "/proc/cpuinfo"
            r0.<init>(r3)
            boolean r0 = r0.exists()
            if (r0 == 0) goto L_0x004c
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0041 }
            java.io.FileReader r4 = new java.io.FileReader     // Catch:{ IOException -> 0x0041 }
            java.io.File r5 = new java.io.File     // Catch:{ IOException -> 0x0041 }
            r5.<init>(r3)     // Catch:{ IOException -> 0x0041 }
            r4.<init>(r5)     // Catch:{ IOException -> 0x0041 }
            r0.<init>(r4)     // Catch:{ IOException -> 0x0041 }
        L_0x002a:
            java.lang.String r3 = r0.readLine()     // Catch:{ IOException -> 0x0041 }
            if (r3 == 0) goto L_0x003c
            java.lang.String r4 = "neon"
            boolean r3 = r3.contains(r4)     // Catch:{ IOException -> 0x0041 }
            if (r3 == 0) goto L_0x002a
            r0.close()     // Catch:{ IOException -> 0x0041 }
            goto L_0x0055
        L_0x003c:
            r0.close()     // Catch:{ IOException -> 0x0041 }
            r0 = 0
            goto L_0x0056
        L_0x0041:
            r0 = move-exception
            java.lang.Object[] r3 = new java.lang.Object[r1]
            java.lang.Class<com.microblink.blinkbarcode.hardware.IllIIIllII> r4 = com.microblink.blinkbarcode.hardware.IllIIIllII.class
            java.lang.String r5 = "Cannot read /proc/cpuinfo to obtain whether NEON is supported. Will assume it is (and risk crash)."
            com.microblink.blinkbarcode.util.Log.m40230e(r4, r0, r5, r3)
            goto L_0x0055
        L_0x004c:
            java.lang.Object[] r0 = new java.lang.Object[r1]
            java.lang.Class<com.microblink.blinkbarcode.hardware.IllIIIllII> r3 = com.microblink.blinkbarcode.hardware.IllIIIllII.class
            java.lang.String r4 = "File /proc/cpuinfo seems to be missing. Cannot determine whether NEON is supported. Will assume it is (and risk crash)."
            com.microblink.blinkbarcode.util.Log.m40229e(r3, r4, r0)
        L_0x0055:
            r0 = 1
        L_0x0056:
            if (r0 == 0) goto L_0x0059
        L_0x0058:
            r1 = 1
        L_0x0059:
            llIIIlllll = r1
            r0 = 0
            IllIIIIllI = r0
            com.microblink.blinkbarcode.recognition.IlIllIlIIl.IllIIIllII()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microblink.blinkbarcode.hardware.MicroblinkDeviceManager.<clinit>():void");
    }

    private MicroblinkDeviceManager(Context context) {
        this.IlIllIlIIl = context;
        try {
            JSONObject jSONObject = new JSONObject(llIIlIIlll());
            JSONArray names = jSONObject.names();
            this.llIIlIlIIl = new HashMap(names.length());
            for (int i = 0; i < names.length(); i++) {
                String string = names.getString(i);
                this.llIIlIlIIl.put(string, new llIIIlllll(jSONObject.getJSONObject(string), string));
            }
            IllIIIllII.IlIllIlIIl();
            String str = Build.VERSION.RELEASE;
            IllIIIllII.IIlIIIllIl();
            String str2 = Build.MANUFACTURER;
            IllIIIllII.lllIIIlIlI();
            String str3 = Build.MODEL;
            IllIIIllII.IllIIIIllI();
            initNativeDeviceInfo(str, str2, str3, Build.DEVICE, IllIIIllII.IlIllIlllI(), IllIIIllII.lIIIIIllll(), llIIIlllll(), IllIIIIllI());
        } catch (JSONException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to parse assets/microblink/device_list_mb.json. Please make sure JSON syntax is correct!", e);
        }
    }

    private boolean IllIIIIllI() {
        llIIIlllll llIIlIlIIl2 = llIIlIlIIl();
        if (llIIlIlIIl2 == null) {
            return false;
        }
        return llIIlIlIIl(llIIlIlIIl2.llIIlIlIIl());
    }

    private static native long initNativeDeviceInfo(String str, String str2, String str3, String str4, int i, int i2, boolean z, boolean z2);

    public static boolean lIlIIIIlIl() {
        return llIIIlllll;
    }

    private boolean llIIIlllll() {
        llIIIlllll llIIlIlIIl2 = llIIlIlIIl();
        if (llIIlIlIIl2 == null) {
            return false;
        }
        return llIIlIlIIl(llIIlIlIIl2.llIIIlllll());
    }

    private String llIIlIIlll() {
        InputStream inputStream = null;
        try {
            InputStream open = this.IlIllIlIIl.getAssets().open("microblink/device_list_mb.json");
            StringWriter stringWriter = new StringWriter();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open, "UTF-8"));
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                stringWriter.write(readLine);
            }
            String obj = stringWriter.toString();
            if (open != null) {
                try {
                    open.close();
                } catch (IOException unused) {
                }
            }
            return obj;
        } catch (IOException e) {
            throw new RuntimeException("Cannot load asset microblink/device_list_mb.json. Please make sure that this asset exists!", e);
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    public static MicroblinkDeviceManager llIIlIlIIl(Context context) {
        if (IllIIIIllI == null) {
            synchronized (MicroblinkDeviceManager.class) {
                if (IllIIIIllI == null) {
                    IllIIIIllI = new MicroblinkDeviceManager(context.getApplicationContext());
                }
            }
        }
        return IllIIIIllI;
    }

    public double IlIllIlIIl() {
        llIIIlllll llIIlIlIIl2 = llIIlIlIIl();
        if (llIIlIlIIl2 != null) {
            return llIIlIlIIl2.IlIllIlIIl();
        }
        return 1.0d;
    }

    public NotSupportedReason IllIIIllII() {
        int i = IllIIIllII.lIlIIIIlIl;
        if (Build.VERSION.SDK_INT < 16) {
            return NotSupportedReason.UNSUPPORTED_ANDROID_VERSION;
        }
        if (!this.IllIIIllII.llIIlIlIIl()) {
            return NotSupportedReason.NO_CAMERA;
        }
        if (!llIIIlllll) {
            return NotSupportedReason.UNSUPPORTED_PROCESSOR_ARCHITECTURE;
        }
        return null;
    }

    private llIIIlllll llIIlIlIIl() {
        int i = IllIIIllII.lIlIIIIlIl;
        return this.llIIlIlIIl.get(new llIIIlllll(Build.DEVICE, Build.MODEL).IllIIIllII());
    }

    private boolean llIIlIlIIl(lIlIIIIlIl liliiiilil) {
        if (liliiiilil == null) {
            return false;
        }
        try {
            int i = IllIIIllII.lIlIIIIlIl;
            return liliiiilil.llIIlIlIIl(new IllIIIIllI(Build.VERSION.RELEASE));
        } catch (Exception e) {
            Log.m40236w(this, e, "Failed to extract android version number!", new Object[0]);
            return false;
        }
    }
}
