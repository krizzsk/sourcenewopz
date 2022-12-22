package com.google.android.gms.internal.auth;

import com.google.android.gms.internal.auth.zzeo;
import com.google.android.gms.internal.auth.zzeq;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
public class zzeo<MessageType extends zzeq<MessageType, BuilderType>, BuilderType extends zzeo<MessageType, BuilderType>> extends zzdl<MessageType, BuilderType> {
    protected MessageType zza;
    protected boolean zzb = false;
    private final MessageType zzc;

    protected zzeo(MessageType messagetype) {
        this.zzc = messagetype;
        this.zza = (zzeq) messagetype.zzj(4, (Object) null, (Object) null);
    }

    private static final void zzj(MessageType messagetype, MessageType messagetype2) {
        zzfy.zza().zzb(messagetype.getClass()).zzf(messagetype, messagetype2);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ zzdl zzb(zzdm zzdm) {
        zze((zzeq) zzdm);
        return this;
    }

    /* renamed from: zzd */
    public final BuilderType zza() {
        BuilderType buildertype = (zzeo) this.zzc.zzj(5, (Object) null, (Object) null);
        buildertype.zze(zzg());
        return buildertype;
    }

    public final BuilderType zze(MessageType messagetype) {
        if (this.zzb) {
            zzi();
            this.zzb = false;
        }
        zzj(this.zza, messagetype);
        return this;
    }

    /* renamed from: zzf */
    public MessageType zzg() {
        if (this.zzb) {
            return this.zza;
        }
        MessageType messagetype = this.zza;
        zzfy.zza().zzb(messagetype.getClass()).zze(messagetype);
        this.zzb = true;
        return this.zza;
    }

    public final /* bridge */ /* synthetic */ zzfq zzh() {
        return this.zzc;
    }

    /* access modifiers changed from: protected */
    public void zzi() {
        MessageType messagetype = (zzeq) this.zza.zzj(4, (Object) null, (Object) null);
        zzj(messagetype, this.zza);
        this.zza = messagetype;
    }
}
