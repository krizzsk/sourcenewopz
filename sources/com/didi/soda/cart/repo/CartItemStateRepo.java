package com.didi.soda.cart.repo;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.CloneUtil;
import com.didi.soda.customer.repo.model.ItemState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00182\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003J\u001a\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003J\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u0003J\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00032\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004J2\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u001a\u0010\u0015\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0002\u0018\u00010\u0016J,\u0010\u0017\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0014\u0010\u0015\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u0016R\u0010\u0010\u0007\u001a\u00020\u0003XD¢\u0006\u0004\n\u0002\b\b¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/soda/cart/repo/CartItemStateRepo;", "Lcom/didi/app/nova/skeleton/repo/Repo;", "Ljava/util/HashMap;", "", "Ljava/util/ArrayList;", "Lcom/didi/soda/customer/repo/model/ItemState;", "()V", "TAG", "TAG$1", "getMainGoodState", "shopId", "uniKey", "getState", "getValue", "setState", "", "itemStateMap", "subscribe", "Lcom/didi/app/nova/skeleton/repo/Subscription;", "pageContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "action", "Lcom/didi/app/nova/skeleton/repo/Action1;", "subscribeList", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CartItemStateRepo.kt */
public final class CartItemStateRepo extends Repo<HashMap<String, ArrayList<ItemState>>> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: b */
    private static final String f40095b = "CartItemStateRepo";

    /* renamed from: a */
    private final String f40096a = f40095b;

    public final ItemState getState(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "shopId");
        HashMap hashMap = (HashMap) getValue();
        if (hashMap == null || !hashMap.containsKey(str) || hashMap.get(str) == null) {
            return null;
        }
        ArrayList arrayList = (ArrayList) hashMap.get(str);
        ItemState itemState = new ItemState();
        Intrinsics.checkNotNull(arrayList);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ItemState itemState2 = (ItemState) it.next();
            if (Intrinsics.areEqual((Object) itemState2.itemUniKey, (Object) str2)) {
                itemState.itemId = itemState2.itemId;
                itemState.itemUniKey = itemState2.itemUniKey;
                itemState.amount += itemState2.amount;
            }
        }
        return itemState;
    }

    public final ItemState getMainGoodState(String str, String str2) {
        String str3;
        Intrinsics.checkNotNullParameter(str, "shopId");
        ArrayList<ItemState> value = getValue(str);
        if (value != null) {
            Iterator<ItemState> it = value.iterator();
            while (it.hasNext()) {
                ItemState next = it.next();
                if (next == null) {
                    str3 = null;
                } else {
                    str3 = next.itemUniKey;
                }
                if (Intrinsics.areEqual((Object) str3, (Object) str2)) {
                    boolean z = false;
                    if (next != null && next.mduType == 1) {
                        z = true;
                    }
                    if (z) {
                        LogUtil.m29100d(this.f40096a, Intrinsics.stringPlus("getMainGoodState:", Integer.valueOf(next.amount)));
                        return next;
                    }
                }
            }
        }
        return null;
    }

    public final ArrayList<ItemState> getValue(String str) {
        Intrinsics.checkNotNullParameter(str, "shopId");
        HashMap hashMap = (HashMap) super.getValue();
        if (hashMap == null || !hashMap.containsKey(str)) {
            return null;
        }
        Object deepClone = CloneUtil.deepClone(hashMap.get(str));
        if (deepClone != null) {
            return (ArrayList) deepClone;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<com.didi.soda.customer.repo.model.ItemState>");
    }

    public final void setState(String str, ArrayList<ItemState> arrayList) {
        Intrinsics.checkNotNullParameter(str, "shopId");
        LogUtil.m29100d(this.f40096a, "setState");
        HashMap hashMap = (HashMap) getValue();
        if (hashMap == null) {
            hashMap = new HashMap();
        }
        if (arrayList == null || arrayList.isEmpty()) {
            hashMap.remove(str);
        } else {
            hashMap.put(str, arrayList);
        }
        super.setValue(hashMap);
    }

    public final Subscription subscribe(String str, ScopeContext scopeContext, Action1<HashMap<String, ItemState>> action1) {
        Intrinsics.checkNotNullParameter(str, "shopId");
        Intrinsics.checkNotNullParameter(scopeContext, "pageContext");
        Subscription subscribe = super.subscribe(scopeContext, new Action1(str, this, action1) {
            public final /* synthetic */ String f$0;
            public final /* synthetic */ CartItemStateRepo f$1;
            public final /* synthetic */ Action1 f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void call(Object obj) {
                CartItemStateRepo.m28534a(this.f$0, this.f$1, this.f$2, (HashMap) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "super.subscribe(pageCont…\n            }\n        })");
        return subscribe;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28534a(String str, CartItemStateRepo cartItemStateRepo, Action1 action1, HashMap hashMap) {
        Intrinsics.checkNotNullParameter(str, "$shopId");
        Intrinsics.checkNotNullParameter(cartItemStateRepo, "this$0");
        if (hashMap != null && hashMap.containsKey(str) && hashMap.get(str) != null) {
            ArrayList arrayList = (ArrayList) hashMap.get(str);
            HashMap hashMap2 = new HashMap();
            Intrinsics.checkNotNull(arrayList);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ItemState itemState = (ItemState) it.next();
                ItemState itemState2 = new ItemState();
                itemState2.mduId = itemState.mduId;
                itemState2.itemId = itemState.itemId;
                itemState2.itemUniKey = itemState.itemUniKey;
                if (!hashMap2.containsKey(itemState.itemUniKey) || hashMap2.get(itemState.itemUniKey) == null) {
                    itemState2.amount = itemState.amount;
                } else {
                    int i = itemState.amount;
                    Object obj = hashMap2.get(itemState.itemUniKey);
                    Intrinsics.checkNotNull(obj);
                    itemState2.amount = i + ((ItemState) obj).amount;
                }
                if (itemState2.itemUniKey != null) {
                    String str2 = itemState2.itemUniKey;
                    Intrinsics.checkNotNullExpressionValue(str2, "newState.itemUniKey");
                    hashMap2.put(str2, itemState2);
                }
                String str3 = cartItemStateRepo.f40096a;
                LogUtil.m29104i(str3, "subscribe  map = " + itemState2.itemId + ",amount = " + itemState2.amount);
            }
            if (action1 != null) {
                action1.call(hashMap2);
            }
        } else if (action1 != null) {
            action1.call(new HashMap());
        }
    }

    public final Subscription subscribeList(String str, ScopeContext scopeContext, Action1<ArrayList<ItemState>> action1) {
        Intrinsics.checkNotNullParameter(str, "shopId");
        Intrinsics.checkNotNullParameter(scopeContext, "pageContext");
        Subscription subscribe = super.subscribe(scopeContext, new Action1(str, action1) {
            public final /* synthetic */ String f$0;
            public final /* synthetic */ Action1 f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void call(Object obj) {
                CartItemStateRepo.m28533a(this.f$0, this.f$1, (HashMap) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(subscribe, "super.subscribe(pageCont…\n            }\n        })");
        return subscribe;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m28533a(String str, Action1 action1, HashMap hashMap) {
        Intrinsics.checkNotNullParameter(str, "$shopId");
        if (hashMap != null && hashMap.containsKey(str) && hashMap.get(str) != null) {
            ArrayList arrayList = (ArrayList) hashMap.get(str);
            if (action1 != null) {
                action1.call(arrayList);
            }
        } else if (action1 != null) {
            action1.call(new ArrayList());
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/cart/repo/CartItemStateRepo$Companion;", "", "()V", "TAG", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CartItemStateRepo.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
