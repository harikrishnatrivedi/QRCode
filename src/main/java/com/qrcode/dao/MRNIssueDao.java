/**
 * 
 */
package com.qrcode.dao;

import java.math.BigDecimal;
import java.util.List;

import com.qrcode.model.MRNIssue;

/**
 * @author harikrishna.trivedi
 *
 */
public interface MRNIssueDao {
 
	MRNIssue findByItemNo(Integer entryNo);
 
    void saveMRNIssue(MRNIssue mRNIssue);
     
    void deleteMRNIssueByItemNo(Integer entryNo);
     
    List<MRNIssue> findAllMRNIssue();
 
}