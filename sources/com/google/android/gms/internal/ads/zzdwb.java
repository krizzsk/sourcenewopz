package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public final class zzdwb {
    private final Context context;
    private final zzduv zzvx;

    public zzdwb(Context context2, zzduv zzduv) {
        this.context = context2;
        this.zzvx = zzduv;
    }

    private final void zzc(byte[] bArr, String str) {
        if (this.zzvx != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("os.arch:");
            sb.append(zzdyn.OS_ARCH.value());
            sb.append(";");
            try {
                String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get((Object) null);
                if (strArr != null) {
                    sb.append("supported_abis:");
                    sb.append(Arrays.toString(strArr));
                    sb.append(";");
                }
            } catch (IllegalAccessException | NoSuchFieldException unused) {
            }
            sb.append("CPU_ABI:");
            sb.append(Build.CPU_ABI);
            sb.append(";");
            sb.append("CPU_ABI2:");
            sb.append(Build.CPU_ABI2);
            sb.append(";");
            if (bArr != null) {
                sb.append("ELF:");
                sb.append(Arrays.toString(bArr));
                sb.append(";");
            }
            if (str != null) {
                sb.append("dbg:");
                sb.append(str);
                sb.append(";");
            }
            this.zzvx.zzg(4007, sb.toString());
        }
    }

    private final String zzazd() {
        HashSet hashSet = new HashSet(Arrays.asList(new String[]{"i686", "armv71"}));
        String value = zzdyn.OS_ARCH.value();
        if (!TextUtils.isEmpty(value) && hashSet.contains(value)) {
            return value;
        }
        try {
            String[] strArr = (String[]) Build.class.getField("SUPPORTED_ABIS").get((Object) null);
            if (strArr != null && strArr.length > 0) {
                return strArr[0];
            }
        } catch (NoSuchFieldException e) {
            zzduv zzduv = this.zzvx;
            if (zzduv != null) {
                zzduv.zza(2024, 0, (Exception) e);
            }
        } catch (IllegalAccessException e2) {
            zzduv zzduv2 = this.zzvx;
            if (zzduv2 != null) {
                zzduv2.zza(2024, 0, (Exception) e2);
            }
        }
        if (Build.CPU_ABI != null) {
            return Build.CPU_ABI;
        }
        return Build.CPU_ABI2;
    }

    private final zzgp zzaze() {
        FileInputStream fileInputStream;
        File file = new File(new File(this.context.getApplicationInfo().dataDir), "lib");
        if (!file.exists()) {
            zzduv zzduv = this.zzvx;
            if (zzduv != null) {
                zzduv.zzg(5017, "No lib/");
            }
            return zzgp.UNKNOWN;
        }
        File[] listFiles = file.listFiles(new zzeab(Pattern.compile(".*\\.so$", 2)));
        if (listFiles == null || listFiles.length == 0) {
            zzduv zzduv2 = this.zzvx;
            if (zzduv2 != null) {
                zzduv2.zzg(5017, "No .so");
            }
            return zzgp.UNKNOWN;
        }
        try {
            fileInputStream = new FileInputStream(listFiles[0]);
            byte[] bArr = new byte[20];
            if (fileInputStream.read(bArr) == 20) {
                byte[] bArr2 = {0, 0};
                if (bArr[5] == 2) {
                    zzc(bArr, (String) null);
                    zzgp zzgp = zzgp.UNSUPPORTED;
                    fileInputStream.close();
                    return zzgp;
                }
                bArr2[0] = bArr[19];
                bArr2[1] = bArr[18];
                short s = ByteBuffer.wrap(bArr2).getShort();
                if (s == 3) {
                    zzgp zzgp2 = zzgp.X86;
                    fileInputStream.close();
                    return zzgp2;
                } else if (s == 40) {
                    zzgp zzgp3 = zzgp.ARM7;
                    fileInputStream.close();
                    return zzgp3;
                } else if (s == 62) {
                    zzgp zzgp4 = zzgp.X86_64;
                    fileInputStream.close();
                    return zzgp4;
                } else if (s != 183) {
                    zzc(bArr, (String) null);
                    zzgp zzgp5 = zzgp.UNSUPPORTED;
                    fileInputStream.close();
                    return zzgp5;
                } else {
                    zzgp zzgp6 = zzgp.ARM64;
                    fileInputStream.close();
                    return zzgp6;
                }
            } else {
                fileInputStream.close();
                return zzgp.UNSUPPORTED;
            }
        } catch (IOException e) {
            zzc((byte[]) null, e.toString());
        } catch (Throwable th) {
            zzekz.zza(th, th);
        }
        throw th;
    }

    public final zzgp zzazf() {
        zzgp zzaze = zzaze();
        if (zzaze == zzgp.UNKNOWN) {
            String zzazd = zzazd();
            if (TextUtils.isEmpty(zzazd)) {
                zzc((byte[]) null, "Empty dev arch");
                zzaze = zzgp.UNSUPPORTED;
            } else if (zzazd.equalsIgnoreCase("i686") || zzazd.equalsIgnoreCase("x86")) {
                zzaze = zzgp.X86;
            } else if (zzazd.equalsIgnoreCase("x86_64")) {
                zzaze = zzgp.X86_64;
            } else if (zzazd.equalsIgnoreCase("arm64-v8a")) {
                zzaze = zzgp.ARM64;
            } else if (zzazd.equalsIgnoreCase("armeabi-v7a") || zzazd.equalsIgnoreCase("armv71")) {
                zzaze = zzgp.ARM7;
            } else {
                zzc((byte[]) null, zzazd);
                zzaze = zzgp.UNSUPPORTED;
            }
        }
        zzduv zzduv = this.zzvx;
        if (zzduv != null) {
            zzduv.zzg(5018, zzaze.name());
        }
        return zzaze;
    }

    public static boolean zza(zzgp zzgp) {
        int i = zzdwa.zzhwy[zzgp.ordinal()];
        return i == 1 || i == 2 || i == 3 || i == 4;
    }
}
