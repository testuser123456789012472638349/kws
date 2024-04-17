const PI = 3.14;
// PI = 75;
const arr = ["홍길동", "김길동", "최길동", "조길동", "이길동", "박길동", "임길동", "정길동"];
console.log("변경전: " + arr.toString());
arr.sort();
console.log(arr[8]); //배열의 처음
console.log(arr[arr.length - 1]); //배열의 마지막
console.log("정렬: " + arr.toString());
console.log(`arr의 크기: ${arr.length}`);

arr[1] = "마길동"; //가능
console.log("변경후: " + arr.join("#"));
// arr = ["조길동", "임길동", "윤길동"]; //불가능
const arr2 = []; //배열의 초기화
arr2[0] = "이길동";
console.log(arr[2]);
const fruits = ["Banana", "Orange", "Apple", "Mango"];
document.getElementById("demo").innerHTML = fruits;

const arr3 = [
    "박길동",
    {mem1: 1, mem2: 2},
    34
];
console.log(arr3[1]);