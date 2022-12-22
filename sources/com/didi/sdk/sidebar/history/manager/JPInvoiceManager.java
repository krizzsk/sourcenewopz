package com.didi.sdk.sidebar.history.manager;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.entrega.customer.foundation.tracker.param.ParamConst;
import com.didi.sdk.config.commonconfig.p149sp.CommonConfigSp;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.push.http.BaseObject;
import com.didi.sdk.sidebar.history.MoreInvoiceFragmentDialog;
import com.didi.sdk.sidebar.history.model.InvoiceOrder;
import com.didi.sdk.sidebar.history.store.HistoryRecordStore;
import com.didi.sdk.sidebar.history.util.HistoryUtils;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.listener.LoginListeners;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.usercenter.api.UserCenterFacade;
import com.didi.usercenter.entity.UserInfo;
import com.didichuxing.foundation.rpc.RpcService;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.taxis99.R;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JPInvoiceManager {
    public static final int FROM_ENDSERVICE = 1;
    public static final int FROM_HISOTRY = 0;

    /* renamed from: a */
    private static final int f37365a = 1001;

    /* renamed from: b */
    private static final int f37366b = 1002;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public MoreInvoiceFragmentDialog f37367c;
    public Context context;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public ICallback f37368d;

    /* renamed from: e */
    private FragmentManager f37369e;

    /* renamed from: f */
    private List<InvoiceOrder> f37370f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f37371g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public int f37372h = 0;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public long f37373i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f37374j = 0;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public String f37375k = "";
    /* access modifiers changed from: private */

    /* renamed from: l */
    public String f37376l = "";
    /* access modifiers changed from: private */

    /* renamed from: m */
    public String f37377m = "";

    /* renamed from: n */
    private int f37378n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public Handler f37379o = new Handler() {
        public void handleMessage(Message message) {
            long j;
            super.handleMessage(message);
            try {
                j = ((Long) message.obj).longValue();
            } catch (Exception e) {
                e.printStackTrace();
                j = 0;
            }
            if (JPInvoiceManager.this.f37373i == j) {
                if (JPInvoiceManager.this.f37371g) {
                    int i = message.what;
                    if (i == 1001) {
                        JPInvoiceManager.m26578c(JPInvoiceManager.this);
                        JPInvoiceManager jPInvoiceManager = JPInvoiceManager.this;
                        jPInvoiceManager.m26565a(jPInvoiceManager.f37372h);
                    } else if (i == 1002) {
                        JPInvoiceManager.this.f37368d.onFail();
                        JPInvoiceManager.this.f37368d.hideLoading();
                        int unused = JPInvoiceManager.this.f37372h = 0;
                        long unused2 = JPInvoiceManager.this.f37373i = 0;
                    }
                } else {
                    JPInvoiceManager.this.f37368d.hideLoading();
                    int unused3 = JPInvoiceManager.this.f37372h = 0;
                    long unused4 = JPInvoiceManager.this.f37373i = 0;
                }
            }
        }
    };

    public interface ICallback {
        void hideLoading();

        void onFail();

        void onSuccess();

        void showLoading();
    }

    /* renamed from: c */
    static /* synthetic */ int m26578c(JPInvoiceManager jPInvoiceManager) {
        int i = jPInvoiceManager.f37372h;
        jPInvoiceManager.f37372h = i + 1;
        return i;
    }

    public JPInvoiceManager(Context context2, ICallback iCallback, int i) {
        this.context = context2;
        this.f37368d = iCallback;
        this.f37378n = i;
    }

    public void sendJPInvoice(FragmentManager fragmentManager, List<InvoiceOrder> list) {
        this.f37368d.showLoading();
        this.f37369e = fragmentManager;
        this.f37370f = list;
        this.f37371g = true;
        this.f37372h = 0;
        long currentTimeMillis = System.currentTimeMillis();
        this.f37373i = currentTimeMillis;
        m26566a(currentTimeMillis);
        m26576b(this.f37373i);
    }

    public void onStart() {
        this.f37371g = true;
    }

    public void onStop() {
        this.f37371g = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26565a(int i) {
        if (i == 2) {
            this.f37368d.hideLoading();
            String str = CommonConfigSp.getInstance().get(CommonConfigSp.KEY_COMMON_LASTTITLE, "");
            if (TextUtils.isEmpty(str)) {
                str = this.f37377m;
            }
            String str2 = str;
            try {
                if (TextUtils.isEmpty(this.f37375k)) {
                    OneLoginFacade.getAction().go2ModifyEmail(this.context, (LoginListeners.ModifyEmailListener) null);
                    return;
                }
                m26567a(this.f37369e, this.f37370f, str2, this.f37376l, this.f37375k, this.f37374j);
            } catch (Exception unused) {
                this.f37368d.onFail();
            }
        }
    }

    /* renamed from: a */
    private void m26566a(final long j) {
        UserCenterFacade.getIns().fetchUserInfo(this.context, NationTypeUtil.getNationComponentData().getLoginInfo().getToken(), NationTypeUtil.getNationComponentData().getGLang(), new RpcService.Callback<UserInfo>() {
            public void onSuccess(UserInfo userInfo) {
                if (userInfo != null) {
                    String unused = JPInvoiceManager.this.f37375k = userInfo.getEmail();
                    String unused2 = JPInvoiceManager.this.f37377m = userInfo.getLast_name();
                    Message obtainMessage = JPInvoiceManager.this.f37379o.obtainMessage();
                    obtainMessage.what = 1001;
                    obtainMessage.obj = Long.valueOf(j);
                    JPInvoiceManager.this.f37379o.sendMessage(obtainMessage);
                    return;
                }
                Message obtainMessage2 = JPInvoiceManager.this.f37379o.obtainMessage();
                obtainMessage2.what = 1002;
                obtainMessage2.obj = Long.valueOf(j);
                JPInvoiceManager.this.f37379o.sendMessage(obtainMessage2);
            }

            public void onFailure(IOException iOException) {
                Message obtainMessage = JPInvoiceManager.this.f37379o.obtainMessage();
                obtainMessage.what = 1002;
                obtainMessage.obj = Long.valueOf(j);
                JPInvoiceManager.this.f37379o.sendMessage(obtainMessage);
            }
        });
    }

    /* renamed from: b */
    private void m26576b(final long j) {
        OneLoginFacade.getFunction().getEmailStatus(this.context, new LoginListeners.EmailStatusListener() {
            public void onSucc(int i, String str) {
                int unused = JPInvoiceManager.this.f37374j = i;
                String unused2 = JPInvoiceManager.this.f37376l = str;
                Message obtainMessage = JPInvoiceManager.this.f37379o.obtainMessage();
                obtainMessage.what = 1001;
                obtainMessage.obj = Long.valueOf(j);
                JPInvoiceManager.this.f37379o.sendMessage(obtainMessage);
            }

            public void onFail(IOException iOException) {
                Message obtainMessage = JPInvoiceManager.this.f37379o.obtainMessage();
                obtainMessage.what = 1002;
                obtainMessage.obj = Long.valueOf(j);
                JPInvoiceManager.this.f37379o.sendMessage(obtainMessage);
            }
        });
    }

    /* renamed from: a */
    private void m26567a(FragmentManager fragmentManager, final List<InvoiceOrder> list, String str, String str2, final String str3, final int i) {
        if (list == null || list.isEmpty()) {
            this.f37368d.onFail();
        } else if (TextUtils.isEmpty(str2)) {
            this.f37368d.onFail();
        } else {
            if (this.f37367c == null) {
                MoreInvoiceFragmentDialog moreInvoiceFragmentDialog = new MoreInvoiceFragmentDialog();
                this.f37367c = moreInvoiceFragmentDialog;
                moreInvoiceFragmentDialog.setCancelable(false);
                this.f37367c.setEditListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        OneLoginFacade.getAction().go2ModifyEmail(JPInvoiceManager.this.context, (LoginListeners.ModifyEmailListener) null);
                        JPInvoiceManager.this.f37367c.dismiss();
                        JPInvoiceManager.this.m26571a("JP_pas_receipt_verify_changeEmail_ck");
                    }
                });
                this.f37367c.setRightOnclickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (i == 1) {
                            JPInvoiceManager.this.m26572a(str3, (List<InvoiceOrder>) list);
                            HashMap hashMap = new HashMap();
                            if (TextUtils.equals(JPInvoiceManager.this.f37377m, JPInvoiceManager.this.f37367c.getTitle())) {
                                hashMap.put("nameChange", "0");
                            } else {
                                hashMap.put("nameChange", "1");
                            }
                            JPInvoiceManager.this.m26573a("JP_pas_receipt_verify_confirm_ck", (Map<String, Object>) hashMap);
                            return;
                        }
                        OneLoginFacade.getAction().go2ModifyEmail(JPInvoiceManager.this.context, (LoginListeners.ModifyEmailListener) null);
                        JPInvoiceManager.this.f37367c.dismiss();
                        JPInvoiceManager.this.m26571a("JP_pas_receipt_verify_ck");
                    }
                });
                this.f37367c.setOnCancelListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        JPInvoiceManager.this.m26571a("JP_pas_receipt_verify_cancel_ck");
                    }
                });
            }
            this.f37367c.setUIData(str, str2, list.size(), i);
            this.f37367c.show(fragmentManager, "invoice");
            HashMap hashMap = new HashMap();
            if (i == 1) {
                hashMap.put("status", LoginOmegaUtil.NEED_VERIFY_EMAIL);
            } else {
                hashMap.put("status", "unverified");
            }
            m26573a("JP_pas_receipt_sw", (Map<String, Object>) hashMap);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26572a(String str, List<InvoiceOrder> list) {
        String title = this.f37367c.getTitle();
        if (!HistoryUtils.emailFormatOk(str)) {
            Context context2 = this.context;
            ToastHelper.showShortInfo(context2, context2.getString(R.string.history_email_format_error));
        } else if (TextUtils.isEmpty(title)) {
            Context context3 = this.context;
            ToastHelper.showShortInfo(context3, context3.getString(R.string.global_invoice_email_title_tips));
        } else {
            CommonConfigSp.getInstance().put(CommonConfigSp.KEY_COMMON_LASTTITLE, title);
            OmegaSDKAdapter.trackEvent("pas_mytrip_boot_ck");
            this.f37368d.showLoading();
            HistoryRecordStore.getInstance().getInvoice(this.context, str, title, list, new RpcService.Callback<BaseObject>() {
                public void onSuccess(BaseObject baseObject) {
                    JPInvoiceManager.this.f37368d.hideLoading();
                    if (baseObject == null || baseObject.errno != 0) {
                        JPInvoiceManager.this.f37368d.onFail();
                    } else {
                        JPInvoiceManager.this.f37368d.onSuccess();
                    }
                }

                public void onFailure(IOException iOException) {
                    JPInvoiceManager.this.f37368d.hideLoading();
                    JPInvoiceManager.this.f37368d.onFail();
                }
            });
            this.f37367c.dismiss();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26571a(String str) {
        m26573a(str, (Map<String, Object>) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26573a(String str, Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        int i = this.f37378n;
        if (i == 0) {
            hashMap.put("source", ParamConst.PARAM_ORDER_LIST);
        } else if (i == 1) {
            hashMap.put("source", "order_detail");
        }
        if (!CollectionUtil.isEmpty((Map<?, ?>) map)) {
            hashMap.putAll(map);
        }
        OmegaSDKAdapter.trackEvent(str, (Map<String, Object>) hashMap);
    }
}
