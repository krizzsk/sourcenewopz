package com.didi.soda.bill.view.item.logic;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.bill.BillOmegaHelper;
import com.didi.soda.bill.model.ComponentDataModel;
import com.didi.soda.bill.model.ComponentModel;
import com.didi.soda.bill.model.datamodel.CutleryModel;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.foundation.rpc.entity.bill.CutleryEntity;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerBillManager;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.Request;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J)\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0002\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002JN\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152#\u0010\u0016\u001a\u001f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0017H\u0016¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/soda/bill/view/item/logic/ItemViewCommonLogicV2;", "Lcom/didi/soda/bill/view/item/logic/ItemViewCommonLogic;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "(Lcom/didi/app/nova/skeleton/ScopeContext;)V", "goToEditAddress", "", "componentModel", "Lcom/didi/soda/bill/model/ComponentModel;", "fromType", "", "msg", "", "(Lcom/didi/soda/bill/model/ComponentModel;Ljava/lang/Integer;Ljava/lang/String;)V", "goToEditRemarkPage", "model", "goToOutOfStockPage", "gotoCouponPage", "gotoPayChannelPage", "onItemClick", "bundle", "Landroid/os/Bundle;", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "(Lcom/didi/soda/bill/model/ComponentModel;Ljava/lang/Integer;Landroid/os/Bundle;Lkotlin/jvm/functions/Function1;)V", "updateCutlery", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ItemViewCommonLogicV2.kt */
public final class ItemViewCommonLogicV2 extends ItemViewCommonLogic {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ItemViewCommonLogicV2(ScopeContext scopeContext) {
        super(scopeContext);
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
    }

