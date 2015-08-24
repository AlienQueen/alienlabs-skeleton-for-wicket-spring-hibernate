package org.alienlabs.amazon;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebComponent;
import org.apache.wicket.model.Model;

/**
 * Creates external image
 * 
 * @author sergej.sizov
 */
public class ExternalImage extends WebComponent
{
	private static final long serialVersionUID = 1L;

	public ExternalImage(final String id, final String imageUrl)
	{
		super(id);
		this.add(AttributeModifier.replace("src", new Model<String>(imageUrl)));
		this.setVisible(!((imageUrl == null) || imageUrl.equals("")));
	}

	@Override
	protected void onComponentTag(final ComponentTag tag)
	{
		super.onComponentTag(tag);
		this.checkComponentTag(tag, "img");
	}

}
