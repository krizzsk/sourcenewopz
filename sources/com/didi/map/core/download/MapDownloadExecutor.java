package com.didi.map.core.download;

public interface MapDownloadExecutor {
    byte[] download(String str);

    byte[] download(String str, byte[] bArr);
}
