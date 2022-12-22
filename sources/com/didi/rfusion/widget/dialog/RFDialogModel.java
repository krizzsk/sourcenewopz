package com.didi.rfusion.widget.dialog;

import com.didi.rfusion.widget.dialog.RFDialog;
import com.didi.rfusion.widget.dialog.RFDialogInterface;

public class RFDialogModel {

    /* renamed from: a */
    private String f33512a;

    /* renamed from: b */
    private int f33513b;

    /* renamed from: c */
    private String f33514c;

    /* renamed from: d */
    private RFDialog.ActionModel f33515d;

    /* renamed from: e */
    private RFDialog.ActionModel f33516e;

    /* renamed from: f */
    private RFDialog.ActionModel f33517f;

    /* renamed from: g */
    private RFDialogInterface.OnDismissListener f33518g;

    /* renamed from: h */
    private boolean f33519h;

    /* renamed from: i */
    private boolean f33520i;

    /* renamed from: j */
    private RFDialog.CloseModel f33521j;

    /* renamed from: k */
    private boolean f33522k = true;

    public String getTitle() {
        return this.f33512a;
    }

    public void setTitle(String str) {
        this.f33512a = str;
    }

    public int getBannerRes() {
        return this.f33513b;
    }

    public void setBannerRes(int i) {
        this.f33513b = i;
        this.f33514c = null;
    }

    public String getBannerUrl() {
        return this.f33514c;
    }

    public void setBannerUrl(String str) {
        this.f33514c = str;
        this.f33513b = 0;
    }

    public RFDialog.ActionModel getMainAction() {
        return this.f33515d;
    }

    public void setMainAction(RFDialog.ActionModel actionModel) {
        this.f33515d = actionModel;
    }

    public RFDialog.ActionModel getSubAction1() {
        return this.f33516e;
    }

    public void setSubAction1(RFDialog.ActionModel actionModel) {
        this.f33516e = actionModel;
    }

    public RFDialog.ActionModel getSubAction2() {
        return this.f33517f;
    }

    public void setSubAction2(RFDialog.ActionModel actionModel) {
        this.f33517f = actionModel;
    }

    public RFDialogInterface.OnDismissListener getOnDismissListener() {
        return this.f33518g;
    }

    public void setOnDismissListener(RFDialogInterface.OnDismissListener onDismissListener) {
        this.f33518g = onDismissListener;
    }

    public void setCancelable(boolean z) {
        this.f33519h = z;
    }

    public boolean isCancelable() {
        return this.f33519h;
    }

    public void setCloseable(boolean z) {
        setCloseable(new RFDialog.CloseModel(z, (RFDialogInterface.OnClickListener) null));
    }

    public void setCloseable(RFDialog.CloseModel closeModel) {
        this.f33520i = closeModel.isCloseable;
        this.f33521j = closeModel;
    }

    public boolean isCloseable() {
        return this.f33520i;
    }

    public RFDialog.CloseModel getCloseModel() {
        return this.f33521j;
    }

    public void setAutoDismiss(boolean z) {
        this.f33522k = z;
    }

    public boolean isAutoDismiss() {
        return this.f33522k;
    }

    public void apply(RFDialogModel rFDialogModel) {
        this.f33512a = rFDialogModel.f33512a;
        this.f33513b = rFDialogModel.f33513b;
        this.f33514c = rFDialogModel.f33514c;
        this.f33515d = rFDialogModel.f33515d;
        this.f33516e = rFDialogModel.f33516e;
        this.f33517f = rFDialogModel.f33517f;
        this.f33518g = rFDialogModel.f33518g;
        this.f33519h = rFDialogModel.f33519h;
        this.f33520i = rFDialogModel.f33520i;
        this.f33521j = rFDialogModel.f33521j;
    }
}
