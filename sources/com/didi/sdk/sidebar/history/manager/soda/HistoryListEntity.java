package com.didi.sdk.sidebar.history.manager.soda;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class HistoryListEntity implements IEntity {
    private static final long serialVersionUID = -3404465099451470441L;
    @SerializedName("haveNext")
    public int haveNext;
    public int mhaveNext;
    public String nextText;
    public List<HistoryItemEntity> orderDone;
    @SerializedName("orderNum")
    public int orderNum;
    public List<HistoryItemEntity> orderWaiting;
    public String timeMode;
    public String toast;
}
