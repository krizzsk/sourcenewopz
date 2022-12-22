package com.koushikdutta.async;

import com.didi.sdk.apm.SystemUtils;
import com.koushikdutta.async.callback.DataCallback;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;

public class PushParser implements DataCallback {

    /* renamed from: d */
    static Hashtable<Class, Method> f55223d = new Hashtable<>();

    /* renamed from: a */
    DataEmitter f55224a;

    /* renamed from: b */
    ByteOrder f55225b = ByteOrder.BIG_ENDIAN;

    /* renamed from: c */
    ByteBufferList f55226c = new ByteBufferList();

    /* renamed from: e */
    private Waiter f55227e = new Waiter(0) {
        public Waiter onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            PushParser.this.f55236n.add((Object) null);
            return null;
        }
    };

    /* renamed from: f */
    private Waiter f55228f = new Waiter(1) {
        public Waiter onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            PushParser.this.f55236n.add(Byte.valueOf(byteBufferList.get()));
            return null;
        }
    };

    /* renamed from: g */
    private Waiter f55229g = new Waiter(2) {
        public Waiter onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            PushParser.this.f55236n.add(Short.valueOf(byteBufferList.getShort()));
            return null;
        }
    };

    /* renamed from: h */
    private Waiter f55230h = new Waiter(4) {
        public Waiter onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            PushParser.this.f55236n.add(Integer.valueOf(byteBufferList.getInt()));
            return null;
        }
    };

    /* renamed from: i */
    private Waiter f55231i = new Waiter(8) {
        public Waiter onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            PushParser.this.f55236n.add(Long.valueOf(byteBufferList.getLong()));
            return null;
        }
    };

    /* renamed from: j */
    private ParseCallback<byte[]> f55232j = new ParseCallback<byte[]>() {
        public void parsed(byte[] bArr) {
            PushParser.this.f55236n.add(bArr);
        }
    };

    /* renamed from: k */
    private ParseCallback<ByteBufferList> f55233k = new ParseCallback<ByteBufferList>() {
        public void parsed(ByteBufferList byteBufferList) {
            PushParser.this.f55236n.add(byteBufferList);
        }
    };

    /* renamed from: l */
    private ParseCallback<byte[]> f55234l = new ParseCallback<byte[]>() {
        public void parsed(byte[] bArr) {
            PushParser.this.f55236n.add(new String(bArr));
        }
    };

    /* renamed from: m */
    private LinkedList<Waiter> f55235m = new LinkedList<>();
    /* access modifiers changed from: private */

    /* renamed from: n */
    public ArrayList<Object> f55236n = new ArrayList<>();

    public interface ParseCallback<T> {
        void parsed(T t);
    }

    static abstract class Waiter {
        int length;

        public abstract Waiter onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList);

        public Waiter(int i) {
            this.length = i;
        }
    }

    static class IntWaiter extends Waiter {
        ParseCallback<Integer> callback;

        public IntWaiter(ParseCallback<Integer> parseCallback) {
            super(4);
            this.callback = parseCallback;
        }

        public Waiter onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            this.callback.parsed(Integer.valueOf(byteBufferList.getInt()));
            return null;
        }
    }

    static class ByteArrayWaiter extends Waiter {
        ParseCallback<byte[]> callback;

        public ByteArrayWaiter(int i, ParseCallback<byte[]> parseCallback) {
            super(i);
            if (i > 0) {
                this.callback = parseCallback;
                return;
            }
            throw new IllegalArgumentException("length should be > 0");
        }

        public Waiter onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            byte[] bArr = new byte[this.length];
            byteBufferList.get(bArr);
            this.callback.parsed(bArr);
            return null;
        }
    }

    static class LenByteArrayWaiter extends Waiter {
        private final ParseCallback<byte[]> callback;

        public LenByteArrayWaiter(ParseCallback<byte[]> parseCallback) {
            super(4);
            this.callback = parseCallback;
        }

        public Waiter onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            int i = byteBufferList.getInt();
            if (i != 0) {
                return new ByteArrayWaiter(i, this.callback);
            }
            this.callback.parsed(new byte[0]);
            return null;
        }
    }

    static class ByteBufferListWaiter extends Waiter {
        ParseCallback<ByteBufferList> callback;

        public ByteBufferListWaiter(int i, ParseCallback<ByteBufferList> parseCallback) {
            super(i);
            if (i > 0) {
                this.callback = parseCallback;
                return;
            }
            throw new IllegalArgumentException("length should be > 0");
        }

        public Waiter onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            this.callback.parsed(byteBufferList.get(this.length));
            return null;
        }
    }

    static class LenByteBufferListWaiter extends Waiter {
        private final ParseCallback<ByteBufferList> callback;

        public LenByteBufferListWaiter(ParseCallback<ByteBufferList> parseCallback) {
            super(4);
            this.callback = parseCallback;
        }

        public Waiter onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            return new ByteBufferListWaiter(byteBufferList.getInt(), this.callback);
        }
    }

    static class UntilWaiter extends Waiter {
        DataCallback callback;
        byte value;

        public UntilWaiter(byte b, DataCallback dataCallback) {
            super(1);
            this.value = b;
            this.callback = dataCallback;
        }

        public Waiter onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            ByteBufferList byteBufferList2 = new ByteBufferList();
            boolean z = true;
            while (true) {
                if (byteBufferList.size() <= 0) {
                    break;
                }
                ByteBuffer remove = byteBufferList.remove();
                remove.mark();
                int i = 0;
                while (remove.remaining() > 0) {
                    z = remove.get() == this.value;
                    if (z) {
                        break;
                    }
                    i++;
                }
                remove.reset();
                if (z) {
                    byteBufferList.addFirst(remove);
                    byteBufferList.get(byteBufferList2, i);
                    byteBufferList.get();
                    break;
                }
                byteBufferList2.add(remove);
            }
            this.callback.onDataAvailable(dataEmitter, byteBufferList2);
            if (z) {
                return null;
            }
            return this;
        }
    }

    private class TapWaiter extends Waiter {
        private final TapCallback callback;

        public TapWaiter(TapCallback tapCallback) {
            super(0);
            this.callback = tapCallback;
        }

        public Waiter onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
            Method a = PushParser.m39733a(this.callback);
            a.setAccessible(true);
            try {
                a.invoke(this.callback, PushParser.this.f55236n.toArray());
            } catch (Exception e) {
                SystemUtils.log(6, "PushParser", "Error while invoking tap callback", e, "com.koushikdutta.async.PushParser$TapWaiter", 172);
            }
            PushParser.this.f55236n.clear();
            return null;
        }
    }

    public PushParser setOrder(ByteOrder byteOrder) {
        this.f55225b = byteOrder;
        return this;
    }

    public PushParser(DataEmitter dataEmitter) {
        this.f55224a = dataEmitter;
        dataEmitter.setDataCallback(this);
    }

    public PushParser readInt(ParseCallback<Integer> parseCallback) {
        this.f55235m.add(new IntWaiter(parseCallback));
        return this;
    }

    public PushParser readByteArray(int i, ParseCallback<byte[]> parseCallback) {
        this.f55235m.add(new ByteArrayWaiter(i, parseCallback));
        return this;
    }

    public PushParser readByteBufferList(int i, ParseCallback<ByteBufferList> parseCallback) {
        this.f55235m.add(new ByteBufferListWaiter(i, parseCallback));
        return this;
    }

    public PushParser until(byte b, DataCallback dataCallback) {
        this.f55235m.add(new UntilWaiter(b, dataCallback));
        return this;
    }

    public PushParser readByte() {
        this.f55235m.add(this.f55228f);
        return this;
    }

    public PushParser readShort() {
        this.f55235m.add(this.f55229g);
        return this;
    }

    public PushParser readInt() {
        this.f55235m.add(this.f55230h);
        return this;
    }

    public PushParser readLong() {
        this.f55235m.add(this.f55231i);
        return this;
    }

    public PushParser readByteArray(int i) {
        return i == -1 ? readLenByteArray() : readByteArray(i, this.f55232j);
    }

    public PushParser readLenByteArray() {
        this.f55235m.add(new LenByteArrayWaiter(this.f55232j));
        return this;
    }

    public PushParser readByteBufferList(int i) {
        return i == -1 ? readLenByteBufferList() : readByteBufferList(i, this.f55233k);
    }

    public PushParser readLenByteBufferList() {
        return readLenByteBufferList(this.f55233k);
    }

    public PushParser readLenByteBufferList(ParseCallback<ByteBufferList> parseCallback) {
        this.f55235m.add(new LenByteBufferListWaiter(parseCallback));
        return this;
    }

    public PushParser readString() {
        this.f55235m.add(new LenByteArrayWaiter(this.f55234l));
        return this;
    }

    public PushParser noop() {
        this.f55235m.add(this.f55227e);
        return this;
    }

    public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
        byteBufferList.get(this.f55226c);
        while (this.f55235m.size() > 0 && this.f55226c.remaining() >= this.f55235m.peek().length) {
            this.f55226c.order(this.f55225b);
            Waiter onDataAvailable = this.f55235m.poll().onDataAvailable(dataEmitter, this.f55226c);
            if (onDataAvailable != null) {
                this.f55235m.addFirst(onDataAvailable);
            }
        }
        if (this.f55235m.size() == 0) {
            this.f55226c.get(byteBufferList);
        }
    }

    public void tap(TapCallback tapCallback) {
        this.f55235m.add(new TapWaiter(tapCallback));
    }

    /* renamed from: a */
    static Method m39733a(TapCallback tapCallback) {
        Method method = f55223d.get(tapCallback.getClass());
        if (method != null) {
            return method;
        }
        for (Method method2 : tapCallback.getClass().getMethods()) {
            if ("tap".equals(method2.getName())) {
                f55223d.put(tapCallback.getClass(), method2);
                return method2;
            }
        }
        Method[] declaredMethods = tapCallback.getClass().getDeclaredMethods();
        if (declaredMethods.length == 1) {
            return declaredMethods[0];
        }
        throw new AssertionError("-keep class * extends com.koushikdutta.async.TapCallback {\n    *;\n}\n");
    }
}
