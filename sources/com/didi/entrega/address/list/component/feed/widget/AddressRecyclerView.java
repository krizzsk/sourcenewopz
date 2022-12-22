package com.didi.entrega.address.list.component.feed.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.didi.app.nova.support.view.recyclerview.view.NovaRecyclerView;
import com.didi.app.nova.support.view.recyclerview.view.helper.NovaItemTouchHelper;
import com.didi.entrega.address.list.component.feed.binder.AddressItemViewHolder;

public class AddressRecyclerView extends NovaRecyclerView {

    /* renamed from: a */
    NovaItemTouchHelper f19435a;

    /* renamed from: b */
    private AddressItemViewHolder f19436b;

    /* renamed from: c */
    private boolean f19437c;

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
            if (this.f19435a == null) {
                this.f19435a = new NovaItemTouchHelper();
            }
            this.f19435a.attachToRecyclerView(this);
            return;
        }
        NovaItemTouchHelper novaItemTouchHelper = this.f19435a;
        if (novaItemTouchHelper != null) {
            novaItemTouchHelper.detachToRecyclerView();
        }
    }

    public void setOneOpenToggle(boolean z) {
        this.f19437c = z;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AddressItemViewHolder addressItemViewHolder;
        if (motionEvent.getAction() == 0) {
            int y = (int) motionEvent.getY();
            if (this.f19437c && (addressItemViewHolder = this.f19436b) != null) {
                int top = addressItemViewHolder.itemView.getTop();
                int bottom = this.f19436b.itemView.getBottom();
                if ((y < top || y > bottom) && this.f19436b.itemView.getScrollX() != 0) {
                    this.f19436b.onMoveIn();
                }
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        NovaItemTouchHelper novaItemTouchHelper;
        if (motionEvent.getAction() == 2 && this.f19437c && (novaItemTouchHelper = this.f19435a) != null && novaItemTouchHelper.mSelected != null && (this.f19435a.mSelected instanceof AddressItemViewHolder)) {
            this.f19436b = (AddressItemViewHolder) this.f19435a.mSelected;
        }
        return super.onTouchEvent(motionEvent);
    }
}
