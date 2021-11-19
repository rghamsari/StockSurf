package com.ghamsari.stocksurf.NetWork;

import android.database.Observable;

import java.util.List;

import io.reactivex.Single;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface jsonBtcusdtHolder {
    @GET("klines")
    Call<ResponseBody> getBitcoin(@Query("interval") String interval , @Query("symbol") String symbol );
}
