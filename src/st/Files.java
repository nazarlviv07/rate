package st;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.zip.GZIPInputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

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

	/*if (kontora.equalsIgnoreCase("Fonbet")){*/
		 BufferedWriter writer = new BufferedWriter(new FileWriter(kontora +".html"));

         writer.write(downloadHtml(webSite));
         writer.newLine();
      
      writer.close();
	/*}else{
		try {

			FileUtils.copyURLToFile(url, destination);

		} catch (MalformedURLException e) {

			e.printStackTrace();
			return false;
		}
		
	}  */
		return true;
	}
	
	private static String downloadHtml(String urlString) {
	    URL url = null;
	    InputStream inStr = null;
	    StringBuffer buffer = new StringBuffer();

	    try {
	        url = new URL(urlString);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection(); // Cast shouldn't fail
	        HttpURLConnection.setFollowRedirects(true);
	        // allow both GZip and Deflate (ZLib) encodings
	        //conn.setRequestProperty("Accept-Encoding", "gzip, deflate"); 
	        String encoding = conn.getContentEncoding();
	        inStr = null;

	        // create the appropriate stream wrapper based on
	        // the encoding type
	        if (encoding != null && encoding.equalsIgnoreCase("gzip")) {
	            inStr = new GZIPInputStream(conn.getInputStream());
	        } else if (encoding != null && encoding.equalsIgnoreCase("deflate")) {
	            inStr = new InflaterInputStream(conn.getInputStream(),
	              new Inflater(true));
	        } else {
	            inStr = conn.getInputStream();
	        }
	        int ptr = 0;


	        InputStreamReader inStrReader = new InputStreamReader(inStr);
	        //InputStreamReader inStrReader = new InputStreamReader(inStr, Charset.forName("GB2312"));

	        while ((ptr = inStrReader.read()) != -1) {
	            buffer.append((char)ptr);
	        }
	        inStrReader.close();

	        conn.disconnect();
	    }
	    catch(Exception e) {

	        e.printStackTrace();
	    }
	    finally {
	        if (inStr != null)
	            try {
	                inStr.close();
	            } catch (IOException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	    }

	    return buffer.toString();
	  }
}
