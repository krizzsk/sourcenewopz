package com.google.android.gms.auth.api.accounttransfer;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
final class zzf extends zzj<DeviceMetaData> {
    final /* synthetic */ zzg zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzf(zzg zzg, zzk zzk) {
        super(zzk);
        this.zza = zzg;
    }

    public final void zzc(DeviceMetaData deviceMetaData) {
        this.zza.zzb.setResult(deviceMetaData);
    }
}
