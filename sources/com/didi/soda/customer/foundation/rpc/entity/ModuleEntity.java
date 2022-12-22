package com.didi.soda.customer.foundation.rpc.entity;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ModuleEntity implements IEntity {
    private static final long serialVersionUID = -4985699377575377852L;
    public boolean hasMore;
    @SerializedName("data")
    public List<ComponentEntity> mComponentEntityList;
    public String moduleId;
    public String subtitle;
    public String title;
    public String type;

    public String toString() {
        return "ModuleEntity{type='" + this.type + '\'' + ", title='" + this.title + '\'' + ", subtitle='" + this.subtitle + '\'' + ", moduleId='" + this.moduleId + '\'' + ", hasMore=" + this.hasMore + ", mComponentEntityList=" + this.mComponentEntityList + '}';
    }
}
