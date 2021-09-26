package com.integrosys.course.ui.test;

import com.integrosys.base.uiinfra.common.CommonForm;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ssathish
 * Date: Jun 20, 2003
 * Time: 2:56:38 PM
 * To change this template use Options | File Templates.
 */
public class AForm extends CommonForm implements Serializable {
    private String name;
    private String country;

    private Long id;
    private String role;
    private List<String> rights;

    public List<String> getRights() {
        return rights;
    }

    public void setRights(List<String> rights) {
        this.rights = new ArrayList<String>();
        rights.addAll(rights);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    private static final String AMAPPER = "com.integrosys.course.ui.test.AMapper";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void reset() {
        country = "SG";
    }
    
    public String[][] getMapper() {
        String[][] input = {
            {"form.OBA", AMAPPER},
        };
        return input;
    }    
}
