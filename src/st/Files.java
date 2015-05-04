package st;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.io.FileUtils;

public class Files {
	public boolean downloadFile(String kontora, String webSite)
			throws IOException {
		System.out.println("download file ");

		URL url;
		url = new URL(webSite);
		File destination = new File(kontora + ".html");

		// =================================================
		
		// Create a trust manager that does not validate certificate chains
		/*TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager(){
		    public X509Certificate[] getAcceptedIssuers(){return null;}
		    public void checkClientTrusted(X509Certificate[] certs, String authType){}
		    public void checkServerTrusted(X509Certificate[] certs, String authType){}
		}};

		// Install the all-trusting trust manager
		try {
		    SSLContext sc = SSLContext.getInstance("TLS");
		    sc.init(null, trustAllCerts, new SecureRandom());
		    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} catch (Exception e) {
		    ;
		}*/
		//===============================================
		try {

			FileUtils.copyURLToFile(url, destination);

		} catch (MalformedURLException e) {

			e.printStackTrace();
			return false;
		}

		return true;
	}
}
