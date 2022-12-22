package com.rider.rlab_im_map_plugin.gps;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.app.nova.skeleton.dialog.Dialog;
import com.didi.app.nova.skeleton.dialog.SimpleTransformAnimation;
import com.didi.app.nova.skeleton.dialog.TransformAnimation;
import com.didi.autotracker.AutoTrackHelper;
import com.rider.rlab_im_map_plugin.channel.MapIMServiceImpl;
import com.rider.rlab_im_map_plugin.engine.ImMapConfig;
import com.rider.rlab_im_map_plugin.tool.ImFavorFrom;
import com.taxis99.R;

public class AppGpsDialog extends Dialog {

    /* renamed from: a */
    private TextView f55878a;

    /* renamed from: b */
    private TextView f55879b;

    /* renamed from: c */
    private TextView f55880c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public OnCancelListener f55881d;

    public interface OnCancelListener {
        void onCancel();
    }

    public void onDestroy() {
    }

    public void onDismiss() {
    }

    public boolean onHandleBack() {
        return true;
    }

    public View onCreate(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.rider_im_gps_dialog, viewGroup, false);
        this.f55879b = (TextView) inflate.findViewById(R.id.tv_set_gps);
        this.f55878a = (TextView) inflate.findViewById(R.id.tv_cancel_gps);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_gps_content);
        this.f55880c = textView;
        this.f55880c.setText(textView.getContext().getResources().getString(R.string.FoodC_IM_Unauthorized_location_kORQ));
        if (ImMapConfig.getInstance().getFavorFrom() == ImFavorFrom.IMMAP_BRAZIL) {
            this.f55879b.setTextColor(ImMapConfig.getInstance().getContext().getResources().getColor(R.color.theme_rider_global_base_brand_color));
        } else {
            this.f55879b.setTextColor(ImMapConfig.getInstance().getContext().getResources().getColor(R.color.theme_rider_brazil_base_brand_color));
        }
        return inflate;
    }

    public void onShow() {
        this.f55879b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                MapIMServiceImpl.iMapViewProvider.goToGpsSetting();
            }
        });
        this.f55878a.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AppGpsDialog.this.dismiss();
                if (AppGpsDialog.this.f55881d != null) {
                    AppGpsDialog.this.f55881d.onCancel();
                }
            }
        });
    }

    public TransformAnimation getEnterAnimation() {
        return new SimpleTransformAnimation();
    }

    public TransformAnimation getExitAnimation() {
        return new SimpleTransformAnimation();
    }

    public void setOnCancelListener(OnCancelListener onCancelListener) {
        this.f55881d = onCancelListener;
    }
}
