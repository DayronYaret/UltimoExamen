package es.ulpgc.dayron.ultimoexamen.Principal;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.dayron.ultimoexamen.Secundario.SecundarioActivity;
import es.ulpgc.dayron.ultimoexamen.app.AppMediator;
import es.ulpgc.dayron.ultimoexamen.app.CountItem;

public class PrincipalRouter implements PrincipalContract.Router {

  public static String TAG = PrincipalRouter.class.getSimpleName();

  private AppMediator mediator;

  public PrincipalRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, SecundarioActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(CountItem item) {
    mediator.setItem(item);
  }

  @Override
  public PrincipalState getDataFromPreviousScreen() {
    PrincipalState state = mediator.getPrincipalState();
    return state;
  }
}
