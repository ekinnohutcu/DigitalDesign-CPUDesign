//Ekin NOHUTÇU 150116067
//Furkan KUSE 150117041
//Metehan ERTAN 150117051

import java.io.*;
import java.util.Scanner;


public class Digital1 {

    public static void main(String args[]) throws IOException {

        String a;
        String b;
        File file = new File("test.txt");
        Scanner sc = new Scanner(file);

        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));

        while(sc.hasNext()){
            a = sc.next();
            String returnString = "";
            if(!sc.hasNext()){
                System.out.println("ERROR!");
                break;
            }

            if(a.equals("AND") || a.equals("OR") || a.equals("ADD") || a.equals("XOR")){
                b = sc.next();
                String[] c = b.split(",");
                if(a.equals("AND")){
                    returnString = "0000";
                }else if(a.equals("OR")){
                    returnString = "0001";
                }
                else if(a.equals("ADD")){
                    returnString = "0010";
                }
                else if(a.equals("XOR")){
                    returnString = "0011";
                }else{
                    System.out.println("ERROR!");
                    break;
                }
                FirstCase(c[0].split("R")[1],c[1].split("R")[1],c[2].split("R")[1],returnString,writer);
            }
            else if(a.equals("ANDI") || a.equals("ORI") || a.equals("ADDI") || a.equals("XORI")){
                b = sc.next();
                String[] c = b.split(",");
                if(a.equals("ANDI")){
                    returnString = "0100";
                }else if(a.equals("ORI")){
                    returnString = "01010";
                }
                else if(a.equals("ADDI")){
                    returnString = "0110";
                }
                else if(a.equals("XORI")){
                    returnString = "0111";
                }else{
                    System.out.println("ERROR!");
                    break;
                }
                SecondCase(c[0].split("R")[1],c[1].split("R")[1],c[2],returnString,writer);
            }
            else if(a.equals("BEQ")|| a.equals("BGT")|| a.equals("BLT")|| a.equals("BGE")|| a.equals("BLE")){
                b = sc.next();
                String[] c = b.split(",");

                if(a.equals("BEQ")){
                    returnString = "1000";
                }else if(a.equals("BGT")){
                    returnString = "1001";
                }
                else if(a.equals("BLT")){
                    returnString = "1010";
                }
                else if(a.equals("BGE")){
                    returnString = "1011";
                }else if(a.equals("BLE")){
                    returnString = "1100";
                }
                else{
                    System.out.println("ERROR!");
                    break;
                }


                ThirdCase(c[0].split("R")[1],c[1].split("R")[1],c[2],returnString,writer);
            }
            else if(a.equals("LD")){
                b = sc.next();
                String[] c = b.split(",");
                returnString = "1101";
                FourthCase(c[0].split("R")[1],c[1],returnString, writer);
            }
            else if(a.equals("ST")){
                b = sc.next();
                String[] c = b.split(",");
                returnString ="1110";
                FifthCase(c[0].split("R")[1],c[1],returnString, writer);
            }
            else if(a.equals("JUMP")){
                b = sc.next();
                String[] c = b.split(",");
                returnString = "1111";
                SixthCase(c[0],returnString, writer);
            }
        }

        writer.close();
    }

    public static void FirstCase(String dest,String src1,String src2,String returnString,BufferedWriter writer) throws IOException {

        int intDest = Integer.parseInt(dest,10);
        String binaryDest = Integer.toBinaryString(intDest);
        binaryDest = concatBinary(binaryDest,4);


        int intSrc1 = Integer.parseInt(src1,10);
        String binarySrc1 = Integer.toBinaryString(intSrc1);
        binarySrc1 = concatBinary(binarySrc1,4);


        int intSrc2 = Integer.parseInt(src2,10);
        String binarySrc2 = Integer.toBinaryString(intSrc2);
        binarySrc2 = concatBinary(binarySrc2,4);


        returnString = returnString + binaryDest + binarySrc1 + binarySrc2 + "00";


        int returnInt = Integer.parseInt(returnString,2);
        returnString = Integer.toString(returnInt,16);


        returnString = concatBinary(returnString,5);


        writer.write(returnString + "\n");
    }

    public static void SecondCase(String dest,String src1,String imm,String returnString,BufferedWriter writer) throws IOException {
        int intDest = Integer.parseInt(dest,10);
        String binaryDest = Integer.toBinaryString(intDest);
        binaryDest = concatBinary(binaryDest,4);

        int intSrc1 = Integer.parseInt(src1,10);
        String binarySrc1 = Integer.toBinaryString(intSrc1);
        binarySrc1 = concatBinary(binarySrc1,4);

        int intImm = Integer.parseInt(imm,10);
        String binaryImm = Integer.toBinaryString(intImm);
        binaryImm = concatBinary(binaryImm,6);

        returnString = returnString + binaryDest + binarySrc1 + binaryImm;

        int returnInt = Integer.parseInt(returnString,2);
        returnString = Integer.toString(returnInt,16);

        returnString = concatBinary(returnString,5);


        writer.write(returnString + "\n");

    }

    public static void ThirdCase(String op1,String op2,String addr,String returnString,BufferedWriter writer) throws IOException {
        int intOp1 = Integer.parseInt(op1,10);
        String binaryOp1 = Integer.toBinaryString(intOp1);
        binaryOp1 = concatBinary(binaryOp1,4);

        int intOp2 = Integer.parseInt(op2,10);
        String binaryOp2 = Integer.toBinaryString(intOp2);
        binaryOp2 = concatBinary(binaryOp2,4);

        int intAddr = Integer.parseInt(addr,10);
        String binaryAddr = Integer.toBinaryString(intAddr);
        binaryAddr = concatBinary(binaryAddr,6);

        returnString = returnString + binaryOp1 + binaryOp2 + binaryAddr;

        int returnInt = Integer.parseInt(returnString,2);
        returnString = Integer.toString(returnInt,16);

        returnString = concatBinary(returnString,5);

        writer.write(returnString + "\n");

    }
    public static void FourthCase(String dest,String addr,String returnString, BufferedWriter writer) throws IOException {

        int intDest = Integer.parseInt(dest,10);
        String binaryDest = Integer.toBinaryString(intDest);
        binaryDest = concatBinary(binaryDest,4);

        int intAddr = Integer.parseInt(addr,10);
        String binaryAddr = Integer.toBinaryString(intAddr);
        binaryAddr = concatBinary(binaryAddr,10);

        returnString = returnString + binaryDest + binaryAddr;

        int returnInt = Integer.parseInt(returnString,2);
        returnString = Integer.toString(returnInt,16);

        returnString = concatBinary(returnString,5);

        writer.write(returnString + "\n");

    }
    public static void FifthCase(String src,String addr,String returnString, BufferedWriter writer) throws IOException {

        int intSrc = Integer.parseInt(src,10);
        String binarySrc = Integer.toBinaryString(intSrc);
        binarySrc = concatBinary(binarySrc,4);

        int intAddr = Integer.parseInt(addr,10);
        String binaryAddr = Integer.toBinaryString(intAddr);
        binaryAddr = concatBinary(binaryAddr,10);

        returnString = returnString + binarySrc + binaryAddr;

        int returnInt = Integer.parseInt(returnString,2);
        returnString = Integer.toString(returnInt,16);

        returnString = concatBinary(returnString,5);

        writer.write(returnString + "\n");
    }
    public static void SixthCase(String addr,String returnString, BufferedWriter writer) throws IOException{


        int intAddr = Integer.parseInt(addr,10);
        String binaryAddr = Integer.toBinaryString(intAddr);
        binaryAddr = concatBinary(binaryAddr,14);


        returnString = returnString + binaryAddr;

        int returnInt = Integer.parseInt(returnString,2);
        returnString = Integer.toString(returnInt,16);

        returnString = concatBinary(returnString,5);

        writer.write(returnString + "\n");
    }

    public static String concatBinary(String binary, int length){
        for(int i = 0; i < length ; i++){
            binary = "0" + binary;
        }

        return binary.substring(binary.length() - length);
    }
}
