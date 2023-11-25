public class RightTriangle {
    public static void main(String[] args) {
       Integer ASide = Integer.parseInt(args[0]);
       Integer BSide = Integer.parseInt(args[1]);
       Integer CSide = Integer.parseInt(args[2]);

        Integer ConvertedASide =  ASide * ASide;
        Integer ConvertedBSide =  BSide * BSide;
        Integer ConvertedCSide =  CSide * CSide;

       Boolean IsRight = ConvertedASide + ConvertedBSide == ConvertedCSide | ConvertedASide + ConvertedCSide == ConvertedBSide | ConvertedBSide + ConvertedCSide == ConvertedASide;
        System.out.println(IsRight);

    }
}
