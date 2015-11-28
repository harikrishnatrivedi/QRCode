/**
 * 
 */
package com.qrcode.dao;

import java.util.List;
import com.qrcode.model.QualityTypeMaster;

/**
 * @author harikrishna.trivedi
 *
 */
public interface QualityTypeMasterDao {
 
	QualityTypeMaster findByQltyTypeMstCode(String qltyTypeMstCode);
 
    void saveQualityTypeMaster(QualityTypeMaster qualityTypeMaster);
     
    void deleteQualityTypeMasterByQltyTypeMstCode(String qltyTypeMstCode);
     
    List<QualityTypeMaster> findAllQualityTypeMaster();
    
}