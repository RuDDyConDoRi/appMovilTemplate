package com.ctr.template;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txtPrueba)
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        title.setText("agregando");
    }

    @OnClick(R.id.txtPrueba)
    public void mostrarMensaje() {
        Toast.makeText(MainActivity.this, "Mostrando", Toast.LENGTH_SHORT).show();
    }

}
