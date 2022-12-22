package com.didi.soda.home.kingkong;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.customer.foundation.rpc.entity.TagEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.AllCategoryEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.CategoryEntity;
import com.didi.soda.datasource.parser.FeedPayload;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\n\"\u0004\b\u001c\u0010\fR\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001c\u00100\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\n\"\u0004\b2\u0010\fR\u001e\u00103\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0010\n\u0002\u0010#\u001a\u0004\b4\u0010 \"\u0004\b5\u0010\"R\u001c\u00106\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\n\"\u0004\b8\u0010\f¨\u00069"}, mo175978d2 = {"Lcom/didi/soda/home/kingkong/KingKongItemModel;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "categoryEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/CategoryEntity;", "payload", "Lcom/didi/soda/datasource/parser/FeedPayload;", "(Lcom/didi/soda/customer/foundation/rpc/entity/topgun/CategoryEntity;Lcom/didi/soda/datasource/parser/FeedPayload;)V", "activityCate", "", "getActivityCate", "()Ljava/lang/String;", "setActivityCate", "(Ljava/lang/String;)V", "activityId", "getActivityId", "setActivityId", "cateId", "getCateId", "setCateId", "img", "getImg", "setImg", "getPayload", "()Lcom/didi/soda/datasource/parser/FeedPayload;", "setPayload", "(Lcom/didi/soda/datasource/parser/FeedPayload;)V", "resourceId", "getResourceId", "setResourceId", "selected", "", "getSelected", "()Ljava/lang/Integer;", "setSelected", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "subItems", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/AllCategoryEntity;", "getSubItems", "()Lcom/didi/soda/customer/foundation/rpc/entity/topgun/AllCategoryEntity;", "setSubItems", "(Lcom/didi/soda/customer/foundation/rpc/entity/topgun/AllCategoryEntity;)V", "tag", "Lcom/didi/soda/customer/foundation/rpc/entity/TagEntity;", "getTag", "()Lcom/didi/soda/customer/foundation/rpc/entity/TagEntity;", "setTag", "(Lcom/didi/soda/customer/foundation/rpc/entity/TagEntity;)V", "title", "getTitle", "setTitle", "type", "getType", "setType", "url", "getUrl", "setUrl", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: KingKongItemModel.kt */
public final class KingKongItemModel implements RecyclerModel {

    /* renamed from: a */
    private String f42656a;

    /* renamed from: b */
    private String f42657b;

    /* renamed from: c */
    private String f42658c;

    /* renamed from: d */
    private String f42659d;

    /* renamed from: e */
    private String f42660e;

    /* renamed from: f */
    private String f42661f;

    /* renamed from: g */
    private String f42662g;

    /* renamed from: h */
    private AllCategoryEntity f42663h;

    /* renamed from: i */
    private FeedPayload f42664i;

    /* renamed from: j */
    private Integer f42665j = 0;

    /* renamed from: k */
    private Integer f42666k = 0;

    /* renamed from: l */
    private TagEntity f42667l;

    public KingKongItemModel(CategoryEntity categoryEntity, FeedPayload feedPayload) {
        Intrinsics.checkNotNullParameter(categoryEntity, "categoryEntity");
        Intrinsics.checkNotNullParameter(feedPayload, "payload");
        this.f42656a = categoryEntity.getUrl();
        this.f42657b = categoryEntity.getImg();
        this.f42658c = categoryEntity.getTitle();
        this.f42659d = categoryEntity.getCateId();
        this.f42660e = categoryEntity.getActivityId();
        this.f42662g = categoryEntity.getResourceId();
        this.f42661f = categoryEntity.getActivityCate();
        this.f42663h = categoryEntity.getSubItems();
        this.f42664i = feedPayload;
        this.f42665j = categoryEntity.getType();
        this.f42666k = categoryEntity.getSelected();
        this.f42667l = categoryEntity.getTag();
    }

    public final String getUrl() {
        return this.f42656a;
    }

    public final void setUrl(String str) {
        this.f42656a = str;
    }

    public final String getImg() {
        return this.f42657b;
    }

    public final void setImg(String str) {
        this.f42657b = str;
    }

    public final String getTitle() {
        return this.f42658c;
    }

    public final void setTitle(String str) {
        this.f42658c = str;
    }

    public final String getCateId() {
        return this.f42659d;
    }

    public final void setCateId(String str) {
        this.f42659d = str;
    }

    public final String getActivityId() {
        return this.f42660e;
    }

    public final void setActivityId(String str) {
        this.f42660e = str;
    }

    public final String getActivityCate() {
        return this.f42661f;
    }

    public final void setActivityCate(String str) {
        this.f42661f = str;
    }

    public final String getResourceId() {
        return this.f42662g;
    }

    public final void setResourceId(String str) {
        this.f42662g = str;
    }

    public final AllCategoryEntity getSubItems() {
        return this.f42663h;
    }

    public final void setSubItems(AllCategoryEntity allCategoryEntity) {
        this.f42663h = allCategoryEntity;
    }

    public final FeedPayload getPayload() {
        return this.f42664i;
    }

    public final void setPayload(FeedPayload feedPayload) {
        this.f42664i = feedPayload;
    }

    public final Integer getType() {
        return this.f42665j;
    }

    public final void setType(Integer num) {
        this.f42665j = num;
    }

    public final Integer getSelected() {
        return this.f42666k;
    }

    public final void setSelected(Integer num) {
        this.f42666k = num;
    }

    public final TagEntity getTag() {
        return this.f42667l;
    }

    public final void setTag(TagEntity tagEntity) {
        this.f42667l = tagEntity;
    }
}
