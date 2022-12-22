package com.didichuxing.xpanel.debug.p199ui;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.xpanel.agent.net.XPanelRequest;
import com.didichuxing.xpanel.debug.models.DebugInfo;
import com.didichuxing.xpanel.debug.models.ListItem;
import com.didichuxing.xpanel.util.LogcatUtil;
import com.didichuxing.xpanel.util.Utils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didichuxing.xpanel.debug.ui.DebugActivity */
public class DebugActivity extends Activity {
    public static String sUserName = "";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f49486a;

    /* renamed from: b */
    private ActionBar f49487b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public AlertDialog f49488c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AlertDialog f49489d;

    /* renamed from: e */
    private RecyclerView f49490e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String[] f49491f = {"", "", "Agent v3 线上", "Agent 线上", "Agent 线上 (Global)", "Agent 线下", "Agent 线下 (Japan)", "Agent 线下 (Mexico)", "测试", "第一台机器", "预览接口(redis)", "预览接口(mock)", "其他...", ""};

    /* renamed from: g */
    private String[] f49492g = {"", "", XPanelRequest.AGENT_ONLINE, XPanelRequest.AGENT_ONLINE_GLOBAL, "", "", "", "", "", "", ""};

    /* renamed from: h */
    private String[] f49493h = {"当前接口地址", "选择接口", "", "", "", "", "", "", "", "", "", "", "", "历史记录"};
    /* access modifiers changed from: private */

