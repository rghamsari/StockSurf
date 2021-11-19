package com.ghamsari.stocksurf.NetWork;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ghamsari.stocksurf.BtRecyclerView;
import com.ghamsari.stocksurf.MainActivity;
import com.ghamsari.stocksurf.Model.Bitcoin;
import com.ghamsari.stocksurf.R;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

    public class GetBtcu extends AsyncTask<Void,Void,Void> {

        private ProgressDialog progressDialog;
        private  Activity activity;
        List<Bitcoin> Btcu = new ArrayList<>();

        public GetBtcu(Activity activity) {
            this.activity = activity;
        }

        public Activity getActivity() {
            return activity;
        }


        @Override
        protected Void doInBackground(Void... voids) {
            Retrofit retrofit = ApiClient.getRetrofitInstance();
            jsonBtcusdtHolder api;
            api =retrofit.create(jsonBtcusdtHolder.class);
            Call<ResponseBody> getBtcUsdt =api.getBitcoin("1m","BTCUSDT");
            getBtcUsdt.enqueue(new Callback<ResponseBody>() {
                @RequiresApi(api = Build.VERSION_CODES.N)


                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if(response.isSuccessful()){
                        try {

                            String jsonString = response.body().string();
                            JSONArray jsonArray =new JSONArray(jsonString);
                            JSONArray jsonArray2 = new JSONArray();
                            for(int i =0 ; i<jsonArray.length();i++) {
                                jsonArray2= (JSONArray) jsonArray.get(i);

                                Bitcoin bitcoin = new Bitcoin();
                                bitcoin.setOpen_time(jsonArray2.getLong(0));

                                bitcoin.setOpen(jsonArray2.getLong(1));

                                bitcoin.setHigh(jsonArray2.getLong(2));

                                bitcoin.setLow(jsonArray2.getLong(3));

                                bitcoin.setClose(jsonArray2.getLong(4));

                                bitcoin.setVolume(jsonArray2.getLong(5));

                                bitcoin.setClose_time(jsonArray2.getLong(6));

                                bitcoin.setQuote_asset_volume(jsonArray2.getLong(7));

                                bitcoin.setNumber_of_trades(jsonArray2.getLong(8));

                                bitcoin.setTaker_buy_base_asset_volume(jsonArray2.getLong(9));

                                bitcoin.setTaker_buy_quote_asset_volume(jsonArray2.getLong(10));

                                bitcoin.setIgnor(jsonArray2.getLong(11));

                                Btcu.add(bitcoin);

                                //    }

                            }
                            RecyclerView recyclerView = activity.findViewById(R.id.recyclview);

                            recyclerView.setLayoutManager(new LinearLayoutManager(activity));

                            BtRecyclerView adapter = new BtRecyclerView();

                            adapter.CustomAdapter(BtRenge(BtSort(Btcu)));

                            recyclerView.setAdapter(adapter);
                        } catch (IOException | JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable t) {

                    Log.v("code",String.valueOf(t.getMessage())+ "  b1" );

                }
            });
            progressDialog.dismiss();
            return null;
        }

        @Override
        protected void onPreExecute() {
            progressDialog =new ProgressDialog(activity);
            progressDialog.setMessage("Pleas Wait....");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }
        @RequiresApi(api = Build.VERSION_CODES.N)
        public List<Bitcoin> BtSort(List<Bitcoin> Btcouin) {
            Btcouin.sort(new Comparator<Bitcoin>() {
                @Override
                public int compare(Bitcoin o1, Bitcoin o2) {
                    //      return o1.High.compareTo(o2.High);
                    return Long.compare(o1.getHigh(), o2.getHigh());
                }
            });
            return Btcouin;
        }


        public List<Bitcoin> BtRenge(List<Bitcoin> Btcouin) {
            List<Bitcoin> temp = new ArrayList<>();
            temp.addAll(Btcouin);
            int small = 0, large = Btcouin.size();
            boolean flag = true;
            for (int i = 0; i < Btcouin.size(); i++) {
                if (flag) {
                    Btcouin.set(i, temp.get(--large));
                } else {
                    Btcouin.set(i, temp.get(small++));
                }
                flag = !flag;

            }
            return Btcouin;

        }
    }


