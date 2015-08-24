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
package org.alienlabs;

import org.alienlabs.amazon.service.PersistenceService;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Required;

/**
 * @author ivaynberg
 * @author Kare Nuorteva
 */
public class DataGenerator implements InitializingBean
{
	private static final String[] TITLES1 = { "Goblin Guide", "Goblin Guide", "Goblin Guide",
			"Goblin Guide", "Vampire Lacerator", "Vampire Lacerator", "Vampire Lacerator",
			"Vampire Lacerator", "Bloodchief Ascension", "Bloodchief Ascension",
			"Bloodchief Ascension", "Bloodchief Ascension", "Mindcrank", "Mindcrank", "Mindcrank",
			"Lightning Bolt", "Lightning Bolt", "Lightning Bolt", "Lightning Bolt", "Arc Trail",
			"Arc Trail", "Arc Trail", "Arc Trail", "Staggershock", "Staggershock", "Staggershock",
			"Staggershock", "Volt Charge", "Volt Charge", "Volt Charge", "Volt Charge",
			"Tezzeret s Gambit", "Tezzeret's Gambit", "Tezzeret's Gambit", "Tezzeret's Gambit",
			"Hideous End", "Hideous End", "Hideous End", "Blackcleave Cliffs",
			"Blackcleave Cliffs", "Blackcleave Cliffs", "Blackcleave Cliffs", "Mountain",
			"Mountain", "Mountain", "Mountain", "Mountain", "Mountain", "Mountain", "Mountain",
			"Mountain", "Swamp", "Swamp", "Swamp", "Swamp", "Swamp", "Swamp", "Swamp", "Swamp",
			"Swamp" };

	private static final String[] TITLES2 = { "Goblin Guide", "Goblin Guide", "Goblin Guide",
			"Goblin Guide", "Spikeshot Elder", "Spikeshot Elder", "Spikeshot Elder",
			"Spikeshot Elder", "Kiln Fiend", "Kiln Fiend", "Kiln Fiend", "Kiln Fiend",
			"Shrine of Burning Rage", "Shrine of Burning Rage", "Shrine of Burning Rage",
			"Shrine of Burning Rage", "Gut Shot", "Gut Shot", "Gut Shot", "Gut Shot",
			"Lightning Bolt", "Lightning Bolt", "Lightning Bolt", "Lightning Bolt",
			"Burst Lightning", "Burst Lightning", "Burst Lightning", "Burst Lightning",
			"Searing Blaze", "Searing Blaze", "Searing Blaze", "Searing Blaze", "Arc Trail",
			"Arc Trail", "Arc Trail", "Arc Trail", "Staggershock", "Staggershock", "Staggershock",
			"Staggershock", "Teetering Peaks", "Teetering Peaks", "Teetering Peaks",
			"Teetering Peaks", "Mountain", "Mountain", "Mountain", "Mountain", "Mountain",
			"Mountain", "Mountain", "Mountain", "Mountain", "Mountain", "Mountain", "Mountain",
			"Mountain", "Mountain", "Mountain", "Mountain" };

	@SpringBean
	private PersistenceService persistenceService;

	@SpringBean
	private transient boolean generateData;

	@Required
	public void setPersistenceService(final PersistenceService _persistenceService)
	{
		this.persistenceService = _persistenceService;
	}

	@Override
	public void afterPropertiesSet()
	{
	}

	@Required
	public void setGenerateData(final boolean _generateData)
	{
		this.generateData = _generateData;
	}

}
