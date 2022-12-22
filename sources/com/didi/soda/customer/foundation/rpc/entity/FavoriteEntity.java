package com.didi.soda.customer.foundation.rpc.entity;

import com.didi.soda.blocks.entity.Template;
import com.didi.soda.customer.foundation.rpc.entity.topgun.ComponentEntity;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

public class FavoriteEntity implements IEntity {
    private static final long serialVersionUID = -7748948295473239051L;
    @SerializedName("compList")
    public List<ComponentEntity> mComponentList;
    @SerializedName("hasMore")
    public boolean mHasMore;
    @SerializedName("page")
    public int mPage;
    @SerializedName("templates")
    public ArrayList<Template> mTemplates;
    @SerializedName("recId")
    public String recId;
}
