package com.cardinalcommerce.dependencies.internal.nimbusds.jose.crypto.impl;

import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JOSEException;
import com.cardinalcommerce.dependencies.internal.nimbusds.jose.JWEHeader;
import com.cardinalcommerce.p060a.setPictureListener;
import com.cardinalcommerce.p060a.valueOf;

public class DeflateHelper {
    public static byte[] init(JWEHeader jWEHeader, byte[] bArr) throws JOSEException {
        setPictureListener setpicturelistener = jWEHeader.Cardinal;
        if (setpicturelistener == null) {
            return bArr;
        }
        if (setpicturelistener.equals(setPictureListener.Cardinal)) {
            try {
                return valueOf.getInstance(bArr);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder("Couldn't compress plain text: ");
                sb.append(e.getMessage());
                throw new JOSEException(sb.toString(), e);
            }
        } else {
            throw new JOSEException("Unsupported compression algorithm: ".concat(String.valueOf(setpicturelistener)));
        }
    }

    public static byte[] getInstance(JWEHeader jWEHeader, byte[] bArr) throws JOSEException {
        setPictureListener setpicturelistener = jWEHeader.Cardinal;
        if (setpicturelistener == null) {
            return bArr;
        }
        if (setpicturelistener.equals(setPictureListener.Cardinal)) {
            try {
                return valueOf.Cardinal(bArr);
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder("Couldn't decompress plain text: ");
                sb.append(e.getMessage());
                throw new JOSEException(sb.toString(), e);
            }
        } else {
            throw new JOSEException("Unsupported compression algorithm: ".concat(String.valueOf(setpicturelistener)));
        }
    }
}
