
package com.oracle.xmlns.apps.hcm.common.batchloader.core.loaderintegrationservice.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ZipFileName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="BusinessObjectList" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded"/>
 *         &lt;element name="BatchName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="LoadType" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="AutoLoad" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "zipFileName",
    "businessObjectList",
    "batchName",
    "loadType",
    "autoLoad"
})
@XmlRootElement(name = "submitBatch")
public class SubmitBatch {

    @XmlElement(name = "ZipFileName", required = true)
    protected String zipFileName;
    @XmlElement(name = "BusinessObjectList", required = true)
    protected List<String> businessObjectList;
    @XmlElement(name = "BatchName", required = true)
    protected String batchName;
    @XmlElement(name = "LoadType", required = true)
    protected String loadType;
    @XmlElement(name = "AutoLoad", required = true)
    protected String autoLoad;

    /**
     * Gets the value of the zipFileName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZipFileName() {
        return zipFileName;
    }

    /**
     * Sets the value of the zipFileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZipFileName(String value) {
        this.zipFileName = value;
    }

    /**
     * Gets the value of the businessObjectList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the businessObjectList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBusinessObjectList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getBusinessObjectList() {
        if (businessObjectList == null) {
            businessObjectList = new ArrayList<String>();
        }
        return this.businessObjectList;
    }

    /**
     * Gets the value of the batchName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBatchName() {
        return batchName;
    }

    /**
     * Sets the value of the batchName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBatchName(String value) {
        this.batchName = value;
    }

    /**
     * Gets the value of the loadType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoadType() {
        return loadType;
    }

    /**
     * Sets the value of the loadType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoadType(String value) {
        this.loadType = value;
    }

    /**
     * Gets the value of the autoLoad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAutoLoad() {
        return autoLoad;
    }

    /**
     * Sets the value of the autoLoad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAutoLoad(String value) {
        this.autoLoad = value;
    }

}
