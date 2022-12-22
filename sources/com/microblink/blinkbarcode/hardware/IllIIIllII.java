package com.microblink.blinkbarcode.hardware;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import com.microblink.blinkbarcode.secured.IlIIIIIlll;
import com.microblink.blinkbarcode.util.Log;
import java.io.BufferedReader;
import java.io.File;
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
public class IllIIIllII {
    private static volatile IllIIIllII IllIIIIllI;
    private static int IllIIIllII;
    public static final /* synthetic */ int lIlIIIIlIl = 0;
    private static int llIIIlllll;
    private Context IlIllIlIIl;
    private Map<String, llIIlIlIIl> llIIlIlIIl;

    static {
        Class<IllIIIllII> cls = IllIIIllII.class;
        try {
            File[] listFiles = new File("/sys/devices/system/cpu/").listFiles(new IlIllIlIIl());
            IllIIIllII = listFiles.length;
            llIIIlllll = -1;
            for (File file : listFiles) {
                String str = file.getAbsolutePath() + "/cpufreq/cpuinfo_max_freq";
                Log.m40227d(cls, "Examining file {}", str);
                int IlIllIlIIl2 = IlIllIlIIl(str);
                if (IlIllIlIIl2 > llIIIlllll) {
                    llIIIlllll = IlIllIlIIl2;
                }
            }
            int i = llIIIlllll;
            if (i != -1) {
                llIIIlllll = Math.round(((float) i) / 1000.0f);
            }
            Log.m40231i(cls, "Calculated max CPU frequency: {} MHz", Integer.valueOf(llIIIlllll));
        } catch (Exception unused) {
            IllIIIllII = Runtime.getRuntime().availableProcessors();
            llIIIlllll = -1;
        }
    }

