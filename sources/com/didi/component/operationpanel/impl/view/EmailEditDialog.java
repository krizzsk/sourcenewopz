package com.didi.component.operationpanel.impl.view;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.common.pininput.PinUploader;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.dcrypto.util.DCryptoUtils;
import com.didi.sdk.nation.NationComponentData;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.oneconf.OneConfStore;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.view.SimplePopupBase;
import com.didi.travel.psnger.HostConstants;
import com.didi.travel.psnger.common.net.base.BaseObject;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.utils.TextUtil;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.usercenter.api.UserCenterFacade;
import com.didi.usercenter.entity.UserInfo;
import com.didichuxing.foundation.gson.GsonDeserializer;
import com.didichuxing.foundation.net.rpc.http.annotation.Get;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.didichuxing.foundation.rpc.annotation.Deserialization;
import com.didichuxing.foundation.rpc.annotation.Path;
import com.didichuxing.foundation.rpc.annotation.QueryParameter;
import com.didichuxing.foundation.rpc.annotation.TargetThread;
import com.didichuxing.foundation.rpc.annotation.ThreadType;
import com.taxis99.R;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class EmailEditDialog extends SimplePopupBase {

    /* renamed from: a */
    private View f14801a;

    /* renamed from: b */
    private TextView f14802b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public EditText f14803c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public View f14804d;

    /* renamed from: e */
    private TextView f14805e;

    /* renamed from: f */
    private TextView f14806f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public IBizSpecialRpcService f14807g;

    /* renamed from: h */
    private BaseEventPublisher.OnEventListener f14808h = new BaseEventPublisher.OnEventListener() {
        public void onEvent(String str, Object obj) {
            if ("invoice_send2email_dismiss_dialog".equalsIgnoreCase(str)) {
                EmailEditDialog.this.dismiss();
            }
        }
    };

    public interface IBizSpecialRpcService extends RpcService {
        @Get
        @Path("/scinvoice/global/payment/ru/invoice/v1/passenger/getInvoice")
        @Deserialization(GsonDeserializer.class)
        void getInvoiceStatus(@QueryParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<PinUploader.Response> callback);

        @Get
        @Path("/scinvoice/global/payment/ru/invoice/v1/passenger/receipt/resend")
        @Deserialization(GsonDeserializer.class)
        void sendInvoice2Email(@QueryParameter("") HashMap<String, Object> hashMap, @TargetThread(ThreadType.MAIN) RpcService.Callback<InvoiceSend2EmalResp> callback);
    }

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.receipt_receive_email;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BaseEventPublisher.getPublisher().subscribe("", this.f14808h);
        this.f14807g = (IBizSpecialRpcService) new RpcServiceFactory(getContext()).newRpcService(IBizSpecialRpcService.class, HostConstants.getInvoiceHost());
        setCancelable(false);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        getDialog().getWindow().setSoftInputMode(4);
        return onCreateView;
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    /* access modifiers changed from: protected */
    public void initView() {
        this.f14801a = this.mRootView.findViewById(R.id.email_edit_pannel);
        this.f14802b = (TextView) this.mRootView.findViewById(R.id.email_edit_title);
        this.f14803c = (EditText) this.mRootView.findViewById(R.id.email_input_et);
        this.f14804d = this.mRootView.findViewById(R.id.email_edit_cleaner_img);
        this.f14805e = (TextView) this.mRootView.findViewById(R.id.edit_email_cancel_btn);
        this.f14806f = (TextView) this.mRootView.findViewById(R.id.edit_email_confirm_btn);
        this.f14804d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                EmailEditDialog.this.f14803c.setText("");
            }
        });
        UserInfo userInfo = UserCenterFacade.getIns().getUserInfo(getContext());
        if (userInfo != null && !TextUtil.isEmpty(userInfo.getEmail())) {
            this.f14803c.setText(userInfo.getEmail());
        }
        this.f14803c.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                if (EmailEditDialog.this.f14804d.getVisibility() != 0) {
                    EmailEditDialog.this.f14804d.setVisibility(0);
                }
            }
        });
        this.f14805e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                EmailEditDialog.this.dismiss();
            }
        });
        this.f14806f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                final String obj = EmailEditDialog.this.f14803c.getText() != null ? EmailEditDialog.this.f14803c.getText().toString() : null;
                if (TextUtil.isEmpty(obj)) {
                    ToastHelper.showShortInfo(EmailEditDialog.this.getContext(), EmailEditDialog.this.getString(R.string.Global_Rider_0417_GlobalRider_RU_Send_Receipt_After_the_Trip_mail_address_invalid));
                    return;
                }
                FutureTask futureTask = new FutureTask(new Callable<Boolean>() {
                    public Boolean call() {
                        return Boolean.valueOf(EmailEditDialog.this.m10602a(obj));
                    }
                });
                Executors.newCachedThreadPool().submit(futureTask);
                try {
                    if (!((Boolean) futureTask.get()).booleanValue()) {
                        ToastHelper.showShortInfo(EmailEditDialog.this.getContext(), EmailEditDialog.this.getString(R.string.Global_Rider_0417_GlobalRider_RU_Send_Receipt_After_the_Trip_mail_address_invalid));
                        return;
                    }
                    HashMap a = EmailEditDialog.this.m10600a(CarOrderHelper.getOrder());
                    a.put("email", obj);
                    NationComponentData.LoginInfo loginInfo = NationComponentDataUtil.getLoginInfo();
                    if (!(loginInfo == null || loginInfo.getToken() == null)) {
                        a.put("token", loginInfo.getToken());
                    }
                    EmailEditDialog.this.f14807g.sendInvoice2Email(a, new RpcService.Callback<InvoiceSend2EmalResp>() {
                        public void onSuccess(InvoiceSend2EmalResp invoiceSend2EmalResp) {
                            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Invoice.KEY_INVOICE_EMAIL_SEND_RESPONSE, invoiceSend2EmalResp);
                            EmailEditDialog.this.dismiss();
                        }

                        public void onFailure(IOException iOException) {
                            EmailEditDialog.this.dismiss();
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                    ToastHelper.showShortInfo(EmailEditDialog.this.getContext(), EmailEditDialog.this.getString(R.string.Global_Rider_0417_GlobalRider_RU_Send_Receipt_After_the_Trip_mail_address_invalid));
                } catch (Throwable unused) {
                    ToastHelper.showShortInfo(EmailEditDialog.this.getContext(), EmailEditDialog.this.getString(R.string.Global_Rider_0417_GlobalRider_RU_Send_Receipt_After_the_Trip_mail_address_invalid));
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public HashMap<String, Object> m10600a(CarOrder carOrder) {
        int i;
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("countryCode", NationComponentDataUtil.getPhoneCountryCode());
        hashMap.put("productId", Integer.valueOf(carOrder.productid));
        hashMap.put("lang", NationTypeUtil.getNationComponentData().getLocaleCode());
        hashMap.put("cityId", Integer.valueOf(OneConfStore.getInstance().getCityId()));
        try {
            i = Integer.parseInt(NationTypeUtil.getNationComponentData().getTerminal_id());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            i = -1;
        }
        hashMap.put(DCryptoUtils.PARAMS_KEY_TERMINAL_ID, Integer.valueOf(i));
        hashMap.put("uid", Long.valueOf(Long.parseLong(OneLoginFacade.getStore().getUid())));
        hashMap.put("orderId", carOrder != null ? carOrder.getOid() : "");
        return hashMap;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m10602a(String str) {
        return Pattern.compile("[\\w!#$%&'*+/=?^_`{|}~-]+(?:\\.[\\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\\w](?:[\\w-]*[\\w])?\\.)+[\\w](?:[\\w-]*[\\w])?").matcher(str).matches();
    }

    class InvoiceSend2EmalResp extends BaseObject {
        private Object data;

        InvoiceSend2EmalResp() {
        }

        /* access modifiers changed from: protected */
        public void parse(JSONObject jSONObject) {
            super.parse(jSONObject);
            this.data = jSONObject.optJSONObject("data");
        }
    }
}
