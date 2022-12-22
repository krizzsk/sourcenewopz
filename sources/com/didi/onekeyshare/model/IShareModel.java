package com.didi.onekeyshare.model;

import com.didi.onekeyshare.entity.OneKeyShareInfo;
import java.util.List;

public interface IShareModel extends IModel {
    List<OneKeyShareInfo> getShareInfo();

    void setShareInfo(List<OneKeyShareInfo> list);
}
