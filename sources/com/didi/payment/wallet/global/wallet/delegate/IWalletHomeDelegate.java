package com.didi.payment.wallet.global.wallet.delegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public interface IWalletHomeDelegate {
    void onActivityResult(int i, int i2, Intent intent);

    View onCreateView(Bundle bundle);

    void onDestroy();

    void onResume();

    void onStart();

    void onStop();

    void requestData();
}
