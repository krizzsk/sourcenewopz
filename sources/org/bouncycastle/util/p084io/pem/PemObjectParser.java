package org.bouncycastle.util.p084io.pem;

import java.io.IOException;

/* renamed from: org.bouncycastle.util.io.pem.PemObjectParser */
public interface PemObjectParser {
    Object parseObject(PemObject pemObject) throws IOException;
}
