package helix;
import java.util.LinkedList;
import java.util.Queue;
public class MatrixHelixMorph {

    /**
     * @param inMatrix
     * @return a matrix that is morphed into a helix version of inMatrix
     */
    public static int[][] helix( int[][] inMatrix) {
        if(inMatrix!=null) {

            Queue<Integer> q = new LinkedList<Integer>();

            for (int i = 0; i < inMatrix.length; i++) {
                for (int j = 0; j < inMatrix[i].length; j++) {
                    q.add(inMatrix[i][j]);
                }
            }

            int horizontal = inMatrix[0].length;
            int vertical = inMatrix.length;

            int x = 0, y = 0, total = horizontal * vertical, counter = 0;
            int ul = 0, ll = 0;
            char direction = 'r';
            boolean inserted = true;

            while (counter < total) {
                if (inserted == true) {
                    inMatrix[x][y] = q.poll();
                    counter++;
                }
                inserted = true;
                switch (direction) {
                    case 'r':
                        if (y < horizontal - 1) {
                            y++;
                        } else {
                            direction = 'd';
                            ul++;
                            inserted = false;
                        }
                        break;
                    case 'd':
                        if (x < vertical - 1) {
                            x++;
                        } else {
                            direction = 'l';
                            horizontal--;
                            inserted = false;
                        }
                        break;
                    case 'l':
                        if (y > 0 && y > ll) {
                            y--;
                        } else {
                            direction = 'u';
                            vertical--;
                            inserted = false;
                        }
                        break;
                    case 'u':
                        if (x > ul) {
                            x--;
                        } else {
                            direction = 'r';
                            ll++;
                            inserted = false;
                        }
                        break;
                }
            }
        }
        return inMatrix;
    }
}