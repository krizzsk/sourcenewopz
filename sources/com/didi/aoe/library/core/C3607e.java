package com.didi.aoe.library.core;

import com.didi.aoe.library.core.pojos.Message;
import com.didi.aoe.library.logging.Logger;
import com.didi.aoe.library.logging.LoggerFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.didi.aoe.library.core.e */
/* compiled from: Paser */
final class C3607e {

    /* renamed from: a */
    private static final int f8190a = 102400;

    /* renamed from: b */
    private static final int f8191b = 500;

    /* renamed from: c */
    private final Logger f8192c = LoggerFactory.getLogger("Paser");

    /* renamed from: d */
    private final List<Message> f8193d = new ArrayList();

    C3607e() {
    }

    /* renamed from: a */
    static List<Message> m5311a(byte[] bArr) {
        int length = bArr.length % 102400 == 0 ? bArr.length / 102400 : (bArr.length / 102400) + 1;
        ArrayList arrayList = new ArrayList(length);
        int i = 0;
        while (i < length) {
            int i2 = i + 1;
            arrayList.add(new Message(length, i, Arrays.copyOfRange(bArr, i * 102400, Math.min(i2 * 102400, bArr.length))));
            i = i2;
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public byte[] mo40242a(Message message) {
        this.f8193d.add(message);
        if (message.getPartNum() == message.getPartIndex() + 1) {
            int i = 0;
            for (Message data : this.f8193d) {
                i += data.getData().length;
            }
            byte[] bArr = new byte[i];
            int i2 = 0;
            for (Message next : this.f8193d) {
                System.arraycopy(next.getData(), 0, bArr, i2, next.getData().length);
                i2 += next.getData().length;
            }
            this.f8193d.clear();
            return bArr;
        }
        if (this.f8193d.size() > 500) {
            Logger logger = this.f8192c;
            logger.warn("reach max data size, ignore!!! size: " + this.f8193d.size(), new Object[0]);
            this.f8193d.clear();
        }
        return new byte[0];
    }
}
