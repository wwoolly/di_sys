
package ru.nsu.fit.kn.messages;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>{@code
 * <complexType>
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="RequestId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="PartNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="PartCount" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="Hash" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="MaxLength" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         <element name="Alphabet">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <sequence>
 *                   <element name="symbols" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 </sequence>
 *               </restriction>
 *             </complexContent>
 *           </complexType>
 *         </element>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "requestId",
    "partNumber",
    "partCount",
    "hash",
    "maxLength",
    "alphabet"
})
@XmlRootElement(name = "CrackHashManagerRequest")
public class CrackHashManagerRequest {

    @XmlElement(name = "RequestId", required = true)
    protected String requestId;
    @XmlElement(name = "PartNumber")
    protected int partNumber;
    @XmlElement(name = "PartCount")
    protected int partCount;
    @XmlElement(name = "Hash", required = true)
    protected String hash;
    @XmlElement(name = "MaxLength")
    protected int maxLength;
    @XmlElement(name = "Alphabet", required = true)
    protected CrackHashManagerRequest.Alphabet alphabet;

    /**
     * Gets the value of the requestId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequestId() {
        return requestId;
    }

    /**
     * Sets the value of the requestId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequestId(String value) {
        this.requestId = value;
    }

    /**
     * Gets the value of the partNumber property.
     * 
     */
    public int getPartNumber() {
        return partNumber;
    }

    /**
     * Sets the value of the partNumber property.
     * 
     */
    public void setPartNumber(int value) {
        this.partNumber = value;
    }

    /**
     * Gets the value of the partCount property.
     * 
     */
    public int getPartCount() {
        return partCount;
    }

    /**
     * Sets the value of the partCount property.
     * 
     */
    public void setPartCount(int value) {
        this.partCount = value;
    }

    /**
     * Gets the value of the hash property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHash() {
        return hash;
    }

    /**
     * Sets the value of the hash property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHash(String value) {
        this.hash = value;
    }

    /**
     * Gets the value of the maxLength property.
     * 
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * Sets the value of the maxLength property.
     * 
     */
    public void setMaxLength(int value) {
        this.maxLength = value;
    }

    /**
     * Gets the value of the alphabet property.
     * 
     * @return
     *     possible object is
     *     {@link CrackHashManagerRequest.Alphabet }
     *     
     */
    public CrackHashManagerRequest.Alphabet getAlphabet() {
        return alphabet;
    }

    /**
     * Sets the value of the alphabet property.
     * 
     * @param value
     *     allowed object is
     *     {@link CrackHashManagerRequest.Alphabet }
     *     
     */
    public void setAlphabet(CrackHashManagerRequest.Alphabet value) {
        this.alphabet = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>{@code
     * <complexType>
     *   <complexContent>
     *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       <sequence>
     *         <element name="symbols" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
     *       </sequence>
     *     </restriction>
     *   </complexContent>
     * </complexType>
     * }</pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "symbols"
    })
    public static class Alphabet {

        protected List<String> symbols;

        /**
         * Gets the value of the symbols property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the Jakarta XML Binding object.
         * This is why there is not a {@code set} method for the symbols property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getSymbols().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         * @return
         *     The value of the symbols property.
         */
        public List<String> getSymbols() {
            if (symbols == null) {
                symbols = new ArrayList<>();
            }
            return this.symbols;
        }

    }

}
