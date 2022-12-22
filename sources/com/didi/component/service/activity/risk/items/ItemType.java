package com.didi.component.service.activity.risk.items;

public enum ItemType {
    FACEBOOK("facebook"),
    CREDIT_CARD("credit_card"),
    MEXICO_CURP("mexico_curp"),
    BIZ_CPF("biz_cpf"),
    NONE("null");
    
    private String type;

    private ItemType(String str) {
        this.type = str;
    }

    public String getType() {
        return this.type;
    }

    public static ItemType getItemByType(String str) {
        for (ItemType itemType : values()) {
            if (itemType.type.equals(str)) {
                return itemType;
            }
        }
        return NONE;
    }
}
