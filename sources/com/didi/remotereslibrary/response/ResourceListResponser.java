package com.didi.remotereslibrary.response;

import com.didi.remotereslibrary.ResourceItemModel;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class ResourceListResponser extends BaseResponse {
    public List<ResourceItemModel> mData = new ArrayList();
    public String md5 = "";

    public void parser(String str) {
        JSONObject optJSONObject;
        super.parser(str);
        if (isSuccess() && this.jsonObject != null && (optJSONObject = this.jsonObject.optJSONObject("data")) != null) {
            this.md5 = optJSONObject.optString("md5");
            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                    ResourceItemModel resourceItemModel = new ResourceItemModel();
                    resourceItemModel.parser(optJSONObject2);
                    this.mData.add(resourceItemModel);
                }
            }
        }
    }
}
