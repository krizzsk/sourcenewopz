package com.didi.unifylogin.base.net.pojo.request;

import android.content.Context;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class SetCellParam extends BaseParam implements Serializable {
    private String cell;
    @SerializedName("src_cell_changeable")
    private boolean checkChangeable;
    @SerializedName("dst_cell_snatchable")
    private boolean checkSnatchable;
    private String code;
    @SerializedName("code_type")
    private int codeType;
    @SerializedName("new_cell")
    private String newCell;
    @SerializedName("new_cell_country_calling_code")
    private String newCellCountryCallingCode;
    @SerializedName("new_code")
    private String newCode;
    @SerializedName("new_code_type")
    private int newCodeType;
    private String ticket;

    public SetCellParam(Context context, int i) {
        super(context, i);
    }

    public SetCellParam setCell(String str) {
        this.cell = str;
        return this;
    }

    public SetCellParam setNewCell(String str) {
        this.newCell = str;
        return this;
    }

    public SetCellParam setTicket(String str) {
        this.ticket = str;
        return this;
    }

    public SetCellParam setCode(String str) {
        this.code = str;
        return this;
    }

    public SetCellParam setNewCode(String str) {
        this.newCode = str;
        return this;
    }

    public SetCellParam setCodeType(int i) {
        this.codeType = i;
        return this;
    }

    public SetCellParam setNewCodeType(int i) {
        this.newCodeType = i;
        return this;
    }

    public SetCellParam setCheckChangeable(boolean z) {
        this.checkChangeable = z;
        return this;
    }

    public SetCellParam setCheckSnatchable(boolean z) {
        this.checkSnatchable = z;
        return this;
    }

    public boolean isCheckChangeable() {
        return this.checkChangeable;
    }

    public boolean isCheckSnatchable() {
        return this.checkSnatchable;
    }

    public String getCell() {
        return this.cell;
    }

    public String getNewCell() {
        return this.newCell;
    }

    public String getCode() {
        return this.code;
    }

    public String getNewCode() {
        return this.newCode;
    }

    public String getNewCellCountryCallingCode() {
        return this.newCellCountryCallingCode;
    }

    public SetCellParam setNewCellCountryCallingCode(String str) {
        this.newCellCountryCallingCode = str;
        return this;
    }
}
