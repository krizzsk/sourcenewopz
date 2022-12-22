package com.didiglobal.common.business.arrangement.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class EeveeArrangementModel implements Serializable {
    @SerializedName("list")
    public List<EeveeArrangementArrayItem> eeveeData;
}
