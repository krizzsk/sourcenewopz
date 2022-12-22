package com.didi.entrega.billmap.model;

import com.didi.common.map.model.LatLng;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/entrega/billmap/model/BillMapInfoModel;", "", "()V", "etaTips", "", "getEtaTips", "()Ljava/lang/String;", "setEtaTips", "(Ljava/lang/String;)V", "receiverDisplayName", "getReceiverDisplayName", "setReceiverDisplayName", "receiverLatLng", "Lcom/didi/common/map/model/LatLng;", "getReceiverLatLng", "()Lcom/didi/common/map/model/LatLng;", "setReceiverLatLng", "(Lcom/didi/common/map/model/LatLng;)V", "senderDisplayName", "getSenderDisplayName", "setSenderDisplayName", "senderLatLng", "getSenderLatLng", "setSenderLatLng", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillMapInfoModel.kt */
public final class BillMapInfoModel {

    /* renamed from: a */
    private String f19625a;

    /* renamed from: b */
    private String f19626b;

    /* renamed from: c */
    private LatLng f19627c;

    /* renamed from: d */
    private LatLng f19628d;

    /* renamed from: e */
    private String f19629e;

    public final String getSenderDisplayName() {
        return this.f19625a;
    }

    public final void setSenderDisplayName(String str) {
        this.f19625a = str;
    }

    public final String getReceiverDisplayName() {
        return this.f19626b;
    }

    public final void setReceiverDisplayName(String str) {
        this.f19626b = str;
    }

    public final LatLng getSenderLatLng() {
        return this.f19627c;
    }

    public final void setSenderLatLng(LatLng latLng) {
        this.f19627c = latLng;
    }

    public final LatLng getReceiverLatLng() {
        return this.f19628d;
    }

    public final void setReceiverLatLng(LatLng latLng) {
        this.f19628d = latLng;
    }

    public final String getEtaTips() {
        return this.f19629e;
    }

    public final void setEtaTips(String str) {
        this.f19629e = str;
    }
}
