package com.didi.soda.home.topgun.binder.model;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.business.model.BusinessGoodsItemRvModel;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.foundation.rpc.entity.BusinessInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.GoodsItemEntity;
import com.didi.soda.customer.foundation.rpc.entity.topgun.HomeTopicEntity;
import com.didi.soda.customer.foundation.tracker.model.ModuleModelV2;
import com.didi.soda.customer.foundation.util.ExtentionsKt;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.datasource.parser.FeedPayload;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00010B\u0005¢\u0006\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001aR*\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R*\u0010)\u001a\u0012\u0012\u0004\u0012\u00020*0\u001cj\b\u0012\u0004\u0012\u00020*`\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010 \"\u0004\b,\u0010\"R\u001a\u0010-\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0007\"\u0004\b/\u0010\t¨\u00061"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/binder/model/HomeTopicRvModel;", "Lcom/didi/soda/customer/foundation/tracker/model/ModuleModelV2;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "()V", "createTime", "", "getCreateTime", "()J", "setCreateTime", "(J)V", "data", "Lcom/didi/soda/customer/foundation/rpc/entity/topgun/HomeTopicEntity;", "getData", "()Lcom/didi/soda/customer/foundation/rpc/entity/topgun/HomeTopicEntity;", "setData", "(Lcom/didi/soda/customer/foundation/rpc/entity/topgun/HomeTopicEntity;)V", "filterParams", "", "getFilterParams", "()Ljava/lang/String;", "setFilterParams", "(Ljava/lang/String;)V", "isPlayingRightTopAnim", "", "()Z", "setPlayingRightTopAnim", "(Z)V", "itemList", "Ljava/util/ArrayList;", "Lcom/didi/soda/business/model/BusinessGoodsItemRvModel;", "Lkotlin/collections/ArrayList;", "getItemList", "()Ljava/util/ArrayList;", "setItemList", "(Ljava/util/ArrayList;)V", "payload", "Lcom/didi/soda/datasource/parser/FeedPayload;", "getPayload", "()Lcom/didi/soda/datasource/parser/FeedPayload;", "setPayload", "(Lcom/didi/soda/datasource/parser/FeedPayload;)V", "shopList", "Lcom/didi/soda/home/topgun/binder/model/HomeBusinessInfoRvModel;", "getShopList", "setShopList", "startAnimTime", "getStartAnimTime", "setStartAnimTime", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeTopicRvModel.kt */
public final class HomeTopicRvModel extends ModuleModelV2 implements RecyclerModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private HomeTopicEntity f42783a;

    /* renamed from: b */
    private FeedPayload f42784b;

    /* renamed from: c */
    private long f42785c;

    /* renamed from: d */
    private long f42786d;

    /* renamed from: e */
    private ArrayList<BusinessGoodsItemRvModel> f42787e = new ArrayList<>();

    /* renamed from: f */
    private ArrayList<HomeBusinessInfoRvModel> f42788f = new ArrayList<>();

    /* renamed from: g */
    private boolean f42789g;

    /* renamed from: h */
    private String f42790h;

    public final HomeTopicEntity getData() {
        return this.f42783a;
    }

    public final void setData(HomeTopicEntity homeTopicEntity) {
        this.f42783a = homeTopicEntity;
    }

    public final FeedPayload getPayload() {
        return this.f42784b;
    }

    public final void setPayload(FeedPayload feedPayload) {
        this.f42784b = feedPayload;
    }

    public final long getCreateTime() {
        return this.f42785c;
    }

    public final void setCreateTime(long j) {
        this.f42785c = j;
    }

    public final long getStartAnimTime() {
        return this.f42786d;
    }

    public final void setStartAnimTime(long j) {
        this.f42786d = j;
    }

    public final ArrayList<BusinessGoodsItemRvModel> getItemList() {
        return this.f42787e;
    }

    public final void setItemList(ArrayList<BusinessGoodsItemRvModel> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.f42787e = arrayList;
    }

    public final ArrayList<HomeBusinessInfoRvModel> getShopList() {
        return this.f42788f;
    }

    public final void setShopList(ArrayList<HomeBusinessInfoRvModel> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.f42788f = arrayList;
    }

    public final boolean isPlayingRightTopAnim() {
        return this.f42789g;
    }

    public final void setPlayingRightTopAnim(boolean z) {
        this.f42789g = z;
    }

    public final String getFilterParams() {
        return this.f42790h;
    }

    public final void setFilterParams(String str) {
        this.f42790h = str;
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/binder/model/HomeTopicRvModel$Companion;", "", "()V", "convert", "Lcom/didi/soda/home/topgun/binder/model/HomeTopicRvModel;", "compJson", "Lcom/google/gson/JsonObject;", "payload", "Lcom/didi/soda/datasource/parser/FeedPayload;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: HomeTopicRvModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HomeTopicRvModel convert(JsonObject jsonObject, FeedPayload feedPayload) {
            JsonElement jsonElement;
            Integer num;
            String str;
            String str2;
            HomeTopicRvModel homeTopicRvModel = new HomeTopicRvModel();
            String str3 = null;
            if (jsonObject == null) {
                jsonElement = null;
            } else {
                jsonElement = jsonObject.get("data");
            }
            if (jsonElement == null) {
                return homeTopicRvModel;
            }
            try {
                Object fromJson = GsonUtil.fromJson(jsonElement, (Type) HomeTopicEntity.class);
                Intrinsics.checkNotNullExpressionValue(fromJson, "fromJson(dataElement, HomeTopicEntity::class.java)");
                HomeTopicEntity homeTopicEntity = (HomeTopicEntity) fromJson;
                if (feedPayload == null) {
                    num = null;
                } else {
                    num = Integer.valueOf(feedPayload.mComponentIndex);
                }
                homeTopicRvModel.mAbsoluteIndex = ExtentionsKt.orZero(num);
                JsonElement jsonElement2 = jsonObject.get(BlocksConst.BLOCK_PARAM_COMPONENT_ID);
                String asString = jsonElement2 == null ? null : jsonElement2.getAsString();
                String str4 = "";
                if (asString == null) {
                    asString = str4;
                }
                homeTopicRvModel.mComponentId = asString;
                JsonElement jsonElement3 = jsonObject.get("position");
                homeTopicRvModel.mIndexInModule = ExtentionsKt.orZero(jsonElement3 == null ? null : Integer.valueOf(jsonElement3.getAsInt()));
                JsonElement jsonElement4 = jsonObject.get("type");
                String asString2 = jsonElement4 == null ? null : jsonElement4.getAsString();
                if (asString2 != null) {
                    str4 = asString2;
                }
                homeTopicRvModel.mComponentType = str4;
                homeTopicRvModel.setData(homeTopicEntity);
                homeTopicRvModel.setPayload(feedPayload);
                homeTopicRvModel.setCreateTime(System.currentTimeMillis());
                if (feedPayload == null) {
                    str = null;
                } else {
                    str = feedPayload.mRecId;
                }
                homeTopicRvModel.mRecId = str;
                if (feedPayload == null) {
                    str2 = null;
                } else {
                    str2 = feedPayload.mTraceId;
                }
                homeTopicRvModel.mTraceId = str2;
                List<GoodsItemEntity> list = homeTopicEntity.mItems;
                if (list != null) {
                    for (GoodsItemEntity newInstance : list) {
                        homeTopicRvModel.getItemList().add(BusinessGoodsItemRvModel.newInstance(newInstance));
                    }
                }
                List<BusinessInfoEntity> list2 = homeTopicEntity.mShopList;
                if (list2 != null) {
                    for (BusinessInfoEntity convertBusinessInfoEntity : list2) {
                        homeTopicRvModel.getShopList().add(HomeBusinessInfoRvModel.convertBusinessInfoEntity(convertBusinessInfoEntity, feedPayload));
                    }
                }
                if (feedPayload != null) {
                    str3 = feedPayload.mPageFilter;
                }
                homeTopicRvModel.setFilterParams(str3);
            } catch (Exception unused) {
            }
            return homeTopicRvModel;
        }
    }
}
