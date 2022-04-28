package example;
public class TicTacToe{
  String boardstate; //global declaration
  // creating constructor
  TicTacToe(String boardstate) {
    this.boardstate = boardstate.toLowerCase();

  }
  public Evaluation evaluateBoard() {
    //if condition to check is valid as the board should only be a string of length 9
    if(boardstate.length()!=9){
      return Evaluation.InvalidInput;
    }
    //checking the number of x and o
    int countx=0;
    int counto=0;
    for(int i=0;i<boardstate.length();i++)
    {
      if(boardstate.charAt(i)=='x') {
        countx++;
      }
      if(boardstate.charAt(i) =='o'){
        counto++;

      }
    }
    //condition for unreachable state that the difference between x and o cannot be greater than 1
    if(Math.abs(countx -counto) >=2){
      return Evaluation.UnreachableState;
    }
    //function call to get boolean output
    boolean xwins = winCondition('x',boardstate);
    boolean owins = winCondition('o',boardstate);
    if((xwins)&& (owins)){
      return Evaluation.UnreachableState;
    }
    if(xwins) {
      return Evaluation.Xwins;
    }
    else if(owins){
      return Evaluation.Owins;
    }
    else{
      return Evaluation.NoWinner;
    }
  }
  //function to check 8 possiblities
  public static boolean winCondition(char checker, String boardState)
  {
    if((boardState.charAt(0)==checker) && (boardState.charAt(1)==checker) && (boardState.charAt(2)==checker)) {
      return (true);
    }
    if((boardState.charAt(3)==checker) && (boardState.charAt(4)==checker) && (boardState.charAt(5)==checker)) {
      return (true);
    }
    if((boardState.charAt(6)==checker) && (boardState.charAt(7)==checker) && (boardState.charAt(8)==checker)){
      return (true);
    }
    if((boardState.charAt(0)==checker) && (boardState.charAt(3)==checker) && (boardState.charAt(6)==checker)) {
      return (true);
    }
    if((boardState.charAt(1)==checker) && (boardState.charAt(4)==checker) && (boardState.charAt(7)==checker)) {
      return (true);
    }
    if((boardState.charAt(2)==checker) && (boardState.charAt(5)==checker) && (boardState.charAt(8)==checker)) {
      return (true);
    }
    if((boardState.charAt(0)==checker) && (boardState.charAt(4)==checker) && (boardState.charAt(8)==checker)) {
      return (true);
    }
   
    return(boardState.charAt(2)== checker) && (boardState.charAt(4)== checker) && (boardState.charAt(6)== checker);

  }
  public static void main(String []args)
  {
    TicTacToe tic =new TicTacToe("x...x.oox");
    System.out.println(tic.evaluateBoard());
  }

}



