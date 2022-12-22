package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import com.didi.sdk.apm.SystemUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@19.0.0 */
final /* synthetic */ class zzhl implements zzib {
    private final Context zza;

    zzhl(Context context) {
        this.zza = context;
    }

    public final Object zza() {
        zzhz zzhz;
        zzhz zzhz2;
        BufferedReader bufferedReader;
        Throwable th;
        Context context = this.zza;
        int i = zzht.zzc;
        String str = Build.TYPE;
        String str2 = Build.TAGS;
        if ((!str.equals("eng") && !str.equals("userdebug")) || (!str2.contains("dev-keys") && !str2.contains("test-keys"))) {
            return zzhz.zzc();
        }
        if (zzgw.zza() && !context.isDeviceProtectedStorage()) {
            context = context.createDeviceProtectedStorageContext();
        }
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            StrictMode.allowThreadDiskWrites();
            File file = new File(context.getDir("phenotype_hermetic", 0), "overrides.txt");
            zzhz = file.exists() ? zzhz.zzd(file) : zzhz.zzc();
        } catch (RuntimeException e) {
            SystemUtils.log(6, "HermeticFileOverrides", "no data dir", e, "com.google.android.gms.internal.measurement.zzhl", 10);
            zzhz = zzhz.zzc();
        } catch (Throwable th2) {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            throw th2;
        }
        if (zzhz.zza()) {
            File file2 = (File) zzhz.zzb();
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file2)));
                HashMap hashMap = new HashMap();
                HashMap hashMap2 = new HashMap();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String[] split = readLine.split(" ", 3);
                    if (split.length != 3) {
                        SystemUtils.log(6, "HermeticFileOverrides", readLine.length() != 0 ? "Invalid: ".concat(readLine) : new String("Invalid: "), (Throwable) null, "com.google.android.gms.internal.measurement.zzhl", 19);
                    } else {
                        String str3 = new String(split[0]);
                        String decode = Uri.decode(new String(split[1]));
                        String str4 = (String) hashMap2.get(split[2]);
                        if (str4 == null) {
                            String str5 = new String(split[2]);
                            str4 = Uri.decode(str5);
                            if (str4.length() < 1024 || str4 == str5) {
                                hashMap2.put(str5, str4);
                            }
                        }
                        if (!hashMap.containsKey(str3)) {
                            hashMap.put(str3, new HashMap());
                        }
                        ((Map) hashMap.get(str3)).put(decode, str4);
                    }
                }
                String valueOf = String.valueOf(file2);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 7);
                sb.append("Parsed ");
                sb.append(valueOf);
                SystemUtils.log(4, "HermeticFileOverrides", sb.toString(), (Throwable) null, "com.google.android.gms.internal.measurement.zzhl", 33);
                zzhi zzhi = new zzhi(hashMap);
                bufferedReader.close();
                zzhz2 = zzhz.zzd(zzhi);
            } catch (IOException e2) {
                throw new RuntimeException(e2);
            } catch (Throwable th3) {
                zzim.zza(th, th3);
            }
        } else {
            zzhz2 = zzhz.zzc();
        }
        StrictMode.setThreadPolicy(allowThreadDiskReads);
        return zzhz2;
        throw th;
    }
}
