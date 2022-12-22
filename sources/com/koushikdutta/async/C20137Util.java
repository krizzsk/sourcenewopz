package com.koushikdutta.async;

import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.callback.WritableCallback;
import com.koushikdutta.async.util.Allocator;
import com.koushikdutta.async.util.StreamUtility;
import com.koushikdutta.async.wrapper.AsyncSocketWrapper;
import com.koushikdutta.async.wrapper.DataEmitterWrapper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.ByteBuffer;

/* renamed from: com.koushikdutta.async.Util */
public class C20137Util {
    public static boolean SUPRESS_DEBUG_EXCEPTIONS = false;

    /* renamed from: a */
    static final /* synthetic */ boolean f55237a = (!C20137Util.class.desiredAssertionStatus());

    public static void emitAllData(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
        int remaining;
        DataCallback dataCallback = null;
        while (!dataEmitter.isPaused() && (dataCallback = dataEmitter.getDataCallback()) != null && (remaining = byteBufferList.remaining()) > 0) {
            dataCallback.onDataAvailable(dataEmitter, byteBufferList);
            if (remaining == byteBufferList.remaining() && dataCallback == dataEmitter.getDataCallback() && !dataEmitter.isPaused()) {
                PrintStream printStream = System.out;
                printStream.println("handler: " + dataCallback);
                byteBufferList.recycle();
                if (!SUPRESS_DEBUG_EXCEPTIONS) {
                    if (!f55237a) {
                        throw new AssertionError();
                    }
                    throw new RuntimeException("mDataHandler failed to consume data, yet remains the mDataHandler.");
                }
                return;
            }
        }
        if (byteBufferList.remaining() != 0 && !dataEmitter.isPaused()) {
            PrintStream printStream2 = System.out;
            printStream2.println("handler: " + dataCallback);
            PrintStream printStream3 = System.out;
            printStream3.println("emitter: " + dataEmitter);
            byteBufferList.recycle();
            if (SUPRESS_DEBUG_EXCEPTIONS) {
            }
        }
    }

    public static void pump(InputStream inputStream, DataSink dataSink, CompletedCallback completedCallback) {
        pump(inputStream, 2147483647L, dataSink, completedCallback);
    }

    public static void pump(InputStream inputStream, long j, DataSink dataSink, final CompletedCallback completedCallback) {
        C201381 r6 = new CompletedCallback() {
            boolean reported;

            public void onCompleted(Exception exc) {
                if (!this.reported) {
                    this.reported = true;
                    completedCallback.onCompleted(exc);
                }
            }
        };
        final DataSink dataSink2 = dataSink;
        final InputStream inputStream2 = inputStream;
        final long j2 = j;
        final C201381 r5 = r6;
        C201392 r0 = new WritableCallback() {
            Allocator allocator = new Allocator().setMinAlloc((int) Math.min(1048576, j2));
            ByteBufferList pending = new ByteBufferList();
            int totalRead = 0;

            private void cleanup() {
                dataSink2.setClosedCallback((CompletedCallback) null);
                dataSink2.setWriteableCallback((WritableCallback) null);
                this.pending.recycle();
                StreamUtility.closeQuietly(inputStream2);
            }

            public void onWriteable() {
                do {
                    try {
                        if (!this.pending.hasRemaining()) {
                            ByteBuffer allocate = this.allocator.allocate();
                            int read = inputStream2.read(allocate.array(), 0, (int) Math.min(j2 - ((long) this.totalRead), (long) allocate.capacity()));
                            if (read != -1) {
                                if (((long) this.totalRead) != j2) {
                                    this.allocator.track((long) read);
                                    this.totalRead += read;
                                    allocate.position(0);
                                    allocate.limit(read);
                                    this.pending.add(allocate);
                                }
                            }
                            cleanup();
                            r5.onCompleted((Exception) null);
                            return;
                        }
                        dataSink2.write(this.pending);
                    } catch (Exception e) {
                        cleanup();
                        r5.onCompleted(e);
                        return;
                    }
                } while (!this.pending.hasRemaining());
            }
        };
        dataSink.setWriteableCallback(r0);
        dataSink.setClosedCallback(r6);
        r0.onWriteable();
    }

