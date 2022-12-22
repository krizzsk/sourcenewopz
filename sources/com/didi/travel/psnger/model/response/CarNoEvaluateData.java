package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CarNoEvaluateData extends BaseObject {
    public String success_result_text;
    public List<CarEvaluateTag> tags;
    public String title;
    public String uncomment_text;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("data");
            JSONObject optJSONObject = jSONObject2.optJSONObject("comment_tag");
            if (optJSONObject != null) {
                jSONObject2 = optJSONObject;
            }
            this.uncomment_text = jSONObject2.optString("uncomment_text");
            this.success_result_text = jSONObject2.optString("success_result_text");
            this.title = jSONObject2.optString("title");
            this.tags = new ArrayList();
            JSONArray jSONArray = jSONObject2.getJSONArray("tags");
            if (jSONArray != null) {
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    CarEvaluateTag carEvaluateTag = new CarEvaluateTag();
                    carEvaluateTag.parse(jSONArray.getJSONObject(i));
                    this.tags.add(carEvaluateTag);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public class CarEvaluateTag extends BaseObject {
        public String content_text;
        public int level;
        public String level_description;
        public String level_text;
        public String negative_text;
        public String refine_guide;
        public String tag_guide;
        public List<EvaluateTagImpl> tag_list;

        public CarEvaluateTag() {
        }

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            super.parse(jSONObject);
            try {
                this.level = jSONObject.optInt("level");
                this.level_text = jSONObject.optString("level_text");
                this.negative_text = jSONObject.optString("negative_text");
                this.content_text = jSONObject.optString("content_text");
                this.level_description = jSONObject.optString("level_description");
                this.tag_guide = jSONObject.optString("tag_guide");
                this.refine_guide = jSONObject.optString("refine_guide");
                this.tag_list = new ArrayList();
                JSONArray jSONArray = jSONObject.getJSONArray("tag_list");
                if (jSONArray != null) {
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        EvaluateTagImpl evaluateTagImpl = new EvaluateTagImpl();
                        evaluateTagImpl.parse(jSONArray.getJSONObject(i));
                        this.tag_list.add(evaluateTagImpl);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public static class EvaluateTagImpl extends BaseObject {
        private String icon;

        /* renamed from: id */
        private long f44213id;
        private String text;

        public EvaluateTagImpl() {
        }

        public EvaluateTagImpl(long j, String str, String str2) {
            this.f44213id = j;
            this.text = str;
            this.icon = str2;
        }

        public String getText() {
            return this.text;
        }

        public long getId() {
            return this.f44213id;
        }

        public String getIcon() {
            return this.icon;
        }

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            super.parse(jSONObject);
            this.f44213id = jSONObject.optLong("tag_id");
            this.text = jSONObject.optString("tag_text");
            this.icon = jSONObject.optString("tag_icon");
        }
    }
}
