package com.didi.entrega.home.component.feed.entity;

import com.didi.entrega.customer.foundation.rpc.entity.IEntity;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/entrega/home/component/feed/entity/HomeFeedEntity;", "Lcom/didi/entrega/customer/foundation/rpc/entity/IEntity;", "()V", "mComponentList", "", "Lcom/didi/entrega/home/component/feed/entity/ComponentEntity;", "getMComponentList", "()Ljava/util/List;", "setMComponentList", "(Ljava/util/List;)V", "mControl", "", "getMControl", "()Ljava/lang/Boolean;", "setMControl", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeFeedEntity.kt */
public final class HomeFeedEntity implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 7689237692133307506L;
    @SerializedName("componentList")
    private List<ComponentEntity> mComponentList;
    @SerializedName("control")
    private Boolean mControl = false;

    public final List<ComponentEntity> getMComponentList() {
        return this.mComponentList;
    }

    public final void setMComponentList(List<ComponentEntity> list) {
        this.mComponentList = list;
    }

    public final Boolean getMControl() {
        return this.mControl;
    }

    public final void setMControl(Boolean bool) {
        this.mControl = bool;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/entrega/home/component/feed/entity/HomeFeedEntity$Companion;", "", "()V", "serialVersionUID", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: HomeFeedEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
