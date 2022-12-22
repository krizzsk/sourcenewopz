package com.facebook.crypto;

import java.io.UnsupportedEncodingException;

public class Entity {
    private String mName;

    public Entity(String str) {
        this.mName = str;
    }

    public byte[] getBytes() throws UnsupportedEncodingException {
        return this.mName.getBytes("UTF-16");
    }
}
