package com.didi.addressnew.framework.fragmentmarket.favorite;

import android.graphics.Canvas;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.addressnew.framework.fragmentmarket.favorite.FavoriteAdapter;
import com.didi.addressnew.util.ViewUtils;
import com.didi.sdk.apm.SystemUtils;

public class FavoriteSwipeCallback extends ItemTouchHelper.Callback {

    /* renamed from: a */
    private float f4424a;

    /* renamed from: b */
    private OnItemSwipeListener f4425b;

    /* renamed from: c */
    private final int f4426c;

    /* renamed from: d */
    private int f4427d;

    /* renamed from: e */
    private int f4428e;

    /* renamed from: f */
    private float f4429f;

    /* renamed from: g */
    private boolean f4430g;

    public interface OnItemSwipeListener {
        void onItemDimiss(RecyclerView.ViewHolder viewHolder);
    }

    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        return false;
    }

    public FavoriteSwipeCallback(float f, int i) {
        this.f4424a = f;
        this.f4426c = i;
    }

    public void setOnItemSwipeListener(OnItemSwipeListener onItemSwipeListener) {
        this.f4425b = onItemSwipeListener;
    }

    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        if (!(viewHolder instanceof FavoriteAdapter.ItemHolder) && !(viewHolder instanceof FavoriteAdapter.ItemNoArrowHolder)) {
            return 0;
        }
        return makeMovementFlags(0, ViewUtils.isRTL() ? 8 : 4);
    }

    public void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
        OnItemSwipeListener onItemSwipeListener = this.f4425b;
        if (onItemSwipeListener != null) {
            onItemSwipeListener.onItemDimiss(viewHolder);
        }
    }

    public float getSwipeThreshold(RecyclerView.ViewHolder viewHolder) {
        return this.f4424a;
    }

    public float getSwipeEscapeVelocity(float f) {
        return this.f4424a;
    }

    public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f, float f2, int i, boolean z) {
        if (f == 0.0f) {
            this.f4427d = viewHolder.itemView.getScrollX();
            this.f4430g = true;
        }
        if (z) {
            viewHolder.itemView.scrollTo(this.f4427d + ((int) (-f)), 0);
            return;
        }
        if (this.f4430g) {
            this.f4430g = false;
            this.f4428e = viewHolder.itemView.getScrollX();
            this.f4429f = f;
        }
        if (viewHolder.itemView.getScrollX() >= this.f4426c) {
            viewHolder.itemView.scrollTo(Math.max(this.f4427d + ((int) (-f)), this.f4426c), 0);
        } else {
            viewHolder.itemView.scrollTo((int) ((((float) this.f4428e) * f) / this.f4429f), 0);
        }
    }

    public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        super.clearView(recyclerView, viewHolder);
        SystemUtils.log(4, "LeftDropXX", "clearView: scroll " + viewHolder.itemView.getScrollX(), (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.favorite.FavoriteSwipeCallback", 99);
        viewHolder.itemView.scrollTo(0, 0);
    }
}
