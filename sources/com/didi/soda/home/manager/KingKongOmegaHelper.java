package com.didi.soda.home.manager;

import android.text.TextUtils;
import com.didi.soda.customer.foundation.rpc.entity.TagEntity;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.OnceActionUtil;
import com.didi.soda.customer.widget.text.RichTextParser;
import com.didi.soda.datasource.parser.FeedPayload;
import com.didi.soda.home.kingkong.KingKongItemModel;
import com.didi.soda.home.kingkong.KingKongModel;
import com.google.gson.JsonArray;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo175978d2 = {"Lcom/didi/soda/home/manager/KingKongOmegaHelper;", "", "()V", "mActionPool", "Lcom/didi/soda/customer/foundation/util/OnceActionUtil$ActionPool;", "onCategoryRedFlagSW", "", "model", "Lcom/didi/soda/home/kingkong/KingKongItemModel;", "position", "", "onKingKongItemCk", "onKingKongItemShow", "onKingKongShow", "Lcom/didi/soda/home/kingkong/KingKongModel;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: KingKongOmegaHelper.kt */
public final class KingKongOmegaHelper {
    public static final KingKongOmegaHelper INSTANCE = new KingKongOmegaHelper();

    /* renamed from: a */
    private static OnceActionUtil.ActionPool f42680a = new OnceActionUtil.ActionPool();

    private KingKongOmegaHelper() {
    }

    @JvmStatic
    public static final void onKingKongShow(KingKongModel kingKongModel) {
        int size;
        Intrinsics.checkNotNullParameter(kingKongModel, "model");
        JsonArray jsonArray = new JsonArray();
        HashMap hashMap = new HashMap();
        if (kingKongModel.getItems() != null && kingKongModel.getItems().size() > 0 && (size = kingKongModel.getItems().size()) > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                KingKongItemModel kingKongItemModel = kingKongModel.getItems().get(i);
                if (kingKongItemModel != null) {
                    Map map = hashMap;
                    map.put("activity_id", String.valueOf(kingKongItemModel.getActivityId()));
                    map.put(ParamConst.PARAM_CATEGORY_ID, String.valueOf(kingKongItemModel.getCateId()));
                    map.put("index", String.valueOf(i));
                    map.put("activity_type", String.valueOf(kingKongItemModel.getActivityCate()));
                    map.put("type", String.valueOf(kingKongItemModel.getType()));
                    jsonArray.add(GsonUtil.toJson(hashMap));
                }
                if (i2 >= size) {
                    break;
                }
                i = i2;
            }
        }
        Object[] objArr = new Object[3];
        objArr[0] = EventConst.KingKong.SAILING_C_X_HOMEPAGE_DIAMOND_BAR_SW;
        FeedPayload payload = kingKongModel.getPayload();
        String str = null;
        objArr[1] = payload == null ? null : Integer.valueOf(payload.mComponentIndex);
        FeedPayload payload2 = kingKongModel.getPayload();
        if (payload2 != null) {
            str = payload2.mTraceId;
        }
        objArr[2] = str;
        f42680a.doAction(new KingKongOmegaHelper$onKingKongShow$onceAction$1(jsonArray, kingKongModel, objArr));
    }

    @JvmStatic
    public static final void onKingKongItemShow(KingKongItemModel kingKongItemModel, int i) {
        Intrinsics.checkNotNullParameter(kingKongItemModel, "model");
        HashMap hashMap = new HashMap();
        Map map = hashMap;
        map.put("activity_id", String.valueOf(kingKongItemModel.getActivityId()));
        map.put(ParamConst.PARAM_CATEGORY_ID, String.valueOf(kingKongItemModel.getCateId()));
        map.put("activity_type", String.valueOf(kingKongItemModel.getActivityCate()));
        map.put("type", String.valueOf(kingKongItemModel.getType()));
        Object[] objArr = new Object[6];
        objArr[0] = EventConst.KingKong.SAILING_C_X_HOMEPAGE_DIAMOND_REALEXPOSURE_SW;
        objArr[1] = Integer.valueOf(i);
        objArr[2] = kingKongItemModel.getCateId();
        objArr[3] = kingKongItemModel.getActivityId();
        objArr[4] = kingKongItemModel.getActivityCate();
        FeedPayload payload = kingKongItemModel.getPayload();
        objArr[5] = payload == null ? null : payload.mTraceId;
        f42680a.doAction(new KingKongOmegaHelper$onKingKongItemShow$onceAction$1(hashMap, kingKongItemModel, i, objArr));
    }

    @JvmStatic
    public static final void onKingKongItemCk(KingKongItemModel kingKongItemModel, int i) {
        String str;
        String str2;
        String num;
        String str3;
        Intrinsics.checkNotNullParameter(kingKongItemModel, "model");
        Map hashMap = new HashMap();
        hashMap.put("activity_id", String.valueOf(kingKongItemModel.getActivityId()));
        hashMap.put(ParamConst.PARAM_CATEGORY_ID, String.valueOf(kingKongItemModel.getCateId()));
        hashMap.put("activity_type", String.valueOf(kingKongItemModel.getActivityCate()));
        hashMap.put("type", String.valueOf(kingKongItemModel.getType()));
        OmegaTracker.Builder addAllEventParam = OmegaTracker.Builder.create(EventConst.KingKong.SAILING_C_X_HOMEPAGE_DIAMOND_CK).addAllEventParam(hashMap);
        FeedPayload payload = kingKongItemModel.getPayload();
        String str4 = "";
        if (payload == null || (str3 = payload.mRecId) == null || (str = str3.toString()) == null) {
            str = str4;
        }
        OmegaTracker.Builder addEventParam = addAllEventParam.addEventParam("rec_id", str);
        FeedPayload payload2 = kingKongItemModel.getPayload();
        if (payload2 == null || (str2 = payload2.mPageId) == null) {
            str2 = str4;
        }
        String lowerCase = str2.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam("page", lowerCase).addEventParam("index", String.valueOf(i));
        String resourceId = kingKongItemModel.getResourceId();
        if (resourceId == null) {
            resourceId = str4;
        }
        OmegaTracker.Builder addEventParam3 = addEventParam2.addEventParam("resource_id", resourceId);
        String url = kingKongItemModel.getUrl();
        if (url == null) {
            url = str4;
        }
        OmegaTracker.Builder addEventParam4 = addEventParam3.addEventParam("activity_url", url);
        FeedPayload payload3 = kingKongItemModel.getPayload();
        if (!(payload3 == null || (num = Integer.valueOf(payload3.mComponentIndex).toString()) == null)) {
            str4 = num;
        }
        addEventParam4.addEventParam(ParamConst.PARAM_ABSOLUTE_POSITION, str4).build().track();
    }

    @JvmStatic
    public static final void onCategoryRedFlagSW(KingKongItemModel kingKongItemModel, int i) {
        CharSequence charSequence;
        String str;
        Intrinsics.checkNotNullParameter(kingKongItemModel, "model");
        if (kingKongItemModel.getTag() != null) {
            TagEntity tag = kingKongItemModel.getTag();
            String str2 = null;
            String str3 = "";
            if (!TextUtils.isEmpty(tag == null ? null : tag.getContent())) {
                TagEntity tag2 = kingKongItemModel.getTag();
                if (tag2 != null) {
                    str2 = tag2.getContent();
                }
                charSequence = RichTextParser.parseText(str2);
            } else {
                charSequence = str3;
            }
            Map hashMap = new HashMap();
            hashMap.put(ParamConst.PARAM_CATEGORY_ID, String.valueOf(kingKongItemModel.getCateId()));
            FeedPayload payload = kingKongItemModel.getPayload();
            if (!(payload == null || (str = payload.mPageId) == null)) {
                str3 = str;
            }
            String lowerCase = str3.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            hashMap.put("page", lowerCase);
            hashMap.put(ParamConst.PARAM_FLAG_LOCATION, String.valueOf(i));
            hashMap.put(ParamConst.PARAM_FLAG_CONTENT, String.valueOf(charSequence));
            OmegaTracker.Builder.create(EventConst.KingKong.SAILING_C_X_CATEGORY_REDFLAG_SW).addAllEventParam(hashMap).build().track();
        }
    }
}
