package com.didi.component.service.activity.risk;

import com.didi.component.common.dialog.IDialog;
import com.didi.component.service.activity.risk.dialog.NormalDialogInfo;

public interface IDialogDisplayer {
    void dismissLoading(IDialog iDialog);

    IDialog showDialog(NormalDialogInfo normalDialogInfo, IDialog.DialogListener dialogListener);

    IDialog showLoading(String str);
}
