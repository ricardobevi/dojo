package com.mercadolibre.dojos.dto;



import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent the different shipping methods available. Example: Send to selected destination or local pick up.
 * Created by mbel on 1/12/15.
 */
public class CheckoutShippingMethodDto {

    private String heading;
    private String title;
    private String subtitle;
//    private ShippingOptionsGroupsDto shippingOptionsGroups;
    @SerializedName("shipping_selections")
    private List<ShippingSelectionDto> shippingSelections;

    public CheckoutShippingMethodDto() {
        // empty constructor
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

//    public ShippingOptionsGroupsDto getShippingOptionsGroups() {
//        return shippingOptionsGroups;
//    }
//
//    public void setShippingOptionsGroups(ShippingOptionsGroupsDto shippingOptionsGroups) {
//        this.shippingOptionsGroups = shippingOptionsGroups;
//    }

    public List<ShippingSelectionDto> getShippingSelections() {
        return new ArrayList<ShippingSelectionDto>(shippingSelections);
    }

    public void setShippingSelections(List<ShippingSelectionDto> shippingSelections) {
        this.shippingSelections = shippingSelections;
    }

    public String getHeading() {
        return heading;
    }

}
