package ru.nsd.islandcount;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.Random;

public class Data {
    private int id;
    private int n;
    private int m;
    private String matrix;
    private int result;

    public Data(){

    }

    public Data(int n, int m, String matrix, int result){
        Random rand = new Random();
        id = rand.nextInt(5);
        this.n = n;
        this.m = m;
        this.matrix = matrix;
        this.result = result;
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public String getMatrix() {
        return matrix;
    }

    public int getResult() {
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setM(int m) {
        this.m = m;
    }

    public void setMatrix(String matrix) {
        this.matrix = matrix;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public JSONObject dataFromFileToJson() {
        JSONObject jsonMainObject = new JSONObject();
        JSONArray rows = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        int id = 1;
        JSONArray data = new JSONArray();
        data.element(n);
        data.element(m);
        data.element(this.matrix);
        data.element(this.result);
        jsonObject.element("id", id);
        jsonObject.element("data", data);
        rows.element(jsonObject);
        jsonMainObject.element("rows", rows);
        return jsonMainObject;
    }

    public String getJsonString(){
        JSONObject json = dataFromFileToJson();
        return json.toString();
    }







}
