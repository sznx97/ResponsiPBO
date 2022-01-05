package com.company;

import java.io.IOException;

public class Main extends  MenuAtm{

    public static void main(String[] args) {
	    MenuAtm menu = new MenuAtm();

        try {
            menu.getLogin();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
