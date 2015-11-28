/**
 * 
 */
package com.qrcode.service;

import java.util.List;

import com.qrcode.model.UpdateLength;

/**
 * @author harikrishna.trivedi
 *
 */
 
public interface UpdateLengthService {
 
	UpdateLength findByBarCode(String barCode);
     
    void saveUpdateLength(UpdateLength updateLength);
     
    void updateUpdateLength(UpdateLength updateLength);
     
    void deleteUpdateLengthByBarCode(String barCode);
 
    List<UpdateLength> findAllUpdateLength(); 
 
}