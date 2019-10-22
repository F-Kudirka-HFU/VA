import javax.net.ssl.HttpsURLConnection;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class HTTPSClient {
    /**
     * Returns true if site exists and is reachable. If not it returns false.
     * @param url HTTP-URL
     * @return returns boolean
     */
    public static boolean urlExists(String url) {
        try {
            URL u = new URL(url);
            HttpsURLConnection con = (HttpsURLConnection)u.openConnection();
        }
        catch (IOException e) {
            return false;
        }
        return true;
    }

    /**
     * Gets the header from a URL
     * @param url HTTP-URL
     * @return returns the Header as a Map.
     * @throws IOException
     */
    public static Map getHeader(String url) throws IOException {
        if(urlExists(url)) {
            URL u = new URL(url);
            HttpsURLConnection con = (HttpsURLConnection) u.openConnection();
            return con.getHeaderFields();
        }
        return null;
    }

    /**
     * Prints out Header to the console
     * @param url HTTP-URL
     * @throws IOException
     */
    public static void get(String url) throws IOException {
        if(urlExists(url)) {
            Map<String, List<String>> map = getHeader(url);
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                System.out.println(entry.getValue());
            }
        }
        else {
            System.out.println("Error while trying to reach the site.");
        }

    }

    /**
     * Returns the header as String.
     * @param url
     * @return
     * @throws IOException
     */

    public static String toString(String url) throws IOException {
        if(urlExists(url)) {
            Map<String, List<String>> map = getHeader(url);
            StringBuffer bf = new StringBuffer();
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                bf.append(entry.getValue()).append("\n");
            }
            return bf.toString();
        }
        return "Error while trying to reach the site.";
    }

    /**
     * Tests static methods with URLs
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String url = "https://www.bundestag.de/presse";
        System.out.println("Is site valid? " + HTTPSClient.urlExists(url));
        System.out.println();
        System.out.println("get Method");
        HTTPSClient.get(url);
        System.out.println();
        System.out.println("toString Method:");
        System.out.println(HTTPSClient.toString(url));
    }
}
