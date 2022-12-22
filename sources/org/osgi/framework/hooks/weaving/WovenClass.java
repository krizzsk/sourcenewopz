package org.osgi.framework.hooks.weaving;

import java.security.ProtectionDomain;
import java.util.List;
import org.osgi.framework.wiring.BundleWiring;

public interface WovenClass {
    public static final int DEFINED = 4;
    public static final int DEFINE_FAILED = 16;
    public static final int TRANSFORMED = 2;
    public static final int TRANSFORMING = 1;
    public static final int TRANSFORMING_FAILED = 8;

    BundleWiring getBundleWiring();

    byte[] getBytes();

    String getClassName();

    Class<?> getDefinedClass();

    List<String> getDynamicImports();

    ProtectionDomain getProtectionDomain();

    int getState();

    boolean isWeavingComplete();

    void setBytes(byte[] bArr);
}
