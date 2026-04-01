package br.gov.sp.cps.provap1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class JokenpoActivity extends AppCompatActivity {

    int qtdRodadas = 5;
    int rodadaAtual = 0;
    int meuPlacar = 0;
    int placarPc = 0;

    TextView textResultado;
    TextView txtPlacar;
    ImageView imgResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_jokenpo);

        textResultado = findViewById(R.id.textResultado);
        txtPlacar = findViewById(R.id.txtPlacar);
        imgResultado = findViewById(R.id.imgResultado);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btnVoltarMenuPrincipal = findViewById(R.id.btnVoltarMenuPrincipal);
        btnVoltarMenuPrincipal.setOnClickListener(v -> {
            finish();
        });
    }

    // Selecionado Pedra
    public void selecPedra(View view){
        opcaoSelecionada("pedra");
    }

    // Selecionado Papel
    public void selecPapel(View view){
        opcaoSelecionada("papel");
    }

    // Selecionado Tesoura
    public void selecTesoura(View view){
        opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String opcaoSelecionada) {

        if (rodadaAtual >= qtdRodadas) {
            finalizarJogo();
            return;
        }

        int numero = new Random().nextInt(3);
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoPC = opcoes[numero];

        switch (opcaoPC) {
            case "pedra":
                imgResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imgResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imgResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        imgResultado.setAlpha(0f);
        imgResultado.animate()
                .alpha(1f)
                .setDuration(500)
                .start();

        if (
                (opcaoPC.equals("tesoura") && opcaoSelecionada.equals("papel")) ||
                        (opcaoPC.equals("papel") && opcaoSelecionada.equals("pedra")) ||
                        (opcaoPC.equals("pedra") && opcaoSelecionada.equals("tesoura"))
        ) {

            textResultado.setText("Pc win - Perdeu mané!");
            placarPc++;

        } else if (
                (opcaoSelecionada.equals("tesoura") && opcaoPC.equals("papel")) ||
                        (opcaoSelecionada.equals("papel") && opcaoPC.equals("pedra")) ||
                        (opcaoSelecionada.equals("pedra") && opcaoPC.equals("tesoura"))
        ) {

            textResultado.setText("Pc Perdeu - Boa!");
            meuPlacar++;

        } else {
            textResultado.setText("Empatou!");
        }

        rodadaAtual++;

        txtPlacar.setText("EU " + meuPlacar + " X "  + placarPc + " PC: " );

        if (rodadaAtual == qtdRodadas) {
            finalizarJogo();
        }
    }

    public void finalizarJogo() {

        String resultadoFinal;

        if (meuPlacar > placarPc) {
            resultadoFinal = "VOCÊ É O CAMPEÃO!";
        } else if (placarPc > meuPlacar) {
            resultadoFinal = "O PC VENCEU O CONFRONTO!";
        } else {
            resultadoFinal = "O CONFRONTO EMPATOU!";
        }

        textResultado.setText(resultadoFinal);
    }

    public void reiniciarJogo(View view){

        rodadaAtual = 0;
        meuPlacar = 0;
        placarPc = 0;

        textResultado.setText("Escolha sua opção:");
        txtPlacar.setText("EU 0 X 0 PC");

        imgResultado.setImageResource(R.drawable.padrao);
    }
}