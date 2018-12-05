package com.example.mtesio.firstproject;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mtesio.firstproject.model.Conversor;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText textInput;
    private Button buttonConverter;
    private TextView cantidadDeKm;
    private Conversor conversor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonConverter = (Button) findViewById(R.id.convertir_button);
        textInput = (TextInputEditText) findViewById(R.id.millas_input);
        cantidadDeKm = (TextView) findViewById(R.id.result_number_text_view);
        conversor = new Conversor();

        buttonConverter.setOnClickListener(buttonListener);
        textInput.addTextChangedListener(inputTextWatcher);

    }

    private TextWatcher inputTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if(!textInput.getText().toString().isEmpty() &&  Double.parseDouble(textInput.getText().toString()) > 0 ){
                conversor.setMillas(Double.parseDouble(textInput.getText().toString()));
            }else{
                Toast.makeText(MainActivity.this, "Ingresa un valor ameo",
                        Toast.LENGTH_LONG).show();
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(!textInput.getText().toString().isEmpty() &&  Double.parseDouble(textInput.getText().toString()) > 0 ){
                conversor.convertir();
                cantidadDeKm.setText(Double.toString(conversor.getKilometros()));
            }else{
                Toast.makeText(v.getContext(), "Ingresa un valor ameo",
                        Toast.LENGTH_LONG).show();
            }
        }
    };
}
