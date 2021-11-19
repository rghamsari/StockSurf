package com.ghamsari.stocksurf.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Bitcoin {
    @SerializedName("0")
    @Expose
    long Open_time;
    @SerializedName("1")
    @Expose
    long Open;
    @SerializedName("2")
    @Expose
    long High;
    @SerializedName("3")
    @Expose
    long Low;
    @SerializedName("4")
    @Expose
    long Close;
    @SerializedName("5")
    @Expose
    long Volume;
    @SerializedName("6")
    @Expose
    long Close_time;
    @SerializedName("7")
    @Expose
    long Quote_asset_volume;
    @SerializedName("8")
    @Expose
    long Number_of_trades;
    @SerializedName("9")
    @Expose
    long Taker_buy_base_asset_volume;
    @SerializedName("10")
    @Expose
    long Taker_buy_quote_asset_volume;
    @SerializedName("11")
    @Expose
    long Ignor;

    public void setClose(long close) {
        Close = close;
    }

    public void setClose_time(long close_time) {
        Close_time = close_time;
    }

    public void setHigh(long high) {
        High = high;
    }

    public void setIgnor(long ignor) {
        Ignor = ignor;
    }

    public void setLow(long low) {
        Low = low;
    }

    public void setNumber_of_trades(long number_of_trades) {
        Number_of_trades = number_of_trades;
    }

    public void setOpen(long open) {
        Open = open;
    }

    public void setOpen_time(long open_time) {
        Open_time = open_time;
    }

    public void setQuote_asset_volume(long quote_asset_volume) {
        Quote_asset_volume = quote_asset_volume;
    }

    public void setTaker_buy_base_asset_volume(long taker_buy_base_asset_volume) {
        Taker_buy_base_asset_volume = taker_buy_base_asset_volume;
    }

    public void setTaker_buy_quote_asset_volume(long taker_buy_quote_asset_volume) {
        Taker_buy_quote_asset_volume = taker_buy_quote_asset_volume;
    }

    public void setVolume(long volume) {
        Volume = volume;
    }

    public long getClose() {
        return Close;
    }

    public long getClose_time() {
        return Close_time;
    }

    public long getQuote_asset_volume() {
        return Quote_asset_volume;
    }

    public long getTaker_buy_base_asset_volume() {
        return Taker_buy_base_asset_volume;
    }

    public long getTaker_buy_quote_asset_volume() {
        return Taker_buy_quote_asset_volume;
    }

    public long getHigh() {
        return High;
    }

    public long getIgnor() {
        return Ignor;
    }

    public long getLow() {
        return Low;
    }

    public long getNumber_of_trades() {
        return Number_of_trades;
    }

    public long getOpen() {
        return Open;
    }

    public long getOpen_time() {
        return Open_time;
    }

    public long getVolume() {
        return Volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bitcoin bitcoin = (Bitcoin) o;
        return High== bitcoin.High;
    }

    @Override
    public int hashCode() {
        return Objects.hash(High);
    }
}
