package com.didi.entrega.bill;

import android.text.TextUtils;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.entrega.bill.repo.BillConfigRepo;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.app.constant.Const;
import com.didi.entrega.customer.base.pages.RoutePath;
import com.didi.entrega.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.entrega.customer.foundation.rpc.entity.address.ContactStufEntity;
import com.didi.entrega.customer.foundation.tracker.param.ParamConst;
import com.didi.entrega.customer.foundation.util.CustomerApolloUtil;
import com.didi.entrega.customer.repo.RepoFactory;
import com.didi.entrega.info.helper.InfoStepConfig;
import com.didi.entrega.manager.CustomerManagerLoader;
import com.didi.entrega.manager.base.ICustomerContactManager;
import com.didi.entrega.router.DiRouter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/entrega/bill/BillExt;", "", "()V", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillExt.kt */
public final class BillExt {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static int f19461a;

    @Metadata(mo175977d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\nJ$\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J\u0012\u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011H\u0002J\u0012\u0010\u0017\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0018"}, mo175978d2 = {"Lcom/didi/entrega/bill/BillExt$Companion;", "", "()V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "billNextBtnOpenPage", "", "pageSource", "eventSource", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "checkAddressAndPackageInfo", "senderAddress", "Lcom/didi/entrega/customer/foundation/rpc/entity/address/AddressEntity;", "receiverAddress", "packageInfo", "Lcom/didi/entrega/customer/foundation/rpc/entity/address/ContactStufEntity;", "isAddressValid", "address", "isPackageInfoValid", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BillExt.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getIndex() {
            return BillExt.f19461a;
        }

        public final void setIndex(int i) {
            BillExt.f19461a = i;
        }

        public final boolean billNextBtnOpenPage(int i, int i2, ScopeContext scopeContext) {
            String str;
            Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
            ICustomerContactManager iCustomerContactManager = (ICustomerContactManager) CustomerManagerLoader.loadManager(ICustomerContactManager.class);
            if (!isAddressValid(iCustomerContactManager.getSendContact())) {
                setIndex(getIndex() + 1);
                str = RoutePath.EDIT_SEND_PAGE;
            } else if (!isAddressValid(iCustomerContactManager.getReceiveContact())) {
                setIndex(getIndex() + 1);
                str = RoutePath.EDIT_RECEIVE_PAGE;
            } else if (!isPackageInfoValid(iCustomerContactManager.getContStuf())) {
                setIndex(getIndex() + 1);
                str = RoutePath.EDIT_STUFF_PAGE;
            } else {
                int index = getIndex();
                if (index >= 0) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3 + 1;
                        GlobalContext.getPageInstrument().pop();
                        if (i3 == index) {
                            break;
                        }
                        i3 = i4;
                    }
                }
                setIndex(0);
                return false;
            }
            DiRouter.request().path(str).setFromPage(scopeContext).putSerializable(Const.BundleKey.INFO_PAGE_CONFIG, InfoStepConfig.Companion.getUPDATE()).putInt("page_source", i).putInt(ParamConst.InfoOmega.EVENT_SOURCE, i2).open();
            return true;
        }

        public final boolean checkAddressAndPackageInfo(AddressEntity addressEntity, AddressEntity addressEntity2, ContactStufEntity contactStufEntity) {
            return isAddressValid(addressEntity) && isAddressValid(addressEntity2) && isPackageInfoValid(contactStufEntity);
        }

        public final boolean checkAddressAndPackageInfo() {
            ICustomerContactManager iCustomerContactManager = (ICustomerContactManager) CustomerManagerLoader.loadManager(ICustomerContactManager.class);
            return checkAddressAndPackageInfo(iCustomerContactManager.getSendContact(), iCustomerContactManager.getReceiveContact(), iCustomerContactManager.getContStuf());
        }

        private final boolean isAddressValid(AddressEntity addressEntity) {
            return addressEntity != null && !TextUtils.isEmpty(addressEntity.phone) && addressEntity.poi != null && !TextUtils.isEmpty(addressEntity.poi.displayName);
        }

        private final boolean isPackageInfoValid(ContactStufEntity contactStufEntity) {
            if (!CustomerApolloUtil.packageInfoSwitch() || ((BillConfigRepo) RepoFactory.getRepo(BillConfigRepo.class)).getValue().getStuffHasShow()) {
                return true;
            }
            if (contactStufEntity == null || TextUtils.isEmpty(contactStufEntity.cateName)) {
                return false;
            }
            return true;
        }
    }
}
