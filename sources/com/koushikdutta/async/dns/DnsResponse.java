package com.koushikdutta.async.dns;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.http.Multimap;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;

public class DnsResponse {
    public ArrayList<InetAddress> addresses = new ArrayList<>();
    public ArrayList<String> names = new ArrayList<>();
    public InetSocketAddress source;
    public Multimap txt = new Multimap();

    /* renamed from: a */
    private static String m39782a(ByteBufferList byteBufferList, ByteBuffer byteBuffer) {
        byteBufferList.order(ByteOrder.BIG_ENDIAN);
        String str = "";
        while (true) {
            int i = byteBufferList.get() & 255;
            if (i == 0) {
                return str;
            }
            if ((i & 192) == 192) {
                int i2 = (byteBufferList.get() & 255) | ((i & 63) << 8);
                if (str.length() > 0) {
                    str = str + ".";
                }
                ByteBufferList byteBufferList2 = new ByteBufferList();
                ByteBuffer duplicate = byteBuffer.duplicate();
                duplicate.get(new byte[i2]);
                byteBufferList2.add(duplicate);
                return str + m39782a(byteBufferList2, byteBuffer);
            }
            byte[] bArr = new byte[i];
            byteBufferList.get(bArr);
            if (str.length() > 0) {
                str = str + ".";
            }
            str = str + new String(bArr);
        }
    }

    public static DnsResponse parse(ByteBufferList byteBufferList) {
        ByteBuffer all = byteBufferList.getAll();
        byteBufferList.add(all.duplicate());
        byteBufferList.order(ByteOrder.BIG_ENDIAN);
        byteBufferList.getShort();
        byteBufferList.getShort();
        short s = byteBufferList.getShort();
        short s2 = byteBufferList.getShort();
        short s3 = byteBufferList.getShort();
        short s4 = byteBufferList.getShort();
        for (int i = 0; i < s; i++) {
            m39782a(byteBufferList, all);
            byteBufferList.getShort();
            byteBufferList.getShort();
        }
        DnsResponse dnsResponse = new DnsResponse();
        for (int i2 = 0; i2 < s2; i2++) {
            m39782a(byteBufferList, all);
            short s5 = byteBufferList.getShort();
            byteBufferList.getShort();
            byteBufferList.getInt();
            int i3 = byteBufferList.getShort();
            if (s5 == 1) {
                try {
                    byte[] bArr = new byte[i3];
                    byteBufferList.get(bArr);
                    dnsResponse.addresses.add(InetAddress.getByAddress(bArr));
                } catch (Exception unused) {
                }
            } else if (s5 == 12) {
                dnsResponse.names.add(m39782a(byteBufferList, all));
            } else if (s5 == 16) {
                ByteBufferList byteBufferList2 = new ByteBufferList();
                byteBufferList.get(byteBufferList2, i3);
                dnsResponse.mo163926a(byteBufferList2);
            } else {
                byteBufferList.get(new byte[i3]);
            }
        }
        for (int i4 = 0; i4 < s3; i4++) {
            m39782a(byteBufferList, all);
            byteBufferList.getShort();
            byteBufferList.getShort();
            byteBufferList.getInt();
            try {
                byteBufferList.get(new byte[byteBufferList.getShort()]);
            } catch (Exception unused2) {
            }
        }
        for (int i5 = 0; i5 < s4; i5++) {
            m39782a(byteBufferList, all);
            short s6 = byteBufferList.getShort();
            byteBufferList.getShort();
            byteBufferList.getInt();
            int i6 = byteBufferList.getShort();
            if (s6 == 16) {
                try {
                    ByteBufferList byteBufferList3 = new ByteBufferList();
                    byteBufferList.get(byteBufferList3, i6);
                    dnsResponse.mo163926a(byteBufferList3);
                } catch (Exception unused3) {
                }
            } else {
                byteBufferList.get(new byte[i6]);
            }
        }
        return dnsResponse;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo163926a(ByteBufferList byteBufferList) {
        while (byteBufferList.hasRemaining()) {
            byte[] bArr = new byte[(byteBufferList.get() & 255)];
            byteBufferList.get(bArr);
            String[] split = new String(bArr).split("=");
            this.txt.add(split[0], split[1]);
        }
    }

    public String toString() {
        Iterator<InetAddress> it = this.addresses.iterator();
        String str = "addresses:\n";
        while (it.hasNext()) {
            str = str + it.next().toString() + "\n";
        }
        String str2 = str + "names:\n";
        Iterator<String> it2 = this.names.iterator();
        while (it2.hasNext()) {
            str2 = str2 + it2.next() + "\n";
        }
        return str2;
    }
}
