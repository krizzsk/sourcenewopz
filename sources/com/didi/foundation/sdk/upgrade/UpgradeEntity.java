package com.didi.foundation.sdk.upgrade;

import java.io.Serializable;

public class UpgradeEntity implements Serializable {
    public String mApkMD5;
    public long mApkSize;
    public String mApkUrl;
    public String mErrMsg;
    public int mErrNum;
    public String mIgnoreBtn;
    public boolean mIsForce;
    public boolean mNeedUpdate;
    public String mPatchMd5;
    public long mPatchSize;
    public String mPatchUrl;
    public int mTaskId;
    public String mUpdateBtn;
    public String mUpdateDesc;
    public String mUpdateTitle;
    public int mUpdateType;
    public String mVersion;
    public int mVersionCode;
    public int mVersionId;
}
