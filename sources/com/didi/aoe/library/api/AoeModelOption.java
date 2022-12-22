package com.didi.aoe.library.api;

import java.io.Serializable;

public interface AoeModelOption extends Serializable {
    String getModelDir();

    String getModelName();

    String getModelSource();

    String getVersion();

    boolean isValid();
}
