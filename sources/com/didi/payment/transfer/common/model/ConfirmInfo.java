package com.didi.payment.transfer.common.model;

import android.content.Context;
import com.google.gson.annotations.SerializedName;
import com.taxis99.R;

public class ConfirmInfo {
    public String btnTextNegative;
    public String btnTextPositive;
    @SerializedName("ntitle")
    public String newTitleMain;
    @SerializedName("desc")
    public String titleDesc;
    @SerializedName("title")
    public String titleMain;

    public void initDefaultBtn(Context context) {
        this.btnTextPositive = context.getString(R.string.GRider_PAX_Determination_ElLp);
        this.btnTextNegative = context.getString(R.string.GRider_PAX_Cancel_GXAY);
    }
}
