package com.didichuxing.publicservice.resourcecontrol.pojo;

import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class CombinedResources {
    public List<OriginResource> list;

    public class OriginResource {
        public String data;
        public Status status;

        public OriginResource(JSONObject jSONObject) throws JSONException {
            this.status = new Status(jSONObject.getJSONObject(C12407a.f36608f));
            this.data = jSONObject.getString("data");
        }

        public class Status {
            public int code;
            public String msg;

            public Status(JSONObject jSONObject) throws JSONException {
                this.code = jSONObject.getInt("code");
                this.msg = jSONObject.optString("msg");
            }
        }
    }
}
