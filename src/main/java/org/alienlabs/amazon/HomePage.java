package org.alienlabs.amazon;

import java.util.List;

import org.alienlabs.amazon.model.Amazon;
import org.alienlabs.amazon.service.PersistenceService;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.springframework.beans.factory.annotation.Required;

public class HomePage extends WebPage
{
	private static final long serialVersionUID = 1L;

	@SpringBean
	PersistenceService persistenceService;


	public HomePage(final PageParameters parameters)
	{
		super(parameters);

		// Welcome message
		final Label message1 = new Label("message1", "version 0.0.1, ");
		final Label message2 = new Label("message2", "built on Saturday, 18th of May 2013.");
		ImportDeckDialog extract = new ImportDeckDialog("extract");
		this.add(message1, message2, extract);
	}

	@Required
	public void setPersistenceService(final PersistenceService _persistenceService)
	{
		this.persistenceService = _persistenceService;
	}

}
