/*
 * $Id: DataGenerator.java 366 2005-10-11 16:06:21 -0700 (Tue, 11 Oct 2005) ivaynberg $
 * $Revision: 366 $
 * $Date: 2005-10-11 16:06:21 -0700 (Tue, 11 Oct 2005) $
 *
 * ==============================================================================
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.alienlabs.amazon.service;

import org.alienlabs.amazon.model.Amazon;
import org.alienlabs.amazon.persistence.dao.AmazonDao;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Required;

/**
 * @author ivaynberg
 * @author Kare Nuorteva
 */
public class DataGenerator implements InitializingBean
{
	@SpringBean
	private AmazonDao amazonDao;

	@SpringBean
	private transient boolean generateData;


	@Override
	public void afterPropertiesSet()
	{
		if (this.generateData)
		{
			final Amazon a1 = new Amazon("./amazons/images.jpeg", "Fuzzy", "Fuzzy Amazon",
					"Fuzzy, hu?", "toto", new String[0], 10l, 2l, 12l);
			final Amazon a2 = new Amazon("./amazons/Croisiere-Amazonie-Perou-fleuve-Amazone.JPG",
					"Clear", "Clear and strong Amazon", "Nicer, isn't?", "titi", new String[0], 8l,
					3l, 11l);
			final Amazon a3 = new Amazon("./amazons/31_10_06_amazon.jpg", "Beautiful",
					"Clear, beautiful and strong Amazon", "Even icer, isn't?", "tata",
					new String[0], 2l, 9l, 11l);
			this.amazonDao.save(a1);
			this.amazonDao.save(a2);
			this.amazonDao.save(a3);
		}
	}

	@Required
	public void setAmazonDao(final AmazonDao _amazonDao)
	{
		this.amazonDao = _amazonDao;
	}

	@Required
	public void setGenerateData(final boolean _generateData)
	{
		this.generateData = _generateData;
	}

}
