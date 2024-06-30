import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLConnection {
    public static void main(String[] args) {

        try {
            // Create a Url object from the String.
            URL url = new URL("https://delhi.nfsu.ac.in/Home");

            // Create a HttpUrlConnection object.
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Setup the HttpUrlConnection object.
            conn.setRequestMethod("GET");

            // Get the response code.
            int responseCode = conn.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            if(responseCode == 200){
                // If the response code is 200 (HTTP_OK) then read the input stream.
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();

                // Read the input stream.
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }

                // Close connections.
                in.close();
                conn.disconnect();

                System.out.println("Output: " + content.toString());
            }else{
                System.out.println("GET request not worked");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
