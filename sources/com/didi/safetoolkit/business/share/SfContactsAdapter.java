package com.didi.safetoolkit.business.share;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.android.didi.theme.DidiThemeManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.safetoolkit.business.contacts.viewhoder.SfBaseVH;
import com.didi.safetoolkit.business.contacts.viewhoder.SfContactInfoBaseVH;
import com.didi.safetoolkit.business.share.model.SfContactsList;
import com.didi.safetoolkit.model.SfContactsModel;
import com.didi.safetoolkit.util.SfStringGetter;
import com.taxis99.R;
import java.util.List;

public class SfContactsAdapter extends RecyclerView.Adapter {

    /* renamed from: d */
    private static final int f34434d = 1;

    /* renamed from: e */
    private static final int f34435e = 2;

    /* renamed from: f */
    private static final int f34436f = 3;

    /* renamed from: a */
    private List<SfContactsModel> f34437a;

    /* renamed from: b */
    private List<SfContactsModel> f34438b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public SfCheckedChangedListener f34439c;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f34440g = true;

    public interface SfCheckedChangedListener {
        void onCheckedChanged(SfContactsModel sfContactsModel, boolean z);
    }

    public void addData(List<SfContactsModel> list) {
        if (list != null && !list.isEmpty()) {
            if (this.f34438b == null) {
                this.f34438b = new SfContactsList();
            }
            if (list.get(0).type == 2) {
                this.f34437a = list;
            } else {
                this.f34438b.addAll(list);
            }
            notifyDataSetChanged();
        }
    }

    public void updateCheckable(boolean z) {
        if (z != this.f34440g) {
            this.f34440g = z;
            notifyDataSetChanged();
        }
    }

    /* renamed from: a */
    private SfContactsModel m24342a(int i) {
        List<SfContactsModel> list = this.f34437a;
        if (list == null || list.size() <= i) {
            return this.f34438b.get(i - m24340a());
        }
        return this.f34437a.get(i);
    }

    /* renamed from: a */
    private int m24340a() {
        List<SfContactsModel> list = this.f34437a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void updateSystemData(List<SfContactsModel> list) {
        this.f34438b = list;
        notifyDataSetChanged();
    }

    public void setListener(SfCheckedChangedListener sfCheckedChangedListener) {
        this.f34439c = sfCheckedChangedListener;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 2) {
            return new SfContactTitleVH(viewGroup);
        }
        if (i == 1) {
            return new SfContactInfoSelectVH(viewGroup);
        }
        if (i == 3) {
            return new SfSortHeaderVH(viewGroup);
        }
        return new SfContactInfoSelectVH(viewGroup);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ((SfBaseVH) viewHolder).setData(m24342a(i));
    }

    public int getItemCount() {
        List<SfContactsModel> list = this.f34438b;
        int i = 0;
        if (list != null) {
            i = 0 + list.size();
        }
        List<SfContactsModel> list2 = this.f34437a;
        return list2 != null ? i + list2.size() : i;
    }

    public int getItemViewType(int i) {
        if (i == 0 && m24342a(i).type == 2) {
            return 2;
        }
        return m24342a(i).type == 3 ? 3 : 1;
    }

    public class SfContactInfoSelectVH extends SfContactInfoBaseVH {
        public SfContactInfoSelectVH(ViewGroup viewGroup) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sf_contacts_info_layout, viewGroup, false));
            this.sfContactSelectBtn.setVisibility(0);
        }

        public SfContactInfoSelectVH(View view) {
            super(view);
            this.sfContactSelectBtn.setVisibility(0);
        }

        public void setData(final SfContactsModel sfContactsModel) {
            super.setData(sfContactsModel);
            if (sfContactsModel != null) {
                this.sfContactSelectBtn.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
                this.itemView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (sfContactsModel.checked) {
                            sfContactsModel.checked = false;
                        } else {
                            sfContactsModel.checked = true;
                        }
                        SfContactInfoSelectVH.this.updateViewByCheckStatus(sfContactsModel.checked);
                        if (SfContactsAdapter.this.f34439c != null) {
                            SfCheckedChangedListener a = SfContactsAdapter.this.f34439c;
                            SfContactsModel sfContactsModel = sfContactsModel;
                            a.onCheckedChanged(sfContactsModel, sfContactsModel.checked);
                        }
                    }
                });
                updateViewByCheckStatus(sfContactsModel.checked);
                if (sfContactsModel.type == 2) {
                    this.sfHeader.setVisibility(0);
                } else {
                    this.sfHeader.setVisibility(8);
                }
            }
        }

        /* access modifiers changed from: private */
        public void updateViewByCheckStatus(boolean z) {
            if (z) {
                this.sfContactName.setTextColor(DidiThemeManager.getIns().getResPicker(this.itemView.getContext()).getColor(R.attr.caution_color));
                this.sfContactSelectBtn.setChecked(true);
                this.sfContactSelectBtn.setEnabled(true);
                this.sfContactSelectBtn.setClickable(false);
                return;
            }
            this.sfContactName.setTextColor(this.itemView.getContext().getResources().getColor(R.color.sf_color_333333));
            this.sfContactSelectBtn.setChecked(false);
            this.sfContactSelectBtn.setClickable(false);
            if (!SfContactsAdapter.this.f34440g) {
                this.sfContactSelectBtn.setEnabled(false);
                this.itemView.setOnClickListener((View.OnClickListener) null);
                return;
            }
            this.sfContactSelectBtn.setEnabled(true);
        }
    }

    public class SfContactTitleVH extends SfContactInfoSelectVH {
        public SfContactTitleVH(ViewGroup viewGroup) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sf_contacts_header_item, viewGroup, false));
            ((TextView) this.itemView.findViewById(R.id.sf_item_header_name)).setText(SfStringGetter.getString(R.string.sf_trusted_contacts_title));
        }

        public void setData(SfContactsModel sfContactsModel) {
            super.setData(sfContactsModel);
        }
    }

    public class SfSortHeaderVH extends SfBaseVH {
        private TextView keyTv = ((TextView) this.itemView.findViewById(R.id.sf_key_tv));

        public SfSortHeaderVH(ViewGroup viewGroup) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sf_contacts_sord_key_item, viewGroup, false));
        }

        public void setData(SfContactsModel sfContactsModel) {
            if (sfContactsModel != null) {
                this.keyTv.setText(sfContactsModel.name);
            }
        }
    }
}
