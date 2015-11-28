/**
 * 
 */
package com.qrcode.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.joda.time.DateTime;
import org.springframework.format.annotation.NumberFormat;

/**
 * @author harikrishna.trivedi
 *
 */


@Entity
@Table(name="BARCODE_CUTTING")
public class BarcodeCutting implements Serializable{

	@Column(name = "SL_NO", nullable = false)
	@NotBlank
	private int slNo;
	
	@Id
	@Size(max=20)
	@NotBlank
	@Column(name = "BARCODE", nullable = false)
	private String barCode;
	
	@Size(max=20)
	@NotBlank
	@Column(name = "OLD_BARCODE", nullable = false)
	private String oldBarCode;
	
	@Size(max=20)
	@NotBlank
	@Column(name = "MRN_NO", nullable = false)
	private String mrnNo;
	
	@Size(max=25)
	@NotBlank
	@Column(name = "ITEM_CODE", nullable = false)
	private String itemCode;
	
	@Column(name = "LENGTH", nullable = true)
	@Digits(integer=15, fraction=4)
	private BigDecimal length;
	
	@Column(name = "STATUS", nullable = false)
	@Size(max=1)
	private String status;
	
	@Column(name = "USER_ID", nullable = false)
	@Size(max=20)
	private String userId;
	
	@Column(name = "DATE", nullable = false)
	private DateTime date;

	@Column(name = "ITEM_DESC", nullable = true)
	@Size(max=100)
	private String itemDesc;

	@Column(name = "TOTAL_LENGTH", nullable = true)
	@Digits(integer=15, fraction=4)
	private int totalLength;
	
	@Column(name = "JOBNO", nullable = true, columnDefinition="varchar (20) default ''")
	@Size(max=20)
	private String jobNo;
	
	/**
	 * @return the slNo
	 */
	public int getSlNo() {
		return slNo;
	}

	/**
	 * @param slNo the slNo to set
	 */
	public void setSlNo(int slNo) {
		this.slNo = slNo;
	}

	/**
	 * @return the barCode
	 */
	public String getBarCode() {
		return barCode;
	}

	/**
	 * @param barCode the barCode to set
	 */
	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	/**
	 * @return the oldBarCode
	 */
	public String getOldBarCode() {
		return oldBarCode;
	}

	/**
	 * @param oldBarCode the oldBarCode to set
	 */
	public void setOldBarCode(String oldBarCode) {
		this.oldBarCode = oldBarCode;
	}

	/**
	 * @return the mrnNo
	 */
	public String getMrnNo() {
		return mrnNo;
	}

	/**
	 * @param mrnNo the mrnNo to set
	 */
	public void setMrnNo(String mrnNo) {
		this.mrnNo = mrnNo;
	}

	/**
	 * @return the itemCode
	 */
	public String getItemCode() {
		return itemCode;
	}

	/**
	 * @param itemCode the itemCode to set
	 */
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	/**
	 * @return the length
	 */
	public BigDecimal getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(BigDecimal length) {
		this.length = length;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the date
	 */
	public DateTime getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(DateTime date) {
		this.date = date;
	}

	/**
	 * @return the itemDesc
	 */
	public String getItemDesc() {
		return itemDesc;
	}

	/**
	 * @param itemDesc the itemDesc to set
	 */
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	/**
	 * @return the totalLength
	 */
	public int getTotalLength() {
		return totalLength;
	}

	/**
	 * @param totalLength the totalLength to set
	 */
	public void setTotalLength(int totalLength) {
		this.totalLength = totalLength;
	}

	/**
	 * @return the jobNo
	 */
	public String getJobNo() {
		return jobNo;
	}

	/**
	 * @param jobNo the jobNo to set
	 */
	public void setJobNo(String jobNo) {
		this.jobNo = jobNo;
	}
	
	@Override
    public String toString() {
        return "barCodeCutting [slNo=" + slNo
        		+ ", barCode=" + barCode
        		+ ", oldBarCode=" + oldBarCode
        		+", mrnNo=" + mrnNo 
        		+", itemCode=" + itemCode
        		+", length=" + length
        		+", status=" + status
        		+", userId=" + userId
        		+", date=" + date
        		+", itemDesc=" + itemDesc
        		+", totalLength=" + totalLength
        		+", jobNo=" + jobNo +"]";
    }
}
