package com.svanberggroup.pfago.Models;

import com.svanberggroup.pfago.R;

public class Quantity {
    private int quantity;

    public enum QuantityType{
        KG(R.string.kg),
        Liter(R.string.liter);

        public final int label;
        QuantityType(int label) {
            this.label = label;
        }

    };
    private QuantityType quantityType;

    public enum PackagingStandard{
        EQ(R.string.eq),
        LQ(R.string.lq),
        EmptyNotCleaned(R.string.empty_not_cleaned);

        public final int label;
        PackagingStandard(int label) {
            this.label = label;
        }
    };

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
