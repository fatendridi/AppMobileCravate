package com.dvinfosys.androidcustomnavigationdrawerusingexpandablelistview.Activity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.dvinfosys.androidcustomnavigationdrawerusingexpandablelistview.Compte;
import com.dvinfosys.androidcustomnavigationdrawerusingexpandablelistview.Model.ChildModel;
import com.dvinfosys.androidcustomnavigationdrawerusingexpandablelistview.Model.HeaderModel;
import com.dvinfosys.androidcustomnavigationdrawerusingexpandablelistview.Notification;
import com.dvinfosys.androidcustomnavigationdrawerusingexpandablelistview.Panier;
import com.dvinfosys.androidcustomnavigationdrawerusingexpandablelistview.R;
import com.dvinfosys.androidcustomnavigationdrawerusingexpandablelistview.Utils.Common;
import com.dvinfosys.androidcustomnavigationdrawerusingexpandablelistview.View.ExpandableNavigationListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;


public class CravateEnfant extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

private static final String URL_DATA1 = "https://www.cravate.tn/api/products/?output_format=JSON&filter[id_category_default]=61&display=[id,name,price]&ws_key=BZ919DXR2Z7PEZPY76J4MVDJWLP5MJ6V&fbclid=IwAR23UWKRg7E_vqwdIhUTyzxksVgGS3mExqGC1uBnTmchmQditpvOz9AioDU";
private static final String URL_DATA = "https://www.cravate.tn/api/images/products&filter[id_category_default]=61?ws_key=BZ919DXR2Z7PEZPY76J4MVDJWLP5MJ6V";
private static final String WS_KEY = "?ws_key=BZ919DXR2Z7PEZPY76J4MVDJWLP5MJ6V";

        ArrayList<ProduitCravateEnfant> listprod;
private RecyclerView.Adapter adapter;

private DrawerLayout drawer;
private ActionBarDrawerToggle toggle;
private NavigationView navigationView;
private ExpandableNavigationListView navigationExpandableListView;
private Context context;
private RecyclerView recyclerView;

        Dialog myDialog;
        Button btn_essayage ;

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cravate_enfant);

       Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
       setSupportActionBar(toolbar);



        getSupportActionBar().setIcon(R.drawable.logocravate);
        context = CravateEnfant.this;


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
@Override
public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
        case R.id.navigation_back:
        Intent c = new Intent(CravateEnfant.this, MainActivity.class);
        startActivity(c);
        break;
        case R.id.navigation_usb:
        Intent a = new Intent(CravateEnfant.this, Panier.class);
        startActivity(a);
        break;
        case R.id.navigation_logo:
        Intent b = new Intent(CravateEnfant.this, Compte.class);
        startActivity(b);
        break;


        }
        return false;
        }
        });



    navigationExpandableListView = (ExpandableNavigationListView) findViewById(R.id.expandable_navigation);

    drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
    drawer.addDrawerListener(toggle);
    toggle.syncState();

    NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);
        navigationExpandableListView
        .init(this)

        .addHeaderModel(
        new HeaderModel("Cravate", R.drawable.plus, true)
        .addChildModel(new ChildModel("Cravate Classique"))
        .addChildModel(new ChildModel("Cravate Slim"))
        .addChildModel(new ChildModel("Cravate Large"))
        .addChildModel(new ChildModel("Cravate Soie"))
        .addChildModel(new ChildModel("Cravate Personnalisée"))

        )

        .addHeaderModel( new HeaderModel("Chemise"))
        .addHeaderModel(
        new HeaderModel("Ceinture", R.drawable.plus, true)
        .addChildModel(new ChildModel("Ceinture Cuir"))
        .addChildModel(new ChildModel("Ceinture Cuir de Djean"))

        )

        .addHeaderModel( new HeaderModel("Noeud Papillon"))
        .addHeaderModel(
        new HeaderModel("Sous-Vetements", R.drawable.plus, true)
        .addChildModel(new ChildModel("Débardeur"))
        .addChildModel(new ChildModel("Chaussettes"))
        .addChildModel(new ChildModel("Boxer"))



        )
        .addHeaderModel(
        new HeaderModel("Accessoires", R.drawable.plus, true)
        .addChildModel(new ChildModel("Pochette"))
        .addChildModel(new ChildModel("Porte Cartes"))
        .addChildModel(new ChildModel("Porte Monnaie"))

        .addChildModel(new ChildModel("Coffret Cadeau"))
        .addChildModel(new ChildModel("Porte Chéquier"))


        )
        .addHeaderModel(
        new HeaderModel("Enfant", R.drawable.plus, true)
        .addChildModel(new ChildModel("Cravate Enfant"))
        .addChildModel(new ChildModel("Noeud Papillon Enfant"))




        )
        .addHeaderModel(
        new HeaderModel("Blog", R.drawable.plus, true)
        .addChildModel(new ChildModel("Histoire de la Cravate"))
        .addChildModel(new ChildModel("Nos Conseils"))
        .addChildModel(new ChildModel("Comment Faire un Noeud de Cravate"))

        .addChildModel(new ChildModel("Comment Choisir la taille de Ceinture"))
        .addChildModel(new ChildModel("Comment Régler Votre Ceinture"))


        )




        .build()
        .addOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
