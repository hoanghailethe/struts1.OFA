package com.integrosys.course.ui.test;

import com.integrosys.base.uiinfra.common.AbstractCommand;
import com.integrosys.base.uiinfra.common.ICommonEventConstant;
import com.integrosys.base.uiinfra.exception.CommandProcessingException;
import com.integrosys.base.uiinfra.exception.CommandValidationException;

import com.integrosys.course.app.test.bus.AProxy;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by IntelliJ IDEA.
 * User: ssathish
 * Date: Jun 20, 2003
 * Time: 3:05:13 PM
 * To change this template use Options | File Templates.
 */
public class PrepareACommand extends AbstractCommand {


    /**
     * Defines an two dimensional array with the result list to be
     * expected as a result from the doExecute method using a HashMap
     * syntax for the array is (HashMapkey,classname,scope)
     * The scope may be request,form or service
     *
     * @return the two dimensional String array
     */
    public String[][] getResultDescriptor() {
	    return (new String[][] {
		    {"countryMap", "java.util.HashMap", REQUEST_SCOPE},
                {"role_accessRight", "java.util.HashMap", REQUEST_SCOPE}
	    });
    }

    public HashMap doExecute(HashMap map) throws CommandProcessingException, CommandValidationException {
        HashMap result = new HashMap();
        HashMap exceptionMap = new HashMap();
        HashMap temp = new HashMap();

        HashMap countryList = AProxy.getInstance().getCountryList();
		result.put("countryMap", countryList);

        HashMap role_accessRight = AProxy.role_accessRight();
        result.put("role_accessRight", role_accessRight);

        temp.put(ICommonEventConstant.COMMAND_RESULT_MAP, result);
        temp.put(ICommonEventConstant.COMMAND_EXCEPTION_MAP, exceptionMap);


        return temp;
    }

}
