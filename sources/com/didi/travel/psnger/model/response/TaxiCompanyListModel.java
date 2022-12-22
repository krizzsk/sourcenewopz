package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.core.model.response.IEstimateModel;
import com.didi.travel.psnger.utils.JsonUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class TaxiCompanyListModel extends BaseObject implements IEstimateModel {
    public static final int MAX_COMPANY_SUGGEST_TIPS_DISPLAY_MARKER = 2;
    public static final int MAX_COMPANY_SUGGEST_TIPS_HIDDEN_MARKER = 1;
    public static final int MAX_COMPANY_SUGGEST_TIPS_MARKER_MAST = 3;
    public List<String> comp4FreePickup;
    public CompanyFreeOption comp4freeOption;
    public List<CompanyModel> list;
    public String listDesc;
    public String multiDesc;

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        JSONArray optJSONArray;
        super.parse(jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            if (optJSONObject.has(ParamKeys.PARAM_ESTIMATE_COMPANY_ID) && (optJSONArray = optJSONObject.optJSONArray(ParamKeys.PARAM_ESTIMATE_COMPANY_ID)) != null) {
                this.list = new JsonUtil().parseJSONArray(optJSONArray, new CompanyModel());
            }
            if (optJSONObject.has("company_free_ids")) {
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("company_free_ids");
                new JsonUtil();
                this.comp4FreePickup = JsonUtil.parseJSONArrayString(optJSONArray2);
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject("company_free");
            if (optJSONObject2 != null) {
                CompanyFreeOption companyFreeOption = new CompanyFreeOption();
                this.comp4freeOption = companyFreeOption;
                companyFreeOption.parse(optJSONObject2);
            }
            this.listDesc = optJSONObject.optString("company_list_desc");
            this.multiDesc = optJSONObject.optString("company_multi_desc");
        }
    }

    public static class CompanyFreeOption extends BaseObject {
        public String desc;
        public String logo;
        public String name;

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            super.parse(jSONObject);
            this.name = jSONObject.optString("name");
            this.logo = jSONObject.optString("logo");
            this.desc = jSONObject.optString("desc");
        }
    }

    public static class CompanyModel extends BaseObject {
        public static final String COMPANY_ID_ANY = "0";
        public static final String COMPANY_ID_FREEPICKUP = "1";
        public List<String> childCids = new ArrayList();
        public String desc;
        public String extraFeeDesc;
        public String iconUrl;

        /* renamed from: id */
        public String f44227id;
        public String name;

        public void fillChildCids(List<String> list) {
            this.childCids.addAll(list);
        }

        public void addChildCid(String str) {
            this.childCids.add(str);
        }

        public boolean isFreePickup() {
            return "1".equals(this.f44227id);
        }

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            super.parse(jSONObject);
            this.f44227id = jSONObject.optString("id");
            this.iconUrl = jSONObject.optString("company_logo");
            this.name = jSONObject.optString("short_name");
            this.desc = jSONObject.optString("fee_msg");
            this.extraFeeDesc = jSONObject.optString("pickup_desc");
        }
    }
}
