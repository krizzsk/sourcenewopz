package com.didichuxing.xpanel.base;

public interface IState {

    public interface IStateChange {
        void stateChange(IState iState);
    }

    int getState();

    void stateBindChange(IStateChange iStateChange);

    void stateDestory();
}
