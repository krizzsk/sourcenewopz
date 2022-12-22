package com.didi.sdk.global.sign.view;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.utils.RTLUtil;
import com.didi.sdk.fastframe.util.CollectionUtil;
import com.didi.sdk.global.sign.model.local.EnterprisePayway;
import com.didi.sdk.global.sign.model.local.PaySelGroupData;
import com.didi.sdk.global.sign.model.local.PaySelItemData;
import com.didi.sdk.global.sign.view.helper.ExpandShrinkViewHelper;
import com.didi.sdk.payment.util.PayUtil;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ContainerViewManager {

    /* renamed from: a */
    private Context f36300a;

    /* renamed from: b */
    private ICardViewController f36301b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f36302c = false;

    /* renamed from: d */
    private View.OnClickListener f36303d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public List<PaySelItemData> f36304e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public LinearLayout f36305f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public EnterprisePayway f36306g;

    public interface ICardViewController {
        void addCardView(LinearLayout linearLayout, PaySelItemData paySelItemData, boolean z);

        void addCreditCardAddView(LinearLayout linearLayout, PaySelItemData paySelItemData);

        void addEnterpriseView(LinearLayout linearLayout, List<PaySelItemData> list, EnterprisePayway enterprisePayway);

        void removeCardViews(LinearLayout linearLayout);
    }

    public ContainerViewManager(Context context, ICardViewController iCardViewController) {
        this.f36300a = context;
        this.f36301b = iCardViewController;
        this.f36303d = new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                ContainerViewManager containerViewManager = ContainerViewManager.this;
                boolean unused = containerViewManager.f36302c = !containerViewManager.f36302c;
                ContainerViewManager containerViewManager2 = ContainerViewManager.this;
                containerViewManager2.insertPayMethodView(containerViewManager2.f36305f, ContainerViewManager.this.f36304e, ContainerViewManager.this.f36306g);
            }
        };
    }

    public void insertPayMethodView(LinearLayout linearLayout, List<PaySelItemData> list, EnterprisePayway enterprisePayway) {
        List<PaySelItemData> list2;
        this.f36304e = list;
        this.f36305f = linearLayout;
        this.f36306g = enterprisePayway;
        m25673a(linearLayout);
        if (this.f36305f != null && (list2 = this.f36304e) != null && list2.size() != 0) {
            if (this.f36306g != null) {
                m25676a(linearLayout, this.f36300a.getString(R.string.one_payment_global_select_pay_model));
                ICardViewController iCardViewController = this.f36301b;
                if (iCardViewController != null) {
                    iCardViewController.addEnterpriseView(linearLayout, this.f36304e, this.f36306g);
                }
                m25686d(linearLayout);
                m25676a(linearLayout, this.f36300a.getString(R.string.one_payment_global_select_pay_way));
            }
            int maxDisplayCardIndex = ExpandShrinkViewHelper.getMaxDisplayCardIndex(list, this.f36302c);
            int i = 0;
            while (i < list.size()) {
                int i2 = list.get(i).channelId;
                int i3 = i + 1;
                int i4 = list.get(Math.min(list.size() - 1, i3)).channelId;
                if (i2 != 150) {
                    if (i2 == 153 || i2 == 154) {
                        m25674a(linearLayout, list.get(i));
                        if (i2 != i4) {
                            if (i4 == 153 || i4 == 154) {
                                m25681b(linearLayout);
                            } else {
                                m25686d(linearLayout);
                            }
                        }
                    } else {
                        m25674a(linearLayout, list.get(i));
                        if (i < list.size()) {
                            m25686d(linearLayout);
                        }
                    }
                } else if (i > maxDisplayCardIndex) {
                    m25675a(linearLayout, list.get(i), false);
                } else {
                    m25674a(linearLayout, list.get(i));
                    if (i == maxDisplayCardIndex) {
                        if (ExpandShrinkViewHelper.isShowSwitchView(list)) {
                            m25681b(linearLayout);
                            View a = m25672a(linearLayout, this.f36302c);
                            if (a != null) {
                                a.setOnClickListener(this.f36303d);
                            }
                        }
                        if (i < list.size() - 1) {
                            m25686d(linearLayout);
                        }
                    } else {
                        m25681b(linearLayout);
                    }
                }
                i = i3;
            }
        }
    }

    public void insertPayMethodViewByGroup(LinearLayout linearLayout, List<PaySelItemData> list, List<PaySelGroupData> list2, EnterprisePayway enterprisePayway) {
        if (linearLayout != null && !CollectionUtil.isEmpty((Collection) list) && !CollectionUtil.isEmpty((Collection) list2)) {
            this.f36304e = list;
            this.f36305f = linearLayout;
            this.f36306g = enterprisePayway;
            m25673a(linearLayout);
            if (this.f36306g != null) {
                m25676a(linearLayout, this.f36300a.getString(R.string.one_payment_global_select_pay_model));
                ICardViewController iCardViewController = this.f36301b;
                if (iCardViewController != null) {
                    iCardViewController.addEnterpriseView(linearLayout, this.f36304e, this.f36306g);
                }
                m25686d(linearLayout);
                m25676a(linearLayout, this.f36300a.getString(R.string.one_payment_global_select_pay_way));
            }
            HashMap hashMap = new HashMap();
            ArrayList arrayList = new ArrayList();
            for (PaySelItemData next : this.f36304e) {
                if (next != null) {
                    if (next.channelId != 150 || TextUtils.isEmpty(next.cardIndex)) {
                        hashMap.put(Integer.valueOf(next.channelId), next);
                    } else {
                        arrayList.add(next);
                    }
                }
            }
            m25677a(linearLayout, list2, hashMap, arrayList);
            if (!CollectionUtil.isEmpty((Map) hashMap)) {
                int i = 0;
                for (PaySelItemData a : hashMap.values()) {
                    m25674a(linearLayout, a);
                    if (i != list.size() - 1) {
                        m25681b(linearLayout);
                    }
                    i++;
                }
            }
        }
    }

    /* renamed from: a */
    private void m25677a(LinearLayout linearLayout, List<PaySelGroupData> list, Map<Integer, PaySelItemData> map, List<PaySelItemData> list2) {
        PaySelItemData createGroupHeaderItem;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (int i = 0; i < list.size(); i++) {
            PaySelGroupData paySelGroupData = list.get(i);
            if (!(paySelGroupData == null || paySelGroupData.channelIds == null || paySelGroupData.channelIds.length == 0 || (createGroupHeaderItem = createGroupHeaderItem(paySelGroupData)) == null)) {
                ArrayList arrayList = new ArrayList();
                for (int i2 : paySelGroupData.channelIds) {
                    PaySelItemData remove = map.remove(Integer.valueOf(i2));
                    if (remove != null) {
                        if (i2 == 150 && list2 != null) {
                            arrayList.addAll(list2);
                        }
                        arrayList.add(remove);
                    }
                }
                linkedHashMap.put(createGroupHeaderItem, arrayList);
            }
        }
        if (!CollectionUtil.isEmpty((Map) linkedHashMap)) {
            for (PaySelItemData paySelItemData : linkedHashMap.keySet()) {
                List list3 = (List) linkedHashMap.get(paySelItemData);
                if (list3 != null) {
                    m25674a(linearLayout, paySelItemData);
                    for (int i3 = 0; i3 < list3.size(); i3++) {
                        PaySelItemData paySelItemData2 = (PaySelItemData) list3.get(i3);
                        if (paySelItemData2 != null) {
                            paySelItemData2.isTitleBold = false;
                            if (paySelItemData2.isAddCreditCard()) {
                                m25684c(linearLayout);
                                m25682b(linearLayout, paySelItemData2);
                            } else {
                                m25681b(linearLayout);
                                paySelItemData2.iconUrl = null;
                                m25674a(linearLayout, paySelItemData2);
                            }
                        }
                    }
                    m25686d(linearLayout);
                }
            }
        }
    }

    public PaySelItemData createGroupHeaderItem(PaySelGroupData paySelGroupData) {
        if (paySelGroupData == null) {
            return null;
        }
        PaySelItemData paySelItemData = new PaySelItemData();
        paySelItemData.iconUrl = paySelGroupData.iconUrl;
        paySelItemData.title = paySelGroupData.name;
        paySelItemData.style = 0;
        return paySelItemData;
    }

    public void insertPromotionView(LinearLayout linearLayout, List<PaySelItemData> list) {
        m25673a(linearLayout);
        for (int i = 0; i < list.size(); i++) {
            m25674a(linearLayout, list.get(i));
            if (i != list.size() - 1) {
                m25681b(linearLayout);
            }
        }
    }

    /* renamed from: a */
    private void m25674a(LinearLayout linearLayout, PaySelItemData paySelItemData) {
        m25675a(linearLayout, paySelItemData, true);
    }

    /* renamed from: a */
    private void m25675a(LinearLayout linearLayout, PaySelItemData paySelItemData, boolean z) {
        ICardViewController iCardViewController = this.f36301b;
        if (iCardViewController != null && linearLayout != null && paySelItemData != null) {
            iCardViewController.addCardView(linearLayout, paySelItemData, z);
        }
    }

    /* renamed from: b */
    private void m25682b(LinearLayout linearLayout, PaySelItemData paySelItemData) {
        ICardViewController iCardViewController = this.f36301b;
        if (iCardViewController != null && linearLayout != null && paySelItemData != null) {
            iCardViewController.addCreditCardAddView(linearLayout, paySelItemData);
        }
    }

    /* renamed from: a */
    private void m25673a(LinearLayout linearLayout) {
        ICardViewController iCardViewController = this.f36301b;
        if (iCardViewController != null && linearLayout != null) {
            iCardViewController.removeCardViews(linearLayout);
        }
    }

    /* renamed from: b */
    private void m25681b(LinearLayout linearLayout) {
        if (linearLayout != null) {
            View view = new View(this.f36300a);
            view.setBackgroundColor(this.f36300a.getResources().getColor(R.color.one_payment_04000000));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 1);
            layoutParams.setMargins(PayUtil.dip2px(this.f36300a, 18.0f), 0, 0, 0);
            if (RTLUtil.isInRTLMode()) {
                layoutParams.setMarginStart(PayUtil.dip2px(this.f36300a, 18.0f));
            }
            linearLayout.addView(view, layoutParams);
        }
    }

    /* renamed from: c */
    private void m25684c(LinearLayout linearLayout) {
        if (linearLayout != null) {
            View view = new View(this.f36300a);
            view.setBackgroundColor(this.f36300a.getResources().getColor(R.color.one_payment_04000000));
            linearLayout.addView(view, new LinearLayout.LayoutParams(-1, 1));
        }
    }

    /* renamed from: d */
    private void m25686d(LinearLayout linearLayout) {
        if (linearLayout != null) {
            View view = new View(this.f36300a);
            view.setBackgroundColor(this.f36300a.getResources().getColor(R.color.one_payment_wallet_bg));
            linearLayout.addView(view, new LinearLayout.LayoutParams(-1, PayUtil.dip2px(this.f36300a, 10.0f)));
        }
    }

    /* renamed from: a */
    private void m25676a(LinearLayout linearLayout, String str) {
        if (linearLayout != null) {
            TextView textView = new TextView(this.f36300a);
            textView.setBackgroundColor(this.f36300a.getResources().getColor(R.color.one_payment_wallet_bg));
            textView.setText(str);
            if (RTLUtil.isInRTLMode()) {
                textView.setGravity(GravityCompat.START);
                if (Build.VERSION.SDK_INT >= 17) {
                    textView.setTextDirection(5);
                    textView.setTextAlignment(5);
                }
            }
            textView.setTextSize(2, 14.0f);
            linearLayout.addView(textView, new LinearLayout.LayoutParams(-1, PayUtil.dip2px(this.f36300a, 20.0f)));
        }
    }

    /* renamed from: a */
    private View m25672a(LinearLayout linearLayout, boolean z) {
        if (linearLayout == null) {
            return null;
        }
        ExpandShrinkView expandShrinkView = new ExpandShrinkView(this.f36300a);
        expandShrinkView.setIsExpand(z);
        linearLayout.addView(expandShrinkView);
        return expandShrinkView;
    }
}
