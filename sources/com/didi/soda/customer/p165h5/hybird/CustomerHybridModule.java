package com.didi.soda.customer.p165h5.hybird;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.api.Extend;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.RouterCallback;
import com.didi.onehybrid.BaseHybridModule;
import com.didi.onehybrid.container.HybridableContainer;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.onehybrid.jsbridge.JsInterface;
import com.didi.soda.bill.WebDeliveryPriceModel;
import com.didi.soda.bill.repo.WebDeliveryPriceDetailRepo;
import com.didi.soda.cart.omega.CartGuideDataManager;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.blocks.BlocksConst;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.address.AddressEntity;
import com.didi.soda.customer.foundation.tracker.OmegaCommonParamHelper;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.NumberParseUtil;
import com.didi.soda.customer.foundation.util.ToastUtil;
import com.didi.soda.customer.p165h5.CustomerDidiPassTrackKt;
import com.didi.soda.customer.p165h5.hybird.model.GuideParamModel;
import com.didi.soda.customer.p165h5.hybird.request.WebRequest;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerCartManager;
import com.didi.soda.manager.base.ICustomerHomeManager;
import com.didi.soda.manager.base.ICustomerOrderManager;
import com.didi.soda.web.model.CallBackModel;
import com.didi.soda.web.tools.WebJsBridgeTool;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.JsonSyntaxException;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.didi.soda.customer.h5.hybird.CustomerHybridModule */
public class CustomerHybridModule extends BaseHybridModule {
    public static final String NAME_SPACE = "Customer";

    /* renamed from: a */
    private static final String f41313a = "CustomerHybridModule";

    /* renamed from: b */
    private WebViewModelCallback f41314b;

    /* renamed from: c */
    private CallbackFunction f41315c;

    /* renamed from: d */
    private Activity f41316d;

    public CustomerHybridModule(HybridableContainer hybridableContainer) {
        super(hybridableContainer);
        this.f41316d = hybridableContainer.getActivity();
    }

