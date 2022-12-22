package com.didi.travel.psnger.model.response.estimate;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.google.gson.annotations.SerializedName;

public class CarInfoPriceModel implements BffGsonStruct {
    @SerializedName("rich")
    public GlobalRichInfo carPrice;
    @SerializedName("line_spacing")
    public int lineSpacing = 0;
    @SerializedName("approx")
    public String priceApprox;
    @SerializedName("currencySymbol")
    public String priceSymbol;
    @SerializedName("currencyFirst")
    public int priceSymbolPosition;
    @SerializedName("type")
    public String priceType;

    public int getPriceSymbolPosition() {
        return this.priceSymbolPosition;
    }
}
