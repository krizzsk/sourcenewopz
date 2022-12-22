package com.didichuxing.gbankcard.ocr.bankcard;

public interface IBankcardDetector {
    public static final int INIT_FAIL = 0;
    public static final int INIT_OK = 1;

    int detect(byte[] bArr, int i, int i2, BankcardResult bankcardResult);

    void stop();
}
