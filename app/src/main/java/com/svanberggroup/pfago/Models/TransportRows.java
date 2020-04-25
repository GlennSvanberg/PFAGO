package com.svanberggroup.pfago.Models;

import com.svanberggroup.pfago.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TransportRows implements Serializable {
    private ControlRow row18;
    private ControlRow row19;
    private ControlRow row20;
    private ControlRow row21;
    private ControlRow row22_1;
    private ControlRow row22_2;
    private ControlRow row22_3;
    private ControlRow row23_1;
    private ControlRow row23_2;
    private ControlRow row24;
    private ControlRow row25_1;
    private ControlRow row25_2;
    private ControlRow row26;
    private ControlRow row27;
    private ControlRow row28_1;
    private ControlRow row28_2;
    private ControlRow row28_3;
    private ControlRow row28_4;
    private ControlRow row29;
    private ControlRow row31;
    private List<ControlRow> rows40;

    private RiskCategory riskCategory;
    public enum RiskCategory{
        category1(R.string.category1),
        category2(R.string.category2),
        category3(R.string.category3);
        public final int label;
        RiskCategory(int label) {
            this.label = label;
        }
    }


    public TransportRows() {
        rows40 = new ArrayList<>();
        row18 = new ControlRow("18. Gods tillåtet för transport");
        row19 = new ControlRow("19. Fordonet godkänt för det transporterade godset");
        row20 = new ControlRow("20. Bestämmelser för transportsätt");
        row21 = new ControlRow("21. Förbud mot samlastning");
        row22_1 = new ControlRow("22.1. Hantering");
        row22_2 = new ControlRow("22.2. Lastning/Stuvning");
        row22_3 = new ControlRow("22.3. Lastsäkring");
        row23_1 = new ControlRow("23.1. Läckage");
        row23_2 = new ControlRow("23.2. Skador på kolli/fordon");
        row24 = new ControlRow("24. Godkännandemärkning av kolli/tankar (ADR kapitel 6)");
        row25_1 = new ControlRow("25.1. Märkning av kolli (5.2.1)");
        row25_2 = new ControlRow("25.2. Ettikering av kolli (5.2.2");
        row26 = new ControlRow("26. Storetiketter (5.3.1");
        row27 = new ControlRow("27. Skyltning/märkning av fordon/transporthenhet");
        row28_1 = new ControlRow("28.1. Stoppklots");
        row28_2 = new ControlRow("28.2. Varningsanordning");
        row28_3 = new ControlRow("28.3. Varningsväst/ögonskydd/handskar");
        row28_4 = new ControlRow("28.4. Bärbar ljuskälla");
        row29 = new ControlRow("29. Godsspecifik utrustning (ADR 8.1.5.2/8.1.5.3)");
        row31 = new ControlRow("31. Brandsläckare (ADR 8.1.4.1/8.1.4.2/10.6)");

    }

    public ControlRow getRow22_3() {
        return row22_3;
    }

    public void setRow22_3(ControlRow row22_3) {
        this.row22_3 = row22_3;
    }

    public ControlRow getRow18() {
        return row18;
    }

    public void setRow18(ControlRow row18) {
        this.row18 = row18;
    }

    public ControlRow getRow19() {
        return row19;
    }

    public void setRow19(ControlRow row19) {
        this.row19 = row19;
    }

    public ControlRow getRow20() {
        return row20;
    }

    public void setRow20(ControlRow row20) {
        this.row20 = row20;
    }

    public ControlRow getRow21() {
        return row21;
    }

    public void setRow21(ControlRow row21) {
        this.row21 = row21;
    }

    public ControlRow getRow22_1() {
        return row22_1;
    }

    public void setRow22_1(ControlRow row22_1) {
        this.row22_1 = row22_1;
    }

    public ControlRow getRow22_2() {
        return row22_2;
    }

    public void setRow22_2(ControlRow row22_2) {
        this.row22_2 = row22_2;
    }

    public ControlRow getRow23_1() {
        return row23_1;
    }

    public void setRow23_1(ControlRow row23_1) {
        this.row23_1 = row23_1;
    }

    public ControlRow getRow23_2() {
        return row23_2;
    }

    public void setRow23_2(ControlRow row23_2) {
        this.row23_2 = row23_2;
    }

    public ControlRow getRow24() {
        return row24;
    }

    public void setRow24(ControlRow row24) {
        this.row24 = row24;
    }

    public ControlRow getRow25_1() {
        return row25_1;
    }

    public void setRow25_1(ControlRow row25_1) {
        this.row25_1 = row25_1;
    }

    public ControlRow getRow25_2() {
        return row25_2;
    }

    public void setRow25_2(ControlRow row25_2) {
        this.row25_2 = row25_2;
    }

    public ControlRow getRow26() {
        return row26;
    }

    public void setRow26(ControlRow row26) {
        this.row26 = row26;
    }

    public ControlRow getRow27() {
        return row27;
    }

    public void setRow27(ControlRow row27) {
        this.row27 = row27;
    }

    public ControlRow getRow28_1() {
        return row28_1;
    }

    public void setRow28_1(ControlRow row28_1) {
        this.row28_1 = row28_1;
    }

    public ControlRow getRow28_2() {
        return row28_2;
    }

    public void setRow28_2(ControlRow row28_2) {
        this.row28_2 = row28_2;
    }

    public ControlRow getRow28_3() {
        return row28_3;
    }

    public void setRow28_3(ControlRow row28_3) {
        this.row28_3 = row28_3;
    }

    public ControlRow getRow28_4() {
        return row28_4;
    }

    public void setRow28_4(ControlRow row28_4) {
        this.row28_4 = row28_4;
    }

    public ControlRow getRow29() {
        return row29;
    }

    public void setRow29(ControlRow row29) {
        this.row29 = row29;
    }

    public ControlRow getRow31() {
        return row31;
    }

    public void setRow31(ControlRow row31) {
        this.row31 = row31;
    }

    public void addRow40(ControlRow row) {
        rows40.add(row);
    }
    public List<ControlRow> getRows40() {
        return rows40;
    }

    public void setRows40(List<ControlRow> rows40) {
        this.rows40 = rows40;
    }

    public RiskCategory getRiskCategory() {
        return riskCategory;
    }

    public void setRiskCategory(RiskCategory riskCategory) {
        this.riskCategory = riskCategory;
    }
}
