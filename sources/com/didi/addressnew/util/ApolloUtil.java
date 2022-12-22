package com.didi.addressnew.util;

public class ApolloUtil {
    public static int SUG_SEARCH_INTERVAL = 500;
    public static int SUG_SEARCH_INTERVAL_MAX = 1300;
    public static int SUG_SEARCH_INTERVAL_MIN = 300;

    /* renamed from: a */
    private static final String f7473a = "ApolloUtil";

    public static void initSugSearchInternalTimeAccordingRegion(String str) {
        Integer valueOf = Integer.valueOf(SUG_SEARCH_INTERVAL);
        if (str != null) {
            if (str.equalsIgnoreCase("MX")) {
                valueOf = 850;
            } else if (str.equalsIgnoreCase("BR")) {
                valueOf = 550;
            }
        }
        int intValue = valueOf.intValue();
        SUG_SEARCH_INTERVAL = intValue;
        if (intValue < SUG_SEARCH_INTERVAL_MIN || intValue > SUG_SEARCH_INTERVAL_MAX) {
            SUG_SEARCH_INTERVAL = 500;
        }
    }

    public static boolean sugStartPoiUseNLP(String str) {
        return str != null && (str.equalsIgnoreCase("MX") || str.equalsIgnoreCase("BR"));
    }

    public static int getNLPTimeOut(String str) {
        return (str == null || (!str.equalsIgnoreCase("MX") && !str.equalsIgnoreCase("BR"))) ? 0 : 1000;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
        r0 = r0.getExperiment();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean getRecOmegaCKAB() {
        /*
            java.lang.String r0 = "map_sug_inversion_rate_test_ab"
            com.didichuxing.apollo.sdk.IToggle r0 = com.didichuxing.apollo.sdk.Apollo.getToggle(r0)
            r1 = 0
            if (r0 == 0) goto L_0x0026
            boolean r2 = r0.allow()
            if (r2 == 0) goto L_0x0026
            com.didichuxing.apollo.sdk.IExperiment r0 = r0.getExperiment()
            if (r0 == 0) goto L_0x0026
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)
            java.lang.String r3 = "is_new"
            java.lang.Object r0 = r0.getParam(r3, r2)
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
            goto L_0x0027
        L_0x0026:
            r0 = 0
        L_0x0027:
            r2 = 1
            if (r0 != r2) goto L_0x002b
            r1 = 1
        L_0x002b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.addressnew.util.ApolloUtil.getRecOmegaCKAB():boolean");
    }
}
