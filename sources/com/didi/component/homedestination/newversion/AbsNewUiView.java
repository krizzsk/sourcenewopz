package com.didi.component.homedestination.newversion;

import com.didi.component.homedestination.abs.AbsHomeDestinationView;
import com.didi.component.homedestination.newversion.AbsNewUiPresenter;
import com.didi.component.homedestination.newversion.HomeDestinationNewRecAdapter;

public interface AbsNewUiView<T extends AbsNewUiPresenter> extends AbsHomeDestinationView<T> {
    void setGuessItemClickListener(HomeDestinationNewRecAdapter.OnItemClickListener onItemClickListener);
}
