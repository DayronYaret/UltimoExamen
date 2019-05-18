package es.ulpgc.dayron.ultimoexamen.Secundario;

import java.lang.ref.WeakReference;

import es.ulpgc.dayron.ultimoexamen.app.CountItem;

interface SecundarioContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(SecundarioViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void increase();
  }

  interface Model {
    String fetchData();

    void increase(int id);

    int getClicks();

    CountItem getItemSingular(int id);
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(SecundarioState state);

    CountItem getDataFromPreviousScreen();
  }
}