    private IllIIIllII(Context context, String str) {
        this.IlIllIlIIl = context;
        try {
            JSONObject jSONObject = new JSONObject(llIIlIlIIl(str));
            JSONArray names = jSONObject.names();
            this.llIIlIlIIl = new HashMap(names.length());
            for (int i = 0; i < names.length(); i++) {
                String string = names.getString(i);
                llIIlIlIIl lliililiil = new llIIlIlIIl(jSONObject.getJSONObject(string), string);
                String[] split = string.split(",");
                if (split.length > 1) {
                    for (String put : split) {
                        this.llIIlIlIIl.put(put, lliililiil);
                    }
                } else {
                    this.llIIlIlIIl.put(string, lliililiil);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to parse assets/microblink/device_list.json. Please make sure JSON syntax is correct!", e);
        }
    }

    public static String IIlIIIllIl() {
        return Build.MANUFACTURER;
    }

    public static String IlIllIlIIl() {
        return Build.VERSION.RELEASE;
    }

    public static int IlIllIlllI() {
        return IllIIIllII;
    }

    public static String IllIIIIllI() {
        return Build.DEVICE;
    }

    public static int lIIIIIllll() {
        return llIIIlllll;
    }

    private llIIlIlIIl lIlIIIIlIl() {
        return this.llIIlIlIIl.get(new llIIlIlIIl(Build.DEVICE, Build.MODEL).IllIIlIIII());
    }

    public static IllIIIllII llIIlIIlll() {
        if (IllIIIIllI != null) {
            return IllIIIIllI;
        }
        throw new IllegalStateException("DeviceManager.setup wasn't called and DeviceManager instance is null.");
    }

    public static void llIIlIlIIl(Context context, String str) {
        if (IllIIIIllI == null) {
            IllIIIIllI = new IllIIIllII(context.getApplicationContext(), str);
        }
    }

    public static String lllIIIlIlI() {
        return Build.MODEL;
    }

    public boolean IlIIlllIIl() {
        llIIlIlIIl lIlIIIIlIl2 = lIlIIIIlIl();
        if (lIlIIIIlIl2 == null) {
            return false;
        }
        return llIIlIlIIl(lIlIIIIlIl2.IllIIIllII());
    }

    public boolean IlIlllllII() {
        llIIlIlIIl lIlIIIIlIl2 = lIlIIIIlIl();
        if (lIlIIIIlIl2 == null) {
            return false;
        }
        return llIIlIlIIl(lIlIIIIlIl2.IIlIIIllIl());
    }

    public int IllIIIllII() {
        llIIlIlIIl lIlIIIIlIl2 = lIlIIIIlIl();
        if (lIlIIIIlIl2 == null) {
            return -1;
        }
        return lIlIIIIlIl2.llIIlIlIIl();
    }

    public IlIIIIIlll.llIIlIlIIl IllIIlIIII() {
        llIIlIlIIl lIlIIIIlIl2 = lIlIIIIlIl();
        if (lIlIIIIlIl2 == null) {
            return null;
        }
        return lIlIIIIlIl2.lllIIIlIlI();
    }

    public boolean lIIIIIlIlI() {
        return this.llIIlIlIIl != null;
    }

    public boolean lIllIIlIIl() {
        llIIlIlIIl lIlIIIIlIl2 = lIlIIIIlIl();
        if (lIlIIIIlIl2 == null) {
            return false;
        }
        return llIIlIlIIl(lIlIIIIlIl2.lllIlIlIIl());
    }

    public boolean lIlllIlIlI() {
        llIIlIlIIl lIlIIIIlIl2 = lIlIIIIlIl();
        if (lIlIIIIlIl2 == null) {
            return true;
        }
        return !llIIlIlIIl(lIlIIIIlIl2.IlIllIlllI());
    }

    public Context llIIIlllll() {
        return this.IlIllIlIIl;
    }

    public boolean llIIlIIIll() {
        llIIlIlIIl lIlIIIIlIl2 = lIlIIIIlIl();
        if (lIlIIIIlIl2 == null) {
            return false;
        }
        return llIIlIlIIl(lIlIIIIlIl2.IlIllIlIIl());
    }

    public boolean llIllIIlll() {
        llIIlIlIIl lIlIIIIlIl2 = lIlIIIIlIl();
        if (lIlIIIIlIl2 == null) {
            return false;
        }
        return llIIlIlIIl(lIlIIIIlIl2.llIIIlllll());
    }

    public IlIIIIIlll.llIIlIlIIl lllIlIlIIl() {
        llIIlIlIIl lIlIIIIlIl2 = lIlIIIIlIl();
        if (lIlIIIIlIl2 == null) {
            return null;
        }
        return lIlIIIIlIl2.lIIIIIllll();
    }

    public boolean lllllIlIll() {
        llIIlIlIIl lIlIIIIlIl2 = lIlIIIIlIl();
        if (lIlIIIIlIl2 == null) {
            return false;
        }
        return llIIlIlIIl(lIlIIIIlIl2.lIlIIIIlIl());
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0042 A[SYNTHETIC, Splitter:B:36:0x0042] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int IlIllIlIIl(java.lang.String r8) {
        /*
            java.lang.Class<com.microblink.blinkbarcode.hardware.IllIIIllII> r0 = com.microblink.blinkbarcode.hardware.IllIIIllII.class
            r1 = -1
            r2 = 0
            r3 = 1
            r4 = 0
            java.io.RandomAccessFile r5 = new java.io.RandomAccessFile     // Catch:{ IOException -> 0x0030 }
            java.lang.String r6 = "r"
            r5.<init>(r8, r6)     // Catch:{ IOException -> 0x0030 }
            java.lang.String r4 = r5.readLine()     // Catch:{ IOException -> 0x002c, all -> 0x0029 }
            if (r4 != 0) goto L_0x0014
            goto L_0x003c
        L_0x0014:
            int r8 = java.lang.Integer.parseInt(r4)     // Catch:{ NumberFormatException -> 0x001c }
            r5.close()     // Catch:{ IOException -> 0x001b }
        L_0x001b:
            return r8
        L_0x001c:
            java.lang.String r6 = "Failed to parse CPU frequency: '{}'"
            java.lang.Object[] r7 = new java.lang.Object[r3]     // Catch:{ IOException -> 0x002c, all -> 0x0029 }
            r7[r2] = r4     // Catch:{ IOException -> 0x002c, all -> 0x0029 }
            com.microblink.blinkbarcode.util.Log.m40229e(r0, r6, r7)     // Catch:{ IOException -> 0x002c, all -> 0x0029 }
            r5.close()     // Catch:{ IOException -> 0x0028 }
        L_0x0028:
            return r1
        L_0x0029:
            r8 = move-exception
            r4 = r5
            goto L_0x0040
        L_0x002c:
            r4 = r5
            goto L_0x0030
        L_0x002e:
            r8 = move-exception
            goto L_0x0040
        L_0x0030:
            java.lang.String r5 = "Failed to open {} for reading"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ all -> 0x002e }
            r3[r2] = r8     // Catch:{ all -> 0x002e }
            com.microblink.blinkbarcode.util.Log.m40231i(r0, r5, r3)     // Catch:{ all -> 0x002e }
            if (r4 == 0) goto L_0x003f
            r5 = r4
        L_0x003c:
            r5.close()     // Catch:{ IOException -> 0x003f }
        L_0x003f:
            return r1
        L_0x0040:
            if (r4 == 0) goto L_0x0045
            r4.close()     // Catch:{ IOException -> 0x0045 }
        L_0x0045:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microblink.blinkbarcode.hardware.IllIIIllII.IlIllIlIIl(java.lang.String):int");
    }

    private String llIIlIlIIl(String str) {
        AssetManager assets = this.IlIllIlIIl.getAssets();
        InputStream inputStream = null;
        try {
            InputStream open = assets.open(str + "/device_list.json");
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
            throw new RuntimeException("Cannot load asset microblink/device_list.json. Please make sure that this asset exists!", e);
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

    public boolean llIIlIlIIl() {
        return this.IlIllIlIIl.getPackageManager().hasSystemFeature("android.hardware.camera") || this.IlIllIlIIl.getPackageManager().hasSystemFeature("android.hardware.camera.front");
    }

    public float llIIlIlIIl(float f) {
        llIIlIlIIl lIlIIIIlIl2 = lIlIIIIlIl();
        if (lIlIIIIlIl2 != null) {
            float llIIlIIlll = (float) lIlIIIIlIl2.llIIlIIlll();
            float IllIIIIllI2 = llIIlIIlll + ((((float) lIlIIIIlIl2.IllIIIIllI()) - llIIlIIlll) * f);
            Log.m40231i(this, "Adjusting zoom level from {} to {}", Float.valueOf(f), Float.valueOf(IllIIIIllI2));
            return IllIIIIllI2;
        }
        Log.m40231i(this, "Keeping zoom level at {}", Float.valueOf(f));
        return f;
    }

    private boolean llIIlIlIIl(lIlIIIIlIl liliiiilil) {
        if (liliiiilil == null) {
            return false;
        }
        try {
            return liliiiilil.llIIlIlIIl(new IllIIIIllI(Build.VERSION.RELEASE));
        } catch (Exception e) {
            Log.m40236w(this, e, "Failed to extract android version number!", new Object[0]);
            return false;
        }
    }
}
