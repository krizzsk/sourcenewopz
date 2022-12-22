package com.didi.onekeyshare.model;

import com.didi.onekeyshare.entity.OneKeyShareInfo;
import java.util.List;

public class ShareModel implements IShareModel {

    /* renamed from: a */
    private List<OneKeyShareInfo> f29771a;

    public void setShareInfo(List<OneKeyShareInfo> list) {
        this.f29771a = list;
    }

    public List<OneKeyShareInfo> getShareInfo() {
        return this.f29771a;
    }
}
