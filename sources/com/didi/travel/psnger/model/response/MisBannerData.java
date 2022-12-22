package com.didi.travel.psnger.model.response;

import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.utils.TextUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class MisBannerData extends BaseObject {
    public List<MisBannerItemModel> dataList;
    private String[] resourceArray;
    private String[] sidArray;

    public MisBannerData(String[] strArr, String[] strArr2) {
        this.resourceArray = strArr;
        this.sidArray = strArr2;
    }

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        super.parse(jSONObject);
        if (jSONObject != null && this.resourceArray != null && this.sidArray != null) {
            this.dataList = new ArrayList();
            int i = 0;
            while (i < this.resourceArray.length) {
                try {
                    JSONObject optJSONObject = jSONObject.optJSONObject(this.resourceArray[i]);
                    if (optJSONObject != null) {
                        for (int i2 = 0; i2 < this.sidArray.length; i2++) {
                            JSONObject optJSONObject2 = optJSONObject.optJSONObject(this.sidArray[i2]);
                            if (optJSONObject2 != null) {
                                List<MisBannerItemModel> covertJsonToModelList = covertJsonToModelList(optJSONObject2, this.sidArray[i2], this.resourceArray[i]);
                                if (covertJsonToModelList.size() > 0) {
                                    this.dataList.addAll(covertJsonToModelList);
                                }
                            }
                        }
                    }
                    i++;
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
        }
    }

    private MisBannerItemModel convertJsonToModel(JSONObject jSONObject, String str, String str2) {
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        MisBannerItemModel misBannerItemModel = new MisBannerItemModel();
        misBannerItemModel.sid = str;
        misBannerItemModel.senceId = str2;
        misBannerItemModel.parse(optJSONObject);
        if (TextUtil.isEmpty(misBannerItemModel.activityId)) {
            return null;
        }
        return misBannerItemModel;
    }

    private List<MisBannerItemModel> covertJsonToModelList(JSONObject jSONObject, String str, String str2) {
        JSONArray optJSONArray = jSONObject.optJSONArray("data");
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            MisBannerItemModel misBannerItemModel = new MisBannerItemModel();
            misBannerItemModel.sid = str;
            misBannerItemModel.senceId = str2;
            misBannerItemModel.parse(optJSONArray.optJSONObject(i));
            if (!TextUtil.isEmpty(misBannerItemModel.activityId)) {
                arrayList.add(misBannerItemModel);
            }
        }
        return arrayList;
    }
}
