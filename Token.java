public class Token{
  private String token;
  private int priority;

  public Token(String Token, int Priority){
    Token = token;
    Priority = priority;
  }

  public String getString(){
    return token;
  }

  public int getPriority(){
    return priority;
  }
}
