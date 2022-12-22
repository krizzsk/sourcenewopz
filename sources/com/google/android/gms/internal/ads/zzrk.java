package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzr;
import java.util.ArrayList;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzrk {
    private final Object lock = new Object();
    private int score;
    private final int zzbsq;
    private final int zzbsr;
    private final int zzbss;
    private final boolean zzbst;
    private final zzrz zzbsu;
    private final zzsg zzbsv;
    private ArrayList<String> zzbsw = new ArrayList<>();
    private ArrayList<String> zzbsx = new ArrayList<>();
    private ArrayList<zzrx> zzbsy = new ArrayList<>();
    private int zzbsz = 0;
    private int zzbta = 0;
    private int zzbtb = 0;
    private String zzbtc = "";
    private String zzbtd = "";
    private String zzbte = "";

    public zzrk(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z) {
        this.zzbsq = i;
        this.zzbsr = i2;
        this.zzbss = i3;
        this.zzbst = z;
        this.zzbsu = new zzrz(i4);
        this.zzbsv = new zzsg(i5, i6, i7);
    }

    public final boolean zzme() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzbtb == 0;
        }
        return z;
    }

    public final String zzmf() {
        return this.zzbtc;
    }

    public final String zzmg() {
        return this.zzbtd;
    }

    public final String zzmh() {
        return this.zzbte;
    }

    public final void zzmi() {
        synchronized (this.lock) {
            this.score -= 100;
        }
    }

    public final void zzmj() {
        synchronized (this.lock) {
            this.zzbtb--;
        }
    }

    public final void zzmk() {
        synchronized (this.lock) {
            this.zzbtb++;
        }
    }

    public final void zza(String str, boolean z, float f, float f2, float f3, float f4) {
        zzc(str, z, f, f2, f3, f4);
        synchronized (this.lock) {
            if (this.zzbtb < 0) {
                zzd.zzdz("ActivityContent: negative number of WebViews.");
            }
            zzmm();
        }
    }

    public final void zzb(String str, boolean z, float f, float f2, float f3, float f4) {
        zzc(str, z, f, f2, f3, f4);
    }

    private final void zzc(String str, boolean z, float f, float f2, float f3, float f4) {
        if (str != null && str.length() >= this.zzbss) {
            synchronized (this.lock) {
                this.zzbsw.add(str);
                this.zzbsz += str.length();
                if (z) {
                    this.zzbsx.add(str);
                    this.zzbsy.add(new zzrx(f, f2, f3, f4, this.zzbsx.size() - 1));
                }
            }
        }
    }

    public final void zzml() {
        synchronized (this.lock) {
            int zzj = zzj(this.zzbsz, this.zzbta);
            if (zzj > this.score) {
                this.score = zzj;
            }
        }
    }

    public final void zzmm() {
        synchronized (this.lock) {
            int zzj = zzj(this.zzbsz, this.zzbta);
            if (zzj > this.score) {
                this.score = zzj;
                if (!zzr.zzkz().zzyl().zzzb()) {
                    this.zzbtc = this.zzbsu.zza(this.zzbsw);
                    this.zzbtd = this.zzbsu.zza(this.zzbsx);
                }
                if (!zzr.zzkz().zzyl().zzzd()) {
                    this.zzbte = this.zzbsv.zza(this.zzbsx, this.zzbsy);
                }
            }
        }
    }

    private final int zzj(int i, int i2) {
        if (this.zzbst) {
            return this.zzbsr;
        }
        return (i * this.zzbsq) + (i2 * this.zzbsr);
    }

    public final int getScore() {
        return this.score;
    }

    public final void zzbw(int i) {
        this.zzbta = i;
    }

    private static String zza(ArrayList<String> arrayList, int i) {
        if (arrayList.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList2.get(i2);
            i2++;
            sb.append((String) obj);
            sb.append(' ');
            if (sb.length() > 100) {
                break;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        String sb2 = sb.toString();
        if (sb2.length() < 100) {
            return sb2;
        }
        return sb2.substring(0, 100);
    }

    public final String toString() {
        int i = this.zzbta;
        int i2 = this.score;
        int i3 = this.zzbsz;
        String zza = zza(this.zzbsw, 100);
        String zza2 = zza(this.zzbsx, 100);
        String str = this.zzbtc;
        String str2 = this.zzbtd;
        String str3 = this.zzbte;
        StringBuilder sb = new StringBuilder(String.valueOf(zza).length() + 165 + String.valueOf(zza2).length() + String.valueOf(str).length() + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append("ActivityContent fetchId: ");
        sb.append(i);
        sb.append(" score:");
        sb.append(i2);
        sb.append(" total_length:");
        sb.append(i3);
        sb.append("\n text: ");
        sb.append(zza);
        sb.append("\n viewableText");
        sb.append(zza2);
        sb.append("\n signture: ");
        sb.append(str);
        sb.append("\n viewableSignture: ");
        sb.append(str2);
        sb.append("\n viewableSignatureForVertical: ");
        sb.append(str3);
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public final int zzmn() {
        return this.zzbsz;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzrk)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        String str = ((zzrk) obj).zzbtc;
        return str != null && str.equals(this.zzbtc);
    }

    public final int hashCode() {
        return this.zzbtc.hashCode();
    }
}
