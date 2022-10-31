package algoexpert;

import java.util.ArrayList;
import java.util.Comparator;

public class ClassPhotos {

    public boolean classPhotos(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        Integer redSum = redShirtHeights.stream().mapToInt(i->i).sum();
        Integer blueSum = blueShirtHeights.stream().mapToInt(i->i).sum();
        if (Math.abs(redSum-blueSum) < redShirtHeights.size()) {
            return false;
        } else {
            redShirtHeights.sort(Comparator.naturalOrder());
            blueShirtHeights.sort(Comparator.naturalOrder());
            if (redSum > blueSum) {
                for (int i=0; i<redShirtHeights.size(); i++) {
                    if (redShirtHeights.get(i)<= blueShirtHeights.get(i)) {
                        return false;
                    }
                }
            } else {
                for (int i=0; i<redShirtHeights.size(); i++) {
                    if (blueShirtHeights.get(i)<= redShirtHeights.get(i)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

}
