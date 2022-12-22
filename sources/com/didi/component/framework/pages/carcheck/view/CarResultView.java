package com.didi.component.framework.pages.carcheck.view;

import com.didi.component.core.IView;
import com.didi.component.framework.pages.carcheck.presenter.CarResultPresenter;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u0004H&J\b\u0010\u000b\u001a\u00020\u0004H&¨\u0006\f"}, mo175978d2 = {"Lcom/didi/component/framework/pages/carcheck/view/CarResultView;", "Lcom/didi/component/core/IView;", "Lcom/didi/component/framework/pages/carcheck/presenter/CarResultPresenter;", "hideLoadingView", "", "initContentView", "reply", "", "showErrorDialog", "msg", "showErrorView", "showLoadingView", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CarResultView.kt */
public interface CarResultView extends IView<CarResultPresenter> {
    void hideLoadingView();

    void initContentView(String str);

    void showErrorDialog(String str);

    void showErrorView();

    void showLoadingView();
}
