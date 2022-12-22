package com.didichuxing.swarm.launcher;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;

public class BundleListActivity extends BaseFragmentActivity implements AdapterView.OnItemClickListener {

    /* renamed from: a */
    private ListView f49156a;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        super.setContentView(17367060);
        super.setupActionBar();
        ListView listView = (ListView) findViewById(16908298);
        this.f49156a = listView;
        listView.setOnItemClickListener(this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f49156a.setAdapter(new BundleListAdapter(SwarmLauncher.getInstance().getFramework().getBundleContext().getBundles()));
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        AutoTrackHelper.trackViewOnClick(adapterView, view, i);
        Intent intent = new Intent(this, BundleActivity.class);
        intent.putExtra(BundleActivity.EXTRA_ID, ((org.osgi.framework.Bundle) adapterView.getItemAtPosition(i)).getBundleId());
        startActivity(intent);
    }

    private static final class BundleListAdapter extends BaseAdapter {
        private final org.osgi.framework.Bundle[] mBundles;

        public long getItemId(int i) {
            return (long) i;
        }

        public BundleListAdapter(org.osgi.framework.Bundle[] bundleArr) {
            this.mBundles = bundleArr;
        }

        public int getCount() {
            return this.mBundles.length;
        }

        public Object getItem(int i) {
            return this.mBundles[i];
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                viewHolder = new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(17367047, (ViewGroup) null));
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            viewHolder.update(this.mBundles[i]);
            return viewHolder.mView;
        }
    }

    private static final class ViewHolder {
        private final TextView mDescription;
        private final TextView mName;
        /* access modifiers changed from: private */
        public final View mView;

        private ViewHolder(View view) {
            this.mView = view;
            this.mName = (TextView) view.findViewById(16908308);
            this.mDescription = (TextView) view.findViewById(16908309);
        }

        public void update(org.osgi.framework.Bundle bundle) {
            this.mName.setText(bundle.getSymbolicName());
            this.mDescription.setText(bundle.getLocation());
        }
    }
}
