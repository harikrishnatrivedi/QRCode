/**
 * 
 */
package com.qrcode.dao;

import java.util.List;
import com.qrcode.model.QualitySubTypeMaster;

/**
 * @author harikrishna.trivedi
 *
 */
public interface QualitySubTypeMasterDao {
 
	QualitySubTypeMaster findByQltySubTypeMasterCode(String qltySubTypeMasterCode);
 
    void saveQualitySubTypeMaster(QualitySubTypeMaster qualitySubTypeMaster);
     
    void deleteQualitySubTypeMasterByQltySubTypeMasterCode(String qltySubTypeMasterCode);
     
    List<QualitySubTypeMaster> findAllQualitySubTypeMaster();
    
}