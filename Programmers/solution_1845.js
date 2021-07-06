function solution(nums) {
    var pkmNums = [];
    nums.forEach(num => {
        if(pkmNums.indexOf(num) == -1) {
            pkmNums.push(num);
        }
    });
    
    return pkmNums.length < nums.length / 2 ? pkmNums.length : nums.length / 2;
}