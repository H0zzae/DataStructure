import java.util.*;

// Name : 허채림
// Student ID : 20181707

@SuppressWarnings("unchecked")
class BST <T extends KeyValue> {

	class TreeNode <U extends KeyValue> {
		U data;	// storage for data : in HW 3, T will be Item
		TreeNode<U> leftChild;	// link to the left Child
		TreeNode<U> rightChild;	// link to the right Child

		// constructors come here
		TreeNode() {
			leftChild = rightChild = null;
		}
		TreeNode(U d) {
			// data is given
			data = d;
			// the leftChild and rightChild field are null
			leftChild = rightChild = null;
		}
	};

	TreeNode <T> root;// the reference to the root node

	BST() {
		// BST constructor.
		root = null;
	}

	void Show() {
		System.out.print( "Pre  Order : ");
		PreOrder(root);
		System.out.println("");
		System.out.print("In   Order : ");
		InOrder(root);
		System.out.println("");
		System.out.print("Post Order : ");
		PostOrder(root);
		System.out.println("");
		System.out.print("Number of Nodes : ");
		System.out.println( Count(root));
		System.out.print("Height : ");
		System.out.println( Height(root));
		System.out.println("");
	}

	// IMPLEMENT THE FOLLOWING FUNCTIONS

	boolean  Insert(T item)  {
		// first search the key
		if(root == null) {
			root = new TreeNode(item);
			return true;
		}

		TreeNode<T> parent;
		parent = root;
		while(true){
			if(item.GetKey()==parent.data.GetKey()){
				return false;
			}if(item.GetKey() < parent.data.GetKey()){
	      if(parent.leftChild == null) {
	          // System.out.println("<-");
	          parent.leftChild = new TreeNode(item);
	          return true;
	      } else {
	          parent = parent.leftChild;
	          continue;
	      }
	  } else {
	      if(parent.rightChild == null) {
	          // System.out.println("->");
	          parent.rightChild = new TreeNode(item);
	          return true;
	      } else {
	          parent = parent.rightChild;
	          continue;
	      }
		  }
    }

	}

	T Get(T item)  {
		// use the key field of item and find the node
		// do not use val field of item
		TreeNode<T> ptr;
		ptr = root;

		while(true){
			if(item.GetKey()==ptr.data.GetKey()){
				return ptr.data;
			}
			if(item.GetKey()<ptr.data.GetKey()){
				if(ptr.leftChild ==null){
					return null;
				}else{
					ptr = ptr.leftChild;
					continue;
				}
			}else {
				if(ptr.rightChild==null){
					return null;
				}else{
				ptr = ptr.rightChild;
				continue;
			}
			}
		}

	}


	boolean Delete(T item)  {
		if(root == null)
			return false;	// non existing key
		TreeNode<T> ptree, parent;
		boolean lt = false;
		parent=ptree=root;
		while(true){
			if(ptree==null){
				break;
			}else if(item.GetKey()<ptree.data.GetKey()){
				parent = ptree;
				ptree=ptree.leftChild;
				lt = true;
				continue;
			}else if(item.GetKey()>ptree.data.GetKey()){
				parent = ptree;
				ptree = ptree.rightChild;
				lt = false;
				continue;
			}else {
				if((ptree.leftChild==null)&&(ptree.rightChild==null)){
					if(ptree==root){
						root=null;
					}else if(lt==true){
						parent.leftChild=null;
					}else {
						parent.rightChild = null;
					}return true;
				}
				if((ptree.leftChild==null)&&(ptree.rightChild!=null)){
					if(ptree == root) {
              root = null;
          }else if(lt==true) {
              parent.leftChild = ptree.rightChild;
          }else {
              parent.rightChild = ptree.rightChild;
          }
          return true;
				}
				if(ptree.leftChild != null && ptree.rightChild == null) {
          if(lt==true) {
              parent.leftChild = ptree.leftChild;
          }else {
              parent.rightChild = ptree.leftChild;
          }
          return true;
        }
				TreeNode<T> search = ptree.leftChild;
        int max = search.data.GetKey();
        while(true) {
	        max = search.data.GetKey();
	        if(search.rightChild == null) break;
						search = search.rightChild;
			}
        T temp = search.data;
        Delete(search.data);
        ptree.data = temp;
        return true;
			}
		}
		return false;
	}

	void  PreOrder(TreeNode<T> t)  {
		if(t!=null){
			System.out.print( "[" + t.data.GetKey() + "(" + t.data.GetValue() + ")]" );
			PreOrder(t.leftChild);
			PreOrder(t.rightChild);
		}
		}

	void  InOrder(TreeNode<T> t)  {
		if(t != null){
	   InOrder(t.leftChild);
	   System.out.print( "[" + t.data.GetKey() + "(" + t.data.GetValue() + ")]" );
	   InOrder(t.rightChild);
	 }
	}

	void  PostOrder(TreeNode<T> t)  {
		if(t != null) {
		 PostOrder(t.leftChild);
		 PostOrder(t.rightChild);
		 System.out.print( "[" + t.data.GetKey() + "(" + t.data.GetValue() + ")]" );
	 }
	}

	int  Count(TreeNode<T> t)  {
		if(t==null) return 0;
			return 1+Count(t.leftChild)+Count(t.rightChild);

	}

	int  Height(TreeNode<T> t)  {
		if(t == null) return 0;
        return 1 + Math.max(Height(t.leftChild), Height(t.rightChild));
	}
}
