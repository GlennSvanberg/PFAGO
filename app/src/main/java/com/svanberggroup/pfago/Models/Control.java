package com.svanberggroup.pfago.Models;

import com.svanberggroup.pfago.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    private TransportDocumentRows tdRows;
    private TransportRows tRows;

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
    private List<Goods> goodsList;
    private List<Fault> faultList;
    private SafetyAdvisor safetyAdvisorCarrier;
    private SafetyAdvisor safetyAdvisorSender;

    private List<Integer> prohibitetFieldNrList;
    private boolean admissionGiven;
    private boolean allowedToContinueTrip;
    private String destination;
    private List<Integer> submissionFieldNrList;

    public enum ReportedEntity{
        Sender(R.string.sender),
        Carrier(R.string.carrier),
        Driver(R.string.driver),
        Receiver(R.string.receiver),
        Passenger(R.string.passenger),
        Other(R.string.other);
        public final int label;
        ReportedEntity(int label) {
            this.label = label;
        }
    }

    private ReportedEntity reportedEntity;
    private List<String> penaltiesList;
    private List<ImageData> images;

    public Control() {
        startDate = new Date();
        tdRows = new TransportDocumentRows();
        tRows = new TransportRows();
        goodsList = new ArrayList<>();
        faultList = new ArrayList<>();
        prohibitetFieldNrList = new ArrayList<>();
        submissionFieldNrList = new ArrayList<>();
        penaltiesList = new ArrayList<>();
        images = new ArrayList<>();
        safetyAdvisorSender = new SafetyAdvisor();
        safetyAdvisorCarrier = new SafetyAdvisor();
    }

    public List<ImageData> getImages() {
        return images;
    }

    public void setImages(List<ImageData> images) {
        this.images = images;
    }

    public void addImage(ImageData image){
        images.add(image);
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

    public TransportDocumentRows getTdRows() {
        return tdRows;
    }

    public void setTdRows(TransportDocumentRows tdRows) {
        this.tdRows = tdRows;
    }

    public TransportRows getTRows() {
        return tRows;
    }

    public void setTRows(TransportRows tRows) {
        this.tRows = tRows;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public void addGoods(Goods goods){
        goodsList.add(goods);
    }

    public List<Fault> getFaultList() {
        return faultList;
    }

    public void setFaultList(List<Fault> faultList) {
        this.faultList = faultList;
    }
    public void addFault(Fault fault) {
        faultList.add(fault);
    }

    public SafetyAdvisor getSafetyAdvisorCarrier() {
        return safetyAdvisorCarrier;
    }

    public void setSafetyAdvisorCarrier(SafetyAdvisor safetyAdvisorCarrier) {
        this.safetyAdvisorCarrier = safetyAdvisorCarrier;
    }

    public SafetyAdvisor getSafetyAdvisorSender() {
        return safetyAdvisorSender;
    }

    public void setSafetyAdvisorSender(SafetyAdvisor safetyAdvisorSender) {
        this.safetyAdvisorSender = safetyAdvisorSender;
    }

    public List<Integer> getProhibitetFieldNrList() {
        return prohibitetFieldNrList;
    }

    public void setProhibitetFieldNrList(List<Integer> prohibitetFieldNrList) {
        this.prohibitetFieldNrList = prohibitetFieldNrList;
    }

    public void addProhibitedField(int nr){
        prohibitetFieldNrList.add(nr);
    }

    public boolean isAllowedToContinueTrip() {
        return allowedToContinueTrip;
    }

    public void setAllowedToContinueTrip(boolean allowedToContinueTrip) {
        this.allowedToContinueTrip = allowedToContinueTrip;
    }

    public boolean isAdmissionGiven() { return admissionGiven; }

    public void setAdmissionGiven(boolean admissionGiven) {
        this.admissionGiven = admissionGiven;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public List<Integer> getSubmissionFieldNrList() {
        return submissionFieldNrList;
    }

    public void setSubmissionFieldNrList(List<Integer> submissionFieldNrList) {
        this.submissionFieldNrList = submissionFieldNrList;
    }

    public void addSubmissionFieldNr(int nr){
        submissionFieldNrList.add(nr);
    }

    public ReportedEntity getReportedEntity() {
        return reportedEntity;
    }

    public void setReportedEntity(ReportedEntity reportedEntity) {
        this.reportedEntity = reportedEntity;
    }

    public List<String> getPenaltiesList() {
        return penaltiesList;
    }

    public void setPenaltiesList(List<String> penaltiesList) {
        this.penaltiesList = penaltiesList;
    }
    public void addPenalty(String penalty){
        penaltiesList.add(penalty);
    }
}
