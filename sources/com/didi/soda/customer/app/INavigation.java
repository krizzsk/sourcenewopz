package com.didi.soda.customer.app;

import androidx.fragment.app.DialogFragment;

public interface INavigation {
    void dismissDialog(DialogFragment dialogFragment);

    void showDialog(DialogFragment dialogFragment);
}
