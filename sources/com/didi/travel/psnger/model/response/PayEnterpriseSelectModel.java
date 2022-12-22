package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.utils.JsonUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class PayEnterpriseSelectModel extends BaseObject {
    private static final String JSON_LIST_TAG_COMPANY = "company_list";
    private static final String JSON_LIST_TAG_COST_CENTER = "cost_center_list";
    private static final String JSON_LIST_TAG_PROJECT = "project_list";
    public static final int TYPE_COMMENT = 3;
    public static final int TYPE_COMPANY = 0;
    public static final int TYPE_COST_CENTER = 1;
    public static final int TYPE_PROJECT = 2;
    private String jsonListTag = "company_list";
    private List<PayEnterpriseSelectItem> list = new ArrayList();
    private int type = 0;

    public List<PayEnterpriseSelectItem> getList() {
        return this.list;
    }

    public void setList(List<PayEnterpriseSelectItem> list2) {
        this.list = list2;
    }

    public PayEnterpriseSelectModel(int i) {
        setType(i);
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
        if (i == 0) {
            this.jsonListTag = "company_list";
        } else if (i == 1) {
            this.jsonListTag = JSON_LIST_TAG_COST_CENTER;
        } else if (i == 2) {
            this.jsonListTag = JSON_LIST_TAG_PROJECT;
        }
    }

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONArray optJSONArray;
        super.parse(jSONObject);
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null && optJSONObject.has(this.jsonListTag) && (optJSONArray = optJSONObject.optJSONArray(this.jsonListTag)) != null) {
            this.list = new JsonUtil().parseJSONArray(optJSONArray, new PayEnterpriseSelectItem(this.type));
        }
    }

    public static class PayEnterpriseSelectItem extends BaseObject {
        private static final String JSON_ID_TAG_COMPANY = "company_id";
        private static final String JSON_ID_TAG_COST_CENTER = "cost_center_id";
        private static final String JSON_ID_TAG_PROJECT = "project_id";
        private String content;

        /* renamed from: id */
        private String f44226id;
        private String jsonCommentTag = "comments";
        private String jsonIdTag = "company_id";
        private String jsonNameTag = "name";
        private int maxSizeComment;
        private int minSizeComment;
        private boolean requiredComment;
        private boolean requiredCostCenter;
        private boolean requiredProject;
        private int type;

        public PayEnterpriseSelectItem(int i) {
            setType(i);
        }

        public PayEnterpriseSelectItem(String str, String str2, int i) {
            this.f44226id = str;
            this.content = str2;
            setType(i);
        }

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            super.parse(jSONObject);
            this.f44226id = jSONObject.optString(this.jsonIdTag);
            this.content = jSONObject.optString(this.jsonNameTag);
            if (this.type == 0) {
                this.requiredCostCenter = jSONObject.optBoolean("cost_center_required");
                this.requiredProject = jSONObject.optBoolean("project_required");
                if (jSONObject.has(this.jsonCommentTag)) {
                    JSONObject optJSONObject = jSONObject.optJSONObject(this.jsonCommentTag);
                    this.requiredComment = optJSONObject.optBoolean("required");
                    this.minSizeComment = optJSONObject.optInt("min_size");
                    this.maxSizeComment = optJSONObject.optInt("max_size");
                }
            }
        }

        public String getId() {
            return this.f44226id;
        }

        public void setId(String str) {
            this.f44226id = str;
        }

        public String getContent() {
            return this.content;
        }

        public void setContent(String str) {
            this.content = str;
        }

        public int getType() {
            return this.type;
        }

        public void setType(int i) {
            this.type = i;
            if (i == 0) {
                this.jsonIdTag = "company_id";
            } else if (i == 1) {
                this.jsonIdTag = "cost_center_id";
            } else if (i == 2) {
                this.jsonIdTag = JSON_ID_TAG_PROJECT;
            }
        }

        public boolean isRequiredCostCenter() {
            return this.requiredCostCenter;
        }

        public void setRequiredCostCenter(boolean z) {
            this.requiredCostCenter = z;
        }

        public boolean isRequiredProject() {
            return this.requiredProject;
        }

        public void setRequiredProject(boolean z) {
            this.requiredProject = z;
        }

        public boolean isRequiredComment() {
            return this.requiredComment;
        }

        public void setRequiredComment(boolean z) {
            this.requiredComment = z;
        }

        public int getMinSizeComment() {
            return this.minSizeComment;
        }

        public void setMinSizeComment(int i) {
            this.minSizeComment = i;
        }

        public int getMaxSizeComment() {
            return this.maxSizeComment;
        }

        public void setMaxSizeComment(int i) {
            this.maxSizeComment = i;
        }
    }
}
