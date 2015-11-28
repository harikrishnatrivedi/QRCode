/**
 * General Controller
 * 
 */
package com.qrcode.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

import java.util.Locale;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.testng.mustache.Model;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;

import com.qrcode.model.MainGRN;
import com.qrcode.model.POBarcode;
import com.qrcode.model.UpdateLength;
import com.qrcode.service.MainGRNService;
import com.qrcode.service.POBarcodeService;
import com.qrcode.service.UpdateLengthService;

/**
 * @author harikrishna.trivedi
 *
 */
@Controller
@RequestMapping("/")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, // 10 MB
maxFileSize = 1024 * 1024 * 10, // 10 MB
maxRequestSize = 1024 * 1024 * 10)
public class GeneralController {
 
    @Autowired
    UpdateLengthService service;
    
    @Autowired
    POBarcodeService pObarCodeService;
    
    @Autowired
    MainGRNService mainGRNService;
    
    @Autowired
    MessageSource messageSource;
 
    /*
     * This method will list all existing employees.
     */
    @RequestMapping(value = {"/",  "/scanLengthBarCode" }, method = RequestMethod.GET)
    public String scanBarCodeForLength(ModelMap model) {
    	UpdateLength updateLength = new UpdateLength();
        model.addAttribute("updateLength", updateLength);
        System.out.println("updateLength : "+updateLength);
        return "barcodedescanlength";
    }
 
    /*
     * This method will provide the medium to search existing employee.
     */
    @RequestMapping(value = {"/",  "/scanLengthBarCode" }, method = RequestMethod.POST)
    public String getBarCodeLengthDtl(UpdateLength updateLength, BindingResult result, ModelMap redirectedModel) {
    	System.out.println("updateLength:::::::::::::::::"+updateLength);
    	System.out.println("updateLength.getBarCode() : "+updateLength.getBarCode());
    	POBarcode pOBarcode=pObarCodeService.findByBarCode(updateLength.getBarCode());
    	if(pOBarcode==null) {
    		FieldError noBarcodeFoundError =new FieldError("barcode","barCode",messageSource.getMessage("barcode.notfound", new String[]{updateLength.getBarCode()}, Locale.getDefault()));
            result.addError(noBarcodeFoundError);
    		return "barcodedescanlength";
    	}else if(pOBarcode.getMrnNo()!=null) {
    		System.out.println("System.out.println(pOBarcode.getMrnNo());" + pOBarcode.getMrnNo());
    		FieldError mRNGeneratedError =new FieldError("barCode","barCode",messageSource.getMessage("barcode.MRNIssued", new String[]{updateLength.getBarCode()}, Locale.getDefault()));
            result.addError(mRNGeneratedError);
    		return "barcodedescanlength";
    	}
    	System.out.println((pOBarcode.getMrnNo()!=null));
    	updateLength.setBarCode(pOBarcode.getBarCode());
    	updateLength.setItem(pOBarcode.getItem());
    	updateLength.setItemDesc(pOBarcode.getProductName());
    	updateLength.setOldLength(pOBarcode.getLength());
    	System.out.println("updateLength:::::::"+updateLength);
    	redirectedModel.clear();
    	redirectedModel.addAttribute("updateLength", updateLength);
    	
    	return "barcodedescanlength";
    }
    
    @RequestMapping(value = {"/updateLengthForBarCode" }, method = RequestMethod.POST)
    public String editBarCodeLengthDtl(UpdateLength lengthUpdate, ModelMap redirectedModel) {
    	
    	
    	System.out.println("lengthUpdate.getLength() : "+lengthUpdate.getLength());
    	POBarcode pOBarcode=pObarCodeService.findByBarCode(lengthUpdate.getBarCode());
    	pOBarcode.setLength(lengthUpdate.getLength());
    	System.out.println("before pobarcode update");
    	pObarCodeService.updatePOBarcode(pOBarcode);
    	System.out.println("after pobarcode update");
    	System.out.println("before MainGRN get pOBarcode.getDocNo() : "+pOBarcode.getDocNo());
    	MainGRN mainGRN=mainGRNService.findByDocNo(pOBarcode.getDocNo());
    	System.out.println("after MainGRN get");
    	System.out.println("mainGRN.getQuantity() : "+mainGRN.getQuantity());
    	//BigDecimal totLength=pObarCodeService.countBarcodeByDocNo(pOBarcode.getDocNo());
    	BigDecimal totLength=new BigDecimal(0);
    	//System.out.println("lengthUpdate.getOldLength() : "+lengthUpdate.getOldLength().toString());
    	//System.out.println("lengthUpdate.getLength() : "+lengthUpdate.getLength().toString());
    	System.out.println("lengthUpdate.getOldLength() : "+lengthUpdate.getOldLength());
    	if(lengthUpdate.getOldLength() == null) {
    		System.out.println("in********************");
    		totLength=lengthUpdate.getLength();
    	}else {
	    	if(lengthUpdate.getOldLength()!=null && !lengthUpdate.getOldLength().toString().isEmpty()) {
	    		if(mainGRN.getQuantity() != null && !mainGRN.getQuantity().toString().isEmpty()) {
	    			if((lengthUpdate.getLength()).compareTo((lengthUpdate.getOldLength()))==0) 
	    				totLength = mainGRN.getQuantity();
	    			else 
	    				totLength = lengthUpdate.getLength().subtract(lengthUpdate.getOldLength());
	    			
	    		} else {
	    			totLength=lengthUpdate.getLength();
	    		}
	    	} else {
	    		totLength=lengthUpdate.getLength();
	    	}
    	}
    	System.out.println("totLength  :  "+totLength);
    	mainGRN.setQuantity(mainGRN.getQuantity().add(totLength));
    	System.out.println("before MainGRN save");
    	System.out.println("mainGRN : "+mainGRN);
    	mainGRNService.updateMainGRN(mainGRN);
    	System.out.println("after MainGRN save");
    	return "success";
    }
    
