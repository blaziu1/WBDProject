package wbd;


import javax.swing.*;
import wbd.gui.Logowanie2;
import wbd.gui.MainWindow;

/**
 * Created by Błażej on 2018-01-20.
 */
public class Main {
    public final DBManager dbmanager;
    public final String dataBase = "jdbc:mysql://wyqk6x041tfxg39e.chr7pe7iynqr.eu-west-1.rds.amazonaws.com:3306/mnbumeaahth4894d?allowMultiQueries=true";
    public final String user = "ibqdlb59r9kj99ow";
    public final String password = "htmakztaq0ya19c2";

    public Main(){
        dbmanager = new DBManager();
        if(!dbmanager.init(dataBase, user, password)){
            if(JOptionPane.showConfirmDialog(null, "Nie można uzyskać dostępu do bazy danych.\nWybierz \"OK\" by pracować lokalnie lub \"Cancel\" by wyjść.", "Uwaga!", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.CANCEL_OPTION)
                System.exit(-1);
        }
    //    java.awt.EventQueue.invokeLater(() -> MainWindow.init(dbmanager).setVisible(true));
        new Logowanie2(dbmanager).setVisible(true);
       // java.awt.EventQueue.invokeLater(() -> Logowanie.setVisible(true));
    }

    public static void main(String[]args){
        Main main = new Main();
    }
}
