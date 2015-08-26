package org.alienlabs.amazon;

import java.io.UnsupportedEncodingException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormSubmitBehavior;
import org.apache.wicket.extensions.ajax.markup.html.IndicatingAjaxButton;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.markup.html.form.upload.FileUploadField;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.util.lang.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Required;
import com.xuggle.mediatool.IMediaReader;
import com.xuggle.mediatool.IMediaWriter;
import com.xuggle.mediatool.ToolFactory;
import com.xuggle.mediatool.IMediaViewer;
import com.xuggle.xuggler.ICodec;

@edu.umd.cs.findbugs.annotations.SuppressFBWarnings(value = { "SE_INNER_CLASS",
"SIC_INNER_SHOULD_BE_STATIC_ANON" }, justification = "In Wicket, serializable inner classes are common. And as the parent Page is serialized as well, this is no concern. This is no bad practice in Wicket")
public class ImportVideoPanel extends Panel
{
	private static final Logger LOGGER = LoggerFactory.getLogger(ImportVideoPanel.class);
	private static final long serialVersionUID = 1L;
	final FileUploadField file;

	public ImportVideoPanel(final String id)
	{
		super(id);
		Injector.get().inject(this);

		final Form<Void> form = new Form<>("form");
		this.file = new FileUploadField("videoFile");
		form.setMarkupId("inputForm").setOutputMarkupId(true);
		form.setMaxSize(Bytes.kilobytes(5));
		form.setMultiPart(true);
		form.add(this.file);
		this.add(form);

		final Button upload = new Button("upload")
		{
			@Override
			public void onSubmit()
			{
				ImportVideoPanel.LOGGER.info("trying to upload something");

				//final FileUpload fupload = ImportDeckDialog.this.file.getFileUpload();
				//if (fupload == null)
				//{
					// No file was provided
				//	ImportDeckDialog.LOGGER.info("Please provide a valid file");
				//	return;
				//}
				//else if (fupload.getSize() == 0)
				//{
				//	ImportDeckDialog.LOGGER.info("Please provide a non-empty file");
				//	return;
				//}
				//else if ((fupload.getClientFileName() == null)
				//		|| ("".equals(fupload.getClientFileName().trim()))
				//		|| (fupload.getClientFileName().endsWith(".txt")))
				//{
				//	ImportDeckDialog.LOGGER.info("Please provide a valid file");
				//	return;
				//}

				//ImportDeckDialog.LOGGER.info("uploading file: "
				//		+ ImportDeckDialog.this.file.getFileUpload().getClientFileName());

				//try
				//{
				//	new String(fupload.getBytes(), "UTF-8");
				ImportVideoPanel.convert("/home/nostromo/test.avi", "/home/nostromo/test.wav");
				//}
				//catch (final UnsupportedEncodingException e)
				//{
				//	ImportDeckDialog.LOGGER.info("Please provide a file encoded with UTF-8 charset");
				//	return;
				//}

				//ImportDeckDialog.LOGGER.info("successfully added deck: "
				//		+ fupload.getClientFileName());
				ImportVideoPanel.LOGGER.info("Your file has been successfully uploaded");
			}
		};
		
		form.add(upload);
	}
	
	public static void convert(String from, final String to) { 
		//Runtime.getRuntime().exec(
		//	"ffmpeg -i " + from + "-acodec pcm_s16le -ac 2 " + to);
		try {
		ProcessBuilder pb = new ProcessBuilder("ffmpeg", "i", from, "acodec", "pcm_s16le", "ac", "2", to);
		System.out.println("Run ffmpeg command");
		Process process = pb.start();
		int errCode = process.waitFor();
		System.out.println("ffmpeg command executed, any errors? " + (errCode == 0 ? "No" : "Yes"));
		System.out.println("ffpmeg Output:\n" + output(process.getInputStream()));   
		}
		catch (Exception e) {
			ImportVideoPanel.LOGGER.error("error fonverti g video to wav", e);
		}
	}
	
	private static String output(InputStream inputStream) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(inputStream));
			String line = null;
			while ((line = br.readLine()) != null) {
				sb.append(line + System.getProperty("line.separator"));
			}
		} finally {
			br.close();
		}
		return sb.toString();
	}
}
