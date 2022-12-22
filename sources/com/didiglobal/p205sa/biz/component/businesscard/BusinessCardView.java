package com.didiglobal.p205sa.biz.component.businesscard;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.didi.component.never.core.IView;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didiglobal.p205sa.biz.component.businesscard.model.BusinessCardModel;
import com.didiglobal.p205sa.biz.component.businesscard.view.BusinessRowItemView;
import com.didiglobal.p205sa.biz.component.sapanel.interfaces.ICardPosition;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\bH\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0012H\u0002J\u0010\u0010\u0017\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019J\u0012\u0010\u001a\u001a\u00020\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/component/businesscard/BusinessCardView;", "Lcom/didi/component/never/core/IView;", "Lcom/didiglobal/sa/biz/component/businesscard/BusinessCardPresenter;", "Lcom/didiglobal/sa/biz/component/sapanel/interfaces/ICardPosition;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "anchorSoda", "Landroid/view/View;", "content_ll", "Landroid/widget/LinearLayout;", "logger", "Lcom/didi/sdk/logging/Logger;", "kotlin.jvm.PlatformType", "presenter", "rootView", "getCardPosition", "type", "", "getView", "log", "", "msg", "setDate", "businessModel", "Lcom/didiglobal/sa/biz/component/businesscard/model/BusinessCardModel;", "setPresenter", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.businesscard.BusinessCardView */
/* compiled from: BusinessCardView.kt */
public final class BusinessCardView implements IView<BusinessCardPresenter>, ICardPosition {

    /* renamed from: a */
    private View f50810a;

    /* renamed from: b */
    private LinearLayout f50811b;

    /* renamed from: c */
    private BusinessCardPresenter f50812c;

    /* renamed from: d */
    private final Logger f50813d = LoggerFactory.getLogger("BusinessCardView");

    /* renamed from: e */
    private View f50814e;

