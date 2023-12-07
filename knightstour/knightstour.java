package knightstour;

public class knightstour{
    private Board board;
    private int totalSteps;

    public knightstour(int dimension) {
        board = new Board(dimension);
        totalSteps = dimension * dimension;
    }

    public void tour() {
        tour(board.getRoot(), 1);
    }

    private void tour(Node node, int step) {
        node.setData(step);

        if (step == totalSteps) {
            board.display();
            return;
        }

        Node[] availableMoves = getAvailableMoves(node);
        for (Node move : availableMoves) {
            if (move.getData() == 0) {
                tour(move, step + 1);
            }
        }

        node.setData(0); // Reset the node value if no available moves found
    }

    private Node[] getAvailableMoves(Node node) {
        int x = getXCoordinate(node);
        int y = getYCoordinate(node);

        Node[] moves = new Node[8];
        moves[0] = getNodeAt(x - 2, y + 1);
        moves[1] = getNodeAt(x - 1, y + 2);
        moves[2] = getNodeAt(x + 1, y + 2);
        moves[3] = getNodeAt(x + 2, y + 1);
        moves[4] = getNodeAt(x + 2, y - 1);
        moves[5] = getNodeAt(x + 1, y - 2);
        moves[6] = getNodeAt(x - 1, y - 2);
        moves[7] = getNodeAt(x - 2, y - 1);

        return moves;
    }

    private Node getNodeAt(int x, int y) {
        if (x >= 0 && x < board.getDimension() && y >= 0 && y < board.getDimension()) {
            Node temp = board.getRoot();
            for (int i = 0; i < y; i++) {
                temp = temp.getDown();
            }
            for (int i = 0; i < x; i++) {
                temp = temp.getRight();
            }
            return temp;
        }
        return null;
    }

    private int getXCoordinate(Node node) {
        int x = 0;
        Node temp = node;
        while (temp.getLeft() != null) {
            temp = temp.getLeft();
            x++;
        }
        return x;
    }

    private int getYCoordinate(Node node) {
        int y = 0;
        Node temp = node;
        while (temp.getUp() != null) {
            temp = temp.getUp();
            y++;
        }
        return y;
    }
}
