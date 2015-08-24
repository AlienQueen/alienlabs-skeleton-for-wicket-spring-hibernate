/*
 * $Id: AmazonDao.java 475 2005-12-08 23:44:08 -0800 (Thu, 08 Dec 2005) ivaynberg $
 * $Revision: 475 $
 * $Date: 2005-12-08 23:44:08 -0800 (Thu, 08 Dec 2005) $
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
package org.alienlabs.amazon.persistence.dao;

import java.io.Serializable;

import org.alienlabs.amazon.model.Amazon;
import org.hibernate.Session;

/**
 * The implementation-independent DAO interface. Defines the operations required
 * to be supported by an implementation.
 * 
 * @author igor
 */
public interface AmazonDao extends Serializable
{
	Session getSession();

	/**
	 * Load a {@link Amazon} from the DB, given it's <tt>id</tt>.
	 * 
	 * @param id
	 *            The id of the Amazon to load.
	 * @return Amazon
	 */
	Amazon load(long id);

	/**
	 * Save the Amazon to the DB
	 * 
	 * @param Amazon
	 * @return persistent instance of Amazon
	 */
	void save(Amazon Amazon);

	/**
	 * Delete a {@link Amazon} from the DB, given it's <tt>id</tt>.
	 * 
	 * @param id
	 *            The id of the Amazon to delete.
	 */
	void delete(long id);
}
