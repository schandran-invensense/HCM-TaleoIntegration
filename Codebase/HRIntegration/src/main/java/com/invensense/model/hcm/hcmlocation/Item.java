
package com.invensense.model.hcm.hcmlocation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "LocationId",
    "SetId",
    "TelephoneNumber1",
    "TelephoneNumber2",
    "TelephoneNumber3",
    "EmailAddress",
    "ShipToSiteFlag",
    "ReceivingSiteFlag",
    "BillToSiteFlag",
    "OfficeSiteFlag",
    "LocationCode",
    "LocationName",
    "Description",
    "MainAddressId",
    "AddressLine1",
    "AddressLine2",
    "AddressLine3",
    "AddressLine4",
    "Country",
    "PostalCode",
    "Region1",
    "Region2",
    "Region3",
    "TimezoneName",
    "TownOrCity",
    "EffectiveStartDate",
    "EffectiveEndDate",
    "CreationDate",
    "LastUpdateDate",
    "links"
})
public class Item {

    @JsonProperty("LocationId")
    private Integer locationId;
    @JsonProperty("SetId")
    private Integer setId;
    @JsonProperty("TelephoneNumber1")
    private String telephoneNumber1;
    @JsonProperty("TelephoneNumber2")
    private Object telephoneNumber2;
    @JsonProperty("TelephoneNumber3")
    private Object telephoneNumber3;
    @JsonProperty("EmailAddress")
    private Object emailAddress;
    @JsonProperty("ShipToSiteFlag")
    private Boolean shipToSiteFlag;
    @JsonProperty("ReceivingSiteFlag")
    private Boolean receivingSiteFlag;
    @JsonProperty("BillToSiteFlag")
    private Boolean billToSiteFlag;
    @JsonProperty("OfficeSiteFlag")
    private Boolean officeSiteFlag;
    @JsonProperty("LocationCode")
    private String locationCode;
    @JsonProperty("LocationName")
    private String locationName;
    @JsonProperty("Description")
    private String description;
    @JsonProperty("MainAddressId")
    private Integer mainAddressId;
    @JsonProperty("AddressLine1")
    private String addressLine1;
    @JsonProperty("AddressLine2")
    private String addressLine2;
    @JsonProperty("AddressLine3")
    private Object addressLine3;
    @JsonProperty("AddressLine4")
    private String addressLine4;
    @JsonProperty("Country")
    private String country;
    @JsonProperty("PostalCode")
    private String postalCode;
    @JsonProperty("Region1")
    private String region1;
    @JsonProperty("Region2")
    private String region2;
    @JsonProperty("Region3")
    private String region3;
    @JsonProperty("TimezoneName")
    private Object timezoneName;
    @JsonProperty("TownOrCity")
    private String townOrCity;
    @JsonProperty("EffectiveStartDate")
    private String effectiveStartDate;
    @JsonProperty("EffectiveEndDate")
    private String effectiveEndDate;
    @JsonProperty("CreationDate")
    private String creationDate;
    @JsonProperty("LastUpdateDate")
    private String lastUpdateDate;
    @JsonProperty("links")
    private List<Link> links = new ArrayList<Link>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The locationId
     */
    @JsonProperty("LocationId")
    public Integer getLocationId() {
        return locationId;
    }

    /**
     * 
     * @param locationId
     *     The LocationId
     */
    @JsonProperty("LocationId")
    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    /**
     * 
     * @return
     *     The setId
     */
    @JsonProperty("SetId")
    public Integer getSetId() {
        return setId;
    }

    /**
     * 
     * @param setId
     *     The SetId
     */
    @JsonProperty("SetId")
    public void setSetId(Integer setId) {
        this.setId = setId;
    }

    /**
     * 
     * @return
     *     The telephoneNumber1
     */
    @JsonProperty("TelephoneNumber1")
    public String getTelephoneNumber1() {
        return telephoneNumber1;
    }

    /**
     * 
     * @param telephoneNumber1
     *     The TelephoneNumber1
     */
    @JsonProperty("TelephoneNumber1")
    public void setTelephoneNumber1(String telephoneNumber1) {
        this.telephoneNumber1 = telephoneNumber1;
    }

    /**
     * 
     * @return
     *     The telephoneNumber2
     */
    @JsonProperty("TelephoneNumber2")
    public Object getTelephoneNumber2() {
        return telephoneNumber2;
    }

    /**
     * 
     * @param telephoneNumber2
     *     The TelephoneNumber2
     */
    @JsonProperty("TelephoneNumber2")
    public void setTelephoneNumber2(Object telephoneNumber2) {
        this.telephoneNumber2 = telephoneNumber2;
    }

