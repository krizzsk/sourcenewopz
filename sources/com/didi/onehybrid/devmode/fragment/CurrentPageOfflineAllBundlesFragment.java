package com.didi.onehybrid.devmode.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.didi.onehybrid.devmode.adapter.MyAdapter;
import com.didi.onehybrid.devmode.interfaces.CommunicationInterface;
import com.taxis99.R;
import java.util.ArrayList;

public class CurrentPageOfflineAllBundlesFragment extends BaseFragment {
    public static final String _TAG = "CurrentPageOfflineAllBundlesFragment";

    /* renamed from: a */
    private View f29568a;

    /* renamed from: b */
    private MyAdapter f29569b;

    public static CurrentPageOfflineAllBundlesFragment newInstance(CommunicationInterface communicationInterface) {
        CurrentPageOfflineAllBundlesFragment currentPageOfflineAllBundlesFragment = new CurrentPageOfflineAllBundlesFragment();
        Bundle bundle = new Bundle();
        bundle.putCharSequence("label", _TAG);
        currentPageOfflineAllBundlesFragment.setArguments(bundle);
        currentPageOfflineAllBundlesFragment.setChangeToTargetFragment(communicationInterface);
        return currentPageOfflineAllBundlesFragment;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f29568a = onCreateView;
        return onCreateView;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ArrayList arrayList = new ArrayList();
        for (String add : this.mInterface.getFusionRuntimeInfo().getRenderInfo().mBundles.keySet()) {
            arrayList.add(add);
        }
        MyAdapter myAdapter = new MyAdapter(getActivity(), arrayList);
        this.f29569b = myAdapter;
        setListAdapter(myAdapter);
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        super.onListItemClick(listView, view, i, j);
        this.mInterface.onChange(((TextView) view.findViewById(R.id.tv_bundle_name)).getText().toString());
    }
}