    public BusinessCardView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = LayoutInflater.from(context).inflate(R.layout.component_sa_business, (ViewGroup) null, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.…sa_business, null, false)");
        this.f50810a = inflate;
        View findViewById = inflate.findViewById(R.id.content_ll);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.content_ll)");
        this.f50811b = (LinearLayout) findViewById;
    }

    /* renamed from: a */
    private final void m36472a(String str) {
        this.f50813d.info(str, new Object[0]);
    }

    public View getView() {
        return this.f50810a;
    }

    public void setPresenter(BusinessCardPresenter businessCardPresenter) {
        this.f50812c = businessCardPresenter;
    }

    public final void setDate(BusinessCardModel businessCardModel) {
        int i;
        int i2;
        int i3;
        BusinessRowItemView businessRowItemView;
        int i4;
        boolean z;
        BusinessCardModel businessCardModel2 = businessCardModel;
        BusinessRowItemView businessRowItemView2 = null;
        if ((businessCardModel2 == null ? null : businessCardModel2.businessMenu) != null) {
            m36472a(Intrinsics.stringPlus("set data ", businessCardModel2.businessMenu));
            int weight = BusinessCardModel.StyleWeight.BIG.getWeight() * 2;
            int size = businessCardModel2.businessMenu.size();
            this.f50814e = null;
            if (size > 0) {
                BusinessRowItemView businessRowItemView3 = null;
                int i5 = weight;
                int i6 = i5;
                int i7 = 0;
                int i8 = 0;
                i2 = 0;
                boolean z2 = true;
                boolean z3 = true;
                while (true) {
                    int i9 = i7 + 1;
                    BusinessCardModel.BusinessMenuModel businessMenuModel = businessCardModel2.businessMenu.get(i7);
                    int i10 = businessMenuModel.style;
                    i = weight;
                    if (i10 == BusinessCardModel.Style.BIG.getType()) {
                        i4 = BusinessCardModel.StyleWeight.BIG.getWeight();
                    } else if (i10 == BusinessCardModel.Style.MID.getType()) {
                        i4 = BusinessCardModel.StyleWeight.MID.getWeight();
                    } else if (i10 == BusinessCardModel.Style.SMALL.getType()) {
                        i4 = BusinessCardModel.StyleWeight.SMALL.getWeight();
                    } else {
                        i4 = BusinessCardModel.StyleWeight.SMALL.getWeight();
                    }
                    i5 -= i4;
                    m36472a("weight = " + i5 + " ,i = " + i7 + ", size = " + size + ", firstRealWeight=" + i8);
                    if (i5 >= 0) {
                        if (businessRowItemView3 == null) {
                            businessRowItemView3 = new BusinessRowItemView(this.f50810a.getContext());
                            businessRowItemView3.updateLayoutParames(true);
                        }
                        i8 += i4;
                        boolean z4 = i5 == 0;
                        if (TextUtils.equals(businessMenuModel.groupType, "soda")) {
                            this.f50814e = businessRowItemView3.addBusinessItem(businessMenuModel, z3, z4);
                        } else {
                            businessRowItemView3.addBusinessItem(businessMenuModel, z3, z4);
                        }
                        z3 = false;
                    } else {
                        i6 -= i4;
                        m36472a("secondRowWeight = " + i6 + " , secondRealWeight=" + i2);
                        if (businessRowItemView2 == null) {
                            BusinessRowItemView businessRowItemView4 = new BusinessRowItemView(this.f50810a.getContext());
                            z = false;
                            businessRowItemView4.updateLayoutParames(false);
                            businessRowItemView2 = businessRowItemView4;
                        } else {
                            z = false;
                        }
                        i2 += i4;
                        if (i6 <= 0) {
                            if (i7 != size - 1) {
                                businessRowItemView2.addMoreItem(businessCardModel);
                                break;
                            }
                            businessRowItemView2.addBusinessItem(businessMenuModel, z2, true);
                        } else {
                            businessRowItemView2.addBusinessItem(businessMenuModel, z2, z);
                        }
                        z2 = false;
                    }
                    if (i9 >= size) {
                        break;
                    }
                    businessCardModel2 = businessCardModel;
                    i7 = i9;
                    weight = i;
                }
                businessRowItemView = businessRowItemView2;
                businessRowItemView2 = businessRowItemView3;
                i3 = i8;
            } else {
                i = weight;
                businessRowItemView = null;
                i3 = 0;
                i2 = 0;
            }
            m36472a("addview end  firstRealWeight=" + i3 + ", secondRealWeight=" + i2);
            if (businessRowItemView2 != null) {
                int i11 = i - i3;
                if (i11 > 0) {
                    businessRowItemView2.addEmptyView((float) i11);
                }
                this.f50811b.removeAllViews();
                this.f50811b.addView(businessRowItemView2);
                if (businessRowItemView != null) {
                    int i12 = i - i2;
                    if (i12 > 0) {
                        businessRowItemView.addEmptyView((float) i12);
                    }
                    this.f50811b.addView(businessRowItemView);
                }
            }
        }
    }

    public View getCardPosition(String str) {
        ViewGroup viewGroup;
        int childCount;
        Object obj;
        int childCount2 = this.f50811b.getChildCount();
        if (childCount2 > 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                View childAt = this.f50811b.getChildAt(i);
                if ((childAt instanceof ViewGroup) && (childCount = viewGroup.getChildCount()) > 0) {
                    int i3 = 0;
                    while (true) {
                        int i4 = i3 + 1;
                        View childAt2 = (viewGroup = (ViewGroup) childAt).getChildAt(i3);
                        if (childAt2 == null) {
                            obj = null;
                        } else {
                            obj = childAt2.getTag();
                        }
                        if (Intrinsics.areEqual((Object) str, obj)) {
                            return childAt2;
                        }
                        if (i4 >= childCount) {
                            break;
                        }
                        i3 = i4;
                    }
                }
                if (i2 >= childCount2) {
                    break;
                }
                i = i2;
            }
        }
        return null;
    }
}
