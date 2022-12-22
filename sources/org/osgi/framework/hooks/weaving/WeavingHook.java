package org.osgi.framework.hooks.weaving;

public interface WeavingHook {
    void weave(WovenClass wovenClass);
}
