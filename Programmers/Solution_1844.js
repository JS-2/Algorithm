function solution(maps) {
  var rowSize = maps.length;
  var colSize = maps[0].length;
  const dir = [
    [-1, 0],
    [0, 1],
    [1, 0],
    [0, -1],
  ];
  let visited = new Array(5);

  for (let i = 0; i < rowSize; i++) {
    visited[i] = new Array(colSize).fill(false);
  }

  let q = [];
  q.push([0, 0]);
  visited[0][0] = true;

  let moveCnt = 0;

  while (q.length != 0) {
    let qLength = q.length;
    ++moveCnt;
    for (let qi = 0; qi < qLength; qi++) {
      let pos = q.shift();
      let row = pos[0];
      let col = pos[1];
      for (let d of dir) {
        let newRow = row + d[0];
        let newCol = col + d[1];
        if (
          newRow < 0 ||
          newRow >= rowSize ||
          newCol < 0 ||
          newCol >= colSize ||
          visited[newRow][newCol] ||
          maps[newRow][newCol] == 0
        ) {
          continue;
        }
        if (newRow == rowSize - 1 && newCol == colSize - 1) return ++moveCnt;
        visited[newRow][newCol] = true;
        q.push([newRow, newCol]);
      }
    }
  }

  return -1;
}
