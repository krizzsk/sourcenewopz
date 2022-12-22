package com.didi.payment.creditcard.global.presenter;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.event.WalletRefreshDataEvent;
import com.didi.payment.base.proxy.LoadingProxyHolder;
import com.didi.payment.base.utils.WalletApolloUtil;
import com.didi.payment.base.utils.WalletCommonParamsUtil;
import com.didi.payment.base.view.PayBaseToast;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.creditcard.global.activity.GlobalCreditCardVerificationActivity;
import com.didi.payment.creditcard.global.model.CreditCardModel;
import com.didi.payment.creditcard.global.model.GlobalCardVerifyInfo;
import com.didi.payment.creditcard.global.model.bean.SignCancelResult;
import com.didi.payment.creditcard.global.model.bean.WithdrawPageInfo;
import com.didi.payment.creditcard.global.model.bean.WithdrawPollResult;
import com.didi.payment.creditcard.global.model.bean.WithdrawResult;
import com.didi.payment.creditcard.global.utils.GlobalDialogUtil;
import com.didi.payment.creditcard.open.DidiGlobalVerifyCardData;
import com.didi.sdk.util.TextUtil;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.security.cardverify.DiCardVerify;
import com.didichuxing.security.cardverify.DiCardVerifyCallback;
import com.didichuxing.security.cardverify.DiCardVerifyParam;
import com.taxis99.R;
import java.io.IOException;
import org.greenrobot.eventbus.EventBus;

public class GlobalVerificationPrePresenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public FragmentActivity f30421a;

    /* renamed from: b */
    private Fragment f30422b;

    /* renamed from: c */
    private int f30423c;

    /* renamed from: d */
    private CreditCardModel f30424d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public CountDownTimer f30425e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f30426f;

    /* renamed from: g */
    private String f30427g;

    /* renamed from: h */
    private String f30428h;

    public void startVerification(FragmentActivity fragmentActivity, int i, DidiGlobalVerifyCardData.VerifyCardParam verifyCardParam) {
        if (fragmentActivity != null && verifyCardParam != null) {
            this.f30421a = fragmentActivity;
            this.f30423c = i;
            this.f30426f = verifyCardParam.cardIndex;
            this.f30427g = verifyCardParam.cardNo;
            this.f30428h = verifyCardParam.productId;
            this.f30424d = new CreditCardModel(this.f30421a);
            if (!TextUtils.isEmpty(this.f30427g)) {
                this.f30427g = this.f30427g.replaceAll("[^0-9]", "");
            }
            if (WalletApolloUtil.isNewRandomVerification()) {
                m21384a(fragmentActivity);
            } else {
                m21381a();
            }
        }
    }

    /* renamed from: a */
    private void m21384a(final FragmentActivity fragmentActivity) {
        DiCardVerify.randomPayVerify(fragmentActivity, new DiCardVerifyParam.Builder(fragmentActivity).cardIndex(this.f30426f).cardNo(this.f30427g).productId(this.f30428h).country(WalletCommonParamsUtil.getCountry(fragmentActivity)).uid(WalletCommonParamsUtil.getUID(fragmentActivity)).terminalId(WalletCommonParamsUtil.getTerminalId(fragmentActivity)).language(WalletCommonParamsUtil.getLang(fragmentActivity)).latitude(WalletCommonParamsUtil.getLat(fragmentActivity)).longitude(WalletCommonParamsUtil.getLng(fragmentActivity)).mo120734ip(WalletCommonParamsUtil.getIP(fragmentActivity)).token(WalletCommonParamsUtil.getToken(fragmentActivity)).phone(WalletCommonParamsUtil.getPhone(fragmentActivity)).build(), new DiCardVerifyCallback() {
            public void onCallback(int i, String str) {
                if (i == 3) {
                    GlobalVerificationPrePresenter globalVerificationPrePresenter = GlobalVerificationPrePresenter.this;
                    globalVerificationPrePresenter.removeCard(globalVerificationPrePresenter.f30426f);
                } else if (i == 4) {
                    GlobalVerificationPrePresenter.this.m21382a((Activity) fragmentActivity, "");
                } else if (i == 0) {
                    EventBus.getDefault().post(new WalletRefreshDataEvent());
                }
            }
        });
    }

    public void removeCard(String str) {
        this.f30424d.cancelSign(150, str, new RpcService.Callback<SignCancelResult>() {
            public void onSuccess(SignCancelResult signCancelResult) {
                if (signCancelResult != null) {
                    String str = TextUtils.isEmpty(signCancelResult.hingMsg) ? signCancelResult.errMsg : signCancelResult.hingMsg;
                    if (signCancelResult.errNo == 0) {
                        DiCardVerify.notifyCardRemoved();
                        EventBus.getDefault().post(new WalletRefreshDataEvent());
                        return;
                    }
                    if (TextUtils.isEmpty(str)) {
                        str = GlobalVerificationPrePresenter.this.f30421a.getString(R.string.one_payment_creditcard_global_net_connerror);
                    }
                    DiCardVerify.notifyRemoveCardFail(str);
                }
            }

            public void onFailure(IOException iOException) {
                DiCardVerify.notifyRemoveCardFail(GlobalVerificationPrePresenter.this.f30421a.getString(R.string.one_payment_creditcard_global_net_connerror));
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21382a(Activity activity, String str) {
        if (TextUtils.isEmpty(str)) {
            String country = WalletCommonParamsUtil.getCountry(activity);
            str = (TextUtils.isEmpty(country) || !country.toUpperCase().contains("BR")) ? "https://help.didiglobal.com/passenger-index.html?source=app_globalck_home" : "https://help.99taxis.mobi/static/index.html?source=app_brck_home";
        }
        WebBrowserUtil.startInternalWebActivity(activity, str, "");
    }

    public void startVerification(Fragment fragment, int i, DidiGlobalVerifyCardData.VerifyCardParam verifyCardParam) {
        if (fragment != null && verifyCardParam != null) {
            this.f30422b = fragment;
            startVerification(fragment.getActivity(), i, verifyCardParam);
        }
    }

    /* renamed from: a */
    private void m21381a() {
        m21397c();
        this.f30424d.requestWithdrawInfo(this.f30426f, new RpcService.Callback<WithdrawPageInfo>() {
            public void onSuccess(WithdrawPageInfo withdrawPageInfo) {
                GlobalVerificationPrePresenter.this.m21399d();
                if (withdrawPageInfo == null || withdrawPageInfo.content == null) {
                    GlobalVerificationPrePresenter globalVerificationPrePresenter = GlobalVerificationPrePresenter.this;
                    globalVerificationPrePresenter.m21383a((Context) globalVerificationPrePresenter.f30421a, GlobalVerificationPrePresenter.this.f30421a.getString(R.string.one_payment_creditcard_global_net_connerror));
                    return;
                }
                int i = withdrawPageInfo.content.code;
                String str = withdrawPageInfo.content.frontMsg;
                if (i == 100003) {
                    GlobalVerificationPrePresenter.this.m21394a(str, (withdrawPageInfo.content.extendResultList == null || withdrawPageInfo.content.extendResultList.size() <= 0) ? null : withdrawPageInfo.content.extendResultList.get(0));
                } else if (i == 100001) {
                    GlobalVerificationPrePresenter globalVerificationPrePresenter2 = GlobalVerificationPrePresenter.this;
                    globalVerificationPrePresenter2.m21383a((Context) globalVerificationPrePresenter2.f30421a, str);
                } else if (i == 100002) {
                    GlobalVerificationPrePresenter.this.m21391a(str);
                } else {
                    GlobalVerificationPrePresenter globalVerificationPrePresenter3 = GlobalVerificationPrePresenter.this;
                    globalVerificationPrePresenter3.m21383a((Context) globalVerificationPrePresenter3.f30421a, GlobalVerificationPrePresenter.this.f30421a.getString(R.string.one_payment_creditcard_global_net_connerror));
                }
            }

            public void onFailure(IOException iOException) {
                GlobalVerificationPrePresenter.this.m21399d();
                GlobalVerificationPrePresenter globalVerificationPrePresenter = GlobalVerificationPrePresenter.this;
                globalVerificationPrePresenter.m21383a((Context) globalVerificationPrePresenter.f30421a, GlobalVerificationPrePresenter.this.f30421a.getString(R.string.one_payment_creditcard_global_net_connerror));
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21391a(String str) {
        GlobalDialogUtil.showVerifyConfirmDialog(this.f30421a, m21380a(str, this.f30427g), new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GlobalVerificationPrePresenter.this.m21396b();
            }
        }, (View.OnClickListener) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m21396b() {
        m21397c();
        this.f30424d.doWithdraw(this.f30426f, new RpcService.Callback<WithdrawResult>() {
            public void onSuccess(WithdrawResult withdrawResult) {
                int i;
                if (withdrawResult == null || withdrawResult.content == null || withdrawResult.content.extend == null) {
                    GlobalVerificationPrePresenter globalVerificationPrePresenter = GlobalVerificationPrePresenter.this;
                    globalVerificationPrePresenter.m21383a((Context) globalVerificationPrePresenter.f30421a, GlobalVerificationPrePresenter.this.f30421a.getString(R.string.one_payment_creditcard_global_net_connerror));
                    GlobalVerificationPrePresenter.this.m21399d();
                    return;
                }
                int i2 = withdrawResult.content.code;
                String str = withdrawResult.content.frontMsg;
                int i3 = 0;
                if (withdrawResult.content.extend.size() > 0) {
                    int i4 = withdrawResult.content.extend.get(0).maxPollingTimes;
                    i = withdrawResult.content.extend.get(0).pollingFrequency;
                    i3 = i4;
                } else {
                    i = 0;
                }
                if (i2 == 100002 || i2 == 100003) {
                    GlobalVerificationPrePresenter globalVerificationPrePresenter2 = GlobalVerificationPrePresenter.this;
                    globalVerificationPrePresenter2.m21393a(globalVerificationPrePresenter2.f30426f, i3, i);
                } else if (i2 == 100001) {
                    GlobalVerificationPrePresenter.this.m21399d();
                    GlobalVerificationPrePresenter globalVerificationPrePresenter3 = GlobalVerificationPrePresenter.this;
                    globalVerificationPrePresenter3.m21383a((Context) globalVerificationPrePresenter3.f30421a, str);
                } else {
                    GlobalVerificationPrePresenter.this.m21399d();
                    GlobalVerificationPrePresenter globalVerificationPrePresenter4 = GlobalVerificationPrePresenter.this;
                    globalVerificationPrePresenter4.m21383a((Context) globalVerificationPrePresenter4.f30421a, GlobalVerificationPrePresenter.this.f30421a.getString(R.string.one_payment_creditcard_global_net_connerror));
                }
            }

            public void onFailure(IOException iOException) {
                GlobalVerificationPrePresenter.this.m21399d();
                GlobalVerificationPrePresenter globalVerificationPrePresenter = GlobalVerificationPrePresenter.this;
                globalVerificationPrePresenter.m21383a((Context) globalVerificationPrePresenter.f30421a, GlobalVerificationPrePresenter.this.f30421a.getString(R.string.one_payment_creditcard_global_net_connerror));
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21393a(String str, int i, int i2) {
        if (i > 0 && i2 > 0) {
            CountDownTimer countDownTimer = this.f30425e;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            final int i3 = i2 * 1000;
            final int i4 = i;
            final String str2 = str;
            this.f30425e = new CountDownTimer((long) (i * i3), (long) i3) {
                public void onTick(long j) {
                    GlobalVerificationPrePresenter.this.m21392a(str2, i4 - ((int) (j / ((long) i3))));
                }

                public void onFinish() {
                    GlobalVerificationPrePresenter.this.m21399d();
                    GlobalVerificationPrePresenter.this.m21392a(str2, i4);
                }
            }.start();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21392a(String str, int i) {
        this.f30424d.pollingQueryWithdrawStatus(str, new RpcService.Callback<WithdrawPollResult>() {
            public void onFailure(IOException iOException) {
            }

            public void onSuccess(WithdrawPollResult withdrawPollResult) {
                if (withdrawPollResult != null && withdrawPollResult.content != null) {
                    int i = withdrawPollResult.content.code;
                    String str = withdrawPollResult.content.frontMsg;
                    if (i == 100001) {
                        GlobalVerificationPrePresenter.this.m21399d();
                        GlobalVerificationPrePresenter.this.m21394a(str, (withdrawPollResult.content.extendResultList == null || withdrawPollResult.content.extendResultList.size() <= 0) ? null : withdrawPollResult.content.extendResultList.get(0));
                        if (GlobalVerificationPrePresenter.this.f30425e != null) {
                            GlobalVerificationPrePresenter.this.f30425e.cancel();
                        }
                    } else if (i == 100003) {
                        GlobalVerificationPrePresenter.this.m21399d();
                        GlobalVerificationPrePresenter globalVerificationPrePresenter = GlobalVerificationPrePresenter.this;
                        globalVerificationPrePresenter.m21383a((Context) globalVerificationPrePresenter.f30421a, str);
                        if (GlobalVerificationPrePresenter.this.f30425e != null) {
                            GlobalVerificationPrePresenter.this.f30425e.cancel();
                        }
                    }
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21394a(String str, WithdrawPageInfo.ExtendContent extendContent) {
        String a = m21380a(str, this.f30427g);
        GlobalCardVerifyInfo globalCardVerifyInfo = new GlobalCardVerifyInfo();
        globalCardVerifyInfo.cardIndex = this.f30426f;
        globalCardVerifyInfo.pageContent = a;
        globalCardVerifyInfo.productId = this.f30428h;
        if (extendContent != null) {
            globalCardVerifyInfo.currencyText = extendContent.currency;
            boolean z = false;
            globalCardVerifyInfo.isShowDecimal = extendContent.isDecimal == 1;
            if (extendContent.isSuffix == 1) {
                z = true;
            }
            globalCardVerifyInfo.isCurrencySuffix = z;
            globalCardVerifyInfo.defaultText = extendContent.defaultText;
        }
        Fragment fragment = this.f30422b;
        if (fragment != null) {
            GlobalCreditCardVerificationActivity.startActivityForResult(fragment, this.f30423c, globalCardVerifyInfo);
        } else {
            GlobalCreditCardVerificationActivity.startActivityForResult((Activity) this.f30421a, this.f30423c, globalCardVerifyInfo);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21383a(Context context, String str) {
        PayBaseToast.showInfo(context, str);
    }

    /* renamed from: c */
    private void m21397c() {
        if (LoadingProxyHolder.getProxy() != null) {
            LoadingProxyHolder.getProxy().showLoading();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m21399d() {
        if (LoadingProxyHolder.getProxy() != null) {
            LoadingProxyHolder.getProxy().dismissLoading();
        }
    }

    /* renamed from: a */
    private String m21380a(String str, String str2) {
        return (TextUtil.isEmpty(str) || TextUtil.isEmpty(str2)) ? str : str.replaceAll("[*][*][*][*]", str2);
    }
}
