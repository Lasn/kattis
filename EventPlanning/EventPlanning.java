public class EventPlanning{

    public static void main(String[] args) {
        Kattio sc = new Kattio(System.in);
        int bestOffer = Integer.MAX_VALUE;
        int participants = sc.getInt();
        int budget = sc.getInt();
        int hotels = sc.getInt();
        int weeks = sc.getInt();
        for(int i = 0; i<hotels;i++){
            int price = sc.getInt();
            for(int w = 0; w<weeks;w++){
                int beds = sc.getInt();
                if(beds >= participants){
                    int totalPrice = participants * price;
                    if(totalPrice<=budget && totalPrice<bestOffer){
                        bestOffer = totalPrice;
                    }
                    
                }
            }
        }
        if(bestOffer != Integer.MAX_VALUE){
            System.out.println(bestOffer);
        } else {
            System.out.println("stay home");
        }
        

    }

}