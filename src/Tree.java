import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class Tree {

  private Node<Integer> root;

  public static void main(String[] args) {
    /*
      Look at Tree.jpg for this tree structure
      */
    Tree tree = new Tree();
    tree.insert(2);
    tree.insert(5);
    tree.insert(3);
    tree.insert(4);
    tree.insert(6);
    tree.insert(1);
    tree.insert(9);
    tree.insert(7);
    tree.insert(0);
    System.out.println("Pre order");
    tree.printPreOrderDFS(tree.getRoot());
    System.out.println("Post order");
    tree.printPostOrderDFS(tree.getRoot());
    System.out.println("In Order (also known as sorted traversal)");
    tree.printInOrderDFS(tree.getRoot());
    System.out.println("Breadth First traversal");
    tree.printBFS();
    System.out.println("Sum of vertical nodes");
    tree.printSumOfVerticalNodes();
  }

  /**
   * The Idea is to give every verticals a number and store the nodes present in that vertical in a list,
   * and later the list into a map as value with the key as the number
   * Example: in Image, node with value 2 can be treated as on a vertical number 0
   * So map will have (0, [2, 3])
   * Every right vertical will be +1 of previous and every left vertical will be -1 of previous
   **/
  private void printSumOfVerticalNodes() {
    Map<Integer, List<Integer>> sortedMap = new TreeMap<>();
    int verticalNumber = 0;
    addVerticalNodesInMap(root, sortedMap, verticalNumber);
    sortedMap.forEach((key, value) -> System.out.print(value.stream().mapToInt(Integer::intValue).sum() + " "));
  }

  private void addVerticalNodesInMap(Node<Integer> root, Map<Integer, List<Integer>> map, int verticalNumber) {
    if(root == null) return;
    List<Integer> values = map.get(verticalNumber);
    if(values == null) {
      values = new ArrayList<>();
    }
    values.add(root.getData());
    map.put(verticalNumber, values);
    addVerticalNodesInMap(root.getLeft(), map, verticalNumber - 1);
    addVerticalNodesInMap(root.getRight(), map, verticalNumber + 1);
  }

  private void printBFS() {
    Node<Integer> tempNode;
    Queue<Node<Integer>> queue = new LinkedList<>();
    queue.offer(root);
    while(queue.peek() != null) {
      tempNode = queue.poll();
      if(tempNode.getLeft() != null) {
        queue.offer(tempNode.getLeft());
      }
      if(tempNode.getRight() != null) {
        queue.offer(tempNode.getRight());
      }
      System.out.println(tempNode.getData());
    }
  }

  public Node<Integer> getRoot() {
    return root;
  }

  private void printPreOrderDFS(Node<Integer> root) {
    if (root == null) {
      return;
    }
    System.out.println(root.getData());
    if (root.getLeft() != null) {
      printPreOrderDFS(root.getLeft());
    }
    if (root.getRight() != null) {
      printPreOrderDFS(root.getRight());
    }
  }

  private void printInOrderDFS(Node<Integer> root) {
    if (root == null) {
      return;
    }
    if (root.getLeft() != null) {
      printInOrderDFS(root.getLeft());
    }
    System.out.println(root.getData());
    if (root.getRight() != null) {
      printInOrderDFS(root.getRight());
    }
  }

  private void printPostOrderDFS(Node<Integer> root) {
    if (root == null) {
      return;
    }
    if (root.getLeft() != null) {
      printPostOrderDFS(root.getLeft());
    }
    if (root.getRight() != null) {
      printPostOrderDFS(root.getRight());
    }
    System.out.println(root.getData());
  }

  private void insert(Integer data) {
    root = insertNode(root, data);
  }

  private Node<Integer> insertNode(Node<Integer> root, Integer data) {
    if (root == null) {
      root = new Node<>(data);
      return root;
    }
    if (data <= root.getData()) {
      root.setLeft(insertNode(root.getLeft(), data));
    } else {
      root.setRight(insertNode(root.getRight(), data));
    }
    return root;
  }

}

class Node<T> {

  private T data;
  private Node<T> left;
  private Node<T> right;

  public Node(T data) {
    this.data = data;
  }

  public T getData() {
    return data;
  }

  public Node<T> getLeft() {
    return left;
  }

  public Node<T> getRight() {
    return right;
  }

  public void setData(T data) {
    this.data = data;
  }

  public void setLeft(Node<T> left) {
    this.left = left;
  }

  public void setRight(Node<T> right) {
    this.right = right;
  }
}