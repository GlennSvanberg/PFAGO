package com.svanberggroup.pfago.Models;

public class Quantity {
    private int quantity;

    public enum QuantityType{ Kg, Liter};
    private QuantityType quantityType;

    public enum PackagingStandard{ EQ, LQ, EmptyNotCleaned};
    private PackagingStandard packagingStandard;

    public Quantity() {

    }
    public Quantity(int quantity, QuantityType quantityType, PackagingStandard packagingStandard) {
        this.quantity = quantity;
        this.quantityType = quantityType;
        this.packagingStandard = packagingStandard;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public QuantityType getQuantityType() {
        return quantityType;
    }

    public void setQuantityType(QuantityType quantityType) {
        this.quantityType = quantityType;
    }

    public PackagingStandard getPackagingStandard() {
        return packagingStandard;
    }

    public void setPackagingStandard(PackagingStandard packagingStandard) {
        this.packagingStandard = packagingStandard;
    }
}
