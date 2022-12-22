package com.didi.soda.cart.manager.task;

import com.didi.soda.cart.omega.FloatingCartOmegaHelper;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartItemEntity;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.util.GsonUtil;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0010J,\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00102\b\u0010\u0017\u001a\u0004\u0018\u00010\u00102\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/soda/cart/manager/task/CartLoadingTrack;", "", "()V", "clickTimeList", "", "", "getLastDuration", "getGetLastDuration", "()J", "getWholeDuration", "getGetWholeDuration", "isContinuous", "", "()Z", "trackInfo", "", "", "Lcom/didi/soda/cart/manager/task/TrackModel;", "addTime", "", "itemId", "track", "shop", "cart", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/cart/CartInfoEntity;", "ex", "Lcom/didi/soda/customer/foundation/rpc/net/SFRpcException;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CartLoadingTrack.kt */
public final class CartLoadingTrack {

    /* renamed from: a */
    private final Map<String, TrackModel> f39998a = new LinkedHashMap();

    /* renamed from: b */
    private final List<Long> f39999b = new ArrayList();

    /* renamed from: a */
    private final long m28504a() {
        if (!this.f39999b.isEmpty()) {
            return System.currentTimeMillis() - ((Number) CollectionsKt.first(this.f39999b)).longValue();
        }
        return 0;
    }

    /* renamed from: b */
    private final long m28505b() {
        if (!this.f39999b.isEmpty()) {
            return System.currentTimeMillis() - ((Number) CollectionsKt.last(this.f39999b)).longValue();
        }
        return 0;
    }

    /* renamed from: c */
    private final boolean m28506c() {
        return this.f39999b.size() > 1;
    }

    public final void addTime(String str) {
        Intrinsics.checkNotNullParameter(str, BlocksConst.ACTION_PARAMS_ITEM_ID);
        Map<String, TrackModel> map = this.f39998a;
        TrackModel trackModel = map.get(str);
        if (trackModel == null) {
            trackModel = new TrackModel(str, new ArrayList(), 0, 4, (DefaultConstructorMarker) null);
            map.put(str, trackModel);
        }
        long currentTimeMillis = System.currentTimeMillis();
        trackModel.getTime().add(Long.valueOf(currentTimeMillis));
        this.f39999b.add(Long.valueOf(currentTimeMillis));
    }

    public final void track(String str, String str2, CartInfoEntity cartInfoEntity, SFRpcException sFRpcException) {
        boolean z;
        String str3;
        TrackModel trackModel;
        String str4 = str;
        Intrinsics.checkNotNullParameter(str4, "shop");
        if (cartInfoEntity != null) {
            str4 = cartInfoEntity.getShopId();
            str3 = cartInfoEntity.getCartId();
            List<CartItemEntity> items = cartInfoEntity.getItems();
            if (items != null) {
                for (CartItemEntity cartItemEntity : items) {
                    if (cartItemEntity.getMduType() == 1 && (trackModel = this.f39998a.get(cartItemEntity.getItemId())) != null) {
                        trackModel.setCopy_num(cartItemEntity.getAmount());
                    }
                }
            }
            z = true;
        } else {
            str3 = str2;
            z = false;
        }
        FloatingCartOmegaHelper.Companion companion = FloatingCartOmegaHelper.Companion;
        String json = GsonUtil.toJson(this.f39998a.values());
        Intrinsics.checkNotNullExpressionValue(json, "toJson(trackInfo.values)");
        companion.trackAddItemRefresh(str4, str3, json, z);
        FloatingCartOmegaHelper.Companion.trackAddEnd(!z, m28506c(), m28504a(), m28505b(), CartLoadingTrackKt.m28507a(cartInfoEntity));
        this.f39998a.clear();
        this.f39999b.clear();
    }
}
