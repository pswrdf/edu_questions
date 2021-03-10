package romanianNumbers;

/**
 * Натуральные числа записываются при помощи повторения этих цифр.
 * При этом, если большая цифра стоит перед меньшей, то они складываются (принцип сложения),
 * если же меньшая стоит перед большей, то меньшая вычитается из большей (принцип вычитания).
 * Последнее правило применяется только во избежание четырёхкратного повторения одной и той же цифры.
 */
public class FromArabian {
    static char one = 'I';
    static char five = 'V';
    static char ten = 'X';
    static char fifty = 'L';
    static char hundred = 'C';
    static char fiveHundred = 'D';
    static char thousand = 'M';

    static char[] latinTen = new char[]{one, ten, hundred, thousand};
    static char[] latinFive = new char[]{five, fifty, fiveHundred};


    public static String toLatin(int i) {
        String ret = "";
        for (int dignum = 4; dignum > 0; dignum--) {
            int digit = (int) ((i % Math.pow(10, dignum)) / Math.pow(10, dignum - 1));
            ret += formDigit(dignum, digit);
        }
        return ret;
    }

    private static String formDigit(int num, int value) {
        num--;
        String ret = "";
        if (value < 4) {
            ret = append(value, latinTen[num], ret);
        } else if (value == 4) {
            ret = append(1, latinTen[num], ret);
            ret = append(1, latinFive[num], ret);
        } else if (value < 9) {
            ret = append(1, latinFive[num], ret);
            ret = append(value - 5, latinTen[num], ret);
        } else {
            ret = append(1, latinTen[num], ret);
            ret = append(1, latinTen[num + 1], ret);
        }
        return ret;
    }

    private static String append(int times, char c, String str) {
        while (times > 0) {
            str += c;
            times--;
        }
        return str;
    }
}
