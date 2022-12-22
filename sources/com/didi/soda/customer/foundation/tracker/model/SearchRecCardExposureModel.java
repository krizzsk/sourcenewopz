package com.didi.soda.customer.foundation.tracker.model;

import com.didi.soda.customer.foundation.rpc.entity.SearchWordsEntity;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class SearchRecCardExposureModel {
    @SerializedName("location")
    public String location;
    @SerializedName("rec_id")
    public String recId;
    @SerializedName("session_id")
    public String sessionID;
    @SerializedName("session_iter")
    public int sessionIter;
    @SerializedName("status")
    public int status;
    @SerializedName("words")
    public List<SearchWordsEntity.SearchWordItem> words;
}
