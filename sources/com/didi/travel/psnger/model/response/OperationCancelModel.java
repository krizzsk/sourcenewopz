package com.didi.travel.psnger.model.response;

import com.didi.map.base.bubble.BaseBubbleBitmapLoader;
import com.didi.travel.psnger.common.net.base.BaseObject;
import org.json.JSONObject;

public class OperationCancelModel extends BaseObject {
    public String actImg;
    public String cancelButton;
    public String[] descList;
    public String keepButton;
    public String subject;
    public String title;

    public void parse(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("cancel_pop");
        this.title = optJSONObject.optString("title");
        this.actImg = optJSONObject.optString("act_img");
        this.descList = optJSONObject.optString("desc_list").split(BaseBubbleBitmapLoader.FILE_SPLIT_FLAG);
        this.cancelButton = optJSONObject.optString("cancel_button");
        this.keepButton = optJSONObject.optString("keep_button");
        this.subject = optJSONObject.optString("subject");
    }
}
