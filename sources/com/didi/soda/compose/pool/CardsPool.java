package com.didi.soda.compose.pool;

import com.didi.soda.compose.adapter.ItemCard;
import com.didi.soda.compose.adapter.ItemCardHolder;
import com.didi.soda.compose.card.BaseCard;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0005J \u0010\u0006\u001a\u0014\u0012\u0002\b\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\bJ \u0010\t\u001a\u00020\n2\u0016\u0010\u000b\u001a\u0012\u0012\u0002\b\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¨\u0006\f"}, mo175978d2 = {"Lcom/didi/soda/compose/pool/CardsPool;", "Lcom/didi/soda/compose/pool/BasePool;", "Lcom/didi/soda/compose/adapter/ItemCard;", "Lcom/didi/soda/compose/adapter/ItemCardHolder;", "Lcom/didi/soda/compose/card/BaseCard;", "()V", "getItemCard", "template", "", "register", "", "clz", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: CardsPool.kt */
public final class CardsPool extends BasePool<ItemCard<?, ? extends ItemCardHolder<BaseCard>>> {
    public void register(ItemCard<?, ? extends ItemCardHolder<BaseCard>> itemCard) {
        Intrinsics.checkParameterIsNotNull(itemCard, "clz");
        getArrayList().add(itemCard);
    }

    public final ItemCard<?, ItemCardHolder<BaseCard>> getItemCard(String str) {
        Intrinsics.checkParameterIsNotNull(str, "template");
        Iterator it = getArrayList().iterator();
        while (it.hasNext()) {
            ItemCard<?, ItemCardHolder<BaseCard>> itemCard = (ItemCard) it.next();
            if (Intrinsics.areEqual((Object) itemCard.templateId(), (Object) str)) {
                return itemCard;
            }
        }
        return null;
    }
}
