package com.didichuxing.swarm.runtime;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Map;

class BundleManifest implements Serializable {
    private static final String BUNDLE_ACTIVATOR = "bundle-activator";
    private static final String BUNDLE_DEPENDENCIES = "bundle-dependencies";
    private static final String BUNDLE_DESCRIPTION = "bundle-description";
    private static final String BUNDLE_NAME = "bundle-name";
    private static final String BUNDLE_SYMBOLIC_NAME = "bundle-symbolicName";
    private static final String BUNDLE_VENDOR = "bundle-vendor";
    private static final String BUNDLE_VERSION = "bundle-version";
    private static final long serialVersionUID = -6622443646845669161L;
    @SerializedName("bundle-activator")
    private String mActivator;
    @SerializedName("bundle-dependencies")
    private Map<String, String> mDependencies;
    @SerializedName("bundle-description")
    private String mDescription;
    @SerializedName("bundle-name")
    private String mName;
    @SerializedName("bundle-symbolicName")
    private String mSymbolicName;
    @SerializedName("bundle-vendor")
    private String mVendor;
    @SerializedName("bundle-version")
    private String mVersion;

    BundleManifest() {
    }

    public String getName() {
        return this.mName;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getSymbolicName() {
        return this.mSymbolicName;
    }

    public String getActivator() {
        return this.mActivator;
    }

    public String getVersion() {
        return this.mVersion;
    }

    public String getVendor() {
        return this.mVendor;
    }

    public Map<String, String> getDependencies() {
        return this.mDependencies;
    }
}
