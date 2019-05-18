package es.ulpgc.dayron.ultimoexamen.Secundario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import es.ulpgc.dayron.ultimoexamen.R;

public class SecundarioActivity
    extends AppCompatActivity implements SecundarioContract.View {

  public static String TAG = SecundarioActivity.class.getSimpleName();

  private SecundarioContract.Presenter presenter;
  Button addButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_secundario);
    addButton=findViewById(R.id.increaseButton);
    addButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        presenter.increase();
      }
    });


    // do the setup
    SecundarioScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.fetchData();
  }

  @Override
  public void injectPresenter(SecundarioContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(SecundarioViewModel viewModel) {
    //Log.e(TAG, "displayData()");
    // deal with the data
    ((TextView) findViewById(R.id.counterTextView)).setText(Integer.toString(viewModel.item.getCount()));
    ((TextView) findViewById(R.id.clickTextView)).setText(Integer.toString(viewModel.clicks));

  }
}
