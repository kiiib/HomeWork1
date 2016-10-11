import java.util.Comparator;
class Bubble {
    public static void sort(double x[]) {
        while(true) {
            boolean updated = false;
            for(int i = 1; i < x.length; i++) {
                if(x[i] < x[i-1]) {
                    double temp = x[i];
                    x[i] = x[i-1];
                    x[i-1] = temp;
                    updated = true;
                }
            }
            if(!updated) break;
        }
    }
    public static void sort(int x[]) {
        while(true) {
            boolean updated = false;
            for(int i = 1; i < x.length; i++) {
                if(x[i] < x[i-1]) {
                    int temp = x[i];
                    x[i] = x[i-1];
                    x[i-1] = temp;
                    updated = true;
                }
            }
            if(!updated) break;
        }
    }


    public static <T extends Comparable> void sort(T x[]) {

        while(true) {
            boolean updated = false;
            for(int i = 1; i < x.length; i++) {
                if(x[i].compareTo(x[i-1]) < 0) {
                    T temp = x[i];
                    x[i] = x[i-1];
                    x[i-1] = temp;
                    updated = true;
                }
            }
            if(!updated) break;
        }
    }

    public static <T> void sort(T x[], Comparator<T> comparator) {

        while(true) {
            boolean updated = false;
            for(int i = 1; i < x.length; i++) {
                if(comparator.compare(x[i], x[i-1]) < 0) {
                    T temp = x[i];
                    x[i] = x[i-1];
                    x[i-1] = temp;
                    updated = true;
                }
            }
            if(!updated) break;
        }
    }

}
