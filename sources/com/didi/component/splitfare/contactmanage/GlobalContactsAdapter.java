package com.didi.component.splitfare.contactmanage;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.android.didi.theme.DidiThemeManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.common.util.CollectionUtils;
import com.didi.sdk.app.DIDIApplicationDelegate;
import com.didi.sdk.util.ToastHelper;
import com.taxis99.R;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GlobalContactsAdapter extends RecyclerView.Adapter {

    /* renamed from: f */
    private static final int f15913f = 1;

    /* renamed from: g */
    private static final int f15914g = 2;

    /* renamed from: h */
    private static final int f15915h = 3;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public List<GlobalContactsModel> f15916a;

    /* renamed from: b */
    private List<GlobalContactsModel> f15917b;

    /* renamed from: c */
    private List<GlobalContactsModel> f15918c;

    /* renamed from: d */
    private List<GlobalContactsModel> f15919d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public GlobalCheckedChangedListener f15920e;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f15921i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f15922j;

    public interface GlobalCheckedChangedListener {
        void onCheckedChanged(GlobalContactsModel globalContactsModel, boolean z);

        void onSearchContactsClick(boolean z);
    }

    public GlobalContactsAdapter(int i) {
        this.f15921i = i;
    }

    public void addData(List<GlobalContactsModel> list) {
        if (list != null && !list.isEmpty()) {
            if (this.f15917b == null) {
                this.f15917b = new GlobalContactsList();
            }
            m11614a(this.f15917b, list);
            if (this.f15919d == null) {
                this.f15919d = new GlobalContactsList();
            }
            this.f15919d.clear();
            m11614a(this.f15919d, this.f15917b);
            notifyDataSetChanged();
        }
    }

    public void addSplitFareData(GlobalContactsModel globalContactsModel) {
        if (!CollectionUtils.isEmpty((Collection) this.f15916a)) {
            for (GlobalContactsModel next : this.f15916a) {
                if (!TextUtils.isEmpty(next.phone) && !TextUtils.isEmpty(globalContactsModel.phone) && next.phone.equals(globalContactsModel.phone)) {
                    next.checked = globalContactsModel.checked;
                    notifyDataSetChanged();
                    return;
                }
            }
        }
        GlobalContactsModel globalContactsModel2 = new GlobalContactsModel();
        globalContactsModel2.name = globalContactsModel.name;
        globalContactsModel2.phone = globalContactsModel.phone;
        globalContactsModel2.checked = globalContactsModel.checked;
        globalContactsModel2.type = 2;
        if (this.f15916a == null) {
            this.f15916a = new CopyOnWriteArrayList();
        }
        this.f15916a.add(globalContactsModel2);
        if (this.f15919d == null) {
            this.f15919d = new GlobalContactsList();
        }
        this.f15919d.clear();
        m11614a(this.f15919d, this.f15916a);
        m11614a(this.f15919d, this.f15917b);
        notifyDataSetChanged();
    }

    public void showDatas() {
        if (this.f15919d == null) {
            this.f15919d = new GlobalContactsList();
        }
        this.f15919d.clear();
        m11614a(this.f15919d, this.f15916a);
        m11614a(this.f15919d, this.f15917b);
        notifyDataSetChanged();
    }

    /* renamed from: a */
    private void m11614a(List<GlobalContactsModel> list, List<GlobalContactsModel> list2) {
        if (list != null && !CollectionUtils.isEmpty((Collection) list2)) {
            list.addAll(list2);
        }
    }

    /* renamed from: a */
    private GlobalContactsModel m11612a(int i) {
        List<GlobalContactsModel> list = this.f15919d;
        if (list == null) {
            return null;
        }
        return list.get(i);
    }

    public void updateSearchData(List<GlobalContactsModel> list) {
        this.f15922j = true;
        if (this.f15918c == null) {
            this.f15918c = new GlobalContactsList();
        }
        this.f15918c.clear();
        m11614a(this.f15918c, list);
        if (this.f15919d == null) {
            this.f15919d = new GlobalContactsList();
        }
        this.f15919d.clear();
        m11614a(this.f15919d, this.f15918c);
        notifyDataSetChanged();
    }

    public void deleteSplitFareData(GlobalContactsModel globalContactsModel) {
        if (!CollectionUtils.isEmpty((Collection) this.f15916a)) {
            Iterator<GlobalContactsModel> it = this.f15916a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                GlobalContactsModel next = it.next();
                if (!TextUtils.isEmpty(next.phone) && !TextUtils.isEmpty(globalContactsModel.phone) && next.phone.equals(globalContactsModel.phone)) {
                    this.f15916a.remove(next);
                    if (this.f15919d == null) {
                        this.f15919d = new GlobalContactsList();
                    }
                    this.f15919d.clear();
                    m11614a(this.f15919d, this.f15916a);
                    m11614a(this.f15919d, this.f15917b);
                }
            }
            if (globalContactsModel.type == 2 && !CollectionUtils.isEmpty((Collection) this.f15917b)) {
                for (GlobalContactsModel next2 : this.f15917b) {
                    if (!TextUtils.isEmpty(next2.phone) && !TextUtils.isEmpty(globalContactsModel.phone) && globalContactsModel.phone.contains(next2.phone) && next2.checked) {
                        next2.checked = false;
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    public void updateSosContacts(GlobalContactsModel globalContactsModel) {
        if (!CollectionUtils.isEmpty((Collection) this.f15916a)) {
            Iterator<GlobalContactsModel> it = this.f15916a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                GlobalContactsModel next = it.next();
                if (!TextUtils.isEmpty(next.phone)) {
                    if (!TextUtils.isEmpty(globalContactsModel.originPhone) && next.phone.contains(globalContactsModel.originPhone)) {
                        next.checked = globalContactsModel.checked;
                        next.phone = globalContactsModel.phone;
                        break;
                    } else if (next.phone.contains(globalContactsModel.phone)) {
                        next.checked = globalContactsModel.checked;
                        next.phone = globalContactsModel.phone;
                        break;
                    }
                }
            }
            if (CollectionUtils.isEmpty((Collection) this.f15917b)) {
                notifyDataSetChanged();
                return;
            }
            Iterator<GlobalContactsModel> it2 = this.f15917b.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                GlobalContactsModel next2 = it2.next();
                if (!TextUtils.isEmpty(next2.phone)) {
                    if (TextUtils.isEmpty(globalContactsModel.originPhone) || !next2.phone.contains(globalContactsModel.originPhone) || !globalContactsModel.name.equals(next2.name)) {
                        if (next2.phone.contains(globalContactsModel.phone) && globalContactsModel.name.equals(next2.name)) {
                            next2.checked = globalContactsModel.checked;
                            next2.phone = globalContactsModel.phone;
                            break;
                        }
                    } else {
                        next2.checked = globalContactsModel.checked;
                        next2.phone = globalContactsModel.phone;
                        break;
                    }
                }
            }
            notifyDataSetChanged();
        }
    }

    public void setListener(GlobalCheckedChangedListener globalCheckedChangedListener) {
        this.f15920e = globalCheckedChangedListener;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 2) {
            return new GlobalContactTitleVH(viewGroup);
        }
        if (i == 1) {
            return new GlobalContactInfoSelectVH(viewGroup);
        }
        if (i == 3) {
            return new GlobalSortHeaderVH(viewGroup);
        }
        return new GlobalContactInfoSelectVH(viewGroup);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ((GlobalBaseVH) viewHolder).setData(m11612a(i));
    }

    public int getItemCount() {
        if (CollectionUtils.isEmpty((Collection) this.f15919d)) {
            return 0;
        }
        return this.f15919d.size();
    }

    public int getItemViewType(int i) {
        GlobalContactsModel a = m11612a(i);
        if (i == 0 && a != null && a.type == 2) {
            return 2;
        }
        return (a == null || a.type != 3) ? 1 : 3;
    }

    public class GlobalContactInfoSelectVH extends GlobalContactInfoBaseVH {
        public GlobalContactInfoSelectVH(ViewGroup viewGroup) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.g_contacts_info_layout, viewGroup, false));
            this.mContactSelectBtn.setVisibility(0);
        }

        public GlobalContactInfoSelectVH(View view) {
            super(view);
            this.mContactSelectBtn.setVisibility(0);
        }

        public void setData(final GlobalContactsModel globalContactsModel) {
            super.setData(globalContactsModel);
            if (globalContactsModel != null) {
                this.itemView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        int i;
                        AutoTrackHelper.trackViewOnClick(view);
                        if (GlobalContactsAdapter.this.f15916a != null) {
                            i = 0;
                            for (GlobalContactsModel globalContactsModel : GlobalContactsAdapter.this.f15916a) {
                                if (globalContactsModel.checked) {
                                    i++;
                                }
                            }
                        } else {
                            i = 0;
                        }
                        if (globalContactsModel.type == 1 && i == GlobalContactsAdapter.this.f15921i) {
                            if (globalContactsModel.checked) {
                                globalContactsModel.checked = false;
                            } else {
                                ToastHelper.showShortInfo(GlobalContactInfoSelectVH.this.itemView.getContext(), String.format(GlobalContactInfoSelectVH.this.itemView.getContext().getString(R.string.g_splitfare_contacts_limit_time), new Object[]{Integer.valueOf(GlobalContactsAdapter.this.f15921i)}), (int) R.drawable.global_toast_error);
                                return;
                            }
                        } else if (globalContactsModel.checked) {
                            globalContactsModel.checked = false;
                        } else {
                            globalContactsModel.checked = true;
                        }
                        GlobalContactInfoSelectVH.this.updateViewByCheckStatus(globalContactsModel.checked);
                        if (GlobalContactsAdapter.this.f15920e != null) {
                            GlobalCheckedChangedListener c = GlobalContactsAdapter.this.f15920e;
                            GlobalContactsModel globalContactsModel2 = globalContactsModel;
                            c.onCheckedChanged(globalContactsModel2, globalContactsModel2.checked);
                            if (GlobalContactsAdapter.this.f15922j) {
                                GlobalContactsAdapter.this.f15920e.onSearchContactsClick(globalContactsModel.checked);
                                boolean unused = GlobalContactsAdapter.this.f15922j = false;
                            }
                        }
                    }
                });
                updateViewByCheckStatus(globalContactsModel.checked);
                if (globalContactsModel.type == 2) {
                    this.mHeader.setVisibility(0);
                } else {
                    this.mHeader.setVisibility(8);
                }
                if (!globalContactsModel.canSelected) {
                    this.mContactSelectBtn.setEnabled(false);
                    this.itemView.setOnClickListener((View.OnClickListener) null);
                    return;
                }
                this.mContactSelectBtn.setEnabled(true);
            }
        }

        /* access modifiers changed from: private */
        public void updateViewByCheckStatus(boolean z) {
            if (z) {
                this.mContactName.setTextColor(DidiThemeManager.getIns().getResPicker(DIDIApplicationDelegate.getAppContext()).getColor(R.attr.caution_color));
                this.mContactSelectBtn.setChecked(true);
                this.mContactSelectBtn.setEnabled(true);
                this.mContactSelectBtn.setClickable(false);
                return;
            }
            this.mContactName.setTextColor(DIDIApplicationDelegate.getAppContext().getResources().getColor(R.color.g_color_333333));
            this.mContactSelectBtn.setChecked(false);
            this.mContactSelectBtn.setClickable(false);
            this.mContactSelectBtn.setEnabled(false);
        }
    }

    public class GlobalContactTitleVH extends GlobalContactInfoSelectVH {
        public GlobalContactTitleVH(ViewGroup viewGroup) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.g_contacts_header_item, viewGroup, false));
            ((TextView) this.itemView.findViewById(R.id.sf_item_header_name)).setText(R.string.g_splitfare_contacts_first_holder_title);
        }

        public void setData(GlobalContactsModel globalContactsModel) {
            super.setData(globalContactsModel);
        }
    }

    public class GlobalSortHeaderVH extends GlobalBaseVH {
        private TextView keyTv = ((TextView) this.itemView.findViewById(R.id.g_key_tv));

        public GlobalSortHeaderVH(ViewGroup viewGroup) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.g_contacts_sort_key_item, viewGroup, false));
        }

        public void setData(GlobalContactsModel globalContactsModel) {
            if (globalContactsModel != null) {
                this.keyTv.setText(globalContactsModel.name);
            }
        }
    }
}
