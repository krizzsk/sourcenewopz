package com.didi.payment.creditcard.base.binrule;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class CardBin implements Serializable {
    @SerializedName("desc")
    public String desc;
    @SerializedName("org")

    /* renamed from: org  reason: collision with root package name */
    public int f61866org;
    @SerializedName("range")
    public List<Range> range;
    @SerializedName("type")
    public int type;

    public static final class Org {
        public static final int AMEX = 4;
        public static final int DINERS = 6;
        public static final int DISCOVER = 7;
        public static final int ELO = 3;
        public static final int HIPER = 10;
        public static final int HIPER_CARD = 9;
        public static final int JCB = 8;
        public static final int MAESTRO = 11;
        public static final int MASTER = 2;
        public static final int MIR = 12;
        public static final int NONE = 0;
        public static final int UNION_PAY = 5;
        public static final int VISA = 1;
    }

    public static final class Type {
        public static final int CREDIT = 3;
        public static final int CREDIT_DEBIT = 1;
        public static final int DEBIT = 2;
        public static final int NONE = 0;
    }

    public class Range {
        @SerializedName("end")
        public int end;
        @SerializedName("start")
        public int start;

        public Range() {
        }
    }
}
