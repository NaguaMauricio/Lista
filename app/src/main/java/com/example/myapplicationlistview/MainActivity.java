package com.example.myapplicationlistview;



import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Asynchtask{
ListView lstLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstLista = (ListView) findViewById(R.id.lstLista);
        // Bundle bundle = this.getIntent().getExtras();
        Map<String, String> datos = new HashMap<String, String>();
        WebServices ws= new WebServices("https://api.androidhive.info/contacts/", datos,
                MainActivity.this, MainActivity.this);
        ws.execute("");


    }


    @Override
    public void processFinish(String result) throws JSONException {
        Log.i("processFinish", result);
        ArrayList<String> contactList = null;
        String datosContac = " ";
        JSONObject jsonObj= new JSONObject(result);
//Getting Json Array node
        JSONArray contacts=jsonObj.getJSONArray("contacts");


        for(int i=0;i<contacts.length();i++){
            JSONObject c=contacts.getJSONObject(i);
            String id = c.getString("id");
            String name =c.getString("name");
            String email =c.getString("email");
            String address =c.getString("address");
            String gender = c.getString("gender");


            JSONObject phone =c.getJSONObject("phone");
            String mobile = phone.getString("mobile");
            String home = phone.getString("home");
            String office = phone.getString("office");
            HashMap<String,String> contact= new HashMap<>();

            contact.put("id",id);
            contact.put("name",name);
            contact.put("email",email);
            contact.put("mobile",mobile);

            datosContac = datosContac + contact.put("id", id)+" ";
            datosContac = datosContac + contact.put("name", name)+"\n";
            datosContac = datosContac + contact.put("mobile", mobile)+"\n"+"\n";



        }
        lstLista= datosContac;
    }
    

//DATASource
    //public Noticias[] noticias =
      //      new Noticias[]{
        //            new Noticias("Noticia 1", "SubNoticia Contenido Contenido Contenido Contenido 1"),
          //          new Noticias("Noticia 2", "SubNoticia Contenido Contenido Contenido Contenido 2"),
            //        new Noticias("Noticia 3", "SubNoticia Contenido Contenido Contenido Contenido 3"),
              //      new Noticias("Noticia 4", "SubNoticia Contenido Contenido Contenido Contenido 4")
    //};


   // @Override
  //  protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
  //     //ADAPTADOR DE DATOS
    //    AdaptadorNoticias adaptadornoticias = new AdaptadorNoticias(this, noticias); //parcea una JSON webService
      //  ListView lstOpciones = (ListView)findViewById(R.id.lstLista);
//        lstOpciones.setAdapter(adaptadornoticias);

  //      View header = getLayoutInflater().inflate(R.layout.ly_cabezera, null);
    //    lstOpciones.addHeaderView(header);
    //}



}
