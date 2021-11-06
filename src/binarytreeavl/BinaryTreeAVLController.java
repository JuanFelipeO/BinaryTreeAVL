package binarytreeavl;

public class BinaryTreeAVLController 
{

    public static void main(String[] args) 
    {
        BinaryTreeAVL binaryTreeAVL = new BinaryTreeAVL();

        binaryTreeAVL.addData(10);
        binaryTreeAVL.addData(5);
        binaryTreeAVL.addData(13);
        binaryTreeAVL.addData(1);
        binaryTreeAVL.addData(6);
        binaryTreeAVL.addData(17);
        binaryTreeAVL.addData(16);
        binaryTreeAVL.inOrden(binaryTreeAVL.getRoot());
    }
}
