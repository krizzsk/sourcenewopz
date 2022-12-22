package com.didi.safetoolkit.business.contacts.viewhoder;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.android.didi.theme.DidiThemeManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.safetoolkit.apollo.SfApolloUtil;
import com.didi.safetoolkit.business.contacts.model.SfContactModel;
import com.didi.safetoolkit.model.SfContactsModel;
import com.didi.safetoolkit.omega.SfOmegaUtil;
import com.didi.safetoolkit.util.SfStringGetter;
import com.didi.safetoolkit.util.SfViewUtils;
import com.didi.safetoolkit.widget.DiTips;
import com.didi.safetoolkit.widget.SfBaseDialog;
import com.google.gson.Gson;
import com.taxis99.R;
import java.util.ArrayList;

public class SfContactInfoShowVH extends SfContactInfoBaseVH {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Callback f34319a;

    /* renamed from: b */
    private TextView f34320b = ((TextView) this.itemView.findViewById(R.id.add_area_code_btn));

    public interface Callback {
        void deleteDialogClickPerform(String str);

        void onAddAreaCodeClick(SfContactsModel sfContactsModel);
    }

    public SfContactInfoShowVH(ViewGroup viewGroup) {
        super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sf_contacts_info_layout, viewGroup, false));
        this.itemView.findViewById(R.id.sf_contact_select_btn).setVisibility(8);
        this.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {
                final DiTips build = new DiTips.Builder(SfContactInfoShowVH.this.itemView.getContext(), R.layout.sf_delete_tips).setAnchor(SfContactInfoShowVH.this.itemView).setBelowAnchor(true).setFitsSystemWindows(true).setFollowingLayout(false).setDismissInTouchOut(true).setOffsetY(-SfViewUtils.dp2px(SfContactInfoShowVH.this.itemView.getContext(), 46.0f)).build();
                build.show();
                build.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        build.dismiss();
                        FragmentActivity fragmentActivity = (FragmentActivity) SfContactInfoShowVH.this.itemView.getContext();
                        int color = DidiThemeManager.getIns().getResPicker(SfContactInfoShowVH.this.itemView.getContext()).getColor(R.attr.recommend_text_color);
                        SfBaseDialog.DialogBuilder titleTypeface = new SfBaseDialog.DialogBuilder(fragmentActivity).setTitle(SfStringGetter.getString(R.string.sf_you_sure)).setTitleTypeface(1);
                        StringBuilder sb = new StringBuilder();
                        sb.append(TextUtils.isEmpty(SfContactInfoShowVH.this.mData.name) ? SfContactInfoShowVH.this.mData.phone : SfContactInfoShowVH.this.mData.name);
                        sb.append(" ");
                        sb.append(SfStringGetter.getString(R.string.sf_no_longer_show));
                        titleTypeface.setContent(sb.toString()).setRightBtn(SfStringGetter.getString(R.string.sf_remove), (View.OnClickListener) new View.OnClickListener() {
                            public void onClick(View view) {
                                AutoTrackHelper.trackViewOnClick(view);
                                if (SfApolloUtil.isNewSyncContactInterface()) {
                                    ArrayList arrayList = new ArrayList();
                                    arrayList.add(SfContactInfoShowVH.this.mData);
                                    try {
                                        SfContactInfoShowVH.this.f34319a.deleteDialogClickPerform(new Gson().toJson((Object) arrayList));
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                } else {
                                    SfContactModel sfContactModel = new SfContactModel();
                                    SfContactsModel sfContactsModel = SfContactInfoShowVH.this.mData;
                                    sfContactModel.name = sfContactsModel.name;
                                    sfContactModel.phone = sfContactsModel.phone;
                                    ArrayList arrayList2 = new ArrayList();
                                    arrayList2.add(sfContactModel);
                                    try {
                                        SfContactInfoShowVH.this.f34319a.deleteDialogClickPerform(new Gson().toJson((Object) arrayList2));
                                    } catch (Exception e2) {
                                        e2.printStackTrace();
                                    }
                                }
                            }
                        }).setRightBtnTextColor(color).setRightBtnTypeface(1).setLeftBtn(SfStringGetter.getString(R.string.sf_cancel)).setLeftBtnTypeface(1).setCancelableWhenTouchOutside(true).build().show(fragmentActivity.getSupportFragmentManager(), "SfContactDeleteDialog");
                    }
                });
                return false;
            }
        });
    }

    public void setData(final SfContactsModel sfContactsModel) {
        super.setData(sfContactsModel);
        if (!SfApolloUtil.isAreaCode4StockShow()) {
            this.f34320b.setVisibility(8);
        } else if (sfContactsModel.need_areacode) {
            this.f34320b.setVisibility(0);
            this.f34320b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (SfContactInfoShowVH.this.f34319a != null) {
                        SfOmegaUtil.addEventId("gp_addAreaCode_btn_ck").report();
                        SfContactInfoShowVH.this.f34319a.onAddAreaCodeClick(sfContactsModel);
                    }
                }
            });
        } else {
            this.f34320b.setVisibility(8);
            this.f34320b.setOnClickListener((View.OnClickListener) null);
        }
    }

    public void setCallback(Callback callback) {
        this.f34319a = callback;
    }
}
