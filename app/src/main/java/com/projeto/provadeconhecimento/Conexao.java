package com.projeto.provadeconhecimento;

import android.os.AsyncTask;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.projeto.provadeconhecimento.ClassesDTO.ListaOficinas;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Conexao extends AsyncTask<String, Void, String> {

    public static final String REQUEST_METHOD = "GET";
    public static final int READ_TIMEOUT = 25000;
    public static final int CONNECTION_TIMEOUT = 25000;
    public  List<String> lista;
    private int data;

    @Override
    protected String doInBackground(String... strings) {

        String stringUrl = "http://app.hinovamobile.com.br/ProvaConhecimentoWebApi/Api/Oficina?codigoAssociacao=601&cpfAssociado=";
        String result;
        String inputLine;
        try {

            URL myUrl = new URL(stringUrl);
            //conexao
            HttpURLConnection connection = (HttpURLConnection) myUrl.openConnection();
            //metodos
            connection.setRequestMethod(REQUEST_METHOD);
            connection.setReadTimeout(READ_TIMEOUT);
            connection.setConnectTimeout(CONNECTION_TIMEOUT);

            //Connectando a url
            connection.connect();

            InputStreamReader streamReader = new InputStreamReader(connection.getInputStream());

            BufferedReader reader = new BufferedReader(streamReader);

            StringBuilder stringBuilder = new StringBuilder();

            while ((inputLine = reader.readLine()) != null)
            {
                stringBuilder.append(inputLine);

            }

            reader.close();
            streamReader.close();

            result = stringBuilder.toString();


            retornoOficinas(result);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            result = null;
        }

        return result;
    }

    public void retornoOficinas(String result)
    {
        lista = new ArrayList<>();
        lista.add(result);


    }

    public String  performPostCall(String requestURL, HashMap<String, String> postDataParams) throws IOException {

        URL url = new URL("http://app.hinovamobile.com.br/ProvaConhecimentoWebApi/Api/Indicacao");
        URLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
        wr.write(data);
        wr.flush();
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readline()) != null) {
            sb.append(line + "\n");

        }
        String text = sb.toString();
        } catch (Exception ex)

        {
        }finally

    {
        try {
            reader.close();
        } catch (Exception ex) {
        }

    }

    content.setText(text);

      /*  conn.setRequestMethod("GET");
        conn.setDoInput(true);
        conn.setDoOutput(true);


        OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, "UTF-8"));
            writer.write(getPostDataString(postDataParams));

            writer.flush();
            writer.close();
            os.close();
            int responseCode=conn.getResponseCode();

            if (responseCode == HttpsURLConnection.HTTP_OK) {
                String line;
                BufferedReader br=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                while ((line=br.readLine()) != null) {
                    response+=line;
                }
            }
            else {
                response="";

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return response;
    }*/

    }