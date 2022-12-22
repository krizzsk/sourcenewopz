package com.didi.foundation.sdk.net.interceptor;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class RpcBlockEntity implements Serializable, Cloneable {
    private static final long serialVersionUID = 2359131874521058583L;
    @SerializedName("errmsg")
    public String errmsg;
    @SerializedName("errno")
    public int errno = -800;
}
