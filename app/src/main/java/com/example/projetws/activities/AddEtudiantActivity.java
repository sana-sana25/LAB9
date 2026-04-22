package com.example.projetws.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.toolbox.StringRequest;
import com.example.projetws.R;
import com.example.projetws.network.VolleySingleton;
import java.util.HashMap;
import java.util.Map;

public class AddEtudiantActivity extends AppCompatActivity {

    private EditText etNom, etPrenom, etVille, etSexe;
    private Button btnAjouter;

    private static final String URL_ADD = "http://10.0.2.2/projet/ws/createEtudiant.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_etudiant);

        etNom    = findViewById(R.id.etNom);
        etPrenom = findViewById(R.id.etPrenom);
        etVille  = findViewById(R.id.etVille);
        etSexe   = findViewById(R.id.etSexe);
        btnAjouter = findViewById(R.id.btnAjouter);

        btnAjouter.setOnClickListener(v -> ajouterEtudiant());
    }

    private void ajouterEtudiant() {
        String nom    = etNom.getText().toString().trim();
        String prenom = etPrenom.getText().toString().trim();
        String ville  = etVille.getText().toString().trim();
        String sexe   = etSexe.getText().toString().trim();

        // Validation
        if (nom.isEmpty() || prenom.isEmpty() || ville.isEmpty() || sexe.isEmpty()) {
            Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
            return;
        }

        StringRequest request = new StringRequest(
                Request.Method.POST,
                URL_ADD,
                response -> {
                    Toast.makeText(this, "Étudiant ajouté avec succès", Toast.LENGTH_SHORT).show();
                    finish(); // Retour à MainActivity
                },
                error -> {
                    Toast.makeText(this, "Erreur : " + error.getMessage(), Toast.LENGTH_LONG).show();
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("nom", nom);
                params.put("prenom", prenom);
                params.put("ville", ville);
                params.put("sexe", sexe);
                return params;
            }
        };

        VolleySingleton.getInstance(this).addToRequestQueue(request);
    }
}