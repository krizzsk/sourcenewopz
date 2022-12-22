package com.didi.soda.web.p168ui;

import android.content.Context;
import android.view.View;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.support.rui.Popup;
import com.didi.app.nova.skeleton.tools.Cancelable;
import com.taxis99.R;
import rui.widget.popup.type.menu.list.PopupMenuList;

/* renamed from: com.didi.soda.web.ui.WebMenuListPopup */
public class WebMenuListPopup implements Cancelable {

    /* renamed from: a */
    private Context f43937a;

    /* renamed from: b */
    private ScopeContext f43938b;

    /* renamed from: c */
    private Popup f43939c;

    /* renamed from: d */
    private PopupMenuList f43940d;

    /* renamed from: e */
    private boolean f43941e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public MenuListClickListener f43942f;

    /* renamed from: com.didi.soda.web.ui.WebMenuListPopup$MenuListClickListener */
    public interface MenuListClickListener {
        void onMenuCancel();

        void onStartAlbum();

        void onStartCamera();
    }

    public WebMenuListPopup(Context context, ScopeContext scopeContext) {
        this.f43937a = context;
        this.f43938b = scopeContext;
        this.f43939c = new Popup(context);
        PopupMenuList popupMenuList = new PopupMenuList();
        this.f43940d = popupMenuList;
        popupMenuList.hasCancel = true;
        this.f43940d.cancelText = this.f43937a.getResources().getString(R.string.cancel);
        this.f43940d.cancelClickListener = new View.OnClickListener() {
            public void onClick(View view) {
                if (WebMenuListPopup.this.f43942f != null) {
                    WebMenuListPopup.this.f43942f.onMenuCancel();
                }
            }
        };
        this.f43940d.addButton(this.f43937a.getResources().getString(R.string.soda_web_take_photo), new View.OnClickListener() {
            public void onClick(View view) {
                if (WebMenuListPopup.this.f43942f != null) {
                    WebMenuListPopup.this.f43942f.onStartCamera();
                }
            }
        });
        this.f43940d.addButton(this.f43937a.getResources().getString(R.string.soda_web_page_choice_from_pictures), new View.OnClickListener() {
            public void onClick(View view) {
                if (WebMenuListPopup.this.f43942f != null) {
                    WebMenuListPopup.this.f43942f.onStartAlbum();
                }
            }
        });
        this.f43939c.init(this.f43940d);
        this.f43939c.setCancelable(false);
        this.f43938b.getLiveHandler().bind(this);
    }

    public void setListener(MenuListClickListener menuListClickListener) {
        this.f43942f = menuListClickListener;
    }

    public void show() {
        ScopeContext scopeContext = this.f43938b;
        if (scopeContext != null && this.f43939c != null && !this.f43941e) {
            this.f43941e = true;
            scopeContext.getNavigator().showDialog(this.f43939c, "WebMenuListPopup");
        }
    }

    public void dismiss() {
        Popup popup = this.f43939c;
        if (popup != null) {
            this.f43941e = false;
            popup.dismiss();
        }
    }

    public void cancel() {
        dismiss();
        if (this.f43940d != null) {
            this.f43940d = null;
        }
    }
}
