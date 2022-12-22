package com.didiglobal.e_where2go;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.drouter.api.DRouter;
import com.didiglobal.common.common.never.component.EeveeIView;
import com.didiglobal.common.common.spi.AddressParamsGetter;
import com.didiglobal.common.common.util.EeveeRichTextUtil;
import com.didiglobal.e_where2go.model.Where2GoModel;
import com.taxis99.R;

public class EWhere2goView implements EeveeIView<EWhere2goPresenter> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public EWhere2goPresenter f50050a;

    /* renamed from: b */
    private ViewGroup f50051b;

    /* renamed from: c */
    private LinearLayout f50052c;

    /* renamed from: d */
    private ImageView f50053d;

    /* renamed from: e */
    private TextView f50054e;

    /* renamed from: f */
    private RelativeLayout f50055f;

    /* renamed from: g */
    private TextView f50056g;

    /* renamed from: h */
    private ImageView f50057h;

    /* renamed from: i */
    private LinearLayout f50058i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public Context f50059j;

    /* renamed from: k */
    private AddressParamsGetter f50060k;

    public View getView() {
        return this.f50051b;
    }

    public EWhere2goView(Context context) {
        this.f50059j = context;
        m36062a(context);
    }

    public void setPresenter(EWhere2goPresenter eWhere2goPresenter) {
        this.f50050a = eWhere2goPresenter;
    }

    /* renamed from: a */
    private void m36062a(Context context) {
        ViewGroup viewGroup = (ViewGroup) View.inflate(context, R.layout.layout_common_where2go, (ViewGroup) null);
        this.f50051b = viewGroup;
        this.f50052c = (LinearLayout) viewGroup.findViewById(R.id.where2go_view);
        this.f50054e = (TextView) this.f50051b.findViewById(R.id.where2go_text);
        this.f50053d = (ImageView) this.f50051b.findViewById(R.id.where2go_icon);
        this.f50055f = (RelativeLayout) this.f50051b.findViewById(R.id.where2_top_bar);
        this.f50056g = (TextView) this.f50051b.findViewById(R.id.top_bar_text);
        this.f50057h = (ImageView) this.f50051b.findViewById(R.id.top_bar_left_icon);
        this.f50058i = (LinearLayout) this.f50051b.findViewById(R.id.where_2_main_layout);
    }

    public void setView() {
        final Where2GoModel model = this.f50050a.getModel();
        EeveeRichTextUtil.setText(this.f50054e, model.title);
        Glide.with(this.f50059j).asBitmap().load(model.icon).into(this.f50053d);
        if (model.top_banner == null || model.top_banner.title == null) {
            this.f50055f.setVisibility(8);
        } else {
            this.f50055f.setVisibility(0);
            if (model.top_banner.link != null) {
                this.f50055f.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        DRouter.build(model.top_banner.link).start(EWhere2goView.this.f50059j);
                    }
                });
            }
            EeveeRichTextUtil.setText(this.f50056g, model.top_banner.title);
            if (!TextUtils.isEmpty(model.top_banner.left_icon)) {
                if (model.top_banner.background_color != null) {
                    model.top_banner.background_color.bindView(this.f50056g, 20);
                }
                this.f50057h.setVisibility(0);
                Glide.with(this.f50059j).asBitmap().load(model.top_banner.left_icon).into(this.f50057h);
            } else {
                this.f50057h.setVisibility(8);
            }
        }
        this.f50058i.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                DRouter.build(model.link).start(EWhere2goView.this.f50059j);
                EWhere2goView.this.f50050a.omegaTrack(EWhere2goPresenter.WHERE_TO_GO_CK);
            }
        });
    }
}
