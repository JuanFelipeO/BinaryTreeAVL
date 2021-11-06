package binarytreeavl;

public class NodeAVL 
{
 int data,fe;
   NodeAVL childrenLeft = null, childrenRight;

   public NodeAVL (int data)
   {
       this.data = data;
       this.fe = 0;
       this.childrenRight = null;
       this.childrenLeft = null;
   }    
}
