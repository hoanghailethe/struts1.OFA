package com.integrosys.course.app.test.bus;

import java.util.List;

public interface IADao {

	public abstract OBA createOBA(OBA oba);

	public abstract OBA getOBA(long key);

	public abstract OBA updateOBA(OBA oba);

    public abstract List findAll();

}