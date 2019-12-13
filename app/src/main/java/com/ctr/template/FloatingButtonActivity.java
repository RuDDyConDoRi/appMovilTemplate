package com.ctr.template;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.animation.Animator;
import android.widget.ListView;
import android.widget.TextView;

import com.ctr.template.utils.BlockUI;

import java.util.ArrayList;

import ch.halcyon.squareprogressbar.SquareProgressBar;

//import dodola.blockindigo.BlockIndigo;

public class FloatingButtonActivity extends AppCompatActivity {

    FloatingActionButton fab, fab1, fab2, fab3;
    LinearLayout fabLayout1, fabLayout2, fabLayout3;
    View fabBGLayout;
    boolean isFABOpen = false;

    ListView listaDeFragments;

    String[] language ={"C","C++","Java",".NET","iPhone","Android","ASP.NET","PHP"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floating_button);
       // BlockIndigo.get().start(this);

        final BlockUI load = new BlockUI(this);
        load.esperar();

        /*
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Load...");
        builder.setIcon(R.drawable.osm_ic_follow_me_on);
        builder.setCancelable(false);

        AlertDialog alertdialog = builder.create();
        alertdialog.show();*/

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        load.finalizar();
                    }
                },
                5000);


        SquareProgressBar squareProgressBar = findViewById(R.id.sprogressbar);
        squareProgressBar.setImage(R.drawable.et_logo_invert);
        squareProgressBar.setProgress(45.0);
        squareProgressBar.setIndeterminate(true);
        squareProgressBar.showProgress(true);
        squareProgressBar.setOpacity(true);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        fabLayout1 = (LinearLayout) findViewById(R.id.fabLayout1);
        fabLayout2 = (LinearLayout) findViewById(R.id.fabLayout2);
        fabLayout3 = (LinearLayout) findViewById(R.id.fabLayout3);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        fab3 = (FloatingActionButton) findViewById(R.id.fab3);
        fabBGLayout = findViewById(R.id.fabBGLayout);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isFABOpen) {
                    showFABMenu();
                } else {
                    closeFABMenu();
                }
            }
        });

        fabBGLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeFABMenu();
            }
        });

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.select_dialog_item,language);
        //Getting the instance of AutoCompleteTextView
        AutoCompleteTextView actv =  (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        actv.setThreshold(1);//will start working from first character
        actv.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView
        actv.setTextColor(Color.RED);


        llenarListaConFragmentos();


    }

    void llenarListaConFragmentos() {
        ////////////////////////////////////////////////
        //listaDeFragments = findViewById(R.id.listaDeFragments);

        listaDeFragments = findViewById(R.id.listaDeFragments);
        final ArrayList<StructNote> notesPage = new ArrayList<StructNote>();
        notesPage.add(new StructNote(
                1000, "s10000", "T10000", "OD100000"
        ));
        notesPage.add(new StructNote(
                2000, "s200000", "T20000", "OD2001"
        ));

        notesPage.add(new StructNote(
                165465, "sadsdasd1", "Tasdasdasd1", "OD1asdasdasdqwe"
        ));

        listaDeFragments = (ListView) findViewById(R.id.listaDeFragments);
        AdapterNote adapter2 = new AdapterNote(getApplicationContext(), notesPage);
        /*LayoutInflater inflater = getLayoutInflater();

        for (int i = 0; i < 5; i++) {
            View addNew = inflater.inflate(R.layout.elemento_lista_ejemplo, listaDeFragments, false);
            listaDeFragments.addHeaderView(addNew, null, false);
        }*/

        listaDeFragments.setAdapter(adapter2);
        adapter2.notifyDataSetChanged();
    }

    private void showFABMenu() {
        isFABOpen = true;
        fabLayout1.setVisibility(View.VISIBLE);
        fabLayout2.setVisibility(View.VISIBLE);
        fabLayout3.setVisibility(View.VISIBLE);
        fabBGLayout.setVisibility(View.VISIBLE);
        fab.animate().rotationBy(180);
        fabLayout1.animate().translationY(-getResources().getDimension(R.dimen.standard_55));
        fabLayout2.animate().translationY(-getResources().getDimension(R.dimen.standard_100));
        fabLayout3.animate().translationY(-getResources().getDimension(R.dimen.standard_145));
    }

    private void closeFABMenu() {
        isFABOpen = false;
        fabBGLayout.setVisibility(View.GONE);
        fab.animate().rotation(0);
        fabLayout1.animate().translationY(0);
        fabLayout2.animate().translationY(0);
        fabLayout3.animate().translationY(0);
        fabLayout3.animate().translationY(0).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animator) {

            }

            @Override
            public void onAnimationEnd(Animator animator) {
                if (!isFABOpen) {
                    fabLayout1.setVisibility(View.GONE);
                    fabLayout2.setVisibility(View.GONE);
                    fabLayout3.setVisibility(View.GONE);
                }
/*                if (fab.getRotation() != -180) {
                    fab.setRotation(-180);
                }*/
            }

            @Override
            public void onAnimationCancel(Animator animator) {

            }

            @Override
            public void onAnimationRepeat(Animator animator) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        if (isFABOpen) {
            closeFABMenu();
        } else {
            super.onBackPressed();
        }
    }

    public void llamarMapa(View view) {
        Context context = getApplicationContext();
        Intent mapa = new Intent(context,ScrollingActivity.class);
        mapa.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(mapa);
    }

    public void llamar(View view) {
        Context context = getApplicationContext();
        Intent mapa = new Intent(context,WizardActivity.class);
        mapa.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(mapa);
    }

    public void llamarNotificacion(View view) {
        Context context = getApplicationContext();
        Intent notification = new Intent(context,NotificationActivity.class);
        notification.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(notification);
    }

    public void mostrarModal(View view) {
        //Context context = getApplicationContext();
        AlertDialog.Builder preguntaBuilderDialog = new AlertDialog.Builder(
                this,
                R.style.ThemeDialogAgc);

        preguntaBuilderDialog = new AlertDialog.Builder(
                this,
                R.style.ThemeDialogAgc);

        final View customLayout = getLayoutInflater().inflate(
                R.layout.formulario_modal_layout,
                null);

        preguntaBuilderDialog.setView(customLayout);
        final CardView panel001 = customLayout.findViewById(R.id.panel001);
        final CardView panel002 = customLayout.findViewById(R.id.panel002);
        panel002.setVisibility(View.GONE);
        /*
        final TextView sector = customLayout
                .findViewById(R.id.input_ayudante_sector);
        */

        Button btnQuitar = customLayout.findViewById(R.id.btnQuitar);
        btnQuitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("TEST", "paso");
                panel001.setVisibility(View.GONE);
                panel002.setVisibility(View.VISIBLE);
            }
        });
        Button btnMostrar = customLayout.findViewById(R.id.btnMostrar);
        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                panel001.setVisibility(View.VISIBLE);
                panel002.setVisibility(View.GONE);
            }
        });


        preguntaBuilderDialog
                .setTitle("Registro Ayudante")
                .setCancelable(false);
                /*.setPositiveButton("Guardar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        / *
                        // send data from the AlertDialog to the Activity
                        EditText nombreAyudante = customLayout
                                .findViewById(R.id.input_ayudante);
                        //sendDialogDataToActivity(editText.getText().toString());
                        EditText apellidoAyudante = customLayout
                                .findViewById(R.id.input_apellido);
                        registrarAyudante(nombreAyudante, apellidoAyudante);
                        * /
                        / *Toast.makeText(
                                getApplicationContext(),
                                "",
                                Toast.LENGTH_SHORT
                        ).show();* /
                    }
                }).setNegativeButton(
                    "Cancelar",
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    }
                );*/
        AlertDialog formuolarioAyudante = preguntaBuilderDialog.create();
        //Setting the title manually
        //ayudanteAlerta.setTitle("Agregar ayudante");
        formuolarioAyudante.show();


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //BlockIndigo.get().stop();
    }

}