@Override
public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
        navigationExpandableListView.setSelected(groupPosition);

        //drawer.closeDrawer(GravityCompat.START);
        if (id == 0) {
        //Home Menu



        } else if (id == 1) {

        Intent it = new Intent(CravateEnfant.this,Chemise.class);
        startActivity(it);

        } else if (id == 2) {




        } else if (id == 3) {

        Intent i1 = new Intent(CravateEnfant.this,NoeudPapillon.class);
        startActivity(i1);


        } else if (id == 4) {



        }
        else if (id == 5) {



        }
        return false;
        }
        })
        .addOnChildClickListener(new ExpandableListView.OnChildClickListener() {
@Override
public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        navigationExpandableListView.setSelected(groupPosition, childPosition);

        if(groupPosition==0) {


        if (id == 0) {
        Intent i = new Intent(CravateEnfant.this,CravateClassique.class);
        startActivity(i);
        } else if (id == 1) {
        Intent iiii = new Intent(CravateEnfant.this,CravateSlim.class);
        startActivity(iiii);
        } else if (id == 2) {
        Intent ii = new Intent(CravateEnfant.this, CravateLarge.class);
        startActivity(ii);
        } else if (id == 3) {
        Intent iii = new Intent(CravateEnfant.this,CravateSoie.class);
        startActivity(iii);
        } else if (id == 4) {
        Common.showToast(context, "Cravate Personnalisée");
        }
        }
        else if(groupPosition==2){
        if (id == 0) {
        Intent i2 = new Intent(CravateEnfant.this,CeintureCuir.class);
        startActivity(i2);

        } else if (id==1) {
        Common.showToast(context, "Ceinture Cuir de Djean");
        }

        }
        else if(groupPosition==4){
        if (id == 0) {
        Intent i22 = new Intent(CravateEnfant.this,Debardeur.class);
        startActivity(i22);

        } else if (id==1) {
        Intent i21 = new Intent(CravateEnfant.this,Chaussettes.class);
        startActivity(i21);
        }
        else if (id==2) {
        Common.showToast(context, "boxer");
        }

        }



        else if (groupPosition==5 ){
        if (id == 0) {
        Intent i3 = new Intent(CravateEnfant.this,Pochette.class);
        startActivity(i3);
        } else if (id == 1) {
        Intent i33 = new Intent(CravateEnfant.this,PorteCartes.class);
        startActivity(i33);
        } else if (id == 2) {
        Intent i333 = new Intent(CravateEnfant.this,PorteMonnaie.class);
        startActivity(i333);

        } else if (id == 3) {
        Intent i3333 = new Intent(CravateEnfant.this,CoffertCadeau.class);
        startActivity(i3333);

        }else{
        Common.showToast(context, "Porte chéquiér");
        }

        }
        else if (groupPosition==7 ){
        if (id == 0) {
        Intent i5 = new Intent(CravateEnfant.this,BlogHistoireCravate.class);
        startActivity(i5);
        } else if (id == 1) {
        Intent i6 = new Intent(CravateEnfant.this,BlogNosConseils.class);
        startActivity(i6);
        } else if (id == 2) {
        Common.showToast(context, "Comment Faire un Noeud de Cravate");
        } else if (id == 3) {
        Intent i7 = new Intent(CravateEnfant.this,BlogChoisirTailleCeinture.class);
        startActivity(i7);
        }else{
        Intent i8 = new Intent(CravateEnfant.this,BlogReglerCeinture.class);
        startActivity(i8);

        }

        }

        drawer.closeDrawer(GravityCompat.START);
        return false;
        }
        });
        //navigationExpandableListView.expandGroup(2);


        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(CravateEnfant.this));
        listprod=new ArrayList<ProduitCravateEnfant>();

