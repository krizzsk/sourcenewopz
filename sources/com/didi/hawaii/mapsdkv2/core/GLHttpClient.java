package com.didi.hawaii.mapsdkv2.core;

import java.io.IOException;

public interface GLHttpClient {

    public interface Callback {
        void onFailed(int i, Exception exc);

        void onSuccess(int i, byte[] bArr);
    }

    public static class Res {
        public byte[] bytes;
        public int retCode;
    }

    Res doGet(String str) throws IOException;

    void doGet(String str, Callback callback);

    Res doPost(String str, byte[] bArr) throws IOException;

    void doPost(String str, byte[] bArr, Callback callback);
}
