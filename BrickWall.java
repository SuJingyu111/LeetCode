import java.util.*;

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int width = 0;
        int layer = wall.size();
        List<Integer> l1 =  wall.get(0);
        for (Integer i :l1) {
            width += i;
        }
        int[] crossBricks = new int[layer];
        int[] currentBrickIdx = new int[layer];
        int idx = 0;
        for (List<Integer> aWall : wall) {
            crossBricks[idx++] = aWall.get(0);
        }
        Arrays.fill(currentBrickIdx, 0);
        int vLine = 1;
        int res = layer;
        while (vLine < width) {
            int nextGap = Integer.MAX_VALUE;
            int thisRes = 0;
            for (int i = 0; i < layer; i++) {
                if (crossBricks[i] <= vLine) {
                    crossBricks[i] += wall.get(i).get(currentBrickIdx[i] + 1);
                    currentBrickIdx[i] = currentBrickIdx[i] + 1;
                }
                else {
                    thisRes += 1;
                }
            }
            for (int i = 0; i < layer; i++) {
                nextGap = Math.min(crossBricks[i] - vLine, nextGap);
            }
            res = Math.min(res, thisRes);
            vLine += nextGap;
        }
        return res;
    }
}