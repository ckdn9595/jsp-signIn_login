package naverapi;
import java.net.URLEncoder;
import java.security.*;
import java.math.BigInteger;
public class Nlogin {
	public static void main(String[] args) {
		
	String clientId = "2zF0slKFPpw3BrSwHK9t";
	String redirectURI = URLEncoder.encode("/cls/main.cls", "UTF-8");
	SecureRandom random = new SecureRandom();
	String state = new BigInteger(130, random).toString();
	String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
	apiURL += "&client_id=" + clientId;
    apiURL += "&redirect_uri=" + redirectURI;
    apiURL += "&state=" + state;
    session.setAttribute("state", state);
	}
    

}
