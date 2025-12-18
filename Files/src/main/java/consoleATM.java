public class consoleATM {
    //current balance
    double Balance=0;
    void Deposit(double Amount){
        Balance=Balance+Amount;
    }
    int Withdraw(double Amount){
        if(Balance>=Amount){
            if(Amount>100) return 0;
            else{
                Balance=Balance-Amount;
                return 1;
            }
        } return -1;
    }
}
