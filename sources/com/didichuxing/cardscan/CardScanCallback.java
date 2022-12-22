package com.didichuxing.cardscan;

public interface CardScanCallback {
    void onBottomBackBtnClick();

    void onKeyBackBtnClick();

    void onLeftTopBackBtnClick();

    void onScanResult(CardScanResult cardScanResult);
}
