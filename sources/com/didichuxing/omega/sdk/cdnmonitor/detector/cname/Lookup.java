package com.didichuxing.omega.sdk.cdnmonitor.detector.cname;

import com.didichuxing.omega.sdk.common.utils.OLog;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class Lookup {
    private String Cname = "";
    private String dnsName;
    private String dns_ip;

    private int getRcode(int i) {
        return i & 15;
    }

    public Lookup(String str, String str2) {
        this.dnsName = str;
        this.dns_ip = str2;
    }

    public String getCname() {
        return this.Cname;
    }

    public void Run() {
        try {
            int length = this.dnsName.length() + 2;
            byte[] buildMessage = buildMessage(this.dnsName, 5);
            DatagramSocket datagramSocket = new DatagramSocket();
            datagramSocket.send(new DatagramPacket(buildMessage, buildMessage.length, new InetSocketAddress(this.dns_ip, 53)));
            DatagramPacket datagramPacket = new DatagramPacket(new byte[100], 100);
            datagramSocket.receive(datagramPacket);
            byte[] data = datagramPacket.getData();
            if (data != null) {
                DNSInput dNSInput = new DNSInput(data);
                dNSInput.jump(2);
                int readU16 = dNSInput.readU16();
                dNSInput.jump(6);
                if (dNSInput.readU16() != 0 && getRcode(readU16) == 0) {
                    int i = length + 12 + 4 + 10;
                    dNSInput.jump(i);
                    int readU162 = dNSInput.readU16();
                    byte[] bArr = new byte[readU162];
                    System.arraycopy(data, i + 2, bArr, 0, readU162);
                    int i2 = readU162 - 2;
                    byte b = bArr[i2];
                    byte b2 = bArr[readU162 - 1];
                    if (b == -64) {
                        dNSInput.jump(b2);
                        int readU8 = dNSInput.readU8();
                        byte[] bArr2 = new byte[(i2 + readU8 + 1)];
                        System.arraycopy(bArr, 0, bArr2, 0, i2);
                        System.arraycopy(data, dNSInput.current() - 1, bArr2, i2, readU8 + 1);
                        addDotsFromCname(new String(bArr2));
                    }
                }
            }
        } catch (Exception e) {
            OLog.m34763e("cname : " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void addDotsFromCname(String str) {
        int i;
        char[] charArray = str.toCharArray();
        String str2 = "";
        int i2 = 0;
        while (i2 < charArray.length) {
            int i3 = i2 + 1;
            char c = charArray[i2];
            int i4 = i3;
            while (true) {
                i = c + i3;
                if (i4 >= i) {
                    break;
                }
                str2 = str2 + charArray[i4];
                i4++;
            }
            if (i != charArray.length) {
                str2 = str2 + ".";
            }
            i2 = i;
        }
        this.Cname = str2;
    }

    private byte[] buildMessage(String str, short s) {
        Header header = new Header();
        header.setFlag(6);
        header.setFlag(7);
        header.setCount(0, 1);
        header.setCount(1, 0);
        header.setCount(2, 0);
        header.setCount(3, 0);
        QUESTION question = new QUESTION(s, 1);
        byte[] bytes = removeDotsFromName(str).getBytes();
        return byteMergerAll(header.toByteArray(), bytes, question.toByteArray());
    }

    private static byte[] byteMergerAll(byte[]... bArr) {
        int i = 0;
        for (byte[] length : bArr) {
            i += length.length;
        }
        byte[] bArr2 = new byte[i];
        int i2 = 0;
        for (byte[] bArr3 : bArr) {
            System.arraycopy(bArr3, 0, bArr2, i2, bArr3.length);
            i2 += bArr3.length;
        }
        return bArr2;
    }

    private String removeDotsFromName(String str) {
        char[] cArr = new char[(str.length() + 2)];
        char[] charArray = (str + ".").toCharArray();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < charArray.length; i3++) {
            if (charArray[i3] == '.') {
                cArr[i] = (char) (i3 - i2);
                i++;
                while (i2 < i3) {
                    cArr[i] = charArray[i2];
                    i2++;
                    i++;
                }
                i2++;
            }
        }
        cArr[i] = 0;
        return String.valueOf(cArr);
    }
}
