package com.didi.soda.customer.foundation.rpc.entity;

import com.didi.soda.blocks.entity.Template;
import com.didi.soda.customer.foundation.rpc.entity.address.HomeAddressEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R6\u0010\u0016\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u00010\u0017j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0018\u0018\u0001`\u00198\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006\u001f"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/SuAppEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "addressInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/address/HomeAddressEntity;", "getAddressInfo", "()Lcom/didi/soda/customer/foundation/rpc/entity/address/HomeAddressEntity;", "setAddressInfo", "(Lcom/didi/soda/customer/foundation/rpc/entity/address/HomeAddressEntity;)V", "compList", "", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/ComponentEntity;", "getCompList", "()Ljava/util/List;", "setCompList", "(Ljava/util/List;)V", "recId", "", "getRecId", "()Ljava/lang/String;", "setRecId", "(Ljava/lang/String;)V", "templates", "Ljava/util/ArrayList;", "Lcom/didi/soda/blocks/entity/Template;", "Lkotlin/collections/ArrayList;", "getTemplates", "()Ljava/util/ArrayList;", "setTemplates", "(Ljava/util/ArrayList;)V", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SuAppEntity.kt */
public final class SuAppEntity implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -8956052919840381905L;
    @SerializedName("addressInfo")
    private HomeAddressEntity addressInfo;
    @SerializedName("compList")
    private List<? extends ComponentEntity> compList;
    @SerializedName("recId")
    private String recId = "";
    @SerializedName("templates")
    private ArrayList<Template> templates;

    public final HomeAddressEntity getAddressInfo() {
        return this.addressInfo;
    }

    public final void setAddressInfo(HomeAddressEntity homeAddressEntity) {
        this.addressInfo = homeAddressEntity;
    }

    public final List<ComponentEntity> getCompList() {
        return this.compList;
    }

    public final void setCompList(List<? extends ComponentEntity> list) {
        this.compList = list;
    }

    public final ArrayList<Template> getTemplates() {
        return this.templates;
    }

    public final void setTemplates(ArrayList<Template> arrayList) {
        this.templates = arrayList;
    }

    public final String getRecId() {
        return this.recId;
    }

    public final void setRecId(String str) {
        this.recId = str;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/SuAppEntity$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SuAppEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
