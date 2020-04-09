public class BSTNode {

    private Node root;
    public class Node {
        String key;
        MovieInfo data;
        Node left, right;

        public Node(String k, MovieInfo m) {
            this.key = k;
            this.data = m;
        }
    }

    public BSTNode() {
        root = null;
    }

    public void insert(MovieInfo data) {
        root = insert(root,data);
    }

    public Node insert(Node x, MovieInfo movie) {
        if (x==null) {
            return new Node(movie.movieName,movie);
        }
        int compare = movie.movieName.compareTo(x.key);
        if (compare<0) {
            x.left = insert(x.left,movie);
        }
        else if (compare>0) {
            x.right = insert(x.right,movie);
        }
        else {
            x.data = movie;
        }
        return x;
    }

    public MovieInfo findExact(String key, String g) {
        Node x = root;
        while (x!=null) {
            int compare = key.compareToIgnoreCase(x.key);		//key is the movieName which is the full name the user inputs
            if (compare<0) {
                x = x.left;
            }
            else if (compare>0) {
                x = x.right;
            }
            else {
                return x.data;									// returns when matched
            }
        }

        return null;
    }

    void printGenre(BSTNode.Node node, String k1, String k2) {

        /* default if there is no tree root */
        if (node == null) {
            return;
        }
        int compareK1 = k1.compareTo(node.data.genre);
        int compareK2 = k2.compareTo(node.data.genre);
        /* Since the desired o/p is sorted, recurse for left subtree first
         If root->data is greater than k1, then only we can get o/p keys
         in left subtree */
        if (compareK1 < 0) {
            printGenre(node.left, k1, k2);
        }

        /* if root's data lies in range, then prints root's data */
        if (compareK1 <= 0 && compareK2 >= 0) {
            System.out.print(node.data.genre + " ");
        }

        /* If root->data is smaller than k2, then only we can get o/p keys
         in right subtree */
        if (compareK2 > 0) {
            printGenre(node.right, k1, k2);
        }
    }
}