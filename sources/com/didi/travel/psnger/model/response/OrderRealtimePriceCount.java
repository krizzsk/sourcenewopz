package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.gson.PostProcessable;

public class OrderRealtimePriceCount extends OrderRealtimePriceCountRaw implements PostProcessable<OrderRealtimePriceCount> {
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public OrderRealtimePriceCount gsonPostProcess() {
        return this.data != null ? this.data : this;
    }
}
