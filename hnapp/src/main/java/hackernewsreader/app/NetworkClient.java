package hackernewsreader.app;

import android.util.Log;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;

public class NetworkClient {
    private static String LOG_TAG = NetworkClient.class.getName();
    private OkHttpClient client = new OkHttpClient();
    private static NetworkClient nwclient = null;

    private NetworkClient(){
    }

    public static NetworkClient getClient(){
        if(nwclient == null ){
            nwclient = new NetworkClient();
            Log.d(LOG_TAG,"Single Client");
        }
        return nwclient;
    }

    public Response request(Request request){
        try {
            Response response = client.newCall(request).execute();
            return response;
        } catch (IOException e) {
            Log.d(LOG_TAG,"Exception in request network client");
            e.printStackTrace();
        }
        return null;
    }

}


