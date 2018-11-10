package com.controller;

import com.modelo.Articulo;
import com.facade.ArticuloFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "articuloController")
@ViewScoped
public class ArticuloController extends AbstractController<Articulo> {

    @Inject
    private TipoarticuloController idtipoarticuloController;

    public ArticuloController() {
        // Inform the Abstract parent controller of the concrete Articulo Entity
        super(Articulo.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idtipoarticuloController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Tipoarticulo controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdtipoarticulo(ActionEvent event) {
        Articulo selected = this.getSelected();
        if (selected != null && idtipoarticuloController.getSelected() == null) {
            idtipoarticuloController.setSelected(selected.getIdtipoarticulo());
        }
    }

}
