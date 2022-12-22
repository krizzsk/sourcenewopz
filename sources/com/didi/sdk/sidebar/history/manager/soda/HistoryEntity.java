package com.didi.sdk.sidebar.history.manager.soda;

import com.google.gson.annotations.SerializedName;

public class HistoryEntity implements IEntity {
    @SerializedName("data")
    public HistoryListEntity data;
}
