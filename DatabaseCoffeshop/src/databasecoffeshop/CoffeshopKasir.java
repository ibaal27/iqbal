package databasecoffeshop;

import java.util.Scanner;
public class CoffeshopKasir {
    public static void main(String[] args){
        System.out.println("=====================================\n" + "=========== ZICHA CASHIER ===========\n" + "=====================================");
        Scanner scn = new Scanner(System.in);
        System.out.print("Masukkan Total Bayar Anda! : ");
        long Bayar = scn.nextLong();
        
        System.out.println("Masukkan Total Belanja Anda! :");
        long Belanja = scn.nextLong();
        
        System.out.println("Total Kembalian Anda! :");
        long kembali = Bayar - Belanja;
        System.out.println("Kembalian :" + kembali);
        
        System.out.println("No Pesanan Anda :");
        long pesanan = scn.nextLong();
        System.out.println("TERIMAKASIH TELAH BELANJA DI TOKO KAMI");
    }
}