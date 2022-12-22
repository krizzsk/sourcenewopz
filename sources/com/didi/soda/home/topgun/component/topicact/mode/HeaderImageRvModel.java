package com.didi.soda.home.topgun.component.topicact.mode;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity;
import com.didi.soda.customer.foundation.tracker.model.ModuleModelV2;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u00012\u00020\u0002:\u0001\nB\u0005¢\u0006\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/component/topicact/mode/HeaderImageRvModel;", "Lcom/didi/soda/customer/foundation/tracker/model/ModuleModelV2;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "()V", "headerImageUrl", "", "getHeaderImageUrl", "()Ljava/lang/String;", "setHeaderImageUrl", "(Ljava/lang/String;)V", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HeaderImageRvModel.kt */
public final class HeaderImageRvModel extends ModuleModelV2 implements RecyclerModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private String f42963a = "";

    public final String getHeaderImageUrl() {
        return this.f42963a;
    }

    public final void setHeaderImageUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f42963a = str;
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/component/topicact/mode/HeaderImageRvModel$Companion;", "", "()V", "convert", "Lcom/didi/soda/home/topgun/component/topicact/mode/HeaderImageRvModel;", "compInfo", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/ComponentEntity;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: HeaderImageRvModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HeaderImageRvModel convert(ComponentEntity componentEntity) {
            Intrinsics.checkNotNullParameter(componentEntity, "compInfo");
            HeaderImageRvModel headerImageRvModel = new HeaderImageRvModel();
            String str = componentEntity.header.img;
            if (str == null) {
                str = "";
            }
            headerImageRvModel.setHeaderImageUrl(str);
            return headerImageRvModel;
        }
    }
}
