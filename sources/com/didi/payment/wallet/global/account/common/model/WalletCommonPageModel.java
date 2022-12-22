package com.didi.payment.wallet.global.account.common.model;

import com.didi.payment.base.service.IWalletService;
import java.io.Serializable;
import java.util.List;

public class WalletCommonPageModel implements Serializable {
    public static final int PAGE_TARGET_SIGN_UP_FAILED = 4;
    public static final int PAGE_TARGET_SIGN_UP_INTRO = 1;
    public static final int PAGE_TARGET_SIGN_UP_SUCCESS = 3;
    public static final int PAGE_TARGET_SIGN_UP_WAITING = 2;
    public IWalletService.AccountInfo accountStatus;
    public String buttonText;
    public int fromPage;
    public int targetPage;
    public int topImageId;
    public List<IWalletService.WalletFunction> walletFunctions;
}
