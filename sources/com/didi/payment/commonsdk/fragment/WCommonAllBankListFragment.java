package com.didi.payment.commonsdk.fragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.commonsdk.p129ui.AbsWBaseFragment;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.commonsdk.view.adapter.TransBankListAdapter;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WCommonAllBankListFragment extends AbsWBaseFragment<WBaseViewModel> {

    /* renamed from: a */
    private TransBankListAdapter f30159a;

    /* renamed from: b */
    private List<String> f30160b;

    /* renamed from: c */
    private RecyclerView f30161c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f30162d = "";

    public int onInflateLayout() {
        return R.layout.w_common_bank_list_fragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ArrayList<String> stringArrayList = getArguments().getStringArrayList("bank_list");
        this.f30160b = stringArrayList;
        Collections.sort(stringArrayList);
        String str = "";
        if (getArguments() != null) {
            str = getArguments().getString("source_page", str);
        }
        this.f30162d = str;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void initCommonTitlebar(CommonTitleBar commonTitleBar) {
        commonTitleBar.setTitle("");
        commonTitleBar.setLeftBackListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                WCommonAllBankListFragment.this.backToPrePage();
            }
        });
        super.initCommonTitlebar(commonTitleBar);
    }

    public void initContentView(View view) {
        super.initContentView(view);
        this.f30161c = (RecyclerView) view.findViewById(R.id.w_common_bank_list_options_lv);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(), 1);
        dividerItemDecoration.setDrawable(new ColorDrawable(Color.parseColor("#1f000000")));
        this.f30161c.addItemDecoration(dividerItemDecoration);
        TransBankListAdapter transBankListAdapter = new TransBankListAdapter(getActivity(), new ArrayList());
        this.f30159a = transBankListAdapter;
        transBankListAdapter.setOnItemclickListener(new TransBankListAdapter.OnItemClickListener() {
            public void onItemClick(String str) {
                Bundle bundle = new Bundle();
                bundle.putString("selected_bank", str);
                bundle.putString("source_page", WCommonAllBankListFragment.this.f30162d);
                WCommonAllBankListFragment.this.backToPrePage(bundle);
            }
        });
        this.f30161c.setLayoutManager(new LinearLayoutManager(getContext()));
        this.f30161c.setAdapter(this.f30159a);
        this.f30159a.updateData(this.f30160b);
    }
}
