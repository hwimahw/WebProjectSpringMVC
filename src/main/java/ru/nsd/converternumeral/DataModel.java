package ru.nsd.converternumeral;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class DataModel {

    private String number;

    private int a;

    private int b;

    private String result;

    public DataModel(String number, int a, int b, String result) {
        this.number = number;
        this.a = a;
        this.b = b;
        this.result = result;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public JSONObject toJson() {
        JSONObject mainJson = new JSONObject();
        JSONObject json = new JSONObject();
        JSONArray rows = new JSONArray();
        JSONArray data = new JSONArray();
        data.element(this.number);
        data.element(this.a);
        data.element(this.b);
        data.element(this.result);
        json.element("id", 1);
        json.element("data", data);
        rows.element(json);
        mainJson.element("rows", rows);
        return mainJson;
    }
}
