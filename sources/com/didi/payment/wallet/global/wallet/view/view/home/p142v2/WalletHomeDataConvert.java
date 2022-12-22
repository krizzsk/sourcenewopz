package com.didi.payment.wallet.global.wallet.view.view.home.p142v2;

import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.CommonResourceState;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.Data;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.Entry;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.FinancialEntry;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.FinancialSection;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.IData;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.PaySection;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.ResourceStateData;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.StringWrapperSection;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.UserAgreementSection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/WalletHomeDataConvert;", "", "()V", "Companion", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeDataConvert */
/* compiled from: WalletHomeDataConvert.kt */
public final class WalletHomeDataConvert {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmStatic
    public static final List<WalletHomeHolderData<? extends IData>> convertHomeData(Data data) {
        return Companion.convertHomeData(data);
    }

    @Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u00050\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0007¨\u0006\t"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/WalletHomeDataConvert$Companion;", "", "()V", "convertHomeData", "", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/WalletHomeHolderData;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/IData;", "homeData", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/resp/Data;", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.WalletHomeDataConvert$Companion */
    /* compiled from: WalletHomeDataConvert.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final List<WalletHomeHolderData<? extends IData>> convertHomeData(Data data) {
            List<ResourceStateData> bannerState;
            List<FinancialEntry> entryList;
            List<Entry> entryList2;
            List<WalletHomeHolderData<? extends IData>> arrayList = new ArrayList<>();
            if (data != null) {
                boolean z = true;
                arrayList.add(new WalletHomeHolderData(1, data));
                PaySection paySection = data.getPaySection();
                if (paySection != null) {
                    arrayList.add(new WalletHomeHolderData(5, null, paySection.getTitle()));
                }
                PaySection paySection2 = data.getPaySection();
                if (!(paySection2 == null || (entryList2 = paySection2.getEntryList()) == null)) {
                    int i = 0;
                    for (Object next : entryList2) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        WalletHomeHolderData walletHomeHolderData = new WalletHomeHolderData(2, (Entry) next);
                        walletHomeHolderData.setLocalIndex(Integer.valueOf(i));
                        arrayList.add(walletHomeHolderData);
                        i = i2;
                    }
                }
                FinancialSection financialSection = data.getFinancialSection();
                if (financialSection != null) {
                    arrayList.add(new WalletHomeHolderData(5, null, financialSection.getTitle()));
                }
                FinancialSection financialSection2 = data.getFinancialSection();
                if (!(financialSection2 == null || (entryList = financialSection2.getEntryList()) == null)) {
                    int i3 = 0;
                    for (Object next2 : entryList) {
                        int i4 = i3 + 1;
                        if (i3 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        WalletHomeHolderData walletHomeHolderData2 = new WalletHomeHolderData(3, (FinancialEntry) next2);
                        walletHomeHolderData2.setLocalIndex(Integer.valueOf(i3));
                        arrayList.add(walletHomeHolderData2);
                        i3 = i4;
                    }
                }
                CommonResourceState commonResourceState = data.getCommonResourceState();
                if (commonResourceState != null) {
                    arrayList.add(new WalletHomeHolderData(5, null, commonResourceState.getTitle()));
                }
                CommonResourceState commonResourceState2 = data.getCommonResourceState();
                if (!(commonResourceState2 == null || (bannerState = commonResourceState2.getBannerState()) == null)) {
                    int i5 = 0;
                    for (Object next3 : bannerState) {
                        int i6 = i5 + 1;
                        if (i5 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        WalletHomeHolderData walletHomeHolderData3 = new WalletHomeHolderData(4, (ResourceStateData) next3);
                        walletHomeHolderData3.setLocalIndex(Integer.valueOf(i5));
                        arrayList.add(walletHomeHolderData3);
                        i5 = i6;
                    }
                }
                UserAgreementSection userAgreementSection = data.getUserAgreementSection();
                if (userAgreementSection != null) {
                    arrayList.add(new WalletHomeHolderData(6, userAgreementSection));
                }
                String brandIcon = data.getBrandIcon();
                if (brandIcon != null) {
                    if (data.getUserAgreementSection() == null) {
                        z = false;
                    }
                    arrayList.add(new WalletHomeHolderData(8, new StringWrapperSection(brandIcon, z)));
                }
            }
            return arrayList;
        }
    }
}
