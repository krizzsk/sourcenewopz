package com.didi.soda.home.manager;

import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.soda.home.binder.model.AllCategoryItemModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00042\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0004B\u0005¢\u0006\u0002\u0010\u0003¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/home/manager/AllCategoryLogicRepo;", "Lcom/didi/app/nova/skeleton/repo/Repo;", "Lcom/didi/soda/home/binder/model/AllCategoryItemModel;", "()V", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AllCategoryLogicRepo.kt */
public final class AllCategoryLogicRepo extends Repo<AllCategoryItemModel> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int LOGIC_RETURN_CATEGORY_CLICKED = 100;

    @Metadata(mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, mo175978d2 = {"Lcom/didi/soda/home/manager/AllCategoryLogicRepo$Companion;", "", "()V", "LOGIC_RETURN_CATEGORY_CLICKED", "", "buildCategoryClickedModel", "Lcom/didi/soda/home/binder/model/AllCategoryItemModel;", "origin", "position", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: AllCategoryLogicRepo.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AllCategoryItemModel buildCategoryClickedModel(AllCategoryItemModel allCategoryItemModel, int i) {
            if (allCategoryItemModel != null) {
                allCategoryItemModel.setLogicType(100);
                allCategoryItemModel.setPosition(i);
            }
            return allCategoryItemModel;
        }
    }
}
