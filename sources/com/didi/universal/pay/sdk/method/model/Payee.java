package com.didi.universal.pay.sdk.method.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Payee implements Serializable {
    @SerializedName("name")
    public String name;
}
