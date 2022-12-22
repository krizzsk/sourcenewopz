package com.didiglobal.p205sa.biz.component.bizcard;

import android.view.View;
import android.view.ViewGroup;
import com.didi.component.never.core.IView;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.p205sa.biz.component.bizcard.model.BizCardModel;
import com.didiglobal.p205sa.biz.util.UiUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u000e\u001a\u00020\rH\u0016J2\u0010\u000f\u001a\u00020\u00102\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00122\u001a\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\tJ\u0012\u0010\u0015\u001a\u00020\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/component/bizcard/BizCardView;", "Lcom/didi/component/never/core/IView;", "Lcom/didiglobal/sa/biz/component/bizcard/BizCardPresenter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "child", "Ljava/util/ArrayList;", "Lcom/didiglobal/enginecore/component/XEComponent;", "Lkotlin/collections/ArrayList;", "container", "Landroid/view/ViewGroup;", "rootView", "Landroid/view/View;", "getView", "refreshData", "", "list", "", "bizCardModelList", "Lcom/didiglobal/sa/biz/component/bizcard/model/BizCardModel;", "setPresenter", "p0", "visibilityView", "visibility", "", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.bizcard.BizCardView */
/* compiled from: BizCardView.kt */
public final class BizCardView implements IView<BizCardPresenter> {

    /* renamed from: a */
    private View f50804a;

    /* renamed from: b */
    private ViewGroup f50805b;

    /* renamed from: c */
    private final ArrayList<XEComponent> f50806c = new ArrayList<>();

    public void setPresenter(BizCardPresenter bizCardPresenter) {
    }

    /* JADX WARNING: type inference failed for: r3v5, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public BizCardView(android.content.Context r3) {
        /*
            r2 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r2.<init>()
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r3)
            r0 = 2131624278(0x7f0e0156, float:1.8875731E38)
            r1 = 0
            android.view.View r3 = r3.inflate(r0, r1)
            java.lang.String r0 = "from(context).inflate(R.…component_biz_card, null)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            r2.f50804a = r3
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            r2.f50806c = r3
            android.view.View r3 = r2.f50804a
            if (r3 != 0) goto L_0x0027
            goto L_0x0031
        L_0x0027:
            r0 = 2131428316(0x7f0b03dc, float:1.8478273E38)
            android.view.View r3 = r3.findViewById(r0)
            r1 = r3
            android.view.ViewGroup r1 = (android.view.ViewGroup) r1
        L_0x0031:
            r2.f50805b = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.p205sa.biz.component.bizcard.BizCardView.<init>(android.content.Context):void");
    }

    public View getView() {
        return this.f50804a;
    }

    public final void refreshData(List<? extends XEComponent> list, ArrayList<BizCardModel> arrayList) {
        boolean z;
        if (arrayList != null && arrayList.isEmpty()) {
            m36470a(0);
            return;
        }
        ViewGroup viewGroup = this.f50805b;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        this.f50806c.clear();
        if (list != null) {
            this.f50806c.addAll(list);
        }
        if (!this.f50806c.isEmpty()) {
            int size = this.f50806c.size();
            if (size > 0) {
                int i = 0;
                z = false;
                while (true) {
                    int i2 = i + 1;
                    XEComponent xEComponent = this.f50806c.get(i);
                    Intrinsics.checkNotNullExpressionValue(xEComponent, "child[i]");
                    View view = xEComponent.getView();
                    if (view != null) {
                        if (i != 0) {
                            View view2 = new View(view.getContext());
                            ViewGroup viewGroup2 = this.f50805b;
                            if (viewGroup2 != null) {
                                viewGroup2.addView(view2, new ViewGroup.LayoutParams(-1, UiUtils.INSTANCE.dip2px(view.getContext(), 20.0f)));
                            }
                        }
                        ViewGroup viewGroup3 = this.f50805b;
                        if (viewGroup3 != null) {
                            viewGroup3.addView(view);
                        }
                        z = true;
                    }
                    if (i2 >= size) {
                        break;
                    }
                    i = i2;
                }
            } else {
                z = false;
            }
            if (z) {
                m36470a(0);
            } else {
                m36470a(8);
            }
        } else {
            m36470a(8);
        }
    }

    /* renamed from: a */
    private final void m36470a(int i) {
        ViewGroup viewGroup = this.f50805b;
        if (viewGroup != null) {
            viewGroup.setVisibility(i);
        }
        View view = this.f50804a;
        if (view != null) {
            view.setVisibility(i);
        }
    }
}
