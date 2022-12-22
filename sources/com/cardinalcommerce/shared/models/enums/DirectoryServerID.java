package com.cardinalcommerce.shared.models.enums;

import com.didi.dcrypto.util.DCryptoUtils;

public enum DirectoryServerID {
    EMVCO1("F000000000"),
    EMVCO2("F000000001"),
    AMEX_STAGING("AMEX"),
    VISA01("VISA01"),
    VISA02("VISA02"),
    VISA03("VISA03"),
    VISA04("VISA03"),
    MASTER_CARD("MASTER_CARD"),
    DEFAULT(DCryptoUtils.KEY_IP_BLOCKING_STATUS_DEFAULT);
    
    private final String string;

    private DirectoryServerID(String str) {
        this.string = str;
    }

    public final String getValue() {
        return this.string;
    }
}
