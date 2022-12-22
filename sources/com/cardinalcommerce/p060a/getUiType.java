package com.cardinalcommerce.p060a;

import com.cardinalcommerce.dependencies.internal.bouncycastle.asn1.ASN1ObjectIdentifier;
import com.cardinalcommerce.p060a.C1943EC;
import com.cardinalcommerce.p060a.C1944GM;
import com.cardinalcommerce.p060a.DSA;
import com.cardinalcommerce.p060a.DSASigner;
import com.cardinalcommerce.p060a.ECGOST;
import com.cardinalcommerce.p060a.IES;
import com.cardinalcommerce.p060a.IESCipher;
import com.cardinalcommerce.p060a.KeyAgreementSpi;
import com.cardinalcommerce.p060a.RSA;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.cardinalcommerce.a.getUiType */
public final class getUiType extends FilterInputStream {

    /* renamed from: a */
    final int f2586a;

    /* renamed from: b */
    private final boolean f2587b;

    /* renamed from: c */
    private final byte[][] f2588c;

    public getUiType(InputStream inputStream) {
        this(inputStream, KeyAgreementSpi.Cardinal(inputStream));
    }

    public getUiType(InputStream inputStream, byte b) {
        this(inputStream, KeyAgreementSpi.Cardinal(inputStream), true);
    }

    private getUiType(InputStream inputStream, int i) {
        this(inputStream, i, false);
    }

    private getUiType(InputStream inputStream, int i, boolean z) {
        super(inputStream);
        this.f2586a = i;
        this.f2587b = z;
        this.f2588c = new byte[11][];
    }

    public getUiType(byte[] bArr) {
        this((InputStream) new ByteArrayInputStream(bArr), bArr.length);
    }

    public getUiType(byte[] bArr, byte b) {
        this(new ByteArrayInputStream(bArr), bArr.length, true);
    }

    /* renamed from: a */
    private int m1906a() throws IOException {
        return getInstance(this, this.f2586a);
    }

    public static int getInstance(InputStream inputStream, int i) throws IOException {
        int read = inputStream.read();
        if (read < 0) {
            throw new EOFException("EOF found when length expected");
        } else if (read == 128) {
            return -1;
        } else {
            if (read <= 127) {
                return read;
            }
            int i2 = read & 127;
            if (i2 <= 4) {
                int i3 = 0;
                int i4 = 0;
                while (i4 < i2) {
                    int read2 = inputStream.read();
                    if (read2 >= 0) {
                        i3 = (i3 << 8) + read2;
                        i4++;
                    } else {
                        throw new EOFException("EOF found reading length");
                    }
                }
                if (i3 < 0) {
                    throw new IOException("corrupted stream - negative length found");
                } else if (i3 < i) {
                    return i3;
                } else {
                    throw new IOException("corrupted stream - out of bounds length found");
                }
            } else {
                throw new IOException("DER length more than 4 bytes: ".concat(String.valueOf(i2)));
            }
        }
    }

    public static int init(InputStream inputStream, int i) throws IOException {
        int i2 = i & 31;
        if (i2 != 31) {
            return i2;
        }
        int i3 = 0;
        int read = inputStream.read();
        if ((read & 127) != 0) {
            while (read >= 0 && (read & 128) != 0) {
                i3 = (i3 | (read & 127)) << 7;
                read = inputStream.read();
            }
            if (read >= 0) {
                return i3 | (read & 127);
            }
            throw new EOFException("EOF found inside tag value.");
        }
        throw new IOException("corrupted stream - invalid high tag number found");
    }

    public final setLocationDataConsentGiven cca_continue() throws IOException {
        int read = read();
        if (read > 0) {
            int init = init(this, read);
            boolean z = (read & 32) != 0;
            int a = m1906a();
            if (a >= 0) {
                try {
                    return m1908a(read, init, a);
                } catch (IllegalArgumentException e) {
                    throw new getEnvironment("corrupted stream detected", e);
                }
            } else if (z) {
                DSASigner.dsaSha3_384 dsasha3_384 = new DSASigner.dsaSha3_384(new KeyAgreementSpi.DHUwithSHA224CKDF(this, this.f2586a), this.f2586a);
                if ((read & 64) != 0) {
                    return new getProcessorTransactionId(init, dsasha3_384).getInstance();
                }
                if ((read & 128) != 0) {
                    return new CardinalInitService(true, init, dsasha3_384).getInstance();
                }
                if (init == 4) {
                    return new getPayment(dsasha3_384).getInstance();
                }
                if (init == 8) {
                    return new C1895DH(dsasha3_384).getInstance();
                }
                if (init == 16) {
                    return new isValidated(dsasha3_384).getInstance();
                }
                if (init == 17) {
                    return new onSetupCompleted(dsasha3_384).getInstance();
                }
                throw new IOException("unknown BER object encountered");
            } else {
                throw new IOException("indefinite-length primitive encoding encountered");
            }
        } else if (read != 0) {
            return null;
        } else {
            throw new IOException("unexpected end-of-contents marker");
        }
    }

