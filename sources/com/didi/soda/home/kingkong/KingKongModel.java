package com.didi.soda.home.kingkong;

import com.didi.app.nova.support.view.recyclerview.binder.RecyclerModel;
import com.didi.soda.customer.foundation.rpc.entity.topgun.CategoryEntity;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.datasource.parser.FeedPayload;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/soda/home/kingkong/KingKongModel;", "Lcom/didi/app/nova/support/view/recyclerview/binder/RecyclerModel;", "()V", "items", "Ljava/util/ArrayList;", "Lcom/didi/soda/home/kingkong/KingKongItemModel;", "Lkotlin/collections/ArrayList;", "getItems", "()Ljava/util/ArrayList;", "setItems", "(Ljava/util/ArrayList;)V", "payload", "Lcom/didi/soda/datasource/parser/FeedPayload;", "getPayload", "()Lcom/didi/soda/datasource/parser/FeedPayload;", "setPayload", "(Lcom/didi/soda/datasource/parser/FeedPayload;)V", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: KingKongModel.kt */
public final class KingKongModel implements RecyclerModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private ArrayList<KingKongItemModel> f42668a = new ArrayList<>();

    /* renamed from: b */
    private FeedPayload f42669b;

    @JvmStatic
    public static final KingKongModel convert(JsonObject jsonObject, FeedPayload feedPayload) {
        return Companion.convert(jsonObject, feedPayload);
    }

    public final ArrayList<KingKongItemModel> getItems() {
        return this.f42668a;
    }

    public final void setItems(ArrayList<KingKongItemModel> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.f42668a = arrayList;
    }

    public final FeedPayload getPayload() {
        return this.f42669b;
    }

    public final void setPayload(FeedPayload feedPayload) {
        this.f42669b = feedPayload;
    }

    @Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, mo175978d2 = {"Lcom/didi/soda/home/kingkong/KingKongModel$Companion;", "", "()V", "convert", "Lcom/didi/soda/home/kingkong/KingKongModel;", "dataJson", "Lcom/google/gson/JsonObject;", "payload", "Lcom/didi/soda/datasource/parser/FeedPayload;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: KingKongModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final KingKongModel convert(JsonObject jsonObject, FeedPayload feedPayload) {
            Intrinsics.checkNotNullParameter(jsonObject, "dataJson");
            Intrinsics.checkNotNullParameter(feedPayload, "payload");
            KingKongModel kingKongModel = new KingKongModel();
            JsonObject asJsonObject = jsonObject.getAsJsonObject("data");
            JsonElement jsonElement = asJsonObject == null ? null : asJsonObject.get(FirebaseAnalytics.Param.ITEMS);
            kingKongModel.setPayload(feedPayload);
            List<CategoryEntity> list = (List) GsonUtil.fromJson(jsonElement, new KingKongModel$Companion$convert$type$1().getType());
            kingKongModel.getItems().clear();
            ArrayList arrayList = new ArrayList();
            if (list == null) {
                return kingKongModel;
            }
            for (CategoryEntity categoryEntity : list) {
                if (categoryEntity != null) {
                    arrayList.add(new KingKongItemModel(categoryEntity, feedPayload));
                }
            }
            kingKongModel.getItems().addAll(arrayList);
            return kingKongModel;
        }
    }
}
