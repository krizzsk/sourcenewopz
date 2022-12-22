package com.google.android.gms.internal.ads;

import com.didichuxing.bigdata.p173dp.locsdk.Const;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public class zzerk implements zzbr, Closeable, Iterator<zzbs> {
    private static zzers zzdc = zzers.zzp(zzerk.class);
    private static final zzbs zzjei = new zzern("eof ");
    long zzate = 0;
    long zzbgk = 0;
    protected zzerm zzjeg;
    protected zzbn zzjej;
    private zzbs zzjek = null;
    long zzjel = 0;
    private List<zzbs> zzjem = new ArrayList();

    public final List<zzbs> zzbnj() {
        if (this.zzjeg == null || this.zzjek == zzjei) {
            return this.zzjem;
        }
        return new zzerq(this.zzjem, this);
    }

    public void zza(zzerm zzerm, long j, zzbn zzbn) throws IOException {
        this.zzjeg = zzerm;
        long position = zzerm.position();
        this.zzbgk = position;
        this.zzjel = position;
        zzerm.zzfd(zzerm.position() + j);
        this.zzate = zzerm.position();
        this.zzjej = zzbn;
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public boolean hasNext() {
        zzbs zzbs = this.zzjek;
        if (zzbs == zzjei) {
            return false;
        }
        if (zzbs != null) {
            return true;
        }
        try {
            this.zzjek = (zzbs) next();
            return true;
        } catch (NoSuchElementException unused) {
            this.zzjek = zzjei;
            return false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzbnk */
    public final zzbs next() {
        zzbs zza;
        zzbs zzbs = this.zzjek;
        if (zzbs == null || zzbs == zzjei) {
            zzerm zzerm = this.zzjeg;
            if (zzerm == null || this.zzjel >= this.zzate) {
                this.zzjek = zzjei;
                throw new NoSuchElementException();
            }
            try {
                synchronized (zzerm) {
                    this.zzjeg.zzfd(this.zzjel);
                    zza = this.zzjej.zza(this.zzjeg, this);
                    this.zzjel = this.zzjeg.position();
                }
                return zza;
            } catch (EOFException unused) {
                throw new NoSuchElementException();
            } catch (IOException unused2) {
                throw new NoSuchElementException();
            }
        } else {
            this.zzjek = null;
            return zzbs;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(Const.jaLeft);
        for (int i = 0; i < this.zzjem.size(); i++) {
            if (i > 0) {
                sb.append(";");
            }
            sb.append(this.zzjem.get(i).toString());
        }
        sb.append(Const.jaRight);
        return sb.toString();
    }

    public void close() throws IOException {
        this.zzjeg.close();
    }
}