    /* renamed from: a */
    private setLocationDataConsentGiven m1908a(int i, int i2, int i3) throws IOException {
        boolean z = (i & 32) != 0;
        IESCipher iESCipher = new IESCipher(this, i3);
        if ((i & 64) != 0) {
            return new AlgorithmParameterGeneratorSpi(z, i2, iESCipher.configure());
        }
        if ((i & 128) != 0) {
            return new DSASigner.dsaSha3_384(iESCipher).init(z, i2);
        }
        if (!z) {
            return Cardinal(i2, iESCipher, this.f2588c);
        }
        if (i2 == 4) {
            getUiType getuitype = new getUiType((InputStream) iESCipher);
            setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
            while (true) {
                setLocationDataConsentGiven cca_continue = getuitype.cca_continue();
                if (cca_continue == null) {
                    break;
                }
                setforegroundtintblendmode.cca_continue.addElement(cca_continue);
            }
            int size = setforegroundtintblendmode.cca_continue.size();
            isEnableDFSync[] isenabledfsyncArr = new isEnableDFSync[size];
            for (int i4 = 0; i4 != size; i4++) {
                isenabledfsyncArr[i4] = (isEnableDFSync) ((getProxyAddress) setforegroundtintblendmode.cca_continue.elementAt(i4));
            }
            return new getErrorNumber(isenabledfsyncArr);
        } else if (i2 == 8) {
            return new BCDHPrivateKey(m1907a(iESCipher));
        } else {
            if (i2 != 16) {
                if (i2 == 17) {
                    getUiType getuitype2 = new getUiType((InputStream) iESCipher);
                    setForegroundTintBlendMode setforegroundtintblendmode2 = new setForegroundTintBlendMode();
                    while (true) {
                        setLocationDataConsentGiven cca_continue2 = getuitype2.cca_continue();
                        if (cca_continue2 == null) {
                            return C1943EC.m1801a(setforegroundtintblendmode2);
                        }
                        setforegroundtintblendmode2.cca_continue.addElement(cca_continue2);
                    }
                } else {
                    StringBuilder sb = new StringBuilder("unknown tag ");
                    sb.append(i2);
                    sb.append(" encountered");
                    throw new IOException(sb.toString());
                }
            } else if (this.f2587b) {
                return new IESCipher.IESwithDESedeCBC(iESCipher.configure());
            } else {
                getUiType getuitype3 = new getUiType((InputStream) iESCipher);
                setForegroundTintBlendMode setforegroundtintblendmode3 = new setForegroundTintBlendMode();
                while (true) {
                    setLocationDataConsentGiven cca_continue3 = getuitype3.cca_continue();
                    if (cca_continue3 == null) {
                        return C1943EC.getInstance(setforegroundtintblendmode3);
                    }
                    setforegroundtintblendmode3.cca_continue.addElement(cca_continue3);
                }
            }
        }
    }

    /* renamed from: a */
    private static setForegroundTintBlendMode m1907a(IESCipher iESCipher) throws IOException {
        getUiType getuitype = new getUiType((InputStream) iESCipher);
        setForegroundTintBlendMode setforegroundtintblendmode = new setForegroundTintBlendMode();
        while (true) {
            setLocationDataConsentGiven cca_continue = getuitype.cca_continue();
            if (cca_continue == null) {
                return setforegroundtintblendmode;
            }
            setforegroundtintblendmode.cca_continue.addElement(cca_continue);
        }
    }

    /* renamed from: a */
    private static byte[] m1909a(IESCipher iESCipher, byte[][] bArr) throws IOException {
        int i = iESCipher.f2442a;
        if (iESCipher.f2442a >= bArr.length) {
            return iESCipher.configure();
        }
        byte[] bArr2 = bArr[i];
        if (bArr2 == null) {
            bArr2 = new byte[i];
            bArr[i] = bArr2;
        }
        setTooltipText.init(iESCipher, bArr2);
        return bArr2;
    }

    /* renamed from: b */
    private static char[] m1910b(IESCipher iESCipher) throws IOException {
        int read;
        int i = iESCipher.f2442a / 2;
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            int read2 = iESCipher.read();
            if (read2 < 0 || (read = iESCipher.read()) < 0) {
                break;
            }
            cArr[i2] = (char) ((read2 << 8) | (read & 255));
        }
        return cArr;
    }

    public static setLocationDataConsentGiven Cardinal(int i, IESCipher iESCipher, byte[][] bArr) throws IOException {
        if (i == 10) {
            return getChallengeTimeout.m1889a(m1909a(iESCipher, bArr));
        }
        if (i == 12) {
            return new RSA.Mappings(iESCipher.configure());
        }
        if (i == 30) {
            return new SubjectPublicKeyInfo(m1910b(iESCipher));
        }
        switch (i) {
            case 1:
                return setChallengeTimeout.m1981a(m1909a(iESCipher, bArr));
            case 2:
                return new setProxyAddress(iESCipher.configure(), false);
            case 3:
                return getString.init(iESCipher.f2442a, iESCipher);
            case 4:
                return new EdEC(iESCipher.configure());
            case 5:
                return ECGOST.Mappings.Cardinal;
            case 6:
                return ASN1ObjectIdentifier.init(m1909a(iESCipher, bArr));
            default:
                switch (i) {
                    case 18:
                        return new ECGOST(iESCipher.configure());
                    case 19:
                        return new C1944GM.Mappings(iESCipher.configure());
                    case 20:
                        return new IES.Mappings(iESCipher.configure());
                    case 21:
                        return new X509(iESCipher.configure());
                    case 22:
                        return new DSA.Mappings(iESCipher.configure());
                    case 23:
                        return new Payment(iESCipher.configure());
                    case 24:
                        return new setRenderType(iESCipher.configure());
                    case 25:
                        return new C1943EC.Mappings(iESCipher.configure());
                    case 26:
                        return new readObject(iESCipher.configure());
                    case 27:
                        return new DSTU4145(iESCipher.configure());
                    case 28:
                        return new IES(iESCipher.configure());
                    default:
                        StringBuilder sb = new StringBuilder("unknown tag ");
                        sb.append(i);
                        sb.append(" encountered");
                        throw new IOException(sb.toString());
                }
        }
    }
}
