package com.didi.payment.transfer.fillamount;

import android.content.Context;
import java.io.Serializable;
import java.util.List;

public interface IConfirmTransferInfo extends Serializable {
    List<ValueType> getChildTypeValue();

    String getTypekey(Context context, ValueType valueType);

    String getValueByType(ValueType valueType);

    <T> void setTypeValue(ValueType valueType, T t);

    public enum ValueType {
        NAME("name"),
        HEAD_ICON("head_icon"),
        CPF("cpf"),
        BANK_NAME("bank_name"),
        BANK_CODE("bank_code"),
        BANK_CARD("bank_card"),
        AGENT_CODE("agency_code"),
        ACCOUNT_TYPE("account_type"),
        ACCOUNT_TYPE_VALUE("account_type_value"),
        To_TEL("toTel"),
        To_Show_Phone("toShowPhone"),
        To_CountryCode("to_country_code"),
        To_IconURL("to_icon_url"),
        Account_Exist("account_exist"),
        Account99_Exist("account99_exist"),
        Transfer_Amount("transfer_amount"),
        Transfer_Amount4Program("transfer_amount4program"),
        Transfer_Total_Amount("transfer_amount_total"),
        Transfer_ServiceFee("transfer_service_fee"),
        Transfer_MoneySymbal("money_symbal"),
        Transfer_Desc("transfer_desc");
        
        public String key;

        private ValueType(String str) {
            this.key = str;
        }

        public String getKey() {
            return this.key;
        }
    }
}
