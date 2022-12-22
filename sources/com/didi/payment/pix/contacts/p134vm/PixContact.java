package com.didi.payment.pix.contacts.p134vm;

/* renamed from: com.didi.payment.pix.contacts.vm.PixContact */
public class PixContact implements Comparable<PixContact> {
    public String name;
    public String pixKey;

    public int compareTo(PixContact pixContact) {
        return this.name.compareTo(pixContact.name);
    }
}
