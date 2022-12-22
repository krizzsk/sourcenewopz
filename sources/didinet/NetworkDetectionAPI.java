package didinet;

public interface NetworkDetectionAPI {
    public static final NetworkDetectionAPI NONE = new NetworkDetectionAPI() {
        public void callPing(PingParam pingParam, Callback<PingResult> callback) {
            callback.handleResult(PingResult.NONE);
        }

        public void callTraceRoute(TraceRouteParam traceRouteParam, Callback<TraceRouteResult> callback) {
            callback.handleResult(TraceRouteResult.NONE);
        }
    };

    public interface Callback<T> {
        void handleResult(T t);
    }

    public static class PingParam {
        public int pingCount;
        public int pingTimeout;
        public String url;
    }

    public static class PingResult {
        public static final PingResult NONE = new PingResult();
        public float averageTime;
        public String errValue;
        public int failCount;

        /* renamed from: ip */
        public String f57121ip;
        public String normalValue;
        public int sucCount;
        public int totalCount;
    }

    public static class TraceRouteParam {
        public String url;
    }

    public static class TraceRouteResult {
        public static final TraceRouteResult NONE = new TraceRouteResult();
        public String value;
    }

    void callPing(PingParam pingParam, Callback<PingResult> callback);

    void callTraceRoute(TraceRouteParam traceRouteParam, Callback<TraceRouteResult> callback);
}
