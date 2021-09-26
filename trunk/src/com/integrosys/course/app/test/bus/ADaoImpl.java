package com.integrosys.course.app.test.bus;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

public class ADaoImpl extends HibernateDaoSupport implements IADao {

    /* (non-Javadoc)
      * @see com.integrosys.course.app.test.bus.IADao#createOBA(com.integrosys.course.app.test.bus.OBA)
      */
    @Override
    public OBA createOBA(OBA oba) {
        Long key = (Long) getHibernateTemplate().save("oba", oba);
        oba.setId(key.longValue());
        return oba;
    }

    /* (non-Javadoc)
      * @see com.integrosys.course.app.test.bus.IADao#getOBA(long)
      */
    @Override
    public OBA getOBA(long key) {
        return (OBA) getHibernateTemplate().get("oba", new Long(key));
    }

    /* (non-Javadoc)
      * @see com.integrosys.course.app.test.bus.IADao#updateOBA(com.integrosys.course.app.test.bus.OBA)
      */
    @Override
    public OBA updateOBA(OBA oba) {
        getHibernateTemplate().update("oba", oba);
        return (OBA) getHibernateTemplate().load("oba", oba.getId());
    }

    public List findAll() {
        DetachedCriteria criteria = DetachedCriteria.forEntityName("oba").addOrder(Order.asc("xxx"));

        List results = getHibernateTemplate().findByCriteria(criteria);

        if (results.isEmpty()) {
            return null;
        }
        return results;
    }
}
