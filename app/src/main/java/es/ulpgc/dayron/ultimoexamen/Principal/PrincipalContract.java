package es.ulpgc.dayron.ultimoexamen.Principal;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.dayron.ultimoexamen.app.CountItem;

interface PrincipalContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(PrincipalViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void add();

    void selectItemListData(CountItem item);
  }

  interface Model {
    String fetchData();

    void add();

    List<CountItem> getItem();
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(CountItem item);

    PrincipalState getDataFromPreviousScreen();
  }
}
