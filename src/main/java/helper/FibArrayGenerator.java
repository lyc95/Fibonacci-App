package helper;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

public class FibArrayGenerator {
    private BigInteger[] IntegerList;
    Comparator<BigInteger> cmp;

    public FibArrayGenerator() {
        initialzie();
    }

    public String[] getFibArrayWithSize(int n) {
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = IntegerList[i].toString();
        }
        return res;
    }
    public String[] getSortedFibArrayWithSize(int n) {
        BigInteger[] list = new BigInteger[n];
        System.arraycopy(IntegerList, 0, list, 0, n);
        Arrays.sort(list, cmp);
        String[] res = new String[n];
        for (int i = 0; i < n; i++) {
            res[i] = list[i].toString();
        }
        return res;
    }
    private void initialzie() {
        IntegerList = new BigInteger[100];
        IntegerList[0] = BigInteger.valueOf(0);
        IntegerList[1] = BigInteger.valueOf(1);
        for (int i = 2; i < IntegerList.length; i++) {
            IntegerList[i] = IntegerList[i-1].add(IntegerList[i-2]);
        }
        cmp = new Comparator<BigInteger>() {
            @Override
            public int compare(BigInteger o1, BigInteger o2) {
                if (o1.equals(o2))
                    return 0;
                boolean isEven1 = o1.getLowestSetBit() != 0;
                boolean isEven2 = o2.getLowestSetBit() != 0;
                // getLowestSetBit() returns the position of first 1’s bit from the rightmost side in this BigInteger.
                if ((isEven1 && isEven2) || (!isEven1 && !isEven2)) {
                    return o2.compareTo(o1);
                }
                else if (isEven1 && !isEven2) {
                    return -1;
                }
                else {
                    return 1;
                }
            }
        };
    }
}
