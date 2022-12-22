package com.didi.soda.bill.model.datamodel;

import com.didi.soda.bill.model.ComponentAbsModel;
import com.didi.soda.bill.model.datamodel.BillCartItemModel;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillCartItemsInfo;
import com.didi.soda.customer.foundation.rpc.entity.bill.BillComponentDataEntity;
import com.didi.soda.customer.foundation.rpc.entity.cart.CartItemEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010+\u001a\u0004\u0018\u00010\u00002\u0006\u0010,\u001a\u00020-H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R*\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00160\u0015j\b\u0012\u0004\u0012\u00020\u0016`\u0017X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\u001c\u0010%\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001f\"\u0004\b'\u0010!R\u001c\u0010(\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001f\"\u0004\b*\u0010!¨\u0006."}, mo175978d2 = {"Lcom/didi/soda/bill/model/datamodel/BillItemsInfoModel;", "Lcom/didi/soda/bill/model/ComponentAbsModel;", "()V", "businessType", "", "getBusinessType", "()I", "setBusinessType", "(I)V", "collapsedHeight", "getCollapsedHeight", "setCollapsedHeight", "expandHeight", "getExpandHeight", "setExpandHeight", "isExpand", "", "()Z", "setExpand", "(Z)V", "items", "Ljava/util/ArrayList;", "Lcom/didi/soda/bill/model/datamodel/BillCartItemModel;", "Lkotlin/collections/ArrayList;", "getItems", "()Ljava/util/ArrayList;", "setItems", "(Ljava/util/ArrayList;)V", "shopId", "", "getShopId", "()Ljava/lang/String;", "setShopId", "(Ljava/lang/String;)V", "shopName", "getShopName", "setShopName", "shopReturnDesc", "getShopReturnDesc", "setShopReturnDesc", "url", "getUrl", "setUrl", "convertModel", "entity", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/BillComponentDataEntity;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillItemsInfoModel.kt */
public final class BillItemsInfoModel extends ComponentAbsModel {

    /* renamed from: a */
    private String f39086a;

    /* renamed from: b */
    private String f39087b;

    /* renamed from: c */
    private ArrayList<BillCartItemModel> f39088c = new ArrayList<>();

    /* renamed from: d */
    private boolean f39089d;

    /* renamed from: e */
    private int f39090e;

    /* renamed from: f */
    private int f39091f;

    /* renamed from: g */
    private int f39092g = 1;

    /* renamed from: h */
    private String f39093h;

    /* renamed from: i */
    private String f39094i;

    public final String getShopId() {
        return this.f39086a;
    }

    public final void setShopId(String str) {
        this.f39086a = str;
    }

    public final String getShopName() {
        return this.f39087b;
    }

    public final void setShopName(String str) {
        this.f39087b = str;
    }

    public final ArrayList<BillCartItemModel> getItems() {
        return this.f39088c;
    }

    public final void setItems(ArrayList<BillCartItemModel> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.f39088c = arrayList;
    }

    public final boolean isExpand() {
        return this.f39089d;
    }

    public final void setExpand(boolean z) {
        this.f39089d = z;
    }

    public final int getExpandHeight() {
        return this.f39090e;
    }

    public final void setExpandHeight(int i) {
        this.f39090e = i;
    }

    public final int getCollapsedHeight() {
        return this.f39091f;
    }

    public final void setCollapsedHeight(int i) {
        this.f39091f = i;
    }

    public final int getBusinessType() {
        return this.f39092g;
    }

    public final void setBusinessType(int i) {
        this.f39092g = i;
    }

    public final String getUrl() {
        return this.f39093h;
    }

    public final void setUrl(String str) {
        this.f39093h = str;
    }

    public final String getShopReturnDesc() {
        return this.f39094i;
    }

    public final void setShopReturnDesc(String str) {
        this.f39094i = str;
    }

    public BillItemsInfoModel convertModel(BillComponentDataEntity billComponentDataEntity) {
        Intrinsics.checkNotNullParameter(billComponentDataEntity, "entity");
        BillCartItemsInfo itemsInfo = billComponentDataEntity.getItemsInfo();
        if (itemsInfo == null) {
            return null;
        }
        BillItemsInfoModel billItemsInfoModel = new BillItemsInfoModel();
        billItemsInfoModel.setShopId(itemsInfo.getShopId());
        billItemsInfoModel.setShopName(itemsInfo.getShopName());
        billItemsInfoModel.setBusinessType(itemsInfo.getBusinessType());
        billItemsInfoModel.setUrl(itemsInfo.getUrl());
        billItemsInfoModel.setShopReturnDesc(itemsInfo.getShopReturnDesc());
        ArrayList<CartItemEntity> items = itemsInfo.getItems();
        Collection collection = items;
        if (!(collection == null || collection.isEmpty())) {
            Iterator<CartItemEntity> it = items.iterator();
            while (it.hasNext()) {
                CartItemEntity next = it.next();
                BillCartItemModel.Companion companion = BillCartItemModel.Companion;
                Intrinsics.checkNotNullExpressionValue(next, "item");
                BillCartItemModel convertModel = companion.convertModel(next);
                ArrayList<BillCartItemModel> items2 = billItemsInfoModel.getItems();
                if (items2 != null) {
                    items2.add(convertModel);
                }
            }
        }
        return billItemsInfoModel;
    }
}
