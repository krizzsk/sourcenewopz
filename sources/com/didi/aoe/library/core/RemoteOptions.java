package com.didi.aoe.library.core;

import com.didi.aoe.library.api.AoeModelOption;
import com.didi.aoe.library.core.AoeClient;
import java.io.Serializable;
import java.util.List;

final class RemoteOptions implements Serializable {
    private AoeClient.Options clientOptions;
    private List<AoeModelOption> modelOptions;

    RemoteOptions() {
    }

    public AoeClient.Options getClientOptions() {
        return this.clientOptions;
    }

    public void setClientOptions(AoeClient.Options options) {
        this.clientOptions = options;
    }

    public List<AoeModelOption> getModelOptions() {
        return this.modelOptions;
    }

    public void setModelOptions(List<AoeModelOption> list) {
        this.modelOptions = list;
    }
}
