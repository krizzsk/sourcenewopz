package com.didi.soda.customer.foundation.rpc.entity.topgun;

import com.didi.soda.customer.foundation.rpc.entity.address.AddressPageListEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.HomeAddressEntity;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/topgun/HomeAddrEntity;", "Ljava/io/Serializable;", "()V", "mAddressInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/address/HomeAddressEntity;", "getMAddressInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/address/HomeAddressEntity;", "setMAddressInfo", "(Lcom/didi/soda/customer/foundation/rpc/entity/address/HomeAddressEntity;)V", "mAddressListInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressPageListEntity;", "getMAddressListInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressPageListEntity;", "setMAddressListInfo", "(Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressPageListEntity;)V", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeAddrEntity.kt */
public final class HomeAddrEntity implements Serializable {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long serialVersionUID = 2010503724474631968L;
    @SerializedName("addressInfo")
    private HomeAddressEntity mAddressInfo;
    @SerializedName("addressListPage")
    private AddressPageListEntity mAddressListInfo;

    public final HomeAddressEntity getMAddressInfo() {
        return this.mAddressInfo;
    }

    public final void setMAddressInfo(HomeAddressEntity homeAddressEntity) {
        this.mAddressInfo = homeAddressEntity;
    }

    public final AddressPageListEntity getMAddressListInfo() {
        return this.mAddressListInfo;
    }

    public final void setMAddressListInfo(AddressPageListEntity addressPageListEntity) {
        this.mAddressListInfo = addressPageListEntity;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/topgun/HomeAddrEntity$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: HomeAddrEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
