package com.didi.component.realtimeprice.model;

import com.taxis99.R;

public class RealTimePrice {
    public String currencyId;
    public String currencySymbol = "";
    public String desc;
    public boolean isDetailPriceClosed;
    public String meterFare;
    public String preFare;
    public int priceTextSize = R.dimen.global_real_time_price_default_text_size;
    public boolean showArrow = true;
    public int symbolSize = R.dimen.global_real_time_price_default_dollar_size;
    public String totalPrice = "";
    public String totalPriceDisplay = "";
}
