package com.integrosys.course.ui.test;

import com.integrosys.base.techinfra.logger.DefaultLogger;
import com.integrosys.course.ui.common.TrxObject;
import com.integrosys.course.app.test.bus.AProxy;
import com.integrosys.course.app.test.bus.OBA;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: ssathish
 * Date: Jun 25, 2003
 * Time: 2:44:30 PM
 * To change this template use Options | File Templates.
 */
public class AHelper {

    /**
     * the name of OB. THis will be used in all the form elements.
     * @return     String name of OB
     */
    public static final String getOBName() {
        return "OBA";
    }

    /**
     * Return the full qualified name of OB
     * @return full qualified name of OB
     */
    public static final String getOBType() {
        return "com.integrosys.course.app.test.bus.OBA";
    }

    /**
     * Return the key ( id) to determine the object. ( TODO this needs to be array??)
     * @return   the name of String
     */
    public static final String getKeyName() {
        return "id";
    }

    //CRUD Operation
    public static TrxObject add(Object a) throws Exception {
        OBA aObj = (OBA) a;
        return AProxy.getInstance().add(aObj);
    }

    //CRUD Operation
    public static TrxObject remove(Object aObj) throws Exception {
        DefaultLogger.debug(AHelper.class, "id in remove is " + aObj);
        return AProxy.getInstance().remove((OBA)aObj);
    }



    //CRUD Operation
    public static OBA get(String name) throws Exception {
        DefaultLogger.debug(AHelper.class, "id in Get is " + name);
        return AProxy.getInstance().get(name);
    }


    //CRUD Operation
    public static TrxObject update(Object aObj) throws Exception {
        DefaultLogger.debug(AHelper.class, "id in update is " + aObj);
        return AProxy.getInstance().update((OBA) aObj);
    }
    
    public static String getCountryName(String countryID) {
	    return AProxy.getCountryName(countryID);
    }

    public static Set getRoleList() {return AProxy.role_accessRight().keySet(); }

    //CRUD Operation
    public static Collection getAll() throws Exception {
        return AProxy.getInstance().getAll();
    }

    public static Collection findByName(String key) {
        return AProxy.getInstance().getAll();
    }

    public static Collection findById(String key) {
        return AProxy.getInstance().getAll();
    }

    public static Collection findByCountry(String key) {
        return AProxy.getInstance().getAll();
    }

    public static Collection findByRole(String key) {
        return AProxy.getInstance().getAll();
    }

    public static Collection findByRights(String key) {
        return AProxy.getInstance().getAll();
    }
}
