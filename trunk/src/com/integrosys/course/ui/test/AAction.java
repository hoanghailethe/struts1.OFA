package com.integrosys.course.ui.test;

import com.integrosys.base.techinfra.context.BeanHouse;
import com.integrosys.base.techinfra.logger.DefaultLogger;
import com.integrosys.base.uiinfra.common.CommonAction;
import com.integrosys.base.uiinfra.common.ICommand;
import com.integrosys.base.uiinfra.common.IPage;
import com.integrosys.base.uiinfra.common.Page;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;

import java.util.HashMap;
import java.util.Locale;

/**
 * Created by IntelliJ IDEA.
 * User: ssathish
 * Date: Jun 20, 2003
 * Time: 2:49:22 PM
 * To change this template use Options | File Templates.
 */
public class AAction extends CommonAction {

    public static final String EVENT_PREPARE_UPDATE = "prepare_update";
	public static final String EVENT_PREPARE_CREATE = "prepare_create";
	
    /**
     * This method return a Array of Commad Objects responsible for a event
     *
     * @param event is of type String
     * @return Icommand Array
     */
    public ICommand[] getCommandChain(String event) {

        ICommand objArray [] = null;
		objArray = new ICommand[1];
		
        if (EVENT_LIST.equals(event)) {	       
//	        objArray[0] = new ListACommand();
		     objArray[0] = (ICommand)BeanHouse.get("aAction.listACommand");
    	}
        else if (EVENT_READ.equals(event)) {
		    objArray[0] = new ReadACommand();
	    } else if (EVENT_PREPARE_UPDATE.equals(event)) {
            objArray = new ICommand[2];
            objArray[0] = new PrepareACommand();
            objArray[1] = new ReadACommand();
        } else if (EVENT_PREPARE_CREATE.equals(event)) {
	        objArray[0] = new PrepareACommand();
        } else if (EVENT_CREATE.equals(event)) {
            objArray[0] = new CreateACommand();
        } else if (EVENT_UPDATE.equals(event)) {
            objArray[0] = new UpdateACommand();
        } else if (EVENT_DELETE.equals(event)) {
            objArray[0] = new DeleteACommand();
        }
        //add Search mapping Actions
        else if("search".equals(event.substring(0,6))){
            objArray[0] = new SearchACommand(event.substring(6));;
        }

        DefaultLogger.debug(this, "*******" + event + "================" + objArray);
        return (objArray);
    }

    /**
     * This method is called only for create and Update command to validate the form
     * and return the ActionErrors object.
     *
     * @param aForm is of type ActionForm
     * @param locale of type Locale
     * @return ActionErrors
     */
    public ActionErrors validateInput(ActionForm aForm, Locale locale) {

        return AValidator.validateInput((AForm) aForm, locale);
    }

    /**
     * This method is used to determine which event requires validation
     *
     * @param event is type String
     * @return boolean
     */
    protected boolean isValidationRequired(String event) {
	    if (EVENT_CREATE.equals(event) ||
	    	EVENT_UPDATE.equals(event))
	    	return true;
	    return false;
	}    
	
    /**
     * This method is used to determine which the page to be displayed next using the event
     * Result hashmap and exception hashmap.It returns the page object .
     *
     * @param event  is of type String
     * @param resultMap is of type HashMap
     * @param exceptionMap is of type HashMap
     * @return IPage
     */
    public IPage getNextPage(String event, HashMap resultMap, HashMap exceptionMap) {
        Page aPage = new Page();
        aPage.setPageReference(getReference(event));
        return aPage;
    }

    /**
     * method which determines the forward name for a particular event
     * @param event as String
     * @return String
     */
    private String getReference(String event) {
        return event;
    }

    public String getDefaultEvent() {
        return EVENT_LIST;
    }

    protected String getErrorEvent(String event) {
	    if (EVENT_CREATE.equals(event))
	    	return EVENT_PREPARE_CREATE;
	    if (EVENT_UPDATE.equals(event))
	    	return EVENT_PREPARE_UPDATE;
        return event;
    }
}


