package com.jumio.ale.swig;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ALEOutputStream extends FilterOutputStream {

    /* renamed from: a */
    public ALERequest f54505a;

    /* renamed from: b */
    public OutputStream f54506b;

    /* renamed from: c */
    public byte[] f54507c;

    /* renamed from: d */
    public int f54508d;

    /* renamed from: e */
    public boolean f54509e;

    public ALEOutputStream(OutputStream outputStream, ALERequest aLERequest, int i) throws Exception {
        this(outputStream, aLERequest, (ALEHeader) null, i);
    }

    public void close() throws IOException {
        if (!this.f54509e) {
            this.f54509e = true;
            try {
                byte[] bArr = new byte[this.f54505a.calculateRequestFinish()];
                this.f54507c = bArr;
                this.f54508d = this.f54505a.finishRequest(bArr);
            } catch (Exception unused) {
                this.f54507c = null;
                this.f54508d = 0;
            }
            try {
                flush();
            } catch (IOException unused2) {
            }
            this.f54506b.close();
        }
    }

    public void flush() throws IOException {
        byte[] bArr = this.f54507c;
        if (bArr != null) {
            this.f54506b.write(bArr, 0, this.f54508d);
            this.f54507c = null;
        }
        this.f54506b.flush();
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (i == 0 && i2 == bArr.length) {
            write(bArr);
            return;
        }
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        write(bArr2);
    }

    public ALEOutputStream(OutputStream outputStream, ALERequest aLERequest, ALEHeader aLEHeader, int i) throws Exception {
        super(outputStream);
        this.f54505a = null;
        this.f54508d = 0;
        this.f54509e = false;
        this.f54506b = outputStream;
        this.f54505a = aLERequest;
        byte[] bArr = new byte[aLERequest.calculateRequestInit(aLEHeader, i)];
        this.f54507c = bArr;
        int initRequest = aLERequest.initRequest(aLEHeader, i, bArr);
        this.f54508d = initRequest;
        outputStream.write(this.f54507c, 0, initRequest);
    }

    public void write(byte[] bArr) throws IOException {
        byte[] bArr2 = new byte[this.f54505a.calculateRequestUpdate(bArr.length)];
        this.f54507c = bArr2;
        try {
            int updateRequest = this.f54505a.updateRequest(bArr, bArr2);
            this.f54508d = updateRequest;
            byte[] bArr3 = this.f54507c;
            if (bArr3 != null) {
                this.f54506b.write(bArr3, 0, updateRequest);
                this.f54507c = null;
                this.f54508d = 0;
            }
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}
