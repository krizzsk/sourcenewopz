package com.didi.soda.compose.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.didi.soda.compose.adapter.ItemCardHolder;
import com.didi.soda.compose.card.BaseCard;
import com.didi.soda.compose.util.ComposeGsonUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0010\b\u0001\u0010\u0002 \u0001*\b\u0012\u0004\u0012\u00020\u00040\u00032\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u001d\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u00012\u0006\u0010\n\u001a\u00020\u0004H&¢\u0006\u0002\u0010\u000bJ\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\rH&J\u001b\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u00012\u0006\u0010\u000f\u001a\u00020\u0004¢\u0006\u0002\u0010\u000bJ\u001d\u0010\u0010\u001a\u00028\u00012\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H&¢\u0006\u0002\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u001aH&¨\u0006\u001b"}, mo175978d2 = {"Lcom/didi/soda/compose/adapter/ItemCard;", "T", "VH", "Lcom/didi/soda/compose/adapter/ItemCardHolder;", "Lcom/didi/soda/compose/card/BaseCard;", "", "()V", "bind", "", "holder", "card", "(Lcom/didi/soda/compose/adapter/ItemCardHolder;Lcom/didi/soda/compose/card/BaseCard;)V", "bindDataType", "Ljava/lang/Class;", "bindViewHolder", "item", "create", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Lcom/didi/soda/compose/adapter/ItemCardHolder;", "extraCanBindCondition", "", "(Ljava/lang/Object;)Z", "templateId", "", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ItemCard.kt */
public abstract class ItemCard<T, VH extends ItemCardHolder<BaseCard>> {
    public abstract void bind(VH vh, BaseCard baseCard);

    public abstract Class<T> bindDataType();

    public abstract VH create(LayoutInflater layoutInflater, ViewGroup viewGroup);

    public boolean extraCanBindCondition(T t) {
        return true;
    }

    public abstract String templateId();

    public final void bindViewHolder(VH vh, BaseCard baseCard) {
        Intrinsics.checkParameterIsNotNull(vh, "holder");
        Intrinsics.checkParameterIsNotNull(baseCard, "item");
        if ((baseCard.getMData() instanceof JSONObject) || (baseCard.getMData() instanceof String)) {
            baseCard.setMData(ComposeGsonUtil.fromJson(String.valueOf(baseCard.getMData()), bindDataType()));
        }
        vh.setMItem(baseCard);
        bind(vh, baseCard);
    }
}
