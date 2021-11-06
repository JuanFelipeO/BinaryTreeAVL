package binarytreeavl;

public class BinaryTreeAVL 
{
    private NodeAVL root;
    
    public NodeAVL getRoot()
    {
        return root;
    }

    public BinaryTreeAVL()
    {
        root = null;
    }

    public int getFE(NodeAVL temp)
    {
        if( temp == null)
        {
            return -1;
        }
        else
        {
            return  temp.fe;
        }
    }

    public  NodeAVL rotateSimpleLeft(NodeAVL temp)
    {
        NodeAVL aux = temp.childrenLeft;
        temp.childrenLeft = aux.childrenRight;
        aux.childrenRight = temp;
        temp.fe = Math.max(getFE(temp.childrenLeft),getFE(temp.childrenRight))+1;
        aux.fe = Math.max(getFE(aux.childrenLeft),getFE(aux.childrenRight))+1;
        return aux;
    }

    public  NodeAVL rotateSimpleRight(NodeAVL temp)
    {
        NodeAVL aux = temp.childrenRight;
        temp.childrenRight = aux.childrenLeft;
        aux.childrenLeft = temp;
        temp.fe = Math.max(getFE(temp.childrenLeft),getFE(temp.childrenRight))+1;
        aux.fe  = Math.max(getFE(aux.childrenLeft),getFE(aux.childrenRight))+1;
        return aux;
    }

    public NodeAVL rotateDoubleLeft(NodeAVL temp)
    {
        NodeAVL aux;
        temp.childrenLeft=rotateSimpleRight(temp.childrenLeft);
        aux = rotateSimpleLeft(temp);
        return aux;
    }

    public NodeAVL rotateDoubleRight(NodeAVL temp)
    {
        NodeAVL aux;
        temp.childrenRight=rotateSimpleLeft(temp.childrenRight);
        aux = rotateSimpleLeft(temp);
        return aux;
    }

    public NodeAVL addAVL(NodeAVL data, NodeAVL subTree)
    {
        NodeAVL newFather = subTree;

        if (data.data < subTree.data)
        {
            if (subTree.childrenLeft == null)
            {
                subTree.childrenLeft = data;
            }
            else
            {
                subTree.childrenLeft = addAVL(data, subTree.childrenLeft);
                if ((getFE(subTree.childrenLeft)-getFE(subTree.childrenRight) == 2))
                {
                    if(data.data < subTree.childrenLeft.data)
                    {
                        newFather = rotateSimpleLeft(subTree);
                    }
                    else
                    {
                        newFather = rotateDoubleLeft(subTree);
                    }
                }
            }
        }
        else if (data.data > subTree.data)
        {
            if (subTree.childrenRight == null)
            {
                subTree.childrenRight = data;
            }
            else
            {
                subTree.childrenRight = newFather = addAVL(data,subTree.childrenRight);
                if ((getFE(subTree.childrenRight)-getFE(subTree.childrenLeft) == 2))
                {
                    if (data.data > subTree.childrenRight.data)
                    {
                        newFather = rotateSimpleRight(subTree);
                    }
                    else
                    {
                        newFather = rotateDoubleRight(subTree);
                    }
                }
            }
        }
        if ((subTree.childrenLeft == null && subTree.childrenRight != null))
        {
            subTree.fe = subTree.childrenRight.fe+1;
        }
        else if ((subTree.childrenRight == null && subTree.childrenLeft != null))
        {
            subTree.fe = subTree.childrenLeft.fe+1;
        }
        else
        {
            subTree.fe = Math.max(getFE(subTree.childrenLeft),getFE(subTree.childrenRight)+1);
        }
        return newFather;
    }

    public void addData(int data)
    {
        NodeAVL aux = new NodeAVL(data);

        if (root == null)
        {
            root = aux;
        }
        else
        {
            root = addAVL(aux, root);
        }
    }

    public void inOrden (NodeAVL temp)
    {
        if (temp != null)
        {
            inOrden(temp.childrenLeft);
            System.out.println(temp.data+ ", ");
            inOrden(temp.childrenRight);
        }
    }
}
