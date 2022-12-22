package com.didi.travel.psnger.model.response.anycar;

import com.android.didi.bfflib.business.BffGsonStruct;
import com.didi.travel.psnger.model.response.estimate.AnyCarCarpoolOperation;
import com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration;
import com.didi.travel.psnger.model.response.estimate.SelectedValueParams;
import com.google.gson.JsonObject;
import java.util.HashMap;

public class AnyCarEstimateItemModel implements BffGsonStruct {
    public AnyCarCarpoolOperation anycarCarpool;
    private HashMap<String, JsonObject> carOperationSelectedValue = new HashMap<>();
    public int countPriceType = 0;
    public String estimateId;
    public NewEstimateChoosedOpration estimatePass;
    public NewEstimateChoosedOpration extraChoice;
    public String feeDisplay;
    public float feeNumber;
    public boolean isSelected = false;
    public AnyCarEstimateNetModel mAnyCarEstimateNetItem;
    public boolean mIsFirstSingle;
    private int selectPos = -1;
    private SelectedValueParams selectedValueParams;

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

    public int getCarLevel() {
        if (this.mAnyCarEstimateNetItem.carConfig != null) {
            return this.mAnyCarEstimateNetItem.carConfig.carLevel;
        }
        return 0;
    }

    public int getCarBussinessId() {
        if (this.mAnyCarEstimateNetItem.carConfig != null) {
            return this.mAnyCarEstimateNetItem.carConfig.carBussinessId;
        }
        return 0;
    }
}
