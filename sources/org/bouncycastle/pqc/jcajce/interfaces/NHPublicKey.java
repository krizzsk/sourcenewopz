package org.bouncycastle.pqc.jcajce.interfaces;

import java.security.PublicKey;

public interface NHPublicKey extends PublicKey, NHKey {
    byte[] getPublicData();
}
