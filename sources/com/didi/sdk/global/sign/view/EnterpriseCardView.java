package com.didi.sdk.global.sign.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.sdk.global.sign.model.local.EnterprisePayway;
import com.didi.sdk.global.sign.model.local.PaySelItemData;
import com.didi.sdk.global.sign.view.PayMethodBaseFragmentView;
import com.didi.sdk.util.Utils;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.taxis99.R;
import java.util.List;

public class EnterpriseCardView extends LinearLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f36307a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public View f36308b;

    /* renamed from: c */
    private ImageView f36309c;

    /* renamed from: d */
    private TextView f36310d;

    /* renamed from: e */
    private TextView f36311e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public Switch f36312f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public PayMethodBaseFragmentView.PayMethodSelectListener f36313g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public AlertDialogFragment f36314h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public AlertDialogFragment f36315i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public AlertDialogFragment f36316j;

    interface Callback {
        void onClick();
    }

    public EnterpriseCardView(Context context) {
        super(context);
        m25691a(context);
    }

    public EnterpriseCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m25691a(context);
    }

    public EnterpriseCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m25691a(context);
    }

    /* renamed from: a */
    private void m25691a(Context context) {
        this.f36307a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.pay_way_enterprise, this, true);
        this.f36308b = inflate;
        this.f36309c = (ImageView) inflate.findViewById(R.id.iv_paymethod_icon);
        this.f36310d = (TextView) this.f36308b.findViewById(R.id.tv_paymethod_name);
        this.f36311e = (TextView) this.f36308b.findViewById(R.id.tv_paymethod_desc);
        this.f36312f = (Switch) this.f36308b.findViewById(R.id.switch_enterprise_item);
    }

    public void setMethodClickListener(PayMethodBaseFragmentView.PayMethodSelectListener payMethodSelectListener) {
        this.f36313g = payMethodSelectListener;
    }

    public void setData(final List<PaySelItemData> list, EnterprisePayway enterprisePayway) {
        if (enterprisePayway != null) {
            GlideUtils.with2load2into(this.f36307a, enterprisePayway.iconUrl, this.f36309c);
            this.f36310d.setText(enterprisePayway.title);
            if (enterprisePayway.toggle) {
                this.f36311e.setText(enterprisePayway.descEnable);
            } else {
                this.f36311e.setText(enterprisePayway.descDisable);
            }
            this.f36312f.setChecked(enterprisePayway.toggle);
            this.f36308b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    int i;
                    AutoTrackHelper.trackViewOnClick(view);
                    if (!Utils.isFastDoubleClick()) {
                        boolean z = !EnterpriseCardView.this.f36312f.isChecked();
                        PaySelItemData paySelItemData = null;
                        int i2 = 0;
                        if (list != null) {
                            int i3 = 0;
                            i = 0;
                            while (i2 < list.size()) {
                                PaySelItemData paySelItemData2 = (PaySelItemData) list.get(i2);
                                if (paySelItemData2.channelId == 153 && paySelItemData2.isSelected) {
                                    i3 = 1;
                                }
                                if (paySelItemData2.channelId != 153 && paySelItemData2.status == 1 && (i = i + 1) == 1) {
                                    paySelItemData = paySelItemData2;
                                }
                                i2++;
                            }
                            i2 = i3;
                        } else {
                            i = 0;
                        }
                        if (!z || i2 == 0) {
                            EnterpriseCardView.this.m25690a();
                        } else if (i == 0) {
                            EnterpriseCardView enterpriseCardView = EnterpriseCardView.this;
                            enterpriseCardView.m25696b(enterpriseCardView.f36307a);
                        } else if (i != 1) {
                            EnterpriseCardView enterpriseCardView2 = EnterpriseCardView.this;
                            enterpriseCardView2.m25698c(enterpriseCardView2.f36307a);
                        } else {
                            EnterpriseCardView enterpriseCardView3 = EnterpriseCardView.this;
                            enterpriseCardView3.m25692a(enterpriseCardView3.f36307a, paySelItemData);
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25690a() {
        boolean z = !this.f36312f.isChecked();
        this.f36312f.setChecked(z);
        PayMethodBaseFragmentView.PayMethodSelectListener payMethodSelectListener = this.f36313g;
        if (payMethodSelectListener != null) {
            payMethodSelectListener.enterpriseClick(this.f36308b, z);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m25696b(Context context) {
        FragmentManager supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
        if (this.f36314h == null) {
            this.f36314h = m25688a(context, context.getString(R.string.one_payment_global_enterprise_no_card), context.getString(R.string.one_payment_global_enterprise_ok), new Callback() {
                public void onClick() {
                    EnterpriseCardView.this.f36314h.dismiss();
                }
            });
        }
        this.f36314h.show(supportFragmentManager, (String) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m25698c(Context context) {
        FragmentManager supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
        if (this.f36316j == null) {
            this.f36316j = m25688a(context, context.getString(R.string.one_payment_global_enterprise_mul_card), context.getString(R.string.one_payment_global_enterprise_ok), new Callback() {
                public void onClick() {
                    EnterpriseCardView.this.f36316j.dismiss();
                }
            });
        }
        this.f36316j.show(supportFragmentManager, (String) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m25692a(Context context, final PaySelItemData paySelItemData) {
        FragmentManager supportFragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
        Context context2 = context;
        AlertDialogFragment a = m25689a(context2, context.getString(R.string.one_payment_global_enterprise_one_card, new Object[]{paySelItemData.title}), context.getString(R.string.one_payment_global_enterprise_cancel), new Callback() {
            public void onClick() {
                EnterpriseCardView.this.f36315i.dismiss();
            }
        }, context.getString(R.string.one_payment_global_enterprise_ok), new Callback() {
            public void onClick() {
                EnterpriseCardView.this.f36315i.dismiss();
                EnterpriseCardView.this.m25690a();
                if (EnterpriseCardView.this.f36313g != null) {
                    EnterpriseCardView.this.f36313g.updateItemInfo(paySelItemData);
                    EnterpriseCardView.this.f36313g.onClick(EnterpriseCardView.this.f36308b);
                }
            }
        });
        this.f36315i = a;
        a.show(supportFragmentManager, (String) null);
    }

    /* renamed from: a */
    private AlertDialogFragment m25688a(Context context, String str, String str2, Callback callback) {
        return m25689a(context, str, str2, callback, (String) null, (Callback) null);
    }

    /* renamed from: a */
    private AlertDialogFragment m25689a(Context context, String str, String str2, final Callback callback, String str3, final Callback callback2) {
        AlertDialogFragment.Builder builder = new AlertDialogFragment.Builder(context);
        builder.setIcon((int) R.drawable.common_dialog_icon_info);
        builder.setMessage(str);
        builder.setCancelable(false);
        builder.setNegativeButton((CharSequence) str2, (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                callback.onClick();
            }
        });
        if (!(str3 == null || callback2 == null)) {
            builder.setPositiveButton((CharSequence) str3, (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    callback2.onClick();
                }
            }).setDefaultButtonTxtColor(R.color.pay_text_orage).setPositiveButtonDefault();
        }
        return builder.create();
    }
}
