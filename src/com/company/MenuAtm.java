package com.company;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;

public class MenuAtm extends Akun{
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat formatUang = new DecimalFormat("'Rp'###,###.00");

    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    public void getLogin() throws IOException{
        int x = 1;
        do{
            try {
                data.put(184400, 300021);

                System.out.println("Selamat datang di ATM!");
                System.out.println("Masukkan nomor rekening :");
                setNoCust(menuInput.nextInt());
                System.out.println("Masukkan pin :");
                setNoPin(menuInput.nextInt());
            }catch (Exception e){
                System.out.println("Hanya boleh angka!");
                x = 2;
            }
            int nc = getNoCust();
            int np = getNoPin();
            if(data.containsKey(nc) && data.get(nc) == np){
                getAkun();
            } else
                System.out.println("Pin atau Rekening salah");
        }while (x == 1);
    }
    public void getAkun(){
        System.out.println("Menu Akun :");
        System.out.println("Type 1 - Informasi saldo");
        System.out.println("Type 2 - Penarikan uang");
        System.out.println("Type 3 - Deposito uang");
        System.out.println("Type 4 - Transfer");
        System.out.println("Keluar");


        int pilihan = menuInput.nextInt();

        switch (pilihan){
            case 1:
                System.out.println("Saldo : " + formatUang.format(getSaldo()));
                getAkun();
                break;
            case 2:
                getInputPenarikanSaldo();
                getAkun();
                break;
            case 3:
                getInputDepositoSaldo();
                getAkun();
            default:
                System.out.println("Invalid");
                getAkun();
        }

    }
}
