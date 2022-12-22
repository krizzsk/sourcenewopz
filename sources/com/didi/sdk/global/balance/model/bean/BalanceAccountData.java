package com.didi.sdk.global.balance.model.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;

@Deprecated
public class BalanceAccountData implements Serializable {
    @SerializedName("allEntries")
    public ArrayList<BalanceAccount> allEntries;
    @SerializedName("title")
    public String title;
}
