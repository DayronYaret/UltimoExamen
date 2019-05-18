package es.ulpgc.dayron.ultimoexamen.app;

public class CountItem {
  private int count;
  private int id;

  public CountItem(int count, int id){
    this.count=count;
    this.id=id;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public int getId(){
    return id;
  }
}
