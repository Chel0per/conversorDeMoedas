package src;

public class CoinConverter {
    public static void main(String[] args) {
        ApiSearch api = new ApiSearch();
        try{
            System.out.println(api.getCurrencyRatio("USD","BRL"));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