final RetryPolicy retryPolicy = new RetryPolicy() {
@Override
public int getCurrentTimeout() {
        return 50000;
        }

@Override
public int getCurrentRetryCount() {
        return 50000;
        }

@Override
public void retry(VolleyError error) throws VolleyError {

        }
        };


        StringRequest stringRequest3 = new StringRequest(StringRequest.Method.GET, URL_DATA1, new Response.Listener<String>() {
@Override
public void onResponse(String response) {
        ProduitCravateEnfant produit;
        JSONArray array;
        String out = "";

        try {
        out = new String(response.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
        }
        try {
        JSONObject jobject = new JSONObject(out);
        array  = jobject.getJSONArray("products");
        for(int i =0;i<array.length();i++){
        JSONObject object =array.getJSONObject(i);
        produit = new ProduitCravateEnfant(object.getInt("id"),object.getString("name"),object.getString("price").substring(0,6)+" Dt");
        listprod.add(produit);
        }

        }
        catch (JSONException e) {
        e.printStackTrace();
        }
        }

        }, new Response.ErrorListener() {
@Override
public void onErrorResponse(VolleyError error) {
        Toast.makeText(CravateEnfant.this, "Error", Toast.LENGTH_LONG).show();
        }
        });
        stringRequest3.setRetryPolicy(retryPolicy);

        RequestQueue requestQueue = Volley.newRequestQueue(CravateEnfant.this);
        requestQueue.add(stringRequest3);

        StringRequest stringRequest=new StringRequest(StringRequest.Method.GET, URL_DATA, new Response.Listener<String>() {
@Override
public void onResponse(String response) {

        JSONObject jsonObj = null;
        try {
        jsonObj = XML.toJSONObject(response);
final ArrayList<ProduitCravateEnfant> produits = new ArrayList<>();

        JSONArray image = new JSONArray(new JSONObject(new JSONObject(jsonObj.getJSONObject("prestashop").toString()).getJSONObject("images").toString()).getJSONArray("image").toString());
        for(int i=0; i<image.length(); i++){
        for (final ProduitCravateEnfant prd : listprod){
        if(String.valueOf(prd.getId()).equals(image.getJSONObject(i).getString("id").toString())){
final String urlalbum = image.getJSONObject(i).getString("xlink:href").toString();
        System.out.println(image.getJSONObject(i).getString("xlink:href"));

        StringRequest stringRequest2 =new StringRequest(StringRequest.Method.GET, urlalbum+WS_KEY, new Response.Listener<String>() {
@Override
public void onResponse(String response) {

        JSONObject jsonObj = null;
        try {
        jsonObj = XML.toJSONObject(response);

        Object image = new JSONObject(new JSONObject(jsonObj.getJSONObject("prestashop").toString()).getJSONObject("image").toString()).get("declination");

        if(image instanceof JSONArray){

        JSONArray imagesarray = new JSONArray( new JSONObject(new JSONObject(jsonObj.getJSONObject("prestashop").toString()).getJSONObject("image").toString()).getJSONArray("declination").toString());
        System.out.println("--------"+urlalbum.substring(urlalbum.length() - 2)+"----------"+imagesarray.getJSONObject(0).getString("xlink:href"));

        ProduitCravateEnfant prod = new ProduitCravateEnfant(prd.getId(), prd.getName(),prd.getPrice(), imagesarray.getJSONObject(0).getString("xlink:href")+WS_KEY);
        produits.add(prod);

        }else if (image instanceof JSONObject){

        JSONObject imageobj = new JSONObject(image.toString());
        System.out.println("--------"+urlalbum.substring(urlalbum.length() - 2)+"----------"+imageobj.getString("xlink:href"));

        ProduitCravateEnfant prod = new ProduitCravateEnfant(prd.getId(), prd.getName(), prd.getPrice(),imageobj.getString("xlink:href")+WS_KEY);
        produits.add(prod);
        }


        } catch (JSONException e) {
        Log.e("JSON exception", e.getMessage());
        e.printStackTrace();
        }

        adapter=new ProduitAdapterCravateEnfant(produits,CravateEnfant.this);
        recyclerView.setAdapter(adapter);
        }

        },new Response.ErrorListener() {
@Override
public void onErrorResponse(VolleyError error) {
        Toast.makeText(CravateEnfant.this, "Error", Toast.LENGTH_LONG).show();
        }
        });

        stringRequest2.setRetryPolicy(retryPolicy);

        RequestQueue requestQueue = Volley.newRequestQueue(CravateEnfant.this);
        requestQueue.add(stringRequest2);
        }
        }
        }
        } catch (JSONException e) {
        Log.e("JSON exception", e.getMessage());
        e.printStackTrace();
        }
        }
        }, new Response.ErrorListener() {
@Override
public void onErrorResponse(VolleyError error) {
        Toast.makeText(CravateEnfant.this, "Error", Toast.LENGTH_LONG).show();

        }
        });
        stringRequest.setRetryPolicy(retryPolicy);
        RequestQueue requestQueue2 = Volley.newRequestQueue(CravateEnfant.this);
        requestQueue2.add(stringRequest);




        btn_essayage = (Button) findViewById(R.id.btn_essayer);
        btn_essayage.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
        openActivity2();
        }
        });

        }
public void openActivity2()
        {
        Intent intent = new Intent(this, Miroir.class);
        startActivity(intent);
        }

@Override
public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
        drawer.closeDrawer(GravityCompat.START);
        } else {
        super.onBackPressed();
        }
        }



@Override
public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
        }

@SuppressWarnings("StatementWithEmptyBody")
@Override
public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

       /* if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
        }



        }