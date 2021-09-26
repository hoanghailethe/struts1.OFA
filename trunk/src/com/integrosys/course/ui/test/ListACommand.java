package com.integrosys.course.ui.test;

import java.util.Collection;
import java.util.HashMap;

import com.integrosys.base.techinfra.logger.DefaultLogger;
import com.integrosys.base.uiinfra.common.AbstractCommand;
import com.integrosys.base.uiinfra.common.ICommonEventConstant;
import com.integrosys.base.uiinfra.exception.CommandProcessingException;
import com.integrosys.base.uiinfra.exception.CommandValidationException;
import com.integrosys.course.app.test.bus.AProxy;

/**
 * Created by IntelliJ IDEA.
 * User: ssathish
 * Date: Jun 24, 2003
 * Time: 9:42:24 AM
 * To change this template use Options | File Templates.
 */
public class ListACommand extends AbstractCommand {

	private AProxy aProxy;
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
                {"request." + AHelper.getOBName() + "List", "java.util.Collection", REQUEST_SCOPE},
        });
    }

    /**
     * This method does the Business operations  with the HashMap and put the results back into
     * the HashMap.Here reading for Company Borrower is done.
     *
     * @param map is of type HashMap
     * @return HashMap with the Result
     * @throws com.integrosys.base.uiinfra.exception.CommandProcessingException
     *          on errors
     * @throws com.integrosys.base.uiinfra.exception.CommandValidationException
     *          on errors
     */
    public HashMap doExecute(HashMap map) throws CommandProcessingException, CommandValidationException {
        HashMap result = new HashMap();
        HashMap exceptionMap = new HashMap();
        HashMap temp = new HashMap();
        Collection c = null;
        try {
            c = AHelper.getAll();
        } catch (Exception e) {
            DefaultLogger.error(this, e);
        }

        result.put("request." + AHelper.getOBName() + "List", c);

        temp.put(ICommonEventConstant.COMMAND_RESULT_MAP, result);
        temp.put(ICommonEventConstant.COMMAND_EXCEPTION_MAP, exceptionMap);
        return temp;
    }

	public AProxy getaProxy() {
		return aProxy;
	}

	public void setaProxy(AProxy aProxy) {
		this.aProxy = aProxy;
	}

}

