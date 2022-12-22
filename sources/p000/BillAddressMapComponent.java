package p000;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;
import com.didi.entrega.billmap.BillMapPresenter;
import com.didi.entrega.billmap.BillMapView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\b\u001a\u00020\u0003H\u0014J\b\u0010\t\u001a\u00020\u0002H\u0014J\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0007\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000¨\u0006\f"}, mo175978d2 = {"LBillAddressMapComponent;", "Lcom/didi/app/nova/skeleton/mvp/MvpComponent;", "Lcom/didi/entrega/billmap/BillMapView;", "Lcom/didi/entrega/billmap/BillMapPresenter;", "container", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "billMapView", "onCreatePresenter", "onCreateView", "removeMarker", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: BillAddressMapComponent */
/* compiled from: BillAddressMapComponent.kt */
public final class BillAddressMapComponent extends MvpComponent<BillMapView, BillMapPresenter> {

    /* renamed from: a */
    private BillMapView f17688a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BillAddressMapComponent(ViewGroup viewGroup) {
        super(viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "container");
    }

    /* access modifiers changed from: protected */
    public BillMapPresenter onCreatePresenter() {
        return new BillMapPresenter();
    }

    /* access modifiers changed from: protected */
    public BillMapView onCreateView() {
        BillMapView billMapView = new BillMapView();
        this.f17688a = billMapView;
        if (billMapView != null) {
            return billMapView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("billMapView");
        return null;
    }

    public final void removeMarker() {
        BillMapView billMapView = this.f17688a;
        if (billMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("billMapView");
            billMapView = null;
        }
        billMapView.removerMarker();
    }
}
