package com.didichuxing.foundation.net.http;

import com.didichuxing.foundation.net.MimeType;
import com.didichuxing.foundation.p188io.Streams;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.didichuxing.foundation.net.http.d */
/* compiled from: FileMultipartBody */
class C15560d extends C15557a {
    private final File mFile;
    private InputStream mStream;

    public String getTransferEncoding() {
        return "binary";
    }

    public C15560d(File file) {
        this(file, MimeType.guess(file));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public C15560d(File file, MimeType mimeType) {
        this(file, mimeType, file == null ? null : file.getName());
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C15560d(File file, MimeType mimeType, String str) {
        super(mimeType == null ? MimeType.APPLICATION_OCTET_STREAM : mimeType, str);
        this.mFile = file;
    }

    public long getContentLength() {
        return this.mFile.length();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(this.mFile);
        try {
            Streams.copy(fileInputStream, outputStream);
        } finally {
            Streams.closeQuietly(fileInputStream);
        }
    }

    public File getFile() {
        return this.mFile;
    }

    public InputStream getContent() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(this.mFile);
        this.mStream = fileInputStream;
        return fileInputStream;
    }

    public void close() throws IOException {
        InputStream inputStream = this.mStream;
        if (inputStream != null) {
            inputStream.close();
            this.mStream = null;
        }
    }
}
