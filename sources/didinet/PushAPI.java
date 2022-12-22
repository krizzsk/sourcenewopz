package didinet;

import diditransreq.p231pb.PushMsg;

public interface PushAPI {
    public static final PushAPI NONE = new PushAPI() {
        public void addPushCallback(PushCallback pushCallback) {
        }

        public PushParam getPushParam() {
            return null;
        }

        public boolean isConnected() {
            return false;
        }

        public boolean isPushInited() {
            return false;
        }

        public int request(int i, byte[] bArr, int i2, byte[] bArr2, boolean z) {
            return -1;
        }

        public LocalIPStack getLocalIPStack() {
            return LocalIPStack.IPv4;
        }
    };

    public interface PushCallback {
        void response(int i, int i2, byte[] bArr, PushMsg pushMsg);
    }

    public static class PushParam {
        public int confVer;
        public int isMulti;
        public String pushHost = null;
        public int pushPort = -1;
        public String pushVer;
        public boolean tls;
    }

    void addPushCallback(PushCallback pushCallback);

    LocalIPStack getLocalIPStack();

    PushParam getPushParam();

    boolean isConnected();

    boolean isPushInited();

    int request(int i, byte[] bArr, int i2, byte[] bArr2, boolean z);
}
