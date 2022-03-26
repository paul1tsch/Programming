package htbla.kaindorf.second_grade.loal.misc;

import java.util.*;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

/**
 * © 2022 All rights reserved.
 * Creator:     Dominik PAULITSCH
 * Initials:    DP
 * Project:     LOAL_POS_SYP_HTBLA-Kaindorf
 * File:        Nonogram.java
 */

public class Nonogram {

    /**
     * Should be an QR-CODE
     * 1 = A
     * 2 = B
     * 3 = C
     * 4 = D
     * 5 = E
     * 6 = F
     * 7 = G
     * 8 = H
     * 9 = I
     */

    static String[] nonogram = {"GAAAAG AAACBAAAA ACABBBBACA ACAAAAAAACA ACAABAABACA AABAAAAA GAAAAAAAG BAAAB AEEABE BACACACA BCBCBAA ACABAAAAAB EBBAAC ACBADCAA ACAABEB BBCA BBBBCAD AAAABABCB AACDBAAA AAAEAAABA ADBCI AAAABAC GABAABAC AABBCBBA ACABBAFB ACAAAAAACAC ACABDBDA AACBABAA GCAAAAC", "GBABDG AAAAAA ACAACDACA ACABCAAACA ACAAECACA AAAAAAAAAAA GAAAAAAAG A FAEADA CAABAABCC AACACAB BACAAAACA CAADADE AAAAABCB AADDAAAD BAADCBA BABECAAD ACAAABA BAAAAAAB AAABBAACBA AIBAFA AAAAAAA GBAAABAAAA AACAACAD ACABABBFAA ACAAAACCAA ACAAAAACAA AACAACE GAAAABB"};

    public static void main(String[] args) {
        for (String[] puzzleData : new String[][]{nonogram})
            newPuzzle(puzzleData);
    }

    static void newPuzzle(String[] data) {
        String[] rowData = data[0].split("\\s");
        String[] colData = data[1].split("\\s");

        List<List<BitSet>> cols, rows;
        rows = getCandidates(rowData, colData.length);
        cols = getCandidates(colData, rowData.length);

        int numChanged;
        do {
            numChanged = reduceMutual(cols, rows);
            if (numChanged == -1) {
                System.out.println("No solution");
                return;
            }
        } while (numChanged > 0);

        for (List<BitSet> row : rows) {
            for (int i = 0; i < cols.size(); i++)
                System.out.print(row.get(0).get(i) ? "▓▓▓" : "░░░");
            System.out.println();
        }
        System.out.println();
    }

    static List<List<BitSet>> getCandidates(String[] data, int len) {
        List<List<BitSet>> result = new ArrayList<>();

        for (String s : data) {
            List<BitSet> lst = new LinkedList<>();

            int sumChars = s.chars().map(c -> c - 'A' + 1).sum();
            List<String> prep = stream(s.split(""))
                    .map(x -> repeat(x.charAt(0) - 'A' + 1, "1")).collect(toList());

            for (String r : genSequence(prep, len - sumChars + 1)) {
                char[] bits = r.substring(1).toCharArray();
                BitSet bitset = new BitSet(bits.length);
                for (int i = 0; i < bits.length; i++)
                    bitset.set(i, bits[i] == '1');
                lst.add(bitset);
            }
            result.add(lst);
        }
        return result;
    }

    static List<String> genSequence(List<String> ones, int numZeros) {
        if (ones.isEmpty())
            return Collections.singletonList(repeat(numZeros, "0"));

        List<String> result = new ArrayList<>();
        for (int x = 1; x < numZeros - ones.size() + 2; x++) {
            List<String> skipOne = ones.stream().skip(1).collect(toList());
            for (String tail : genSequence(skipOne, numZeros - x))
                result.add(repeat(x, "0") + ones.get(0) + tail);
        }
        return result;
    }

    static String repeat(int n, String s) {
        return String.valueOf(s).repeat(Math.max(0, n));
    }


    static int reduceMutual(List<List<BitSet>> cols, List<List<BitSet>> rows) {
        int countRemoved1 = reduce(cols, rows);
        if (countRemoved1 == -1)
            return -1;

        int countRemoved2 = reduce(rows, cols);
        if (countRemoved2 == -1)
            return -1;

        return countRemoved1 + countRemoved2;
    }

    static int reduce(List<List<BitSet>> a, List<List<BitSet>> b) {
        int countRemoved = 0;

        for (int i = 0; i < a.size(); i++) {

            BitSet commonOn = new BitSet();
            commonOn.set(0, b.size());
            BitSet commonOff = new BitSet();

            for (BitSet candidate : a.get(i)) {
                commonOn.and(candidate);
                commonOff.or(candidate);
            }

            for (int j = 0; j < b.size(); j++) {
                final int fi = i, fj = j;

                if (b.get(j).removeIf(cnd -> (commonOn.get(fj) && !cnd.get(fi))
                        || (!commonOff.get(fj) && cnd.get(fi))))
                    countRemoved++;

                if (b.get(j).isEmpty())
                    return -1;
            }
        }
        return countRemoved;
    }
}
