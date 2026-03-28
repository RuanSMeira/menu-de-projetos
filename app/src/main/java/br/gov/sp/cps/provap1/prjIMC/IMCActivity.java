package br.gov.sp.cps.provap1.prjIMC;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.gov.sp.cps.provap1.R;

public class IMCActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_imc);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btnCalcular = findViewById(R.id.btnCalcularImc);
        Button btnLimpar = findViewById(R.id.btnLimparCampos);
        Button btnVoltar = findViewById(R.id.btnVoltarMenuPrincipal);
        EditText nomePessoa = findViewById(R.id.editNomePessoa);
        EditText numAltura = findViewById(R.id.editAltura);
        EditText numPeso = findViewById(R.id.editPeso);
        TextView txtImc = findViewById(R.id.txtTituloImc);

        btnCalcular.setOnClickListener(v -> {

            String strPeso = numPeso.getText().toString().trim().replace(",", ".");
            String strAltura = numAltura.getText().toString().trim().replace(",", ".");
            String nomeDigitado = nomePessoa.getText().toString().trim();


            if (strPeso.isEmpty() || strAltura.isEmpty() || nomeDigitado.isEmpty()) {
                txtImc.setText("Preencha todos os campos!");
                txtImc.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark));
                return;
            }

            try {

                double pesoDigitado = Double.parseDouble(strPeso);
                double alturaDigitada = Double.parseDouble(strAltura);
                double imcGerado = pesoDigitado / (alturaDigitada * alturaDigitada);


                int layoutId;
                if (imcGerado < 18.5) {
                    layoutId = R.layout.activity_resultado_imc1;
                    } else if (imcGerado < 25) {
                    layoutId = R.layout.activity_resultado_imc2;
                } else if (imcGerado < 30) {
                    layoutId = R.layout.activity_resultado_imc3;
                } else if (imcGerado < 35) {
                    layoutId = R.layout.activity_resultado_imc4;
                } else if (imcGerado < 40) {
                    layoutId = R.layout.activity_resultado_imc5;
                } else {
                    layoutId = R.layout.activity_resultado_imc6;
                }


                Intent intent = new Intent(this, ResultadoImcActivity.class);
                intent.putExtra("layout_escolhido", layoutId);
                intent.putExtra("nome", nomeDigitado);
                intent.putExtra("peso", pesoDigitado);
                intent.putExtra("altura", alturaDigitada);
                intent.putExtra("imc", imcGerado);

                startActivity(intent);

            } catch (NumberFormatException e) {
                txtImc.setText("Erro nos números digitados!");
                e.printStackTrace();
            }
        });

        btnLimpar.setOnClickListener(v -> {
            nomePessoa.setText("");
            numPeso.setText("");
            numAltura.setText("");
            txtImc.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark));
            txtImc.setText("Digite seu IMC !!");
            nomePessoa.requestFocus();
        });

        btnVoltar.setOnClickListener(v -> {
            finish();
        });
    }

}