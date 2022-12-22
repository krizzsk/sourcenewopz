package com.didi.sdk.sidebar.travelsafe;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class TripSecurityResponse implements Serializable {
    @SerializedName("errno")
    public int errno;
    @SerializedName("result")
    public TravelSafetyState result;
}
