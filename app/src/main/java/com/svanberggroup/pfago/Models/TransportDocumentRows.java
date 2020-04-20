package com.svanberggroup.pfago.Models;

import com.svanberggroup.pfago.R;

public class TransportDocumentRows {

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

    public ControlRow getGoodsDeclarationRow() {
        return goodsDeclarationRow;
    }

    public void setGoodsDeclarationRow(ControlRow goodsDeclarationRow) {
        this.goodsDeclarationRow = goodsDeclarationRow;
    }

    public Declaration getDeclaration() {
        return declaration;
    }

    public void setDeclaration(Declaration declaration) {
        this.declaration = declaration;
    }

    public ControlRow getWrittenInstructionsRow() {
        return writtenInstructionsRow;
    }

    public void setWrittenInstructionsRow(ControlRow writtenInstructionsRow) {
        this.writtenInstructionsRow = writtenInstructionsRow;
    }

    public ControlRow getApprovalRow() {
        return approvalRow;
    }

    public void setApprovalRow(ControlRow approvalRow) {
        this.approvalRow = approvalRow;
    }

    public Approval getApproval() {
        return approval;
    }

    public void setApproval(Approval approval) {
        this.approval = approval;
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
}
