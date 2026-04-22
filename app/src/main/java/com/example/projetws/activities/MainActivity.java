package com.example.projetws.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.example.projetws.R;
import com.example.projetws.adapters.EtudiantAdapter;
import com.example.projetws.models.Etudiant;
import com.example.projetws.network.VolleySingleton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EtudiantAdapter adapter;
    private List<Etudiant> etudiantList;
    private Button btnAdd;

    private static final String URL_LOAD = "http://10.0.2.2/projet/ws/loadEtudiant.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        btnAdd = findViewById(R.id.btnAdd);

        etudiantList = new ArrayList<>();
        adapter = new EtudiantAdapter(etudiantList);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        btnAdd.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddEtudiantActivity.class);
            startActivity(intent);
        });

        chargerEtudiants();
    }

    // Recharger la liste à chaque retour sur MainActivity
    @Override
    protected void onResume() {
        super.onResume();
        chargerEtudiants();
    }

    private void chargerEtudiants() {
        StringRequest request = new StringRequest(
                Request.Method.GET,
                URL_LOAD,
                response -> {
                    try {
                        Gson gson = new Gson();
                        Type listType = new TypeToken<List<Etudiant>>(){}.getType();
                        List<Etudiant> liste = gson.fromJson(response, listType);

                        etudiantList.clear();
                        etudiantList.addAll(liste);
                        adapter.notifyDataSetChanged();

                    } catch (Exception e) {
                        Toast.makeText(this, "Erreur parsing JSON : " + e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                },
                error -> {
                    Toast.makeText(this, "Erreur réseau : " + error.getMessage(), Toast.LENGTH_LONG).show();
                }
        );

        VolleySingleton.getInstance(this).addToRequestQueue(request);
    }
}