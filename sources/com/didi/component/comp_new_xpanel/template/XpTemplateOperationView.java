package com.didi.component.comp_new_xpanel.template;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.component.comp_new_xpanel.template.XpTemplateOperationModel;
import com.didiglobal.enginecore.template.temp.IXEView;
import com.taxis99.R;

public class XpTemplateOperationView implements IXEView<XpTemplateOperationModel> {

    /* renamed from: a */
    private Context f12338a;

    /* renamed from: b */
    private View f12339b;

    /* renamed from: c */
    private TextView f12340c;

    /* renamed from: d */
    private TextView f12341d;

    /* renamed from: e */
    private ImageView f12342e;

    public void initView(Context context) {
        this.f12338a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.g_xp_template_operate, (ViewGroup) null);
        this.f12339b = inflate;
        this.f12340c = (TextView) inflate.findViewById(R.id.xp_template_operate_title);
        this.f12341d = (TextView) this.f12339b.findViewById(R.id.xp_template_operate_btn);
        this.f12342e = (ImageView) this.f12339b.findViewById(R.id.xp_template_operate_bg);
    }

    public void bindData(XpTemplateOperationModel xpTemplateOperationModel) {
        if (xpTemplateOperationModel == null || xpTemplateOperationModel.normal == null || xpTemplateOperationModel.normal.data == null) {
            this.f12339b.setVisibility(8);
            return;
        }
        this.f12339b.setVisibility(0);
        XpTemplateOperationModel.OperationTemplateData operationTemplateData = xpTemplateOperationModel.normal.data;
        if (operationTemplateData.title != null) {
            this.f12340c.setVisibility(0);
            operationTemplateData.title.bindTextView(this.f12340c);
        } else {
            this.f12340c.setVisibility(8);
        }
        if (operationTemplateData.button == null || operationTemplateData.button.title == null || TextUtils.isEmpty(operationTemplateData.button.title.getContent())) {
            this.f12341d.setVisibility(8);
        } else {
            this.f12341d.setVisibility(0);
            operationTemplateData.button.bindTextView(xpTemplateOperationModel, this.f12341d, 15);
        }
        if (!TextUtils.isEmpty(operationTemplateData.bgImage)) {
            this.f12342e.setVisibility(0);
            ((RequestBuilder) Glide.with(this.f12338a).load(operationTemplateData.bgImage).centerCrop()).into(this.f12342e);
        } else {
            this.f12342e.setVisibility(8);
        }
        if (operationTemplateData.cardClick != null) {
            operationTemplateData.cardClick.bindView(xpTemplateOperationModel, this.f12339b);
        }
    }

    public View getView() {
        return this.f12339b;
    }
}
