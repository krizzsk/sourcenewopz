package com.didi.safetoolkit.business.toolkit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.didi.safetoolkit.fragment.BaseDialogFragment;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.safetoolkit.apollo.SfApolloUtil;
import com.didi.safetoolkit.business.emergency.SfEmergencyNumHelper;
import com.didi.safetoolkit.business.toolkit.ISfToolkitContract;
import com.didi.safetoolkit.business.toolkit.model.SfViewMenuModel;
import com.didi.safetoolkit.business.toolkit.model.SfViewMonitorMenuModel;
import com.didi.safetoolkit.business.toolkit.model.SfViewRecordMenuModel;
import com.didi.safetoolkit.business.toolkit.view.SfViewAdapter;
import com.didi.safetoolkit.business.triprecording.DurationListener;
import com.didi.safetoolkit.business.triprecording.TripRecordingManager;
import com.didi.safetoolkit.util.SfStringGetter;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class SfToolkitDialog extends BaseDialogFragment implements ISfToolkitContract.ToolkitView {

    /* renamed from: a */
    private View f34457a;

    /* renamed from: b */
    private View f34458b;

    /* renamed from: c */
    private TextView f34459c;

    /* renamed from: d */
    private RecyclerView f34460d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public SfViewAdapter f34461e;

    /* renamed from: f */
    private List<SfViewMenuModel> f34462f;

    /* renamed from: g */
    private boolean f34463g = true;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public SfToolkitPresenter f34464h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public String f34465i;

    /* renamed from: j */
    private DurationListener f34466j = new DurationListener() {
        public void onCallback(String str) {
            if (SfToolkitDialog.this.f34461e != null) {
                SfToolkitDialog.this.f34461e.notifyRecordTimeChanged(str);
            }
        }
    };

    /* access modifiers changed from: protected */
    public int getLayoutRes() {
        return R.layout.sf_toolkit_dialog_layout;
    }

    public void setShareEnable(boolean z) {
    }

    /* access modifiers changed from: protected */
    public void parseBundle(Bundle bundle) {
        if (bundle != null) {
            this.f34463g = bundle.getBoolean("isShareCanUse", true);
            this.f34465i = bundle.getString("orderId", "");
            this.f34462f = (ArrayList) bundle.getSerializable("menuList");
        }
    }

    /* access modifiers changed from: protected */
    public void findViews() {
        this.f34457a = findViewById(R.id.sf_toolkit_dialog_share_btn);
        this.f34458b = findViewById(R.id.sf_toolkit_dialog_alert_btn);
        this.f34459c = (TextView) findViewById(R.id.sf_toolkit_dialog_alert_btn_text);
        this.f34460d = (RecyclerView) findViewById(R.id.sf_toolkit_dialog_recycler_view);
        SfViewAdapter sfViewAdapter = new SfViewAdapter();
        this.f34461e = sfViewAdapter;
        sfViewAdapter.setData(this.f34462f);
        this.f34460d.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.f34460d.setAdapter(this.f34461e);
    }

    /* access modifiers changed from: protected */
    public void initObjects() {
        this.f34464h = new SfToolkitPresenter(this);
    }

    /* access modifiers changed from: protected */
    public void initData() {
        setDialogSizePercent(1.0f);
        setDialogGravity(80);
        this.f34457a.setEnabled(this.f34463g);
        this.f34459c.setText(SfStringGetter.getString(R.string.sf_toolkit_dialog_alert_btn_text, SfEmergencyNumHelper.getEmergencyCallNum()));
    }

    /* access modifiers changed from: protected */
    public void setListener() {
        this.f34457a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                boolean isApolloNewShare = SfApolloUtil.isApolloNewShare();
                SfToolkitDialog.this.f34464h.onShareClick(isApolloNewShare);
                if (isApolloNewShare) {
                    SfToolkitDialog.this.dismiss();
                }
            }
        });
        this.f34458b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SfToolkitDialog.this.f34464h.onAlertClick();
            }
        });
        this.f34461e.setCardClickListener(new SfViewAdapter.CardClickListener() {
            public void onClick(SfViewMenuModel sfViewMenuModel) {
                if (sfViewMenuModel == null) {
                    return;
                }
                if (SfViewMenuModel.TYPE_SAFE_CENTER.equals(sfViewMenuModel.type)) {
                    SfToolkitDialog.this.f34464h.onSafeCenterClick();
                } else if (SfViewMenuModel.TYPE_AUDIO_RECORD.equals(sfViewMenuModel.type)) {
                    SfToolkitDialog.this.f34464h.onAudioRecordClick(SfToolkitDialog.this.f34465i, (SfViewRecordMenuModel) sfViewMenuModel);
                } else if (SfViewMenuModel.TYPE_REALTIME_MONITOR.equals(sfViewMenuModel.type)) {
                    SfToolkitDialog.this.f34464h.onMonitorClick((SfViewMonitorMenuModel) sfViewMenuModel);
                }
            }
        });
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        TripRecordingManager.Companion.getInstance().setDurationListener(this.f34466j);
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDestroyView() {
        super.onDestroyView();
        TripRecordingManager.Companion.getInstance().removeDurationListener(this.f34466j);
    }

    public void updateSfViewMenuModelList(List<SfViewMenuModel> list) {
        this.f34462f = list;
        SfViewAdapter sfViewAdapter = this.f34461e;
        if (sfViewAdapter != null) {
            sfViewAdapter.setData(list);
            this.f34461e.notifyDataSetChanged();
        }
    }
}
