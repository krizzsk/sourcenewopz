package com.didi.entrega.customer.foundation.rpc.sliding.entity;

import com.didi.dimina.container.p106ui.custom.SameLayerRenderingUtil;
import com.didi.entrega.customer.foundation.tracker.error.ErrorConst;
import com.didi.entrega.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didichuxing.carsliding.model.Driver;
import com.didichuxing.carsliding.model.DriverCollection;
import com.didichuxing.carsliding.model.VectorCoordinate;
import com.didichuxing.carsliding.model.VectorCoordinateList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NearDriversEntity extends BaseObjectEntity {
    private static final long serialVersionUID = -1134829523515768709L;
    public DriverCollection drivers = new DriverCollection();
    public int eta = 0;
    public int etaDistance = 0;
    public String etaStr = "";
    public boolean isDebugOpen = false;
    public int orderState = 0;
    public int productId = 0;
    public int redirect = 0;

    public String toString() {
        return "NearDriversEntity{productId=" + this.productId + ", eta=" + this.eta + ", etaDistance=" + this.etaDistance + ", etaStr='" + this.etaStr + '\'' + ", drivers=" + this.drivers + '}';
    }

    /* access modifiers changed from: protected */
    public void parse(JSONObject jSONObject) {
        JSONArray optJSONArray;
        JSONArray jSONArray;
        String str;
        String str2 = "coords";
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            this.productId = optJSONObject.optInt("product_id");
            this.eta = optJSONObject.optInt("eta");
            this.etaDistance = optJSONObject.optInt("eta_distance");
            this.etaStr = optJSONObject.optString("eta_str");
            this.redirect = optJSONObject.optInt("redirect");
            if (optJSONObject.has("loc") && (optJSONArray = optJSONObject.optJSONArray("loc")) != null && optJSONArray.length() > 0) {
                int length = optJSONArray.length();
                int i = 0;
                while (i < length) {
                    try {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        String optString = jSONObject2.optString("dirverId");
                        jSONObject2.optInt("mType");
                        VectorCoordinateList vectorCoordinateList = new VectorCoordinateList();
                        if (jSONObject2.has(str2)) {
                            JSONArray optJSONArray2 = jSONObject2.optJSONArray(str2);
                            if (optJSONArray != null && optJSONArray2.length() > 0) {
                                int length2 = optJSONArray2.length();
                                int i2 = 0;
                                while (i2 < length2) {
                                    JSONObject jSONObject3 = optJSONArray2.getJSONObject(i2);
                                    str = str2;
                                    jSONArray = optJSONArray;
                                    try {
                                        VectorCoordinate vectorCoordinate = new VectorCoordinate(jSONObject3.getDouble("x"), jSONObject3.getDouble(SameLayerRenderingUtil.KEY_COMP_Y), (float) jSONObject3.getDouble(BlocksConst.WIDGET_PARAMS_ANGLE), (long) jSONObject3.optInt("timestamp"));
                                        vectorCoordinateList.add(vectorCoordinate);
                                        i2++;
                                        str2 = str;
                                        optJSONArray = jSONArray;
                                    } catch (JSONException e) {
                                        e = e;
                                        e.printStackTrace();
                                        ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_SERVICE_SLIDING_ERROR).addModuleName("order").addErrorType(ErrorTracker.getErrorType(e)).addErrorMsg(ErrorTracker.getExceptionMsg(e)).build().trackError();
                                        i++;
                                        str2 = str;
                                        optJSONArray = jSONArray;
                                    }
                                }
                            }
                        }
                        str = str2;
                        jSONArray = optJSONArray;
                        Driver driver = new Driver(optString);
                        driver.setVectorCoordinateList(vectorCoordinateList);
                        this.drivers.add(driver);
                    } catch (JSONException e2) {
                        e = e2;
                        str = str2;
                        jSONArray = optJSONArray;
                        e.printStackTrace();
                        ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_SERVICE_SLIDING_ERROR).addModuleName("order").addErrorType(ErrorTracker.getErrorType(e)).addErrorMsg(ErrorTracker.getExceptionMsg(e)).build().trackError();
                        i++;
                        str2 = str;
                        optJSONArray = jSONArray;
                    }
                    i++;
                    str2 = str;
                    optJSONArray = jSONArray;
                }
            }
        }
    }
}