    @RequestMapping(value = "/getScanBarcode", method = RequestMethod.GET) 
    public String getAbc(HttpServletRequest request) {
    	return "storeinventorybarcodedetails";
    }
    
    @RequestMapping(value = "/getScanBarcode", method = {RequestMethod.POST, RequestMethod.HEAD},// headers = "Content-Type=multipart/form-data",  
    	     consumes = MediaType.ALL_VALUE)// headers = "Content-Type=application/x-www-form-urlencoded",  headers = "Content-Type=multipart/form-data", method = RequestMethod.POST)//headers = "application/x-www-form-urlencoded",  ------------ Content-Type=application/x-www-form-urlencoded ---consumes = MediaType.MULTIPART_FORM_DATA_VALUE  --- multipart/form-data
    public @ResponseBody String getScanBarcodeOl(HttpServletRequest request) { //@RequestParam(value = "abc", defaultValue="yyy") String abc,

    	String qrBarCode="error";
    	System.out.println("123");
   	 
   	 Part part;
   	 Result result=null;
        try {
       	  part = request.getPart("blob");
       	  
       	  
           InputStream is = part.getInputStream();
   	     BufferedImage image=ImageIO.read(is);
   	     System.out.println("3");
   	     if (image != null) {
   	     	System.out.println("5");
   	       LuminanceSource source=new BufferedImageLuminanceSource(image);
   	       System.out.println("6");
   	       BinaryBitmap bitmap=new BinaryBitmap(new HybridBinarizer(source));
   	       System.out.println("7");
   	       result = new MultiFormatReader().decode(bitmap);
   	       //result=reader.decode(bitmap);
   	       System.out.println("8");
   	       System.out.println("Result Barcode/QRcode : "+result.getText());
   	    qrBarCode="Result Barcode/QRcode : " + result.getText();
   	       }
   	     }
   	  catch (ReaderException re) {
   	         System.out.println("RE : "+re.toString());
   	         	qrBarCode="error";
   		     } catch(Exception ex) {
   		    	 ex.printStackTrace();
   		    	qrBarCode="error_other";
   		    	// return "EX : "+ex.getMessage();
   		     }
        return qrBarCode;
    }
    
    
    @RequestMapping(value = "/test", method = RequestMethod.GET) 
    public String getAbcd(HttpServletRequest request) {
    	return "test";
    }
    
    private static final long serialVersionUID = 1L;
    @RequestMapping(value = "/test", method = RequestMethod.POST,// headers = "Content-Type=multipart/form-data",  
	     consumes = MediaType.ALL_VALUE)// headers = "Content-Type=application/x-www-form-urlencoded",  headers = "Content-Type=multipart/form-data", method = RequestMethod.POST)//headers = "application/x-www-form-urlencoded",  ------------ Content-Type=application/x-www-form-urlencoded ---consumes = MediaType.MULTIPART_FORM_DATA_VALUE  --- multipart/form-data
    public @ResponseBody void getScanBarcode(HttpServletRequest request,
     HttpServletResponse response) throws ServletException, IOException {
    System.out.println("1");
     Part part = request.getPart("blob");
     System.out.println("2");
     String fileName = null;
     if (part != null) {
    	 System.out.println("3");
      //writing blob
      fileName = request.getParameter("blobName");
      System.out.println("4");
      part.write("D:\\\\UserData" + File.separator + fileName);
      System.out.println("5");

     } else {
    	 System.out.println("6");
      //Writing image or file
      part = request.getPart("file");
      System.out.println("7");
      fileName = getFileName(part);
      System.out.println("8");
      part.write("D:\\\\UserData" + File.separator + fileName);
      System.out.println("9");
     }

     // Extra logic to support multiple domain - you may want to remove this
     response.setHeader("Access-Control-Allow-Origin", "*");
     System.out.println("10");
     response.getWriter().print(fileName + " uploaded successfully");
     System.out.println("11");
    }

    private String getFileName(Part part) {
     String contentDisp = part.getHeader("content-disposition");
     System.out.println("content-disposition header= " + contentDisp);
     String[] tokens = contentDisp.split(";");
     for (String token : tokens) {
      if (token.trim().startsWith("filename")) {
       return token.substring(token.indexOf("=") + 2,
         token.length() - 1);
      }
     }
     return "";
    }
    
}