    /**
     * 
     * @return
     *     The telephoneNumber3
     */
    @JsonProperty("TelephoneNumber3")
    public Object getTelephoneNumber3() {
        return telephoneNumber3;
    }

    /**
     * 
     * @param telephoneNumber3
     *     The TelephoneNumber3
     */
    @JsonProperty("TelephoneNumber3")
    public void setTelephoneNumber3(Object telephoneNumber3) {
        this.telephoneNumber3 = telephoneNumber3;
    }

    /**
     * 
     * @return
     *     The emailAddress
     */
    @JsonProperty("EmailAddress")
    public Object getEmailAddress() {
        return emailAddress;
    }

    /**
     * 
     * @param emailAddress
     *     The EmailAddress
     */
    @JsonProperty("EmailAddress")
    public void setEmailAddress(Object emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * 
     * @return
     *     The shipToSiteFlag
     */
    @JsonProperty("ShipToSiteFlag")
    public Boolean getShipToSiteFlag() {
        return shipToSiteFlag;
    }

    /**
     * 
     * @param shipToSiteFlag
     *     The ShipToSiteFlag
     */
    @JsonProperty("ShipToSiteFlag")
    public void setShipToSiteFlag(Boolean shipToSiteFlag) {
        this.shipToSiteFlag = shipToSiteFlag;
    }

    /**
     * 
     * @return
     *     The receivingSiteFlag
     */
    @JsonProperty("ReceivingSiteFlag")
    public Boolean getReceivingSiteFlag() {
        return receivingSiteFlag;
    }

    /**
     * 
     * @param receivingSiteFlag
     *     The ReceivingSiteFlag
     */
    @JsonProperty("ReceivingSiteFlag")
    public void setReceivingSiteFlag(Boolean receivingSiteFlag) {
        this.receivingSiteFlag = receivingSiteFlag;
    }

    /**
     * 
     * @return
     *     The billToSiteFlag
     */
    @JsonProperty("BillToSiteFlag")
    public Boolean getBillToSiteFlag() {
        return billToSiteFlag;
    }

    /**
     * 
     * @param billToSiteFlag
     *     The BillToSiteFlag
     */
    @JsonProperty("BillToSiteFlag")
    public void setBillToSiteFlag(Boolean billToSiteFlag) {
        this.billToSiteFlag = billToSiteFlag;
    }

    /**
     * 
     * @return
     *     The officeSiteFlag
     */
    @JsonProperty("OfficeSiteFlag")
    public Boolean getOfficeSiteFlag() {
        return officeSiteFlag;
    }

    /**
     * 
     * @param officeSiteFlag
     *     The OfficeSiteFlag
     */
    @JsonProperty("OfficeSiteFlag")
    public void setOfficeSiteFlag(Boolean officeSiteFlag) {
        this.officeSiteFlag = officeSiteFlag;
    }

    /**
     * 
     * @return
     *     The locationCode
     */
    @JsonProperty("LocationCode")
    public String getLocationCode() {
        return locationCode;
    }

    /**
     * 
     * @param locationCode
     *     The LocationCode
     */
    @JsonProperty("LocationCode")
    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    /**
     * 
     * @return
     *     The locationName
     */
    @JsonProperty("LocationName")
    public String getLocationName() {
        return locationName;
    }

    /**
     * 
     * @param locationName
     *     The LocationName
     */
    @JsonProperty("LocationName")
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    /**
     * 
     * @return
     *     The description
     */
    @JsonProperty("Description")
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The Description
     */
    @JsonProperty("Description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The mainAddressId
     */
    @JsonProperty("MainAddressId")
    public Integer getMainAddressId() {
        return mainAddressId;
    }

    /**
     * 
     * @param mainAddressId
     *     The MainAddressId
     */
    @JsonProperty("MainAddressId")
    public void setMainAddressId(Integer mainAddressId) {
        this.mainAddressId = mainAddressId;
    }

    /**
     * 
     * @return
     *     The addressLine1
     */
    @JsonProperty("AddressLine1")
    public String getAddressLine1() {
        return addressLine1;
    }

    /**
     * 
     * @param addressLine1
     *     The AddressLine1
     */
    @JsonProperty("AddressLine1")
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    /**
     * 
     * @return
     *     The addressLine2
     */
    @JsonProperty("AddressLine2")
    public String getAddressLine2() {
        return addressLine2;
    }

    /**
     * 
     * @param addressLine2
     *     The AddressLine2
     */
    @JsonProperty("AddressLine2")
    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    /**
     * 
     * @return
     *     The addressLine3
     */
    @JsonProperty("AddressLine3")
    public Object getAddressLine3() {
        return addressLine3;
    }

    /**
     * 
     * @param addressLine3
     *     The AddressLine3
     */
    @JsonProperty("AddressLine3")
    public void setAddressLine3(Object addressLine3) {
        this.addressLine3 = addressLine3;
    }

    /**
     * 
     * @return
     *     The addressLine4
     */
    @JsonProperty("AddressLine4")
    public String getAddressLine4() {
        return addressLine4;
    }

    /**
     * 
     * @param addressLine4
     *     The AddressLine4
     */
    @JsonProperty("AddressLine4")
    public void setAddressLine4(String addressLine4) {
        this.addressLine4 = addressLine4;
    }

    /**
     * 
     * @return
     *     The country
     */
    @JsonProperty("Country")
    public String getCountry() {
        return country;
    }

    /**
     * 
     * @param country
     *     The Country
     */
    @JsonProperty("Country")
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 
     * @return
     *     The postalCode
     */
    @JsonProperty("PostalCode")
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * 
     * @param postalCode
     *     The PostalCode
     */
    @JsonProperty("PostalCode")
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * 
     * @return
     *     The region1
     */
    @JsonProperty("Region1")
    public String getRegion1() {
        return region1;
    }

    /**
     * 
     * @param region1
     *     The Region1
     */
    @JsonProperty("Region1")
    public void setRegion1(String region1) {
        this.region1 = region1;
    }

    /**
     * 
     * @return
     *     The region2
     */
    @JsonProperty("Region2")
    public String getRegion2() {
        return region2;
    }

    /**
     * 
     * @param region2
     *     The Region2
     */
    @JsonProperty("Region2")
    public void setRegion2(String region2) {
        this.region2 = region2;
    }

    /**
     * 
     * @return
     *     The region3
     */
    @JsonProperty("Region3")
    public String getRegion3() {
        return region3;
    }

    /**
     * 
     * @param region3
     *     The Region3
     */
    @JsonProperty("Region3")
    public void setRegion3(String region3) {
        this.region3 = region3;
    }

    /**
     * 
     * @return
     *     The timezoneName
     */
    @JsonProperty("TimezoneName")
    public Object getTimezoneName() {
        return timezoneName;
    }

    /**
     * 
     * @param timezoneName
     *     The TimezoneName
     */
    @JsonProperty("TimezoneName")
    public void setTimezoneName(Object timezoneName) {
        this.timezoneName = timezoneName;
    }

    /**
     * 
     * @return
     *     The townOrCity
     */
    @JsonProperty("TownOrCity")
    public String getTownOrCity() {
        return townOrCity;
    }

    /**
     * 
     * @param townOrCity
     *     The TownOrCity
     */
    @JsonProperty("TownOrCity")
    public void setTownOrCity(String townOrCity) {
        this.townOrCity = townOrCity;
    }

    /**
     * 
     * @return
     *     The effectiveStartDate
     */
    @JsonProperty("EffectiveStartDate")
    public String getEffectiveStartDate() {
        return effectiveStartDate;
    }

    /**
     * 
     * @param effectiveStartDate
     *     The EffectiveStartDate
     */
    @JsonProperty("EffectiveStartDate")
    public void setEffectiveStartDate(String effectiveStartDate) {
        this.effectiveStartDate = effectiveStartDate;
    }

    /**
     * 
     * @return
     *     The effectiveEndDate
     */
    @JsonProperty("EffectiveEndDate")
    public String getEffectiveEndDate() {
        return effectiveEndDate;
    }

    /**
     * 
     * @param effectiveEndDate
     *     The EffectiveEndDate
     */
    @JsonProperty("EffectiveEndDate")
    public void setEffectiveEndDate(String effectiveEndDate) {
        this.effectiveEndDate = effectiveEndDate;
    }

    /**
     * 
     * @return
     *     The creationDate
     */
    @JsonProperty("CreationDate")
    public String getCreationDate() {
        return creationDate;
    }

    /**
     * 
     * @param creationDate
     *     The CreationDate
     */
    @JsonProperty("CreationDate")
    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * 
     * @return
     *     The lastUpdateDate
     */
    @JsonProperty("LastUpdateDate")
    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    /**
     * 
     * @param lastUpdateDate
     *     The LastUpdateDate
     */
    @JsonProperty("LastUpdateDate")
    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    /**
     * 
     * @return
     *     The links
     */
    @JsonProperty("links")
    public List<Link> getLinks() {
        return links;
    }

    /**
     * 
     * @param links
     *     The links
     */
    @JsonProperty("links")
    public void setLinks(List<Link> links) {
        this.links = links;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
