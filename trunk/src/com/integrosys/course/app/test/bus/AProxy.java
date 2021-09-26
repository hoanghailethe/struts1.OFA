package com.integrosys.course.app.test.bus;

import com.integrosys.base.techinfra.logger.DefaultLogger;
import com.integrosys.course.ui.common.TrxObject;
import com.integrosys.course.ui.test.AHelper;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: ssathish
 * Date: Jun 20, 2003
 * Time: 3:10:01 PM
 * To change this template use Options | File Templates.
 */
public class AProxy {
    HashMap store = new HashMap();

    private static AProxy aProxy;

    public static AProxy getInstance() {
        if (aProxy == null)
            aProxy = new AProxy();
        return aProxy;
    }

    public static final HashMap getCountryList() {
        HashMap hm = new HashMap();
        hm.put("HK", "Hong Kong");
        hm.put("IN", "India");
        hm.put("SG", "Singapore");
		hm.put("MY", "Malaysia");
        return hm;
    }

    public static final HashMap<String, List<String>> role_accessRight() {
        HashMap hm = new HashMap();
        List<String> right1 = new ArrayList<String>(Arrays.asList("RM Profile1", "pm3"));
        List<String> right2= new ArrayList<String>(Arrays.asList("RM Profile1", "RM Profile2"));
        List<String> right3= new ArrayList<String>(Arrays.asList("RMTL Profile1" , "RMTL Profile"));
        List<String> right4= new ArrayList<String>(Arrays.asList("RM Profile1", "CA Profile2", "AC Profile1", "BCA Profile2"));
        hm.put("RM", right1);
        hm.put("RMTL", right2);
        hm.put("CA",right3 );
        hm.put("BCA", right4);
        return hm;
    }

    public static List<String>getRightsFromRole(String key){
        return role_accessRight().get(key);
    }
    
	public static String getCountryName(String countryID) {
		return (String)getCountryList().get(countryID);
	}    

    public TrxObject add(OBA oba) throws AException {
        store.put( Long.toString(oba.getId()) , oba);
        return makeTrxObject(oba.hashCode());
    }

    public TrxObject update(OBA oba) throws AException {
        if (oba != null) {
            DefaultLogger.debug(AHelper.class, "OBA name - PUT(from proxy)" + oba);
            store.put( Long.toString(oba.getId() ), oba);
            return makeTrxObject(oba.hashCode());
        } else
            throw new AException("nothing to update");
    }

    public OBA get(String key) throws AException {
        DefaultLogger.debug(AHelper.class, "OBA id - GET (from Proxy)" + key);
        OBA a = (OBA) store.get(key);
        if (a == null)
            throw new AException("Key not found");
        return a;
    }

    public TrxObject remove(OBA oba) throws AException {
        if ( oba != null) {
            DefaultLogger.debug(AHelper.class, "OBA name - REMOVE " + oba);
            store.remove( Long.toString(oba.getId() ));
            return makeTrxObject(oba.hashCode());
        } else
            throw new AException("nothing to remove");

//        if (get(key) != null)
//            store.remove(key);
//        else
//            throw new AException("Key not found");
//        return makeTrxObject(key.hashCode());
    }

    public Collection getAll() {
        Collection c = store.values();
        ArrayList list = new ArrayList();
        list.addAll(c);
        return list;
    }

    public static TrxObject makeTrxObject(int a) {
        TrxObject trxObj = new TrxObject();
        trxObj.setID(a);
        trxObj.setDate(new Date());
        return trxObj;
    }
}

