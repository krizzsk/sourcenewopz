package com.didi.onekeyshare.view;

import com.didi.onekeyshare.entity.OneKeyShareInfo;
import java.util.List;

public interface IShareView extends IView {
    void updateShareView(List<OneKeyShareInfo> list);
}
