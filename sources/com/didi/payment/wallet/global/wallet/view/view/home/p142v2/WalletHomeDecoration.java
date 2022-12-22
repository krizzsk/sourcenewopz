package com.didi.payment.wallet.global.wallet.view.view.home.p142v2;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.IData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B5\u0012\u0016\u0010\u0002\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ(\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J \u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J \u0010$\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J \u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u00072\u0006\u0010'\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010(\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010)\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u001a\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR*\u0010\u0002\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000e¨\u0006*"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/WalletHomeDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "list", "", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/WalletHomeHolderData;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/IData;", "left", "", "right", "gap", "(Ljava/util/List;III)V", "getGap", "()I", "setGap", "(I)V", "getLeft", "setLeft", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "getRight", "setRight", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "onDraw", "c", "Landroid/graphics/Canvas;", "onDrawOver", "setItemOffsets", "index", "rowCount", "setOneColumnOffsets", "setTwoColumnOffsets", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeDecoration */
/* compiled from: WalletHomeDecoration.kt */
public final class WalletHomeDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: a */
    private List<WalletHomeHolderData<? extends IData>> f32634a;

    /* renamed from: b */
    private int f32635b;

    /* renamed from: c */
    private int f32636c;

    /* renamed from: d */
    private int f32637d;

    public WalletHomeDecoration(List<WalletHomeHolderData<? extends IData>> list, int i, int i2, int i3) {
        this.f32634a = list;
        this.f32635b = i;
        this.f32636c = i2;
        this.f32637d = i3;
    }

    public final int getGap() {
        return this.f32637d;
    }

    public final int getLeft() {
        return this.f32635b;
    }

    public final List<WalletHomeHolderData<? extends IData>> getList() {
        return this.f32634a;
    }

    public final int getRight() {
        return this.f32636c;
    }

    public final void setGap(int i) {
        this.f32637d = i;
    }

    public final void setLeft(int i) {
        this.f32635b = i;
    }

    public final void setList(List<WalletHomeHolderData<? extends IData>> list) {
        this.f32634a = list;
    }

    public final void setRight(int i) {
        this.f32636c = i;
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(canvas, "c");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.onDraw(canvas, recyclerView, state);
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(canvas, "c");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.onDrawOver(canvas, recyclerView, state);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        Integer localIndex;
        Intrinsics.checkNotNullParameter(rect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        List<WalletHomeHolderData<? extends IData>> list = this.f32634a;
        if (childAdapterPosition < (list == null ? 0 : list.size())) {
            List<WalletHomeHolderData<? extends IData>> list2 = this.f32634a;
            Integer num = null;
            WalletHomeHolderData walletHomeHolderData = list2 == null ? null : list2.get(childAdapterPosition);
            if (walletHomeHolderData != null) {
                num = walletHomeHolderData.getViewType();
            }
            if (num != null && num.intValue() == 2) {
                Integer localIndex2 = walletHomeHolderData.getLocalIndex();
                if (localIndex2 != null) {
                    m23085a(localIndex2.intValue(), 3, rect);
                }
            } else if (num != null && num.intValue() == 3) {
                Integer localIndex3 = walletHomeHolderData.getLocalIndex();
                if (localIndex3 != null) {
                    m23086a(localIndex3.intValue(), rect);
                }
            } else if (num != null && num.intValue() == 4 && (localIndex = walletHomeHolderData.getLocalIndex()) != null) {
                localIndex.intValue();
                m23087a(rect);
            }
        }
    }

    /* renamed from: a */
    private final void m23085a(int i, int i2, Rect rect) {
        int i3 = i % i2;
        if (i3 == 0) {
            rect.left = this.f32635b;
            rect.right = 0;
        } else if (i3 == i2 - 1) {
            rect.left = 0;
            rect.right = this.f32636c;
        } else {
            rect.left = this.f32637d;
            rect.right = this.f32637d;
        }
    }

    /* renamed from: a */
    private final void m23086a(int i, Rect rect) {
        int i2 = i % 2;
        if (i2 == 0) {
            rect.left = this.f32635b;
            rect.right = this.f32637d / 2;
        } else if (i2 == 1) {
            rect.left = this.f32637d / 2;
            rect.right = this.f32636c;
        }
    }

    /* renamed from: a */
    private final void m23087a(Rect rect) {
        rect.left = this.f32635b;
        rect.right = this.f32636c;
    }
}
