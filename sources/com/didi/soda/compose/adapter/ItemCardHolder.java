package com.didi.soda.compose.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.didi.soda.compose.util.Constants;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001f\u0010\f\u001a\u0002H\r\"\b\b\u0001\u0010\r*\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fH\u0014¢\u0006\u0002\u0010\u0010J\r\u0010\u0011\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\bJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u0013\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00028\u0000¢\u0006\u0002\u0010\nR\u001e\u0010\u0006\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/soda/compose/adapter/ItemCardHolder;", "BaseCard", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "mItem", "getMItem", "()Ljava/lang/Object;", "setMItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "findViewById", "S", "id", "", "(I)Landroid/view/View;", "getItem", "init", "", "layoutType", "", "setItem", "item", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ItemCardHolder.kt */
public class ItemCardHolder<BaseCard> extends RecyclerView.ViewHolder {

    /* renamed from: a */
    private BaseCard f40112a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ItemCardHolder(View view) {
        super(view);
        Intrinsics.checkParameterIsNotNull(view, "itemView");
    }

    public final BaseCard getMItem() {
        return this.f40112a;
    }

    public final void setMItem(BaseCard basecard) {
        this.f40112a = basecard;
    }

    public final BaseCard getItem() {
        return this.f40112a;
    }

    public final void setItem(BaseCard basecard) {
        this.f40112a = basecard;
    }

    /* access modifiers changed from: protected */
    public <S extends View> S findViewById(int i) {
        S findViewById = this.itemView.findViewById(i);
        if (findViewById != null) {
            return findViewById;
        }
        throw new TypeCastException("null cannot be cast to non-null type S");
    }

    public final void init(String str) {
        StaggeredGridLayoutManager.LayoutParams layoutParams;
        Intrinsics.checkParameterIsNotNull(str, "layoutType");
        if (Intrinsics.areEqual((Object) Constants.SINGLE_COL_LAYOUT, (Object) str)) {
            View view = this.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view, "itemView");
            if (view.getLayoutParams() instanceof StaggeredGridLayoutManager.LayoutParams) {
                View view2 = this.itemView;
                Intrinsics.checkExpressionValueIsNotNull(view2, "itemView");
                ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                if (layoutParams2 != null) {
                    layoutParams = (StaggeredGridLayoutManager.LayoutParams) layoutParams2;
                    layoutParams.height = -2;
                    layoutParams.width = -1;
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams");
                }
            } else {
                layoutParams = new StaggeredGridLayoutManager.LayoutParams(-1, -2);
            }
            layoutParams.setFullSpan(true);
            View view3 = this.itemView;
            Intrinsics.checkExpressionValueIsNotNull(view3, "itemView");
            view3.setLayoutParams(layoutParams);
        }
    }
}
