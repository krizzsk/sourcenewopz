package com.didi.safetoolkit.business.share.store;

import com.didi.safetoolkit.model.SfContactsModel;
import java.util.List;

public interface SfCallback {
    void onFailed(String str);

    void onSucceed(List<SfContactsModel> list);
}
