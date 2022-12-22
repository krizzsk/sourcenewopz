package com.didi.payment.wallet.global.wallet.entity;

import com.didi.payment.wallet.global.model.WalletApolloUtils;
import com.didi.payment.wallet.global.model.resp.WalletHomeResp;
import com.didi.payment.wallet.global.model.resp.WalletPageQueryResp;
import com.didi.payment.wallet.global.wallet.entity.WalletPageInfo;
import com.didi.sdk.fastframe.util.CollectionUtil;
import java.util.ArrayList;
import java.util.Collection;

public class WalletModelConvert {
    public static WalletSettingPageInfo convertByWalletHomeData(WalletHomeResp.DataBean dataBean) {
        WalletSettingPageInfo walletSettingPageInfo = new WalletSettingPageInfo();
        WalletHomeResp.AccountSection accountSection = dataBean.accountSection;
        if (accountSection != null) {
            WalletPageQueryResp.AccountSectionItem accountSectionItem = new WalletPageQueryResp.AccountSectionItem();
            accountSectionItem.status = accountSection.status;
            accountSectionItem.facialRecognitionStatus = accountSection.facialRecognitionStatus;
            accountSectionItem.name = accountSection.title;
            accountSectionItem.channelId = accountSection.channelId;
            accountSectionItem.currency = accountSection.currency;
            accountSectionItem.balanceAmount = accountSection.balanceAmount;
            accountSectionItem.richText = accountSection.statusMsg;
            accountSectionItem.detailsText = accountSection.detailsMsg;
            accountSectionItem.interestStatus = accountSection.interestStatus;
            accountSectionItem.buttonText = accountSection.buttonText;
            if (accountSection.promotionHeader != null) {
                accountSectionItem.promotionText = accountSection.promotionHeader.text;
            }
            accountSectionItem.fullKycStatus = accountSection.fullKycStatus;
            accountSectionItem.supportFullKyc = accountSection.supportFullKyc;
            accountSectionItem.hasInterest = accountSection.hasInterest;
            accountSectionItem.title = accountSection.title;
            accountSectionItem.freezeData = accountSection.accountFreezeData;
            accountSectionItem.accountStatus = accountSection.accountStatus;
            walletSettingPageInfo.accountSection = accountSectionItem;
        }
        walletSettingPageInfo.freezonData = dataBean.freezonData;
        if (!(dataBean.paymentSection == null || dataBean.paymentSection.payMethodItems == null)) {
            for (WalletHomeResp.PaymentMethodItem next : dataBean.paymentSection.payMethodItems) {
                if (next.channelId == 152) {
                    WalletPageQueryResp.PaymentMethodEntryItemBean paymentMethodEntryItemBean = new WalletPageQueryResp.PaymentMethodEntryItemBean();
                    paymentMethodEntryItemBean.cardIndex = next.cardIndex;
                    paymentMethodEntryItemBean.cardStatus = next.cardStatus;
                    paymentMethodEntryItemBean.channelId = next.channelId;
                    paymentMethodEntryItemBean.desc = next.desc;
                    paymentMethodEntryItemBean.name = next.name;
                    paymentMethodEntryItemBean.iconUrl = next.iconUrl;
                    paymentMethodEntryItemBean.linkUrl = next.linkUrl;
                    paymentMethodEntryItemBean.signStatus = next.signStatus;
                    paymentMethodEntryItemBean.expireDate = next.expireDate;
                    paymentMethodEntryItemBean.cardIndex = next.cardIndex;
                    paymentMethodEntryItemBean.profileIdentifier = next.profileIdentifier;
                    paymentMethodEntryItemBean.expired = next.expired;
                    paymentMethodEntryItemBean.expiredDesc = next.expiredDesc;
                }
            }
        }
        walletSettingPageInfo.serviceCenterUrl = dataBean.customerSupportUrl;
        return walletSettingPageInfo;
    }

    public static WalletSettingPageInfo convertByWalletPageInfo(WalletPageInfo walletPageInfo) {
        WalletSettingPageInfo walletSettingPageInfo = new WalletSettingPageInfo();
        walletSettingPageInfo.accountSection = walletPageInfo.accountSection;
        walletSettingPageInfo.freezonData = walletPageInfo.freezonData;
        walletSettingPageInfo.paypalItem = walletPageInfo.paypalItem;
        walletSettingPageInfo.serviceCenterUrl = walletPageInfo.serviceCenterUrl;
        return walletSettingPageInfo;
    }