    /* renamed from: i */
    public AgentAdapter f49494i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public List<ListItem> f49495j = new ArrayList();

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView(R.layout.oc_x_panel_debug_activity);
        this.f49486a = this;
        ActionBar actionBar = getActionBar();
        this.f49487b = actionBar;
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            this.f49487b.setHomeButtonEnabled(true);
            this.f49487b.setDisplayShowTitleEnabled(true);
            this.f49487b.setTitle(R.string.oc_x_panel_debug_main_title);
        }
        m35716b();
        m35711a();
    }

    /* renamed from: a */
    private void m35711a() {
        this.f49495j.clear();
        for (int i = 0; i < this.f49491f.length; i++) {
            ListItem listItem = new ListItem();
            listItem.content = this.f49491f[i];
            listItem.url = this.f49492g[i];
            listItem.description = this.f49493h[i];
            if (i == 0) {
                listItem.subContent = getResources().getString(R.string.oc_x_panel_debug_description);
                listItem.itemType = 2;
            }
            if (i == this.f49492g.length - 2) {
                listItem.itemType = 1;
            }
            if (i == this.f49492g.length - 3) {
                listItem.itemType = 4;
            }
            if (i == 1 || i == this.f49491f.length - 1) {
                listItem.isShowDivider = true;
                listItem.itemType = 2;
            }
            this.f49495j.add(listItem);
        }
        for (int i2 = 0; i2 < XPanelRequest.mDebugInfos.size(); i2++) {
            ListItem listItem2 = new ListItem();
            DebugInfo debugInfo = XPanelRequest.mDebugInfos.get(i2);
            listItem2.itemType = 3;
            listItem2.content = debugInfo.getRequestUrl();
            listItem2.subContent = debugInfo.getRequestTime() + " " + debugInfo.getDimension();
            this.f49495j.add(listItem2);
        }
    }

    /* renamed from: b */
    private void m35716b() {
        final Button button = (Button) findViewById(R.id.ox_x_panel_debug_btn_omega);
        button.setText(R.string.oc_x_panel_debug_omega_log_on);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (LogcatUtil.sLogEnable) {
                    LogcatUtil.sLogEnable = false;
                    button.setText(R.string.oc_x_panel_debug_omega_log_on);
                    return;
                }
                LogcatUtil.sLogEnable = true;
                button.setText(R.string.oc_x_panel_debug_omega_log_off);
            }
        });
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.oc_x_panel_debug_address_list);
        this.f49490e = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this.f49486a));
        AgentAdapter agentAdapter = new AgentAdapter();
        this.f49494i = agentAdapter;
        this.f49490e.setAdapter(agentAdapter);
        this.f49490e.setOverScrollMode(2);
    }

    /* renamed from: com.didichuxing.xpanel.debug.ui.DebugActivity$AgentAdapter */
    private class AgentAdapter extends RecyclerView.Adapter {
        private AgentAdapter() {
        }

        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new SimpleHolder(LayoutInflater.from(DebugActivity.this.f49486a).inflate(R.layout.oc_x_panel_debug_item, viewGroup, false));
        }

        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            SimpleHolder simpleHolder = (SimpleHolder) viewHolder;
            ListItem listItem = (ListItem) DebugActivity.this.f49495j.get(i);
            if (listItem != null) {
                String str = listItem.content;
                String str2 = listItem.description;
                String str3 = listItem.subContent;
                boolean z = listItem.isShowDivider;
                int i2 = 0;
                if (i == 0) {
                    simpleHolder.content.setText(XPanelRequest.mDebugUrl);
                    simpleHolder.content.setVisibility(0);
                } else {
                    simpleHolder.content.setText(str);
                    simpleHolder.content.setVisibility(Utils.getVisibility(str));
                }
                View view = simpleHolder.divider1;
                if (!z) {
                    i2 = 8;
                }
                view.setVisibility(i2);
                simpleHolder.description1.setText(str2);
                simpleHolder.description1.setVisibility(Utils.getVisibility(str2));
                simpleHolder.subContent.setText(str3);
                simpleHolder.subContent.setVisibility(Utils.getVisibility(str3));
                simpleHolder.content.setMaxLines(3);
                simpleHolder.itemView.setTag(Integer.valueOf(i));
            }
        }

        public int getItemCount() {
            return DebugActivity.this.f49495j.size();
        }

        /* renamed from: com.didichuxing.xpanel.debug.ui.DebugActivity$AgentAdapter$SimpleHolder */
        private class SimpleHolder extends RecyclerView.ViewHolder {
            public TextView content;
            public TextView description1;
            public View divider1;
            public TextView subContent;

            public SimpleHolder(View view) {
                super(view);
                this.content = (TextView) view.findViewById(R.id.oc_x_panel_debug_content);
                this.subContent = (TextView) view.findViewById(R.id.oc_x_panel_debug_sub_content);
                this.divider1 = view.findViewById(R.id.oc_x_panel_debug_divider1);
                this.description1 = (TextView) view.findViewById(R.id.oc_x_panel_debug_item_description1);
                view.setOnClickListener(new View.OnClickListener(AgentAdapter.this) {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        try {
                            int intValue = ((Integer) view.getTag()).intValue();
                            ListItem listItem = (ListItem) DebugActivity.this.f49495j.get(intValue);
                            if (listItem != null) {
                                int i = listItem.itemType;
                                if (i == 1) {
                                    SimpleHolder.this.showHostDialog();
                                } else if (i == 2) {
                                } else {
                                    if (i == 3) {
                                        Intent intent = new Intent(DebugActivity.this.f49486a, DetailActivity.class);
                                        intent.putExtra("position", intValue - DebugActivity.this.f49491f.length);
                                        DebugActivity.this.startActivity(intent);
                                    } else if (i != 4) {
                                        XPanelRequest.changeDebugURL(listItem.url);
                                        AgentAdapter.this.notifyItemChanged(0);
                                    } else {
                                        SimpleHolder.this.showPhoneDialog();
                                    }
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }

            /* access modifiers changed from: private */
            public void showPhoneDialog() {
                if (DebugActivity.this.f49489d == null) {
                    AlertDialog unused = DebugActivity.this.f49489d = createPhoneDialog();
                }
                Window window = DebugActivity.this.f49489d.getWindow();
                if (window != null) {
                    window.setSoftInputMode(5);
                }
                SystemUtils.showDialog(DebugActivity.this.f49489d);
            }

            /* access modifiers changed from: private */
            public void showHostDialog() {
                if (DebugActivity.this.f49488c == null) {
                    AlertDialog unused = DebugActivity.this.f49488c = createAddressDialog();
                }
                Window window = DebugActivity.this.f49488c.getWindow();
                if (window != null) {
                    window.setSoftInputMode(5);
                }
                SystemUtils.showDialog(DebugActivity.this.f49488c);
            }

            private AlertDialog createAddressDialog() {
                AlertDialog.Builder builder = new AlertDialog.Builder(DebugActivity.this.f49486a);
                builder.setTitle(R.string.oc_x_panel_debug_add_address);
                View inflate = LayoutInflater.from(DebugActivity.this.f49486a).inflate(R.layout.oc_x_panel_debug_dialog, (ViewGroup) null);
                builder.setView(inflate);
                builder.setCancelable(true);
                final EditText editText = (EditText) inflate.findViewById(R.id.debug_url_input);
                editText.setText("http://agent/v3/feeds");
                editText.setSelection(editText.getText().toString().length());
                builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AutoTrackHelper.trackViewOnClick(dialogInterface, i);
                        String obj = editText.getText().toString();
                        if (TextUtils.isEmpty(obj) || !DebugActivity.this.m35713a(obj)) {
                            SystemUtils.showToast(Toast.makeText(DebugActivity.this.f49486a, "invalid url", 0));
                        } else {
                            XPanelRequest.changeDebugURL(obj);
                            DebugActivity.this.f49494i.notifyItemChanged(0);
                        }
                        dialogInterface.cancel();
                    }
                });
                builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AutoTrackHelper.trackViewOnClick(dialogInterface, i);
                        dialogInterface.cancel();
                    }
                });
                return builder.create();
            }

            private AlertDialog createPhoneDialog() {
                AlertDialog.Builder builder = new AlertDialog.Builder(DebugActivity.this.f49486a);
                builder.setTitle("输入mis账号名：");
                View inflate = LayoutInflater.from(DebugActivity.this.f49486a).inflate(R.layout.oc_x_panel_debug_dialog, (ViewGroup) null);
                builder.setView(inflate);
                builder.setCancelable(true);
                final EditText editText = (EditText) inflate.findViewById(R.id.debug_url_input);
                editText.setHint("输入的用户名将会作为参数上传");
                editText.setSelection(editText.getText().toString().length());
                builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AutoTrackHelper.trackViewOnClick(dialogInterface, i);
                        String obj = editText.getText().toString();
                        if (!TextUtils.isEmpty(obj)) {
                            DebugActivity.sUserName = obj;
                            AgentAdapter.this.notifyItemChanged(0);
                        }
                        dialogInterface.cancel();
                    }
                });
                builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        AutoTrackHelper.trackViewOnClick(dialogInterface, i);
                        dialogInterface.cancel();
                    }
                });
                return builder.create();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m35713a(String str) {
        return Patterns.WEB_URL.matcher(str.toLowerCase()).matches() && !str.endsWith("/");
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }
}
