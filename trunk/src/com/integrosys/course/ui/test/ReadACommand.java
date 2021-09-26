package com.integrosys.course.ui.test;

import com.integrosys.base.techinfra.logger.DefaultLogger;
import com.integrosys.base.uiinfra.common.AbstractCommand;
import com.integrosys.base.uiinfra.common.ICommonEventConstant;
import com.integrosys.base.uiinfra.exception.CommandProcessingException;
import com.integrosys.base.uiinfra.exception.CommandValidationException;
import com.integrosys.course.app.test.bus.AProxy;
import com.integrosys.course.app.test.bus.OBA;
import com.integrosys.course.ui.common.TrxObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ssathish
 * Date: Jun 24, 2003
 * Time: 9:42:24 AM
 * To change this template use Options | File Templates.
 */
public class ReadACommand extends AbstractCommand {
    public String[][] getParameterDescriptor() {
        return (new String[][]{
                {AHelper.getKeyName(), "java.lang.String", REQUEST_SCOPE},
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
                {"form." + AHelper.getOBName(), AHelper.getOBType(), FORM_SCOPE},
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

        String name = (String) map.get(AHelper.getKeyName());


        Object aObj = null;
        try {
            aObj = AHelper.get(name);
        } catch (Exception e) {
            DefaultLogger.error(this, e);
        }

        if (aObj != null)
            result.put("form." + AHelper.getOBName(), aObj);


        temp.put(ICommonEventConstant.COMMAND_RESULT_MAP, result);
        temp.put(ICommonEventConstant.COMMAND_EXCEPTION_MAP, exceptionMap);
        return temp;
    }
}

