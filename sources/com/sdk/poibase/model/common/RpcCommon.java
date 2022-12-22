package com.sdk.poibase.model.common;

import com.google.gson.annotations.SerializedName;
import com.sdk.poibase.model.HttpResultBase;
import java.util.ArrayList;

public class RpcCommon extends HttpResultBase {
    @SerializedName("addrlist")
    public ArrayList<RpcCommonPoi> commonAddresses;
    @SerializedName("lang")
    public String language;

    public String toString() {
        return "{errno=" + this.errno + ", result=" + this.commonAddresses + "，language=" + this.language + '}';
    }
}
