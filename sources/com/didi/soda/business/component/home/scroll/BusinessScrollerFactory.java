package com.didi.soda.business.component.home.scroll;

import androidx.recyclerview.widget.RecyclerView;

public class BusinessScrollerFactory {

    /* renamed from: a */
    private BusinessSmoothScroller f39592a;

    /* renamed from: b */
    private BusinessFastScroller f39593b;

    public IScroller getBusinessScroller(RecyclerView recyclerView, int i) {
        if (Math.abs(i) <= 30) {
            if (this.f39592a == null) {
                this.f39592a = new BusinessSmoothScroller(recyclerView);
            }
            return this.f39592a;
        }
        if (this.f39593b == null) {
            this.f39593b = new BusinessFastScroller(recyclerView);
        }
        return this.f39593b;
    }
}