    public static void pump(final DataEmitter dataEmitter, final DataSink dataSink, final CompletedCallback completedCallback) {
        dataEmitter.setDataCallback(new DataCallback() {
            public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
                dataSink.write(byteBufferList);
                if (byteBufferList.remaining() > 0) {
                    dataEmitter.pause();
                }
            }
        });
        dataSink.setWriteableCallback(new WritableCallback() {
            public void onWriteable() {
                dataEmitter.resume();
            }
        });
        final C201425 r0 = new CompletedCallback() {
            boolean reported;

            public void onCompleted(Exception exc) {
                if (!this.reported) {
                    this.reported = true;
                    dataEmitter.setDataCallback((DataCallback) null);
                    dataEmitter.setEndCallback((CompletedCallback) null);
                    dataSink.setClosedCallback((CompletedCallback) null);
                    dataSink.setWriteableCallback((WritableCallback) null);
                    completedCallback.onCompleted(exc);
                }
            }
        };
        dataEmitter.setEndCallback(r0);
        dataSink.setClosedCallback(new CompletedCallback() {
            public void onCompleted(Exception exc) {
                if (exc == null) {
                    exc = new IOException("sink was closed before emitter ended");
                }
                r0.onCompleted(exc);
            }
        });
    }

    public static void stream(AsyncSocket asyncSocket, AsyncSocket asyncSocket2, CompletedCallback completedCallback) {
        pump((DataEmitter) asyncSocket, (DataSink) asyncSocket2, completedCallback);
        pump((DataEmitter) asyncSocket2, (DataSink) asyncSocket, completedCallback);
    }

    public static void pump(File file, DataSink dataSink, final CompletedCallback completedCallback) {
        if (file == null || dataSink == null) {
            completedCallback.onCompleted((Exception) null);
            return;
        }
        try {
            final FileInputStream fileInputStream = new FileInputStream(file);
            pump((InputStream) fileInputStream, dataSink, (CompletedCallback) new CompletedCallback() {
                public void onCompleted(Exception exc) {
                    try {
                        fileInputStream.close();
                        completedCallback.onCompleted(exc);
                    } catch (IOException e) {
                        completedCallback.onCompleted(e);
                    }
                }
            });
        } catch (Exception e) {
            completedCallback.onCompleted(e);
        }
    }

    public static void writeAll(final DataSink dataSink, final ByteBufferList byteBufferList, final CompletedCallback completedCallback) {
        C201458 r0 = new WritableCallback() {
            public void onWriteable() {
                dataSink.write(byteBufferList);
                if (byteBufferList.remaining() == 0 && completedCallback != null) {
                    dataSink.setWriteableCallback((WritableCallback) null);
                    completedCallback.onCompleted((Exception) null);
                }
            }
        };
        dataSink.setWriteableCallback(r0);
        r0.onWriteable();
    }

    public static void writeAll(DataSink dataSink, byte[] bArr, CompletedCallback completedCallback) {
        ByteBuffer obtain = ByteBufferList.obtain(bArr.length);
        obtain.put(bArr);
        obtain.flip();
        ByteBufferList byteBufferList = new ByteBufferList();
        byteBufferList.add(obtain);
        writeAll(dataSink, byteBufferList, completedCallback);
    }

    public static <T extends AsyncSocket> T getWrappedSocket(T t, Class<T> cls) {
        if (cls.isInstance(t)) {
            return t;
        }
        while (t instanceof AsyncSocketWrapper) {
            t = ((AsyncSocketWrapper) t).getSocket();
            if (cls.isInstance(t)) {
                return t;
            }
        }
        return null;
    }

    public static DataEmitter getWrappedDataEmitter(DataEmitter dataEmitter, Class cls) {
        if (cls.isInstance(dataEmitter)) {
            return dataEmitter;
        }
        while (dataEmitter instanceof DataEmitterWrapper) {
            dataEmitter = ((AsyncSocketWrapper) dataEmitter).getSocket();
            if (cls.isInstance(dataEmitter)) {
                return dataEmitter;
            }
        }
        return null;
    }

    public static void end(DataEmitter dataEmitter, Exception exc) {
        if (dataEmitter != null) {
            end(dataEmitter.getEndCallback(), exc);
        }
    }

    public static void end(CompletedCallback completedCallback, Exception exc) {
        if (completedCallback != null) {
            completedCallback.onCompleted(exc);
        }
    }

    public static void writable(DataSink dataSink) {
        if (dataSink != null) {
            writable(dataSink.getWriteableCallback());
        }
    }

    public static void writable(WritableCallback writableCallback) {
        if (writableCallback != null) {
            writableCallback.onWriteable();
        }
    }
}
