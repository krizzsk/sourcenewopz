package com.didi.soda.bill.model;

import com.didi.soda.bill.model.ComponentModel;
import com.didi.soda.bill.model.datamodel.AddressModel;
import com.didi.soda.bill.model.datamodel.BillItemsInfoModel;
import com.didi.soda.bill.model.datamodel.BillLineModel;
import com.didi.soda.bill.model.datamodel.BillTipModel;
import com.didi.soda.bill.model.datamodel.BottomTipInfoModel;
import com.didi.soda.bill.model.datamodel.CetaInfoModel;
import com.didi.soda.bill.model.datamodel.CouponInfoModel;
import com.didi.soda.bill.model.datamodel.CutleryModel;
import com.didi.soda.bill.model.datamodel.DeliveryModel;
import com.didi.soda.bill.model.datamodel.FollowModel;
import com.didi.soda.bill.model.datamodel.OutOfStockModel;
import com.didi.soda.bill.model.datamodel.PayChannelModel;
import com.didi.soda.bill.model.datamodel.PriceInfoModel;
import com.didi.soda.bill.model.datamodel.RemarkInfoModel;
import com.didi.soda.bill.model.datamodel.ReminderModel;
import com.didi.soda.bill.model.datamodel.TitleInfoModel;
import com.didi.soda.cart.model.CartTyingModel;
import com.didi.soda.customer.foundation.rpc.entity.FollowingInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.CetaEntity;
import com.didi.soda.customer.foundation.rpc.entity.address.DeliveryMethodEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillCartItemsInfo;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillComponentDataEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillComponentEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillLineInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillSection;
import com.didi.soda.customer.foundation.rpc.entity.bill.CutleryEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.IsValidationEntity;
import com.didi.soda.customer.foundation.rpc.entity.bill.PriceInfo;
import com.didi.soda.customer.foundation.rpc.entity.bill.ReminderInfo;
import com.didi.soda.customer.foundation.rpc.entity.bill.ShopInfo;
import com.didi.soda.customer.foundation.rpc.entity.bill.TitleInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.AbnormalItemInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.BottomTipInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.CouponInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.RemarkInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.TipFeeInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.TyingItems;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bJ0\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u000b0\nj\b\u0012\u0004\u0012\u00020\u000b`\f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e¨\u0006\u0011"}, mo175978d2 = {"Lcom/didi/soda/bill/model/BillDataFactoryV2;", "", "()V", "createComponentDataModel", "Lcom/didi/soda/bill/model/ComponentDataModel;", "componentData", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillComponentDataEntity;", "billInfoEntity", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillInfoEntity;", "createSectionModels", "Ljava/util/ArrayList;", "Lcom/didi/soda/bill/model/SectionModel;", "Lkotlin/collections/ArrayList;", "sourcePage", "", "source", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillDataFactoryV2.kt */
public final class BillDataFactoryV2 {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final BillDataFactoryV2 f39023a = new BillDataFactoryV2();

    public static /* synthetic */ ArrayList createSectionModels$default(BillDataFactoryV2 billDataFactoryV2, BillInfoEntity billInfoEntity, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return billDataFactoryV2.createSectionModels(billInfoEntity, i, i2);
    }

    public final ArrayList<SectionModel> createSectionModels(BillInfoEntity billInfoEntity, int i, int i2) {
        ComponentDataModel data;
        BillLineModel lineModel;
        BillLineInfoEntity lineInfo;
        BillInfoEntity billInfoEntity2 = billInfoEntity;
        Intrinsics.checkNotNullParameter(billInfoEntity2, "billInfoEntity");
        ArrayList<SectionModel> arrayList = new ArrayList<>();
        List<BillSection> sections = billInfoEntity.getSections();
        Intrinsics.checkNotNull(sections);
        int i3 = 0;
        for (BillSection components : sections) {
            int i4 = i3 + 1;
            SectionModel sectionModel = new SectionModel();
            ArrayList<BillComponentEntity> components2 = components.getComponents();
            Intrinsics.checkNotNull(components2);
            Iterator<BillComponentEntity> it = components2.iterator();
            ComponentModel componentModel = null;
            while (it.hasNext()) {
                BillComponentEntity next = it.next();
                ComponentModel.Companion companion = ComponentModel.Companion;
                Intrinsics.checkNotNullExpressionValue(next, "componentItem");
                ComponentModel convertV2 = companion.convertV2(next, billInfoEntity2, i3, i2);
                ShopInfo shopInfo = billInfoEntity.getShopInfo();
                convertV2.setShopId(shopInfo == null ? null : shopInfo.getShopId());
                ShopInfo shopInfo2 = billInfoEntity.getShopInfo();
                convertV2.setShopStatus(shopInfo2 == null ? null : Integer.valueOf(shopInfo2.getCShopStatus()));
                convertV2.setCartId(billInfoEntity.getCartId());
                convertV2.setAfterFavPrice(billInfoEntity.getAfterFavPrice());
                convertV2.setCurrency(billInfoEntity.getCurrency());
                convertV2.setSourcePage(i);
                convertV2.setAddressRecStrategy(billInfoEntity.getAddressRecStrategy());
                IsValidationEntity isValidation = billInfoEntity.isValidation();
                convertV2.setCheckNameEmpty(!(isValidation != null && isValidation.getFullNameSwitch() == 0));
                sectionModel.getComponents().add(convertV2);
                BillComponentDataEntity data2 = next.getData();
                if (!(data2 == null || (lineInfo = data2.getLineInfo()) == null || componentModel == null)) {
                    componentModel.setBottomExtraPadding(lineInfo.getUpGap());
                }
                if (!(componentModel == null || (data = componentModel.getData()) == null || (lineModel = data.getLineModel()) == null)) {
                    convertV2.setTopExtraPadding(lineModel.getDownGap());
                }
                componentModel = convertV2;
            }
            int i5 = i;
            int i6 = i2;
            arrayList.add(sectionModel);
            i3 = i4;
        }
        return arrayList;
    }

    public final ComponentDataModel createComponentDataModel(BillComponentDataEntity billComponentDataEntity, BillInfoEntity billInfoEntity) {
        PriceInfo priceInfo;
        ReminderInfo reminderInfo;
        ArrayList<DeliveryMethodEntity> arrayList;
        FollowingInfoEntity followingInfoEntity;
        CouponInfoEntity couponInfoEntity;
        PayChannelEntity payChannelEntity;
        BillCartItemsInfo billCartItemsInfo;
        TipFeeInfoEntity tipFeeInfoEntity;
        RemarkInfoEntity remarkInfoEntity;
        AbnormalItemInfoEntity abnormalItemInfoEntity;
        BottomTipInfoEntity bottomTipInfoEntity;
        CetaEntity cetaEntity;
        CutleryEntity cutleryEntity;
        BillLineInfoEntity billLineInfoEntity;
        TitleInfoEntity titleInfoEntity;
        Intrinsics.checkNotNullParameter(billInfoEntity, "billInfoEntity");
        ComponentDataModel componentDataModel = new ComponentDataModel();
        AddressModel addressModel = new AddressModel();
        if (billComponentDataEntity != null) {
            addressModel.convertModel(billComponentDataEntity);
        }
        Unit unit = Unit.INSTANCE;
        componentDataModel.setAddressModel(addressModel);
        TyingItems tyingItems = null;
        if (billComponentDataEntity == null) {
            priceInfo = null;
        } else {
            priceInfo = billComponentDataEntity.getPriceInfo();
        }
        if (priceInfo != null) {
            componentDataModel.setPriceInfoModel(new PriceInfoModel().convertModel(billComponentDataEntity));
        }
        if (billComponentDataEntity == null) {
            reminderInfo = null;
        } else {
            reminderInfo = billComponentDataEntity.getReminderInfo();
        }
        if (reminderInfo != null) {
            componentDataModel.setReminderModel(new ReminderModel().convertModel(billComponentDataEntity));
        }
        if (billComponentDataEntity == null) {
            arrayList = null;
        } else {
            arrayList = billComponentDataEntity.getDeliveryMethods();
        }
        if (arrayList != null) {
            componentDataModel.setDeliveryModel(new DeliveryModel().convertModel(billComponentDataEntity));
        }
        if (billComponentDataEntity == null) {
            followingInfoEntity = null;
        } else {
            followingInfoEntity = billComponentDataEntity.getFollowingInfo();
        }
        if (followingInfoEntity != null) {
            componentDataModel.setFollowModel(new FollowModel().convertModelV2(billComponentDataEntity));
        }
        if (billComponentDataEntity == null) {
            couponInfoEntity = null;
        } else {
            couponInfoEntity = billComponentDataEntity.getCouponInfo();
        }
        if (couponInfoEntity != null) {
            componentDataModel.setCouponInfoModel(new CouponInfoModel().convertModel(billComponentDataEntity));
        }
        if (billComponentDataEntity == null) {
            payChannelEntity = null;
        } else {
            payChannelEntity = billComponentDataEntity.getPayChannel();
        }
        if (payChannelEntity != null) {
            componentDataModel.setPayChannelModel(new PayChannelModel().convertModel(billComponentDataEntity));
        }
        if (billComponentDataEntity == null) {
            billCartItemsInfo = null;
        } else {
            billCartItemsInfo = billComponentDataEntity.getItemsInfo();
        }
        if (billCartItemsInfo != null) {
            componentDataModel.setItemsInfoModel(new BillItemsInfoModel().convertModel(billComponentDataEntity));
        }
        if (billComponentDataEntity == null) {
            tipFeeInfoEntity = null;
        } else {
            tipFeeInfoEntity = billComponentDataEntity.getTipFeeInfo();
        }
        if (tipFeeInfoEntity != null) {
            componentDataModel.setTipModel(new BillTipModel().convertModelV2(billComponentDataEntity));
        }
        if (billComponentDataEntity == null) {
            remarkInfoEntity = null;
        } else {
            remarkInfoEntity = billComponentDataEntity.getRemarkInfo();
        }
        if (remarkInfoEntity != null) {
            componentDataModel.setRemarkModel(new RemarkInfoModel().convertModel(billComponentDataEntity));
        }
        if (billComponentDataEntity == null) {
            abnormalItemInfoEntity = null;
        } else {
            abnormalItemInfoEntity = billComponentDataEntity.getAbnormalItemInfo();
        }
        if (abnormalItemInfoEntity != null) {
            componentDataModel.setOutOfStockModel(new OutOfStockModel().convertModel(billComponentDataEntity));
        }
        if (billComponentDataEntity == null) {
            bottomTipInfoEntity = null;
        } else {
            bottomTipInfoEntity = billComponentDataEntity.getBottomTipInfo();
        }
        if (bottomTipInfoEntity != null) {
            componentDataModel.setBottomTipInfoModel(new BottomTipInfoModel().convertModel(billComponentDataEntity));
        }
        if (billComponentDataEntity == null) {
            cetaEntity = null;
        } else {
            cetaEntity = billComponentDataEntity.getCetaInfo();
        }
        if (cetaEntity != null) {
            componentDataModel.setCetaInfoModel(new CetaInfoModel().convertModel(billComponentDataEntity));
        }
        if (billComponentDataEntity == null) {
            cutleryEntity = null;
        } else {
            cutleryEntity = billComponentDataEntity.getCutlery();
        }
        if (cutleryEntity != null) {
            componentDataModel.setCutleryModel(new CutleryModel().convertModel(billComponentDataEntity));
        }
        if (billComponentDataEntity == null) {
            billLineInfoEntity = null;
        } else {
            billLineInfoEntity = billComponentDataEntity.getLineInfo();
        }
        if (billLineInfoEntity != null) {
            componentDataModel.setLineModel(new BillLineModel().convertModel(billComponentDataEntity));
        }
        if (billComponentDataEntity == null) {
            titleInfoEntity = null;
        } else {
            titleInfoEntity = billComponentDataEntity.getTitleInfo();
        }
        if (titleInfoEntity != null) {
            componentDataModel.setTitleInfoModel(new TitleInfoModel().convertModel(billComponentDataEntity));
        }
        if (billComponentDataEntity != null) {
            tyingItems = billComponentDataEntity.getTyingItems();
        }
        if (tyingItems != null) {
            CartTyingModel.Companion companion = CartTyingModel.Companion;
            TyingItems tyingItems2 = billComponentDataEntity.getTyingItems();
            Intrinsics.checkNotNull(tyingItems2);
            ShopInfo shopInfo = billInfoEntity.getShopInfo();
            componentDataModel.setTyingItem(companion.convert(tyingItems2, shopInfo == null ? 1 : shopInfo.getCShopStatus(), billInfoEntity.getCartId()));
        }
        return componentDataModel;
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/soda/bill/model/BillDataFactoryV2$Companion;", "", "()V", "factory", "Lcom/didi/soda/bill/model/BillDataFactoryV2;", "getFactory", "()Lcom/didi/soda/bill/model/BillDataFactoryV2;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BillDataFactoryV2.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final BillDataFactoryV2 getFactory() {
            return BillDataFactoryV2.f39023a;
        }
    }
}
