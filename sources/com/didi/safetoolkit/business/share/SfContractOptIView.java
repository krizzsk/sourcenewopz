package com.didi.safetoolkit.business.share;

import com.android.didi.safetoolkit.presenter.IBaseView;

public interface SfContractOptIView extends IBaseView {
    void hideGuide();

    void hideLoadingState();

    void showGuide();

    void showLoadingState();
}
