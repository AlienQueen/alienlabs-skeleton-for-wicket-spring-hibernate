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
		this.add(message1, message2);

		final List<Amazon> allAmazons = this.persistenceService.getAmazons(0l, 9l);
		final ListView<Amazon> list = new ListView<Amazon>("amazon", allAmazons)
		{
			private static final long serialVersionUID = 1L;

			@Override
			protected void populateItem(final ListItem<Amazon> element)
			{
				final Amazon amazon = element.getModelObject();

				element.add(new ExternalImage("amazonImage", amazon.getPictureFilename()));

				element.add(new Label("amazonName", amazon.getAmazonName()));
				element.add(new Label("pictureName", amazon.getPictureTitle()));
				element.add(new Label("pictureDescription", amazon.getPictureDescription()));
				element.add(new Label("publisherName", amazon.getPublisherName()));
				element.add(new Label("metadata", amazon.getMetadata()));
				element.add(new Label("numberOfPluses", amazon.getNumberOfPluses()));
				element.add(new Label("numberOfMinuses", amazon.getNumberOfMinuses()));
				element.add(new Label("numberOfVotes", amazon.getNumberOfVotes()));
			}
		};

		this.add(list);
	}

	@Required
	public void setPersistenceService(final PersistenceService _persistenceService)
	{
		this.persistenceService = _persistenceService;
	}

}
