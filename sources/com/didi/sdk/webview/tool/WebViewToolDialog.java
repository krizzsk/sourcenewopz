package com.didi.sdk.webview.tool;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.onekeyshare.ShareBuilder;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.entity.OneKeyShareInfo;
import com.didi.onekeyshare.util.C10429QQ;
import com.didi.onekeyshare.util.QZone;
import com.didi.onekeyshare.view.fragment.ShareFragment;
import com.didi.sdk.component.share.ShareView;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.ToastHelper;
import com.didi.sharesdk.OneKeyShareModel;
import com.didi.sharesdk.ShareApi;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class WebViewToolDialog {

    /* renamed from: a */
    private static int[] f38502a = {1, 16, 256, 4096, 65536, 1048576, 16777216, 268435456};
    /* access modifiers changed from: private */

    /* renamed from: b */
    public AlertDialog f38503b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public View f38504c;

    /* renamed from: d */
    private View f38505d;

    /* renamed from: e */
    private ShareFragment f38506e;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m27291a(View view) {
        AlertDialog alertDialog = this.f38503b;
        if (alertDialog != null) {
            Animation loadAnimation = AnimationUtils.loadAnimation(alertDialog.getContext(), R.anim.webview_tool_footer_slide_out);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() {
                public void onAnimationRepeat(Animation animation) {
                }

                public void onAnimationStart(Animation animation) {
                }

                public void onAnimationEnd(Animation animation) {
                    WebViewToolDialog.this.f38503b.dismiss();
                }
            });
            view.startAnimation(loadAnimation);
        }
    }

    public void dismiss() {
        View view = this.f38504c;
        if (view != null) {
            m27291a(view);
        }
    }

    public ArrayList<OneKeyShareInfo> convertShareInfo(List<WebViewToolModel> list) {
        ArrayList<OneKeyShareInfo> arrayList = new ArrayList<>();
        for (WebViewToolModel next : list) {
            OneKeyShareModel oneKeyShareModel = next.onkKeyShareModel;
            OneKeyShareInfo oneKeyShareInfo = new OneKeyShareInfo();
            if (oneKeyShareModel != null) {
                oneKeyShareInfo.content = oneKeyShareModel.content;
                oneKeyShareInfo.imageData = oneKeyShareModel.bitmap;
                oneKeyShareInfo.imagePath = oneKeyShareModel.imgPath;
                oneKeyShareInfo.imageUrl = oneKeyShareModel.imgUrl;
                oneKeyShareInfo.url = oneKeyShareModel.url;
                oneKeyShareInfo.title = oneKeyShareModel.title;
                oneKeyShareInfo.customName = next.name;
                oneKeyShareInfo.smsMessage = oneKeyShareModel.smsMessage;
            }
            oneKeyShareInfo.phone = next.phone;
            if (!TextUtil.isEmpty(next.message)) {
                oneKeyShareInfo.smsMessage = next.message;
            }
            if (WebViewToolModel.contains(next.type)) {
                oneKeyShareInfo.platform = WebViewToolModel.getPlatform(next.type);
            }
            arrayList.add(oneKeyShareInfo);
        }
        return arrayList;
    }

    public void showShareFragment(FragmentActivity fragmentActivity, List<WebViewToolModel> list, ICallback.IH5ShareCallback iH5ShareCallback) {
        this.f38506e = ShareBuilder.buildH5Share(fragmentActivity, convertShareInfo(list), iH5ShareCallback);
    }

    public void show(Activity activity, List<WebViewToolModel> list, WebToolCallBack webToolCallBack) {
        if (list != null) {
            AlertDialog show = new AlertDialog.Builder(activity, R.style.web_view_tool_dialog).show();
            this.f38503b = show;
            Window window = show.getWindow();
            View inflate = LayoutInflater.from(activity).inflate(R.layout.v_webview_tool, (ViewGroup) null);
            this.f38504c = inflate;
            inflate.startAnimation(AnimationUtils.loadAnimation(activity, R.anim.webview_tool_footer_slide_in));
            this.f38505d = this.f38504c.findViewById(R.id.cut_line);
            this.f38504c.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    WebViewToolDialog webViewToolDialog = WebViewToolDialog.this;
                    webViewToolDialog.m27291a(webViewToolDialog.f38504c);
                }
            });
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            m27293a(list, (List<WebViewToolModel>) arrayList, (List<WebViewToolModel>) arrayList2);
            if (arrayList.size() <= 0 || arrayList2.size() <= 0) {
                this.f38505d.setVisibility(8);
            } else {
                this.f38505d.setVisibility(0);
            }
            initGridView(webToolCallBack, activity, arrayList);
            initToolGridView(webToolCallBack, activity, arrayList2);
            this.f38504c.setBackgroundColor(activity.getResources().getColor(R.color.transparent));
            window.setContentView(this.f38504c);
            window.setLayout(-1, -2);
            window.getAttributes().gravity = 81;
            this.f38504c.findViewById(R.id.btnWebViewToolCancel).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    WebViewToolDialog webViewToolDialog = WebViewToolDialog.this;
                    webViewToolDialog.m27291a(webViewToolDialog.f38504c);
                }
            });
        }
    }

    /* renamed from: a */
    private void m27293a(List<WebViewToolModel> list, List<WebViewToolModel> list2, List<WebViewToolModel> list3) {
        List<String> webViewModels = WebViewToolModel.getWebViewModels();
        for (int i = 0; i < list.size(); i++) {
            WebViewToolModel webViewToolModel = list.get(i);
            int indexOf = webViewModels.indexOf(webViewToolModel.type) / 2;
            if (indexOf == 6 || indexOf == 7 || indexOf == 9) {
                list3.add(webViewToolModel);
            } else {
                list2.add(webViewToolModel);
            }
        }
    }

    @Deprecated
    public void show(final Activity activity, ShareView.ShareModel shareModel) {
        ArrayList arrayList = new ArrayList();
        for (int a : f38502a) {
            WebViewToolModel a2 = m27290a((Context) activity, shareModel, a);
            if (a2 != null) {
                arrayList.add(a2);
            }
        }
        show(activity, arrayList, new WebToolCallBack() {
            public void close() {
            }

            public void refresh() {
            }

            public void webRedirect(WebViewToolModel webViewToolModel) {
            }

            public void showShareView(OneKeyShareModel oneKeyShareModel) {
                ShareApi.show(activity, oneKeyShareModel, (ICallback.IPlatformShareCallback) null);
            }
        });
    }

    /* renamed from: a */
    private WebViewToolModel m27290a(Context context, ShareView.ShareModel shareModel, int i) {
        OneKeyShareModel oneKeyShareModel = null;
        if ((shareModel.platforms & i) != i) {
            return null;
        }
        WebViewToolModel webViewToolModel = new WebViewToolModel();
        String str = shareModel.url;
        String str2 = shareModel.iconUrl;
        String str3 = shareModel.imageUrl;
        String str4 = shareModel.title;
        String str5 = shareModel.content;
        webViewToolModel.phone = shareModel.phone;
        webViewToolModel.message = shareModel.message;
        List<String> webViewModels = WebViewToolModel.getWebViewModels();
        if (4096 == i) {
            oneKeyShareModel = new OneKeyShareModel(C10429QQ.NAME);
            webViewToolModel.resId = R.drawable.share_btn_qq_normal;
            webViewToolModel.type = webViewModels.get(2);
        } else if (65536 == i) {
            oneKeyShareModel = new OneKeyShareModel(QZone.NAME);
            webViewToolModel.resId = R.drawable.share_btn_qzone_normal;
            webViewToolModel.type = webViewModels.get(3);
        } else if (1048576 == i) {
            oneKeyShareModel = new OneKeyShareModel("ALIPAY_FRIENDS");
            webViewToolModel.type = webViewModels.get(4);
        } else if (16777216 == i) {
            oneKeyShareModel = new OneKeyShareModel("ALIPAY_TIMELINE");
            webViewToolModel.type = webViewModels.get(5);
        } else if (268435456 == i) {
            oneKeyShareModel = new OneKeyShareModel("ALIPAY_TIMELINE");
            webViewToolModel.resId = R.drawable.share_btn_message;
            webViewToolModel.type = webViewModels.get(8);
            webViewToolModel.name = context.getString(R.string.share_sys_msg);
        }
        if (oneKeyShareModel != null) {
            oneKeyShareModel.url = str;
            if (TextUtils.isEmpty(str2)) {
                str2 = str3;
            }
            oneKeyShareModel.imgUrl = str2;
            oneKeyShareModel.title = str4;
            oneKeyShareModel.content = str5;
            webViewToolModel.onkKeyShareModel = oneKeyShareModel;
        }
        return webViewToolModel;
    }

    private static class WebToolAdapter extends BaseAdapter {
        private Context mContext;
        private List<WebViewToolModel> mData;

        public long getItemId(int i) {
            return (long) i;
        }

        public WebToolAdapter(List<WebViewToolModel> list, Context context) {
            this.mData = list;
            this.mContext = context;
        }

        public int getCount() {
            return this.mData.size();
        }

        public Object getItem(int i) {
            return this.mData.get(i);
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder;
            if (view == null) {
                view = LayoutInflater.from(this.mContext).inflate(R.layout.v_webview_item_tool_gridview, (ViewGroup) null);
                viewHolder = new ViewHolder();
                viewHolder.imgIcon = (ImageView) view.findViewById(R.id.imgIcon);
                viewHolder.txtName = (TextView) view.findViewById(R.id.txtName);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            WebViewToolModel webViewToolModel = this.mData.get(i);
            ImageView imageView = viewHolder.imgIcon;
            if (webViewToolModel.resId != -1) {
                imageView.setImageResource(webViewToolModel.resId);
            } else if (!TextUtil.isEmpty(webViewToolModel.icon)) {
                Glide.with(this.mContext).load(webViewToolModel.icon).into(imageView);
            }
            viewHolder.txtName.setText(webViewToolModel.name);
            return view;
        }

        private static class ViewHolder {
            public ImageView imgIcon;
            public TextView txtName;

            private ViewHolder() {
            }
        }
    }

    public void initGridView(final WebToolCallBack webToolCallBack, final Activity activity, final List<WebViewToolModel> list) {
        GridView gridView = (GridView) this.f38504c.findViewById(R.id.gridview);
        int size = list.size();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        gridView.setLayoutParams(new LinearLayout.LayoutParams((int) (((float) ((size * 66) + 9)) * displayMetrics.density), -1));
        gridView.setStretchMode(0);
        gridView.setNumColumns(size);
        gridView.setSelector(R.drawable.transparent);
        gridView.setAdapter(new WebToolAdapter(list, activity));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AutoTrackHelper.trackViewOnClick((AdapterView) adapterView, view, i);
                if (WebViewToolDialog.this.f38504c != null) {
                    WebViewToolDialog webViewToolDialog = WebViewToolDialog.this;
                    webViewToolDialog.m27291a(webViewToolDialog.f38504c);
                }
                List<String> webViewModels = WebViewToolModel.getWebViewModels();
                WebViewToolModel webViewToolModel = (WebViewToolModel) list.get(i);
                int indexOf = webViewModels.indexOf(webViewToolModel.type) / 2;
                if (indexOf == 0 || indexOf == 1 || indexOf == 2 || indexOf == 3 || indexOf == 4 || indexOf == 5) {
                    webToolCallBack.showShareView(webViewToolModel.onkKeyShareModel);
                } else if (indexOf != 8) {
                    ToastHelper.showShortCompleted((Context) activity, (int) R.string.webview_lowVer_content);
                } else {
                    WebViewToolDialog.this.sendSMS(activity, webViewToolModel.phone, webViewToolModel.message);
                }
            }
        });
    }

    public void initToolGridView(final WebToolCallBack webToolCallBack, final Activity activity, final List<WebViewToolModel> list) {
        GridView gridView = (GridView) this.f38504c.findViewById(R.id.gridview_tool);
        gridView.setNumColumns(list.size());
        int size = list.size();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        gridView.setLayoutParams(new LinearLayout.LayoutParams((int) (((float) ((size * 67) + 9)) * displayMetrics.density), -1));
        gridView.setStretchMode(0);
        gridView.setSelector(R.drawable.transparent);
        gridView.setAdapter(new WebToolAdapter(list, activity));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AutoTrackHelper.trackViewOnClick((AdapterView) adapterView, view, i);
                if (WebViewToolDialog.this.f38504c != null) {
                    WebViewToolDialog webViewToolDialog = WebViewToolDialog.this;
                    webViewToolDialog.m27291a(webViewToolDialog.f38504c);
                }
                List<String> webViewModels = WebViewToolModel.getWebViewModels();
                WebViewToolModel webViewToolModel = (WebViewToolModel) list.get(i);
                int indexOf = webViewModels.indexOf(webViewToolModel.type) / 2;
                if (indexOf == 6) {
                    webToolCallBack.refresh();
                } else if (indexOf == 7) {
                    webToolCallBack.webRedirect(webViewToolModel);
                } else if (indexOf != 9) {
                    ToastHelper.showShortCompleted((Context) activity, (int) R.string.webview_lowVer_content);
                } else {
                    webToolCallBack.close();
                }
            }
        });
    }

    public void sendSMS(Context context, String str, String str2) {
        try {
            Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + str));
            intent.putExtra("sms_body", str2);
            context.startActivity(intent);
        } catch (Exception e) {
            LoggerFactory.getLogger("WebViewToolDialog").debug("sendSMS Exception", e.toString());
        }
    }

    public void dismissH5Dialog() {
        ShareFragment shareFragment = this.f38506e;
        if (shareFragment != null) {
            shareFragment.dismissTrack();
        }
    }
}
