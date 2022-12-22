package com.didi.soda.address.component.feed.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.helper.NovaItemTouchHelper;

public class AddressRecyclerView extends NovaRecyclerView {

    /* renamed from: a */
    NovaItemTouchHelper f38676a;

    /* renamed from: b */
    private AddressItemViewHolder f38677b;

    /* renamed from: c */
    private boolean f38678c;

    public AddressRecyclerView(Context context) {
        super(context);
    }

    public AddressRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AddressRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setItemTouchControlEnable(boolean z) {
        if (z) {
            if (this.f38676a == null) {
                this.f38676a = new NovaItemTouchHelper();
            }
            this.f38676a.attachToRecyclerView(this);
            return;
        }
        NovaItemTouchHelper novaItemTouchHelper = this.f38676a;
        if (novaItemTouchHelper != null) {
            novaItemTouchHelper.detachToRecyclerView();
        }
    }

    public void setOneOpenToggle(boolean z) {
        this.f38678c = z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AddressItemViewHolder addressItemViewHolder;
        if (motionEvent.getAction() == 0) {
            int y = (int) motionEvent.getY();
            if (this.f38678c && (addressItemViewHolder = this.f38677b) != null) {
                int top = addressItemViewHolder.itemView.getTop();
                int bottom = this.f38677b.itemView.getBottom();
                if ((y < top || y > bottom) && this.f38677b.itemView.getScrollX() != 0) {
                    this.f38677b.onMoveIn();
                }
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        NovaItemTouchHelper novaItemTouchHelper;
        if (motionEvent.getAction() == 2 && this.f38678c && (novaItemTouchHelper = this.f38676a) != null && novaItemTouchHelper.mSelected != null && (this.f38676a.mSelected instanceof AddressItemViewHolder)) {
            this.f38677b = (AddressItemViewHolder) this.f38676a.mSelected;
        }
        return super.onTouchEvent(motionEvent);
    }
}
