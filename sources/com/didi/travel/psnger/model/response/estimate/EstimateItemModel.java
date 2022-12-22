package com.didi.travel.psnger.model.response.estimate;

import android.text.TextUtils;
import com.android.didi.bfflib.business.BffGsonStruct;
import com.didi.travel.psnger.model.response.EstimateItem;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.List;

public class EstimateItemModel implements BffGsonStruct {
    public static final int ALL_VERTICAL = 1;
    public static final int ESTIMATE_ONE_CAR = 3;
    public static final int HORIZONTAL = 0;
    public static final int HORIZONTAL_LOADING = 11;
    public static final int RECOMMEND_VERTICAL = 2;
    public static final int VERTICAL_LOADING = 12;
    public static final int VERTICAL_LOADING_SEL = 13;
    @SerializedName("business_config")
    public CarBusinessConfig businessConfig;
    @SerializedName("break_module")
    public CarBreakModel carBreakModel;
    @SerializedName("bubble_module")
    public CarBubbleModule carBubbleModule;
    @SerializedName("config")
    public CarConfigModel carConfig;
    @SerializedName("user_datepick_info")
    public CarDatepickInfo carDatepickInfo;
    @SerializedName("cars_info_detail")
    public List<CarDetailInfoListModel> carDetail;
    @SerializedName("car_info")
    public CarInfoModel carInfo;
    @SerializedName("message_module")
    public List<CarMessageModel> carMessage;
    @SerializedName("car_operation")
    public List<CarOperationModel> carOperation;
    private HashMap<String, JsonObject> carOperationSelectedValue = new HashMap<>();
    @SerializedName("user_pay_group")
    public List<CarPayGroupInfoModel> carPayGroupInfo;
    @SerializedName("user_pay_info")
    public List<CarPayInfoModel> carPayInfo;
    public NewEsimateCompanyOperation company;
    public int countPriceType = 0;
    public NewEstimateChoosedOpration dispatchFeeChoice;
    public String estimateId;
    public NewEstimateChoosedOpration estimatePass;
    public NewEstimateChoosedOpration extraChoice;
    public String feeDisplay;
    public float feeNumber;
    public boolean isSelected = false;
    public String itemTitle;
    @SerializedName("form_operation")
    public FormOperationModel mFormOperationModel;
    @SerializedName("pay_assistor_module")
    public JsonObject mPayAssistorModule;
    @SerializedName("map_info")
    public MapInfoModel mapInfoModel;
    public int measureHeight;
    public NewEstimateChoosedOpration memberpoint;
    public EstimateItem oldEstimateItem;
    @SerializedName("pay_assistor_info")
    public PayAssistorInfo payAssistorInfo;
    @SerializedName("user_pay_config")
    public CarPayConfigInfoModel payCfgInfo;
    private int selectPos = -1;
    private SelectedValueParams selectedValueParams;
    public NewEstimateChoosedOpration twoPriceChoice;
    public int viewType;
    public NewEstimateChoosedOpration xml;

    public EstimateItemModel clone() throws CloneNotSupportedException {
        return (EstimateItemModel) super.clone();
    }

    public boolean showDataPick() {
        CarDatepickInfo carDatepickInfo2 = this.carDatepickInfo;
        return carDatepickInfo2 != null && carDatepickInfo2.beginTime > 0 && this.carDatepickInfo.endTime > 0;
    }

    public HashMap<String, JsonObject> getSelectedValueMap() {
        return this.carOperationSelectedValue;
    }

    public void addSelectedValueJsonObject(String str, JsonObject jsonObject) {
        if (jsonObject == null) {
            this.carOperationSelectedValue.remove(str);
        } else {
            this.carOperationSelectedValue.put(str, jsonObject);
        }
    }

    public SelectedValueParams getSelectedValueParams() {
        return this.selectedValueParams;
    }

    public void setSelectedValueParams(SelectedValueParams selectedValueParams2, JsonObject jsonObject) {
        this.selectedValueParams = selectedValueParams2;
        addSelectedValueJsonObject("seatvalue", jsonObject);
    }

    public int getSelectPos() {
        return this.selectPos;
    }

    public void setSelectPos(int i) {
        this.selectPos = i;
    }

    public boolean isOperationContainsTwoPrice() {
        List<CarOperationModel> list = this.carOperation;
        if (list != null && list.size() > 0) {
            int i = 0;
            while (i < this.carOperation.size()) {
                CarOperationModel carOperationModel = this.carOperation.get(i);
                if (TextUtils.isEmpty(carOperationModel.operationType) || !"0".equals(carOperationModel.operationType)) {
                    i++;
                } else if (carOperationModel.isShowCheckBox == 1) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public int getCarLevel() {
        CarConfigModel carConfigModel = this.carConfig;
        if (carConfigModel != null) {
            return carConfigModel.carLevel;
        }
        return 0;
    }

    public int getCarBussinessId() {
        CarConfigModel carConfigModel = this.carConfig;
        if (carConfigModel != null) {
            return carConfigModel.carBussinessId;
        }
        return 0;
    }
}
