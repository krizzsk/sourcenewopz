package com.didi.payment.wallet.global.wallet.presenter;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.didi.dcrypto.DCryptoMainFragment;
import com.didi.payment.base.utils.WalletToast;
import com.didi.payment.wallet.global.model.WalletBalanceModel;
import com.didi.payment.wallet.global.model.resp.WalletBalanceInterestResp;
import com.didi.payment.wallet.global.wallet.contract.WalletNewBalanceInterestContract;
import com.didi.sdk.fastframe.util.CollectionUtil;
import com.didi.sdk.util.ResourcesHelper;
import com.didichuxing.foundation.rpc.RpcService;
import com.taxis99.R;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class WalletNewBalanceInterestPresenter implements WalletNewBalanceInterestContract.Presenter {

    /* renamed from: a */
    private WalletNewBalanceInterestContract.View f32048a;

    /* renamed from: b */
    private WalletBalanceModel f32049b;

    /* renamed from: c */
    private FragmentActivity f32050c;

    /* renamed from: d */
    private WalletBalanceInterestResp.DataBean f32051d;

    /* renamed from: e */
    private String[] f32052e;

    /* renamed from: f */
    private String[] f32053f;

    /* renamed from: g */
    private String[] f32054g;

    /* renamed from: h */
    private Date f32055h;

    /* renamed from: i */
    private Calendar f32056i = Calendar.getInstance();

    /* renamed from: j */
    private SimpleDateFormat f32057j = new SimpleDateFormat("dd/MM/yyyy");

    /* renamed from: k */
    private SimpleDateFormat f32058k = new SimpleDateFormat("MM/yyyy");

    /* renamed from: l */
    private SimpleDateFormat f32059l = new SimpleDateFormat("dd/MM/yyyy");

    /* renamed from: m */
    private SimpleDateFormat f32060m = new SimpleDateFormat("MM/yyyy");

    /* renamed from: n */
    private SimpleDateFormat f32061n = new SimpleDateFormat("dd/MM");

    /* renamed from: o */
    private SimpleDateFormat f32062o = new SimpleDateFormat("dd/MM/yyyy");

    /* renamed from: p */
    private WalletBalanceInterestResp.InterestInfo f32063p;

    public void onDestroy() {
    }

    public WalletNewBalanceInterestPresenter(FragmentActivity fragmentActivity, WalletNewBalanceInterestContract.View view) {
        this.f32050c = fragmentActivity;
        this.f32048a = view;
        this.f32049b = new WalletBalanceModel(fragmentActivity);
        WalletBalanceInterestResp.InterestInfo interestInfo = new WalletBalanceInterestResp.InterestInfo();
        this.f32063p = interestInfo;
        interestInfo.date = "";
        this.f32063p.amount = 0.0d;
        this.f32063p.amountText = DCryptoMainFragment.DCRYPTO_ZERO;
    }

    public void init() {
        requestData();
    }

    public void requestData() {
        this.f32048a.showLoadingDialog();
        C111921 r0 = new RpcService.Callback<WalletBalanceInterestResp>() {
            public void onSuccess(WalletBalanceInterestResp walletBalanceInterestResp) {
                WalletNewBalanceInterestPresenter.this.m22728a(walletBalanceInterestResp);
            }

            public void onFailure(IOException iOException) {
                WalletNewBalanceInterestPresenter.this.m22728a((WalletBalanceInterestResp) null);
            }
        };
        int type = this.f32048a.getType();
        if (type == 0) {
            this.f32049b.getBalanceInterestInfo(r0);
        } else if (type == 1) {
            this.f32049b.getBalanceCashbackInfo(r0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22728a(WalletBalanceInterestResp walletBalanceInterestResp) {
        this.f32048a.dismissLoadingDialog();
        if (walletBalanceInterestResp == null || walletBalanceInterestResp.errno != 0 || walletBalanceInterestResp.data == null) {
            if (walletBalanceInterestResp != null && !TextUtils.isEmpty(walletBalanceInterestResp.errmsg)) {
                WalletToast.showFailedMsg(this.f32050c, walletBalanceInterestResp.errmsg);
            }
            this.f32048a.showErrorPage();
            return;
        }
        WalletBalanceInterestResp.DataBean dataBean = walletBalanceInterestResp.data;
        this.f32048a.showIntroduction(dataBean.metaInfo);
        if (dataBean.daySet == null || dataBean.monthSet == null || dataBean.totalSet == null || CollectionUtil.isEmpty((Object[]) dataBean.daySet.infoList) || CollectionUtil.isEmpty((Object[]) dataBean.monthSet.infoList) || CollectionUtil.isEmpty((Object[]) dataBean.totalSet.infoList)) {
            this.f32048a.showEmptyPage(dataBean.metaInfo);
            return;
        }
        this.f32051d = dataBean;
        try {
            this.f32055h = this.f32057j.parse(dataBean.metaInfo.currentDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (this.f32051d.metaInfo != null) {
            if (!CollectionUtil.isEmpty((Object[]) this.f32051d.metaInfo.interestTitles)) {
                this.f32063p.amountItems = new String[this.f32051d.metaInfo.interestTitles.length];
                Arrays.fill(this.f32063p.amountItems, this.f32051d.metaInfo.defaultAmount);
            }
            if (!TextUtils.isEmpty(this.f32051d.metaInfo.defaultAmountValue)) {
                this.f32063p.amountText = this.f32051d.metaInfo.defaultAmountValue;
            }
        }
        m22727a(walletBalanceInterestResp.data.daySet);
        m22730b(walletBalanceInterestResp.data.monthSet);
        m22731c(walletBalanceInterestResp.data.totalSet);
        m22726a();
        this.f32048a.updateMetaData(this.f32051d.metaInfo);
        this.f32048a.showChartInDay(this.f32051d.daySet.infoList, this.f32052e);
        this.f32048a.showInterestInfo(this.f32051d.daySet.infoList[this.f32051d.daySet.infoList.length - 1], this.f32059l.format(this.f32055h));
    }

    /* renamed from: a */
    private void m22727a(WalletBalanceInterestResp.InterestSetInfo interestSetInfo) {
        try {
            Date parse = this.f32057j.parse(interestSetInfo.startDate);
            int daysBetweenDate = getDaysBetweenDate(parse, this.f32055h) + 1;
            WalletBalanceInterestResp.InterestInfo[] interestInfoArr = new WalletBalanceInterestResp.InterestInfo[daysBetweenDate];
            int i = 0;
            for (WalletBalanceInterestResp.InterestInfo interestInfo : interestSetInfo.infoList) {
                if (interestInfo != null) {
                    int daysBetweenDate2 = getDaysBetweenDate(parse, this.f32057j.parse(interestInfo.date));
                    while (i < daysBetweenDate2) {
                        interestInfoArr[i] = this.f32063p;
                        i++;
                    }
                    interestInfoArr[i] = interestInfo;
                    i = daysBetweenDate2 + 1;
                }
            }
            while (i < daysBetweenDate) {
                interestInfoArr[i] = this.f32063p;
                i++;
            }
            interestSetInfo.infoList = interestInfoArr;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m22730b(WalletBalanceInterestResp.InterestSetInfo interestSetInfo) {
        try {
            Date parse = this.f32058k.parse(interestSetInfo.startDate);
            int monthsBetweenDate = getMonthsBetweenDate(parse, this.f32055h) + 1;
            WalletBalanceInterestResp.InterestInfo[] interestInfoArr = new WalletBalanceInterestResp.InterestInfo[monthsBetweenDate];
            int i = 0;
            for (WalletBalanceInterestResp.InterestInfo interestInfo : interestSetInfo.infoList) {
                if (interestInfo != null) {
                    Date parse2 = this.f32058k.parse(interestInfo.date);
                    this.f32056i.setTime(parse2);
                    int monthsBetweenDate2 = getMonthsBetweenDate(parse, parse2);
                    while (i < monthsBetweenDate2) {
                        interestInfoArr[i] = this.f32063p;
                        i++;
                    }
                    interestInfoArr[i] = interestInfo;
                    i = monthsBetweenDate2 + 1;
                }
            }
            while (i < monthsBetweenDate) {
                interestInfoArr[i] = this.f32063p;
                i++;
            }
            interestSetInfo.infoList = interestInfoArr;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: c */
    private void m22731c(WalletBalanceInterestResp.InterestSetInfo interestSetInfo) {
        try {
            Date parse = this.f32057j.parse(interestSetInfo.startDate);
            int daysBetweenDate = getDaysBetweenDate(parse, this.f32055h) + 1;
            WalletBalanceInterestResp.InterestInfo[] interestInfoArr = new WalletBalanceInterestResp.InterestInfo[daysBetweenDate];
            int i = 0;
            for (WalletBalanceInterestResp.InterestInfo interestInfo : interestSetInfo.infoList) {
                if (interestInfo != null) {
                    int daysBetweenDate2 = getDaysBetweenDate(parse, this.f32057j.parse(interestInfo.date));
                    while (i < daysBetweenDate2) {
                        if (i == 0) {
                            interestInfoArr[i] = interestInfo;
                        } else {
                            interestInfoArr[i] = interestInfoArr[i - 1];
                        }
                        i++;
                    }
                    interestInfoArr[i] = interestInfo;
                    i = daysBetweenDate2 + 1;
                }
            }
            if (i != 0) {
                while (i < daysBetweenDate) {
                    interestInfoArr[i] = interestInfoArr[i - 1];
                    i++;
                }
                interestSetInfo.infoList = interestInfoArr;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m22726a() {
        WalletBalanceInterestResp.DataBean dataBean;
        if (this.f32055h != null && (dataBean = this.f32051d) != null) {
            if (dataBean.daySet != null && !CollectionUtil.isEmpty((Object[]) this.f32051d.daySet.infoList)) {
                this.f32052e = new String[]{m22725a(this.f32051d.daySet.infoList.length, 0, 6, this.f32061n), this.f32061n.format(this.f32055h)};
            }
            if (this.f32051d.totalSet != null && !CollectionUtil.isEmpty((Object[]) this.f32051d.totalSet.infoList)) {
                this.f32054g = new String[]{m22725a(this.f32051d.totalSet.infoList.length, 0, 6, this.f32062o), this.f32062o.format(this.f32055h)};
            }
            if (this.f32051d.monthSet != null && this.f32051d.monthSet.startDate != null && !CollectionUtil.isEmpty((Object[]) this.f32051d.monthSet.infoList)) {
                String[] stringArray = ResourcesHelper.getStringArray(this.f32050c, R.array.wallet_balance_interest_months);
                String[] strArr = null;
                try {
                    int length = this.f32051d.monthSet.infoList.length;
                    strArr = new String[length];
                    this.f32056i.setTime(this.f32058k.parse(this.f32051d.monthSet.startDate));
                    int i = this.f32056i.get(2);
                    for (int i2 = 0; i2 < length; i2++) {
                        strArr[i2] = stringArray[(i2 + i) % stringArray.length];
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                this.f32053f = strArr;
            }
        }
    }

    public void onInterestDayClicked() {
        WalletBalanceInterestResp.DataBean dataBean = this.f32051d;
        if (dataBean != null && dataBean.daySet != null && !CollectionUtil.isEmpty((Object[]) this.f32051d.daySet.infoList)) {
            this.f32048a.showChartInDay(this.f32051d.daySet.infoList, this.f32052e);
            this.f32048a.showInterestInfo(this.f32051d.daySet.infoList[this.f32051d.daySet.infoList.length - 1], this.f32059l.format(this.f32055h));
        }
    }

    public void onInterestMonthClicked() {
        WalletBalanceInterestResp.DataBean dataBean = this.f32051d;
        if (dataBean != null && dataBean.monthSet != null && !CollectionUtil.isEmpty((Object[]) this.f32051d.monthSet.infoList)) {
            this.f32048a.showChartInMonth(this.f32051d.monthSet.infoList, this.f32053f);
            this.f32048a.showInterestInfo(this.f32051d.monthSet.infoList[this.f32051d.monthSet.infoList.length - 1], this.f32060m.format(this.f32055h));
        }
    }

    public void onInterestTotalClicked() {
        WalletBalanceInterestResp.DataBean dataBean = this.f32051d;
        if (dataBean != null && dataBean.totalSet != null && !CollectionUtil.isEmpty((Object[]) this.f32051d.totalSet.infoList)) {
            this.f32048a.showChartInTotal(this.f32051d.totalSet.infoList, this.f32054g);
            this.f32048a.showInterestInfo(this.f32051d.totalSet.infoList[this.f32051d.totalSet.infoList.length - 1], this.f32059l.format(this.f32055h));
        }
    }

    public void onChartItemSelectedInDay(int i) {
        WalletBalanceInterestResp.DataBean dataBean = this.f32051d;
        if (dataBean != null && dataBean.daySet != null && !CollectionUtil.isEmpty((Object[]) this.f32051d.daySet.infoList) && i < this.f32051d.daySet.infoList.length) {
            this.f32048a.showInterestInfo(this.f32051d.daySet.infoList[i], m22725a(this.f32051d.daySet.infoList.length, i, 6, this.f32059l));
        }
    }

    public void onChartItemSelectedInMonth(int i) {
        WalletBalanceInterestResp.DataBean dataBean = this.f32051d;
        if (dataBean != null && dataBean.monthSet != null && !CollectionUtil.isEmpty((Object[]) this.f32051d.monthSet.infoList) && i < this.f32051d.monthSet.infoList.length) {
            this.f32048a.showInterestInfo(this.f32051d.monthSet.infoList[i], m22725a(this.f32051d.monthSet.infoList.length, i, 2, this.f32060m));
        }
    }

    public void onChartItemSelectedInTotal(int i) {
        WalletBalanceInterestResp.DataBean dataBean = this.f32051d;
        if (dataBean != null && dataBean.totalSet != null && !CollectionUtil.isEmpty((Object[]) this.f32051d.totalSet.infoList) && i < this.f32051d.totalSet.infoList.length) {
            this.f32048a.showInterestInfo(this.f32051d.totalSet.infoList[i], m22725a(this.f32051d.totalSet.infoList.length, i, 6, this.f32059l));
        }
    }

    /* renamed from: a */
    private String m22725a(int i, int i2, int i3, SimpleDateFormat simpleDateFormat) {
        Calendar calendar;
        Date date = this.f32055h;
        if (date == null || (calendar = this.f32056i) == null || simpleDateFormat == null) {
            return "";
        }
        calendar.setTime(date);
        this.f32056i.add(i3, (i2 - i) + 1);
        return simpleDateFormat.format(this.f32056i.getTime());
    }

    public int getDaysBetweenDate(Date date, Date date2) {
        return (int) ((date2.getTime() - date.getTime()) / 86400000);
    }

    public int getMonthsBetweenDate(Date date, Date date2) {
        this.f32056i.setTime(date);
        int i = this.f32056i.get(2) + 1;
        int i2 = this.f32056i.get(1);
        this.f32056i.setTime(date2);
        int i3 = this.f32056i.get(2) + 1;
        int i4 = this.f32056i.get(1);
        return i4 == i2 ? i3 - i : (i3 + ((i4 - i2) * 12)) - i;
    }
}
