package org.bouncycastle.jcajce.interfaces;

import java.security.PrivateKey;

public interface XDHPrivateKey extends PrivateKey, XDHKey {
    XDHPublicKey getPublicKey();
}
