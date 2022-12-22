package com.didi.soda.customer.foundation.rpc.entity.topgun;

import com.didi.soda.customer.foundation.rpc.entity.IEntity;
import com.didi.soda.customer.foundation.rpc.entity.TagEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 12\u00020\u0001:\u00011B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001c\u0010(\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR\u001e\u0010+\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b,\u0010\u0018\"\u0004\b-\u0010\u001aR\u001c\u0010.\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\b¨\u00062"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/topgun/CategoryEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "activityCate", "", "getActivityCate", "()Ljava/lang/String;", "setActivityCate", "(Ljava/lang/String;)V", "activityId", "getActivityId", "setActivityId", "cateId", "getCateId", "setCateId", "img", "getImg", "setImg", "resourceId", "getResourceId", "setResourceId", "selected", "", "getSelected", "()Ljava/lang/Integer;", "setSelected", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "subItems", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/AllCategoryEntity;", "getSubItems", "()Lcom/didi/soda/customer/foundation/rpc/entity/topgun/AllCategoryEntity;", "setSubItems", "(Lcom/didi/soda/customer/foundation/rpc/entity/topgun/AllCategoryEntity;)V", "tag", "Lcom/didi/soda/customer/foundation/rpc/entity/TagEntity;", "getTag", "()Lcom/didi/soda/customer/foundation/rpc/entity/TagEntity;", "setTag", "(Lcom/didi/soda/customer/foundation/rpc/entity/TagEntity;)V", "title", "getTitle", "setTitle", "type", "getType", "setType", "url", "getUrl", "setUrl", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CategoryEntity.kt */
public final class CategoryEntity implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = -4705530578666490198L;
    private String activityCate;
    private String activityId;
    private String cateId;
    private String img;
    private String resourceId;
    private Integer selected = 0;
    private AllCategoryEntity subItems;
    private TagEntity tag;
    private String title;
    private Integer type = 0;
    private String url;

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        this.url = str;
    }

    public final String getImg() {
        return this.img;
    }

    public final void setImg(String str) {
        this.img = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        this.title = str;
    }

    public final String getCateId() {
        return this.cateId;
    }

    public final void setCateId(String str) {
        this.cateId = str;
    }

    public final Integer getType() {
        return this.type;
    }

    public final void setType(Integer num) {
        this.type = num;
    }

    public final Integer getSelected() {
        return this.selected;
    }

    public final void setSelected(Integer num) {
        this.selected = num;
    }

    public final String getActivityId() {
        return this.activityId;
    }

    public final void setActivityId(String str) {
        this.activityId = str;
    }

    public final String getResourceId() {
        return this.resourceId;
    }

    public final void setResourceId(String str) {
        this.resourceId = str;
    }

    public final String getActivityCate() {
        return this.activityCate;
    }

    public final void setActivityCate(String str) {
        this.activityCate = str;
    }

    public final AllCategoryEntity getSubItems() {
        return this.subItems;
    }

    public final void setSubItems(AllCategoryEntity allCategoryEntity) {
        this.subItems = allCategoryEntity;
    }

    public final TagEntity getTag() {
        return this.tag;
    }

    public final void setTag(TagEntity tagEntity) {
        this.tag = tagEntity;
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/topgun/CategoryEntity$Companion;", "", "()V", "serialVersionUID", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CategoryEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
