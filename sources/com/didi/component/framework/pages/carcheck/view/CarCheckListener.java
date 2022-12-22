package com.didi.component.framework.pages.carcheck.view;

import android.os.Bundle;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\u001a\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&¨\u0006\r"}, mo175978d2 = {"Lcom/didi/component/framework/pages/carcheck/view/CarCheckListener;", "", "hideLoadingView", "", "showErrorDialog", "msg", "", "showErrorView", "showLoadingView", "switchToTargetPage", "tag", "bundle", "Landroid/os/Bundle;", "framework_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CarCheckListener.kt */
public interface CarCheckListener {
    void hideLoadingView();

    void showErrorDialog(String str);

    void showErrorView();

    void showLoadingView();

    void switchToTargetPage(String str, Bundle bundle);
}
