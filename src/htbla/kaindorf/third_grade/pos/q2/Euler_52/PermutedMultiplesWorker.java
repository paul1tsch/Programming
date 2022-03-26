package htbla.kaindorf.third_grade.pos.q2.Euler_52;

import java.util.concurrent.Callable;

public class PermutedMultiplesWorker implements Callable<Integer> {
    private int number;
    private int maxFactor;

    public PermutedMultiplesWorker(int number, int maxFactor) {
        this.number = number;
        this.maxFactor = maxFactor;
    }

    @Override
    public Integer call() throws Exception {
        for (int i = 2; i < maxFactor; i++) {
            if (containsSameDigits(number * i)) {
                continue;
            }
            return null;
        }
        return number;
    }

    private boolean containsSameDigits(int newnumber) {
        String numberString = number + "";
        String newString = newnumber + "";
        if (numberString.length() != newString.length()){
            return false;
        }
        for (int i = 0; i < numberString.length(); i++) {
            for (int j = 0; j < newString.length(); j++) {
                if (newString.contains(numberString.charAt(i) + "")) {
                    newString = newString.substring(0, i) + newString.substring(i);
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}