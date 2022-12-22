package com.didi.component.estimate.newui.presenter;

import android.content.Context;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.event.VerticalDataUpdateEvent;
import com.didi.component.business.util.UiUtils;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.estimate.newui.view.IV2EstimateView;
import com.didi.component.estimate.newui.view.vertical.NewVerticalEstimateView;
import com.didi.component.estimate.presenter.EstimatePresenter;
import com.didi.component.utils.EstimateTrackEventUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.travel.psnger.model.response.PayWayModel;
import com.didi.travel.psnger.model.response.estimate.CarDetailInfoListModel;
import com.didi.travel.psnger.model.response.estimate.CarPayExtraItemInfo;
import com.didi.travel.psnger.model.response.estimate.CarPayInfoModel;
import com.didi.travel.psnger.model.response.estimate.CarSeatChoiceModel;
import com.didi.travel.psnger.model.response.estimate.EstimateGlobalConfigModel;
import com.didi.travel.psnger.model.response.estimate.EstimateGroupModel;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.didiglobal.travel.util.CollectionUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class NewEstimatePresenter {
    public static final String SELECT_DEFAULT = "1";

    /* renamed from: a */
    private final List<EstimateItemModel> f13030a = new ArrayList();
    public List<String> allCarString = new ArrayList();
    public List<EstimateGroupModel> allGroups;

    /* renamed from: b */
    private EstimateItemModel f13031b;
    public EstimatePresenter estimatePresenter;
    public final List<EstimateItemModel> expandList = new ArrayList();
    public EstimateGlobalConfigModel globalConfigModel;
    public EstimateItemModel lastSelectModel;
    protected final Logger mLogger = LoggerFactory.getLogger(getClass());
    public EstimateItemModel mOneCarItemModel;
    public int mRecommendsItemHeight;
    public IV2EstimateView mView;
    public List<String> recommendIds;
    public final List<EstimateItemModel> recommendsList = new ArrayList();

    public void collectRecommends(boolean z) {
        m8854a(z);
    }

    /* renamed from: a */
    private void m8854a(boolean z) {
        EstimateItemModel estimateItemModel;
        if (this.recommendIds != null) {
            this.f13030a.clear();
            this.recommendsList.clear();
            for (String next : this.recommendIds) {
                Iterator<EstimateItemModel> it = this.expandList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    EstimateItemModel next2 = it.next();
                    if (next2.carConfig != null && !TextUtils.isEmpty(next2.carConfig.uniqueId) && next.equals(next2.carConfig.uniqueId)) {
                        this.f13030a.add(next2);
                        this.recommendsList.add(next2);
                        if (this.f13031b == null && "1".equals(next2.carConfig.selectDefault)) {
                            this.f13031b = next2;
                            next2.isSelected = true;
                        }
                    }
                }
            }
            if (this.f13030a.size() == 0 && this.expandList.size() > 0) {
                this.f13030a.add(this.expandList.get(0));
            }
            if (this.f13030a.size() > 0 && this.f13031b == null) {
                EstimateItemModel estimateItemModel2 = this.f13030a.get(0);
                this.f13031b = estimateItemModel2;
                estimateItemModel2.isSelected = true;
            }
            if (!z && (estimateItemModel = this.f13031b) != null) {
                updateRecHead(estimateItemModel);
            }
            EstimatePresenter estimatePresenter2 = this.estimatePresenter;
            if (estimatePresenter2 != null) {
                estimatePresenter2.updateSelectModel(this.f13031b, true);
                EstimateItemModel estimateItemModel3 = this.f13031b;
                if (!(estimateItemModel3 == null || estimateItemModel3.carConfig == null || this.f13031b.carConfig.extraData == null || this.f13031b.carConfig.extraData.getOrderParams() == null || TextUtils.isEmpty(this.f13031b.carConfig.extraData.getOrderParams().bubbleId))) {
                    FormStore.getInstance().setBubbleId(this.f13031b.carConfig.extraData.getOrderParams().bubbleId);
                }
            }
            EstimateTrackEventUtils.trackOrderConfirmDialogShow();
        }
    }

    /* renamed from: b */
    private void m8855b(boolean z) {
        this.lastSelectModel = this.f13031b;
        this.f13031b = null;
        this.expandList.clear();
        for (EstimateGroupModel next : this.allGroups) {
            for (int i = 0; i < next.estimateItems.size(); i++) {
                EstimateItemModel estimateItemModel = next.estimateItems.get(i);
                if (i == 0) {
                    estimateItemModel.itemTitle = next.title;
                }
                if (!z) {
                    EstimateItemModel findEstimateModel = findEstimateModel(estimateItemModel);
                    if (findEstimateModel != null) {
                        if (findEstimateModel.isSelected) {
                            this.f13031b = estimateItemModel;
                        }
                        estimateItemModel.isSelected = findEstimateModel.isSelected;
                        setEstimateOperation(estimateItemModel, findEstimateModel);
                        if (findEstimateModel.getSelectedValueParams() != null && findEstimateModel.getSelectPos() >= 0) {
                            m8853a(estimateItemModel, findEstimateModel.getSelectPos());
                        }
                    } else {
                        setEstimateOperation(estimateItemModel, (EstimateItemModel) null);
                    }
                } else {
                    setEstimateOperation(estimateItemModel, (EstimateItemModel) null);
                }
                estimateItemModel.oldEstimateItem = newEstimateItemToOld(estimateItemModel);
                this.expandList.add(estimateItemModel);
            }
        }
        FormStore.getInstance().setInfoList(this.allCarString.toString());
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x017f  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0186  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01a1  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01ad  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01b4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didi.travel.psnger.model.response.EstimateItem newEstimateItemToOld(com.didi.travel.psnger.model.response.estimate.EstimateItemModel r15) {
        /*
            r14 = this;
            com.didi.travel.psnger.model.response.EstimateItem r0 = new com.didi.travel.psnger.model.response.EstimateItem
            r0.<init>()
            java.lang.String r1 = ""
            r15.feeDisplay = r1
            com.didi.travel.psnger.model.response.estimate.CarConfigModel r2 = r15.carConfig
            if (r2 == 0) goto L_0x01d5
            com.didi.travel.psnger.model.response.estimate.SelectedValueParams r2 = r15.getSelectedValueParams()
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0089
            java.lang.String r5 = r2.seatPoolEstimateId
            boolean r5 = android.text.TextUtils.isEmpty(r5)
            if (r5 != 0) goto L_0x0021
            java.lang.String r5 = r2.seatPoolEstimateId
            r15.estimateId = r5
        L_0x0021:
            int r5 = r2.seatPoolCountType
            r15.countPriceType = r5
            float r5 = r2.seatPoolEstimatePrice
            r15.feeNumber = r5
            com.didi.travel.psnger.model.response.estimate.CarInfoModel r5 = r15.carInfo
            if (r5 == 0) goto L_0x010d
            com.didi.travel.psnger.model.response.estimate.CarInfoModel r5 = r15.carInfo
            java.util.List<com.didi.travel.psnger.model.response.estimate.CarInfoPriceModel> r5 = r5.carPriceInfo
            boolean r5 = com.didiglobal.travel.util.CollectionUtils.isNotEmpty((java.util.Collection<?>) r5)
            if (r5 == 0) goto L_0x010d
            com.didi.travel.psnger.model.response.estimate.CarInfoModel r5 = r15.carInfo
            java.util.List<com.didi.travel.psnger.model.response.estimate.CarInfoPriceModel> r5 = r5.carPriceInfo
            java.lang.Object r5 = r5.get(r4)
            com.didi.travel.psnger.model.response.estimate.CarInfoPriceModel r5 = (com.didi.travel.psnger.model.response.estimate.CarInfoPriceModel) r5
            java.lang.String r6 = r5.priceSymbol
            int r5 = r5.priceSymbolPosition
            float r2 = r2.seatPoolEstimatePrice
            java.lang.String r2 = java.lang.String.valueOf(r2)
            boolean r7 = android.text.TextUtils.isEmpty(r2)
            if (r7 != 0) goto L_0x007f
            boolean r7 = android.text.TextUtils.isEmpty(r6)
            if (r7 != 0) goto L_0x007f
            if (r5 != r3) goto L_0x006c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            r3.append(r6)
            java.lang.String r2 = r3.toString()
            r15.feeDisplay = r2
            goto L_0x010d
        L_0x006c:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r6)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r15.feeDisplay = r2
            goto L_0x010d
        L_0x007f:
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L_0x010d
            r15.feeDisplay = r2
            goto L_0x010d
        L_0x0089:
            com.didi.travel.psnger.model.response.estimate.CarConfigModel r2 = r15.carConfig
            java.lang.String r2 = r2.estimateId
            r15.estimateId = r2
            com.didi.travel.psnger.model.response.estimate.CarConfigModel r2 = r15.carConfig
            int r2 = r2.countPriceType
            r15.countPriceType = r2
            com.didi.travel.psnger.model.response.estimate.CarInfoModel r2 = r15.carInfo
            if (r2 == 0) goto L_0x00f1
            com.didi.travel.psnger.model.response.estimate.CarInfoModel r2 = r15.carInfo
            java.util.List<com.didi.travel.psnger.model.response.estimate.CarInfoPriceModel> r2 = r2.carPriceInfo
            boolean r2 = com.didiglobal.travel.util.CollectionUtils.isNotEmpty((java.util.Collection<?>) r2)
            if (r2 == 0) goto L_0x00f1
            com.didi.travel.psnger.model.response.estimate.CarInfoModel r2 = r15.carInfo
            java.util.List<com.didi.travel.psnger.model.response.estimate.CarInfoPriceModel> r2 = r2.carPriceInfo
            java.lang.Object r2 = r2.get(r4)
            com.didi.travel.psnger.model.response.estimate.CarInfoPriceModel r2 = (com.didi.travel.psnger.model.response.estimate.CarInfoPriceModel) r2
            java.lang.String r5 = r2.priceSymbol
            int r6 = r2.priceSymbolPosition
            com.didi.travel.psnger.model.response.GlobalRichInfo r2 = r2.carPrice
            java.lang.String r2 = r2.getContent()
            boolean r7 = android.text.TextUtils.isEmpty(r2)
            if (r7 != 0) goto L_0x00e9
            boolean r7 = android.text.TextUtils.isEmpty(r5)
            if (r7 != 0) goto L_0x00e9
            if (r6 != r3) goto L_0x00d7
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r2)
            r3.append(r5)
            java.lang.String r2 = r3.toString()
            r15.feeDisplay = r2
            goto L_0x00f1
        L_0x00d7:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r3.append(r5)
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r15.feeDisplay = r2
            goto L_0x00f1
        L_0x00e9:
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L_0x00f1
            r15.feeDisplay = r2
        L_0x00f1:
            com.didi.travel.psnger.model.response.estimate.CarConfigModel r2 = r15.carConfig
            com.didi.travel.psnger.model.response.estimate.CarExtraDataModel r2 = r2.extraData
            if (r2 == 0) goto L_0x010d
            com.didi.travel.psnger.model.response.estimate.CarConfigModel r2 = r15.carConfig
            com.didi.travel.psnger.model.response.estimate.CarExtraDataModel r2 = r2.extraData
            com.didi.travel.psnger.model.response.estimate.OrderParams r2 = r2.getOrderParams()
            if (r2 == 0) goto L_0x010d
            com.didi.travel.psnger.model.response.estimate.CarConfigModel r2 = r15.carConfig
            com.didi.travel.psnger.model.response.estimate.CarExtraDataModel r2 = r2.extraData
            com.didi.travel.psnger.model.response.estimate.OrderParams r2 = r2.getOrderParams()
            float r2 = r2.feeAmount
            r15.feeNumber = r2
        L_0x010d:
            com.didi.travel.psnger.model.response.estimate.CarConfigModel r2 = r15.carConfig
            int r2 = r2.carBussinessId
            r0.businessId = r2
            com.didi.travel.psnger.model.response.estimate.CarConfigModel r2 = r15.carConfig
            int r2 = r2.carLevel
            r0.carTypeId = r2
            com.didi.travel.psnger.model.response.estimate.CarConfigModel r2 = r15.carConfig
            com.didi.travel.psnger.model.response.estimate.CarExtraDataModel r2 = r2.extraData
            if (r2 == 0) goto L_0x01d5
            com.didi.travel.psnger.model.response.estimate.CarConfigModel r2 = r15.carConfig
            com.didi.travel.psnger.model.response.estimate.CarExtraDataModel r2 = r2.extraData
            com.didi.travel.psnger.model.response.estimate.CarExtraLogModel r2 = r2.getExtraLog()
            if (r2 == 0) goto L_0x01d5
            com.didi.travel.psnger.model.response.estimate.CarConfigModel r2 = r15.carConfig
            com.didi.travel.psnger.model.response.estimate.CarExtraDataModel r2 = r2.extraData
            com.didi.travel.psnger.model.response.estimate.CarExtraLogModel r2 = r2.getExtraLog()
            java.lang.String r3 = r2.eta
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x014f
            com.didi.component.business.data.form.FormStore r3 = com.didi.component.business.data.form.FormStore.getInstance()     // Catch:{ Exception -> 0x0147 }
            java.lang.String r5 = r2.eta     // Catch:{ Exception -> 0x0147 }
            int r5 = java.lang.Integer.parseInt(r5)     // Catch:{ Exception -> 0x0147 }
            r3.setEta(r5)     // Catch:{ Exception -> 0x0147 }
            goto L_0x0156
        L_0x0147:
            com.didi.component.business.data.form.FormStore r3 = com.didi.component.business.data.form.FormStore.getInstance()
            r3.setEta(r4)
            goto L_0x0156
        L_0x014f:
            com.didi.component.business.data.form.FormStore r3 = com.didi.component.business.data.form.FormStore.getInstance()
            r3.setEta(r4)
        L_0x0156:
            java.lang.String r3 = r2.originFee
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            r4 = 0
            if (r3 != 0) goto L_0x0166
            java.lang.String r2 = r2.originFee     // Catch:{ Exception -> 0x0166 }
            float r2 = java.lang.Float.parseFloat(r2)     // Catch:{ Exception -> 0x0166 }
            goto L_0x0167
        L_0x0166:
            r2 = 0
        L_0x0167:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            com.didi.travel.psnger.model.response.estimate.CarConfigModel r5 = r15.carConfig
            int r5 = r5.carLevel
            r3.append(r5)
            com.didi.component.business.data.form.FormStore r5 = com.didi.component.business.data.form.FormStore.getInstance()
            int r5 = r5.getEta()
            java.lang.String r6 = ":"
            if (r5 != 0) goto L_0x0186
            r3.append(r6)
            r3.append(r1)
            goto L_0x0194
        L_0x0186:
            r3.append(r6)
            com.didi.component.business.data.form.FormStore r5 = com.didi.component.business.data.form.FormStore.getInstance()
            int r5 = r5.getEta()
            r3.append(r5)
        L_0x0194:
            float r5 = r15.feeNumber
            int r5 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r5 != 0) goto L_0x01a1
            r3.append(r6)
            r3.append(r1)
            goto L_0x01a9
        L_0x01a1:
            r3.append(r6)
            float r5 = r15.feeNumber
            r3.append(r5)
        L_0x01a9:
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 != 0) goto L_0x01b4
            r3.append(r6)
            r3.append(r1)
            goto L_0x01ba
        L_0x01b4:
            r3.append(r6)
            r3.append(r2)
        L_0x01ba:
            r3.append(r6)
            com.didi.travel.psnger.model.response.estimate.CarConfigModel r1 = r15.carConfig
            java.util.List<java.lang.String> r1 = r1.guideType
            r3.append(r1)
            r3.append(r6)
            boolean r1 = r15.isSelected
            r3.append(r1)
            java.util.List<java.lang.String> r1 = r14.allCarString
            java.lang.String r2 = r3.toString()
            r1.add(r2)
        L_0x01d5:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r0.payWayList = r1
            java.util.List<com.didi.travel.psnger.model.response.estimate.CarPayInfoModel> r1 = r15.carPayInfo
            boolean r1 = com.didiglobal.travel.util.CollectionUtils.isNotEmpty((java.util.Collection<?>) r1)
            if (r1 == 0) goto L_0x0200
            java.util.List<com.didi.travel.psnger.model.response.estimate.CarPayInfoModel> r1 = r15.carPayInfo
            java.util.Iterator r1 = r1.iterator()
        L_0x01ea:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0200
            java.lang.Object r2 = r1.next()
            com.didi.travel.psnger.model.response.estimate.CarPayInfoModel r2 = (com.didi.travel.psnger.model.response.estimate.CarPayInfoModel) r2
            java.util.List<com.didi.travel.psnger.model.response.PayWayModel$PayWayItem> r3 = r0.payWayList
            com.didi.travel.psnger.model.response.PayWayModel$PayWayItem r2 = r14.carPayInfoToPayWayItem(r2)
            r3.add(r2)
            goto L_0x01ea
        L_0x0200:
            java.util.List<com.didi.travel.psnger.model.response.estimate.CarPayGroupInfoModel> r1 = r15.carPayGroupInfo
            r0.payGroupList = r1
            com.didi.travel.psnger.model.response.estimate.CarPayConfigInfoModel r1 = r15.payCfgInfo
            r0.payCfgInfo = r1
            com.didi.travel.psnger.model.response.estimate.CarBusinessConfig r1 = r15.businessConfig
            if (r1 == 0) goto L_0x0234
            com.didi.travel.psnger.model.response.estimate.CarBusinessConfig r15 = r15.businessConfig
            java.lang.String r1 = r15.memberId
            java.lang.String r3 = r15.defaultCompanyId
            java.lang.String r4 = r15.defaultCompanyName
            java.lang.String r5 = r15.defaultCostCenterId
            java.lang.String r6 = r15.defaultCostCenterName
            java.lang.String r7 = r15.defaultProjectId
            java.lang.String r8 = r15.defaultProjectName
            boolean r9 = r15.costCenterRequired
            boolean r10 = r15.projectRequired
            boolean r11 = r15.commentsRequired
            int r12 = r15.commentsMinSize
            int r13 = r15.commentsMaxSize
            com.didi.travel.psnger.model.response.PayEnterpriseInfo r15 = new com.didi.travel.psnger.model.response.PayEnterpriseInfo
            r15.<init>()
            r2 = r15
            r2.setDefault(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            r15.setMemberId(r1)
            r0.payEnterpriseInfo = r15
        L_0x0234:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.estimate.newui.presenter.NewEstimatePresenter.newEstimateItemToOld(com.didi.travel.psnger.model.response.estimate.EstimateItemModel):com.didi.travel.psnger.model.response.EstimateItem");
    }

    public PayWayModel.PayWayItem carPayInfoToPayWayItem(CarPayInfoModel carPayInfoModel) {
        PayWayModel.PayWayItem payWayItem = new PayWayModel.PayWayItem();
        payWayItem.tag = carPayInfoModel.payTag;
        payWayItem.text = carPayInfoModel.payShowMessage;
        payWayItem.title = carPayInfoModel.payMessage;
        payWayItem.titleInSelectPage = carPayInfoModel.payMessageInSelectPage;
        payWayItem.tips = carPayInfoModel.payTips;
        payWayItem.businessUrl = carPayInfoModel.payBussUrl;
        payWayItem.businessConstSet = carPayInfoModel.payBussConstSet;
        payWayItem.companyPayMsg = carPayInfoModel.payCompanyMsg;
        payWayItem.isSigned = carPayInfoModel.payIsSigned;
        payWayItem.channelID = carPayInfoModel.payChannelId;
        payWayItem.isSelected = carPayInfoModel.payIsSelected;
        payWayItem.isPriorityUse = carPayInfoModel.isPriorityUse;
        payWayItem.isHit99payCombination = carPayInfoModel.isHit99payCombination;
        payWayItem.isOffline = carPayInfoModel.payIsOffline;
        payWayItem.card = carPayInfoModel.payCard;
        payWayItem.card_org = carPayInfoModel.payCardOrg;
        payWayItem.iconUrl = carPayInfoModel.payIconUrl;
        payWayItem.disabled = carPayInfoModel.payDisable;
        payWayItem.recommendSignPayType = carPayInfoModel.payRecommendSignPayType;
        payWayItem.priorityShow = carPayInfoModel.priorityShow;
        boolean z = true;
        if (carPayInfoModel.payIsOffline == 1) {
            payWayItem.viewType = PayWayModel.PayWayItem.ViewType.PAY_IN_CAR;
        } else {
            payWayItem.viewType = PayWayModel.PayWayItem.ViewType.PAY_IN_APP;
        }
        payWayItem.companyCarpoolOpen = carPayInfoModel.payCarpoolOpen == 1;
        payWayItem.cardIndex = carPayInfoModel.payCarIndex;
        payWayItem.cardPrefix = carPayInfoModel.cardPrefix;
        payWayItem.totalDiscount = carPayInfoModel.payTotalDiscount;
        payWayItem.discountMsg = carPayInfoModel.payDiscountMessage;
        if (carPayInfoModel.payHasCoupon != 1) {
            z = false;
        }
        payWayItem.hasCoupon = z;
        payWayItem.balanceMsg = carPayInfoModel.payBalanceMsg;
        payWayItem.is_sufficient = carPayInfoModel.payIsSufficient;
        payWayItem.isPromotion = carPayInfoModel.payIsPromotion;
        payWayItem.expired = carPayInfoModel.payExpired;
        payWayItem.expiredDesc = carPayInfoModel.payExpiredDesc;
        payWayItem.can_combination_pay_type = carPayInfoModel.payCombineType;
        payWayItem.toAddCardInfo = carPayInfoModel.toAddCardInfo;
        payWayItem.cardDiscountTags = carPayInfoModel.cardDiscountTags;
        payWayItem.mostFavorableTxt = carPayInfoModel.mostFavorableTxt;
        if (carPayInfoModel.mLogData != null) {
            payWayItem.mLogData = carPayInfoModel.mLogData.toString();
        }
        if (!TextUtils.isEmpty(carPayInfoModel.payExtraInfo)) {
            try {
                JSONObject jSONObject = new JSONObject(carPayInfoModel.payExtraInfo);
                payWayItem.channelTip = jSONObject.optString("channel_tip");
                payWayItem.guidePageH5 = jSONObject.optString("guide_page_h5");
                payWayItem.balance = jSONObject.optString("balance");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (carPayInfoModel.payExtraItemInfos != null) {
            payWayItem.extroInfoItemList = new ArrayList();
            for (CarPayExtraItemInfo next : carPayInfoModel.payExtraItemInfos) {
                PayWayModel.ExtroInfoItem extroInfoItem = new PayWayModel.ExtroInfoItem();
                extroInfoItem.cardDesc = next.cardStatusDesc;
                extroInfoItem.cardIndex = next.cardIndex;
                extroInfoItem.cardOrg = next.carOrg;
                extroInfoItem.cardStatus = next.cardStatus;
                extroInfoItem.cardSuffix = next.cardSuffix;
                extroInfoItem.cardSuffixInSelectPage = next.cardSuffixInSelectPage;
                extroInfoItem.expired = next.cardExpried;
                extroInfoItem.expiredDesc = next.expiredDesc;
                extroInfoItem.discountMsg = next.discountMsg;
                extroInfoItem.cardDiscountTags = next.cardDiscountTags;
                extroInfoItem.mostFavorableTxt = next.mostFavorableTxt;
                if (next.mLogData != null) {
                    extroInfoItem.mLogData = next.mLogData.toString();
                }
                payWayItem.extroInfoItemList.add(extroInfoItem);
            }
        }
        return payWayItem;
    }

    /* renamed from: a */
    private void m8853a(EstimateItemModel estimateItemModel, int i) {
        CarSeatChoiceModel carSeatChoiceModel;
        if (estimateItemModel != null && estimateItemModel.carBreakModel != null && estimateItemModel.carBreakModel.carBreakSeat != null && CollectionUtils.isNotEmpty((Collection<?>) estimateItemModel.carBreakModel.carBreakSeat.seatBreakChoice) && (carSeatChoiceModel = estimateItemModel.carBreakModel.carBreakSeat.seatBreakChoice.get(i)) != null && carSeatChoiceModel.getselectValue() != null) {
            estimateItemModel.setSelectedValueParams(carSeatChoiceModel.getselectValue(), carSeatChoiceModel.selectValueObject);
            estimateItemModel.setSelectPos(i);
            FormStore.getInstance().setCurrentComboType(carSeatChoiceModel.getselectValue().comboType);
            FormStore.getInstance().setCarpoolOrderScene(carSeatChoiceModel.getselectValue().carpoolOrderScene);
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setEstimateOperation(com.didi.travel.psnger.model.response.estimate.EstimateItemModel r8, com.didi.travel.psnger.model.response.estimate.EstimateItemModel r9) {
        /*
            r7 = this;
            java.util.List<com.didi.travel.psnger.model.response.estimate.CarOperationModel> r0 = r8.carOperation
            if (r0 == 0) goto L_0x01b0
            java.util.List<com.didi.travel.psnger.model.response.estimate.CarOperationModel> r0 = r8.carOperation
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x01b0
            java.util.List<com.didi.travel.psnger.model.response.estimate.CarOperationModel> r0 = r8.carOperation
            java.util.Iterator r0 = r0.iterator()
        L_0x0012:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x01b0
            java.lang.Object r1 = r0.next()
            com.didi.travel.psnger.model.response.estimate.CarOperationModel r1 = (com.didi.travel.psnger.model.response.estimate.CarOperationModel) r1
            com.google.gson.JsonObject r2 = r1.xmlData
            java.lang.String r3 = "6"
            if (r2 == 0) goto L_0x002c
            java.lang.String r2 = r1.operationType
            boolean r2 = r3.equals(r2)
            if (r2 != 0) goto L_0x005e
        L_0x002c:
            com.didi.travel.psnger.model.response.estimate.CarOperationDataModel r2 = r1.operationData
            if (r2 == 0) goto L_0x01ab
            java.lang.String r2 = r1.operationType
            if (r2 == 0) goto L_0x01ab
            com.didi.travel.psnger.model.response.estimate.CarOperationDataModel r2 = r1.operationData
            com.didi.travel.psnger.model.response.GlobalRichInfo r2 = r2.operationText
            if (r2 == 0) goto L_0x0048
            com.didi.travel.psnger.model.response.estimate.CarOperationDataModel r2 = r1.operationData
            com.didi.travel.psnger.model.response.GlobalRichInfo r2 = r2.operationText
            java.lang.String r2 = r2.getContent()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x005e
        L_0x0048:
            com.didi.travel.psnger.model.response.estimate.CarOperationDataModel r2 = r1.operationData
            com.didi.global.globaluikit.richinfo.LEGORichInfo r2 = r2.operationTextV2
            if (r2 == 0) goto L_0x01ab
            com.didi.travel.psnger.model.response.estimate.CarOperationDataModel r2 = r1.operationData
            com.didi.global.globaluikit.richinfo.LEGORichInfo r2 = r2.operationTextV2
            java.lang.String r2 = r2.getContent()
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x005e
            goto L_0x01ab
        L_0x005e:
            java.lang.String r2 = r1.operationType
            int r4 = r2.hashCode()
            r5 = -1
            r6 = 1
            switch(r4) {
                case 48: goto L_0x00a4;
                case 49: goto L_0x009a;
                case 50: goto L_0x0090;
                case 51: goto L_0x0086;
                case 52: goto L_0x007c;
                case 53: goto L_0x0072;
                case 54: goto L_0x006a;
                default: goto L_0x0069;
            }
        L_0x0069:
            goto L_0x00ae
        L_0x006a:
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00ae
            r2 = 6
            goto L_0x00af
        L_0x0072:
            java.lang.String r3 = "5"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00ae
            r2 = 5
            goto L_0x00af
        L_0x007c:
            java.lang.String r3 = "4"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00ae
            r2 = 4
            goto L_0x00af
        L_0x0086:
            java.lang.String r3 = "3"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00ae
            r2 = 3
            goto L_0x00af
        L_0x0090:
            java.lang.String r3 = "2"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00ae
            r2 = 1
            goto L_0x00af
        L_0x009a:
            java.lang.String r3 = "1"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00ae
            r2 = 0
            goto L_0x00af
        L_0x00a4:
            java.lang.String r3 = "0"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00ae
            r2 = 2
            goto L_0x00af
        L_0x00ae:
            r2 = -1
        L_0x00af:
            switch(r2) {
                case 0: goto L_0x0182;
                case 1: goto L_0x0159;
                case 2: goto L_0x0130;
                case 3: goto L_0x0111;
                case 4: goto L_0x00f2;
                case 5: goto L_0x00d3;
                case 6: goto L_0x00b4;
                default: goto L_0x00b2;
            }
        L_0x00b2:
            goto L_0x0012
        L_0x00b4:
            if (r9 == 0) goto L_0x00c4
            com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration r2 = r9.xml
            if (r2 == 0) goto L_0x00c4
            int r2 = r1.carOperationCache
            if (r2 == r5) goto L_0x00bf
            goto L_0x00c4
        L_0x00bf:
            com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration r2 = r9.xml
            r8.xml = r2
            goto L_0x00cb
        L_0x00c4:
            com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration r2 = new com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration
            r2.<init>()
            r8.xml = r2
        L_0x00cb:
            com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration r2 = r8.xml
            com.didi.travel.psnger.model.response.estimate.CarOperationDataModel r1 = r1.operationData
            r2.operationData = r1
            goto L_0x0012
        L_0x00d3:
            if (r9 == 0) goto L_0x00e3
            com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration r2 = r9.estimatePass
            if (r2 == 0) goto L_0x00e3
            int r2 = r1.carOperationCache
            if (r2 == r5) goto L_0x00de
            goto L_0x00e3
        L_0x00de:
            com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration r2 = r9.estimatePass
            r8.estimatePass = r2
            goto L_0x00ea
        L_0x00e3:
            com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration r2 = new com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration
            r2.<init>()
            r8.estimatePass = r2
        L_0x00ea:
            com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration r2 = r8.estimatePass
            com.didi.travel.psnger.model.response.estimate.CarOperationDataModel r1 = r1.operationData
            r2.operationData = r1
            goto L_0x0012
        L_0x00f2:
            if (r9 == 0) goto L_0x0102
            com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration r2 = r9.memberpoint
            if (r2 == 0) goto L_0x0102
            int r2 = r1.carOperationCache
            if (r2 == r6) goto L_0x00fd
            goto L_0x0102
        L_0x00fd:
            com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration r2 = r9.memberpoint
            r8.memberpoint = r2
            goto L_0x0109
        L_0x0102:
            com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration r2 = new com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration
            r2.<init>()
            r8.memberpoint = r2
        L_0x0109:
            com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration r2 = r8.memberpoint
            com.didi.travel.psnger.model.response.estimate.CarOperationDataModel r1 = r1.operationData
            r2.operationData = r1
            goto L_0x0012
        L_0x0111:
            if (r9 == 0) goto L_0x0121
            com.didi.travel.psnger.model.response.estimate.NewEsimateCompanyOperation r2 = r9.company
            if (r2 == 0) goto L_0x0121
            int r2 = r1.carOperationCache
            if (r2 == r6) goto L_0x011c
            goto L_0x0121
        L_0x011c:
            com.didi.travel.psnger.model.response.estimate.NewEsimateCompanyOperation r2 = r9.company
            r8.company = r2
            goto L_0x0128
        L_0x0121:
            com.didi.travel.psnger.model.response.estimate.NewEsimateCompanyOperation r2 = new com.didi.travel.psnger.model.response.estimate.NewEsimateCompanyOperation
            r2.<init>()
            r8.company = r2
        L_0x0128:
            com.didi.travel.psnger.model.response.estimate.NewEsimateCompanyOperation r2 = r8.company
            com.didi.travel.psnger.model.response.estimate.CarOperationDataModel r1 = r1.operationData
            r2.operationData = r1
            goto L_0x0012
        L_0x0130:
            if (r9 == 0) goto L_0x014a
            com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration r2 = r9.twoPriceChoice
            if (r2 == 0) goto L_0x014a
            com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration r2 = r9.twoPriceChoice
            java.lang.String r2 = r2.selectedValue
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x014a
            int r2 = r1.carOperationCache
            if (r2 == r6) goto L_0x0145
            goto L_0x014a
        L_0x0145:
            com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration r2 = r9.twoPriceChoice
            r8.twoPriceChoice = r2
            goto L_0x0151
        L_0x014a:
            com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration r2 = new com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration
            r2.<init>()
            r8.twoPriceChoice = r2
        L_0x0151:
            com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration r2 = r8.twoPriceChoice
            com.didi.travel.psnger.model.response.estimate.CarOperationDataModel r1 = r1.operationData
            r2.operationData = r1
            goto L_0x0012
        L_0x0159:
            if (r9 == 0) goto L_0x0173
            com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration r2 = r9.extraChoice
            if (r2 == 0) goto L_0x0173
            com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration r2 = r9.extraChoice
            java.lang.String r2 = r2.selectedValue
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x0173
            int r2 = r1.carOperationCache
            if (r2 == r6) goto L_0x016e
            goto L_0x0173
        L_0x016e:
            com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration r2 = r9.extraChoice
            r8.extraChoice = r2
            goto L_0x017a
        L_0x0173:
            com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration r2 = new com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration
            r2.<init>()
            r8.extraChoice = r2
        L_0x017a:
            com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration r2 = r8.extraChoice
            com.didi.travel.psnger.model.response.estimate.CarOperationDataModel r1 = r1.operationData
            r2.operationData = r1
            goto L_0x0012
        L_0x0182:
            if (r9 == 0) goto L_0x019c
            com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration r2 = r9.dispatchFeeChoice
            if (r2 == 0) goto L_0x019c
            com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration r2 = r9.dispatchFeeChoice
            java.lang.String r2 = r2.selectedValue
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x019c
            int r2 = r1.carOperationCache
            if (r2 == r6) goto L_0x0197
            goto L_0x019c
        L_0x0197:
            com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration r2 = r9.dispatchFeeChoice
            r8.dispatchFeeChoice = r2
            goto L_0x01a3
        L_0x019c:
            com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration r2 = new com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration
            r2.<init>()
            r8.dispatchFeeChoice = r2
        L_0x01a3:
            com.didi.travel.psnger.model.response.estimate.NewEstimateChoosedOpration r2 = r8.dispatchFeeChoice
            com.didi.travel.psnger.model.response.estimate.CarOperationDataModel r1 = r1.operationData
            r2.operationData = r1
            goto L_0x0012
        L_0x01ab:
            java.util.List<com.didi.travel.psnger.model.response.estimate.CarOperationModel> r8 = r8.carOperation
            r8.remove(r1)
        L_0x01b0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.estimate.newui.presenter.NewEstimatePresenter.setEstimateOperation(com.didi.travel.psnger.model.response.estimate.EstimateItemModel, com.didi.travel.psnger.model.response.estimate.EstimateItemModel):void");
    }

    public EstimateItemModel findEstimateModel(EstimateItemModel estimateItemModel) {
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        if (newEstimateItem == null || !estimateItemModel.carConfig.uniqueId.equals(newEstimateItem.carConfig.uniqueId)) {
            return null;
        }
        return newEstimateItem;
    }

    public List<CarDetailInfoListModel> collectDetailList() {
        ArrayList arrayList = new ArrayList();
        for (EstimateItemModel next : this.recommendsList) {
            if (CollectionUtils.isNotEmpty((Collection<?>) next.carDetail)) {
                arrayList.addAll(next.carDetail);
            }
        }
        ArrayList<EstimateItemModel> arrayList2 = new ArrayList<>(this.expandList);
        arrayList2.removeAll(this.recommendsList);
        for (EstimateItemModel estimateItemModel : arrayList2) {
            if (CollectionUtils.isNotEmpty((Collection<?>) estimateItemModel.carDetail)) {
                arrayList.addAll(estimateItemModel.carDetail);
            }
        }
        return arrayList;
    }

    public void handleEstimateList(List<EstimateGroupModel> list, boolean z) {
        m8855b(z);
        collectRecommends(z);
    }

    public List<EstimateItemModel> updateRecommendsByModel(EstimateItemModel estimateItemModel, boolean z) {
        if (estimateItemModel == null) {
            return this.recommendsList;
        }
        EstimateItemModel estimateItemModel2 = this.f13031b;
        if (estimateItemModel2 != null) {
            this.lastSelectModel = estimateItemModel2;
            estimateItemModel2.isSelected = false;
        }
        this.f13031b = estimateItemModel;
        estimateItemModel.isSelected = true;
        if (z) {
            updateRecHead(this.f13031b);
        }
        EstimatePresenter estimatePresenter2 = this.estimatePresenter;
        if (estimatePresenter2 != null) {
            estimatePresenter2.updateSelectModel(this.f13031b, false);
            this.estimatePresenter.bubbleSelectUpload(this.f13031b);
        }
        return this.recommendsList;
    }

    public void updateRecHead(EstimateItemModel estimateItemModel) {
        this.recommendsList.clear();
        this.recommendsList.addAll(this.f13030a);
        if (this.recommendsList.size() > 0) {
            for (int i = 0; i < this.recommendsList.size(); i++) {
                if (estimateItemModel.carConfig.uniqueId.equals(this.recommendsList.get(i).carConfig.uniqueId)) {
                    this.recommendsList.remove(i);
                    this.recommendsList.add(0, estimateItemModel);
                    return;
                }
            }
            this.recommendsList.add(0, estimateItemModel);
            if (this.recommendsList.size() > this.recommendIds.size()) {
                List<EstimateItemModel> list = this.recommendsList;
                list.remove(list.size() - 1);
                return;
            }
            return;
        }
        this.recommendsList.add(estimateItemModel);
    }

    public List<EstimateItemModel> updateRecommendsByUid(String str, boolean z, boolean z2) {
        EstimateItemModel estimateItemByUid = getEstimateItemByUid(str, z);
        if (estimateItemByUid != null) {
            updateRecommendsByModel(estimateItemByUid, z2);
        }
        return this.recommendsList;
    }

    public EstimateItemModel getEstimateItemByUid(String str, boolean z) {
        for (EstimateItemModel next : this.expandList) {
            if (next.carConfig != null && next.carConfig.uniqueId != null && !next.carConfig.uniqueId.isEmpty() && next.carConfig.uniqueId.equals(str)) {
                if (next.twoPriceChoice != null) {
                    next.twoPriceChoice.selectedValue = z ? "1" : "0";
                }
                return next;
            }
        }
        return null;
    }

    public void setView(IV2EstimateView iV2EstimateView) {
        this.mView = iV2EstimateView;
    }

    public EstimateItemModel getSelectModel() {
        return this.f13031b;
    }

    public EstimateItemModel getLastSelectedItemModel() {
        return this.lastSelectModel;
    }

    public List<EstimateItemModel> getAllModels() {
        return this.expandList;
    }

    public void setOneCarItemHeight(Context context, int i, boolean z) {
        int i2;
        Logger logger = this.mLogger;
        logger.info("itemHeight: " + i, new Object[0]);
        if (!z) {
            i2 = 0;
        } else if (this.mView.getMessageViewHeight() == 0) {
            i2 = UiUtils.dip2px(context, 63.0f);
            Logger logger2 = this.mLogger;
            logger2.info("itemHeight: 0 " + i2, new Object[0]);
        } else {
            i2 = this.mView.getMessageViewHeight();
            Logger logger3 = this.mLogger;
            logger3.info("itemHeight: msgh  " + i2, new Object[0]);
        }
        if (FormStore.getInstance().ismGroupFormViewChanged()) {
            i += UiUtils.dip2px(context, 15.0f);
        }
        updateEstimateHeight(i + i2, false);
        scrollEstimateViewBottom();
    }

    public void setRecommendItemHeight(int i, boolean z, boolean z2) {
        this.mRecommendsItemHeight = i;
        updateEstimateHeight(i + (z ? this.mView.getMessageViewHeight() : 0), z2);
    }

    public void setAbnormalViewHeight(int i) {
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Confirm.EVENT_VERTICAL_DATA_UPDATE, new VerticalDataUpdateEvent(i, 0, true, false));
    }

    public void updateEstimateHeight(int i, boolean z) {
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Confirm.EVENT_VERTICAL_DATA_UPDATE, new VerticalDataUpdateEvent(i, NewVerticalEstimateView.CardHeightConstant.BOTTOM_CONFIRM_LAYOUT_HEIGHT, true, z));
    }

    public void scrollEstimateViewBottom() {
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Confirm.EVENT_NEW_VERTICAL_SCROLL_BOTTOM);
    }

    public void scrollEstimateViewTop() {
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Confirm.EVENT_NEW_VERTICAL_SCROLL_TOP);
    }

    public void setScrollToTop() {
        this.mView.setScrollToTop();
    }

    public void setScrollToBottom() {
        this.mView.setScrollToBottom();
    }

    public void hideMessageView() {
        this.mView.hideMessageView();
    }

    public void hideBottomBar() {
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Confirm.EVENT_NEW_VERTICAL_HIDE_BOTTOM);
    }
}
