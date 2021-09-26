package com.integrosys.course.ui.test;

import com.integrosys.base.uiinfra.common.AbstractCommonMapper;
import com.integrosys.base.uiinfra.common.CommonForm;
import com.integrosys.base.uiinfra.exception.MapperException;
import com.integrosys.course.app.test.bus.AException;
import com.integrosys.course.app.test.bus.AProxy;
import com.integrosys.course.app.test.bus.OBA;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: ssathish
 * Date: Jun 22, 2003
 * Time: 4:45:05 PM
 * To change this template use Options | File Templates.
 */
public class AMapper extends AbstractCommonMapper {

    public Object mapFormToOB(CommonForm cForm, HashMap inputs) throws MapperException {
        AForm aForm = (AForm) cForm;

        OBA aObj = new OBA();
        aObj.setName(aForm.getName());
        aObj.setCountry(aForm.getCountry());

        aObj.setId(aForm.getId());
        aObj.setRole(aForm.getRole());

        aObj.setRights(AProxy.getRightsFromRole((aForm.getRole())));

        return aObj;
    }

    public CommonForm mapOBToForm(CommonForm cForm, Object obj, HashMap inputs) throws MapperException {
        OBA aObj = (OBA) obj;
        AForm aForm = (AForm) cForm;

        aForm.setName(aObj.getName());
        aForm.setCountry(aObj.getCountry());
        aForm.setRole(aObj.getRole());
        aForm.setId(aObj.getId());
        aForm.setRights(aObj.getRights());
        return aForm;
    }


}