    public static WalletPageInfo convert(WalletPageQueryResp walletPageQueryResp) {
        WalletPageInfo walletPageInfo = new WalletPageInfo();
        if (walletPageQueryResp == null || walletPageQueryResp.data == null) {
            return null;
        }
        walletPageInfo.title = walletPageQueryResp.data.title;
        walletPageInfo.serviceCenterUrl = walletPageQueryResp.data.customerSupportUrl;
        walletPageInfo.balanceSection = m22669a(walletPageQueryResp.data.balanceSection);
        if (walletPageQueryResp.data.paymentData != null) {
            walletPageInfo.payMethodSection = m22670a(walletPageQueryResp.data.paymentData.paymentMethodSection, walletPageQueryResp.data.paymentData.signEntrySection, walletPageQueryResp.data.sampleStyle);
            walletPageInfo.promotionSection = m22671a(walletPageQueryResp.data.paymentData.promotionSection);
        }
        if (WalletApolloUtils.useOldServer()) {
            walletPageInfo.payMethodSection = m22670a(walletPageQueryResp.data.paymentMethodSectionOldServer, walletPageQueryResp.data.signEntrySectionOldServer, walletPageQueryResp.data.sampleStyle);
            walletPageInfo.promotionSection = m22671a(walletPageQueryResp.data.promotionSectionOldServer);
        }
        if (!(walletPageQueryResp.data.accountSection == null || walletPageQueryResp.data.accountSection.entryList == null || walletPageQueryResp.data.accountSection.entryList.size() <= 0)) {
            walletPageInfo.accountSection = walletPageQueryResp.data.accountSection.entryList.get(0);
        }
        walletPageInfo.consumeSection = walletPageQueryResp.data.consumeSection;
        walletPageInfo.freezonData = walletPageQueryResp.data.accountFreezeData;
        walletPageInfo.pixSection = walletPageQueryResp.data.pixSection;
        walletPageInfo.financeSection = walletPageQueryResp.data.financeSection;
        walletPageInfo.extendEntrySection = walletPageQueryResp.data.extendEntrySection;
        walletPageInfo.newPayMethodSection = walletPageQueryResp.data.newPaymentMethodSection;
        if (walletPageQueryResp.data.newPaymentMethodSection != null && !CollectionUtil.isEmpty((Collection) walletPageQueryResp.data.newPaymentMethodSection.entryList)) {
            ArrayList arrayList = new ArrayList();
            for (WalletPageQueryResp.PaymentMethodEntryItemBean next : walletPageQueryResp.data.newPaymentMethodSection.entryList) {
                if (next.channelId == 152) {
                    walletPageInfo.paypalItem = next;
                } else {
                    arrayList.add(next);
                }
            }
            walletPageInfo.newPayMethodSection.entryList = arrayList;
        }
        if (!(!walletPageQueryResp.data.sampleStyle || walletPageInfo.accountSection == null || walletPageInfo.payMethodSection == null)) {
            walletPageInfo.title = "";
            walletPageInfo.accountSection.title = walletPageInfo.payMethodSection.title;
            walletPageInfo.accountSection.helpUrl = walletPageInfo.payMethodSection.helpUrl;
            walletPageInfo.payMethodSection.title = null;
            walletPageInfo.payMethodSection.helpUrl = null;
        }
        return walletPageInfo;
    }

    /* renamed from: a */
    private static WalletPageInfo.BalanceSection m22669a(WalletPageQueryResp.BalanceSectionBean balanceSectionBean) {
        if (balanceSectionBean == null || balanceSectionBean.balanceData == null) {
            return null;
        }
        WalletPageInfo.BalanceSection balanceSection = new WalletPageInfo.BalanceSection();
        balanceSection.title = balanceSectionBean.title;
        balanceSection.value = balanceSectionBean.balanceData.value;
        balanceSection.currency = balanceSectionBean.balanceData.currency;
        balanceSection.status = balanceSectionBean.balanceData.enabled ? 1 : 0;
        balanceSection.symbol = balanceSectionBean.balanceData.currencySymbol;
        balanceSection.desc = balanceSectionBean.balanceData.desc;
        balanceSection.helpUrl = balanceSectionBean.url;
        balanceSection.linkUrl = balanceSectionBean.balanceData.transDetailUrl;
        if (balanceSectionBean.promotionBanner != null) {
            balanceSection.bannerUrl = balanceSectionBean.promotionBanner.imageUrl;
            balanceSection.bannerLinkUrl = balanceSectionBean.promotionBanner.linkUrl;
        }
        balanceSection.menuItems = new ArrayList();
        if (balanceSectionBean.menuItems != null && balanceSectionBean.menuItems.size() > 0) {
            for (WalletPageQueryResp.BalanceMenuItemBean next : balanceSectionBean.menuItems) {
                WalletPageInfo.BalanceItem balanceItem = new WalletPageInfo.BalanceItem();
                if (next != null) {
                    balanceItem.f32015id = next.f31755id;
                    balanceItem.status = next.enabled ? 1 : 0;
                    balanceItem.title = next.name;
                    balanceItem.iconUrl = next.iconUrl;
                    balanceItem.promotionText = next.promotionText;
                    balanceItem.linkUrl = next.linkUrl;
                    balanceSection.menuItems.add(balanceItem);
                }
            }
        }
        return balanceSection;
    }

