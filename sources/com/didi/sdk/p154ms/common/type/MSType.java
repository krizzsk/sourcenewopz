package com.didi.sdk.p154ms.common.type;

/* renamed from: com.didi.sdk.ms.common.type.MSType */
public enum MSType {
    GMS(IMSType.GMS),
    HMS(IMSType.HMS);
    
    private String mType;

    private MSType(String str) {
        this.mType = str;
    }

    public String getType() {
        return this.mType;
    }
}
