package com.didi.unifylogin.presenter;

import android.content.Context;
import com.didi.unifylogin.base.presenter.LoginBasePresenter;
import com.didi.unifylogin.presenter.ability.IDeleteAccountFailedPresenter;
import com.didi.unifylogin.view.ability.IDeleteAccountFailedView;

public class DeleteAccountFailedPresenter extends LoginBasePresenter<IDeleteAccountFailedView> implements IDeleteAccountFailedPresenter {
    public DeleteAccountFailedPresenter(IDeleteAccountFailedView iDeleteAccountFailedView, Context context) {
        super(iDeleteAccountFailedView, context);
    }

    public void updateView() {
        super.updateView();
        String deleteAccountFailedSubPromptTitle = this.messenger.getDeleteAccountFailedSubPromptTitle();
        String str = "";
        if (deleteAccountFailedSubPromptTitle == null) {
            deleteAccountFailedSubPromptTitle = str;
        }
        String deleteAccountFailedSubTitle = this.messenger.getDeleteAccountFailedSubTitle();
        if (deleteAccountFailedSubTitle != null) {
            str = deleteAccountFailedSubTitle;
        }
        ((IDeleteAccountFailedView) this.view).updateSubTitleText(str);
        ((IDeleteAccountFailedView) this.view).updatePrompTitleText(deleteAccountFailedSubPromptTitle);
        ((IDeleteAccountFailedView) this.view).updateDeleteAccountFailTexts(this.messenger.getDeleteAccountFailTexts());
    }

    public void pressNext() {
        ((IDeleteAccountFailedView) this.view).onFlowFinish(0);
    }
}
