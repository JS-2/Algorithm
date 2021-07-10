function solution(a, b) {
  let days = [0, 0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335];
  let dayOfWeek = ['FRI', 'SAT', 'SUN', 'MON', 'TUE', 'WED', 'THU'];
  let sum = b + days[a];

  let mod = (sum - 1) % 7;
  return dayOfWeek[mod];
}
