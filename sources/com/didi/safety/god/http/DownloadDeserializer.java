package com.didi.safety.god.http;

import com.didi.safety.god.manager.GodManager;
import com.didichuxing.foundation.p188io.AbstractDeserializer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

public class DownloadDeserializer extends AbstractDeserializer<Long> implements Serializable {
    public Long deserialize(InputStream inputStream) throws IOException {
        File downloadPath = GodManager.getInstance().getDownloadPath();
        if (!downloadPath.getParentFile().exists()) {
            downloadPath.getParentFile().mkdirs();
        }
        downloadPath.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(downloadPath);
        byte[] bArr = new byte[Constants.CONN_CHANNEL_RECVBUFFERSIZE];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                fileOutputStream.close();
                return Long.valueOf(GodManager.getInstance().getDownloadModelVersion(downloadPath.getAbsolutePath()));
            }
        }
    }
}
