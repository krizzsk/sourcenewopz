package com.didichuxing.diface.appeal.mexico.model;

import android.text.TextUtils;
import java.io.Serializable;

public class DocumentCardsBean implements Serializable {
    private String args;
    private String docDesc;
    private String docName;
    private String docPicDemo;
    private String requirement;
    private boolean useFrontCamera;
    private String wireframePicDemo;

    public String getDocDesc() {
        return this.docDesc;
    }

    public void setDocDesc(String str) {
        this.docDesc = str;
    }

    public String getDocName() {
        return this.docName;
    }

    public void setDocName(String str) {
        this.docName = str;
    }

    public String getDocPicDemo() {
        return this.docPicDemo;
    }

    public void setDocPicDemo(String str) {
        this.docPicDemo = str;
    }

    public void setArgs(String str) {
        this.args = str;
    }

    public String getArgs() {
        return this.args;
    }

    public String getRequirement() {
        return this.requirement;
    }

    public void setRequirement(String str) {
        this.requirement = str;
    }

    public String getWireframePicDemo() {
        return this.wireframePicDemo;
    }

    public void setWireframePicDemo(String str) {
        this.wireframePicDemo = str;
    }

    public boolean isUseFrontCamera() {
        return this.useFrontCamera;
    }

    public void setUseFrontCamera(boolean z) {
        this.useFrontCamera = z;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DocumentCardsBean)) {
            return false;
        }
        DocumentCardsBean documentCardsBean = (DocumentCardsBean) obj;
        if (!TextUtils.equals(this.args, documentCardsBean.args) || !TextUtils.equals(this.docDesc, documentCardsBean.docDesc) || !TextUtils.equals(this.docName, documentCardsBean.docName)) {
            return false;
        }
        return true;
    }
}
