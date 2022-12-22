package com.didi.unifylogin.view.adpter;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.unifylogin.base.view.BaseViewUtil;
import com.didi.unifylogin.utils.LoginLog;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.phone.PhoneUtils;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.taxis99.R;
import java.io.Serializable;
import java.util.ArrayList;

public class EmailExportListAdapter extends RecyclerView.Adapter<ViewHolder> {
    protected String TAG = getClass().getSimpleName();

    /* renamed from: a */
    ArrayList<ExportInfo> f45081a;

    /* renamed from: b */
    FragmentActivity f45082b;

    public EmailExportListAdapter(FragmentActivity fragmentActivity, String str) {
        this.f45082b = fragmentActivity;
        try {
            this.f45081a = (ArrayList) new Gson().fromJson(str, new TypeToken<ArrayList<ExportInfo>>() {
            }.getType());
        } catch (Exception unused) {
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.login_unify_item_list_email_export, viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, final int i) {
        final ExportInfo exportInfo = this.f45081a.get(i);
        viewHolder.desTv.setText(exportInfo.enterDes);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                EmailExportListAdapter.this.m32376a(exportInfo);
                new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_VERIFY_EMAIL_HELP_CK).add("key：position", Integer.valueOf(i + 1)).send();
            }
        });
    }

    public int getItemCount() {
        ArrayList<ExportInfo> arrayList = this.f45081a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32376a(final ExportInfo exportInfo) {
        if (exportInfo != null) {
            BaseViewUtil.showDialog(this.f45082b, exportInfo.title, exportInfo.text, exportInfo.btnCall, exportInfo.btnCancle, new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (exportInfo.phone != null) {
                        String replace = exportInfo.phone.replace("-", "");
                        if (PhoneUtils.isNum(replace)) {
                            LoginLog.write(EmailExportListAdapter.this.TAG + " call：" + replace);
                            StringBuilder sb = new StringBuilder();
                            sb.append("tel:");
                            sb.append(replace);
                            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(sb.toString()));
                            intent.setFlags(268435456);
                            EmailExportListAdapter.this.f45082b.startActivity(intent);
                        }
                    }
                    new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_VERIFY_EMAIL_HELP_DAILOG_CALL).send();
                }
            }, new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_VERIFY_EMAIL_HELP_DAILOG_CANCEL).send();
                }
            });
            new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_VERIFY_EMAIL_HELP_DAILOG).send();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView desTv;

        public ViewHolder(View view) {
            super(view);
            this.desTv = (TextView) view.findViewById(R.id.tv_des);
        }
    }

    class ExportInfo implements Serializable {
        @SerializedName("btn_call")
        public String btnCall;
        @SerializedName("btn_cancel")
        public String btnCancle;
        @SerializedName("enter_des")
        public String enterDes;
        public String phone;
        public String text;
        public String title;

        ExportInfo() {
        }
    }
}
