/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gov.to.secad.jmoe.sauron.view.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.DashboardReorderEvent;
import org.primefaces.model.DashboardColumn;
import org.primefaces.model.DashboardModel;
import org.primefaces.model.DefaultDashboardColumn;
import org.primefaces.model.DefaultDashboardModel;

/**
 *
 * @author SKYNET
 */
@ManagedBean
@ViewScoped
public class ViewController implements Serializable {
    private DashboardModel model;  
     public ViewController() {  
        model = new DefaultDashboardModel();  
        DashboardColumn column1 = new DefaultDashboardColumn();  
        DashboardColumn column2 = new DefaultDashboardColumn();  
          
        column1.addWidget("detalhes");  
        column1.addWidget("");  
          
        column2.addWidget("documentos");  
        column2.addWidget("");  
       
        model.addColumn(column1);  
        model.addColumn(column2);  
       
    }  
      
    public void handleReorder(DashboardReorderEvent event) {  
        FacesMessage message = new FacesMessage();  
        message.setSeverity(FacesMessage.SEVERITY_INFO);  
        message.setSummary("Reordenando: " + event.getWidgetId());  
        message.setDetail("Item Inicial: " + event.getItemIndex() + ", Column index: " + event.getColumnIndex() + ", Sender index: " + event.getSenderColumnIndex());  
          
        addMessage(message);  
    }  
      
      
    private void addMessage(FacesMessage message) {  
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }  
      
    public DashboardModel getModel() {  
        return model;  
    }  
}
