package com.jumio.core.extraction.barcode;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import com.jumio.commons.camera.PreviewProperties;
import com.jumio.commons.log.Log;
import com.jumio.commons.log.LogUtils;
import com.jumio.core.extraction.ExtractionClient;
import com.jumio.core.extraction.ExtractionUpdateState;
import com.jumio.core.extraction.barcode.model.BarcodeDataModel;
import com.jumio.core.extraction.barcode.parser.PDF417Data;
import com.jumio.core.extraction.barcode.parser.PDF417Parser;
import com.jumio.core.model.StaticModel;
import com.jumio.core.models.IDScanPartModel;
import com.jumio.core.models.SelectionModel;
import com.jumio.core.persistence.DataManager;
import com.jumio.jvision.jvcorejava.swig.ImageSource;
import java.io.PrintWriter;
import java.io.StringWriter;

public abstract class BaseBarcodeClient extends ExtractionClient {

    /* renamed from: g */
    public SelectionModel f54727g;

    /* renamed from: h */
    public PDF417Parser f54728h;
    public ImageSource imageSource = null;

    public BaseBarcodeClient(Context context) {
        super(context);
    }

    public void configure(DataManager dataManager, StaticModel staticModel) {
        super.configure(dataManager, staticModel);
        if (staticModel instanceof IDScanPartModel) {
            this.f54727g = ((IDScanPartModel) staticModel).getSelectionModel();
            return;
        }
        throw new IllegalArgumentException("Configuration model should be an instance of ScanPartModel");
    }

    public void init(PreviewProperties previewProperties, Rect rect) {
        super.init(previewProperties, rect);
        this.f54728h = PDF417Parser.getParser(this.f54727g.getCountry());
    }

    public boolean onFinished(String str, Bitmap bitmap, int i, int i2) {
        String str2 = str;
        BarcodeDataModel barcodeDataModel = new BarcodeDataModel();
        String simpleName = getClass().getSimpleName();
        try {
            Log.LogLevel logLevel = Log.LogLevel.INFO;
            if (Log.isLogEnabledForLevel(logLevel)) {
                LogUtils.logInfoInSubfolder(str2, simpleName, "rawdata.text");
            }
            barcodeDataModel.setRawBarcodeData(str2);
            PDF417Data parse = this.f54728h.parse(str2);
            barcodeDataModel.setIdNumber(parse.getIdNumber());
            barcodeDataModel.setIssuingDate(parse.getIssueDate());
            barcodeDataModel.setExpiryDate(parse.getExpiryDate());
            String issuingCountry = parse.getIssuingCountry();
            if (issuingCountry == null || issuingCountry.length() == 0) {
                issuingCountry = this.f54727g.getCountry().getIsoCode();
            }
            barcodeDataModel.setIssuingCountry(issuingCountry);
            barcodeDataModel.setLastName(parse.getLastName());
            barcodeDataModel.setFirstNames(parse.getFirstName(), parse.getMiddleName());
            barcodeDataModel.setNameSuffix(parse.getNameSuffix());
            barcodeDataModel.setDob(parse.getDateOfBirth());
            barcodeDataModel.setGender(parse.getGender());
            barcodeDataModel.setAddressLine(parse.getAddressStreet1());
            barcodeDataModel.setCity(parse.getAddressCity());
            barcodeDataModel.setSubdivision(parse.getAddressState());
            barcodeDataModel.setPostCode(parse.getAddressZip());
            if (Log.isLogEnabledForLevel(logLevel)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Image dimensions:");
                sb.append("\r\n");
                sb.append("width: " + i);
                sb.append("height: " + i2);
                sb.append("\r\n");
                sb.append("\r\n");
                sb.append("Raw Data:");
                sb.append("\r\n");
                sb.append(str2.replaceAll(String.format("[^\\x20-\\x7E%s]+", new Object[]{""}), "<Binary Data>"));
                sb.append("\r\n");
                sb.append("\r\n");
                sb.append("Result:");
                sb.append("\r\n");
                LogUtils.appendParameter(sb, "getIdNumber() ", parse.getIdNumber());
                LogUtils.appendParameter(sb, "getIssueDate() ", parse.getIssueDate());
                LogUtils.appendParameter(sb, "getExpiryDate() ", parse.getExpiryDate());
                LogUtils.appendParameter(sb, "getIssuingCountry() ", parse.getIssuingCountry());
                LogUtils.appendParameter(sb, "getLastName() ", parse.getLastName());
                LogUtils.appendParameter(sb, "getFirstName() ", parse.getFirstName());
                LogUtils.appendParameter(sb, "getMiddleName() ", parse.getMiddleName());
                LogUtils.appendParameter(sb, "getNameSuffix() ", parse.getNameSuffix());
                LogUtils.appendParameter(sb, "getDateOfBirth() ", parse.getDateOfBirth());
                if (parse.getGender() != null) {
                    LogUtils.appendParameter(sb, "getGender() ", parse.getGender().name());
                }
                LogUtils.appendParameter(sb, "getAddressStreet1() ", parse.getAddressStreet1());
                LogUtils.appendParameter(sb, "getAddressCity() ", parse.getAddressCity());
                LogUtils.appendParameter(sb, "getAddressState() ", parse.getAddressState());
                LogUtils.appendParameter(sb, "getAddressZip() ", parse.getAddressZip());
                sb.append("\r\n");
                sb.append("\r\n");
                sb.append("Unused:");
                sb.append("\r\n");
                LogUtils.appendParameter(sb, "getAddressStreet2() ", parse.getAddressStreet2());
                LogUtils.appendParameter(sb, "getEndorsementCodes() ", parse.getEndorsementCodes());
                if (parse.getEyeColor() != null) {
                    LogUtils.appendParameter(sb, "getEyeColor() ", parse.getEyeColor().name());
                }
                LogUtils.appendParameter(sb, "getHeight() ", parse.getHeight());
                LogUtils.appendParameter(sb, "getRestrictionCodes() ", parse.getRestrictionCodes());
                LogUtils.appendParameter(sb, "getVehicleClass() ", parse.getVehicleClass());
                sb.append("\r\n");
                sb.append("\r\n");
                sb.append("Unparsed:");
                sb.append("\r\n");
                sb.append(parse.getUnparsedData().toString().replaceAll(String.format("[^\\x20-\\x7E%s]+", new Object[]{""}), "<Binary Data>"));
                LogUtils.logInfoInSubfolder(sb.toString(), simpleName, (String) null);
            }
            System.gc();
            publishUpdate(new ExtractionClient.ExtractionUpdate(ExtractionUpdateState.shotTaken, null));
            publishUpdate(new ExtractionClient.ExtractionUpdate(ExtractionUpdateState.saveImage, bitmap));
            publishResult(barcodeDataModel);
            return true;
        } catch (Exception e) {
            if (Log.isLogEnabledForLevel(Log.LogLevel.INFO)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Raw Data:");
                sb2.append("\r\n");
                sb2.append(str2);
                sb2.append("\r\n");
                sb2.append("\r\n");
                sb2.append("Result:");
                sb2.append("\r\n");
                StringWriter stringWriter = new StringWriter();
                e.printStackTrace(new PrintWriter(stringWriter));
                sb2.append(stringWriter.toString());
                LogUtils.logInfoInSubfolder(sb2.toString(), simpleName, (String) null);
            }
            return false;
        }
    }
}
