package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public abstract class zzbl implements zzbn {
    private static Logger zzcz = Logger.getLogger(zzbl.class.getName());
    private ThreadLocal<ByteBuffer> zzda = new zzbo(this);

    public abstract zzbs zza(String str, byte[] bArr, String str2);

    public final zzbs zza(zzerm zzerm, zzbr zzbr) throws IOException {
        int read;
        long j;
        zzerm zzerm2 = zzerm;
        zzbr zzbr2 = zzbr;
        long position = zzerm.position();
        this.zzda.get().rewind().limit(8);
        do {
            read = zzerm2.read(this.zzda.get());
            if (read == 8) {
                this.zzda.get().rewind();
                long zzf = zzbp.zzf(this.zzda.get());
                byte[] bArr = null;
                if (zzf >= 8 || zzf <= 1) {
                    String zzk = zzbp.zzk(this.zzda.get());
                    if (zzf == 1) {
                        this.zzda.get().limit(16);
                        zzerm2.read(this.zzda.get());
                        this.zzda.get().position(8);
                        j = zzbp.zzh(this.zzda.get()) - 16;
                    } else {
                        j = zzf == 0 ? zzerm.size() - zzerm.position() : zzf - 8;
                    }
                    if ("uuid".equals(zzk)) {
                        this.zzda.get().limit(this.zzda.get().limit() + 16);
                        zzerm2.read(this.zzda.get());
                        bArr = new byte[16];
                        for (int position2 = this.zzda.get().position() - 16; position2 < this.zzda.get().position(); position2++) {
                            bArr[position2 - (this.zzda.get().position() - 16)] = this.zzda.get().get(position2);
                        }
                        j -= 16;
                    }
                    long j2 = j;
                    zzbs zza = zza(zzk, bArr, zzbr2 instanceof zzbs ? ((zzbs) zzbr2).getType() : "");
                    zza.zza(zzbr2);
                    this.zzda.get().rewind();
                    zza.zza(zzerm, this.zzda.get(), j2, this);
                    return zza;
                }
                Logger logger = zzcz;
                Level level = Level.SEVERE;
                StringBuilder sb = new StringBuilder(80);
                sb.append("Plausibility check failed: size < 8 (size = ");
                sb.append(zzf);
                sb.append("). Stop parsing!");
                logger.logp(level, "com.coremedia.iso.AbstractBoxParser", "parseBox", sb.toString());
                return null;
            }
        } while (read >= 0);
        zzerm2.zzfd(position);
        throw new EOFException();
    }
}
