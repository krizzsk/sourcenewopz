package com.google.android.play.core.assetpacks;

import com.google.android.play.core.internal.C18481cb;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/* renamed from: com.google.android.play.core.assetpacks.be */
final class C18322be extends C18481cb {

    /* renamed from: a */
    private final File f52804a;

    /* renamed from: b */
    private final File f52805b;

    /* renamed from: c */
    private final NavigableMap<Long, File> f52806c = new TreeMap();

    C18322be(File file, File file2) throws IOException {
        this.f52804a = file;
        this.f52805b = file2;
        List<File> a = C18391dt.m37681a(this.f52804a, this.f52805b);
        if (!a.isEmpty()) {
            long j = 0;
            for (File next : a) {
                this.f52806c.put(Long.valueOf(j), next);
                j += next.length();
            }
            return;
        }
        throw new C18339bv(String.format("Virtualized slice archive empty for %s, %s", new Object[]{this.f52804a, this.f52805b}));
    }

    /* renamed from: a */
    private final InputStream m37545a(long j, Long l) throws IOException {
        FileInputStream fileInputStream = new FileInputStream((File) this.f52806c.get(l));
        if (fileInputStream.skip(j - l.longValue()) == j - l.longValue()) {
            return fileInputStream;
        }
        throw new C18339bv(String.format("Virtualized slice archive corrupt, could not skip in file with key %s", new Object[]{l}));
    }

    /* renamed from: a */
    public final long mo148938a() {
        Map.Entry<Long, File> lastEntry = this.f52806c.lastEntry();
        return lastEntry.getKey().longValue() + lastEntry.getValue().length();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final InputStream mo148939a(long j, long j2) throws IOException {
        if (j < 0 || j2 < 0) {
            throw new C18339bv(String.format("Invalid input parameters %s, %s", new Object[]{Long.valueOf(j), Long.valueOf(j2)}));
        }
        long j3 = j + j2;
        if (j3 <= mo148938a()) {
            Long floorKey = this.f52806c.floorKey(Long.valueOf(j));
            Long floorKey2 = this.f52806c.floorKey(Long.valueOf(j3));
            if (floorKey.equals(floorKey2)) {
                return new C18321bd(m37545a(j, floorKey), j2);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(m37545a(j, floorKey));
            Collection values = this.f52806c.subMap(floorKey, false, floorKey2, false).values();
            if (!values.isEmpty()) {
                arrayList.add(new C18374dc(Collections.enumeration(values)));
            }
            arrayList.add(new C18321bd(new FileInputStream((File) this.f52806c.get(floorKey2)), j2 - (floorKey2.longValue() - j)));
            return new SequenceInputStream(Collections.enumeration(arrayList));
        }
        throw new C18339bv(String.format("Trying to access archive out of bounds. Archive ends at: %s. Tried accessing: %s", new Object[]{Long.valueOf(mo148938a()), Long.valueOf(j3)}));
    }

    public final void close() {
    }
}
