# LEVEL 3: Two Pointer Technique (VERY IMPORTANT)

This file contains common Two Pointer interview questions with Brute Force and Optimal approaches with Java code.

---

## 1. Two Sum

### Brute Force (O(n²))

```java
for(int i=0;i<n;i++){
  for(int j=i+1;j<n;j++){
    if(arr[i]+arr[j]==target) return true;
  }
}
```

### Better (HashMap - O(n))

```java
HashMap<Integer,Integer> map=new HashMap<>();
for(int i=0;i<n;i++){
 int need=target-arr[i];
 if(map.containsKey(need)) return true;
 map.put(arr[i],i);
}
```

### Optimal (Sorted + Two Pointer - O(n))

```java
int l=0,r=n-1;
while(l<r){
 int sum=arr[l]+arr[r];
 if(sum==target) return true;
 else if(sum<target) l++;
 else r--;
}
```

---

## 2. Pair With Given Sum (Sorted Array)

### Brute Force

```java
for(int i=0;i<n;i++){
 for(int j=i+1;j<n;j++){
  if(arr[i]+arr[j]==k) return true;
 }
}
```

### Optimal (Two Pointer)

```java
int l=0,r=n-1;
while(l<r){
 int sum=arr[l]+arr[r];
 if(sum==k) return true;
 else if(sum<k) l++;
 else r--;
}
```

---

## 3. Remove Duplicates (Sorted Array)

### Brute Force (Set)

```java
Set<Integer> set=new LinkedHashSet<>();
for(int x:arr) set.add(x);
```

### Optimal (Two Pointer)

```java
int i=0;
for(int j=1;j<n;j++){
 if(arr[j]!=arr[i]){
  i++;
  arr[i]=arr[j];
 }
}
return i+1;
```

---

## 4. Move Zeros To End

### Brute Force

```java
int[] temp=new int[n];
int k=0;
for(int x:arr) if(x!=0) temp[k++]=x;
```

### Optimal (Two Pointer)

```java
int i=0;
for(int j=0;j<n;j++){
 if(arr[j]!=0){
  arr[i]=arr[j];
  i++;
 }
}
while(i<n) arr[i++]=0;
```

---

## 5. Sort 0,1,2 (Dutch Flag)

### Brute Force

```java
Arrays.sort(arr);
```

### Better (Count)

```java
int c0=0,c1=0,c2=0;
for(int x:arr){
 if(x==0) c0++;
 else if(x==1) c1++;
 else c2++;
}
```

### Optimal (Dutch Flag)

```java
int low=0,mid=0,high=n-1;
while(mid<=high){
 if(arr[mid]==0){ swap(low,mid); low++; mid++; }
 else if(arr[mid]==1) mid++;
 else{ swap(mid,high); high--; }
}
```

---

## 6. Merge Two Sorted Arrays

### Brute Force

```java
int[] res=new int[n+m];
```

### Optimal (In-place from Back)

```java
int i=m-1,j=n-1,k=m+n-1;
while(i>=0 && j>=0){
 if(a[i]>b[j]) a[k--]=a[i--];
 else a[k--]=b[j--];
}
while(j>=0) a[k--]=b[j--];
```

---

## 7. Container With Most Water

### Brute Force

```java
for(int i=0;i<n;i++){
 for(int j=i+1;j<n;j++){
  ans=Math.max(ans,(j-i)*Math.min(h[i],h[j]));
 }
}
```

### Optimal (Two Pointer)

```java
int l=0,r=n-1,ans=0;
while(l<r){
 ans=Math.max(ans,(r-l)*Math.min(h[l],h[r]));
 if(h[l]<h[r]) l++;
 else r--;
}
```

---

# Interview Explanation Template

1. Explain brute force.
2. Give complexity.
3. Show why slow.
4. Give optimal approach.
5. Explain pointer move.
6. Final complexity.

---

# Complexity Summary

| Problem      | Brute        | Optimal    |
| ------------ | ------------ | ---------- |
| Two Sum      | O(n²)        | O(n)       |
| Pair Sum     | O(n²)        | O(n)       |
| Remove Dups  | O(n) Space   | O(1) Space |
| Move Zeros   | O(n) Space   | O(1) Space |
| Sort 0,1,2   | O(n log n)   | O(n)       |
| Merge Arrays | O(n+m) Space | O(1) Space |
| Container    | O(n²)        | O(n)       |

---

# Key Rule

Sorted Array → Two Pointers First.
Need O(n) → Try Two Pointers.

---

Prepared for Interview + GitHub.
