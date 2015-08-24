package org.alienlabs.amazon.service;

import java.io.Serializable;
import java.util.List;

import org.alienlabs.amazon.model.Amazon;
import org.alienlabs.amazon.persistence.dao.AmazonDao;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.transaction.annotation.Transactional;

public class PersistenceService implements Serializable
{
	private static final long serialVersionUID = 1L;

	static final Logger LOGGER = LoggerFactory.getLogger(PersistenceService.class);

	@SpringBean
	private AmazonDao amazonDao;

	@Transactional
	public List<Amazon> getAmazons(final Long first, final Long numberOfAmazonsToGet)
	{
		final Session session = this.amazonDao.getSession();
		final SQLQuery query = session.createSQLQuery("select * from Amazon limit ?, ?");
		query.addEntity(Amazon.class);
		query.setLong(0, first);
		query.setLong(1, numberOfAmazonsToGet);
		final List<Amazon> result = query.list();

		return result;
	}

	@Required
	public void setAmazonDao(final AmazonDao _amazonDao)
	{
		this.amazonDao = _amazonDao;
	}

}
