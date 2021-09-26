package com.integrosys.course.ui.test;

import com.integrosys.base.techinfra.logger.DefaultLogger;
import com.integrosys.base.techinfra.validation.Validator;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;

import java.util.Locale;

/**
 * Created by IntelliJ IDEA.
 * User: ssathish
 * Date: Jun 20, 2003
 * Time: 6:42:25 PM
 * To change this template use Options | File Templates.
 */
public class AValidator {
    public static ActionErrors validateInput(AForm aForm, Locale locale) {
        ActionErrors errors = new ActionErrors();
        String errorCode = null;
        DefaultLogger.debug("this", "The value of NAME IS:" + aForm.getName());
        if (!(errorCode = Validator.checkString(aForm.getName(), true, 1, 20)).equals(Validator.ERROR_NONE)) {
            errors.add("name", new ActionError("error.string.mandatory", "1", "20"));
        }
        if (aForm.getName() != null && aForm.getName().startsWith("X")) {
            DefaultLogger.debug("this", "Name StartswithX" + aForm.getName());
            errors.add("name", new ActionError("name.invalid.startwith.X"));
        }

        return errors;

    }
}
