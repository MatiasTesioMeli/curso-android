package com.example.mtesio.firstproject.conversor;

public class ConversorPresenter {

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
            view.showError("Ingresa un valor ameo");
        }
    }

    public void convertirMillasAKm(){
        if (view != null && isInputOK(view.getTextFromInput())) {
            conversor.convertir();
            view.setCantidadDeKm(conversor.getKilometros());
        } else {
            view.showError("Ingresa un valor ameo");
        }
    }

    public boolean isInputOK(String input){
        return !(input.isEmpty() ||  Double.parseDouble(input) < 0 );
    }
}
