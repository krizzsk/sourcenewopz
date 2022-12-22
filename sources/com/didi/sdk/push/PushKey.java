package com.didi.sdk.push;

public interface PushKey {
    long generateKey();

    public static class Creator {
        public static PushKey createPushMsgKey(int i) {
            return new PushMsgKey(i);
        }

        public static PushKey createAppPushMsgKey(int i) {
            return new AppPushMsgKey(i);
        }
    }
}
