package com.didi.addressold.view;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.addressold.view.enhance.CommonItemEnhancer;
import com.didi.addressold.view.enhance.EndItemEnhancer;
import com.didi.addressold.view.enhance.IAddressItemEnhancer;
import com.didi.addressold.view.enhance.StartItemEnhancer;
import com.didi.addressold.view.enhance.SugRecItemEnhancer;
import com.didi.addressold.widget.SubAddressViewApi;
import com.didi.addressold.widget.SweepView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.util.collection.CollectionUtil;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.recsug.RpcRecSug;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;

public class AddressAdapter extends BaseAdapter {

    /* renamed from: a */
    private ArrayList<RpcPoi> f7838a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public RpcRecSug.TrackParameterForChild f7839b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public OnItemSelectedListener f7840c;

    /* renamed from: d */
    private int f7841d = -1;

    /* renamed from: e */
    private IAddressItemEnhancer f7842e;

    /* renamed from: f */
    private boolean f7843f;

    public interface OnItemSelectedListener {
        void onItemSelected(RpcPoi rpcPoi, RpcRecSug.TrackParameterForChild trackParameterForChild, int i, int i2);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public AddressAdapter(boolean z) {
        this.f7843f = z;
    }

    public void updateAddress(ArrayList<RpcPoi> arrayList, RpcRecSug.TrackParameterForChild trackParameterForChild, int i) {
        this.f7838a = arrayList;
        this.f7839b = trackParameterForChild;
        this.f7841d = i;
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.f7840c = onItemSelectedListener;
    }

    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        Context context = viewGroup.getContext();
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.old_poi_one_address_address_item, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.contentLayout = view.findViewById(R.id.layout_content);
            viewHolder.markImage = (ImageView) view.findViewById(R.id.sug_icon);
            viewHolder.nameLayout = (ViewGroup) view.findViewById(R.id.layout_name);
            viewHolder.displayNameText = (TextView) view.findViewById(R.id.sug_name);
            viewHolder.sugDistrictText = (TextView) view.findViewById(R.id.sug_district);
            viewHolder.addressText = (TextView) view.findViewById(R.id.sug_addr);
            viewHolder.suggestTagView = (TextView) view.findViewById(R.id.cf_tag);
            viewHolder.recTagView = (TextView) view.findViewById(R.id.rec_tag);
            viewHolder.distanceText = (TextView) view.findViewById(R.id.sug_distance);
            viewHolder.subView = (SubAddressViewApi) view.findViewById(R.id.view_subpoi);
            viewHolder.sweepView = (SweepView) view.findViewById(R.id.sweep_view);
            viewHolder.behindDeleteView = (TextView) view.findViewById(R.id.button_delete);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        final RpcPoi item = getItem(i);
        ((RequestBuilder) ((RequestBuilder) Glide.with(context.getApplicationContext()).load(item.extend_info.pre_logo_url).placeholder((int) R.drawable.icon_position)).error((int) R.drawable.icon_position)).into(viewHolder.markImage);
        viewHolder.sweepView.setExpandable(false);
        viewHolder.sweepView.setDragClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (AddressAdapter.this.f7840c != null) {
                    AddressAdapter.this.f7840c.onItemSelected(item, AddressAdapter.this.f7839b, i, -1);
                }
            }
        });
        viewHolder.contentLayout.setContentDescription(item.base_info.displayname + item.base_info.addressAll);
        String str = item.base_info.displayname;
        if (this.f7843f && item.extend_info.is_city_cross == 1 && !TextUtils.isEmpty(item.base_info.city_name)) {
            str = item.base_info.displayname + context.getResources().getString(R.string.global_sug_name_separator) + item.base_info.city_name;
        }
        m5057a(viewHolder.displayNameText, str, item.extend_info.displayName_attribute);
        m5058a(viewHolder);
        if (this.f7842e == null) {
            SugRecItemEnhancer sugRecItemEnhancer = new SugRecItemEnhancer();
            int i2 = this.f7841d;
            if (i2 == 1) {
                this.f7842e = new StartItemEnhancer(sugRecItemEnhancer);
            } else if (i2 == 2) {
                this.f7842e = new EndItemEnhancer(sugRecItemEnhancer);
            } else {
                this.f7842e = new CommonItemEnhancer(sugRecItemEnhancer);
            }
        }
        IAddressItemEnhancer iAddressItemEnhancer = this.f7842e;
        if (iAddressItemEnhancer != null) {
            iAddressItemEnhancer.enhance(view, i, item);
        }
        viewHolder.nameLayout.requestLayout();
        if (!TextUtils.isEmpty(item.extend_info.business_district)) {
            viewHolder.sugDistrictText.setVisibility(0);
            viewHolder.sugDistrictText.setText(item.extend_info.business_district);
            if (!TextUtils.isEmpty(item.extend_info.business_district_color)) {
                viewHolder.sugDistrictText.setTextColor(Color.parseColor(item.extend_info.business_district_color));
            }
        } else {
            viewHolder.sugDistrictText.setVisibility(8);
        }
        m5060b(viewHolder.addressText, item.base_info.address, item.extend_info.address_attribute);
        if (!TextUtils.isEmpty(item.extend_info.distance)) {
            viewHolder.distanceText.setVisibility(0);
            viewHolder.distanceText.setText(item.extend_info.distance);
        } else {
            viewHolder.distanceText.setVisibility(8);
        }
        viewHolder.subView.fillData(item.sub_poi_list);
        viewHolder.subView.setOnItemClickLister(new SubAddressViewApi.OnItemClickListener() {
            public void onItemClick(RpcPoi rpcPoi, int i) {
                if (AddressAdapter.this.f7840c != null) {
                    if (rpcPoi != null && !TextUtils.isEmpty(rpcPoi.base_info.fullname)) {
                        rpcPoi.base_info.displayname = rpcPoi.base_info.fullname;
                    }
                    AddressAdapter.this.f7840c.onItemSelected(rpcPoi, AddressAdapter.this.f7839b, i, i);
                }
            }
        });
        return view;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0033, code lost:
        r2 = java.lang.Math.max(r8.location, 0);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m5057a(android.widget.TextView r6, java.lang.String r7, java.util.List<com.sdk.poibase.model.RpcPoiExtendInfo.DisplayNameAttribute> r8) {
        /*
            r5 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 != 0) goto L_0x0056
            if (r8 == 0) goto L_0x0056
            int r0 = r8.size()
            if (r0 != 0) goto L_0x000f
            goto L_0x0056
        L_0x000f:
            int r0 = r7.length()
            android.text.SpannableString r1 = new android.text.SpannableString
            r1.<init>(r7)
            java.util.Iterator r7 = r8.iterator()
        L_0x001c:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0052
            java.lang.Object r8 = r7.next()
            com.sdk.poibase.model.RpcPoiExtendInfo$DisplayNameAttribute r8 = (com.sdk.poibase.model.RpcPoiExtendInfo.DisplayNameAttribute) r8
            if (r8 == 0) goto L_0x001c
            int r2 = r8.location
            if (r2 >= r0) goto L_0x001c
            int r2 = r8.length
            if (r2 > 0) goto L_0x0033
            goto L_0x001c
        L_0x0033:
            int r2 = r8.location
            r3 = 0
            int r2 = java.lang.Math.max(r2, r3)
            int r3 = r8.location
            int r8 = r8.length
            int r3 = r3 + r8
            int r8 = java.lang.Math.min(r3, r0)
            if (r8 > r2) goto L_0x0046
            goto L_0x001c
        L_0x0046:
            android.text.style.StyleSpan r3 = new android.text.style.StyleSpan
            r4 = 1
            r3.<init>(r4)
            r4 = 33
            r1.setSpan(r3, r2, r8, r4)
            goto L_0x001c
        L_0x0052:
            r6.setText(r1)
            return
        L_0x0056:
            r6.setText(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.addressold.view.AddressAdapter.m5057a(android.widget.TextView, java.lang.String, java.util.List):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
        r2 = java.lang.Math.max(r8.location, 0);
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m5060b(android.widget.TextView r6, java.lang.String r7, java.util.List<com.sdk.poibase.model.RpcPoiExtendInfo.AddressAttribute> r8) {
        /*
            r5 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 != 0) goto L_0x0063
            if (r8 == 0) goto L_0x0063
            int r0 = r8.size()
            if (r0 != 0) goto L_0x000f
            goto L_0x0063
        L_0x000f:
            int r0 = r7.length()
            android.text.SpannableString r1 = new android.text.SpannableString
            r1.<init>(r7)
            java.util.Iterator r7 = r8.iterator()
        L_0x001c:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x005f
            java.lang.Object r8 = r7.next()
            com.sdk.poibase.model.RpcPoiExtendInfo$AddressAttribute r8 = (com.sdk.poibase.model.RpcPoiExtendInfo.AddressAttribute) r8
            if (r8 == 0) goto L_0x001c
            int r2 = r8.location
            if (r2 >= r0) goto L_0x001c
            int r2 = r8.length
            if (r2 <= 0) goto L_0x001c
            java.lang.String r2 = r8.color
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x003b
            goto L_0x001c
        L_0x003b:
            int r2 = r8.location
            r3 = 0
            int r2 = java.lang.Math.max(r2, r3)
            int r3 = r8.location
            int r4 = r8.length
            int r3 = r3 + r4
            int r3 = java.lang.Math.min(r3, r0)
            if (r3 > r2) goto L_0x004e
            goto L_0x001c
        L_0x004e:
            android.text.style.ForegroundColorSpan r4 = new android.text.style.ForegroundColorSpan
            java.lang.String r8 = r8.color
            int r8 = android.graphics.Color.parseColor(r8)
            r4.<init>(r8)
            r8 = 33
            r1.setSpan(r4, r2, r3, r8)
            goto L_0x001c
        L_0x005f:
            r6.setText(r1)
            return
        L_0x0063:
            r6.setText(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.addressold.view.AddressAdapter.m5060b(android.widget.TextView, java.lang.String, java.util.List):void");
    }

    /* renamed from: a */
    private void m5058a(final ViewHolder viewHolder) {
        viewHolder.displayNameText.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                viewHolder.displayNameText.removeOnLayoutChangeListener(this);
                viewHolder.displayNameText.setMaxWidth(viewHolder.getDisplayNameMaxSize());
            }
        });
    }

    public int getCount() {
        return CollectionUtil.size((Collection<?>) this.f7838a);
    }

    public RpcPoi getItem(int i) {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f7838a)) {
            return this.f7838a.get(i);
        }
        return null;
    }

    private class ViewHolder {
        public TextView addressText;
        public TextView behindDeleteView;
        public View contentLayout;
        public TextView displayNameText;
        public TextView distanceText;
        public ImageView markImage;
        public ViewGroup nameLayout;
        public TextView recTagView;
        public SubAddressViewApi subView;
        public TextView sugDistrictText;
        public TextView suggestTagView;
        public SweepView sweepView;

        private ViewHolder() {
        }

        public int getDisplayNameMaxSize() {
            return this.nameLayout.getWidth() - this.suggestTagView.getWidth();
        }
    }
}
