package es.ulpgc.dayron.ultimoexamen.app;

import android.app.Application;

import es.ulpgc.dayron.ultimoexamen.Principal.PrincipalState;
import es.ulpgc.dayron.ultimoexamen.Secundario.SecundarioState;

public class AppMediator extends Application {
  private PrincipalState principalState;
  private SecundarioState secundarioState;
  private CountItem item;

  public AppMediator(){
    principalState= new PrincipalState();
    secundarioState = new SecundarioState();
  }

  public PrincipalState getPrincipalState() {
    return principalState;
  }

  public void setPrincipalState(PrincipalState principalState) {
    this.principalState = principalState;
  }

  public SecundarioState getSecundarioState() {
    return secundarioState;
  }

  public void setSecundarioState(SecundarioState secundarioState) {
    this.secundarioState = secundarioState;
  }

  public CountItem getItem() {
    return item;
  }

  public void setItem(CountItem item) {
    this.item = item;
  }
}
