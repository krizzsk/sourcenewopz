package com.didi.aoe.library.modeloption.loader.pojos;

import android.text.TextUtils;
import com.didi.aoe.library.api.AoeModelOption;

public class LocalModelOption implements AoeModelOption {
    private String modelDir;
    private String modelName;
    private String version;

    public String getModelSource() {
        return "local";
    }

    public String getVersion() {
        return this.version;
    }

    public String getModelDir() {
        return this.modelDir;
    }

    public String getModelName() {
        return this.modelName;
    }

    public boolean isValid() {
        return !TextUtils.isEmpty(this.modelDir) && !TextUtils.isEmpty(this.modelName);
    }

    public String toString() {
        return "LocalModelOption{version='" + this.version + '\'' + ", modelDir='" + this.modelDir + '\'' + ", modelName='" + this.modelName + '\'' + '}';
    }
}
