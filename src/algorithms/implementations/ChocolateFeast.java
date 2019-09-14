package algorithms.implementations;

public class ChocolateFeast {
	
	static int chocolateFeast(int n, int c, int m) {
        int total = n/c;
        int wrappers = total;
        while(wrappers>=m){
            int exchange = wrappers/m;
            total += exchange;
            wrappers = (wrappers/m) + (wrappers%m);
        }
        return total;

    }

}
