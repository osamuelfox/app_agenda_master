package dev.samuel.teste.agenda.view.principal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import dev.samuel.teste.agenda.R;
import dev.samuel.teste.agenda.controller.EventoDAO;

public class Mes_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mes);

        Button novoEvento = findViewById(R.id.bt_CriarEvento);

        novoEvento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Mes_Activity.this,
                        EventActivity.class));
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        EventoDAO dao = new EventoDAO();

        ListView listaEventos = findViewById(R.id.lista);

        listaEventos.setAdapter(new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, dao.todos()

        ));
    }
}