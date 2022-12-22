package com.didi.soda.customer.blocks.card.suapp;

import com.didi.soda.customer.foundation.rpc.entity.address.HomeAddressEntity;
import com.didi.soda.home.topgun.binder.model.HomeBusinessInfoRvModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/card/suapp/SaTopicModel;", "", "()V", "actId", "", "getActId", "()Ljava/lang/String;", "setActId", "(Ljava/lang/String;)V", "addressInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/address/HomeAddressEntity;", "getAddressInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/address/HomeAddressEntity;", "setAddressInfo", "(Lcom/didi/soda/customer/foundation/rpc/entity/address/HomeAddressEntity;)V", "componentId", "getComponentId", "setComponentId", "scene", "", "getScene", "()I", "setScene", "(I)V", "shopRvList", "", "Lcom/didi/soda/home/topgun/binder/model/HomeBusinessInfoRvModel;", "getShopRvList", "()Ljava/util/List;", "setShopRvList", "(Ljava/util/List;)V", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SaTopicModel.kt */
public final class SaTopicModel {

    /* renamed from: a */
    private int f40644a;

    /* renamed from: b */
    private String f40645b = "";

    /* renamed from: c */
    private String f40646c = "";

    /* renamed from: d */
    private HomeAddressEntity f40647d;

    /* renamed from: e */
    private List<? extends HomeBusinessInfoRvModel> f40648e;

    public final int getScene() {
        return this.f40644a;
    }

    public final void setScene(int i) {
        this.f40644a = i;
    }

    public final String getComponentId() {
        return this.f40645b;
    }

    public final void setComponentId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f40645b = str;
    }

    public final String getActId() {
        return this.f40646c;
    }

    public final void setActId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f40646c = str;
    }

    public final HomeAddressEntity getAddressInfo() {
        return this.f40647d;
    }

    public final void setAddressInfo(HomeAddressEntity homeAddressEntity) {
        this.f40647d = homeAddressEntity;
    }

    public final List<HomeBusinessInfoRvModel> getShopRvList() {
        return this.f40648e;
    }

    public final void setShopRvList(List<? extends HomeBusinessInfoRvModel> list) {
        this.f40648e = list;
    }
}
