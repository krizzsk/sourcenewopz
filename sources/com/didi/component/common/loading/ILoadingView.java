package com.didi.component.common.loading;

import com.didi.component.core.IPresenter;
import com.didi.component.core.IView;
import com.didi.global.loading.ILoadingable;

public interface ILoadingView<P extends IPresenter> extends IView<P>, ILoadingable {
}
