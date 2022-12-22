package com.didi.safetoolkit.business.toolkit.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.safetoolkit.business.toolkit.model.SfViewMenuModel;
import com.didi.safetoolkit.business.triprecording.TripRecordingManager;
import com.didi.sdk.util.SPUtils;
import com.taxis99.R;
import java.util.List;

public class SfViewAdapter extends RecyclerView.Adapter {

    /* renamed from: a */
    private List<SfViewMenuModel> f34467a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CardClickListener f34468b;

    public interface CardClickListener {
        void onClick(SfViewMenuModel sfViewMenuModel);
    }

    public void setData(List<SfViewMenuModel> list) {
        if (list != null) {
            this.f34467a = list;
            notifyDataSetChanged();
        }
    }

    public void setCardClickListener(CardClickListener cardClickListener) {
        this.f34468b = cardClickListener;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new CommonViewHolder(viewGroup);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ((CommonViewHolder) viewHolder).bindData(this.f34467a.get(i));
    }

    public int getItemCount() {
        List<SfViewMenuModel> list = this.f34467a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    private class CommonViewHolder extends RecyclerView.ViewHolder {
        private TextView content = ((TextView) this.itemView.findViewById(R.id.content));
        private ImageView icon = ((ImageView) this.itemView.findViewById(R.id.icon));
        /* access modifiers changed from: private */
        public ImageView newIcon = ((ImageView) this.itemView.findViewById(R.id.icon_new));
        private TextView time = ((TextView) this.itemView.findViewById(R.id.time));
        private TextView title = ((TextView) this.itemView.findViewById(R.id.title));

        public CommonViewHolder(ViewGroup viewGroup) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sf_toolkit_dialog_menu_layout, viewGroup, false));
        }

        public void bindData(final SfViewMenuModel sfViewMenuModel) {
            if (sfViewMenuModel != null) {
                this.title.setText(sfViewMenuModel.title);
                this.content.setText(sfViewMenuModel.content);
                this.icon.setImageResource(sfViewMenuModel.icon);
                if (SfViewMenuModel.TYPE_AUDIO_RECORD.equals(sfViewMenuModel.type)) {
                    if (!TextUtils.isEmpty(sfViewMenuModel.time)) {
                        this.time.setText(sfViewMenuModel.time);
                        this.time.setVisibility(0);
                    }
                    if (TripRecordingManager.Companion.getInstance().isRecording()) {
                        sfViewMenuModel.icon = R.drawable.sf_toolkit_dialog_record_audio_open_icon;
                        this.content.setText(R.string.Global_Driver_In_trip_recording_DRV_Recording_jjLT);
                    } else {
                        sfViewMenuModel.icon = R.drawable.sf_toolkit_dialog_record_audio_close_icon;
                    }
                } else if (SfViewMenuModel.TYPE_REALTIME_MONITOR.equals(sfViewMenuModel.type)) {
                    boolean booleanValue = ((Boolean) SPUtils.get(this.newIcon.getContext(), SfViewMenuModel.newIconKey, true)).booleanValue();
                    if (!sfViewMenuModel.isNew || !booleanValue) {
                        this.newIcon.setVisibility(8);
                    } else {
                        this.newIcon.setVisibility(0);
                    }
                }
                this.itemView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (SfViewAdapter.this.f34468b != null) {
                            SfViewAdapter.this.f34468b.onClick(sfViewMenuModel);
                            CommonViewHolder.this.newIcon.setVisibility(8);
                        }
                    }
                });
            }
        }
    }

    public void notifyRecordTimeChanged(String str) {
        List<SfViewMenuModel> list;
        if (!TextUtils.isEmpty(str) && (list = this.f34467a) != null && list.size() > 0) {
            for (SfViewMenuModel next : this.f34467a) {
                if (SfViewMenuModel.TYPE_AUDIO_RECORD.equals(next.type)) {
                    next.time = str;
                    notifyDataSetChanged();
                    return;
                }
            }
        }
    }
}
