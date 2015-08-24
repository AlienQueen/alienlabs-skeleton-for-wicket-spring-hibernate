package org.alienlabs;

import org.alienlabs.amazon.AmazonApplication;
import org.alienlabs.amazon.HomePage;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

/**
 * Simple test using the WicketTester
 */
public class TestHomePage
{
	private WicketTester tester;

	@Before
	public void setUp()
	{
		this.tester = new WicketTester(new AmazonApplication());
	}

	@Test
	public void homepageRendersSuccessfully()
	{
		// start and render the test page
		this.tester.startPage(HomePage.class);

		// assert rendered page class
		this.tester.assertRenderedPage(HomePage.class);
	}
}
