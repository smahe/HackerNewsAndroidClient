package hackernewsreader.app;

import android.os.AsyncTask;
import android.util.Log;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

public class Helper {
    private static final String LOG_TAG = Helper.class.getName();
    public Helper(){
        new AsyncTask<String, Integer, String>(){

            @Override
            protected String doInBackground(String... params) {
                try {
                    NetworkClient client = NetworkClient.getClient();
                    //Hitting localhost
                    Request request = new Request.Builder().url("http://192.168.56.1:3000/top")
//                            .header("User-Agent","OkHttp Headers.java")
//                            .addHeader("Accept-Encoding","gzip")
                            .addHeader("Accept","application/json").build();
                    Response response = client.request(request);
                    InputStream is = response.body().byteStream();
                    Log.d(LOG_TAG,"++++++++++"+response.message());
                    byte[] buffer = new byte[1024];
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    is.read();
                    int numRead = 0;
                    while ((numRead = is.read(buffer)) != -1) {
                        baos.write(buffer, 0, numRead);
                    }
                    String con = new String(baos.toByteArray());
                    Log.d(LOG_TAG,"====================="+con);
                    //                    GZIPInputStream gis = new GZIPInputStream(new BufferedInputStream(is));
//                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
//                    byte[] buffer = new byte[1024];
//                    int numRead = 0;
//                    while ((numRead = gis.read(buffer)) != -1) {
//                        baos.write(buffer, 0, numRead);
//                    }
//                    String con = new String(baos.toByteArray());
//                    Log.d(LOG_TAG,con);
//                    is.close();
//                    gis.close();

                } catch (Exception e) {
                    Log.d(LOG_TAG, "EXCEPTION IN DO IN BACKGROUND");
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);
            }
        }.execute();
    }
}