    /* renamed from: a */
    private static WalletPageInfo.PayMethodSection m22670a(WalletPageQueryResp.PaymentMethodSectionBean paymentMethodSectionBean, WalletPageQueryResp.SignEntrySectionBean signEntrySectionBean, boolean z) {
        if (paymentMethodSectionBean == null || signEntrySectionBean == null) {
            return null;
        }
        WalletPageInfo.PayMethodSection payMethodSection = new WalletPageInfo.PayMethodSection();
        payMethodSection.title = paymentMethodSectionBean.title;
        payMethodSection.helpUrl = paymentMethodSectionBean.url;
        payMethodSection.signEntry = m22668a(signEntrySectionBean);
        payMethodSection.payMethodItems = new ArrayList();
        if (paymentMethodSectionBean.entryList != null && paymentMethodSectionBean.entryList.size() > 0) {
            for (WalletPageQueryResp.PaymentMethodEntryItemBean next : paymentMethodSectionBean.entryList) {
                if (!z || next.channelId != 190) {
                    WalletPageInfo.PayMethodItem payMethodItem = new WalletPageInfo.PayMethodItem();
                    payMethodItem.channelId = next.channelId;
                    payMethodItem.signStatus = next.signStatus;
                    payMethodItem.cardStatus = next.cardStatus;
                    payMethodItem.title = next.name;
                    payMethodItem.desc = next.desc;
                    payMethodItem.iconUrl = next.iconUrl;
                    payMethodItem.linkUrl = next.linkUrl;
                    payMethodItem.cardIndex = next.cardIndex;
                    payMethodItem.cardExpiryDate = next.expireDate;
                    payMethodItem.profileIdentifier = next.profileIdentifier;
                    payMethodItem.expired = next.expired;
                    payMethodItem.expiredDesc = next.expiredDesc;
                    payMethodSection.payMethodItems.add(payMethodItem);
                }
            }
        }
        return payMethodSection;
    }

    /* renamed from: a */
    private static WalletPageInfo.AddPayMethodEntry m22668a(WalletPageQueryResp.SignEntrySectionBean signEntrySectionBean) {
        WalletPageInfo.AddPayMethodEntry addPayMethodEntry = new WalletPageInfo.AddPayMethodEntry();
        if (signEntrySectionBean == null) {
            return addPayMethodEntry;
        }
        addPayMethodEntry.title = signEntrySectionBean.title;
        addPayMethodEntry.iconUrl = signEntrySectionBean.url;
        addPayMethodEntry.desc = signEntrySectionBean.desc;
        addPayMethodEntry.dialogInfo = new WalletPageInfo.AddPayMethodEntryDialogInfo();
        addPayMethodEntry.dialogInfo.title = signEntrySectionBean.entryListTitle;
        addPayMethodEntry.dialogInfo.signEntries = new ArrayList();
        if (signEntrySectionBean.entryList != null && signEntrySectionBean.entryList.size() > 0) {
            for (WalletPageQueryResp.SignEntryItemBean next : signEntrySectionBean.entryList) {
                WalletPageInfo.AddPayMethodEntryDialogItem addPayMethodEntryDialogItem = new WalletPageInfo.AddPayMethodEntryDialogItem();
                if (next != null) {
                    addPayMethodEntryDialogItem.name = next.name;
                    addPayMethodEntryDialogItem.desc = next.desc;
                    addPayMethodEntryDialogItem.channelId = next.channelId;
                    addPayMethodEntryDialogItem.iconUrl = next.iconUrl;
                    addPayMethodEntryDialogItem.linkUrl = next.linkUrl;
                    addPayMethodEntry.dialogInfo.signEntries.add(addPayMethodEntryDialogItem);
                }
            }
        }
        return addPayMethodEntry;
    }

    /* renamed from: a */
    private static WalletPageInfo.PromotionSection m22671a(WalletPageQueryResp.PromotionSectionBean promotionSectionBean) {
        if (promotionSectionBean == null) {
            return null;
        }
        WalletPageInfo.PromotionSection promotionSection = new WalletPageInfo.PromotionSection();
        promotionSection.title = promotionSectionBean.title;
        promotionSection.helpUrl = promotionSectionBean.url;
        promotionSection.desc = promotionSectionBean.desc;
        promotionSection.promotionItems = new ArrayList();
        if (promotionSectionBean.entryList != null && promotionSectionBean.entryList.size() > 0) {
            for (WalletPageQueryResp.PromotionEntryItemBean next : promotionSectionBean.entryList) {
                WalletPageInfo.PromotionItem promotionItem = new WalletPageInfo.PromotionItem();
                if (next != null) {
                    promotionItem.title = next.name;
                    promotionItem.desc = next.desc;
                    promotionItem.iconUrl = next.iconUrl;
                    promotionItem.linkUrl = next.linkUrl;
                    promotionSection.promotionItems.add(promotionItem);
                }
            }
        }
        return promotionSection;
    }
}
