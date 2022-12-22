package com.didi.app.nova.skeleton;

import android.os.Bundle;
import com.didi.app.nova.skeleton.dialog.Dialog;

public interface INavigator {
    void finish();

    void finish(Bundle bundle);

    void popToRoot();

    void push(Page page);

    void pushForResult(Page page);

    void showDialog(Dialog dialog, String str);
}
