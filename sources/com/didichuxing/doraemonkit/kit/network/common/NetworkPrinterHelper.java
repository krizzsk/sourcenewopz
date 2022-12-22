package com.didichuxing.doraemonkit.kit.network.common;

public class NetworkPrinterHelper {

    /* renamed from: a */
    private static final String f47555a = "NetworkLogHelper";

    public static int obtainRequestId() {
        return 0;
    }

    public static void updateRequest(CommonInspectorRequest commonInspectorRequest) {
    }

    public static void updateResponse(CommonInspectorResponse commonInspectorResponse) {
    }

    public static void updateResponseBody(int i, String str) {
    }

    private NetworkPrinterHelper() {
    }

    private static class Holder {
        /* access modifiers changed from: private */
        public static NetworkPrinterHelper INSTANCE = new NetworkPrinterHelper();

        private Holder() {
        }
    }

    /* renamed from: a */
    private static NetworkPrinterHelper m34034a() {
        return Holder.INSTANCE;
    }
}
