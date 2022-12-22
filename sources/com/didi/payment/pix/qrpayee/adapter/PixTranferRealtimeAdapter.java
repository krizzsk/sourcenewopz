package com.didi.payment.pix.qrpayee.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.commonsdk.push.PixTransferAction;
import com.didi.sdk.util.collection.CollectionUtil;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class PixTranferRealtimeAdapter extends RecyclerView.Adapter<ItemHolder> {

    /* renamed from: a */
    private final LayoutInflater f31173a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f31174b;

    /* renamed from: c */
    private List<PixTransferAction> f31175c = new ArrayList();

    public PixTranferRealtimeAdapter(Context context) {
        this.f31174b = context;
        this.f31173a = LayoutInflater.from(context);
    }

    public void refreshOrAppendItem(PixTransferAction pixTransferAction) {
        if (pixTransferAction != null && pixTransferAction.innerData != null && pixTransferAction.innerData.isValid()) {
            if (CollectionUtil.isEmpty((Collection<?>) this.f31175c)) {
                this.f31175c.add(pixTransferAction);
                notifyDataSetChanged();
                return;
            }
            boolean z = false;
            Iterator<PixTransferAction> it = this.f31175c.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                PixTransferAction next = it.next();
                if (next.innerData != null && pixTransferAction.innerData != null && next.innerData.isValid() && pixTransferAction.innerData.cpf.equals(next.innerData.cpf)) {
                    this.f31175c.remove(next);
                    this.f31175c.add(pixTransferAction);
                    notifyDataSetChanged();
                    z = true;
                    break;
                }
            }
            if (!z) {
                this.f31175c.add(pixTransferAction);
                notifyDataSetChanged();
            }
        }
    }

    public void setItems(List<PixTransferAction> list) {
        this.f31175c.addAll(list);
        notifyDataSetChanged();
    }

    public ItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ItemHolder(this.f31173a.inflate(R.layout.pix_transfer_realtime_action_lv_item, viewGroup, false));
    }

    public void onBindViewHolder(ItemHolder itemHolder, int i) {
        itemHolder.bind(m21942a(i));
    }

    /* renamed from: a */
    private PixTransferAction m21942a(int i) {
        if (this.f31175c.size() > i) {
            return this.f31175c.get(i);
        }
        return null;
    }

    public int getItemCount() {
        return this.f31175c.size();
    }

    class ItemHolder extends RecyclerView.ViewHolder {
        ImageView headIconImg;
        TextView nameTv;
        TextView statusTv;

        public ItemHolder(View view) {
            super(view);
            this.headIconImg = (ImageView) view.findViewById(R.id.pix_contact_head_icon_img);
            this.nameTv = (TextView) view.findViewById(R.id.pix_contact_name_tv);
            this.statusTv = (TextView) view.findViewById(R.id.pix_tansfer_status_tv);
        }

        public void bind(PixTransferAction pixTransferAction) {
            if (pixTransferAction != null && pixTransferAction.innerData != null && pixTransferAction.innerData.isValid()) {
                GlideUtils.loadCircleImageWithDefaultImg(PixTranferRealtimeAdapter.this.f31174b, Uri.parse(pixTransferAction.innerData.iconUrl), R.drawable.pay_icon_contacts, this.headIconImg);
                this.nameTv.setText(pixTransferAction.innerData.name);
                this.statusTv.setText(pixTransferAction.innerData.status);
            }
        }
    }
}
