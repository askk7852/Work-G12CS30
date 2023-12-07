package linkedgrid;

public class linkedgrid {

	private Node root;
	
	linkedgrid(int dimension){
		
		//create first node in row
		root = new Node();
		Node columnmarker = root;	
		Node rowmarker = root;
		Node temp = null;
		
		//completing row
		for(int x  = 0; x < dimension-1; x++) {//(dimension - 1) because root exists
			temp = new Node();
			columnmarker.setRight(temp);
			temp.setLeft(columnmarker);
			columnmarker = temp;
		}
		
		for (int y = 0; y < dimension - 1; y++) {
		    // first node in new row
		    temp = new Node();
		    columnmarker = temp;
		    rowmarker.setDown(temp);
		    temp.setUp(rowmarker);

		    // completing row
		    for (int x = 0; x < dimension - 1; x++) {
		        temp.setLeft(columnmarker);
		        columnmarker.setRight(temp);
		        temp.setUp(columnmarker.getUp().getRight());
		        temp.getUp().setDown(temp);
		        columnmarker = temp;
		    }

		    rowmarker = rowmarker.getDown();
		}
		}
	
	
	public void display() {
        Node temp = root;
        Node rowMarker = root;

        while (rowMarker != null) {
            while (temp != null) {
                System.out.print(temp.getData() + " ");
                temp = temp.getRight();
            }
            System.out.println();
            rowMarker = rowMarker.getDown();
            temp = rowMarker;
        }
    }

		 public void flood(int newnumber) {
		        flood(root, root.getData(), newnumber);
		    }

		    private void flood(Node currentnode, int oldnumber, int newnumber) {
		        if (currentnode == null || currentnode.getData() != oldnumber) {
		            return;
		        }

		        currentnode.setData(newnumber);

		        flood(currentnode.getUp(), oldnumber, newnumber);
		        flood(currentnode.getRight(), oldnumber, newnumber);
		        flood(currentnode.getDown(), oldnumber, newnumber);
		        flood(currentnode.getLeft(), oldnumber, newnumber);
		    }
		
		public boolean solved() {
			int target = root.getData();
			Node temp = root; 
			Node rowmarker = root;
			
			while(temp != null) {
				while(temp != null) {
					if(temp.getData() != target)
						return false;
					temp = temp.getRight();
				}
				System.out.println();
				temp = rowmarker.getDown();
				rowmarker = temp;
			}	
			
			return true;
		}
		
	
}
