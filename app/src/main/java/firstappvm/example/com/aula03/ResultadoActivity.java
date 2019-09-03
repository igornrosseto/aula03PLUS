package firstappvm.example.com.aula03;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class ResultadoActivity extends AppCompatActivity {

    Switch bgTemaTela2;
    Button btVoltar;
    TextView saida;
    ConstraintLayout constraintLayoutTela2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        constraintLayoutTela2 = findViewById(R.id.cl2);
        bgTemaTela2 = findViewById(R.id.switchBG2);
        btVoltar = findViewById(R.id.buttonVoltar);
        saida = findViewById(R.id.txtsaida);
        Intent it = getIntent();
        Bundle dados = it.getExtras();

        saida.setText("Nome: " + dados.getString("nome") +  " " + dados.getString("sobrenome"));

        bgTemaTela2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (bgTemaTela2.isChecked()){
                    constraintLayoutTela2.setBackgroundResource(R.drawable.art1);
                }
                else{
                    constraintLayoutTela2.setBackgroundResource(R.drawable.art3);
                }
            }
        });


        btVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });



















    }

}

