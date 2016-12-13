package com.edsapps.carlist.utility;

import android.app.Activity;

import com.edsapps.carlist.BuildConfig;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class FakeInterceptor implements Interceptor {
    // FAKE RESPONSES.
    private final static String responseString = "";

    private Activity activity = null;

    public FakeInterceptor(Activity activity) {
        super();
        this.activity = activity;

    }
    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response;
        if(BuildConfig.DEBUG) {

            StringBuilder buf=new StringBuilder();
            InputStream json=activity.getAssets().open("car.json");
            BufferedReader in=
                    new BufferedReader(new InputStreamReader(json, "UTF-8"));
            String responseString;
            while ((responseString=in.readLine()) != null) {
                buf.append(responseString);
            }

            in.close();

            response = new Response.Builder()
                    .code(200)
                    .message(buf.toString())
                    .request(chain.request())
                    .protocol(Protocol.HTTP_1_0)
                    .body(ResponseBody.create(MediaType.parse("application/json"), buf.toString().getBytes()))
                    .addHeader("content-type", "application/json")
                    .build();
        } else {
            response = chain.proceed(chain.request());
        }

        return response;
    }
}