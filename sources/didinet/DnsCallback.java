package didinet;

public interface DnsCallback {
    void onDnsFinished(DnsContext dnsContext);

    public static class DnsContext {
        private int cost;
        private boolean success;

        public DnsContext(boolean z, int i) {
            this.success = z;
            this.cost = i;
        }

        public boolean isSuccess() {
            return this.success;
        }

        public int getCost() {
            return this.cost;
        }
    }
}
