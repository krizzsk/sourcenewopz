package com.didi.payment.utilities;

import com.didi.payment.base.utils.WalletApolloUtil;
import java.util.Arrays;
import java.util.List;

public class CsInputFilter {

    /* renamed from: a */
    private static final String f31542a = "[^0-9]";

    /* renamed from: b */
    private List<Integer> f31543b;

    /* renamed from: c */
    private List<Integer> f31544c;

    /* renamed from: d */
    private char f31545d;

    /* renamed from: e */
    private char f31546e;

    public CsInputFilter() {
        if (WalletApolloUtil.isBoletoScanOptEnable()) {
            this.f31545d = '-';
            this.f31546e = 10;
            this.f31543b = Arrays.asList(new Integer[]{11, 23, 35, 47});
            this.f31544c = Arrays.asList(new Integer[]{12, 24, 36});
            return;
        }
        this.f31545d = '.';
        this.f31546e = ' ';
        this.f31543b = Arrays.asList(new Integer[]{5, 15, 25});
        this.f31544c = Arrays.asList(new Integer[]{10, 21, 32, 33});
    }

    public CsInputFilter(char c, char c2) {
        this(c, Arrays.asList(new Integer[]{11, 23, 35, 47}), c2, Arrays.asList(new Integer[]{12, 24, 36}));
    }

    public CsInputFilter(char c, List<Integer> list, char c2, List<Integer> list2) {
        this.f31545d = c;
        this.f31546e = c2;
        this.f31543b = list;
        this.f31544c = list2;
    }

    public String wrapperString(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (this.f31543b.contains(Integer.valueOf(i))) {
                sb.append(this.f31545d);
            }
            if (this.f31544c.contains(Integer.valueOf(i))) {
                sb.append(this.f31546e);
            }
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static String removeNonNumber(String str) {
        if (str == null) {
            return null;
        }
        return str.replaceAll(f31542a, "");
    }
}
