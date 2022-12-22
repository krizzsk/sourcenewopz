package com.didi.sdk.sidebar.http.response;

import com.didi.sdk.push.http.BaseObject;
import com.didi.sdk.sidebar.account.model.Age;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class AgeListResponse extends BaseObject {
    @SerializedName("list_info")
    List<Age> list_info;

    public List<Age> getList_info() {
        return this.list_info;
    }

    public void setList_info(List<Age> list) {
        this.list_info = list;
    }
}
