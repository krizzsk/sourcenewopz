package com.didi.soda.home.binder.model;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.customer.foundation.rpc.entity.topgun.CategoryEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/soda/home/binder/model/AllCategoryItemModel;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "()V", "category", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/CategoryEntity;", "getCategory", "()Lcom/didi/soda/customer/foundation/rpc/entity/topgun/CategoryEntity;", "setCategory", "(Lcom/didi/soda/customer/foundation/rpc/entity/topgun/CategoryEntity;)V", "logicType", "", "getLogicType", "()I", "setLogicType", "(I)V", "position", "getPosition", "setPosition", "recId", "", "getRecId", "()Ljava/lang/String;", "setRecId", "(Ljava/lang/String;)V", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AllCategoryItemModel.kt */
public final class AllCategoryItemModel implements RecyclerModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private CategoryEntity f42537a;

    /* renamed from: b */
    private int f42538b;

    /* renamed from: c */
    private String f42539c = "";

    /* renamed from: d */
    private int f42540d;

    public final CategoryEntity getCategory() {
        return this.f42537a;
    }

    public final void setCategory(CategoryEntity categoryEntity) {
        this.f42537a = categoryEntity;
    }

    public final int getLogicType() {
        return this.f42538b;
    }

    public final void setLogicType(int i) {
        this.f42538b = i;
    }

    public final String getRecId() {
        return this.f42539c;
    }

    public final void setRecId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f42539c = str;
    }

    public final int getPosition() {
        return this.f42540d;
    }

    public final void setPosition(int i) {
        this.f42540d = i;
    }

    @Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0018\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bJ\"\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\u0007\u001a\u00020\b¨\u0006\f"}, mo175978d2 = {"Lcom/didi/soda/home/binder/model/AllCategoryItemModel$Companion;", "", "()V", "convertModel", "Lcom/didi/soda/home/binder/model/AllCategoryItemModel;", "category", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/CategoryEntity;", "recId", "", "convetModelList", "", "categoryList", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: AllCategoryItemModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final AllCategoryItemModel convertModel(CategoryEntity categoryEntity) {
            return convertModel(categoryEntity, "");
        }

        public final AllCategoryItemModel convertModel(CategoryEntity categoryEntity, String str) {
            Intrinsics.checkNotNullParameter(str, "recId");
            AllCategoryItemModel allCategoryItemModel = new AllCategoryItemModel();
            allCategoryItemModel.setCategory(categoryEntity);
            allCategoryItemModel.setRecId(str);
            return allCategoryItemModel;
        }

        public final List<AllCategoryItemModel> convetModelList(List<CategoryEntity> list, String str) {
            Intrinsics.checkNotNullParameter(list, "categoryList");
            Intrinsics.checkNotNullParameter(str, "recId");
            List<AllCategoryItemModel> arrayList = new ArrayList<>();
            for (CategoryEntity convertModel : list) {
                arrayList.add(convertModel(convertModel, str));
            }
            return arrayList;
        }
    }
}
