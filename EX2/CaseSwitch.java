package EX2;
public class CaseSwitch {

    public int switcha1(int i) {
        switch (i) {
            case -100: return -1;
            case 0:    return  0;
            case 100:  return  1;
            default:   return -1;
        }
    }
    public int switcha2(int i) {
        switch (i) {
            case -7: return -1;
            case -6: return -1;
            case -5: return -1;
            case -4: return -1;
            case -3: return -1;
            case -2: return -1;
            case -1: return -1;
            case 0:  return  0;
            case 1:  return  1;
            default: return -1;
        }
    }

    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        CaseSwitch dummy = new CaseSwitch();

        switch (a) {
            case 1:  dummy.switcha1(b);
            case 2:  dummy.switcha2(b);
            default: dummy.switcha1(b);
        }
    }
}