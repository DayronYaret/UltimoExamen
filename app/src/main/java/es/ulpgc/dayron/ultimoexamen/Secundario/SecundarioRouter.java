package es.ulpgc.dayron.ultimoexamen.Secundario;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.dayron.ultimoexamen.app.AppMediator;
import es.ulpgc.dayron.ultimoexamen.app.CountItem;

public class SecundarioRouter implements SecundarioContract.Router {

  public static String TAG = SecundarioRouter.class.getSimpleName();

  private AppMediator mediator;

  public SecundarioRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, SecundarioActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(SecundarioState state) {
    mediator.setSecundarioState(state);
  }

  @Override
  public CountItem getDataFromPreviousScreen() {
    CountItem item = mediator.getItem();
    return item;
  }
}
