package com.controller;

import com.modelo.Tipoarticulo;
import com.modelo.Articulo;
import java.util.Collection;
import com.facade.TipoarticuloFacade;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tipoarticuloController")
@ViewScoped
public class TipoarticuloController extends AbstractController<Tipoarticulo> {

    // Flags to indicate if child collections are empty
    private boolean isArticuloCollectionEmpty;

    public TipoarticuloController() {
        // Inform the Abstract parent controller of the concrete Tipoarticulo Entity
        super(Tipoarticulo.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsArticuloCollectionEmpty();
    }

    public boolean getIsArticuloCollectionEmpty() {
        return this.isArticuloCollectionEmpty;
    }

    private void setIsArticuloCollectionEmpty() {
        Tipoarticulo selected = this.getSelected();
        if (selected != null) {
            TipoarticuloFacade ejbFacade = (TipoarticuloFacade) this.getFacade();
            this.isArticuloCollectionEmpty = ejbFacade.isArticuloCollectionEmpty(selected);
        } else {
            this.isArticuloCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Articulo entities that
     * are retrieved from Tipoarticulo and returns the navigation outcome.
     *
     * @return navigation outcome for Articulo page
     */
    public String navigateArticuloCollection() {
        Tipoarticulo selected = this.getSelected();
        if (selected != null) {
            TipoarticuloFacade ejbFacade = (TipoarticuloFacade) this.getFacade();
            Collection<Articulo> selectedArticuloCollection = ejbFacade.findArticuloCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Articulo_items", selectedArticuloCollection);
        }
        return "/app/articulo/index";
    }

}
