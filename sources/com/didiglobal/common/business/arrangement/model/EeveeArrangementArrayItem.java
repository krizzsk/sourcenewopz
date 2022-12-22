package com.didiglobal.common.business.arrangement.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class EeveeArrangementArrayItem implements Serializable {
    @SerializedName("biz_config")
    public EeveeArrangementBizConfig bizConfig;
    @SerializedName("group_type")
    public String groupType;
    @SerializedName("node_config")
    public List<EeveeArrangementNodeModel> nodeConfig;
}
