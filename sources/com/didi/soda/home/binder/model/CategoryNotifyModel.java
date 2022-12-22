package com.didi.soda.home.binder.model;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.customer.foundation.rpc.entity.TagEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.CategoryNotifyEntity;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, mo175978d2 = {"Lcom/didi/soda/home/binder/model/CategoryNotifyModel;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "()V", "notify", "Lcom/didi/soda/customer/foundation/rpc/entity/TagEntity;", "getNotify", "()Lcom/didi/soda/customer/foundation/rpc/entity/TagEntity;", "setNotify", "(Lcom/didi/soda/customer/foundation/rpc/entity/TagEntity;)V", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CategoryNotifyModel.kt */
public final class CategoryNotifyModel implements RecyclerModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private TagEntity f42541a;

    @JvmStatic
    public static final CategoryNotifyModel convert(CategoryNotifyEntity categoryNotifyEntity) {
        return Companion.convert(categoryNotifyEntity);
    }

    public final TagEntity getNotify() {
        return this.f42541a;
    }

    public final void setNotify(TagEntity tagEntity) {
        this.f42541a = tagEntity;
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/soda/home/binder/model/CategoryNotifyModel$Companion;", "", "()V", "convert", "Lcom/didi/soda/home/binder/model/CategoryNotifyModel;", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/CategoryNotifyEntity;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CategoryNotifyModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CategoryNotifyModel convert(CategoryNotifyEntity categoryNotifyEntity) {
            Intrinsics.checkNotNullParameter(categoryNotifyEntity, "entity");
            CategoryNotifyModel categoryNotifyModel = new CategoryNotifyModel();
            categoryNotifyModel.setNotify(categoryNotifyEntity.getTip());
            return categoryNotifyModel;
        }
    }
}
