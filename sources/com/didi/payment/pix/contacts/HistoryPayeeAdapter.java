package com.didi.payment.pix.contacts;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.didi.payment.pix.contacts.p134vm.model.PayeeItem;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.collection.CollectionUtil;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class HistoryPayeeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Context f31021a;

    /* renamed from: b */
    private List<PayeeItem> f31022b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ContactItemListener f31023c;

    /* renamed from: d */
    private final int f31024d = 0;

    /* renamed from: e */
    private final int f31025e = 1;

    /* renamed from: f */
    private final int f31026f = 2;

    public interface ContactItemListener {
        void onContactItemClick(PayeeItem payeeItem);

        void onLastItemVisible();
    }

    public HistoryPayeeAdapter(Context context, ContactItemListener contactItemListener) {
        this.f31021a = context;
        this.f31023c = contactItemListener;
    }

    public void setList(List<PayeeItem> list) {
        this.f31022b = list;
        notifyDataSetChanged();
    }

    public void appendData(List<PayeeItem> list) {
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            if (this.f31022b == null) {
                this.f31022b = new ArrayList();
            }
            this.f31022b.addAll(list);
            notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    private PayeeItem m21811a(int i) {
        if (CollectionUtil.isEmpty((Collection<?>) this.f31022b) || this.f31022b.size() <= i) {
            return null;
        }
        return this.f31022b.get(i);
    }

    public void foldGroupItem(PayeeItem payeeItem) {
        int indexOf = this.f31022b.indexOf(payeeItem);
        if (indexOf >= 0) {
            payeeItem.displayStyle = 0;
            while (true) {
                indexOf++;
                if (indexOf >= this.f31022b.size()) {
                    break;
                }
                PayeeItem payeeItem2 = this.f31022b.get(indexOf);
                if (TextUtil.isEmpty(payeeItem.cpf) || TextUtil.isEmpty(payeeItem2.cpf) || !payeeItem.cpf.equals(payeeItem2.cpf) || !payeeItem2.isChild) {
                    break;
                }
                payeeItem2.visibility = 8;
            }
            notifyDataSetChanged();
        }
    }

    public void expandChildItems(PayeeItem payeeItem) {
        int indexOf = this.f31022b.indexOf(payeeItem);
        if (indexOf >= 0) {
            payeeItem.displayStyle = 1;
            for (int i = indexOf + 1; i < this.f31022b.size(); i++) {
                PayeeItem payeeItem2 = this.f31022b.get(i);
                if (TextUtil.isEmpty(payeeItem.cpf) || TextUtil.isEmpty(payeeItem2.cpf) || !payeeItem.cpf.equals(payeeItem2.cpf)) {
                    break;
                }
                payeeItem2.visibility = 0;
            }
            notifyDataSetChanged();
        }
    }

    public HistoryContactViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 0 || i == 1) {
            return new HistoryContactViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pix_histrans_contact_item, viewGroup, false));
        }
        return new ViewHolder4Child(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pix_histrans_contact_item, viewGroup, false));
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        boolean z = true;
        if (i != getItemCount() - 1) {
            z = false;
        }
        ((HistoryContactViewHolder) viewHolder).bind(m21813b(i), z);
    }

    /* renamed from: b */
    private PayeeItem m21813b(int i) {
        if (CollectionUtil.isEmpty((Collection<?>) this.f31022b)) {
            return null;
        }
        int i2 = 0;
        for (PayeeItem next : this.f31022b) {
            if (next.visibility == 0) {
                if (i2 == i) {
                    return next;
                }
                i2++;
            }
        }
        return null;
    }

    public int getItemCount() {
        int i = 0;
        if (CollectionUtil.isEmpty((Collection<?>) this.f31022b)) {
            return 0;
        }
        for (PayeeItem payeeItem : this.f31022b) {
            if (payeeItem.visibility == 0) {
                i++;
            }
        }
        return i;
    }

    public int getItemViewType(int i) {
        PayeeItem payeeItem;
        Iterator<PayeeItem> it = this.f31022b.iterator();
        int i2 = 0;
        while (true) {
            if (!it.hasNext()) {
                payeeItem = null;
                break;
            }
            payeeItem = it.next();
            if (payeeItem.visibility == 0) {
                if (i2 == i) {
                    break;
                }
                i2++;
            }
        }
        if (payeeItem.isChild || payeeItem.childCount <= 1) {
            return 2;
        }
        if (payeeItem.displayStyle == 1) {
            return 1;
        }
        return 0;
    }

    class HistoryContactViewHolder extends RecyclerView.ViewHolder {
        TextView childCountTv;
        PayeeItem data;
        ImageView expandIndicatorImg;
        TextView headIconTv;
        ImageView headImg;
        TextView nameTv;
        TextView pixKeyTv;

        public HistoryContactViewHolder(View view) {
            super(view);
            this.headIconTv = (TextView) view.findViewById(R.id.pix_contact_head_icon_tv);
            this.nameTv = (TextView) view.findViewById(R.id.pix_contact_name_tv);
            this.pixKeyTv = (TextView) view.findViewById(R.id.pix_key_value_tv);
            this.childCountTv = (TextView) view.findViewById(R.id.child_count_tv);
            this.headImg = (ImageView) view.findViewById(R.id.pix_contact_head_icon_img);
            this.expandIndicatorImg = (ImageView) view.findViewById(R.id.expand_indicator_img);
            view.setOnClickListener(new DoubleCheckOnClickListener(HistoryPayeeAdapter.this) {
                public void doClick(View view) {
                    if (HistoryPayeeAdapter.this.f31023c != null) {
                        HistoryPayeeAdapter.this.f31023c.onContactItemClick(HistoryContactViewHolder.this.data);
                    }
                }
            });
        }

        public void bind(PayeeItem payeeItem, boolean z) {
            if (payeeItem != null) {
                this.data = payeeItem;
                if (!TextUtil.isEmpty(payeeItem.icon)) {
                    if (this.headImg.getVisibility() != 0) {
                        this.headImg.setVisibility(0);
                    }
                    GlideUtils.loadCircleImageWithDefaultImg(HistoryPayeeAdapter.this.f31021a, Uri.parse(payeeItem.icon), R.drawable.pay_icon_contacts, this.headImg);
                } else if (!TextUtil.isEmpty(payeeItem.name)) {
                    if (this.headIconTv.getVisibility() != 0) {
                        this.headIconTv.setVisibility(0);
                    }
                    this.headIconTv.setText(payeeItem.name.substring(0, 1));
                }
                if (!TextUtil.isEmpty(payeeItem.name)) {
                    this.nameTv.setText(payeeItem.name);
                }
                if (payeeItem.childCount > 1) {
                    this.childCountTv.setText(String.valueOf(payeeItem.childCount));
                    this.childCountTv.setVisibility(0);
                    this.expandIndicatorImg.setVisibility(0);
                    if (payeeItem.displayStyle == 0) {
                        this.expandIndicatorImg.setImageResource(R.drawable.pix_icon_indicator_expand_arrow);
                    } else {
                        this.expandIndicatorImg.setImageResource(R.drawable.pix_icon_indicator_folder_arrow);
                    }
                    this.pixKeyTv.setVisibility(8);
                } else {
                    this.childCountTv.setVisibility(8);
                    this.expandIndicatorImg.setVisibility(8);
                    this.pixKeyTv.setVisibility(0);
                    this.pixKeyTv.setText(payeeItem.showKeyByType);
                }
                if (z && HistoryPayeeAdapter.this.f31023c != null) {
                    HistoryPayeeAdapter.this.f31023c.onLastItemVisible();
                }
            }
        }

        public String toString() {
            return super.toString();
        }
    }

    class ViewHolder4Child extends HistoryContactViewHolder {
        public ViewHolder4Child(View view) {
            super(view);
        }

        public void bind(PayeeItem payeeItem, boolean z) {
            super.bind(payeeItem, z);
            if (payeeItem != null) {
                if (payeeItem.isChild) {
                    this.headIconTv.setVisibility(4);
                    this.headImg.setVisibility(4);
                    if (!TextUtil.isEmpty(payeeItem.pspName)) {
                        this.nameTv.setText(payeeItem.pspName);
                    }
                    this.pixKeyTv.setVisibility(0);
                    if (!TextUtil.isEmpty(payeeItem.key)) {
                        this.pixKeyTv.setText(payeeItem.showKeyByType);
                    }
                }
                if (payeeItem.childCount <= 1) {
                    this.pixKeyTv.setVisibility(0);
                    if (!TextUtil.isEmpty(payeeItem.showKeyByType)) {
                        this.pixKeyTv.setText(payeeItem.showKeyByType);
                    }
                }
            }
        }
    }
}
