package com.didi.soda.business.binder.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.soda.blocks.action.BaseAction;
import com.didi.soda.blocks.model.WidgetNodeModel;
import com.didi.soda.blocks.scope.IBlockScope;
import com.didi.soda.blocks.style.BaseBinder;
import com.didi.soda.blocks.utils.ColorUtils;
import com.didi.soda.blocks.widget.Buildable;
import com.didi.soda.blocks.widget.WidgetNameMeta;
import com.didi.soda.blocks.widget.image.BackgroundHelper;
import com.didi.soda.business.widget.BusinessLittleStepper;
import com.didi.soda.business.widget.WidgetTriggerBean;
import com.didi.soda.cart.repo.CartItemStateRepo;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.customer.repo.model.ItemState;
import com.taxis99.R;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@WidgetNameMeta(widgetName = "CateStepper")
@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J0\u0010\u0018\u001a\u00020\u00192&\u0010\u001a\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bj\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0016Jt\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u00072\u0010\u0010#\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u00010$2F\u0010&\u001aB\u0012\u0013\u0012\u00110!¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b( \u0012\u0013\u0012\u00110*¢\u0006\f\b(\u0012\b\b)\u0012\u0004\b\b(+\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u00010$\u0012\u0004\u0012\u00020\u00190'H\u0016J\b\u0010,\u001a\u00020\u0019H\u0002J\b\u0010-\u001a\u00020\u0019H\u0002J\b\u0010.\u001a\u00020\u0019H\u0016J\u0012\u0010/\u001a\u00020\u00192\b\u00100\u001a\u0004\u0018\u00010\u0010H\u0002J0\u00101\u001a\u00020\u000e2&\u0010\u001a\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bj\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u001dH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007XD¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u00062"}, mo175978d2 = {"Lcom/didi/soda/business/binder/home/BusinessLittleStepperBinder;", "Lcom/didi/soda/blocks/style/BaseBinder;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TAG", "", "backgroundHelper", "Lcom/didi/soda/blocks/widget/image/BackgroundHelper;", "mItemStateRepo", "Lcom/didi/soda/cart/repo/CartItemStateRepo;", "mask", "needMask", "", "onAddBean", "Lcom/didi/soda/business/widget/WidgetTriggerBean;", "onMinus", "shopId", "stepper", "Lcom/didi/soda/business/widget/BusinessLittleStepper;", "subscription", "Lcom/didi/app/nova/skeleton/repo/Subscription;", "valueKey", "bindProps", "", "props", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "createView", "handleOtherTrigger", "scope", "Lcom/didi/soda/blocks/scope/IBlockScope;", "callBackType", "actions", "", "Lcom/didi/soda/blocks/action/BaseAction;", "handler", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "Lcom/didi/soda/blocks/widget/Buildable;", "widget", "initProps", "initStata", "initView", "invokeTriggerBean", "bean", "shouldShow", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BusinessLittleStepperBinder.kt */
public final class BusinessLittleStepperBinder extends BaseBinder<View> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final String f39349a = "BusinessLittleStepperBinder";

    /* renamed from: b */
    private String f39350b;

    /* renamed from: c */
    private String f39351c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f39352d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public BusinessLittleStepper f39353e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View f39354f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public WidgetTriggerBean f39355g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public WidgetTriggerBean f39356h;

    /* renamed from: i */
    private CartItemStateRepo f39357i;

    /* renamed from: j */
    private Subscription f39358j;

    /* renamed from: k */
    private BackgroundHelper f39359k;

    public boolean shouldShow(HashMap<String, Object> hashMap) {
        return true;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BusinessLittleStepperBinder(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public View createView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        View inflate = LayoutInflater.from(context).inflate(R.layout.customer_widget_binder_litter_stepper_layout, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(R.…ter_stepper_layout, null)");
        return inflate;
    }

    public void initView() {
        super.initView();
        this.f39353e = (BusinessLittleStepper) getView().findViewById(R.id.step_bottom);
        this.f39354f = getView().findViewById(R.id.ll_mask);
        BusinessLittleStepper businessLittleStepper = this.f39353e;
        if (businessLittleStepper != null) {
            businessLittleStepper.setUpAction(new BusinessLittleStepperBinder$initView$1(this));
        }
        BusinessLittleStepper businessLittleStepper2 = this.f39353e;
        if (businessLittleStepper2 != null) {
            businessLittleStepper2.setDownAction(new BusinessLittleStepperBinder$initView$2(this));
        }
        BusinessLittleStepper businessLittleStepper3 = this.f39353e;
        if (businessLittleStepper3 != null) {
            businessLittleStepper3.setStepperListener(new BusinessLittleStepperBinder$initView$3(this));
        }
        this.f39357i = (CartItemStateRepo) RepoFactory.getRepo(CartItemStateRepo.class);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m27858a(WidgetTriggerBean widgetTriggerBean) {
        WidgetNodeModel virtualNode;
        HashMap<String, Object> contextParams;
        if (widgetTriggerBean != null) {
            if (!(!(widgetTriggerBean.getWidgetBuildable() instanceof BaseBinder) || (virtualNode = ((BaseBinder) widgetTriggerBean.getWidgetBuildable()).getVirtualNode()) == null || (contextParams = virtualNode.getContextParams()) == null)) {
                BusinessLittleStepper businessLittleStepper = this.f39353e;
                contextParams.put(BlocksConst.SCOPE_ACTION_PARAM_GOOD_NEXT_VALUE, Integer.valueOf(businessLittleStepper == null ? 0 : businessLittleStepper.getCurrentNum()));
            }
            Function3<IBlockScope, Buildable, List<? extends BaseAction>, Unit> handler = widgetTriggerBean.getHandler();
            if (handler != null) {
                handler.invoke(widgetTriggerBean.getScope(), widgetTriggerBean.getWidgetBuildable(), widgetTriggerBean.getActions());
            }
        }
    }

    public boolean handleOtherTrigger(IBlockScope iBlockScope, String str, List<? extends BaseAction> list, Function3<? super IBlockScope, ? super Buildable, ? super List<? extends BaseAction>, Unit> function3) {
        Intrinsics.checkNotNullParameter(iBlockScope, "scope");
        Intrinsics.checkNotNullParameter(function3, "handler");
        if (Intrinsics.areEqual((Object) str, (Object) BlocksConst.ON_ADD_CLICK)) {
            this.f39355g = new WidgetTriggerBean(iBlockScope, this, list, function3);
        }
        if (!Intrinsics.areEqual((Object) str, (Object) BlocksConst.ON_MINUS_CLICK)) {
            return true;
        }
        this.f39356h = new WidgetTriggerBean(iBlockScope, this, list, function3);
        return true;
    }

    public void bindProps(HashMap<String, Object> hashMap) {
        BusinessLittleStepper businessLittleStepper;
        BusinessLittleStepper businessLittleStepper2;
        BusinessLittleStepper businessLittleStepper3;
        BusinessLittleStepper businessLittleStepper4;
        BusinessLittleStepper businessLittleStepper5;
        BusinessLittleStepper businessLittleStepper6;
        super.bindProps(hashMap);
        m27856a();
        if (hashMap != null) {
            for (Map.Entry entry : hashMap.entrySet()) {
                String str = (String) entry.getKey();
                Object value = entry.getValue();
                boolean z = false;
                switch (str.hashCode()) {
                    case -1730016560:
                        if (str.equals(BlocksConst.NEED_EXPAND) && (value instanceof String)) {
                            try {
                                BusinessLittleStepper businessLittleStepper7 = this.f39353e;
                                if (businessLittleStepper7 != null) {
                                    if (Integer.parseInt((String) value) == 1) {
                                        z = true;
                                    }
                                    businessLittleStepper7.setNeedExpand(z);
                                    break;
                                } else {
                                    break;
                                }
                            } catch (Exception e) {
                                LogUtil.m29100d(this.f39349a, e.getMessage());
                                break;
                            }
                        }
                    case -1636122011:
                        if (str.equals(BlocksConst.STEPPER_TEXT_COLOR) && (businessLittleStepper = this.f39353e) != null) {
                            businessLittleStepper.setStepperTextColor(Integer.valueOf(ColorUtils.parseColor(value.toString())));
                            break;
                        }
                    case -1410182354:
                        if (str.equals(BlocksConst.VALUE_KEY) && (value instanceof String)) {
                            this.f39350b = (String) value;
                            break;
                        }
                    case -1229729094:
                        if (str.equals(BlocksConst.SELECTED_BACKGROUND_COLOR) && (businessLittleStepper2 = this.f39353e) != null) {
                            businessLittleStepper2.setSelectedBackgroundColor(ColorUtils.convertColor(value.toString()));
                            break;
                        }
                    case -1187177220:
                        if (str.equals(BlocksConst.SELECTED_BORDER_COLOR) && (businessLittleStepper3 = this.f39353e) != null) {
                            businessLittleStepper3.setSelectedBorderColor(Integer.valueOf(ColorUtils.parseColor(value.toString())));
                            break;
                        }
                    case -673354812:
                        if (str.equals(BlocksConst.STEPPER_BACKGROUND_COLOR) && (businessLittleStepper4 = this.f39353e) != null) {
                            businessLittleStepper4.setStepperBackgroundColor(ColorUtils.convertColor(value.toString()));
                            break;
                        }
                    case -77812777:
                        if (!str.equals("maskColor")) {
                            break;
                        } else {
                            BackgroundHelper backgroundHelper = this.f39359k;
                            if (backgroundHelper != null) {
                                backgroundHelper.setBackgroundColor(ColorUtils.convertColor(value));
                            }
                            LogUtil.m29100d(this.f39349a, Intrinsics.stringPlus("backcolor:", ColorUtils.convertColor(value)));
                            break;
                        }
                    case 258001670:
                        if (str.equals(BlocksConst.STEPPER_BORDER_COLOR) && (businessLittleStepper5 = this.f39353e) != null) {
                            businessLittleStepper5.setStepperBorderColor(Integer.valueOf(ColorUtils.parseColor(value.toString())));
                            break;
                        }
                    case 865454242:
                        if (str.equals(BlocksConst.NEED_MASK) && (value instanceof String)) {
                            try {
                                if (Integer.parseInt((String) value) == 1) {
                                    z = true;
                                }
                                this.f39352d = z;
                                break;
                            } catch (Exception e2) {
                                LogUtil.m29100d(this.f39349a, e2.getMessage());
                                break;
                            }
                        }
                    case 1544493531:
                        if (str.equals(BlocksConst.SELECTED_TEXT_COLOR) && (businessLittleStepper6 = this.f39353e) != null) {
                            businessLittleStepper6.setSelectedTextColor(Integer.valueOf(ColorUtils.parseColor(value.toString())));
                            break;
                        }
                }
            }
        }
        BusinessLittleStepper businessLittleStepper8 = this.f39353e;
        if (businessLittleStepper8 != null) {
            businessLittleStepper8.initState();
        }
        m27859b();
    }

    /* renamed from: a */
    private final void m27856a() {
        Subscription subscription = this.f39358j;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.f39350b = "";
        View view = this.f39354f;
        if (view != null) {
            view.setVisibility(8);
        }
        View view2 = this.f39354f;
        if (view2 != null) {
            this.f39359k = new BackgroundHelper(getContext(), view2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0009, code lost:
        r0 = r0.getObject("shopId");
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m27859b() {
        /*
            r5 = this;
            com.didi.soda.blocks.scope.IBlockScope r0 = r5.getBlockScope()
            r1 = 0
            if (r0 != 0) goto L_0x0009
        L_0x0007:
            r0 = r1
            goto L_0x0017
        L_0x0009:
            java.lang.String r2 = "shopId"
            java.lang.Object r0 = r0.getObject(r2)
            if (r0 != 0) goto L_0x0013
            goto L_0x0007
        L_0x0013:
            java.lang.String r0 = r0.toString()
        L_0x0017:
            r5.f39351c = r0
            com.didi.soda.blocks.scope.IBlockScope r0 = r5.getBlockScope()
            if (r0 != 0) goto L_0x0020
            goto L_0x0042
        L_0x0020:
            java.lang.String r2 = "scope_context"
            java.lang.Object r0 = r0.getObject(r2)
            if (r0 != 0) goto L_0x002a
            goto L_0x0042
        L_0x002a:
            com.didi.app.nova.skeleton.ScopeContext r0 = (com.didi.app.nova.skeleton.ScopeContext) r0
            com.didi.soda.cart.repo.CartItemStateRepo r2 = r5.f39357i
            if (r2 != 0) goto L_0x0031
            goto L_0x0040
        L_0x0031:
            java.lang.String r1 = r5.f39351c
            if (r1 != 0) goto L_0x0037
            java.lang.String r1 = ""
        L_0x0037:
            com.didi.soda.business.binder.home.-$$Lambda$BusinessLittleStepperBinder$MvpIrDUlw7mRmn7NwMmT1lM0gzY r3 = new com.didi.soda.business.binder.home.-$$Lambda$BusinessLittleStepperBinder$MvpIrDUlw7mRmn7NwMmT1lM0gzY
            r3.<init>()
            com.didi.app.nova.skeleton.repo.Subscription r1 = r2.subscribe(r1, r0, r3)
        L_0x0040:
            r5.f39358j = r1
        L_0x0042:
            java.lang.String r0 = r5.f39351c
            if (r0 != 0) goto L_0x0047
            goto L_0x0060
        L_0x0047:
            com.didi.soda.business.widget.BusinessLittleStepper r1 = r5.f39353e
            if (r1 != 0) goto L_0x004c
            goto L_0x0060
        L_0x004c:
            com.didi.soda.cart.repo.CartItemStateRepo r2 = r5.f39357i
            r3 = 0
            if (r2 != 0) goto L_0x0052
            goto L_0x005d
        L_0x0052:
            java.lang.String r4 = r5.f39350b
            com.didi.soda.customer.repo.model.ItemState r0 = r2.getState(r0, r4)
            if (r0 != 0) goto L_0x005b
            goto L_0x005d
        L_0x005b:
            int r3 = r0.amount
        L_0x005d:
            r1.setCurrentNum(r3)
        L_0x0060:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.business.binder.home.BusinessLittleStepperBinder.m27859b():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27857a(BusinessLittleStepperBinder businessLittleStepperBinder, HashMap hashMap) {
        Intrinsics.checkNotNullParameter(businessLittleStepperBinder, "this$0");
        if (hashMap != null) {
            ItemState itemState = (ItemState) hashMap.get(businessLittleStepperBinder.f39350b);
            if (itemState != null) {
                String str = businessLittleStepperBinder.f39349a;
                LogUtil.m29100d(str, "itemStateMap is not null key:" + businessLittleStepperBinder.f39350b + ",amount:" + itemState.amount);
                BusinessLittleStepper businessLittleStepper = businessLittleStepperBinder.f39353e;
                if (businessLittleStepper != null) {
                    businessLittleStepper.setCurrentNum(itemState.amount);
                }
            }
            LogUtil.m29100d(businessLittleStepperBinder.f39349a, Intrinsics.stringPlus("itemStateMap ----l key:", businessLittleStepperBinder.f39350b));
        }
        if (hashMap == null) {
            BusinessLittleStepper businessLittleStepper2 = businessLittleStepperBinder.f39353e;
            if (businessLittleStepper2 != null) {
                businessLittleStepper2.setCurrentNum(0);
            }
            LogUtil.m29100d(businessLittleStepperBinder.f39349a, Intrinsics.stringPlus("itemStateMap is null:", businessLittleStepperBinder.f39350b));
        }
    }
}
