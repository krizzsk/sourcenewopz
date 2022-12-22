package com.didi.component.service.util.verifycard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.creditcard.open.DidiGlobalCheckCardData;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.didi.travel.psnger.model.response.CarOrder;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class VerifyCardDialogBuilder {
    public static final int STATUS_FAILED = 2;
    public static final int STATUS_SUCCESS = 1;
    public static final int STATUS_VERIFY = 0;

    /* renamed from: a */
    private static final Map<Integer, Integer> f15779a;

    /* renamed from: b */
    private int f15780b;

    /* renamed from: c */
    private Context f15781c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public IDialogOperation f15782d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public IVerifyOperation f15783e;

    static {
        HashMap hashMap = new HashMap();
        f15779a = hashMap;
        hashMap.put(0, Integer.valueOf(R.layout.global_dialog_verify_card));
        Map<Integer, Integer> map = f15779a;
        Integer valueOf = Integer.valueOf(R.layout.global_dialog_verify_result);
        map.put(1, valueOf);
        f15779a.put(2, valueOf);
    }

    public VerifyCardDialogBuilder(Context context) {
        this.f15781c = context;
    }

    public void setDialogStatus(int i) {
        this.f15780b = i;
    }

    public void setDialogOperation(IDialogOperation iDialogOperation) {
        this.f15782d = iDialogOperation;
    }

    public void setVerifyOperation(IVerifyOperation iVerifyOperation) {
        this.f15783e = iVerifyOperation;
    }

    public AlertDialogFragment.Builder buildDialog(final CarOrder carOrder) {
        final View inflate = LayoutInflater.from(this.f15781c).inflate(f15779a.get(Integer.valueOf(this.f15780b)).intValue(), (ViewGroup) null, false);
        m11511a(inflate);
        ((TextView) inflate.findViewById(R.id.content)).setText(carOrder.getErrorMsg());
        ((TextView) inflate.findViewById(R.id.input_tips)).setText(ResourcesHelper.getString(this.f15781c, R.string.global_dialog_verify_card_verify_tip, carOrder.cardSuffix));
        ((TextView) inflate.findViewById(R.id.tail_id)).setText(carOrder.cardSuffix);
        return new AlertDialogFragment.Builder(this.f15781c).setPositiveButton((CharSequence) ResourcesHelper.getString(this.f15781c, R.string.global_dialog_verify_card_verify), (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
            public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                DidiGlobalCheckCardData.CheckCardParam checkCardParam = new DidiGlobalCheckCardData.CheckCardParam();
                EditText editText = (EditText) inflate.findViewById(R.id.edit);
                if (!(editText == null || editText.getText() == null)) {
                    checkCardParam.cardNo = editText.getText() + carOrder.cardSuffix;
                }
                VerifyCardDialogBuilder.this.f15783e.onVerify(checkCardParam);
            }
        }).setPositiveButtonDefault().setContentView(inflate);
    }

    /* renamed from: a */
    private void m11511a(View view) {
        view.findViewById(R.id.close_button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (VerifyCardDialogBuilder.this.f15782d != null) {
                    VerifyCardDialogBuilder.this.f15782d.cancelDismiss();
                }
            }
        });
        ((TextView) view.findViewById(R.id.title)).setText(ResourcesHelper.getString(this.f15781c, R.string.global_dialog_verify_card_verificatioin_of_information));
    }

    public AlertDialogFragment.Builder buildDialog() {
        View inflate = LayoutInflater.from(this.f15781c).inflate(f15779a.get(Integer.valueOf(this.f15780b)).intValue(), (ViewGroup) null, false);
        m11511a(inflate);
        AlertDialogFragment.Builder builder = new AlertDialogFragment.Builder(this.f15781c);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.icon);
        int i = this.f15780b;
        if (i == 1) {
            imageView.setImageResource(R.drawable.dialog_success_icon);
            ((TextView) inflate.findViewById(R.id.content)).setText(ResourcesHelper.getString(this.f15781c, R.string.global_dialog_verify_card_success));
            inflate.findViewById(R.id.fucktail).setVisibility(8);
            return builder.setPositiveButton((CharSequence) ResourcesHelper.getString(this.f15781c, R.string.global_dialog_verify_card_confirm), (AlertDialogFragment.OnClickListener) new AlertDialogFragment.OnClickListener() {
                public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                    if (VerifyCardDialogBuilder.this.f15782d != null) {
                        VerifyCardDialogBuilder.this.f15782d.dismiss();
                    }
                    if (VerifyCardDialogBuilder.this.f15783e != null) {
                        VerifyCardDialogBuilder.this.f15783e.onSuccess();
                    }
                }
            }).setPositiveButtonDefault().setContentView(inflate);
        } else if (i != 2) {
            return builder;
        } else {
            imageView.setImageResource(R.drawable.dialog_failed_icon);
            ((TextView) inflate.findViewById(R.id.content)).setText(ResourcesHelper.getString(this.f15781c, R.string.global_dialog_verify_card_failed));
            inflate.findViewById(R.id.fucktail).setVisibility(0);
            TextView textView = (TextView) inflate.findViewById(R.id.button1);
            textView.setText(ResourcesHelper.getString(this.f15781c, R.string.global_dialog_verify_card_try_again));
            textView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (VerifyCardDialogBuilder.this.f15783e != null) {
                        VerifyCardDialogBuilder.this.f15783e.onReVerfiry();
                    }
                }
            });
            TextView textView2 = (TextView) inflate.findViewById(R.id.button2);
            textView2.setText(ResourcesHelper.getString(this.f15781c, R.string.global_dialog_verify_card_change_payment_methods));
            textView2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (VerifyCardDialogBuilder.this.f15783e != null) {
                        VerifyCardDialogBuilder.this.f15783e.onChangePayMethod();
                    }
                }
            });
            return builder.setContentView(inflate);
        }
    }
}
