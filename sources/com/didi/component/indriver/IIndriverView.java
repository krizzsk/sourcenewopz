package com.didi.component.indriver;

import com.didi.component.business.model.XpTrackItem;
import com.didi.component.core.IView;
import com.didi.component.indriver.model.DriverData;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import java.util.List;

public interface IIndriverView extends IView<AbsIndriverPresenter> {
    void engineCommit(boolean z, boolean z2);

    void expandView(boolean z);

    void omegaTrack(XpTrackItem xpTrackItem);

    void removeItem(DriverData driverData);

    void resetView();

    void setCurrentPriceText(LEGORichInfo lEGORichInfo);

    void setIndriverList(List<DriverData> list, int i);

    void setTipsText(String str);

    void setTitleText(String str);
}
