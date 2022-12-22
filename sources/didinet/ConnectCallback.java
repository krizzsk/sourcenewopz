package didinet;

public interface ConnectCallback {
    void onConnectFinished(ConnectContext connectContext);

    public static class ConnectContext {
        private int cost;
        private boolean success;

        public ConnectContext(boolean z, int i) {
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
