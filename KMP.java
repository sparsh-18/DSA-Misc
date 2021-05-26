import java.util.Scanner;

public class KMP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String");
        char t[] = sc.nextLine().toCharArray();
        System.out.println("Eter pattern");
        char pat[] = sc.nextLine().toCharArray();

        KMP_Search(t, pat);
    }

    private static void KMP_Search(char[] t, char[] pat) {
        int m = pat.length;
        int lps[] = new int[m];

        computeLps(pat, m, lps);

        int n = t.length;

        int i = 0, j = 0;

        while(i<n) {

            if(t[i] == pat[j]) {
                i++;
                j++;
            }

            if(j == m) {
                System.out.println("Found at index "+(i-j));
                j = lps[j-1];
            }

            else if(j<m && pat[j] != t[i]) {
                if(j!=0) 
                    j=lps[j-1];

                else i++;
            }
        }
    }

    private static void computeLps(char[] pat, int m, int[] lps) {
        int i = 1, len = 0;
        lps[0] = 0;

        while (i < m) {

            if (pat[len] == pat[i]) {
                len++;
                lps[i] = len;
                i++;
            } 
            
            else {

                if (len > 0 && pat[len] != pat[i]) {
                    len = pat[len - 1];
                } 
                
                else // len==0 {
                    lps[i] = len;
                i++;
            }
        }
    }
}
