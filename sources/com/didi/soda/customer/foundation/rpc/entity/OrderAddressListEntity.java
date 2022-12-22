package com.didi.soda.customer.foundation.rpc.entity;

import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00172\u00020\u0001:\u0002\u0016\u0017B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\b¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/OrderAddressListEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "addAddrRuleDesc", "", "getAddAddrRuleDesc", "()Ljava/lang/String;", "setAddAddrRuleDesc", "(Ljava/lang/String;)V", "addressList", "", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderAddressListEntity$AddrOptionStructEntity;", "getAddressList", "()Ljava/util/List;", "setAddressList", "(Ljava/util/List;)V", "orderAid", "getOrderAid", "setOrderAid", "ruleDesc", "getRuleDesc", "setRuleDesc", "AddrOptionStructEntity", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderAddressListEntity.kt */
public final class OrderAddressListEntity implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -1308445993892064884L;
    private String addAddrRuleDesc;
    private List<AddrOptionStructEntity> addressList;
    private String orderAid;
    private String ruleDesc;

    public final String getRuleDesc() {
        return this.ruleDesc;
    }

    public final void setRuleDesc(String str) {
        this.ruleDesc = str;
    }

    public final String getAddAddrRuleDesc() {
        return this.addAddrRuleDesc;
    }

    public final void setAddAddrRuleDesc(String str) {
        this.addAddrRuleDesc = str;
    }

    public final String getOrderAid() {
        return this.orderAid;
    }

    public final void setOrderAid(String str) {
        this.orderAid = str;
    }

    public final List<AddrOptionStructEntity> getAddressList() {
        return this.addressList;
    }

    public final void setAddressList(List<AddrOptionStructEntity> list) {
        this.addressList = list;
    }

    @Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001a¨\u0006 "}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/OrderAddressListEntity$AddrOptionStructEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "addrTag", "Lcom/didi/soda/customer/foundation/rpc/entity/OrderAddressListEntity$AddrOptionStructEntity$TagEntity;", "getAddrTag", "()Lcom/didi/soda/customer/foundation/rpc/entity/OrderAddressListEntity$AddrOptionStructEntity$TagEntity;", "setAddrTag", "(Lcom/didi/soda/customer/foundation/rpc/entity/OrderAddressListEntity$AddrOptionStructEntity$TagEntity;)V", "address", "Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressEntity;", "getAddress", "()Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressEntity;", "setAddress", "(Lcom/didi/soda/customer/foundation/rpc/entity/address/AddressEntity;)V", "disable", "", "getDisable", "()I", "setDisable", "(I)V", "disableReason", "", "getDisableReason", "()Ljava/lang/String;", "setDisableReason", "(Ljava/lang/String;)V", "disableTag", "getDisableTag", "setDisableTag", "Companion", "TagEntity", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderAddressListEntity.kt */
    public static final class AddrOptionStructEntity implements IEntity {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final long serialVersionUID = -1113076276481063066L;
        private TagEntity addrTag;
        private AddressEntity address;
        private int disable;
        private String disableReason;
        private String disableTag;

        public final AddressEntity getAddress() {
            return this.address;
        }

        public final void setAddress(AddressEntity addressEntity) {
            this.address = addressEntity;
        }

        public final TagEntity getAddrTag() {
            return this.addrTag;
        }

        public final void setAddrTag(TagEntity tagEntity) {
            this.addrTag = tagEntity;
        }

        public final int getDisable() {
            return this.disable;
        }

        public final void setDisable(int i) {
            this.disable = i;
        }

        public final String getDisableTag() {
            return this.disableTag;
        }

        public final void setDisableTag(String str) {
            this.disableTag = str;
        }

        public final String getDisableReason() {
            return this.disableReason;
        }

        public final void setDisableReason(String str) {
            this.disableReason = str;
        }

        @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/OrderAddressListEntity$AddrOptionStructEntity$TagEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "content", "", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: OrderAddressListEntity.kt */
        public static final class TagEntity implements IEntity {
            public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
            private static final long serialVersionUID = -3758372242957668657L;
            private String content;

            public final String getContent() {
                return this.content;
            }

            public final void setContent(String str) {
                this.content = str;
            }

            @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/OrderAddressListEntity$AddrOptionStructEntity$TagEntity$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
            /* compiled from: OrderAddressListEntity.kt */
            public static final class Companion {
                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private Companion() {
                }
            }
        }

        @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/OrderAddressListEntity$AddrOptionStructEntity$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
        /* compiled from: OrderAddressListEntity.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/OrderAddressListEntity$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderAddressListEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
