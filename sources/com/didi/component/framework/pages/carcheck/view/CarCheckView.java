package com.didi.component.framework.pages.carcheck.view;

import android.os.Bundle;
import com.didi.component.core.IView;
import com.didi.component.framework.pages.carcheck.presenter.CarCheckPresenter;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0004H&J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\b\u0010\f\u001a\u00020\u0004H&¨\u0006\r"}, mo175978d2 = {"Lcom/didi/component/framework/pages/carcheck/view/CarCheckView;", "Lcom/didi/component/core/IView;", "Lcom/didi/component/framework/pages/carcheck/presenter/CarCheckPresenter;", "hideLoadingView", "", "initCarDetails", "card", "", "carType", "jumpToResultPage", "bundle", "Landroid/os/Bundle;", "showLoadingView", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CarCheckView.kt */
public interface CarCheckView extends IView<CarCheckPresenter> {
    void hideLoadingView();

    void initCarDetails(String str, String str2);

    void jumpToResultPage(Bundle bundle);

    void showLoadingView();
}
