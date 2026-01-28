✅ LEVEL 2 – Searching & Counting (Master File)
import java.util.*;

/*
 LEVEL 2: Searching & Counting (Frequency / Hashing)

 Topics Covered:
 1. Find Duplicate Number
 2. Find Missing Number (1 to N)
 3. Frequency of Elements
 4. First Repeating Element
 5. Majority Element (> n/2)
 6. Elements Appearing Once
*/

public class Level2_Searching_Counting {

    public static void main(String[] args){

        int[] nums = {1,2,2,3,1,4,2};

        System.out.println("Duplicate: " + findDuplicate(nums));
        System.out.println("Missing (1 to N): " + findMissing(nums, 7));

        printFrequency(nums);

        System.out.println("First Repeating: " + firstRepeating(nums));
        System.out.println("Majority Element: " + majorityElement(nums));

        System.out.println("Single Elements: " + singleElements(nums));
    }

    // --------------------------------------------------
    // 1️⃣ Find Duplicate Number (HashSet)
    // Time: O(N), Space: O(N)
    // --------------------------------------------------
    static int findDuplicate(int[] nums){

        HashSet<Integer> set = new HashSet<>();

        for(int n : nums){

            if(set.contains(n)){
                return n;
            }

            set.add(n);
        }

        return -1;
    }

    // --------------------------------------------------
    // 2️⃣ Find Missing Number (1 to N) - Sum Formula
    // Time: O(N), Space: O(1)
    // --------------------------------------------------
    static int findMissing(int[] nums, int n){

        int expected = n * (n + 1) / 2;

        int actual = 0;

        for(int num : nums){
            actual += num;
        }

        return expected - actual;
    }

    // --------------------------------------------------
    // 3️⃣ Frequency of Elements (HashMap)
    // Time: O(N), Space: O(N)
    // --------------------------------------------------
    static void printFrequency(int[] nums){

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        System.out.println("Frequencies:");

        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            System.out.println(e.getKey() + " -> " + e.getValue());
        }
    }

    // --------------------------------------------------
    // 4️⃣ First Repeating Element (Two Pass HashMap)
    // Time: O(N), Space: O(N)
    // --------------------------------------------------
    static int firstRepeating(int[] nums){

        HashMap<Integer, Integer> map = new HashMap<>();

        // Count
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // Find first repeating
        for(int n : nums){

            if(map.get(n) > 1){
                return n;
            }
        }

        return -1;
    }

    // --------------------------------------------------
    // 5️⃣ Majority Element (> n/2) - Boyer Moore
    // Time: O(N), Space: O(1)
    // --------------------------------------------------
    static int majorityElement(int[] nums){

        int count = 0;
        int candidate = 0;

        // Find candidate
        for(int n : nums){

            if(count == 0){
                candidate = n;
            }

            if(n == candidate){
                count++;
            } else {
                count--;
            }
        }

        // Optional: Verify candidate
        count = 0;

        for(int n : nums){
            if(n == candidate){
                count++;
            }
        }

        if(count > nums.length / 2){
            return candidate;
        }

        return -1;
    }

    // --------------------------------------------------
    // 6️⃣ Elements Appearing Once (HashMap)
    // Time: O(N), Space: O(N)
    // --------------------------------------------------
    static List<Integer> singleElements(int[] nums){

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();

        for(Map.Entry<Integer,Integer> e : map.entrySet()){

            if(e.getValue() == 1){
                result.add(e.getKey());
            }
        }

        return result;
    }
}

📌 SUMMARY (For README / Revision)
Problem	Best Approach	Time	Space
Duplicate	HashSet	O(N)	O(N)
Missing (1–N)	Sum Formula	O(N)	O(1)
Frequency	HashMap	O(N)	O(N)
First Repeating	2-Pass Map	O(N)	O(N)
Majority	Boyer-Moore	O(N)	O(1)
Single Elements	HashMap	O(N)
