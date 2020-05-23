public class FizzBuzz
{
    
    public static void main(String[]args){
        String s="";
        for(int i=1; i<=200 ; i++){
            if(i%3==0){
                s="Fizz";
            }else if(i%5==0){
                s="Buzz";
            }else if(i%15==0){
            s="FizzBuzz";
        }else{
            s=i+" ";
}
            System.out.println(s);
        }
    }
}

