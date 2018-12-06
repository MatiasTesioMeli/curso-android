package com.example.mtesio.firstproject.conversor;

public class ConversorPresenter {

    private final String ERROR_MESSAGE = "Ingresa un valor ameo";

    private ConversorView view;
    private Conversor conversor;

    public ConversorPresenter(ConversorView view, Conversor conversor) {
        this.view = view;
        this.conversor = conversor;
    }

    public void onDestroy() {
        view = null;
    }

    public void setMillasInModel(double millas) {
        if (view != null && isInputOK(view.getTextFromInput())) {
            conversor.setMillas(millas);
        } else {
            view.showError(ERROR_MESSAGE);
        }
    }

    public void convertirMillasAKm(){
        if (view != null && isInputOK(view.getTextFromInput())) {
            conversor.convertir();
            view.setCantidadDeKm(conversor.getKilometros());
        } else {
            view.showError(ERROR_MESSAGE);
        }
    }

    public ConversorView getView() {
        return view;
    }

    public boolean isInputOK(String input){
        return !( input == null || input.isEmpty() ||  Double.parseDouble(input) < 0 );
    }
}
