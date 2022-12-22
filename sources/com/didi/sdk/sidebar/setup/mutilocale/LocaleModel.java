package com.didi.sdk.sidebar.setup.mutilocale;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class LocaleModel implements Serializable {
    public boolean isSelected;
    @SerializedName("tag")
    public String localeTag;
    public String name;
}
