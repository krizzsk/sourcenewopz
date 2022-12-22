package com.koushikdutta.async.stream;

import com.koushikdutta.async.AsyncServer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileDataSink extends OutputStreamDataSink {

    /* renamed from: a */
    File f55439a;

    public FileDataSink(AsyncServer asyncServer, File file) {
        super(asyncServer);
        this.f55439a = file;
    }

    public OutputStream getOutputStream() throws IOException {
        OutputStream outputStream = super.getOutputStream();
        if (outputStream != null) {
            return outputStream;
        }
        this.f55439a.getParentFile().mkdirs();
        FileOutputStream fileOutputStream = new FileOutputStream(this.f55439a);
        setOutputStream(fileOutputStream);
        return fileOutputStream;
    }
}
