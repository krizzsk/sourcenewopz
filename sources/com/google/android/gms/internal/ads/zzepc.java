package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-gass@@19.8.0 */
interface zzepc {
    int getTag();

    double readDouble() throws IOException;

    float readFloat() throws IOException;

    String readString() throws IOException;

    void readStringList(List<String> list) throws IOException;

    <T> T zza(zzepi<T> zzepi, zzemn zzemn) throws IOException;

    <T> void zza(List<T> list, zzepi<T> zzepi, zzemn zzemn) throws IOException;

    <K, V> void zza(Map<K, V> map, zzeoe<K, V> zzeoe, zzemn zzemn) throws IOException;

    void zzaa(List<Integer> list) throws IOException;

    void zzab(List<Long> list) throws IOException;

    @Deprecated
    <T> T zzb(zzepi<T> zzepi, zzemn zzemn) throws IOException;

    @Deprecated
    <T> void zzb(List<T> list, zzepi<T> zzepi, zzemn zzemn) throws IOException;

    long zzbhs() throws IOException;

    long zzbht() throws IOException;

    int zzbhu() throws IOException;

    long zzbhv() throws IOException;

    int zzbhw() throws IOException;

    boolean zzbhx() throws IOException;

    String zzbhy() throws IOException;

    zzelq zzbhz() throws IOException;

    int zzbia() throws IOException;

    int zzbib() throws IOException;

    int zzbic() throws IOException;

    long zzbid() throws IOException;

    int zzbie() throws IOException;

    long zzbif() throws IOException;

    int zzbip() throws IOException;

    boolean zzbiq() throws IOException;

    void zzm(List<Double> list) throws IOException;

    void zzn(List<Float> list) throws IOException;

    void zzo(List<Long> list) throws IOException;

    void zzp(List<Long> list) throws IOException;

    void zzq(List<Integer> list) throws IOException;

    void zzr(List<Long> list) throws IOException;

    void zzs(List<Integer> list) throws IOException;

    void zzt(List<Boolean> list) throws IOException;

    void zzu(List<String> list) throws IOException;

    void zzv(List<zzelq> list) throws IOException;

    void zzw(List<Integer> list) throws IOException;

    void zzx(List<Integer> list) throws IOException;

    void zzy(List<Integer> list) throws IOException;

    void zzz(List<Long> list) throws IOException;
}
