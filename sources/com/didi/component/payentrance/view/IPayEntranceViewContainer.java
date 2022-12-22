package com.didi.component.payentrance.view;

public interface IPayEntranceViewContainer extends IPayEntranceView {
    void hide();

    void setMode(Mode mode);

    void setNewCard(boolean z);
}
