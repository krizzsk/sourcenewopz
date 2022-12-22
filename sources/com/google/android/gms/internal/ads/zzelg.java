package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelf;
import com.google.android.gms.internal.ads.zzelg;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
public abstract class zzelg<MessageType extends zzelg<MessageType, BuilderType>, BuilderType extends zzelf<MessageType, BuilderType>> implements zzeon {
    protected int zziop = 0;

    public final zzelq zzbgy() {
        try {
            zzely zzgj = zzelq.zzgj(zzbjj());
            zzb(zzgj.zzbhq());
            return zzgj.zzbhp();
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + "ByteString".length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("ByteString");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    public final byte[] toByteArray() {
        try {
            byte[] bArr = new byte[zzbjj()];
            zzemk zzv = zzemk.zzv(bArr);
            zzb(zzv);
            zzv.zzbis();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + "byte array".length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    /* access modifiers changed from: package-private */
    public int zzbgz() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public void zzgd(int i) {
        throw new UnsupportedOperationException();
    }

    protected static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzenc.checkNotNull(iterable);
        if (iterable instanceof zzenu) {
            List<?> zzbkl = ((zzenu) iterable).zzbkl();
            zzenu zzenu = (zzenu) list;
            int size = list.size();
            for (Object next : zzbkl) {
                if (next == null) {
                    StringBuilder sb = new StringBuilder(37);
                    sb.append("Element at index ");
                    sb.append(zzenu.size() - size);
                    sb.append(" is null.");
                    String sb2 = sb.toString();
                    for (int size2 = zzenu.size() - 1; size2 >= size; size2--) {
                        zzenu.remove(size2);
                    }
                    throw new NullPointerException(sb2);
                } else if (next instanceof zzelq) {
                    zzenu.zzak((zzelq) next);
                } else {
                    zzenu.add((String) next);
                }
            }
        } else if (iterable instanceof zzeoz) {
            list.addAll((Collection) iterable);
        } else {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size3 = list.size();
            for (T next2 : iterable) {
                if (next2 == null) {
                    StringBuilder sb3 = new StringBuilder(37);
                    sb3.append("Element at index ");
                    sb3.append(list.size() - size3);
                    sb3.append(" is null.");
                    String sb4 = sb3.toString();
                    for (int size4 = list.size() - 1; size4 >= size3; size4--) {
                        list.remove(size4);
                    }
                    throw new NullPointerException(sb4);
                }
                list.add(next2);
            }
        }
    }
}
