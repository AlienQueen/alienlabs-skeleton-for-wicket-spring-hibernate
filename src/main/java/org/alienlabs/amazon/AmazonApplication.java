package org.alienlabs.amazon;

import java.io.File;
import java.util.ResourceBundle;

import org.apache.wicket.Application;
import org.apache.wicket.RuntimeConfigurationType;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.IResource;
import org.apache.wicket.request.resource.ResourceStreamResource;
import org.apache.wicket.request.resource.SharedResourceReference;
import org.apache.wicket.settings.IExceptionSettings;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.apache.wicket.util.resource.FileResourceStream;
import org.apache.wicket.util.time.Duration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import de.agilecoders.wicket.Bootstrap;
import de.agilecoders.wicket.settings.BootstrapSettings;

/**
 * Application object for your web application. If you want to run this
 * application without deploying, run the Start class.
 * 
 * @see org.alienlabs.amazon.Start#main(String[])
 */
public class AmazonApplication extends WebApplication
{
	/**
	 * @see org.apache.wicket.Application#getHomePage()
	 */
	@Override
	public Class<? extends WebPage> getHomePage()
	{
		return HomePage.class;
	}

	public static AmazonApplication get()
	{
		return (AmazonApplication)Application.get();
	}

	/**
	 * @see org.apache.wicket.Application#init()
	 */
	@Override
	public void init()
	{
		super.init();

		final ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		this.getComponentInstantiationListeners().add(
				new SpringComponentInjector(this, applicationContext));

		// CSS & JS minification
		Bootstrap.install(Application.get(), new BootstrapSettings());

		this.getRequestCycleSettings().setTimeout(Duration.minutes(15));
		this.getResourceSettings().setDefaultCacheDuration(Duration.seconds(2));

		this.getExceptionSettings().setUnexpectedExceptionDisplay(
				IExceptionSettings.SHOW_EXCEPTION_PAGE);

		this.getSharedResources().add(
				"amazons",
				new FolderContentResource(new File(ResourceBundle.getBundle(
						AmazonApplication.class.getCanonicalName()).getString(
						"SharedResourceFolder"))));
		this.mountResource("amazons", new SharedResourceReference("amazons"));
	}

	@Override
	public RuntimeConfigurationType getConfigurationType()
	{

		return RuntimeConfigurationType.DEVELOPMENT;
	}

	static class FolderContentResource implements IResource
	{
		private static final long serialVersionUID = 1L;

		private final File rootFolder;

		public FolderContentResource(final File rootFolder)
		{
			this.rootFolder = rootFolder;
		}

		@Override
		public void respond(final Attributes attributes)
		{
			final PageParameters parameters = attributes.getParameters();
			final String fileName = parameters.get(0).toString();
			final File file = new File(this.rootFolder, fileName);
			final FileResourceStream fileResourceStream = new FileResourceStream(file);
			final ResourceStreamResource resource = new ResourceStreamResource(fileResourceStream);
			resource.respond(attributes);
		}
	}

}
