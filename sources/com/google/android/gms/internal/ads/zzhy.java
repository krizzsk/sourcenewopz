package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public interface zzhy extends zzhj {
    void disable();

    int getState();

    int getTrackType();

    boolean isReady();

    void setIndex(int i);

    void start() throws zzhe;

    void stop() throws zzhe;

    void zza(zzia zzia, zzht[] zzhtArr, zznn zznn, long j, boolean z, long j2) throws zzhe;

    void zza(zzht[] zzhtArr, zznn zznn, long j) throws zzhe;

    void zzb(long j, long j2) throws zzhe;

    void zzdm(long j) throws zzhe;

    zzib zzec();

    zzpk zzed();

    zznn zzee();

    boolean zzef();

    void zzeg();

    boolean zzeh();

    void zzei() throws IOException;

    boolean zzfi();
}
