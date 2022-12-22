package com.didi.safetoolkit.business.contacts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.safetoolkit.business.contacts.viewhoder.SfContactInfoShowVH;
import com.didi.safetoolkit.model.SfContactsModel;
import com.didi.safetoolkit.util.SfStringGetter;
import com.taxis99.R;
import java.util.List;

public class SfContactsManageAdapter extends RecyclerView.Adapter {

    /* renamed from: a */
    private static final int f34297a = 0;

    /* renamed from: b */
    private static final int f34298b = 1;

    /* renamed from: c */
    private static final int f34299c = 2;

    /* renamed from: d */
    private static final int f34300d = 5;

    /* renamed from: e */
    private List<SfContactsModel> f34301e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View.OnClickListener f34302f;

    /* renamed from: g */
    private SfContactInfoShowVH.Callback f34303g;

    public void setData(List<SfContactsModel> list) {
        this.f34301e = list;
    }

    public void setAddContactVHClickListener(View.OnClickListener onClickListener) {
        this.f34302f = onClickListener;
    }

    public void setDeleteListener(SfContactInfoShowVH.Callback callback) {
        this.f34303g = callback;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new SfContactInfoShowVH(viewGroup);
        }
        if (i == 1) {
            return new AddContactsVH(viewGroup);
        }
        if (i != 2) {
            return new SfContactInfoShowVH(viewGroup);
        }
        return new Contacts2UpLimitVH(viewGroup);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof SfContactInfoShowVH) {
            SfContactInfoShowVH sfContactInfoShowVH = (SfContactInfoShowVH) viewHolder;
            sfContactInfoShowVH.setData(this.f34301e.get(i));
            sfContactInfoShowVH.setCallback(this.f34303g);
        }
    }

    public int getItemViewType(int i) {
        if (i < this.f34301e.size()) {
            return 0;
        }
        if (this.f34301e.size() > 0 && this.f34301e.size() < 5) {
            return 1;
        }
        if (this.f34301e.size() == 5) {
            return 2;
        }
        return 0;
    }

    public int getItemCount() {
        List<SfContactsModel> list = this.f34301e;
        if (list == null) {
            return 0;
        }
        return list.size() + 1;
    }

    private class AddContactsVH extends RecyclerView.ViewHolder {
        public TextView addTrustedContactTv;

        private AddContactsVH(ViewGroup viewGroup) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sf_add_contacts_layout, viewGroup, false));
            TextView textView = (TextView) this.itemView.findViewById(R.id.sf_add_trusted_contact_tv);
            this.addTrustedContactTv = textView;
            textView.setText(SfStringGetter.getString(R.string.sf_trusted_contacts_add));
            this.itemView.setOnClickListener(SfContactsManageAdapter.this.f34302f);
        }
    }

    private class Contacts2UpLimitVH extends RecyclerView.ViewHolder {
        public TextView sfContact2UpLimit;

        private Contacts2UpLimitVH(ViewGroup viewGroup) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sf_contacts_to_uplimit, viewGroup, false));
            TextView textView = (TextView) this.itemView.findViewById(R.id.sf_contact_2_up_limit);
            this.sfContact2UpLimit = textView;
            textView.setText(SfStringGetter.getString(R.string.sf_already_added_5));
        }
    }
}
