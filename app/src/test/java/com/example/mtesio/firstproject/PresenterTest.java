package com.example.mtesio.firstproject;

import com.example.mtesio.firstproject.conversor.Conversor;
import com.example.mtesio.firstproject.conversor.ConversorPresenter;
import com.example.mtesio.firstproject.conversor.ConversorView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PresenterTest {

    @Mock
    ConversorView view;
    @Mock
    Conversor conversor;

    private ConversorPresenter presenter;

    @Before
    public void setUp() throws Exception {
        presenter = new ConversorPresenter(view, conversor);
    }

    @Test
    public void checkIfViewIsReleasedOnDestroy() {
        presenter.onDestroy();
        assertNull(presenter.getView());
    }

    @Test
    public void isInputOKeturnsShouldReturnFalseWithNull() {
        assertFalse(presenter.isInputOK(null));
    }

    @Test
    public void isInputOKeturnsShouldReturnFalseWithEmptyString() {
        assertFalse(presenter.isInputOK(""));
    }

    @Test
    public void isInputOKeturnsShouldReturnFalseWithNegativeValue() {
        assertFalse(presenter.isInputOK("-3"));
    }

    @Test
    public void isInputOKeturnsShouldReturnTrueWithCeroValue() {
        assertTrue(presenter.isInputOK("0"));
    }

    @Test
    public void setMillasInModelShouldExecuteSetMillasOnce() {
        when(view.getTextFromInput()).thenReturn("10");
        presenter.setMillasInModel(10);
        verify(conversor, times(1)).setMillas(10);
    }

    @Test
    public void convertirMillasAKmShouldExecuteConvertir() {
        when(view.getTextFromInput()).thenReturn("10");
        presenter.convertirMillasAKm();
        verify(conversor, times(1)).convertir();
    }

    @Test
    public void convertirMillasAKmShouldExecuteSetCantidadDeKm() {
        when(view.getTextFromInput()).thenReturn("10");
        when(conversor.getKilometros()).thenReturn(10.00);

        presenter.convertirMillasAKm();
        verify(view, times(1)).setCantidadDeKm(10.00);
    }

    @Test
    public void setMillasInModelShouldExecuteSendError() {
        when(view.getTextFromInput()).thenReturn("-10");
        presenter.setMillasInModel(10);
        verify(view, times(1)).showError("Ingresa un valor ameo");
    }

    @Test
    public void convertirMillasAKmShouldExecuteShowError() {
        when(view.getTextFromInput()).thenReturn("-10");
        presenter.convertirMillasAKm();
        verify(view, times(1)).showError("Ingresa un valor ameo");
    }

}
