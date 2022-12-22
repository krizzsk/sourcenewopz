package com.didi.entrega.bill.datastore.p110op;

import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.bill.BillOmegaHelper;
import com.didi.entrega.bill.datastore.BillRepo;
import com.didi.entrega.bill.datastore.BillRepoExtKt;
import com.didi.entrega.bill.model.ComponentDataModel;
import com.didi.entrega.bill.model.ComponentModel;
import com.didi.entrega.bill.model.CouponModel;
import com.didi.entrega.bill.model.SectionModel;
import com.didi.entrega.customer.app.constant.Const;
import com.didi.entrega.customer.base.pages.RoutePath;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.rpc.entity.BillComponentEntity;
import com.didi.entrega.customer.foundation.rpc.entity.BillEntity;
import com.didi.entrega.customer.foundation.rpc.entity.BillExtraData;
import com.didi.entrega.customer.foundation.rpc.entity.BillSectionEntity;
import com.didi.entrega.customer.foundation.tracker.param.ParamConst;
import com.didi.entrega.info.helper.InfoStepConfig;
import com.didi.entrega.pay.PayMethodPage;
import com.didi.entrega.router.DiRouter;
import com.didi.entrega.router.Request;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0001B\u000f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nH\u0002J\u0010\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\nH\u0002J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0002J \u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/entrega/bill/datastore/op/BillSectionsOperation;", "Lcom/didi/entrega/bill/datastore/op/EntityOperation;", "", "Lcom/didi/entrega/bill/model/SectionModel;", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "(Lcom/didi/app/nova/skeleton/ScopeContext;)V", "getScopeContext", "()Lcom/didi/app/nova/skeleton/ScopeContext;", "buildComponentModel", "Lcom/didi/entrega/bill/model/ComponentModel;", "entity", "Lcom/didi/entrega/customer/foundation/rpc/entity/BillEntity;", "componentEntity", "Lcom/didi/entrega/customer/foundation/rpc/entity/BillComponentEntity;", "index", "", "gotoCouponPage", "", "componentModel", "gotoTipPage", "onClickComponent", "model", "operate", "repo", "Lcom/didi/entrega/bill/datastore/BillRepo;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.entrega.bill.datastore.op.BillSectionsOperation */
/* compiled from: BillSectionsOperation.kt */
public final class BillSectionsOperation extends EntityOperation<List<? extends SectionModel>> {

    /* renamed from: a */
    private final ScopeContext f19518a;

    public final ScopeContext getScopeContext() {
        return this.f19518a;
    }

    public BillSectionsOperation(ScopeContext scopeContext) {
        this.f19518a = scopeContext;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m14609a(ComponentModel componentModel, BillComponentEntity billComponentEntity) {
        int type = componentModel.getType();
        if (type == 4) {
            BillOmegaHelper.INSTANCE.trackBillClick(this.f19518a, "pay_method");
            ScopeContext scopeContext = this.f19518a;
            String cartId = componentModel.getCartId();
            BillExtraData data = billComponentEntity.getData();
            PayMethodPage.toPayMethod(scopeContext, 0, 0, cartId, data == null ? null : data.getPayChannel());
        } else if (type == 7) {
            BillOmegaHelper.INSTANCE.trackBillClick(this.f19518a, "tips");
            if (componentModel.isCanRedirect() == 1) {
            }
            m14610b(componentModel);
        } else if (type == 10) {
            BillOmegaHelper.INSTANCE.trackBillClick(this.f19518a, "coupon");
            if (componentModel.isCanRedirect() == 1) {
            }
            m14608a(componentModel);
        } else if (type == 16) {
            if (this.f19518a != null) {
                BillOmegaHelper.INSTANCE.trackBillClick(getScopeContext(), Const.BillClickType.TRANSFORM);
            }
            ScopeContext scopeContext2 = this.f19518a;
            if (scopeContext2 != null) {
                BillRepoExtKt.switchAddress(BillRepo.Companion.get(scopeContext2));
            }
        } else if (type == 17) {
            BillOmegaHelper.INSTANCE.trackBillClick(this.f19518a, Const.BillClickType.GOODS);
            ScopeContext scopeContext3 = this.f19518a;
            if (scopeContext3 != null) {
                DiRouter.request().path(RoutePath.EDIT_STUFF_PAGE).setFromPage(getScopeContext()).putSerializable(Const.BundleKey.INFO_PAGE_CONFIG, InfoStepConfig.Companion.getUPDATE()).putInt("page_source", BillRepo.Companion.get(scopeContext3).getPageSource()).putInt(ParamConst.InfoOmega.EVENT_SOURCE, 2).open();
            }
        }
    }

    /* renamed from: a */
    private final ComponentModel m14607a(BillEntity billEntity, BillComponentEntity billComponentEntity, int i) {
        ComponentModel convert = ComponentModel.Companion.convert(this.f19518a, billEntity, billComponentEntity, i);
        convert.setOnCardClick(new BillSectionsOperation$buildComponentModel$1$1(this, convert, billComponentEntity));
        return convert;
    }

    public List<SectionModel> operate(BillRepo billRepo, BillEntity billEntity) {
        List list;
        SectionModel sectionModel;
        Intrinsics.checkNotNullParameter(billRepo, "repo");
        Intrinsics.checkNotNullParameter(billEntity, "entity");
        List<BillSectionEntity> sections = billEntity.getSections();
        if (sections != null) {
            Collection arrayList = new ArrayList();
            for (BillSectionEntity components : sections) {
                List<BillComponentEntity> components2 = components.getComponents();
                if (components2 == null) {
                    list = null;
                } else {
                    Iterable iterable = components2;
                    Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                    int i = 0;
                    for (Object next : iterable) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        arrayList2.add(m14607a(billEntity, (BillComponentEntity) next, i));
                        i = i2;
                    }
                    list = (List) arrayList2;
                }
                if (list == null) {
                    sectionModel = null;
                } else {
                    sectionModel = new SectionModel(list);
                }
                if (sectionModel != null) {
                    arrayList.add(sectionModel);
                }
            }
            return (List) arrayList;
        }
        LogUtil.m14761d("TAG", "API 返回字段没有 sections ");
        return null;
    }

    /* renamed from: a */
    private final void m14608a(ComponentModel componentModel) {
        CouponModel couponModel;
        HashMap hashMap = new HashMap();
        ComponentDataModel data = componentModel.getData();
        String str = null;
        if (!(data == null || (couponModel = data.getCouponModel()) == null)) {
            str = couponModel.getCouponId();
        }
        if (str != null) {
            hashMap.put("selected", str);
        }
        Map map = hashMap;
        map.put("cart_id", componentModel.getCartId());
        map.put("bill_coupon_type", "0");
        DiRouter.request().path("verticalWebPage").setFromPage(this.f19518a).putString("url", "https://food-c-h5.99app.com/${locale}/cart/coupon").putSerializable("params", hashMap).open();
    }

    /* renamed from: b */
    private final void m14610b(ComponentModel componentModel) {
        Request.Builder fromPage = DiRouter.request().path("billTipPage").setFromPage(this.f19518a);
        ComponentDataModel data = componentModel.getData();
        fromPage.putSerializable("tip_info", data == null ? null : data.getTipModel()).putString("currency", componentModel.getCurrency()).putInt("price", componentModel.getTipFeeBasePrice()).open();
    }
}
