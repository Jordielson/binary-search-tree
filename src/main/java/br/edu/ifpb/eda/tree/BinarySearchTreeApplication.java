package br.edu.ifpb.eda.tree;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BinarySearchTreeApplication implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		BinarySearchTree tree = new BinarySearchTree();
		 
        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
        20   40  60   80 */
        tree.add(50);
        tree.add(30);
        tree.add(20);
        tree.add(10);
        tree.add(5);
        tree.add(40);
        tree.add(70);
//        tree.add(60);
//		tree.add(80);

        System.out.println("Altura esq: " + tree.altura(tree.root.esq));
        System.out.println("Altura dir: " + tree.altura(tree.root.dir));
        System.out.println("FB: " + tree.fb(tree.root));
        System.out.println("Quantidade de nos: " + tree.qtdDeNos());
        System.out.println(
            "Inorder traversal of the given tree");
        tree.inorder();
 
        System.out.println("\nDelete 80");
        tree.removeRestricted(70);
        System.out.println(
            "Inorder traversal of the modified tree");
        tree.inorder();
 
        System.out.println("\nDelete 30");
        tree.removeRestricted(30);
        System.out.println(
            "Inorder traversal of the modified tree");
        tree.inorder();
 
        System.out.println("\nDelete 50");
        tree.removeRestricted(50);
        System.out.println(
            "Inorder traversal of the modified tree");
        tree.inorder();
        
        System.out.println("\nDelete 120");
        tree.removeRestricted(120);
        System.out.println(
            "Inorder traversal of the modified tree");
        tree.inorder();
        System.out.println();
	}

}
