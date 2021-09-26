package com.integrosys.course.app.test.bus;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: ssathish
 * Date: Jun 20, 2003
 * Time: 3:13:12 PM
 * To change this template use Options | File Templates.
 */
public class OBA {
	Long id;
    String name;
    String country;
    String role;
    List<String> rights;

    public String getName() {
        return name;
    }

    public List<String> getRights() {
        return rights;
    }

    public void setRights(List<String> rights) {
        this.rights = rights;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    long versionTime;

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String toString() {
        return "Id:"+id+",Name:" + name + ":Country:" + country+",Role:"+role;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getVersionTime() {
		return versionTime;
	}

	public void setVersionTime(long versionTime) {
		this.versionTime = versionTime;
	}
    
    
}
