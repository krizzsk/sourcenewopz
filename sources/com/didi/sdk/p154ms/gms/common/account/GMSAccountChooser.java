package com.didi.sdk.p154ms.gms.common.account;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import com.didi.sdk.p154ms.common.account.IAccountChooser;
import com.didi.sdk.p154ms.gms.common.GMSType;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.google.android.gms.common.AccountPicker;
import java.util.ArrayList;

@ServiceProvider(alias = "GMS", value = {IAccountChooser.class})
/* renamed from: com.didi.sdk.ms.gms.common.account.GMSAccountChooser */
public class GMSAccountChooser extends GMSType implements IAccountChooser {
    public Intent newChooseAccountIntent() {
        return AccountPicker.newChooseAccountIntent((Account) null, (ArrayList<Account>) null, new String[]{"com.google"}, false, (String) null, (String) null, (String[]) null, (Bundle) null);
    }
}
