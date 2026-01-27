📘 DSA Arrays – Basics Master Notes (Interview Ready)
1️⃣ Find Maximum & Minimum in Array
❌ Common Mistakes

Using sorting (O(N log N))

Wrong comparison signs

Not initializing properly

✅ Best Approach: Single Loop
Code
int max = nums[0];
int min = nums[0];

for(int i = 1; i < nums.length; i++){
    if(nums[i] > max) max = nums[i];
    if(nums[i] < min) min = nums[i];
}

🧠 Remember

Bigger → max, Smaller → min

2️⃣ Reverse an Array
❌ Mistakes

Loop till n (double reverse)

Wrong swapping

✅ Best: Two Pointer
Code
int l = 0, r = nums.length - 1;

while(l < r){
    int temp = nums[l];
    nums[l] = nums[r];
    nums[r] = temp;
    l++;
    r--;
}

🧠 Remember

Start + End → Swap → Move inside

3️⃣ Sum of Elements
❌ Mistakes

Overflow with int

Using recursion unnecessarily

✅ Best: Loop
Code
long sum = 0;

for(int n : nums){
    sum += n;
}

🧠 Remember

Use long if numbers are big

4️⃣ Check if Array is Sorted
❌ Mistakes

Wrong comparison

Starting from i=0

✅ Best: Compare Adjacent
Code
boolean sorted = true;

for(int i = 1; i < nums.length; i++){
    if(nums[i] < nums[i-1]){
        sorted = false;
        break;
    }
}

🧠 Remember

Current < Previous → Not sorted

5️⃣ Count Even / Odd
❌ Mistakes

Forgetting negative numbers

Wrong mod logic

✅ Best: %2 or &1
Code (%2)
int even = 0, odd = 0;

for(int n : nums){
    if(n % 2 == 0) even++;
    else odd++;
}

Code (Bit)
if((n & 1) == 0) even++;
else odd++;

🧠 Remember

Last bit = 0 → Even

6️⃣ Second Largest Element
❌ Mistakes

Sorting

Not handling duplicates

✅ Best: One Pass
Code
int max = Integer.MIN_VALUE;
int second = Integer.MIN_VALUE;

for(int n : nums){

    if(n > max){
        second = max;
        max = n;
    }
    else if(n != max && n > second){
        second = n;
    }
}

🧠 Remember

New max → old max = second

7️⃣ Rotate Array by 1 (Left)
❌ Mistakes

Forgetting first element

Wrong shifting

✅ Best: Shift
Code
int first = nums[0];

for(int i = 1; i < nums.length; i++){
    nums[i-1] = nums[i];
}

nums[nums.length-1] = first;

🧠 Remember

Save first → Shift → Put last

8️⃣ Rotate Array by K (Left)
❌ Mistakes

Not doing k % n

Wrong reverse order

✅ Best: Reverse Algorithm
Code
k = k % nums.length;

reverse(nums, 0, k-1);
reverse(nums, k, nums.length-1);
reverse(nums, 0, nums.length-1);


Helper:

static void reverse(int[] a, int l, int r){
    while(l < r){
        int t = a[l];
        a[l] = a[r];
        a[r] = t;
        l++; r--;
    }
}

🧠 Remember

First K → Rest → All

9️⃣ Rotate Array by K (Right)
❌ Mistakes

Mixing left/right logic

✅ Best: Reverse
Code
k = k % nums.length;

reverse(nums, 0, nums.length-1);
reverse(nums, 0, k-1);
reverse(nums, k, nums.length-1);

🧠 Remember

All → First K → Rest

📌 Final Memory Cheatsheet
Problem	Pattern
Max/Min	One Loop
Reverse	Two Pointer
Sum	Accumulator
Sorted	Adjacent Compare
Even/Odd	%2 / &1
2nd Largest	Track Two
Rotate 1	Shift
Rotate K	Reverse Algo
🎯 Interview Golden Rules

✔️ Avoid sorting unless asked
✔️ Prefer O(N) solutions
✔️ Handle k > n
✔️ Watch edge cases
✔️ Dry run always
