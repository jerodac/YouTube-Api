package br.com.jerodac.controllers;

import br.com.jerodac.model.ModelPresenter;

/**
 * @author Jean Rodrigo Dalbon Cunha on 02/03/17.
 */
public class MainController {

    private ModelPresenter modelPresenter;
    private static MainController mainController;

    public MainController getInstance() {
        if (mainController == null) {
            mainController = new MainController();
        }
        return mainController;
    }

    private MainController() {
        modelPresenter = new ModelPresenter();
    }
    

}