    /* JADX WARNING: type inference failed for: r2v8, types: [com.didi.soda.bill.model.datamodel.BillTipModel] */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003c, code lost:
        r0 = r0.getTipModel();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onItemClick(com.didi.soda.bill.model.ComponentModel r6, java.lang.Integer r7, android.os.Bundle r8, kotlin.jvm.functions.Function1<? super com.didi.app.nova.skeleton.ScopeContext, kotlin.Unit> r9) {
        /*
            r5 = this;
            java.lang.String r0 = "componentModel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            int r0 = r6.getType()
            r1 = 10
            if (r0 == r1) goto L_0x014d
            int r0 = r6.getType()
            r1 = 9
            if (r0 == r1) goto L_0x014d
            int r0 = r6.getType()
            r1 = 15
            if (r0 != r1) goto L_0x001f
            goto L_0x014d
        L_0x001f:
            int r0 = r6.getType()
            r1 = 7
            r2 = 0
            java.lang.String r3 = ""
            r4 = 0
            if (r0 != r1) goto L_0x00b1
            com.didi.soda.bill.BillOmegaHelper$Companion r7 = com.didi.soda.bill.BillOmegaHelper.Companion
            java.lang.String r8 = r6.getCartId()
            java.lang.String r9 = r6.getShopId()
            com.didi.soda.bill.model.ComponentDataModel r0 = r6.getData()
            if (r0 != 0) goto L_0x003c
        L_0x003a:
            r1 = 0
            goto L_0x0048
        L_0x003c:
            com.didi.soda.bill.model.datamodel.BillTipModel r0 = r0.getTipModel()
            if (r0 != 0) goto L_0x0043
            goto L_0x003a
        L_0x0043:
            long r0 = r0.getTipFeeValue()
            int r1 = (int) r0
        L_0x0048:
            com.didi.soda.bill.model.ComponentDataModel r0 = r6.getData()
            if (r0 != 0) goto L_0x004f
            goto L_0x005a
        L_0x004f:
            com.didi.soda.bill.model.datamodel.BillTipModel r0 = r0.getTipModel()
            if (r0 != 0) goto L_0x0056
            goto L_0x005a
        L_0x0056:
            int r4 = r0.getTipFeeType()
        L_0x005a:
            r7.trackTipsClick(r8, r9, r1, r4)
            com.didi.soda.router.Request$Builder r7 = com.didi.soda.router.DiRouter.request()
            java.lang.String r8 = "billTipPage"
            com.didi.soda.router.Request$Builder r7 = r7.path(r8)
            com.didi.soda.bill.model.ComponentDataModel r8 = r6.getData()
            if (r8 != 0) goto L_0x006e
            goto L_0x0072
        L_0x006e:
            com.didi.soda.bill.model.datamodel.BillTipModel r2 = r8.getTipModel()
        L_0x0072:
            java.io.Serializable r2 = (java.io.Serializable) r2
            java.lang.String r8 = "tip_info"
            com.didi.soda.router.Request$Builder r7 = r7.putSerializable(r8, r2)
            java.lang.String r8 = r6.getCurrency()
            java.lang.String r9 = "currency"
            com.didi.soda.router.Request$Builder r7 = r7.putString(r9, r8)
            int r8 = r6.getAfterFavPrice()
            java.lang.String r9 = "price"
            com.didi.soda.router.Request$Builder r7 = r7.putInt(r9, r8)
            java.lang.String r8 = r6.getCartId()
            if (r8 == 0) goto L_0x0097
            goto L_0x0098
        L_0x0097:
            r8 = r3
        L_0x0098:
            java.lang.String r9 = "cart_id"
            com.didi.soda.router.Request$Builder r7 = r7.putString(r9, r8)
            java.lang.String r6 = r6.getShopId()
            if (r6 == 0) goto L_0x00a5
            r3 = r6
        L_0x00a5:
            java.lang.String r6 = "shop_id"
            com.didi.soda.router.Request$Builder r6 = r7.putString(r6, r3)
            r6.open()
            goto L_0x0150
        L_0x00b1:
            int r0 = r6.getType()
            r1 = 8
            if (r0 != r1) goto L_0x0103
            com.didi.soda.bill.model.ComponentDataModel r7 = r6.getData()
            if (r7 != 0) goto L_0x00c0
            goto L_0x00cb
        L_0x00c0:
            com.didi.soda.bill.model.datamodel.RemarkInfoModel r7 = r7.getRemarkModel()
            if (r7 != 0) goto L_0x00c7
            goto L_0x00cb
        L_0x00c7:
            java.lang.String r2 = r7.getDisableRemark()
        L_0x00cb:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x00d5
            int r7 = r2.length()
            if (r7 != 0) goto L_0x00d6
        L_0x00d5:
            r4 = 1
        L_0x00d6:
            if (r4 != 0) goto L_0x00ff
            com.didi.soda.bill.model.ComponentDataModel r7 = r6.getData()
            if (r7 != 0) goto L_0x00df
            goto L_0x00ee
        L_0x00df:
            com.didi.soda.bill.model.datamodel.RemarkInfoModel r7 = r7.getRemarkModel()
            if (r7 != 0) goto L_0x00e6
            goto L_0x00ee
        L_0x00e6:
            java.lang.String r7 = r7.getDisableRemark()
            if (r7 != 0) goto L_0x00ed
            goto L_0x00ee
        L_0x00ed:
            r3 = r7
        L_0x00ee:
            r5.showToast(r3)
            com.didi.soda.bill.BillOmegaHelper$Companion r7 = com.didi.soda.bill.BillOmegaHelper.Companion
            java.lang.String r8 = r6.getCartId()
            java.lang.String r6 = r6.getShopId()
            r7.remarkDisableToastSw(r8, r6)
            goto L_0x0150
        L_0x00ff:
            r5.m27807d(r6)
            goto L_0x0150
        L_0x0103:
            int r0 = r6.getType()
            r1 = 13
            if (r0 != r1) goto L_0x010f
            r5.m27806c(r6)
            goto L_0x0150
        L_0x010f:
            int r0 = r6.getType()
            r1 = 21
            if (r0 != r1) goto L_0x011b
            r5.m27805b(r6)
            goto L_0x0150
        L_0x011b:
            int r0 = r6.getType()
            r1 = 22
            if (r0 != r1) goto L_0x012e
            if (r9 != 0) goto L_0x0126
            goto L_0x0150
        L_0x0126:
            com.didi.app.nova.skeleton.ScopeContext r6 = r5.getScopeContext()
            r9.invoke(r6)
            goto L_0x0150
        L_0x012e:
            int r9 = r6.getType()
            r0 = 2
            if (r9 != r0) goto L_0x0142
            if (r8 != 0) goto L_0x0138
            goto L_0x013e
        L_0x0138:
            java.lang.String r9 = "address_name_not_legal"
            java.lang.String r2 = r8.getString(r9)
        L_0x013e:
            r5.m27804a(r6, r7, r2)
            goto L_0x0150
        L_0x0142:
            int r7 = r6.getType()
            r8 = 4
            if (r7 != r8) goto L_0x0150
            r5.m27803a(r6)
            goto L_0x0150
        L_0x014d:
            r5.m27808e(r6)
        L_0x0150:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.bill.view.item.logic.ItemViewCommonLogicV2.onItemClick(com.didi.soda.bill.model.ComponentModel, java.lang.Integer, android.os.Bundle, kotlin.jvm.functions.Function1):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0019, code lost:
        r8 = r8.getPayChannelModel();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m27803a(com.didi.soda.bill.model.ComponentModel r8) {
        /*
            r7 = this;
            com.didi.app.nova.skeleton.ScopeContext r0 = r7.getScopeContext()
            java.lang.String r1 = r8.getShopId()
            java.lang.String r4 = r8.getCartId()
            int r5 = r8.getHintType()
            com.didi.soda.bill.model.ComponentDataModel r8 = r8.getData()
            r2 = 0
            if (r8 != 0) goto L_0x0019
        L_0x0017:
            r6 = r2
            goto L_0x0025
        L_0x0019:
            com.didi.soda.bill.model.datamodel.PayChannelModel r8 = r8.getPayChannelModel()
            if (r8 != 0) goto L_0x0020
            goto L_0x0017
        L_0x0020:
            com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity r8 = r8.getPayChannelEntity()
            r6 = r8
        L_0x0025:
            r2 = 0
            r3 = 0
            com.didi.soda.pay.PayMethodPage.toPayMethod(r0, r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.bill.view.item.logic.ItemViewCommonLogicV2.m27803a(com.didi.soda.bill.model.ComponentModel):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0064, code lost:
        if (r10.isCheckNameEmpty() != false) goto L_0x007d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00cc  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m27804a(com.didi.soda.bill.model.ComponentModel r10, java.lang.Integer r11, java.lang.String r12) {
        /*
            r9 = this;
            com.didi.soda.bill.model.ComponentDataModel r0 = r10.getData()
            if (r0 != 0) goto L_0x0008
            r0 = 0
            goto L_0x000c
        L_0x0008:
            com.didi.soda.bill.model.datamodel.AddressModel r0 = r0.getAddressModel()
        L_0x000c:
            if (r0 != 0) goto L_0x000f
            return
        L_0x000f:
            int r1 = r10.getAddressRecStrategy()
            r2 = 1
            r0.setAddressClicked(r2)
            com.didi.soda.bill.BillOmegaHelper$Companion r3 = com.didi.soda.bill.BillOmegaHelper.Companion
            java.lang.String r4 = r0.getAid()
            java.lang.String r5 = r10.getCartId()
            java.lang.String r6 = r10.getShopId()
            java.lang.String r7 = r0.getBuildingName()
            java.lang.String r8 = r0.getHouseNumber()
            r3.trackAddressCK(r4, r5, r6, r7, r8)
            r3 = 6
            r4 = 0
            if (r11 != 0) goto L_0x0035
            goto L_0x003d
        L_0x0035:
            int r5 = r11.intValue()
            if (r5 != r2) goto L_0x003d
        L_0x003b:
            r5 = 0
            goto L_0x007d
        L_0x003d:
            r5 = 2
            if (r11 != 0) goto L_0x0041
            goto L_0x0049
        L_0x0041:
            int r6 = r11.intValue()
            if (r6 != r5) goto L_0x0049
            r3 = 7
            goto L_0x003b
        L_0x0049:
            r6 = 3
            if (r11 != 0) goto L_0x004d
            goto L_0x0056
        L_0x004d:
            int r7 = r11.intValue()
            if (r7 != r6) goto L_0x0056
            r3 = 8
            goto L_0x003b
        L_0x0056:
            r7 = 4
            if (r11 != 0) goto L_0x005a
            goto L_0x0067
        L_0x005a:
            int r8 = r11.intValue()
            if (r8 != r7) goto L_0x0067
            boolean r11 = r10.isCheckNameEmpty()
            if (r11 == 0) goto L_0x003b
            goto L_0x007d
        L_0x0067:
            r5 = 5
            if (r11 != 0) goto L_0x006b
            goto L_0x007b
        L_0x006b:
            int r11 = r11.intValue()
            if (r11 != r5) goto L_0x007b
            boolean r11 = r10.isCheckNameEmpty()
            if (r11 == 0) goto L_0x0078
            goto L_0x0079
        L_0x0078:
            r6 = 0
        L_0x0079:
            r5 = r6
            goto L_0x007d
        L_0x007b:
            r3 = 1
            goto L_0x003b
        L_0x007d:
            com.didi.soda.customer.foundation.rpc.entity.address.ContactEntity r11 = r0.getContactEntity()
            if (r11 != 0) goto L_0x0084
            goto L_0x0086
        L_0x0084:
            r11.nameErrorMsg = r12
        L_0x0086:
            com.didi.soda.router.Request$Builder r11 = com.didi.soda.router.DiRouter.request()
            java.lang.String r12 = "addressEdit"
            com.didi.soda.router.Request$Builder r11 = r11.path(r12)
            java.lang.String r12 = "address_strategy"
            com.didi.soda.router.Request$Builder r11 = r11.putInt(r12, r1)
            com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity r12 = r0.getAddressEntity()
            java.io.Serializable r12 = (java.io.Serializable) r12
            java.lang.String r6 = "address_entity"
            com.didi.soda.router.Request$Builder r11 = r11.putSerializable(r6, r12)
            com.didi.soda.customer.foundation.rpc.entity.address.ContactEntity r12 = r0.getContactEntity()
            java.io.Serializable r12 = (java.io.Serializable) r12
            java.lang.String r6 = "contact_entity"
            com.didi.soda.router.Request$Builder r11 = r11.putSerializable(r6, r12)
            com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity r12 = r0.getRecAddressEntity()
            java.io.Serializable r12 = (java.io.Serializable) r12
            java.lang.String r6 = "rec_address_entity"
            com.didi.soda.router.Request$Builder r11 = r11.putSerializable(r6, r12)
            java.lang.String r12 = r0.getAid()
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            if (r12 == 0) goto L_0x00cc
            int r12 = r12.length()
            if (r12 != 0) goto L_0x00ca
            goto L_0x00cc
        L_0x00ca:
            r12 = 0
            goto L_0x00cd
        L_0x00cc:
            r12 = 1
        L_0x00cd:
            if (r12 == 0) goto L_0x00d2
            if (r1 == 0) goto L_0x00d2
            goto L_0x00d3
        L_0x00d2:
            r2 = 0
        L_0x00d3:
            java.lang.String r12 = "is_show_bill_address_data"
            com.didi.soda.router.Request$Builder r11 = r11.putBoolean(r12, r2)
            java.lang.String r12 = r10.getShopId()
            java.lang.String r0 = "shopid"
            com.didi.soda.router.Request$Builder r11 = r11.putString(r0, r12)
            java.lang.String r12 = r10.getCartId()
            java.lang.String r0 = "cartid"
            com.didi.soda.router.Request$Builder r11 = r11.putString(r0, r12)
            boolean r10 = r10.isCheckNameEmpty()
            java.lang.String r12 = "name_complete_strategy"
            com.didi.soda.router.Request$Builder r10 = r11.putBoolean(r12, r10)
            java.lang.String r11 = "bill_address_page_scene"
            com.didi.soda.router.Request$Builder r10 = r10.putInt(r11, r5)
            java.lang.String r11 = "from"
            com.didi.soda.router.Request$Builder r10 = r10.putInt(r11, r3)
            r10.open()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.bill.view.item.logic.ItemViewCommonLogicV2.m27804a(com.didi.soda.bill.model.ComponentModel, java.lang.Integer, java.lang.String):void");
    }

    /* renamed from: b */
    private final void m27805b(ComponentModel componentModel) {
        CutleryModel cutleryModel;
        CutleryEntity cutleryEntity = new CutleryEntity();
        ComponentDataModel data = componentModel.getData();
        boolean z = false;
        if (!(data == null || (cutleryModel = data.getCutleryModel()) == null)) {
            z = cutleryModel.isNeeded();
        }
        cutleryEntity.isNeeded = z ^ true ? 1 : 0;
        ((ICustomerBillManager) CustomerManagerLoader.loadManager(ICustomerBillManager.class)).dispatchChange(cutleryEntity);
    }

    /* renamed from: c */
    private final void m27806c(ComponentModel componentModel) {
        Request.Builder path = DiRouter.request().path(RoutePath.BILL_OUT_OF_STOCK);
        String shopId = componentModel.getShopId();
        String str = "";
        if (shopId == null) {
            shopId = str;
        }
        Request.Builder putString = path.putString("current_shop_id", shopId);
        String cartId = componentModel.getCartId();
        if (cartId != null) {
            str = cartId;
        }
        Request.Builder putString2 = putString.putString("cart_id", str);
        ComponentDataModel data = componentModel.getData();
        putString2.putSerializable("out_of_stock_data", data == null ? null : data.getOutOfStockModel()).open();
        BillOmegaHelper.Companion.trackOutOfStockCk(componentModel);
    }

    /* renamed from: d */
    private final void m27807d(ComponentModel componentModel) {
        Request.Builder path = DiRouter.request().path(RoutePath.REMARK_EDIT);
        String shopId = componentModel.getShopId();
        String str = "";
        if (shopId == null) {
            shopId = str;
        }
        Request.Builder putString = path.putString("current_shop_id", shopId);
        String cartId = componentModel.getCartId();
        if (cartId != null) {
            str = cartId;
        }
        putString.putString("cart_id", str).putString("cart_note", componentModel.getContent()).open();
        BillOmegaHelper.Companion.trackCartRemarkCk(componentModel);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0009, code lost:
        r0 = r0.getCouponInfoModel();
     */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m27808e(com.didi.soda.bill.model.ComponentModel r13) {
        /*
            r12 = this;
            com.didi.soda.bill.model.ComponentDataModel r0 = r13.getData()
            r1 = 0
            if (r0 != 0) goto L_0x0009
        L_0x0007:
            r0 = r1
            goto L_0x0014
        L_0x0009:
            com.didi.soda.bill.model.datamodel.CouponInfoModel r0 = r0.getCouponInfoModel()
            if (r0 != 0) goto L_0x0010
            goto L_0x0007
        L_0x0010:
            java.lang.String r0 = r0.getCouponId()
        L_0x0014:
            com.didi.soda.bill.model.ComponentDataModel r2 = r13.getData()
            if (r2 != 0) goto L_0x001c
        L_0x001a:
            r4 = r1
            goto L_0x0028
        L_0x001c:
            com.didi.soda.bill.model.datamodel.CouponInfoModel r2 = r2.getCouponInfoModel()
            if (r2 != 0) goto L_0x0023
            goto L_0x001a
        L_0x0023:
            java.lang.String r2 = r2.getBatchId()
            r4 = r2
        L_0x0028:
            com.didi.soda.bill.model.ComponentDataModel r2 = r13.getData()
            if (r2 != 0) goto L_0x0030
        L_0x002e:
            r5 = r1
            goto L_0x003c
        L_0x0030:
            com.didi.soda.bill.model.datamodel.CouponInfoModel r2 = r2.getCouponInfoModel()
            if (r2 != 0) goto L_0x0037
            goto L_0x002e
        L_0x0037:
            java.lang.String r2 = r2.getActivityId()
            r5 = r2
        L_0x003c:
            com.didi.soda.bill.model.ComponentDataModel r2 = r13.getData()
            if (r2 != 0) goto L_0x0044
        L_0x0042:
            r6 = r1
            goto L_0x0054
        L_0x0044:
            com.didi.soda.bill.model.datamodel.PriceInfoModel r2 = r2.getPriceInfoModel()
            if (r2 != 0) goto L_0x004b
            goto L_0x0042
        L_0x004b:
            int r2 = r2.getPayPrice()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r6 = r2
        L_0x0054:
            int r2 = r13.getType()
            r3 = 9
            r10 = 15
            if (r2 == r3) goto L_0x0066
            if (r2 == r10) goto L_0x0063
            java.lang.String r2 = "0"
            goto L_0x0068
        L_0x0063:
            java.lang.String r2 = "101"
            goto L_0x0068
        L_0x0066:
            java.lang.String r2 = "1"
        L_0x0068:
            r11 = r2
            com.didi.soda.bill.BillOmegaHelper$Companion r2 = com.didi.soda.bill.BillOmegaHelper.Companion
            java.lang.String r7 = r13.getCartId()
            java.lang.String r8 = r13.getShopId()
            int r3 = r13.getType()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r3)
            r3 = r0
            r2.trackCouponCK(r3, r4, r5, r6, r7, r8, r9)
            java.lang.Class<com.didi.soda.manager.base.ICustomerAddressManager> r2 = com.didi.soda.manager.base.ICustomerAddressManager.class
            com.didi.soda.manager.base.ICustomerManager r2 = com.didi.soda.manager.CustomerManagerLoader.loadManager(r2)
            com.didi.soda.manager.base.ICustomerAddressManager r2 = (com.didi.soda.manager.base.ICustomerAddressManager) r2
            com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity r2 = r2.getDelieveryAddress()
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            if (r0 != 0) goto L_0x0093
            goto L_0x009c
        L_0x0093:
            r4 = r3
            java.util.Map r4 = (java.util.Map) r4
            java.lang.String r5 = "selected"
            r4.put(r5, r0)
        L_0x009c:
            r0 = r3
            java.util.Map r0 = (java.util.Map) r0
            java.lang.String r4 = r13.getCartId()
            java.lang.String r5 = "cart_id"
            r0.put(r5, r4)
            if (r2 != 0) goto L_0x00ab
            goto L_0x00af
        L_0x00ab:
            java.lang.String r1 = r2.getAid()
        L_0x00af:
            java.lang.String r2 = "aid"
            r0.put(r2, r1)
            java.lang.String r1 = "bill_coupon_type"
            r0.put(r1, r11)
            java.lang.String r1 = r13.getShopId()
            if (r1 == 0) goto L_0x00c0
            goto L_0x00c2
        L_0x00c0:
            java.lang.String r1 = ""
        L_0x00c2:
            java.lang.String r2 = "shopId"
            r0.put(r2, r1)
            java.lang.Class<com.didi.soda.manager.base.ICustomerBillManager> r1 = com.didi.soda.manager.base.ICustomerBillManager.class
            com.didi.soda.manager.base.ICustomerManager r1 = com.didi.soda.manager.CustomerManagerLoader.loadManager(r1)
            com.didi.soda.manager.base.ICustomerBillManager r1 = (com.didi.soda.manager.base.ICustomerBillManager) r1
            com.didi.soda.customer.foundation.rpc.entity.address.ContactEntity r1 = r1.getCurrentContact()
            java.lang.String r2 = r1.phone
            java.lang.String r4 = "receivePhone"
            r0.put(r4, r2)
            java.lang.String r1 = r1.callingCode
            java.lang.String r2 = "receiveCallingCode"
            r0.put(r2, r1)
            int r13 = r13.getType()
            java.lang.String r0 = "params"
            java.lang.String r1 = "url"
            java.lang.String r2 = "verticalWebPage"
            if (r13 != r10) goto L_0x010b
            com.didi.soda.router.Request$Builder r13 = com.didi.soda.router.DiRouter.request()
            com.didi.soda.router.Request$Builder r13 = r13.path(r2)
            java.lang.String r2 = "https://food-c-h5.99app.com/${locale}/cart/r/coupon"
            com.didi.soda.router.Request$Builder r13 = r13.putString(r1, r2)
            java.io.Serializable r3 = (java.io.Serializable) r3
            com.didi.soda.router.Request$Builder r13 = r13.putSerializable(r0, r3)
            r13.open()
            goto L_0x0122
        L_0x010b:
            com.didi.soda.router.Request$Builder r13 = com.didi.soda.router.DiRouter.request()
            com.didi.soda.router.Request$Builder r13 = r13.path(r2)
            java.lang.String r2 = "https://food-c-h5.99app.com/${locale}/cart/coupon"
            com.didi.soda.router.Request$Builder r13 = r13.putString(r1, r2)
            java.io.Serializable r3 = (java.io.Serializable) r3
            com.didi.soda.router.Request$Builder r13 = r13.putSerializable(r0, r3)
            r13.open()
        L_0x0122:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.bill.view.item.logic.ItemViewCommonLogicV2.m27808e(com.didi.soda.bill.model.ComponentModel):void");
    }
}
