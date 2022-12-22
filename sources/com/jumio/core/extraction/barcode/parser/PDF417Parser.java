package com.jumio.core.extraction.barcode.parser;

import com.jumio.core.data.country.Country;
import com.jumio.core.extraction.barcode.exception.PDF417ParserException;
import com.jumio.core.extraction.barcode.parser.col.COLParser;
import com.jumio.core.extraction.barcode.parser.uscan.USCANParser;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;

public abstract class PDF417Parser {
    public PDF417Data data;
    public SimpleDateFormat dateFormat;
    public String rawData;

    public static PDF417Parser getParser(Country country) {
        if ("USA".equals(country.getIsoCode()) || "CAN".equals(country.getIsoCode())) {
            return new USCANParser();
        }
        if ("COL".equals(country.getIsoCode())) {
            return new COLParser();
        }
        return null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:3|4|5) */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0013, code lost:
        return new com.jumio.core.extraction.barcode.parser.col.COLParser().parse(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0014, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x000a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.jumio.core.extraction.barcode.parser.PDF417Data multiParse(java.lang.String r1) {
        /*
            com.jumio.core.extraction.barcode.parser.uscan.USCANParser r0 = new com.jumio.core.extraction.barcode.parser.uscan.USCANParser     // Catch:{ PDF417ParserException -> 0x000a }
            r0.<init>()     // Catch:{ PDF417ParserException -> 0x000a }
            com.jumio.core.extraction.barcode.parser.PDF417Data r1 = r0.parse(r1)     // Catch:{ PDF417ParserException -> 0x000a }
            return r1
        L_0x000a:
            com.jumio.core.extraction.barcode.parser.col.COLParser r0 = new com.jumio.core.extraction.barcode.parser.col.COLParser     // Catch:{ PDF417ParserException -> 0x0014 }
            r0.<init>()     // Catch:{ PDF417ParserException -> 0x0014 }
            com.jumio.core.extraction.barcode.parser.PDF417Data r1 = r0.parse(r1)     // Catch:{ PDF417ParserException -> 0x0014 }
            return r1
        L_0x0014:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.extraction.barcode.parser.PDF417Parser.multiParse(java.lang.String):com.jumio.core.extraction.barcode.parser.PDF417Data");
    }

    public PDF417Data parse(String str) throws PDF417ParserException {
        if (str != null) {
            this.rawData = str;
            this.data = new PDF417Data();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("", Locale.ENGLISH);
            this.dateFormat = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            parse();
            return this.data;
        }
        throw new PDF417ParserException("Empty data");
    }

    public abstract void parse() throws PDF417ParserException;
}
