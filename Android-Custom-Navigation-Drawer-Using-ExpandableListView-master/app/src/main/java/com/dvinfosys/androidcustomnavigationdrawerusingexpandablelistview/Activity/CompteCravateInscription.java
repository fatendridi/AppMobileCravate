package com.dvinfosys.androidcustomnavigationdrawerusingexpandablelistview.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;

import com.dvinfosys.androidcustomnavigationdrawerusingexpandablelistview.Compte;
import com.dvinfosys.androidcustomnavigationdrawerusingexpandablelistview.Model.ChildModel;
import com.dvinfosys.androidcustomnavigationdrawerusingexpandablelistview.Model.HeaderModel;
import com.dvinfosys.androidcustomnavigationdrawerusingexpandablelistview.Notification;
import com.dvinfosys.androidcustomnavigationdrawerusingexpandablelistview.Panier;
import com.dvinfosys.androidcustomnavigationdrawerusingexpandablelistview.R;
import com.dvinfosys.androidcustomnavigationdrawerusingexpandablelistview.Utils.Common;
import com.dvinfosys.androidcustomnavigationdrawerusingexpandablelistview.View.ExpandableNavigationListView;

public class CompteCravateInscription extends AppCompatActivity

            implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;
    private ExpandableNavigationListView navigationExpandableListView;
    private Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comptecravate_inscription);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        getSupportActionBar().setIcon(R.drawable.logocravate);
        context = CompteCravateInscription.this;


        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_back:
                        break;
                    case R.id.navigation_usb:
                        Intent a = new Intent(CompteCravateInscription.this, Panier.class);
                        startActivity(a);
                        break;
                    case R.id.navigation_logo:
                        Intent b = new Intent(CompteCravateInscription.this, Compte.class);
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
                                .addChildModel(new ChildModel("Cravate Personnalisée"))

                )

                .addHeaderModel(new HeaderModel("chemise"))
                .addHeaderModel(
                        new HeaderModel("Ceinture", R.drawable.plus, true)
                                .addChildModel(new ChildModel("Ceinture Cuir"))
                                .addChildModel(new ChildModel("Ceinture Cuir de Djean"))

                )

                .addHeaderModel(new HeaderModel("Noeud Papillon"))
                .addHeaderModel(
                        new HeaderModel("Accessoires", R.drawable.plus, true)
                                .addChildModel(new ChildModel("Pochette"))
                                .addChildModel(new ChildModel("Porte Cartes"))
                                .addChildModel(new ChildModel("Porte Monnaie"))

                                .addChildModel(new ChildModel("Coffret Cadeau"))
                                .addChildModel(new ChildModel("Porte Chéquier"))


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


                            drawer.closeDrawer(GravityCompat.START);
                        } else if (id == 2) {


                        } else if (id == 3) {

                            Intent i1 = new Intent(CompteCravateInscription.this, NoeudPapillon.class);
                            startActivity(i1);


                        } else if (id == 4) {


                        } else if (id == 5) {


                        }
                        return false;
                    }
                })
                .addOnChildClickListener(new ExpandableListView.OnChildClickListener() {
                    @Override
                    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                        navigationExpandableListView.setSelected(groupPosition, childPosition);

                        if (groupPosition == 0) {


                            if (id == 0) {
                                Intent i = new Intent(CompteCravateInscription.this, CravateClassique.class);
                                startActivity(i);
                            } else if (id == 1) {
                                Common.showToast(context, "Cravate Slim");
                            } else if (id == 2) {
                                Common.showToast(context, "Cravate Large");
                            } else if (id == 3) {
                                Common.showToast(context, "Cravate Personnalisée");
                            }
                        } else if (groupPosition == 2) {
                            if (id == 0) {
                                Intent i2 = new Intent(CompteCravateInscription.this, CeintureCuir.class);
                                startActivity(i2);

                            } else if (id == 1) {
                                Common.showToast(context, "Ceinture Cuir de Djean");
                            }

                        } else if (groupPosition == 4) {
                            if (id == 0) {
                                Intent i3 = new Intent(CompteCravateInscription.this, Pochette.class);
                                startActivity(i3);
                            } else if (id == 1) {
                                Common.showToast(context, "Porte_Cartes");
                            } else if (id == 2) {
                                Common.showToast(context, "Porte_Monnaie");
                            } else if (id == 3) {
                                Common.showToast(context, "Coffret Cadeau");
                            } else {
                                Common.showToast(context, "Porte chéquiér");
                            }

                        } else if (groupPosition == 5) {
                            if (id == 0) {
                                Common.showToast(context, "Histoire de la Cravate");
                            } else if (id == 1) {
                                Common.showToast(context, "Nos Conseils");
                            } else if (id == 2) {
                                Common.showToast(context, "Comment Faire un Noeud de Cravate");
                            } else if (id == 3) {
                                Common.showToast(context, "Comment Choisir La Taille De Ceinture");
                            } else {
                                Common.showToast(context, "Comment Régler Votre Ceinture");
                            }

                        }

                        drawer.closeDrawer(GravityCompat.START);
                        return false;
                    }
                });
        //navigationExpandableListView.expandGroup(2);

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