package com.didi.component.common.loading;

import com.didi.component.core.IGroupView;
import com.didi.component.core.PresenterGroup;
import com.didi.global.loading.ILoadingable;

public interface ILoadingGroupView<P extends PresenterGroup> extends IGroupView<P>, ILoadingable {
}
