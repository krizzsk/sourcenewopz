package com.didi.component.comp_anycar_append_list;

import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didi.travel.psnger.model.response.anycar.AnyCarGroup;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class AnyCarAppendData {
    @SerializedName("append_link")
    public String append_link;
    @SerializedName("request_btn_info")
    public BtnInfo btnInfo;
    @SerializedName("list")
    public List<AnyCarGroup> carAppendList;
    @SerializedName("select_item_commit_url")
    public String selectItemCommitUrl;
    @SerializedName("show_timestamp")
    public long show_timestamp;
    @SerializedName("title")
    public LEGORichInfo title;

    public static class BtnInfo {
        @SerializedName("state_disable")
        public LEGORichInfo stateDisable;
        @SerializedName("state_enable")
        public LEGORichInfo stateEnable;
    }
}
