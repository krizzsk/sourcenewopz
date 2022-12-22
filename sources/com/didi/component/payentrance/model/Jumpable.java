package com.didi.component.payentrance.model;

public interface Jumpable {
    public static final int ID_DETAIL = 1;
    public static final int ID_ENTERPRISE = 2;
    public static final int ID_FEE_DOUBT = 3;

    int getId();

    CharSequence getText();

    int getTextRes();
}
