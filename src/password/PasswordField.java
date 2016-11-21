package password;

import password.EraserThread;

import java.io.*;

/**
 * Copied from http://stackoverflow.com/questions/10819469/hide-input-on-command-line.
 */

public class PasswordField {

    /**
     *@param prompt to display to the user
     *@return The password as entered by the user
     */
    public static String readPassword (String prompt) {
        EraserThread et = new EraserThread(prompt);
        Thread mask = new Thread(et);
        mask.start();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String password = "";

        try {
            password = in.readLine();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        // stop masking
        et.stopMasking();

        // return the password entered by the user
        return password;
    }
}
