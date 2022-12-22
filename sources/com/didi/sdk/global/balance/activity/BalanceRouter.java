package com.didi.sdk.global.balance.activity;

import android.app.Activity;

@Deprecated
public class BalanceRouter {
    public static void launchBalanceDetailActivity(Activity activity, int i) {
        GlobalBalanceDetailActivity.launch(activity, i);
    }
}
