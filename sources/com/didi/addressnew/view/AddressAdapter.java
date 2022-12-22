package com.didi.addressnew.view;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.address.model.SugParams;
import com.didi.addressnew.view.enhance.CommonItemEnhancer;
import com.didi.addressnew.view.enhance.EndItemEnhancer;
import com.didi.addressnew.view.enhance.IAddressItemEnhancer;
import com.didi.addressnew.view.enhance.StartItemEnhancer;
import com.didi.addressnew.view.enhance.SugRecItemEnhancer;
import com.didi.addressnew.widget.SubAddressViewApi;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.util.collection.CollectionUtil;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.RpcPoiExtendInfo;
import com.sdk.poibase.model.recsug.RpcRecSug;
import com.sdk.poibase.model.recsug.RpcRecSugInfo;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class AddressAdapter extends BaseAdapter {

    /* renamed from: a */
    private ArrayList<RpcPoi> f7482a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public RpcRecSug.TrackParameterForChild f7483b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public OnItemSelectedListener f7484c;

    /* renamed from: d */
    private int f7485d;

    /* renamed from: e */
    private SugParams f7486e;

    /* renamed from: f */
    private int f7487f = -1;

    /* renamed from: g */
    private IAddressItemEnhancer f7488g;

    /* renamed from: h */
    private boolean f7489h;

    public interface OnItemSelectedListener {
        void onItemSelected(RpcPoi rpcPoi, RpcPoi rpcPoi2, RpcRecSug.TrackParameterForChild trackParameterForChild, int i, int i2);
    }

    public interface OnMapConfirmClickListener {
        void onMapConfirmClicked(ArrayList<RpcPoi> arrayList, RpcRecSug.TrackParameterForChild trackParameterForChild, int i, int i2);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public void updateAddress(ArrayList<RpcPoi> arrayList, SugParams sugParams, RpcRecSug.TrackParameterForChild trackParameterForChild, int i, int i2) {
        this.f7482a = arrayList;
        m4735a();
        this.f7486e = sugParams;
        this.f7483b = trackParameterForChild;
        this.f7487f = i;
        this.f7485d = i2;
    }

    /* renamed from: a */
    private void m4735a() {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f7482a)) {
            Iterator<RpcPoi> it = this.f7482a.iterator();
            while (it.hasNext()) {
                RpcPoi next = it.next();
                if (next != null && (next.base_info == null || (next.base_info != null && TextUtils.isEmpty(next.base_info.displayname) && TextUtils.isEmpty(next.base_info.address)))) {
                    it.remove();
                }
            }
        }
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.f7484c = onItemSelectedListener;
    }

    public void setSupportConfirmDropOff(boolean z) {
        this.f7489h = z;
    }

    public View getView(final int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        Context context = viewGroup.getContext();
        ArrayList<RpcPoiExtendInfo.AddressAttribute> arrayList = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.poi_one_address_address_item, viewGroup, false);
            viewHolder = new ViewHolder();
            viewHolder.itemLayout = view.findViewById(R.id.layout_item);
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
            viewHolder.behindDeleteView = (TextView) view.findViewById(R.id.button_delete);
            viewHolder.discountView = (SubAddressViewApi) view.findViewById(R.id.view_discountpoi);
            viewHolder.broadArrow = (ImageView) view.findViewById(R.id.poi_item_arrow);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        final RpcPoi item = getItem(i);
        if (item.extend_info != null) {
            if (!TextUtils.isEmpty(item.extend_info.pre_icon_url)) {
                int i2 = this.f7487f;
                if (i2 == 1) {
                    ((RequestBuilder) ((RequestBuilder) Glide.with(context.getApplicationContext()).load(item.extend_info.pre_icon_url).placeholder((int) R.drawable.icon_position_start)).error((int) R.drawable.icon_position_start)).into(viewHolder.markImage);
                } else if (i2 == 2 || i2 == 6 || i2 == 101 || i2 == 102 || i2 == 4 || i2 == 3 || i2 == 5) {
                    ((RequestBuilder) ((RequestBuilder) Glide.with(context.getApplicationContext()).load(item.extend_info.pre_icon_url).placeholder((int) R.drawable.icon_position_end)).error((int) R.drawable.icon_position_end)).into(viewHolder.markImage);
                }
            } else {
                ((RequestBuilder) ((RequestBuilder) Glide.with(context.getApplicationContext()).load(item.extend_info.pre_logo_url).placeholder((int) R.drawable.icon_position)).error((int) R.drawable.icon_position)).into(viewHolder.markImage);
            }
        }
        if (item.base_info != null) {
            viewHolder.contentLayout.setContentDescription(item.base_info.displayname + item.base_info.addressAll);
            m4736a(viewHolder.displayNameText, TextUtils.isEmpty(item.base_info.displayname) ? item.base_info.address : item.base_info.displayname, item.extend_info != null ? item.extend_info.displayName_attribute : null);
        }
        m4740b(viewHolder);
        if (this.f7488g == null) {
            SugRecItemEnhancer sugRecItemEnhancer = new SugRecItemEnhancer();
            sugRecItemEnhancer.setSupportConfirmDropOff(this.f7489h);
            sugRecItemEnhancer.setSupportMultiLineName(true);
            int i3 = this.f7487f;
            if (i3 == 1) {
                this.f7488g = new StartItemEnhancer(sugRecItemEnhancer);
            } else if (i3 == 2) {
                this.f7488g = new EndItemEnhancer(sugRecItemEnhancer);
            } else {
                this.f7488g = new CommonItemEnhancer(sugRecItemEnhancer);
            }
        }
        viewHolder.nameLayout.requestLayout();
        if (item.extend_info == null || TextUtils.isEmpty(item.extend_info.business_district)) {
            viewHolder.sugDistrictText.setVisibility(8);
        } else {
            viewHolder.sugDistrictText.setVisibility(0);
            viewHolder.sugDistrictText.setText(item.extend_info.business_district);
            if (!TextUtils.isEmpty(item.extend_info.business_district_color)) {
                viewHolder.sugDistrictText.setTextColor(Color.parseColor(item.extend_info.business_district_color));
            }
        }
        if (item.base_info != null) {
            String str = TextUtils.isEmpty(item.base_info.address) ? item.base_info.displayname : item.base_info.address;
            TextView textView = viewHolder.addressText;
            if (item.extend_info != null) {
                arrayList = item.extend_info.address_attribute;
            }
            m4739b(textView, str, arrayList);
        }
        if (item.extend_info == null || TextUtils.isEmpty(item.extend_info.distance)) {
            viewHolder.distanceText.setVisibility(8);
        } else {
            viewHolder.distanceText.setVisibility(0);
            viewHolder.distanceText.setText(item.extend_info.distance);
        }
        IAddressItemEnhancer iAddressItemEnhancer = this.f7488g;
        if (iAddressItemEnhancer != null) {
            iAddressItemEnhancer.enhance(view, i, item);
        }
        viewHolder.itemLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (AddressAdapter.this.f7484c != null) {
                    AddressAdapter.this.f7484c.onItemSelected(item, (RpcPoi) null, AddressAdapter.this.f7483b, i, -1);
                }
            }
        });
        boolean z = !CollectionUtil.isEmpty((Collection<?>) item.discount_poi);
        viewHolder.discountView.fillData(item, item.discount_poi, z, this.f7483b);
        viewHolder.discountView.setOnItemClickLister(new SubAddressViewApi.OnItemClickListener() {
            public void onItemClick(RpcPoi rpcPoi, int i) {
                if (AddressAdapter.this.f7484c != null) {
                    if (!(rpcPoi == null || rpcPoi.base_info == null || TextUtils.isEmpty(rpcPoi.base_info.fullname))) {
                        rpcPoi.base_info.displayname = rpcPoi.base_info.fullname;
                    }
                    AddressAdapter.this.f7484c.onItemSelected(rpcPoi, item, AddressAdapter.this.f7483b, i, i);
                }
            }
        });
        viewHolder.subView.fillData(item, item.sub_poi_list, !z, this.f7483b);
        viewHolder.subView.setOnItemClickLister(new SubAddressViewApi.OnItemClickListener() {
            public void onItemClick(RpcPoi rpcPoi, int i) {
                if (AddressAdapter.this.f7484c != null) {
                    if (!(rpcPoi == null || rpcPoi.base_info == null || TextUtils.isEmpty(rpcPoi.base_info.fullname))) {
                        rpcPoi.base_info.displayname = rpcPoi.base_info.fullname;
                    }
                    AddressAdapter.this.f7484c.onItemSelected(rpcPoi, item, AddressAdapter.this.f7483b, i, i);
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
    private void m4736a(android.widget.TextView r6, java.lang.String r7, java.util.List<com.sdk.poibase.model.RpcPoiExtendInfo.DisplayNameAttribute> r8) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.didi.addressnew.view.AddressAdapter.m4736a(android.widget.TextView, java.lang.String, java.util.List):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
        r2 = java.lang.Math.max(r8.location, 0);
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4739b(android.widget.TextView r6, java.lang.String r7, java.util.List<com.sdk.poibase.model.RpcPoiExtendInfo.AddressAttribute> r8) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.didi.addressnew.view.AddressAdapter.m4739b(android.widget.TextView, java.lang.String, java.util.List):void");
    }

    /* renamed from: a */
    private void m4737a(final ViewHolder viewHolder) {
        viewHolder.displayNameText.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                viewHolder.displayNameText.removeOnLayoutChangeListener(this);
                viewHolder.displayNameText.setMaxWidth(viewHolder.getDisplayNameMaxSize());
            }
        });
    }

    /* renamed from: b */
    private void m4740b(ViewHolder viewHolder) {
        if (m4741b()) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewHolder.distanceText.getLayoutParams();
            if (this.f7485d == RpcRecSugInfo.TYPE_EMPTY_RESULT) {
                layoutParams.rightMargin = 34;
                viewHolder.broadArrow.setVisibility(0);
            } else {
                layoutParams.rightMargin = 20;
                viewHolder.broadArrow.setVisibility(8);
            }
            viewHolder.distanceText.setLayoutParams(layoutParams);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000d, code lost:
        r0 = r3.f7486e;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m4741b() {
        /*
            r3 = this;
            int r0 = r3.f7485d
            int r1 = com.sdk.poibase.model.recsug.RpcRecSugInfo.TYPE_EMPTY_RESULT
            r2 = 1
            if (r0 == r1) goto L_0x000d
            int r0 = r3.f7485d
            int r1 = com.sdk.poibase.model.recsug.RpcRecSugInfo.TYPE_SIMILAR_SCENE
            if (r0 != r1) goto L_0x0041
        L_0x000d:
            com.didi.address.model.SugParams r0 = r3.f7486e
            if (r0 == 0) goto L_0x0041
            com.didi.address.FromType r0 = r0.fromType
            com.didi.address.FromType r1 = com.didi.address.FromType.FROM_HOME_ROUTE_EDITOR
            if (r0 == r1) goto L_0x0041
            com.didi.address.model.SugParams r0 = r3.f7486e
            com.didi.address.FromType r0 = r0.fromType
            com.didi.address.FromType r1 = com.didi.address.FromType.ROUTE_EDITOR
            if (r0 == r1) goto L_0x0041
            com.didi.address.model.SugParams r0 = r3.f7486e
            com.didi.address.FromType r0 = r0.fromType
            com.didi.address.FromType r1 = com.didi.address.FromType.FROM_CONFIRM_ROUTE_EDITOR
            if (r0 == r1) goto L_0x0041
            com.didi.address.model.SugParams r0 = r3.f7486e
            com.didi.address.FromType r0 = r0.fromType
            com.didi.address.FromType r1 = com.didi.address.FromType.OPEN_RIDE_ROUTE_EDIT
            if (r0 == r1) goto L_0x0041
            com.didi.address.model.SugParams r0 = r3.f7486e
            com.sdk.poibase.model.AddressParam r0 = r0.addressParam
            int r0 = r0.addressType
            if (r0 == r2) goto L_0x0042
            com.didi.address.model.SugParams r0 = r3.f7486e
            com.sdk.poibase.model.AddressParam r0 = r0.addressParam
            int r0 = r0.addressType
            r1 = 2
            if (r0 != r1) goto L_0x0041
            goto L_0x0042
        L_0x0041:
            r2 = 0
        L_0x0042:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.addressnew.view.AddressAdapter.m4741b():boolean");
    }

    public int getCount() {
        return CollectionUtil.size((Collection<?>) this.f7482a);
    }

    public RpcPoi getItem(int i) {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f7482a)) {
            return this.f7482a.get(i);
        }
        return null;
    }

    private class ViewHolder {
        public TextView addressText;
        public TextView behindDeleteView;
        public ImageView broadArrow;
        public View contentLayout;
        public SubAddressViewApi discountView;
        public TextView displayNameText;
        public TextView distanceText;
        public View itemLayout;
        public ImageView markImage;
        public ViewGroup nameLayout;
        public TextView recTagView;
        public SubAddressViewApi subView;
        public TextView sugDistrictText;
        public TextView suggestTagView;

        private ViewHolder() {
        }

        public int getDisplayNameMaxSize() {
            return this.nameLayout.getWidth() - this.suggestTagView.getWidth();
        }
    }
}
