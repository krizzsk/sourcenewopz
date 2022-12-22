package com.didi.component.business.model;

import com.didichuxing.publicservice.p196db.model.ScreenAdNewModel;
import org.json.JSONObject;

public class BCCInfoModel {
    public static final int CARPOOL_ORDER_NOT_CARPOOL = -1;
    public static final int CARPOOL_ORDER_SCENE_CARPOOL = 0;
    public static final int CARPOOL_ORDER_SCENE_MATCHTOGO = 2;
    public static final int CARPOOL_ORDER_SCENE_NOT_MATCH_DISCOUNT = 3;
    public static final int CARPOOL_ORDER_SCENE_TWO_PRICE = 1;
    public int bussinessId;
    public int carPoolOrderScene;
    public int carTypeId;
    public int comboType;
    public boolean isDefault;

    public JSONObject toJsonObject() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("business_id", this.bussinessId);
            jSONObject.put("require_level", this.carTypeId);
            jSONObject.put("combo_type", this.comboType);
            jSONObject.put(ScreenAdNewModel.ScreenAdNewColumn.IS_DEFAULT, this.isDefault ? 1 : 0);
            jSONObject.put("carpool_order_scene", this.carPoolOrderScene);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
