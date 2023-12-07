package knightstour;


public class Board {
    private Node root;
    private int dimension;

    public Board(int dimension) {
        this.dimension = dimension;
        createBoard();
    }

    private void createBoard() {
        // Create the board using a linked grid
        root = new Node();
        Node columnMarker = root;
        Node rowMarker = root;
        Node temp;

        // Create rows and columns
        for (int x = 0; x < dimension - 1; x++) {
            temp = new Node();
            columnMarker.setRight(temp);
            temp.setLeft(columnMarker);
            columnMarker = temp;
        }

        for (int y = 0; y < dimension - 1; y++) {
            temp = new Node();
            columnMarker = temp;
            rowMarker.setDown(temp);
            temp.setUp(rowMarker);
            for (int x = 0; x < dimension - 1; x++) {
                temp.setLeft(columnMarker);
                columnMarker.setRight(temp);
                temp.setUp(columnMarker.getUp().getRight());
                temp.getUp().setDown(temp);
                columnMarker = temp;
            }
            rowMarker = rowMarker.getDown();
        }
    }

    public void display() {
        Node temp = root;
        Node rowMarker = root;

        while (temp != null) {
            while (temp != null) {
                System.out.print(temp.getData() + " ");
                temp = temp.getRight();
            }
            System.out.println();
            temp = rowMarker.getDown();
            rowMarker = temp;
        }
    }
}
