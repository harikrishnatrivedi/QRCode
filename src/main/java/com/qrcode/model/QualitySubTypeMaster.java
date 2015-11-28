/**
 * 
 */
package com.qrcode.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

/**
 * @author harikrishna.trivedi
 *
 */

@Entity @Table(name="QUALITY_SUB_TYPE_MST")
public class QualitySubTypeMaster implements Serializable {

	@Column(name = "SL_NO", nullable = false)
	private Integer slNo;

	@Id
	@Size(max = 15)
    @Column(name = "QTY_SUB_TYPE_CODE", nullable = false)
	private String qtySubTypeCode;

	@Size(max = 50)
	@Column(name = "QTY_SUB_TYPE_NAME", nullable = false)
	private String qtySubTypeName;

	@Size(max = 15)
	@Column(name = "QTY_TYPE_CODE", nullable = true)
	private String qtyTypeCode;

	@Size(max = 50)
	@Column(name = "QTY_TYPE_NAME", nullable = true)
	private String qtyTypeName;

	@Size(max = 50)
	@Column(name = "QTY_SUB_TYPE_USER_CODE", nullable = false)
	private String qtySubTypeUserCode;

	@Size(max = 1)
	@Column(name = "QTY_SUB_TYPE_STATUS", nullable = false)
	private String qtySubTypeStatus;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "QTY_SUB_TYPE_DATE", nullable = true)
	private Date qtySubTypeDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "QTY_SUB_TYPE_LAST_UPDATED_DATE", nullable = true)
	private Date qtySubTypeLastUpdatedDate;

	@Override
	public String toString() {
		return "barCodeCutting [slNo=" + slNo 
				+ ", qtySubTypeCode=" + qtySubTypeCode 
				+ ", qtySubTypeName=" + qtySubTypeName 
				+ ", qtySubTypeUserCode=" + qtySubTypeUserCode
				+ ", qtySubTypeStatus=" + qtySubTypeStatus 
				+ ", qtySubTypeDate=" + qtySubTypeDate 
				+ ", qtySubTypeLastUpdatedDate=" + qtySubTypeLastUpdatedDate 
				+ "]";
	}
}