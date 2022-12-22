package com.didi.travel.psnger.model.response;

public class CarPopeAction {
    public String actionData;
    public String actionType;
    public int productId;

    public CarPopeAction() {
    }

    public CarPopeAction(int i, String str, String str2) {
        this.productId = i;
        this.actionType = str;
        this.actionData = str2;
    }
}
