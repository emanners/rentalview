package com.edsapps.carlist.utility;

import com.edsapps.carlist.model.CarResponse;

import java.io.IOException;
import java.util.List;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public final class CarService {

    private static final String API_BASE_URL =  "http://www.cartrawler.com/";

    private static CarServiceI _instance;

    private static final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static final Retrofit.Builder  builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());


    public interface CarServiceI {
        @GET("/ctabe/cars.json") Call<List<CarResponse>> getCarService();
    }

    private static <S> S createCarService(Class<S> serviceClass) {

            httpClient.addInterceptor(new Interceptor() {
              @Override
              public Response intercept(Chain chain) throws IOException {
                  Request original = chain.request();
                  HttpUrl originalHttpUrl = original.url();

                  HttpUrl url = originalHttpUrl.newBuilder().build();

                  Request.Builder requestBuilder = original.newBuilder().url(url);

                  Request request = requestBuilder.build();
                  return chain.proceed(request);
              }
            });

            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClient.addInterceptor(logging);

            OkHttpClient client = httpClient.build();
            Retrofit retrofit = builder.client(client).build();
            return retrofit.create(serviceClass);
    }



    public static CarServiceI getInstance() {

        if (_instance == null)
            _instance = CarService.createCarService(CarServiceI.class);

        return _instance;
    }


}