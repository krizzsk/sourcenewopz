package com.didi.beatles.p099im.views.bottombar;

import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.IMCommonContextInfoHelper;
import com.didi.beatles.p099im.access.IMEngine;
import com.didi.beatles.p099im.access.action.IMActionItem;
import com.didi.beatles.p099im.access.style.IMStyleManager;
import com.didi.beatles.p099im.access.utils.ConfigLoadListener;
import com.didi.beatles.p099im.access.utils.IMBusinessConfig;
import com.didi.beatles.p099im.api.entity.IMSessionExtendInfo;
import com.didi.beatles.p099im.common.IMBtsAudioHelper;
import com.didi.beatles.p099im.data.IMInnerData;
import com.didi.beatles.p099im.event.IMMessageUnlockRecyclerViewEvent;
import com.didi.beatles.p099im.manager.IMManager;
import com.didi.beatles.p099im.module.IIMGlobalModule;
import com.didi.beatles.p099im.module.IIMUserModule;
import com.didi.beatles.p099im.module.IMEmojiModule;
import com.didi.beatles.p099im.module.IMUsefulExpressionCallback;
import com.didi.beatles.p099im.module.entity.IMSession;
import com.didi.beatles.p099im.omega.IMMsgOmega;
import com.didi.beatles.p099im.omega.IMTraceUtil;
import com.didi.beatles.p099im.pref.IMPreference;
import com.didi.beatles.p099im.protocol.host.IMActionInvokeEnv;
import com.didi.beatles.p099im.protocol.host.IMActionInvokeReturn;
import com.didi.beatles.p099im.protocol.model.IMExtendActionItem;
import com.didi.beatles.p099im.protocol.model.IMTabActionItem;
import com.didi.beatles.p099im.protocol.view.IMGuideConfig;
import com.didi.beatles.p099im.protocol.view.IMSkinConfig;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.utils.C4234I;
import com.didi.beatles.p099im.utils.IMEmotionInputDetector;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.utils.IMParamUtil;
import com.didi.beatles.p099im.utils.IMPermissionDescUtil;
import com.didi.beatles.p099im.utils.IMStreetUtils;
import com.didi.beatles.p099im.utils.IMTextUtil;
import com.didi.beatles.p099im.utils.IMToastHelper;
import com.didi.beatles.p099im.utils.IMViewUtil;
import com.didi.beatles.p099im.views.IMRecommendEmojiView;
import com.didi.beatles.p099im.views.bottombar.IMBaseBottomBar;
import com.didi.beatles.p099im.views.bottombar.contain.IMBtmContainCallback;
import com.didi.beatles.p099im.views.bottombar.contain.IMBtmContainManager;
import com.didi.beatles.p099im.views.bottombar.recorder.IMBtmRecorder;
import com.didi.beatles.p099im.views.bottombar.recorder.IMBtmRecorderAdmin;
import com.didi.beatles.p099im.views.bottombar.recorder.IMBtmRecorderGlobalPsg;
import com.didi.beatles.p099im.views.bottombar.tab.IMBtmTabContainManager;
import com.didi.beatles.p099im.views.bottombar.tab.IMBtmTabUtil;
import com.didi.commoninterfacelib.permission.PermissionCallback;
import com.didi.commoninterfacelib.permission.PermissionContext;
import com.didi.commoninterfacelib.permission.PermissionUtil;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;

/* renamed from: com.didi.beatles.im.views.bottombar.IMConversationBottomBar */
public class IMConversationBottomBar extends IMBaseBottomBar {
    public static final int TYPE_DO_NOTIING = 3;
    public static final int TYPE_SET_VOICE_MODE = 4;
    public static final int TYPE_SHOW_COMMON_WORD = 2;
    public static final int TYPE_SHOW_KEY_BOARD = 1;
    public static final int TYPE_SHOW_ROBOT = 5;

    /* renamed from: j */
    private static final String f9974j = "IMConversationBtmBar";

    /* renamed from: s */
    private static final int f9975s = 5;

    /* renamed from: A */
    private boolean f9976A = false;

    /* renamed from: B */
    private IMBtmRecorder f9977B;

