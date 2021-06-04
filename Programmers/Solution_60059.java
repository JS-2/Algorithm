
class Solution {
    
	public static void mapShow(int[][] map) {
		for(int r = 0; r < map.length; r++) {
			for(int c = 0; c < map.length; c++) {
				System.out.print(map[r][c]);
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void turnKey(int[][] key) {
		int[][] newKey = new int[key.length][key.length];
		for(int r = 0; r < key.length; r++) {
			for(int c = 0; c < key.length; c++) {
				newKey[c][key.length - 1 - r] = key[r][c];
			}
		}
		for(int r = 0; r < key.length; r++) {
			key[r] = newKey[r];
		}
	}
	
	public static int[][] cloneLock(int[][] lock) {
		int[][] cLock = new int[lock.length][];
		for(int i = 0; i < lock.length; i++) {
			cLock[i] = lock[i].clone();
		}
		return cLock;
	}
	
	public static boolean solution(int[][] key, int[][] lock) {
		for(int i = 0; i < 4; i++) {
			for(int rs = -key.length + 1; rs < lock.length; rs++) {
				loop:
				for(int cs = -key.length + 1; cs < lock.length; cs++) {
					int[][] cLock = cloneLock(lock); 
					for(int r = rs; r < rs + key.length; r++) {
						for(int c = cs; c < cs + key.length; c++) {
							if(r >= 0 && c >= 0 && r < lock.length && c < lock.length) {
								cLock[r][c] += key[r - rs][c - cs];
								if(cLock[r][c] > 1) continue loop;
							}
						}
					}
					for(int r = 0; r < cLock.length; r++) {
						for(int c = 0; c < cLock.length; c++) {
							if(cLock[r][c] == 0) continue loop;
						}
					}
					return true;
				}
			}
			if(i == 3) return false;
			turnKey(key);
		}
        return false;
    }
	
	public static void main(String[] args) {
		int[][] key = { { 0, 0, 0 }, { 1, 0, 0 }, { 0, 1, 1 } };
		int[][] lock = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
		
		System.out.println(solution(key, lock));
	}
}