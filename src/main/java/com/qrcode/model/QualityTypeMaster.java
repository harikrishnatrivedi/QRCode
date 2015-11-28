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

@Entity @Table(name="QUALITY_TYPE_MST")
public class QualityTypeMaster implements Serializable {

	@Column(name = "SL_NO", nullable = false)
	private Integer slNo;

	@Id
	@Size(max = 15)
	@Column(name = "QTY_TYPE_CODE", nullable = false)
	private String qtyTypeCode;

	@Size(max = 100)
	@Column(name = "QTY_TYPE_NAME", nullable = false)
	private String qtyTypeName;

	@Size(max = 15)
	@Column(name = "QTY_TYPE_USER_CODE", nullable = false)
	private String qtyTypeUserCode;

	@Size(max = 1)
	@Column(name = "QTY_TYPE_STATUS", nullable = false)
	private String qtyTypeStatus;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "QTY_TYPE_DATE", nullable = true)
	private Date qtyTypeDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "QTY_TYPE_LAST_UPDATED_DATE", nullable = true)
	private Date qtyTypeLastUpdatedDate;
	
	@Override
	public String toString() {
		return "qualityTestMaster [slNo=" + slNo 
				+ ", qtyTypeCode=" + qtyTypeCode 
				+ ", qtyTypeName=" + qtyTypeName 
				+ ", qtyTypeUserCode=" + qtyTypeUserCode
				+ ", qtyTypeStatus=" + qtyTypeStatus 
				+ ", qtyTypeDate=" + qtyTypeDate 
				+ ", qtyTypeLastUpdatedDate=" + qtyTypeLastUpdatedDate
				+ "]";
	}
}