package st;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.json.JSONTokener;

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
		
		/*JSONObject jo = (JSONObject) new JSONTokener(IOUtils.toString(new URL("http://gdata.youtube.com/feeds/api/videos/SIFL9qfmu5U?alt=json"))).nextValue();
		System.out.println(jo);
		URL url2 = new URL("http://live.fonbet.com/live/currentLine/ru/?0.20472579340931407");
	      BufferedReader reader = new BufferedReader(new InputStreamReader(url2.openStream()));
	      BufferedWriter writer = new BufferedWriter(new FileWriter("data.html"));
	      String line;
	      while ((line = reader.readLine()) != null) {
	        // System.out.println(line);
	         writer.write(line);
	         writer.newLine();
	      }
	      reader.close();
	      writer.close();
*/
		return true;
	}
}
