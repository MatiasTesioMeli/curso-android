package com.example.mtesio.firstproject.conversor;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mtesio.firstproject.R;

public class ConversorActivity extends AppCompatActivity implements ConversorView{

    private TextInputEditText textInput;
    private Button buttonConverter;
    private TextView cantidadDeKm;
    private ConversorPresenter conversorPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonConverter = findViewById(R.id.convertir_button);
        textInput = findViewById(R.id.millas_input);
        cantidadDeKm = findViewById(R.id.result_number_text_view);

        conversorPresenter = new ConversorPresenter(this, new Conversor());

        buttonConverter.setOnClickListener(buttonListener);
        textInput.addTextChangedListener(inputTextWatcher);

    }

    @Override
    protected void onDestroy() {
        conversorPresenter.onDestroy();
        super.onDestroy();
    }

    private TextWatcher inputTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if(conversorPresenter.isInputOK(textInput.getText().toString()))
                conversorPresenter.setMillasInModel(Double.parseDouble(textInput.getText().toString()));
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private View.OnClickListener buttonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            conversorPresenter.convertirMillasAKm();
        }
    };

    @Override
    public void setCantidadDeKm(double km) {
        cantidadDeKm.setText(Double.toString(km));

    }

    @Override
    public String getTextFromInput (){
        return textInput.getText().toString();
    }

    @Override
    public void showError(String message){
        Toast.makeText(this, message,
                Toast.LENGTH_LONG).show();
    }
}
