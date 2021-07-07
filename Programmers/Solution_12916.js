function solution(s){
    s = s.toLowerCase();
    var pCnt = 0;
    var yCnt = 0;
    for(let i = 0; i < s.length; i++) {
        if(s.charAt(i) == 'p') ++pCnt;
        else if(s.charAt(i) == 'y') ++yCnt;
    }
    return pCnt == yCnt ? true : false;
}