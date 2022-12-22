package com.didi.soda.pay;

import android.content.Intent;

public interface IPayMethodCallback {
    void startActivityForResult(Intent intent, int i);
}
