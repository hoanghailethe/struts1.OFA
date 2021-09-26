package com.integrosys.course.ui.test;

import com.integrosys.base.techinfra.logger.DefaultLogger;
import com.integrosys.base.uiinfra.common.AbstractCommand;
import com.integrosys.base.uiinfra.common.ICommonEventConstant;
import com.integrosys.base.uiinfra.exception.CommandProcessingException;
import com.integrosys.base.uiinfra.exception.CommandValidationException;
import com.integrosys.course.app.test.bus.OBA;
import com.integrosys.course.ui.common.TrxObject;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: ssathish
 * Date: Jun 24, 2003
 * Time: 9:42:24 AM
 * To change this template use Options | File Templates.
 */
public class DeleteACommand extends AbstractCommand {

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

        DefaultLogger.log(DeleteACommand.class, 2,"map in delete is " + map );
        DefaultLogger.debug(DeleteACommand.class, "map in delete is " + map);

        String name = (String) map.get(AHelper.getKeyName());

        OBA aObj = (OBA)map.get("form." + AHelper.getOBName());

        TrxObject trxObj = null;
        try {
            trxObj = AHelper.remove(aObj);
        } catch (Exception e) {
            DefaultLogger.error(this, e);
        }
        result.put("request.trxObject", trxObj);
        temp.put(ICommonEventConstant.COMMAND_RESULT_MAP, result);
        temp.put(ICommonEventConstant.COMMAND_EXCEPTION_MAP, exceptionMap);
        return temp;
    }
}