    @JsInterface({"cancelOrder"})
    public void cancelOrder(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m29104i(f41313a, "cancelOrder");
        if (jSONObject != null) {
            LogUtil.m29104i(f41313a, jSONObject.toString());
            try {
                String string = jSONObject.getString("orderId");
                String string2 = jSONObject.getString("status");
                String optString = jSONObject.optString("statusDesc");
                String optString2 = jSONObject.optString("statusSubDesc");
                LogUtil.m29104i(f41313a, "orderId=" + string + " status" + string2 + " statusDesc=" + optString + "/" + optString2);
                int parseInt = Integer.parseInt(string2);
                if (!TextUtils.isEmpty(string) && parseInt == 901) {
                    ((ICustomerOrderManager) CustomerManagerLoader.loadManager(ICustomerOrderManager.class)).updateOrder2Monitor(string);
                }
                if (callbackFunction == null) {
                    return;
                }
                if (!TextUtils.isEmpty(string)) {
                    callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(0));
                    return;
                }
                callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(1, "param[orderId] is empty", (JSONObject) null)));
            } catch (JSONException e) {
                e.printStackTrace();
                if (callbackFunction != null) {
                    callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(1, e.getMessage(), (JSONObject) null)));
                }
            }
        }
    }

    @JsInterface({"callProtectedPhone"})
    public void callProtectedPhone(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m29104i(f41313a, "callProtectedPhone");
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString("orderId");
                int parseInt = NumberParseUtil.parseInt(jSONObject.getString("type"));
                ScopeContext proviedScopeContext = this.f41314b != null ? this.f41314b.proviedScopeContext() : null;
                LogUtil.m29104i(f41313a, "callContactType=" + 22 + " contactJsRole=" + parseInt);
                ((ICustomerOrderManager) CustomerManagerLoader.loadManager(ICustomerOrderManager.class)).onJsContactAction(this.f41316d, proviedScopeContext, string, 22, parseInt);
                if (callbackFunction != null) {
                    callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(0));
                }
            } catch (Exception e) {
                e.printStackTrace();
                ErrorTracker.create(ErrorConst.ErrorName.PARSE_EXCEPTIONS).addModuleName("hybrid").addErrorType(ErrorTracker.getErrorType(e)).addErrorMsg(ErrorTracker.getExceptionMsg(e)).addParam("content_json", jSONObject.toString()).build().trackError();
                if (callbackFunction != null) {
                    callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(1, e.getMessage(), (JSONObject) null)));
                }
            }
        }
    }

    @JsInterface({"callIM"})
    public void callIM(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m29104i(f41313a, "callIM");
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString("orderId");
                int parseInt = NumberParseUtil.parseInt(jSONObject.getString("type"));
                ScopeContext proviedScopeContext = this.f41314b != null ? this.f41314b.proviedScopeContext() : null;
                LogUtil.m29104i(f41313a, "callContactType=" + 11 + " contactJsRole=" + parseInt);
                ((ICustomerOrderManager) CustomerManagerLoader.loadManager(ICustomerOrderManager.class)).onJsContactAction(this.f41316d, proviedScopeContext, string, 11, parseInt);
                if (callbackFunction != null) {
                    callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(0));
                }
            } catch (Exception e) {
                e.printStackTrace();
                ErrorTracker.create(ErrorConst.ErrorName.PARSE_EXCEPTIONS).addModuleName("hybrid").addErrorType(ErrorTracker.getErrorType(e)).addErrorMsg(ErrorTracker.getExceptionMsg(e)).addParam("content_json", jSONObject.toString()).build().trackError();
                if (callbackFunction != null) {
                    callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(1, e.getMessage(), (JSONObject) null)));
                }
            }
        }
    }

    @JsInterface({"changeReceiveAddress"})
    public void changeReceiveAddress(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m29104i(f41313a, "changeReceiveAddress");
        if (jSONObject != null) {
            try {
                AddressEntity a = m29265a(jSONObject);
                if (a != null) {
                    ((ICustomerHomeManager) CustomerManagerLoader.loadManager(ICustomerHomeManager.class)).refreshHomeByAddress(a, 4);
                }
            } catch (Exception e) {
                e.printStackTrace();
                ErrorTracker.create(ErrorConst.ErrorName.PARSE_EXCEPTIONS).addModuleName("hybrid").addErrorType(ErrorTracker.getErrorType(e)).addErrorMsg(ErrorTracker.getExceptionMsg(e)).addParam("content_json", jSONObject.toString()).build().trackError();
            }
        }
    }

    @JsInterface({"getDeliveryPriceDetail"})
    public void getDeliveryPriceDetail(JSONObject jSONObject, CallbackFunction callbackFunction) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("deliveryPriceDetail", ((WebDeliveryPriceModel) ((WebDeliveryPriceDetailRepo) RepoFactory.getRepo(WebDeliveryPriceDetailRepo.class)).getValue()).deliveryPriceDetail);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (callbackFunction != null) {
            callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(jSONObject2)));
        }
    }

    @JsInterface({"onRiskAuthResult"})
    public void onRiskAuthResult(JSONObject jSONObject) {
        LogUtil.m29104i(f41313a, "onRiskAuthResult");
        WebViewModelCallback webViewModelCallback = this.f41314b;
        if (webViewModelCallback != null) {
            webViewModelCallback.setRiskAuthResult(jSONObject);
        }
    }

    @JsInterface({"onRiskAuthResult"})
    public void onRiskAuthResult(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m29104i(f41313a, "onRiskAuthResult");
        WebViewModelCallback webViewModelCallback = this.f41314b;
        if (webViewModelCallback != null) {
            webViewModelCallback.setRiskAuthResult(jSONObject);
        }
        if (callbackFunction != null) {
            callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(0));
        }
    }

    @JsInterface({"selectCoupon"})
    public void selectCoupon(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m29104i(f41313a, "selectCoupon");
        if (jSONObject != null) {
            LogUtil.m29104i(f41313a, jSONObject.toString());
            try {
                String string = jSONObject.getString("coupon_id");
                String optString = jSONObject.optString("shopId");
                int optInt = jSONObject.optInt("bill_coupon_type", 0);
                String optString2 = jSONObject.optString("relate_id", "");
                if (this.f41314b != null) {
                    this.f41314b.selectCoupon(string, optString, optInt, optString2);
                }
                if (callbackFunction != null) {
                    callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(0));
                }
            } catch (JSONException e) {
                e.printStackTrace();
                if (callbackFunction != null) {
                    callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(1, e.getMessage(), (JSONObject) null)));
                }
            }
        }
    }

    public void setWebViewCallback(WebViewModelCallback webViewModelCallback) {
        this.f41314b = webViewModelCallback;
    }

    @JsInterface({"toast"})
    public void toast(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m29104i(f41313a, BlocksConst.ACTION_TYPE_TOAST);
        if (jSONObject != null) {
            LogUtil.m29104i(f41313a, jSONObject.toString());
            try {
                String string = jSONObject.getString("type");
                String string2 = jSONObject.getString("txt");
                if ("error".equals(string)) {
                    ToastUtil.showCustomerErrorToast(this.f41314b == null ? null : this.f41314b.proviedScopeContext(), string2);
                } else if ("success".equals(string)) {
                    ToastUtil.showCustomerSuccessToast(this.f41314b == null ? null : this.f41314b.proviedScopeContext(), string2);
                } else {
                    ToastUtil.showCustomerErrorToast(this.f41314b == null ? null : this.f41314b.proviedScopeContext(), string2);
                }
                if (callbackFunction != null) {
                    callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(0));
                }
            } catch (JSONException e) {
                e.printStackTrace();
                if (callbackFunction != null) {
                    callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(1, e.getMessage(), (JSONObject) null)));
                }
            }
        }
    }

    @JsInterface({"finishedLoadHtml"})
    public void finishedLoadHtml(JSONObject jSONObject, CallbackFunction callbackFunction) {
        LogUtil.m29104i(f41313a, "finishedLoadHtml");
        WebViewModelCallback webViewModelCallback = this.f41314b;
        if (webViewModelCallback != null) {
            webViewModelCallback.finishedLoadHtml();
        }
    }

    @JsInterface({"queryPayStatus"})
    public void queryPayStatus(JSONObject jSONObject, CallbackFunction callbackFunction) {
        WebViewModelCallback webViewModelCallback = this.f41314b;
        if (webViewModelCallback != null) {
            webViewModelCallback.queryPayStatus(jSONObject, callbackFunction);
        }
    }

    @JsInterface({"registerTrigger"})
    public void registerTrigger(JSONObject jSONObject, CallbackFunction callbackFunction) {
        WebViewModelCallback webViewModelCallback = this.f41314b;
        if (webViewModelCallback != null) {
            CallBackModel callBackModel = new CallBackModel(0, "", webViewModelCallback.registerTrigger(jSONObject));
            if (callbackFunction != null) {
                callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(callBackModel));
            }
        } else if (callbackFunction != null) {
            callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(1));
        }
    }

    @JsInterface({"unregisterTrigger"})
    public void unregisterTrigger(JSONObject jSONObject, CallbackFunction callbackFunction) {
        WebViewModelCallback webViewModelCallback = this.f41314b;
        if (webViewModelCallback != null) {
            webViewModelCallback.unregisterTrigger(jSONObject);
            if (callbackFunction != null) {
                callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(0));
            }
        } else if (callbackFunction != null) {
            callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(1));
        }
    }

    @JsInterface({"updateGlobalCart"})
    public void notifyUpdateGlobalCart(JSONObject jSONObject, CallbackFunction callbackFunction) {
        ((ICustomerCartManager) CustomerManagerLoader.loadManager(ICustomerCartManager.class)).triggerRefreshGlobalCartList();
        if (callbackFunction != null) {
            callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(0));
        }
    }

    @JsInterface({"addCartEvent"})
    public void addCartEvent(JSONObject jSONObject, CallbackFunction callbackFunction) {
        int i;
        try {
            String optString = jSONObject.optString("shopId");
            JSONArray optJSONArray = jSONObject.optJSONArray(FirebaseAnalytics.Param.ITEMS);
            if (optJSONArray != null) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    String optString2 = optJSONObject.optString(BlocksConst.ACTION_PARAMS_ITEM_ID);
                    if (optJSONObject.optInt("amount") == 0) {
                        CartGuideDataManager.Companion.getInstance().deleteItemParams(optString, optString2);
                    }
                }
            }
            i = 0;
        } catch (Exception e) {
            e.printStackTrace();
            i = 1;
        }
        if (callbackFunction != null) {
            callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(i));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    @com.didi.onehybrid.jsbridge.JsInterface({"updateBill"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void notifyBillUpdate(org.json.JSONObject r13, com.didi.onehybrid.jsbridge.CallbackFunction r14) {
        /*
            r12 = this;
            r0 = 0
            r1 = 0
            r2 = 1
            java.lang.String r3 = "actionType"
            r4 = -1
            int r3 = r13.optInt(r3, r4)     // Catch:{ Exception -> 0x007c }
            java.lang.String r4 = "ok"
            if (r3 < 0) goto L_0x0078
            java.lang.String r5 = "mduId"
            if (r3 != r2) goto L_0x0033
            java.lang.String r13 = r13.optString(r5)     // Catch:{ Exception -> 0x007c }
            boolean r3 = android.text.TextUtils.isEmpty(r13)     // Catch:{ Exception -> 0x007c }
            if (r3 == 0) goto L_0x0021
            java.lang.String r4 = "没有传mduId."
            goto L_0x0084
        L_0x0021:
            java.lang.Class<com.didi.soda.manager.base.ICustomerBillManager> r3 = com.didi.soda.manager.base.ICustomerBillManager.class
            com.didi.soda.manager.base.ICustomerManager r3 = com.didi.soda.manager.CustomerManagerLoader.loadManager(r3)     // Catch:{ Exception -> 0x007c }
            com.didi.soda.manager.base.ICustomerBillManager r3 = (com.didi.soda.manager.base.ICustomerBillManager) r3     // Catch:{ Exception -> 0x007c }
            com.didi.soda.customer.foundation.rpc.entity.bill.BillDelItemEntity r5 = new com.didi.soda.customer.foundation.rpc.entity.bill.BillDelItemEntity     // Catch:{ Exception -> 0x007c }
            r5.<init>(r13)     // Catch:{ Exception -> 0x007c }
            r3.dispatchChange(r5)     // Catch:{ Exception -> 0x007c }
        L_0x0031:
            r13 = 0
            goto L_0x0085
        L_0x0033:
            java.lang.String r3 = "cartId"
            java.lang.String r7 = r13.optString(r3)     // Catch:{ Exception -> 0x007c }
            java.lang.String r3 = "shopId"
            java.lang.String r8 = r13.optString(r3)     // Catch:{ Exception -> 0x007c }
            java.lang.String r9 = r13.optString(r5)     // Catch:{ Exception -> 0x007c }
            java.lang.String r3 = "nodeList"
            org.json.JSONArray r13 = r13.optJSONArray(r3)     // Catch:{ Exception -> 0x007c }
            com.didi.soda.customer.foundation.rpc.net.TypeUtil$ParameterizedTypeImpl r3 = new com.didi.soda.customer.foundation.rpc.net.TypeUtil$ParameterizedTypeImpl     // Catch:{ Exception -> 0x007c }
            java.lang.Class<java.util.ArrayList> r5 = java.util.ArrayList.class
            java.lang.reflect.Type[] r6 = new java.lang.reflect.Type[r2]     // Catch:{ Exception -> 0x007c }
            java.lang.Class<com.didi.soda.customer.foundation.rpc.entity.ItemNodeEntity> r10 = com.didi.soda.customer.foundation.rpc.entity.ItemNodeEntity.class
            r6[r1] = r10     // Catch:{ Exception -> 0x007c }
            r3.<init>(r0, r5, r6)     // Catch:{ Exception -> 0x007c }
            java.lang.String r13 = r13.toString()     // Catch:{ Exception -> 0x007c }
            java.lang.Object r13 = com.didi.soda.customer.foundation.util.GsonUtil.fromJson((java.lang.String) r13, (java.lang.reflect.Type) r3)     // Catch:{ Exception -> 0x007c }
            r10 = r13
            java.util.ArrayList r10 = (java.util.ArrayList) r10     // Catch:{ Exception -> 0x007c }
            com.didi.soda.customer.foundation.rpc.entity.bill.BillUpdateParams r13 = new com.didi.soda.customer.foundation.rpc.entity.bill.BillUpdateParams     // Catch:{ Exception -> 0x007c }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x007c }
            r6 = r13
            r6.<init>(r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x007c }
            java.lang.Class<com.didi.soda.manager.base.ICustomerBillManager> r3 = com.didi.soda.manager.base.ICustomerBillManager.class
            com.didi.soda.manager.base.ICustomerManager r3 = com.didi.soda.manager.CustomerManagerLoader.loadManager(r3)     // Catch:{ Exception -> 0x007c }
            com.didi.soda.manager.base.ICustomerBillManager r3 = (com.didi.soda.manager.base.ICustomerBillManager) r3     // Catch:{ Exception -> 0x007c }
            r3.dispatchChange(r13)     // Catch:{ Exception -> 0x007c }
            goto L_0x0031
        L_0x0078:
            java.lang.String r4 = "没有传actionType."
            goto L_0x0084
        L_0x007c:
            r13 = move-exception
            r13.printStackTrace()
            java.lang.String r4 = r13.getMessage()
        L_0x0084:
            r13 = 1
        L_0x0085:
            if (r14 == 0) goto L_0x0097
            com.didi.soda.web.model.CallBackModel r3 = new com.didi.soda.web.model.CallBackModel
            r3.<init>(r13, r4, r0)
            java.lang.Object[] r13 = new java.lang.Object[r2]
            org.json.JSONObject r0 = com.didi.soda.web.tools.WebJsBridgeTool.buildResponse((com.didi.soda.web.model.CallBackModel) r3)
            r13[r1] = r0
            r14.onCallBack(r13)
        L_0x0097:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.p165h5.hybird.CustomerHybridModule.notifyBillUpdate(org.json.JSONObject, com.didi.onehybrid.jsbridge.CallbackFunction):void");
    }

    @JsInterface({"guideParams"})
    public void guideParams(JSONObject jSONObject, CallbackFunction callbackFunction) {
        String str;
        int i;
        JSONObject jSONObject2 = null;
        try {
            GuideParamModel guideParamModel = (GuideParamModel) GsonUtil.fromJson(jSONObject.toString(), GuideParamModel.class);
            if (TextUtils.equals(guideParamModel.action, "get")) {
                Map<String, Object> guideParamMap = OmegaCommonParamHelper.getGuideParamMap();
                if (guideParamMap != null) {
                    jSONObject2 = new JSONObject(guideParamMap);
                }
            } else {
                if (guideParamModel.params != null) {
                    OmegaCommonParamHelper.setLv1RecId(guideParamModel.params.get("lv1_recid"));
                    OmegaCommonParamHelper.setLv1Location(guideParamModel.params.get("lv1_location"));
                    OmegaCommonParamHelper.setLv3Location(guideParamModel.params.get("lv3_location"));
                    OmegaCommonParamHelper.setLv3RecId(guideParamModel.params.get("lv3_recid"));
                }
                if (!TextUtils.isEmpty(guideParamModel.itemId) && !TextUtils.isEmpty(guideParamModel.shopId)) {
                    CartGuideDataManager.Companion.getInstance().getCartGuideParams(guideParamModel.shopId, guideParamModel.itemId);
                }
            }
            str = "ok";
            i = 0;
        } catch (Exception e) {
            e.printStackTrace();
            str = e.getMessage();
            i = 1;
        }
        if (callbackFunction != null) {
            callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(i, str, jSONObject2)));
        }
    }

    @JsInterface({"request"})
    public void transRequest(JSONObject jSONObject, CallbackFunction callbackFunction) {
        try {
            new WebRequest().transRequest(jSONObject, callbackFunction);
        } catch (Exception e) {
            if (callbackFunction != null) {
                callbackFunction.onCallBack(WebJsBridgeTool.buildResponse(new CallBackModel(1, e.getMessage(), (JSONObject) null)));
            }
        }
    }

    @JsInterface({"bindCard"})
    public void bindCard(JSONObject jSONObject, CallbackFunction callbackFunction) {
        WebViewModelCallback webViewModelCallback = this.f41314b;
        if (webViewModelCallback != null) {
            webViewModelCallback.bindCard(jSONObject, callbackFunction);
        }
    }

    @JsInterface({"openUniPay"})
    public void openUniPay(JSONObject jSONObject, CallbackFunction callbackFunction) {
        CustomerDidiPassTrackKt.trackDidiPassPayCk(jSONObject == null ? "null" : jSONObject.toString());
        LogUtil.m29104i(f41313a, "JsInterface openUniPay method");
        if (jSONObject != null) {
            try {
                if (jSONObject.has(Const.PayParams.BIZ_CONTENT_UNDERLINE)) {
                    jSONObject.put(Const.PayParams.BIZ_CONTENT, jSONObject.opt(Const.PayParams.BIZ_CONTENT_UNDERLINE));
                }
                if (jSONObject.has(Const.PayParams.SIGN_TYPE_UNDERLINE)) {
                    jSONObject.put(Const.PayParams.SIGN_TYPE, jSONObject.opt(Const.PayParams.SIGN_TYPE_UNDERLINE));
                }
                if (jSONObject.has("out_trade_id")) {
                    jSONObject.put(Const.PayParams.OUT_TRADE_ID, jSONObject.opt("out_trade_id"));
                }
                this.f41315c = callbackFunction;
                Intent intent = new Intent();
                intent.setPackage(GlobalContext.getContext().getPackageName());
                intent.setAction(Const.PayParams.PAY_ACTIVITY_ACTION);
                Bundle bundle = new Bundle();
                bundle.putSerializable("uni_pay_param", jSONObject.toString());
                intent.putExtras(bundle);
                ((Request) DRouter.build("").putExtra(Extend.START_ACTIVITY_VIA_INTENT, (Parcelable) intent)).start(GlobalContext.getContext(), new RouterCallback.ActivityCallback() {
                    public void onActivityResult(int i, Intent intent) {
                        CustomerHybridModule.this.m29266a(intent);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                LogUtil.m29100d(f41313a, "error message: " + e.toString());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m29266a(Intent intent) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (intent != null) {
                int intExtra = intent.getIntExtra("code", 0);
                String stringExtra = intent.getStringExtra("message");
                jSONObject.put("code", intExtra);
                jSONObject.put("message", stringExtra);
            } else {
                jSONObject.put("code", 0);
                jSONObject.put("message", "");
            }
            CustomerDidiPassTrackKt.trackDidiPassPayCallBack(jSONObject.toString());
            LogUtil.m29104i(f41313a, "didi pass pay callback" + jSONObject.toString());
            if (this.f41315c != null) {
                this.f41315c.onCallBack(jSONObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.m29104i(f41313a, "didi pass pay callback error: " + e.toString());
            CustomerDidiPassTrackKt.trackDidiPassPayCallBack(e.toString());
        }
    }

    /* renamed from: a */
    private AddressEntity m29265a(JSONObject jSONObject) throws JsonSyntaxException {
        AddressEntity addressEntity = new AddressEntity();
        if (jSONObject != null) {
            addressEntity.poi = (AddressEntity.PoiEntity) GsonUtil.fromJson(jSONObject.toString(), AddressEntity.PoiEntity.class);
        }
        return addressEntity;
    }
}
