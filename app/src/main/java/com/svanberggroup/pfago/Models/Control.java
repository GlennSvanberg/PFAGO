package com.svanberggroup.pfago.Models;

import com.svanberggroup.pfago.R;

import java.io.Serializable;
import java.util.Date;

public class Control implements Serializable {

    private int id;
    private Date startDate;
    private Date endDate;
    private String location;

    public enum LocationType{
        CargoTerminal(R.string.cargo_terminal),
        CompanyVisit(R.string.company_visit),
        Road(R.string.road),
        PortTerminal(R.string.port_terminal),
        System(R.string.system);

        public final int label;
        LocationType(int label) {
            this.label = label;
        }
    };
    private LocationType locationType;

    private Transporter carrier;
    private Transporter driver;
    private Transporter passenger;

    private Vehicle truck;
    private Vehicle trailer;

    private TransportLocation sender;
    private TransportLocation receiver;

    private Quantity quantity;
    private boolean valueQuantityExceeded;
    private int valueQuantity;

    private ControlRow goodsDeclarationRow;
    public enum Declaration {
        LoadingPlane(R.string.loading_plane),
        StowageCertificate(R.string.stowing_certificate);

        public final int label;
        Declaration(int label) {
            this.label = label;
        }
    }
    private Declaration declaration;
    private ControlRow writtenInstructionsRow;

    private ControlRow approvalRow;
    public enum Approval {
        Bilateral(R.string.bilateral),
        Multilateral(R.string.multilateral),
        NationalApproval(R.string.natninal_approval);

        public final int label;
        Approval(int label) {
            this.label = label;
        }
    }
    private Approval approval;

    private ControlRow approvalCertificateRow;
    private ControlRow driverCertificationRow;
    private ControlRow otherADRTrainingRow;


    public enum TransportType{
        Tank(R.string.tank),
        Bulk(R.string.bulk),
        MixedCargo(R.string.mixed_cargo),
        Other(R.string.other);

        public final int label;
        TransportType(int label) {
            this.label = label;
        }

    };
    private TransportType transportType;

    public enum TransportStandard{
        ADR(R.string.adr),
        ADRS(R.string.adrs),
        IMDG(R.string.imdg),
        ICAO(R.string.icao),
        RID(R.string.rid),
        RIDS(R.string.rids),
        MOU(R.string.mou),
        Other(R.string.other);
        public final int label;
        TransportStandard(int label) {
            this.label = label;
        }
    };
    private TransportStandard transportStandard;


    public Control() {
        startDate = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }

    public Transporter getCarrier() {
        return carrier;
    }

    public void setCarrier(Transporter carrier) {
        this.carrier = carrier;
    }

    public Transporter getDriver() {
        return driver;
    }

    public void setDriver(Transporter driver) {
        this.driver = driver;
    }

    public Transporter getPassenger() {
        return passenger;
    }

    public void setPassenger(Transporter passenger) {
        this.passenger = passenger;
    }

    public Vehicle getTruck() {
        return truck;
    }

    public void setTruck(Vehicle truck) {
        this.truck = truck;
    }

    public Vehicle getTrailer() {
        return trailer;
    }

    public void setTrailer(Vehicle trailer) {
        this.trailer = trailer;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    public boolean isValueQuantityExceeded() {
        return valueQuantityExceeded;
    }

    public void setValueQuantityExceeded(boolean valueQuantityExceeded) {
        this.valueQuantityExceeded = valueQuantityExceeded;
    }

    public int getValueQuantity() {
        return valueQuantity;
    }

    public void setValueQuantity(int valueQuantity) {
        this.valueQuantity = valueQuantity;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public TransportStandard getTransportStandard() {
        return transportStandard;
    }

    public void setTransportStandard(TransportStandard transportStandard) {
        this.transportStandard = transportStandard;
    }

    public TransportLocation getSender() {
        return sender;
    }

    public void setSender(TransportLocation sender) {
        this.sender = sender;
    }

    public TransportLocation getReceiver() {
        return receiver;
    }

    public void setReceiver(TransportLocation receiver) {
        this.receiver = receiver;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public ControlRow getGoodsDeclarationRow() {
        return goodsDeclarationRow;
    }

    public void setGoodsDeclarationRow(ControlRow goodsDeclarationRow) {
        this.goodsDeclarationRow = goodsDeclarationRow;
    }

    public ControlRow getWrittenInstructionsRow() {
        return writtenInstructionsRow;
    }

    public void setWrittenInstructionsRow(ControlRow writtenInstructionsRow) {
        this.writtenInstructionsRow = writtenInstructionsRow;
    }

    public ControlRow getApprovalCertificateRow() {
        return approvalCertificateRow;
    }

    public void setApprovalCertificateRow(ControlRow approvalCertificateRow) {
        this.approvalCertificateRow = approvalCertificateRow;
    }

    public ControlRow getDriverCertificationRow() {
        return driverCertificationRow;
    }

    public void setDriverCertificationRow(ControlRow driverCertificationRow) {
        this.driverCertificationRow = driverCertificationRow;
    }

    public ControlRow getOtherADRTrainingRow() {
        return otherADRTrainingRow;
    }

    public void setOtherADRTrainingRow(ControlRow otherADRTrainingRow) {
        this.otherADRTrainingRow = otherADRTrainingRow;
    }

    public ControlRow getApprovalRow() {
        return approvalRow;
    }

    public void setApprovalRow(ControlRow approvalRow) {
        this.approvalRow = approvalRow;
    }

    public Declaration getDeclaration() {
        return declaration;
    }

    public void setDeclaration(Declaration declaration) {
        this.declaration = declaration;
    }

    public Approval getApproval() {
        return approval;
    }

    public void setApproval(Approval approval) {
        this.approval = approval;
    }
}
