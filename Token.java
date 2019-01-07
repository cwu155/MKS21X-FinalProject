public class Token{
  private String token;
  private int priority;

  public Token(String value, int importance){
    token = value;
    priority = importance;
  }

  public String getString(){
    return token;
  }

  public int getPriority(){
    return priority;
  }

  public void setPriority(int other){
    priority = other;
  }
}
