package com.zsx.http;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

/**
 * @date 2022/11/1
 */
public class GetHttpUtils {


    public static void main(String[] args) {

        OkHttpClient okHttpClient = new OkHttpClient();

        Request request = new Request.Builder().url("https://www.baidu.com").build();

        try (Response response = okHttpClient.newCall(request).execute()) {
            System.out.println(response.body().string());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //

        RequestBody requestBody = new FormBody.Builder()
                .add("q","test")
                .add("wd","java")
                .build();

        Request postReq = new Request.Builder().url("https://www.baidu.com")
                .post(requestBody).build();
        try (Response response = okHttpClient.newCall(postReq).execute()) {
            System.out.println(response.body().string());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
