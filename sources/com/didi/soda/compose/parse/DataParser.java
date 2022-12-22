package com.didi.soda.compose.parse;

import com.didi.soda.compose.card.BaseCard;
import com.didi.soda.compose.entity.CardEntity;
import com.didi.soda.compose.entity.ComposeEntity;
import com.didi.soda.compose.entity.LayoutEntity;
import com.didi.soda.compose.log.ComposeLogUtil;
import com.didi.soda.compose.service.ServiceManager;
import com.didi.soda.compose.util.ComposeGsonUtil;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u0003\u001a\u00020\u0004J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/soda/compose/parse/DataParser;", "", "()V", "hasMore", "", "idCardsMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/didi/soda/compose/card/BaseCard;", "findCardById", "template", "parseCardData", "Ljava/util/LinkedList;", "entity", "Lcom/didi/soda/compose/entity/ComposeEntity;", "service", "Lcom/didi/soda/compose/service/ServiceManager;", "jsonObject", "Lorg/json/JSONObject;", "Companion", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: DataParser.kt */
public final class DataParser {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "DataParser";

    /* renamed from: a */
    private boolean f40137a;

    /* renamed from: b */
    private ConcurrentHashMap<String, BaseCard> f40138b = new ConcurrentHashMap<>();

    public final LinkedList<BaseCard> parseCardData(ComposeEntity composeEntity, ServiceManager serviceManager) {
        Intrinsics.checkParameterIsNotNull(composeEntity, "entity");
        Intrinsics.checkParameterIsNotNull(serviceManager, "service");
        LinkedList<BaseCard> linkedList = new LinkedList<>();
        this.f40137a = composeEntity.getHasMore();
        List<LayoutEntity> layouts = composeEntity.getLayouts();
        if (layouts != null) {
            for (LayoutEntity layoutEntity : layouts) {
                List<BaseCard> cards = layoutEntity.getCards();
                if (cards != null) {
                    int size = cards.size();
                    for (int i = 0; i < size; i++) {
                        BaseCard baseCard = new BaseCard();
                        baseCard.setMData(cards.get(i).getMData());
                        baseCard.setMServiceManager(serviceManager);
                        baseCard.setMLayoutType(layoutEntity.getType());
                        baseCard.setMTemplate(cards.get(i).getMTemplate());
                        baseCard.setMRenderType(cards.get(i).getMRenderType());
                        if (baseCard.getMTemplate() != null) {
                            Map map = this.f40138b;
                            String mTemplate = baseCard.getMTemplate();
                            if (mTemplate == null) {
                                Intrinsics.throwNpe();
                            }
                            map.put(mTemplate, baseCard);
                        }
                        linkedList.add(baseCard);
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String format = String.format("card.mData = %s,card layoutType = %s,card renderType = %s,card postion = %s", Arrays.copyOf(new Object[]{baseCard.getMData(), baseCard.getMLayoutType(), baseCard.getMRenderType()}, 3));
                        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
                        ComposeLogUtil.m28548i(TAG, format);
                    }
                }
            }
        }
        return linkedList;
    }

    public final LinkedList<BaseCard> parseCardData(JSONObject jSONObject, ServiceManager serviceManager) {
        Intrinsics.checkParameterIsNotNull(jSONObject, "jsonObject");
        Intrinsics.checkParameterIsNotNull(serviceManager, "service");
        LinkedList<BaseCard> linkedList = new LinkedList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("layouts");
        this.f40137a = jSONObject.optBoolean("hasMore");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            int i = 0;
            while (i < length) {
                Object obj = optJSONArray.get(i);
                if (obj != null) {
                    JSONObject jSONObject2 = (JSONObject) obj;
                    String optString = jSONObject2.optString("type");
                    Object fromJson = ComposeGsonUtil.fromJson(jSONObject2.optString("cards"), new DataParser$parseCardData$cardsEntity$1().getType());
                    Intrinsics.checkExpressionValueIsNotNull(fromJson, "ComposeGsonUtil.fromJson…{}.type\n                )");
                    List list = (List) fromJson;
                    int size = list.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        BaseCard baseCard = new BaseCard();
                        baseCard.setMData(((CardEntity) list.get(i2)).getData());
                        baseCard.setMServiceManager(serviceManager);
                        baseCard.setMLayoutType(optString);
                        baseCard.setMTemplate(((CardEntity) list.get(i2)).getTemplate());
                        baseCard.setMRenderType(((CardEntity) list.get(i2)).getRenderType());
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String format = String.format("card.mData = %s,card layoutType = %s,card renderType = %s", Arrays.copyOf(new Object[]{baseCard.getMData(), baseCard.getMLayoutType(), baseCard.getMRenderType()}, 3));
                        Intrinsics.checkExpressionValueIsNotNull(format, "java.lang.String.format(format, *args)");
                        ComposeLogUtil.m28544d(TAG, format);
                        if (baseCard.getMTemplate() != null) {
                            Map map = this.f40138b;
                            String mTemplate = baseCard.getMTemplate();
                            if (mTemplate == null) {
                                Intrinsics.throwNpe();
                            }
                            map.put(mTemplate, baseCard);
                        }
                        linkedList.add(baseCard);
                    }
                    i++;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type org.json.JSONObject");
                }
            }
        }
        return linkedList;
    }

    public final BaseCard findCardById(String str) {
        Intrinsics.checkParameterIsNotNull(str, "template");
        return this.f40138b.get(str);
    }

    public final boolean hasMore() {
        return this.f40137a;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/compose/parse/DataParser$Companion;", "", "()V", "TAG", "", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: DataParser.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
