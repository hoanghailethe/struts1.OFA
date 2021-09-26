package com.integrosys.course.ui.test;


import com.integrosys.base.techinfra.context.BeanHouse;
import com.integrosys.base.techinfra.logger.DefaultLogger;
import com.integrosys.base.uiinfra.common.AbstractCommand;
import com.integrosys.base.uiinfra.common.ICommonEventConstant;
import com.integrosys.base.uiinfra.exception.CommandProcessingException;
import com.integrosys.base.uiinfra.exception.CommandValidationException;
import com.integrosys.course.ui.common.TrxObject;
import com.integrosys.course.app.test.bus.IADao;
import com.integrosys.course.app.test.bus.OBA;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: ssathish
 * Date: Jun 20, 2003
 * Time: 3:27:22 PM
 * To change this template use Options | File Templates.
 */
public class CreateACommand extends AbstractCommand {

    public String[][] getParameterDescriptor() {
        return (new String[][]{
            {"form." + AHelper.getOBName(), AHelper.getOBType(), FORM_SCOPE},
        });
    }

    /**
     * Defines an two dimensional array with the result list to be
     * expected as a result from the doExecute method using a HashMap
     * syntax for the array is (HashMapkey,classname,scope)
     * The scope may be request,form or service
     *
     * @return the two dimensional String array
     */
    public String[][] getResultDescriptor() {

        return (new String[][]{
            {"request.trxObject", "com.integrosys.course.ui.common.TrxObject", REQUEST_SCOPE}
        });
    }

    /**
     * This method does the Business operations  with the HashMap and put the results back into
     * the HashMap.Here reading for Company Borrower is done.
     *
     * @param map is of type HashMap
     * @throws com.integrosys.base.uiinfra.exception.CommandProcessingException on errors
     * @throws com.integrosys.base.uiinfra.exception.CommandValidationException on errors
     * @return HashMap with the Result
     */
    public HashMap doExecute(HashMap map) throws CommandProcessingException, CommandValidationException {

        HashMap result = new HashMap();
        HashMap exceptionMap = new HashMap();
        HashMap temp = new HashMap();

        DefaultLogger.log(CreateACommand.class, 2,"map in create is " + map );
        DefaultLogger.debug(CreateACommand.class, "map in create is " + map);
 
        OBA aObj = (OBA)map.get("form." + AHelper.getOBName());
        TrxObject trxObj = null;
        try {
            trxObj = AHelper.add(aObj);
        } catch (Exception e) {
            DefaultLogger.error(this, e);
        }

//      IADao dao = (IADao) BeanHouse.get("aDAO");
//    	OBA oba = new OBA();
//    	oba.setCountry("MY");
//    	oba.setName("Andy");
//    	
//    	oba = dao.createOBA(oba);
//    	System.out.println("######################## Retrieve OB for ID "+ oba.getId() +" &&&&& "+ dao.getOBA(oba.getId()).toString());   
        
        result.put("request.trxObject", trxObj);

        temp.put(ICommonEventConstant.COMMAND_RESULT_MAP, result);
        temp.put(ICommonEventConstant.COMMAND_EXCEPTION_MAP, exceptionMap);
        return temp;
    }
}
