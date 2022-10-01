package br.edu.ifpb.eda.tree;

public class BinarySearchTree implements TBinarySearchTree {
	TNo root;
	
	public boolean add(int valor) {
		if(root != null) {
			return add(root, valor);
		}
		root = new TNo(valor);
		return true;
	}
	
	public boolean add(TNo aux, int valor) {
		if(aux.dado > valor) {
			if(aux.esq == null) {
				aux.esq = new TNo(valor);
				return true;
			} else {
				return add(aux.esq, valor);
			}
		} else if(aux.dado < valor) {
			if(aux.dir == null) {
				aux.dir = new TNo(valor);
				return true;
			} else {
				return add(aux.dir, valor);
			}
		}
		return false;
	}

	@Override
	public void removeRestricted(int valor) {
		root = removerRestrita(root, valor);
	}
	
	private TNo removerRestrita(TNo aux, int valor) {
		if(aux == null) {
			return aux;
		}
		if(aux.dado > valor){
			aux.esq = removerRestrita(aux.esq, valor);
		} else if(aux.dado < valor) {
			aux.dir = removerRestrita(aux.dir, valor);
		} else {
			if(aux.esq == null) {
				return aux.dir;
			} else if(aux.dir == null) {
				return aux.esq;
			} else {
				aux.dado = menor(aux.dir);
				aux.dir = removerRestrita(aux.dir, aux.dado);
			}
		}
		return aux;
	}
	
	private int menor(TNo aux) {
		int menor = aux.dado;
        while (aux.esq != null) {
            menor = aux.esq.dado;
            aux = aux.esq;
        }
        System.out.println("Aux : " +aux.dado);
        System.out.println("Menor: "+ menor);
        return menor;
	}

	public int qtdDeNos() {
		return qtd(root);
	}
	
	private int qtd(TNo aux) {
		if(aux == null) {
			return 0;
		} else {
			return qtd(aux.esq) + 1 + qtd(aux.dir);
		}
	}
	
	void deleteKey(int key) { root = deleteRec(root, key); }
	 
    /* A recursive function to
      delete an existing key in BST
     */
    TNo deleteRec(TNo root, int valor)
    {
        /* Base Case: If the tree is empty */
        if (root == null)
            return root;
 
        /* Otherwise, recur down the tree */
        if (valor < root.dado)
            root.esq = deleteRec(root.esq, valor);
        else if (valor > root.dado)
            root.dir = deleteRec(root.dir, valor);
 
        // if key is same as root's
        // key, then This is the
        // node to be deleted
        else {
            // node with only one child or no child
            if (root.esq == null)
                return root.dir;
            else if (root.dir == null)
                return root.esq;
 
            // node with two children: Get the inorder
            // successor (smallest in the right subtree)
            root.dado = minValue(root.dir);
 
            // Delete the inorder successor
            root.dir = deleteRec(root.dir, root.dado);
        }
 
        return root;
    }
 
    int minValue(TNo root)
    {
        int minv = root.dado;
        while (root.esq != null) {
            minv = root.esq.dado;
            root = root.esq;
        }
        return minv;
    }
    
    public void inorder() { inorderRec(root); }
    
    // A utility function to do inorder traversal of BST
    void inorderRec(TNo root)
    {
        if (root != null) {
            inorderRec(root.esq);
            System.out.print(root.dado + " ");
            inorderRec(root.dir);
        }
    }
    
    public int fb(TNo no) {
    	int fb = altura(no.dir) - altura(no.esq);
    	return fb;
    }
    
    public int altura(TNo no) {
    	if(no == null) {
    		return -1;
    	}
    	int altEsq = altura(no.esq);
    	int altDir = altura(no.dir);

    	if(altEsq > altDir) {
    		return altEsq + 1;
    	} else {
    		return altDir + 1;
    	}
    }

}
