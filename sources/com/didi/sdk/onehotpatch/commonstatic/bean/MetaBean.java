package com.didi.sdk.onehotpatch.commonstatic.bean;

import java.io.Serializable;

public class MetaBean implements Serializable {
    private static final long serialVersionUID = 7383871726611778860L;
    public String ext;
    public int max_sdk = Integer.MAX_VALUE;
    public int min_sdk = -1;
    public String random = "";
    public String target_version = "";
    public String version = "";
}
