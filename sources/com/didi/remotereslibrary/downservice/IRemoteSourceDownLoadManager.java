package com.didi.remotereslibrary.downservice;

import com.didi.remotereslibrary.ResourceItemModel;

public interface IRemoteSourceDownLoadManager {
    long downFile(ResourceItemModel resourceItemModel);
}
