public class Sales {
    //sale data
    double potatoPrice, OnionPrice,OilPrice, potatoSold,OnionSold,OilSold;
    double potatoRevenue,onionRevenue, oilRevenue, totalRvenue;
    //purchase data
    double potatoPurchasePrice, onionPurchasePrice,oilPurchasePrice, potatoPurchased, onionPurchased, oilPurchased;
    double potatoCost,onionCost, oilCost, totalCost;
    int TransportCost;

    void setPrices(double potato, double onion,double oil){
        potatoPrice=potato;
        OnionPrice=onion;
        OilPrice=oil;
    }
    void setSales(double potato, double onion,double oil){
        potatoSold=potato;
        OnionSold=onion;
        OilSold=oil;
    }

    void setPurchasePrice(double potato,double onion, double oil, int transport){
        potatoPurchasePrice=potato;
        onionPurchasePrice=onion;
        oilPurchasePrice=oil;
        TransportCost=transport;
    }
    void setPurchased(double potato, double onion,double oil){
        potatoPurchased=potato;
        onionPurchased=onion;
        oilPurchased=oil;
    }

    void calculateRevenue(){
        potatoRevenue= potatoPrice*potatoSold;
        onionRevenue=OnionPrice*OnionSold;
        oilRevenue= OilPrice*OilSold;
        totalRvenue=potatoRevenue+onionRevenue+oilRevenue;
    }
    void calculateCost(){
        potatoCost= potatoPurchasePrice*potatoPurchased;
        onionCost=onionPurchasePrice*onionPurchased;
        oilCost= oilPurchasePrice*oilPurchased;
        totalCost=potatoCost+onionCost+oilCost;
    }

    String saleSummary(){
        calculateRevenue();
        return "---Sales Data---"
                +"\nPotato Revenue: ["+potatoRevenue+"]"
                +"\nOnion Revenue: ["+onionRevenue+"]"
                +"\nOil Revenue: ["+oilRevenue+"]"
                +"\nTotal Sold Price: ["+totalRvenue+"]";
    }
    String CostSummary(){
        calculateCost();
        return "---Cost Data---"
                +"\nPotato Purchase Cost: ["+potatoCost+"]"
                +"\nOnion Purchase Cost: ["+onionCost+"]"
                +"\nOil Purchase Cost: ["+oilCost+"]"
                +"\nTotal Purchase Cost: ["+totalCost+"]"
                +"\nTotal Transportation Cost: ["+TransportCost+"]";
    }
    String netIncome(){
        return "--- Final Result ---\nNet Income: ["+(totalRvenue - totalCost-TransportCost)+"]";
    }
}