    /* renamed from: C */
    private View.OnClickListener f9978C = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            int id = view.getId();
            if (id == R.id.bottombar_voice_btn) {
                IMConversationBottomBar.this.m6770m();
            } else if (id == R.id.bottombar_keyboard_btn) {
                IMConversationBottomBar.this.setModeKeyboard(false);
            } else if (id == R.id.btn_send) {
                IMConversationBottomBar.this.m6768l();
            } else if (id == R.id.bottombar_commomword_btn) {
                IMConversationBottomBar.this.m6734a(1, false);
            } else if (id == R.id.et_sendmessage) {
                IMConversationBottomBar.this.m6764j();
            } else if (id != R.id.bottombar_more_btn) {
            } else {
                if (!IMConversationBottomBar.this.m6728B()) {
                    IMConversationBottomBar.this.m6734a(2, false);
                } else if (IMConversationBottomBar.this.f9986f.isTagExpandShow(String.valueOf(2))) {
                    IMConversationBottomBar.this.m6734a(3, false);
                } else {
                    IMConversationBottomBar.this.f9989i.invokeActionItem(IMConversationBottomBar.this.f10003y, true);
                }
            }
        }
    };

    /* renamed from: D */
    private View.OnFocusChangeListener f9979D = new View.OnFocusChangeListener() {
        public void onFocusChange(View view, boolean z) {
            if (z && IMConversationBottomBar.this.mListener != null) {
                IMConversationBottomBar.this.mListener.onEditFocus();
            }
        }
    };

    /* renamed from: E */
    private TextWatcher f9980E = new TextWatcher() {
        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (!TextUtils.isEmpty(charSequence)) {
                IMConversationBottomBar.this.f9991l.setVisibility(0);
                IMConversationBottomBar.this.f9983c.setVisibility(8);
                IMConversationBottomBar.this.m6755e();
                if (IMConversationBottomBar.this.f9995p) {
                    if (charSequence.toString().length() < 5) {
                        int a = IMConversationBottomBar.this.m6744b(charSequence.toString());
                        if (a != -1) {
                            IMConversationBottomBar.this.m6733a(a);
                        } else {
                            IMConversationBottomBar.this.m6766k();
                        }
                    } else {
                        IMConversationBottomBar.this.m6766k();
                    }
                }
            } else {
                IMConversationBottomBar.this.f9991l.setVisibility(8);
                IMConversationBottomBar.this.m6753d();
                IMConversationBottomBar.this.m6760h();
            }
        }
    };

    /* renamed from: a */
    IMSkinTextView f9981a;

    /* renamed from: b */
    IMSkinTextView f9982b;

    /* renamed from: c */
    IMSkinTextView f9983c;

    /* renamed from: d */
    IMSkinTextView f9984d;

    /* renamed from: e */
    View f9985e;

    /* renamed from: f */
    IMEmotionInputDetector f9986f;

    /* renamed from: g */
    boolean f9987g;

    /* renamed from: h */
    boolean f9988h;

    /* renamed from: i */
    IMBtmContainManager f9989i;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public EditText f9990k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public TextView f9991l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public TextView f9992m;
    public View mContentRootView;
    public IMBottomSkinManager mSkinManager;

    /* renamed from: n */
    private TextView f9993n;

    /* renamed from: o */
    private boolean f9994o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public boolean f9995p;

    /* renamed from: q */
    private ViewGroup f9996q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public List<IMEmojiModule> f9997r;

    /* renamed from: t */
    private IMBtmTabContainManager f9998t;

    /* renamed from: u */
    private FrameLayout f9999u;

    /* renamed from: v */
    private IMRecommendEmojiView f10000v;

    /* renamed from: w */
    private boolean f10001w = true;

    /* renamed from: x */
    private boolean f10002x = false;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public IMActionItem f10003y = null;

    /* renamed from: z */
    private IMBottomGuideManager f10004z = null;

    public void onActivityCreate() {
        super.onActivityCreate();
        m6746b();
        m6758g();
        m6784v();
        m6785w();
        m6781s();
        m6783u();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View view;
        if (this.mBusinessConfig.getIMStyle() == IMStyleManager.Style.GLOBAL_PSG) {
            view = layoutInflater.inflate(R.layout.bts_im_bottom_bar_global_psg, viewGroup, false);
        } else {
            view = layoutInflater.inflate(R.layout.bts_im_bottom_bar, viewGroup, false);
        }
        m6736a(view);
        return view;
    }

    /* renamed from: a */
    private void m6736a(View view) {
        this.mContentRootView = view;
        view.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_bottom_bar_background_round));
        this.f9985e = view.findViewById(R.id.rl_bottom);
        EditText editText = (EditText) view.findViewById(R.id.et_sendmessage);
        this.f9990k = editText;
        editText.setHint(getContext().getString(R.string.bts_im_chat_input_default));
        this.f9990k.setCursorVisible(true);
        this.f9990k.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_bottom_bar_input_bg));
        this.f9982b = (IMSkinTextView) view.findViewById(R.id.bottombar_keyboard_btn);
        this.f9981a = (IMSkinTextView) view.findViewById(R.id.bottombar_voice_btn);
        this.f9991l = (TextView) view.findViewById(R.id.btn_send);
        this.f9984d = (IMSkinTextView) view.findViewById(R.id.bottombar_commomword_btn);
        this.f9983c = (IMSkinTextView) view.findViewById(R.id.bottombar_more_btn);
        this.f9991l.setText(getContext().getString(R.string.bts_im_button_send));
        TextView textView = (TextView) view.findViewById(R.id.voice_text);
        this.f9992m = textView;
        textView.setText(getContext().getString(R.string.bts_im_button_pushtotalk));
        this.f9992m.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_bottom_bar_voice_text_bg_nor));
        this.f9993n = (TextView) view.findViewById(R.id.disable_text);
        m6751c(view);
        m6747b(view);
    }

    /* renamed from: b */
    private void m6746b() {
        IMBottomSkinManager iMBottomSkinManager = new IMBottomSkinManager();
        this.mSkinManager = iMBottomSkinManager;
        iMBottomSkinManager.bindVoiceBtnView(this.f9981a);
        this.mSkinManager.bindCommonWordView(this.f9984d);
        this.mSkinManager.bindKeyBoardView(this.f9982b);
        this.mSkinManager.bindMoreBtnView(this.f9983c);
        this.mSkinManager.showCommonSkin();
    }

    /* renamed from: c */
    private void m6750c() {
        if (!this.f9994o || this.f10002x || !TextUtils.isEmpty(this.f9990k.getText())) {
            m6755e();
            return;
        }
        IMSkinTextView iMSkinTextView = this.f9984d;
        if (iMSkinTextView != null) {
            iMSkinTextView.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m6753d() {
        IMSkinTextView iMSkinTextView;
        if (this.f9994o && !this.f10002x && (iMSkinTextView = this.f9984d) != null) {
            iMSkinTextView.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m6755e() {
        IMSkinTextView iMSkinTextView = this.f9984d;
        if (iMSkinTextView != null) {
            iMSkinTextView.setVisibility(8);
        }
    }

    /* renamed from: b */
    private void m6747b(View view) {
        ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.user_view_contain);
        this.f9996q = viewGroup;
        IMBtmContainManager iMBtmContainManager = new IMBtmContainManager(viewGroup, this.mBusinessId);
        this.f9989i = iMBtmContainManager;
        iMBtmContainManager.setCallback(new IMBtmContainCallback() {
            public void backToFunc() {
                IMConversationBottomBar.this.m6734a(2, false);
            }

            public void invokeAction(IMActionItem iMActionItem, final boolean z) {
                if (IMConversationBottomBar.this.mListener != null) {
                    if (z) {
                        if (IMConversationBottomBar.this.m6728B()) {
                            IMTraceUtil.addBusinessEvent("ddim_service_mini_kkrobot_ck").report();
                        } else {
                            IMTraceUtil.addBusinessEvent("ddim_service_kkrobot_add_ck").add("order_id", IMConversationBottomBar.this.m6729C()).add(IMConversationBottomBar.this.m6730D()).report();
                        }
                    }
                    IMActionInvokeReturn invokeAction = IMConversationBottomBar.this.mListener.invokeAction(iMActionItem, new IMActionInvokeEnv(IMConversationBottomBar.this.getContext()) {
                        public String getRobotGuideId() {
                            return IMConversationBottomBar.this.mBusinessParam != null ? IMConversationBottomBar.this.mBusinessParam.getRobotGuideId() : "";
                        }

                        public int getBusinessId() {
                            return IMConversationBottomBar.this.mBusinessId;
                        }

                        public long getSessionId() {
                            if (IMConversationBottomBar.this.mSession != null) {
                                return IMConversationBottomBar.this.mSession.getSessionId();
                            }
                            return 0;
                        }

                        public String getOrderId() {
                            return IMConversationBottomBar.this.m6729C();
                        }

                        public int getActionSource() {
                            return IMConversationBottomBar.this.m6728B() ? z ? 1 : 2 : z ? 3 : 4;
                        }

                        public Map<String, String> getBusinessTraceParam() {
                            return IMConversationBottomBar.this.m6730D();
                        }

                        public int getContentHeight() {
                            return IMConversationBottomBar.this.f9986f.getKeyboardHeight();
                        }
                    });
                    if (!(invokeAction == null || invokeAction.containView == null)) {
                        IMConversationBottomBar.this.f9989i.refreshCustomView(invokeAction.containView, IMConversationBottomBar.this.f10003y == null);
                        IMConversationBottomBar.this.m6734a(3, false);
                    }
                    IMConversationBottomBar.this.f9989i.refreshFuncStatus(iMActionItem);
                }
            }

            public void sendCommonWord(String str, int i) {
                IMTraceUtil.addBusinessEvent("ddim_service_kkrobot_msglist_ck").add("order_id", IMConversationBottomBar.this.m6729C()).add("tips_text", str).add(IMConversationBottomBar.this.m6730D()).report();
                if (IMConversationBottomBar.this.mListener != null) {
                    IMConversationBottomBar.this.mListener.onTextMessageSend(str, 65536, i);
                }
            }

            public void addCommonWord(int i) {
                if (IMConversationBottomBar.this.mListener != null) {
                    IMConversationBottomBar.this.mListener.showAddCustomWordDialog((String) null, 1, i);
                }
            }

            public void sendEmoji(String str, String str2, String str3) {
                if (IMConversationBottomBar.this.mListener != null) {
                    IMConversationBottomBar.this.mListener.sendEmoji(str, str2, str3);
                }
            }
        });
    }

    /* renamed from: c */
    private void m6751c(View view) {
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.im_bottom_tab_contain_container);
        this.f9999u = frameLayout;
        IMBtmTabContainManager iMBtmTabContainManager = new IMBtmTabContainManager(frameLayout, this.mBusinessId);
        this.f9998t = iMBtmTabContainManager;
        iMBtmTabContainManager.setExtraTraceMap(m6730D());
        this.f9998t.setCallback(new IMBtmTabContainManager.IMBtmTabContainCallback() {
            public void invokeMsgAction(boolean z) {
                IMConversationBottomBar.this.m6734a(1, true);
            }

            public void invokeEmojiAction(boolean z) {
                IMConversationBottomBar.this.m6734a(4, true);
            }

            public void invokeFuncAction(boolean z) {
                IMConversationBottomBar.this.m6734a(2, true);
            }

            public void invokePluginAction(final IMTabActionItem iMTabActionItem, final boolean z) {
                IMActionInvokeReturn invokeTabAction;
                if (IMConversationBottomBar.this.mListener != null && (invokeTabAction = IMConversationBottomBar.this.mListener.invokeTabAction(iMTabActionItem, new IMActionInvokeEnv(IMConversationBottomBar.this.getContext()) {
                    public String getRobotGuideId() {
                        return IMConversationBottomBar.this.mBusinessParam != null ? IMConversationBottomBar.this.mBusinessParam.getRobotGuideId() : "";
                    }

                    public int getBusinessId() {
                        return IMConversationBottomBar.this.mBusinessId;
                    }

                    public long getSessionId() {
                        if (IMConversationBottomBar.this.mSession != null) {
                            return IMConversationBottomBar.this.mSession.getSessionId();
                        }
                        return 0;
                    }

                    public String getOrderId() {
                        return IMConversationBottomBar.this.m6729C();
                    }

                    public int getActionSource() {
                        return z ? 5 : 6;
                    }

                    public Map<String, String> getBusinessTraceParam() {
                        return IMConversationBottomBar.this.m6730D();
                    }

                    public int getContentHeight() {
                        return IMConversationBottomBar.this.f9986f.getKeyboardHeight();
                    }

                    public int getPluginTheme() {
                        if (iMTabActionItem.pluginId != 3) {
                            return super.getPluginTheme();
                        }
                        if (IMConversationBottomBar.this.mSession == null || IMConversationBottomBar.this.mSession.getExtendSessionInfo() == null || IMConversationBottomBar.this.mSession.getExtendSessionInfo().robotTheme != 1) {
                            return 0;
                        }
                        return 1;
                    }
                })) != null && invokeTabAction.containView != null) {
                    IMConversationBottomBar.this.f9989i.refreshCustomView(invokeTabAction.containView, false);
                    IMConversationBottomBar.this.m6734a(3, true);
                }
            }
        });
    }

    /* renamed from: f */
    private boolean m6757f() {
        IMBusinessConfig currentBusinessConfig = IMEngine.getInstance(getContext()).getCurrentBusinessConfig(this.mBusinessId);
        if (currentBusinessConfig == null) {
            return true;
        }
        return currentBusinessConfig.isUseAudioMessage();
    }

    public void setRecommendEmojiView(IMRecommendEmojiView iMRecommendEmojiView) {
        this.f10000v = iMRecommendEmojiView;
        iMRecommendEmojiView.setRecommondListener(new IMRecommendEmojiView.RecommendListener() {
            public void onClick(String str, String str2, String str3) {
                if (IMConversationBottomBar.this.mListener != null) {
                    IMConversationBottomBar.this.f9990k.setText("");
                    IMConversationBottomBar.this.mListener.sendEmoji(str, str2, str3);
                }
            }
        });
    }

    /* renamed from: g */
    private void m6758g() {
        this.f9981a.setViewClickListener(this.f9978C);
        this.f9982b.setViewClickListener(this.f9978C);
        this.f9992m.setOnClickListener(this.f9978C);
        this.f9991l.setOnClickListener(this.f9978C);
        this.f9990k.setOnClickListener(this.f9978C);
        this.f9983c.setViewClickListener(this.f9978C);
        this.f9984d.setViewClickListener(this.f9978C);
        this.f9990k.addTextChangedListener(this.f9980E);
        this.f9990k.setOnFocusChangeListener(this.f9979D);
        if (this.mBusinessConfig.getIMStyle() == IMStyleManager.Style.GLOBAL_PSG) {
            this.f9977B = new IMBtmRecorderGlobalPsg();
        } else {
            this.f9977B = new IMBtmRecorderAdmin();
        }
        this.f9977B.bindListener(this.f9992m, this);
    }

    public void bindEmotionInputDetector(Activity activity, View view) {
        this.f9986f = IMEmotionInputDetector.with(activity).setEmotionView(this.f9996q).bindToContent(view).bindToEditText(this.f9990k).bindToCommonButton(this.f9984d).bindToBottom(this).build();
    }

    public IMEmotionInputDetector getEmotion() {
        return this.f9986f;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m6760h() {
        if (!this.f9987g || this.f9991l.isShown()) {
            this.f9983c.setVisibility(8);
        } else {
            this.f9983c.setVisibility(0);
        }
    }

    /* renamed from: a */
    private void m6740a(String str) {
        IMLog.m6631d(f9974j, "[showChatDisable]  disableHint=" + str);
        IMViewUtil.show((View) this.f9993n);
        IMViewUtil.hide(this.f9985e);
        if (TextUtils.isEmpty(str)) {
            this.f9993n.setText(IMResource.getString(R.string.im_can_not_send_msg));
        } else {
            this.f9993n.setText(str);
        }
        ViewGroup viewGroup = this.f9996q;
        if (viewGroup != null) {
            viewGroup.setVisibility(8);
        }
        IMBtmTabContainManager iMBtmTabContainManager = this.f9998t;
        if (iMBtmTabContainManager != null) {
            iMBtmTabContainManager.clear();
        }
    }

    /* renamed from: a */
    private void m6742a(boolean z, String str) {
        IMEmotionInputDetector iMEmotionInputDetector;
        IMLog.m6631d(f9974j, "showChatExpire: " + z);
        IMViewUtil.show(this.f9985e);
        IMViewUtil.hide((View) this.f9993n);
        if (this.f10001w) {
            setModeKeyboard(true);
            this.f10001w = false;
        }
        this.f9990k.setFocusable(z);
        this.f9990k.setFocusableInTouchMode(z);
        this.f9990k.setEnabled(z);
        this.f9981a.setClickable(z);
        this.f9983c.setClickable(z);
        this.f9984d.setClickable(z);
        this.f9992m.setEnabled(z);
        this.f9982b.setEnabled(z);
        if (!z) {
            this.f9990k.setHintTextColor(IMResource.getColor(R.color.bts_im_editview_disable));
            if (TextUtils.isEmpty(str)) {
                this.f9990k.setHint(IMResource.getString(R.string.im_can_not_send_msg));
            } else {
                this.f9990k.setHint(str);
            }
            if (!this.mSession.getSessionEnable() || m6763i()) {
                IMLog.m6635i(f9974j, "[showChatExpire] hide expand view with session is expired");
                this.f9996q.setVisibility(8);
            }
            this.mSkinManager.showDisableSkin();
            return;
        }
        this.f9990k.setHintTextColor(IMResource.getColor(R.color.bts_im_editview_able));
        this.f9990k.setHint(IMResource.getString(R.string.bts_im_chat_input_default));
        this.mSkinManager.showCommonSkin();
        if (this.f9996q.getVisibility() == 0 && (iMEmotionInputDetector = this.f9986f) != null && !iMEmotionInputDetector.isTagExpandShow("3") && this.mBusinessConfig.getIMStyle() != IMStyleManager.Style.GLOBAL_PSG) {
            this.f9984d.showCustomSkin(IMBottomSkinManager.KEY_BOARD);
        }
    }

    /* renamed from: i */
    private boolean m6763i() {
        List<IMSessionExtendInfo.BottomTabInfo> list;
        IMBtmTabContainManager iMBtmTabContainManager;
        int checkedPluginId;
        if (this.mSession == null || this.mSession.getExtendSessionInfo() == null || (list = this.mSession.getExtendSessionInfo().bottomTabInfoList) == null || list.size() == 0 || (iMBtmTabContainManager = this.f9998t) == null || (checkedPluginId = iMBtmTabContainManager.getCheckedPluginId()) == -1) {
            return true;
        }
        for (IMSessionExtendInfo.BottomTabInfo next : list) {
            if (next != null && next.f9129id == checkedPluginId && next.isEnable()) {
                IMLog.m6631d(f9974j, C4234I.m6591t("[shouldHideCurrentTabPanel] Still show tab : " + checkedPluginId));
                return false;
            }
        }
        IMLog.m6631d(f9974j, C4234I.m6591t("[shouldHideCurrentTabPanel] Should hide tab : " + checkedPluginId));
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m6764j() {
        if (TextUtils.isEmpty(this.f9990k.getText().toString())) {
            this.f9984d.showCommonSkin();
            m6750c();
            m6760h();
        }
        m6741a(false);
        m6777p();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public int m6744b(String str) {
        List<IMEmojiModule> list = this.f9997r;
        if (list == null || list.size() == 0) {
            return -1;
        }
        for (int i = 0; i < this.f9997r.size(); i++) {
            if (this.f9997r.get(i).desc != null && this.f9997r.get(i).desc.equals(str)) {
                return i;
            }
        }
        return -1;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6733a(int i) {
        List<IMEmojiModule> list = this.f9997r;
        if (list != null && list.size() >= i) {
            this.f10000v.show(this.f9997r.get(i));
            HashMap hashMap = new HashMap();
            hashMap.put("name", this.f9997r.get(i).desc);
            IMMsgOmega.getInstance().track("ddim_dy_all_icon_sw", hashMap);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m6766k() {
        if (this.f10000v.isShown()) {
            this.f10000v.dismiss();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m6768l() {
        String trim = this.f9990k.getText().toString().trim();
        if (!TextUtils.isEmpty(trim)) {
            this.mListener.onTextMessageSend(trim, 65536, -1);
            this.f9990k.setText("");
            return;
        }
        IMToastHelper.showShortInfo(getContext(), IMResource.getString(R.string.im_input_not_null));
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m6770m() {
        if (PermissionUtil.checkPermissionAllGranted(this.context, Permission.RECORD_AUDIO)) {
            try {
                if (IMBtsAudioHelper.checkRecordPermission()) {
                    if (this.mListener != null) {
                        this.mListener.onEditFocus();
                    }
                    m6780r();
                    m6741a(false);
                    this.f9984d.showCommonSkin();
                    m6753d();
                    this.f9990k.setVisibility(8);
                    this.f9981a.setVisibility(8);
                    this.f9982b.setVisibility(0);
                    this.f9991l.setVisibility(8);
                    this.f9992m.setVisibility(0);
                    m6760h();
                    m6774o();
                }
            } catch (Exception unused) {
                SystemUtils.showToast(Toast.makeText(getContext(), IMResource.getString(R.string.im_something_wrong_with_record_permission), 0));
            }
        } else {
            IMPermissionDescUtil.INSTANCE.showPermissionDesc(this.context, Permission.RECORD_AUDIO);
            PermissionUtil.requestPermissions((PermissionContext) getContext(), (PermissionCallback) new PermissionCallback() {
                public void isAllGranted(boolean z, String[] strArr) {
                    if (!((Activity) IMConversationBottomBar.this.getContext()).isFinishing()) {
                        IMPermissionDescUtil.INSTANCE.hidePermissionDesc();
                        if (z) {
                            try {
                                if (IMBtsAudioHelper.checkRecordPermission()) {
                                    if (IMConversationBottomBar.this.mListener != null) {
                                        IMConversationBottomBar.this.mListener.onEditFocus();
                                    }
                                    IMConversationBottomBar.this.m6780r();
                                    IMConversationBottomBar.this.m6741a(false);
                                    IMConversationBottomBar.this.f9984d.showCommonSkin();
                                    IMConversationBottomBar.this.m6753d();
                                    IMConversationBottomBar.this.f9990k.setVisibility(8);
                                    IMConversationBottomBar.this.f9981a.setVisibility(8);
                                    IMConversationBottomBar.this.f9982b.setVisibility(0);
                                    IMConversationBottomBar.this.f9991l.setVisibility(8);
                                    IMConversationBottomBar.this.f9992m.setVisibility(0);
                                    IMConversationBottomBar.this.m6760h();
                                    IMConversationBottomBar.this.m6774o();
                                }
                            } catch (Exception unused) {
                                SystemUtils.showToast(Toast.makeText(IMConversationBottomBar.this.getContext(), IMResource.getString(R.string.im_something_wrong_with_record_permission), 0));
                            }
                        }
                    }
                }
            }, Permission.RECORD_AUDIO, false);
        }
    }

    /* renamed from: n */
    private void m6772n() {
        IMBtmTabContainManager iMBtmTabContainManager = this.f9998t;
        if (iMBtmTabContainManager != null) {
            iMBtmTabContainManager.showTab();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m6774o() {
        IMBtmTabContainManager iMBtmTabContainManager = this.f9998t;
        if (iMBtmTabContainManager != null) {
            iMBtmTabContainManager.hideTab();
        }
    }

    /* renamed from: p */
    private void m6777p() {
        IMBtmTabContainManager iMBtmTabContainManager = this.f9998t;
        if (iMBtmTabContainManager != null) {
            iMBtmTabContainManager.reset();
        }
    }

    public void setModeKeyboard(boolean z) {
        if (!z) {
            m6778q();
            m6741a(false);
        }
        this.f9990k.setVisibility(0);
        this.f9982b.setVisibility(8);
        this.f9981a.setVisibility(m6757f() ? 0 : 8);
        this.f9990k.requestFocus();
        this.f9992m.setVisibility(8);
        m6772n();
        if (TextUtils.isEmpty(this.f9990k.getText())) {
            this.f9991l.setVisibility(8);
            m6753d();
            m6760h();
            return;
        }
        m6755e();
        this.f9991l.setVisibility(0);
        this.f9983c.setVisibility(8);
    }

    /* renamed from: q */
    private void m6778q() {
        IMEmotionInputDetector iMEmotionInputDetector = this.f9986f;
        if (iMEmotionInputDetector != null) {
            iMEmotionInputDetector.showSoftInput();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public void m6780r() {
        IMEmotionInputDetector iMEmotionInputDetector = this.f9986f;
        if (iMEmotionInputDetector != null) {
            iMEmotionInputDetector.hideSoftInput();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6741a(boolean z) {
        if (this.f9996q.isShown()) {
            this.f9996q.setVisibility(8);
            EventBus.getDefault().post(new IMMessageUnlockRecyclerViewEvent(0));
            if (!z) {
                this.f9984d.showCommonSkin();
            }
            m6777p();
        }
    }

    public IMBaseBottomBar.BottomBarListener getBottomBarListener() {
        return this.mListener;
    }

    /* renamed from: s */
    private void m6781s() {
        String draft = this.mSession.getDraft();
        if (!IMTextUtil.isEmpty(draft)) {
            this.f9990k.setText(draft);
            this.f9990k.requestFocus();
            this.f9990k.setSelection(draft.length());
        }
    }

    /* renamed from: t */
    private void m6782t() {
        IMLog.m6631d(f9974j, "[resetDraft]");
        EditText editText = this.f9990k;
        if (editText != null) {
            editText.setText("");
        }
    }

    /* renamed from: u */
    private void m6783u() {
        IMBottomGuideManager iMBottomGuideManager = new IMBottomGuideManager(this);
        this.f10004z = iMBottomGuideManager;
        iMBottomGuideManager.showBottomGuide();
    }

    public void onDestroy() {
        super.onDestroy();
        EditText editText = this.f9990k;
        if (editText != null) {
            editText.removeTextChangedListener(this.f9980E);
            this.f9990k.setOnFocusChangeListener((View.OnFocusChangeListener) null);
            this.f9990k.setCursorVisible(false);
        }
        IMBtmContainManager iMBtmContainManager = this.f9989i;
        if (iMBtmContainManager != null) {
            iMBtmContainManager.release();
        }
        IMBottomGuideManager iMBottomGuideManager = this.f10004z;
        if (iMBottomGuideManager != null) {
            iMBottomGuideManager.release();
        }
        IMBtmTabContainManager iMBtmTabContainManager = this.f9998t;
        if (iMBtmTabContainManager != null) {
            iMBtmTabContainManager.release();
        }
    }

    /* renamed from: v */
    private void m6784v() {
        this.f9995p = this.mBusinessConfig.isShowEmoji();
        this.f9994o = this.mBusinessConfig.isShowUsefulExpression();
    }

    /* renamed from: w */
    private void m6785w() {
        m6750c();
        if (!(this.mSession == null || this.mSession.getExtendSessionInfo() == null)) {
            IMSessionExtendInfo extendSessionInfo = this.mSession.getExtendSessionInfo();
            boolean z = extendSessionInfo.bottomTabInfoList != null && extendSessionInfo.bottomTabInfoList.size() > 0;
            if (this.mSession.getExtendSessionInfo().openActionIds == null || !this.mSession.getExtendSessionInfo().openActionIds.contains(3)) {
                if (z) {
                    if (!this.mSession.getSessionEnable()) {
                        IMLog.m6635i(f9974j, "TAB btm session disable so initBottomInput return");
                        return;
                    }
                } else if (this.mSession.getExtendSessionInfo().input == 0) {
                    IMLog.m6635i(f9974j, "mSession status is disable initBottomInput return");
                    return;
                }
            } else if (!this.mSession.getSessionEnable()) {
                IMLog.m6635i(f9974j, "robot btm session disable so initBottomInput return");
                return;
            }
        }
        if (this.mBusinessParam != null) {
            int bottomInputConfig = this.mBusinessParam.getBottomInputConfig();
            if (bottomInputConfig == 4 && !m6757f()) {
                bottomInputConfig = 3;
            }
            if (bottomInputConfig == 1) {
                m6778q();
                m6748b(false);
            } else if (bottomInputConfig == 2) {
                m6748b(true);
            } else if (bottomInputConfig == 3) {
                m6748b(false);
            } else if (bottomInputConfig == 4) {
                m6770m();
            } else if (bottomInputConfig != 5) {
                m6748b(this.mBusinessConfig.isDefaultOpenUsefulExpression());
            } else {
                m6748b(true);
                IMBtmTabContainManager iMBtmTabContainManager = this.f9998t;
                if (iMBtmTabContainManager != null) {
                    iMBtmTabContainManager.setCheck(3);
                }
            }
        }
    }

    /* renamed from: b */
    private void m6748b(boolean z) {
        IMLog.m6631d(f9974j, "initReplayAndEmoji isShow:" + this.f9994o + " isExpand: " + z + " isEmoji:" + this.f9995p);
        if (this.f9994o) {
            this.f9989i.configMsg(this.f9995p);
            m6788z();
            if (z && !m6786x() && !m6787y()) {
                m6734a(1, false);
            }
            if (m6728B()) {
                IMTraceUtil.BusinessParam add = IMTraceUtil.addBusinessEvent("ddim_service_mini_kkrobot_sw").add("order_id", m6729C()).add(m6730D());
                IMActionItem iMActionItem = this.f10003y;
                if (!(iMActionItem == null || iMActionItem.item == null)) {
                    IMExtendActionItem iMExtendActionItem = this.f10003y.item;
                    Context context = getContext();
                    IMGuideConfig btmGuideConfig = iMExtendActionItem.getBtmGuideConfig(context, this.mSession.getSessionId() + "", this.mListener.getBottomGuideConfigList());
                    if (btmGuideConfig != null) {
                        add.add("btn_tips", btmGuideConfig.text);
                    }
                }
                add.report();
                return;
            }
            return;
        }
        this.f9996q.setVisibility(8);
    }

    /* renamed from: x */
    private boolean m6786x() {
        IMBtmContainManager iMBtmContainManager = this.f9989i;
        if (iMBtmContainManager == null) {
            return false;
        }
        for (IMActionItem next : iMBtmContainManager.getFuncList()) {
            if (next.item != null && next.enable && next.item.invokeWhenEnter()) {
                this.f9989i.invokeActionItem(next, false);
                return true;
            }
        }
        return false;
    }

    /* renamed from: y */
    private boolean m6787y() {
        List<IMTabActionItem> tabActionItemList;
        IMBtmTabContainManager iMBtmTabContainManager = this.f9998t;
        if (iMBtmTabContainManager == null || (tabActionItemList = iMBtmTabContainManager.getTabActionItemList()) == null) {
            return false;
        }
        int bottomTabSelectPluginId = IMPreference.getInstance(getContext()).getBottomTabSelectPluginId(IMCommonContextInfoHelper.getUid(), 4);
        for (IMTabActionItem next : tabActionItemList) {
            if (next.enable && bottomTabSelectPluginId == next.pluginId) {
                IMLog.m6631d(f9974j, C4234I.m6591t("[tryShowTabActionWhenInit] setCheck=", Integer.valueOf(bottomTabSelectPluginId)));
                this.f9998t.setCheck(next.pluginId);
                return true;
            }
        }
        return false;
    }

    /* renamed from: z */
    private void m6788z() {
        boolean z;
        IMSkinConfig moreSkinConfig;
        if (this.f9994o) {
            this.f9989i.refreshSystemComWords(this.mBusinessConfig.getQuickMessages(mo44029a(), this.mBusinessId), IMStreetUtils.enableStreetImage(this.mSession));
            IIMUserModule userModel = IMManager.getInstance().getUserModel();
            if (userModel == null) {
                IMLog.m6632e(f9974j, "getCustomCommonWord failed while userModule is null !");
            } else if (!this.f9976A) {
                this.f9976A = true;
                userModel.executeUsfulExpression(3, 0, (String) null, new IMUsefulExpressionCallback() {
                    public void onResponse(int i, String str) {
                        if (i == 0) {
                            IMConversationBottomBar.this.f9989i.refreshCustomWords(IMManager.getInstance().getCustomUsefulExpression());
                        }
                    }
                });
            }
            this.f9997r = null;
            if (this.mBusinessConfig.isShowEmoji()) {
                IMLog.m6635i(f9974j, "try load list while get getIMEmojiList");
                this.mBusinessConfig.getIMEmojiList(mo44029a(), this.mBusinessId, new ConfigLoadListener.IMGetEmojiListCallback() {
                    public void finishLoad(ArrayList<IMEmojiModule> arrayList) {
                        if (arrayList == null || arrayList.size() == 0) {
                            IMLog.m6632e(IMConversationBottomBar.f9974j, "list is null while getIMEmojiList");
                        }
                        List unused = IMConversationBottomBar.this.f9997r = arrayList;
                        IMConversationBottomBar.this.f9989i.refreshEmojis(arrayList);
                    }
                });
            }
            if (this.f9997r != null) {
                IMLog.m6635i(f9974j, "remove tab emoji config while getIMEmojiList");
                IMSessionExtendInfo.BottomTabInfo tab = IMBtmTabUtil.getTab(getBottomBarListener(), 6);
                if (tab != null) {
                    tab.ignore = true;
                }
            } else if (IMBtmTabUtil.getTab(getBottomBarListener(), 6) != null) {
                IMLog.m6635i(f9974j, "try load im emoji config while getIMEmojiList");
                this.f9995p = true;
                IIMGlobalModule globalModel = IMManager.getInstance().getGlobalModel();
                if (globalModel != null) {
                    if (globalModel.getCommonConfig() != null) {
                        IMInnerData.getInstance().setEmojiPrefix(globalModel.getCommonConfig().emojiUrlPrefix);
                    }
                    if (this.mSession.getExtendSessionInfo() != null) {
                        this.f9997r = globalModel.getEmojiConfigList(this.mBusinessId, this.mSession.getExtendSessionInfo().emojiKey);
                    }
                }
                this.f9989i.refreshTabEmojis(this.f9997r);
            }
        }
        List<IMActionItem> systemAction = this.mListener == null ? null : this.mListener.getSystemAction();
        List<IMActionItem> interceptMoreAction = this.mListener.interceptMoreAction(this.mBusinessConfig.getIMMoreAction(mo44029a()));
        if (!(interceptMoreAction == null || this.mSession.getExtendSessionInfo() == null)) {
            for (IMActionItem iMActionItem : interceptMoreAction) {
                iMActionItem.enable = this.mSession.getExtendSessionInfo().input != 0;
            }
        }
        ArrayList<IMActionItem> arrayList = new ArrayList<>();
        if (systemAction != null) {
            arrayList.addAll(systemAction);
        }
        if (interceptMoreAction != null) {
            arrayList.addAll(interceptMoreAction);
        }
        List<IMSessionExtendInfo.BottomTabInfo> bottomTabList = this.mListener != null ? this.mListener.getBottomTabList() : null;
        if (bottomTabList != null) {
            Iterator<IMSessionExtendInfo.BottomTabInfo> it = bottomTabList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                IMSessionExtendInfo.BottomTabInfo next = it.next();
                if (next != null && next.f9129id == 5) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        boolean z2 = !z && arrayList.size() > 0;
        this.f9987g = z2;
        if (z2 && !this.f9988h && this.mBusinessConfig != null) {
            this.f9988h = true;
            this.mBusinessConfig.onMoreButtonShow(this.mSession, this.mBusinessParam);
        }
        this.f9989i.refreshSystemFunc(systemAction);
        this.f9989i.refreshMoreFunc(interceptMoreAction);
        m6727A();
        this.f10003y = null;
        this.mSkinManager.bindMoreBtnView(this.f9983c);
        if (arrayList.size() == 1) {
            IMActionItem iMActionItem2 = (IMActionItem) arrayList.get(0);
            this.f10003y = iMActionItem2;
            if (!(iMActionItem2.item == null || (moreSkinConfig = iMActionItem2.item.moreSkinConfig(getContext())) == null)) {
                this.mSkinManager.updateBtnView(this.f9983c, moreSkinConfig);
            }
        }
        this.f9983c.resetViewSkin();
        m6760h();
        if (this.mSession.getExtendSessionInfo().input == 0) {
            for (IMActionItem iMActionItem3 : arrayList) {
                if (iMActionItem3.enable) {
                    this.f9983c.showCommonSkin();
                    this.f9983c.setClickable(true);
                    return;
                }
            }
        }
    }

    /* renamed from: A */
    private void m6727A() {
        if (this.mSession != null && this.mSession.getExtendSessionInfo() != null) {
            boolean z = true;
            if (!this.mSession.getSessionEnable()) {
                IMLog.m6631d(f9974j, "[onUpdateBottomTabInfo] Disable bottom tab");
                return;
            }
            List<IMSessionExtendInfo.BottomTabInfo> bottomTabList = this.mListener != null ? this.mListener.getBottomTabList() : null;
            this.f9998t.refreshTabList(bottomTabList, this.mSession.getExtendSessionInfo().robotTheme);
            if (bottomTabList == null) {
                this.f10002x = false;
            } else {
                Iterator<IMSessionExtendInfo.BottomTabInfo> it = bottomTabList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    }
                    IMSessionExtendInfo.BottomTabInfo next = it.next();
                    if (next != null && next.f9129id == 4) {
                        break;
                    }
                }
                this.f10002x = z;
            }
            IMLog.m6631d(f9974j, "[onUpdateBottomTabInfo] mHideCommonWordBtnWithTabUI=" + this.f10002x);
            m6750c();
        }
    }

    public void onStatusChanged(IMSession iMSession) {
        if (iMSession != null && iMSession.getExtendSessionInfo() != null) {
            this.mSession = iMSession;
            if (!iMSession.getSessionEnable() || iMSession.getExtendSessionInfo().input == 0) {
                m6782t();
            }
            if (iMSession.getSessionEnable()) {
                m6742a(iMSession.getSessionEnable() && iMSession.getExtendSessionInfo().input != 0, iMSession.getExtendSessionInfo().na_txt);
                m6788z();
                return;
            }
            m6740a(iMSession.getExtendSessionInfo().naTxtInvalid);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo44029a() {
        if (this.mBusinessId == 259) {
            return this.mSession.getExtendSessionInfo().qk_key;
        }
        return this.mBusinessParam != null ? this.mBusinessParam.getSceneKey() : "";
    }

    public void resumeInitStatus() {
        getViewRoot().postDelayed(new Runnable() {
            public void run() {
                IMConversationBottomBar.this.f9992m.setText(IMResource.getString(R.string.im_bottombar_record));
                IMConversationBottomBar.this.f9992m.setTextColor(IMResource.getColor(R.color.im_color_333));
                IMConversationBottomBar.this.f9992m.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_bottom_bar_voice_text_bg_nor));
            }
        }, 200);
        this.mContentRootView.setBackgroundResource(IMResource.getDrawableID(R.drawable.im_bottom_bar_background_round));
        this.mSkinManager.showCommonSkin();
    }

    public void shrinkBottomBar() {
        boolean z = (this.mSession == null || this.mSession.getExtendSessionInfo() == null || this.mSession.getExtendSessionInfo().input != 0) ? false : true;
        EditText editText = this.f9990k;
        if (editText != null) {
            editText.clearFocus();
        }
        m6741a(z);
        m6780r();
    }

    public void shrinkBottomBarByRecycle() {
        if (this.mBusinessConfig.getIMStyle() != IMStyleManager.Style.GLOBAL_PSG) {
            super.shrinkBottomBarByRecycle();
        } else if (this.f9986f.isSoftInputShown()) {
            m6734a(1, false);
        } else if (!this.f9986f.isTagExpandShow("1")) {
            super.shrinkBottomBarByRecycle();
        }
    }

    public boolean onBackPressed() {
        IMBtmTabContainManager iMBtmTabContainManager;
        IMBtmRecorder iMBtmRecorder = this.f9977B;
        boolean z = true;
        if (iMBtmRecorder != null && iMBtmRecorder.interceptBackPressed()) {
            return true;
        }
        if (getEmotion() == null || !getEmotion().interceptBackPress()) {
            z = false;
        }
        if (z && (iMBtmTabContainManager = this.f9998t) != null) {
            iMBtmTabContainManager.reset();
        }
        return z;
    }

    public void onPause() {
        IMSession iMSession = this.mSession;
        EditText editText = this.f9990k;
        iMSession.setDraft(editText != null ? editText.getText().toString() : "");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6734a(int i, boolean z) {
        if (this.f9986f != null && this.f9989i != null) {
            boolean z2 = false;
            if (this.mSession.getExtendSessionInfo() == null || this.mSession.getExtendSessionInfo().input != 1) {
                if (this.f9986f.isTagExpandShow(String.valueOf(i))) {
                    shrinkBottomBar();
                } else {
                    if (i == 1) {
                        z2 = true;
                    }
                    m6735a(i, z2, z);
                }
                this.f9984d.showDisableSkin();
            } else if (this.mBusinessConfig.getIMStyle() != IMStyleManager.Style.GLOBAL_PSG) {
                if (i == 1) {
                    z2 = true;
                }
                m6735a(i, z2, z);
            } else if (this.f9986f.isTagExpandShow(String.valueOf(i))) {
                shrinkBottomBar();
            } else {
                m6735a(i, false, z);
            }
        }
    }

    /* renamed from: a */
    private void m6735a(int i, boolean z, boolean z2) {
        IMEmotionInputDetector iMEmotionInputDetector = this.f9986f;
        if (iMEmotionInputDetector != null && this.f9989i != null) {
            if (!iMEmotionInputDetector.isTagExpandShow(String.valueOf(i))) {
                if (i == 2) {
                    IMTraceUtil.addBusinessEvent("ddim_service_kkrobot_add_sw").add("order_id", m6729C()).add(m6730D()).report();
                }
                if (this.mBusinessConfig != null) {
                    this.mBusinessConfig.onBottomBarExpandViewShow(i, this.mSession, this.mBusinessParam);
                }
            }
            if (!z2) {
                m6777p();
            }
            this.f9986f.changeExpandView(String.valueOf(i), z);
            this.f9989i.showContainView(i, IMStreetUtils.enableStreetImage(this.mSession));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: B */
    public boolean m6728B() {
        IMActionItem iMActionItem = this.f10003y;
        return (iMActionItem == null || iMActionItem.item == null || !this.f10003y.item.moreInvokeAction()) ? false : true;
    }

    /* access modifiers changed from: private */
    /* renamed from: C */
    public String m6729C() {
        return IMParamUtil.getTraceOrderId(this.mBusinessParam, this.mSession);
    }

    /* access modifiers changed from: private */
    /* renamed from: D */
    public Map<String, String> m6730D() {
        return IMParamUtil.getTraceExtra(this.mBusinessParam, this.mActivityFrom);
    }
}
