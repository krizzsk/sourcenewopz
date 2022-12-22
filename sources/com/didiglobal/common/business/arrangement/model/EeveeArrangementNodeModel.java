package com.didiglobal.common.business.arrangement.model;

import com.google.gson.JsonObject;
import java.io.Serializable;
import java.util.List;

public class EeveeArrangementNodeModel implements Serializable {
    public List<EeveeArrangementComponentModel> element_list;
    public String scene;
    public JsonObject scene_cache;
    public String super_node;
}
