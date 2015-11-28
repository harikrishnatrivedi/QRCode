/**
 * 
 */
package com.qrcode.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * @author harikrishna.trivedi
 *
 */

@Entity
@Table(name = "[Dee Development Engineers Ltd_$MRN Issue]")
public class MRNIssue {

	@Column(name = "[Item No_]", nullable = true)
	@Size(max = 20)
	private String itemNo;

	@Id
	@Column(name = "[Entry No_]", nullable = false)
	private Integer entryNo;

	@Size(max = 20)
	@Column(name = "[GE No_]", nullable = true)
	private String geNo;

	@Column(name = "[No of Pcs]", nullable = true)
	private Integer noOfPcs;

	@Column(name = "[IM Line No]", nullable = true)
	private Integer imLineNo;

	@Column(name = "[Qty M]", precision = 38, scale = 20, nullable = true)
	private BigDecimal qtyM;

	@Column(name = "[Qty Kg]", precision = 38, scale = 20, nullable = true)
	private BigDecimal qtyKg;

	@Column(name = "[PO No]", nullable = true)
	@Size(max = 20)
	private String poNo;

	@Column(name = "Posted", nullable = true)
	private Integer posted;

	@Column(name = "Type", columnDefinition = "TINYINT", length = 1, nullable = true)
	private Boolean type;

	@Column(name = "[Barcode Update Qty]", precision = 38, scale = 20, nullable = true)
	private BigDecimal barcodeUpdateQty;

	@Column(name = "[FA Scanned]", columnDefinition = "TINYINT", length = 1, nullable = true)
	private Boolean faScanned;

	@Size(max = 20)
	@Column(name = "[Control No_]", nullable = true)
	private String controlNo;

	@Column(name = "[Heat No_]", nullable = true)
	@Size(max = 20)
	private String heatNo;

	@Column(name = "[Document Type]", nullable = true)
	private Integer documentType;

	@Column(name = "[FGS Transfered]", columnDefinition = "TINYINT", length = 1, nullable = true)
	private Boolean fgsTransfered;

	/**
	 * @return the itemNo
	 */
	public String getItemNo() {
		return itemNo;
	}

	/**
	 * @param itemNo
	 *            the itemNo to set
	 */
	public void setItemNo(String itemNo) {
		this.itemNo = itemNo;
	}

	/**
	 * @return the entryNo
	 */
	public Integer getEntryNo() {
		return entryNo;
	}

	/**
	 * @param entryNo
	 *            the entryNo to set
	 */
	public void setEntryNo(Integer entryNo) {
		this.entryNo = entryNo;
	}

	/**
	 * @return the geNo
	 */
	public String getGeNo() {
		return geNo;
	}

	/**
	 * @param geNo
	 *            the geNo to set
	 */
	public void setGeNo(String geNo) {
		this.geNo = geNo;
	}

	/**
	 * @return the noOfPcs
	 */
	public Integer getNoOfPcs() {
		return noOfPcs;
	}

	/**
	 * @param noOfPcs
	 *            the noOfPcs to set
	 */
	public void setNoOfPcs(Integer noOfPcs) {
		this.noOfPcs = noOfPcs;
	}

	/**
	 * @return the imLineNo
	 */
	public Integer getImLineNo() {
		return imLineNo;
	}

	/**
	 * @param imLineNo
	 *            the imLineNo to set
	 */
	public void setImLineNo(Integer imLineNo) {
		this.imLineNo = imLineNo;
	}

	/**
	 * @return the qtyM
	 */
	public BigDecimal getQtyM() {
		return qtyM;
	}

	/**
	 * @param qtyM
	 *            the qtyM to set
	 */
	public void setQtyM(BigDecimal qtyM) {
		this.qtyM = qtyM;
	}

	/**
	 * @return the qtyKg
	 */
	public BigDecimal getQtyKg() {
		return qtyKg;
	}

	/**
	 * @param qtyKg
	 *            the qtyKg to set
	 */
	public void setQtyKg(BigDecimal qtyKg) {
		this.qtyKg = qtyKg;
	}

	/**
	 * @return the poNo
	 */
	public String getPoNo() {
		return poNo;
	}

	/**
	 * @param poNo
	 *            the poNo to set
	 */
	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}

	/**
	 * @return the posted
	 */
	public Integer getPosted() {
		return posted;
	}

	/**
	 * @param posted
	 *            the posted to set
	 */
	public void setPosted(Integer posted) {
		this.posted = posted;
	}

	/**
	 * @return the type
	 */
	public Boolean getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(Boolean type) {
		this.type = type;
	}

	/**
	 * @return the barcodeUpdateQty
	 */
	public BigDecimal getBarcodeUpdateQty() {
		return barcodeUpdateQty;
	}

	/**
	 * @param barcodeUpdateQty
	 *            the barcodeUpdateQty to set
	 */
	public void setBarcodeUpdateQty(BigDecimal barcodeUpdateQty) {
		this.barcodeUpdateQty = barcodeUpdateQty;
	}

	/**
	 * @return the faScanned
	 */
	public Boolean getFaScanned() {
		return faScanned;
	}

	/**
	 * @param faScanned
	 *            the faScanned to set
	 */
	public void setFaScanned(Boolean faScanned) {
		this.faScanned = faScanned;
	}

	/**
	 * @return the controlNo
	 */
	public String getControlNo() {
		return controlNo;
	}

	/**
	 * @param controlNo
	 *            the controlNo to set
	 */
	public void setControlNo(String controlNo) {
		this.controlNo = controlNo;
	}

	/**
	 * @return the heatNo
	 */
	public String getHeatNo() {
		return heatNo;
	}

	/**
	 * @param heatNo
	 *            the heatNo to set
	 */
	public void setHeatNo(String heatNo) {
		this.heatNo = heatNo;
	}

	/**
	 * @return the documentType
	 */
	public Integer getDocumentType() {
		return documentType;
	}

	/**
	 * @param documentType
	 *            the documentType to set
	 */
	public void setDocumentType(Integer documentType) {
		this.documentType = documentType;
	}

	/**
	 * @return the fgsTransfered
	 */
	public Boolean getFgsTransfered() {
		return fgsTransfered;
	}

	/**
	 * @param fgsTransfered
	 *            the fgsTransfered to set
	 */
	public void setFgsTransfered(Boolean fgsTransfered) {
		this.fgsTransfered = fgsTransfered;
	}

	@Override
	public String toString() {
		return "mrnIssue [itemNo=" + itemNo + 
				", entryNo=" + entryNo + 
				", geNo=" + geNo + 
				", noOfPcs=" + noOfPcs + 
				", imLineNo=" + imLineNo + 
				", qtyM=" + qtyM + 
				", qtyKg=" + qtyKg + 
				", poNo=" + poNo + 
				", posted=" + posted + 
				", type=" + type + 
				", barcodeUpdateQty=" + barcodeUpdateQty + 
				", faScanned=" + faScanned + 
				", controlNo=" + controlNo + 
				", heatNo=" + heatNo + 
				", documentType=" + documentType + 
				", fgsTransfered=" + fgsTransfered + "]";
	}
}
