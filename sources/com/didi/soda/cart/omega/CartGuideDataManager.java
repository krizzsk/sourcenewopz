package com.didi.soda.cart.omega;

import com.didi.soda.cart.model.CartGuideModel;
import com.didi.soda.customer.blocks.BlocksConst;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \u000e2\u00020\u0001:\u0002\u000e\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0005J\u0016\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005J\u001c\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u0005J\u0018\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005R&\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/soda/cart/omega/CartGuideDataManager;", "", "()V", "itemDataMap", "", "", "Lcom/didi/soda/cart/model/CartGuideModel;", "clearData", "", "shopId", "deleteItemParams", "itemId", "getAllCartGuideParams", "getCartGuideParams", "Companion", "SingletonHolder", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CartGuideDataManager.kt */
public final class CartGuideDataManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final CartGuideDataManager f40087b = SingletonHolder.INSTANCE.getHolder();

    /* renamed from: a */
    private final Map<String, Map<String, CartGuideModel>> f40088a;

    public /* synthetic */ CartGuideDataManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private CartGuideDataManager() {
        this.f40088a = new LinkedHashMap();
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/soda/cart/omega/CartGuideDataManager$Companion;", "", "()V", "instance", "Lcom/didi/soda/cart/omega/CartGuideDataManager;", "getInstance", "()Lcom/didi/soda/cart/omega/CartGuideDataManager;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CartGuideDataManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final CartGuideDataManager getInstance() {
            return CartGuideDataManager.f40087b;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/soda/cart/omega/CartGuideDataManager$SingletonHolder;", "", "()V", "holder", "Lcom/didi/soda/cart/omega/CartGuideDataManager;", "getHolder", "()Lcom/didi/soda/cart/omega/CartGuideDataManager;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CartGuideDataManager.kt */
    private static final class SingletonHolder {
        public static final SingletonHolder INSTANCE = new SingletonHolder();
        private static final CartGuideDataManager holder = new CartGuideDataManager((DefaultConstructorMarker) null);

        private SingletonHolder() {
        }

        public final CartGuideDataManager getHolder() {
            return holder;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0043, code lost:
        if ((r4 == null || r4.isEmpty()) != false) goto L_0x0045;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.didi.soda.cart.model.CartGuideModel getCartGuideParams(java.lang.String r9, java.lang.String r10) {
        /*
            r8 = this;
            java.lang.String r0 = "shopId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "itemId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, com.didi.soda.cart.model.CartGuideModel>> r0 = r8.f40088a
            java.lang.Object r0 = r0.get(r9)
            java.util.Map r0 = (java.util.Map) r0
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0020
            boolean r3 = r0.isEmpty()
            if (r3 == 0) goto L_0x001e
            goto L_0x0020
        L_0x001e:
            r3 = 0
            goto L_0x0021
        L_0x0020:
            r3 = 1
        L_0x0021:
            if (r3 == 0) goto L_0x002a
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            java.util.Map r0 = (java.util.Map) r0
        L_0x002a:
            java.lang.Object r3 = r0.get(r10)
            if (r3 == 0) goto L_0x0045
            r4 = r3
            com.didi.soda.cart.model.CartGuideModel r4 = (com.didi.soda.cart.model.CartGuideModel) r4
            java.util.Map r4 = r4.getGuideParams()
            if (r4 == 0) goto L_0x0042
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x0040
            goto L_0x0042
        L_0x0040:
            r4 = 0
            goto L_0x0043
        L_0x0042:
            r4 = 1
        L_0x0043:
            if (r4 == 0) goto L_0x00a3
        L_0x0045:
            com.didi.soda.cart.model.CartGuideModel r3 = new com.didi.soda.cart.model.CartGuideModel
            r3.<init>()
            r3.setShopId(r9)
            r3.setItemId(r10)
            java.util.Map r4 = com.didi.soda.customer.foundation.tracker.OmegaCommonParamHelper.getGuideParamMap()
            r3.setGuideParams(r4)
            java.util.Map r4 = r3.getGuideParams()
            if (r4 != 0) goto L_0x005e
            goto L_0x009b
        L_0x005e:
            java.util.Map r4 = r3.getGuideParams()
            if (r4 == 0) goto L_0x009b
            java.util.Map r4 = r3.getGuideParams()
            if (r4 == 0) goto L_0x0093
            java.util.Map r4 = kotlin.jvm.internal.TypeIntrinsics.asMutableMap(r4)
            java.lang.String r5 = "lv1_filter"
            java.lang.Object r6 = r4.get(r5)
            boolean r7 = r6 instanceof java.lang.String
            if (r7 == 0) goto L_0x009b
            r7 = r6
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            int r7 = r7.length()
            if (r7 <= 0) goto L_0x0082
            r1 = 1
        L_0x0082:
            if (r1 == 0) goto L_0x009b
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r1 = com.didi.soda.customer.foundation.rpc.entity.topgun.FilterEntity.toMapParam(r6)
            java.lang.String r2 = "filterMap"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r4.put(r5, r1)
            goto L_0x009b
        L_0x0093:
            java.lang.NullPointerException r9 = new java.lang.NullPointerException
            java.lang.String r10 = "null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.String, kotlin.Any>"
            r9.<init>(r10)
            throw r9
        L_0x009b:
            r0.put(r10, r3)
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, com.didi.soda.cart.model.CartGuideModel>> r10 = r8.f40088a
            r10.put(r9, r0)
        L_0x00a3:
            com.didi.soda.cart.model.CartGuideModel r3 = (com.didi.soda.cart.model.CartGuideModel) r3
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.cart.omega.CartGuideDataManager.getCartGuideParams(java.lang.String, java.lang.String):com.didi.soda.cart.model.CartGuideModel");
    }

    public final void deleteItemParams(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "shopId");
        Intrinsics.checkNotNullParameter(str2, BlocksConst.ACTION_PARAMS_ITEM_ID);
        Map map = this.f40088a.get(str);
        if (!(map == null || map.isEmpty())) {
            map.put(str2, new CartGuideModel());
            this.f40088a.put(str, map);
        }
    }

    public final Map<String, CartGuideModel> getAllCartGuideParams(String str) {
        Intrinsics.checkNotNullParameter(str, "shopId");
        return this.f40088a.get(str);
    }

    public final void clearData(String str) {
        Map map;
        if (str != null && (map = this.f40088a.get(str)) != null) {
            map.clear();
        }
    }
}
