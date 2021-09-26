package com.integrosys.course.ui.test;

import com.integrosys.base.techinfra.logger.DefaultLogger;
import com.integrosys.base.uiinfra.common.AbstractCommand;
import com.integrosys.base.uiinfra.common.ICommonEventConstant;
import com.integrosys.base.uiinfra.exception.CommandProcessingException;
import com.integrosys.base.uiinfra.exception.CommandValidationException;
import com.integrosys.course.app.test.bus.AProxy;

import java.util.Collection;
import java.util.HashMap;

public class SearchACommand extends AbstractCommand {
    private AProxy aProxy;
    String keySearch;
    public SearchACommand(String key) {
        this.keySearch = key;
    }

    public String[][] getResultDescriptor() {
        return (new String[][]{
                {"request." + AHelper.getOBName() + "List", "java.util.Collection", REQUEST_SCOPE},
        });
    }

    public HashMap doExecute(HashMap map) throws CommandProcessingException, CommandValidationException {
        HashMap result = new HashMap();
        HashMap exceptionMap = new HashMap();
        HashMap temp = new HashMap();
        Collection c = null;

        int div = keySearch.indexOf("/");
        String field = keySearch.substring(0, div);
        String key = keySearch.substring(div+1);
        try {
            switch (field) {
                case "name" : c = AHelper.findByName(key); break;
                case "id" : c = AHelper.findById(key); break;
                case "country" : c = AHelper.findByCountry(key); break;
                case "role" : c = AHelper.findByRole(key); break;
                default: c = AHelper.findByRights(key);
            }

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
