package com.jumio.core.extraction.barcode.parser.col;

import android.util.SparseArray;

public class LocationLookup {

    /* renamed from: a */
    public static final SparseArray<String> f54754a;

    /* renamed from: b */
    public static final SparseArray<String> f54755b;

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: android.util.SparseArray<java.lang.String>} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            android.util.SparseArray r0 = new android.util.SparseArray
            r0.<init>()
            f54754a = r0
            android.util.SparseArray r1 = new android.util.SparseArray
            r1.<init>()
            f54755b = r1
            r2 = 1
            java.lang.String r3 = "ANTIOQUIA"
            r0.put(r2, r3)
            r2 = 3
            java.lang.String r4 = "ATLANTICO"
            r0.put(r2, r4)
            r2 = 5
            java.lang.String r4 = "BOLIVAR"
            r0.put(r2, r4)
            r2 = 7
            java.lang.String r5 = "BOYACA"
            r0.put(r2, r5)
            r2 = 9
            java.lang.String r6 = "CALDAS"
            r0.put(r2, r6)
            r2 = 11
            java.lang.String r7 = "CAUCA"
            r0.put(r2, r7)
            r2 = 12
            java.lang.String r7 = "CESAR"
            r0.put(r2, r7)
            r2 = 13
            java.lang.String r7 = "CORDOBA"
            r0.put(r2, r7)
            r2 = 15
            java.lang.String r8 = "CUNDINAMARCA"
            r0.put(r2, r8)
            r2 = 16
            java.lang.String r8 = "BOGOTA D.C."
            r0.put(r2, r8)
            r2 = 17
            java.lang.String r9 = "CHOCO"
            r0.put(r2, r9)
            r2 = 19
            java.lang.String r9 = "HUILA"
            r0.put(r2, r9)
            r2 = 21
            java.lang.String r9 = "MAGDALENA"
            r0.put(r2, r9)
            r2 = 23
            java.lang.String r9 = "NARIÑO"
            r0.put(r2, r9)
            r2 = 24
            java.lang.String r9 = "RISARALDA"
            r0.put(r2, r9)
            r2 = 25
            java.lang.String r9 = "NORTE DE SAN"
            r0.put(r2, r9)
            r2 = 26
            java.lang.String r9 = "QUINDIO"
            r0.put(r2, r9)
            r2 = 27
            java.lang.String r9 = "SANTANDER"
            r0.put(r2, r9)
            r2 = 28
            java.lang.String r9 = "SUCRE"
            r0.put(r2, r9)
            r2 = 29
            java.lang.String r10 = "TOLIMA"
            r0.put(r2, r10)
            r2 = 31
            java.lang.String r10 = "VALLE"
            r0.put(r2, r10)
            r2 = 40
            java.lang.String r10 = "ARAUCA"
            r0.put(r2, r10)
            r2 = 44
            java.lang.String r10 = "CAQUETA"
            r0.put(r2, r10)
            r2 = 46
            java.lang.String r10 = "CASANARE"
            r0.put(r2, r10)
            r2 = 48
            java.lang.String r10 = "LA GUAJIRA"
            r0.put(r2, r10)
            r2 = 50
            java.lang.String r10 = "GUAINIA"
            r0.put(r2, r10)
            r2 = 52
            java.lang.String r10 = "META"
            r0.put(r2, r10)
            r2 = 54
            java.lang.String r10 = "GUAVIARE"
            r0.put(r2, r10)
            r2 = 56
            java.lang.String r10 = "SAN ANDRES"
            r0.put(r2, r10)
            r2 = 60
            java.lang.String r11 = "AMAZONAS"
            r0.put(r2, r11)
            r2 = 64
            java.lang.String r11 = "PUTUMAYO"
            r0.put(r2, r11)
            r2 = 68
            java.lang.String r11 = "VAUPES"
            r0.put(r2, r11)
            r2 = 72
            java.lang.String r11 = "VICHADA"
            r0.put(r2, r11)
            r2 = 81
            java.lang.String r11 = "VENEZUELA"
            r0.put(r2, r11)
            r0 = 1001(0x3e9, float:1.403E-42)
            java.lang.String r2 = "MEDELLIN"
            r1.put(r0, r2)
            r0 = 1004(0x3ec, float:1.407E-42)
            java.lang.String r2 = "ABEJORRAL"
            r1.put(r0, r2)
            r0 = 1007(0x3ef, float:1.411E-42)
            java.lang.String r2 = "ABRIAQUI"
            r1.put(r0, r2)
            r0 = 1010(0x3f2, float:1.415E-42)
            java.lang.String r2 = "ALEJANDRIA"
            r1.put(r0, r2)
            r0 = 1013(0x3f5, float:1.42E-42)
            java.lang.String r2 = "AMAGA"
            r1.put(r0, r2)
            r0 = 1016(0x3f8, float:1.424E-42)
            java.lang.String r2 = "AMALFI"
            r1.put(r0, r2)
            r0 = 1019(0x3fb, float:1.428E-42)
            java.lang.String r2 = "ANDES"
            r1.put(r0, r2)
            r0 = 1022(0x3fe, float:1.432E-42)
            java.lang.String r2 = "ANGELOPOLIS"
            r1.put(r0, r2)
            r0 = 1025(0x401, float:1.436E-42)
            java.lang.String r2 = "ANGOSTURA"
            r1.put(r0, r2)
            r0 = 1028(0x404, float:1.44E-42)
            java.lang.String r2 = "ANORI"
            r1.put(r0, r2)
            r0 = 1031(0x407, float:1.445E-42)
            r1.put(r0, r3)
            r0 = 1034(0x40a, float:1.449E-42)
            java.lang.String r2 = "ANZA"
            r1.put(r0, r2)
            r0 = 1035(0x40b, float:1.45E-42)
            java.lang.String r2 = "APARTADO"
            r1.put(r0, r2)
            r0 = 1037(0x40d, float:1.453E-42)
            java.lang.String r2 = "ARBOLETES"
            r1.put(r0, r2)
            r0 = 1039(0x40f, float:1.456E-42)
            java.lang.String r2 = "ARGELIA"
            r1.put(r0, r2)
            r0 = 1040(0x410, float:1.457E-42)
            java.lang.String r3 = "ARMENIA"
            r1.put(r0, r3)
            r0 = 1043(0x413, float:1.462E-42)
            java.lang.String r3 = "BARBOSA"
            r1.put(r0, r3)
            r0 = 1046(0x416, float:1.466E-42)
            java.lang.String r3 = "BELMIRA"
            r1.put(r0, r3)
            r0 = 1049(0x419, float:1.47E-42)
            java.lang.String r3 = "BELLO"
            r1.put(r0, r3)
            r0 = 1052(0x41c, float:1.474E-42)
            java.lang.String r3 = "BETANIA"
            r1.put(r0, r3)
            r0 = 1055(0x41f, float:1.478E-42)
            java.lang.String r3 = "BETULIA"
            r1.put(r0, r3)
            r0 = 1058(0x422, float:1.483E-42)
            r1.put(r0, r4)
            r0 = 1061(0x425, float:1.487E-42)
            java.lang.String r3 = "BURITICA"
            r1.put(r0, r3)
            r0 = 1062(0x426, float:1.488E-42)
            java.lang.String r3 = "BRICE/O"
            r1.put(r0, r3)
            r0 = 1064(0x428, float:1.491E-42)
            java.lang.String r3 = "CACERES"
            r1.put(r0, r3)
            r0 = 1067(0x42b, float:1.495E-42)
            java.lang.String r3 = "CAICEDO"
            r1.put(r0, r3)
            r0 = 1070(0x42e, float:1.5E-42)
            r1.put(r0, r6)
            r0 = 1073(0x431, float:1.504E-42)
            java.lang.String r3 = "CAMPAMENTO"
            r1.put(r0, r3)
            r0 = 1076(0x434, float:1.508E-42)
            java.lang.String r3 = "CA/ASGORDAS"
            r1.put(r0, r3)
            r0 = 1078(0x436, float:1.51E-42)
            java.lang.String r3 = "CARACOLI"
            r1.put(r0, r3)
            r0 = 1079(0x437, float:1.512E-42)
            java.lang.String r3 = "CARAMANTA"
            r1.put(r0, r3)
            r0 = 1080(0x438, float:1.513E-42)
            java.lang.String r3 = "CAREPA"
            r1.put(r0, r3)
            r0 = 1082(0x43a, float:1.516E-42)
            java.lang.String r3 = "CARMEN DE VIBORAL"
            r1.put(r0, r3)
            r0 = 1085(0x43d, float:1.52E-42)
            java.lang.String r3 = "CAROLINA"
            r1.put(r0, r3)
            r0 = 1088(0x440, float:1.525E-42)
            java.lang.String r3 = "CAUCASIA"
            r1.put(r0, r3)
            r0 = 1091(0x443, float:1.529E-42)
            java.lang.String r3 = "CISNEROS"
            r1.put(r0, r3)
            r0 = 1094(0x446, float:1.533E-42)
            java.lang.String r3 = "COCORNA"
            r1.put(r0, r3)
            r0 = 1097(0x449, float:1.537E-42)
            java.lang.String r3 = "CONCEPCION"
            r1.put(r0, r3)
            r0 = 1100(0x44c, float:1.541E-42)
            java.lang.String r3 = "CONCORDIA"
            r1.put(r0, r3)
            r0 = 1103(0x44f, float:1.546E-42)
            java.lang.String r3 = "COPACABANA"
            r1.put(r0, r3)
            r0 = 1106(0x452, float:1.55E-42)
            java.lang.String r3 = "CHIGORODO"
            r1.put(r0, r3)
            r0 = 1109(0x455, float:1.554E-42)
            java.lang.String r3 = "DABEIBA"
            r1.put(r0, r3)
            r0 = 1112(0x458, float:1.558E-42)
            java.lang.String r3 = "DON MATIAS"
            r1.put(r0, r3)
            r0 = 1115(0x45b, float:1.562E-42)
            java.lang.String r3 = "EBEJICO"
            r1.put(r0, r3)
            r0 = 1117(0x45d, float:1.565E-42)
            java.lang.String r3 = "EL BAGRE"
            r1.put(r0, r3)
            r0 = 1118(0x45e, float:1.567E-42)
            java.lang.String r3 = "ENTRERRIOS"
            r1.put(r0, r3)
            r0 = 1121(0x461, float:1.571E-42)
            java.lang.String r3 = "ENVIGADO"
            r1.put(r0, r3)
            r0 = 1124(0x464, float:1.575E-42)
            java.lang.String r3 = "FREDONIA"
            r1.put(r0, r3)
            r0 = 1127(0x467, float:1.579E-42)
            java.lang.String r3 = "FRONTINO"
            r1.put(r0, r3)
            r0 = 1130(0x46a, float:1.583E-42)
            java.lang.String r3 = "GIRALDO"
            r1.put(r0, r3)
            r0 = 1133(0x46d, float:1.588E-42)
            java.lang.String r3 = "GIRARDOTA"
            r1.put(r0, r3)
            r0 = 1136(0x470, float:1.592E-42)
            java.lang.String r3 = "GOMEZ PLATA"
            r1.put(r0, r3)
            r0 = 1139(0x473, float:1.596E-42)
            java.lang.String r3 = "GRANADA"
            r1.put(r0, r3)
            r0 = 1140(0x474, float:1.597E-42)
            java.lang.String r11 = "GUADALUPE"
            r1.put(r0, r11)
            r0 = 1142(0x476, float:1.6E-42)
            java.lang.String r12 = "GUARNE"
            r1.put(r0, r12)
            r0 = 1145(0x479, float:1.604E-42)
            java.lang.String r12 = "GUATAPE"
            r1.put(r0, r12)
            r0 = 1148(0x47c, float:1.609E-42)
            java.lang.String r12 = "HELICONIA"
            r1.put(r0, r12)
            r0 = 1150(0x47e, float:1.611E-42)
            java.lang.String r12 = "HISPANIA"
            r1.put(r0, r12)
            r0 = 1151(0x47f, float:1.613E-42)
            java.lang.String r12 = "ITAGUI"
            r1.put(r0, r12)
            r0 = 1154(0x482, float:1.617E-42)
            java.lang.String r12 = "ITUANGO"
            r1.put(r0, r12)
            r0 = 1157(0x485, float:1.621E-42)
            java.lang.String r12 = "JARDIN"
            r1.put(r0, r12)
            r0 = 1160(0x488, float:1.626E-42)
            java.lang.String r12 = "JERICO"
            r1.put(r0, r12)
            r0 = 1163(0x48b, float:1.63E-42)
            java.lang.String r12 = "LA CEJA"
            r1.put(r0, r12)
            r0 = 1166(0x48e, float:1.634E-42)
            java.lang.String r12 = "LA ESTRELLA"
            r1.put(r0, r12)
            r0 = 1168(0x490, float:1.637E-42)
            java.lang.String r12 = "PUERTO NARE-LA MAGDALENA"
            r1.put(r0, r12)
            r0 = 1169(0x491, float:1.638E-42)
            java.lang.String r12 = "LA UNION"
            r1.put(r0, r12)
            r0 = 1170(0x492, float:1.64E-42)
            java.lang.String r13 = "LA PINTADA"
            r1.put(r0, r13)
            r0 = 1172(0x494, float:1.642E-42)
            java.lang.String r13 = "LIBORINA"
            r1.put(r0, r13)
            r0 = 1175(0x497, float:1.647E-42)
            java.lang.String r13 = "MACEO"
            r1.put(r0, r13)
            r0 = 1178(0x49a, float:1.651E-42)
            java.lang.String r13 = "MARINILLA"
            r1.put(r0, r13)
            r0 = 1181(0x49d, float:1.655E-42)
            java.lang.String r13 = "MONTEBELLO"
            r1.put(r0, r13)
            r0 = 1184(0x4a0, float:1.659E-42)
            java.lang.String r13 = "MURINDO"
            r1.put(r0, r13)
            r0 = 1187(0x4a3, float:1.663E-42)
            java.lang.String r13 = "MUTATA"
            r1.put(r0, r13)
            r0 = 1190(0x4a6, float:1.668E-42)
            java.lang.String r13 = "NARI/O"
            r1.put(r0, r13)
            r0 = 1191(0x4a7, float:1.669E-42)
            java.lang.String r14 = "NECHI"
            r1.put(r0, r14)
            r0 = 1192(0x4a8, float:1.67E-42)
            java.lang.String r14 = "NECOCLI"
            r1.put(r0, r14)
            r0 = 1193(0x4a9, float:1.672E-42)
            java.lang.String r14 = "OLAYA"
            r1.put(r0, r14)
            r0 = 1196(0x4ac, float:1.676E-42)
            java.lang.String r14 = "PE/OL"
            r1.put(r0, r14)
            r0 = 1199(0x4af, float:1.68E-42)
            java.lang.String r14 = "PEQUE"
            r1.put(r0, r14)
            r0 = 1202(0x4b2, float:1.684E-42)
            java.lang.String r14 = "PUEBLORRICO"
            r1.put(r0, r14)
            r0 = 1205(0x4b5, float:1.689E-42)
            java.lang.String r14 = "PUERTO BERRIO"
            r1.put(r0, r14)
            r0 = 1206(0x4b6, float:1.69E-42)
            java.lang.String r14 = "PUERTO TRIUNFO"
            r1.put(r0, r14)
            r0 = 1208(0x4b8, float:1.693E-42)
            java.lang.String r14 = "REMEDIOS"
            r1.put(r0, r14)
            r0 = 1211(0x4bb, float:1.697E-42)
            java.lang.String r14 = "RETIRO"
            r1.put(r0, r14)
            r0 = 1214(0x4be, float:1.701E-42)
            java.lang.String r14 = "RIONEGRO"
            r1.put(r0, r14)
            r0 = 1217(0x4c1, float:1.705E-42)
            java.lang.String r14 = "SABANALARGA"
            r1.put(r0, r14)
            r0 = 1218(0x4c2, float:1.707E-42)
            java.lang.String r15 = "SABANETA"
            r1.put(r0, r15)
            r0 = 1220(0x4c4, float:1.71E-42)
            java.lang.String r15 = "SALGAR"
            r1.put(r0, r15)
            r0 = 1223(0x4c7, float:1.714E-42)
            r1.put(r0, r10)
            r0 = 1226(0x4ca, float:1.718E-42)
            java.lang.String r15 = "SAN CARLOS"
            r1.put(r0, r15)
            r0 = 1227(0x4cb, float:1.72E-42)
            java.lang.String r15 = "SAN FRANCISCO"
            r1.put(r0, r15)
            r0 = 1229(0x4cd, float:1.722E-42)
            r16 = r10
            java.lang.String r10 = "SAN JERONIMO"
            r1.put(r0, r10)
            r0 = 1230(0x4ce, float:1.724E-42)
            java.lang.String r10 = "SAN JOSE DE LA MONTA/A"
            r1.put(r0, r10)
            r0 = 1231(0x4cf, float:1.725E-42)
            java.lang.String r10 = "SAN JUAN DE URABA"
            r1.put(r0, r10)
            r0 = 1232(0x4d0, float:1.726E-42)
            java.lang.String r10 = "SAN LUIS"
            r1.put(r0, r10)
            r0 = 1235(0x4d3, float:1.73E-42)
            java.lang.String r10 = "SAN PEDRO"
            r1.put(r0, r10)
            r0 = 1237(0x4d5, float:1.733E-42)
            r17 = r10
            java.lang.String r10 = "SAN PEDRO DE URABA"
            r1.put(r0, r10)
            r0 = 1238(0x4d6, float:1.735E-42)
            java.lang.String r10 = "SAN RAFAEL"
            r1.put(r0, r10)
            r0 = 1241(0x4d9, float:1.739E-42)
            java.lang.String r10 = "SAN ROQUE"
            r1.put(r0, r10)
            r0 = 1244(0x4dc, float:1.743E-42)
            java.lang.String r10 = "SAN VICENTE"
            r1.put(r0, r10)
            r0 = 1247(0x4df, float:1.747E-42)
            java.lang.String r10 = "SANTA BARBARA"
            r1.put(r0, r10)
            r0 = 1250(0x4e2, float:1.752E-42)
            java.lang.String r10 = "SANTA ROSA DE OSOS"
            r1.put(r0, r10)
            r0 = 1253(0x4e5, float:1.756E-42)
            java.lang.String r10 = "SANTO DOMINGO"
            r1.put(r0, r10)
            r0 = 1256(0x4e8, float:1.76E-42)
            java.lang.String r10 = "SANTUARIO"
            r1.put(r0, r10)
            r0 = 1259(0x4eb, float:1.764E-42)
            java.lang.String r10 = "SEGOVIA"
            r1.put(r0, r10)
            r0 = 1262(0x4ee, float:1.768E-42)
            java.lang.String r10 = "SONSON"
            r1.put(r0, r10)
            r0 = 1265(0x4f1, float:1.773E-42)
            java.lang.String r10 = "SOPETRAN"
            r1.put(r0, r10)
            r0 = 1268(0x4f4, float:1.777E-42)
            java.lang.String r10 = "TAMESIS"
            r1.put(r0, r10)
            r0 = 1270(0x4f6, float:1.78E-42)
            java.lang.String r10 = "TARAZA"
            r1.put(r0, r10)
            r0 = 1271(0x4f7, float:1.781E-42)
            java.lang.String r10 = "TARSO"
            r1.put(r0, r10)
            r0 = 1274(0x4fa, float:1.785E-42)
            java.lang.String r10 = "TITIRIBI"
            r1.put(r0, r10)
            r0 = 1277(0x4fd, float:1.79E-42)
            java.lang.String r10 = "TOLEDO"
            r1.put(r0, r10)
            r0 = 1280(0x500, float:1.794E-42)
            java.lang.String r10 = "TURBO"
            r1.put(r0, r10)
            r0 = 1282(0x502, float:1.796E-42)
            java.lang.String r10 = "URAMITA"
            r1.put(r0, r10)
            r0 = 1283(0x503, float:1.798E-42)
            java.lang.String r10 = "URRAO"
            r1.put(r0, r10)
            r0 = 1286(0x506, float:1.802E-42)
            java.lang.String r10 = "VALDIVIA"
            r1.put(r0, r10)
            r0 = 1289(0x509, float:1.806E-42)
            java.lang.String r10 = "VALPARAISO"
            r1.put(r0, r10)
            r0 = 1290(0x50a, float:1.808E-42)
            java.lang.String r10 = "VEGACHI"
            r1.put(r0, r10)
            r0 = 1291(0x50b, float:1.809E-42)
            java.lang.String r10 = "VIGIA DEL FUERTE"
            r1.put(r0, r10)
            r0 = 1292(0x50c, float:1.81E-42)
            java.lang.String r10 = "VENECIA"
            r1.put(r0, r10)
            r0 = 1293(0x50d, float:1.812E-42)
            java.lang.String r10 = "YALI"
            r1.put(r0, r10)
            r0 = 1295(0x50f, float:1.815E-42)
            java.lang.String r10 = "YARUMAL"
            r1.put(r0, r10)
            r0 = 1298(0x512, float:1.819E-42)
            java.lang.String r10 = "YOLOMBO"
            r1.put(r0, r10)
            r0 = 1300(0x514, float:1.822E-42)
            java.lang.String r10 = "YONDO-CASABE"
            r1.put(r0, r10)
            r0 = 1301(0x515, float:1.823E-42)
            java.lang.String r10 = "ZARAGOZA"
            r1.put(r0, r10)
            r0 = 3001(0xbb9, float:4.205E-42)
            java.lang.String r10 = "BARRANQUILLA"
            r1.put(r0, r10)
            r0 = 3004(0xbbc, float:4.21E-42)
            java.lang.String r10 = "BARANOA"
            r1.put(r0, r10)
            r0 = 3007(0xbbf, float:4.214E-42)
            java.lang.String r10 = "CAMPO DE LA CRUZ"
            r1.put(r0, r10)
            r0 = 3010(0xbc2, float:4.218E-42)
            java.lang.String r10 = "CANDELARIA"
            r1.put(r0, r10)
            r0 = 3013(0xbc5, float:4.222E-42)
            java.lang.String r10 = "GALAPA"
            r1.put(r0, r10)
            r0 = 3016(0xbc8, float:4.226E-42)
            java.lang.String r10 = "JUAN DE ACOSTA"
            r1.put(r0, r10)
            r0 = 3019(0xbcb, float:4.23E-42)
            java.lang.String r10 = "LURUACO"
            r1.put(r0, r10)
            r0 = 3022(0xbce, float:4.235E-42)
            java.lang.String r10 = "MALAMBO"
            r1.put(r0, r10)
            r0 = 3025(0xbd1, float:4.239E-42)
            java.lang.String r10 = "MANATI"
            r1.put(r0, r10)
            r0 = 3028(0xbd4, float:4.243E-42)
            java.lang.String r10 = "PALMAR DE VARELA"
            r1.put(r0, r10)
            r0 = 3031(0xbd7, float:4.247E-42)
            java.lang.String r10 = "PIOJO"
            r1.put(r0, r10)
            r0 = 3034(0xbda, float:4.252E-42)
            java.lang.String r10 = "POLONUEVO"
            r1.put(r0, r10)
            r0 = 3035(0xbdb, float:4.253E-42)
            java.lang.String r10 = "PONEDERA"
            r1.put(r0, r10)
            r0 = 3037(0xbdd, float:4.256E-42)
            java.lang.String r10 = "PUERTO COLOMBIA"
            r1.put(r0, r10)
            r0 = 3040(0xbe0, float:4.26E-42)
            java.lang.String r10 = "REPELON"
            r1.put(r0, r10)
            r0 = 3043(0xbe3, float:4.264E-42)
            java.lang.String r10 = "SABANAGRANDE"
            r1.put(r0, r10)
            r0 = 3046(0xbe6, float:4.268E-42)
            r1.put(r0, r14)
            r0 = 3047(0xbe7, float:4.27E-42)
            java.lang.String r10 = "SANTA LUCIA"
            r1.put(r0, r10)
            r0 = 3049(0xbe9, float:4.273E-42)
            java.lang.String r10 = "SANTO TOMAS"
            r1.put(r0, r10)
            r0 = 3052(0xbec, float:4.277E-42)
            java.lang.String r10 = "SOLEDAD"
            r1.put(r0, r10)
            r0 = 3055(0xbef, float:4.281E-42)
            java.lang.String r10 = "SUAN"
            r1.put(r0, r10)
            r0 = 3058(0xbf2, float:4.285E-42)
            java.lang.String r10 = "TUBARA"
            r1.put(r0, r10)
            r0 = 3061(0xbf5, float:4.29E-42)
            java.lang.String r10 = "USIACURI"
            r1.put(r0, r10)
            r0 = 5001(0x1389, float:7.008E-42)
            java.lang.String r10 = "CARTAGENA"
            r1.put(r0, r10)
            r0 = 5004(0x138c, float:7.012E-42)
            java.lang.String r10 = "ACHI"
            r1.put(r0, r10)
            r0 = 5005(0x138d, float:7.013E-42)
            java.lang.String r10 = "ARENAL"
            r1.put(r0, r10)
            r0 = 5006(0x138e, float:7.015E-42)
            java.lang.String r10 = "ALTOS DEL ROSARIO"
            r1.put(r0, r10)
            r0 = 5007(0x138f, float:7.016E-42)
            java.lang.String r10 = "ARJONA"
            r1.put(r0, r10)
            r0 = 5009(0x1391, float:7.019E-42)
            java.lang.String r10 = "ARROYO HONDO"
            r1.put(r0, r10)
            r0 = 5010(0x1392, float:7.02E-42)
            java.lang.String r10 = "BARRANCO DE LOBA"
            r1.put(r0, r10)
            r0 = 5013(0x1395, float:7.025E-42)
            java.lang.String r10 = "CALAMAR"
            r1.put(r0, r10)
            r0 = 5014(0x1396, float:7.026E-42)
            java.lang.String r10 = "CANTAGALLO"
            r1.put(r0, r10)
            r0 = 5015(0x1397, float:7.028E-42)
            java.lang.String r10 = "CICUCO"
            r1.put(r0, r10)
            r0 = 5016(0x1398, float:7.029E-42)
            r1.put(r0, r7)
            r0 = 5018(0x139a, float:7.032E-42)
            java.lang.String r10 = "CLEMENCIA"
            r1.put(r0, r10)
            r0 = 5022(0x139e, float:7.037E-42)
            java.lang.String r10 = "EL CARMEN DE BOLIVAR"
            r1.put(r0, r10)
            r0 = 5025(0x13a1, float:7.042E-42)
            java.lang.String r10 = "EL GUAMO"
            r1.put(r0, r10)
            r0 = 5026(0x13a2, float:7.043E-42)
            java.lang.String r10 = "HATILLO DE LOBA"
            r1.put(r0, r10)
            r0 = 5027(0x13a3, float:7.044E-42)
            java.lang.String r10 = "EL PE/ON"
            r1.put(r0, r10)
            r0 = 5028(0x13a4, float:7.046E-42)
            r18 = r14
            java.lang.String r14 = "MAGANGUE"
            r1.put(r0, r14)
            r0 = 5031(0x13a7, float:7.05E-42)
            java.lang.String r14 = "MAHATES"
            r1.put(r0, r14)
            r0 = 5037(0x13ad, float:7.058E-42)
            java.lang.String r14 = "MARGARITA"
            r1.put(r0, r14)
            r0 = 5040(0x13b0, float:7.063E-42)
            java.lang.String r14 = "MARIA LA BAJA"
            r1.put(r0, r14)
            r0 = 5041(0x13b1, float:7.064E-42)
            java.lang.String r14 = "MONTECRISTO"
            r1.put(r0, r14)
            r0 = 5043(0x13b3, float:7.067E-42)
            java.lang.String r14 = "MOMPOS"
            r1.put(r0, r14)
            r0 = 5044(0x13b4, float:7.068E-42)
            java.lang.String r14 = "MORALES"
            r1.put(r0, r14)
            r0 = 5050(0x13ba, float:7.077E-42)
            java.lang.String r14 = "NOROSI"
            r1.put(r0, r14)
            r0 = 5059(0x13c3, float:7.089E-42)
            java.lang.String r14 = "PINILLOS"
            r1.put(r0, r14)
            r0 = 5063(0x13c7, float:7.095E-42)
            java.lang.String r14 = "REGIDOR"
            r1.put(r0, r14)
            r0 = 5065(0x13c9, float:7.098E-42)
            java.lang.String r14 = "RIOVIEJO"
            r1.put(r0, r14)
            r0 = 5070(0x13ce, float:7.105E-42)
            java.lang.String r14 = "SAN ESTANISLAO"
            r1.put(r0, r14)
            r0 = 5072(0x13d0, float:7.107E-42)
            java.lang.String r14 = "SAN CRISTOBAL"
            r1.put(r0, r14)
            r0 = 5073(0x13d1, float:7.109E-42)
            java.lang.String r14 = "SAN FERNANDO"
            r1.put(r0, r14)
            r0 = 5076(0x13d4, float:7.113E-42)
            java.lang.String r14 = "SAN JACINTO"
            r1.put(r0, r14)
            r0 = 5078(0x13d6, float:7.116E-42)
            java.lang.String r14 = "SAN JACINTO DEL CAUCA"
            r1.put(r0, r14)
            r0 = 5079(0x13d7, float:7.117E-42)
            java.lang.String r14 = "SAN JUAN NEPOMUCENO"
            r1.put(r0, r14)
            r0 = 5082(0x13da, float:7.121E-42)
            java.lang.String r14 = "SAN MARTIN DE LOBA"
            r1.put(r0, r14)
            r0 = 5084(0x13dc, float:7.124E-42)
            java.lang.String r14 = "SAN PABLO"
            r1.put(r0, r14)
            r0 = 5091(0x13e3, float:7.134E-42)
            java.lang.String r14 = "SANTA CATALINA"
            r1.put(r0, r14)
            r0 = 5094(0x13e6, float:7.138E-42)
            java.lang.String r14 = "SANTA ROSA"
            r1.put(r0, r14)
            r0 = 5095(0x13e7, float:7.14E-42)
            java.lang.String r14 = "SANTA ROSA DEL SUR"
            r1.put(r0, r14)
            r0 = 5097(0x13e9, float:7.142E-42)
            java.lang.String r14 = "SIMITI"
            r1.put(r0, r14)
            r0 = 5106(0x13f2, float:7.155E-42)
            java.lang.String r14 = "SOPLAVIENTO"
            r1.put(r0, r14)
            r0 = 5110(0x13f6, float:7.16E-42)
            java.lang.String r14 = "TALAIGUA NUEVO"
            r1.put(r0, r14)
            r0 = 5113(0x13f9, float:7.165E-42)
            java.lang.String r14 = "TIQUISIO (PTO. RICO)"
            r1.put(r0, r14)
            r0 = 5118(0x13fe, float:7.172E-42)
            java.lang.String r14 = "TURBACO"
            r1.put(r0, r14)
            r0 = 5121(0x1401, float:7.176E-42)
            java.lang.String r14 = "TURBANA"
            r1.put(r0, r14)
            r0 = 5124(0x1404, float:7.18E-42)
            java.lang.String r14 = "VILLANUEVA"
            r1.put(r0, r14)
            r0 = 5127(0x1407, float:7.184E-42)
            r19 = r14
            java.lang.String r14 = "ZAMBRANO"
            r1.put(r0, r14)
            r0 = 7001(0x1b59, float:9.81E-42)
            java.lang.String r14 = "TUNJA"
            r1.put(r0, r14)
            r0 = 7007(0x1b5f, float:9.819E-42)
            java.lang.String r14 = "ALMEIDA"
            r1.put(r0, r14)
            r0 = 7008(0x1b60, float:9.82E-42)
            java.lang.String r14 = "AQUITANIA (PUEBLOVIEJO)"
            r1.put(r0, r14)
            r0 = 7010(0x1b62, float:9.823E-42)
            java.lang.String r14 = "ARCABUCO"
            r1.put(r0, r14)
            r0 = 7013(0x1b65, float:9.827E-42)
            java.lang.String r14 = "BELEN"
            r1.put(r0, r14)
            r0 = 7016(0x1b68, float:9.832E-42)
            java.lang.String r14 = "BERBEO"
            r1.put(r0, r14)
            r0 = 7019(0x1b6b, float:9.836E-42)
            java.lang.String r14 = "BETEITIVA"
            r1.put(r0, r14)
            r0 = 7022(0x1b6e, float:9.84E-42)
            java.lang.String r14 = "BOAVITA"
            r1.put(r0, r14)
            r0 = 7025(0x1b71, float:9.844E-42)
            r1.put(r0, r5)
            r0 = 7028(0x1b74, float:9.848E-42)
            java.lang.String r5 = "BRICE/O"
            r1.put(r0, r5)
            r0 = 7031(0x1b77, float:9.853E-42)
            java.lang.String r5 = "BUENAVISTA"
            r1.put(r0, r5)
            r0 = 7034(0x1b7a, float:9.857E-42)
            java.lang.String r14 = "BUSBANZA"
            r1.put(r0, r14)
            r0 = 7037(0x1b7d, float:9.861E-42)
            r1.put(r0, r6)
            r0 = 7040(0x1b80, float:9.865E-42)
            java.lang.String r6 = "CAMPOHERMOSO"
            r1.put(r0, r6)
            r0 = 7043(0x1b83, float:9.87E-42)
            java.lang.String r6 = "CERINZA"
            r1.put(r0, r6)
            r0 = 7046(0x1b86, float:9.874E-42)
            java.lang.String r6 = "CIENEGA"
            r1.put(r0, r6)
            r0 = 7049(0x1b89, float:9.878E-42)
            java.lang.String r6 = "COMBITA"
            r1.put(r0, r6)
            r0 = 7052(0x1b8c, float:9.882E-42)
            java.lang.String r6 = "COPER"
            r1.put(r0, r6)
            r0 = 7055(0x1b8f, float:9.886E-42)
            java.lang.String r6 = "CORRALES"
            r1.put(r0, r6)
            r0 = 7058(0x1b92, float:9.89E-42)
            java.lang.String r6 = "COVARACHIA"
            r1.put(r0, r6)
            r0 = 7059(0x1b93, float:9.892E-42)
            java.lang.String r6 = "CUBARA"
            r1.put(r0, r6)
            r0 = 7060(0x1b94, float:9.893E-42)
            java.lang.String r6 = "CUCAITA"
            r1.put(r0, r6)
            r0 = 7061(0x1b95, float:9.895E-42)
            java.lang.String r6 = "CUITIVA"
            r1.put(r0, r6)
            r0 = 7064(0x1b98, float:9.899E-42)
            java.lang.String r6 = "CHINAVITA"
            r1.put(r0, r6)
            r0 = 7067(0x1b9b, float:9.903E-42)
            java.lang.String r6 = "CHIQUINQUIRA"
            r1.put(r0, r6)
            r0 = 7068(0x1b9c, float:9.904E-42)
            java.lang.String r6 = "CHIQUIZA"
            r1.put(r0, r6)
            r0 = 7070(0x1b9e, float:9.907E-42)
            java.lang.String r6 = "CHISCAS"
            r1.put(r0, r6)
            r0 = 7073(0x1ba1, float:9.911E-42)
            java.lang.String r6 = "CHITA"
            r1.put(r0, r6)
            r0 = 7076(0x1ba4, float:9.916E-42)
            java.lang.String r6 = "CHITARAQUE"
            r1.put(r0, r6)
            r0 = 7077(0x1ba5, float:9.917E-42)
            java.lang.String r6 = "CHIVATA"
            r1.put(r0, r6)
            r0 = 7078(0x1ba6, float:9.918E-42)
            java.lang.String r6 = "CHIVOR"
            r1.put(r0, r6)
            r0 = 7079(0x1ba7, float:9.92E-42)
            java.lang.String r6 = "DUITAMA"
            r1.put(r0, r6)
            r0 = 7082(0x1baa, float:9.924E-42)
            java.lang.String r6 = "EL COCUY"
            r1.put(r0, r6)
            r0 = 7085(0x1bad, float:9.928E-42)
            java.lang.String r6 = "EL ESPINO"
            r1.put(r0, r6)
            r0 = 7088(0x1bb0, float:9.932E-42)
            java.lang.String r6 = "FIRAVITOBA"
            r1.put(r0, r6)
            r0 = 7091(0x1bb3, float:9.937E-42)
            java.lang.String r6 = "FLORESTA"
            r1.put(r0, r6)
            r0 = 7094(0x1bb6, float:9.941E-42)
            java.lang.String r6 = "GACHANTIVA"
            r1.put(r0, r6)
            r0 = 7097(0x1bb9, float:9.945E-42)
            java.lang.String r6 = "GAMEZA"
            r1.put(r0, r6)
            r0 = 7100(0x1bbc, float:9.949E-42)
            java.lang.String r6 = "GARAGOA"
            r1.put(r0, r6)
            r0 = 7103(0x1bbf, float:9.953E-42)
            java.lang.String r6 = "GUACAMAYAS"
            r1.put(r0, r6)
            r0 = 7106(0x1bc2, float:9.958E-42)
            java.lang.String r6 = "GUATEQUE"
            r1.put(r0, r6)
            r0 = 7109(0x1bc5, float:9.962E-42)
            java.lang.String r6 = "GUAYATA"
            r1.put(r0, r6)
            r0 = 7112(0x1bc8, float:9.966E-42)
            java.lang.String r6 = "GUICAN"
            r1.put(r0, r6)
            r0 = 7118(0x1bce, float:9.974E-42)
            java.lang.String r6 = "IZA"
            r1.put(r0, r6)
            r0 = 7121(0x1bd1, float:9.979E-42)
            java.lang.String r6 = "JENESANO"
            r1.put(r0, r6)
            r0 = 7124(0x1bd4, float:9.983E-42)
            java.lang.String r6 = "JERICO"
            r1.put(r0, r6)
            r0 = 7127(0x1bd7, float:9.987E-42)
            java.lang.String r6 = "LABRANZAGRANDE"
            r1.put(r0, r6)
            r0 = 7130(0x1bda, float:9.991E-42)
            java.lang.String r6 = "LA CAPILLA"
            r1.put(r0, r6)
            r0 = 7136(0x1be0, float:1.0E-41)
            java.lang.String r6 = "LA UVITA"
            r1.put(r0, r6)
            r0 = 7137(0x1be1, float:1.0001E-41)
            java.lang.String r6 = "LA VICTORIA"
            r1.put(r0, r6)
            r0 = 7139(0x1be3, float:1.0004E-41)
            java.lang.String r14 = "VILLA DE LEIVA"
            r1.put(r0, r14)
            r0 = 7142(0x1be6, float:1.0008E-41)
            java.lang.String r14 = "MACANAL"
            r1.put(r0, r14)
            r0 = 7148(0x1bec, float:1.0016E-41)
            java.lang.String r14 = "MARIPI"
            r1.put(r0, r14)
            r0 = 7151(0x1bef, float:1.002E-41)
            java.lang.String r14 = "MIRAFLORES"
            r1.put(r0, r14)
            r0 = 7154(0x1bf2, float:1.0025E-41)
            java.lang.String r14 = "MONGUA"
            r1.put(r0, r14)
            r0 = 7157(0x1bf5, float:1.0029E-41)
            java.lang.String r14 = "MONGUI"
            r1.put(r0, r14)
            r0 = 7160(0x1bf8, float:1.0033E-41)
            java.lang.String r14 = "MONIQUIRA"
            r1.put(r0, r14)
            r0 = 7161(0x1bf9, float:1.0035E-41)
            java.lang.String r14 = "MOTAVITA"
            r1.put(r0, r14)
            r0 = 7163(0x1bfb, float:1.0038E-41)
            java.lang.String r14 = "MUZO"
            r1.put(r0, r14)
            r0 = 7166(0x1bfe, float:1.0042E-41)
            java.lang.String r14 = "NOBSA"
            r1.put(r0, r14)
            r0 = 7169(0x1c01, float:1.0046E-41)
            java.lang.String r14 = "NUEVO COLON"
            r1.put(r0, r14)
            r0 = 7173(0x1c05, float:1.0052E-41)
            java.lang.String r14 = "OICATA"
            r1.put(r0, r14)
            r0 = 7176(0x1c08, float:1.0056E-41)
            java.lang.String r14 = "OTANCHE"
            r1.put(r0, r14)
            r0 = 7178(0x1c0a, float:1.0059E-41)
            java.lang.String r14 = "PACHAVITA"
            r1.put(r0, r14)
            r0 = 7179(0x1c0b, float:1.006E-41)
            java.lang.String r14 = "PAEZ"
            r1.put(r0, r14)
            r0 = 7181(0x1c0d, float:1.0063E-41)
            java.lang.String r14 = "PAIPA"
            r1.put(r0, r14)
            r0 = 7184(0x1c10, float:1.0067E-41)
            java.lang.String r14 = "PAJARITO"
            r1.put(r0, r14)
            r0 = 7187(0x1c13, float:1.0071E-41)
            java.lang.String r14 = "PANQUEBA"
            r1.put(r0, r14)
            r0 = 7190(0x1c16, float:1.0075E-41)
            java.lang.String r14 = "PAUNA"
            r1.put(r0, r14)
            r0 = 7193(0x1c19, float:1.008E-41)
            java.lang.String r14 = "PAYA"
            r1.put(r0, r14)
            r0 = 7199(0x1c1f, float:1.0088E-41)
            java.lang.String r14 = "PAZ DE RIO"
            r1.put(r0, r14)
            r0 = 7202(0x1c22, float:1.0092E-41)
            java.lang.String r14 = "PESCA"
            r1.put(r0, r14)
            r0 = 7205(0x1c25, float:1.0096E-41)
            java.lang.String r14 = "PISBA"
            r1.put(r0, r14)
            r0 = 7214(0x1c2e, float:1.0109E-41)
            java.lang.String r14 = "PUERTO BOYACA"
            r1.put(r0, r14)
            r0 = 7215(0x1c2f, float:1.011E-41)
            java.lang.String r14 = "QUIPAMA"
            r1.put(r0, r14)
            r0 = 7217(0x1c31, float:1.0113E-41)
            java.lang.String r14 = "RAMIRIQUI"
            r1.put(r0, r14)
            r0 = 7220(0x1c34, float:1.0117E-41)
            java.lang.String r14 = "RAQUIRA"
            r1.put(r0, r14)
            r0 = 7223(0x1c37, float:1.0122E-41)
            java.lang.String r14 = "RONDON"
            r1.put(r0, r14)
            r0 = 7226(0x1c3a, float:1.0126E-41)
            java.lang.String r14 = "SABOYA"
            r1.put(r0, r14)
            r0 = 7232(0x1c40, float:1.0134E-41)
            java.lang.String r14 = "SACHICA"
            r1.put(r0, r14)
            r0 = 7235(0x1c43, float:1.0138E-41)
            java.lang.String r14 = "SAMACA"
            r1.put(r0, r14)
            r0 = 7237(0x1c45, float:1.0141E-41)
            java.lang.String r14 = "SAN EDUARDO"
            r1.put(r0, r14)
            r0 = 7238(0x1c46, float:1.0143E-41)
            java.lang.String r14 = "SAN JOSE DE PARE"
            r1.put(r0, r14)
            r0 = 7241(0x1c49, float:1.0147E-41)
            java.lang.String r14 = "SAN LUIS DE GACENO"
            r1.put(r0, r14)
            r0 = 7247(0x1c4f, float:1.0155E-41)
            java.lang.String r14 = "SAN MATEO"
            r1.put(r0, r14)
            r0 = 7248(0x1c50, float:1.0157E-41)
            java.lang.String r14 = "SAN MIGUEL DE SEMA"
            r1.put(r0, r14)
            r0 = 7249(0x1c51, float:1.0158E-41)
            java.lang.String r14 = "SAN PABLO DE BORBUR"
            r1.put(r0, r14)
            r0 = 7250(0x1c52, float:1.016E-41)
            java.lang.String r14 = "SANTANA"
            r1.put(r0, r14)
            r0 = 7251(0x1c53, float:1.0161E-41)
            java.lang.String r14 = "SANTA MARIA"
            r1.put(r0, r14)
            r0 = 7253(0x1c55, float:1.0164E-41)
            java.lang.String r14 = "SANTA ROSA DE VITERBO"
            r1.put(r0, r14)
            r0 = 7256(0x1c58, float:1.0168E-41)
            java.lang.String r14 = "SANTA SOFIA"
            r1.put(r0, r14)
            r0 = 7259(0x1c5b, float:1.0172E-41)
            java.lang.String r14 = "SATIVANORTE"
            r1.put(r0, r14)
            r0 = 7262(0x1c5e, float:1.0176E-41)
            java.lang.String r14 = "SATIVASUR"
            r1.put(r0, r14)
            r0 = 7265(0x1c61, float:1.018E-41)
            java.lang.String r14 = "SIACHOQUE"
            r1.put(r0, r14)
            r0 = 7268(0x1c64, float:1.0185E-41)
            java.lang.String r14 = "SOATA"
            r1.put(r0, r14)
            r0 = 7271(0x1c67, float:1.0189E-41)
            java.lang.String r14 = "SOCOTA"
            r1.put(r0, r14)
            r0 = 7274(0x1c6a, float:1.0193E-41)
            java.lang.String r14 = "SOCHA"
            r1.put(r0, r14)
            r0 = 7277(0x1c6d, float:1.0197E-41)
            java.lang.String r14 = "SOGAMOSO"
            r1.put(r0, r14)
            r0 = 7280(0x1c70, float:1.0201E-41)
            java.lang.String r14 = "SOMONDOCO"
            r1.put(r0, r14)
            r0 = 7281(0x1c71, float:1.0203E-41)
            java.lang.String r14 = "SORA"
            r1.put(r0, r14)
            r0 = 7282(0x1c72, float:1.0204E-41)
            java.lang.String r14 = "SORACA"
            r1.put(r0, r14)
            r0 = 7283(0x1c73, float:1.0206E-41)
            java.lang.String r14 = "SOTAQUIRA"
            r1.put(r0, r14)
            r0 = 7286(0x1c76, float:1.021E-41)
            java.lang.String r14 = "SUSACON"
            r1.put(r0, r14)
            r0 = 7289(0x1c79, float:1.0214E-41)
            java.lang.String r14 = "SUTAMARCHAN"
            r1.put(r0, r14)
            r0 = 7292(0x1c7c, float:1.0218E-41)
            java.lang.String r14 = "SUTATENZA"
            r1.put(r0, r14)
            r0 = 7298(0x1c82, float:1.0227E-41)
            java.lang.String r14 = "TASCO"
            r1.put(r0, r14)
            r0 = 7301(0x1c85, float:1.0231E-41)
            java.lang.String r14 = "TENZA"
            r1.put(r0, r14)
            r0 = 7304(0x1c88, float:1.0235E-41)
            java.lang.String r14 = "TIBANA"
            r1.put(r0, r14)
            r0 = 7307(0x1c8b, float:1.0239E-41)
            java.lang.String r14 = "TIBASOSA"
            r1.put(r0, r14)
            r0 = 7310(0x1c8e, float:1.0243E-41)
            java.lang.String r14 = "TINJACA"
            r1.put(r0, r14)
            r0 = 7311(0x1c8f, float:1.0245E-41)
            java.lang.String r14 = "TIPACOQUE"
            r1.put(r0, r14)
            r0 = 7313(0x1c91, float:1.0248E-41)
            java.lang.String r14 = "TOCA"
            r1.put(r0, r14)
            r0 = 7316(0x1c94, float:1.0252E-41)
            java.lang.String r14 = "TOGUI"
            r1.put(r0, r14)
            r0 = 7319(0x1c97, float:1.0256E-41)
            java.lang.String r14 = "TOPAGA"
            r1.put(r0, r14)
            r0 = 7322(0x1c9a, float:1.026E-41)
            java.lang.String r14 = "TOTA"
            r1.put(r0, r14)
            r0 = 7324(0x1c9c, float:1.0263E-41)
            java.lang.String r14 = "TUNUNGUA"
            r1.put(r0, r14)
            r0 = 7325(0x1c9d, float:1.0265E-41)
            java.lang.String r14 = "TURMEQUE"
            r1.put(r0, r14)
            r0 = 7328(0x1ca0, float:1.0269E-41)
            java.lang.String r14 = "TUTA"
            r1.put(r0, r14)
            r0 = 7331(0x1ca3, float:1.0273E-41)
            java.lang.String r14 = "TUTAZA"
            r1.put(r0, r14)
            r0 = 7334(0x1ca6, float:1.0277E-41)
            java.lang.String r14 = "UMBITA"
            r1.put(r0, r14)
            r0 = 7337(0x1ca9, float:1.0281E-41)
            java.lang.String r14 = "VENTAQUEMADA"
            r1.put(r0, r14)
            r0 = 7340(0x1cac, float:1.0286E-41)
            java.lang.String r14 = "VIRACACHA"
            r1.put(r0, r14)
            r0 = 7346(0x1cb2, float:1.0294E-41)
            java.lang.String r14 = "ZETAQUIRA"
            r1.put(r0, r14)
            r0 = 9001(0x2329, float:1.2613E-41)
            java.lang.String r14 = "MANIZALES"
            r1.put(r0, r14)
            r0 = 9004(0x232c, float:1.2617E-41)
            java.lang.String r14 = "AGUADAS"
            r1.put(r0, r14)
            r0 = 9007(0x232f, float:1.2621E-41)
            java.lang.String r14 = "ANSERMA"
            r1.put(r0, r14)
            r0 = 9013(0x2335, float:1.263E-41)
            java.lang.String r14 = "ARANZAZU"
            r1.put(r0, r14)
            r0 = 9022(0x233e, float:1.2643E-41)
            java.lang.String r14 = "BELALCAZAR"
            r1.put(r0, r14)
            r0 = 9034(0x234a, float:1.266E-41)
            java.lang.String r14 = "CHINCHINA"
            r1.put(r0, r14)
            r0 = 9037(0x234d, float:1.2664E-41)
            java.lang.String r14 = "FILADELFIA"
            r1.put(r0, r14)
            r0 = 9049(0x2359, float:1.268E-41)
            java.lang.String r14 = "LA DORADA"
            r1.put(r0, r14)
            r0 = 9052(0x235c, float:1.2685E-41)
            java.lang.String r14 = "LA MERCED"
            r1.put(r0, r14)
            r0 = 9055(0x235f, float:1.2689E-41)
            java.lang.String r14 = "MANZANARES"
            r1.put(r0, r14)
            r0 = 9058(0x2362, float:1.2693E-41)
            java.lang.String r14 = "MARMATO"
            r1.put(r0, r14)
            r0 = 9061(0x2365, float:1.2697E-41)
            java.lang.String r14 = "MARQUETALIA"
            r1.put(r0, r14)
            r0 = 9067(0x236b, float:1.2706E-41)
            java.lang.String r14 = "MARULANDA"
            r1.put(r0, r14)
            r0 = 9076(0x2374, float:1.2718E-41)
            java.lang.String r14 = "NEIRA"
            r1.put(r0, r14)
            r0 = 9078(0x2376, float:1.2721E-41)
            java.lang.String r14 = "NORCASIA"
            r1.put(r0, r14)
            r0 = 9079(0x2377, float:1.2722E-41)
            java.lang.String r14 = "PACORA"
            r1.put(r0, r14)
            r0 = 9082(0x237a, float:1.2727E-41)
            java.lang.String r14 = "PALESTINA"
            r1.put(r0, r14)
            r0 = 9085(0x237d, float:1.2731E-41)
            java.lang.String r14 = "PENSILVANIA"
            r1.put(r0, r14)
            r0 = 9103(0x238f, float:1.2756E-41)
            java.lang.String r14 = "RIOSUCIO"
            r1.put(r0, r14)
            r0 = 9106(0x2392, float:1.276E-41)
            java.lang.String r14 = "RISARALDA"
            r1.put(r0, r14)
            r0 = 9109(0x2395, float:1.2764E-41)
            java.lang.String r14 = "SALAMINA"
            r1.put(r0, r14)
            r0 = 9115(0x239b, float:1.2773E-41)
            java.lang.String r14 = "SAMANA"
            r1.put(r0, r14)
            r0 = 9120(0x23a0, float:1.278E-41)
            java.lang.String r14 = "SAN JOSE"
            r1.put(r0, r14)
            r0 = 9124(0x23a4, float:1.2785E-41)
            java.lang.String r14 = "SUPIA"
            r1.put(r0, r14)
            r0 = 9127(0x23a7, float:1.279E-41)
            java.lang.String r14 = "VICTORIA"
            r1.put(r0, r14)
            r0 = 9130(0x23aa, float:1.2794E-41)
            java.lang.String r14 = "VILLAMARIA"
            r1.put(r0, r14)
            r0 = 9133(0x23ad, float:1.2798E-41)
            java.lang.String r14 = "VITERBO"
            r1.put(r0, r14)
            r0 = 11001(0x2af9, float:1.5416E-41)
            java.lang.String r14 = "POPAYAN"
            r1.put(r0, r14)
            r0 = 11004(0x2afc, float:1.542E-41)
            java.lang.String r14 = "ALMAGUER"
            r1.put(r0, r14)
            r0 = 11005(0x2afd, float:1.5421E-41)
            r1.put(r0, r2)
            r0 = 11006(0x2afe, float:1.5423E-41)
            java.lang.String r14 = "BALBOA"
            r1.put(r0, r14)
            r0 = 11007(0x2aff, float:1.5424E-41)
            r1.put(r0, r4)
            r0 = 11010(0x2b02, float:1.5428E-41)
            java.lang.String r14 = "BUENOS AIRES"
            r1.put(r0, r14)
            r0 = 11013(0x2b05, float:1.5432E-41)
            java.lang.String r14 = "CAJIBIO"
            r1.put(r0, r14)
            r0 = 11016(0x2b08, float:1.5437E-41)
            java.lang.String r14 = "CALDONO"
            r1.put(r0, r14)
            r0 = 11019(0x2b0b, float:1.5441E-41)
            java.lang.String r14 = "CALOTO"
            r1.put(r0, r14)
            r0 = 11022(0x2b0e, float:1.5445E-41)
            java.lang.String r14 = "CORINTO"
            r1.put(r0, r14)
            r0 = 11025(0x2b11, float:1.545E-41)
            java.lang.String r14 = "EL TAMBO"
            r1.put(r0, r14)
            r0 = 11027(0x2b13, float:1.5452E-41)
            java.lang.String r14 = "FLORENCIA"
            r1.put(r0, r14)
            r0 = 11028(0x2b14, float:1.5454E-41)
            java.lang.String r14 = "GUAPI"
            r1.put(r0, r14)
            r0 = 11029(0x2b15, float:1.5455E-41)
            java.lang.String r14 = "GUACHENE"
            r1.put(r0, r14)
            r0 = 11031(0x2b17, float:1.5458E-41)
            java.lang.String r14 = "INZA"
            r1.put(r0, r14)
            r0 = 11034(0x2b1a, float:1.5462E-41)
            java.lang.String r14 = "JAMBALO"
            r1.put(r0, r14)
            r0 = 11037(0x2b1d, float:1.5466E-41)
            java.lang.String r14 = "LA SIERRA"
            r1.put(r0, r14)
            r0 = 11040(0x2b20, float:1.547E-41)
            java.lang.String r14 = "LA VEGA"
            r1.put(r0, r14)
            r0 = 11043(0x2b23, float:1.5475E-41)
            java.lang.String r14 = "LOPEZ (MICAY)"
            r1.put(r0, r14)
            r0 = 11046(0x2b26, float:1.5479E-41)
            java.lang.String r14 = "MERCADERES"
            r1.put(r0, r14)
            r0 = 11049(0x2b29, float:1.5483E-41)
            java.lang.String r14 = "MIRANDA"
            r1.put(r0, r14)
            r0 = 11052(0x2b2c, float:1.5487E-41)
            java.lang.String r14 = "MORALES"
            r1.put(r0, r14)
            r0 = 11053(0x2b2d, float:1.5489E-41)
            java.lang.String r14 = "PADILLA"
            r1.put(r0, r14)
            r0 = 11055(0x2b2f, float:1.5491E-41)
            java.lang.String r14 = "PAEZ (BELALCAZAR)"
            r1.put(r0, r14)
            r0 = 11058(0x2b32, float:1.5496E-41)
            java.lang.String r14 = "PATIA (EL BORDO)"
            r1.put(r0, r14)
            r0 = 11060(0x2b34, float:1.5498E-41)
            java.lang.String r14 = "PIAMONTE"
            r1.put(r0, r14)
            r0 = 11061(0x2b35, float:1.55E-41)
            java.lang.String r14 = "PIENDAMO"
            r1.put(r0, r14)
            r0 = 11064(0x2b38, float:1.5504E-41)
            java.lang.String r14 = "PUERTO TEJADA"
            r1.put(r0, r14)
            r0 = 11067(0x2b3b, float:1.5508E-41)
            java.lang.String r14 = "PURACE (COCONUCO)"
            r1.put(r0, r14)
            r0 = 11070(0x2b3e, float:1.5512E-41)
            java.lang.String r14 = "ROSAS"
            r1.put(r0, r14)
            r0 = 11073(0x2b41, float:1.5517E-41)
            java.lang.String r14 = "SAN SEBASTIAN"
            r1.put(r0, r14)
            r0 = 11076(0x2b44, float:1.5521E-41)
            java.lang.String r14 = "SANTANDER DE QUILICHAO"
            r1.put(r0, r14)
            r0 = 11079(0x2b47, float:1.5525E-41)
            java.lang.String r14 = "SANTA ROSA"
            r1.put(r0, r14)
            r0 = 11082(0x2b4a, float:1.5529E-41)
            java.lang.String r14 = "SILVIA"
            r1.put(r0, r14)
            r0 = 11085(0x2b4d, float:1.5533E-41)
            java.lang.String r14 = "SOTARA (PAISPAMBA)"
            r1.put(r0, r14)
            r0 = 11086(0x2b4e, float:1.5535E-41)
            r1.put(r0, r9)
            r0 = 11087(0x2b4f, float:1.5536E-41)
            java.lang.String r14 = "SUAREZ"
            r1.put(r0, r14)
            r0 = 11088(0x2b50, float:1.5538E-41)
            java.lang.String r14 = "TIMBIO"
            r1.put(r0, r14)
            r0 = 11091(0x2b53, float:1.5542E-41)
            java.lang.String r14 = "TIMBIQUI"
            r1.put(r0, r14)
            r0 = 11094(0x2b56, float:1.5546E-41)
            java.lang.String r14 = "TORIBIO"
            r1.put(r0, r14)
            r0 = 11097(0x2b59, float:1.555E-41)
            java.lang.String r14 = "TOTORO"
            r1.put(r0, r14)
            r0 = 11098(0x2b5a, float:1.5552E-41)
            java.lang.String r14 = "VILLA RICA"
            r1.put(r0, r14)
            r0 = 12001(0x2ee1, float:1.6817E-41)
            java.lang.String r14 = "VALLEDUPAR"
            r1.put(r0, r14)
            r0 = 12075(0x2f2b, float:1.692E-41)
            java.lang.String r14 = "AGUACHICA"
            r1.put(r0, r14)
            r0 = 12150(0x2f76, float:1.7026E-41)
            java.lang.String r14 = "AGUSTIN CODAZZI"
            r1.put(r0, r14)
            r0 = 12170(0x2f8a, float:1.7054E-41)
            java.lang.String r14 = "ASTREA"
            r1.put(r0, r14)
            r0 = 12180(0x2f94, float:1.7068E-41)
            java.lang.String r14 = "BECERRIL"
            r1.put(r0, r14)
            r0 = 12200(0x2fa8, float:1.7096E-41)
            java.lang.String r14 = "BOSCONIA"
            r1.put(r0, r14)
            r0 = 12225(0x2fc1, float:1.7131E-41)
            java.lang.String r14 = "CURUMANI"
            r1.put(r0, r14)
            r0 = 12300(0x300c, float:1.7236E-41)
            java.lang.String r14 = "CHIMICHAGUA"
            r1.put(r0, r14)
            r0 = 12375(0x3057, float:1.7341E-41)
            java.lang.String r14 = "CHIRIGUANA"
            r1.put(r0, r14)
            r0 = 12410(0x307a, float:1.739E-41)
            java.lang.String r14 = "EL COPEY"
            r1.put(r0, r14)
            r0 = 12415(0x307f, float:1.7397E-41)
            java.lang.String r14 = "EL PASO"
            r1.put(r0, r14)
            r0 = 12450(0x30a2, float:1.7446E-41)
            java.lang.String r14 = "GAMARRA"
            r1.put(r0, r14)
            r0 = 12525(0x30ed, float:1.7551E-41)
            java.lang.String r14 = "GONZALEZ"
            r1.put(r0, r14)
            r0 = 12600(0x3138, float:1.7656E-41)
            java.lang.String r14 = "LA GLORIA"
            r1.put(r0, r14)
            r0 = 12608(0x3140, float:1.7668E-41)
            java.lang.String r14 = "LA JAGUA DE IBIRICO"
            r1.put(r0, r14)
            r0 = 12625(0x3151, float:1.7691E-41)
            java.lang.String r14 = "MANAURE BALCON DEL CESAR (MANA"
            r1.put(r0, r14)
            r0 = 12650(0x316a, float:1.7726E-41)
            java.lang.String r14 = "PAILITAS"
            r1.put(r0, r14)
            r0 = 12700(0x319c, float:1.7796E-41)
            java.lang.String r14 = "PELAYA"
            r1.put(r0, r14)
            r0 = 12720(0x31b0, float:1.7825E-41)
            java.lang.String r14 = "PUEBLO BELLO"
            r1.put(r0, r14)
            r0 = 12750(0x31ce, float:1.7867E-41)
            java.lang.String r14 = "RIO DE ORO"
            r1.put(r0, r14)
            r0 = 12800(0x3200, float:1.7937E-41)
            java.lang.String r14 = "SAN ALBERTO"
            r1.put(r0, r14)
            r0 = 12825(0x3219, float:1.7972E-41)
            java.lang.String r14 = "LA PAZ"
            r1.put(r0, r14)
            r0 = 12850(0x3232, float:1.8007E-41)
            java.lang.String r14 = "SAN DIEGO"
            r1.put(r0, r14)
            r0 = 12875(0x324b, float:1.8042E-41)
            java.lang.String r14 = "SAN MARTIN"
            r1.put(r0, r14)
            r0 = 12900(0x3264, float:1.8077E-41)
            java.lang.String r14 = "TAMALAMEQUE"
            r1.put(r0, r14)
            r0 = 13001(0x32c9, float:1.8218E-41)
            java.lang.String r14 = "MONTERIA"
            r1.put(r0, r14)
            r0 = 13004(0x32cc, float:1.8222E-41)
            java.lang.String r14 = "AYAPEL"
            r1.put(r0, r14)
            r0 = 13007(0x32cf, float:1.8227E-41)
            r1.put(r0, r5)
            r0 = 13009(0x32d1, float:1.823E-41)
            java.lang.String r14 = "CANALETE"
            r1.put(r0, r14)
            r0 = 13010(0x32d2, float:1.8231E-41)
            java.lang.String r14 = "CERETE"
            r1.put(r0, r14)
            r0 = 13013(0x32d5, float:1.8235E-41)
            java.lang.String r14 = "CIENAGA DE ORO"
            r1.put(r0, r14)
            r0 = 13014(0x32d6, float:1.8236E-41)
            java.lang.String r14 = "COTORRA (BONGO)"
            r1.put(r0, r14)
            r0 = 13016(0x32d8, float:1.824E-41)
            java.lang.String r14 = "CHIMA"
            r1.put(r0, r14)
            r0 = 13019(0x32db, float:1.8244E-41)
            java.lang.String r14 = "CHINU"
            r1.put(r0, r14)
            r0 = 13020(0x32dc, float:1.8245E-41)
            java.lang.String r14 = "LA APARTADA (FRONTERA)"
            r1.put(r0, r14)
            r0 = 13022(0x32de, float:1.8248E-41)
            java.lang.String r14 = "LORICA"
            r1.put(r0, r14)
            r0 = 13023(0x32df, float:1.8249E-41)
            java.lang.String r14 = "LOS CORDOBAS"
            r1.put(r0, r14)
            r0 = 13024(0x32e0, float:1.825E-41)
            java.lang.String r14 = "MOMIL"
            r1.put(r0, r14)
            r0 = 13025(0x32e1, float:1.8252E-41)
            java.lang.String r14 = "MONTELIBANO"
            r1.put(r0, r14)
            r0 = 13027(0x32e3, float:1.8255E-41)
            java.lang.String r14 = "MO/ITOS"
            r1.put(r0, r14)
            r0 = 13028(0x32e4, float:1.8256E-41)
            java.lang.String r14 = "PLANETA RICA"
            r1.put(r0, r14)
            r0 = 13031(0x32e7, float:1.826E-41)
            java.lang.String r14 = "PUEBLO NUEVO"
            r1.put(r0, r14)
            r0 = 13032(0x32e8, float:1.8262E-41)
            java.lang.String r14 = "PUERTO LIBERTADOR"
            r1.put(r0, r14)
            r0 = 13033(0x32e9, float:1.8263E-41)
            java.lang.String r14 = "PUERTO ESCONDIDO"
            r1.put(r0, r14)
            r0 = 13034(0x32ea, float:1.8265E-41)
            java.lang.String r14 = "PURISIMA"
            r1.put(r0, r14)
            r0 = 13037(0x32ed, float:1.8269E-41)
            java.lang.String r14 = "SAHAGUN"
            r1.put(r0, r14)
            r0 = 13040(0x32f0, float:1.8273E-41)
            java.lang.String r14 = "SAN ANDRES DE SOTAVENTO"
            r1.put(r0, r14)
            r0 = 13043(0x32f3, float:1.8277E-41)
            java.lang.String r14 = "SAN ANTERO"
            r1.put(r0, r14)
            r0 = 13046(0x32f6, float:1.8281E-41)
            java.lang.String r14 = "SAN BERNARDO DEL VIENTO"
            r1.put(r0, r14)
            r0 = 13049(0x32f9, float:1.8286E-41)
            java.lang.String r14 = "SAN CARLOS"
            r1.put(r0, r14)
            r0 = 13052(0x32fc, float:1.829E-41)
            java.lang.String r14 = "SAN JOSE DE URE"
            r1.put(r0, r14)
            r0 = 13055(0x32ff, float:1.8294E-41)
            java.lang.String r14 = "SAN PELAYO"
            r1.put(r0, r14)
            r0 = 13058(0x3302, float:1.8298E-41)
            java.lang.String r14 = "TIERRALTA"
            r1.put(r0, r14)
            r0 = 13060(0x3304, float:1.8301E-41)
            java.lang.String r14 = "TUCHIN"
            r1.put(r0, r14)
            r0 = 13061(0x3305, float:1.8302E-41)
            java.lang.String r14 = "VALENCIA"
            r1.put(r0, r14)
            r0 = 15001(0x3a99, float:2.1021E-41)
            r1.put(r0, r8)
            r0 = 15004(0x3a9c, float:2.1025E-41)
            java.lang.String r14 = "AGUA DE DIOS"
            r1.put(r0, r14)
            r0 = 15007(0x3a9f, float:2.1029E-41)
            java.lang.String r14 = "ALBAN"
            r1.put(r0, r14)
            r0 = 15010(0x3aa2, float:2.1033E-41)
            java.lang.String r14 = "ANAPOIMA"
            r1.put(r0, r14)
            r0 = 15013(0x3aa5, float:2.1038E-41)
            java.lang.String r14 = "ANOLAIMA"
            r1.put(r0, r14)
            r0 = 15016(0x3aa8, float:2.1042E-41)
            java.lang.String r14 = "ARBELAEZ"
            r1.put(r0, r14)
            r0 = 15019(0x3aab, float:2.1046E-41)
            java.lang.String r14 = "BELTRAN"
            r1.put(r0, r14)
            r0 = 15022(0x3aae, float:2.105E-41)
            java.lang.String r14 = "BITUIMA"
            r1.put(r0, r14)
            r0 = 15025(0x3ab1, float:2.1055E-41)
            java.lang.String r14 = "BOJACA"
            r1.put(r0, r14)
            r0 = 15029(0x3ab5, float:2.106E-41)
            java.lang.String r14 = "CABRERA"
            r1.put(r0, r14)
            r0 = 15030(0x3ab6, float:2.1062E-41)
            java.lang.String r14 = "CACHIPAY"
            r1.put(r0, r14)
            r0 = 15031(0x3ab7, float:2.1063E-41)
            java.lang.String r14 = "CAJICA"
            r1.put(r0, r14)
            r0 = 15034(0x3aba, float:2.1067E-41)
            java.lang.String r14 = "CAPARRAPI"
            r1.put(r0, r14)
            r0 = 15037(0x3abd, float:2.1071E-41)
            java.lang.String r14 = "CAQUEZA"
            r1.put(r0, r14)
            r0 = 15040(0x3ac0, float:2.1076E-41)
            java.lang.String r14 = "CARMEN DE CARUPA"
            r1.put(r0, r14)
            r0 = 15043(0x3ac3, float:2.108E-41)
            java.lang.String r14 = "COGUA"
            r1.put(r0, r14)
            r0 = 15046(0x3ac6, float:2.1084E-41)
            java.lang.String r14 = "COTA"
            r1.put(r0, r14)
            r0 = 15049(0x3ac9, float:2.1088E-41)
            java.lang.String r14 = "CUCUNUBA"
            r1.put(r0, r14)
            r0 = 15052(0x3acc, float:2.1092E-41)
            java.lang.String r14 = "CHAGUANI"
            r1.put(r0, r14)
            r0 = 15055(0x3acf, float:2.1097E-41)
            java.lang.String r14 = "CHIA"
            r1.put(r0, r14)
            r0 = 15058(0x3ad2, float:2.1101E-41)
            java.lang.String r14 = "CHIPAQUE"
            r1.put(r0, r14)
            r0 = 15061(0x3ad5, float:2.1105E-41)
            java.lang.String r14 = "CHOACHI"
            r1.put(r0, r14)
            r0 = 15064(0x3ad8, float:2.1109E-41)
            java.lang.String r14 = "CHOCONTA"
            r1.put(r0, r14)
            r0 = 15067(0x3adb, float:2.1113E-41)
            java.lang.String r14 = "EL COLEGIO"
            r1.put(r0, r14)
            r0 = 15070(0x3ade, float:2.1118E-41)
            r1.put(r0, r10)
            r0 = 15072(0x3ae0, float:2.112E-41)
            java.lang.String r14 = "EL ROSAL"
            r1.put(r0, r14)
            r0 = 15076(0x3ae4, float:2.1126E-41)
            java.lang.String r14 = "FACATATIVA"
            r1.put(r0, r14)
            r0 = 15079(0x3ae7, float:2.113E-41)
            java.lang.String r14 = "FOMEQUE"
            r1.put(r0, r14)
            r0 = 15085(0x3aed, float:2.1139E-41)
            java.lang.String r14 = "FOSCA"
            r1.put(r0, r14)
            r0 = 15088(0x3af0, float:2.1143E-41)
            java.lang.String r14 = "FUNZA"
            r1.put(r0, r14)
            r0 = 15091(0x3af3, float:2.1147E-41)
            java.lang.String r14 = "FUQUENE"
            r1.put(r0, r14)
            r0 = 15094(0x3af6, float:2.1151E-41)
            java.lang.String r14 = "FUSAGASUGA"
            r1.put(r0, r14)
            r0 = 15097(0x3af9, float:2.1155E-41)
            java.lang.String r14 = "GACHALA"
            r1.put(r0, r14)
            r0 = 15100(0x3afc, float:2.116E-41)
            java.lang.String r14 = "GACHANCIPA"
            r1.put(r0, r14)
            r0 = 15103(0x3aff, float:2.1164E-41)
            java.lang.String r14 = "GACHETA"
            r1.put(r0, r14)
            r0 = 15106(0x3b02, float:2.1168E-41)
            java.lang.String r14 = "GAMA"
            r1.put(r0, r14)
            r0 = 15109(0x3b05, float:2.1172E-41)
            java.lang.String r14 = "GIRARDOT"
            r1.put(r0, r14)
            r0 = 15112(0x3b08, float:2.1176E-41)
            java.lang.String r14 = "GUACHETA"
            r1.put(r0, r14)
            r0 = 15115(0x3b0b, float:2.118E-41)
            java.lang.String r14 = "GUADUAS"
            r1.put(r0, r14)
            r0 = 15118(0x3b0e, float:2.1185E-41)
            java.lang.String r14 = "GUASCA"
            r1.put(r0, r14)
            r0 = 15121(0x3b11, float:2.1189E-41)
            java.lang.String r14 = "GUATAQUI"
            r1.put(r0, r14)
            r0 = 15124(0x3b14, float:2.1193E-41)
            java.lang.String r14 = "GUATAVITA"
            r1.put(r0, r14)
            r0 = 15127(0x3b17, float:2.1197E-41)
            java.lang.String r14 = "GUAYABAL DE SIQUIMA"
            r1.put(r0, r14)
            r0 = 15128(0x3b18, float:2.1199E-41)
            java.lang.String r14 = "GUAYABETAL"
            r1.put(r0, r14)
            r0 = 15130(0x3b1a, float:2.1202E-41)
            java.lang.String r14 = "GUTIERREZ"
            r1.put(r0, r14)
            r0 = 15132(0x3b1c, float:2.1204E-41)
            r1.put(r0, r3)
            r0 = 15133(0x3b1d, float:2.1206E-41)
            java.lang.String r14 = "JERUSALEN"
            r1.put(r0, r14)
            r0 = 15136(0x3b20, float:2.121E-41)
            java.lang.String r14 = "JUNIN"
            r1.put(r0, r14)
            r0 = 15139(0x3b23, float:2.1214E-41)
            java.lang.String r14 = "LA CALERA"
            r1.put(r0, r14)
            r0 = 15142(0x3b26, float:2.1218E-41)
            java.lang.String r14 = "LA MESA"
            r1.put(r0, r14)
            r0 = 15145(0x3b29, float:2.1223E-41)
            java.lang.String r14 = "LA PALMA"
            r1.put(r0, r14)
            r0 = 15148(0x3b2c, float:2.1227E-41)
            java.lang.String r14 = "LA PE/A"
            r1.put(r0, r14)
            r0 = 15151(0x3b2f, float:2.1231E-41)
            java.lang.String r14 = "LA VEGA"
            r1.put(r0, r14)
            r0 = 15154(0x3b32, float:2.1235E-41)
            java.lang.String r14 = "LENGUAZAQUE"
            r1.put(r0, r14)
            r0 = 15157(0x3b35, float:2.124E-41)
            java.lang.String r14 = "MACHETA"
            r1.put(r0, r14)
            r0 = 15160(0x3b38, float:2.1244E-41)
            java.lang.String r14 = "MADRID"
            r1.put(r0, r14)
            r0 = 15163(0x3b3b, float:2.1248E-41)
            java.lang.String r14 = "MANTA"
            r1.put(r0, r14)
            r0 = 15166(0x3b3e, float:2.1252E-41)
            java.lang.String r14 = "MEDINA"
            r1.put(r0, r14)
            r0 = 15169(0x3b41, float:2.1256E-41)
            java.lang.String r14 = "MOSQUERA"
            r1.put(r0, r14)
            r0 = 15172(0x3b44, float:2.126E-41)
            r1.put(r0, r13)
            r0 = 15175(0x3b47, float:2.1265E-41)
            java.lang.String r14 = "NEMOCON"
            r1.put(r0, r14)
            r0 = 15178(0x3b4a, float:2.1269E-41)
            java.lang.String r14 = "NILO"
            r1.put(r0, r14)
            r0 = 15181(0x3b4d, float:2.1273E-41)
            java.lang.String r14 = "NIMAIMA"
            r1.put(r0, r14)
            r0 = 15184(0x3b50, float:2.1277E-41)
            java.lang.String r14 = "NOCAIMA"
            r1.put(r0, r14)
            r0 = 15190(0x3b56, float:2.1286E-41)
            java.lang.String r14 = "PACHO"
            r1.put(r0, r14)
            r0 = 15193(0x3b59, float:2.129E-41)
            java.lang.String r14 = "PAIME"
            r1.put(r0, r14)
            r0 = 15196(0x3b5c, float:2.1294E-41)
            java.lang.String r14 = "PANDI"
            r1.put(r0, r14)
            r0 = 15198(0x3b5e, float:2.1297E-41)
            java.lang.String r14 = "PARATEBUENO (LA NAGUAYA)"
            r1.put(r0, r14)
            r0 = 15199(0x3b5f, float:2.1298E-41)
            java.lang.String r14 = "PASCA"
            r1.put(r0, r14)
            r0 = 15202(0x3b62, float:2.1303E-41)
            java.lang.String r14 = "PUERTO SALGAR"
            r1.put(r0, r14)
            r0 = 15205(0x3b65, float:2.1307E-41)
            java.lang.String r14 = "PULI"
            r1.put(r0, r14)
            r0 = 15208(0x3b68, float:2.1311E-41)
            java.lang.String r14 = "QUEBRADANEGRA"
            r1.put(r0, r14)
            r0 = 15211(0x3b6b, float:2.1315E-41)
            java.lang.String r14 = "QUETAME"
            r1.put(r0, r14)
            r0 = 15214(0x3b6e, float:2.132E-41)
            java.lang.String r14 = "QUIPILE"
            r1.put(r0, r14)
            r0 = 15217(0x3b71, float:2.1324E-41)
            java.lang.String r14 = "APULO"
            r1.put(r0, r14)
            r0 = 15218(0x3b72, float:2.1325E-41)
            java.lang.String r14 = "RICAURTE"
            r1.put(r0, r14)
            r0 = 15220(0x3b74, float:2.1328E-41)
            java.lang.String r14 = "SAN ANTONIO DEL TEQUENDAMA"
            r1.put(r0, r14)
            r0 = 15223(0x3b77, float:2.1332E-41)
            java.lang.String r14 = "SAN BERNARDO"
            r1.put(r0, r14)
            r0 = 15226(0x3b7a, float:2.1336E-41)
            java.lang.String r14 = "SAN CAYETANO"
            r1.put(r0, r14)
            r0 = 15229(0x3b7d, float:2.134E-41)
            r1.put(r0, r15)
            r0 = 15232(0x3b80, float:2.1345E-41)
            java.lang.String r14 = "SAN JUAN DE RIOSECO"
            r1.put(r0, r14)
            r0 = 15235(0x3b83, float:2.1349E-41)
            java.lang.String r14 = "SASAIMA"
            r1.put(r0, r14)
            r0 = 15238(0x3b86, float:2.1353E-41)
            java.lang.String r14 = "SESQUILE"
            r1.put(r0, r14)
            r0 = 15239(0x3b87, float:2.1354E-41)
            java.lang.String r14 = "SIBATE"
            r1.put(r0, r14)
            r0 = 15241(0x3b89, float:2.1357E-41)
            java.lang.String r14 = "SILVANIA"
            r1.put(r0, r14)
            r0 = 15244(0x3b8c, float:2.1361E-41)
            java.lang.String r14 = "SIMIJACA"
            r1.put(r0, r14)
            r0 = 15247(0x3b8f, float:2.1366E-41)
            java.lang.String r14 = "SOACHA"
            r1.put(r0, r14)
            r0 = 15250(0x3b92, float:2.137E-41)
            java.lang.String r14 = "SOPO"
            r1.put(r0, r14)
            r0 = 15256(0x3b98, float:2.1378E-41)
            java.lang.String r14 = "SUBACHOQUE"
            r1.put(r0, r14)
            r0 = 15259(0x3b9b, float:2.1382E-41)
            java.lang.String r14 = "SUESCA"
            r1.put(r0, r14)
            r0 = 15262(0x3b9e, float:2.1387E-41)
            java.lang.String r14 = "SUPATA"
            r1.put(r0, r14)
            r0 = 15265(0x3ba1, float:2.1391E-41)
            java.lang.String r14 = "SUSA"
            r1.put(r0, r14)
            r0 = 15268(0x3ba4, float:2.1395E-41)
            java.lang.String r14 = "SUTATAUSA"
            r1.put(r0, r14)
            r0 = 15271(0x3ba7, float:2.1399E-41)
            java.lang.String r14 = "TABIO"
            r1.put(r0, r14)
            r0 = 15274(0x3baa, float:2.1403E-41)
            java.lang.String r14 = "TAUSA"
            r1.put(r0, r14)
            r0 = 15277(0x3bad, float:2.1408E-41)
            java.lang.String r14 = "TENA"
            r1.put(r0, r14)
            r0 = 15280(0x3bb0, float:2.1412E-41)
            java.lang.String r14 = "TENJO"
            r1.put(r0, r14)
            r0 = 15283(0x3bb3, float:2.1416E-41)
            java.lang.String r14 = "TIBACUY"
            r1.put(r0, r14)
            r0 = 15286(0x3bb6, float:2.142E-41)
            java.lang.String r14 = "TIBIRITA"
            r1.put(r0, r14)
            r0 = 15289(0x3bb9, float:2.1424E-41)
            java.lang.String r14 = "TOCAIMA"
            r1.put(r0, r14)
            r0 = 15292(0x3bbc, float:2.1429E-41)
            java.lang.String r14 = "TOCANCIPA"
            r1.put(r0, r14)
            r0 = 15295(0x3bbf, float:2.1433E-41)
            java.lang.String r14 = "TOPAIPI"
            r1.put(r0, r14)
            r0 = 15298(0x3bc2, float:2.1437E-41)
            java.lang.String r14 = "UBALA"
            r1.put(r0, r14)
            r0 = 15301(0x3bc5, float:2.1441E-41)
            java.lang.String r14 = "UBAQUE"
            r1.put(r0, r14)
            r0 = 15304(0x3bc8, float:2.1445E-41)
            java.lang.String r14 = "UBATE"
            r1.put(r0, r14)
            r0 = 15307(0x3bcb, float:2.145E-41)
            java.lang.String r14 = "UNE"
            r1.put(r0, r14)
            r0 = 15316(0x3bd4, float:2.1462E-41)
            java.lang.String r14 = "UTICA"
            r1.put(r0, r14)
            r0 = 15318(0x3bd6, float:2.1465E-41)
            java.lang.String r14 = "VENECIA"
            r1.put(r0, r14)
            r0 = 15319(0x3bd7, float:2.1466E-41)
            java.lang.String r14 = "VERGARA"
            r1.put(r0, r14)
            r0 = 15322(0x3bda, float:2.147E-41)
            java.lang.String r14 = "VIANI"
            r1.put(r0, r14)
            r0 = 15323(0x3bdb, float:2.1472E-41)
            java.lang.String r14 = "VILLAGOMEZ"
            r1.put(r0, r14)
            r0 = 15325(0x3bdd, float:2.1475E-41)
            java.lang.String r14 = "VILLAPINZON"
            r1.put(r0, r14)
            r0 = 15328(0x3be0, float:2.1479E-41)
            java.lang.String r14 = "VILLETA"
            r1.put(r0, r14)
            r0 = 15331(0x3be3, float:2.1483E-41)
            java.lang.String r14 = "VIOTA"
            r1.put(r0, r14)
            r0 = 15334(0x3be6, float:2.1488E-41)
            java.lang.String r14 = "YACOPI"
            r1.put(r0, r14)
            r0 = 15337(0x3be9, float:2.1492E-41)
            java.lang.String r14 = "ZIPACON"
            r1.put(r0, r14)
            r0 = 15340(0x3bec, float:2.1496E-41)
            java.lang.String r14 = "ZIPAQUIRA"
            r1.put(r0, r14)
            r0 = 16001(0x3e81, float:2.2422E-41)
            r1.put(r0, r8)
            r0 = 17001(0x4269, float:2.3823E-41)
            java.lang.String r8 = "QUIBDO"
            r1.put(r0, r8)
            r0 = 17002(0x426a, float:2.3825E-41)
            java.lang.String r8 = "ATRATO (YUTO)"
            r1.put(r0, r8)
            r0 = 17004(0x426c, float:2.3828E-41)
            java.lang.String r8 = "ACANDI"
            r1.put(r0, r8)
            r0 = 17006(0x426e, float:2.383E-41)
            java.lang.String r8 = "ALTO BAUDO (PIE DE PATO)"
            r1.put(r0, r8)
            r0 = 17007(0x426f, float:2.3832E-41)
            java.lang.String r8 = "BAGADO"
            r1.put(r0, r8)
            r0 = 17008(0x4270, float:2.3833E-41)
            java.lang.String r8 = "BAHIA SOLANO (MUTIS)"
            r1.put(r0, r8)
            r0 = 17010(0x4272, float:2.3836E-41)
            java.lang.String r8 = "BAJO BAUDO (PIZARRO)"
            r1.put(r0, r8)
            r0 = 17011(0x4273, float:2.3837E-41)
            java.lang.String r8 = "BOJAYA (BELLAVISTA)"
            r1.put(r0, r8)
            r0 = 17012(0x4274, float:2.3839E-41)
            java.lang.String r8 = "MEDIO ATRATO (BETE)"
            r1.put(r0, r8)
            r0 = 17013(0x4275, float:2.384E-41)
            java.lang.String r8 = "CONDOTO"
            r1.put(r0, r8)
            r0 = 17014(0x4276, float:2.3842E-41)
            java.lang.String r8 = "CERTEGUI"
            r1.put(r0, r8)
            r0 = 17015(0x4277, float:2.3843E-41)
            java.lang.String r8 = "CARMEN DEL DARIEN"
            r1.put(r0, r8)
            r0 = 17016(0x4278, float:2.3844E-41)
            java.lang.String r8 = "EL CARMEN"
            r1.put(r0, r8)
            r0 = 17017(0x4279, float:2.3846E-41)
            java.lang.String r14 = "EL CANTON DEL SAN PABLO (MAN."
            r1.put(r0, r14)
            r0 = 17019(0x427b, float:2.3849E-41)
            java.lang.String r14 = "ISTMINA"
            r1.put(r0, r14)
            r0 = 17022(0x427e, float:2.3853E-41)
            java.lang.String r14 = "JURADO"
            r1.put(r0, r14)
            r0 = 17025(0x4281, float:2.3857E-41)
            java.lang.String r14 = "LLORO"
            r1.put(r0, r14)
            r0 = 17026(0x4282, float:2.3859E-41)
            java.lang.String r14 = "MEDIO BAUDO (PUERTO MELUK)"
            r1.put(r0, r14)
            r0 = 17027(0x4283, float:2.386E-41)
            java.lang.String r14 = "MEDIO SAN JUAN"
            r1.put(r0, r14)
            r0 = 17028(0x4284, float:2.3861E-41)
            java.lang.String r14 = "NOVITA"
            r1.put(r0, r14)
            r0 = 17031(0x4287, float:2.3866E-41)
            java.lang.String r14 = "NUQUI"
            r1.put(r0, r14)
            r0 = 17032(0x4288, float:2.3867E-41)
            java.lang.String r14 = "RIO IRO"
            r1.put(r0, r14)
            r0 = 17034(0x428a, float:2.387E-41)
            java.lang.String r14 = "RIOSUCIO"
            r1.put(r0, r14)
            r0 = 17035(0x428b, float:2.3871E-41)
            java.lang.String r14 = "RIO QUITO (PAIMADO)"
            r1.put(r0, r14)
            r0 = 17037(0x428d, float:2.3874E-41)
            java.lang.String r14 = "SAN JOSE DEL PALMAR"
            r1.put(r0, r14)
            r0 = 17038(0x428e, float:2.3875E-41)
            java.lang.String r14 = "EL LITORAL DEL SAN JUAN"
            r1.put(r0, r14)
            r0 = 17040(0x4290, float:2.3878E-41)
            java.lang.String r14 = "SIPI"
            r1.put(r0, r14)
            r0 = 17043(0x4293, float:2.3882E-41)
            java.lang.String r14 = "TADO"
            r1.put(r0, r14)
            r0 = 17048(0x4298, float:2.389E-41)
            java.lang.String r14 = "UNGUIA"
            r1.put(r0, r14)
            r0 = 17060(0x42a4, float:2.3906E-41)
            java.lang.String r14 = "UNION PANAMERICANA (LAS ANIMAS"
            r1.put(r0, r14)
            r0 = 19001(0x4a39, float:2.6626E-41)
            java.lang.String r14 = "NEIVA"
            r1.put(r0, r14)
            r0 = 19004(0x4a3c, float:2.663E-41)
            java.lang.String r14 = "ACEVEDO"
            r1.put(r0, r14)
            r0 = 19007(0x4a3f, float:2.6634E-41)
            java.lang.String r14 = "AGRADO"
            r1.put(r0, r14)
            r0 = 19010(0x4a42, float:2.6639E-41)
            java.lang.String r14 = "AIPE"
            r1.put(r0, r14)
            r0 = 19013(0x4a45, float:2.6643E-41)
            java.lang.String r14 = "ALGECIRAS"
            r1.put(r0, r14)
            r0 = 19016(0x4a48, float:2.6647E-41)
            java.lang.String r14 = "ALTAMIRA"
            r1.put(r0, r14)
            r0 = 19019(0x4a4b, float:2.6651E-41)
            java.lang.String r14 = "BARAYA"
            r1.put(r0, r14)
            r0 = 19022(0x4a4e, float:2.6655E-41)
            java.lang.String r14 = "CAMPOALEGRE"
            r1.put(r0, r14)
            r0 = 19025(0x4a51, float:2.666E-41)
            java.lang.String r14 = "TESALIA (CARNICERIAS)"
            r1.put(r0, r14)
            r0 = 19028(0x4a54, float:2.6664E-41)
            java.lang.String r14 = "COLOMBIA"
            r1.put(r0, r14)
            r0 = 19031(0x4a57, float:2.6668E-41)
            java.lang.String r14 = "ELIAS"
            r1.put(r0, r14)
            r0 = 19034(0x4a5a, float:2.6672E-41)
            java.lang.String r14 = "GARZON"
            r1.put(r0, r14)
            r0 = 19037(0x4a5d, float:2.6677E-41)
            java.lang.String r14 = "GIGANTE"
            r1.put(r0, r14)
            r0 = 19040(0x4a60, float:2.6681E-41)
            r1.put(r0, r11)
            r0 = 19043(0x4a63, float:2.6685E-41)
            java.lang.String r14 = "HOBO"
            r1.put(r0, r14)
            r0 = 19044(0x4a64, float:2.6686E-41)
            java.lang.String r14 = "ISNOS"
            r1.put(r0, r14)
            r0 = 19046(0x4a66, float:2.6689E-41)
            java.lang.String r14 = "IQUIRA"
            r1.put(r0, r14)
            r0 = 19047(0x4a67, float:2.669E-41)
            java.lang.String r14 = "LA ARGENTINA (PLATA VIEJA)"
            r1.put(r0, r14)
            r0 = 19049(0x4a69, float:2.6693E-41)
            java.lang.String r14 = "LA PLATA"
            r1.put(r0, r14)
            r0 = 19050(0x4a6a, float:2.6695E-41)
            java.lang.String r14 = "NATAGA"
            r1.put(r0, r14)
            r0 = 19051(0x4a6b, float:2.6696E-41)
            java.lang.String r14 = "OPORAPA"
            r1.put(r0, r14)
            r0 = 19052(0x4a6c, float:2.6698E-41)
            java.lang.String r14 = "PAICOL"
            r1.put(r0, r14)
            r0 = 19055(0x4a6f, float:2.6702E-41)
            java.lang.String r14 = "PALERMO"
            r1.put(r0, r14)
            r0 = 19056(0x4a70, float:2.6703E-41)
            java.lang.String r14 = "PALESTINA"
            r1.put(r0, r14)
            r0 = 19058(0x4a72, float:2.6706E-41)
            java.lang.String r14 = "PITAL"
            r1.put(r0, r14)
            r0 = 19061(0x4a75, float:2.671E-41)
            java.lang.String r14 = "PITALITO"
            r1.put(r0, r14)
            r0 = 19064(0x4a78, float:2.6714E-41)
            java.lang.String r14 = "RIVERA"
            r1.put(r0, r14)
            r0 = 19067(0x4a7b, float:2.6719E-41)
            java.lang.String r14 = "SALADOBLANCO"
            r1.put(r0, r14)
            r0 = 19070(0x4a7e, float:2.6723E-41)
            java.lang.String r14 = "SAN AGUSTIN"
            r1.put(r0, r14)
            r0 = 19074(0x4a82, float:2.6728E-41)
            java.lang.String r14 = "SANTA MARIA"
            r1.put(r0, r14)
            r0 = 19076(0x4a84, float:2.6731E-41)
            java.lang.String r14 = "SUAZA"
            r1.put(r0, r14)
            r0 = 19079(0x4a87, float:2.6735E-41)
            java.lang.String r14 = "TARQUI"
            r1.put(r0, r14)
            r0 = 19082(0x4a8a, float:2.674E-41)
            java.lang.String r14 = "TELLO"
            r1.put(r0, r14)
            r0 = 19085(0x4a8d, float:2.6744E-41)
            java.lang.String r14 = "TERUEL"
            r1.put(r0, r14)
            r0 = 19088(0x4a90, float:2.6748E-41)
            java.lang.String r14 = "TIMANA"
            r1.put(r0, r14)
            r0 = 19091(0x4a93, float:2.6752E-41)
            java.lang.String r14 = "VILLAVIEJA"
            r1.put(r0, r14)
            r0 = 19094(0x4a96, float:2.6756E-41)
            java.lang.String r14 = "YAGUARA"
            r1.put(r0, r14)
            r0 = 21001(0x5209, float:2.9429E-41)
            java.lang.String r14 = "SANTA MARTA"
            r1.put(r0, r14)
            r0 = 21008(0x5210, float:2.9438E-41)
            java.lang.String r14 = "ALGARROBO"
            r1.put(r0, r14)
            r0 = 21010(0x5212, float:2.9441E-41)
            java.lang.String r14 = "ARACATACA"
            r1.put(r0, r14)
            r0 = 21012(0x5214, float:2.9444E-41)
            java.lang.String r14 = "ARIGUANI (EL DIFICIL)"
            r1.put(r0, r14)
            r0 = 21013(0x5215, float:2.9445E-41)
            java.lang.String r14 = "CERRO DE SAN ANTONIO"
            r1.put(r0, r14)
            r0 = 21015(0x5217, float:2.9448E-41)
            java.lang.String r14 = "CHIVOLO"
            r1.put(r0, r14)
            r0 = 21016(0x5218, float:2.945E-41)
            java.lang.String r14 = "CIENAGA"
            r1.put(r0, r14)
            r0 = 21020(0x521c, float:2.9455E-41)
            java.lang.String r14 = "CONCORDIA"
            r1.put(r0, r14)
            r0 = 21025(0x5221, float:2.9462E-41)
            java.lang.String r14 = "EL BANCO"
            r1.put(r0, r14)
            r0 = 21028(0x5224, float:2.9467E-41)
            java.lang.String r14 = "EL PI/ON"
            r1.put(r0, r14)
            r0 = 21030(0x5226, float:2.947E-41)
            java.lang.String r14 = "EL RETEN"
            r1.put(r0, r14)
            r0 = 21031(0x5227, float:2.9471E-41)
            java.lang.String r14 = "FUNDACION"
            r1.put(r0, r14)
            r0 = 21040(0x5230, float:2.9483E-41)
            java.lang.String r14 = "GUAMAL"
            r1.put(r0, r14)
            r0 = 21042(0x5232, float:2.9486E-41)
            java.lang.String r14 = "NUEVA GRANADA"
            r1.put(r0, r14)
            r0 = 21046(0x5236, float:2.9492E-41)
            java.lang.String r14 = "PEDRAZA"
            r1.put(r0, r14)
            r0 = 21048(0x5238, float:2.9495E-41)
            java.lang.String r14 = "PIJI/O DEL CARMEN"
            r1.put(r0, r14)
            r0 = 21049(0x5239, float:2.9496E-41)
            java.lang.String r14 = "PIVIJAY"
            r1.put(r0, r14)
            r0 = 21052(0x523c, float:2.95E-41)
            java.lang.String r14 = "PLATO"
            r1.put(r0, r14)
            r0 = 21055(0x523f, float:2.9504E-41)
            java.lang.String r14 = "PUEBLOVIEJO"
            r1.put(r0, r14)
            r0 = 21058(0x5242, float:2.9509E-41)
            java.lang.String r14 = "REMOLINO"
            r1.put(r0, r14)
            r0 = 21060(0x5244, float:2.9511E-41)
            java.lang.String r14 = "SABANAS DE SAN ANGEL"
            r1.put(r0, r14)
            r0 = 21067(0x524b, float:2.9521E-41)
            java.lang.String r14 = "SALAMINA"
            r1.put(r0, r14)
            r0 = 21070(0x524e, float:2.9525E-41)
            java.lang.String r14 = "SAN SEBASTIAN DE BUENAVISTA"
            r1.put(r0, r14)
            r0 = 21073(0x5251, float:2.953E-41)
            java.lang.String r14 = "SAN ZENON"
            r1.put(r0, r14)
            r0 = 21076(0x5254, float:2.9534E-41)
            java.lang.String r14 = "SANTA ANA"
            r1.put(r0, r14)
            r0 = 21078(0x5256, float:2.9537E-41)
            java.lang.String r14 = "SANTA BARBARA DE PINTO"
            r1.put(r0, r14)
            r0 = 21079(0x5257, float:2.9538E-41)
            java.lang.String r14 = "SITIONUEVO"
            r1.put(r0, r14)
            r0 = 21085(0x525d, float:2.9546E-41)
            java.lang.String r14 = "TENERIFE"
            r1.put(r0, r14)
            r0 = 21090(0x5262, float:2.9553E-41)
            java.lang.String r14 = "ZAPAYAN"
            r1.put(r0, r14)
            r0 = 21095(0x5267, float:2.956E-41)
            java.lang.String r14 = "ZONA BANANERA (SEVILLA)"
            r1.put(r0, r14)
            r0 = 23001(0x59d9, float:3.2231E-41)
            java.lang.String r14 = "PASTO"
            r1.put(r0, r14)
            r0 = 23004(0x59dc, float:3.2235E-41)
            java.lang.String r14 = "ALBAN (SAN JOSE)"
            r1.put(r0, r14)
            r0 = 23007(0x59df, float:3.224E-41)
            java.lang.String r14 = "ALDANA"
            r1.put(r0, r14)
            r0 = 23010(0x59e2, float:3.2244E-41)
            java.lang.String r14 = "ANCUYA"
            r1.put(r0, r14)
            r0 = 23013(0x59e5, float:3.2248E-41)
            java.lang.String r14 = "ARBOLEDA (BERRUECOS)"
            r1.put(r0, r14)
            r0 = 23016(0x59e8, float:3.2252E-41)
            java.lang.String r14 = "BARBACOAS"
            r1.put(r0, r14)
            r0 = 23017(0x59e9, float:3.2254E-41)
            java.lang.String r14 = "BELEN"
            r1.put(r0, r14)
            r0 = 23019(0x59eb, float:3.2256E-41)
            java.lang.String r14 = "BUESACO"
            r1.put(r0, r14)
            r0 = 23022(0x59ee, float:3.226E-41)
            java.lang.String r14 = "COLON (GENOVA)"
            r1.put(r0, r14)
            r0 = 23025(0x59f1, float:3.2265E-41)
            java.lang.String r14 = "CONSACA"
            r1.put(r0, r14)
            r0 = 23028(0x59f4, float:3.2269E-41)
            java.lang.String r14 = "CONTADERO"
            r1.put(r0, r14)
            r0 = 23031(0x59f7, float:3.2273E-41)
            r1.put(r0, r7)
            r0 = 23034(0x59fa, float:3.2278E-41)
            java.lang.String r14 = "CUASPUD (CARLOSAMA)"
            r1.put(r0, r14)
            r0 = 23037(0x59fd, float:3.2282E-41)
            java.lang.String r14 = "CUMBAL"
            r1.put(r0, r14)
            r0 = 23038(0x59fe, float:3.2283E-41)
            java.lang.String r14 = "CHACHAGUI"
            r1.put(r0, r14)
            r0 = 23039(0x59ff, float:3.2285E-41)
            java.lang.String r14 = "CUMBITARA"
            r1.put(r0, r14)
            r0 = 23040(0x5a00, float:3.2286E-41)
            java.lang.String r14 = "EL ROSARIO"
            r1.put(r0, r14)
            r0 = 23041(0x5a01, float:3.2287E-41)
            java.lang.String r14 = "EL CHARCO"
            r1.put(r0, r14)
            r0 = 23043(0x5a03, float:3.229E-41)
            java.lang.String r14 = "EL TABLON"
            r1.put(r0, r14)
            r0 = 23044(0x5a04, float:3.2292E-41)
            java.lang.String r14 = "EL PE/OL"
            r1.put(r0, r14)
            r0 = 23046(0x5a06, float:3.2294E-41)
            java.lang.String r14 = "EL TAMBO"
            r1.put(r0, r14)
            r0 = 23047(0x5a07, float:3.2296E-41)
            java.lang.String r14 = "FRANCISCO PIZARRO (SALAHONDA)"
            r1.put(r0, r14)
            r0 = 23049(0x5a09, float:3.2299E-41)
            java.lang.String r14 = "FUNES"
            r1.put(r0, r14)
            r0 = 23052(0x5a0c, float:3.2303E-41)
            java.lang.String r14 = "GUACHUCAL"
            r1.put(r0, r14)
            r0 = 23055(0x5a0f, float:3.2307E-41)
            java.lang.String r14 = "GUAITARILLA"
            r1.put(r0, r14)
            r0 = 23058(0x5a12, float:3.2311E-41)
            java.lang.String r14 = "GUALMATAN"
            r1.put(r0, r14)
            r0 = 23061(0x5a15, float:3.2315E-41)
            java.lang.String r14 = "ILES"
            r1.put(r0, r14)
            r0 = 23064(0x5a18, float:3.232E-41)
            java.lang.String r14 = "IMUES"
            r1.put(r0, r14)
            r0 = 23067(0x5a1b, float:3.2324E-41)
            java.lang.String r14 = "IPIALES"
            r1.put(r0, r14)
            r0 = 23073(0x5a21, float:3.2332E-41)
            java.lang.String r14 = "LA CRUZ"
            r1.put(r0, r14)
            r0 = 23076(0x5a24, float:3.2336E-41)
            java.lang.String r14 = "LA FLORIDA"
            r1.put(r0, r14)
            r0 = 23077(0x5a25, float:3.2338E-41)
            java.lang.String r14 = "LA LLANADA"
            r1.put(r0, r14)
            r0 = 23078(0x5a26, float:3.2339E-41)
            java.lang.String r14 = "LA TOLA"
            r1.put(r0, r14)
            r0 = 23079(0x5a27, float:3.234E-41)
            r1.put(r0, r12)
            r0 = 23080(0x5a28, float:3.2342E-41)
            java.lang.String r14 = "LEIVA"
            r1.put(r0, r14)
            r0 = 23082(0x5a2a, float:3.2345E-41)
            java.lang.String r14 = "LINARES"
            r1.put(r0, r14)
            r0 = 23085(0x5a2d, float:3.2349E-41)
            java.lang.String r14 = "LOS ANDES (SOTOMAYOR)"
            r1.put(r0, r14)
            r0 = 23088(0x5a30, float:3.2353E-41)
            java.lang.String r14 = "MAGUI (PAYAN)"
            r1.put(r0, r14)
            r0 = 23091(0x5a33, float:3.2357E-41)
            java.lang.String r14 = "MALLAMA (PIEDRANCHA)"
            r1.put(r0, r14)
            r0 = 23094(0x5a36, float:3.2362E-41)
            java.lang.String r14 = "MOSQUERA"
            r1.put(r0, r14)
            r0 = 23095(0x5a37, float:3.2363E-41)
            java.lang.String r14 = "OLAYA HERRERA"
            r1.put(r0, r14)
            r0 = 23096(0x5a38, float:3.2364E-41)
            r1.put(r0, r13)
            r0 = 23097(0x5a39, float:3.2366E-41)
            java.lang.String r13 = "OSPINA"
            r1.put(r0, r13)
            r0 = 23098(0x5a3a, float:3.2367E-41)
            java.lang.String r13 = "POLICARPA"
            r1.put(r0, r13)
            r0 = 23100(0x5a3c, float:3.237E-41)
            java.lang.String r13 = "POTOSI"
            r1.put(r0, r13)
            r0 = 23101(0x5a3d, float:3.2371E-41)
            java.lang.String r13 = "PROVIDENCIA"
            r1.put(r0, r13)
            r0 = 23103(0x5a3f, float:3.2374E-41)
            java.lang.String r13 = "PUERRES"
            r1.put(r0, r13)
            r0 = 23106(0x5a42, float:3.2378E-41)
            java.lang.String r13 = "PUPIALES"
            r1.put(r0, r13)
            r0 = 23109(0x5a45, float:3.2383E-41)
            java.lang.String r13 = "RICAURTE"
            r1.put(r0, r13)
            r0 = 23112(0x5a48, float:3.2387E-41)
            java.lang.String r13 = "ROBERTO PAYAN (SAN JOSE)"
            r1.put(r0, r13)
            r0 = 23115(0x5a4b, float:3.2391E-41)
            java.lang.String r13 = "SAMANIEGO"
            r1.put(r0, r13)
            r0 = 23118(0x5a4e, float:3.2395E-41)
            java.lang.String r13 = "SANDONA"
            r1.put(r0, r13)
            r0 = 23120(0x5a50, float:3.2398E-41)
            java.lang.String r13 = "SAN BERNARDO"
            r1.put(r0, r13)
            r0 = 23121(0x5a51, float:3.24E-41)
            java.lang.String r13 = "SAN LORENZO"
            r1.put(r0, r13)
            r0 = 23123(0x5a53, float:3.2402E-41)
            java.lang.String r13 = "SAN PEDRO DE CARTAGO"
            r1.put(r0, r13)
            r0 = 23124(0x5a54, float:3.2404E-41)
            java.lang.String r13 = "SAN PABLO"
            r1.put(r0, r13)
            r0 = 23125(0x5a55, float:3.2405E-41)
            java.lang.String r13 = "SANTA BARBARA (ISCUANDE)"
            r1.put(r0, r13)
            r0 = 23127(0x5a57, float:3.2408E-41)
            java.lang.String r13 = "SANTACRUZ (GUACHAVES)"
            r1.put(r0, r13)
            r0 = 23130(0x5a5a, float:3.2412E-41)
            java.lang.String r13 = "SAPUYES"
            r1.put(r0, r13)
            r0 = 23133(0x5a5d, float:3.2416E-41)
            java.lang.String r13 = "TAMINANGO"
            r1.put(r0, r13)
            r0 = 23136(0x5a60, float:3.242E-41)
            java.lang.String r13 = "TANGUA"
            r1.put(r0, r13)
            r0 = 23139(0x5a63, float:3.2425E-41)
            java.lang.String r13 = "TUMACO"
            r1.put(r0, r13)
            r0 = 23142(0x5a66, float:3.2429E-41)
            java.lang.String r13 = "TUQUERRES"
            r1.put(r0, r13)
            r0 = 23145(0x5a69, float:3.2433E-41)
            java.lang.String r13 = "YACUANQUER"
            r1.put(r0, r13)
            r0 = 24001(0x5dc1, float:3.3633E-41)
            java.lang.String r13 = "PEREIRA"
            r1.put(r0, r13)
            r0 = 24008(0x5dc8, float:3.3642E-41)
            java.lang.String r13 = "APIA"
            r1.put(r0, r13)
            r0 = 24013(0x5dcd, float:3.365E-41)
            java.lang.String r13 = "BALBOA"
            r1.put(r0, r13)
            r0 = 24021(0x5dd5, float:3.366E-41)
            java.lang.String r13 = "BELEN DE UMBRIA"
            r1.put(r0, r13)
            r0 = 24025(0x5dd9, float:3.3666E-41)
            java.lang.String r13 = "DOSQUEBRADAS"
            r1.put(r0, r13)
            r0 = 24029(0x5ddd, float:3.3672E-41)
            java.lang.String r13 = "GUATICA"
            r1.put(r0, r13)
            r0 = 24038(0x5de6, float:3.3684E-41)
            java.lang.String r13 = "LA CELIA"
            r1.put(r0, r13)
            r0 = 24046(0x5dee, float:3.3696E-41)
            java.lang.String r13 = "LA VIRGINIA"
            r1.put(r0, r13)
            r0 = 24054(0x5df6, float:3.3707E-41)
            java.lang.String r13 = "MARSELLA"
            r1.put(r0, r13)
            r0 = 24062(0x5dfe, float:3.3718E-41)
            java.lang.String r13 = "MISTRATO"
            r1.put(r0, r13)
            r0 = 24070(0x5e06, float:3.3729E-41)
            java.lang.String r13 = "PUEBLO RICO"
            r1.put(r0, r13)
            r0 = 24078(0x5e0e, float:3.374E-41)
            java.lang.String r13 = "QUINCHIA"
            r1.put(r0, r13)
            r0 = 24086(0x5e16, float:3.3752E-41)
            java.lang.String r13 = "SANTA ROSA DE CABAL"
            r1.put(r0, r13)
            r0 = 24094(0x5e1e, float:3.3763E-41)
            java.lang.String r13 = "SANTUARIO"
            r1.put(r0, r13)
            r0 = 25001(0x61a9, float:3.5034E-41)
            java.lang.String r13 = "CUCUTA"
            r1.put(r0, r13)
            r0 = 25004(0x61ac, float:3.5038E-41)
            java.lang.String r13 = "ABREGO"
            r1.put(r0, r13)
            r0 = 25007(0x61af, float:3.5042E-41)
            java.lang.String r13 = "ARBOLEDAS"
            r1.put(r0, r13)
            r0 = 25010(0x61b2, float:3.5046E-41)
            java.lang.String r13 = "BOCHALEMA"
            r1.put(r0, r13)
            r0 = 25013(0x61b5, float:3.505E-41)
            java.lang.String r13 = "BUCARASICA"
            r1.put(r0, r13)
            r0 = 25016(0x61b8, float:3.5055E-41)
            java.lang.String r13 = "CACOTA"
            r1.put(r0, r13)
            r0 = 25019(0x61bb, float:3.5059E-41)
            java.lang.String r13 = "CACHIRA"
            r1.put(r0, r13)
            r0 = 25022(0x61be, float:3.5063E-41)
            java.lang.String r13 = "CONVENCION"
            r1.put(r0, r13)
            r0 = 25025(0x61c1, float:3.5067E-41)
            java.lang.String r13 = "CUCUTILLA"
            r1.put(r0, r13)
            r0 = 25028(0x61c4, float:3.5072E-41)
            java.lang.String r13 = "CHINACOTA"
            r1.put(r0, r13)
            r0 = 25031(0x61c7, float:3.5076E-41)
            java.lang.String r13 = "CHITAGA"
            r1.put(r0, r13)
            r0 = 25034(0x61ca, float:3.508E-41)
            java.lang.String r13 = "DURANIA"
            r1.put(r0, r13)
            r0 = 25036(0x61cc, float:3.5083E-41)
            java.lang.String r13 = "EL TARRA"
            r1.put(r0, r13)
            r0 = 25037(0x61cd, float:3.5084E-41)
            r1.put(r0, r8)
            r0 = 25038(0x61ce, float:3.5086E-41)
            java.lang.String r13 = "EL ZULIA"
            r1.put(r0, r13)
            r0 = 25040(0x61d0, float:3.5089E-41)
            java.lang.String r13 = "GRAMALOTE"
            r1.put(r0, r13)
            r0 = 25043(0x61d3, float:3.5093E-41)
            java.lang.String r13 = "HACARI"
            r1.put(r0, r13)
            r0 = 25046(0x61d6, float:3.5097E-41)
            java.lang.String r13 = "HERRAN"
            r1.put(r0, r13)
            r0 = 25049(0x61d9, float:3.5101E-41)
            java.lang.String r13 = "LABATECA"
            r1.put(r0, r13)
            r0 = 25051(0x61db, float:3.5104E-41)
            java.lang.String r13 = "LA ESPERANZA"
            r1.put(r0, r13)
            r0 = 25052(0x61dc, float:3.5105E-41)
            java.lang.String r13 = "LA PLAYA"
            r1.put(r0, r13)
            r0 = 25054(0x61de, float:3.5108E-41)
            java.lang.String r13 = "LOS PATIOS"
            r1.put(r0, r13)
            r0 = 25055(0x61df, float:3.511E-41)
            java.lang.String r13 = "LOURDES"
            r1.put(r0, r13)
            r0 = 25058(0x61e2, float:3.5114E-41)
            java.lang.String r13 = "MUTISCUA"
            r1.put(r0, r13)
            r0 = 25061(0x61e5, float:3.5118E-41)
            java.lang.String r13 = "OCA/A"
            r1.put(r0, r13)
            r0 = 25064(0x61e8, float:3.5122E-41)
            java.lang.String r13 = "PAMPLONA"
            r1.put(r0, r13)
            r0 = 25067(0x61eb, float:3.5126E-41)
            java.lang.String r13 = "PAMPLONITA"
            r1.put(r0, r13)
            r0 = 25069(0x61ed, float:3.5129E-41)
            java.lang.String r13 = "PUERTO SANTANDER"
            r1.put(r0, r13)
            r0 = 25070(0x61ee, float:3.513E-41)
            java.lang.String r13 = "RAGONVALIA"
            r1.put(r0, r13)
            r0 = 25073(0x61f1, float:3.5135E-41)
            java.lang.String r13 = "SALAZAR"
            r1.put(r0, r13)
            r0 = 25076(0x61f4, float:3.5139E-41)
            java.lang.String r13 = "SAN CALIXTO"
            r1.put(r0, r13)
            r0 = 25079(0x61f7, float:3.5143E-41)
            java.lang.String r13 = "SAN CAYETANO"
            r1.put(r0, r13)
            r0 = 25082(0x61fa, float:3.5147E-41)
            java.lang.String r13 = "SANTIAGO"
            r1.put(r0, r13)
            r0 = 25085(0x61fd, float:3.5152E-41)
            java.lang.String r13 = "SARDINATA"
            r1.put(r0, r13)
            r0 = 25088(0x6200, float:3.5156E-41)
            java.lang.String r13 = "SILOS"
            r1.put(r0, r13)
            r0 = 25091(0x6203, float:3.516E-41)
            java.lang.String r13 = "TEORAMA"
            r1.put(r0, r13)
            r0 = 25093(0x6205, float:3.5163E-41)
            java.lang.String r13 = "TIBU"
            r1.put(r0, r13)
            r0 = 25094(0x6206, float:3.5164E-41)
            java.lang.String r13 = "TOLEDO"
            r1.put(r0, r13)
            r0 = 25097(0x6209, float:3.5168E-41)
            java.lang.String r13 = "VILLA CARO"
            r1.put(r0, r13)
            r0 = 25100(0x620c, float:3.5173E-41)
            java.lang.String r13 = "VILLA DEL ROSARIO"
            r1.put(r0, r13)
            r0 = 26001(0x6591, float:3.6435E-41)
            java.lang.String r13 = "ARMENIA"
            r1.put(r0, r13)
            r0 = 26005(0x6595, float:3.6441E-41)
            r1.put(r0, r5)
            r0 = 26010(0x659a, float:3.6448E-41)
            java.lang.String r13 = "CALARCA"
            r1.put(r0, r13)
            r0 = 26020(0x65a4, float:3.6462E-41)
            java.lang.String r13 = "CIRCASIA"
            r1.put(r0, r13)
            r0 = 26025(0x65a9, float:3.6469E-41)
            r1.put(r0, r7)
            r0 = 26030(0x65ae, float:3.6476E-41)
            java.lang.String r7 = "FILANDIA"
            r1.put(r0, r7)
            r0 = 26040(0x65b8, float:3.649E-41)
            java.lang.String r7 = "GENOVA"
            r1.put(r0, r7)
            r0 = 26050(0x65c2, float:3.6504E-41)
            java.lang.String r7 = "LA TEBAIDA"
            r1.put(r0, r7)
            r0 = 26060(0x65cc, float:3.6518E-41)
            java.lang.String r7 = "MONTENEGRO"
            r1.put(r0, r7)
            r0 = 26070(0x65d6, float:3.6532E-41)
            java.lang.String r7 = "PIJAO"
            r1.put(r0, r7)
            r0 = 26080(0x65e0, float:3.6546E-41)
            java.lang.String r7 = "QUIMBAYA"
            r1.put(r0, r7)
            r0 = 26090(0x65ea, float:3.656E-41)
            java.lang.String r7 = "SALENTO"
            r1.put(r0, r7)
            r0 = 27001(0x6979, float:3.7836E-41)
            java.lang.String r7 = "BUCARAMANGA"
            r1.put(r0, r7)
            r0 = 27004(0x697c, float:3.784E-41)
            java.lang.String r7 = "AGUADA"
            r1.put(r0, r7)
            r0 = 27007(0x697f, float:3.7845E-41)
            java.lang.String r7 = "ALBANIA"
            r1.put(r0, r7)
            r0 = 27010(0x6982, float:3.7849E-41)
            java.lang.String r13 = "ARATOCA"
            r1.put(r0, r13)
            r0 = 27013(0x6985, float:3.7853E-41)
            java.lang.String r13 = "BARBOSA"
            r1.put(r0, r13)
            r0 = 27016(0x6988, float:3.7857E-41)
            java.lang.String r13 = "BARICHARA"
            r1.put(r0, r13)
            r0 = 27019(0x698b, float:3.7862E-41)
            java.lang.String r13 = "BARRANCABERMEJA"
            r1.put(r0, r13)
            r0 = 27022(0x698e, float:3.7866E-41)
            java.lang.String r13 = "BETULIA"
            r1.put(r0, r13)
            r0 = 27025(0x6991, float:3.787E-41)
            r1.put(r0, r4)
            r0 = 27028(0x6994, float:3.7874E-41)
            java.lang.String r13 = "CABRERA"
            r1.put(r0, r13)
            r0 = 27031(0x6997, float:3.7878E-41)
            java.lang.String r13 = "CALIFORNIA"
            r1.put(r0, r13)
            r0 = 27034(0x699a, float:3.7883E-41)
            java.lang.String r13 = "CAPITANEJO"
            r1.put(r0, r13)
            r0 = 27037(0x699d, float:3.7887E-41)
            java.lang.String r13 = "CARCASI"
            r1.put(r0, r13)
            r0 = 27040(0x69a0, float:3.7891E-41)
            java.lang.String r13 = "CEPITA"
            r1.put(r0, r13)
            r0 = 27043(0x69a3, float:3.7895E-41)
            java.lang.String r13 = "CERRITO"
            r1.put(r0, r13)
            r0 = 27045(0x69a5, float:3.7898E-41)
            java.lang.String r13 = "CIMITARRA"
            r1.put(r0, r13)
            r0 = 27046(0x69a6, float:3.79E-41)
            java.lang.String r13 = "CONCEPCION"
            r1.put(r0, r13)
            r0 = 27049(0x69a9, float:3.7904E-41)
            java.lang.String r13 = "CONFINES"
            r1.put(r0, r13)
            r0 = 27052(0x69ac, float:3.7908E-41)
            java.lang.String r13 = "CONTRATACION"
            r1.put(r0, r13)
            r0 = 27055(0x69af, float:3.7912E-41)
            java.lang.String r13 = "COROMORO"
            r1.put(r0, r13)
            r0 = 27058(0x69b2, float:3.7916E-41)
            java.lang.String r13 = "CURITI"
            r1.put(r0, r13)
            r0 = 27061(0x69b5, float:3.792E-41)
            java.lang.String r13 = "CHARALA"
            r1.put(r0, r13)
            r0 = 27064(0x69b8, float:3.7925E-41)
            java.lang.String r13 = "CHARTA"
            r1.put(r0, r13)
            r0 = 27067(0x69bb, float:3.7929E-41)
            java.lang.String r13 = "CHIMA"
            r1.put(r0, r13)
            r0 = 27070(0x69be, float:3.7933E-41)
            java.lang.String r13 = "CHIPATA"
            r1.put(r0, r13)
            r0 = 27071(0x69bf, float:3.7935E-41)
            r1.put(r0, r8)
            r0 = 27073(0x69c1, float:3.7937E-41)
            java.lang.String r8 = "EL GUACAMAYO"
            r1.put(r0, r8)
            r0 = 27074(0x69c2, float:3.7939E-41)
            java.lang.String r8 = "EL PLAYON"
            r1.put(r0, r8)
            r0 = 27075(0x69c3, float:3.794E-41)
            r1.put(r0, r10)
            r0 = 27076(0x69c4, float:3.7942E-41)
            java.lang.String r8 = "ENCINO"
            r1.put(r0, r8)
            r0 = 27079(0x69c7, float:3.7946E-41)
            java.lang.String r8 = "ENCISO"
            r1.put(r0, r8)
            r0 = 27080(0x69c8, float:3.7947E-41)
            java.lang.String r8 = "FLORIAN"
            r1.put(r0, r8)
            r0 = 27082(0x69ca, float:3.795E-41)
            java.lang.String r8 = "FLORIDABLANCA"
            r1.put(r0, r8)
            r0 = 27085(0x69cd, float:3.7954E-41)
            java.lang.String r8 = "GALAN"
            r1.put(r0, r8)
            r0 = 27088(0x69d0, float:3.7958E-41)
            java.lang.String r8 = "GAMBITA"
            r1.put(r0, r8)
            r0 = 27091(0x69d3, float:3.7963E-41)
            java.lang.String r8 = "GIRON"
            r1.put(r0, r8)
            r0 = 27094(0x69d6, float:3.7967E-41)
            java.lang.String r8 = "GUACA"
            r1.put(r0, r8)
            r0 = 27097(0x69d9, float:3.7971E-41)
            r1.put(r0, r11)
            r0 = 27100(0x69dc, float:3.7975E-41)
            java.lang.String r8 = "GUAPOTA"
            r1.put(r0, r8)
            r0 = 27103(0x69df, float:3.798E-41)
            java.lang.String r8 = "GUAVATA"
            r1.put(r0, r8)
            r0 = 27106(0x69e2, float:3.7984E-41)
            java.lang.String r8 = "GUEPSA"
            r1.put(r0, r8)
            r0 = 27109(0x69e5, float:3.7988E-41)
            java.lang.String r8 = "HATO"
            r1.put(r0, r8)
            r0 = 27112(0x69e8, float:3.7992E-41)
            java.lang.String r8 = "JESUS MARIA"
            r1.put(r0, r8)
            r0 = 27115(0x69eb, float:3.7996E-41)
            java.lang.String r8 = "JORDAN"
            r1.put(r0, r8)
            r0 = 27118(0x69ee, float:3.8E-41)
            java.lang.String r8 = "LA PAZ"
            r1.put(r0, r8)
            r0 = 27119(0x69ef, float:3.8002E-41)
            java.lang.String r8 = "LA BELLEZA"
            r1.put(r0, r8)
            r0 = 27120(0x69f0, float:3.8003E-41)
            java.lang.String r8 = "LANDAZURI"
            r1.put(r0, r8)
            r0 = 27121(0x69f1, float:3.8005E-41)
            java.lang.String r8 = "LEBRIJA"
            r1.put(r0, r8)
            r0 = 27124(0x69f4, float:3.8009E-41)
            java.lang.String r8 = "LOS SANTOS"
            r1.put(r0, r8)
            r0 = 27127(0x69f7, float:3.8013E-41)
            java.lang.String r8 = "MACARAVITA"
            r1.put(r0, r8)
            r0 = 27130(0x69fa, float:3.8017E-41)
            java.lang.String r8 = "MALAGA"
            r1.put(r0, r8)
            r0 = 27133(0x69fd, float:3.8021E-41)
            java.lang.String r8 = "MATANZA"
            r1.put(r0, r8)
            r0 = 27136(0x6a00, float:3.8026E-41)
            java.lang.String r8 = "MOGOTES"
            r1.put(r0, r8)
            r0 = 27139(0x6a03, float:3.803E-41)
            java.lang.String r8 = "MOLAGAVITA"
            r1.put(r0, r8)
            r0 = 27142(0x6a06, float:3.8034E-41)
            java.lang.String r8 = "OCAMONTE"
            r1.put(r0, r8)
            r0 = 27145(0x6a09, float:3.8038E-41)
            java.lang.String r8 = "OIBA"
            r1.put(r0, r8)
            r0 = 27148(0x6a0c, float:3.8042E-41)
            java.lang.String r8 = "ONZAGA"
            r1.put(r0, r8)
            r0 = 27151(0x6a0f, float:3.8047E-41)
            java.lang.String r8 = "PALMAR"
            r1.put(r0, r8)
            r0 = 27154(0x6a12, float:3.8051E-41)
            java.lang.String r8 = "PALMAS DEL SOCORRO"
            r1.put(r0, r8)
            r0 = 27157(0x6a15, float:3.8055E-41)
            java.lang.String r8 = "PARAMO"
            r1.put(r0, r8)
            r0 = 27160(0x6a18, float:3.8059E-41)
            java.lang.String r8 = "PIEDECUESTA"
            r1.put(r0, r8)
            r0 = 27163(0x6a1b, float:3.8063E-41)
            java.lang.String r8 = "PINCHOTE"
            r1.put(r0, r8)
            r0 = 27166(0x6a1e, float:3.8068E-41)
            java.lang.String r8 = "PUENTE NACIONAL"
            r1.put(r0, r8)
            r0 = 27167(0x6a1f, float:3.8069E-41)
            java.lang.String r8 = "PUERTO PARRA"
            r1.put(r0, r8)
            r0 = 27169(0x6a21, float:3.8072E-41)
            java.lang.String r8 = "PUERTO WILCHES"
            r1.put(r0, r8)
            r0 = 27172(0x6a24, float:3.8076E-41)
            java.lang.String r8 = "RIONEGRO"
            r1.put(r0, r8)
            r0 = 27174(0x6a26, float:3.8079E-41)
            java.lang.String r8 = "SABANA DE TORRES"
            r1.put(r0, r8)
            r0 = 27175(0x6a27, float:3.808E-41)
            r8 = r16
            r1.put(r0, r8)
            r0 = 27178(0x6a2a, float:3.8084E-41)
            java.lang.String r10 = "SAN BENITO"
            r1.put(r0, r10)
            r0 = 27181(0x6a2d, float:3.8089E-41)
            java.lang.String r10 = "SAN GIL"
            r1.put(r0, r10)
            r0 = 27184(0x6a30, float:3.8093E-41)
            java.lang.String r10 = "SAN JOAQUIN"
            r1.put(r0, r10)
            r0 = 27187(0x6a33, float:3.8097E-41)
            java.lang.String r10 = "SAN JOSE DE MIRANDA"
            r1.put(r0, r10)
            r0 = 27190(0x6a36, float:3.8101E-41)
            java.lang.String r10 = "SAN MIGUEL"
            r1.put(r0, r10)
            r0 = 27193(0x6a39, float:3.8106E-41)
            java.lang.String r10 = "SAN VICENTE DE CHUCURI"
            r1.put(r0, r10)
            r0 = 27194(0x6a3a, float:3.8107E-41)
            java.lang.String r10 = "SANTA HELENA DEL OPON"
            r1.put(r0, r10)
            r0 = 27195(0x6a3b, float:3.8108E-41)
            java.lang.String r10 = "SANTA BARBARA"
            r1.put(r0, r10)
            r0 = 27196(0x6a3c, float:3.811E-41)
            java.lang.String r10 = "SIMACOTA"
            r1.put(r0, r10)
            r0 = 27199(0x6a3f, float:3.8114E-41)
            java.lang.String r10 = "SOCORRO"
            r1.put(r0, r10)
            r0 = 27202(0x6a42, float:3.8118E-41)
            java.lang.String r10 = "SUAITA"
            r1.put(r0, r10)
            r0 = 27205(0x6a45, float:3.8122E-41)
            r1.put(r0, r9)
            r0 = 27208(0x6a48, float:3.8127E-41)
            java.lang.String r10 = "SURATA"
            r1.put(r0, r10)
            r0 = 27211(0x6a4b, float:3.8131E-41)
            java.lang.String r10 = "TONA"
            r1.put(r0, r10)
            r0 = 27217(0x6a51, float:3.8139E-41)
            java.lang.String r10 = "VALLE DE SAN JOSE"
            r1.put(r0, r10)
            r0 = 27219(0x6a53, float:3.8142E-41)
            java.lang.String r10 = "VETAS"
            r1.put(r0, r10)
            r0 = 27220(0x6a54, float:3.8143E-41)
            java.lang.String r10 = "VELEZ"
            r1.put(r0, r10)
            r0 = 27221(0x6a55, float:3.8145E-41)
            r10 = r19
            r1.put(r0, r10)
            r0 = 27223(0x6a57, float:3.8148E-41)
            java.lang.String r11 = "ZAPATOCA"
            r1.put(r0, r11)
            r0 = 28001(0x6d61, float:3.9238E-41)
            java.lang.String r11 = "SINCELEJO"
            r1.put(r0, r11)
            r0 = 28010(0x6d6a, float:3.925E-41)
            r1.put(r0, r5)
            r0 = 28020(0x6d74, float:3.9264E-41)
            java.lang.String r5 = "CAIMITO"
            r1.put(r0, r5)
            r0 = 28030(0x6d7e, float:3.9278E-41)
            java.lang.String r5 = "COLOSO (RICAURTE)"
            r1.put(r0, r5)
            r0 = 28040(0x6d88, float:3.9292E-41)
            java.lang.String r5 = "COROZAL"
            r1.put(r0, r5)
            r0 = 28041(0x6d89, float:3.9294E-41)
            java.lang.String r5 = "COVE/AS"
            r1.put(r0, r5)
            r0 = 28042(0x6d8a, float:3.9295E-41)
            java.lang.String r5 = "EL ROBLE"
            r1.put(r0, r5)
            r0 = 28045(0x6d8d, float:3.93E-41)
            java.lang.String r5 = "CHALAN"
            r1.put(r0, r5)
            r0 = 28048(0x6d90, float:3.9304E-41)
            java.lang.String r5 = "GALERAS (NUEVA GRANADA)"
            r1.put(r0, r5)
            r0 = 28049(0x6d91, float:3.9305E-41)
            java.lang.String r5 = "GUARANDA"
            r1.put(r0, r5)
            r0 = 28050(0x6d92, float:3.9306E-41)
            r1.put(r0, r12)
            r0 = 28055(0x6d97, float:3.9313E-41)
            java.lang.String r5 = "LOS PALMITOS"
            r1.put(r0, r5)
            r0 = 28060(0x6d9c, float:3.932E-41)
            java.lang.String r5 = "MAJAGUAL"
            r1.put(r0, r5)
            r0 = 28080(0x6db0, float:3.9348E-41)
            java.lang.String r5 = "MORROA"
            r1.put(r0, r5)
            r0 = 28100(0x6dc4, float:3.9376E-41)
            java.lang.String r5 = "OVEJAS"
            r1.put(r0, r5)
            r0 = 28120(0x6dd8, float:3.9405E-41)
            java.lang.String r5 = "PALMITO"
            r1.put(r0, r5)
            r0 = 28160(0x6e00, float:3.946E-41)
            java.lang.String r5 = "SAMPUES"
            r1.put(r0, r5)
            r0 = 28180(0x6e14, float:3.9489E-41)
            java.lang.String r5 = "SAN BENITO ABAD"
            r1.put(r0, r5)
            r0 = 28190(0x6e1e, float:3.9503E-41)
            java.lang.String r5 = "SAN JUAN DE BETULIA (BETULIA)"
            r1.put(r0, r5)
            r0 = 28200(0x6e28, float:3.9517E-41)
            java.lang.String r5 = "SAN MARCOS"
            r1.put(r0, r5)
            r0 = 28220(0x6e3c, float:3.9545E-41)
            java.lang.String r5 = "SAN ONOFRE"
            r1.put(r0, r5)
            r0 = 28240(0x6e50, float:3.9573E-41)
            r5 = r17
            r1.put(r0, r5)
            r0 = 28260(0x6e64, float:3.96E-41)
            java.lang.String r11 = "SINCE"
            r1.put(r0, r11)
            r0 = 28280(0x6e78, float:3.9629E-41)
            r1.put(r0, r9)
            r0 = 28300(0x6e8c, float:3.9657E-41)
            java.lang.String r9 = "TOLU"
            r1.put(r0, r9)
            r0 = 28320(0x6ea0, float:3.9685E-41)
            java.lang.String r9 = "TOLUVIEJO"
            r1.put(r0, r9)
            r0 = 29001(0x7149, float:4.0639E-41)
            java.lang.String r9 = "IBAGUE"
            r1.put(r0, r9)
            r0 = 29004(0x714c, float:4.0643E-41)
            java.lang.String r9 = "ALPUJARRA"
            r1.put(r0, r9)
            r0 = 29007(0x714f, float:4.0647E-41)
            java.lang.String r9 = "ALVARADO"
            r1.put(r0, r9)
            r0 = 29010(0x7152, float:4.0652E-41)
            java.lang.String r9 = "AMBALEMA"
            r1.put(r0, r9)
            r0 = 29013(0x7155, float:4.0656E-41)
            java.lang.String r9 = "ANZOATEGUI"
            r1.put(r0, r9)
            r0 = 29016(0x7158, float:4.066E-41)
            java.lang.String r9 = "ARMERO (GUAYABAL)"
            r1.put(r0, r9)
            r0 = 29019(0x715b, float:4.0664E-41)
            java.lang.String r9 = "ATACO"
            r1.put(r0, r9)
            r0 = 29022(0x715e, float:4.0668E-41)
            java.lang.String r9 = "CAJAMARCA"
            r1.put(r0, r9)
            r0 = 29025(0x7161, float:4.0673E-41)
            java.lang.String r9 = "CARMEN DE APICALA"
            r1.put(r0, r9)
            r0 = 29028(0x7164, float:4.0677E-41)
            java.lang.String r9 = "CASABIANCA"
            r1.put(r0, r9)
            r0 = 29031(0x7167, float:4.0681E-41)
            java.lang.String r9 = "COELLO"
            r1.put(r0, r9)
            r0 = 29034(0x716a, float:4.0685E-41)
            java.lang.String r9 = "COYAIMA"
            r1.put(r0, r9)
            r0 = 29037(0x716d, float:4.069E-41)
            java.lang.String r9 = "CUNDAY"
            r1.put(r0, r9)
            r0 = 29040(0x7170, float:4.0694E-41)
            java.lang.String r9 = "CHAPARRAL"
            r1.put(r0, r9)
            r0 = 29043(0x7173, float:4.0698E-41)
            java.lang.String r9 = "DOLORES"
            r1.put(r0, r9)
            r0 = 29046(0x7176, float:4.0702E-41)
            java.lang.String r9 = "ESPINAL"
            r1.put(r0, r9)
            r0 = 29049(0x7179, float:4.0706E-41)
            java.lang.String r9 = "FALAN"
            r1.put(r0, r9)
            r0 = 29052(0x717c, float:4.071E-41)
            java.lang.String r9 = "FLANDES"
            r1.put(r0, r9)
            r0 = 29055(0x717f, float:4.0715E-41)
            java.lang.String r9 = "FRESNO"
            r1.put(r0, r9)
            r0 = 29058(0x7182, float:4.0719E-41)
            java.lang.String r9 = "GUAMO"
            r1.put(r0, r9)
            r0 = 29061(0x7185, float:4.0723E-41)
            java.lang.String r9 = "HERVEO"
            r1.put(r0, r9)
            r0 = 29064(0x7188, float:4.0727E-41)
            java.lang.String r9 = "HONDA"
            r1.put(r0, r9)
            r0 = 29067(0x718b, float:4.0732E-41)
            java.lang.String r9 = "ICONONZO"
            r1.put(r0, r9)
            r0 = 29070(0x718e, float:4.0736E-41)
            java.lang.String r9 = "LERIDA"
            r1.put(r0, r9)
            r0 = 29073(0x7191, float:4.074E-41)
            java.lang.String r9 = "LIBANO"
            r1.put(r0, r9)
            r0 = 29076(0x7194, float:4.0744E-41)
            java.lang.String r9 = "MARIQUITA"
            r1.put(r0, r9)
            r0 = 29079(0x7197, float:4.0748E-41)
            java.lang.String r9 = "MELGAR"
            r1.put(r0, r9)
            r0 = 29080(0x7198, float:4.075E-41)
            java.lang.String r9 = "MURILLO"
            r1.put(r0, r9)
            r0 = 29082(0x719a, float:4.0753E-41)
            java.lang.String r9 = "NATAGAIMA"
            r1.put(r0, r9)
            r0 = 29085(0x719d, float:4.0757E-41)
            java.lang.String r9 = "ORTEGA"
            r1.put(r0, r9)
            r0 = 29087(0x719f, float:4.076E-41)
            java.lang.String r9 = "PALOCABILDO"
            r1.put(r0, r9)
            r0 = 29088(0x71a0, float:4.0761E-41)
            java.lang.String r9 = "PIEDRAS"
            r1.put(r0, r9)
            r0 = 29089(0x71a1, float:4.0762E-41)
            java.lang.String r9 = "PLANADAS"
            r1.put(r0, r9)
            r0 = 29091(0x71a3, float:4.0765E-41)
            java.lang.String r9 = "PRADO"
            r1.put(r0, r9)
            r0 = 29094(0x71a6, float:4.077E-41)
            java.lang.String r9 = "PURIFICACION"
            r1.put(r0, r9)
            r0 = 29097(0x71a9, float:4.0774E-41)
            java.lang.String r9 = "RIOBLANCO"
            r1.put(r0, r9)
            r0 = 29100(0x71ac, float:4.0778E-41)
            java.lang.String r9 = "RONCESVALLES"
            r1.put(r0, r9)
            r0 = 29103(0x71af, float:4.0782E-41)
            java.lang.String r9 = "ROVIRA"
            r1.put(r0, r9)
            r0 = 29105(0x71b1, float:4.0785E-41)
            java.lang.String r9 = "SALDA/A"
            r1.put(r0, r9)
            r0 = 29106(0x71b2, float:4.0786E-41)
            java.lang.String r9 = "SAN ANTONIO"
            r1.put(r0, r9)
            r0 = 29109(0x71b5, float:4.079E-41)
            java.lang.String r9 = "SAN LUIS"
            r1.put(r0, r9)
            r0 = 29112(0x71b8, float:4.0795E-41)
            java.lang.String r9 = "SANTA ISABEL"
            r1.put(r0, r9)
            r0 = 29115(0x71bb, float:4.0799E-41)
            java.lang.String r9 = "SUAREZ"
            r1.put(r0, r9)
            r0 = 29118(0x71be, float:4.0803E-41)
            java.lang.String r9 = "VALLE DE SAN JUAN"
            r1.put(r0, r9)
            r0 = 29121(0x71c1, float:4.0807E-41)
            java.lang.String r9 = "VENADILLO"
            r1.put(r0, r9)
            r0 = 29124(0x71c4, float:4.0811E-41)
            java.lang.String r9 = "VILLAHERMOSA"
            r1.put(r0, r9)
            r0 = 29127(0x71c7, float:4.0816E-41)
            java.lang.String r9 = "VILLARRICA"
            r1.put(r0, r9)
            r0 = 31001(0x7919, float:4.3442E-41)
            java.lang.String r9 = "CALI"
            r1.put(r0, r9)
            r0 = 31004(0x791c, float:4.3446E-41)
            java.lang.String r9 = "ALCALA"
            r1.put(r0, r9)
            r0 = 31007(0x791f, float:4.345E-41)
            java.lang.String r9 = "ANDALUCIA"
            r1.put(r0, r9)
            r0 = 31010(0x7922, float:4.3454E-41)
            java.lang.String r9 = "ANSERMANUEVO"
            r1.put(r0, r9)
            r0 = 31013(0x7925, float:4.3458E-41)
            r1.put(r0, r2)
            r0 = 31016(0x7928, float:4.3463E-41)
            r1.put(r0, r4)
            r0 = 31019(0x792b, float:4.3467E-41)
            java.lang.String r2 = "BUENAVENTURA"
            r1.put(r0, r2)
            r0 = 31022(0x792e, float:4.3471E-41)
            java.lang.String r2 = "BUGA"
            r1.put(r0, r2)
            r0 = 31025(0x7931, float:4.3475E-41)
            java.lang.String r2 = "BUGALAGRANDE"
            r1.put(r0, r2)
            r0 = 31028(0x7934, float:4.348E-41)
            java.lang.String r2 = "CAICEDONIA"
            r1.put(r0, r2)
            r0 = 31031(0x7937, float:4.3484E-41)
            java.lang.String r2 = "CANDELARIA"
            r1.put(r0, r2)
            r0 = 31034(0x793a, float:4.3488E-41)
            java.lang.String r2 = "CARTAGO"
            r1.put(r0, r2)
            r0 = 31037(0x793d, float:4.3492E-41)
            java.lang.String r2 = "DAGUA"
            r1.put(r0, r2)
            r0 = 31040(0x7940, float:4.3496E-41)
            java.lang.String r2 = "CALIMA (DARIEN)"
            r1.put(r0, r2)
            r0 = 31043(0x7943, float:4.35E-41)
            java.lang.String r2 = "EL AGUILA"
            r1.put(r0, r2)
            r0 = 31046(0x7946, float:4.3505E-41)
            java.lang.String r2 = "EL CAIRO"
            r1.put(r0, r2)
            r0 = 31049(0x7949, float:4.3509E-41)
            java.lang.String r2 = "EL CERRITO"
            r1.put(r0, r2)
            r0 = 31052(0x794c, float:4.3513E-41)
            java.lang.String r2 = "EL DOVIO"
            r1.put(r0, r2)
            r0 = 31055(0x794f, float:4.3517E-41)
            java.lang.String r2 = "FLORIDA"
            r1.put(r0, r2)
            r0 = 31058(0x7952, float:4.3522E-41)
            java.lang.String r2 = "GINEBRA"
            r1.put(r0, r2)
            r0 = 31061(0x7955, float:4.3526E-41)
            java.lang.String r2 = "GUACARI"
            r1.put(r0, r2)
            r0 = 31064(0x7958, float:4.353E-41)
            java.lang.String r2 = "JAMUNDI"
            r1.put(r0, r2)
            r0 = 31067(0x795b, float:4.3534E-41)
            java.lang.String r2 = "LA CUMBRE"
            r1.put(r0, r2)
            r0 = 31070(0x795e, float:4.3538E-41)
            r1.put(r0, r12)
            r0 = 31073(0x7961, float:4.3543E-41)
            r1.put(r0, r6)
            r0 = 31076(0x7964, float:4.3547E-41)
            java.lang.String r2 = "OBANDO"
            r1.put(r0, r2)
            r0 = 31079(0x7967, float:4.3551E-41)
            java.lang.String r2 = "PALMIRA"
            r1.put(r0, r2)
            r0 = 31082(0x796a, float:4.3555E-41)
            java.lang.String r2 = "PRADERA"
            r1.put(r0, r2)
            r0 = 31085(0x796d, float:4.356E-41)
            java.lang.String r2 = "RESTREPO"
            r1.put(r0, r2)
            r0 = 31088(0x7970, float:4.3564E-41)
            java.lang.String r2 = "RIOFRIO"
            r1.put(r0, r2)
            r0 = 31091(0x7973, float:4.3568E-41)
            java.lang.String r2 = "ROLDANILLO"
            r1.put(r0, r2)
            r0 = 31094(0x7976, float:4.3572E-41)
            r1.put(r0, r5)
            r0 = 31097(0x7979, float:4.3576E-41)
            java.lang.String r2 = "SEVILLA"
            r1.put(r0, r2)
            r0 = 31100(0x797c, float:4.358E-41)
            java.lang.String r2 = "TORO"
            r1.put(r0, r2)
            r0 = 31103(0x797f, float:4.3585E-41)
            java.lang.String r2 = "TRUJILLO"
            r1.put(r0, r2)
            r0 = 31106(0x7982, float:4.3589E-41)
            java.lang.String r2 = "TULUA"
            r1.put(r0, r2)
            r0 = 31109(0x7985, float:4.3593E-41)
            java.lang.String r2 = "ULLOA"
            r1.put(r0, r2)
            r0 = 31112(0x7988, float:4.3597E-41)
            java.lang.String r2 = "VERSALLES"
            r1.put(r0, r2)
            r0 = 31115(0x798b, float:4.3601E-41)
            java.lang.String r2 = "VIJES"
            r1.put(r0, r2)
            r0 = 31118(0x798e, float:4.3606E-41)
            java.lang.String r2 = "YOTOCO"
            r1.put(r0, r2)
            r0 = 31121(0x7991, float:4.361E-41)
            java.lang.String r2 = "YUMBO"
            r1.put(r0, r2)
            r0 = 31124(0x7994, float:4.3614E-41)
            java.lang.String r2 = "ZARZAL"
            r1.put(r0, r2)
            r0 = 40001(0x9c41, float:5.6053E-41)
            java.lang.String r2 = "ARAUCA"
            r1.put(r0, r2)
            r0 = 40005(0x9c45, float:5.6059E-41)
            java.lang.String r2 = "TAME"
            r1.put(r0, r2)
            r0 = 40010(0x9c4a, float:5.6066E-41)
            java.lang.String r2 = "ARAUQUITA"
            r1.put(r0, r2)
            r0 = 40015(0x9c4f, float:5.6073E-41)
            java.lang.String r2 = "CRAVO NORTE"
            r1.put(r0, r2)
            r0 = 40017(0x9c51, float:5.6076E-41)
            java.lang.String r2 = "FORTUL"
            r1.put(r0, r2)
            r0 = 40020(0x9c54, float:5.608E-41)
            java.lang.String r2 = "PUERTO RONDON"
            r1.put(r0, r2)
            r0 = 40025(0x9c59, float:5.6087E-41)
            java.lang.String r2 = "SARAVENA"
            r1.put(r0, r2)
            r0 = 44001(0xabe1, float:6.1659E-41)
            java.lang.String r2 = "FLORENCIA"
            r1.put(r0, r2)
            r0 = 44002(0xabe2, float:6.166E-41)
            r1.put(r0, r7)
            r0 = 44003(0xabe3, float:6.1661E-41)
            java.lang.String r2 = "CARTAGENA DEL CHAIRA"
            r1.put(r0, r2)
            r0 = 44004(0xabe4, float:6.1663E-41)
            java.lang.String r2 = "BELEN DE LOS ANDAQUIES"
            r1.put(r0, r2)
            r0 = 44005(0xabe5, float:6.1664E-41)
            java.lang.String r2 = "EL DONCELLO"
            r1.put(r0, r2)
            r0 = 44006(0xabe6, float:6.1666E-41)
            java.lang.String r2 = "EL PAUJIL"
            r1.put(r0, r2)
            r0 = 44007(0xabe7, float:6.1667E-41)
            java.lang.String r2 = "LA MONTA/ITA"
            r1.put(r0, r2)
            r0 = 44009(0xabe9, float:6.167E-41)
            java.lang.String r2 = "PUERTO RICO"
            r1.put(r0, r2)
            r0 = 44010(0xabea, float:6.1671E-41)
            java.lang.String r2 = "SAN VICENTE DEL CAGUAN"
            r1.put(r0, r2)
            r0 = 44012(0xabec, float:6.1674E-41)
            java.lang.String r2 = "CURILLO"
            r1.put(r0, r2)
            r0 = 44016(0xabf0, float:6.168E-41)
            java.lang.String r2 = "MILAN"
            r1.put(r0, r2)
            r0 = 44017(0xabf1, float:6.1681E-41)
            java.lang.String r2 = "MORELIA"
            r1.put(r0, r2)
            r0 = 44020(0xabf4, float:6.1685E-41)
            java.lang.String r2 = "SAN JOSE DEL FRAGUA"
            r1.put(r0, r2)
            r0 = 44022(0xabf6, float:6.1688E-41)
            java.lang.String r2 = "SOLANO"
            r1.put(r0, r2)
            r0 = 44024(0xabf8, float:6.1691E-41)
            java.lang.String r2 = "SOLITA"
            r1.put(r0, r2)
            r0 = 44040(0xac08, float:6.1713E-41)
            java.lang.String r2 = "VALPARAISO"
            r1.put(r0, r2)
            r0 = 46001(0xb3b1, float:6.4461E-41)
            java.lang.String r2 = "YOPAL"
            r1.put(r0, r2)
            r0 = 46040(0xb3d8, float:6.4516E-41)
            java.lang.String r2 = "AGUAZUL"
            r1.put(r0, r2)
            r0 = 46120(0xb428, float:6.4628E-41)
            java.lang.String r2 = "CHAMEZA"
            r1.put(r0, r2)
            r0 = 46320(0xb4f0, float:6.4908E-41)
            java.lang.String r2 = "HATO COROZAL"
            r1.put(r0, r2)
            r0 = 46480(0xb590, float:6.5132E-41)
            java.lang.String r2 = "LA SALINA"
            r1.put(r0, r2)
            r0 = 46520(0xb5b8, float:6.5188E-41)
            java.lang.String r2 = "MANI"
            r1.put(r0, r2)
            r0 = 46540(0xb5cc, float:6.5216E-41)
            java.lang.String r2 = "MONTERREY"
            r1.put(r0, r2)
            r0 = 46560(0xb5e0, float:6.5244E-41)
            java.lang.String r2 = "NUNCHIA"
            r1.put(r0, r2)
            r0 = 46640(0xb630, float:6.5357E-41)
            java.lang.String r2 = "OROCUE"
            r1.put(r0, r2)
            r0 = 46680(0xb658, float:6.5413E-41)
            java.lang.String r2 = "PAZ DE ARIPORO (MORENO)"
            r1.put(r0, r2)
            r0 = 46700(0xb66c, float:6.544E-41)
            java.lang.String r2 = "PORE"
            r1.put(r0, r2)
            r0 = 46760(0xb6a8, float:6.5525E-41)
            java.lang.String r2 = "RECETOR"
            r1.put(r0, r2)
            r0 = 46800(0xb6d0, float:6.5581E-41)
            r2 = r18
            r1.put(r0, r2)
            r0 = 46815(0xb6df, float:6.5602E-41)
            java.lang.String r2 = "SACAMA"
            r1.put(r0, r2)
            r0 = 46830(0xb6ee, float:6.5623E-41)
            java.lang.String r2 = "SAN LUIS DE PALENQUE"
            r1.put(r0, r2)
            r0 = 46840(0xb6f8, float:6.5637E-41)
            java.lang.String r2 = "TAMARA"
            r1.put(r0, r2)
            r0 = 46850(0xb702, float:6.5651E-41)
            java.lang.String r2 = "TAURAMENA"
            r1.put(r0, r2)
            r0 = 46865(0xb711, float:6.5672E-41)
            java.lang.String r2 = "TRINIDAD"
            r1.put(r0, r2)
            r0 = 46880(0xb720, float:6.5693E-41)
            r1.put(r0, r10)
            r0 = 48001(0xbb81, float:6.7264E-41)
            java.lang.String r2 = "RIOHACHA"
            r1.put(r0, r2)
            r0 = 48002(0xbb82, float:6.7265E-41)
            r1.put(r0, r7)
            r0 = 48004(0xbb84, float:6.7268E-41)
            java.lang.String r2 = "BARRANCAS"
            r1.put(r0, r2)
            r0 = 48005(0xbb85, float:6.727E-41)
            java.lang.String r2 = "DIBULLA"
            r1.put(r0, r2)
            r0 = 48006(0xbb86, float:6.7271E-41)
            java.lang.String r2 = "EL MOLINO"
            r1.put(r0, r2)
            r0 = 48007(0xbb87, float:6.7272E-41)
            java.lang.String r2 = "FONSECA"
            r1.put(r0, r2)
            r0 = 48008(0xbb88, float:6.7274E-41)
            java.lang.String r2 = "DISTRACCION"
            r1.put(r0, r2)
            r0 = 48009(0xbb89, float:6.7275E-41)
            java.lang.String r2 = "HATONUEVO"
            r1.put(r0, r2)
            r0 = 48010(0xbb8a, float:6.7276E-41)
            java.lang.String r2 = "MAICAO"
            r1.put(r0, r2)
            r0 = 48011(0xbb8b, float:6.7278E-41)
            java.lang.String r2 = "MANAURE"
            r1.put(r0, r2)
            r0 = 48012(0xbb8c, float:6.7279E-41)
            java.lang.String r2 = "LA JAGUA DEL PILAR"
            r1.put(r0, r2)
            r0 = 48013(0xbb8d, float:6.728E-41)
            java.lang.String r2 = "SAN JUAN DEL CESAR"
            r1.put(r0, r2)
            r0 = 48016(0xbb90, float:6.7285E-41)
            java.lang.String r2 = "URIBIA"
            r1.put(r0, r2)
            r0 = 48018(0xbb92, float:6.7288E-41)
            java.lang.String r2 = "URUMITA"
            r1.put(r0, r2)
            r0 = 48020(0xbb94, float:6.729E-41)
            r1.put(r0, r10)
            r0 = 50001(0xc351, float:7.0066E-41)
            java.lang.String r2 = "INIRIDA"
            r1.put(r0, r2)
            r0 = 50050(0xc382, float:7.0135E-41)
            java.lang.String r2 = "MAPIRIPANA"
            r1.put(r0, r2)
            r0 = 50070(0xc396, float:7.0163E-41)
            java.lang.String r2 = "BARRANCO MINAS"
            r1.put(r0, r2)
            r0 = 50073(0xc399, float:7.0167E-41)
            java.lang.String r2 = "CACAHUAL"
            r1.put(r0, r2)
            r0 = 50078(0xc39e, float:7.0174E-41)
            java.lang.String r2 = "LA GUADALUPE"
            r1.put(r0, r2)
            r0 = 50083(0xc3a3, float:7.0181E-41)
            java.lang.String r2 = "MORICHAL (MORICHAL NUEVO)"
            r1.put(r0, r2)
            r0 = 50087(0xc3a7, float:7.0187E-41)
            java.lang.String r2 = "PANA PANA (CAMPO ALEGRE)"
            r1.put(r0, r2)
            r0 = 50090(0xc3aa, float:7.0191E-41)
            java.lang.String r2 = "PUERTO COLOMBIA"
            r1.put(r0, r2)
            r0 = 50092(0xc3ac, float:7.0194E-41)
            java.lang.String r2 = "SAN FELIPE"
            r1.put(r0, r2)
            r0 = 52001(0xcb21, float:7.2869E-41)
            java.lang.String r2 = "VILLAVICENCIO"
            r1.put(r0, r2)
            r0 = 52005(0xcb25, float:7.2875E-41)
            java.lang.String r2 = "ACACIAS"
            r1.put(r0, r2)
            r0 = 52006(0xcb26, float:7.2876E-41)
            java.lang.String r2 = "BARRANCA DE UPIA"
            r1.put(r0, r2)
            r0 = 52008(0xcb28, float:7.2879E-41)
            java.lang.String r2 = "CABUYARO"
            r1.put(r0, r2)
            r0 = 52010(0xcb2a, float:7.2882E-41)
            java.lang.String r2 = "CASTILLA LA NUEVA"
            r1.put(r0, r2)
            r0 = 52015(0xcb2f, float:7.2889E-41)
            java.lang.String r2 = "CUBARRAL"
            r1.put(r0, r2)
            r0 = 52020(0xcb34, float:7.2896E-41)
            java.lang.String r2 = "CUMARAL"
            r1.put(r0, r2)
            r0 = 52025(0xcb39, float:7.2903E-41)
            java.lang.String r2 = "EL CALVARIO"
            r1.put(r0, r2)
            r0 = 52027(0xcb3b, float:7.2905E-41)
            java.lang.String r2 = "EL CASTILLO"
            r1.put(r0, r2)
            r0 = 52028(0xcb3c, float:7.2907E-41)
            java.lang.String r2 = "EL DORADO"
            r1.put(r0, r2)
            r0 = 52030(0xcb3e, float:7.291E-41)
            java.lang.String r2 = "FUENTE DE ORO"
            r1.put(r0, r2)
            r0 = 52035(0xcb43, float:7.2917E-41)
            r1.put(r0, r3)
            r0 = 52040(0xcb48, float:7.2924E-41)
            java.lang.String r2 = "GUAMAL"
            r1.put(r0, r2)
            r0 = 52041(0xcb49, float:7.2925E-41)
            java.lang.String r2 = "LA MACARENA"
            r1.put(r0, r2)
            r0 = 52042(0xcb4a, float:7.2926E-41)
            java.lang.String r2 = "LEJANIAS"
            r1.put(r0, r2)
            r0 = 52043(0xcb4b, float:7.2928E-41)
            java.lang.String r2 = "PUERTO GAITAN"
            r1.put(r0, r2)
            r0 = 52044(0xcb4c, float:7.2929E-41)
            java.lang.String r2 = "MESETAS"
            r1.put(r0, r2)
            r0 = 52045(0xcb4d, float:7.293E-41)
            java.lang.String r2 = "PUERTO LOPEZ"
            r1.put(r0, r2)
            r0 = 52046(0xcb4e, float:7.2932E-41)
            java.lang.String r2 = "MAPIRIPAN"
            r1.put(r0, r2)
            r0 = 52047(0xcb4f, float:7.2933E-41)
            java.lang.String r2 = "PUERTO CONCORDIA"
            r1.put(r0, r2)
            r0 = 52048(0xcb50, float:7.2935E-41)
            java.lang.String r2 = "PUERTO LLERAS"
            r1.put(r0, r2)
            r0 = 52049(0xcb51, float:7.2936E-41)
            java.lang.String r2 = "PUERTO RICO"
            r1.put(r0, r2)
            r0 = 52050(0xcb52, float:7.2938E-41)
            java.lang.String r2 = "RESTREPO"
            r1.put(r0, r2)
            r0 = 52055(0xcb57, float:7.2945E-41)
            java.lang.String r2 = "SAN CARLOS DE GUAROA"
            r1.put(r0, r2)
            r0 = 52058(0xcb5a, float:7.2949E-41)
            java.lang.String r2 = "SAN JUAN DE ARAMA"
            r1.put(r0, r2)
            r0 = 52059(0xcb5b, float:7.295E-41)
            java.lang.String r2 = "SAN JUANITO"
            r1.put(r0, r2)
            r0 = 52060(0xcb5c, float:7.2952E-41)
            java.lang.String r2 = "SAN MARTIN DE LOS LLANOS"
            r1.put(r0, r2)
            r0 = 52074(0xcb6a, float:7.2971E-41)
            java.lang.String r2 = "URIBE"
            r1.put(r0, r2)
            r0 = 52080(0xcb70, float:7.298E-41)
            java.lang.String r2 = "VISTA HERMOSA"
            r1.put(r0, r2)
            r0 = 54001(0xd2f1, float:7.5672E-41)
            java.lang.String r2 = "SAN JOSE DEL GUAVIARE"
            r1.put(r0, r2)
            r0 = 54003(0xd2f3, float:7.5674E-41)
            java.lang.String r2 = "CALAMAR"
            r1.put(r0, r2)
            r0 = 54007(0xd2f7, float:7.568E-41)
            java.lang.String r2 = "EL RETORNO"
            r1.put(r0, r2)
            r0 = 54012(0xd2fc, float:7.5687E-41)
            java.lang.String r2 = "MIRAFLORES"
            r1.put(r0, r2)
            r0 = 56001(0xdac1, float:7.8474E-41)
            r1.put(r0, r8)
            r0 = 56004(0xdac4, float:7.8478E-41)
            java.lang.String r2 = "PROVIDENCIA"
            r1.put(r0, r2)
            r0 = 60001(0xea61, float:8.408E-41)
            java.lang.String r2 = "LETICIA"
            r1.put(r0, r2)
            r0 = 60007(0xea67, float:8.4088E-41)
            java.lang.String r2 = "PUERTO NARI/O"
            r1.put(r0, r2)
            r0 = 60010(0xea6a, float:8.4092E-41)
            java.lang.String r2 = "EL ENCANTO"
            r1.put(r0, r2)
            r0 = 60013(0xea6d, float:8.4096E-41)
            java.lang.String r2 = "LA CHORRERA"
            r1.put(r0, r2)
            r0 = 60016(0xea70, float:8.41E-41)
            java.lang.String r2 = "LA PEDRERA"
            r1.put(r0, r2)
            r0 = 60017(0xea71, float:8.4102E-41)
            r1.put(r0, r6)
            r0 = 60019(0xea73, float:8.4105E-41)
            java.lang.String r2 = "MIRITI PARANA"
            r1.put(r0, r2)
            r0 = 60021(0xea75, float:8.4107E-41)
            java.lang.String r2 = "PUERTO SANTANDER"
            r1.put(r0, r2)
            r0 = 60022(0xea76, float:8.4109E-41)
            java.lang.String r2 = "TARAPACA"
            r1.put(r0, r2)
            r0 = 60030(0xea7e, float:8.412E-41)
            java.lang.String r2 = "PUERTO ALEGRIA"
            r1.put(r0, r2)
            r0 = 60040(0xea88, float:8.4134E-41)
            java.lang.String r2 = "PUERTO ARICA"
            r1.put(r0, r2)
            r0 = 64001(0xfa01, float:8.9685E-41)
            java.lang.String r2 = "MOCOA"
            r1.put(r0, r2)
            r0 = 64002(0xfa02, float:8.9686E-41)
            java.lang.String r2 = "PUERTO ASIS"
            r1.put(r0, r2)
            r0 = 64004(0xfa04, float:8.9689E-41)
            java.lang.String r2 = "PUERTO LEGUIZAMO"
            r1.put(r0, r2)
            r0 = 64007(0xfa07, float:8.9693E-41)
            java.lang.String r2 = "COLON"
            r1.put(r0, r2)
            r0 = 64013(0xfa0d, float:8.9701E-41)
            r1.put(r0, r15)
            r0 = 64016(0xfa10, float:8.9706E-41)
            java.lang.String r2 = "SANTIAGO"
            r1.put(r0, r2)
            r0 = 64018(0xfa12, float:8.9708E-41)
            java.lang.String r2 = "SAN MIGUEL (LA DORADA)"
            r1.put(r0, r2)
            r0 = 64019(0xfa13, float:8.971E-41)
            java.lang.String r2 = "SIBUNDOY"
            r1.put(r0, r2)
            r0 = 64023(0xfa17, float:8.9715E-41)
            java.lang.String r2 = "ORITO"
            r1.put(r0, r2)
            r0 = 64025(0xfa19, float:8.9718E-41)
            java.lang.String r2 = "PUERTO GUZMAN"
            r1.put(r0, r2)
            r0 = 64026(0xfa1a, float:8.972E-41)
            java.lang.String r2 = "PUERTO CAICEDO"
            r1.put(r0, r2)
            r0 = 64028(0xfa1c, float:8.9722E-41)
            java.lang.String r2 = "VALLE DEL GUAMUEZ (LA HORMIGA)"
            r1.put(r0, r2)
            r0 = 64030(0xfa1e, float:8.9725E-41)
            java.lang.String r2 = "VILLAGARZON"
            r1.put(r0, r2)
            r0 = 68001(0x109a1, float:9.529E-41)
            java.lang.String r2 = "MITU"
            r1.put(r0, r2)
            r0 = 68004(0x109a4, float:9.5294E-41)
            java.lang.String r2 = "CARURU"
            r1.put(r0, r2)
            r0 = 68010(0x109aa, float:9.5302E-41)
            java.lang.String r2 = "MORICHAL (PAPUNAGUA)"
            r1.put(r0, r2)
            r0 = 68013(0x109ad, float:9.5307E-41)
            java.lang.String r2 = "BUENOS AIRES (PACOA)"
            r1.put(r0, r2)
            r0 = 68017(0x109b1, float:9.5312E-41)
            java.lang.String r2 = "TARAIRA"
            r1.put(r0, r2)
            r0 = 68022(0x109b6, float:9.5319E-41)
            java.lang.String r2 = "YAVARATE"
            r1.put(r0, r2)
            r0 = 72001(0x11941, float:1.00895E-40)
            java.lang.String r2 = "PUERTO CARRE/O"
            r1.put(r0, r2)
            r0 = 72002(0x11942, float:1.00896E-40)
            java.lang.String r2 = "SANTA ROSALIA"
            r1.put(r0, r2)
            r0 = 72006(0x11946, float:1.00902E-40)
            java.lang.String r2 = "CUMARIBO"
            r1.put(r0, r2)
            r0 = 81505(0x13e61, float:1.14213E-40)
            java.lang.String r2 = "SAN CRISTOBAL"
            r1.put(r0, r2)
            r0 = 81607(0x13ec7, float:1.14356E-40)
            java.lang.String r2 = "LIBERTADOR-DISTRITO CAPITAL"
            r1.put(r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.extraction.barcode.parser.col.LocationLookup.<clinit>():void");
    }

    public static String getCity(String str) {
        return f54755b.get(Integer.parseInt(str.substring(0, 5)), (Object) null);
    }

    public static String getState(String str) {
        return f54754a.get(Integer.parseInt(str.substring(0, 2)), (Object) null);
    }
}
