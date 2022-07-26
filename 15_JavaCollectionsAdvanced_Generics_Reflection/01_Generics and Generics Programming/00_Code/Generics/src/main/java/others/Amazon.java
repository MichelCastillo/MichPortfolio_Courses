package others;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class Amazon {

    public static long getHeaviestPackage(List<Integer> packageWeights) {
        // Write your code here
        return 1;

    }

    public static void main(String[] args) {

    }

    private int ComputeCombination(List<Integer> packageWeights)
    {
        int smallP = 0;
        int largerP = 0;
        int index = -1;

        for (int i = 0; i < packageWeights.size() - 1; i++)
        {
            if (packageWeights.get(i) < packageWeights.get(i + 1) && packageWeights.get(i + 1) > largerP)
            {
                smallP = packageWeights.get(i);
                largerP = packageWeights.get(i + 1);
                index = i;
            }
        }

        if (index != -1)
        {
            int combinedWeight = smallP + largerP;
            packageWeights.set(index + 1, combinedWeight);
            packageWeights.remove(index);

            getHeaviestPackage(packageWeights);
        }
        return packageWeights.stream().max(Comparator.naturalOrder()).orElseThrow(NoSuchElementException::new);
    }

}