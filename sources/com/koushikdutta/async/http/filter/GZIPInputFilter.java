package com.koushikdutta.async.http.filter;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.PushParser;
import com.koushikdutta.async.callback.DataCallback;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Locale;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.UShort;

public class GZIPInputFilter extends InflaterInputFilter {

    /* renamed from: d */
    private static final int f55413d = 16;

    /* renamed from: e */
    private static final int f55414e = 4;

    /* renamed from: f */
    private static final int f55415f = 2;

    /* renamed from: g */
    private static final int f55416g = 8;

    /* renamed from: a */
    boolean f55417a = true;
    protected CRC32 crc = new CRC32();

    public static int unsignedToBytes(byte b) {
        return b & 255;
    }

    /* renamed from: a */
    static short m39991a(byte[] bArr, int i, ByteOrder byteOrder) {
        int i2;
        byte b;
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            i2 = bArr[i] << 8;
            b = bArr[i + 1];
        } else {
            i2 = bArr[i + 1] << 8;
            b = bArr[i];
        }
        return (short) ((b & 255) | i2);
    }

    public GZIPInputFilter() {
        super(new Inflater(true));
    }

    public void onDataAvailable(final DataEmitter dataEmitter, ByteBufferList byteBufferList) {
        if (this.f55417a) {
            final PushParser pushParser = new PushParser(dataEmitter);
            pushParser.readByteArray(10, new PushParser.ParseCallback<byte[]>() {
                int flags;
                boolean hcrc;

                public void parsed(byte[] bArr) {
                    short a = GZIPInputFilter.m39991a(bArr, 0, ByteOrder.LITTLE_ENDIAN);
                    boolean z = true;
                    if (a != -29921) {
                        GZIPInputFilter.this.report(new IOException(String.format(Locale.ENGLISH, "unknown format (magic number %x)", new Object[]{Short.valueOf(a)})));
                        dataEmitter.setDataCallback(new DataCallback.NullDataCallback());
                        return;
                    }
                    byte b = bArr[3];
                    this.flags = b;
                    if ((b & 2) == 0) {
                        z = false;
                    }
                    this.hcrc = z;
                    if (z) {
                        GZIPInputFilter.this.crc.update(bArr, 0, bArr.length);
                    }
                    if ((this.flags & 4) != 0) {
                        pushParser.readByteArray(2, new PushParser.ParseCallback<byte[]>() {
                            public void parsed(byte[] bArr) {
                                if (C202221.this.hcrc) {
                                    GZIPInputFilter.this.crc.update(bArr, 0, 2);
                                }
                                pushParser.readByteArray(GZIPInputFilter.m39991a(bArr, 0, ByteOrder.LITTLE_ENDIAN) & UShort.MAX_VALUE, new PushParser.ParseCallback<byte[]>() {
                                    public void parsed(byte[] bArr) {
                                        if (C202221.this.hcrc) {
                                            GZIPInputFilter.this.crc.update(bArr, 0, bArr.length);
                                        }
                                        C202221.this.next();
                                    }
                                });
                            }
                        });
                    } else {
                        next();
                    }
                }

                /* access modifiers changed from: private */
                public void next() {
                    PushParser pushParser = new PushParser(dataEmitter);
                    C202252 r1 = new DataCallback() {
                        public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
                            if (C202221.this.hcrc) {
                                while (byteBufferList.size() > 0) {
                                    ByteBuffer remove = byteBufferList.remove();
                                    GZIPInputFilter.this.crc.update(remove.array(), remove.arrayOffset() + remove.position(), remove.remaining());
                                    ByteBufferList.reclaim(remove);
                                }
                            }
                            byteBufferList.recycle();
                            C202221.this.done();
                        }
                    };
                    int i = this.flags;
                    if ((i & 8) != 0) {
                        pushParser.until((byte) 0, r1);
                    } else if ((i & 16) != 0) {
                        pushParser.until((byte) 0, r1);
                    } else {
                        done();
                    }
                }

                /* access modifiers changed from: private */
                public void done() {
                    if (this.hcrc) {
                        pushParser.readByteArray(2, new PushParser.ParseCallback<byte[]>() {
                            public void parsed(byte[] bArr) {
                                if (((short) ((int) GZIPInputFilter.this.crc.getValue())) != GZIPInputFilter.m39991a(bArr, 0, ByteOrder.LITTLE_ENDIAN)) {
                                    GZIPInputFilter.this.report(new IOException("CRC mismatch"));
                                    return;
                                }
                                GZIPInputFilter.this.crc.reset();
                                GZIPInputFilter.this.f55417a = false;
                                GZIPInputFilter.this.setDataEmitter(dataEmitter);
                            }
                        });
                        return;
                    }
                    GZIPInputFilter.this.f55417a = false;
                    GZIPInputFilter.this.setDataEmitter(dataEmitter);
                }
            });
            return;
        }
        super.onDataAvailable(dataEmitter, byteBufferList);
    }
}
