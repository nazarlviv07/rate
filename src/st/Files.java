package st;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;

public class Files {
	public boolean downloadFile(String kontora, String webSite)
			throws IOException {
		System.out.println("download file ");

		URL url;
		url = new URL(webSite);
		File destination = new File(kontora + ".html");

		try {

			FileUtils.copyURLToFile(url, destination);

		} catch (MalformedURLException e) {

			e.printStackTrace();
			return false;
		}

		return true;
	}
}
