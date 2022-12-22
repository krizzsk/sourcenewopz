package net.lingala.zip4j.model;

import net.lingala.zip4j.headers.HeaderSignature;
import net.lingala.zip4j.model.enums.AesKeyStrength;
import net.lingala.zip4j.model.enums.AesVersion;
import net.lingala.zip4j.model.enums.CompressionMethod;

public class AESExtraDataRecord extends ZipHeader {

    /* renamed from: a */
    private int f4908a = 7;

    /* renamed from: b */
    private AesVersion f4909b = AesVersion.TWO;

    /* renamed from: c */
    private String f4910c = "AE";

    /* renamed from: d */
    private AesKeyStrength f4911d = AesKeyStrength.KEY_STRENGTH_256;

    /* renamed from: e */
    private CompressionMethod f4912e = CompressionMethod.DEFLATE;

    public AESExtraDataRecord() {
        setSignature(HeaderSignature.AES_EXTRA_DATA_RECORD);
    }

    public int getDataSize() {
        return this.f4908a;
    }

    public void setDataSize(int i) {
        this.f4908a = i;
    }

    public AesVersion getAesVersion() {
        return this.f4909b;
    }

    public void setAesVersion(AesVersion aesVersion) {
        this.f4909b = aesVersion;
    }

    public String getVendorID() {
        return this.f4910c;
    }

    public void setVendorID(String str) {
        this.f4910c = str;
    }

    public AesKeyStrength getAesKeyStrength() {
        return this.f4911d;
    }

    public void setAesKeyStrength(AesKeyStrength aesKeyStrength) {
        this.f4911d = aesKeyStrength;
    }

    public CompressionMethod getCompressionMethod() {
        return this.f4912e;
    }

    public void setCompressionMethod(CompressionMethod compressionMethod) {
        this.f4912e = compressionMethod;
    }
}
