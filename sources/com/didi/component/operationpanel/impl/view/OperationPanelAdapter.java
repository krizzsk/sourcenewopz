package com.didi.component.operationpanel.impl.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.common.view.PositionSensitiveView;
import com.didi.component.core.IComponent;
import com.didi.component.core.IView;
import com.didi.component.operationpanel.AbsOperationPanelPresenter;
import com.didi.component.operationpanel.OperationPanelItemModel;
import com.didi.sdk.util.ResourcesHelper;
import com.taxis99.R;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OperationPanelAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: a */
    private static final int f14809a = 0;

    /* renamed from: b */
    private static final int f14810b = 1;

    /* renamed from: c */
    private static final int f14811c = 2;

    /* renamed from: d */
    private static final int f14812d = 3;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public AbsOperationPanelPresenter f14813e;

    /* renamed from: f */
    private List<OperationPanelItemModel> f14814f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Context f14815g;

    /* renamed from: h */
    private boolean f14816h;

    /* renamed from: i */
    private Set<IComponent> f14817i = new HashSet();

    public OperationPanelAdapter(Context context, boolean z) {
        this.f14815g = context;
        this.f14816h = z;
    }

    public void setData(List<OperationPanelItemModel> list) {
        this.f14814f = list;
        notifyDataSetChanged();
    }

    public void setPresenter(AbsOperationPanelPresenter absOperationPanelPresenter) {
        this.f14813e = absOperationPanelPresenter;
    }

    public List<OperationPanelItemModel> getData() {
        return this.f14814f;
    }

    public int getItemViewType(int i) {
        if (!this.f14816h) {
            return 0;
        }
        if (this.f14814f.get(i).f14774id == 512) {
            return 2;
        }
        return this.f14814f.get(i).f14774id == 520 ? 3 : 1;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new OperationPanelOldVH(viewGroup);
        }
        if (i == 1) {
            return new OperationPanelCommonVH(viewGroup);
        }
        if (i == 2) {
            return new OperationPanelCancelVH(viewGroup);
        }
        if (i != 3) {
            return new OperationPanelCommonVH(viewGroup);
        }
        return new OperationComponentViewVH(viewGroup);
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ((OperationPanelBaseVH) viewHolder).bindData(this.f14814f.get(i), i);
    }

    public int getItemCount() {
        List<OperationPanelItemModel> list = this.f14814f;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void onRemove() {
        for (IComponent removeComponent : this.f14817i) {
            this.f14813e.removeComponent(removeComponent);
        }
    }

    private class OperationPanelBaseVH extends RecyclerView.ViewHolder {
        public OperationPanelBaseVH(View view) {
            super(view);
        }

        public void bindData(final OperationPanelItemModel operationPanelItemModel, int i) {
            this.itemView.setEnabled(operationPanelItemModel.enable);
            this.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (OperationPanelAdapter.this.f14813e != null) {
                        OperationPanelAdapter.this.f14813e.onOperationPanelItemClicked(operationPanelItemModel);
                    }
                }
            });
        }
    }

    private class OperationPanelCancelVH extends OperationPanelBaseVH {
        private TextView mNameView = ((TextView) this.itemView.findViewById(R.id.global_operation_cancel_btn));

        public OperationPanelCancelVH(ViewGroup viewGroup) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.global_operation_panel_item_cancel, viewGroup, false));
            if (!(OperationPanelAdapter.this.f14813e != null ? OperationPanelAdapter.this.f14813e.supportStandoutColor() : true)) {
                this.mNameView.setTextColor(OperationPanelAdapter.this.f14815g.getResources().getColor(R.color.global_operation_item_text_color));
            }
            if (OperationPanelAdapter.this.getItemCount() == 1) {
                this.itemView.findViewById(R.id.global_operation_divider).setVisibility(8);
            }
        }

        public void bindData(OperationPanelItemModel operationPanelItemModel, int i) {
            super.bindData(operationPanelItemModel, i);
            if (!TextUtils.isEmpty(operationPanelItemModel.operationName)) {
                this.mNameView.setText(operationPanelItemModel.operationName);
            } else if (operationPanelItemModel.operationNameId != 0) {
                this.mNameView.setText(operationPanelItemModel.operationNameId);
            }
        }
    }

    private class OperationComponentViewVH extends OperationPanelBaseVH {
        IView cView;
        View componentView;

        public OperationComponentViewVH(ViewGroup viewGroup) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.global_operation_panel_item_component_view, viewGroup, false));
        }

        public void bindData(OperationPanelItemModel operationPanelItemModel, int i) {
            if (this.componentView == null) {
                ViewGroup viewGroup = (ViewGroup) this.itemView;
                IComponent inflateComponent = OperationPanelAdapter.this.f14813e.inflateComponent(operationPanelItemModel.componentType, viewGroup);
                viewGroup.removeAllViews();
                if (inflateComponent != null) {
                    IView view = inflateComponent.getView();
                    this.cView = view;
                    View view2 = view.getView();
                    this.componentView = view2;
                    viewGroup.addView(view2);
                }
            }
            IView iView = this.cView;
            if (iView instanceof PositionSensitiveView) {
                ((PositionSensitiveView) iView).setPositionOfParentComponent(i);
            }
        }
    }

    private class OperationPanelOldVH extends OperationPanelBaseVH {
        private TextView mNameView = ((TextView) this.itemView.findViewById(R.id.tv_operationpanel_item_name));

        public OperationPanelOldVH(ViewGroup viewGroup) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.global_operation_panel_item_hor_view, viewGroup, false));
        }

        public void bindData(OperationPanelItemModel operationPanelItemModel, int i) {
            if (!TextUtils.isEmpty(operationPanelItemModel.operationName)) {
                this.mNameView.setText(operationPanelItemModel.operationName);
            } else if (operationPanelItemModel.operationNameId != 0) {
                this.mNameView.setText(operationPanelItemModel.operationNameId);
            }
            boolean supportStandoutColor = OperationPanelAdapter.this.f14813e != null ? OperationPanelAdapter.this.f14813e.supportStandoutColor() : true;
            if (operationPanelItemModel.f14774id != 512 || !supportStandoutColor) {
                this.mNameView.setTextColor(OperationPanelAdapter.this.f14815g.getResources().getColor(R.color.global_operation_item_text_color));
            } else {
                this.mNameView.setTextColor(OperationPanelAdapter.this.f14815g.getResources().getColor(R.color.global_operation_cancel_item_text_color));
            }
            OperationPanelAdapter.this.m10606a(this.mNameView);
            super.bindData(operationPanelItemModel, i);
        }
    }

    public class OperationPanelCommonVH extends OperationPanelBaseVH {
        public ImageView mIconView = ((ImageView) this.itemView.findViewById(R.id.iv_operationpanel_item_icon));
        private TextView mNameView = ((TextView) this.itemView.findViewById(R.id.tv_operationpanel_item_name));
        private TextView mSubTitle = ((TextView) this.itemView.findViewById(R.id.tv_operationpanel_item_subtitle));

        public OperationPanelCommonVH(ViewGroup viewGroup) {
            super(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.global_operation_panel_item_new_common, viewGroup, false));
        }

        public void bindData(OperationPanelItemModel operationPanelItemModel, int i) {
            super.bindData(operationPanelItemModel, i);
            if (!TextUtils.isEmpty(operationPanelItemModel.operationName)) {
                this.mNameView.setText(operationPanelItemModel.operationName);
            } else if (operationPanelItemModel.operationNameId != 0) {
                this.mNameView.setText(operationPanelItemModel.operationNameId);
            }
            if (operationPanelItemModel.topIcon != 0) {
                this.mIconView.setImageDrawable(OperationPanelAdapter.this.f14815g.getResources().getDrawable(operationPanelItemModel.topIcon));
            }
            OperationPanelAdapter.this.m10606a(this.mNameView);
            if (!TextUtils.isEmpty(operationPanelItemModel.subTitle)) {
                this.mSubTitle.setVisibility(0);
                this.mSubTitle.setText(operationPanelItemModel.subTitle);
            } else {
                this.mSubTitle.setVisibility(8);
            }
            if (operationPanelItemModel.f14774id != 529) {
                this.mNameView.setTextColor(OperationPanelAdapter.this.f14815g.getResources().getColorStateList(R.color.global_operation_item_text_new_color));
            } else if (operationPanelItemModel.enable) {
                this.mNameView.setTextColor(OperationPanelAdapter.this.f14815g.getResources().getColorStateList(R.color.global_operation_item_text_new_color));
            } else {
                this.mNameView.setTextColor(OperationPanelAdapter.this.f14815g.getResources().getColor(R.color.g_color_D4D7D9));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m10606a(TextView textView) {
        if (textView != null && textView.getText() != null) {
            String string = ResourcesHelper.getString(textView.getContext(), R.string.contentdesc_button, textView.getText().toString());
            textView.setContentDescription(string);
            if (textView.getParent() != null) {
                ((View) textView.getParent()).setContentDescription(string);
            }
        }
    }
}
