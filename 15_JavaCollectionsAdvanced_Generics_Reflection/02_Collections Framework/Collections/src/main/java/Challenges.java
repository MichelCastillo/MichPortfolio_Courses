import java.util.*;

public class Challenges {

    public static void main(String[] args) {
    }

    public static String gridChallenge(List<String> grid) {
        // Write your code here
        grid.forEach(row -> {
            for (int i = 0; i < row.length(); i++){

            }
        });

        return "";

    }


    public static int palindromeIndex(String s) {
        // Write your code here
        char[] cadena = s.toCharArray();
        int middle = s.length() / 2;

        for (int i = 0; i < middle; i++) {
            if(cadena[i] != cadena[s.length() -  (i + 1)]){

                if(cadena[i] == cadena[s.length() -  (i + 2)]){
                    return s.length() -  (i + 1);
                }
                return i;
            }
        }

        return -1;
    }

    public static int palindromeIndex2(String s) {
        // Write your code here
        int start = 0;
        int end = s.length() - 1;

        while (start < end && s.charAt(start) == s.charAt(end)){
            start++;
            end--;
        }

        if (start >= end) return -1;
        if (isPalindrome(s, ++start, end)) return start;
        if (isPalindrome(s, start, --end)) return end;

        return -1;
    }

    public static boolean isPalindrome(String s, int startIndex, int endIndex) {

        while(startIndex < endIndex && s.charAt(startIndex) == s.charAt(endIndex)){
            startIndex++;
            endIndex--;
        }

        return startIndex >= endIndex;
    }

    public static int towerBreakers(int n, int m) {
        // Write your code here
        return (m != 1 && n % 2 == 1) ? 1 : 2;
    }

    public static String caesarCipher(String s, int k) {
        // Write your code here
        List<Character> abc = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'
                , 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't'
                , 'u', 'v', 'w', 'x', 'y', 'z');

        if (abc.size() < k){
            k = k % abc.size();
        }

        StringBuilder result = new StringBuilder();

        for (char ch : s.toCharArray()) {

            if(Character.isLetter(ch)){
                int chi = abc.indexOf(Character.toLowerCase(ch));

                int index = chi + k;
                if(index > abc.size()-1){
                    index = index - (abc.size());
                }

                if(Character.isUpperCase(ch)){
                    result.append(Character.toUpperCase(abc.get(index)));
                } else {
                    result.append(abc.get(index));
                }

            } else {
                result.append(ch);
            }
        }

        return result.toString();

    }

    public static String timeConversion(String s) {
        // Write your code here
        String hs = s.split(":")[0];
        String ms = s.split(":")[1];
        String ss = s.split(":")[2].substring(0,2);

        if (s.contains("AM")){
            if (Integer.parseInt(hs) == 12)
                return "00" + ":" + ms + ":" + ss;

            return hs + ":" + ms + ":" + ss;

        }

        return (Integer.parseInt(hs) == 12) ? (Integer.parseInt(hs) + 12) + ":" + ms + ":" + ss : "00" + ":" + ms + ":" + ss;
    }

    public static int flippingMatrix(List<List<Integer>> matrix) {
        // Write your code here
        List<Integer> set = new ArrayList<>();
        int lenght = matrix.size() / 2;
        int result = 0;

        matrix.forEach(array -> {
            array.sort(Comparator.naturalOrder());
            for (int i = lenght; i > 0; i--) {
                set.add(array.get(array.size()-i));
            }
        });

        for (int i = lenght; i > 0; i--) {
            result += (set.get(set.size()-i));
        }

        return result;

    }

    public static void findZigZagSequence(int [] a, int n){
        Arrays.sort(a);
        int mid = (n + 1)/2;
        int temp = a[mid-1];
        a[mid - 1] = a[n - 1];
        a[n - 1] = temp;

        int st = mid;
        int ed = n - 2;
        while(st <= ed){
            temp = a[st];
            a[st] = a[ed];
            a[ed] = temp;
            st = st + 1;
            ed = ed - 1;
        }
        for(int i = 0; i < n; i++){
            if(i > 0) System.out.print(" ");
            System.out.print(a[i]);
        }
        System.out.println();
    }
}
