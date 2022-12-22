package com.didi.jacoco.runtime.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.didi.jacoco.runtime.module.role.Data;
import com.taxis99.R;
import java.util.List;
import org.jacoco.agent.p086rt.internal_8ff85ea.Offline;

public class NameAdapter extends BaseAdapter {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final String TAG = "NameAdapter";
    private Context mContext;
    private List<Data> mList;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-256755795389041125L, "com/didi/jacoco/runtime/adapter/NameAdapter", 12);
        $jacocoData = probes;
        return probes;
    }

    public NameAdapter(Context context, List<Data> list) {
        boolean[] $jacocoInit = $jacocoInit();
        this.mContext = context;
        this.mList = list;
        $jacocoInit[0] = true;
    }

    public void setData(List<Data> list) {
        boolean[] $jacocoInit = $jacocoInit();
        this.mList = list;
        $jacocoInit[1] = true;
    }

    public int getCount() {
        boolean[] $jacocoInit = $jacocoInit();
        int size = this.mList.size();
        $jacocoInit[2] = true;
        return size;
    }

    public Object getItem(int i) {
        boolean[] $jacocoInit = $jacocoInit();
        Data data = this.mList.get(i);
        $jacocoInit[3] = true;
        return data;
    }

    public long getItemId(int i) {
        long j = (long) i;
        $jacocoInit()[4] = true;
        return j;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        boolean[] $jacocoInit = $jacocoInit();
        if (view == null) {
            $jacocoInit[5] = true;
            LayoutInflater from = LayoutInflater.from(this.mContext);
            $jacocoInit[6] = true;
            view = from.inflate(R.layout.item_role, (ViewGroup) null);
            $jacocoInit[7] = true;
            viewHolder = new ViewHolder(view);
            $jacocoInit[8] = true;
            view.setTag(viewHolder);
            $jacocoInit[9] = true;
        } else {
            viewHolder = (ViewHolder) view.getTag();
            $jacocoInit[10] = true;
        }
        viewHolder.tvInfo.setText(this.mList.get(i).getName());
        $jacocoInit[11] = true;
        return view;
    }

    private static class ViewHolder {
        private static transient /* synthetic */ boolean[] $jacocoData;
        public TextView tvInfo;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(-8175816581768737453L, "com/didi/jacoco/runtime/adapter/NameAdapter$ViewHolder", 2);
            $jacocoData = probes;
            return probes;
        }

        public ViewHolder(View view) {
            boolean[] $jacocoInit = $jacocoInit();
            $jacocoInit[0] = true;
            this.tvInfo = (TextView) view.findViewById(R.id.txt_info);
            $jacocoInit[1] = true;
        }
    }
}
